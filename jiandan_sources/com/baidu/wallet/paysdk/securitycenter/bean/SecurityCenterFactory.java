package com.baidu.wallet.paysdk.securitycenter.bean;

import com.dxmpay.apollon.beans.IBeanFactory;

public final class SecurityCenterFactory implements IBeanFactory {
    public static final int BEAN_ID_PAY_SET_LIST = 1;
    public static final int BEAN_ID_SECURITY_CENTER = 0;

    public static class a {
        public static SecurityCenterFactory a = new SecurityCenterFactory();
    }

    public static SecurityCenterFactory getInstance() {
        return a.a;
    }

    public SecurityCenterFactory() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.dxmpay.wallet.core.beans.OtherBean<?> getBean(android.content.Context r2, int r3, java.lang.String r4) {
        /*
            r1 = this;
            android.content.Context r2 = r2.getApplicationContext()
            if (r3 == 0) goto L_0x0011
            r0 = 1
            if (r3 == r0) goto L_0x000b
            r2 = 0
            goto L_0x0017
        L_0x000b:
            com.baidu.wallet.paysdk.securitycenter.bean.PaySetListBean r3 = new com.baidu.wallet.paysdk.securitycenter.bean.PaySetListBean
            r3.<init>(r2)
            goto L_0x0016
        L_0x0011:
            com.baidu.wallet.paysdk.securitycenter.bean.SecurityCenterBean r3 = new com.baidu.wallet.paysdk.securitycenter.bean.SecurityCenterBean
            r3.<init>(r2)
        L_0x0016:
            r2 = r3
        L_0x0017:
            if (r2 == 0) goto L_0x0020
            com.dxmpay.wallet.core.beans.BeanManager r3 = com.dxmpay.wallet.core.beans.BeanManager.getInstance()
            r3.addBean(r4, r2)
        L_0x0020:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.securitycenter.bean.SecurityCenterFactory.getBean(android.content.Context, int, java.lang.String):com.dxmpay.wallet.core.beans.OtherBean");
    }
}
