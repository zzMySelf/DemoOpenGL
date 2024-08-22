package com.alipay.sdk.m.i0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;

public class f {
    public static volatile f g = null;
    public static boolean h = false;
    public a a = new a("udid");
    public a b = new a("oaid");
    public a c = new a("aaid");
    public a d = new a("vaid");
    public c e = new c();
    public BroadcastReceiver f;

    public static d a(Cursor cursor) {
        String str;
        d dVar = new d((String) null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else if (cursor.isClosed()) {
            str = "parseValue fail, cursor is closed.";
        } else {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                dVar.a = cursor.getString(columnIndex);
            } else {
                a("parseValue fail, index < 0.");
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                dVar.b = cursor.getInt(columnIndex2);
            } else {
                a("parseCode fail, index < 0.");
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                dVar.c = cursor.getLong(columnIndex3);
            } else {
                a("parseExpired fail, index < 0.");
            }
            return dVar;
        }
        a(str);
        return dVar;
    }

    public static final f a() {
        if (g == null) {
            synchronized (f.class) {
                if (g == null) {
                    g = new f();
                }
            }
        }
        return g;
    }

    public static String a(PackageManager packageManager, String str) {
        ProviderInfo resolveContentProvider;
        if (packageManager == null || (resolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (resolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return resolveContentProvider.packageName;
    }

    public static void a(String str) {
        boolean z = h;
    }

    public static void a(boolean z) {
        h = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        if (r7 != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r7 == null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005b, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        if ("0".equals(r8.a) != false) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            a((java.lang.String) r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x0040 }
            r3 = 0
            r4 = 0
            java.lang.String r8 = "supported"
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch:{ Exception -> 0x0040 }
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0040 }
            if (r7 == 0) goto L_0x003b
            com.alipay.sdk.m.i0.d r8 = a((android.database.Cursor) r7)     // Catch:{ Exception -> 0x0040 }
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r8.b     // Catch:{ Exception -> 0x0040 }
            if (r1 != r2) goto L_0x0034
            java.lang.String r1 = "0"
            java.lang.String r8 = r8.a     // Catch:{ Exception -> 0x0040 }
            boolean r8 = r1.equals(r8)     // Catch:{ Exception -> 0x0040 }
            if (r8 == 0) goto L_0x0035
        L_0x0034:
            r0 = 1
        L_0x0035:
            if (r7 == 0) goto L_0x003a
            r7.close()
        L_0x003a:
            return r0
        L_0x003b:
            if (r7 == 0) goto L_0x005b
            goto L_0x0058
        L_0x003e:
            r8 = move-exception
            goto L_0x005c
        L_0x0040:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch:{ all -> 0x003e }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x003e }
            r1.append(r8)     // Catch:{ all -> 0x003e }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x003e }
            a((java.lang.String) r8)     // Catch:{ all -> 0x003e }
            if (r7 == 0) goto L_0x005b
        L_0x0058:
            r7.close()
        L_0x005b:
            return r0
        L_0x005c:
            if (r7 == 0) goto L_0x0061
            r7.close()
        L_0x0061:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.i0.f.a(android.content.Context):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(android.content.Context r10, com.alipay.sdk.m.i0.a r11) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r11.c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            a((java.lang.String) r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch:{ Exception -> 0x009b }
            r3 = 0
            r4 = 0
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch:{ Exception -> 0x009b }
            java.lang.String r6 = r11.c     // Catch:{ Exception -> 0x009b }
            r8 = 0
            r5[r8] = r6     // Catch:{ Exception -> 0x009b }
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x007b
            com.alipay.sdk.m.i0.d r2 = a((android.database.Cursor) r1)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r0 = r2.a     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            r11.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            long r3 = r2.c     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            r11.a((long) r3)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            int r3 = r2.b     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            r11.a((int) r3)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            r3.<init>()     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r4 = r11.c     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            r3.append(r4)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r4 = " errorCode : "
            r3.append(r4)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            int r11 = r11.d     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            r3.append(r11)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r11 = r3.toString()     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            a((java.lang.String) r11)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            int r11 = r2.b     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r11 == r2) goto L_0x008f
            r9.b(r10)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            boolean r11 = r9.a((android.content.Context) r10, (boolean) r8)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            if (r11 != 0) goto L_0x008f
            boolean r10 = r9.a((android.content.Context) r10, (boolean) r7)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r11 = "not support, forceQuery isSupported: "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
        L_0x0076:
            java.lang.String r10 = r11.concat(r10)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            goto L_0x008c
        L_0x007b:
            boolean r11 = r9.a((android.content.Context) r10, (boolean) r8)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            if (r11 == 0) goto L_0x008f
            boolean r10 = r9.a((android.content.Context) r10, (boolean) r7)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            java.lang.String r11 = "forceQuery isSupported : "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
            goto L_0x0076
        L_0x008c:
            a((java.lang.String) r10)     // Catch:{ Exception -> 0x0095, all -> 0x0092 }
        L_0x008f:
            if (r1 == 0) goto L_0x00bb
            goto L_0x00b6
        L_0x0092:
            r10 = move-exception
            r0 = r1
            goto L_0x00bc
        L_0x0095:
            r10 = move-exception
            r11 = r0
            r0 = r1
            goto L_0x009d
        L_0x0099:
            r10 = move-exception
            goto L_0x00bc
        L_0x009b:
            r10 = move-exception
            r11 = r0
        L_0x009d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            java.lang.String r2 = "queryId, Exception : "
            r1.<init>(r2)     // Catch:{ all -> 0x0099 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x0099 }
            r1.append(r10)     // Catch:{ all -> 0x0099 }
            java.lang.String r10 = r1.toString()     // Catch:{ all -> 0x0099 }
            a((java.lang.String) r10)     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x00ba
            r1 = r0
            r0 = r11
        L_0x00b6:
            r1.close()
            goto L_0x00bb
        L_0x00ba:
            r0 = r11
        L_0x00bb:
            return r0
        L_0x00bc:
            if (r0 == 0) goto L_0x00c1
            r0.close()
        L_0x00c1:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.i0.f.b(android.content.Context, com.alipay.sdk.m.i0.a):java.lang.String");
    }

    public static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            a("getAppVersion, Exception : " + e2.getMessage());
            return null;
        }
    }

    private synchronized void b(Context context) {
        if (this.f == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
            e eVar = new e();
            this.f = eVar;
            context.registerReceiver(eVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", (Handler) null);
        }
    }

    public final String a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "getId, openId = null.";
        } else if (aVar.a()) {
            return aVar.b;
        } else {
            if (a(context, true)) {
                return b(context, aVar);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    public final boolean a(Context context, boolean z) {
        if (this.e.a() && !z) {
            return this.e.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String a2 = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        String b2 = b(packageManager, a2);
        if (!this.e.a() || !this.e.a(b2)) {
            this.e.b(b2);
            boolean a3 = a(context);
            a("query support, result : ".concat(String.valueOf(a3)));
            this.e.a(a3);
            return a3;
        }
        a("use same version cache, safeVersion : ".concat(String.valueOf(b2)));
        return this.e.b();
    }
}
