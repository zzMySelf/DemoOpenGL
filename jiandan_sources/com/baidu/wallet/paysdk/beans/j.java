package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PayResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class j extends BaseBean<PayResponse> {
    public PwdRequest a;
    public PayRequest b;

    public j(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.a = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
        this.b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
    }

    public void execBean() {
        super.execBean(PayResponse.class, ErrorContentResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        PayData.CreditInfo creditInfo;
        PayData.InstalmentPlan[] instalmentPlanArr;
        ArrayList arrayList = new ArrayList();
        PwdRequest pwdRequest = this.a;
        if (pwdRequest != null && !TextUtils.isEmpty(pwdRequest.mPayPass)) {
            String seed = PasswordController.getSeed();
            arrayList.add(new RestNameValuePair("mobilepwd", PasswordController.handlePwd(this.a.mPayPass, seed)));
            arrayList.add(new RestNameValuePair("seed", SecurePay.getInstance().encryptProxy(seed)));
        } else if (!PayDataCache.getInstance().isPassFree() && this.b != null && !b.a()) {
            String generateOTPKey = WalletFingerprint.getInstance(this.mContext).generateOTPKey(this.b.otp_seed);
            String sn = WalletFingerprint.getInstance(this.mContext).getSN();
            if (!TextUtils.isEmpty(generateOTPKey) && !TextUtils.isEmpty(sn)) {
                arrayList.add(new RestNameValuePair("f_token_code", SecurePay.getInstance().encrypt(generateOTPKey)));
                arrayList.add(new RestNameValuePair("f_serial_num", SecurePay.getInstance().encrypt(sn)));
                if (!TextUtils.isEmpty(this.b.getOtpReuseCode())) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.FINGERPRINT_PAY_AGAIN, (Map<String, Object>) null, new String[0]);
                    arrayList.add(new RestNameValuePair(PayUtils.KEY_OTP_REUSE_CODE, SecurePay.getInstance().encrypt(this.b.getOtpReuseCode())));
                    this.b.setOtpReuseCode((String) null);
                }
            }
        }
        PayRequest payRequest = this.b;
        if (payRequest != null && !TextUtils.isEmpty(payRequest.mSmsCode)) {
            arrayList.add(new RestNameValuePair("message_vcode", this.b.mSmsCode));
            this.b.mSmsCode = null;
        }
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (!(payResponse == null || (directPayPay = payResponse.pay) == null || (creditPay = directPayPay.credit_pay) == null || (creditInfo = creditPay.credit_info) == null || (instalmentPlanArr = creditInfo.instalment_plan) == null || instalmentPlanArr.length <= 0)) {
            arrayList.add(new RestNameValuePair("credit_rate", instalmentPlanArr[0].rate));
            arrayList.add(new RestNameValuePair("stage_number", payResponse.pay.credit_pay.credit_info.instalment_plan[0].instalment));
            arrayList.add(new RestNameValuePair("each_repayment", payResponse.pay.credit_pay.credit_info.instalment_plan[0].amount));
        }
        arrayList.addAll(PayDataCache.getInstance().getCreditPayPostInfo());
        if (!TextUtils.isEmpty(PayDataCache.getInstance().getPaySessionInfo())) {
            arrayList.add(new RestNameValuePair("session_info", PayDataCache.getInstance().getPaySessionInfo()));
        }
        PayRequest payRequest2 = this.b;
        if (payRequest2 != null && !TextUtils.isEmpty(payRequest2.withholding_auth)) {
            arrayList.add(new RestNameValuePair("need_open_authorize", this.b.withholding_auth));
        }
        PayRequest payRequest3 = this.b;
        if (payRequest3 != null && !TextUtils.isEmpty(payRequest3.mSecurityParams)) {
            arrayList.add(new RestNameValuePair("security_sdk_param", this.b.mSecurityParams));
        }
        UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
        if (userInfo != null && !TextUtils.isEmpty(userInfo.getPassfreeMsg())) {
            arrayList.add(new RestNameValuePair("need_open_passfree", String.valueOf(this.b.getOpenPassFreeFlag())));
        }
        if (!TextUtils.isEmpty(this.b.getmBankCardNumber())) {
            arrayList.add(new RestNameValuePair("card_no_required", PayUtils.encrypt("card_no", this.b.getmBankCardNumber())));
        }
        if (!TextUtils.isEmpty(this.b.getmCvv2())) {
            arrayList.add(new RestNameValuePair("verify_code_required", PayUtils.encrypt("cvv2", this.b.getmCvv2())));
        }
        if (!TextUtils.isEmpty(this.b.getmIdCard())) {
            arrayList.add(new RestNameValuePair("certificate_code_required", PayUtils.encrypt("identity_code", this.b.getmIdCard())));
        }
        this.b.setmBankCardNumber("");
        this.b.setmCvv2("");
        this.b.setmIdCard("");
        PayRequestCache.getInstance().addBeanRequestToCache(DxmPayBeanConstants.REQUEST_ID_PAY, this.b);
        PayRequest payRequest4 = this.b;
        if (payRequest4 != null && !TextUtils.isEmpty(payRequest4.mLivingKey)) {
            arrayList.add(new RestNameValuePair("living_key", this.b.mLivingKey));
            this.b.mLivingKey = null;
        }
        PayRequest payRequest5 = this.b;
        if (payRequest5 != null && !TextUtils.isEmpty(payRequest5.mLivingResultCode)) {
            arrayList.add(new RestNameValuePair("living_result_code", this.b.mLivingResultCode));
            this.b.mLivingResultCode = null;
        }
        arrayList.add(new RestNameValuePair("request_time", String.valueOf(System.currentTimeMillis())));
        return arrayList;
    }

    public int getBeanId() {
        return 263;
    }

    public String getEncode() {
        return "UTF-8";
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_DO_PAY;
    }

    public boolean needNonce() {
        return true;
    }
}
