package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.wallet.paysdk.datamodel.BalancePayResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;

public class a extends BaseBean<BalancePayResponse> {
    public PwdRequest a;
    public PayRequest b;
    public BindFastRequest c;

    public a(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.c = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        this.a = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
        this.b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
    }

    public void execBean() {
        super.execBean(BalancePayResponse.class, ErrorContentResponse.class);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x015f A[SYNTHETIC, Splitter:B:35:0x015f] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01db A[Catch:{ JSONException -> 0x037f }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01fd A[Catch:{ JSONException -> 0x037f }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x021f A[Catch:{ JSONException -> 0x037f }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02c2 A[Catch:{ JSONException -> 0x037f }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0302 A[Catch:{ JSONException -> 0x037f }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0317 A[Catch:{ JSONException -> 0x037f }, LOOP:1: B:87:0x0311->B:89:0x0317, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0337 A[Catch:{ JSONException -> 0x037f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.dxmpay.apollon.restnet.RestNameValuePair> generateRequestParam() {
        /*
            r12 = this;
            java.lang.String r0 = "session_id"
            java.lang.String r1 = "seed"
            java.lang.String r2 = "mobilepwd"
            java.lang.String r3 = "request_time"
            java.lang.String r4 = ""
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.String r6 = "0"
            com.dxmpay.wallet.utils.StatHelper.cacheCardType(r6)
            com.dxmpay.wallet.utils.StatHelper.cacheBankCode(r6)
            com.dxmpay.wallet.core.lollipop.json.JSONObject r6 = new com.dxmpay.wallet.core.lollipop.json.JSONObject
            r6.<init>()
            long r7 = java.lang.System.currentTimeMillis()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            com.dxmpay.apollon.restnet.RestNameValuePair r8 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r9 = "bank_code"
            r8.<init>(r9, r4)     // Catch:{ JSONException -> 0x037f }
            r5.add(r8)     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r8 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            r8.<init>(r3, r7)     // Catch:{ JSONException -> 0x037f }
            r5.add(r8)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.PwdRequest r8 = r12.a     // Catch:{ JSONException -> 0x037f }
            r9 = 0
            if (r8 == 0) goto L_0x0074
            com.baidu.wallet.paysdk.datamodel.PwdRequest r8 = r12.a     // Catch:{ JSONException -> 0x037f }
            java.lang.String r8 = r8.mPayPass     // Catch:{ JSONException -> 0x037f }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x037f }
            if (r8 != 0) goto L_0x0074
            java.lang.String r8 = com.baidu.wallet.base.controllers.PasswordController.getSeed()     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.PwdRequest r10 = r12.a     // Catch:{ JSONException -> 0x037f }
            java.lang.String r10 = r10.mPayPass     // Catch:{ JSONException -> 0x037f }
            java.lang.String r10 = com.baidu.wallet.base.controllers.PasswordController.handlePwd(r10, r8)     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r11 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            r11.<init>(r2, r10)     // Catch:{ JSONException -> 0x037f }
            r5.add(r11)     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.armor.SecurePay r11 = com.dxmpay.apollon.armor.SecurePay.getInstance()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r8 = r11.encryptProxy(r8)     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r11 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            r11.<init>(r1, r8)     // Catch:{ JSONException -> 0x037f }
            r5.add(r11)     // Catch:{ JSONException -> 0x037f }
            r6.put((java.lang.String) r2, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x037f }
            r6.put((java.lang.String) r1, (java.lang.Object) r8)     // Catch:{ JSONException -> 0x037f }
            r6.put((java.lang.String) r3, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x037f }
            goto L_0x0101
        L_0x0074:
            com.baidu.wallet.paysdk.storage.PayDataCache r1 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()     // Catch:{ JSONException -> 0x037f }
            boolean r1 = r1.isPassFree()     // Catch:{ JSONException -> 0x037f }
            if (r1 != 0) goto L_0x0101
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            if (r1 == 0) goto L_0x0101
            boolean r1 = com.baidu.wallet.paysdk.a.b.a()     // Catch:{ JSONException -> 0x037f }
            if (r1 != 0) goto L_0x0101
            android.content.Context r1 = r12.mContext     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.fingerprint.WalletFingerprint r1 = com.baidu.wallet.paysdk.fingerprint.WalletFingerprint.getInstance(r1)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.PayRequest r2 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r2 = r2.otp_seed     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.generateOTPKey(r2)     // Catch:{ JSONException -> 0x037f }
            android.content.Context r2 = r12.mContext     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.fingerprint.WalletFingerprint r2 = com.baidu.wallet.paysdk.fingerprint.WalletFingerprint.getInstance(r2)     // Catch:{ JSONException -> 0x037f }
            java.lang.String r2 = r2.getSN()     // Catch:{ JSONException -> 0x037f }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            if (r3 != 0) goto L_0x0101
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x037f }
            if (r3 != 0) goto L_0x0101
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r7 = "f_token_code"
            com.dxmpay.apollon.armor.SecurePay r8 = com.dxmpay.apollon.armor.SecurePay.getInstance()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r8.encrypt(r1)     // Catch:{ JSONException -> 0x037f }
            r3.<init>(r7, r1)     // Catch:{ JSONException -> 0x037f }
            r5.add(r3)     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r1 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r3 = "f_serial_num"
            com.dxmpay.apollon.armor.SecurePay r7 = com.dxmpay.apollon.armor.SecurePay.getInstance()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r2 = r7.encrypt(r2)     // Catch:{ JSONException -> 0x037f }
            r1.<init>(r3, r2)     // Catch:{ JSONException -> 0x037f }
            r5.add(r1)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.getOtpReuseCode()     // Catch:{ JSONException -> 0x037f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            if (r1 != 0) goto L_0x0101
            java.lang.String r1 = "fingerprint_pay_again"
            r2 = 0
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.wallet.utils.StatHelper.statServiceEvent(r1, r9, r2)     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r1 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r2 = "otp_reuse_code"
            com.dxmpay.apollon.armor.SecurePay r3 = com.dxmpay.apollon.armor.SecurePay.getInstance()     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.PayRequest r7 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r7 = r7.getOtpReuseCode()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r3 = r3.encrypt(r7)     // Catch:{ JSONException -> 0x037f }
            r1.<init>(r2, r3)     // Catch:{ JSONException -> 0x037f }
            r5.add(r1)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            r1.setOtpReuseCode(r9)     // Catch:{ JSONException -> 0x037f }
        L_0x0101:
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r2 = "message_vcode"
            if (r1 == 0) goto L_0x0122
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.mSmsCode     // Catch:{ JSONException -> 0x037f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            if (r1 != 0) goto L_0x0122
            com.dxmpay.apollon.restnet.RestNameValuePair r1 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.PayRequest r3 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r3 = r3.mSmsCode     // Catch:{ JSONException -> 0x037f }
            r1.<init>(r2, r3)     // Catch:{ JSONException -> 0x037f }
            r5.add(r1)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            r1.mSmsCode = r9     // Catch:{ JSONException -> 0x037f }
            goto L_0x0144
        L_0x0122:
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r1 = r12.c     // Catch:{ JSONException -> 0x037f }
            if (r1 == 0) goto L_0x0144
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r1 = r12.c     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.getmSmsVCode()     // Catch:{ JSONException -> 0x037f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            if (r1 != 0) goto L_0x0144
            com.dxmpay.apollon.restnet.RestNameValuePair r1 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r3 = r12.c     // Catch:{ JSONException -> 0x037f }
            java.lang.String r3 = r3.getmSmsVCode()     // Catch:{ JSONException -> 0x037f }
            r1.<init>(r2, r3)     // Catch:{ JSONException -> 0x037f }
            r5.add(r1)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r1 = r12.c     // Catch:{ JSONException -> 0x037f }
            r1.mSmsVCode = r9     // Catch:{ JSONException -> 0x037f }
        L_0x0144:
            com.baidu.wallet.paysdk.storage.PayDataCache r1 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()     // Catch:{ JSONException -> 0x037f }
            java.util.List r1 = r1.getBalancePayPostInfo()     // Catch:{ JSONException -> 0x037f }
            r5.addAll(r1)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.storage.PayDataCache r1 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.getPaySessionInfo()     // Catch:{ JSONException -> 0x037f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            java.lang.String r2 = "session_info"
            if (r1 != 0) goto L_0x016f
            com.baidu.wallet.paysdk.storage.PayDataCache r1 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.getPaySessionInfo()     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            r3.<init>(r2, r1)     // Catch:{ JSONException -> 0x037f }
            r5.add(r3)     // Catch:{ JSONException -> 0x037f }
        L_0x016f:
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            if (r1 == 0) goto L_0x018b
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.withholding_auth     // Catch:{ JSONException -> 0x037f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            if (r1 != 0) goto L_0x018b
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.withholding_auth     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r7 = "need_open_authorize"
            r3.<init>(r7, r1)     // Catch:{ JSONException -> 0x037f }
            r5.add(r3)     // Catch:{ JSONException -> 0x037f }
        L_0x018b:
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            if (r1 == 0) goto L_0x01a7
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.mSecurityParams     // Catch:{ JSONException -> 0x037f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            if (r1 != 0) goto L_0x01a7
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.mSecurityParams     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r7 = "security_sdk_param"
            r3.<init>(r7, r1)     // Catch:{ JSONException -> 0x037f }
            r5.add(r3)     // Catch:{ JSONException -> 0x037f }
        L_0x01a7:
            com.baidu.wallet.paysdk.storage.PayDataCache r1 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r1 = r1.getUserInfo()     // Catch:{ JSONException -> 0x037f }
            if (r1 == 0) goto L_0x01cf
            java.lang.String r1 = r1.getPassfreeMsg()     // Catch:{ JSONException -> 0x037f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            if (r1 != 0) goto L_0x01cf
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            int r1 = r1.getOpenPassFreeFlag()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r7 = "need_open_passfree"
            r3.<init>(r7, r1)     // Catch:{ JSONException -> 0x037f }
            r5.add(r3)     // Catch:{ JSONException -> 0x037f }
        L_0x01cf:
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.getmBankCardNumber()     // Catch:{ JSONException -> 0x037f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            if (r1 != 0) goto L_0x01f1
            java.lang.String r1 = "card_no"
            com.baidu.wallet.paysdk.datamodel.PayRequest r3 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r3 = r3.getmBankCardNumber()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r1, r3)     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r7 = "card_no_required"
            r3.<init>(r7, r1)     // Catch:{ JSONException -> 0x037f }
            r5.add(r3)     // Catch:{ JSONException -> 0x037f }
        L_0x01f1:
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.getmCvv2()     // Catch:{ JSONException -> 0x037f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            if (r1 != 0) goto L_0x0213
            java.lang.String r1 = "cvv2"
            com.baidu.wallet.paysdk.datamodel.PayRequest r3 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r3 = r3.getmCvv2()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r1, r3)     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r7 = "verify_code_required"
            r3.<init>(r7, r1)     // Catch:{ JSONException -> 0x037f }
            r5.add(r3)     // Catch:{ JSONException -> 0x037f }
        L_0x0213:
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.getmIdCard()     // Catch:{ JSONException -> 0x037f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            if (r1 != 0) goto L_0x0235
            java.lang.String r1 = "identity_code"
            com.baidu.wallet.paysdk.datamodel.PayRequest r3 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r3 = r3.getmIdCard()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = com.dxmpay.wallet.paysdk.PayUtils.encrypt(r1, r3)     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r7 = "certificate_code_required"
            r3.<init>(r7, r1)     // Catch:{ JSONException -> 0x037f }
            r5.add(r3)     // Catch:{ JSONException -> 0x037f }
        L_0x0235:
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            r1.setmBankCardNumber(r4)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            r1.setmCvv2(r4)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            r1.setmIdCard(r4)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.storage.PayRequestCache r1 = com.baidu.wallet.paysdk.storage.PayRequestCache.getInstance()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r3 = "key_pay_request"
            com.baidu.wallet.paysdk.datamodel.PayRequest r4 = r12.b     // Catch:{ JSONException -> 0x037f }
            r1.addBeanRequestToCache(r3, r4)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            if (r1 == 0) goto L_0x026f
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.mLivingKey     // Catch:{ JSONException -> 0x037f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            if (r1 != 0) goto L_0x026f
            com.dxmpay.apollon.restnet.RestNameValuePair r1 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r3 = "living_key"
            com.baidu.wallet.paysdk.datamodel.PayRequest r4 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r4 = r4.mLivingKey     // Catch:{ JSONException -> 0x037f }
            r1.<init>(r3, r4)     // Catch:{ JSONException -> 0x037f }
            r5.add(r1)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            r1.mLivingKey = r9     // Catch:{ JSONException -> 0x037f }
        L_0x026f:
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            if (r1 == 0) goto L_0x028f
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.mLivingResultCode     // Catch:{ JSONException -> 0x037f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            if (r1 != 0) goto L_0x028f
            com.dxmpay.apollon.restnet.RestNameValuePair r1 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r3 = "living_result_code"
            com.baidu.wallet.paysdk.datamodel.PayRequest r4 = r12.b     // Catch:{ JSONException -> 0x037f }
            java.lang.String r4 = r4.mLivingResultCode     // Catch:{ JSONException -> 0x037f }
            r1.<init>(r3, r4)     // Catch:{ JSONException -> 0x037f }
            r5.add(r1)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.PayRequest r1 = r12.b     // Catch:{ JSONException -> 0x037f }
            r1.mLivingResultCode = r9     // Catch:{ JSONException -> 0x037f }
        L_0x028f:
            com.baidu.wallet.paysdk.c.a r1 = com.baidu.wallet.paysdk.c.a.a()     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r1 = r1.e()     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.c.a r3 = com.baidu.wallet.paysdk.c.a.a()     // Catch:{ JSONException -> 0x037f }
            boolean r3 = r3.c()     // Catch:{ JSONException -> 0x037f }
            if (r3 == 0) goto L_0x0383
            if (r1 == 0) goto L_0x0383
            com.dxmpay.wallet.core.lollipop.json.JSONObject r1 = new com.dxmpay.wallet.core.lollipop.json.JSONObject     // Catch:{ JSONException -> 0x037f }
            r1.<init>()     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.wallet.core.beans.NetworkBean$SessionCache r4 = com.dxmpay.wallet.core.beans.NetworkBean.SessionCache.getInstance()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r4 = r4.getSessionId(r9)     // Catch:{ JSONException -> 0x037f }
            r3.<init>(r0, r4)     // Catch:{ JSONException -> 0x037f }
            r5.add(r3)     // Catch:{ JSONException -> 0x037f }
            java.util.Iterator r3 = r5.iterator()     // Catch:{ JSONException -> 0x037f }
        L_0x02bc:
            boolean r4 = r3.hasNext()     // Catch:{ JSONException -> 0x037f }
            if (r4 == 0) goto L_0x02d9
            java.lang.Object r4 = r3.next()     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r4 = (com.dxmpay.apollon.restnet.RestNameValuePair) r4     // Catch:{ JSONException -> 0x037f }
            java.lang.String r7 = r4.getName()     // Catch:{ JSONException -> 0x02d4 }
            java.lang.String r4 = r4.getValue()     // Catch:{ JSONException -> 0x02d4 }
            r1.put((java.lang.String) r7, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x02d4 }
            goto L_0x02bc
        L_0x02d4:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ JSONException -> 0x037f }
            goto L_0x02bc
        L_0x02d9:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ JSONException -> 0x037f }
            r3.<init>()     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r4 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r7 = "fund_order_info"
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x037f }
            byte[] r1 = r1.getBytes()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = com.dxmpay.apollon.utils.Base64Utils.encodeToString(r1)     // Catch:{ JSONException -> 0x037f }
            r4.<init>(r7, r1)     // Catch:{ JSONException -> 0x037f }
            r3.add(r4)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.c.a r1 = com.baidu.wallet.paysdk.c.a.a()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.f()     // Catch:{ JSONException -> 0x037f }
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            if (r4 != 0) goto L_0x0305
            r6.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x037f }
        L_0x0305:
            com.baidu.wallet.paysdk.c.a r1 = com.baidu.wallet.paysdk.c.a.a()     // Catch:{ JSONException -> 0x037f }
            java.util.List r1 = r1.i()     // Catch:{ JSONException -> 0x037f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ JSONException -> 0x037f }
        L_0x0311:
            boolean r2 = r1.hasNext()     // Catch:{ JSONException -> 0x037f }
            if (r2 == 0) goto L_0x0329
            java.lang.Object r2 = r1.next()     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = (com.dxmpay.apollon.restnet.RestNameValuePair) r2     // Catch:{ JSONException -> 0x037f }
            java.lang.String r4 = r2.getName()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r2 = r2.getValue()     // Catch:{ JSONException -> 0x037f }
            r6.put((java.lang.String) r4, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x037f }
            goto L_0x0311
        L_0x0329:
            com.baidu.wallet.paysdk.c.a r1 = com.baidu.wallet.paysdk.c.a.a()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.g()     // Catch:{ JSONException -> 0x037f }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x037f }
            if (r2 != 0) goto L_0x033a
            r6.put((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x037f }
        L_0x033a:
            com.dxmpay.apollon.restnet.RestNameValuePair r0 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = "repayment_order_info"
            java.lang.String r2 = r6.toString()     // Catch:{ JSONException -> 0x037f }
            byte[] r2 = r2.getBytes()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r2 = com.dxmpay.apollon.utils.Base64Utils.encodeToString(r2)     // Catch:{ JSONException -> 0x037f }
            r0.<init>(r1, r2)     // Catch:{ JSONException -> 0x037f }
            r3.add(r0)     // Catch:{ JSONException -> 0x037f }
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ JSONException -> 0x037f }
            r0.<init>()     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.c.a r1 = com.baidu.wallet.paysdk.c.a.a()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.d()     // Catch:{ JSONException -> 0x037f }
            r0.append(r1)     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = ","
            r0.append(r1)     // Catch:{ JSONException -> 0x037f }
            com.baidu.wallet.paysdk.storage.PayDataCache r1 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()     // Catch:{ JSONException -> 0x037f }
            java.lang.String r1 = r1.getInsideTransOrder()     // Catch:{ JSONException -> 0x037f }
            r0.append(r1)     // Catch:{ JSONException -> 0x037f }
            com.dxmpay.apollon.restnet.RestNameValuePair r1 = new com.dxmpay.apollon.restnet.RestNameValuePair     // Catch:{ JSONException -> 0x037f }
            java.lang.String r2 = "combine_trans"
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x037f }
            r1.<init>(r2, r0)     // Catch:{ JSONException -> 0x037f }
            r3.add(r1)     // Catch:{ JSONException -> 0x037f }
            return r3
        L_0x037f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0383:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.beans.a.generateRequestParam():java.util.List");
    }

    public int getBeanId() {
        return 14;
    }

    public String getEncode() {
        return "UTF-8";
    }

    public String getUrl() {
        if (!com.baidu.wallet.paysdk.c.a.a().c() || com.baidu.wallet.paysdk.c.a.a().e() == null) {
            return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_DO_PAY;
        }
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_LICAI_BALANCE_PAY;
    }

    public boolean needNonce() {
        return true;
    }
}
