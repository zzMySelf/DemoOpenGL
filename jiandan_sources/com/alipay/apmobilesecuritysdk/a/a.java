package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.os.Environment;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.sdk.m.f0.c;
import com.alipay.sdk.m.f0.d;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public final class a {
    public Context a;
    public com.alipay.apmobilesecuritysdk.b.a b = com.alipay.apmobilesecuritysdk.b.a.a();
    public int c = 4;

    public a(Context context) {
        this.a = context;
    }

    public static String a(Context context) {
        String b2 = b(context);
        return com.alipay.sdk.m.z.a.a(b2) ? h.f(context) : b2;
    }

    public static String a(Context context, String str) {
        try {
            b();
            String a2 = i.a(str);
            if (!com.alipay.sdk.m.z.a.a(a2)) {
                return a2;
            }
            String a3 = g.a(context, str);
            i.a(str, a3);
            return !com.alipay.sdk.m.z.a.a(a3) ? a3 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int random = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        int i2 = 0;
        while (i2 < 3) {
            try {
                String[] split = strArr[i2].split(" ");
                if (split != null && split.length == 2) {
                    Date date = new Date();
                    Date parse = simpleDateFormat.parse(split[0] + " 00:00:00");
                    Date parse2 = simpleDateFormat.parse(split[1] + " 23:59:59");
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(parse2);
                    instance.add(13, random);
                    Date time = instance.getTime();
                    if (date.after(parse) && date.before(time)) {
                        return true;
                    }
                }
                i2++;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private c b(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        b b2;
        b c2;
        String str4 = "";
        try {
            Context context = this.a;
            d dVar = new d();
            String a2 = com.alipay.sdk.m.z.a.a(map, "appName", str4);
            String a3 = com.alipay.sdk.m.z.a.a(map, "sessionId", str4);
            String a4 = com.alipay.sdk.m.z.a.a(map, "rpcVersion", str4);
            String a5 = a(context, a2);
            String securityToken = UmidSdkWrapper.getSecurityToken(context);
            String d = h.d(context);
            if (com.alipay.sdk.m.z.a.b(a3)) {
                dVar.c = a3;
            } else {
                dVar.c = a5;
            }
            dVar.d = securityToken;
            dVar.e = d;
            dVar.a = SapiDeviceInfo.OS_TYPE;
            com.alipay.apmobilesecuritysdk.e.c c3 = com.alipay.apmobilesecuritysdk.e.d.c(context);
            if (c3 != null) {
                str = c3.a;
                str2 = c3.c;
            } else {
                str2 = str4;
                str = str2;
            }
            if (com.alipay.sdk.m.z.a.a(str) && (c2 = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                str = c2.a;
                str2 = c2.c;
            }
            com.alipay.apmobilesecuritysdk.e.c b3 = com.alipay.apmobilesecuritysdk.e.d.b();
            if (b3 != null) {
                str4 = b3.a;
                str3 = b3.c;
            } else {
                str3 = str4;
            }
            if (com.alipay.sdk.m.z.a.a(str4) && (b2 = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                str4 = b2.a;
                str3 = b2.c;
            }
            dVar.h = str;
            dVar.g = str4;
            dVar.j = a4;
            if (com.alipay.sdk.m.z.a.a(str)) {
                dVar.b = str4;
                str2 = str3;
            } else {
                dVar.b = str;
            }
            dVar.f658i = str2;
            dVar.f = e.a(context, map);
            return com.alipay.sdk.m.d0.d.b(this.a, this.b.c()).a(dVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
            com.alipay.apmobilesecuritysdk.c.a.a(th2);
            return null;
        }
    }

    public static String b(Context context) {
        try {
            String b2 = i.b();
            if (!com.alipay.sdk.m.z.a.a(b2)) {
                return b2;
            }
            com.alipay.apmobilesecuritysdk.e.c b3 = com.alipay.apmobilesecuritysdk.e.d.b(context);
            if (b3 != null) {
                i.a(b3);
                String str = b3.a;
                if (com.alipay.sdk.m.z.a.b(str)) {
                    return str;
                }
            }
            b b4 = com.alipay.apmobilesecuritysdk.e.a.b(context);
            if (b4 == null) {
                return "";
            }
            i.a(b4);
            String str2 = b4.a;
            return com.alipay.sdk.m.z.a.b(str2) ? str2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b() {
        try {
            String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i2 = 0; i2 < 5; i2++) {
                String str = strArr[i2];
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory, ".SystemConfig/" + str);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b9, code lost:
        if (com.alipay.sdk.m.z.a.a(b(r9.a)) != false) goto L_0x00bb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d6 A[Catch:{ Exception -> 0x0240 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d8 A[Catch:{ Exception -> 0x0240 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0203 A[Catch:{ Exception -> 0x0240 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "utdid"
            java.lang.String r1 = "tid"
            java.lang.String r2 = ""
            android.content.Context r3 = r9.a     // Catch:{ Exception -> 0x0240 }
            java.lang.String r4 = com.alipay.sdk.m.z.a.a(r10, r1, r2)     // Catch:{ Exception -> 0x0240 }
            java.lang.String r5 = com.alipay.sdk.m.z.a.a(r10, r0, r2)     // Catch:{ Exception -> 0x0240 }
            android.content.Context r6 = r9.a     // Catch:{ Exception -> 0x0240 }
            java.lang.String r6 = a((android.content.Context) r6)     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.c.a.a(r3, r4, r5, r6)     // Catch:{ Exception -> 0x0240 }
            java.lang.String r3 = "appName"
            java.lang.String r3 = com.alipay.sdk.m.z.a.a(r10, r3, r2)     // Catch:{ Exception -> 0x0240 }
            b()     // Catch:{ Exception -> 0x0240 }
            android.content.Context r4 = r9.a     // Catch:{ Exception -> 0x0240 }
            b((android.content.Context) r4)     // Catch:{ Exception -> 0x0240 }
            android.content.Context r4 = r9.a     // Catch:{ Exception -> 0x0240 }
            a(r4, r3)     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.i.a()     // Catch:{ Exception -> 0x0240 }
            boolean r4 = a()     // Catch:{ Exception -> 0x0240 }
            r5 = 0
            r6 = 1
            if (r4 != 0) goto L_0x00a2
            android.content.Context r4 = r9.a     // Catch:{ Exception -> 0x0240 }
            boolean r4 = com.alipay.apmobilesecuritysdk.common.a.a((android.content.Context) r4)     // Catch:{ Exception -> 0x0240 }
            if (r4 == 0) goto L_0x0040
            goto L_0x00a2
        L_0x0040:
            com.alipay.apmobilesecuritysdk.d.e.a()     // Catch:{ Exception -> 0x0240 }
            android.content.Context r4 = r9.a     // Catch:{ Exception -> 0x0240 }
            java.lang.String r4 = com.alipay.apmobilesecuritysdk.d.e.b(r4, r10)     // Catch:{ Exception -> 0x0240 }
            java.lang.String r7 = com.alipay.apmobilesecuritysdk.e.i.c()     // Catch:{ Exception -> 0x0240 }
            boolean r4 = com.alipay.sdk.m.z.a.a(r4, r7)     // Catch:{ Exception -> 0x0240 }
            r4 = r4 ^ r6
            if (r4 == 0) goto L_0x0055
            goto L_0x00bb
        L_0x0055:
            java.lang.String r4 = com.alipay.sdk.m.z.a.a(r10, r1, r2)     // Catch:{ Exception -> 0x0240 }
            java.lang.String r7 = com.alipay.sdk.m.z.a.a(r10, r0, r2)     // Catch:{ Exception -> 0x0240 }
            boolean r8 = com.alipay.sdk.m.z.a.b(r4)     // Catch:{ Exception -> 0x0240 }
            if (r8 == 0) goto L_0x006e
            java.lang.String r8 = com.alipay.apmobilesecuritysdk.e.i.d()     // Catch:{ Exception -> 0x0240 }
            boolean r4 = com.alipay.sdk.m.z.a.a(r4, r8)     // Catch:{ Exception -> 0x0240 }
            if (r4 != 0) goto L_0x006e
            goto L_0x00bb
        L_0x006e:
            boolean r4 = com.alipay.sdk.m.z.a.b(r7)     // Catch:{ Exception -> 0x0240 }
            if (r4 == 0) goto L_0x007f
            java.lang.String r4 = com.alipay.apmobilesecuritysdk.e.i.e()     // Catch:{ Exception -> 0x0240 }
            boolean r4 = com.alipay.sdk.m.z.a.a(r7, r4)     // Catch:{ Exception -> 0x0240 }
            if (r4 != 0) goto L_0x007f
            goto L_0x00bb
        L_0x007f:
            android.content.Context r4 = r9.a     // Catch:{ Exception -> 0x0240 }
            boolean r4 = com.alipay.apmobilesecuritysdk.e.i.a((android.content.Context) r4, (java.lang.String) r3)     // Catch:{ Exception -> 0x0240 }
            if (r4 != 0) goto L_0x0088
            goto L_0x00bb
        L_0x0088:
            android.content.Context r4 = r9.a     // Catch:{ Exception -> 0x0240 }
            java.lang.String r4 = a(r4, r3)     // Catch:{ Exception -> 0x0240 }
            boolean r4 = com.alipay.sdk.m.z.a.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0240 }
            if (r4 == 0) goto L_0x0095
            goto L_0x00bb
        L_0x0095:
            android.content.Context r4 = r9.a     // Catch:{ Exception -> 0x0240 }
            java.lang.String r4 = b((android.content.Context) r4)     // Catch:{ Exception -> 0x0240 }
            boolean r4 = com.alipay.sdk.m.z.a.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0240 }
            if (r4 == 0) goto L_0x00bd
            goto L_0x00bb
        L_0x00a2:
            android.content.Context r4 = r9.a     // Catch:{ Exception -> 0x0240 }
            java.lang.String r4 = a(r4, r3)     // Catch:{ Exception -> 0x0240 }
            boolean r4 = com.alipay.sdk.m.z.a.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0240 }
            if (r4 == 0) goto L_0x00af
            goto L_0x00bb
        L_0x00af:
            android.content.Context r4 = r9.a     // Catch:{ Exception -> 0x0240 }
            java.lang.String r4 = b((android.content.Context) r4)     // Catch:{ Exception -> 0x0240 }
            boolean r4 = com.alipay.sdk.m.z.a.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0240 }
            if (r4 == 0) goto L_0x00bd
        L_0x00bb:
            r4 = 1
            goto L_0x00be
        L_0x00bd:
            r4 = 0
        L_0x00be:
            android.content.Context r7 = r9.a     // Catch:{ Exception -> 0x0240 }
            android.content.Context r8 = r9.a     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.face.APSecuritySdk r8 = com.alipay.apmobilesecuritysdk.face.APSecuritySdk.getInstance(r8)     // Catch:{ Exception -> 0x0240 }
            com.alipay.sdk.m.a0.b.a((com.alipay.sdk.m.a0.f) r8)     // Catch:{ Exception -> 0x0240 }
            java.lang.String r8 = com.alipay.sdk.m.a0.b.m()     // Catch:{ Exception -> 0x0240 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.h.b(r7, r8)     // Catch:{ Exception -> 0x0240 }
            if (r4 != 0) goto L_0x00d8
            goto L_0x01e7
        L_0x00d8:
            com.alipay.apmobilesecuritysdk.c.b r4 = new com.alipay.apmobilesecuritysdk.c.b     // Catch:{ Exception -> 0x0240 }
            r4.<init>()     // Catch:{ Exception -> 0x0240 }
            android.content.Context r4 = r9.a     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.b.a r7 = com.alipay.apmobilesecuritysdk.b.a.a()     // Catch:{ Exception -> 0x0240 }
            int r7 = r7.b()     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper.startUmidTaskSync(r4, r7)     // Catch:{ Exception -> 0x0240 }
            com.alipay.sdk.m.f0.c r4 = r9.b((java.util.Map<java.lang.String, java.lang.String>) r10)     // Catch:{ Exception -> 0x0240 }
            if (r4 == 0) goto L_0x00f5
            int r7 = r4.c()     // Catch:{ Exception -> 0x0240 }
            goto L_0x00f6
        L_0x00f5:
            r7 = 2
        L_0x00f6:
            if (r7 == r6) goto L_0x0126
            r10 = 3
            if (r7 == r10) goto L_0x0123
            if (r4 == 0) goto L_0x0111
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0240 }
            java.lang.String r0 = "Server error, result:"
            r10.<init>(r0)     // Catch:{ Exception -> 0x0240 }
            java.lang.String r0 = r4.b     // Catch:{ Exception -> 0x0240 }
            r10.append(r0)     // Catch:{ Exception -> 0x0240 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0240 }
        L_0x010d:
            com.alipay.apmobilesecuritysdk.c.a.a((java.lang.String) r10)     // Catch:{ Exception -> 0x0240 }
            goto L_0x0114
        L_0x0111:
            java.lang.String r10 = "Server error, returned null"
            goto L_0x010d
        L_0x0114:
            android.content.Context r10 = r9.a     // Catch:{ Exception -> 0x0240 }
            java.lang.String r10 = a(r10, r3)     // Catch:{ Exception -> 0x0240 }
            boolean r10 = com.alipay.sdk.m.z.a.a((java.lang.String) r10)     // Catch:{ Exception -> 0x0240 }
            if (r10 == 0) goto L_0x01e7
            r10 = 4
            goto L_0x01e8
        L_0x0123:
            r10 = 1
            goto L_0x01e8
        L_0x0126:
            android.content.Context r7 = r9.a     // Catch:{ Exception -> 0x0240 }
            boolean r8 = r4.b()     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.h.a((android.content.Context) r7, (boolean) r8)     // Catch:{ Exception -> 0x0240 }
            android.content.Context r7 = r9.a     // Catch:{ Exception -> 0x0240 }
            java.lang.String r8 = r4.a()     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.h.d(r7, r8)     // Catch:{ Exception -> 0x0240 }
            android.content.Context r7 = r9.a     // Catch:{ Exception -> 0x0240 }
            java.lang.String r8 = r4.g     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.h.e(r7, r8)     // Catch:{ Exception -> 0x0240 }
            android.content.Context r7 = r9.a     // Catch:{ Exception -> 0x0240 }
            java.lang.String r8 = r4.h     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.h.a((android.content.Context) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x0240 }
            android.content.Context r7 = r9.a     // Catch:{ Exception -> 0x0240 }
            java.lang.String r8 = r4.f657i     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.h.f(r7, r8)     // Catch:{ Exception -> 0x0240 }
            android.content.Context r7 = r9.a     // Catch:{ Exception -> 0x0240 }
            java.lang.String r8 = r4.k     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.h.g(r7, r8)     // Catch:{ Exception -> 0x0240 }
            android.content.Context r7 = r9.a     // Catch:{ Exception -> 0x0240 }
            java.lang.String r7 = com.alipay.apmobilesecuritysdk.d.e.b(r7, r10)     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.i.c(r7)     // Catch:{ Exception -> 0x0240 }
            java.lang.String r7 = r4.d     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.i.a((java.lang.String) r3, (java.lang.String) r7)     // Catch:{ Exception -> 0x0240 }
            java.lang.String r7 = r4.c     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.i.b(r7)     // Catch:{ Exception -> 0x0240 }
            java.lang.String r4 = r4.j     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.i.d(r4)     // Catch:{ Exception -> 0x0240 }
            java.lang.String r1 = com.alipay.sdk.m.z.a.a(r10, r1, r2)     // Catch:{ Exception -> 0x0240 }
            boolean r4 = com.alipay.sdk.m.z.a.b(r1)     // Catch:{ Exception -> 0x0240 }
            if (r4 == 0) goto L_0x0184
            java.lang.String r4 = com.alipay.apmobilesecuritysdk.e.i.d()     // Catch:{ Exception -> 0x0240 }
            boolean r4 = com.alipay.sdk.m.z.a.a(r1, r4)     // Catch:{ Exception -> 0x0240 }
            if (r4 != 0) goto L_0x0184
            com.alipay.apmobilesecuritysdk.e.i.e(r1)     // Catch:{ Exception -> 0x0240 }
            goto L_0x0188
        L_0x0184:
            java.lang.String r1 = com.alipay.apmobilesecuritysdk.e.i.d()     // Catch:{ Exception -> 0x0240 }
        L_0x0188:
            com.alipay.apmobilesecuritysdk.e.i.e(r1)     // Catch:{ Exception -> 0x0240 }
            java.lang.String r10 = com.alipay.sdk.m.z.a.a(r10, r0, r2)     // Catch:{ Exception -> 0x0240 }
            boolean r0 = com.alipay.sdk.m.z.a.b(r10)     // Catch:{ Exception -> 0x0240 }
            if (r0 == 0) goto L_0x01a3
            java.lang.String r0 = com.alipay.apmobilesecuritysdk.e.i.e()     // Catch:{ Exception -> 0x0240 }
            boolean r0 = com.alipay.sdk.m.z.a.a(r10, r0)     // Catch:{ Exception -> 0x0240 }
            if (r0 != 0) goto L_0x01a3
            com.alipay.apmobilesecuritysdk.e.i.f(r10)     // Catch:{ Exception -> 0x0240 }
            goto L_0x01a7
        L_0x01a3:
            java.lang.String r10 = com.alipay.apmobilesecuritysdk.e.i.e()     // Catch:{ Exception -> 0x0240 }
        L_0x01a7:
            com.alipay.apmobilesecuritysdk.e.i.f(r10)     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.i.a()     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.c r10 = com.alipay.apmobilesecuritysdk.e.i.g()     // Catch:{ Exception -> 0x0240 }
            android.content.Context r0 = r9.a     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.d.a(r0, r10)     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.d.a()     // Catch:{ Exception -> 0x0240 }
            android.content.Context r10 = r9.a     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.b r0 = new com.alipay.apmobilesecuritysdk.e.b     // Catch:{ Exception -> 0x0240 }
            java.lang.String r1 = com.alipay.apmobilesecuritysdk.e.i.b()     // Catch:{ Exception -> 0x0240 }
            java.lang.String r2 = com.alipay.apmobilesecuritysdk.e.i.c()     // Catch:{ Exception -> 0x0240 }
            java.lang.String r4 = com.alipay.apmobilesecuritysdk.e.i.f()     // Catch:{ Exception -> 0x0240 }
            r0.<init>(r1, r2, r4)     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.a.a(r10, r0)     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.a.a()     // Catch:{ Exception -> 0x0240 }
            java.lang.String r10 = com.alipay.apmobilesecuritysdk.e.i.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0240 }
            android.content.Context r0 = r9.a     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.g.a(r0, r3, r10)     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.g.a()     // Catch:{ Exception -> 0x0240 }
            android.content.Context r10 = r9.a     // Catch:{ Exception -> 0x0240 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.e.h.a((android.content.Context) r10, (java.lang.String) r3, (long) r0)     // Catch:{ Exception -> 0x0240 }
        L_0x01e7:
            r10 = 0
        L_0x01e8:
            r9.c = r10     // Catch:{ Exception -> 0x0240 }
            android.content.Context r10 = r9.a     // Catch:{ Exception -> 0x0240 }
            com.alipay.apmobilesecuritysdk.b.a r0 = r9.b     // Catch:{ Exception -> 0x0240 }
            java.lang.String r0 = r0.c()     // Catch:{ Exception -> 0x0240 }
            com.alipay.sdk.m.g0.a r10 = com.alipay.sdk.m.d0.d.b(r10, r0)     // Catch:{ Exception -> 0x0240 }
            android.content.Context r0 = r9.a     // Catch:{ Exception -> 0x0240 }
            r1 = 0
            java.lang.String r2 = "connectivity"
            java.lang.Object r2 = r0.getSystemService(r2)     // Catch:{ Exception -> 0x0240 }
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch:{ Exception -> 0x0240 }
            if (r2 == 0) goto L_0x0207
            android.net.NetworkInfo r1 = r2.getActiveNetworkInfo()     // Catch:{ Exception -> 0x0240 }
        L_0x0207:
            if (r1 == 0) goto L_0x0216
            boolean r2 = r1.isConnected()     // Catch:{ Exception -> 0x0240 }
            if (r2 == 0) goto L_0x0216
            int r1 = r1.getType()     // Catch:{ Exception -> 0x0240 }
            if (r1 != r6) goto L_0x0216
            r5 = 1
        L_0x0216:
            if (r5 == 0) goto L_0x0244
            boolean r1 = com.alipay.apmobilesecuritysdk.e.h.c(r0)     // Catch:{ Exception -> 0x0240 }
            if (r1 == 0) goto L_0x0244
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0240 }
            r1.<init>()     // Catch:{ Exception -> 0x0240 }
            java.io.File r0 = r0.getFilesDir()     // Catch:{ Exception -> 0x0240 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x0240 }
            r1.append(r0)     // Catch:{ Exception -> 0x0240 }
            java.lang.String r0 = "/log/ap"
            r1.append(r0)     // Catch:{ Exception -> 0x0240 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0240 }
            com.alipay.sdk.m.c0.b r1 = new com.alipay.sdk.m.c0.b     // Catch:{ Exception -> 0x0240 }
            r1.<init>(r0, r10)     // Catch:{ Exception -> 0x0240 }
            r1.a()     // Catch:{ Exception -> 0x0240 }
            goto L_0x0244
        L_0x0240:
            r10 = move-exception
            com.alipay.apmobilesecuritysdk.c.a.a((java.lang.Throwable) r10)
        L_0x0244:
            int r10 = r9.c
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.a.a.a(java.util.Map):int");
    }
}
