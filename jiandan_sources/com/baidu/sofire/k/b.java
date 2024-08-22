package com.baidu.sofire.k;

import android.content.Context;
import android.os.Bundle;
import com.baidu.sofire.a.a;
import com.baidu.sofire.b.l;
import com.baidu.sofire.l.c;
import com.baidu.sofire.mutiprocess.Sp;
import com.baidu.sofire.xclient.privacycontrol.PrvControlManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {
    public static long a;
    public static Boolean b;

    public static void a(String str) {
        try {
            if (b()) {
                PrvControlManager.getInstance().updateConfig(str);
                Bundle bundle = new Bundle();
                bundle.putInt(Sp.BUNDLE_KEY_CTRL_ACTION, 3);
                bundle.putString("bundle_key_config", str);
                Sp.mainProcessBroadcastCtrlActionToAll(bundle);
            }
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public static boolean b() {
        if (b == null) {
            try {
                PrvControlManager.class.toString();
                b = Boolean.TRUE;
                return true;
            } catch (Throwable unused) {
                b = Boolean.FALSE;
            }
        }
        Boolean bool = b;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0099, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009c, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0095 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r16) {
        /*
            java.lang.Class<com.baidu.sofire.k.b> r1 = com.baidu.sofire.k.b.class
            monitor-enter(r1)
            boolean r0 = b()     // Catch:{ all -> 0x0095 }
            if (r0 != 0) goto L_0x000b
            monitor-exit(r1)
            return
        L_0x000b:
            boolean r0 = a()     // Catch:{ all -> 0x0095 }
            if (r0 != 0) goto L_0x0013
            monitor-exit(r1)
            return
        L_0x0013:
            com.baidu.sofire.j.a r0 = com.baidu.sofire.j.a.a((android.content.Context) r16)     // Catch:{ all -> 0x0095 }
            com.baidu.sofire.xclient.privacycontrol.PrvControlManager r2 = com.baidu.sofire.xclient.privacycontrol.PrvControlManager.getInstance()     // Catch:{ all -> 0x0095 }
            r3 = 20
            java.util.Map r2 = r2.getReportData(r3)     // Catch:{ all -> 0x0095 }
        L_0x0021:
            if (r2 == 0) goto L_0x0097
            int r4 = r2.size()     // Catch:{ all -> 0x0095 }
            if (r4 <= 0) goto L_0x0097
            int r4 = com.baidu.sofire.l.c.g((android.content.Context) r16)     // Catch:{ all -> 0x0095 }
            android.content.SharedPreferences r5 = r0.e     // Catch:{ all -> 0x0095 }
            java.lang.String r6 = "re_day_len"
            r7 = 0
            long r5 = r5.getLong(r6, r7)     // Catch:{ all -> 0x0095 }
            r9 = 2
            if (r9 == r4) goto L_0x0072
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0095 }
            android.content.SharedPreferences r4 = r0.e     // Catch:{ all -> 0x0095 }
            java.lang.String r11 = "re_day_b_t"
            long r11 = r4.getLong(r11, r7)     // Catch:{ all -> 0x0095 }
            android.content.SharedPreferences r4 = r0.e     // Catch:{ all -> 0x0095 }
            java.lang.String r13 = "re_net_dy_lt"
            r14 = 50
            int r4 = r4.getInt(r13, r14)     // Catch:{ all -> 0x0095 }
            int r13 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r13 != 0) goto L_0x0058
            r0.a((long) r9)     // Catch:{ all -> 0x0095 }
            r11 = r9
        L_0x0058:
            long r11 = r9 - r11
            r13 = 86400000(0x5265c00, double:4.2687272E-316)
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x006c
            r7 = 1048576(0x100000, float:1.469368E-39)
            int r4 = r4 * r7
            long r7 = (long) r4
            int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x0072
            monitor-exit(r1)
            return
        L_0x006c:
            r0.b((long) r7)     // Catch:{ all -> 0x0095 }
            r0.a((long) r9)     // Catch:{ all -> 0x0095 }
        L_0x0072:
            java.util.List r4 = a((java.util.Map<java.lang.String, java.lang.String>) r2)     // Catch:{ all -> 0x0095 }
            if (r4 != 0) goto L_0x0079
            goto L_0x0097
        L_0x0079:
            r7 = r16
            a(r7, r4, r5)     // Catch:{ all -> 0x0095 }
            int r2 = r2.size()     // Catch:{ all -> 0x0095 }
            if (r2 >= r3) goto L_0x0085
            goto L_0x0097
        L_0x0085:
            boolean r2 = a()     // Catch:{ all -> 0x0095 }
            if (r2 != 0) goto L_0x008c
            goto L_0x0097
        L_0x008c:
            com.baidu.sofire.xclient.privacycontrol.PrvControlManager r2 = com.baidu.sofire.xclient.privacycontrol.PrvControlManager.getInstance()     // Catch:{ all -> 0x0095 }
            java.util.Map r2 = r2.getReportData(r3)     // Catch:{ all -> 0x0095 }
            goto L_0x0021
        L_0x0095:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0099 }
        L_0x0097:
            monitor-exit(r1)
            return
        L_0x0099:
            r0 = move-exception
            r2 = r0
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.k.b.a(android.content.Context):void");
    }

    public static void a(Context context, List<com.baidu.sofire.h.a> list, long j) {
        int g = c.g(context);
        int i2 = com.baidu.sofire.j.a.a(context).e.getInt("re_net_one_lt", 5);
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        int i3 = 0;
        for (com.baidu.sofire.h.a next : list) {
            try {
                JSONObject b2 = c.b(context, new JSONObject(next.e));
                int length = b2.toString().length() + i3;
                if (length >= 1048576 * i2) {
                    break;
                }
                arrayList.add(next.b);
                jSONArray.put(b2);
                i3 = length;
            } catch (Exception unused) {
                int i4 = a.a;
            }
        }
        if (jSONArray.length() > 0) {
            if (l.a(context, jSONArray.toString())) {
                PrvControlManager.getInstance().notifyReportSuccess(arrayList);
            } else {
                a = System.currentTimeMillis();
            }
        }
        if (2 != g) {
            com.baidu.sofire.j.a.a(context).b(((long) i3) + j);
        }
    }

    public static List<com.baidu.sofire.h.a> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : map.entrySet()) {
                com.baidu.sofire.h.a b2 = c.b((String) next.getValue());
                b2.b = (String) next.getKey();
                arrayList.add(b2);
            }
            return arrayList;
        } catch (Throwable unused) {
            int i2 = a.a;
            return null;
        }
    }

    public static boolean a() {
        if (a <= 0) {
            return true;
        }
        if (System.currentTimeMillis() - a < 300000) {
            return false;
        }
        a = 0;
        return true;
    }
}
