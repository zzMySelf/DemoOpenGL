package com.baidu.sofire.a;

import android.content.Context;
import android.content.Intent;

public class d implements Runnable {
    public final /* synthetic */ Intent a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Context c;

    public d(Intent intent, boolean z, Context context) {
        this.a = intent;
        this.b = z;
        this.c = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00fd */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0068 A[Catch:{ all -> 0x0131 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069 A[Catch:{ all -> 0x0131 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r14 = this;
            android.content.Intent r0 = r14.a     // Catch:{ all -> 0x0131 }
            java.lang.String r0 = r0.getAction()     // Catch:{ all -> 0x0131 }
            boolean r1 = r14.b     // Catch:{ all -> 0x0131 }
            r2 = 3
            java.lang.String r3 = "android.net.conn.CONNECTIVITY_CHANGE"
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0037
            boolean r1 = r3.equals(r0)     // Catch:{ all -> 0x0131 }
            if (r1 == 0) goto L_0x0037
            android.content.Context r1 = r14.c     // Catch:{ all -> 0x0131 }
            boolean r1 = com.baidu.sofire.l.c.l(r1)     // Catch:{ all -> 0x0131 }
            if (r1 == 0) goto L_0x0037
            boolean r1 = com.baidu.sofire.b.a.s     // Catch:{ all -> 0x0131 }
            if (r1 == 0) goto L_0x0037
            android.content.Context r1 = r14.c     // Catch:{ all -> 0x0131 }
            com.baidu.sofire.l.w r1 = com.baidu.sofire.l.w.a((android.content.Context) r1)     // Catch:{ all -> 0x0131 }
            com.baidu.sofire.ac.U r6 = new com.baidu.sofire.ac.U     // Catch:{ all -> 0x0131 }
            android.content.Context r7 = r14.c     // Catch:{ all -> 0x0131 }
            android.content.Context r7 = r7.getApplicationContext()     // Catch:{ all -> 0x0131 }
            r6.<init>(r7, r2, r5)     // Catch:{ all -> 0x0131 }
            r1.b(r6)     // Catch:{ all -> 0x0131 }
            r1 = 1
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            boolean r6 = r14.b     // Catch:{ all -> 0x0131 }
            if (r6 == 0) goto L_0x0064
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x0131 }
            if (r0 == 0) goto L_0x0064
            boolean r0 = com.baidu.sofire.l.c.b     // Catch:{ all -> 0x0131 }
            if (r0 == 0) goto L_0x0064
            if (r1 != 0) goto L_0x0064
            android.content.Context r0 = r14.c     // Catch:{ all -> 0x0131 }
            boolean r0 = com.baidu.sofire.l.c.m(r0)     // Catch:{ all -> 0x0131 }
            if (r0 == 0) goto L_0x0064
            android.content.Context r0 = r14.c     // Catch:{ all -> 0x0131 }
            com.baidu.sofire.l.w r0 = com.baidu.sofire.l.w.a((android.content.Context) r0)     // Catch:{ all -> 0x0131 }
            com.baidu.sofire.ac.U r1 = new com.baidu.sofire.ac.U     // Catch:{ all -> 0x0131 }
            android.content.Context r3 = r14.c     // Catch:{ all -> 0x0131 }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0131 }
            r1.<init>(r3, r2, r5)     // Catch:{ all -> 0x0131 }
            r0.b(r1)     // Catch:{ all -> 0x0131 }
        L_0x0064:
            boolean r0 = r14.b     // Catch:{ all -> 0x0131 }
            if (r0 == 0) goto L_0x0069
            return
        L_0x0069:
            android.content.Intent r0 = r14.a     // Catch:{ all -> 0x0131 }
            java.lang.String r1 = "from_plugin_package"
            java.lang.String r0 = r0.getStringExtra(r1)     // Catch:{ all -> 0x0131 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0131 }
            if (r1 == 0) goto L_0x0103
            com.baidu.sofire.b.j r0 = com.baidu.sofire.b.j.g     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x007c
            return
        L_0x007c:
            java.util.List r0 = r0.b()     // Catch:{ all -> 0x0131 }
            if (r0 == 0) goto L_0x0102
            r1 = 0
        L_0x0083:
            int r2 = r0.size()     // Catch:{ all -> 0x0131 }
            if (r1 >= r2) goto L_0x0102
            java.lang.Object r2 = r0.get(r1)     // Catch:{ all -> 0x0131 }
            com.baidu.sofire.core.ApkInfo r2 = (com.baidu.sofire.core.ApkInfo) r2     // Catch:{ all -> 0x0131 }
            java.util.List<com.baidu.sofire.b.k> r3 = r2.intentFilters     // Catch:{ all -> 0x0131 }
            if (r3 == 0) goto L_0x00ff
            r3 = 0
        L_0x0094:
            java.util.List<com.baidu.sofire.b.k> r6 = r2.intentFilters     // Catch:{ all -> 0x00fd }
            int r6 = r6.size()     // Catch:{ all -> 0x00fd }
            if (r3 >= r6) goto L_0x00ff
            java.util.List<com.baidu.sofire.b.k> r6 = r2.intentFilters     // Catch:{ all -> 0x00fd }
            java.lang.Object r6 = r6.get(r3)     // Catch:{ all -> 0x00fd }
            com.baidu.sofire.b.k r6 = (com.baidu.sofire.b.k) r6     // Catch:{ all -> 0x00fd }
            android.content.IntentFilter r7 = r6.d     // Catch:{ all -> 0x00fd }
            android.content.Intent r8 = r14.a     // Catch:{ all -> 0x00fd }
            java.lang.String r8 = r8.getAction()     // Catch:{ all -> 0x00fd }
            android.content.Intent r9 = r14.a     // Catch:{ all -> 0x00fd }
            java.lang.String r9 = r9.getType()     // Catch:{ all -> 0x00fd }
            android.content.Intent r10 = r14.a     // Catch:{ all -> 0x00fd }
            java.lang.String r10 = r10.getScheme()     // Catch:{ all -> 0x00fd }
            android.content.Intent r11 = r14.a     // Catch:{ all -> 0x00fd }
            android.net.Uri r11 = r11.getData()     // Catch:{ all -> 0x00fd }
            android.content.Intent r12 = r14.a     // Catch:{ all -> 0x00fd }
            java.util.Set r12 = r12.getCategories()     // Catch:{ all -> 0x00fd }
            java.lang.String r13 = "PIF"
            int r7 = r7.match(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00fd }
            if (r7 < 0) goto L_0x00fa
            java.lang.ClassLoader r7 = r2.classLoader     // Catch:{ all -> 0x00fd }
            java.lang.String r8 = r6.b     // Catch:{ all -> 0x00fd }
            java.lang.Class r7 = r7.loadClass(r8)     // Catch:{ all -> 0x00fd }
            java.lang.Object r8 = r7.newInstance()     // Catch:{ all -> 0x00fd }
            java.lang.String r6 = r6.c     // Catch:{ all -> 0x00fd }
            r9 = 2
            java.lang.Class[] r10 = new java.lang.Class[r9]     // Catch:{ all -> 0x00fd }
            java.lang.Class<android.content.Context> r11 = android.content.Context.class
            r10[r5] = r11     // Catch:{ all -> 0x00fd }
            java.lang.Class<android.content.Intent> r11 = android.content.Intent.class
            r10[r4] = r11     // Catch:{ all -> 0x00fd }
            java.lang.reflect.Method r6 = r7.getDeclaredMethod(r6, r10)     // Catch:{ all -> 0x00fd }
            java.lang.Object[] r7 = new java.lang.Object[r9]     // Catch:{ all -> 0x00fd }
            android.content.Context r9 = r14.c     // Catch:{ all -> 0x00fd }
            android.content.Context r9 = r9.getApplicationContext()     // Catch:{ all -> 0x00fd }
            r7[r5] = r9     // Catch:{ all -> 0x00fd }
            android.content.Intent r9 = r14.a     // Catch:{ all -> 0x00fd }
            r7[r4] = r9     // Catch:{ all -> 0x00fd }
            r6.invoke(r8, r7)     // Catch:{ all -> 0x00fd }
        L_0x00fa:
            int r3 = r3 + 1
            goto L_0x0094
        L_0x00fd:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0131 }
        L_0x00ff:
            int r1 = r1 + 1
            goto L_0x0083
        L_0x0102:
            return
        L_0x0103:
            android.content.Context r1 = r14.c     // Catch:{ all -> 0x0131 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x0131 }
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x0131 }
            if (r1 == 0) goto L_0x011b
            android.content.Context r0 = r14.c     // Catch:{ all -> 0x0131 }
            java.lang.ClassLoader r1 = r0.getClassLoader()     // Catch:{ all -> 0x0131 }
            android.content.Intent r2 = r14.a     // Catch:{ all -> 0x0131 }
            com.baidu.sofire.b.l.a((android.content.Context) r0, (java.lang.ClassLoader) r1, (android.content.Intent) r2)     // Catch:{ all -> 0x0131 }
            return
        L_0x011b:
            com.baidu.sofire.b.j r1 = com.baidu.sofire.b.j.g     // Catch:{ all -> 0x0131 }
            if (r1 != 0) goto L_0x0120
            return
        L_0x0120:
            com.baidu.sofire.core.ApkInfo r0 = r1.b((java.lang.String) r0)     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x0127
            return
        L_0x0127:
            android.content.Context r1 = r14.c     // Catch:{ all -> 0x0131 }
            java.lang.ClassLoader r0 = r0.classLoader     // Catch:{ all -> 0x0131 }
            android.content.Intent r2 = r14.a     // Catch:{ all -> 0x0131 }
            com.baidu.sofire.b.l.a((android.content.Context) r1, (java.lang.ClassLoader) r0, (android.content.Intent) r2)     // Catch:{ all -> 0x0131 }
            goto L_0x0133
        L_0x0131:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0133:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.a.d.run():void");
    }
}
