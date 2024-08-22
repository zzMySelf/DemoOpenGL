package com.baidu.sofire.m;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.k.a;

/* compiled from: DoubleListUtil */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static int f3354a = -1;

    public static void a(Context context) {
        a a2 = a.a(context);
        a2.f3299d.putString("rpandid", "");
        a2.f3299d.commit();
        a2.f3299d.putString("rpiiem", "");
        a2.f3299d.commit();
        if (TextUtils.isEmpty("")) {
            a2.f3299d.putString("rpiiemn", "");
            a2.f3299d.commit();
        } else {
            try {
                a2.f3299d.putString("rpiiemn", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                a2.f3299d.commit();
            } catch (Throwable th2) {
                int i2 = com.baidu.sofire.a.a.f3011a;
            }
        }
        if (TextUtils.isEmpty("")) {
            a2.f3297b.putString("p_s_o_d_t", "");
            a2.f3297b.commit();
        } else {
            try {
                a2.f3297b.putString("p_s_o_d_t", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                a2.f3297b.commit();
            } catch (Throwable th3) {
                int i3 = com.baidu.sofire.a.a.f3011a;
            }
        }
        a2.f3297b.putLong("p_s_o_d_t_t", 0);
        a2.f3297b.commit();
        if (TextUtils.isEmpty("")) {
            a2.f3297b.putString("p_s_s_o_t", "");
            a2.f3297b.commit();
        } else {
            try {
                a2.f3297b.putString("p_s_s_o_t", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                a2.f3297b.commit();
            } catch (Throwable th4) {
                int i4 = com.baidu.sofire.a.a.f3011a;
            }
        }
        a2.f3297b.putLong("p_s_s_o_t_t", 0);
        a2.f3297b.commit();
        if (TextUtils.isEmpty("")) {
            a2.f3297b.putString("p_s_n_o_t", "");
            a2.f3297b.commit();
        } else {
            try {
                a2.f3297b.putString("p_s_n_o_t", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                a2.f3297b.commit();
            } catch (Throwable th5) {
                int i5 = com.baidu.sofire.a.a.f3011a;
            }
        }
        a2.f3297b.putLong("p_s_n_o_t_t", 0);
        a2.f3297b.commit();
        if (b(context)) {
            if (TextUtils.isEmpty("")) {
                a2.f3297b.putString("p_s_e_c_t", "");
                a2.f3297b.commit();
            } else {
                try {
                    a2.f3297b.putString("p_s_e_c_t", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.f3297b.commit();
                } catch (Throwable th6) {
                    int i6 = com.baidu.sofire.a.a.f3011a;
                }
            }
            a2.f3297b.putLong("p_s_e_c_t_t", 0);
            a2.f3297b.commit();
            if (TextUtils.isEmpty("")) {
                a2.f3297b.putString("p_s_s_c_t", "");
                a2.f3297b.commit();
            } else {
                try {
                    a2.f3297b.putString("p_s_s_c_t", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.f3297b.commit();
                } catch (Throwable th7) {
                    int i7 = com.baidu.sofire.a.a.f3011a;
                }
            }
            a2.f3297b.putLong("p_s_s_c_t_t", 0);
            a2.f3297b.commit();
            if (TextUtils.isEmpty("")) {
                a2.f3297b.putString("p_s_a_i_t", "");
                a2.f3297b.commit();
            } else {
                try {
                    a2.f3297b.putString("p_s_a_i_t", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.f3297b.commit();
                } catch (Throwable th8) {
                    int i8 = com.baidu.sofire.a.a.f3011a;
                }
            }
            a2.f3297b.putLong("p_s_a_i_t_t", 0);
            a2.f3297b.commit();
            if (TextUtils.isEmpty("")) {
                a2.f3297b.putString("p_s_i_t", "");
                a2.f3297b.commit();
            } else {
                try {
                    a2.f3297b.putString("p_s_i_t", new String(Base64.encode(g.b(a.k, "".getBytes("UTF-8"), true), 10), "UTF-8"));
                    a2.f3297b.commit();
                } catch (Throwable th9) {
                    int i9 = com.baidu.sofire.a.a.f3011a;
                }
            }
            a2.f3297b.putLong("p_s_i_t_t", 0);
            a2.f3297b.commit();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000e, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean b(android.content.Context r5) {
        /*
            java.lang.Class<com.baidu.sofire.m.f> r0 = com.baidu.sofire.m.f.class
            monitor-enter(r0)
            int r1 = f3354a     // Catch:{ all -> 0x0028 }
            r2 = -1
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L_0x000f
            if (r1 != r4) goto L_0x000d
            r3 = r4
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
            f3354a = r4     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)
            return r4
        L_0x0028:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.m.f.b(android.content.Context):boolean");
    }
}
