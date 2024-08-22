package com.baidu.sofire.xclient.privacycontrol.b;

import android.content.Context;

public class a implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ long e;
    public final /* synthetic */ long[] f;
    public final /* synthetic */ Context g;
    public final /* synthetic */ String h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f1096i;

    public a(c cVar, int i2, String str, int i3, long j, long[] jArr, Context context, String str2, String str3) {
        this.a = cVar;
        this.b = i2;
        this.c = str;
        this.d = i3;
        this.e = j;
        this.f = jArr;
        this.g = context;
        this.h = str2;
        this.f1096i = str3;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0086 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x001b A[Catch:{ all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            com.baidu.sofire.xclient.privacycontrol.b.c r0 = r9.a     // Catch:{ all -> 0x00e4 }
            int r1 = r9.b     // Catch:{ all -> 0x00e4 }
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0009
            goto L_0x0016
        L_0x0009:
            boolean r4 = r0.d     // Catch:{ all -> 0x00e4 }
            if (r4 != 0) goto L_0x000e
            goto L_0x0016
        L_0x000e:
            r4 = 2
            if (r1 != r4) goto L_0x0018
            boolean r1 = r0.f     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r1 = 0
            goto L_0x0019
        L_0x0018:
            r1 = 1
        L_0x0019:
            if (r1 == 0) goto L_0x00e4
            java.lang.String r1 = r9.c     // Catch:{ all -> 0x00e4 }
            boolean r0 = com.baidu.sofire.xclient.privacycontrol.b.b.a((com.baidu.sofire.xclient.privacycontrol.b.c) r0, (java.lang.String) r1)     // Catch:{ all -> 0x00e4 }
            if (r0 != 0) goto L_0x0025
            goto L_0x00e4
        L_0x0025:
            java.util.UUID r0 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x00e4 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00e4 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x00e4 }
            r1.<init>()     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = "1"
            int r5 = r9.d     // Catch:{ all -> 0x00e4 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00e4 }
            r1.put(r4, r5)     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = "2"
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00e4 }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r7
            r1.put(r4, r5)     // Catch:{ all -> 0x00e4 }
            com.baidu.sofire.xclient.privacycontrol.b.c r4 = r9.a     // Catch:{ all -> 0x00e4 }
            boolean r4 = r4.g     // Catch:{ all -> 0x00e4 }
            if (r4 == 0) goto L_0x0061
            java.lang.String r4 = "3"
            long r5 = r9.e     // Catch:{ all -> 0x00e4 }
            r1.put(r4, r5)     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = "11"
            long[] r5 = r9.f     // Catch:{ all -> 0x00e4 }
            java.lang.String r5 = java.util.Arrays.toString(r5)     // Catch:{ all -> 0x00e4 }
            r1.put(r4, r5)     // Catch:{ all -> 0x00e4 }
        L_0x0061:
            java.lang.String r4 = "4"
            java.lang.String r5 = r9.c     // Catch:{ all -> 0x00e4 }
            r1.put(r4, r5)     // Catch:{ all -> 0x00e4 }
            android.content.Context r4 = r9.g     // Catch:{ all -> 0x00e4 }
            java.lang.String r5 = com.baidu.sofire.xclient.privacycontrol.b.b.a     // Catch:{ all -> 0x00e4 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00e4 }
            java.lang.String r6 = ""
            if (r5 != 0) goto L_0x0075
            goto L_0x0088
        L_0x0075:
            android.content.pm.PackageManager r5 = r4.getPackageManager()     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x0086 }
            android.content.pm.PackageInfo r3 = r5.getPackageInfo(r4, r3)     // Catch:{ all -> 0x0086 }
            java.lang.String r3 = r3.versionName     // Catch:{ all -> 0x0086 }
            com.baidu.sofire.xclient.privacycontrol.b.b.a = r3     // Catch:{ all -> 0x0086 }
            goto L_0x0088
        L_0x0086:
            com.baidu.sofire.xclient.privacycontrol.b.b.a = r6     // Catch:{ all -> 0x00e4 }
        L_0x0088:
            java.lang.String r3 = com.baidu.sofire.xclient.privacycontrol.b.b.a     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = "5"
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00e4 }
            if (r5 == 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r6 = r3
        L_0x0094:
            r1.put(r4, r6)     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = "7"
            r1.put(r3, r0)     // Catch:{ all -> 0x00e4 }
            java.lang.String r0 = "10"
            android.content.Context r3 = r9.g     // Catch:{ all -> 0x00e4 }
            com.baidu.sofire.ac.F r4 = com.baidu.sofire.ac.F.getInstance()     // Catch:{ all -> 0x00e4 }
            boolean r3 = r4.cp(r3)     // Catch:{ all -> 0x00e4 }
            r1.put(r0, r3)     // Catch:{ all -> 0x00e4 }
            java.lang.String r0 = "12"
            java.lang.String r3 = r9.h     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = r9.f1096i     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = com.baidu.sofire.xclient.privacycontrol.b.b.a((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x00e4 }
            r1.put(r0, r3)     // Catch:{ all -> 0x00e4 }
            java.lang.String r0 = "13"
            int r3 = r9.b     // Catch:{ all -> 0x00e4 }
            r1.put(r0, r3)     // Catch:{ all -> 0x00e4 }
            com.baidu.sofire.xclient.privacycontrol.e.b r0 = com.baidu.sofire.xclient.privacycontrol.e.b.c()     // Catch:{ all -> 0x00e4 }
            boolean r0 = r0.e     // Catch:{ all -> 0x00e4 }
            if (r0 == 0) goto L_0x00d8
            int r0 = r9.b     // Catch:{ all -> 0x00e4 }
            if (r0 != r2) goto L_0x00d8
            java.lang.String r0 = "14"
            int r2 = android.os.Process.myPid()     // Catch:{ all -> 0x00e4 }
            java.lang.String r2 = com.baidu.sofire.xclient.privacycontrol.b.b.a((int) r2)     // Catch:{ all -> 0x00e4 }
            r1.put(r0, r2)     // Catch:{ all -> 0x00e4 }
        L_0x00d8:
            com.baidu.sofire.xclient.privacycontrol.e.b r0 = com.baidu.sofire.xclient.privacycontrol.e.b.c()     // Catch:{ all -> 0x00e4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e4 }
            r0.a((java.lang.String) r1)     // Catch:{ all -> 0x00e4 }
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.b.a.run():void");
    }
}
