package com.baidu.sofire.b;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.a.a;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.d.b;
import com.baidu.sofire.l.c;
import com.baidu.sofire.l.k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;

public class j {
    public static j g;
    public static Application h;

    /* renamed from: i  reason: collision with root package name */
    public static List<Integer> f1087i = new ArrayList();
    public static List<Integer> j = new ArrayList();
    public String a;
    public boolean b;
    public Map<String, ApkInfo> c = new ConcurrentHashMap();
    public Map<String, ApkInfo> d = new ConcurrentHashMap();
    public Map<Integer, ApkInfo> e = new ConcurrentHashMap();
    public Map<String, MyReceiver> f = new HashMap();

    public static synchronized j a(Context context) {
        j jVar;
        synchronized (j.class) {
            if (g == null) {
                h = (Application) context.getApplicationContext();
                g = new j();
            }
            jVar = g;
        }
        return jVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:23|24|25|26|70) */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0041, code lost:
        continue;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0059 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x00cf */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(com.baidu.sofire.b.k r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.content.IntentFilter r0 = r5.d     // Catch:{ all -> 0x00cf }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r0 = r4.d     // Catch:{ all -> 0x00cf }
            java.lang.String r1 = r5.a     // Catch:{ all -> 0x00cf }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00cf }
            com.baidu.sofire.core.ApkInfo r0 = (com.baidu.sofire.core.ApkInfo) r0     // Catch:{ all -> 0x00cf }
            if (r0 == 0) goto L_0x0069
            java.util.List<com.baidu.sofire.b.k> r1 = r0.intentFilters     // Catch:{ all -> 0x00cf }
            if (r1 == 0) goto L_0x0069
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00cf }
            r1.<init>()     // Catch:{ all -> 0x00cf }
            r2 = 0
        L_0x001d:
            java.util.List<com.baidu.sofire.b.k> r3 = r0.intentFilters     // Catch:{ all -> 0x00cf }
            int r3 = r3.size()     // Catch:{ all -> 0x00cf }
            if (r2 >= r3) goto L_0x003d
            java.util.List<com.baidu.sofire.b.k> r3 = r0.intentFilters     // Catch:{ all -> 0x00cf }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x00cf }
            com.baidu.sofire.b.k r3 = (com.baidu.sofire.b.k) r3     // Catch:{ all -> 0x00cf }
            boolean r3 = r5.a(r3)     // Catch:{ all -> 0x00cf }
            if (r3 == 0) goto L_0x003a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00cf }
            r1.add(r3)     // Catch:{ all -> 0x00cf }
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x001d
        L_0x003d:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00cf }
        L_0x0041:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00cf }
            if (r2 == 0) goto L_0x005c
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00cf }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x00cf }
            int r2 = r2.intValue()     // Catch:{ all -> 0x00cf }
            java.util.List<com.baidu.sofire.b.k> r3 = r0.intentFilters     // Catch:{ all -> 0x00cf }
            if (r3 == 0) goto L_0x0041
            r3.remove(r2)     // Catch:{ all -> 0x0059 }
            goto L_0x0041
        L_0x0059:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x00cf }
            goto L_0x0041
        L_0x005c:
            java.util.List<com.baidu.sofire.b.k> r1 = r0.intentFilters     // Catch:{ all -> 0x00cf }
            if (r1 == 0) goto L_0x0069
            int r1 = r1.size()     // Catch:{ all -> 0x00cf }
            if (r1 != 0) goto L_0x0069
            r1 = 0
            r0.intentFilters = r1     // Catch:{ all -> 0x00cf }
        L_0x0069:
            android.content.IntentFilter r5 = r5.d     // Catch:{ all -> 0x00cf }
            java.lang.String r5 = a((android.content.IntentFilter) r5)     // Catch:{ all -> 0x00cf }
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00cf }
            if (r0 == 0) goto L_0x0077
            monitor-exit(r4)
            return
        L_0x0077:
            java.util.List r0 = r4.b()     // Catch:{ all -> 0x00cf }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00cf }
        L_0x007f:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00cf }
            if (r1 == 0) goto L_0x00bc
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00cf }
            com.baidu.sofire.core.ApkInfo r1 = (com.baidu.sofire.core.ApkInfo) r1     // Catch:{ all -> 0x00cf }
            java.util.List<com.baidu.sofire.b.k> r2 = r1.intentFilters     // Catch:{ all -> 0x00cf }
            if (r2 == 0) goto L_0x007f
            int r2 = r2.size()     // Catch:{ all -> 0x00cf }
            if (r2 <= 0) goto L_0x007f
            java.util.List<com.baidu.sofire.b.k> r1 = r1.intentFilters     // Catch:{ all -> 0x00cf }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00cf }
        L_0x009b:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00cf }
            if (r2 == 0) goto L_0x007f
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00cf }
            com.baidu.sofire.b.k r2 = (com.baidu.sofire.b.k) r2     // Catch:{ all -> 0x00cf }
            android.content.IntentFilter r2 = r2.d     // Catch:{ all -> 0x00cf }
            java.lang.String r2 = a((android.content.IntentFilter) r2)     // Catch:{ all -> 0x00cf }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00cf }
            if (r3 == 0) goto L_0x00b4
            goto L_0x009b
        L_0x00b4:
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x00cf }
            if (r2 == 0) goto L_0x009b
            monitor-exit(r4)
            return
        L_0x00bc:
            java.util.Map<java.lang.String, com.baidu.sofire.MyReceiver> r0 = r4.f     // Catch:{ all -> 0x00cf }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x00cf }
            com.baidu.sofire.MyReceiver r0 = (com.baidu.sofire.MyReceiver) r0     // Catch:{ all -> 0x00cf }
            android.app.Application r1 = h     // Catch:{ all -> 0x00cf }
            r1.unregisterReceiver(r0)     // Catch:{ all -> 0x00cf }
            java.util.Map<java.lang.String, com.baidu.sofire.MyReceiver> r0 = r4.f     // Catch:{ all -> 0x00cf }
            r0.remove(r5)     // Catch:{ all -> 0x00cf }
            goto L_0x00d1
        L_0x00cf:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x00d3 }
        L_0x00d1:
            monitor-exit(r4)
            return
        L_0x00d3:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.b(com.baidu.sofire.b.k):void");
    }

    public boolean c(String str) {
        ApkInfo apkInfo = this.c.get(str);
        if (apkInfo == null) {
            return false;
        }
        this.c.remove(str);
        this.d.remove(apkInfo.packageName);
        this.e.remove(Integer.valueOf(apkInfo.key));
        b.a(apkInfo.packageName);
        c.e(apkInfo.dataDir);
        Application application = h;
        if (application == null) {
            return true;
        }
        c.e(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
        return true;
    }

    public boolean d(String str) {
        ApkInfo apkInfo = this.d.get(str);
        if (apkInfo == null) {
            return false;
        }
        this.c.remove(apkInfo.pkgPath);
        this.d.remove(str);
        this.e.remove(Integer.valueOf(apkInfo.key));
        b.a(str);
        c.e(apkInfo.dataDir);
        Application application = h;
        if (application == null) {
            return true;
        }
        c.e(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
        return true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:11|12|13|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r1 = r7.d     // Catch:{ all -> 0x0056 }
            java.lang.Object r1 = r1.get(r8)     // Catch:{ all -> 0x0056 }
            com.baidu.sofire.core.ApkInfo r1 = (com.baidu.sofire.core.ApkInfo) r1     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0055
            r2 = 1
            java.lang.ClassLoader r3 = r1.classLoader     // Catch:{ all -> 0x003b }
            com.baidu.sofire.b.i r3 = (com.baidu.sofire.b.i) r3     // Catch:{ all -> 0x003b }
            java.lang.String r4 = r1.es     // Catch:{ all -> 0x003b }
            java.lang.String r4 = com.baidu.sofire.l.c.c((java.lang.String) r4)     // Catch:{ all -> 0x003b }
            java.lang.Class r3 = r3.a(r4)     // Catch:{ all -> 0x003b }
            java.lang.String r4 = "getInstance"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ all -> 0x003b }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r5[r0] = r6     // Catch:{ all -> 0x003b }
            java.lang.reflect.Method r4 = r3.getDeclaredMethod(r4, r5)     // Catch:{ all -> 0x003b }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x003b }
            android.app.Application r6 = h     // Catch:{ all -> 0x003b }
            r5[r0] = r6     // Catch:{ all -> 0x003b }
            java.lang.Object r3 = r4.invoke(r3, r5)     // Catch:{ all -> 0x003b }
            if (r3 == 0) goto L_0x003d
            java.lang.String r4 = "unload"
            r5 = 0
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ all -> 0x003b }
            com.baidu.sofire.l.c.a((java.lang.Object) r3, (java.lang.String) r4, (java.lang.Class<?>[]) r5, (java.lang.Object[]) r6)     // Catch:{ all -> 0x003b }
            goto L_0x003d
        L_0x003b:
            int r3 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0056 }
        L_0x003d:
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r3 = r7.c     // Catch:{ all -> 0x0056 }
            java.lang.String r4 = r1.pkgPath     // Catch:{ all -> 0x0056 }
            r3.remove(r4)     // Catch:{ all -> 0x0056 }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r3 = r7.d     // Catch:{ all -> 0x0056 }
            r3.remove(r8)     // Catch:{ all -> 0x0056 }
            java.util.Map<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r8 = r7.e     // Catch:{ all -> 0x0056 }
            int r1 = r1.key     // Catch:{ all -> 0x0056 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0056 }
            r8.remove(r1)     // Catch:{ all -> 0x0056 }
            return r2
        L_0x0055:
            return r0
        L_0x0056:
            int r8 = com.baidu.sofire.a.a.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.e(java.lang.String):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:31|32|33|34|35|36) */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0087, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r5 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0077 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0088 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.baidu.sofire.b.k r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.content.IntentFilter r0 = r5.d     // Catch:{ all -> 0x0088 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r0 = r4.d     // Catch:{ all -> 0x0088 }
            java.lang.String r1 = r5.a     // Catch:{ all -> 0x0088 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0088 }
            com.baidu.sofire.core.ApkInfo r0 = (com.baidu.sofire.core.ApkInfo) r0     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x008a
            java.util.List<com.baidu.sofire.b.k> r1 = r0.intentFilters     // Catch:{ all -> 0x0088 }
            if (r1 != 0) goto L_0x001e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0088 }
            r1.<init>()     // Catch:{ all -> 0x0088 }
            r0.intentFilters = r1     // Catch:{ all -> 0x0088 }
        L_0x001e:
            r1 = 0
        L_0x001f:
            java.util.List<com.baidu.sofire.b.k> r2 = r0.intentFilters     // Catch:{ all -> 0x0088 }
            int r2 = r2.size()     // Catch:{ all -> 0x0088 }
            if (r1 >= r2) goto L_0x003a
            java.util.List<com.baidu.sofire.b.k> r2 = r0.intentFilters     // Catch:{ all -> 0x0088 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0088 }
            com.baidu.sofire.b.k r2 = (com.baidu.sofire.b.k) r2     // Catch:{ all -> 0x0088 }
            boolean r2 = r5.a(r2)     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x0037
            monitor-exit(r4)
            return
        L_0x0037:
            int r1 = r1 + 1
            goto L_0x001f
        L_0x003a:
            java.util.List<com.baidu.sofire.b.k> r0 = r0.intentFilters     // Catch:{ all -> 0x0088 }
            r0.add(r5)     // Catch:{ all -> 0x0088 }
            android.content.IntentFilter r0 = r5.d     // Catch:{ all -> 0x0088 }
            java.lang.String r0 = a((android.content.IntentFilter) r0)     // Catch:{ all -> 0x0088 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0088 }
            if (r1 != 0) goto L_0x0086
            java.lang.String r1 = "____"
            boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x0054
            goto L_0x0086
        L_0x0054:
            java.util.Map<java.lang.String, com.baidu.sofire.MyReceiver> r1 = r4.f     // Catch:{ all -> 0x0088 }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x0088 }
            boolean r1 = r1.contains(r0)     // Catch:{ all -> 0x0088 }
            if (r1 != 0) goto L_0x008a
            com.baidu.sofire.MyReceiver r1 = new com.baidu.sofire.MyReceiver     // Catch:{ all -> 0x0088 }
            r1.<init>()     // Catch:{ all -> 0x0088 }
            android.app.Application r2 = h     // Catch:{ all -> 0x0088 }
            android.content.IntentFilter r3 = r5.d     // Catch:{ all -> 0x0088 }
            boolean r2 = com.baidu.sofire.l.c.a((android.content.Context) r2, (android.content.BroadcastReceiver) r1, (android.content.IntentFilter) r3)     // Catch:{ all -> 0x0088 }
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x0080
            r2 = 3000(0xbb8, double:1.482E-320)
            java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x0077 }
            goto L_0x0079
        L_0x0077:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0088 }
        L_0x0079:
            android.app.Application r2 = h     // Catch:{ all -> 0x0088 }
            android.content.IntentFilter r5 = r5.d     // Catch:{ all -> 0x0088 }
            com.baidu.sofire.l.c.a((android.content.Context) r2, (android.content.BroadcastReceiver) r1, (android.content.IntentFilter) r5)     // Catch:{ all -> 0x0088 }
        L_0x0080:
            java.util.Map<java.lang.String, com.baidu.sofire.MyReceiver> r5 = r4.f     // Catch:{ all -> 0x0088 }
            r5.put(r0, r1)     // Catch:{ all -> 0x0088 }
            goto L_0x008a
        L_0x0086:
            monitor-exit(r4)
            return
        L_0x0088:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x008c }
        L_0x008a:
            monitor-exit(r4)
            return
        L_0x008c:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.a(com.baidu.sofire.b.k):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:15|16|90) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r7 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r7 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r7 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r6 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0029 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x006e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00b3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x00f7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.IntentFilter r9) {
        /*
            java.lang.String r0 = ""
            if (r9 != 0) goto L_0x0005
            return r0
        L_0x0005:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0125 }
            r1.<init>()     // Catch:{ all -> 0x0125 }
            int r2 = r9.countActions()     // Catch:{ all -> 0x0125 }
            r3 = 0
            java.lang.String r4 = "_"
            if (r2 <= 0) goto L_0x004f
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0125 }
            r5.<init>()     // Catch:{ all -> 0x0125 }
            r6 = 0
        L_0x0019:
            if (r6 >= r2) goto L_0x002e
            java.lang.String r7 = r9.getAction(r6)     // Catch:{ all -> 0x0029 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0029 }
            if (r8 != 0) goto L_0x002b
            r5.add(r7)     // Catch:{ all -> 0x0029 }
            goto L_0x002b
        L_0x0029:
            int r7 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0125 }
        L_0x002b:
            int r6 = r6 + 1
            goto L_0x0019
        L_0x002e:
            int r2 = r5.size()     // Catch:{ all -> 0x0125 }
            if (r2 <= 0) goto L_0x004b
            java.util.Collections.sort(r5)     // Catch:{ all -> 0x0125 }
            java.util.Iterator r2 = r5.iterator()     // Catch:{ all -> 0x0125 }
        L_0x003b:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x0125 }
            if (r5 == 0) goto L_0x0052
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x0125 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0125 }
            r1.append(r5)     // Catch:{ all -> 0x0125 }
            goto L_0x003b
        L_0x004b:
            r1.append(r4)     // Catch:{ all -> 0x0125 }
            goto L_0x0052
        L_0x004f:
            r1.append(r4)     // Catch:{ all -> 0x0125 }
        L_0x0052:
            int r2 = r9.countCategories()     // Catch:{ all -> 0x0125 }
            if (r2 <= 0) goto L_0x0094
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0125 }
            r5.<init>()     // Catch:{ all -> 0x0125 }
            r6 = 0
        L_0x005e:
            if (r6 >= r2) goto L_0x0073
            java.lang.String r7 = r9.getCategory(r6)     // Catch:{ all -> 0x006e }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x006e }
            if (r8 != 0) goto L_0x0070
            r5.add(r7)     // Catch:{ all -> 0x006e }
            goto L_0x0070
        L_0x006e:
            int r7 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0125 }
        L_0x0070:
            int r6 = r6 + 1
            goto L_0x005e
        L_0x0073:
            int r6 = r5.size()     // Catch:{ all -> 0x0125 }
            if (r6 <= 0) goto L_0x0090
            java.util.Collections.sort(r5)     // Catch:{ all -> 0x0125 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0125 }
        L_0x0080:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0125 }
            if (r6 == 0) goto L_0x0097
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0125 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0125 }
            r1.append(r6)     // Catch:{ all -> 0x0125 }
            goto L_0x0080
        L_0x0090:
            r1.append(r4)     // Catch:{ all -> 0x0125 }
            goto L_0x0097
        L_0x0094:
            r1.append(r4)     // Catch:{ all -> 0x0125 }
        L_0x0097:
            int r5 = r9.countDataTypes()     // Catch:{ all -> 0x0125 }
            if (r5 <= 0) goto L_0x00d9
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0125 }
            r5.<init>()     // Catch:{ all -> 0x0125 }
            r6 = 0
        L_0x00a3:
            if (r6 >= r2) goto L_0x00b8
            java.lang.String r7 = r9.getDataType(r6)     // Catch:{ all -> 0x00b3 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00b3 }
            if (r8 != 0) goto L_0x00b5
            r5.add(r7)     // Catch:{ all -> 0x00b3 }
            goto L_0x00b5
        L_0x00b3:
            int r7 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0125 }
        L_0x00b5:
            int r6 = r6 + 1
            goto L_0x00a3
        L_0x00b8:
            int r2 = r5.size()     // Catch:{ all -> 0x0125 }
            if (r2 <= 0) goto L_0x00d5
            java.util.Collections.sort(r5)     // Catch:{ all -> 0x0125 }
            java.util.Iterator r2 = r5.iterator()     // Catch:{ all -> 0x0125 }
        L_0x00c5:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x0125 }
            if (r5 == 0) goto L_0x00dc
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x0125 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0125 }
            r1.append(r5)     // Catch:{ all -> 0x0125 }
            goto L_0x00c5
        L_0x00d5:
            r1.append(r4)     // Catch:{ all -> 0x0125 }
            goto L_0x00dc
        L_0x00d9:
            r1.append(r4)     // Catch:{ all -> 0x0125 }
        L_0x00dc:
            int r2 = r9.countDataSchemes()     // Catch:{ all -> 0x0125 }
            if (r2 <= 0) goto L_0x011d
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0125 }
            r5.<init>()     // Catch:{ all -> 0x0125 }
        L_0x00e7:
            if (r3 >= r2) goto L_0x00fc
            java.lang.String r6 = r9.getDataScheme(r3)     // Catch:{ all -> 0x00f7 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00f7 }
            if (r7 != 0) goto L_0x00f9
            r5.add(r6)     // Catch:{ all -> 0x00f7 }
            goto L_0x00f9
        L_0x00f7:
            int r6 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0125 }
        L_0x00f9:
            int r3 = r3 + 1
            goto L_0x00e7
        L_0x00fc:
            int r9 = r5.size()     // Catch:{ all -> 0x0125 }
            if (r9 <= 0) goto L_0x0119
            java.util.Collections.sort(r5)     // Catch:{ all -> 0x0125 }
            java.util.Iterator r9 = r5.iterator()     // Catch:{ all -> 0x0125 }
        L_0x0109:
            boolean r2 = r9.hasNext()     // Catch:{ all -> 0x0125 }
            if (r2 == 0) goto L_0x0120
            java.lang.Object r2 = r9.next()     // Catch:{ all -> 0x0125 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0125 }
            r1.append(r2)     // Catch:{ all -> 0x0125 }
            goto L_0x0109
        L_0x0119:
            r1.append(r4)     // Catch:{ all -> 0x0125 }
            goto L_0x0120
        L_0x011d:
            r1.append(r4)     // Catch:{ all -> 0x0125 }
        L_0x0120:
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x0125 }
            return r9
        L_0x0125:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.a(android.content.IntentFilter):java.lang.String");
    }

    public List<ApkInfo> b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : this.d.keySet()) {
                arrayList.add(this.d.get(str));
            }
            return arrayList;
        } catch (Throwable unused) {
            int i2 = a.a;
            return null;
        }
    }

    public Pair<Boolean, String> b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        File file = new File(str2);
        if (!c.a(file)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        String a2 = k.a(file);
        if (TextUtils.isEmpty(a2)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        if (!a2.equalsIgnoreCase(str)) {
            return new Pair<>(Boolean.FALSE, a2);
        }
        return new Pair<>(Boolean.TRUE, "");
    }

    public ApkInfo b(String str) {
        try {
            return this.d.get(str);
        } catch (Throwable unused) {
            int i2 = a.a;
            return null;
        }
    }

    public boolean b(int i2) {
        List<Integer> list = f1087i;
        return list != null && list.contains(Integer.valueOf(i2));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        c(r7.pkgPath);
        r8 = com.baidu.sofire.a.a.a;
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        return true;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0130 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:86:0x02e7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.baidu.sofire.core.ApkInfo r7, boolean r8) {
        /*
            r6 = this;
            java.lang.System.currentTimeMillis()
            r6.b = r8
            java.lang.String r8 = r7.versionName
            r6.a = r8
            monitor-enter(r6)
            java.lang.String r8 = r7.pkgPath     // Catch:{ all -> 0x02ec }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x02ec }
            r0 = 1
            r1 = 0
            if (r8 == 0) goto L_0x0016
            goto L_0x02e9
        L_0x0016:
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r8 = r6.c     // Catch:{ all -> 0x02ec }
            java.lang.String r2 = r7.pkgPath     // Catch:{ all -> 0x02ec }
            java.lang.Object r8 = r8.get(r2)     // Catch:{ all -> 0x02ec }
            com.baidu.sofire.core.ApkInfo r8 = (com.baidu.sofire.core.ApkInfo) r8     // Catch:{ all -> 0x02ec }
            if (r8 == 0) goto L_0x0033
            java.lang.String r8 = r8.versionName     // Catch:{ all -> 0x02ec }
            java.lang.String r2 = r7.versionName     // Catch:{ all -> 0x02ec }
            boolean r8 = r8.equals(r2)     // Catch:{ all -> 0x02ec }
            if (r8 == 0) goto L_0x002e
            goto L_0x0252
        L_0x002e:
            java.lang.String r8 = r7.pkgPath     // Catch:{ all -> 0x02ec }
            r6.c(r8)     // Catch:{ all -> 0x02ec }
        L_0x0033:
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x02ec }
            java.lang.String r2 = r7.pkgPath     // Catch:{ all -> 0x02ec }
            r8.<init>(r2)     // Catch:{ all -> 0x02ec }
            boolean r8 = com.baidu.sofire.l.c.a((java.io.File) r8)     // Catch:{ all -> 0x02ec }
            if (r8 != 0) goto L_0x006e
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x02ec }
            r8.<init>()     // Catch:{ all -> 0x02ec }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x02ec }
            java.lang.String r2 = "0"
            r8.put(r2, r0)     // Catch:{ all -> 0x02ec }
            int r0 = r7.key     // Catch:{ all -> 0x02ec }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x02ec }
            java.lang.String r2 = "1"
            r8.put(r2, r0)     // Catch:{ all -> 0x02ec }
            java.lang.String r7 = r7.versionName     // Catch:{ all -> 0x02ec }
            java.lang.String r0 = "2"
            r8.put(r0, r7)     // Catch:{ all -> 0x02ec }
            android.app.Application r7 = h     // Catch:{ all -> 0x02ec }
            android.content.Context r7 = r7.getApplicationContext()     // Catch:{ all -> 0x02ec }
            java.lang.String r0 = "1003117"
            com.baidu.sofire.l.c.a((android.content.Context) r7, (java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r8, (boolean) r1)     // Catch:{ all -> 0x02ec }
            monitor-exit(r6)
            goto L_0x02ea
        L_0x006e:
            android.app.Application r8 = h     // Catch:{ all -> 0x0265 }
            r7.hostContext = r8     // Catch:{ all -> 0x0265 }
            int r8 = r7.apkParseSuc     // Catch:{ all -> 0x0265 }
            if (r8 != r0) goto L_0x0139
            java.lang.String r8 = r7.packageName     // Catch:{ all -> 0x0130 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0130 }
            if (r8 != 0) goto L_0x0128
            java.lang.String r8 = r7.pkgPath     // Catch:{ all -> 0x0130 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0130 }
            if (r8 != 0) goto L_0x0128
            int r8 = r7.key     // Catch:{ all -> 0x0130 }
            java.lang.String r2 = r7.versionName     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = r7.apkMD5     // Catch:{ all -> 0x0130 }
            java.lang.String r4 = r7.pkgPath     // Catch:{ all -> 0x0130 }
            boolean r8 = r6.a(r8, r2, r3, r4)     // Catch:{ all -> 0x0130 }
            if (r8 != 0) goto L_0x0096
            goto L_0x02e9
        L_0x0096:
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0130 }
            android.app.Application r2 = h     // Catch:{ all -> 0x0130 }
            java.io.File r2 = com.baidu.sofire.l.c.f((android.content.Context) r2)     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = "sofire_tmp"
            r8.<init>(r2, r3)     // Catch:{ all -> 0x0130 }
            java.lang.String r8 = r8.getCanonicalPath()     // Catch:{ all -> 0x0130 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r2.<init>()     // Catch:{ all -> 0x0130 }
            r2.append(r8)     // Catch:{ all -> 0x0130 }
            java.lang.String r8 = "/."
            r2.append(r8)     // Catch:{ all -> 0x0130 }
            int r8 = r7.key     // Catch:{ all -> 0x0130 }
            r2.append(r8)     // Catch:{ all -> 0x0130 }
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x0130 }
            r7.dataDir = r8     // Catch:{ all -> 0x0130 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r8.<init>()     // Catch:{ all -> 0x0130 }
            java.lang.String r2 = r7.dataDir     // Catch:{ all -> 0x0130 }
            r8.append(r2)     // Catch:{ all -> 0x0130 }
            java.lang.String r2 = "/dex"
            r8.append(r2)     // Catch:{ all -> 0x0130 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0130 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r2.<init>()     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = r7.dataDir     // Catch:{ all -> 0x0130 }
            r2.append(r3)     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = "/lib/"
            r2.append(r3)     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = r6.a     // Catch:{ all -> 0x0130 }
            r2.append(r3)     // Catch:{ all -> 0x0130 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0130 }
            java.lang.String r3 = com.baidu.sofire.l.v.a()     // Catch:{ all -> 0x0130 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0130 }
            r4.<init>()     // Catch:{ all -> 0x0130 }
            r4.append(r2)     // Catch:{ all -> 0x0130 }
            java.lang.String r2 = "/"
            r4.append(r2)     // Catch:{ all -> 0x0130 }
            r4.append(r3)     // Catch:{ all -> 0x0130 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0130 }
            a((java.lang.String) r8)     // Catch:{ all -> 0x0130 }
            com.baidu.sofire.l.c.a((java.lang.String) r8, (boolean) r1)     // Catch:{ all -> 0x0130 }
            a((java.lang.String) r2)     // Catch:{ all -> 0x0130 }
            r6.a((com.baidu.sofire.core.ApkInfo) r7, (java.lang.String) r2, (java.lang.String) r8)     // Catch:{ all -> 0x0130 }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r8 = r6.c     // Catch:{ all -> 0x0130 }
            java.lang.String r2 = r7.pkgPath     // Catch:{ all -> 0x0130 }
            r8.put(r2, r7)     // Catch:{ all -> 0x0130 }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r8 = r6.d     // Catch:{ all -> 0x0130 }
            java.lang.String r2 = r7.packageName     // Catch:{ all -> 0x0130 }
            r8.put(r2, r7)     // Catch:{ all -> 0x0130 }
            java.util.Map<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r8 = r6.e     // Catch:{ all -> 0x0130 }
            int r2 = r7.key     // Catch:{ all -> 0x0130 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0130 }
            r8.put(r2, r7)     // Catch:{ all -> 0x0130 }
            goto L_0x0139
        L_0x0128:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch:{ all -> 0x0130 }
            java.lang.String r2 = "packageName or pkgPath miss"
            r8.<init>(r2)     // Catch:{ all -> 0x0130 }
            throw r8     // Catch:{ all -> 0x0130 }
        L_0x0130:
            java.lang.String r8 = r7.pkgPath     // Catch:{ all -> 0x0265 }
            r6.c(r8)     // Catch:{ all -> 0x0265 }
            int r8 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0265 }
            r8 = 1
            goto L_0x013a
        L_0x0139:
            r8 = 0
        L_0x013a:
            int r2 = r7.apkParseSuc     // Catch:{ all -> 0x0265 }
            if (r2 != r0) goto L_0x0140
            if (r8 == 0) goto L_0x0252
        L_0x0140:
            android.content.pm.PackageInfo r8 = r7.cloudPkgInfo     // Catch:{ all -> 0x0265 }
            if (r8 == 0) goto L_0x0155
            java.lang.String r2 = r8.packageName     // Catch:{ all -> 0x0265 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0265 }
            if (r2 != 0) goto L_0x0155
            java.lang.String r2 = r8.versionName     // Catch:{ all -> 0x0265 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0265 }
            if (r2 != 0) goto L_0x0155
            goto L_0x018d
        L_0x0155:
            android.app.Application r8 = h     // Catch:{ all -> 0x0265 }
            android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch:{ all -> 0x0265 }
            java.lang.String r2 = r7.pkgPath     // Catch:{ all -> 0x0265 }
            android.content.pm.PackageInfo r8 = r8.getPackageArchiveInfo(r2, r0)     // Catch:{ all -> 0x0265 }
            if (r8 == 0) goto L_0x0173
            java.lang.String r2 = r8.packageName     // Catch:{ all -> 0x0265 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0265 }
            if (r2 != 0) goto L_0x0173
            java.lang.String r2 = r8.versionName     // Catch:{ all -> 0x0265 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0265 }
            if (r2 == 0) goto L_0x018d
        L_0x0173:
            java.lang.String r8 = r7.packageName     // Catch:{ all -> 0x0265 }
            java.lang.String r2 = r7.apkMD5     // Catch:{ all -> 0x0265 }
            android.content.pm.PackageInfo r8 = r6.a((java.lang.String) r8, (java.lang.String) r2)     // Catch:{ all -> 0x0265 }
            if (r8 == 0) goto L_0x025d
            java.lang.String r2 = r8.packageName     // Catch:{ all -> 0x0265 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0265 }
            if (r2 != 0) goto L_0x025d
            java.lang.String r2 = r8.versionName     // Catch:{ all -> 0x0265 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0265 }
            if (r2 != 0) goto L_0x025d
        L_0x018d:
            java.lang.String r2 = r8.packageName     // Catch:{ all -> 0x0265 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0265 }
            if (r2 != 0) goto L_0x0255
            java.lang.String r2 = r8.packageName     // Catch:{ all -> 0x0265 }
            java.lang.String r3 = "com.baidu.sofire"
            boolean r2 = r2.startsWith(r3)     // Catch:{ all -> 0x0265 }
            if (r2 == 0) goto L_0x0255
            int r2 = r7.key     // Catch:{ all -> 0x0265 }
            java.lang.String r3 = r8.versionName     // Catch:{ all -> 0x0265 }
            java.lang.String r4 = r7.apkMD5     // Catch:{ all -> 0x0265 }
            java.lang.String r5 = r7.pkgPath     // Catch:{ all -> 0x0265 }
            boolean r2 = r6.a(r2, r3, r4, r5)     // Catch:{ all -> 0x0265 }
            if (r2 != 0) goto L_0x01af
            goto L_0x02e9
        L_0x01af:
            java.lang.String r2 = r8.packageName     // Catch:{ all -> 0x0265 }
            r7.packageName = r2     // Catch:{ all -> 0x0265 }
            android.content.pm.ApplicationInfo r2 = r8.applicationInfo     // Catch:{ all -> 0x0265 }
            java.lang.String r3 = r2.className     // Catch:{ all -> 0x0265 }
            r7.className = r3     // Catch:{ all -> 0x0265 }
            java.lang.String r8 = r8.versionName     // Catch:{ all -> 0x0265 }
            r7.versionName = r8     // Catch:{ all -> 0x0265 }
            int r8 = r2.theme     // Catch:{ all -> 0x0265 }
            r7.applicationTheme = r8     // Catch:{ all -> 0x0265 }
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0265 }
            android.app.Application r2 = h     // Catch:{ all -> 0x0265 }
            java.io.File r2 = com.baidu.sofire.l.c.f((android.content.Context) r2)     // Catch:{ all -> 0x0265 }
            java.lang.String r3 = "sofire_tmp"
            r8.<init>(r2, r3)     // Catch:{ all -> 0x0265 }
            java.lang.String r8 = r8.getCanonicalPath()     // Catch:{ all -> 0x0265 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0265 }
            r2.<init>()     // Catch:{ all -> 0x0265 }
            r2.append(r8)     // Catch:{ all -> 0x0265 }
            java.lang.String r8 = "/."
            r2.append(r8)     // Catch:{ all -> 0x0265 }
            int r8 = r7.key     // Catch:{ all -> 0x0265 }
            r2.append(r8)     // Catch:{ all -> 0x0265 }
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x0265 }
            r7.dataDir = r8     // Catch:{ all -> 0x0265 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0265 }
            r8.<init>()     // Catch:{ all -> 0x0265 }
            java.lang.String r2 = r7.dataDir     // Catch:{ all -> 0x0265 }
            r8.append(r2)     // Catch:{ all -> 0x0265 }
            java.lang.String r2 = "/dex"
            r8.append(r2)     // Catch:{ all -> 0x0265 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0265 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0265 }
            r2.<init>()     // Catch:{ all -> 0x0265 }
            java.lang.String r3 = r7.dataDir     // Catch:{ all -> 0x0265 }
            r2.append(r3)     // Catch:{ all -> 0x0265 }
            java.lang.String r3 = "/lib/"
            r2.append(r3)     // Catch:{ all -> 0x0265 }
            java.lang.String r3 = r6.a     // Catch:{ all -> 0x0265 }
            r2.append(r3)     // Catch:{ all -> 0x0265 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0265 }
            java.lang.String r3 = com.baidu.sofire.l.v.a()     // Catch:{ all -> 0x0265 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0265 }
            r4.<init>()     // Catch:{ all -> 0x0265 }
            r4.append(r2)     // Catch:{ all -> 0x0265 }
            java.lang.String r2 = "/"
            r4.append(r2)     // Catch:{ all -> 0x0265 }
            r4.append(r3)     // Catch:{ all -> 0x0265 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0265 }
            a((java.lang.String) r8)     // Catch:{ all -> 0x0265 }
            com.baidu.sofire.l.c.a((java.lang.String) r8, (boolean) r1)     // Catch:{ all -> 0x0265 }
            a((java.lang.String) r2)     // Catch:{ all -> 0x0265 }
            r6.a((com.baidu.sofire.core.ApkInfo) r7, (java.lang.String) r2, (java.lang.String) r8)     // Catch:{ all -> 0x0265 }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r8 = r6.c     // Catch:{ all -> 0x0265 }
            java.lang.String r2 = r7.pkgPath     // Catch:{ all -> 0x0265 }
            r8.put(r2, r7)     // Catch:{ all -> 0x0265 }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r8 = r6.d     // Catch:{ all -> 0x0265 }
            java.lang.String r2 = r7.packageName     // Catch:{ all -> 0x0265 }
            r8.put(r2, r7)     // Catch:{ all -> 0x0265 }
            java.util.Map<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r8 = r6.e     // Catch:{ all -> 0x0265 }
            int r2 = r7.key     // Catch:{ all -> 0x0265 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0265 }
            r8.put(r2, r7)     // Catch:{ all -> 0x0265 }
        L_0x0252:
            monitor-exit(r6)
            goto L_0x02eb
        L_0x0255:
            java.lang.Exception r8 = new java.lang.Exception     // Catch:{ all -> 0x0265 }
            java.lang.String r0 = "package name check failed"
            r8.<init>(r0)     // Catch:{ all -> 0x0265 }
            throw r8     // Catch:{ all -> 0x0265 }
        L_0x025d:
            java.lang.Exception r8 = new java.lang.Exception     // Catch:{ all -> 0x0265 }
            java.lang.String r0 = "requestCloudPackageInfo failed"
            r8.<init>(r0)     // Catch:{ all -> 0x0265 }
            throw r8     // Catch:{ all -> 0x0265 }
        L_0x0265:
            r8 = move-exception
            java.lang.String r0 = r7.pkgPath     // Catch:{ all -> 0x02e7 }
            r6.c(r0)     // Catch:{ all -> 0x02e7 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x02e7 }
            r0.<init>()     // Catch:{ all -> 0x02e7 }
            java.lang.String r8 = com.baidu.sofire.a.a.a(r8)     // Catch:{ all -> 0x02e7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02e7 }
            r2.<init>()     // Catch:{ all -> 0x02e7 }
            r2.append(r8)     // Catch:{ all -> 0x02e7 }
            java.lang.String r8 = "\r\n isUpgrade="
            r2.append(r8)     // Catch:{ all -> 0x02e7 }
            boolean r8 = r6.b     // Catch:{ all -> 0x02e7 }
            r2.append(r8)     // Catch:{ all -> 0x02e7 }
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x02e7 }
            java.lang.String r2 = "space left"
            boolean r2 = r8.contains(r2)     // Catch:{ all -> 0x02e7 }
            if (r2 == 0) goto L_0x029a
            android.app.Application r2 = h     // Catch:{ all -> 0x02e7 }
            java.lang.String r3 = r7.packageName     // Catch:{ all -> 0x02e7 }
            java.lang.String r8 = com.baidu.sofire.l.h.a(r2, r8, r3)     // Catch:{ all -> 0x02e7 }
        L_0x029a:
            java.lang.String r2 = "0"
            r3 = 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x02e7 }
            r0.put(r2, r3)     // Catch:{ all -> 0x02e7 }
            java.lang.String r2 = "1"
            int r3 = r7.key     // Catch:{ all -> 0x02e7 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x02e7 }
            r0.put(r2, r3)     // Catch:{ all -> 0x02e7 }
            java.lang.String r2 = "2"
            java.lang.String r7 = r7.versionName     // Catch:{ all -> 0x02e7 }
            r0.put(r2, r7)     // Catch:{ all -> 0x02e7 }
            java.lang.String r7 = "3"
            byte[] r8 = r8.getBytes()     // Catch:{ all -> 0x02e7 }
            java.lang.String r8 = android.util.Base64.encodeToString(r8, r1)     // Catch:{ all -> 0x02e7 }
            java.lang.String r2 = "\n"
            java.lang.String r3 = ""
            java.lang.String r8 = r8.replace(r2, r3)     // Catch:{ all -> 0x02e7 }
            java.lang.String r2 = "\t"
            java.lang.String r3 = ""
            java.lang.String r8 = r8.replace(r2, r3)     // Catch:{ all -> 0x02e7 }
            java.lang.String r2 = "\r"
            java.lang.String r3 = ""
            java.lang.String r8 = r8.replace(r2, r3)     // Catch:{ all -> 0x02e7 }
            r0.put(r7, r8)     // Catch:{ all -> 0x02e7 }
            android.app.Application r7 = h     // Catch:{ all -> 0x02e7 }
            android.content.Context r7 = r7.getApplicationContext()     // Catch:{ all -> 0x02e7 }
            java.lang.String r8 = "1003117"
            com.baidu.sofire.l.c.a((android.content.Context) r7, (java.lang.String) r8, (java.util.Map<java.lang.String, java.lang.Object>) r0, (boolean) r1)     // Catch:{ all -> 0x02e7 }
            goto L_0x02e9
        L_0x02e7:
            int r7 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x02ec }
        L_0x02e9:
            monitor-exit(r6)
        L_0x02ea:
            r0 = 0
        L_0x02eb:
            return r0
        L_0x02ec:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.a(com.baidu.sofire.core.ApkInfo, boolean):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:30|31|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0105 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.pm.PackageInfo a(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "t"
            java.lang.String r1 = "n"
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            r3.<init>()     // Catch:{ all -> 0x011f }
            java.lang.String r4 = com.baidu.sofire.l.c.b()     // Catch:{ all -> 0x011f }
            r3.append(r4)     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "p/1/pdl"
            r3.append(r4)     // Catch:{ all -> 0x011f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x011f }
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x011f }
            r4.<init>()     // Catch:{ all -> 0x011f }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x011f }
            r5.<init>()     // Catch:{ all -> 0x011f }
            java.lang.String r6 = "pk"
            r5.put(r6, r11)     // Catch:{ all -> 0x011f }
            java.lang.String r11 = "m"
            r5.put(r11, r12)     // Catch:{ all -> 0x011f }
            r4.put(r5)     // Catch:{ all -> 0x011f }
            java.lang.String r11 = r4.toString()     // Catch:{ all -> 0x011f }
            android.app.Application r12 = h     // Catch:{ all -> 0x011f }
            r4 = 1
            r5 = 0
            java.lang.String r11 = com.baidu.sofire.b.l.a((android.content.Context) r12, (java.lang.String) r3, (java.lang.String) r11, (boolean) r5, (boolean) r4)     // Catch:{ all -> 0x011f }
            org.json.JSONArray r12 = new org.json.JSONArray     // Catch:{ all -> 0x011f }
            r12.<init>(r11)     // Catch:{ all -> 0x011f }
            int r11 = r12.length()     // Catch:{ all -> 0x011f }
            if (r11 > 0) goto L_0x0049
            return r2
        L_0x0049:
            org.json.JSONObject r11 = r12.optJSONObject(r5)     // Catch:{ all -> 0x011f }
            android.content.pm.PackageInfo r12 = new android.content.pm.PackageInfo     // Catch:{ all -> 0x011f }
            r12.<init>()     // Catch:{ all -> 0x011f }
            java.lang.String r3 = "p"
            java.lang.String r3 = r11.optString(r3)     // Catch:{ all -> 0x011f }
            r12.packageName = r3     // Catch:{ all -> 0x011f }
            java.lang.String r3 = "v"
            java.lang.String r3 = r11.optString(r3)     // Catch:{ all -> 0x011f }
            r12.versionName = r3     // Catch:{ all -> 0x011f }
            android.content.pm.ApplicationInfo r3 = new android.content.pm.ApplicationInfo     // Catch:{ all -> 0x011f }
            r3.<init>()     // Catch:{ all -> 0x011f }
            java.lang.String r4 = r11.optString(r1)     // Catch:{ all -> 0x011f }
            r3.className = r4     // Catch:{ all -> 0x011f }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x011f }
            java.lang.String r6 = "."
            if (r4 != 0) goto L_0x0092
            java.lang.String r4 = r3.className     // Catch:{ all -> 0x011f }
            boolean r4 = r4.startsWith(r6)     // Catch:{ all -> 0x011f }
            if (r4 == 0) goto L_0x0092
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            r4.<init>()     // Catch:{ all -> 0x011f }
            java.lang.String r7 = r12.packageName     // Catch:{ all -> 0x011f }
            r4.append(r7)     // Catch:{ all -> 0x011f }
            java.lang.String r7 = r3.className     // Catch:{ all -> 0x011f }
            r4.append(r7)     // Catch:{ all -> 0x011f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x011f }
            r3.className = r4     // Catch:{ all -> 0x011f }
        L_0x0092:
            int r4 = r11.optInt(r0)     // Catch:{ all -> 0x011f }
            r3.theme = r4     // Catch:{ all -> 0x011f }
            r12.applicationInfo = r3     // Catch:{ all -> 0x011f }
            java.lang.String r3 = "a"
            org.json.JSONArray r11 = r11.optJSONArray(r3)     // Catch:{ all -> 0x011f }
            if (r11 == 0) goto L_0x011e
            int r3 = r11.length()     // Catch:{ all -> 0x011f }
            if (r3 <= 0) goto L_0x011e
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x011f }
            r3.<init>()     // Catch:{ all -> 0x011f }
        L_0x00ad:
            int r4 = r11.length()     // Catch:{ all -> 0x011f }
            if (r5 >= r4) goto L_0x010a
            org.json.JSONObject r4 = r11.getJSONObject(r5)     // Catch:{ all -> 0x0105 }
            if (r4 == 0) goto L_0x0107
            android.content.pm.ActivityInfo r7 = new android.content.pm.ActivityInfo     // Catch:{ all -> 0x0105 }
            r7.<init>()     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = r4.optString(r1)     // Catch:{ all -> 0x0105 }
            r7.name = r8     // Catch:{ all -> 0x0105 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0105 }
            if (r8 != 0) goto L_0x00e7
            java.lang.String r8 = r7.name     // Catch:{ all -> 0x0105 }
            boolean r8 = r8.startsWith(r6)     // Catch:{ all -> 0x0105 }
            if (r8 == 0) goto L_0x00e7
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0105 }
            r8.<init>()     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = r12.packageName     // Catch:{ all -> 0x0105 }
            r8.append(r9)     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = r7.name     // Catch:{ all -> 0x0105 }
            r8.append(r9)     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0105 }
            r7.name = r8     // Catch:{ all -> 0x0105 }
        L_0x00e7:
            java.lang.String r8 = r12.packageName     // Catch:{ all -> 0x0105 }
            r7.packageName = r8     // Catch:{ all -> 0x0105 }
            int r8 = r4.optInt(r0)     // Catch:{ all -> 0x0105 }
            r7.theme = r8     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = "l"
            int r4 = r4.optInt(r8)     // Catch:{ all -> 0x0105 }
            r7.labelRes = r4     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = r7.name     // Catch:{ all -> 0x0105 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0105 }
            if (r4 != 0) goto L_0x0107
            r3.add(r7)     // Catch:{ all -> 0x0105 }
            goto L_0x0107
        L_0x0105:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x011f }
        L_0x0107:
            int r5 = r5 + 1
            goto L_0x00ad
        L_0x010a:
            int r11 = r3.size()     // Catch:{ all -> 0x011f }
            if (r11 <= 0) goto L_0x011e
            int r11 = r3.size()     // Catch:{ all -> 0x011f }
            android.content.pm.ActivityInfo[] r11 = new android.content.pm.ActivityInfo[r11]     // Catch:{ all -> 0x011f }
            java.lang.Object[] r11 = r3.toArray(r11)     // Catch:{ all -> 0x011f }
            android.content.pm.ActivityInfo[] r11 = (android.content.pm.ActivityInfo[]) r11     // Catch:{ all -> 0x011f }
            r12.activities = r11     // Catch:{ all -> 0x011f }
        L_0x011e:
            return r12
        L_0x011f:
            int r11 = com.baidu.sofire.a.a.a
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.a(java.lang.String, java.lang.String):android.content.pm.PackageInfo");
    }

    public final boolean a(int i2, String str, String str2, String str3) {
        String str4 = i2 + str;
        Map<String, String> map = a.w;
        if (map != null) {
            String str5 = map.get(str4);
            if (!TextUtils.isEmpty(str5)) {
                str2 = str5;
            }
        }
        Pair<Boolean, String> b2 = b(str2, str3);
        if (((Boolean) b2.first).booleanValue()) {
            return true;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("0", 3);
        hashMap.put("1", Integer.valueOf(i2));
        hashMap.put("2", str);
        hashMap.put("3", Base64.encodeToString(((String) b2.second).getBytes(), 0).replace(StringUtils.LF, "").replace("\t", "").replace(StringUtils.CR, ""));
        c.a(h.getApplicationContext(), "1003117", (Map<String, Object>) hashMap, false);
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:42|43|(1:51)|52|(1:54)|(2:58|59)(1:69)) */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        com.baidu.sofire.l.c.e(new java.io.File(r3, "apkDex").getAbsolutePath());
        r3 = new java.io.File(r3, "dexDex").getAbsolutePath();
        com.baidu.sofire.l.c.e(r3);
        a(r3);
        r9 = a(r1, r2, false);
        r2 = new java.io.File(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x012b, code lost:
        r2.setReadOnly();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x012e, code lost:
        r2 = new com.baidu.sofire.b.i(r9, r3, r6, r7);
        r1.classLoader = r2;
        r2 = r2.loadClass(com.baidu.sofire.l.c.c(r1.es));
        r3 = new java.io.File(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0148, code lost:
        if (r3.exists() != false) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x014a, code lost:
        r3.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x014d, code lost:
        if (r2 == null) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x015f, code lost:
        throw new java.lang.Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        com.baidu.sofire.l.c.e(r1.dataDir);
        r2 = h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0167, code lost:
        if (r2 != null) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0169, code lost:
        com.baidu.sofire.l.c.e(r2.getFileStreamPath(r1.packageName).getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0177, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0199, code lost:
        throw new java.lang.RuntimeException("can't load EngineImpl by both dexFile:" + "" + " and ZipFile:" + r1.pkgPath);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00ec */
    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x0160 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.baidu.sofire.core.ApkInfo r19, java.lang.String r20, java.lang.String r21) throws java.lang.Throwable {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            java.lang.String r4 = "class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null"
            java.lang.String r5 = "apkDex"
            r6 = 1
            java.lang.String r6 = r0.a((com.baidu.sofire.core.ApkInfo) r1, (java.lang.String) r2, (boolean) r6)
            java.lang.String r7 = "java.library.path"
            java.lang.String r7 = java.lang.System.getProperty(r7)
            int r8 = android.os.Build.VERSION.SDK_INT
            java.lang.String r9 = ""
            r10 = 25
            if (r8 >= r10) goto L_0x0025
            boolean r10 = android.text.TextUtils.isEmpty(r7)
            if (r10 == 0) goto L_0x0026
        L_0x0025:
            r7 = r9
        L_0x0026:
            boolean r10 = android.text.TextUtils.isEmpty(r6)
            if (r10 != 0) goto L_0x0047
            boolean r10 = android.text.TextUtils.isEmpty(r7)
            if (r10 != 0) goto L_0x0048
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r6)
            java.lang.String r6 = ":"
            r10.append(r6)
            r10.append(r7)
            java.lang.String r6 = r10.toString()
            goto L_0x0048
        L_0x0047:
            r6 = r7
        L_0x0048:
            r1.libPath = r6
            java.lang.Class<com.baidu.sofire.b.j> r7 = com.baidu.sofire.b.j.class
            java.lang.ClassLoader r7 = r7.getClassLoader()
            r10 = 34
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x00ec }
            r11.<init>(r3, r5)     // Catch:{ all -> 0x00ec }
            java.lang.String r12 = r11.getAbsolutePath()     // Catch:{ all -> 0x00ec }
            com.baidu.sofire.l.c.e((java.lang.String) r12)     // Catch:{ all -> 0x00ec }
            java.io.File r13 = new java.io.File     // Catch:{ all -> 0x00ec }
            java.lang.String r14 = r1.pkgPath     // Catch:{ all -> 0x00ec }
            r13.<init>(r14)     // Catch:{ all -> 0x00ec }
            if (r8 < r10) goto L_0x007c
            boolean r14 = r13.exists()     // Catch:{ all -> 0x00ec }
            if (r14 == 0) goto L_0x007c
            boolean r14 = r13.isFile()     // Catch:{ all -> 0x00ec }
            if (r14 == 0) goto L_0x007c
            boolean r14 = r13.canWrite()     // Catch:{ all -> 0x00ec }
            if (r14 == 0) goto L_0x007c
            r13.setReadOnly()     // Catch:{ all -> 0x00ec }
        L_0x007c:
            a((java.lang.String) r12)     // Catch:{ all -> 0x00ec }
            r14 = 21
            if (r8 == r14) goto L_0x0087
            r14 = 22
            if (r8 != r14) goto L_0x00c6
        L_0x0087:
            long r14 = r11.getFreeSpace()     // Catch:{ all -> 0x00ec }
            boolean r8 = r13.exists()     // Catch:{ all -> 0x00ec }
            if (r8 == 0) goto L_0x00c6
            boolean r8 = r13.isFile()     // Catch:{ all -> 0x00ec }
            if (r8 == 0) goto L_0x00c6
            long r10 = r13.length()     // Catch:{ all -> 0x00ec }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ec }
            r13.<init>()     // Catch:{ all -> 0x00ec }
            java.lang.String r8 = "V5 freeSpace="
            r13.append(r8)     // Catch:{ all -> 0x00ec }
            r13.append(r14)     // Catch:{ all -> 0x00ec }
            java.lang.String r8 = ",fileSize="
            r13.append(r8)     // Catch:{ all -> 0x00ec }
            r13.append(r10)     // Catch:{ all -> 0x00ec }
            r13.toString()     // Catch:{ all -> 0x00ec }
            int r8 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x00ec }
            r16 = 2
            long r10 = r10 * r16
            int r8 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r8 < 0) goto L_0x00be
            goto L_0x00c6
        L_0x00be:
            java.lang.Exception r8 = new java.lang.Exception     // Catch:{ all -> 0x00ec }
            java.lang.String r10 = "Have no space to load plugin."
            r8.<init>(r10)     // Catch:{ all -> 0x00ec }
            throw r8     // Catch:{ all -> 0x00ec }
        L_0x00c6:
            com.baidu.sofire.b.i r8 = new com.baidu.sofire.b.i     // Catch:{ all -> 0x00ec }
            java.lang.String r10 = r1.pkgPath     // Catch:{ all -> 0x00ec }
            r8.<init>(r10, r12, r6, r7)     // Catch:{ all -> 0x00ec }
            r1.classLoader = r8     // Catch:{ all -> 0x00ec }
            java.lang.String r10 = r1.es     // Catch:{ all -> 0x00ec }
            java.lang.String r10 = com.baidu.sofire.l.c.c((java.lang.String) r10)     // Catch:{ all -> 0x00ec }
            java.lang.Class r8 = r8.loadClass(r10)     // Catch:{ all -> 0x00ec }
            if (r8 == 0) goto L_0x00e6
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x00ec }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00ec }
            if (r8 != 0) goto L_0x00e6
            goto L_0x0159
        L_0x00e6:
            java.lang.Exception r8 = new java.lang.Exception     // Catch:{ all -> 0x00ec }
            r8.<init>(r4)     // Catch:{ all -> 0x00ec }
            throw r8     // Catch:{ all -> 0x00ec }
        L_0x00ec:
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0160 }
            r8.<init>(r3, r5)     // Catch:{ all -> 0x0160 }
            java.lang.String r5 = r8.getAbsolutePath()     // Catch:{ all -> 0x0160 }
            com.baidu.sofire.l.c.e((java.lang.String) r5)     // Catch:{ all -> 0x0160 }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0160 }
            java.lang.String r8 = "dexDex"
            r5.<init>(r3, r8)     // Catch:{ all -> 0x0160 }
            java.lang.String r3 = r5.getAbsolutePath()     // Catch:{ all -> 0x0160 }
            com.baidu.sofire.l.c.e((java.lang.String) r3)     // Catch:{ all -> 0x0160 }
            a((java.lang.String) r3)     // Catch:{ all -> 0x0160 }
            r5 = 0
            java.lang.String r9 = r0.a((com.baidu.sofire.core.ApkInfo) r1, (java.lang.String) r2, (boolean) r5)     // Catch:{ all -> 0x0160 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0160 }
            r2.<init>(r9)     // Catch:{ all -> 0x0160 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0160 }
            r8 = 34
            if (r5 < r8) goto L_0x012e
            boolean r5 = r2.exists()     // Catch:{ all -> 0x0160 }
            if (r5 == 0) goto L_0x012e
            boolean r5 = r2.isFile()     // Catch:{ all -> 0x0160 }
            if (r5 == 0) goto L_0x012e
            boolean r5 = r2.canWrite()     // Catch:{ all -> 0x0160 }
            if (r5 == 0) goto L_0x012e
            r2.setReadOnly()     // Catch:{ all -> 0x0160 }
        L_0x012e:
            com.baidu.sofire.b.i r2 = new com.baidu.sofire.b.i     // Catch:{ all -> 0x0160 }
            r2.<init>(r9, r3, r6, r7)     // Catch:{ all -> 0x0160 }
            r1.classLoader = r2     // Catch:{ all -> 0x0160 }
            java.lang.String r3 = r1.es     // Catch:{ all -> 0x0160 }
            java.lang.String r3 = com.baidu.sofire.l.c.c((java.lang.String) r3)     // Catch:{ all -> 0x0160 }
            java.lang.Class r2 = r2.loadClass(r3)     // Catch:{ all -> 0x0160 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0160 }
            r3.<init>(r9)     // Catch:{ all -> 0x0160 }
            boolean r5 = r3.exists()     // Catch:{ all -> 0x0160 }
            if (r5 == 0) goto L_0x014d
            r3.delete()     // Catch:{ all -> 0x0160 }
        L_0x014d:
            if (r2 == 0) goto L_0x015a
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0160 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0160 }
            if (r2 != 0) goto L_0x015a
        L_0x0159:
            return
        L_0x015a:
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ all -> 0x0160 }
            r2.<init>(r4)     // Catch:{ all -> 0x0160 }
            throw r2     // Catch:{ all -> 0x0160 }
        L_0x0160:
            java.lang.String r2 = r1.dataDir     // Catch:{ all -> 0x0177 }
            com.baidu.sofire.l.c.e((java.lang.String) r2)     // Catch:{ all -> 0x0177 }
            android.app.Application r2 = h     // Catch:{ all -> 0x0177 }
            if (r2 == 0) goto L_0x0179
            java.lang.String r3 = r1.packageName     // Catch:{ all -> 0x0177 }
            java.io.File r2 = r2.getFileStreamPath(r3)     // Catch:{ all -> 0x0177 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0177 }
            com.baidu.sofire.l.c.e((java.lang.String) r2)     // Catch:{ all -> 0x0177 }
            goto L_0x0179
        L_0x0177:
            int r2 = com.baidu.sofire.a.a.a
        L_0x0179:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "can't load EngineImpl by both dexFile:"
            r3.append(r4)
            r3.append(r9)
            java.lang.String r4 = " and ZipFile:"
            r3.append(r4)
            java.lang.String r1 = r1.pkgPath
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.a(com.baidu.sofire.core.ApkInfo, java.lang.String, java.lang.String):void");
    }

    public ApkInfo a(int i2) {
        try {
            return this.e.get(Integer.valueOf(i2));
        } catch (Throwable unused) {
            int i3 = a.a;
            return null;
        }
    }

    public static boolean a(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable unused) {
            int i2 = a.a;
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0218, code lost:
        r20 = r4;
        r18 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x021c, code lost:
        r19 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0222, code lost:
        r20 = r4;
        r18 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0226, code lost:
        r19 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x022c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x022d, code lost:
        r14 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0230, code lost:
        r20 = r4;
        r18 = r9;
        r14 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0238, code lost:
        r20 = r4;
        r18 = r9;
        r14 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02b4, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02b5, code lost:
        if (r14 != null) goto L_0x02b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:?, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02bb, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02c1, code lost:
        if (r10 == null) goto L_0x02d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02c7, code lost:
        if (r10 == null) goto L_0x02d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02cd, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02d1, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x011b, code lost:
        r20 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x011f, code lost:
        r20 = r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:18:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x022c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:27:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02b7 A[SYNTHETIC, Splitter:B:152:0x02b7] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0391 A[SYNTHETIC, Splitter:B:216:0x0391] */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x0482 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0178 A[SYNTHETIC, Splitter:B:92:0x0178] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(com.baidu.sofire.core.ApkInfo r22, java.lang.String r23, boolean r24) throws java.lang.Throwable {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r3 = r23
            java.lang.String r4 = "lib/"
            java.lang.String r5 = ".."
            java.lang.String r6 = ".dex"
            java.lang.String r7 = ".so"
            java.lang.String r8 = "/"
            java.lang.String r9 = ""
            if (r2 != 0) goto L_0x0015
            return r9
        L_0x0015:
            java.lang.String r11 = "."
            if (r24 == 0) goto L_0x0029
            java.lang.String r0 = r2.versionName
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0029
            java.lang.String r0 = r2.versionName
            java.lang.String r0 = r0.replace(r11, r9)
            r12 = r0
            goto L_0x002a
        L_0x0029:
            r12 = r9
        L_0x002a:
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ FileNotFoundException -> 0x0043 }
            java.lang.String r10 = r2.pkgPath     // Catch:{ FileNotFoundException -> 0x0043 }
            r0.<init>(r10)     // Catch:{ FileNotFoundException -> 0x0043 }
        L_0x0031:
            r10 = r0
            goto L_0x00a7
        L_0x0034:
            r0 = move-exception
            goto L_0x02b4
        L_0x0037:
            r20 = r4
            r18 = r9
            goto L_0x02be
        L_0x003d:
            r20 = r4
            r18 = r9
            goto L_0x02c4
        L_0x0043:
            r0 = move-exception
            java.lang.String r10 = r0.getMessage()     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            java.io.File r0 = new java.io.File     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            java.lang.String r14 = r2.pkgPath     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            r0.<init>(r14)     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            java.io.File r0 = r0.getParentFile()     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            boolean r14 = r0.exists()     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            if (r14 == 0) goto L_0x0299
            java.io.File r14 = new java.io.File     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            r13.<init>()     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            int r15 = r2.key     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            r13.append(r15)     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            r13.append(r11)     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            java.lang.String r15 = r2.versionName     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            r13.append(r15)     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            java.lang.String r15 = ".b"
            r13.append(r15)     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            java.lang.String r13 = r13.toString()     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            r14.<init>(r0, r13)     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            boolean r0 = r14.exists()     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            if (r0 == 0) goto L_0x027e
            java.io.File r0 = new java.io.File     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            java.lang.String r13 = r2.pkgPath     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            r0.<init>(r13)     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            com.baidu.sofire.b.l.a((java.io.File) r14, (java.io.File) r0)     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            java.lang.String r13 = r2.pkgPath     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            r15 = 1
            com.baidu.sofire.l.c.a((java.lang.String) r13, (boolean) r15)     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            com.baidu.sofire.a.b.a(r0)     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            android.content.Context r13 = r2.hostContext     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            int r15 = r2.key     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            com.baidu.sofire.a.b.a(r13, r15, r0, r14)     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            boolean r0 = r0.exists()     // Catch:{ ZipException -> 0x003d, EOFException -> 0x0037, all -> 0x0034 }
            if (r0 == 0) goto L_0x0263
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ all -> 0x0240 }
            java.lang.String r13 = r2.pkgPath     // Catch:{ all -> 0x0240 }
            r0.<init>(r13)     // Catch:{ all -> 0x0240 }
            goto L_0x0031
        L_0x00a7:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ ZipException -> 0x0238, EOFException -> 0x0230, all -> 0x022c }
            r0.<init>()     // Catch:{ ZipException -> 0x0238, EOFException -> 0x0230, all -> 0x022c }
            java.util.Enumeration r13 = r10.entries()     // Catch:{ ZipException -> 0x0238, EOFException -> 0x0230, all -> 0x022c }
            r14 = r9
        L_0x00b1:
            boolean r15 = r13.hasMoreElements()     // Catch:{ ZipException -> 0x0222, EOFException -> 0x0218, all -> 0x022c }
            if (r15 == 0) goto L_0x018b
            java.lang.Object r15 = r13.nextElement()     // Catch:{ ZipException -> 0x0222, EOFException -> 0x0218, all -> 0x022c }
            java.util.zip.ZipEntry r15 = (java.util.zip.ZipEntry) r15     // Catch:{ ZipException -> 0x0222, EOFException -> 0x0218, all -> 0x022c }
            r17 = r13
            java.lang.String r13 = r15.getName()     // Catch:{ ZipException -> 0x0222, EOFException -> 0x0218, all -> 0x022c }
            boolean r18 = r13.contains(r5)     // Catch:{ ZipException -> 0x0222, EOFException -> 0x0218, all -> 0x022c }
            if (r18 == 0) goto L_0x00d0
            r10.close()     // Catch:{ all -> 0x00cd }
            goto L_0x00cf
        L_0x00cd:
            int r0 = com.baidu.sofire.a.a.a
        L_0x00cf:
            return r9
        L_0x00d0:
            boolean r18 = android.text.TextUtils.isEmpty(r13)     // Catch:{ ZipException -> 0x0222, EOFException -> 0x0218, all -> 0x022c }
            if (r18 != 0) goto L_0x0123
            boolean r18 = r13.startsWith(r4)     // Catch:{ ZipException -> 0x0222, EOFException -> 0x0218, all -> 0x022c }
            if (r18 == 0) goto L_0x0123
            boolean r18 = r15.isDirectory()     // Catch:{ ZipException -> 0x0222, EOFException -> 0x0218, all -> 0x022c }
            if (r18 != 0) goto L_0x0123
            if (r24 == 0) goto L_0x0123
            r18 = r9
            java.lang.String[] r9 = r13.split(r8)     // Catch:{ ZipException -> 0x011f, EOFException -> 0x011b, all -> 0x022c }
            r19 = r14
            int r14 = r9.length     // Catch:{ ZipException -> 0x0117, EOFException -> 0x0113, all -> 0x022c }
            r20 = r4
            r4 = 3
            if (r14 == r4) goto L_0x00f4
            goto L_0x0181
        L_0x00f4:
            r4 = 1
            r9 = r9[r4]     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            if (r4 == 0) goto L_0x00ff
            goto L_0x0181
        L_0x00ff:
            java.lang.Object r4 = r0.get(r9)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            java.util.List r4 = (java.util.List) r4     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            if (r4 != 0) goto L_0x010f
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            r4.<init>()     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            r0.put(r9, r4)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
        L_0x010f:
            r4.add(r15)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            goto L_0x0129
        L_0x0113:
            r20 = r4
            goto L_0x021e
        L_0x0117:
            r20 = r4
            goto L_0x0228
        L_0x011b:
            r20 = r4
            goto L_0x021c
        L_0x011f:
            r20 = r4
            goto L_0x0226
        L_0x0123:
            r20 = r4
            r18 = r9
            r19 = r14
        L_0x0129:
            boolean r4 = r13.endsWith(r6)     // Catch:{ all -> 0x0175 }
            if (r4 == 0) goto L_0x0181
            boolean r4 = r15.isDirectory()     // Catch:{ all -> 0x0175 }
            if (r4 != 0) goto L_0x0181
            if (r24 != 0) goto L_0x0181
            java.lang.String r4 = r2.dataDir     // Catch:{ all -> 0x0175 }
            a((java.lang.String) r4)     // Catch:{ all -> 0x0175 }
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x0175 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r13.<init>()     // Catch:{ all -> 0x0175 }
            int r14 = r2.key     // Catch:{ all -> 0x0175 }
            r13.append(r14)     // Catch:{ all -> 0x0175 }
            r13.append(r11)     // Catch:{ all -> 0x0175 }
            java.lang.String r14 = r2.versionName     // Catch:{ all -> 0x0175 }
            r13.append(r14)     // Catch:{ all -> 0x0175 }
            r13.append(r6)     // Catch:{ all -> 0x0175 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0175 }
            r9.<init>(r4, r13)     // Catch:{ all -> 0x0175 }
            boolean r4 = r1.a((java.util.zip.ZipFile) r10, (java.util.zip.ZipEntry) r15, (java.io.File) r9)     // Catch:{ all -> 0x0173 }
            if (r4 == 0) goto L_0x0169
            java.lang.String r14 = r9.getAbsolutePath()     // Catch:{ all -> 0x0173 }
            r13 = r17
            r9 = r18
            goto L_0x0187
        L_0x0169:
            boolean r4 = r9.exists()     // Catch:{ all -> 0x0173 }
            if (r4 == 0) goto L_0x0181
            r9.delete()     // Catch:{ all -> 0x0173 }
            goto L_0x0181
        L_0x0173:
            goto L_0x0176
        L_0x0175:
            r9 = 0
        L_0x0176:
            if (r9 == 0) goto L_0x0181
            boolean r4 = r9.exists()     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            if (r4 == 0) goto L_0x0181
            r9.delete()     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
        L_0x0181:
            r13 = r17
            r9 = r18
            r14 = r19
        L_0x0187:
            r4 = r20
            goto L_0x00b1
        L_0x018b:
            r20 = r4
            r18 = r9
            r19 = r14
            if (r24 == 0) goto L_0x020d
            int r4 = r0.size()     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            if (r4 <= 0) goto L_0x020d
            java.util.Set r4 = r0.keySet()     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            android.content.Context r9 = r2.hostContext     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            java.lang.String r4 = com.baidu.sofire.l.a.a(r9, r4)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            boolean r9 = android.text.TextUtils.isEmpty(r4)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            if (r9 != 0) goto L_0x020d
            java.io.File r9 = new java.io.File     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            r9.<init>(r3, r4)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            java.lang.String r13 = r9.getAbsolutePath()     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            a((java.lang.String) r13)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            java.util.List r0 = (java.util.List) r0     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            if (r0 == 0) goto L_0x0208
            int r4 = r0.size()     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            if (r4 <= 0) goto L_0x0208
            java.util.Iterator r0 = r0.iterator()     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
        L_0x01c7:
            boolean r4 = r0.hasNext()     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            if (r4 == 0) goto L_0x0208
            java.lang.Object r4 = r0.next()     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            java.util.zip.ZipEntry r4 = (java.util.zip.ZipEntry) r4     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            java.lang.String r13 = r4.getName()     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            int r14 = r13.lastIndexOf(r8)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            r15 = 1
            int r14 = r14 + r15
            java.lang.String r13 = r13.substring(r14)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            r14.<init>()     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            r14.append(r12)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            r14.append(r7)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            java.lang.String r14 = r14.toString()     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            java.lang.String r13 = r13.replace(r7, r14)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            java.io.File r14 = new java.io.File     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            r14.<init>(r9, r13)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            boolean r4 = r1.a((java.util.zip.ZipFile) r10, (java.util.zip.ZipEntry) r4, (java.io.File) r14)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            if (r4 == 0) goto L_0x0200
            goto L_0x01c7
        L_0x0200:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            java.lang.String r4 = "UnZip so failed.Report space left."
            r0.<init>(r4)     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            throw r0     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
        L_0x0208:
            java.lang.String r14 = r9.getAbsolutePath()     // Catch:{ ZipException -> 0x0228, EOFException -> 0x021e, all -> 0x022c }
            goto L_0x020f
        L_0x020d:
            r14 = r19
        L_0x020f:
            r10.close()     // Catch:{ all -> 0x0215 }
            r10 = 0
            goto L_0x02d2
        L_0x0215:
            r10 = 0
            goto L_0x02ce
        L_0x0218:
            r20 = r4
            r18 = r9
        L_0x021c:
            r19 = r14
        L_0x021e:
            r14 = r19
            goto L_0x02c1
        L_0x0222:
            r20 = r4
            r18 = r9
        L_0x0226:
            r19 = r14
        L_0x0228:
            r14 = r19
            goto L_0x02c7
        L_0x022c:
            r0 = move-exception
            r14 = r10
            goto L_0x02b5
        L_0x0230:
            r20 = r4
            r18 = r9
            r14 = r18
            goto L_0x02c1
        L_0x0238:
            r20 = r4
            r18 = r9
            r14 = r18
            goto L_0x02c7
        L_0x0240:
            r0 = move-exception
            r20 = r4
            r18 = r9
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            r9.<init>()     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            r9.append(r10)     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            java.lang.String r10 = "--"
            r9.append(r10)     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            r9.append(r0)     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            java.lang.String r0 = r9.toString()     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            r4.<init>(r0)     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            throw r4     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
        L_0x0263:
            r20 = r4
            r18 = r9
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            r4.<init>()     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            r4.append(r10)     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            java.lang.String r9 = "--file not exists after copy"
            r4.append(r9)     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            java.lang.String r4 = r4.toString()     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            r0.<init>(r4)     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            throw r0     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
        L_0x027e:
            r20 = r4
            r18 = r9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            r0.<init>()     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            r0.append(r10)     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            java.lang.String r4 = "--backupFile not exists"
            r0.append(r4)     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            java.lang.String r0 = r0.toString()     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            r4.<init>(r0)     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            throw r4     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
        L_0x0299:
            r20 = r4
            r18 = r9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            r0.<init>()     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            r0.append(r10)     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            java.lang.String r4 = "--backupDir not exists"
            r0.append(r4)     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            java.lang.String r0 = r0.toString()     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            r4.<init>(r0)     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
            throw r4     // Catch:{ ZipException -> 0x02c4, EOFException -> 0x02be, all -> 0x0034 }
        L_0x02b4:
            r14 = 0
        L_0x02b5:
            if (r14 == 0) goto L_0x02bd
            r14.close()     // Catch:{ all -> 0x02bb }
            goto L_0x02bd
        L_0x02bb:
            int r2 = com.baidu.sofire.a.a.a
        L_0x02bd:
            throw r0
        L_0x02be:
            r14 = r18
            r10 = 0
        L_0x02c1:
            if (r10 == 0) goto L_0x02d1
            goto L_0x02c9
        L_0x02c4:
            r14 = r18
            r10 = 0
        L_0x02c7:
            if (r10 == 0) goto L_0x02d1
        L_0x02c9:
            r10.close()     // Catch:{ all -> 0x02cd }
            goto L_0x02d1
        L_0x02cd:
            r10 = 1
        L_0x02ce:
            int r0 = com.baidu.sofire.a.a.a
            goto L_0x02d2
        L_0x02d1:
            r10 = 1
        L_0x02d2:
            if (r10 == 0) goto L_0x0482
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.zip.ZipInputStream r4 = new java.util.zip.ZipInputStream
            java.io.FileInputStream r9 = new java.io.FileInputStream
            java.lang.String r10 = r2.pkgPath
            r9.<init>(r10)
            r4.<init>(r9)
            r9 = r18
        L_0x02e7:
            java.util.zip.ZipEntry r10 = r4.getNextEntry()     // Catch:{ all -> 0x047a }
            if (r10 == 0) goto L_0x03a5
            java.lang.String r13 = r10.getName()     // Catch:{ all -> 0x047a }
            boolean r14 = r13.contains(r5)     // Catch:{ all -> 0x047a }
            if (r14 == 0) goto L_0x0300
            r4.close()     // Catch:{ all -> 0x02fc }
            goto L_0x03f3
        L_0x02fc:
            int r0 = com.baidu.sofire.a.a.a
            goto L_0x03f3
        L_0x0300:
            r14 = r20
            boolean r15 = r13.startsWith(r14)     // Catch:{ all -> 0x047a }
            if (r15 == 0) goto L_0x033c
            boolean r15 = r10.isDirectory()     // Catch:{ all -> 0x047a }
            if (r15 != 0) goto L_0x033c
            if (r24 == 0) goto L_0x033c
            java.lang.String[] r15 = r13.split(r8)     // Catch:{ all -> 0x047a }
            r16 = r9
            int r9 = r15.length     // Catch:{ all -> 0x047a }
            r17 = r12
            r12 = 3
            if (r9 == r12) goto L_0x0320
            r4.closeEntry()     // Catch:{ all -> 0x047a }
            goto L_0x032c
        L_0x0320:
            r9 = 1
            r12 = r15[r9]     // Catch:{ all -> 0x047a }
            boolean r9 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x047a }
            if (r9 == 0) goto L_0x0332
            r4.closeEntry()     // Catch:{ all -> 0x047a }
        L_0x032c:
            r20 = r14
            r9 = r16
            goto L_0x03a1
        L_0x0332:
            boolean r9 = r0.contains(r12)     // Catch:{ all -> 0x047a }
            if (r9 != 0) goto L_0x0340
            r0.add(r12)     // Catch:{ all -> 0x047a }
            goto L_0x0340
        L_0x033c:
            r16 = r9
            r17 = r12
        L_0x0340:
            boolean r9 = r13.endsWith(r6)     // Catch:{ all -> 0x038e }
            if (r9 == 0) goto L_0x039a
            boolean r9 = r10.isDirectory()     // Catch:{ all -> 0x038e }
            if (r9 != 0) goto L_0x039a
            if (r24 != 0) goto L_0x039a
            java.lang.String r9 = r2.dataDir     // Catch:{ all -> 0x038e }
            a((java.lang.String) r9)     // Catch:{ all -> 0x038e }
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x038e }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x038e }
            r12.<init>()     // Catch:{ all -> 0x038e }
            int r13 = r2.key     // Catch:{ all -> 0x038e }
            r12.append(r13)     // Catch:{ all -> 0x038e }
            r12.append(r11)     // Catch:{ all -> 0x038e }
            java.lang.String r13 = r2.versionName     // Catch:{ all -> 0x038e }
            r12.append(r13)     // Catch:{ all -> 0x038e }
            r12.append(r6)     // Catch:{ all -> 0x038e }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x038e }
            r10.<init>(r9, r12)     // Catch:{ all -> 0x038e }
            r10.delete()     // Catch:{ all -> 0x038c }
            r10.createNewFile()     // Catch:{ all -> 0x038c }
            boolean r9 = r1.a((java.io.File) r10, (java.util.zip.ZipInputStream) r4)     // Catch:{ all -> 0x038c }
            if (r9 == 0) goto L_0x0382
            java.lang.String r9 = r10.getAbsolutePath()     // Catch:{ all -> 0x038c }
            goto L_0x039c
        L_0x0382:
            boolean r9 = r10.exists()     // Catch:{ all -> 0x038c }
            if (r9 == 0) goto L_0x039a
            r10.delete()     // Catch:{ all -> 0x038c }
            goto L_0x039a
        L_0x038c:
            goto L_0x038f
        L_0x038e:
            r10 = 0
        L_0x038f:
            if (r10 == 0) goto L_0x039a
            boolean r9 = r10.exists()     // Catch:{ all -> 0x047a }
            if (r9 == 0) goto L_0x039a
            r10.delete()     // Catch:{ all -> 0x047a }
        L_0x039a:
            r9 = r16
        L_0x039c:
            r4.closeEntry()     // Catch:{ all -> 0x047a }
            r20 = r14
        L_0x03a1:
            r12 = r17
            goto L_0x02e7
        L_0x03a5:
            r16 = r9
            r17 = r12
            r14 = r20
            r4.close()     // Catch:{ all -> 0x03af }
            goto L_0x03b1
        L_0x03af:
            int r4 = com.baidu.sofire.a.a.a
        L_0x03b1:
            if (r24 == 0) goto L_0x0477
            int r4 = r0.size()
            if (r4 <= 0) goto L_0x0477
            android.content.Context r4 = r2.hostContext
            java.lang.String r0 = com.baidu.sofire.l.a.a(r4, r0)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x0477
            java.io.File r4 = new java.io.File
            r4.<init>(r3, r0)
            java.lang.String r3 = r4.getAbsolutePath()
            a((java.lang.String) r3)
            java.util.zip.ZipInputStream r3 = new java.util.zip.ZipInputStream
            java.io.FileInputStream r6 = new java.io.FileInputStream
            java.lang.String r2 = r2.pkgPath
            r6.<init>(r2)
            r3.<init>(r6)
        L_0x03dd:
            java.util.zip.ZipEntry r2 = r3.getNextEntry()     // Catch:{ all -> 0x046f }
            if (r2 == 0) goto L_0x0464
            java.lang.String r6 = r2.getName()     // Catch:{ all -> 0x046f }
            boolean r9 = r6.contains(r5)     // Catch:{ all -> 0x046f }
            if (r9 == 0) goto L_0x03f7
            r3.close()     // Catch:{ all -> 0x03f1 }
            goto L_0x03f3
        L_0x03f1:
            int r0 = com.baidu.sofire.a.a.a
        L_0x03f3:
            r9 = r18
            goto L_0x0479
        L_0x03f7:
            boolean r9 = r6.startsWith(r14)     // Catch:{ all -> 0x046f }
            if (r9 == 0) goto L_0x0459
            boolean r9 = r6.endsWith(r7)     // Catch:{ all -> 0x046f }
            if (r9 == 0) goto L_0x0459
            boolean r2 = r2.isDirectory()     // Catch:{ all -> 0x046f }
            if (r2 != 0) goto L_0x0459
            java.lang.String[] r2 = r6.split(r8)     // Catch:{ all -> 0x046f }
            int r9 = r2.length     // Catch:{ all -> 0x046f }
            r10 = 3
            if (r9 == r10) goto L_0x0415
            r3.closeEntry()     // Catch:{ all -> 0x046f }
            goto L_0x03dd
        L_0x0415:
            r9 = 1
            r2 = r2[r9]     // Catch:{ all -> 0x046f }
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x046f }
            if (r2 == 0) goto L_0x0456
            int r2 = r6.lastIndexOf(r8)     // Catch:{ all -> 0x046f }
            int r2 = r2 + r9
            java.lang.String r2 = r6.substring(r2)     // Catch:{ all -> 0x046f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x046f }
            r6.<init>()     // Catch:{ all -> 0x046f }
            r11 = r17
            r6.append(r11)     // Catch:{ all -> 0x046f }
            r6.append(r7)     // Catch:{ all -> 0x046f }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x046f }
            java.lang.String r2 = r2.replace(r7, r6)     // Catch:{ all -> 0x046f }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x046f }
            r6.<init>(r4, r2)     // Catch:{ all -> 0x046f }
            r6.delete()     // Catch:{ all -> 0x046f }
            r6.createNewFile()     // Catch:{ all -> 0x046f }
            boolean r2 = r1.a((java.io.File) r6, (java.util.zip.ZipInputStream) r3)     // Catch:{ all -> 0x046f }
            if (r2 == 0) goto L_0x044e
            goto L_0x045d
        L_0x044e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x046f }
            java.lang.String r2 = "Stream UnZip so failed.Report space left."
            r0.<init>(r2)     // Catch:{ all -> 0x046f }
            throw r0     // Catch:{ all -> 0x046f }
        L_0x0456:
            r11 = r17
            goto L_0x045d
        L_0x0459:
            r11 = r17
            r9 = 1
            r10 = 3
        L_0x045d:
            r3.closeEntry()     // Catch:{ all -> 0x046f }
            r17 = r11
            goto L_0x03dd
        L_0x0464:
            java.lang.String r9 = r4.getAbsolutePath()     // Catch:{ all -> 0x046f }
            r3.close()     // Catch:{ all -> 0x046c }
            goto L_0x0479
        L_0x046c:
            int r0 = com.baidu.sofire.a.a.a
            goto L_0x0479
        L_0x046f:
            r0 = move-exception
            r3.close()     // Catch:{ all -> 0x0474 }
            goto L_0x0476
        L_0x0474:
            int r2 = com.baidu.sofire.a.a.a
        L_0x0476:
            throw r0
        L_0x0477:
            r9 = r16
        L_0x0479:
            return r9
        L_0x047a:
            r0 = move-exception
            r4.close()     // Catch:{ all -> 0x047f }
            goto L_0x0481
        L_0x047f:
            int r2 = com.baidu.sofire.a.a.a
        L_0x0481:
            throw r0
        L_0x0482:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.a(com.baidu.sofire.core.ApkInfo, java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0034 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0038 A[SYNTHETIC, Splitter:B:28:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0040 A[SYNTHETIC, Splitter:B:33:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.util.zip.ZipFile r4, java.util.zip.ZipEntry r5, java.io.File r6) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r4 = r4.getInputStream(r5)     // Catch:{ all -> 0x0033 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x0034 }
            r5.<init>(r6)     // Catch:{ all -> 0x0034 }
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0031 }
        L_0x000f:
            int r2 = r4.read(r1)     // Catch:{ all -> 0x0031 }
            if (r2 <= 0) goto L_0x0019
            r5.write(r1, r0, r2)     // Catch:{ all -> 0x0031 }
            goto L_0x000f
        L_0x0019:
            r5.flush()     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ all -> 0x0031 }
            r1 = 1
            com.baidu.sofire.l.c.a((java.lang.String) r6, (boolean) r1)     // Catch:{ all -> 0x0031 }
            r4.close()     // Catch:{ all -> 0x0028 }
            goto L_0x002a
        L_0x0028:
            int r4 = com.baidu.sofire.a.a.a
        L_0x002a:
            r5.close()     // Catch:{ all -> 0x002e }
            goto L_0x0030
        L_0x002e:
            int r4 = com.baidu.sofire.a.a.a
        L_0x0030:
            return r1
        L_0x0031:
            r1 = r5
            goto L_0x0034
        L_0x0033:
            r4 = r1
        L_0x0034:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x003e
            r4.close()     // Catch:{ all -> 0x003c }
            goto L_0x003e
        L_0x003c:
            int r4 = com.baidu.sofire.a.a.a
        L_0x003e:
            if (r1 == 0) goto L_0x0046
            r1.close()     // Catch:{ all -> 0x0044 }
            goto L_0x0046
        L_0x0044:
            int r4 = com.baidu.sofire.a.a.a
        L_0x0046:
            return r0
        L_0x0047:
            r5 = move-exception
            if (r4 == 0) goto L_0x0050
            r4.close()     // Catch:{ all -> 0x004e }
            goto L_0x0050
        L_0x004e:
            int r4 = com.baidu.sofire.a.a.a
        L_0x0050:
            if (r1 == 0) goto L_0x0058
            r1.close()     // Catch:{ all -> 0x0056 }
            goto L_0x0058
        L_0x0056:
            int r4 = com.baidu.sofire.a.a.a
        L_0x0058:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.a(java.util.zip.ZipFile, java.util.zip.ZipEntry, java.io.File):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r5 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
        if (r1 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002f, code lost:
        r5 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0031, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0032, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0033, code lost:
        if (r1 != null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0039, code lost:
        r6 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.File r5, java.util.zip.ZipInputStream r6) {
        /*
            r4 = this;
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0026 }
            r1.<init>(r5)     // Catch:{ all -> 0x0026 }
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0027 }
        L_0x000a:
            int r3 = r6.read(r2)     // Catch:{ all -> 0x0027 }
            if (r3 <= 0) goto L_0x0014
            r1.write(r2, r0, r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000a
        L_0x0014:
            r1.flush()     // Catch:{ all -> 0x0027 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x0027 }
            r6 = 1
            com.baidu.sofire.l.c.a((java.lang.String) r5, (boolean) r6)     // Catch:{ all -> 0x0027 }
            r1.close()     // Catch:{ all -> 0x0023 }
            goto L_0x0025
        L_0x0023:
            int r5 = com.baidu.sofire.a.a.a
        L_0x0025:
            return r6
        L_0x0026:
            r1 = 0
        L_0x0027:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ all -> 0x002f }
            goto L_0x0031
        L_0x002f:
            int r5 = com.baidu.sofire.a.a.a
        L_0x0031:
            return r0
        L_0x0032:
            r5 = move-exception
            if (r1 == 0) goto L_0x003b
            r1.close()     // Catch:{ all -> 0x0039 }
            goto L_0x003b
        L_0x0039:
            int r6 = com.baidu.sofire.a.a.a
        L_0x003b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.j.a(java.io.File, java.util.zip.ZipInputStream):boolean");
    }

    public synchronized void a(int i2, boolean z) {
        if (z) {
            List<Integer> list = f1087i;
            if (list != null && !list.contains(Integer.valueOf(i2))) {
                f1087i.add(Integer.valueOf(i2));
            }
        } else {
            List<Integer> list2 = f1087i;
            if (list2 != null && list2.contains(Integer.valueOf(i2))) {
                f1087i.remove(Integer.valueOf(i2));
            }
        }
    }

    public boolean a() {
        try {
            String a2 = a.a(new Throwable());
            for (ApkInfo next : b()) {
                if (TextUtils.isEmpty(next.es)) {
                    if (a2.contains("com.baidu.sofire.engine.EngineImpl")) {
                        return true;
                    }
                } else if (a2.contains(c.c(next.es))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            int i2 = a.a;
            return false;
        }
    }
}
