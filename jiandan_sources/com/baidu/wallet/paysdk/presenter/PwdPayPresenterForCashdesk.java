package com.baidu.wallet.paysdk.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.a;
import com.baidu.wallet.paysdk.beans.j;
import com.baidu.wallet.paysdk.beans.v;
import com.baidu.wallet.paysdk.beans.z;
import com.baidu.wallet.paysdk.contract.PwdPayContract;
import com.baidu.wallet.paysdk.datamodel.AuthorizeInfo;
import com.baidu.wallet.paysdk.datamodel.BalancePayResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.beans.sm.SMManagerDelegate;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PwdPayPresenterForCashdesk extends PwdPayContract.Presenter implements PwdPayContract.a {
    public boolean checkPass = false;
    public CheckForWhat mCheckForWhat = CheckForWhat.FOR_ONEKEYPAY;
    public boolean mIsForBindCardPay;
    public PayRequest mPayRequest;
    public String otpToken;
    public String pwdword;

    public enum CheckForWhat {
        FOR_ONEKEYPAY,
        FOR_BIND_CARD_PAY,
        FOR_COMPLETE_PAY
    }

    public PwdPayPresenterForCashdesk(PwdPayActivity pwdPayActivity, Intent intent) {
        super(pwdPayActivity);
        if (intent != null) {
            this.mIsForBindCardPay = intent.getBooleanExtra("IS_FOR_BIND_CARD_PAY", false);
            this.otpToken = intent.getStringExtra("otpToken");
            String stringExtra = intent.getStringExtra("warningTips");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.mActivity.showWarningTips(stringExtra);
            }
        }
    }

    private boolean isPwdOnekeypay() {
        if (this.mCheckForWhat == CheckForWhat.FOR_ONEKEYPAY && this.mPayRequest.getPayWay() == 3) {
            return true;
        }
        return false;
    }

    private void refreshPara() {
        PayRequest.PayPrice payPrice = this.mPayRequest.getPayPrice();
        if (payPrice == null) {
            PwdPayActivity pwdPayActivity = this.mActivity;
            PayCallBackManager.callBackClientCancel(pwdPayActivity, this.TAG + "initView().1");
            return;
        }
        if (this.mIsForBindCardPay) {
            this.mCheckForWhat = CheckForWhat.FOR_BIND_CARD_PAY;
            PwdPayActivity pwdPayActivity2 = this.mActivity;
            pwdPayActivity2.setTitleText(ResUtils.getString(pwdPayActivity2, "ebpay_please_input_pwd2"));
        } else {
            PayRequest.PayPrice.PayType payType = payPrice.payType;
            if (payType == PayRequest.PayPrice.PayType.BANKCARD) {
                CardData.BondCard bondCard = this.mPayRequest.mBondCard;
                if (bondCard == null) {
                    this.mCheckForWhat = CheckForWhat.FOR_BIND_CARD_PAY;
                } else if (!bondCard.isCompled()) {
                    this.mCheckForWhat = CheckForWhat.FOR_COMPLETE_PAY;
                } else {
                    this.mCheckForWhat = CheckForWhat.FOR_ONEKEYPAY;
                }
            } else if (payType == PayRequest.PayPrice.PayType.BALANCE || payType == PayRequest.PayPrice.PayType.LICAIBALANCE) {
                this.mCheckForWhat = CheckForWhat.FOR_ONEKEYPAY;
            } else if (payType == PayRequest.PayPrice.PayType.CREIDT) {
                this.mCheckForWhat = CheckForWhat.FOR_ONEKEYPAY;
            }
        }
        if (PayDataCache.getInstance().isFromPreCashier()) {
            if (this.mCheckForWhat != CheckForWhat.FOR_ONEKEYPAY) {
                this.mActivity.setErrorArea(true);
                this.mActivity.showLikeLoadingPage(false);
            } else if (isFingerprintPay()) {
                this.mActivity.showLikeLoadingPage(true);
                this.mActivity.doVerifyFingerprint(this.mPayRequest.mFingerprintPay);
            } else if (PayDataCache.getInstance().isPassFree()) {
                this.mActivity.showLikeLoadingPage(true);
                this.mActivity.setErrorArea(false);
                PayRequest payRequest = this.mPayRequest;
                if (payRequest != null) {
                    payRequest.setPayWay(1);
                }
                doPay();
            }
        } else if (this.mCheckForWhat != CheckForWhat.FOR_ONEKEYPAY) {
            this.mActivity.setErrorArea(true);
        } else if (isFingerprintPay()) {
            if (!TextUtils.isEmpty(this.otpToken)) {
                onFPCheckOK(this.otpToken);
            } else {
                this.mActivity.doVerifyFingerprint(this.mPayRequest.mFingerprintPay);
            }
        } else if (PayDataCache.getInstance().isPassFree()) {
            this.mActivity.setErrorArea(false);
            PayRequest payRequest2 = this.mPayRequest;
            if (payRequest2 != null) {
                payRequest2.setPayWay(1);
            }
            doPay();
        }
        if (this.mPayRequest.supportFingerprintPay && isPwdOnekeypay()) {
            this.mActivity.rightTextShow(true, "指纹支付");
        } else if (isFingerprintPay()) {
            this.mActivity.rightTextShow(true, "密码支付");
        } else {
            this.mActivity.rightTextShow(false, (String) null);
        }
    }

    private void statPaySuccess(int i2) {
        StatHelper.cachePayType(i2);
        if (PayDataCache.getInstance().isFromPreCashier()) {
            StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY);
            StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_SUCCESS, PayCallBackManager.PRE_HASH_NAME, PayCallBackManager.PRE_HASH_ID, PayCallBackManager.PAY_SUCCESS_MSG, new String[0]);
            return;
        }
        StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY);
        StatHelper.statPayAllServiceEvent(PayStatServiceEvent.STD_PAY_SUCCESS, PayCallBackManager.STD_HASH_NAME, PayCallBackManager.STD_HASH_ID, PayCallBackManager.PAY_SUCCESS_MSG, new String[0]);
    }

    public boolean dialogNevigateOper_QuitCashDesk() {
        return (PayDataCache.getInstance().isPassFree() || isFingerprintPay()) && PayDataCache.getInstance().isFromPreCashier();
    }

    public boolean dialogNevigateOper_QuitCurrentPage() {
        return (PayDataCache.getInstance().isPassFree() || isFingerprintPay()) && !PayDataCache.getInstance().isFromPreCashier();
    }

    public boolean directQuit() {
        if (PayDataCache.getInstance().isFromPreCashier()) {
            WalletGlobalUtils.safeShowDialog(this.mActivity, 18, "");
            return false;
        } else if (!isGatewaySignPay()) {
            return true;
        } else {
            BaiduPayDelegate.getInstance().reOrderPay(this.mActivity);
            return false;
        }
    }

    public void doPay() {
        PwdRequest pwdRequest = new PwdRequest();
        int i2 = 2;
        if (PayDataCache.getInstance().isPassFree()) {
            pwdRequest.mPayPass = null;
        } else {
            pwdRequest.mPayPass = this.pwdword;
            PayRequest payRequest = this.mPayRequest;
            i2 = (payRequest == null || payRequest.getPayWay() != 2) ? 0 : 1;
        }
        StatHelper.cachePayWay(i2);
        PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
        if (this.mPayRequest == null) {
            PwdPayActivity pwdPayActivity = this.mActivity;
            PayCallBackManager.callBackClientCancel(pwdPayActivity, this.TAG + "doPay().1");
            return;
        }
        if (shouldFullScreenLoading()) {
            this.mActivity.showLikeLoadingPage(true);
        } else {
            this.mActivity.showLikeLoadingPage(false);
        }
        PayRequest.PayPrice.PayType payType = this.mPayRequest.getPayPrice().payType;
        if (payType == PayRequest.PayPrice.PayType.BALANCE) {
            if (!this.checkPass) {
                this.mActivity.showLoading(-1);
            }
            a aVar = (a) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 14, this.TAG);
            aVar.setResponseCallback(this);
            aVar.execBean();
        } else if (payType == PayRequest.PayPrice.PayType.CREIDT) {
            if (!this.checkPass) {
                this.mActivity.showLoading(-1);
            }
            j jVar = (j) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 263, this.TAG);
            jVar.setResponseCallback(this);
            jVar.execBean();
        } else if (payType == PayRequest.PayPrice.PayType.BANKCARD) {
            if (!this.checkPass) {
                this.mActivity.showLoading(-1);
            }
            z zVar = (z) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 13, this.TAG);
            zVar.a(true);
            zVar.setResponseCallback(this);
            zVar.execBean();
        } else if (payType == PayRequest.PayPrice.PayType.LICAIBALANCE) {
            if (!this.checkPass) {
                this.mActivity.showLoading(-1);
            }
            v vVar = (v) PayBeanFactory.getInstance().getBean((Context) this.mActivity, (int) PayBeanFactory.BEAN_ID_LICAI_BALANCE_PAY, this.TAG);
            vVar.setResponseCallback(this);
            vVar.execBean();
        } else {
            PwdPayActivity pwdPayActivity2 = this.mActivity;
            PayCallBackManager.callBackClientCancel(pwdPayActivity2, this.TAG + "doPay().2");
        }
    }

    public void handleActivityError() {
        ErrorContentResponse errorContentResponse = this.mActivity.mErrorContent;
        if (errorContentResponse != null && errorContentResponse.mkt_solution != null) {
            z zVar = (z) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 13, this.TAG);
            if (this.mPayRequest == null) {
                this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            }
            this.mPayRequest.setMktSolution(this.mActivity.mErrorContent.mkt_solution);
            this.mActivity.showLoading(-1);
            zVar.a(true);
            zVar.setResponseCallback(this);
            zVar.execBean();
        }
    }

    public void handleFailure(int i2, int i3, String str) {
        StatHelper.cacheCodeAndMsg(i3 + "", str);
        this.mActivity.dismissLoading(-1);
        if ((PayDataCache.getInstance().isPassFree() || (this.mPayRequest != null && isFingerprintPay())) && PayDataCache.getInstance().isFromPreCashier() && this.mCheckForWhat == CheckForWhat.FOR_ONEKEYPAY) {
            this.mActivity.setPageTransparent(true);
        }
        if (i2 == 14 || i2 == 13 || i2 == 263 || i2 == 622) {
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
                if (65301 == i3) {
                    WalletFingerprint.getInstance(this.mActivity).clearOTPToken();
                    StatisticManager.onEvent(StatServiceEvent.EVENT_65301_ON_FP_SMSACT);
                } else {
                    StatisticManager.onEvent("fp_sys_65312_on_pwdpay");
                }
                PwdPayActivity pwdPayActivity3 = this.mActivity;
                GlobalUtils.toast(pwdPayActivity3, ResUtils.getString(pwdPayActivity3, "bd_wallet_fingerprint_auth_failed"));
                "指纹验证失败, 切到密码输入模式   , wireless-pay接口请求失败 错误码是  : " + i3;
                this.mActivity.turntoPwdPay(true, (String) null);
            } else {
                if (55000 == i3 || 55001 == i3) {
                    new SMManagerDelegate().deleteUserKeyId(this.mActivity);
                }
                PwdPayActivity pwdPayActivity4 = this.mActivity;
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(this.mActivity, "dxm_fp_get_data_fail");
                }
                pwdPayActivity4.mDialogMsg = str;
                WalletGlobalUtils.safeShowDialog(this.mActivity, 12, "");
            }
        } else {
            super.handleFailure(i2, i3, str);
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        StatHelper.cacheCodeAndMsg("0", StatHelper.SENSOR_OK);
        if (i2 == 257) {
            CheckForWhat checkForWhat = this.mCheckForWhat;
            if (checkForWhat == CheckForWhat.FOR_BIND_CARD_PAY) {
                PayController instance = PayController.getInstance();
                PwdPayActivity pwdPayActivity = this.mActivity;
                instance.bindCardPay(pwdPayActivity, pwdPayActivity.getIntent(), false);
                this.mActivity.finishWithoutAnim();
            } else if (checkForWhat == CheckForWhat.FOR_COMPLETE_PAY) {
                PayController.getInstance().completeCardPay(this.mActivity, this.mPayRequest.mBondCard);
                this.mActivity.finishWithoutAnim();
            } else if (checkForWhat == CheckForWhat.FOR_ONEKEYPAY) {
                doPay();
            }
        } else if (i2 != 14) {
            super.handleResponse(i2, obj, str);
        } else if (!PayDataCache.getInstance().isFromPreCashier() || !com.baidu.wallet.paysdk.c.a.a().c()) {
            BalancePayResponse balancePayResponse = (BalancePayResponse) obj;
            if (balancePayResponse != null && balancePayResponse.checkResponseValidity()) {
                PayResultContent payResultContent = new PayResultContent();
                payResultContent.notify = balancePayResponse.notify;
                payResultContent.paytype_desc = balancePayResponse.paytype_desc;
                payResultContent.coupon_msg = balancePayResponse.coupon_msg;
                BalancePayResponse.Business business = balancePayResponse.business;
                if (business != null) {
                    String str2 = business.stream_recharge_msg;
                    if (str2 != null) {
                        payResultContent.stream_recharge_msg = str2;
                    }
                    String str3 = balancePayResponse.business.expected_time;
                    if (str3 != null) {
                        payResultContent.expected_time = str3;
                    }
                }
                payResultContent.coupon_find_prompt = balancePayResponse.coupon_find_prompt;
                payResultContent.total_amount = balancePayResponse.total_amount;
                payResultContent.cash_amount = balancePayResponse.cash_amount;
                payResultContent.discount_amount = balancePayResponse.discount_amount;
                payResultContent.discount_info = balancePayResponse.discount_info;
                payResultContent.pay_detail_info = balancePayResponse.pay_detail_info;
                payResultContent.paytype_info = balancePayResponse.paytype_info;
                payResultContent.cross_market = balancePayResponse.cross_market;
                payResultContent.order_prefix = balancePayResponse.order_prefix;
                payResultContent.discount_prefix = balancePayResponse.discount_prefix;
                payResultContent.payResultCashbackDetail = balancePayResponse.cashback_dialog_detail;
                AuthorizeInfo authorizeInfo = balancePayResponse.authorize_info;
                payResultContent.authorize_msg = authorizeInfo != null ? authorizeInfo.authorize_desc : "";
                payResultContent.feedback_info = balancePayResponse.feedback_info;
                payResultContent.trans_no = balancePayResponse.trans_no;
                payResultContent.redirect_sp_succpage_remain_time = balancePayResponse.redirect_sp_succpage_remain_time;
                payResultContent.fp_open_or_update_msg = balancePayResponse.fp_open_or_update_msg;
                payResultContent.compliance = balancePayResponse.compliance;
                payResultContent.title_url = balancePayResponse.title_url;
                payResultContent.order_no = balancePayResponse.order_no;
                StatHelper.cachePayAmount(Double.valueOf(balancePayResponse.cash_amount).doubleValue());
                statPaySuccess(1);
                if (balancePayResponse.toShowH5ResultPage()) {
                    PayDataCache.getInstance().setH5ResultParams(new H5ResultParams(balancePayResponse.redirect_sp_succpage_remain_time, balancePayResponse.pay_result_url, balancePayResponse.pay_result_params, balancePayResponse.show_h5_result, CashierDeskPayResult.PayScenario.BalancedPay));
                }
                this.mActivity.showPaySuccessPage(true, payResultContent, 1);
            }
        } else {
            this.mActivity.licaiBalancePaySuccess(3, i2, obj);
        }
    }

    public boolean isFingerprintPay() {
        if (this.mCheckForWhat == CheckForWhat.FOR_ONEKEYPAY && this.mPayRequest.getPayWay() == 2) {
            return true;
        }
        return false;
    }

    public PwdPayContract.protocolModel needshowProtocolContainer() {
        UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
        if (userInfo == null || this.mPayRequest == null) {
            return null;
        }
        PwdPayContract.protocolModel protocolmodel = new PwdPayContract.protocolModel();
        boolean z = true;
        if (!userInfo.getPassfreeSelected() && this.mPayRequest.getOpenPassFreeFlag() != 1) {
            z = false;
        }
        protocolmodel.checked = z;
        if (userInfo.getPassfreeProtocol() != null && !TextUtils.isEmpty(userInfo.getPassfreeProtocol().getPassfreeProtocolPrefix()) && !TextUtils.isEmpty(userInfo.getPassfreeProtocol().getPassfreeProtocolMsg()) && !TextUtils.isEmpty(userInfo.getPassfreeProtocol().getPassfreeProtocolUrl())) {
            protocolmodel.passfree_protocol_msg = userInfo.getPassfreeProtocol().getPassfreeProtocolMsg();
            protocolmodel.passfree_protocol_prefix = userInfo.getPassfreeProtocol().getPassfreeProtocolPrefix();
            protocolmodel.passfree_protocol_url = userInfo.getPassfreeProtocol().getPassfreeProtocolUrl();
        }
        protocolmodel.iClickCallback = this;
        return protocolmodel;
    }

    public boolean onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        if (!PayDataCache.getInstance().isPassFree() && !isFingerprintPay()) {
            this.mActivity.showPWdInputView(true);
        }
        ErrorContentResponse errorContentResponse = null;
        if (obj != null && (obj instanceof ErrorContentResponse)) {
            errorContentResponse = (ErrorContentResponse) obj;
        }
        clearPayPwdCache(i3);
        if (i3 == 100015 && errorContentResponse != null && "1".equals(errorContentResponse.use_vcode_to_pay)) {
            this.mActivity.showPassError(str);
            this.mPayRequest.mUseVcodeToPay = errorContentResponse.use_vcode_to_pay;
            triggleSmsPay();
            this.mActivity.finishWithoutAnim();
            return true;
        } else if (errorContentResponse == null || !"1".equals(errorContentResponse.need_other_pay_method)) {
            return super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
        } else {
            PwdPayActivity pwdPayActivity = this.mActivity;
            pwdPayActivity.mDialogMsg = str;
            WalletGlobalUtils.safeShowDialog(pwdPayActivity, 36, "");
            return true;
        }
    }

    public void onCreate(Bundle bundle) {
        Serializable serializable;
        this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (!(bundle == null || (serializable = bundle.getSerializable("checkforwhat")) == null || !(serializable instanceof CheckForWhat))) {
            this.mCheckForWhat = (CheckForWhat) serializable;
        }
        if (this.mPayRequest == null) {
            PwdPayActivity pwdPayActivity = this.mActivity;
            PayCallBackManager.callBackClientCancel(pwdPayActivity, this.TAG + "onCreate().1");
            this.mActivity.finishWithoutAnim();
            return;
        }
        refreshPara();
    }

    public void onDestroy() {
    }

    public void onFPCheckCancel() {
        if (PayDataCache.getInstance().isFromPreCashier()) {
            PayCallBackManager.callBackClientCancel(this.mActivity, "doVerifyFingerprint().1");
        } else {
            this.mActivity.finish();
        }
    }

    public void onFPCheckOK(String str) {
        this.mPayRequest.storeFingerprintData(str);
        if (this.mPayRequest.mFingerprintPay instanceof SysFingerprintPay) {
            StatHelper.statPayAllServiceEvent("fp_sys_verify_success_pay", PwdPayActivity.PWD_PAY_HASH_NAME, PwdPayActivity.PWD_PAY_HASH_ID, "指纹验证成功", new String[0]);
        } else {
            StatisticManager.onEvent("fp_fido_verify_success_pay");
        }
        doPay();
    }

    public void onPause() {
    }

    public void onProtocolClicked(boolean z) {
        this.mPayRequest.applyNoPwd(z);
    }

    public void onPwdChanged(String str) {
        if (this.mCheckForWhat == CheckForWhat.FOR_ONEKEYPAY) {
            this.pwdword = str;
            PayRequest payRequest = this.mPayRequest;
            if (payRequest != null) {
                CardData.BondCard bondCard = payRequest.mBondCard;
                boolean z = bondCard != null && bondCard.isCheckPass;
                this.checkPass = z;
                if (z) {
                    doCheckPwd(str);
                } else {
                    doPay();
                }
            }
        } else {
            doCheckPwd(str);
        }
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("checkforwhat", this.mCheckForWhat);
    }

    public void onTurntoPwdPay(boolean z) {
        if (z) {
            this.mPayRequest.supportFingerprintPay = false;
        }
        this.mPayRequest.setPayWay(3);
        refreshPara();
    }

    public void pwdAndFpTypeChange() {
        if (isPwdOnekeypay()) {
            this.mPayRequest.setPayWay(2);
            if (PayDataCache.getInstance().isFromPreCashier()) {
                this.mActivity.doVerifyFingerprint(this.mPayRequest.mFingerprintPay);
            } else {
                this.mActivity.finish();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("pay_from", StatHelper.getPayFrom());
            ArrayList arrayList = new ArrayList();
            arrayList.add(StatHelper.getOrderNo());
            hashMap.put(StatHelper.PAY_WAY, "1");
            StatisticManager.onEventWithValues(PayStatServiceEvent.CHANGE_PAY_WAY, (Collection<String>) arrayList, (Map<String, Object>) hashMap);
        } else if (isFingerprintPay()) {
            this.mActivity.turntoPwdPay(false, (String) null);
        }
    }

    public boolean shouldFullScreenLoading() {
        if (PayDataCache.getInstance().isFromPreCashier()) {
            return isFingerprintPay() || PayDataCache.getInstance().isPassFree();
        }
        return false;
    }

    public boolean showSucAnim() {
        return !shouldFullScreenLoading();
    }
}
