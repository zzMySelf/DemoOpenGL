package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;

public class x extends BaseBean<Object> {
    public String a;
    public String b;
    public boolean c = true;
    public String d;

    public <T> x(Context context) {
        super(context);
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public void execBean() {
        super.execBean(String.class, ErrorContentResponse.class);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.dxmpay.apollon.restnet.RestNameValuePair> generateRequestParam() {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = com.baidu.wallet.base.controllers.PasswordController.getSeed()
            com.dxmpay.apollon.armor.SecurePay r2 = com.dxmpay.apollon.armor.SecurePay.getInstance()
            java.lang.String r2 = r2.encryptProxy(r1)
            boolean r3 = r11.c
            java.lang.String r4 = "2"
            java.lang.String r5 = "1"
            if (r3 == 0) goto L_0x0034
            java.lang.String r3 = r11.a
            java.lang.String r1 = com.baidu.wallet.base.controllers.PasswordController.handlePwd(r3, r1)
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r6 = "mobile_pwd"
            r3.<init>(r6, r1)
            r0.add(r3)
            com.dxmpay.apollon.restnet.RestNameValuePair r1 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r3 = "seed"
            r1.<init>(r3, r2)
            r0.add(r1)
            goto L_0x0086
        L_0x0034:
            android.content.Context r1 = r11.mContext
            com.baidu.wallet.paysdk.fingerprint.WalletFingerprint r1 = com.baidu.wallet.paysdk.fingerprint.WalletFingerprint.getInstance(r1)
            java.lang.String r2 = r11.b
            java.lang.String r1 = r1.generateOTPKey(r2)
            android.content.Context r2 = r11.mContext
            com.baidu.wallet.paysdk.fingerprint.WalletFingerprint r2 = com.baidu.wallet.paysdk.fingerprint.WalletFingerprint.getInstance(r2)
            java.lang.String r2 = r2.getSN()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0086
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0086
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.dxmpay.apollon.armor.SecurePay r6 = com.dxmpay.apollon.armor.SecurePay.getInstance()
            java.lang.String r1 = r6.encrypt(r1)
            java.lang.String r6 = "token_code"
            r3.<init>(r6, r1)
            r0.add(r3)
            com.dxmpay.apollon.restnet.RestNameValuePair r1 = new com.dxmpay.apollon.restnet.RestNameValuePair
            com.dxmpay.apollon.armor.SecurePay r3 = com.dxmpay.apollon.armor.SecurePay.getInstance()
            java.lang.String r2 = r3.encrypt(r2)
            java.lang.String r3 = "serial_num"
            r1.<init>(r3, r2)
            r0.add(r1)
            com.dxmpay.apollon.restnet.RestNameValuePair r1 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r2 = "verify_type"
            r1.<init>(r2, r4)
            r0.add(r1)
            r1 = r5
            goto L_0x0088
        L_0x0086:
            java.lang.String r1 = "0"
        L_0x0088:
            com.dxmpay.apollon.armor.SecurePay r2 = com.dxmpay.apollon.armor.SecurePay.getInstance()
            java.lang.String r2 = r2.getpwProxy()
            com.dxmpay.apollon.restnet.RestNameValuePair r3 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r6 = "key"
            r3.<init>(r6, r2)
            r0.add(r3)
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r3 = "scenario"
            java.lang.String r6 = "bindcard"
            r2.<init>(r3, r6)
            r0.add(r2)
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r3 = "source_flag"
            java.lang.String r6 = "3"
            r2.<init>(r3, r6)
            r0.add(r2)
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            r3 = 1
            java.lang.String r7 = com.baidu.wallet.paysdk.datamodel.BindFastRequest.getCardRequestType(r3)
            java.lang.String r8 = "request_type"
            r2.<init>(r8, r7)
            r0.add(r2)
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r7 = "service_type"
            java.lang.String r8 = ""
            r2.<init>(r7, r8)
            r0.add(r2)
            com.baidu.wallet.paysdk.storage.PayRequestCache r2 = com.baidu.wallet.paysdk.storage.PayRequestCache.getInstance()
            com.baidu.wallet.paysdk.storage.PayRequestCache$BindCategory r7 = com.baidu.wallet.paysdk.storage.PayRequestCache.BindCategory.Initiative
            java.lang.String r7 = r7.name()
            com.dxmpay.wallet.core.beans.BeanRequestBase r2 = r2.getBeanRequestFromCache(r7)
            com.baidu.wallet.paysdk.datamodel.BindFastRequest r2 = (com.baidu.wallet.paysdk.datamodel.BindFastRequest) r2
            com.baidu.wallet.newbindcard.NewBindCardEntry r7 = com.baidu.wallet.newbindcard.NewBindCardEntry.getInstance()
            com.dxmpay.apollon.beans.BeanResponseBase$Session r7 = r7.getSession()
            java.lang.String r9 = r11.d
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r10 = "session_id"
            if (r9 != 0) goto L_0x00fb
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r4 = r11.d
            r2.<init>(r10, r4)
            r0.add(r2)
            r4 = r5
            goto L_0x012c
        L_0x00fb:
            if (r2 == 0) goto L_0x0114
            java.lang.String r5 = r2.getSessionId()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0114
            com.dxmpay.apollon.restnet.RestNameValuePair r5 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r2 = r2.getSessionId()
            r5.<init>(r10, r2)
            r0.add(r5)
            goto L_0x012c
        L_0x0114:
            if (r7 == 0) goto L_0x0123
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            java.lang.String r4 = r7.session_id
            r2.<init>(r10, r4)
            r0.add(r2)
            java.lang.String r4 = "4"
            goto L_0x012c
        L_0x0123:
            com.dxmpay.apollon.restnet.RestNameValuePair r2 = new com.dxmpay.apollon.restnet.RestNameValuePair
            r2.<init>(r10, r8)
            r0.add(r2)
            r4 = r6
        L_0x012c:
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]
            r5 = 0
            r2[r5] = r1
            r2[r3] = r4
            java.lang.String r1 = "new_start_check_pwd"
            java.lang.String r3 = "验证密码/指纹/人脸页面"
            java.lang.String r4 = "paySDKInitiativeBindCardCheckPwdPage"
            java.lang.String r5 = "校验密码sessin_id存在"
            com.baidu.wallet.newbindcard.c.a.a(r1, r3, r4, r5, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.beans.x.generateRequestParam():java.util.List");
    }

    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_NEW_CHECK_PASSWORD;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_VERIFY_MOBILE_PWD_NEW;
    }

    public void a(boolean z) {
        this.c = z;
    }
}
