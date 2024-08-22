package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.c.a;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PayResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardProtocolActivity;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.utils.StatHelper;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class z extends BaseBean<PayResponse> {
    public BindFastRequest a;
    public PwdRequest b;
    public PayRequest c;
    public boolean d;
    public boolean e;

    public z(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = false;
        this.e = false;
        this.a = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        this.b = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
        this.c = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
    }

    private List<RestNameValuePair> a() {
        ArrayList arrayList = new ArrayList();
        CardData.BondCard bondCard = this.c.mBondCard;
        StatHelper.cacheCardType(String.valueOf(bondCard.card_type));
        StatHelper.cacheBankCode(bondCard.bank_code);
        arrayList.add(new RestNameValuePair(StatHelper.CARD_TYPE, String.valueOf(bondCard.card_type)));
        arrayList.add(new RestNameValuePair("bind_flag", "1"));
        arrayList.add(new RestNameValuePair("need_bind_card", "0"));
        arrayList.add(new RestNameValuePair("reser", PayUtils.encrypt("phone_number", bondCard.mobile)));
        arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", bondCard.account_no)));
        arrayList.add(new RestNameValuePair("true_name", bondCard.true_name));
        arrayList.add(new RestNameValuePair("key", SecurePay.getInstance().getpwProxy()));
        if (!TextUtils.isEmpty(this.c.mSmsCode)) {
            arrayList.add(new RestNameValuePair("message_vcode", this.c.mSmsCode));
            this.c.mSmsCode = null;
        }
        if (!TextUtils.isEmpty(bondCard.account_bank_code)) {
            arrayList.add(new RestNameValuePair("account_bank_code", bondCard.account_bank_code));
        }
        arrayList.add(new RestNameValuePair(StatHelper.BANK_CODE, this.c.mChannelNo));
        arrayList.add(new RestNameValuePair("sub_bank_code", bondCard.bank_code));
        PwdRequest pwdRequest = this.b;
        if (pwdRequest != null && !TextUtils.isEmpty(pwdRequest.mPayPass)) {
            String seed = PasswordController.getSeed();
            arrayList.add(new RestNameValuePair("mobilepwd", PasswordController.handlePwd(this.b.mPayPass, seed)));
            arrayList.add(new RestNameValuePair("seed", SecurePay.getInstance().encryptProxy(seed)));
        } else if (!PayDataCache.getInstance().isPassFree() && this.c != null && !b.a()) {
            String generateOTPKey = WalletFingerprint.getInstance(this.mContext).generateOTPKey(this.c.otp_seed);
            String sn = WalletFingerprint.getInstance(this.mContext).getSN();
            if (!TextUtils.isEmpty(generateOTPKey) && !TextUtils.isEmpty(sn)) {
                arrayList.add(new RestNameValuePair("f_token_code", SecurePay.getInstance().encrypt(generateOTPKey)));
                arrayList.add(new RestNameValuePair("f_serial_num", SecurePay.getInstance().encrypt(sn)));
                if (!TextUtils.isEmpty(this.c.getOtpReuseCode())) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.FINGERPRINT_PAY_AGAIN, (Map<String, Object>) null, new String[0]);
                    arrayList.add(new RestNameValuePair(PayUtils.KEY_OTP_REUSE_CODE, SecurePay.getInstance().encrypt(this.c.getOtpReuseCode())));
                    this.c.setOtpReuseCode((String) null);
                }
            }
        }
        return arrayList;
    }

    private List<RestNameValuePair> b() {
        ArrayList arrayList = new ArrayList();
        CardData.BondCard bondCard = this.a.mBondCard;
        StatHelper.cacheCardType(String.valueOf(bondCard.card_type));
        StatHelper.cacheBankCode(String.valueOf(bondCard.bank_code));
        arrayList.add(new RestNameValuePair(StatHelper.CARD_TYPE, String.valueOf(bondCard.card_type)));
        arrayList.add(new RestNameValuePair("bind_flag", "1"));
        arrayList.add(new RestNameValuePair("need_bind_card", "0"));
        arrayList.add(new RestNameValuePair("reser", PayUtils.encrypt("phone_number", bondCard.mobile)));
        arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", bondCard.account_no)));
        arrayList.add(new RestNameValuePair("true_name", bondCard.true_name));
        arrayList.add(new RestNameValuePair("key", SecurePay.getInstance().getpwProxy()));
        if (!TextUtils.isEmpty(this.a.getmSmsVCode())) {
            arrayList.add(new RestNameValuePair("message_vcode", this.a.getmSmsVCode()));
            this.a.mSmsVCode = null;
        }
        if (!TextUtils.isEmpty(bondCard.account_bank_code)) {
            arrayList.add(new RestNameValuePair("account_bank_code", bondCard.account_bank_code));
        }
        arrayList.add(new RestNameValuePair(StatHelper.BANK_CODE, this.a.getChannelNo()));
        arrayList.add(new RestNameValuePair("sub_bank_code", bondCard.bank_code));
        if (this.b == null) {
            return arrayList;
        }
        a((List<RestNameValuePair>) arrayList);
        return arrayList;
    }

    private List<RestNameValuePair> c(boolean z) {
        ArrayList arrayList = new ArrayList();
        String valueOf = String.valueOf(z ? 1 : 2);
        StatHelper.cacheCardType(valueOf);
        StatHelper.cacheBankCode(this.a.mBankNo);
        arrayList.add(new RestNameValuePair(StatHelper.CARD_TYPE, valueOf));
        arrayList.add(new RestNameValuePair("bind_flag", "0"));
        arrayList.add(new RestNameValuePair("need_bind_card", "1"));
        if (!TextUtils.isEmpty(this.a.mSmsVCode)) {
            arrayList.add(new RestNameValuePair("message_vcode", this.a.mSmsVCode));
            this.a.mSmsVCode = null;
        }
        arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.a.mBankCard)));
        arrayList.add(new RestNameValuePair("key", SecurePay.getInstance().getpwProxy()));
        if (!TextUtils.isEmpty(this.a.getmName())) {
            arrayList.add(new RestNameValuePair("true_name", this.a.getmName()));
        }
        if (!TextUtils.isEmpty(this.a.getCertificateType())) {
            arrayList.add(new RestNameValuePair(BindCardProtocolActivity.IDENTITY_TYPE, this.a.getCertificateType()));
        }
        if (!TextUtils.isEmpty(this.a.getmIdCard())) {
            arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.a.getmIdCard())));
        }
        if (!TextUtils.isEmpty(this.a.getmPhone())) {
            arrayList.add(new RestNameValuePair("reser", PayUtils.encrypt("phone_number", this.a.getmPhone())));
        }
        if (!TextUtils.isEmpty(this.a.getmValidDate())) {
            arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.a.getmValidDate())));
        }
        if (!TextUtils.isEmpty(this.a.getmCvv())) {
            arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", this.a.getmCvv())));
        }
        arrayList.add(new RestNameValuePair("account_bank_code", this.a.getChannelNo()));
        arrayList.add(new RestNameValuePair(StatHelper.BANK_CODE, this.a.getChannelNo()));
        arrayList.add(new RestNameValuePair("sub_bank_code", this.a.mBankNo));
        if (this.b == null) {
            return arrayList;
        }
        a((List<RestNameValuePair>) arrayList);
        return arrayList;
    }

    private List<RestNameValuePair> d(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (PayDataCache.getInstance().hasMobilePwd()) {
            arrayList.add(new RestNameValuePair("bind_flag", "1"));
            arrayList.add(new RestNameValuePair("need_bind_card", "0"));
        } else {
            arrayList.add(new RestNameValuePair("bind_flag", "0"));
            arrayList.add(new RestNameValuePair("need_bind_card", "1"));
        }
        BindFastRequest bindFastRequest = this.a;
        CardData.BondCard bondCard = bindFastRequest.mBondCard;
        if (bondCard == null) {
            return arrayList;
        }
        ErrorContentResponse errorContentResponse = bindFastRequest.mCardInfoUpdateContent;
        if (!TextUtils.isEmpty(bondCard.need_true_name)) {
            arrayList.add(new RestNameValuePair("need_true_name", bondCard.need_true_name));
        }
        if (!TextUtils.isEmpty(bondCard.need_identity_code)) {
            arrayList.add(new RestNameValuePair("need_identity_code", bondCard.need_identity_code));
        }
        if (!TextUtils.isEmpty(bondCard.need_identity_type)) {
            arrayList.add(new RestNameValuePair("need_identity_type", bondCard.need_identity_type));
        }
        if (errorContentResponse != null && errorContentResponse.isNeedPhoneNum()) {
            arrayList.add(new RestNameValuePair("need_phone_num", errorContentResponse.need_phone_num));
        } else if (!TextUtils.isEmpty(bondCard.need_phone_num)) {
            arrayList.add(new RestNameValuePair("need_phone_num", bondCard.need_phone_num));
        }
        if (z) {
            StatHelper.cacheCardType(String.valueOf(1));
            arrayList.add(new RestNameValuePair(StatHelper.CARD_TYPE, String.valueOf(1)));
            if (errorContentResponse != null && errorContentResponse.isNeedValidCode()) {
                arrayList.add(new RestNameValuePair("need_cvv2", errorContentResponse.need_cvv2));
            } else if (!TextUtils.isEmpty(bondCard.need_cvv2)) {
                arrayList.add(new RestNameValuePair("need_cvv2", bondCard.need_cvv2));
            }
            if (errorContentResponse != null && errorContentResponse.isNeedValidDate()) {
                arrayList.add(new RestNameValuePair("need_valid_date", errorContentResponse.need_valid_date));
            } else if (!TextUtils.isEmpty(bondCard.need_valid_date)) {
                arrayList.add(new RestNameValuePair("need_valid_date", bondCard.need_valid_date));
            }
            if (!TextUtils.isEmpty(this.a.getmValidDate())) {
                arrayList.add(new RestNameValuePair("valid_date", PayUtils.encrypt("valid_date", this.a.getmValidDate())));
            }
            if (!TextUtils.isEmpty(this.a.getmCvv())) {
                arrayList.add(new RestNameValuePair("cvv2", PayUtils.encrypt("cvv2", this.a.getmCvv())));
            }
        } else {
            StatHelper.cacheCardType(String.valueOf(2));
            arrayList.add(new RestNameValuePair(StatHelper.CARD_TYPE, String.valueOf(2)));
        }
        if (!TextUtils.isEmpty(this.a.mSmsVCode)) {
            arrayList.add(new RestNameValuePair("message_vcode", this.a.mSmsVCode));
            this.a.mSmsVCode = null;
        }
        arrayList.add(new RestNameValuePair("reser", PayUtils.encrypt("phone_number", this.a.getmPhone())));
        arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.a.mBankCard)));
        arrayList.add(new RestNameValuePair("key", SecurePay.getInstance().getpwProxy()));
        if (!TextUtils.isEmpty(this.a.getmName())) {
            arrayList.add(new RestNameValuePair("true_name", this.a.getmName()));
        }
        if (!TextUtils.isEmpty(this.a.getCertificateType())) {
            arrayList.add(new RestNameValuePair(BindCardProtocolActivity.IDENTITY_TYPE, this.a.getCertificateType()));
        }
        if (!TextUtils.isEmpty(this.a.getmIdCard())) {
            arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.a.getmIdCard())));
        }
        arrayList.add(new RestNameValuePair(StatHelper.BANK_CODE, this.a.getChannelNo()));
        arrayList.add(new RestNameValuePair("sub_bank_code", bondCard.bank_code));
        StatHelper.cacheBankCode(bondCard.bank_code);
        if (!TextUtils.isEmpty(bondCard.account_bank_code)) {
            arrayList.add(new RestNameValuePair("account_bank_code", bondCard.account_bank_code));
        }
        if (this.b == null) {
            return arrayList;
        }
        a((List<RestNameValuePair>) arrayList);
        return arrayList;
    }

    public void execBean() {
        super.execBean(PayResponse.class, ErrorContentResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        List<RestNameValuePair> list;
        CalcPaymentResponse calcPaymentResponse;
        PayRequest payRequest;
        ErrorContentResponse.MktSolution mktSolution;
        PayRequest payRequest2;
        boolean z = false;
        int i2 = 1;
        if (this.d || ((payRequest2 = this.c) != null && payRequest2.isContinuePay())) {
            list = a();
            this.c.setContinuePay(false);
        } else {
            BindFastRequest bindFastRequest = this.a;
            if (bindFastRequest == null) {
                return new ArrayList();
            }
            int i3 = bindFastRequest.mBindFrom;
            if (i3 == 0 || i3 == 6) {
                if (this.a.getCardType() == 1) {
                    z = true;
                }
                list = c(z);
            } else if (i3 == 2 || i3 == 7 || i3 == 9) {
                if (this.a.getCardType() == 1) {
                    z = true;
                }
                list = d(z);
            } else if (i3 != 8) {
                return new ArrayList();
            } else {
                list = b();
            }
        }
        PayRequest payRequest3 = this.c;
        if (payRequest3 != null && !TextUtils.isEmpty(payRequest3.mUseVcodeToPay)) {
            list.add(new RestNameValuePair("use_vcode_to_pay", this.c.mUseVcodeToPay));
        }
        PayRequest payRequest4 = this.c;
        if (payRequest4 == null || !payRequest4.isPayByMktSolution || (mktSolution = payRequest4.mMktSolution) == null) {
            StringBuilder sb = new StringBuilder();
            if (!this.d || (payRequest = this.c) == null) {
                BindFastRequest bindFastRequest2 = this.a;
                if (bindFastRequest2 == null || bindFastRequest2.mBindFrom != 0) {
                    PayRequest payRequest5 = this.c;
                    if (payRequest5 != null) {
                        calcPaymentResponse = payRequest5.getCalcPayment() != null ? this.c.getCalcPayment() : null;
                        list.add(new RestNameValuePair("pay_amount", this.c.getEasyPayAmount()));
                    } else {
                        calcPaymentResponse = null;
                    }
                } else {
                    calcPaymentResponse = bindFastRequest2.getCalcPaymentResponse();
                    list.add(new RestNameValuePair("pay_amount", this.a.getEasyPayAmount()));
                }
            } else {
                calcPaymentResponse = payRequest.getCalcPayment() != null ? this.c.getCalcPayment() : null;
                list.add(new RestNameValuePair("pay_amount", this.c.getEasyPayAmount()));
            }
            if (calcPaymentResponse != null) {
                if (!TextUtils.isEmpty(calcPaymentResponse.getSelectedDiscountIds())) {
                    sb.append(calcPaymentResponse.getSelectedDiscountIds());
                    i2 = 2;
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    list.add(new RestNameValuePair(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, sb.toString()));
                }
                if (!TextUtils.isEmpty(calcPaymentResponse.getSelectedCouponIds())) {
                    list.add(new RestNameValuePair("coupon_id", calcPaymentResponse.getSelectedCouponIds()));
                    i2++;
                }
            }
        } else {
            if (!TextUtils.isEmpty(mktSolution.easypay_amount)) {
                list.add(new RestNameValuePair("pay_amount", this.c.mMktSolution.easypay_amount));
            }
            if (this.c.getCalcPayment() != null) {
                String selectedDiscountIds = this.c.getCalcPayment().getSelectedDiscountIds(this.c.mMktSolution.activity_list);
                if (!TextUtils.isEmpty(selectedDiscountIds)) {
                    list.add(new RestNameValuePair(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, selectedDiscountIds));
                    i2 = 2;
                }
                String selectedCouponIds = this.c.getCalcPayment().getSelectedCouponIds(this.c.mMktSolution.coupon_list);
                if (!TextUtils.isEmpty(selectedCouponIds)) {
                    i2++;
                    list.add(new RestNameValuePair("coupon_id", selectedCouponIds));
                }
            }
        }
        if (i2 >= 2) {
            list.add(new RestNameValuePair("composite_flag", "1"));
        } else {
            list.add(new RestNameValuePair("composite_flag", "0"));
        }
        list.addAll(PayDataCache.getInstance().getPayPostInfo());
        if (!TextUtils.isEmpty(PayDataCache.getInstance().getPaySessionInfo())) {
            list.add(new RestNameValuePair("session_info", PayDataCache.getInstance().getPaySessionInfo()));
        }
        PayRequest payRequest6 = this.c;
        if (payRequest6 != null && !TextUtils.isEmpty(payRequest6.withholding_auth)) {
            list.add(new RestNameValuePair("need_open_authorize", this.c.withholding_auth));
        }
        PayRequest payRequest7 = this.c;
        if (payRequest7 != null && !TextUtils.isEmpty(payRequest7.mSecurityParams)) {
            list.add(new RestNameValuePair("security_sdk_param", this.c.mSecurityParams));
        }
        UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
        if (userInfo != null && !TextUtils.isEmpty(userInfo.getPassfreeMsg())) {
            list.add(new RestNameValuePair("need_open_passfree", String.valueOf(this.c.getOpenPassFreeFlag())));
        }
        if (!TextUtils.isEmpty(this.c.getmBankCardNumber())) {
            list.add(new RestNameValuePair("card_no_required", PayUtils.encrypt("card_no", this.c.getmBankCardNumber())));
        }
        if (!TextUtils.isEmpty(this.c.getmCvv2())) {
            list.add(new RestNameValuePair("verify_code_required", PayUtils.encrypt("cvv2", this.c.getmCvv2())));
        }
        if (!TextUtils.isEmpty(this.c.getmIdCard())) {
            list.add(new RestNameValuePair("certificate_code_required", PayUtils.encrypt("identity_code", this.c.getmIdCard())));
        }
        this.c.setmBankCardNumber("");
        this.c.setmCvv2("");
        this.c.setmIdCard("");
        PayRequestCache.getInstance().addBeanRequestToCache(DxmPayBeanConstants.REQUEST_ID_PAY, this.c);
        if (this.e) {
            list.add(new RestNameValuePair("is_pay_sms", "1"));
        }
        PayRequest payRequest8 = this.c;
        if (payRequest8 != null && !TextUtils.isEmpty(payRequest8.mLivingKey)) {
            list.add(new RestNameValuePair("living_key", this.c.mLivingKey));
            this.c.mLivingKey = null;
        }
        PayRequest payRequest9 = this.c;
        if (payRequest9 != null && !TextUtils.isEmpty(payRequest9.mLivingResultCode)) {
            list.add(new RestNameValuePair("living_result_code", this.c.mLivingResultCode));
            this.c.mLivingResultCode = null;
        }
        list.add(new RestNameValuePair("request_time", String.valueOf(System.currentTimeMillis())));
        PayDataCache.getInstance().setPrePayRequestParams(list);
        DirectPayContentResponse e2 = a.a().e();
        if (!a.a().c() || e2 == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        list.add(new RestNameValuePair("session_id", NetworkBean.SessionCache.getInstance().getSessionId((NetworkBean.BizType) null)));
        for (RestNameValuePair next : list) {
            try {
                String name = next.getName();
                String value = next.getValue();
                if (!"key".equals(name)) {
                    jSONObject.put(name, (Object) value);
                }
                if ("mobilepwd".equals(name) || "seed".equals(name) || "request_time".equals(name)) {
                    jSONObject2.put(name, (Object) value);
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        arrayList.add(new RestNameValuePair("fund_order_info", Base64Utils.encodeToString(jSONObject.toString().getBytes())));
        String f = a.a().f();
        try {
            if (!TextUtils.isEmpty(f)) {
                jSONObject2.put("session_info", (Object) f);
            }
            for (RestNameValuePair next2 : a.a().i()) {
                jSONObject2.put(next2.getName(), (Object) next2.getValue());
            }
            String g = a.a().g();
            if (!TextUtils.isEmpty(g)) {
                jSONObject2.put("session_id", (Object) g);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        arrayList.add(new RestNameValuePair("repayment_order_info", Base64Utils.encodeToString(jSONObject2.toString().getBytes())));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a.a().d());
        stringBuffer.append(",");
        stringBuffer.append(PayDataCache.getInstance().getInsideTransOrder());
        arrayList.add(new RestNameValuePair("combine_trans", stringBuffer.toString()));
        return arrayList;
    }

    public int getBeanId() {
        return 13;
    }

    public String getEncode() {
        return "UTF-8";
    }

    public String getUrl() {
        if (b.a()) {
            return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_SIGN_CONTRACT_PAY;
        } else if (!a.a().c() || a.a().e() == null) {
            return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_DO_PAY;
        } else {
            return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_LICAI_BALANCE_PAY;
        }
    }

    public boolean needNonce() {
        return true;
    }

    public void b(boolean z) {
        this.e = z;
    }

    private void a(List<RestNameValuePair> list) {
        if (list != null && this.b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("mPwdRequest == null ");
            sb.append(this.b == null);
            sb.toString();
            if (!TextUtils.isEmpty(this.b.mPayPass)) {
                if (!TextUtils.isEmpty(this.b.mConfirmPayPass)) {
                    list.add(new RestNameValuePair("mobilepwd", SecurePay.getInstance().encryptProxy(PasswordController.handlePwdSimple(this.b.mPayPass))));
                } else {
                    String seed = PasswordController.getSeed();
                    list.add(new RestNameValuePair("mobilepwd", PasswordController.handlePwd(this.b.mPayPass, seed)));
                    list.add(new RestNameValuePair("seed", SecurePay.getInstance().encryptProxy(seed)));
                }
            } else if (!PayDataCache.getInstance().isPassFree() && this.c != null && !b.a()) {
                String generateOTPKey = WalletFingerprint.getInstance(this.mContext).generateOTPKey(this.c.otp_seed);
                String sn = WalletFingerprint.getInstance(this.mContext).getSN();
                if (!TextUtils.isEmpty(generateOTPKey) && !TextUtils.isEmpty(sn)) {
                    list.add(new RestNameValuePair("f_token_code", SecurePay.getInstance().encrypt(generateOTPKey)));
                    list.add(new RestNameValuePair("f_serial_num", SecurePay.getInstance().encrypt(sn)));
                    if (!TextUtils.isEmpty(this.c.getOtpReuseCode())) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.FINGERPRINT_PAY_AGAIN, (Map<String, Object>) null, new String[0]);
                        list.add(new RestNameValuePair(PayUtils.KEY_OTP_REUSE_CODE, SecurePay.getInstance().encrypt(this.c.getOtpReuseCode())));
                        this.c.setOtpReuseCode((String) null);
                    }
                }
            }
            if (!TextUtils.isEmpty(this.b.mConfirmPayPass)) {
                String seed2 = PasswordController.getSeed();
                list.add(new RestNameValuePair("confirm_mobilepwd", PasswordController.handlePwd(this.b.mConfirmPayPass, seed2)));
                list.add(new RestNameValuePair("seed", SecurePay.getInstance().encryptProxy(seed2)));
                list.add(new RestNameValuePair("mobile_pwd_psp", PasswordController.handlePwdForPassport(this.b.mConfirmPayPass)));
            }
        }
    }

    public void a(boolean z) {
        this.d = z;
    }
}
