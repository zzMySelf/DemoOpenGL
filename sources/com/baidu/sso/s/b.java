package com.baidu.sso.s;

import android.content.Context;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f3707a;

    public b(Context context) {
        this.f3707a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(int r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x0027
            r1 = 1
            if (r8 == r1) goto L_0x0013
            r1 = 2
            if (r8 == r1) goto L_0x000b
            r2 = r0
            goto L_0x002e
        L_0x000b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            goto L_0x001a
        L_0x0013:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
        L_0x001a:
            java.lang.StringBuilder r8 = r8.append(r1)
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            goto L_0x0029
        L_0x0027:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
        L_0x0029:
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r2 = r8
        L_0x002e:
            android.content.Context r8 = r7.f3707a
            android.content.ContentResolver r1 = r8.getContentResolver()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)
            if (r8 == 0) goto L_0x0053
            boolean r9 = r8.moveToNext()
            if (r9 == 0) goto L_0x0050
            java.lang.String r9 = "value"
            int r9 = r8.getColumnIndex(r9)
            java.lang.String r9 = r8.getString(r9)
            r0 = r9
        L_0x0050:
            r8.close()
        L_0x0053:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sso.s.b.a(int, java.lang.String):java.lang.String");
    }
}
