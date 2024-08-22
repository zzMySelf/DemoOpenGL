package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import com.alipay.sdk.m.b0.e;
import com.alipay.sdk.m.y.c;
import java.util.HashMap;

public class a {
    public static String a(Context context, String str, String str2) {
        if (context == null || com.alipay.sdk.m.z.a.a(str) || com.alipay.sdk.m.z.a.a(str2)) {
            return null;
        }
        try {
            String a = e.a(context, str, str2, "");
            if (com.alipay.sdk.m.z.a.a(a)) {
                return null;
            }
            return c.b(c.a(), a);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003b, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.Class<com.alipay.apmobilesecuritysdk.f.a> r0 = com.alipay.apmobilesecuritysdk.f.a.class
            monitor-enter(r0)
            boolean r1 = com.alipay.sdk.m.z.a.a((java.lang.String) r3)     // Catch:{ all -> 0x003c }
            r2 = 0
            if (r1 != 0) goto L_0x003a
            boolean r1 = com.alipay.sdk.m.z.a.a((java.lang.String) r4)     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x0011
            goto L_0x003a
        L_0x0011:
            java.lang.String r3 = com.alipay.sdk.m.b0.b.a(r3)     // Catch:{ all -> 0x0038 }
            boolean r1 = com.alipay.sdk.m.z.a.a((java.lang.String) r3)     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return r2
        L_0x001d:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0038 }
            r1.<init>(r3)     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = r1.getString(r4)     // Catch:{ all -> 0x0038 }
            boolean r4 = com.alipay.sdk.m.z.a.a((java.lang.String) r3)     // Catch:{ all -> 0x0038 }
            if (r4 == 0) goto L_0x002e
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return r2
        L_0x002e:
            java.lang.String r4 = com.alipay.sdk.m.y.c.a()     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = com.alipay.sdk.m.y.c.b(r4, r3)     // Catch:{ all -> 0x0038 }
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return r3
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return r2
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return r2
        L_0x003c:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.f.a.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (!com.alipay.sdk.m.z.a.a(str) && !com.alipay.sdk.m.z.a.a(str2) && context != null) {
            try {
                String a = c.a(c.a(), str3);
                HashMap hashMap = new HashMap();
                hashMap.put(str2, a);
                e.a(context, str, hashMap);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:7|8|(4:10|11|12|13)|14|15|16|17|18|(4:20|21|22|(2:24|(1:28)))|29|30|31) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0075, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0025 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0072 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041 A[Catch:{  }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.Class<com.alipay.apmobilesecuritysdk.f.a> r0 = com.alipay.apmobilesecuritysdk.f.a.class
            monitor-enter(r0)
            boolean r1 = com.alipay.sdk.m.z.a.a((java.lang.String) r4)     // Catch:{ all -> 0x0076 }
            if (r1 != 0) goto L_0x0074
            boolean r1 = com.alipay.sdk.m.z.a.a((java.lang.String) r5)     // Catch:{ all -> 0x0076 }
            if (r1 == 0) goto L_0x0010
            goto L_0x0074
        L_0x0010:
            java.lang.String r1 = com.alipay.sdk.m.b0.b.a(r4)     // Catch:{  }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{  }
            r2.<init>()     // Catch:{  }
            boolean r3 = com.alipay.sdk.m.z.a.b(r1)     // Catch:{  }
            if (r3 == 0) goto L_0x002a
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0025 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0025 }
            goto L_0x002a
        L_0x0025:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{  }
            r2.<init>()     // Catch:{  }
        L_0x002a:
            java.lang.String r1 = com.alipay.sdk.m.y.c.a()     // Catch:{  }
            java.lang.String r6 = com.alipay.sdk.m.y.c.a(r1, r6)     // Catch:{  }
            r2.put(r5, r6)     // Catch:{  }
            r2.toString()     // Catch:{  }
            java.lang.System.clearProperty(r4)     // Catch:{ all -> 0x003b }
        L_0x003b:
            boolean r5 = com.alipay.sdk.m.b0.c.a()     // Catch:{  }
            if (r5 == 0) goto L_0x0072
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{  }
            java.lang.String r6 = ".SystemConfig"
            r5.<init>(r6)     // Catch:{  }
            java.lang.String r6 = java.io.File.separator     // Catch:{  }
            r5.append(r6)     // Catch:{  }
            r5.append(r4)     // Catch:{  }
            java.lang.String r4 = r5.toString()     // Catch:{  }
            boolean r5 = com.alipay.sdk.m.b0.c.a()     // Catch:{ all -> 0x0072 }
            if (r5 == 0) goto L_0x0072
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0072 }
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x0072 }
            r5.<init>(r6, r4)     // Catch:{ all -> 0x0072 }
            boolean r4 = r5.exists()     // Catch:{ all -> 0x0072 }
            if (r4 == 0) goto L_0x0072
            boolean r4 = r5.isFile()     // Catch:{ all -> 0x0072 }
            if (r4 == 0) goto L_0x0072
            r5.delete()     // Catch:{ all -> 0x0072 }
        L_0x0072:
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            return
        L_0x0074:
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            return
        L_0x0076:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.f.a.a(java.lang.String, java.lang.String, java.lang.String):void");
    }
}
