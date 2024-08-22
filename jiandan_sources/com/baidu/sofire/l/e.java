package com.baidu.sofire.l;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.j.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public final class e {
    public static byte[] a = g.a(16);
    public static String b = "";
    public static Object c = new Object();
    public static boolean d;

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r1 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r1 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00c0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r7) {
        /*
            java.lang.String r0 = b     // Catch:{ all -> 0x0175 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0175 }
            if (r0 != 0) goto L_0x000b
            java.lang.String r7 = b     // Catch:{ all -> 0x0175 }
            return r7
        L_0x000b:
            com.baidu.sofire.j.a r0 = com.baidu.sofire.j.a.a((android.content.Context) r7)     // Catch:{ all -> 0x0175 }
            java.lang.String r1 = r0.d()     // Catch:{ all -> 0x0175 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0175 }
            if (r2 != 0) goto L_0x002d
            java.lang.String r1 = com.baidu.sofire.l.c.d((java.lang.String) r1)     // Catch:{ all -> 0x002b }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x002b }
            if (r2 != 0) goto L_0x002d
            b = r1     // Catch:{ all -> 0x002b }
            a(r7, r1)     // Catch:{ all -> 0x002b }
            java.lang.String r7 = b     // Catch:{ all -> 0x002b }
            return r7
        L_0x002b:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0175 }
        L_0x002d:
            java.lang.String r1 = r0.a()     // Catch:{ all -> 0x0175 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0175 }
            r3 = 10
            r4 = 1
            if (r2 != 0) goto L_0x0065
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0175 }
            byte[] r5 = a     // Catch:{ all -> 0x0175 }
            java.lang.String r6 = "UTF-8"
            byte[] r6 = r1.getBytes(r6)     // Catch:{ all -> 0x0175 }
            byte[] r4 = com.baidu.sofire.l.g.b(r5, r6, r4)     // Catch:{ all -> 0x0175 }
            byte[] r3 = android.util.Base64.encode(r4, r3)     // Catch:{ all -> 0x0175 }
            java.lang.String r4 = "UTF-8"
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0175 }
            android.content.SharedPreferences$Editor r3 = r0.d     // Catch:{ all -> 0x0175 }
            java.lang.String r4 = "xyusec"
            r3.putString(r4, r2)     // Catch:{ all -> 0x0175 }
            android.content.SharedPreferences$Editor r0 = r0.d     // Catch:{ all -> 0x0175 }
            r0.commit()     // Catch:{ all -> 0x0175 }
            b = r1     // Catch:{ all -> 0x0175 }
            a(r7, r1)     // Catch:{ all -> 0x0175 }
            java.lang.String r7 = b     // Catch:{ all -> 0x0175 }
            return r7
        L_0x0065:
            java.lang.String r1 = b     // Catch:{ all -> 0x0175 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0175 }
            if (r1 == 0) goto L_0x0172
            boolean r1 = d     // Catch:{ all -> 0x0175 }
            if (r1 != 0) goto L_0x00f9
            boolean r1 = com.baidu.sofire.k.a.b()     // Catch:{ all -> 0x0175 }
            if (r1 == 0) goto L_0x00f9
            com.baidu.sofire.l.x r1 = com.baidu.sofire.l.x.a((android.content.Context) r7)     // Catch:{ all -> 0x0175 }
            r2 = 0
            android.util.Pair r1 = r1.a((boolean) r4, (boolean) r2)     // Catch:{ all -> 0x0175 }
            java.lang.Object r1 = r1.first     // Catch:{ all -> 0x0175 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0175 }
            b = r1     // Catch:{ all -> 0x0175 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0175 }
            if (r1 == 0) goto L_0x00c2
            com.baidu.sofire.l.x r1 = com.baidu.sofire.l.x.a((android.content.Context) r7)     // Catch:{ all -> 0x0175 }
            android.util.Pair r1 = r1.a((boolean) r2, (boolean) r4)     // Catch:{ all -> 0x0175 }
            java.lang.Object r1 = r1.second     // Catch:{ all -> 0x0175 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0175 }
            b = r1     // Catch:{ all -> 0x0175 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0175 }
            if (r1 != 0) goto L_0x00c2
            com.baidu.sofire.l.x r1 = com.baidu.sofire.l.x.a((android.content.Context) r7)     // Catch:{ all -> 0x0175 }
            java.lang.String r2 = b     // Catch:{ all -> 0x0175 }
            r1.a((java.lang.String) r2, (boolean) r4)     // Catch:{ all -> 0x0175 }
            com.baidu.sofire.l.x r1 = com.baidu.sofire.l.x.a((android.content.Context) r7)     // Catch:{ all -> 0x0175 }
            r1.getClass()     // Catch:{ all -> 0x0175 }
            java.io.File r2 = r1.f     // Catch:{ all -> 0x00c0 }
            if (r2 == 0) goto L_0x00c2
            boolean r2 = r2.exists()     // Catch:{ all -> 0x00c0 }
            if (r2 == 0) goto L_0x00c2
            java.io.File r1 = r1.f     // Catch:{ all -> 0x00c0 }
            r1.delete()     // Catch:{ all -> 0x00c0 }
            goto L_0x00c2
        L_0x00c0:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0175 }
        L_0x00c2:
            java.lang.String r1 = b     // Catch:{ all -> 0x0175 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0175 }
            if (r1 != 0) goto L_0x00f9
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x0175 }
            byte[] r1 = a     // Catch:{ all -> 0x0175 }
            java.lang.String r2 = b     // Catch:{ all -> 0x0175 }
            java.lang.String r5 = "UTF-8"
            byte[] r2 = r2.getBytes(r5)     // Catch:{ all -> 0x0175 }
            byte[] r1 = com.baidu.sofire.l.g.b(r1, r2, r4)     // Catch:{ all -> 0x0175 }
            byte[] r1 = android.util.Base64.encode(r1, r3)     // Catch:{ all -> 0x0175 }
            java.lang.String r2 = "UTF-8"
            r7.<init>(r1, r2)     // Catch:{ all -> 0x0175 }
            java.lang.String r1 = b     // Catch:{ all -> 0x0175 }
            r0.c((java.lang.String) r1)     // Catch:{ all -> 0x0175 }
            android.content.SharedPreferences$Editor r1 = r0.d     // Catch:{ all -> 0x0175 }
            java.lang.String r2 = "xyusec"
            r1.putString(r2, r7)     // Catch:{ all -> 0x0175 }
            android.content.SharedPreferences$Editor r7 = r0.d     // Catch:{ all -> 0x0175 }
            r7.commit()     // Catch:{ all -> 0x0175 }
            d = r4     // Catch:{ all -> 0x0175 }
            java.lang.String r7 = b     // Catch:{ all -> 0x0175 }
            return r7
        L_0x00f9:
            java.lang.String r1 = b     // Catch:{ all -> 0x0175 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0175 }
            if (r1 == 0) goto L_0x0123
            java.util.UUID.randomUUID()     // Catch:{ all -> 0x0175 }
            java.lang.Object r1 = c     // Catch:{ all -> 0x0175 }
            monitor-enter(r1)     // Catch:{ all -> 0x0175 }
            java.lang.String r2 = b     // Catch:{ all -> 0x0120 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0120 }
            if (r2 == 0) goto L_0x0117
            java.lang.String r2 = a()     // Catch:{ all -> 0x0120 }
            b = r2     // Catch:{ all -> 0x0120 }
            monitor-exit(r1)     // Catch:{ all -> 0x0120 }
            goto L_0x0123
        L_0x0117:
            java.lang.String r0 = b     // Catch:{ all -> 0x0120 }
            a(r7, r0)     // Catch:{ all -> 0x0120 }
            java.lang.String r7 = b     // Catch:{ all -> 0x0120 }
            monitor-exit(r1)     // Catch:{ all -> 0x0120 }
            return r7
        L_0x0120:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0120 }
            throw r7     // Catch:{ all -> 0x0175 }
        L_0x0123:
            java.lang.String r1 = b     // Catch:{ all -> 0x0175 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0175 }
            if (r1 == 0) goto L_0x012e
            java.lang.String r7 = b     // Catch:{ all -> 0x0175 }
            return r7
        L_0x012e:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0175 }
            byte[] r2 = a     // Catch:{ all -> 0x0175 }
            java.lang.String r5 = b     // Catch:{ all -> 0x0175 }
            java.lang.String r6 = "UTF-8"
            byte[] r5 = r5.getBytes(r6)     // Catch:{ all -> 0x0175 }
            byte[] r2 = com.baidu.sofire.l.g.b(r2, r5, r4)     // Catch:{ all -> 0x0175 }
            byte[] r2 = android.util.Base64.encode(r2, r3)     // Catch:{ all -> 0x0175 }
            java.lang.String r3 = "UTF-8"
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0175 }
            java.lang.String r2 = r0.a()     // Catch:{ all -> 0x0175 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0175 }
            if (r3 == 0) goto L_0x016a
            java.lang.String r2 = b     // Catch:{ all -> 0x0175 }
            r0.c((java.lang.String) r2)     // Catch:{ all -> 0x0175 }
            android.content.SharedPreferences$Editor r2 = r0.d     // Catch:{ all -> 0x0175 }
            java.lang.String r3 = "xyusec"
            r2.putString(r3, r1)     // Catch:{ all -> 0x0175 }
            android.content.SharedPreferences$Editor r0 = r0.d     // Catch:{ all -> 0x0175 }
            r0.commit()     // Catch:{ all -> 0x0175 }
            java.lang.String r0 = b     // Catch:{ all -> 0x0175 }
            a(r7, r0)     // Catch:{ all -> 0x0175 }
            java.lang.String r7 = b     // Catch:{ all -> 0x0175 }
            return r7
        L_0x016a:
            b = r2     // Catch:{ all -> 0x0175 }
            a(r7, r2)     // Catch:{ all -> 0x0175 }
            java.lang.String r7 = b     // Catch:{ all -> 0x0175 }
            return r7
        L_0x0172:
            java.lang.String r7 = b     // Catch:{ all -> 0x0175 }
            return r7
        L_0x0175:
            int r7 = com.baidu.sofire.a.a.a
            java.lang.String r7 = ""
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.e.a(android.content.Context):java.lang.String");
    }

    public static void b(Context context) {
        String[] split;
        try {
            a a2 = a.a(context);
            String d2 = a2.d();
            if (!TextUtils.isEmpty(d2)) {
                String d3 = c.d(d2);
                if (TextUtils.isEmpty(d3) || (split = d3.split("\\|")) == null || split.length != 2 || TextUtils.isEmpty(split[0])) {
                    return;
                }
                if (!TextUtils.isEmpty(split[1])) {
                    if (!split[1].equals("0")) {
                        String str = split[0] + "|0";
                        a2.d.putString("xyusec", new String(Base64.encode(g.b(a, str.getBytes("UTF-8"), true), 10), "UTF-8"));
                        a2.d.commit();
                        a2.d.putString("xyus", str);
                        a2.d.commit();
                    }
                }
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    public static void a(Context context, String str) {
        try {
            if (d) {
                return;
            }
            if (com.baidu.sofire.k.a.b()) {
                String str2 = (String) x.a(context).a(true, false).first;
                if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
                    x.a(context).a(str, true);
                }
                d = true;
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    public static String a() {
        String str;
        byte[] bytes = UUID.randomUUID().toString().getBytes();
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bytes);
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
                sb.append("");
            }
            str = sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            int i2 = com.baidu.sofire.a.a.a;
            str = null;
        }
        return str + "|" + "0";
    }
}
