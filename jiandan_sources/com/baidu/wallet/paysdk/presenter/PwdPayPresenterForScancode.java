package com.baidu.wallet.paysdk.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.contract.PwdPayContract;
import com.baidu.wallet.paysdk.datamodel.O2OPayResultItemInfo;
import com.baidu.wallet.paysdk.datamodel.O2OTransInfo;
import com.baidu.wallet.paysdk.datamodel.PayQueryRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.ScanCodeConstant;
import com.baidu.wallet.paysdk.datamodel.ScanCodeLimitPayResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Collection;
import java.util.HashMap;

public class PwdPayPresenterForScancode extends PwdPayContract.Presenter {
    public boolean isQuerying = false;
    public boolean mCheckSMS = false;
    public O2OTransInfo mOrderInfo;
    public PayQueryRequest mQueryRequest;

    public PwdPayPresenterForScancode(PwdPayActivity pwdPayActivity, Intent intent) {
        super(pwdPayActivity);
        if (intent != null) {
            this.mOrderInfo = (O2OTransInfo) intent.getSerializableExtra(ScanCodeConstant.ORDER_INFO_KEY);
            this.mCheckSMS = intent.getBooleanExtra("checkSms", false);
        }
    }

    private void scancodePay() {
        LocalRouter.getInstance(this.mActivity).route(this.mActivity, new RouterRequest().provider("scancode").action("getLimitPayBean"), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (i2 == 0 && hashMap != null && hashMap.get("data") != null) {
                    Object obj = hashMap.get("data");
                    if (obj != null && (obj instanceof BaseBean)) {
                        BaseBean baseBean = (BaseBean) obj;
                        baseBean.setBeanParams(PwdPayPresenterForScancode.this.mOrderInfo.sp_no, PwdPayPresenterForScancode.this.mOrderInfo.order_no, PwdPayPresenterForScancode.this.mOrderInfo.pay_code, "");
                        baseBean.setResponseCallback(PwdPayPresenterForScancode.this);
                        baseBean.execBean();
                    }
                } else if (i2 == 5) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("provider", "scancode");
                    hashMap2.put("action", "getLimitPayBean");
                    StatisticManager.onEventEndWithValues("sdk_router_error", i2, (Collection<String>) hashMap2.values());
                }
            }
        });
    }

    public boolean directQuit() {
        WalletGlobalUtils.safeShowDialog(this.mActivity, 18, "");
        return false;
    }

    public void handleFailure(int i2, int i3, String str) {
        this.mActivity.dismissLoading(-1);
        if (i2 == 594) {
            this.mActivity.showPWdInputView(true);
            clearPayPwdCache(i3);
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.mActivity, "dxm_fp_get_data_fail");
            }
            if (i3 == 5003) {
                AccountManager.getInstance(this.mActivity).logout();
                WalletLoginHelper.getInstance().logout(false);
            } else if (i3 == 15414 || i3 == 15432 || i3 == 100015) {
                this.mActivity.showPassError(str);
            } else if (i3 == 100018) {
                this.mActivity.showPassError(str);
            }
            if (i3 == 65235) {
                this.mActivity.showPassError(str);
            } else {
                this.mActivity.showPassError(str);
            }
        } else {
            super.handleFailure(i2, i3, str);
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        if (i2 == 257) {
            if (this.mCheckSMS) {
                this.mActivity.dismissLoading(-1);
                this.mActivity.showPWdInputView(true);
                triggleSmsPay();
                return;
            }
            scancodePay();
        } else if (i2 == 594) {
            this.isQuerying = false;
            ScanCodeLimitPayResponse scanCodeLimitPayResponse = (ScanCodeLimitPayResponse) obj;
            if (scanCodeLimitPayResponse.checkResponseValidity()) {
                O2OTransInfo o2OTransInfo = this.mOrderInfo;
                o2OTransInfo.notify = scanCodeLimitPayResponse.notify;
                o2OTransInfo.score_tip = scanCodeLimitPayResponse.score_tip;
                if ("2".equalsIgnoreCase(scanCodeLimitPayResponse.pay_type)) {
                    if (this.mQueryRequest == null) {
                        this.mQueryRequest = new PayQueryRequest();
                    }
                    PayQueryRequest payQueryRequest = this.mQueryRequest;
                    payQueryRequest.mBankNo = scanCodeLimitPayResponse.bank_no;
                    payQueryRequest.mOrderNo = scanCodeLimitPayResponse.bank_send_trans_no;
                    PayRequestCache.getInstance().addBeanRequestToCache(this.mQueryRequest.getRequestId(), this.mQueryRequest);
                    this.mActivity.queryPayResult();
                } else if (scanCodeLimitPayResponse != null || this.mOrderInfo != null) {
                    PayRequest payRequest = new PayRequest();
                    payRequest.setPayFrom(DxmPayBeanConstants.PAY_FROM_B_SAO_C);
                    payRequest.mGoodName = this.mOrderInfo.goods_name;
                    PayRequestCache.getInstance().addBeanRequestToCache(payRequest.getRequestId(), payRequest);
                    this.mOrderInfo.paytype_desc = scanCodeLimitPayResponse.paytype_desc;
                    PayResultContent payResultContent = new PayResultContent();
                    payResultContent.notify = scanCodeLimitPayResponse.notify;
                    payResultContent.score_tip = scanCodeLimitPayResponse.score_tip;
                    payResultContent.paytype_desc = scanCodeLimitPayResponse.paytype_desc;
                    O2OPayResultItemInfo o2OPayResultItemInfo = scanCodeLimitPayResponse.pay_result;
                    if (o2OPayResultItemInfo != null) {
                        payResultContent.coupon_msg = o2OPayResultItemInfo.coupon_msg;
                        payResultContent.coupon_find_prompt = o2OPayResultItemInfo.coupon_find_prompt;
                        String str2 = o2OPayResultItemInfo.cash_amount;
                        payResultContent.cash_amount = str2;
                        payResultContent.total_amount = o2OPayResultItemInfo.total_amount;
                        payResultContent.discount_amount = o2OPayResultItemInfo.discount_amount;
                        payResultContent.pay_detail_info = o2OPayResultItemInfo.pay_detail_info;
                        payResultContent.paytype_info = o2OPayResultItemInfo.paytype_info;
                        payResultContent.discount_prefix = o2OPayResultItemInfo.discount_prefix;
                        payResultContent.order_prefix = o2OPayResultItemInfo.order_prefix;
                        payResultContent.redirect_sp_succpage_remain_time = o2OPayResultItemInfo.redirect_sp_succpage_remain_time;
                        StatHelper.cachePayAmount(Double.valueOf(str2).doubleValue());
                    }
                    this.mActivity.showPaySuccessPage(true, payResultContent, 1);
                }
            }
        } else if (i2 != 12) {
            super.handleResponse(i2, obj, str);
        } else if (this.mOrderInfo != null) {
            PayRequest payRequest2 = new PayRequest();
            payRequest2.setPayFrom(DxmPayBeanConstants.PAY_FROM_B_SAO_C);
            payRequest2.mGoodName = this.mOrderInfo.goods_name;
            PayRequestCache.getInstance().addBeanRequestToCache(payRequest2.getRequestId(), payRequest2);
        }
    }

    public boolean onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        clearPayPwdCache(i3);
        return false;
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.mOrderInfo = (O2OTransInfo) bundle.getSerializable(ScanCodeConstant.ORDER_INFO_KEY);
            this.mCheckSMS = bundle.getBoolean("checkSms", false);
        }
    }

    public void onDestroy() {
    }

    public void onFPCheckCancel() {
        this.mActivity.finish();
    }

    public void onFPCheckOK(String str) {
    }

    public void onPause() {
    }

    public void onPwdChanged(String str) {
        doCheckPwd(str);
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(ScanCodeConstant.ORDER_INFO_KEY, this.mOrderInfo);
        bundle.putSerializable("checkSms", Boolean.valueOf(this.mCheckSMS));
    }

    public void pwdAndFpTypeChange() {
    }

    public void triggleSmsPay() {
        StatisticManager.onEvent("triggleSmsVerify");
        Intent intent = new Intent();
        intent.setClass(this.mActivity, WalletSmsActivity.class);
        intent.putExtra(DxmPayBeanConstants.SMS_ACTIVITY_FROM_KEY, 10);
        intent.putExtra(ScanCodeConstant.ORDER_INFO_KEY, this.mOrderInfo);
        this.mActivity.startActivityWithoutAnim(intent);
    }
}
