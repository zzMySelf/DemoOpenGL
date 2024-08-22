package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.a;
import com.baidu.wallet.paysdk.beans.ae;
import com.baidu.wallet.paysdk.beans.af;
import com.baidu.wallet.paysdk.beans.h;
import com.baidu.wallet.paysdk.beans.j;
import com.baidu.wallet.paysdk.beans.v;
import com.baidu.wallet.paysdk.beans.z;
import com.baidu.wallet.paysdk.datamodel.AuthorizeInfo;
import com.baidu.wallet.paysdk.datamodel.BalancePayResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.datamodel.VerifyByBankResponse;
import com.baidu.wallet.paysdk.datamodel.VerifyCodeResponse;
import com.baidu.wallet.paysdk.datamodel.b;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.dxmpay.wallet.core.beans.sm.SMManagerDelegate;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;

public class d implements a {
    public CardData.BondCard a;
    public PayRequest b;
    public PayBaseActivity c;
    public SmsUpdateUiInterface d;
    public ErrorContentResponse e;
    public String f;
    public SmsVerifyHandler g;
    public PwdRequest h;

    /* renamed from: i  reason: collision with root package name */
    public h f3604i;
    public z j;
    public boolean k = false;
    public String l = "";
    public af m;
    public boolean n;

    private void c() {
        j jVar = (j) PayBeanFactory.getInstance().getBean((Context) this.c, 263, ISmsController.BEAN_TAG);
        jVar.setResponseCallback(this.c);
        jVar.execBean();
    }

    private void d() {
        a aVar = (a) PayBeanFactory.getInstance().getBean((Context) this.c, 14, ISmsController.BEAN_TAG);
        aVar.setResponseCallback(this.c);
        aVar.execBean();
    }

    private void e() {
        v vVar = (v) PayBeanFactory.getInstance().getBean((Context) this.c, (int) PayBeanFactory.BEAN_ID_LICAI_BALANCE_PAY, ISmsController.BEAN_TAG);
        vVar.setResponseCallback(this.c);
        vVar.execBean();
    }

