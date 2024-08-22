package com.baidu.android.lbspay.beans;

import com.dxmpay.apollon.beans.IBeanFactory;

public final class LbsPayBeanFactory implements IBeanFactory {
    public static final int BEAN_ID_AUTHORIZE_SIGN = 3;
    public static final int BEAN_ID_GET_PAY = 2;
    public static final int BEAN_ID_NEW_CASHIER = 1;
    public static final int BEAN_ID_SIGN_RESULT = 4;

    public static class a {
        public static LbsPayBeanFactory a = new LbsPayBeanFactory();
    }

    public static LbsPayBeanFactory getInstance() {
        return a.a;
    }

    public LbsPayBeanFactory() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.dxmpay.wallet.core.beans.BaseBean<?> getBean(android.content.Context r2, int r3, java.lang.String r4) {
        /*
            r1 = this;
            r0 = 1
            if (r3 == r0) goto L_0x0020
            r0 = 2
            if (r3 == r0) goto L_0x001a
            r0 = 3
            if (r3 == r0) goto L_0x0014
            r0 = 4
            if (r3 == r0) goto L_0x000e
            r2 = 0
            goto L_0x0026
        L_0x000e:
            com.baidu.android.lbspay.beans.SignResultBean r3 = new com.baidu.android.lbspay.beans.SignResultBean
            r3.<init>(r2)
            goto L_0x0025
        L_0x0014:
            com.baidu.android.lbspay.beans.AuthorizeSignBean r3 = new com.baidu.android.lbspay.beans.AuthorizeSignBean
            r3.<init>(r2)
            goto L_0x0025
        L_0x001a:
            com.baidu.android.lbspay.beans.GetPayBean r3 = new com.baidu.android.lbspay.beans.GetPayBean
            r3.<init>(r2)
            goto L_0x0025
        L_0x0020:
            com.baidu.android.lbspay.beans.NewCashierBean r3 = new com.baidu.android.lbspay.beans.NewCashierBean
            r3.<init>(r2)
        L_0x0025:
            r2 = r3
        L_0x0026:
            if (r2 == 0) goto L_0x002f
            com.dxmpay.wallet.core.beans.BeanManager r3 = com.dxmpay.wallet.core.beans.BeanManager.getInstance()
            r3.addBean(r4, r2)
        L_0x002f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.lbspay.beans.LbsPayBeanFactory.getBean(android.content.Context, int, java.lang.String):com.dxmpay.wallet.core.beans.BaseBean");
    }
}
