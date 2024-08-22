package com.baidu.wallet.paysdk.fingerprint.bean;

import com.dxmpay.apollon.beans.IBeanFactory;

public final class FingerprintBeanFactory implements IBeanFactory {
    public static final int BEAN_ID_SYS_FINGERPRINT_CLOSE = 773;
    public static final int BEAN_ID_SYS_FINGERPRINT_OPEN = 772;

    public static class a {
        public static FingerprintBeanFactory a = new FingerprintBeanFactory();
    }

    public static FingerprintBeanFactory getInstance() {
        return a.a;
    }

    public FingerprintBeanFactory() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.dxmpay.wallet.core.beans.BaseBean<?> getBean(android.content.Context r2, int r3, java.lang.String r4) {
        /*
            r1 = this;
            r0 = 772(0x304, float:1.082E-42)
            if (r3 == r0) goto L_0x0010
            r0 = 773(0x305, float:1.083E-42)
            if (r3 == r0) goto L_0x000a
            r2 = 0
            goto L_0x0016
        L_0x000a:
            com.baidu.wallet.paysdk.fingerprint.bean.a r3 = new com.baidu.wallet.paysdk.fingerprint.bean.a
            r3.<init>(r2)
            goto L_0x0015
        L_0x0010:
            com.baidu.wallet.paysdk.fingerprint.bean.b r3 = new com.baidu.wallet.paysdk.fingerprint.bean.b
            r3.<init>(r2)
        L_0x0015:
            r2 = r3
        L_0x0016:
            if (r2 == 0) goto L_0x001f
            com.dxmpay.wallet.core.beans.BeanManager r3 = com.dxmpay.wallet.core.beans.BeanManager.getInstance()
            r3.addBean(r4, r2)
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory.getBean(android.content.Context, int, java.lang.String):com.dxmpay.wallet.core.beans.BaseBean");
    }
}
