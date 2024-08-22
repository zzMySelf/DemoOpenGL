package com.baidu.sofire.ac;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.a.a;
import com.baidu.sofire.b.c;
import com.baidu.sofire.b.j;
import com.baidu.sofire.b.k;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.jni.Asc;
import com.baidu.sofire.l.e;
import com.baidu.sofire.l.l;
import com.baidu.sofire.l.r;
import com.baidu.sofire.l.s;
import com.baidu.sofire.l.w;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class F implements FI {
    public static F instance;
    public static Asc sAsc;

    public static synchronized F getInstance() {
        F f;
        synchronized (F.class) {
            if (instance == null) {
                instance = new F();
            }
            f = instance;
        }
        return f;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] ad(byte[] r4, byte[] r5) {
        /*
            r3 = this;
            r0 = 0
            if (r5 == 0) goto L_0x001f
            int r1 = r5.length     // Catch:{ all -> 0x0022 }
            if (r1 <= 0) goto L_0x001f
            if (r4 == 0) goto L_0x001f
            int r1 = r4.length     // Catch:{ all -> 0x0022 }
            if (r1 > 0) goto L_0x000c
            goto L_0x001f
        L_0x000c:
            r1 = 0
            r2 = 1
            byte[] r1 = com.baidu.sofire.l.g.a(r5, r4, r2)     // Catch:{ all -> 0x0013 }
            goto L_0x0015
        L_0x0013:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0022 }
        L_0x0015:
            if (r1 == 0) goto L_0x001c
            int r4 = r1.length     // Catch:{ all -> 0x0022 }
            if (r4 != 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            return r1
        L_0x001c:
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x0022 }
            return r4
        L_0x001f:
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x0022 }
            return r4
        L_0x0022:
            int r4 = com.baidu.sofire.a.a.a
            byte[] r4 = new byte[r0]
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.ad(byte[], byte[]):byte[]");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] ae(byte[] r4, byte[] r5) {
        /*
            r3 = this;
            r0 = 0
            if (r5 == 0) goto L_0x001f
            int r1 = r5.length     // Catch:{ all -> 0x0022 }
            if (r1 <= 0) goto L_0x001f
            if (r4 == 0) goto L_0x001f
            int r1 = r4.length     // Catch:{ all -> 0x0022 }
            if (r1 > 0) goto L_0x000c
            goto L_0x001f
        L_0x000c:
            r1 = 0
            r2 = 1
            byte[] r1 = com.baidu.sofire.l.g.b(r5, r4, r2)     // Catch:{ all -> 0x0013 }
            goto L_0x0015
        L_0x0013:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0022 }
        L_0x0015:
            if (r1 == 0) goto L_0x001c
            int r4 = r1.length     // Catch:{ all -> 0x0022 }
            if (r4 != 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            return r1
        L_0x001c:
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x0022 }
            return r4
        L_0x001f:
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x0022 }
            return r4
        L_0x0022:
            int r4 = com.baidu.sofire.a.a.a
            byte[] r4 = new byte[r0]
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.ae(byte[], byte[]):byte[]");
    }

    public boolean chh(Context context, String str) {
        return true;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cm(java.lang.String r5, java.lang.String r6, java.lang.String r7, com.baidu.sofire.ac.Callback r8, java.lang.Class<?>[] r9, java.lang.Object... r10) {
        /*
            r4 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0078 }
            r1 = 0
            if (r0 != 0) goto L_0x0070
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x0070
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0014
            goto L_0x0070
        L_0x0014:
            com.baidu.sofire.b.j r0 = com.baidu.sofire.b.j.g     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x0020
            if (r8 == 0) goto L_0x001f
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0078 }
            r8.onEnd(r5)     // Catch:{ all -> 0x0078 }
        L_0x001f:
            return
        L_0x0020:
            com.baidu.sofire.core.ApkInfo r6 = r0.b((java.lang.String) r6)     // Catch:{ all -> 0x0078 }
            com.baidu.sofire.core.ApkInfo r5 = r0.b((java.lang.String) r5)     // Catch:{ all -> 0x0078 }
            if (r5 == 0) goto L_0x0068
            if (r6 != 0) goto L_0x002d
            goto L_0x0068
        L_0x002d:
            java.lang.ClassLoader r5 = r6.classLoader     // Catch:{ all -> 0x005f }
            com.baidu.sofire.b.i r5 = (com.baidu.sofire.b.i) r5     // Catch:{ all -> 0x005f }
            java.lang.String r6 = r6.es     // Catch:{ all -> 0x005f }
            java.lang.String r6 = com.baidu.sofire.l.c.c((java.lang.String) r6)     // Catch:{ all -> 0x005f }
            java.lang.Class r5 = r5.a(r6)     // Catch:{ all -> 0x005f }
            java.lang.String r6 = "getInstance"
            r0 = 1
            java.lang.Class[] r2 = new java.lang.Class[r0]     // Catch:{ all -> 0x005f }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r1] = r3     // Catch:{ all -> 0x005f }
            java.lang.reflect.Method r6 = r5.getDeclaredMethod(r6, r2)     // Catch:{ all -> 0x005f }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x005f }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x005f }
            java.lang.Object r5 = r6.invoke(r5, r2)     // Catch:{ all -> 0x005f }
            java.lang.Object r5 = com.baidu.sofire.l.c.a((java.lang.Object) r5, (java.lang.String) r7, (java.lang.Class<?>[]) r9, (java.lang.Object[]) r10)     // Catch:{ all -> 0x005f }
            if (r8 == 0) goto L_0x007a
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ all -> 0x005f }
            r6[r1] = r5     // Catch:{ all -> 0x005f }
            r8.onEnd(r6)     // Catch:{ all -> 0x005f }
            goto L_0x007a
        L_0x005f:
            if (r8 == 0) goto L_0x007a
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0078 }
            r8.onEnd(r5)     // Catch:{ all -> 0x0078 }
            goto L_0x007a
        L_0x0068:
            if (r8 == 0) goto L_0x006f
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0078 }
            r8.onEnd(r5)     // Catch:{ all -> 0x0078 }
        L_0x006f:
            return
        L_0x0070:
            if (r8 == 0) goto L_0x0077
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0078 }
            r8.onEnd(r5)     // Catch:{ all -> 0x0078 }
        L_0x0077:
            return
        L_0x0078:
            int r5 = com.baidu.sofire.a.a.a
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.cm(java.lang.String, java.lang.String, java.lang.String, com.baidu.sofire.ac.Callback, java.lang.Class[], java.lang.Object[]):void");
    }

    public Pair<Integer, Object> cmsi(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            c cVar = c.d;
            if (cVar == null) {
                return new Pair<>(4, (Object) null);
            }
            return cVar.a(i2, str, clsArr, objArr);
        } catch (Throwable unused) {
            int i3 = a.a;
            return new Pair<>(3, (Object) null);
        }
    }

    public boolean cp(Context context) {
        if (context == null) {
            return false;
        }
        return s.a(context);
    }

    public int fg() {
        return r.a() ? 2 : 1;
    }

    public Context gct() {
        if (c.d == null) {
            return null;
        }
        return c.e;
    }

    public SharedPreferences getCustomMutiProcessSharedPreferences(Context context, String str) {
        if (context == null) {
            return null;
        }
        return com.baidu.sofire.j.a.a(context).b(str);
    }

    public Pair<Boolean, DeviceInfoCallback> getDeviceInfoCallback() {
        return new Pair<>(Boolean.FALSE, r.a);
    }

    public SharedPreferences getPlatformPrivateSharedPreferences(Context context) {
        if (context == null) {
            return null;
        }
        return com.baidu.sofire.j.a.a(context).a;
    }

    public SharedPreferences getPlatformSharedSharedPreferences(Context context) {
        if (context == null) {
            return null;
        }
        return com.baidu.sofire.j.a.a(context).c;
    }

    public Map<Long, Throwable> gg() {
        boolean z = l.a;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(l.c);
        l.c.clear();
        return concurrentHashMap;
    }

    public Map<Long, Throwable> gi() {
        boolean z = l.a;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(l.b);
        l.b.clear();
        return concurrentHashMap;
    }

    public String gm(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "-1";
            }
            if (TextUtils.isEmpty(str2)) {
                return "-1";
            }
            j jVar = j.g;
            if (jVar == null) {
                return StatHelper.SENSOR_ERR_2;
            }
            ApkInfo b = jVar.b(str);
            if (b == null) {
                return "-3";
            }
            if (!str2.equals(b.versionName)) {
                return "-4";
            }
            String str3 = b.apkMD5;
            if (com.baidu.sofire.b.a.w == null) {
                return str3;
            }
            String str4 = com.baidu.sofire.b.a.w.get(b.key + b.versionName);
            return !TextUtils.isEmpty(str4) ? str4 : str3;
        } catch (Throwable unused) {
            int i2 = a.a;
            return "-5";
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public java.lang.String goh(android.content.Context r7) {
        /*
            r6 = this;
            com.baidu.sofire.b.j r0 = com.baidu.sofire.b.j.a((android.content.Context) r7)
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0062
            java.lang.Class<com.baidu.sofire.l.p> r0 = com.baidu.sofire.l.p.class
            monitor-enter(r0)
            java.lang.Object r1 = com.baidu.sofire.l.p.a     // Catch:{ all -> 0x005f }
            r1 = 1
            r2 = 0
            java.lang.Class<fe.fe.pf.ad> r3 = fe.fe.pf.ad.class
            java.lang.Class<com.baidu.helios.OnGetIdResultCallback> r4 = com.baidu.helios.OnGetIdResultCallback.class
            r3.toString()     // Catch:{ all -> 0x001d }
            r4.toString()     // Catch:{ all -> 0x001d }
            r3 = 1
            goto L_0x0020
        L_0x001d:
            int r3 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x005f }
            r3 = 0
        L_0x0020:
            if (r3 != 0) goto L_0x0026
            java.lang.String r7 = ""
            monitor-exit(r0)
            goto L_0x005e
        L_0x0026:
            java.lang.String r3 = ""
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ all -> 0x0059 }
            boolean[] r1 = new boolean[r1]     // Catch:{ all -> 0x0059 }
            r1[r2] = r2     // Catch:{ all -> 0x0059 }
            fe.fe.pf.ad r7 = fe.fe.pf.ad.th(r7)     // Catch:{ all -> 0x0059 }
            com.baidu.sofire.l.n r4 = new com.baidu.sofire.l.n     // Catch:{ all -> 0x0059 }
            r4.<init>(r3, r1)     // Catch:{ all -> 0x0059 }
            com.baidu.sofire.xclient.privacycontrol.lib.OaidHelper.requestOid(r7, r4)     // Catch:{ all -> 0x0059 }
            boolean r7 = r1[r2]     // Catch:{ all -> 0x0059 }
            if (r7 != 0) goto L_0x0055
            java.lang.Object r7 = com.baidu.sofire.l.p.a     // Catch:{ InterruptedException -> 0x0053 }
            monitor-enter(r7)     // Catch:{ InterruptedException -> 0x0053 }
            java.lang.Object r1 = com.baidu.sofire.l.p.a     // Catch:{ all -> 0x0050 }
            java.lang.Long r4 = com.baidu.sofire.l.p.c     // Catch:{ all -> 0x0050 }
            long r4 = r4.longValue()     // Catch:{ all -> 0x0050 }
            r1.wait(r4)     // Catch:{ all -> 0x0050 }
            monitor-exit(r7)     // Catch:{ all -> 0x0050 }
            goto L_0x0055
        L_0x0050:
            r1 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0050 }
            throw r1     // Catch:{ InterruptedException -> 0x0053 }
        L_0x0053:
            int r7 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0059 }
        L_0x0055:
            r7 = r3[r2]     // Catch:{ all -> 0x0059 }
            monitor-exit(r0)
            goto L_0x005e
        L_0x0059:
            int r7 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x005f }
            java.lang.String r7 = ""
            monitor-exit(r0)
        L_0x005e:
            return r7
        L_0x005f:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        L_0x0062:
            java.lang.String r7 = ""
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.goh(android.content.Context):java.lang.String");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public java.lang.String gom(android.content.Context r7) {
        /*
            r6 = this;
            com.baidu.sofire.b.j r0 = com.baidu.sofire.b.j.a((android.content.Context) r7)
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0066
            java.lang.Class<com.baidu.sofire.l.p> r0 = com.baidu.sofire.l.p.class
            monitor-enter(r0)
            java.lang.Object r1 = com.baidu.sofire.l.p.a     // Catch:{ all -> 0x0063 }
            r1 = 1
            r2 = 0
            java.lang.Class<com.bun.miitmdid.core.MdidSdkHelper> r3 = com.bun.miitmdid.core.MdidSdkHelper.class
            java.lang.Class<com.bun.miitmdid.interfaces.IIdentifierListener> r4 = com.bun.miitmdid.interfaces.IIdentifierListener.class
            r3.toString()     // Catch:{ all -> 0x001d }
            r4.toString()     // Catch:{ all -> 0x001d }
            r3 = 1
            goto L_0x0020
        L_0x001d:
            int r3 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0063 }
            r3 = 0
        L_0x0020:
            if (r3 != 0) goto L_0x0026
            java.lang.String r7 = ""
            monitor-exit(r0)
            goto L_0x0062
        L_0x0026:
            java.lang.String r3 = ""
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ all -> 0x005d }
            boolean[] r4 = new boolean[r1]     // Catch:{ all -> 0x005d }
            r4[r2] = r2     // Catch:{ all -> 0x005d }
            com.baidu.sofire.l.o r5 = new com.baidu.sofire.l.o     // Catch:{ all -> 0x005d }
            r5.<init>(r3, r4)     // Catch:{ all -> 0x005d }
            int r7 = com.bun.miitmdid.core.MdidSdkHelper.InitSdk(r7, r2, r5)     // Catch:{ all -> 0x005d }
            r5 = 1008610(0xf63e2, float:1.413364E-39)
            if (r7 == r5) goto L_0x0040
            r4[r2] = r1     // Catch:{ all -> 0x005d }
        L_0x0040:
            boolean r7 = r4[r2]     // Catch:{ all -> 0x005d }
            if (r7 != 0) goto L_0x0059
            java.lang.Object r7 = com.baidu.sofire.l.p.b     // Catch:{ InterruptedException -> 0x0057 }
            monitor-enter(r7)     // Catch:{ InterruptedException -> 0x0057 }
            java.lang.Object r1 = com.baidu.sofire.l.p.b     // Catch:{ all -> 0x0054 }
            java.lang.Long r4 = com.baidu.sofire.l.p.c     // Catch:{ all -> 0x0054 }
            long r4 = r4.longValue()     // Catch:{ all -> 0x0054 }
            r1.wait(r4)     // Catch:{ all -> 0x0054 }
            monitor-exit(r7)     // Catch:{ all -> 0x0054 }
            goto L_0x0059
        L_0x0054:
            r1 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0054 }
            throw r1     // Catch:{ InterruptedException -> 0x0057 }
        L_0x0057:
            int r7 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x005d }
        L_0x0059:
            r7 = r3[r2]     // Catch:{ all -> 0x005d }
            monitor-exit(r0)
            goto L_0x0062
        L_0x005d:
            int r7 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = ""
            monitor-exit(r0)
        L_0x0062:
            return r7
        L_0x0063:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        L_0x0066:
            java.lang.String r7 = ""
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.gom(android.content.Context):java.lang.String");
    }

    public Map<Integer, String> gpd() {
        try {
            com.baidu.sofire.c.a aVar = com.baidu.sofire.c.a.d;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        } catch (Throwable unused) {
            int i2 = a.a;
            return null;
        }
    }

    public String gs(String str) {
        ApkInfo b;
        try {
            j jVar = j.g;
            if (jVar == null || (b = jVar.b(str)) == null) {
                return "";
            }
            return b.libPath;
        } catch (Throwable unused) {
            int i2 = a.a;
            return "";
        }
    }

    public String gta(Context context) {
        return "";
    }

    public String gzd(Context context) {
        return context == null ? "" : e.a(context);
    }

    public String p(String str) {
        try {
            ApkInfo apkInfo = j.g.d.get(str);
            if (apkInfo == null) {
                return null;
            }
            return apkInfo.pkgPath;
        } catch (Throwable unused) {
            int i2 = a.a;
            return "";
        }
    }

    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && intentFilter != null && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str3)) {
                    j jVar = j.g;
                    if (jVar != null) {
                        jVar.a(new k(str, intentFilter, str2, str3));
                    }
                }
            }
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:25|26) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0021, code lost:
        if (r4.length > 0) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0028 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0031 A[Catch:{ all -> 0x003c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] rd(byte[] r4, byte[] r5) {
        /*
            r3 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0039
            int r1 = r5.length     // Catch:{ all -> 0x003c }
            if (r1 <= 0) goto L_0x0039
            if (r4 == 0) goto L_0x0039
            int r1 = r4.length     // Catch:{ all -> 0x003c }
            if (r1 > 0) goto L_0x000c
            goto L_0x0039
        L_0x000c:
            r1 = 0
            com.baidu.sofire.jni.Asc r2 = com.baidu.sofire.l.g.a     // Catch:{ all -> 0x002d }
            int r2 = r5.length     // Catch:{ all -> 0x0028 }
            if (r2 <= 0) goto L_0x0025
            int r2 = r4.length     // Catch:{ all -> 0x0028 }
            if (r2 > 0) goto L_0x0016
            goto L_0x0025
        L_0x0016:
            com.baidu.sofire.jni.Asc r2 = com.baidu.sofire.l.g.a     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x002a
            byte[] r4 = r2.dr(r4, r5)     // Catch:{ all -> 0x0028 }
            if (r4 == 0) goto L_0x002a
            int r5 = r4.length     // Catch:{ all -> 0x0028 }
            if (r5 <= 0) goto L_0x002a
        L_0x0023:
            r1 = r4
            goto L_0x002f
        L_0x0025:
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x0028 }
            goto L_0x0023
        L_0x0028:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x002d }
        L_0x002a:
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x002d }
            goto L_0x0023
        L_0x002d:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x003c }
        L_0x002f:
            if (r1 == 0) goto L_0x0036
            int r4 = r1.length     // Catch:{ all -> 0x003c }
            if (r4 != 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            return r1
        L_0x0036:
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x003c }
            return r4
        L_0x0039:
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x003c }
            return r4
        L_0x003c:
            int r4 = com.baidu.sofire.a.a.a
            byte[] r4 = new byte[r0]
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.rd(byte[], byte[]):byte[]");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:25|26) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0021, code lost:
        if (r4.length > 0) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0028 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0031 A[Catch:{ all -> 0x003c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] re(byte[] r4, byte[] r5) {
        /*
            r3 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0039
            int r1 = r5.length     // Catch:{ all -> 0x003c }
            if (r1 <= 0) goto L_0x0039
            if (r4 == 0) goto L_0x0039
            int r1 = r4.length     // Catch:{ all -> 0x003c }
            if (r1 > 0) goto L_0x000c
            goto L_0x0039
        L_0x000c:
            r1 = 0
            com.baidu.sofire.jni.Asc r2 = com.baidu.sofire.l.g.a     // Catch:{ all -> 0x002d }
            int r2 = r5.length     // Catch:{ all -> 0x0028 }
            if (r2 <= 0) goto L_0x0025
            int r2 = r4.length     // Catch:{ all -> 0x0028 }
            if (r2 > 0) goto L_0x0016
            goto L_0x0025
        L_0x0016:
            com.baidu.sofire.jni.Asc r2 = com.baidu.sofire.l.g.a     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x002a
            byte[] r4 = r2.ar(r4, r5)     // Catch:{ all -> 0x0028 }
            if (r4 == 0) goto L_0x002a
            int r5 = r4.length     // Catch:{ all -> 0x0028 }
            if (r5 <= 0) goto L_0x002a
        L_0x0023:
            r1 = r4
            goto L_0x002f
        L_0x0025:
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x0028 }
            goto L_0x0023
        L_0x0028:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x002d }
        L_0x002a:
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x002d }
            goto L_0x0023
        L_0x002d:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x003c }
        L_0x002f:
            if (r1 == 0) goto L_0x0036
            int r4 = r1.length     // Catch:{ all -> 0x003c }
            if (r4 != 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            return r1
        L_0x0036:
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x003c }
            return r4
        L_0x0039:
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x003c }
            return r4
        L_0x003c:
            int r4 = com.baidu.sofire.a.a.a
            byte[] r4 = new byte[r0]
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.re(byte[], byte[]):byte[]");
    }

    public void rf(Context context) {
        if (context != null) {
            try {
                w.a(context).b(new U(context.getApplicationContext(), 5, true));
            } catch (Throwable unused) {
                int i2 = a.a;
            }
        }
    }

    public void s(int i2, boolean z) {
        try {
            com.baidu.sofire.c.a aVar = com.baidu.sofire.c.a.d;
            if (aVar != null) {
                aVar.a(i2, z ? 1 : 0);
            }
        } catch (Throwable unused) {
            int i3 = a.a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sp(java.lang.String r6, boolean r7) {
        /*
            r5 = this;
            com.baidu.sofire.c.a r0 = com.baidu.sofire.c.a.d     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0027
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ all -> 0x0025 }
            r1.<init>()     // Catch:{ all -> 0x0025 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = "s"
            r1.put(r2, r7)     // Catch:{ all -> 0x0025 }
            android.database.sqlite.SQLiteDatabase r7 = r0.b     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = "pgn"
            java.lang.String r2 = "p=? and n=1"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ all -> 0x0022 }
            r4 = 0
            r3[r4] = r6     // Catch:{ all -> 0x0022 }
            r7.update(r0, r1, r2, r3)     // Catch:{ all -> 0x0022 }
            goto L_0x0027
        L_0x0022:
            int r6 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0025 }
            goto L_0x0027
        L_0x0025:
            int r6 = com.baidu.sofire.a.a.a
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.sp(java.lang.String, boolean):void");
    }

    public void sse(Context context, String str, Map<String, Object> map, boolean z) {
        com.baidu.sofire.l.c.a(context, str, map, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007a A[SYNTHETIC, Splitter:B:19:0x007a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sser(android.content.Context r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 == 0) goto L_0x000a
            goto L_0x009f
        L_0x000a:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x009d }
            r1.<init>()     // Catch:{ all -> 0x009d }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x009d }
            r2.<init>()     // Catch:{ all -> 0x009d }
            java.lang.String r3 = "0"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009d }
            r2.put(r3, r4)     // Catch:{ all -> 0x009d }
            java.lang.String r3 = "1"
            r2.put(r3, r0)     // Catch:{ all -> 0x009d }
            java.lang.String r3 = "2"
            r2.put(r3, r0)     // Catch:{ all -> 0x009d }
            java.lang.String[] r0 = com.baidu.sofire.l.c.p(r9)     // Catch:{ all -> 0x009d }
            int r3 = r0.length     // Catch:{ all -> 0x009d }
            r4 = 2
            r5 = 1
            java.lang.String r6 = "3"
            r7 = 0
            if (r3 != r4) goto L_0x0046
            r3 = r0[r7]     // Catch:{ all -> 0x009d }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x009d }
            if (r3 != 0) goto L_0x0046
            r3 = r0[r5]     // Catch:{ all -> 0x009d }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x009d }
            if (r3 != 0) goto L_0x0046
            r0 = r0[r7]     // Catch:{ all -> 0x009d }
            goto L_0x0047
        L_0x0046:
            r0 = r6
        L_0x0047:
            r2.put(r6, r0)     // Catch:{ all -> 0x009d }
            java.lang.String r0 = "4"
            r2.put(r0, r7)     // Catch:{ all -> 0x009d }
            java.lang.String r0 = "5"
            r2.put(r0, r7)     // Catch:{ all -> 0x009d }
            java.lang.String r0 = "6"
            r2.put(r0, r5)     // Catch:{ all -> 0x009d }
            java.lang.String r0 = "7"
            r2.put(r0, r7)     // Catch:{ all -> 0x009d }
            java.lang.String r0 = "8"
            java.lang.String r3 = "sofire"
            r2.put(r0, r3)     // Catch:{ all -> 0x009d }
            java.lang.String r0 = "9"
            java.lang.String r3 = "3.6.7.0"
            r2.put(r0, r3)     // Catch:{ all -> 0x009d }
            java.lang.String r0 = "10"
            r2.put(r0, r10)     // Catch:{ all -> 0x009d }
            java.lang.String r10 = "Common_section"
            r1.put(r10, r2)     // Catch:{ all -> 0x009d }
            java.lang.String r10 = "Module_section"
            if (r11 == 0) goto L_0x0089
            int r0 = r11.size()     // Catch:{ all -> 0x009d }
            if (r0 <= 0) goto L_0x0089
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x009d }
            r0.<init>(r11)     // Catch:{ all -> 0x009d }
            r1.put(r10, r0)     // Catch:{ all -> 0x009d }
            goto L_0x0091
        L_0x0089:
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ all -> 0x009d }
            r11.<init>()     // Catch:{ all -> 0x009d }
            r1.put(r10, r11)     // Catch:{ all -> 0x009d }
        L_0x0091:
            com.baidu.sofire.rp.Report r9 = com.baidu.sofire.rp.Report.getInstance(r9)     // Catch:{ all -> 0x009d }
            java.lang.String r10 = r1.toString()     // Catch:{ all -> 0x009d }
            r9.sr(r10)     // Catch:{ all -> 0x009d }
            goto L_0x009f
        L_0x009d:
            int r9 = com.baidu.sofire.a.a.a
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.F.sser(android.content.Context, java.lang.String, java.util.Map):void");
    }

    public void u(String str) {
        try {
            c.d.b(str);
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str3)) {
                    j jVar = j.g;
                    if (jVar != null) {
                        jVar.b(new k(str, intentFilter, str2, str3));
                    }
                }
            }
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }
}
