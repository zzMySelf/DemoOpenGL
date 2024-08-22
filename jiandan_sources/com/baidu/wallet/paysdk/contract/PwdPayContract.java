package com.baidu.wallet.paysdk.contract;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.w;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.presenter.NetWorkPresenter;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.Serializable;

public interface PwdPayContract {

    public static abstract class Presenter extends NetWorkPresenter {
        public String TAG = toString();
        public PwdPayActivity mActivity;
        public PayRequest mPayRequest;

        public Presenter(PwdPayActivity pwdPayActivity) {
            super(pwdPayActivity);
            this.mActivity = pwdPayActivity;
            pwdPayActivity.setPresenter(this);
            this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        }

        public void clearPayPwdCache(int i2) {
            PwdRequest pwdRequest;
            if ((100015 == i2 || 100018 == i2) && (pwdRequest = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD)) != null) {
                pwdRequest.mPayPass = null;
            }
        }

        public boolean dialogNevigateOper_QuitCashDesk() {
            return false;
        }

        public boolean dialogNevigateOper_QuitCurrentPage() {
            return false;
        }

        public abstract boolean directQuit();

        public final void doCheckPwd(String str) {
            PwdRequest pwdRequest = new PwdRequest();
            pwdRequest.mFrom = 1;
            pwdRequest.mRequestType = 2;
            pwdRequest.mPayPass = str;
            PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
            w wVar = (w) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 257, this.TAG);
            this.mActivity.showLoading(-1);
            wVar.setResponseCallback(this);
            wVar.execBean();
        }

        public void handleActivityError() {
        }

        public void handleFailure(int i2, int i3, String str) {
            this.mActivity.dismissLoading(-1);
            if (i2 == 257) {
                this.mActivity.showPWdInputView(true);
                clearPayPwdCache(i3);
                if (i3 == 100015) {
                    this.mActivity.showPassError(str);
                } else if (i3 == 100018) {
                    this.mActivity.setErrorTips(false, (String) null);
                    PwdPayActivity pwdPayActivity = this.mActivity;
                    pwdPayActivity.mDialogMsg = str;
                    pwdPayActivity.mPayErrorCode = i3;
                    pwdPayActivity.mBeanId = i2;
                    WalletGlobalUtils.safeShowDialog(pwdPayActivity, 17, "");
                } else if (i3 == -8) {
                    WalletGlobalUtils.safeShowDialog(this.mActivity, 11, "");
                } else if (i3 == 60500) {
                    PwdPayActivity pwdPayActivity2 = this.mActivity;
                    pwdPayActivity2.mDialogMsg = str;
                    pwdPayActivity2.mPayErrorCode = i3;
                    pwdPayActivity2.mBeanId = i2;
                    WalletGlobalUtils.safeShowDialog(pwdPayActivity2, 37, "");
                } else if (65312 == i3 || 65301 == i3) {
                    PwdPayActivity pwdPayActivity3 = this.mActivity;
                    GlobalUtils.toast(pwdPayActivity3, ResUtils.getString(pwdPayActivity3, "bd_wallet_fingerprint_auth_failed"));
                    "指纹验证失败, 切到密码输入模式   , wireless-pay接口请求失败 错误码是  : " + i3;
                    if (65301 == i3) {
                        WalletFingerprint.getInstance(this.mActivity).clearOTPToken();
                        StatisticManager.onEvent(StatServiceEvent.EVENT_65301_ON_FP_SMSACT);
                    } else {
                        StatisticManager.onEvent("fp_sys_65312_on_pwdpay");
                    }
                    this.mActivity.turntoPwdPay(true, (String) null);
                } else {
                    PwdPayActivity pwdPayActivity4 = this.mActivity;
                    if (TextUtils.isEmpty(str)) {
                        str = ResUtils.getString(this.mActivity, "dxm_fp_get_data_fail");
                    }
                    pwdPayActivity4.mDialogMsg = str;
                    WalletGlobalUtils.safeShowDialog(this.mActivity, 12, "");
                }
            } else {
                this.mActivity.handleFailure(i2, i3, str);
            }
        }

        public void handleResponse(int i2, Object obj, String str) {
            this.mActivity.handleResponse(i2, obj, str);
        }

        public boolean isGatewaySignPay() {
            return this.mActivity.isGatewaySignPay();
        }

        public protocolModel needshowProtocolContainer() {
            return null;
        }

        public boolean onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
            clearPayPwdCache(i3);
            return false;
        }

        public abstract void onFPCheckCancel();

        public abstract void onFPCheckOK(String str);

        public abstract void onPwdChanged(String str);

        public void onTurntoPwdPay(boolean z) {
        }

        public abstract void pwdAndFpTypeChange();

        public boolean showSucAnim() {
            return true;
        }

        public void triggleSmsPay() {
            StatisticManager.onEvent("triggleSmsVerify");
            Intent intent = new Intent();
            intent.setClass(this.mActivity, WalletSmsActivity.class);
            intent.putExtra(DxmPayBeanConstants.SMS_ACTIVITY_FROM_KEY, 1);
            intent.putExtra("pay_by_smscode", true);
            this.mActivity.startActivityWithoutAnim(intent);
        }
    }

    public interface a {
        void onProtocolClicked(boolean z);
    }

    public static class protocolModel implements NoProguard, Serializable {
        public boolean checked;
        public a iClickCallback;
        public String passfree_protocol_msg;
        public String passfree_protocol_prefix;
        public String passfree_protocol_url;
    }
}
