package com.baidu.sofire.l;

import android.content.Context;
import android.os.PowerManager;
import com.baidu.sofire.ac.DeviceInfoCallback;
import com.baidu.sofire.b.c;
import com.baidu.sofire.j.a;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class r {
    public static DeviceInfoCallback a = null;
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = true;
    public static boolean e = true;
    public static boolean f = true;
    public static boolean g = false;
    public static boolean h;

    /* renamed from: i  reason: collision with root package name */
    public static long f1093i;

    public static void a(JSONObject jSONObject) {
        f = jSONObject.optInt("0", 1) != 0;
        JSONArray optJSONArray = jSONObject.optJSONArray("1");
        if (optJSONArray != null) {
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                hashSet.add(Integer.valueOf(optJSONArray.optInt(i2)));
            }
            b = !hashSet.contains(42);
            d = !hashSet.contains(43);
            c = !hashSet.contains(44);
            e = !hashSet.contains(45);
        }
    }

    public static boolean b(Context context) {
        return s.a(context) && c(context);
    }

    public static boolean c(Context context) {
        boolean z = false;
        if (a.a(c.e).a.getBoolean("s_u_l_c_f", false)) {
            if (!d(context) || !a()) {
                return false;
            }
            return true;
        } else if (System.currentTimeMillis() - f1093i < 1000) {
            return h;
        } else {
            if (d(context) && a()) {
                z = true;
            }
            h = z;
            f1093i = System.currentTimeMillis();
            return h;
        }
    }

    public static boolean d(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return false;
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void e(android.content.Context r3) {
        /*
            java.lang.Class<com.baidu.sofire.l.r> r0 = com.baidu.sofire.l.r.class
            monitor-enter(r0)
            if (r3 != 0) goto L_0x0007
            monitor-exit(r0)
            return
        L_0x0007:
            boolean r1 = g     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)
            return
        L_0x000d:
            r1 = 1
            g = r1     // Catch:{ all -> 0x0027 }
            com.baidu.sofire.j.a r3 = com.baidu.sofire.j.a.a((android.content.Context) r3)     // Catch:{ all -> 0x0027 }
            android.content.SharedPreferences r3 = r3.a     // Catch:{ all -> 0x0027 }
            java.lang.String r1 = "p_s_p_c"
            java.lang.String r2 = ""
            java.lang.String r3 = r3.getString(r1, r2)     // Catch:{ all -> 0x0027 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0027 }
            r1.<init>(r3)     // Catch:{ all -> 0x0027 }
            a((org.json.JSONObject) r1)     // Catch:{ all -> 0x0027 }
            goto L_0x0029
        L_0x0027:
            int r3 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.r.e(android.content.Context):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:47|48|79) */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r1 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00cb, code lost:
        r1 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0086 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x002c=Splitter:B:16:0x002c, B:39:0x005d=Splitter:B:39:0x005d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a() {
        /*
            r0 = 0
            android.content.Context r1 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x00cb }
            if (r1 != 0) goto L_0x0006
            return r0
        L_0x0006:
            com.baidu.sofire.j.a r1 = com.baidu.sofire.j.a.a((android.content.Context) r1)     // Catch:{ all -> 0x00cb }
            android.content.SharedPreferences r1 = r1.a     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "s_u_l_c_f"
            boolean r1 = r1.getBoolean(r2, r0)     // Catch:{ all -> 0x00cb }
            r2 = 1
            if (r1 == 0) goto L_0x0053
            android.content.Context r1 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x00cb }
            java.lang.Class<com.baidu.sofire.l.b> r3 = com.baidu.sofire.l.b.class
            monitor-enter(r3)     // Catch:{ all -> 0x00cb }
            if (r1 != 0) goto L_0x001f
            com.baidu.sofire.l.b r1 = com.baidu.sofire.l.b.h     // Catch:{ all -> 0x0050 }
            goto L_0x002c
        L_0x001f:
            com.baidu.sofire.l.b r4 = com.baidu.sofire.l.b.h     // Catch:{ all -> 0x0050 }
            if (r4 != 0) goto L_0x002a
            com.baidu.sofire.l.b r4 = new com.baidu.sofire.l.b     // Catch:{ all -> 0x0050 }
            r4.<init>(r1)     // Catch:{ all -> 0x0050 }
            com.baidu.sofire.l.b.h = r4     // Catch:{ all -> 0x0050 }
        L_0x002a:
            com.baidu.sofire.l.b r1 = com.baidu.sofire.l.b.h     // Catch:{ all -> 0x0050 }
        L_0x002c:
            monitor-exit(r3)     // Catch:{ all -> 0x00cb }
            r1.getClass()     // Catch:{ all -> 0x00cb }
            int r3 = com.baidu.sofire.l.b.f1090i     // Catch:{ all -> 0x00cb }
            if (r3 <= 0) goto L_0x0036
            r3 = 1
            goto L_0x0037
        L_0x0036:
            r3 = 0
        L_0x0037:
            if (r3 == 0) goto L_0x003a
            goto L_0x004e
        L_0x003a:
            java.io.File r3 = r1.c     // Catch:{ all -> 0x00cb }
            if (r3 == 0) goto L_0x004f
            boolean r3 = r3.isDirectory()     // Catch:{ all -> 0x00cb }
            if (r3 != 0) goto L_0x0045
            goto L_0x004f
        L_0x0045:
            java.io.File r1 = r1.c     // Catch:{ all -> 0x00cb }
            java.io.File[] r1 = r1.listFiles()     // Catch:{ all -> 0x00cb }
            int r1 = r1.length     // Catch:{ all -> 0x00cb }
            if (r1 <= 0) goto L_0x004f
        L_0x004e:
            r0 = 1
        L_0x004f:
            return r0
        L_0x0050:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00cb }
            throw r1     // Catch:{ all -> 0x00cb }
        L_0x0053:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00cb }
            r3 = 21
            if (r1 >= r3) goto L_0x0089
            android.content.Context r1 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x00cb }
            java.lang.String r3 = "activity"
            java.lang.Object r3 = r1.getSystemService(r3)     // Catch:{ all -> 0x0086 }
            android.app.ActivityManager r3 = (android.app.ActivityManager) r3     // Catch:{ all -> 0x0086 }
            java.util.List r4 = r3.getRunningTasks(r2)     // Catch:{ all -> 0x0086 }
            if (r4 != 0) goto L_0x006a
            goto L_0x0088
        L_0x006a:
            java.util.List r2 = r3.getRunningTasks(r2)     // Catch:{ all -> 0x0086 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0086 }
            android.app.ActivityManager$RunningTaskInfo r2 = (android.app.ActivityManager.RunningTaskInfo) r2     // Catch:{ all -> 0x0086 }
            if (r2 != 0) goto L_0x0077
            goto L_0x0088
        L_0x0077:
            android.content.ComponentName r2 = r2.topActivity     // Catch:{ all -> 0x0086 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ all -> 0x0086 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x0086 }
            boolean r0 = r1.equals(r2)     // Catch:{ all -> 0x0086 }
            goto L_0x0088
        L_0x0086:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x00cb }
        L_0x0088:
            return r0
        L_0x0089:
            android.content.Context r1 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x00cd
            java.lang.String r3 = "activity"
            java.lang.Object r1 = r1.getSystemService(r3)     // Catch:{ all -> 0x00cb }
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch:{ all -> 0x00cb }
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch:{ all -> 0x00cb }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00cb }
        L_0x009d:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x00cb }
            if (r3 == 0) goto L_0x00cd
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x00cb }
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch:{ all -> 0x00cb }
            int r4 = r3.importance     // Catch:{ all -> 0x00cb }
            r5 = 100
            if (r4 != r5) goto L_0x009d
            int r4 = r3.importanceReasonCode     // Catch:{ all -> 0x00cb }
            if (r4 != 0) goto L_0x009d
            java.lang.String[] r3 = r3.pkgList     // Catch:{ all -> 0x00cb }
            if (r3 == 0) goto L_0x009d
            int r4 = r3.length     // Catch:{ all -> 0x00cb }
            if (r4 == 0) goto L_0x009d
            java.util.List r3 = java.util.Arrays.asList(r3)     // Catch:{ all -> 0x00cb }
            android.content.Context r4 = com.baidu.sofire.b.c.e     // Catch:{ all -> 0x00cb }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x00cb }
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x00cb }
            if (r3 == 0) goto L_0x009d
            return r2
        L_0x00cb:
            int r1 = com.baidu.sofire.a.a.a
        L_0x00cd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.r.a():boolean");
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return f || c(context);
    }
}