    private void f() {
        boolean z = false;
        StatHelper.statPayAllServiceEvent(this.n ? StatServiceEvent.EVENT_CONFIRM_PAY_FROM_SMS_VERIFY : StatServiceEvent.EVENT_CONFIRM_PAY_BY_SMS, WalletSmsActivity.PAY_SMS_HASH_NAME, WalletSmsActivity.PAY_SMS_HASH_ID, "输完短信验证码，点击确认", new String[0]);
        if (this.j == null) {
            this.j = (z) PayBeanFactory.getInstance().getBean((Context) this.c, 13, ISmsController.BEAN_TAG);
        }
        this.j.setResponseCallback(this.c);
        if (PayRequestCache.getInstance().isBondPay()) {
            this.j.a(true);
        }
        int intExtra = this.c.getIntent().getIntExtra(DxmPayBeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
        z zVar = this.j;
        if (intExtra == 5320) {
            z = true;
        }
        zVar.b(z);
        this.j.execBean();
    }

    private String g() {
        CardData.BondCard bondCard;
        if (!TextUtils.isEmpty(this.f)) {
            return SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.f));
        }
        if (!PayRequestCache.getInstance().isBondPay() || (bondCard = this.a) == null) {
            return ((BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name())).getSendSmsphone();
        }
        return bondCard.mobile;
    }

    /* access modifiers changed from: private */
    public String h() {
        PayRequest payRequest = this.b;
        if (payRequest == null) {
            return "";
        }
        if (payRequest.mMktSolution != null) {
            return String.format(ResUtils.getString(this.c, "wallet_base_confirm_pay"), new Object[]{StringUtils.fen2Yuan(this.b.mMktSolution.easypay_amount)});
        }
        return String.format(ResUtils.getString(this.c, "wallet_base_confirm_pay"), new Object[]{StringUtils.fen2Yuan(this.b.getFinalPayAmount())});
    }

    private void i() {
        if (5320 == this.c.getIntent().getIntExtra(DxmPayBeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) && this.d != null) {
            ErrorContentResponse.Verify verify = (ErrorContentResponse.Verify) this.c.getIntent().getSerializableExtra(DxmPayBeanConstants.EXTRA_VERIFY_VOICE_DATA);
            this.d.upDateSafeKeyBoradView(verify.sms_length, verify.sms_type);
        }
    }

    public boolean doOnBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        if (i3 == 80320 || i3 == 80321 || i3 == 80326 || i3 == 80327) {
            WalletGlobalUtils.safeDismissDialog(this.c, 0);
            PayDataCache.getInstance().cleanDetainmentDesc();
            if (obj instanceof ErrorContentResponse) {
                this.e = (ErrorContentResponse) obj;
                if (!TextUtils.isEmpty(str)) {
                    this.l = str;
                    PayBaseActivity payBaseActivity = this.c;
                    payBaseActivity.mPayErrorCode = i3;
                    payBaseActivity.mBeanId = i2;
                    WalletGlobalUtils.safeShowDialog(payBaseActivity, ISmsController.DIALOG_CANNOT_DISCOUNT, "");
                }
            }
            return true;
        } else if (i3 != 15500 || obj == null || !(obj instanceof ErrorContentResponse)) {
            return false;
        } else {
            this.l = str;
            PayBaseActivity payBaseActivity2 = this.c;
            payBaseActivity2.mPayErrorCode = i3;
            payBaseActivity2.mBeanId = i2;
            this.e = (ErrorContentResponse) obj;
            WalletGlobalUtils.safeDismissDialog(payBaseActivity2, 0);
            WalletGlobalUtils.safeShowDialog(this.c, 65316, "");
            return true;
        }
    }

    public Dialog doOnCreateDialog(int i2) {
        if (i2 == 65315) {
            PromptMultiBtnDialog promptMultiBtnDialog = new PromptMultiBtnDialog(this.c.getActivity());
            promptMultiBtnDialog.setNewDialogStyle(false);
            return promptMultiBtnDialog;
        } else if (i2 != 65316) {
            return null;
        } else {
            PromptMultiBtnDialog promptMultiBtnDialog2 = new PromptMultiBtnDialog(this.c.getActivity());
            promptMultiBtnDialog2.setNewDialogStyle(false);
            return promptMultiBtnDialog2;
        }
    }

    public void doOnDestroy() {
        this.c = null;
    }

    public void doOnEvent() {
        StatisticManager.onEvent("clickInputVcode");
    }

    public boolean doOnPrepareDialog(int i2, Dialog dialog) {
        switch (i2) {
            case ISmsController.DIALOG_CANNOT_DISCOUNT:
                return b((PromptMultiBtnDialog) dialog);
            case 65316:
                return a((PromptMultiBtnDialog) dialog);
            case ISmsController.DIALOG_CARDBALANCE_NOT_ENOUGH:
                return a((PromptDialog) dialog);
            default:
                return false;
        }
    }

    public void doOnSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("mPwdRequest", this.h);
        bundle.putSerializable("mPayRequest", this.b);
        bundle.putBoolean("mPayBySmsCode", this.n);
        bundle.putSerializable("mCardInfoUpdateContent", this.e);
        bundle.putString("phone_no", this.f);
    }

    public boolean handleFailure(int i2, int i3, String str) {
        if (i2 == 5) {
            if (i3 == 5003) {
                AccountManager.getInstance(this.c.getActivity()).logout();
                WalletLoginHelper.getInstance().logout(false);
            }
            a(i2, i3, str);
            return true;
        } else if (i2 == 13 || i2 == 14 || i2 == 263 || i2 == 622) {
            WalletGlobalUtils.safeDismissDialog(this.c, 0);
            if (i3 == 5003) {
                AccountManager.getInstance(this.c.getActivity()).logout();
                WalletLoginHelper.getInstance().logout(false);
            } else if (i3 == 60500) {
                this.l = str;
                PayBaseActivity payBaseActivity = this.c;
                payBaseActivity.mPayErrorCode = i3;
                payBaseActivity.mBeanId = i2;
                WalletGlobalUtils.safeShowDialog(payBaseActivity, ISmsController.DIALOG_CARDBALANCE_NOT_ENOUGH, "");
            } else if (65312 == i3 || 65301 == i3) {
                if (65301 == i3) {
                    WalletFingerprint.getInstance(this.c).clearOTPToken();
                    StatisticManager.onEvent(StatServiceEvent.EVENT_65301_ON_FP_SMSACT);
                } else {
                    StatisticManager.onEvent("fp_sys_65312_on_smsact");
                }
                PayBaseActivity payBaseActivity2 = this.c;
                if (payBaseActivity2 != null) {
                    GlobalUtils.toast(payBaseActivity2, ResUtils.getString(payBaseActivity2, "bd_wallet_fingerprint_auth_failed"));
                    this.c.finish();
                }
                PayRequest payRequest = this.b;
                if (payRequest != null) {
                    payRequest.setPayWay(3);
                    PayController.getInstance().gotoPwdPay(this.c);
                }
            } else {
                if (55000 == i3 || 55001 == i3) {
                    new SMManagerDelegate().deleteUserKeyId(this.c);
                }
                SmsVerifyHandler smsVerifyHandler = this.g;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsVerifyFailure(i3, str);
                }
            }
            StatisticManager.onEventWithValue("onekeyPayAcceptFail", String.valueOf(i3));
            return true;
        } else if (i2 != 9 && i2 != 264) {
            return false;
        } else {
            a(i2, i3, str);
            return true;
        }
    }

    public boolean handleResponse(int i2, Object obj, String str) {
        if (i2 == 5) {
            WalletGlobalUtils.safeDismissDialog(this.c, 0);
            return e(obj);
        } else if (i2 == 13) {
            SmsVerifyHandler smsVerifyHandler = this.g;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsVerifySuccess();
            }
            return false;
        } else if (i2 == 9) {
            WalletGlobalUtils.safeDismissDialog(this.c, 0);
            return d(obj);
        } else if (i2 == 14) {
            WalletGlobalUtils.safeDismissDialog(this.c, 0);
            return c(obj);
        } else if (i2 == 263) {
            SmsVerifyHandler smsVerifyHandler2 = this.g;
            if (smsVerifyHandler2 != null) {
                smsVerifyHandler2.onSmsVerifySuccess();
            }
            return false;
        } else if (i2 == 264) {
            WalletGlobalUtils.safeDismissDialog(this.c, 0);
            return b(obj);
        } else if (i2 == 15) {
            return a(obj);
        } else {
            if (i2 == 622) {
                WalletGlobalUtils.safeDismissDialog(this.c, 0);
                SmsVerifyHandler smsVerifyHandler3 = this.g;
                if (smsVerifyHandler3 != null) {
                    smsVerifyHandler3.onSmsVerifySuccess();
                }
            }
            return false;
        }
    }

    public void initSmsActivityView() {
        String string = ResUtils.getString(this.c, "ebpay_submit_pay");
        PayRequest payRequest = this.b;
        if (payRequest != null) {
            if (payRequest.mMktSolution != null) {
                string = String.format(ResUtils.getString(this.c, "wallet_base_confirm_pay"), new Object[]{StringUtils.fen2Yuan(this.b.mMktSolution.easypay_amount)});
            } else {
                string = String.format(ResUtils.getString(this.c, "wallet_base_confirm_pay"), new Object[]{StringUtils.fen2Yuan(this.b.getFinalPayAmount())});
            }
        }
        String str = string;
        PayRequest payRequest2 = this.b;
        if (payRequest2 != null) {
            this.a = payRequest2.mBondCard;
            if (this.d != null) {
                this.d.initSMSActivityView("ebpay_sms_title_tip_security_check", this.n ? ResUtils.getString(this.c, "ebpay_sms_pwd_error_tip") : "", str, g(), true);
            }
        }
    }

    public boolean isBelongPaySDK() {
        return true;
    }

    public boolean isSendSmsOnCreate() {
        i();
        return 5320 != this.c.getIntent().getIntExtra(DxmPayBeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
    }

    public boolean onCreateCheckInvalide(Bundle bundle) {
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("mPwdRequest");
            if (serializable != null && (serializable instanceof PwdRequest)) {
                this.h = (PwdRequest) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("mPayRequest");
            if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                this.b = (PayRequest) serializable2;
            }
            Serializable serializable3 = bundle.getSerializable("payBySmsCode");
            if (serializable3 != null && (serializable3 instanceof Boolean)) {
                this.n = ((Boolean) serializable3).booleanValue();
            }
            Serializable serializable4 = bundle.getSerializable("mCardInfoUpdateContent");
            if (serializable4 != null && (serializable4 instanceof ErrorContentResponse)) {
                this.e = (ErrorContentResponse) serializable4;
            }
            this.f = bundle.getString("phone_no");
        } else {
            this.h = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
            this.b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            this.n = this.c.getIntent().getBooleanExtra("pay_by_smscode", false);
            Serializable serializableExtra = this.c.getIntent().getSerializableExtra(DxmPayBeanConstants.EXTRA_VERIFY_VOICE_DATA);
            if (serializableExtra != null) {
                this.f = ((ErrorContentResponse.Verify) serializableExtra).getVerifyMobile();
            }
        }
        if (this.b != null) {
            PayRequestCache.getInstance().addBeanRequestToCache(this.b.getRequestId(), this.b);
            if (this.h != null) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.h.getRequestId(), this.h);
            }
            this.k = isSendSmsOnCreate();
            return true;
        }
        PayCallBackManager.callBackClientCancel(this.c, "SmsControllerForPaySMS.onCreateCheckInvalide().1");
        return false;
    }

    public void onNextBtnClick(String str) {
        BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        if (bindFastRequest != null) {
            bindFastRequest.mSmsVCode = str;
        }
        PayRequest payRequest = this.b;
        if (payRequest != null) {
            payRequest.mSmsCode = str;
        }
        WalletGlobalUtils.safeShowDialog(this.c, 0, "");
        PayRequest.PayPrice.PayType a2 = a();
        if (a2 == PayRequest.PayPrice.PayType.BANKCARD) {
            f();
        } else if (a2 == PayRequest.PayPrice.PayType.BALANCE) {
            d();
        } else if (a2 == PayRequest.PayPrice.PayType.CREIDT) {
            c();
        } else if (a2 == PayRequest.PayPrice.PayType.LICAIBALANCE) {
            e();
        }
    }

    public void sendSms(boolean z) {
        PayBaseActivity payBaseActivity = this.c;
        if (payBaseActivity != null) {
            if (this.k) {
                WalletGlobalUtils.safeShowDialog(payBaseActivity, 0, "");
            }
            if (this.c.getIntent().getIntExtra(DxmPayBeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320) {
                b();
                return;
            }
            PayRequest.PayPrice.PayType a2 = a();
            if (a2 == PayRequest.PayPrice.PayType.BANKCARD) {
                a(z);
            } else if (a2 == PayRequest.PayPrice.PayType.BALANCE || a2 == PayRequest.PayPrice.PayType.CREIDT || a2 == PayRequest.PayPrice.PayType.LICAIBALANCE) {
                a(a2);
            }
        }
    }

    public void setActivity(PayBaseActivity payBaseActivity) {
        this.c = payBaseActivity;
    }

    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        this.d = smsUpdateUiInterface;
    }

    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        this.g = smsVerifyHandler;
    }

    private void b() {
        ae aeVar = (ae) PayBeanFactory.getInstance().getBean((Context) this.c, (int) PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, ISmsController.BEAN_TAG);
        aeVar.setResponseCallback(this.c);
        aeVar.execBean();
    }

    private void a(PayRequest.PayPrice.PayType payType) {
        String str = this.f;
        PayRequest payRequest = this.b;
        b bVar = new b(str, payRequest.mSpNO, payRequest.mOrderNo, b(payType));
        PayRequestCache.getInstance().addBeanRequestToCache(bVar.getRequestId(), bVar);
        if (this.m == null) {
            this.m = (af) PayBeanFactory.getInstance().getBean((Context) this.c, 9, ISmsController.BEAN_TAG);
        }
        this.m.setResponseCallback(this.c);
        this.m.execBean();
    }

    private boolean c(Object obj) {
        SmsVerifyHandler smsVerifyHandler = this.g;
        if (smsVerifyHandler != null) {
            smsVerifyHandler.onSmsVerifySuccess();
        }
        if (!PayDataCache.getInstance().isFromPreCashier() || !com.baidu.wallet.paysdk.c.a.a().c()) {
            if (obj != null && (obj instanceof BalancePayResponse)) {
                BalancePayResponse balancePayResponse = (BalancePayResponse) obj;
                PayResultContent payResultContent = new PayResultContent();
                payResultContent.notify = balancePayResponse.notify;
                payResultContent.paytype_desc = balancePayResponse.paytype_desc;
                payResultContent.coupon_msg = balancePayResponse.coupon_msg;
                BalancePayResponse.Business business = balancePayResponse.business;
                if (business != null) {
                    String str = business.stream_recharge_msg;
                    if (str != null) {
                        payResultContent.stream_recharge_msg = str;
                    }
                    String str2 = balancePayResponse.business.expected_time;
                    if (str2 != null) {
                        payResultContent.expected_time = str2;
                    }
                }
                payResultContent.coupon_find_prompt = balancePayResponse.coupon_find_prompt;
                payResultContent.total_amount = balancePayResponse.total_amount;
                payResultContent.cash_amount = balancePayResponse.cash_amount;
                payResultContent.discount_amount = balancePayResponse.discount_amount;
                payResultContent.pay_detail_info = balancePayResponse.pay_detail_info;
                payResultContent.paytype_info = balancePayResponse.paytype_info;
                payResultContent.order_no = balancePayResponse.order_no;
                AuthorizeInfo authorizeInfo = balancePayResponse.authorize_info;
                payResultContent.authorize_msg = authorizeInfo != null ? authorizeInfo.authorize_desc : "";
                payResultContent.order_prefix = balancePayResponse.order_prefix;
                payResultContent.discount_prefix = balancePayResponse.discount_prefix;
                payResultContent.payResultCashbackDetail = balancePayResponse.cashback_dialog_detail;
                payResultContent.feedback_info = balancePayResponse.feedback_info;
                payResultContent.trans_no = balancePayResponse.trans_no;
                payResultContent.redirect_sp_succpage_remain_time = balancePayResponse.redirect_sp_succpage_remain_time;
                payResultContent.fp_open_or_update_msg = balancePayResponse.fp_open_or_update_msg;
                payResultContent.compliance = balancePayResponse.compliance;
                StatHelper.cachePayAmount(Double.valueOf(balancePayResponse.cash_amount).doubleValue());
                a(1);
                if (balancePayResponse.toShowH5ResultPage()) {
                    PayDataCache.getInstance().setH5ResultParams(new H5ResultParams(balancePayResponse.redirect_sp_succpage_remain_time, balancePayResponse.pay_result_url, balancePayResponse.pay_result_params, balancePayResponse.show_h5_result, CashierDeskPayResult.PayScenario.BalancedPay));
                }
                PayController.getInstance().paySucess(this.c, payResultContent, 1);
            }
            return true;
        }
        this.c.licaiBalancePaySuccess(3, 14, obj);
        return true;
    }

    private boolean d(Object obj) {
        VerifyCodeResponse verifyCodeResponse = obj instanceof VerifyCodeResponse ? (VerifyCodeResponse) obj : null;
        if (this.k) {
            this.k = false;
        }
        SmsUpdateUiInterface smsUpdateUiInterface = this.d;
        if (!(smsUpdateUiInterface == null || verifyCodeResponse == null)) {
            smsUpdateUiInterface.upDateSafeKeyBoradView(verifyCodeResponse.sms_length, verifyCodeResponse.sms_type);
        }
        SmsVerifyHandler smsVerifyHandler = this.g;
        if (smsVerifyHandler == null) {
            return true;
        }
        smsVerifyHandler.onSmsSendSuccess();
        return true;
    }

    private boolean e(Object obj) {
        CheckCardInfoResponse checkCardInfoResponse;
        if (obj == null || !(obj instanceof CheckCardInfoResponse)) {
            checkCardInfoResponse = null;
        } else {
            checkCardInfoResponse = (CheckCardInfoResponse) obj;
            PayRequest payRequest = this.b;
            if (payRequest != null) {
                payRequest.mChannelNo = checkCardInfoResponse.channel_no;
            }
        }
        this.k = false;
        SmsUpdateUiInterface smsUpdateUiInterface = this.d;
        if (!(smsUpdateUiInterface == null || checkCardInfoResponse == null)) {
            smsUpdateUiInterface.upDateSafeKeyBoradView(checkCardInfoResponse.sms_length, checkCardInfoResponse.sms_type);
            this.d.updateModifyPhoneUI(!TextUtils.isEmpty(checkCardInfoResponse.update_mobile_desc), checkCardInfoResponse.update_mobile_desc);
            this.d.updateComplianceTipUI(checkCardInfoResponse.send_sms_tips);
            this.d.unableReceiveSmsTip(checkCardInfoResponse.display_reset_route);
        }
        SmsVerifyHandler smsVerifyHandler = this.g;
        if (smsVerifyHandler != null) {
            smsVerifyHandler.onSmsSendSuccess();
        }
        return true;
    }

    private String b(PayRequest.PayPrice.PayType payType) {
        ArrayList arrayList = new ArrayList();
        if (payType == PayRequest.PayPrice.PayType.BALANCE) {
            arrayList.addAll(PayDataCache.getInstance().getBalancePayPostInfo());
        } else if (payType == PayRequest.PayPrice.PayType.CREIDT) {
            arrayList.addAll(PayDataCache.getInstance().getCreditPayPostInfo());
        } else if (payType == PayRequest.PayPrice.PayType.LICAIBALANCE) {
            arrayList.addAll(PayDataCache.getInstance().getLicaiBalancePayPostInfo());
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if ("pay_type".equals(((RestNameValuePair) arrayList.get(i2)).getName())) {
                return ((RestNameValuePair) arrayList.get(i2)).getValue();
            }
        }
        return "";
    }

    private void a(boolean z) {
        if (this.f3604i == null) {
            this.f3604i = (h) PayBeanFactory.getInstance().getBean((Context) this.c, 5, ISmsController.BEAN_TAG);
        }
        if (PayRequestCache.getInstance().isBondPay()) {
            this.f3604i.a();
        }
        this.f3604i.a(z);
        this.f3604i.a(PayRequestCache.getBindRequest(this.c.getActivity()));
        this.f3604i.setResponseCallback(this.c);
        this.f3604i.execBean();
    }

    private boolean b(Object obj) {
        VerifyByBankResponse verifyByBankResponse = obj instanceof VerifyByBankResponse ? (VerifyByBankResponse) obj : null;
        if (this.k) {
            this.k = false;
        }
        SmsUpdateUiInterface smsUpdateUiInterface = this.d;
        if (!(smsUpdateUiInterface == null || verifyByBankResponse == null)) {
            smsUpdateUiInterface.upDateSafeKeyBoradView(verifyByBankResponse.sms_length, verifyByBankResponse.sms_type);
        }
        SmsVerifyHandler smsVerifyHandler = this.g;
        if (smsVerifyHandler == null) {
            return true;
        }
        smsVerifyHandler.onSmsSendSuccess();
        return true;
    }

    private boolean a(Object obj) {
        if (!(obj instanceof GetCardInfoResponse)) {
            return false;
        }
        this.c.finishWithoutAnim();
        PayController.getInstance().completeCardPay(this.c, this.b.mBondCard, (GetCardInfoResponse) obj);
        return true;
    }

    private void a(int i2) {
        StatHelper.cachePayType(i2);
        if (PayDataCache.getInstance().isFromPreCashier()) {
            StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY);
            StatHelper.statPayAllServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_SUCCESS, PayCallBackManager.PRE_HASH_NAME, PayCallBackManager.PRE_HASH_ID, PayCallBackManager.PAY_SUCCESS_MSG, new String[0]);
            return;
        }
        StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY);
        StatHelper.statPayAllServiceEvent(PayStatServiceEvent.STD_PAY_SUCCESS, PayCallBackManager.STD_HASH_NAME, PayCallBackManager.STD_HASH_ID, PayCallBackManager.PAY_SUCCESS_MSG, new String[0]);
    }

    private boolean b(PromptMultiBtnDialog promptMultiBtnDialog) {
        StatisticManager.onEvent("showOrigPriceAlert");
        promptMultiBtnDialog.setMessage((CharSequence) this.l);
        promptMultiBtnDialog.setFirstBtn(ResUtils.getString(this.c, "bd_wallet_pay_by_order_price"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                PayBaseActivity payBaseActivity = d.this.c;
                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "bd_wallet_pay_by_order_price"));
                StatisticManager.onEvent("origPriceFromAlert");
                d dVar = d.this;
                ErrorContentResponse errorContentResponse = dVar.e;
                if (errorContentResponse != null && errorContentResponse.mkt_solution != null) {
                    if (dVar.f3604i == null) {
                        h unused = d.this.f3604i = (h) PayBeanFactory.getInstance().getBean((Context) d.this.c, 5, ISmsController.BEAN_TAG);
                    }
                    ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY)).setMktSolution(d.this.e.mkt_solution);
                    if (PayRequestCache.getInstance().isBondPay()) {
                        d.this.f3604i.a();
                    }
                    d.this.f3604i.setResponseCallback(d.this.c);
                    d.this.f3604i.execBean();
                    WalletGlobalUtils.safeShowDialog(d.this.c, 0, "");
                    WalletGlobalUtils.safeDismissDialog(d.this.c, ISmsController.DIALOG_CANNOT_DISCOUNT);
                    d dVar2 = d.this;
                    if (dVar2.d != null) {
                        String b = dVar2.h();
                        if (!TextUtils.isEmpty(b)) {
                            d.this.d.updateButtonTip(b);
                        }
                    }
                    SmsUpdateUiInterface smsUpdateUiInterface = d.this.d;
                    if (smsUpdateUiInterface != null) {
                        smsUpdateUiInterface.clearSmsEditText();
                        d.this.d.doStartCountDown();
                    }
                }
            }
        });
        promptMultiBtnDialog.setSecondBtn(ResUtils.getString(this.c, "ebpay_use_other_paytype"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                PayBaseActivity payBaseActivity = d.this.c;
                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_use_other_paytype"));
                WalletGlobalUtils.safeDismissDialog(d.this.c, ISmsController.DIALOG_CANNOT_DISCOUNT);
                PayController.getInstance().gotoPayTypePage(d.this.c, false);
                d.this.c.finish();
            }
        });
        promptMultiBtnDialog.setThirdBtn("取消", (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                d.this.c.addDoPayorCheckCardStatistics("取消");
                WalletGlobalUtils.safeDismissDialog(d.this.c, ISmsController.DIALOG_CANNOT_DISCOUNT);
            }
        });
        return true;
    }

    private void a(int i2, int i3, String str) {
        if (this.k) {
            this.k = false;
        }
        SmsUpdateUiInterface smsUpdateUiInterface = this.d;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.clearSmsEditText();
            this.d.doStopCountDown();
            this.d.unableReceiveSmsTip((String) null);
        }
        WalletGlobalUtils.safeDismissDialog(this.c, 0);
        if (TextUtils.isEmpty(str)) {
            str = ResUtils.getString(this.c.getActivity(), "ebpay_send_fail");
        }
        SmsVerifyHandler smsVerifyHandler = this.g;
        if (smsVerifyHandler != null) {
            smsVerifyHandler.onSmsSendFailure(i3, str);
        }
    }

    private boolean a(PromptMultiBtnDialog promptMultiBtnDialog) {
        StatisticManager.onEvent("showCardOverDue");
        promptMultiBtnDialog.setMessage((CharSequence) this.l);
        promptMultiBtnDialog.setFirstBtn(ResUtils.string(this.c, "ebpay_wallet_continue_pay"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                PayBaseActivity payBaseActivity = d.this.c;
                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_wallet_continue_pay"));
                StatisticManager.onEvent("continueFromCardOverdue");
                BindFastRequest bindFastRequest = new BindFastRequest();
                bindFastRequest.mBindFrom = 2;
                PayRequest payRequest = d.this.b;
                if (payRequest != null) {
                    bindFastRequest.mBondCard = payRequest.mBondCard;
                }
                PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
                WalletGlobalUtils.safeDismissDialog(d.this.c, 65316);
                PayController instance = PayController.getInstance();
                d dVar = d.this;
                instance.updateCardInfoPay(dVar.c, dVar.e);
                d.this.c.finishWithoutAnim();
            }
        });
        promptMultiBtnDialog.setSecondBtn(ResUtils.string(this.c, "ebpay_use_other_paytype"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
                if (payRequest != null) {
                    payRequest.clearMktSolution();
                }
                PayBaseActivity payBaseActivity = d.this.c;
                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_use_other_paytype"));
                WalletGlobalUtils.safeDismissDialog(d.this.c, 65316);
                PayController.getInstance().gotoPayTypePage(d.this.c, false);
                d.this.c.finishWithoutAnim();
            }
        });
        promptMultiBtnDialog.setThirdBtn("取消", (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                d.this.c.addDoPayorCheckCardStatistics("取消");
                WalletGlobalUtils.safeDismissDialog(d.this.c, 65316);
            }
        });
        return true;
    }

    private boolean a(PromptDialog promptDialog) {
        promptDialog.setMessage((CharSequence) this.l);
        promptDialog.setNegativeBtn(ResUtils.getString(this.c, "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                PayBaseActivity payBaseActivity = d.this.c;
                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "dxm_ebpay_know"));
                WalletGlobalUtils.safeDismissDialog(d.this.c, ISmsController.DIALOG_CARDBALANCE_NOT_ENOUGH);
            }
        });
        promptDialog.setPositiveBtn(ResUtils.getString(this.c, "ebpay_use_other_paytype"), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                PayBaseActivity payBaseActivity = d.this.c;
                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_use_other_paytype"));
                WalletGlobalUtils.safeDismissDialog(d.this.c, ISmsController.DIALOG_CARDBALANCE_NOT_ENOUGH);
                PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
                if (payRequest != null) {
                    payRequest.clearMktSolution();
                }
                PayController.getInstance().gotoPayTypePage(d.this.c, false);
                d.this.c.finish();
            }
        });
        return true;
    }

    public PayRequest.PayPrice.PayType a() {
        return this.b.getPayPrice().payType;
    }
}
