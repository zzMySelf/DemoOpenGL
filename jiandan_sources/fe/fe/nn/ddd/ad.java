package fe.fe.nn.ddd;

import android.content.Context;

public class ad {
    public Context qw;

    public ad(Context context) {
        this.qw = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String qw(int r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x0025
            r1 = 1
            if (r8 == r1) goto L_0x0013
            r1 = 2
            if (r8 == r1) goto L_0x000b
            r2 = r0
            goto L_0x002c
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
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            goto L_0x0027
        L_0x0025:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
        L_0x0027:
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r2 = r8
        L_0x002c:
            android.content.Context r8 = r7.qw
            android.content.ContentResolver r1 = r8.getContentResolver()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)
            if (r8 == 0) goto L_0x0050
            boolean r9 = r8.moveToNext()
            if (r9 == 0) goto L_0x004d
            java.lang.String r9 = "value"
            int r9 = r8.getColumnIndex(r9)
            java.lang.String r9 = r8.getString(r9)
            r0 = r9
        L_0x004d:
            r8.close()
        L_0x0050:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.nn.ddd.ad.qw(int, java.lang.String):java.lang.String");
    }
}
