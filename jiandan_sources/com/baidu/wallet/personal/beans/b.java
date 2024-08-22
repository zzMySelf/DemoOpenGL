package com.baidu.wallet.personal.beans;

import com.baidu.apollon.beans.IBeanFactory;

public final class b implements IBeanFactory {

    public static class a {
        public static b a = new b();
    }

    public b() {
    }

    public static b a() {
        return a.a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.wallet.core.beans.BaseBean<?> getBean(android.content.Context r2, int r3, java.lang.String r4) {
        /*
            r1 = this;
            r0 = 515(0x203, float:7.22E-43)
            if (r3 == r0) goto L_0x0010
            r0 = 516(0x204, float:7.23E-43)
            if (r3 == r0) goto L_0x000a
            r2 = 0
            goto L_0x0016
        L_0x000a:
            com.baidu.wallet.personal.beans.c r3 = new com.baidu.wallet.personal.beans.c
            r3.<init>(r2)
            goto L_0x0015
        L_0x0010:
            com.baidu.wallet.personal.beans.QueryCouponListBean r3 = new com.baidu.wallet.personal.beans.QueryCouponListBean
            r3.<init>(r2)
        L_0x0015:
            r2 = r3
        L_0x0016:
            if (r2 == 0) goto L_0x001f
            com.baidu.wallet.core.beans.BeanManager r3 = com.baidu.wallet.core.beans.BeanManager.getInstance()
            r3.addBean(r4, r2)
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.personal.beans.b.getBean(android.content.Context, int, java.lang.String):com.baidu.wallet.core.beans.BaseBean");
    }
}
