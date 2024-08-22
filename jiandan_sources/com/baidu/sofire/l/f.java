package com.baidu.sofire.l;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.j.a;

public class f {
    public static int a = -1;

    public static void a(Context context) {
        a a2 = a.a(context);
        a2.d.putString("rpandid", "");
        a2.d.commit();
        a2.d.putString("rpiiem", "");
        a2.d.commit();
        if (TextUtils.isEmpty("")) {
            a2.d.putString("rpiiemn", "");
            a2.d.commit();
        } else {
            try {
                a2.d.putString("rpiiemn", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                a2.d.commit();
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
            }
        }
        if (TextUtils.isEmpty("")) {
            a2.b.putString("p_s_o_d_t", "");
            a2.b.commit();
        } else {
            try {
                a2.b.putString("p_s_o_d_t", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                a2.b.commit();
            } catch (Throwable unused2) {
                int i3 = com.baidu.sofire.a.a.a;
            }
        }
        a2.b.putLong("p_s_o_d_t_t", 0);
        a2.b.commit();
        if (TextUtils.isEmpty("")) {
            a2.b.putString("p_s_s_o_t", "");
            a2.b.commit();
        } else {
            try {
                a2.b.putString("p_s_s_o_t", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                a2.b.commit();
            } catch (Throwable unused3) {
                int i4 = com.baidu.sofire.a.a.a;
            }
        }
        a2.b.putLong("p_s_s_o_t_t", 0);
        a2.b.commit();
        if (TextUtils.isEmpty("")) {
            a2.b.putString("p_s_n_o_t", "");
            a2.b.commit();
        } else {
            try {
                a2.b.putString("p_s_n_o_t", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                a2.b.commit();
            } catch (Throwable unused4) {
                int i5 = com.baidu.sofire.a.a.a;
            }
        }
        a2.b.putLong("p_s_n_o_t_t", 0);
        a2.b.commit();
        if (b(context)) {
            if (TextUtils.isEmpty("")) {
                a2.b.putString("p_s_e_c_t", "");
                a2.b.commit();
            } else {
                try {
                    a2.b.putString("p_s_e_c_t", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.b.commit();
                } catch (Throwable unused5) {
                    int i6 = com.baidu.sofire.a.a.a;
                }
            }
            a2.b.putLong("p_s_e_c_t_t", 0);
            a2.b.commit();
            if (TextUtils.isEmpty("")) {
                a2.b.putString("p_s_s_c_t", "");
                a2.b.commit();
            } else {
                try {
                    a2.b.putString("p_s_s_c_t", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.b.commit();
                } catch (Throwable unused6) {
                    int i7 = com.baidu.sofire.a.a.a;
                }
            }
            a2.b.putLong("p_s_s_c_t_t", 0);
            a2.b.commit();
            if (TextUtils.isEmpty("")) {
                a2.b.putString("p_s_a_i_t", "");
                a2.b.commit();
            } else {
                try {
                    a2.b.putString("p_s_a_i_t", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.b.commit();
                } catch (Throwable unused7) {
                    int i8 = com.baidu.sofire.a.a.a;
                }
            }
            a2.b.putLong("p_s_a_i_t_t", 0);
            a2.b.commit();
            if (TextUtils.isEmpty("")) {
                a2.b.putString("p_s_i_t", "");
                a2.b.commit();
            } else {
                try {
                    a2.b.putString("p_s_i_t", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.b.commit();
                } catch (Throwable unused8) {
                    int i9 = com.baidu.sofire.a.a.a;
                }
            }
            a2.b.putLong("p_s_i_t_t", 0);
            a2.b.commit();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000e, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean b(android.content.Context r5) {
        /*
            java.lang.Class<com.baidu.sofire.l.f> r0 = com.baidu.sofire.l.f.class
            monitor-enter(r0)
            int r1 = a     // Catch:{ all -> 0x0028 }
            r2 = -1
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L_0x000f
            if (r1 != r4) goto L_0x000d
            r3 = 1
        L_0x000d:
            monitor-exit(r0)
            return r3
        L_0x000f:
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x0028 }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x001b
            monitor-exit(r0)
            return r3
        L_0x001b:
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = "baidu"
            r5.contains(r1)     // Catch:{ all -> 0x0028 }
            a = r4     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)
            return r4
        L_0x0028:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.f.b(android.content.Context):boolean");
    }
}
