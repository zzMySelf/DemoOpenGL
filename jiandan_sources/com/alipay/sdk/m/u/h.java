package com.alipay.sdk.m.u;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.APayEntranceActivity;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.n;
import com.baidu.android.common.others.lang.StringUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class h {

    /* renamed from: i  reason: collision with root package name */
    public static final String f684i = "failed";
    public static final String j = "scheme_failed";
    public Activity a;
    public volatile IAlixPay b;
    public final Object c = IAlixPay.class;
    public boolean d;
    public f e;
    public final com.alipay.sdk.m.s.a f;
    public boolean g = false;
    public String h = null;

    public class a implements APayEntranceActivity.a {
        public final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        public void a(String str) {
            String unused = h.this.h = str;
            synchronized (this.a) {
                try {
                    this.a.notify();
                } catch (Throwable th2) {
                    com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, "BSAResultEx", th2);
                }
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ APayEntranceActivity.a a;

        public b(APayEntranceActivity.a aVar) {
            this.a = aVar;
        }

        public void run() {
            if (h.this.f != null && !h.this.f.d()) {
                com.alipay.sdk.m.k.a.b(h.this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.e0, "");
                if (com.alipay.sdk.m.m.a.z().t()) {
                    h.this.f.b(true);
                    this.a.a(com.alipay.sdk.m.j.b.a());
                }
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Intent a;
        public final /* synthetic */ Object b;

        public c(Intent intent, Object obj) {
            this.a = intent;
            this.b = obj;
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                com.alipay.sdk.m.u.h r0 = com.alipay.sdk.m.u.h.this     // Catch:{ all -> 0x0035 }
                android.app.Activity r0 = r0.a     // Catch:{ all -> 0x0035 }
                if (r0 == 0) goto L_0x0014
                com.alipay.sdk.m.u.h r0 = com.alipay.sdk.m.u.h.this     // Catch:{ all -> 0x0035 }
                android.app.Activity r0 = r0.a     // Catch:{ all -> 0x0035 }
                android.content.Intent r1 = r5.a     // Catch:{ all -> 0x0035 }
                r0.startActivity(r1)     // Catch:{ all -> 0x0035 }
                goto L_0x0075
            L_0x0014:
                com.alipay.sdk.m.u.h r0 = com.alipay.sdk.m.u.h.this     // Catch:{ all -> 0x0035 }
                com.alipay.sdk.m.s.a r0 = r0.f     // Catch:{ all -> 0x0035 }
                java.lang.String r1 = "biz"
                java.lang.String r2 = "ErrActNull2"
                java.lang.String r3 = ""
                com.alipay.sdk.m.k.a.b((com.alipay.sdk.m.s.a) r0, (java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0035 }
                com.alipay.sdk.m.u.h r0 = com.alipay.sdk.m.u.h.this     // Catch:{ all -> 0x0035 }
                com.alipay.sdk.m.s.a r0 = r0.f     // Catch:{ all -> 0x0035 }
                android.content.Context r0 = r0.a()     // Catch:{ all -> 0x0035 }
                if (r0 == 0) goto L_0x0075
                android.content.Intent r1 = r5.a     // Catch:{ all -> 0x0035 }
                r0.startActivity(r1)     // Catch:{ all -> 0x0035 }
                goto L_0x0075
            L_0x0035:
                r0 = move-exception
                com.alipay.sdk.m.u.h r1 = com.alipay.sdk.m.u.h.this
                com.alipay.sdk.m.s.a r1 = r1.f
                java.lang.String r2 = "biz"
                java.lang.String r3 = "ErrActEx2"
                com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.Throwable) r0)
                com.alipay.sdk.m.u.h r0 = com.alipay.sdk.m.u.h.this
                android.app.Activity r0 = r0.a
                com.alipay.sdk.m.u.h r1 = com.alipay.sdk.m.u.h.this
                com.alipay.sdk.m.s.a r1 = r1.f
                java.lang.String r2 = "alipaySdk"
                java.lang.String r3 = "startActivityEx"
                com.alipay.sdk.m.u.n.a((java.lang.String) r2, (java.lang.String) r3, (android.content.Context) r0, (com.alipay.sdk.m.s.a) r1)
                java.lang.Object r0 = r5.b
                monitor-enter(r0)
                com.alipay.sdk.m.u.h r1 = com.alipay.sdk.m.u.h.this     // Catch:{ all -> 0x0066 }
                java.lang.String r2 = "scheme_failed"
                java.lang.String unused = r1.h = r2     // Catch:{ all -> 0x0066 }
                java.lang.Object r1 = r5.b     // Catch:{ all -> 0x0066 }
                r1.notify()     // Catch:{ all -> 0x0066 }
                goto L_0x0074
            L_0x0066:
                r1 = move-exception
                com.alipay.sdk.m.u.h r2 = com.alipay.sdk.m.u.h.this     // Catch:{ all -> 0x0076 }
                com.alipay.sdk.m.s.a r2 = r2.f     // Catch:{ all -> 0x0076 }
                java.lang.String r3 = "biz"
                java.lang.String r4 = "BSAResultEx"
                com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0076 }
            L_0x0074:
                monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            L_0x0075:
                return
            L_0x0076:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0076 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.u.h.c.run():void");
        }
    }

    public class d extends IRemoteServiceCallback.Stub {
        public d() {
        }

        public int getVersion() throws RemoteException {
            return 4;
        }

        public boolean isHideLoadingScreen() throws RemoteException {
            return false;
        }

        public void payEnd(boolean z, String str) throws RemoteException {
        }

        public void r03(String str, String str2, Map map) throws RemoteException {
            com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.p, str, str2);
            if (TextUtils.equals(str2, "ActivityStartSuccess")) {
                if (h.this.e != null) {
                    h.this.e.a();
                }
                if (h.this.f != null) {
                    h.this.f.c(true);
                }
            }
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005d */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0067 A[SYNTHETIC, Splitter:B:20:0x0067] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0094 A[Catch:{ all -> 0x00af }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void startActivity(java.lang.String r6, java.lang.String r7, int r8, android.os.Bundle r9) throws android.os.RemoteException {
            /*
                r5 = this;
                java.lang.String r0 = "|"
                java.lang.String r1 = "biz"
                android.content.Intent r2 = new android.content.Intent
                java.lang.String r3 = "android.intent.action.MAIN"
                r4 = 0
                r2.<init>(r3, r4)
                if (r9 != 0) goto L_0x0013
                android.os.Bundle r9 = new android.os.Bundle
                r9.<init>()
            L_0x0013:
                java.lang.String r3 = "CallingPid"
                r9.putInt(r3, r8)     // Catch:{ Exception -> 0x001c }
                r2.putExtras(r9)     // Catch:{ Exception -> 0x001c }
                goto L_0x0028
            L_0x001c:
                r8 = move-exception
                com.alipay.sdk.m.u.h r9 = com.alipay.sdk.m.u.h.this
                com.alipay.sdk.m.s.a r9 = r9.f
                java.lang.String r3 = "ErrIntentEx"
                com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r9, (java.lang.String) r1, (java.lang.String) r3, (java.lang.Throwable) r8)
            L_0x0028:
                r2.setClassName(r6, r7)
                int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x005d }
                r7 = 16
                if (r6 < r7) goto L_0x005d
                android.app.ActivityManager$RunningAppProcessInfo r6 = new android.app.ActivityManager$RunningAppProcessInfo     // Catch:{ all -> 0x005d }
                r6.<init>()     // Catch:{ all -> 0x005d }
                android.app.ActivityManager.getMyMemoryState(r6)     // Catch:{ all -> 0x005d }
                com.alipay.sdk.m.u.h r7 = com.alipay.sdk.m.u.h.this     // Catch:{ all -> 0x005d }
                com.alipay.sdk.m.s.a r7 = r7.f     // Catch:{ all -> 0x005d }
                java.lang.String r8 = "isFg"
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
                r9.<init>()     // Catch:{ all -> 0x005d }
                java.lang.String r3 = r6.processName     // Catch:{ all -> 0x005d }
                r9.append(r3)     // Catch:{ all -> 0x005d }
                r9.append(r0)     // Catch:{ all -> 0x005d }
                int r6 = r6.importance     // Catch:{ all -> 0x005d }
                r9.append(r6)     // Catch:{ all -> 0x005d }
                r9.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r6 = r9.toString()     // Catch:{ all -> 0x005d }
                com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r7, (java.lang.String) r1, (java.lang.String) r8, (java.lang.String) r6)     // Catch:{ all -> 0x005d }
            L_0x005d:
                com.alipay.sdk.m.u.h r6 = com.alipay.sdk.m.u.h.this     // Catch:{ all -> 0x00af }
                android.app.Activity r6 = r6.a     // Catch:{ all -> 0x00af }
                java.lang.String r7 = ""
                if (r6 == 0) goto L_0x0094
                long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00af }
                com.alipay.sdk.m.u.h r6 = com.alipay.sdk.m.u.h.this     // Catch:{ all -> 0x00af }
                android.app.Activity r6 = r6.a     // Catch:{ all -> 0x00af }
                r6.startActivity(r2)     // Catch:{ all -> 0x00af }
                com.alipay.sdk.m.u.h r6 = com.alipay.sdk.m.u.h.this     // Catch:{ all -> 0x00af }
                com.alipay.sdk.m.s.a r6 = r6.f     // Catch:{ all -> 0x00af }
                java.lang.String r0 = "stAct2"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
                r2.<init>()     // Catch:{ all -> 0x00af }
                r2.append(r7)     // Catch:{ all -> 0x00af }
                long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00af }
                long r3 = r3 - r8
                r2.append(r3)     // Catch:{ all -> 0x00af }
                java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x00af }
                com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r6, (java.lang.String) r1, (java.lang.String) r0, (java.lang.String) r7)     // Catch:{ all -> 0x00af }
                goto L_0x00ae
            L_0x0094:
                com.alipay.sdk.m.u.h r6 = com.alipay.sdk.m.u.h.this     // Catch:{ all -> 0x00af }
                com.alipay.sdk.m.s.a r6 = r6.f     // Catch:{ all -> 0x00af }
                java.lang.String r8 = "ErrActNull"
                com.alipay.sdk.m.k.a.b((com.alipay.sdk.m.s.a) r6, (java.lang.String) r1, (java.lang.String) r8, (java.lang.String) r7)     // Catch:{ all -> 0x00af }
                com.alipay.sdk.m.u.h r6 = com.alipay.sdk.m.u.h.this     // Catch:{ all -> 0x00af }
                com.alipay.sdk.m.s.a r6 = r6.f     // Catch:{ all -> 0x00af }
                android.content.Context r6 = r6.a()     // Catch:{ all -> 0x00af }
                if (r6 == 0) goto L_0x00ae
                r6.startActivity(r2)     // Catch:{ all -> 0x00af }
            L_0x00ae:
                return
            L_0x00af:
                r6 = move-exception
                com.alipay.sdk.m.u.h r7 = com.alipay.sdk.m.u.h.this
                com.alipay.sdk.m.s.a r7 = r7.f
                java.lang.String r8 = "ErrActEx"
                com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r7, (java.lang.String) r1, (java.lang.String) r8, (java.lang.Throwable) r6)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.u.h.d.startActivity(java.lang.String, java.lang.String, int, android.os.Bundle):void");
        }

        public /* synthetic */ d(h hVar, a aVar) {
            this();
        }
    }

    public class e implements ServiceConnection {
        public e() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, "srvCon");
            synchronized (h.this.c) {
                IAlixPay unused = h.this.b = IAlixPay.Stub.asInterface(iBinder);
                h.this.c.notify();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            com.alipay.sdk.m.k.a.a(h.this.f, com.alipay.sdk.m.k.b.l, "srvDis");
            IAlixPay unused = h.this.b = null;
        }

        public /* synthetic */ e(h hVar, a aVar) {
            this();
        }
    }

    public interface f {
        void a();

        void b();
    }

    public h(Activity activity, com.alipay.sdk.m.s.a aVar, f fVar) {
        this.a = activity;
        this.f = aVar;
        this.e = fVar;
        e.d(com.alipay.sdk.m.l.a.A, "alipaySdk");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005a A[Catch:{ all -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0087 A[Catch:{ all -> 0x00ae }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r9, boolean r10) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            r1 = 0
            com.alipay.sdk.m.m.a r2 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x00b3 }
            java.util.List r2 = r2.j()     // Catch:{ all -> 0x00b3 }
            com.alipay.sdk.m.m.a r3 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x00b3 }
            boolean r3 = r3.g     // Catch:{ all -> 0x00b3 }
            if (r3 == 0) goto L_0x0015
            if (r2 != 0) goto L_0x0017
        L_0x0015:
            java.util.List<com.alipay.sdk.m.m.a$b> r2 = com.alipay.sdk.m.j.a.d     // Catch:{ all -> 0x00b3 }
        L_0x0017:
            com.alipay.sdk.m.s.a r3 = r8.f     // Catch:{ all -> 0x00b3 }
            android.app.Activity r4 = r8.a     // Catch:{ all -> 0x00b3 }
            com.alipay.sdk.m.u.n$c r2 = com.alipay.sdk.m.u.n.a((com.alipay.sdk.m.s.a) r3, (android.content.Context) r4, (java.util.List<com.alipay.sdk.m.m.a.b>) r2)     // Catch:{ all -> 0x00b3 }
            java.lang.String r3 = "failed"
            if (r2 == 0) goto L_0x00b2
            com.alipay.sdk.m.s.a r4 = r8.f     // Catch:{ all -> 0x00b0 }
            boolean r4 = r2.a(r4)     // Catch:{ all -> 0x00b0 }
            if (r4 != 0) goto L_0x00b2
            boolean r4 = r2.a()     // Catch:{ all -> 0x00b0 }
            if (r4 == 0) goto L_0x0033
            goto L_0x00b2
        L_0x0033:
            android.content.pm.PackageInfo r4 = r2.a     // Catch:{ all -> 0x00b0 }
            boolean r4 = com.alipay.sdk.m.u.n.a((android.content.pm.PackageInfo) r4)     // Catch:{ all -> 0x00b0 }
            if (r4 == 0) goto L_0x003c
            return r3
        L_0x003c:
            android.content.pm.PackageInfo r3 = r2.a     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x0052
            java.lang.String r3 = "com.eg.android.AlipayGphone"
            android.content.pm.PackageInfo r4 = r2.a     // Catch:{ all -> 0x00b0 }
            java.lang.String r4 = r4.packageName     // Catch:{ all -> 0x00b0 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x004d
            goto L_0x0052
        L_0x004d:
            android.content.pm.PackageInfo r3 = r2.a     // Catch:{ all -> 0x00b0 }
            java.lang.String r0 = r3.packageName     // Catch:{ all -> 0x00b0 }
            goto L_0x0056
        L_0x0052:
            java.lang.String r0 = com.alipay.sdk.m.u.n.b()     // Catch:{ all -> 0x00b0 }
        L_0x0056:
            android.content.pm.PackageInfo r3 = r2.a     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x005c
            android.content.pm.PackageInfo r1 = r2.a     // Catch:{ all -> 0x00b0 }
        L_0x005c:
            com.alipay.sdk.m.m.a r3 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x00b0 }
            java.lang.String r3 = r3.c()     // Catch:{ all -> 0x00b0 }
            if (r3 == 0) goto L_0x00be
            int r4 = r3.length()     // Catch:{ all -> 0x00b0 }
            if (r4 <= 0) goto L_0x00be
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x00ae }
            r4.<init>(r3)     // Catch:{ all -> 0x00ae }
            org.json.JSONObject r3 = r4.optJSONObject(r0)     // Catch:{ all -> 0x00ae }
            if (r3 == 0) goto L_0x00be
            int r4 = r3.length()     // Catch:{ all -> 0x00ae }
            if (r4 <= 0) goto L_0x00be
            java.util.Iterator r4 = r3.keys()     // Catch:{ all -> 0x00ae }
        L_0x0081:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00ae }
            if (r5 == 0) goto L_0x00be
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00ae }
            int r6 = java.lang.Integer.parseInt(r5)     // Catch:{ all -> 0x00ae }
            if (r1 == 0) goto L_0x0081
            int r7 = r1.versionCode     // Catch:{ all -> 0x00ae }
            if (r7 < r6) goto L_0x0081
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x0081 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0081 }
            com.alipay.sdk.m.m.a r6 = com.alipay.sdk.m.m.a.z()     // Catch:{ Exception -> 0x0081 }
            android.app.Activity r7 = r8.a     // Catch:{ Exception -> 0x0081 }
            boolean r5 = r6.a((android.content.Context) r7, (int) r5)     // Catch:{ Exception -> 0x0081 }
            r8.g = r5     // Catch:{ Exception -> 0x0081 }
            if (r5 == 0) goto L_0x0081
            goto L_0x00be
        L_0x00ae:
            goto L_0x00be
        L_0x00b0:
            r3 = move-exception
            goto L_0x00b5
        L_0x00b2:
            return r3
        L_0x00b3:
            r3 = move-exception
            r2 = r1
        L_0x00b5:
            com.alipay.sdk.m.s.a r4 = r8.f
            java.lang.String r5 = "biz"
            java.lang.String r6 = "CheckClientSignEx"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.Throwable) r3)
        L_0x00be:
            com.alipay.sdk.m.s.a r3 = r8.f
            boolean r3 = com.alipay.sdk.m.u.n.b((com.alipay.sdk.m.s.a) r3)
            if (r10 != 0) goto L_0x00ca
            boolean r10 = r8.g
            if (r10 == 0) goto L_0x00db
        L_0x00ca:
            if (r3 != 0) goto L_0x00db
            android.app.Activity r10 = r8.a
            com.alipay.sdk.m.s.a r3 = r8.f
            boolean r10 = a((java.lang.String) r0, (android.content.Context) r10, (com.alipay.sdk.m.s.a) r3)
            if (r10 == 0) goto L_0x00db
            java.lang.String r9 = r8.a((java.lang.String) r9, (java.lang.String) r0, (android.content.pm.PackageInfo) r1)
            return r9
        L_0x00db:
            java.lang.String r9 = r8.a(r9, r0, r1, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.u.h.a(java.lang.String, boolean):java.lang.String");
    }

    private void a(n.c cVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (cVar != null && (packageInfo = cVar.a) != null) {
            String str = packageInfo.packageName;
            Intent intent = new Intent();
            intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
            try {
                this.a.startActivity(intent);
            } catch (Throwable th2) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.g0, th2);
            }
            Thread.sleep(200);
        }
    }

    private String a(String str, String str2, PackageInfo packageInfo) {
        String str3 = packageInfo != null ? packageInfo.versionName : "";
        e.d(com.alipay.sdk.m.l.a.A, "pay payInvokeAct");
        com.alipay.sdk.m.s.a aVar = this.f;
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.X, str2 + "|" + str3);
        Activity activity = this.a;
        com.alipay.sdk.m.s.a aVar2 = this.f;
        com.alipay.sdk.m.k.a.a((Context) activity, aVar2, str, aVar2.d);
        return a(str, str2);
    }

    private String a(String str, String str2, PackageInfo packageInfo, n.c cVar) {
        String str3;
        Activity activity;
        boolean z = false;
        int i2 = packageInfo != null ? packageInfo.versionCode : 0;
        if (packageInfo != null) {
            String str4 = packageInfo.versionName;
        }
        e.d(com.alipay.sdk.m.l.a.A, "pay bind or scheme");
        com.alipay.sdk.m.s.a aVar = this.f;
        if (aVar != null && !TextUtils.isEmpty(aVar.g)) {
            z = this.f.g.toLowerCase().contains(com.alipay.sdk.m.k.b.n);
        }
        if (z || !n.d(this.f, str2)) {
            if (cVar != null) {
                try {
                    if (!com.alipay.sdk.m.m.a.z().n()) {
                        a(cVar);
                    }
                } catch (Throwable unused) {
                }
            }
            Pair<String, Boolean> a2 = a(str, str2, this.f);
            str3 = (String) a2.first;
            try {
                if (f684i.equals(str3) && ((Boolean) a2.second).booleanValue() && com.alipay.sdk.m.m.a.z().l()) {
                    com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BindRetry");
                    str3 = (String) a(str, str2, this.f).first;
                }
            } catch (Throwable th2) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BindRetryEx", th2);
            }
        } else {
            if (cVar != null) {
                try {
                    if (com.alipay.sdk.m.m.a.z().x()) {
                        a(cVar);
                    }
                } catch (Throwable unused2) {
                }
            }
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BindSkipByL");
            str3 = f684i;
        }
        e.d(com.alipay.sdk.m.l.a.A, "pay bind result: " + str3);
        Activity activity2 = this.a;
        com.alipay.sdk.m.s.a aVar2 = this.f;
        com.alipay.sdk.m.k.a.a((Context) activity2, aVar2, str, aVar2.d);
        if (f684i.equals(str3)) {
            if (!n.b.equals(str2)) {
                com.alipay.sdk.m.s.a aVar3 = this.f;
                com.alipay.sdk.m.k.a.a(aVar3, com.alipay.sdk.m.k.b.l, "BSPNotStartByAlipay", str2 + "|" + i2);
                return str3;
            } else if (i2 >= 460 && !z && (activity = this.a) != null && a(str2, (Context) activity, this.f)) {
                return a(str, str2, packageInfo);
            }
        }
        return str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02b7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02b8, code lost:
        r6 = r8;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:?, code lost:
        r4.unregisterCallback(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x02d2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x02d3, code lost:
        com.alipay.sdk.m.u.e.a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0166, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        com.alipay.sdk.m.u.e.a(r0);
        r0 = 0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:42:0x00d5, B:70:0x0161] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02ce A[SYNTHETIC, Splitter:B:168:0x02ce] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.util.Pair<java.lang.String, java.lang.Boolean> a(java.lang.String r18, java.lang.String r19, com.alipay.sdk.m.s.a r20) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = r20
            android.content.Intent r4 = new android.content.Intent
            r4.<init>()
            r0 = r19
            r4.setPackage(r0)
            java.lang.String r0 = com.alipay.sdk.m.u.n.c((java.lang.String) r19)
            r4.setAction(r0)
            long r5 = android.os.SystemClock.elapsedRealtime()
            java.lang.String r0 = "biz"
            java.lang.String r7 = "PgBindStarting"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = ""
            r8.append(r9)
            r8.append(r5)
            java.lang.String r9 = "|"
            r8.append(r9)
            r9 = 0
            if (r2 == 0) goto L_0x0039
            int r10 = r18.length()
            goto L_0x003a
        L_0x0039:
            r10 = 0
        L_0x003a:
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r0, (java.lang.String) r7, (java.lang.String) r8)
            android.app.Activity r0 = r1.a
            java.lang.String r7 = r3.d
            com.alipay.sdk.m.k.a.a((android.content.Context) r0, (com.alipay.sdk.m.s.a) r3, (java.lang.String) r2, (java.lang.String) r7)
            com.alipay.sdk.m.m.a r0 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x007a }
            boolean r0 = r0.f()     // Catch:{ all -> 0x007a }
            if (r0 != 0) goto L_0x0070
            android.app.Activity r0 = r1.a     // Catch:{ all -> 0x007a }
            android.app.Application r0 = r0.getApplication()     // Catch:{ all -> 0x007a }
            android.content.ComponentName r0 = r0.startService(r4)     // Catch:{ all -> 0x007a }
            java.lang.String r7 = "biz"
            java.lang.String r8 = "stSrv"
            if (r0 == 0) goto L_0x006a
            java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x007a }
            goto L_0x006c
        L_0x006a:
            java.lang.String r0 = "null"
        L_0x006c:
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r0)     // Catch:{ all -> 0x007a }
            goto L_0x0082
        L_0x0070:
            java.lang.String r0 = "biz"
            java.lang.String r7 = "stSrv"
            java.lang.String r8 = "skipped"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r0, (java.lang.String) r7, (java.lang.String) r8)     // Catch:{ all -> 0x007a }
            goto L_0x0082
        L_0x007a:
            r0 = move-exception
            java.lang.String r7 = "biz"
            java.lang.String r8 = "TryStartServiceEx"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r7, (java.lang.String) r8, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0375 }
        L_0x0082:
            com.alipay.sdk.m.m.a r0 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x0375 }
            boolean r0 = r0.b()     // Catch:{ all -> 0x0375 }
            r7 = 1
            if (r0 == 0) goto L_0x0099
            r0 = 65
            java.lang.String r8 = "biz"
            java.lang.String r10 = "bindFlg"
            java.lang.String r11 = "imp"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r8, (java.lang.String) r10, (java.lang.String) r11)     // Catch:{ all -> 0x0375 }
            goto L_0x009a
        L_0x0099:
            r0 = 1
        L_0x009a:
            com.alipay.sdk.m.u.h$e r8 = new com.alipay.sdk.m.u.h$e     // Catch:{ all -> 0x0375 }
            r10 = 0
            r8.<init>(r1, r10)     // Catch:{ all -> 0x0375 }
            android.app.Activity r11 = r1.a     // Catch:{ all -> 0x0375 }
            android.content.Context r11 = r11.getApplicationContext()     // Catch:{ all -> 0x0375 }
            boolean r0 = r11.bindService(r4, r8, r0)     // Catch:{ all -> 0x0375 }
            if (r0 == 0) goto L_0x036d
            java.lang.Object r4 = r1.c
            monitor-enter(r4)
            com.alipay.android.app.IAlixPay r0 = r1.b     // Catch:{ all -> 0x036a }
            if (r0 != 0) goto L_0x00ca
            java.lang.Object r0 = r1.c     // Catch:{ InterruptedException -> 0x00c2 }
            com.alipay.sdk.m.m.a r11 = com.alipay.sdk.m.m.a.z()     // Catch:{ InterruptedException -> 0x00c2 }
            int r11 = r11.i()     // Catch:{ InterruptedException -> 0x00c2 }
            long r11 = (long) r11     // Catch:{ InterruptedException -> 0x00c2 }
            r0.wait(r11)     // Catch:{ InterruptedException -> 0x00c2 }
            goto L_0x00ca
        L_0x00c2:
            r0 = move-exception
            java.lang.String r11 = "biz"
            java.lang.String r12 = "BindWaitTimeoutEx"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r11, (java.lang.String) r12, (java.lang.Throwable) r0)     // Catch:{ all -> 0x036a }
        L_0x00ca:
            monitor-exit(r4)     // Catch:{ all -> 0x036a }
            com.alipay.android.app.IAlixPay r4 = r1.b
            if (r4 != 0) goto L_0x012d
            java.lang.String r0 = "biz"
            java.lang.String r5 = "ClientBindFailed"
            java.lang.String r6 = ""
            com.alipay.sdk.m.k.a.b((com.alipay.sdk.m.s.a) r3, (java.lang.String) r0, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x02b7 }
            java.lang.String r0 = "alipaySdk"
            java.lang.String r5 = "bindServiceTimeout"
            android.app.Activity r6 = r1.a     // Catch:{ all -> 0x02b7 }
            com.alipay.sdk.m.s.a r7 = r1.f     // Catch:{ all -> 0x02b7 }
            com.alipay.sdk.m.u.n.a((java.lang.String) r0, (java.lang.String) r5, (android.content.Context) r6, (com.alipay.sdk.m.s.a) r7)     // Catch:{ all -> 0x02b7 }
            android.util.Pair r5 = new android.util.Pair     // Catch:{ all -> 0x02b7 }
            java.lang.String r0 = "failed"
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x02b7 }
            r5.<init>(r0, r6)     // Catch:{ all -> 0x02b7 }
            android.app.Activity r0 = r1.a     // Catch:{ all -> 0x00f6 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x00f6 }
            r0.unbindService(r8)     // Catch:{ all -> 0x00f6 }
            goto L_0x00fa
        L_0x00f6:
            r0 = move-exception
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r0)
        L_0x00fa:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = ""
            r0.append(r4)
            long r6 = android.os.SystemClock.elapsedRealtime()
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "biz"
            java.lang.String r6 = "PgBindEnd"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r4, (java.lang.String) r6, (java.lang.String) r0)
            android.app.Activity r0 = r1.a
            java.lang.String r4 = r3.d
            com.alipay.sdk.m.k.a.a((android.content.Context) r0, (com.alipay.sdk.m.s.a) r3, (java.lang.String) r2, (java.lang.String) r4)
            r1.b = r10
            boolean r0 = r1.d
            if (r0 == 0) goto L_0x012c
            android.app.Activity r0 = r1.a
            if (r0 == 0) goto L_0x012c
            r0.setRequestedOrientation(r9)
            r1.d = r9
        L_0x012c:
            return r5
        L_0x012d:
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x02b7 }
            java.lang.String r0 = "biz"
            java.lang.String r13 = "PgBinded"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x02b7 }
            r14.<init>()     // Catch:{ all -> 0x02b7 }
            java.lang.String r15 = ""
            r14.append(r15)     // Catch:{ all -> 0x02b7 }
            r14.append(r11)     // Catch:{ all -> 0x02b7 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x02b7 }
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r0, (java.lang.String) r13, (java.lang.String) r14)     // Catch:{ all -> 0x02b7 }
            com.alipay.sdk.m.u.h$f r0 = r1.e     // Catch:{ all -> 0x02b7 }
            if (r0 == 0) goto L_0x0152
            com.alipay.sdk.m.u.h$f r0 = r1.e     // Catch:{ all -> 0x02b7 }
            r0.b()     // Catch:{ all -> 0x02b7 }
        L_0x0152:
            android.app.Activity r0 = r1.a     // Catch:{ all -> 0x02b7 }
            int r0 = r0.getRequestedOrientation()     // Catch:{ all -> 0x02b7 }
            if (r0 != 0) goto L_0x0161
            android.app.Activity r0 = r1.a     // Catch:{ all -> 0x02b7 }
            r0.setRequestedOrientation(r7)     // Catch:{ all -> 0x02b7 }
            r1.d = r7     // Catch:{ all -> 0x02b7 }
        L_0x0161:
            int r0 = r4.getVersion()     // Catch:{ all -> 0x0166 }
            goto L_0x016c
        L_0x0166:
            r0 = move-exception
            r7 = r0
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r7)     // Catch:{ all -> 0x02b7 }
            r0 = 0
        L_0x016c:
            com.alipay.sdk.m.u.h$d r7 = new com.alipay.sdk.m.u.h$d     // Catch:{ all -> 0x02b7 }
            r7.<init>(r1, r10)     // Catch:{ all -> 0x02b7 }
            r13 = 3
            if (r0 < r13) goto L_0x0178
            r4.registerCallback03(r7, r2, r10)     // Catch:{ all -> 0x02b4 }
            goto L_0x017b
        L_0x0178:
            r4.registerCallback(r7)     // Catch:{ all -> 0x02b4 }
        L_0x017b:
            long r14 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x02b4 }
            java.lang.String r9 = "biz"
            java.lang.String r10 = "PgBindPay"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x02b4 }
            r13.<init>()     // Catch:{ all -> 0x02b4 }
            r16 = r8
            java.lang.String r8 = ""
            r13.append(r8)     // Catch:{ all -> 0x02b0 }
            r13.append(r14)     // Catch:{ all -> 0x02b0 }
            java.lang.String r8 = r13.toString()     // Catch:{ all -> 0x02b0 }
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r8)     // Catch:{ all -> 0x02b0 }
            r8 = 3
            if (r0 < r8) goto L_0x01a4
            java.lang.String r8 = "biz"
            java.lang.String r9 = "bind_pay"
            r10 = 0
            r4.r03(r8, r9, r10)     // Catch:{ all -> 0x02b0 }
        L_0x01a4:
            r8 = 2
            if (r0 < r8) goto L_0x01cb
            java.util.HashMap r0 = com.alipay.sdk.m.s.a.a((com.alipay.sdk.m.s.a) r20)     // Catch:{ all -> 0x01d4 }
            java.lang.String r8 = "ts_bind"
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x01d4 }
            r0.put(r8, r5)     // Catch:{ all -> 0x01d4 }
            java.lang.String r5 = "ts_bend"
            java.lang.String r6 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x01d4 }
            r0.put(r5, r6)     // Catch:{ all -> 0x01d4 }
            java.lang.String r5 = "ts_pay"
            java.lang.String r6 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x01d4 }
            r0.put(r5, r6)     // Catch:{ all -> 0x01d4 }
            java.lang.String r0 = r4.pay02(r2, r0)     // Catch:{ all -> 0x01d4 }
            goto L_0x01cf
        L_0x01cb:
            java.lang.String r0 = r4.Pay(r2)     // Catch:{ all -> 0x01d4 }
        L_0x01cf:
            r5 = r0
            r6 = r16
            goto L_0x025b
        L_0x01d4:
            r0 = move-exception
            com.alipay.sdk.m.s.a r5 = r1.f     // Catch:{ all -> 0x02b0 }
            if (r5 == 0) goto L_0x0254
            com.alipay.sdk.m.s.a r5 = r1.f     // Catch:{ all -> 0x02b0 }
            boolean r5 = r5.f()     // Catch:{ all -> 0x02b0 }
            if (r5 != 0) goto L_0x0254
            java.lang.String r5 = "biz"
            java.lang.String r6 = "ClientBindException"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r5, (java.lang.String) r6, (java.lang.Throwable) r0)     // Catch:{ all -> 0x02b0 }
            java.lang.String r0 = "alipaySdk"
            java.lang.String r5 = "bindServiceEx"
            android.app.Activity r6 = r1.a     // Catch:{ all -> 0x02b0 }
            com.alipay.sdk.m.s.a r8 = r1.f     // Catch:{ all -> 0x02b0 }
            com.alipay.sdk.m.u.n.a((java.lang.String) r0, (java.lang.String) r5, (android.content.Context) r6, (com.alipay.sdk.m.s.a) r8)     // Catch:{ all -> 0x02b0 }
            com.alipay.sdk.m.m.a r0 = com.alipay.sdk.m.m.a.z()     // Catch:{ all -> 0x02b0 }
            boolean r0 = r0.r()     // Catch:{ all -> 0x02b0 }
            if (r0 == 0) goto L_0x0254
            android.util.Pair r5 = new android.util.Pair     // Catch:{ all -> 0x02b0 }
            java.lang.String r0 = "failed"
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x02b0 }
            r5.<init>(r0, r6)     // Catch:{ all -> 0x02b0 }
            r4.unregisterCallback(r7)     // Catch:{ all -> 0x020a }
            goto L_0x020f
        L_0x020a:
            r0 = move-exception
            r4 = r0
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r4)
        L_0x020f:
            android.app.Activity r0 = r1.a     // Catch:{ all -> 0x021b }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x021b }
            r6 = r16
            r0.unbindService(r6)     // Catch:{ all -> 0x021b }
            goto L_0x021f
        L_0x021b:
            r0 = move-exception
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r0)
        L_0x021f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = ""
            r0.append(r4)
            long r6 = android.os.SystemClock.elapsedRealtime()
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "biz"
            java.lang.String r6 = "PgBindEnd"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r4, (java.lang.String) r6, (java.lang.String) r0)
            android.app.Activity r0 = r1.a
            java.lang.String r4 = r3.d
            com.alipay.sdk.m.k.a.a((android.content.Context) r0, (com.alipay.sdk.m.s.a) r3, (java.lang.String) r2, (java.lang.String) r4)
            r2 = 0
            r1.b = r2
            boolean r0 = r1.d
            if (r0 == 0) goto L_0x0253
            android.app.Activity r0 = r1.a
            if (r0 == 0) goto L_0x0253
            r2 = 0
            r0.setRequestedOrientation(r2)
            r1.d = r2
        L_0x0253:
            return r5
        L_0x0254:
            r6 = r16
            java.lang.String r0 = com.alipay.sdk.m.j.b.a()     // Catch:{ all -> 0x02ae }
            r5 = r0
        L_0x025b:
            r4.unregisterCallback(r7)     // Catch:{ all -> 0x025f }
            goto L_0x0264
        L_0x025f:
            r0 = move-exception
            r4 = r0
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r4)
        L_0x0264:
            android.app.Activity r0 = r1.a     // Catch:{ all -> 0x026e }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x026e }
            r0.unbindService(r6)     // Catch:{ all -> 0x026e }
            goto L_0x0272
        L_0x026e:
            r0 = move-exception
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r0)
        L_0x0272:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = ""
            r0.append(r4)
            long r6 = android.os.SystemClock.elapsedRealtime()
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "biz"
            java.lang.String r6 = "PgBindEnd"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r4, (java.lang.String) r6, (java.lang.String) r0)
            android.app.Activity r0 = r1.a
            java.lang.String r4 = r3.d
            com.alipay.sdk.m.k.a.a((android.content.Context) r0, (com.alipay.sdk.m.s.a) r3, (java.lang.String) r2, (java.lang.String) r4)
            r2 = 0
            r1.b = r2
            boolean r0 = r1.d
            if (r0 == 0) goto L_0x02a6
            android.app.Activity r0 = r1.a
            if (r0 == 0) goto L_0x02a6
            r2 = 0
            r0.setRequestedOrientation(r2)
            r1.d = r2
        L_0x02a6:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.<init>(r5, r2)
            return r0
        L_0x02ae:
            r0 = move-exception
            goto L_0x02ba
        L_0x02b0:
            r0 = move-exception
            r6 = r16
            goto L_0x02ba
        L_0x02b4:
            r0 = move-exception
            r6 = r8
            goto L_0x02ba
        L_0x02b7:
            r0 = move-exception
            r6 = r8
            r7 = 0
        L_0x02ba:
            java.lang.String r5 = "biz"
            java.lang.String r8 = "ClientBindFailed"
            java.lang.String r9 = "in_bind"
            com.alipay.sdk.m.k.a.a(r3, r5, r8, r0, r9)     // Catch:{ all -> 0x031a }
            android.util.Pair r5 = new android.util.Pair     // Catch:{ all -> 0x031a }
            java.lang.String r0 = "failed"
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x031a }
            r5.<init>(r0, r8)     // Catch:{ all -> 0x031a }
            if (r7 == 0) goto L_0x02d7
            r4.unregisterCallback(r7)     // Catch:{ all -> 0x02d2 }
            goto L_0x02d7
        L_0x02d2:
            r0 = move-exception
            r4 = r0
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r4)
        L_0x02d7:
            android.app.Activity r0 = r1.a     // Catch:{ all -> 0x02e1 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x02e1 }
            r0.unbindService(r6)     // Catch:{ all -> 0x02e1 }
            goto L_0x02e5
        L_0x02e1:
            r0 = move-exception
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r0)
        L_0x02e5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = ""
            r0.append(r4)
            long r6 = android.os.SystemClock.elapsedRealtime()
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "biz"
            java.lang.String r6 = "PgBindEnd"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r4, (java.lang.String) r6, (java.lang.String) r0)
            android.app.Activity r0 = r1.a
            java.lang.String r4 = r3.d
            com.alipay.sdk.m.k.a.a((android.content.Context) r0, (com.alipay.sdk.m.s.a) r3, (java.lang.String) r2, (java.lang.String) r4)
            r2 = 0
            r1.b = r2
            boolean r0 = r1.d
            if (r0 == 0) goto L_0x0319
            android.app.Activity r0 = r1.a
            if (r0 == 0) goto L_0x0319
            r2 = 0
            r0.setRequestedOrientation(r2)
            r1.d = r2
        L_0x0319:
            return r5
        L_0x031a:
            r0 = move-exception
            r5 = r0
            if (r7 == 0) goto L_0x0327
            r4.unregisterCallback(r7)     // Catch:{ all -> 0x0322 }
            goto L_0x0327
        L_0x0322:
            r0 = move-exception
            r4 = r0
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r4)
        L_0x0327:
            android.app.Activity r0 = r1.a     // Catch:{ all -> 0x0331 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0331 }
            r0.unbindService(r6)     // Catch:{ all -> 0x0331 }
            goto L_0x0335
        L_0x0331:
            r0 = move-exception
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r0)
        L_0x0335:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = ""
            r0.append(r4)
            long r6 = android.os.SystemClock.elapsedRealtime()
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "biz"
            java.lang.String r6 = "PgBindEnd"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r4, (java.lang.String) r6, (java.lang.String) r0)
            android.app.Activity r0 = r1.a
            java.lang.String r4 = r3.d
            com.alipay.sdk.m.k.a.a((android.content.Context) r0, (com.alipay.sdk.m.s.a) r3, (java.lang.String) r2, (java.lang.String) r4)
            r2 = 0
            r1.b = r2
            boolean r0 = r1.d
            if (r0 == 0) goto L_0x0369
            android.app.Activity r0 = r1.a
            if (r0 == 0) goto L_0x0369
            r2 = 0
            r0.setRequestedOrientation(r2)
            r1.d = r2
        L_0x0369:
            throw r5
        L_0x036a:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x036a }
            throw r0
        L_0x036d:
            java.lang.Throwable r0 = new java.lang.Throwable     // Catch:{ all -> 0x0375 }
            java.lang.String r2 = "bindService fail"
            r0.<init>(r2)     // Catch:{ all -> 0x0375 }
            throw r0     // Catch:{ all -> 0x0375 }
        L_0x0375:
            r0 = move-exception
            java.lang.String r2 = "biz"
            java.lang.String r4 = "ClientBindServiceFailed"
            com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) r3, (java.lang.String) r2, (java.lang.String) r4, (java.lang.Throwable) r0)
            android.app.Activity r0 = r1.a
            com.alipay.sdk.m.s.a r2 = r1.f
            java.lang.String r3 = "alipaySdk"
            java.lang.String r4 = "bindServiceFail"
            com.alipay.sdk.m.u.n.a((java.lang.String) r3, (java.lang.String) r4, (android.content.Context) r0, (com.alipay.sdk.m.s.a) r2)
            android.util.Pair r0 = new android.util.Pair
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            java.lang.String r3 = "failed"
            r0.<init>(r3, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.u.h.a(java.lang.String, java.lang.String, com.alipay.sdk.m.s.a):android.util.Pair");
    }

    private String a(String str, String str2) {
        JSONObject jSONObject;
        Object obj = new Object();
        String a2 = n.a(32);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.alipay.sdk.m.s.a aVar = this.f;
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSAStart", a2 + "|" + elapsedRealtime);
        a.C0016a.a(this.f, a2);
        a aVar2 = new a(obj);
        APayEntranceActivity.h.put(a2, aVar2);
        try {
            HashMap<String, String> a3 = com.alipay.sdk.m.s.a.a(this.f);
            a3.put("ts_intent", String.valueOf(elapsedRealtime));
            jSONObject = new JSONObject(a3);
        } catch (Throwable th2) {
            try {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSALocEx", th2);
                jSONObject = null;
            } catch (InterruptedException e2) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAWaiting", (Throwable) e2);
                return com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.c.PAY_WAITTING.b(), com.alipay.sdk.m.j.c.PAY_WAITTING.a(), "");
            } catch (Throwable th3) {
                com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAEx", th3);
                n.a("alipaySdk", com.alipay.sdk.m.l.b.q, (Context) this.a, this.f);
                return j;
            }
        }
        Intent intent = new Intent(this.a, APayEntranceActivity.class);
        intent.putExtra(APayEntranceActivity.d, str);
        intent.putExtra(APayEntranceActivity.e, str2);
        intent.putExtra(APayEntranceActivity.f, a2);
        if (jSONObject != null) {
            intent.putExtra(APayEntranceActivity.g, jSONObject.toString());
        }
        new Handler(Looper.getMainLooper()).postDelayed(new b(aVar2), (long) com.alipay.sdk.m.m.a.z().i());
        com.alipay.sdk.m.k.a.a((Context) this.a, this.f, str, this.f.d);
        if (com.alipay.sdk.m.m.a.z().w()) {
            new Handler(Looper.getMainLooper()).post(new c(intent, obj));
        } else if (this.a != null) {
            this.a.startActivity(intent);
        } else {
            com.alipay.sdk.m.k.a.b(this.f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.a0, "");
            Context a4 = this.f.a();
            if (a4 != null) {
                a4.startActivity(intent);
            }
        }
        synchronized (obj) {
            obj.wait();
        }
        String str3 = this.h;
        String str4 = "unknown";
        try {
            String str5 = l.a(this.f, str3).get("resultStatus");
            str4 = str5 == null ? StringUtil.NULL_STRING : str5;
        } catch (Throwable th4) {
            com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAStatEx", th4);
        }
        com.alipay.sdk.m.s.a aVar3 = this.f;
        com.alipay.sdk.m.k.a.a(aVar3, com.alipay.sdk.m.k.b.l, "BSADone-" + str4);
        if (!TextUtils.isEmpty(str3)) {
            return str3;
        }
        com.alipay.sdk.m.k.a.a(this.f, com.alipay.sdk.m.k.b.l, "BSAEmpty");
        return j;
    }

    public void a() {
        this.a = null;
        this.e = null;
    }

    public static boolean a(String str, Context context, com.alipay.sdk.m.s.a aVar) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSADetectFail");
            return false;
        } catch (Throwable th2) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSADetectFail", th2);
            return false;
        }
    }
}
