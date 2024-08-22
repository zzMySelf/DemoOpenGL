package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.s.b;
import com.alipay.sdk.m.u.h;
import com.alipay.sdk.m.u.l;
import com.alipay.sdk.m.u.n;
import java.util.List;
import java.util.Map;

public class AuthTask {
    public static final Object c = h.class;
    public Activity a;
    public com.alipay.sdk.m.x.a b;

    public class a implements h.f {
        public a() {
        }

        public void a() {
            AuthTask.this.a();
        }

        public void b() {
        }
    }

    public AuthTask(Activity activity) {
        this.a = activity;
        b.d().a(this.a);
        this.b = new com.alipay.sdk.m.x.a(activity, com.alipay.sdk.m.x.a.k);
    }

    private h.f b() {
        return new a();
    }

    private void c() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    public synchronized String auth(String str, boolean z) {
        return innerAuth(new com.alipay.sdk.m.s.a(this.a, str, com.alipay.sdk.m.k.b.n), str, z);
    }

    public synchronized Map<String, String> authV2(String str, boolean z) {
        com.alipay.sdk.m.s.a aVar;
        aVar = new com.alipay.sdk.m.s.a(this.a, str, "authV2");
        return l.a(aVar, innerAuth(aVar, str, z));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x006b, code lost:
        if (com.alipay.sdk.m.m.a.z().p() == false) goto L_0x00c1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String innerAuth(com.alipay.sdk.m.s.a r7, java.lang.String r8, boolean r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r9 == 0) goto L_0x0006
            r6.c()     // Catch:{ all -> 0x0137 }
        L_0x0006:
            com.alipay.sdk.m.s.b r9 = com.alipay.sdk.m.s.b.d()     // Catch:{ all -> 0x0137 }
            android.app.Activity r0 = r6.a     // Catch:{ all -> 0x0137 }
            r9.a(r0)     // Catch:{ all -> 0x0137 }
            java.lang.String r9 = com.alipay.sdk.m.j.b.a()     // Catch:{ all -> 0x0137 }
            java.lang.String r0 = ""
            com.alipay.sdk.m.j.a.a(r0)     // Catch:{ all -> 0x0137 }
            r0 = 1
            r1 = 0
            android.app.Activity r2 = r6.a     // Catch:{ Exception -> 0x0070 }
            java.lang.String r9 = r6.a(r2, r8, r7)     // Catch:{ Exception -> 0x0070 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
            r2.<init>()     // Catch:{ all -> 0x0137 }
            java.lang.String r3 = ""
            r2.append(r3)     // Catch:{ all -> 0x0137 }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0137 }
            r2.append(r3)     // Catch:{ all -> 0x0137 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0137 }
            java.lang.String r3 = "biz"
            java.lang.String r4 = "PgReturn"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r7, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r2)     // Catch:{ all -> 0x0137 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
            r2.<init>()     // Catch:{ all -> 0x0137 }
            java.lang.String r3 = "resultStatus"
            java.lang.String r3 = com.alipay.sdk.m.u.l.a((java.lang.String) r9, (java.lang.String) r3)     // Catch:{ all -> 0x0137 }
            r2.append(r3)     // Catch:{ all -> 0x0137 }
            java.lang.String r3 = "|"
            r2.append(r3)     // Catch:{ all -> 0x0137 }
            java.lang.String r3 = "memo"
            java.lang.String r3 = com.alipay.sdk.m.u.l.a((java.lang.String) r9, (java.lang.String) r3)     // Catch:{ all -> 0x0137 }
            r2.append(r3)     // Catch:{ all -> 0x0137 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0137 }
            java.lang.String r3 = "biz"
            java.lang.String r4 = "PgReturnV"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r7, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r2)     // Catch:{ all -> 0x0137 }
            com.alipay.sdk.m.m.a r2 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x0137 }
            boolean r2 = r2.p()     // Catch:{ all -> 0x0137 }
            if (r2 != 0) goto L_0x00ca
            goto L_0x00c1
        L_0x006e:
            r2 = move-exception
            goto L_0x00d6
        L_0x0070:
            r2 = move-exception
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x006e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
            r2.<init>()     // Catch:{ all -> 0x0137 }
            java.lang.String r3 = ""
            r2.append(r3)     // Catch:{ all -> 0x0137 }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0137 }
            r2.append(r3)     // Catch:{ all -> 0x0137 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0137 }
            java.lang.String r3 = "biz"
            java.lang.String r4 = "PgReturn"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r7, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r2)     // Catch:{ all -> 0x0137 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
            r2.<init>()     // Catch:{ all -> 0x0137 }
            java.lang.String r3 = "resultStatus"
            java.lang.String r3 = com.alipay.sdk.m.u.l.a((java.lang.String) r9, (java.lang.String) r3)     // Catch:{ all -> 0x0137 }
            r2.append(r3)     // Catch:{ all -> 0x0137 }
            java.lang.String r3 = "|"
            r2.append(r3)     // Catch:{ all -> 0x0137 }
            java.lang.String r3 = "memo"
            java.lang.String r3 = com.alipay.sdk.m.u.l.a((java.lang.String) r9, (java.lang.String) r3)     // Catch:{ all -> 0x0137 }
            r2.append(r3)     // Catch:{ all -> 0x0137 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0137 }
            java.lang.String r3 = "biz"
            java.lang.String r4 = "PgReturnV"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r7, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r2)     // Catch:{ all -> 0x0137 }
            com.alipay.sdk.m.m.a r2 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x0137 }
            boolean r2 = r2.p()     // Catch:{ all -> 0x0137 }
            if (r2 != 0) goto L_0x00ca
        L_0x00c1:
            com.alipay.sdk.m.m.a r2 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x0137 }
            android.app.Activity r3 = r6.a     // Catch:{ all -> 0x0137 }
            r2.a(r7, r3, r1, r0)     // Catch:{ all -> 0x0137 }
        L_0x00ca:
            r6.a()     // Catch:{ all -> 0x0137 }
            android.app.Activity r0 = r6.a     // Catch:{ all -> 0x0137 }
            java.lang.String r1 = r7.d     // Catch:{ all -> 0x0137 }
            com.alipay.sdk.m.k.a.b((android.content.Context) r0, (com.alipay.sdk.m.s.a) r7, (java.lang.String) r8, (java.lang.String) r1)     // Catch:{ all -> 0x0137 }
            monitor-exit(r6)
            return r9
        L_0x00d6:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
            r3.<init>()     // Catch:{ all -> 0x0137 }
            java.lang.String r4 = ""
            r3.append(r4)     // Catch:{ all -> 0x0137 }
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0137 }
            r3.append(r4)     // Catch:{ all -> 0x0137 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0137 }
            java.lang.String r4 = "biz"
            java.lang.String r5 = "PgReturn"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r7, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r3)     // Catch:{ all -> 0x0137 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
            r3.<init>()     // Catch:{ all -> 0x0137 }
            java.lang.String r4 = "resultStatus"
            java.lang.String r4 = com.alipay.sdk.m.u.l.a((java.lang.String) r9, (java.lang.String) r4)     // Catch:{ all -> 0x0137 }
            r3.append(r4)     // Catch:{ all -> 0x0137 }
            java.lang.String r4 = "|"
            r3.append(r4)     // Catch:{ all -> 0x0137 }
            java.lang.String r4 = "memo"
            java.lang.String r9 = com.alipay.sdk.m.u.l.a((java.lang.String) r9, (java.lang.String) r4)     // Catch:{ all -> 0x0137 }
            r3.append(r9)     // Catch:{ all -> 0x0137 }
            java.lang.String r9 = r3.toString()     // Catch:{ all -> 0x0137 }
            java.lang.String r3 = "biz"
            java.lang.String r4 = "PgReturnV"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r7, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r9)     // Catch:{ all -> 0x0137 }
            com.alipay.sdk.m.m.a r9 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x0137 }
            boolean r9 = r9.p()     // Catch:{ all -> 0x0137 }
            if (r9 != 0) goto L_0x012c
            com.alipay.sdk.m.m.a r9 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x0137 }
            android.app.Activity r3 = r6.a     // Catch:{ all -> 0x0137 }
            r9.a(r7, r3, r1, r0)     // Catch:{ all -> 0x0137 }
        L_0x012c:
            r6.a()     // Catch:{ all -> 0x0137 }
            android.app.Activity r9 = r6.a     // Catch:{ all -> 0x0137 }
            java.lang.String r0 = r7.d     // Catch:{ all -> 0x0137 }
            com.alipay.sdk.m.k.a.b((android.content.Context) r9, (com.alipay.sdk.m.s.a) r7, (java.lang.String) r8, (java.lang.String) r0)     // Catch:{ all -> 0x0137 }
            throw r2     // Catch:{ all -> 0x0137 }
        L_0x0137:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.innerAuth(com.alipay.sdk.m.s.a, java.lang.String, boolean):java.lang.String");
    }

    /* access modifiers changed from: private */
    public void a() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(android.app.Activity r4, java.lang.String r5, com.alipay.sdk.m.s.a r6) {
        /*
            r3 = this;
            r3.c()
            r0 = 0
            com.alipay.sdk.m.q.a r1 = new com.alipay.sdk.m.q.a     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            r1.<init>()     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            com.alipay.sdk.m.p.b r4 = r1.a((com.alipay.sdk.m.s.a) r6, (android.content.Context) r4, (java.lang.String) r5)     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            org.json.JSONObject r4 = r4.c()     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            java.lang.String r5 = "form"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            java.lang.String r5 = "onload"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            java.util.List r4 = com.alipay.sdk.m.r.b.a((org.json.JSONObject) r4)     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            r3.a()     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            r5 = 0
        L_0x0025:
            int r1 = r4.size()     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            if (r5 >= r1) goto L_0x004a
            java.lang.Object r1 = r4.get(r5)     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            com.alipay.sdk.m.r.b r1 = (com.alipay.sdk.m.r.b) r1     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            com.alipay.sdk.m.r.a r1 = r1.a()     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            com.alipay.sdk.m.r.a r2 = com.alipay.sdk.m.r.a.WapPay     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            if (r1 != r2) goto L_0x0047
            java.lang.Object r4 = r4.get(r5)     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            com.alipay.sdk.m.r.b r4 = (com.alipay.sdk.m.r.b) r4     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            java.lang.String r4 = r3.a(r6, r4)     // Catch:{ IOException -> 0x0057, all -> 0x004e }
            r3.a()
            return r4
        L_0x0047:
            int r5 = r5 + 1
            goto L_0x0025
        L_0x004a:
            r3.a()
            goto L_0x006b
        L_0x004e:
            r4 = move-exception
            java.lang.String r5 = "biz"
            java.lang.String r1 = "H5AuthDataAnalysisError"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r6, (java.lang.String) r5, (java.lang.String) r1, (java.lang.Throwable) r4)     // Catch:{ all -> 0x0086 }
            goto L_0x0068
        L_0x0057:
            r4 = move-exception
            com.alipay.sdk.m.j.c r5 = com.alipay.sdk.m.j.c.NETWORK_ERROR     // Catch:{ all -> 0x0086 }
            int r5 = r5.b()     // Catch:{ all -> 0x0086 }
            com.alipay.sdk.m.j.c r5 = com.alipay.sdk.m.j.c.b(r5)     // Catch:{ all -> 0x0086 }
            java.lang.String r0 = "net"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r6, (java.lang.String) r0, (java.lang.Throwable) r4)     // Catch:{ all -> 0x0086 }
            r0 = r5
        L_0x0068:
            r3.a()
        L_0x006b:
            if (r0 != 0) goto L_0x0077
            com.alipay.sdk.m.j.c r4 = com.alipay.sdk.m.j.c.FAILED
            int r4 = r4.b()
            com.alipay.sdk.m.j.c r0 = com.alipay.sdk.m.j.c.b(r4)
        L_0x0077:
            int r4 = r0.b()
            java.lang.String r5 = r0.a()
            java.lang.String r6 = ""
            java.lang.String r4 = com.alipay.sdk.m.j.b.a(r4, r5, r6)
            return r4
        L_0x0086:
            r4 = move-exception
            r3.a()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.b(android.app.Activity, java.lang.String, com.alipay.sdk.m.s.a):java.lang.String");
    }

    private String a(Activity activity, String str, com.alipay.sdk.m.s.a aVar) {
        String a2 = aVar.a(str);
        List<a.b> j = com.alipay.sdk.m.m.a.z().j();
        if (!com.alipay.sdk.m.m.a.z().g || j == null) {
            j = com.alipay.sdk.m.j.a.d;
        }
        if (n.a(aVar, (Context) this.a, j, true)) {
            h hVar = new h(activity, aVar, b());
            String a3 = hVar.a(a2, false);
            hVar.a();
            if (!TextUtils.equals(a3, h.f684i) && !TextUtils.equals(a3, h.j)) {
                return TextUtils.isEmpty(a3) ? com.alipay.sdk.m.j.b.a() : a3;
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.i0);
            return b(activity, a2, aVar);
        }
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.j0);
        return b(activity, a2, aVar);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r5 = com.alipay.sdk.m.j.b.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return com.alipay.sdk.m.j.b.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002e, code lost:
        r4 = com.alipay.sdk.m.j.b.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0036, code lost:
        if (android.text.TextUtils.isEmpty(r4) == false) goto L_?;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(com.alipay.sdk.m.s.a r4, com.alipay.sdk.m.r.b r5) {
        /*
            r3 = this;
            java.lang.String[] r5 = r5.c()
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r1 = 0
            r5 = r5[r1]
            java.lang.String r1 = "url"
            r0.putString(r1, r5)
            android.content.Intent r5 = new android.content.Intent
            android.app.Activity r1 = r3.a
            java.lang.Class<com.alipay.sdk.app.H5AuthActivity> r2 = com.alipay.sdk.app.H5AuthActivity.class
            r5.<init>(r1, r2)
            r5.putExtras(r0)
            com.alipay.sdk.m.s.a.C0016a.a((com.alipay.sdk.m.s.a) r4, (android.content.Intent) r5)
            android.app.Activity r4 = r3.a
            r4.startActivity(r5)
            java.lang.Object r4 = c
            monitor-enter(r4)
            java.lang.Object r5 = c     // Catch:{ InterruptedException -> 0x003f }
            r5.wait()     // Catch:{ InterruptedException -> 0x003f }
            monitor-exit(r4)     // Catch:{ all -> 0x003d }
            java.lang.String r4 = com.alipay.sdk.m.j.b.d()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x003c
            java.lang.String r4 = com.alipay.sdk.m.j.b.a()
        L_0x003c:
            return r4
        L_0x003d:
            r5 = move-exception
            goto L_0x0045
        L_0x003f:
            java.lang.String r5 = com.alipay.sdk.m.j.b.a()     // Catch:{ all -> 0x003d }
            monitor-exit(r4)     // Catch:{ all -> 0x003d }
            return r5
        L_0x0045:
            monitor-exit(r4)     // Catch:{ all -> 0x003d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.a(com.alipay.sdk.m.s.a, com.alipay.sdk.m.r.b):java.lang.String");
    }
}
