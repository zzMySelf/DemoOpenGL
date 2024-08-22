package com.alipay.sdk.m.i0;

import android.content.BroadcastReceiver;

public final class e extends BroadcastReceiver {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r0 == 0) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        if (android.text.TextUtils.equals(r6.getStringExtra("openIdPackage"), r5.getPackageName()) != false) goto L_0x0044;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0085
            if (r6 != 0) goto L_0x0006
            goto L_0x0085
        L_0x0006:
            java.lang.String r0 = "openIdNotifyFlag"
            r1 = 0
            int r0 = r6.getIntExtra(r0, r1)
            java.lang.String r2 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "shouldUpdateId, notifyFlag : "
            java.lang.String r2 = r3.concat(r2)
            com.alipay.sdk.m.i0.f.a((java.lang.String) r2)
            r2 = 1
            if (r0 != r2) goto L_0x002e
            java.lang.String r0 = "openIdPackage"
            java.lang.String r0 = r6.getStringExtra(r0)
            java.lang.String r5 = r5.getPackageName()
            boolean r5 = android.text.TextUtils.equals(r0, r5)
            if (r5 == 0) goto L_0x0045
            goto L_0x0044
        L_0x002e:
            r3 = 2
            if (r0 != r3) goto L_0x0042
            java.lang.String r0 = "openIdPackageList"
            java.util.ArrayList r0 = r6.getStringArrayListExtra(r0)
            if (r0 == 0) goto L_0x0045
            java.lang.String r5 = r5.getPackageName()
            boolean r1 = r0.contains(r5)
            goto L_0x0045
        L_0x0042:
            if (r0 != 0) goto L_0x0045
        L_0x0044:
            r1 = 1
        L_0x0045:
            if (r1 != 0) goto L_0x0048
            return
        L_0x0048:
            java.lang.String r5 = "openIdType"
            java.lang.String r5 = r6.getStringExtra(r5)
            com.alipay.sdk.m.i0.f r6 = com.alipay.sdk.m.i0.f.a()
            java.lang.String r0 = "oaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x005d
            com.alipay.sdk.m.i0.a r5 = r6.b
            goto L_0x007f
        L_0x005d:
            java.lang.String r0 = "vaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0068
            com.alipay.sdk.m.i0.a r5 = r6.d
            goto L_0x007f
        L_0x0068:
            java.lang.String r0 = "aaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0073
            com.alipay.sdk.m.i0.a r5 = r6.c
            goto L_0x007f
        L_0x0073:
            java.lang.String r0 = "udid"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x007e
            com.alipay.sdk.m.i0.a r5 = r6.a
            goto L_0x007f
        L_0x007e:
            r5 = 0
        L_0x007f:
            if (r5 != 0) goto L_0x0082
            return
        L_0x0082:
            r5.b()
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.i0.e.onReceive(android.content.Context, android.content.Intent):void");
    }
}
