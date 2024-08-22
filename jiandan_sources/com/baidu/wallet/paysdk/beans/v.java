package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.LicaiBalancePayResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;

public class v extends BaseBean<LicaiBalancePayResponse> {
    public PwdRequest a;
    public PayRequest b;
    public BindFastRequest c;

    public v(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.c = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        this.a = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
        this.b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
    }

    public void execBean() {
        super.execBean(LicaiBalancePayResponse.class, ErrorContentResponse.class);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0116 A[Catch:{ JSONException -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x013a A[Catch:{ JSONException -> 0x01c4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.dxmpay.apollon.restnet.RestNameValuePair> generateRequestParam() {
        /*
            r7 = this;
            com.dxmpay.wallet.core.lollipop.json.JSONObject r0 = new com.dxmpay.wallet.core.lollipop.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "1"
            com.dxmpay.wallet.utils.StatHelper.cacheCardType(r1)
            com.dxmpay.wallet.utils.StatHelper.cacheBankCode(r1)
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r2 = "request_time"
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x01c4 }
            com.baidu.wallet.paysdk.datamodel.PwdRequest r1 = r7.a     // Catch:{ JSONException -> 0x01c4 }
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x004a
            com.baidu.wallet.paysdk.datamodel.PwdRequest r1 = r7.a     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = r1.mPayPass     // Catch:{ JSONException -> 0x01c4 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x01c4 }
            if (r1 != 0) goto L_0x004a
            java.lang.String r1 = com.baidu.wallet.base.controllers.PasswordController.getSeed()     // Catch:{ JSONException -> 0x01c4 }
            com.baidu.wallet.paysdk.datamodel.PwdRequest r4 = r7.a     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r4 = r4.mPayPass     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r4 = com.baidu.wallet.base.controllers.PasswordController.handlePwd(r4, r1)     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r5 = "mobilepwd"
            r0.put((java.lang.String) r5, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x01c4 }
            com.dxmpay.apollon.armor.SecurePay r4 = com.dxmpay.apollon.armor.SecurePay.getInstance()     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = r4.encryptProxy(r1)     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r4 = "seed"
            r0.put((java.lang.String) r4, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x01c4 }
            goto L_0x00c7
        L_0x004a:
            com.baidu.wallet.paysdk.storage.PayDataCache r1 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()     // Catch:{ JSONException -> 0x01c4 }
            boolean r1 = r1.isPassFree()     // Catch:{ JSONException -> 0x01c4 }
            if (r1 != 0) goto L_0x00c7
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            if (r1 == 0) goto L_0x00c7
            boolean r1 = com.baidu.wallet.paysdk.a.b.a()     // Catch:{ JSONException -> 0x01c4 }
            if (r1 != 0) goto L_0x00c7
            android.content.Context r1 = r7.mContext     // Catch:{ JSONException -> 0x01c4 }
            com.baidu.wallet.paysdk.fingerprint.WalletFingerprint r1 = com.baidu.wallet.paysdk.fingerprint.WalletFingerprint.getInstance(r1)     // Catch:{ JSONException -> 0x01c4 }
            com.baidu.wallet.paysdk.datamodel.PayRequest r4 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r4 = r4.otp_seed     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = r1.generateOTPKey(r4)     // Catch:{ JSONException -> 0x01c4 }
            android.content.Context r4 = r7.mContext     // Catch:{ JSONException -> 0x01c4 }
            com.baidu.wallet.paysdk.fingerprint.WalletFingerprint r4 = com.baidu.wallet.paysdk.fingerprint.WalletFingerprint.getInstance(r4)     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r4 = r4.getSN()     // Catch:{ JSONException -> 0x01c4 }
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x01c4 }
            if (r5 != 0) goto L_0x00c7
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x01c4 }
            if (r5 != 0) goto L_0x00c7
            java.lang.String r5 = "f_token_code"
            com.dxmpay.apollon.armor.SecurePay r6 = com.dxmpay.apollon.armor.SecurePay.getInstance()     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = r6.encrypt(r1)     // Catch:{ JSONException -> 0x01c4 }
            r0.put((java.lang.String) r5, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = "f_serial_num"
            com.dxmpay.apollon.armor.SecurePay r5 = com.dxmpay.apollon.armor.SecurePay.getInstance()     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r4 = r5.encrypt(r4)     // Catch:{ JSONException -> 0x01c4 }
            r0.put((java.lang.String) r1, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x01c4 }
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = r1.getOtpReuseCode()     // Catch:{ JSONException -> 0x01c4 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x01c4 }
            if (r1 != 0) goto L_0x00c7
            java.lang.String r1 = "fingerprint_pay_again"
            java.lang.String[] r4 = new java.lang.String[r2]     // Catch:{ JSONException -> 0x01c4 }
            com.dxmpay.wallet.utils.StatHelper.statServiceEvent(r1, r3, r4)     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = "otp_reuse_code"
            com.dxmpay.apollon.armor.SecurePay r4 = com.dxmpay.apollon.armor.SecurePay.getInstance()     // Catch:{ JSONException -> 0x01c4 }
            com.baidu.wallet.paysdk.datamodel.PayRequest r5 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r5 = r5.getOtpReuseCode()     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r4 = r4.encrypt(r5)     // Catch:{ JSONException -> 0x01c4 }
            r0.put((java.lang.String) r1, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x01c4 }
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            r1.setOtpReuseCode(r3)     // Catch:{ JSONException -> 0x01c4 }
        L_0x00c7:
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r4 = "message_vcode"
            if (r1 == 0) goto L_0x00e3
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = r1.mSmsCode     // Catch:{ JSONException -> 0x01c4 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x01c4 }
            if (r1 != 0) goto L_0x00e3
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = r1.mSmsCode     // Catch:{ JSONException -> 0x01c4 }
            r0.put((java.lang.String) r4, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x01c4 }
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            r1.mSmsCode = r3     // Catch:{ JSONException -> 0x01c4 }
            goto L_0x0100
        L_0x00e3:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r1 = r7.c     // Catch:{ JSONException -> 0x01c4 }
            if (r1 == 0) goto L_0x0100
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r1 = r7.c     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = r1.getmSmsVCode()     // Catch:{ JSONException -> 0x01c4 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x01c4 }
            if (r1 != 0) goto L_0x0100
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r1 = r7.c     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = r1.getmSmsVCode()     // Catch:{ JSONException -> 0x01c4 }
            r0.put((java.lang.String) r4, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x01c4 }
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r1 = r7.c     // Catch:{ JSONException -> 0x01c4 }
            r1.mSmsVCode = r3     // Catch:{ JSONException -> 0x01c4 }
        L_0x0100:
            com.baidu.wallet.paysdk.storage.PayDataCache r1 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()     // Catch:{ JSONException -> 0x01c4 }
            java.util.List r1 = r1.getLicaiBalancePayPostInfo()     // Catch:{ JSONException -> 0x01c4 }
            if (r1 == 0) goto L_0x012c
            boolean r4 = r1.isEmpty()     // Catch:{ JSONException -> 0x01c4 }
            if (r4 != 0) goto L_0x012c
        L_0x0110:
            int r4 = r1.size()     // Catch:{ JSONException -> 0x01c4 }
            if (r2 >= r4) goto L_0x012c
            java.lang.Object r4 = r1.get(r2)     // Catch:{ JSONException -> 0x01c4 }
            com.dxmpay.apollon.restnet.RestNameValuePair r4 = (com.dxmpay.apollon.restnet.RestNameValuePair) r4     // Catch:{ JSONException -> 0x01c4 }
            if (r4 == 0) goto L_0x0129
            java.lang.String r5 = r4.getName()     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r4 = r4.getValue()     // Catch:{ JSONException -> 0x01c4 }
            r0.put((java.lang.String) r5, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x01c4 }
        L_0x0129:
            int r2 = r2 + 1
            goto L_0x0110
        L_0x012c:
            com.baidu.wallet.paysdk.storage.PayDataCache r1 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = r1.getPaySessionInfo()     // Catch:{ JSONException -> 0x01c4 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x01c4 }
            if (r1 != 0) goto L_0x0147
            java.lang.String r1 = "session_info"
            com.baidu.wallet.paysdk.storage.PayDataCache r2 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r2 = r2.getPaySessionInfo()     // Catch:{ JSONException -> 0x01c4 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x01c4 }
        L_0x0147:
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            if (r1 == 0) goto L_0x015e
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = r1.withholding_auth     // Catch:{ JSONException -> 0x01c4 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x01c4 }
            if (r1 != 0) goto L_0x015e
            java.lang.String r1 = "need_open_authorize"
            com.baidu.wallet.paysdk.datamodel.PayRequest r2 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r2 = r2.withholding_auth     // Catch:{ JSONException -> 0x01c4 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x01c4 }
        L_0x015e:
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            if (r1 == 0) goto L_0x0175
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = r1.mSecurityParams     // Catch:{ JSONException -> 0x01c4 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x01c4 }
            if (r1 != 0) goto L_0x0175
            java.lang.String r1 = "security_sdk_param"
            com.baidu.wallet.paysdk.datamodel.PayRequest r2 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r2 = r2.mSecurityParams     // Catch:{ JSONException -> 0x01c4 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x01c4 }
        L_0x0175:
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            if (r1 == 0) goto L_0x0190
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = r1.mLivingKey     // Catch:{ JSONException -> 0x01c4 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x01c4 }
            if (r1 != 0) goto L_0x0190
            java.lang.String r1 = "living_key"
            com.baidu.wallet.paysdk.datamodel.PayRequest r2 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r2 = r2.mLivingKey     // Catch:{ JSONException -> 0x01c4 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x01c4 }
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            r1.mLivingKey = r3     // Catch:{ JSONException -> 0x01c4 }
        L_0x0190:
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            if (r1 == 0) goto L_0x01ab
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r1 = r1.mLivingResultCode     // Catch:{ JSONException -> 0x01c4 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x01c4 }
            if (r1 != 0) goto L_0x01ab
            java.lang.String r1 = "living_result_code"
            com.baidu.wallet.paysdk.datamodel.PayRequest r2 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r2 = r2.mLivingResultCode     // Catch:{ JSONException -> 0x01c4 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x01c4 }
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            r1.mLivingResultCode = r3     // Catch:{ JSONException -> 0x01c4 }
        L_0x01ab:
            java.lang.String r1 = "session_id"
            com.dxmpay.wallet.core.beans.NetworkBean$SessionCache r2 = com.dxmpay.wallet.core.beans.NetworkBean.SessionCache.getInstance()     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r2 = r2.getSessionId(r3)     // Catch:{ JSONException -> 0x01c4 }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x01c4 }
            com.baidu.wallet.paysdk.storage.PayRequestCache r1 = com.baidu.wallet.paysdk.storage.PayRequestCache.getInstance()     // Catch:{ JSONException -> 0x01c4 }
            java.lang.String r2 = "key_pay_request"
            com.baidu.wallet.paysdk.datamodel.PayRequest r3 = r7.b     // Catch:{ JSONException -> 0x01c4 }
            r1.addBeanRequestToCache(r2, r3)     // Catch:{ JSONException -> 0x01c4 }
            goto L_0x01c8
        L_0x01c4:
            r1 = move-exception
            r1.printStackTrace()
        L_0x01c8:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r0 = r0.toString()
            byte[] r0 = r0.getBytes()
            java.lang.String r0 = com.dxmpay.apollon.utils.Base64Utils.encodeToString(r0)
            java.lang.String r3 = "repayment_order_info"
            r2.<init>(r3, r0)
            r1.add(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.beans.v.generateRequestParam():java.util.List");
    }

    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_LICAI_BALANCE_PAY;
    }

    public String getEncode() {
        return "UTF-8";
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_LICAI_BALANCE_PAY;
    }

    public boolean needNonce() {
        return true;
    }
}
