package com.baidu.sofire.mutiprocess;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.sofire.d.a;
import com.baidu.sofire.d.b;
import com.baidu.sofire.l.c;
import com.baidu.sofire.l.t;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sp {
    public static final String BUNDLE_KEY_CTRL_ACTION = "bundle_key_ctrl_action";
    public static final int CTRL_ACTION_BROADCAST_PRIVACY_MODULE_CONFIG = 3;

    public static int isMainProcess(Context context) {
        Context context2 = b.a;
        return c.k(context);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0051 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void mainProcessBroadcastCtrlActionToAll(android.os.Bundle r5) {
        /*
            android.content.Context r0 = com.baidu.sofire.d.b.a
            java.util.Map<java.lang.Integer, com.baidu.sofire.d.a> r0 = com.baidu.sofire.d.b.b     // Catch:{ all -> 0x0057 }
            if (r0 != 0) goto L_0x0007
            goto L_0x0059
        L_0x0007:
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x0057 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0057 }
        L_0x000f:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0059
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0057 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0057 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0057 }
            java.lang.Object r2 = r5.clone()     // Catch:{ all -> 0x0057 }
            android.os.Bundle r2 = (android.os.Bundle) r2     // Catch:{ all -> 0x0057 }
            java.util.Map<java.lang.Integer, com.baidu.sofire.d.a> r3 = com.baidu.sofire.d.b.b     // Catch:{ RemoteException -> 0x0054, all -> 0x0051 }
            java.lang.String r4 = "bundle_key_error_code"
            if (r3 != 0) goto L_0x0036
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ RemoteException -> 0x0054, all -> 0x0051 }
            r1.<init>()     // Catch:{ RemoteException -> 0x0054, all -> 0x0051 }
            r2 = -200(0xffffffffffffff38, float:NaN)
            r1.putInt(r4, r2)     // Catch:{ RemoteException -> 0x0054, all -> 0x0051 }
            goto L_0x000f
        L_0x0036:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ RemoteException -> 0x0054, all -> 0x0051 }
            java.lang.Object r1 = r3.get(r1)     // Catch:{ RemoteException -> 0x0054, all -> 0x0051 }
            com.baidu.sofire.d.a r1 = (com.baidu.sofire.d.a) r1     // Catch:{ RemoteException -> 0x0054, all -> 0x0051 }
            if (r1 != 0) goto L_0x004d
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ RemoteException -> 0x0054, all -> 0x0051 }
            r1.<init>()     // Catch:{ RemoteException -> 0x0054, all -> 0x0051 }
            r2 = -202(0xffffffffffffff36, float:NaN)
            r1.putInt(r4, r2)     // Catch:{ RemoteException -> 0x0054, all -> 0x0051 }
            goto L_0x000f
        L_0x004d:
            r1.a((android.os.Bundle) r2)     // Catch:{ RemoteException -> 0x0054, all -> 0x0051 }
            goto L_0x000f
        L_0x0051:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0057 }
            goto L_0x000f
        L_0x0054:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0057 }
            goto L_0x000f
        L_0x0057:
            int r5 = com.baidu.sofire.a.a.a
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.mutiprocess.Sp.mainProcessBroadcastCtrlActionToAll(android.os.Bundle):void");
    }

    public static Bundle mainProcessCallGetPluginStatus(int i2, String str) {
        Context context = b.a;
        try {
            if (TextUtils.isEmpty(str)) {
                return b.a(-201);
            }
            Map<Integer, a> map = b.b;
            if (map == null) {
                return b.a(-200);
            }
            a aVar = map.get(Integer.valueOf(i2));
            if (aVar == null) {
                return b.a(-202);
            }
            return aVar.a(str);
        } catch (RemoteException unused) {
            int i3 = com.baidu.sofire.a.a.a;
            return b.a(-203);
        } catch (Throwable unused2) {
            int i4 = com.baidu.sofire.a.a.a;
            return b.a(-200);
        }
    }

    public static Set<Integer> mainProcessGetSubProcessPids() {
        Context context = b.a;
        try {
            Map<Integer, a> map = b.b;
            if (map == null) {
                return null;
            }
            return map.keySet();
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return null;
        }
    }

    public static Bundle mainProcessRequestCallPlugin(int i2, Bundle bundle) {
        Context context = b.a;
        if (bundle == null) {
            try {
                return b.a(-201);
            } catch (RemoteException unused) {
                int i3 = com.baidu.sofire.a.a.a;
                return b.a(-203);
            } catch (Throwable unused2) {
                int i4 = com.baidu.sofire.a.a.a;
                return null;
            }
        } else {
            Map<Integer, a> map = b.b;
            if (map == null) {
                return b.a(-200);
            }
            a aVar = map.get(Integer.valueOf(i2));
            if (aVar == null) {
                return b.a(-202);
            }
            return aVar.b(bundle);
        }
    }

    public static Map<Integer, Integer> mainProcessStartAllPlugin(String str) {
        Context context = b.a;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (b.b == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (Integer next : b.b.keySet()) {
                hashMap.put(next, Integer.valueOf(b.a(next.intValue(), str, true)));
            }
            return hashMap;
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return null;
        }
    }

    public static int mainProcessStartOrStopPlugin(int i2, String str, boolean z) {
        return b.a(i2, str, z);
    }

    public static void registerNeedNotifySubProcess(String str, boolean z) {
        Context context = b.a;
        try {
            if (!TextUtils.isEmpty(str)) {
                List<String> list = b.d;
                if (list == null) {
                    return;
                }
                if (z) {
                    list.add(str);
                } else {
                    list.remove(str);
                }
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    public static Bundle subProcessRequestCallPlugin(Bundle bundle) {
        Context context = b.a;
        if (context == null) {
            try {
                return b.a(-204);
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
                return b.a(-200);
            }
        } else if (bundle == null) {
            return b.a(-201);
        } else {
            return t.a(context, "sub_process_call_main_plugin", bundle, "sofire");
        }
    }
}
