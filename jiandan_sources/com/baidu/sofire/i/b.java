package com.baidu.sofire.i;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sofire.b.l;
import com.baidu.sofire.l.c;
import com.baidu.sofire.l.i;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {
    public static long f;
    public static long g;
    public a a = new a(i.a());
    public com.baidu.sofire.j.a b = com.baidu.sofire.j.a.a(this.c);
    public Context c;
    public Receiver d;
    public boolean e;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:29|30|31) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
            if (r2 != null) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r0 = com.baidu.sofire.a.a.a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0087, code lost:
            r0 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0088, code lost:
            if (r2 == null) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            r2 = com.baidu.sofire.a.a.a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0085 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00cc */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r14) {
            /*
                r13 = this;
                int r0 = r14.what     // Catch:{ all -> 0x016b }
                r1 = 1
                if (r0 == r1) goto L_0x013b
                r2 = 2
                r3 = 0
                if (r0 == r2) goto L_0x0128
                r4 = 5
                if (r0 == r4) goto L_0x00f7
                r4 = 6
                if (r0 == r4) goto L_0x00df
                switch(r0) {
                    case 9: goto L_0x00d8;
                    case 10: goto L_0x0053;
                    case 11: goto L_0x0014;
                    default: goto L_0x0012;
                }     // Catch:{ all -> 0x016b }
            L_0x0012:
                goto L_0x016d
            L_0x0014:
                java.lang.Object r14 = r14.obj     // Catch:{ all -> 0x016b }
                java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x016b }
                com.baidu.sofire.i.b r0 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                android.content.Context r0 = r0.c     // Catch:{ all -> 0x016b }
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x016b }
                r1.<init>(r14)     // Catch:{ all -> 0x016b }
                org.json.JSONObject r0 = com.baidu.sofire.l.c.b((android.content.Context) r0, (org.json.JSONObject) r1)     // Catch:{ all -> 0x016b }
                com.baidu.sofire.i.b r1 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                android.content.Context r1 = r1.c     // Catch:{ all -> 0x016b }
                org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ all -> 0x016b }
                r2.<init>()     // Catch:{ all -> 0x016b }
                org.json.JSONArray r0 = r2.put(r0)     // Catch:{ all -> 0x016b }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x016b }
                boolean r0 = com.baidu.sofire.b.l.a((android.content.Context) r1, (java.lang.String) r0)     // Catch:{ all -> 0x016b }
                if (r0 != 0) goto L_0x016d
                com.baidu.sofire.i.b r0 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                android.content.Context r0 = r0.c     // Catch:{ all -> 0x016b }
                com.baidu.sofire.h.a r14 = com.baidu.sofire.l.c.b((java.lang.String) r14)     // Catch:{ all -> 0x004f }
                com.baidu.sofire.l.d r0 = com.baidu.sofire.l.d.a((android.content.Context) r0)     // Catch:{ all -> 0x004f }
                r0.a((com.baidu.sofire.h.a) r14, (boolean) r3)     // Catch:{ all -> 0x004f }
                goto L_0x016d
            L_0x004f:
                int r14 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x016b }
                goto L_0x016d
            L_0x0053:
                com.baidu.sofire.i.b r14 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                android.content.Context r14 = r14.c     // Catch:{ all -> 0x016b }
                int r14 = com.baidu.sofire.l.c.g((android.content.Context) r14)     // Catch:{ all -> 0x016b }
                if (r2 != r14) goto L_0x00cf
                com.baidu.sofire.i.b r0 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                android.content.Context r0 = r0.c     // Catch:{ all -> 0x016b }
                com.baidu.sofire.g.a r0 = com.baidu.sofire.g.a.a((android.content.Context) r0)     // Catch:{ all -> 0x016b }
                r0.getClass()     // Catch:{ all -> 0x016b }
                r2 = 0
                android.database.sqlite.SQLiteDatabase r4 = r0.b     // Catch:{ Exception -> 0x0085 }
                java.lang.String r5 = "r"
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0085 }
                if (r2 == 0) goto L_0x007f
                int r0 = r2.getCount()     // Catch:{ Exception -> 0x0085 }
                goto L_0x0080
            L_0x007f:
                r0 = 0
            L_0x0080:
                if (r2 == 0) goto L_0x0090
                goto L_0x008a
            L_0x0083:
                r14 = move-exception
                goto L_0x00c6
            L_0x0085:
                int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0083 }
                r0 = 0
                if (r2 == 0) goto L_0x0090
            L_0x008a:
                r2.close()     // Catch:{ Exception -> 0x008e }
                goto L_0x0090
            L_0x008e:
                int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x016b }
            L_0x0090:
                com.baidu.sofire.i.b r2 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                android.content.Context r2 = r2.c     // Catch:{ all -> 0x016b }
                com.baidu.sofire.j.a r2 = com.baidu.sofire.j.a.a((android.content.Context) r2)     // Catch:{ all -> 0x016b }
                android.content.SharedPreferences r2 = r2.e     // Catch:{ all -> 0x016b }
                java.lang.String r4 = "up_nu_co"
                r5 = 50
                int r2 = r2.getInt(r4, r5)     // Catch:{ all -> 0x016b }
                if (r0 < r2) goto L_0x00ab
                com.baidu.sofire.i.b r0 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                com.baidu.sofire.i.b.a((com.baidu.sofire.i.b) r0, (int) r3, (int) r14)     // Catch:{ all -> 0x016b }
                goto L_0x016d
            L_0x00ab:
                com.baidu.sofire.i.b r0 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                android.content.Context r0 = r0.c     // Catch:{ all -> 0x016b }
                com.baidu.sofire.g.a r0 = com.baidu.sofire.g.a.a((android.content.Context) r0)     // Catch:{ all -> 0x016b }
                java.util.List r0 = r0.a(r14, r1)     // Catch:{ all -> 0x016b }
                java.util.ArrayList r0 = (java.util.ArrayList) r0
                int r0 = r0.size()     // Catch:{ all -> 0x016b }
                if (r0 <= 0) goto L_0x016d
                com.baidu.sofire.i.b r0 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                com.baidu.sofire.i.b.a((com.baidu.sofire.i.b) r0, (int) r3, (int) r14)     // Catch:{ all -> 0x016b }
                goto L_0x016d
            L_0x00c6:
                if (r2 == 0) goto L_0x00ce
                r2.close()     // Catch:{ Exception -> 0x00cc }
                goto L_0x00ce
            L_0x00cc:
                int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x016b }
            L_0x00ce:
                throw r14     // Catch:{ all -> 0x016b }
            L_0x00cf:
                if (r1 != r14) goto L_0x016d
                com.baidu.sofire.i.b r0 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                com.baidu.sofire.i.b.a((com.baidu.sofire.i.b) r0, (int) r1, (int) r14)     // Catch:{ all -> 0x016b }
                goto L_0x016d
            L_0x00d8:
                com.baidu.sofire.i.b r14 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                com.baidu.sofire.i.b.a((com.baidu.sofire.i.b) r14, (int) r3, (int) r2)     // Catch:{ all -> 0x016b }
                goto L_0x016d
            L_0x00df:
                com.baidu.sofire.i.b r14 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                android.content.Context r14 = r14.c     // Catch:{ all -> 0x016b }
                int r14 = com.baidu.sofire.l.c.g((android.content.Context) r14)     // Catch:{ all -> 0x016b }
                if (r2 != r14) goto L_0x00f0
                com.baidu.sofire.i.b r0 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                com.baidu.sofire.i.b.a((com.baidu.sofire.i.b) r0, (int) r3, (int) r14)     // Catch:{ all -> 0x016b }
                goto L_0x016d
            L_0x00f0:
                com.baidu.sofire.i.b r0 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                com.baidu.sofire.i.b.a((com.baidu.sofire.i.b) r0, (int) r1, (int) r14)     // Catch:{ all -> 0x016b }
                goto L_0x016d
            L_0x00f7:
                com.baidu.sofire.i.b r14 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                android.content.Context r0 = r14.c     // Catch:{ all -> 0x016b }
                com.baidu.sofire.j.a r0 = com.baidu.sofire.j.a.a((android.content.Context) r0)     // Catch:{ all -> 0x016b }
                int r1 = r0.l()     // Catch:{ all -> 0x016b }
                android.content.Context r2 = r14.c     // Catch:{ all -> 0x016b }
                com.baidu.sofire.l.d r2 = com.baidu.sofire.l.d.a((android.content.Context) r2)     // Catch:{ all -> 0x016b }
                r2.a((boolean) r3)     // Catch:{ all -> 0x016b }
                android.content.Context r14 = r14.c     // Catch:{ all -> 0x016b }
                r2 = 3600000(0x36ee80, float:5.044674E-39)
                int r1 = r1 * r2
                long r1 = (long) r1     // Catch:{ all -> 0x016b }
                com.baidu.sofire.l.c.a((android.content.Context) r14, (long) r1)     // Catch:{ all -> 0x016b }
                long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x016b }
                android.content.SharedPreferences$Editor r14 = r0.f     // Catch:{ all -> 0x016b }
                java.lang.String r3 = "re_last_ofline_time"
                r14.putLong(r3, r1)     // Catch:{ all -> 0x016b }
                android.content.SharedPreferences$Editor r14 = r0.f     // Catch:{ all -> 0x016b }
                r14.commit()     // Catch:{ all -> 0x016b }
                goto L_0x016d
            L_0x0128:
                com.baidu.sofire.i.b r14 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                r14.b()     // Catch:{ all -> 0x016b }
                com.baidu.sofire.i.b r14 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                android.content.Context r14 = r14.c     // Catch:{ all -> 0x016b }
                int r14 = com.baidu.sofire.l.c.g((android.content.Context) r14)     // Catch:{ all -> 0x016b }
                com.baidu.sofire.i.b r0 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                com.baidu.sofire.i.b.a((com.baidu.sofire.i.b) r0, (int) r3, (int) r14)     // Catch:{ all -> 0x016b }
                goto L_0x016d
            L_0x013b:
                java.lang.Object r14 = r14.obj     // Catch:{ all -> 0x016b }
                com.baidu.sofire.h.a r14 = (com.baidu.sofire.h.a) r14     // Catch:{ all -> 0x016b }
                com.baidu.sofire.i.b r0 = com.baidu.sofire.i.b.this     // Catch:{ all -> 0x016b }
                android.content.Context r0 = r0.c     // Catch:{ all -> 0x016b }
                com.baidu.sofire.g.a r0 = com.baidu.sofire.g.a.a((android.content.Context) r0)     // Catch:{ all -> 0x016b }
                r0.a((com.baidu.sofire.h.a) r14)     // Catch:{ all -> 0x016b }
                long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x016b }
                long r2 = com.baidu.sofire.i.b.f     // Catch:{ all -> 0x016b }
                long r0 = r0 - r2
                r2 = 180000(0x2bf20, double:8.8932E-319)
                int r14 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r14 < 0) goto L_0x016d
                long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x016b }
                com.baidu.sofire.i.b.f = r0     // Catch:{ all -> 0x016b }
                android.os.Message r14 = new android.os.Message     // Catch:{ all -> 0x016b }
                r14.<init>()     // Catch:{ all -> 0x016b }
                r0 = 10
                r14.what = r0     // Catch:{ all -> 0x016b }
                r13.sendMessage(r14)     // Catch:{ all -> 0x016b }
                goto L_0x016d
            L_0x016b:
                int r14 = com.baidu.sofire.a.a.a
            L_0x016d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.i.b.a.handleMessage(android.os.Message):void");
        }
    }

    public b(Context context) {
        this.c = context.getApplicationContext();
    }

    public final boolean b() {
        List<com.baidu.sofire.f.a> c2 = this.b.c();
        boolean z = false;
        if (c2 == null) {
            return false;
        }
        for (com.baidu.sofire.f.a next : c2) {
            if (a(this.b.e.getString("li_pk_s", ""), next.b) && a(next)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0182, code lost:
        if (r2 != 0) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        r0 = r1.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x018c, code lost:
        if (r2 != 0) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0196, code lost:
        if (r2 != 0) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        r0 = r1.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x019f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01a0, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01a1, code lost:
        if (r2 == 0) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        com.baidu.sofire.k.b.a(r1.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01a8, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = com.baidu.sofire.a.a.a;
        r3 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r3 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0177, code lost:
        if (r2 != 0) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        r0 = r1.c;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:110:0x0194 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0054 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0069 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0070 A[Catch:{ all -> 0x019f }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.baidu.sofire.i.b r19, int r20, int r21) {
        /*
            r1 = r19
            r2 = r20
            r0 = r21
            monitor-enter(r19)
            boolean r3 = r1.e     // Catch:{ all -> 0x01a9 }
            if (r3 == 0) goto L_0x000d
            goto L_0x019d
        L_0x000d:
            android.content.Context r3 = r1.c     // Catch:{ all -> 0x01a9 }
            java.util.Random r4 = com.baidu.sofire.l.u.a     // Catch:{ all -> 0x01a9 }
            r4 = 5
            r5 = 0
            r6 = 1
            r7 = 0
            java.text.SimpleDateFormat r9 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0069 }
            java.lang.String r10 = "HH:mm:ss"
            r9.<init>(r10)     // Catch:{ all -> 0x0069 }
            java.util.Date r10 = new java.util.Date     // Catch:{ all -> 0x0069 }
            r10.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r9 = r9.format(r10)     // Catch:{ all -> 0x0069 }
            java.lang.String r10 = ":"
            java.lang.String[] r9 = r9.split(r10)     // Catch:{ all -> 0x0069 }
            r10 = r9[r5]     // Catch:{ all -> 0x0069 }
            r9 = r9[r6]     // Catch:{ all -> 0x0069 }
            java.lang.String r11 = "00"
            boolean r10 = r11.equals(r10)     // Catch:{ all -> 0x0069 }
            if (r10 == 0) goto L_0x006b
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ all -> 0x0069 }
            if (r9 > r4) goto L_0x006b
            java.util.Random r9 = com.baidu.sofire.l.u.a     // Catch:{ all -> 0x0069 }
            r10 = 10
            int r9 = r9.nextInt(r10)     // Catch:{ all -> 0x0069 }
            int r9 = r9 + r6
            com.baidu.sofire.j.a r3 = com.baidu.sofire.j.a.a((android.content.Context) r3)     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences r3 = r3.a     // Catch:{ all -> 0x0054 }
            java.lang.String r10 = "g_r_d_r_r"
            int r3 = r3.getInt(r10, r4)     // Catch:{ all -> 0x0054 }
            goto L_0x0057
        L_0x0054:
            int r3 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0069 }
            r3 = 5
        L_0x0057:
            if (r9 <= r3) goto L_0x005a
            goto L_0x006b
        L_0x005a:
            java.util.Random r3 = com.baidu.sofire.l.u.a     // Catch:{ all -> 0x0069 }
            r9 = 600000(0x927c0, float:8.40779E-40)
            int r3 = r3.nextInt(r9)     // Catch:{ all -> 0x0069 }
            long r9 = (long) r3
            r11 = 300000(0x493e0, double:1.482197E-318)
            long r9 = r9 + r11
            goto L_0x006c
        L_0x0069:
            int r3 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x01a9 }
        L_0x006b:
            r9 = r7
        L_0x006c:
            int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x0082
            java.util.Timer r0 = new java.util.Timer     // Catch:{ all -> 0x01a9 }
            r0.<init>()     // Catch:{ all -> 0x01a9 }
            r1.e = r6     // Catch:{ all -> 0x01a9 }
            com.baidu.sofire.i.a r2 = new com.baidu.sofire.i.a     // Catch:{ all -> 0x01a9 }
            r2.<init>(r1, r0)     // Catch:{ all -> 0x01a9 }
            r0.schedule(r2, r9)     // Catch:{ all -> 0x01a9 }
            monitor-exit(r19)
            goto L_0x019e
        L_0x0082:
            if (r0 != 0) goto L_0x008a
            if (r2 != 0) goto L_0x019d
            android.content.Context r0 = r1.c     // Catch:{ all -> 0x01a9 }
            goto L_0x019a
        L_0x008a:
            boolean r3 = r19.a()     // Catch:{ all -> 0x0194 }
            if (r3 != 0) goto L_0x0096
            if (r2 != 0) goto L_0x019d
            android.content.Context r0 = r1.c     // Catch:{ all -> 0x01a9 }
            goto L_0x019a
        L_0x0096:
            if (r2 != r6) goto L_0x00a3
            android.content.Context r3 = r1.c     // Catch:{ all -> 0x0194 }
            com.baidu.sofire.g.a r3 = com.baidu.sofire.g.a.a((android.content.Context) r3)     // Catch:{ all -> 0x0194 }
            java.util.List r3 = r3.a(r0, r6)     // Catch:{ all -> 0x0194 }
            goto L_0x00ad
        L_0x00a3:
            android.content.Context r3 = r1.c     // Catch:{ all -> 0x0194 }
            com.baidu.sofire.g.a r3 = com.baidu.sofire.g.a.a((android.content.Context) r3)     // Catch:{ all -> 0x0194 }
            java.util.List r3 = r3.a(r0, r5)     // Catch:{ all -> 0x0194 }
        L_0x00ad:
            int r9 = r3.size()     // Catch:{ all -> 0x0194 }
            if (r9 > 0) goto L_0x00b9
            if (r2 != 0) goto L_0x019d
            android.content.Context r0 = r1.c     // Catch:{ all -> 0x01a9 }
            goto L_0x019a
        L_0x00b9:
            com.baidu.sofire.j.a r9 = r1.b     // Catch:{ all -> 0x0194 }
            android.content.SharedPreferences r9 = r9.e     // Catch:{ all -> 0x0194 }
            java.lang.String r10 = "re_day_len"
            long r9 = r9.getLong(r10, r7)     // Catch:{ all -> 0x0194 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0194 }
            com.baidu.sofire.j.a r13 = r1.b     // Catch:{ all -> 0x0194 }
            android.content.SharedPreferences r13 = r13.e     // Catch:{ all -> 0x0194 }
            java.lang.String r14 = "re_day_b_t"
            long r13 = r13.getLong(r14, r7)     // Catch:{ all -> 0x0194 }
            com.baidu.sofire.j.a r15 = r1.b     // Catch:{ all -> 0x0194 }
            android.content.SharedPreferences r15 = r15.e     // Catch:{ all -> 0x0194 }
            java.lang.String r6 = "re_net_dy_lt"
            r4 = 50
            int r4 = r15.getInt(r6, r4)     // Catch:{ all -> 0x0194 }
            int r6 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x00e7
            com.baidu.sofire.j.a r6 = r1.b     // Catch:{ all -> 0x0194 }
            r6.a((long) r11)     // Catch:{ all -> 0x0194 }
            r13 = r11
        L_0x00e7:
            long r13 = r11 - r13
            r16 = 86400000(0x5265c00, double:4.2687272E-316)
            r6 = 2
            r15 = 3
            int r18 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r18 >= 0) goto L_0x0128
            if (r2 != r15) goto L_0x0117
            com.baidu.sofire.j.a r7 = r1.b     // Catch:{ all -> 0x0194 }
            android.content.SharedPreferences r7 = r7.e     // Catch:{ all -> 0x0194 }
            java.lang.String r8 = "g_r_d_d_n"
            int r5 = r7.getInt(r8, r5)     // Catch:{ all -> 0x0194 }
            r7 = 5
            if (r5 < r7) goto L_0x0107
            if (r2 != 0) goto L_0x019d
            android.content.Context r0 = r1.c     // Catch:{ all -> 0x01a9 }
            goto L_0x019a
        L_0x0107:
            com.baidu.sofire.j.a r7 = r1.b     // Catch:{ all -> 0x0194 }
            r8 = 1
            int r5 = r5 + r8
            android.content.SharedPreferences$Editor r8 = r7.f     // Catch:{ all -> 0x0194 }
            java.lang.String r11 = "g_r_d_d_n"
            r8.putInt(r11, r5)     // Catch:{ all -> 0x0194 }
            android.content.SharedPreferences$Editor r5 = r7.f     // Catch:{ all -> 0x0194 }
            r5.commit()     // Catch:{ all -> 0x0194 }
        L_0x0117:
            if (r0 == r6) goto L_0x0142
            r5 = 1048576(0x100000, float:1.469368E-39)
            int r4 = r4 * r5
            long r4 = (long) r4
            int r7 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x0142
            if (r2 != 0) goto L_0x019d
            android.content.Context r0 = r1.c     // Catch:{ all -> 0x01a9 }
            goto L_0x019a
        L_0x0128:
            com.baidu.sofire.j.a r4 = r1.b     // Catch:{ all -> 0x0194 }
            r4.b((long) r7)     // Catch:{ all -> 0x0194 }
            com.baidu.sofire.j.a r4 = r1.b     // Catch:{ all -> 0x0194 }
            r4.a((long) r11)     // Catch:{ all -> 0x0194 }
            if (r2 != r15) goto L_0x0142
            com.baidu.sofire.j.a r4 = r1.b     // Catch:{ all -> 0x0194 }
            android.content.SharedPreferences$Editor r7 = r4.f     // Catch:{ all -> 0x0194 }
            java.lang.String r8 = "g_r_d_d_n"
            r7.putInt(r8, r5)     // Catch:{ all -> 0x0194 }
            android.content.SharedPreferences$Editor r4 = r4.f     // Catch:{ all -> 0x0194 }
            r4.commit()     // Catch:{ all -> 0x0194 }
        L_0x0142:
            r1.a((java.util.List<com.baidu.sofire.h.a>) r3, (int) r0, (long) r9)     // Catch:{ all -> 0x0194 }
            boolean r4 = r19.a()     // Catch:{ all -> 0x0194 }
            if (r4 != 0) goto L_0x0150
            if (r2 != 0) goto L_0x019d
            android.content.Context r0 = r1.c     // Catch:{ all -> 0x01a9 }
            goto L_0x019a
        L_0x0150:
            if (r2 != 0) goto L_0x018f
            if (r0 == r6) goto L_0x0155
            goto L_0x018f
        L_0x0155:
            int r3 = r3.size()     // Catch:{ all -> 0x0194 }
            r4 = 100
            if (r3 >= r4) goto L_0x0162
            if (r2 != 0) goto L_0x019d
            android.content.Context r0 = r1.c     // Catch:{ all -> 0x01a9 }
            goto L_0x019a
        L_0x0162:
            java.util.List r3 = r19.a((int) r20, (int) r21)     // Catch:{ all -> 0x0194 }
        L_0x0166:
            if (r3 == 0) goto L_0x018c
            int r5 = r3.size()     // Catch:{ all -> 0x0194 }
            if (r5 == 0) goto L_0x018c
            r1.a((java.util.List<com.baidu.sofire.h.a>) r3, (int) r0, (long) r9)     // Catch:{ all -> 0x0194 }
            int r3 = r3.size()     // Catch:{ all -> 0x0194 }
            if (r3 >= r4) goto L_0x017c
            if (r2 != 0) goto L_0x019d
            android.content.Context r0 = r1.c     // Catch:{ all -> 0x01a9 }
            goto L_0x019a
        L_0x017c:
            boolean r3 = r19.a()     // Catch:{ all -> 0x0194 }
            if (r3 != 0) goto L_0x0187
            if (r2 != 0) goto L_0x019d
            android.content.Context r0 = r1.c     // Catch:{ all -> 0x01a9 }
            goto L_0x019a
        L_0x0187:
            java.util.List r3 = r19.a((int) r20, (int) r21)     // Catch:{ all -> 0x0194 }
            goto L_0x0166
        L_0x018c:
            if (r2 != 0) goto L_0x019d
            goto L_0x0198
        L_0x018f:
            if (r2 != 0) goto L_0x019d
            android.content.Context r0 = r1.c     // Catch:{ all -> 0x01a9 }
            goto L_0x019a
        L_0x0194:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x019f }
            if (r2 != 0) goto L_0x019d
        L_0x0198:
            android.content.Context r0 = r1.c     // Catch:{ all -> 0x01a9 }
        L_0x019a:
            com.baidu.sofire.k.b.a((android.content.Context) r0)     // Catch:{ all -> 0x01a9 }
        L_0x019d:
            monitor-exit(r19)
        L_0x019e:
            return
        L_0x019f:
            r0 = move-exception
            r3 = r0
            if (r2 != 0) goto L_0x01a8
            android.content.Context r0 = r1.c     // Catch:{ all -> 0x01a9 }
            com.baidu.sofire.k.b.a((android.content.Context) r0)     // Catch:{ all -> 0x01a9 }
        L_0x01a8:
            throw r3     // Catch:{ all -> 0x01a9 }
        L_0x01a9:
            r0 = move-exception
            monitor-exit(r19)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.i.b.a(com.baidu.sofire.i.b, int, int):void");
    }

    public final boolean a() {
        if (g <= 0) {
            return true;
        }
        if (System.currentTimeMillis() - g < 300000) {
            return false;
        }
        g = 0;
        return true;
    }

    public final List<com.baidu.sofire.h.a> a(int i2, int i3) {
        if (i2 == 0 && i3 == 2) {
            return com.baidu.sofire.g.a.a(this.c).a(i3, false);
        }
        return null;
    }

    public final void a(List<com.baidu.sofire.h.a> list, int i2, long j) {
        int i3 = this.b.e.getInt("re_net_one_lt", 5);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        for (com.baidu.sofire.h.a next : list) {
            try {
                JSONObject b2 = c.b(this.c, new JSONObject(next.e));
                int length = b2.toString().length() + i4;
                if (length >= 1048576 * i3) {
                    break;
                }
                arrayList.add(Integer.valueOf(next.a));
                arrayList2.add(new com.baidu.sofire.h.b(b2, next.k, next.a));
                i4 = length;
            } catch (Exception unused) {
                int i5 = com.baidu.sofire.a.a.a;
            }
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList3 = new ArrayList();
        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
            com.baidu.sofire.h.b bVar = (com.baidu.sofire.h.b) arrayList2.get(i6);
            if (bVar != null) {
                String str = bVar.b;
                if (TextUtils.isEmpty(str)) {
                    jSONArray.put(bVar.a);
                    arrayList3.add(Integer.valueOf(bVar.c));
                } else {
                    if (hashMap.containsKey(str)) {
                        JSONArray jSONArray2 = (JSONArray) hashMap.get(str);
                        if (jSONArray2 == null) {
                            jSONArray2 = new JSONArray();
                        }
                        jSONArray2.put(bVar.a);
                        hashMap.put(str, jSONArray2);
                    } else {
                        JSONArray jSONArray3 = new JSONArray();
                        jSONArray3.put(bVar.a);
                        hashMap.put(str, jSONArray3);
                    }
                    ArrayList arrayList4 = (ArrayList) hashMap2.get(str);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(Integer.valueOf(bVar.c));
                    hashMap2.put(str, arrayList4);
                }
            }
        }
        if (jSONArray.length() > 0) {
            if (l.a(this.c, jSONArray.toString())) {
                com.baidu.sofire.g.a.a(this.c).a((List<Integer>) arrayList3);
            } else {
                g = System.currentTimeMillis();
            }
        }
        if (hashMap.size() > 0) {
            for (String str2 : hashMap.keySet()) {
                JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    if (l.a(this.c, jSONArray4.toString())) {
                        com.baidu.sofire.g.a.a(this.c).a((List<Integer>) (List) hashMap2.get(str2));
                    } else {
                        g = System.currentTimeMillis();
                    }
                }
            }
        }
        com.baidu.sofire.g.a a2 = com.baidu.sofire.g.a.a(this.c);
        com.baidu.sofire.j.a a3 = com.baidu.sofire.j.a.a(a2.c);
        long currentTimeMillis = System.currentTimeMillis();
        int i7 = a3.e.getInt("re_net_over", 7) * 86400000;
        try {
            a2.b.delete("r", "(d <= ? or (d < (" + currentTimeMillis + "-" + "f" + "*" + 3600000 + ") and " + "f" + "!= 0)) and " + "b" + " != '1001001'and " + com.cmic.sso.sdk.e.i.a + " != 5 ", new String[]{String.valueOf(currentTimeMillis - ((long) i7))});
        } catch (Exception unused2) {
            int i8 = com.baidu.sofire.a.a.a;
        }
        if (2 != i2) {
            this.b.b(((long) i4) + j);
        }
    }

    public final boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.equals(this.c.getPackageName())) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (str2.equals(jSONArray.get(i2))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x00e8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x00f7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(com.baidu.sofire.f.a r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            com.baidu.sofire.j.a r0 = r12.b     // Catch:{ all -> 0x011a }
            java.lang.String r1 = r13.d     // Catch:{ all -> 0x011a }
            android.content.SharedPreferences r0 = r0.e     // Catch:{ all -> 0x011a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x011a }
            r2.<init>()     // Catch:{ all -> 0x011a }
            java.lang.String r3 = "re_net_ali2_"
            r2.append(r3)     // Catch:{ all -> 0x011a }
            r2.append(r1)     // Catch:{ all -> 0x011a }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x011a }
            java.lang.String r2 = ""
            java.lang.String r0 = r0.getString(r1, r2)     // Catch:{ all -> 0x011a }
            java.util.Calendar r1 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x011a }
            r2 = 1
            int r3 = r1.get(r2)     // Catch:{ all -> 0x011a }
            r4 = 2
            int r5 = r1.get(r4)     // Catch:{ all -> 0x011a }
            r6 = 5
            int r1 = r1.get(r6)     // Catch:{ all -> 0x011a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x011a }
            r7.<init>()     // Catch:{ all -> 0x011a }
            r7.append(r3)     // Catch:{ all -> 0x011a }
            java.lang.String r3 = ""
            r7.append(r3)     // Catch:{ all -> 0x011a }
            r7.append(r5)     // Catch:{ all -> 0x011a }
            java.lang.String r3 = ""
            r7.append(r3)     // Catch:{ all -> 0x011a }
            r7.append(r1)     // Catch:{ all -> 0x011a }
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x011a }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x011a }
            r3 = 0
            if (r0 == 0) goto L_0x0056
            monitor-exit(r12)
            return r3
        L_0x0056:
            com.baidu.sofire.j.a r0 = r12.b     // Catch:{ all -> 0x011a }
            java.lang.String r5 = r13.d     // Catch:{ all -> 0x011a }
            android.content.SharedPreferences r0 = r0.e     // Catch:{ all -> 0x011a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x011a }
            r7.<init>()     // Catch:{ all -> 0x011a }
            java.lang.String r8 = "al_da"
            r7.append(r8)     // Catch:{ all -> 0x011a }
            r7.append(r5)     // Catch:{ all -> 0x011a }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x011a }
            java.lang.String r7 = ""
            java.lang.String r0 = r0.getString(r5, r7)     // Catch:{ all -> 0x011a }
            java.lang.String r5 = r13.d     // Catch:{ all -> 0x011a }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x011a }
            android.content.Context r9 = r12.c     // Catch:{ all -> 0x011a }
            org.json.JSONObject r0 = com.baidu.sofire.l.c.a((android.content.Context) r9, (com.baidu.sofire.f.a) r13, (java.lang.String) r0, (boolean) r2)     // Catch:{ all -> 0x011a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x011a }
            android.content.Context r9 = r12.c     // Catch:{ all -> 0x011a }
            com.baidu.sofire.g.a r9 = com.baidu.sofire.g.a.a((android.content.Context) r9)     // Catch:{ all -> 0x011a }
            android.content.ContentValues r10 = new android.content.ContentValues     // Catch:{ all -> 0x011a }
            r10.<init>()     // Catch:{ all -> 0x011a }
            java.lang.String r11 = "b"
            r10.put(r11, r5)     // Catch:{ all -> 0x011a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x011a }
            java.lang.String r5 = "c"
            r10.put(r5, r4)     // Catch:{ all -> 0x011a }
            java.lang.Long r4 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x011a }
            java.lang.String r5 = "d"
            r10.put(r5, r4)     // Catch:{ all -> 0x011a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x011a }
            java.lang.String r5 = "e"
            r10.put(r5, r4)     // Catch:{ all -> 0x011a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x011a }
            java.lang.String r5 = "g"
            r10.put(r5, r4)     // Catch:{ all -> 0x011a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x011a }
            java.lang.String r5 = "f"
            r10.put(r5, r4)     // Catch:{ all -> 0x011a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x011a }
            java.lang.String r5 = "i"
            r10.put(r5, r4)     // Catch:{ all -> 0x011a }
            java.lang.String r4 = "j"
            r5 = 0
            r10.put(r4, r5)     // Catch:{ all -> 0x011a }
            com.baidu.sofire.ac.F r4 = com.baidu.sofire.ac.F.getInstance()     // Catch:{ Exception -> 0x00e8 }
            byte[] r6 = r0.getBytes()     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r7 = "xVOTuxgN3lkRN2v4"
            java.lang.String r8 = "utf-8"
            byte[] r7 = r7.getBytes(r8)     // Catch:{ Exception -> 0x00e8 }
            byte[] r4 = r4.ae(r6, r7)     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r0 = android.util.Base64.encodeToString(r4, r3)     // Catch:{ Exception -> 0x00e8 }
            goto L_0x00ea
        L_0x00e8:
            int r3 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x011a }
        L_0x00ea:
            java.lang.String r3 = "h"
            r10.put(r3, r0)     // Catch:{ all -> 0x011a }
            android.database.sqlite.SQLiteDatabase r0 = r9.b     // Catch:{ all -> 0x00f7 }
            java.lang.String r3 = "r"
            r0.insert(r3, r5, r10)     // Catch:{ all -> 0x00f7 }
            goto L_0x00f9
        L_0x00f7:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x011a }
        L_0x00f9:
            com.baidu.sofire.j.a r0 = r12.b     // Catch:{ all -> 0x011a }
            java.lang.String r13 = r13.d     // Catch:{ all -> 0x011a }
            android.content.SharedPreferences$Editor r3 = r0.f     // Catch:{ all -> 0x011a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x011a }
            r4.<init>()     // Catch:{ all -> 0x011a }
            java.lang.String r5 = "re_net_ali2_"
            r4.append(r5)     // Catch:{ all -> 0x011a }
            r4.append(r13)     // Catch:{ all -> 0x011a }
            java.lang.String r13 = r4.toString()     // Catch:{ all -> 0x011a }
            r3.putString(r13, r1)     // Catch:{ all -> 0x011a }
            android.content.SharedPreferences$Editor r13 = r0.f     // Catch:{ all -> 0x011a }
            r13.commit()     // Catch:{ all -> 0x011a }
            monitor-exit(r12)
            return r2
        L_0x011a:
            r13 = move-exception
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.i.b.a(com.baidu.sofire.f.a):boolean");
    }
}
