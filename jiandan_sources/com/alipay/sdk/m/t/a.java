package com.alipay.sdk.m.t;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.app.OpenAuthTask;
import com.alipay.sdk.m.u.e;
import java.util.Random;
import org.json.JSONObject;

public class a {
    public static final String g = "alipay_tid_storage";
    public static final String h = "tidinfo";

    /* renamed from: i  reason: collision with root package name */
    public static final String f680i = "tid";
    public static final String j = "client_key";
    public static final String k = "timestamp";
    public static final String l = "vimei";
    public static final String m = "vimsi";
    public static Context n;

    /* renamed from: o  reason: collision with root package name */
    public static a f681o;
    public String a;
    public String b;
    public long c;
    public String d;
    public String e;
    public boolean f = false;

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f681o == null) {
                f681o = new a();
            }
            if (n == null) {
                f681o.b(context);
            }
            aVar = f681o;
        }
        return aVar;
    }

    private void b(Context context) {
        if (context != null) {
            n = context.getApplicationContext();
        }
        if (!this.f) {
            this.f = true;
            l();
        }
    }

    private String k() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(OpenAuthTask.OK) + 1000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l() {
        /*
            r9 = this;
            java.lang.String r0 = ""
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r2 = 0
            java.lang.String r3 = "alipay_tid_storage"
            java.lang.String r4 = "tidinfo"
            r5 = 1
            java.lang.String r3 = com.alipay.sdk.m.t.a.C0017a.a((java.lang.String) r3, (java.lang.String) r4, (boolean) r5)     // Catch:{ Exception -> 0x0052 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0052 }
            if (r4 != 0) goto L_0x004e
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0052 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r3 = "tid"
            java.lang.String r3 = r4.optString(r3, r0)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r5 = "client_key"
            java.lang.String r5 = r4.optString(r5, r0)     // Catch:{ Exception -> 0x004b }
            java.lang.String r6 = "timestamp"
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0048 }
            long r6 = r4.optLong(r6, r7)     // Catch:{ Exception -> 0x0048 }
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r6 = "vimei"
            java.lang.String r6 = r4.optString(r6, r0)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r7 = "vimsi"
            java.lang.String r2 = r4.optString(r7, r0)     // Catch:{ Exception -> 0x0046 }
            goto L_0x0059
        L_0x0046:
            r0 = move-exception
            goto L_0x0056
        L_0x0048:
            r0 = move-exception
            r6 = r2
            goto L_0x0056
        L_0x004b:
            r0 = move-exception
            r5 = r2
            goto L_0x0055
        L_0x004e:
            r0 = r2
            r5 = r0
            r6 = r5
            goto L_0x005b
        L_0x0052:
            r0 = move-exception
            r3 = r2
            r5 = r3
        L_0x0055:
            r6 = r5
        L_0x0056:
            com.alipay.sdk.m.u.e.a((java.lang.Throwable) r0)
        L_0x0059:
            r0 = r2
            r2 = r3
        L_0x005b:
            java.lang.String r3 = "mspl"
            java.lang.String r4 = "tid_str: load"
            com.alipay.sdk.m.u.e.b(r3, r4)
            boolean r3 = r9.a(r2, r5, r6, r0)
            if (r3 == 0) goto L_0x006c
            r9.m()
            goto L_0x007a
        L_0x006c:
            r9.a = r2
            r9.b = r5
            long r1 = r1.longValue()
            r9.c = r1
            r9.d = r6
            r9.e = r0
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.t.a.l():void");
    }

    private void m() {
        this.a = "";
        this.b = b();
        this.c = System.currentTimeMillis();
        this.d = k();
        this.e = k();
        C0017a.b(g, h);
    }

    private void n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.a);
            jSONObject.put(j, this.b);
            jSONObject.put("timestamp", this.c);
            jSONObject.put(l, this.d);
            jSONObject.put(m, this.e);
            C0017a.a(g, h, jSONObject.toString(), true);
        } catch (Exception e2) {
            e.a((Throwable) e2);
        }
    }

    private void o() {
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public Long e() {
        return Long.valueOf(this.c);
    }

    public String f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }

    public boolean h() {
        return i();
    }

    public boolean i() {
        return TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e);
    }

    /* renamed from: com.alipay.sdk.m.t.a$a  reason: collision with other inner class name */
    public static class C0017a {
        public static boolean a(String str, String str2) {
            if (a.n == null) {
                return false;
            }
            return a.n.getSharedPreferences(str, 0).contains(str2);
        }

        public static void b(String str, String str2) {
            if (a.n != null) {
                a.n.getSharedPreferences(str, 0).edit().remove(str2).apply();
            }
        }

        public static boolean c(String str, String str2) {
            if (a.n == null) {
                return false;
            }
            return a.n.getSharedPreferences(str, 0).contains(str2);
        }

        public static String d(String str, String str2) {
            return a(str, str2, true);
        }

        public static String a(String str, String str2, boolean z) {
            if (a.n == null) {
                return null;
            }
            String string = a.n.getSharedPreferences(str, 0).getString(str2, (String) null);
            if (!TextUtils.isEmpty(string) && z) {
                string = com.alipay.sdk.m.n.e.a(a(), string, string);
                if (TextUtils.isEmpty(string)) {
                    e.b(com.alipay.sdk.m.l.a.A, "tid_str: pref failed");
                }
            }
            e.b(com.alipay.sdk.m.l.a.A, "tid_str: from local");
            return string;
        }

        public static void a(String str, String str2, String str3) {
            a(str, str2, str3, true);
        }

        public static void a(String str, String str2, String str3, boolean z) {
            if (a.n != null) {
                SharedPreferences sharedPreferences = a.n.getSharedPreferences(str, 0);
                if (z) {
                    String a = a();
                    String b = com.alipay.sdk.m.n.e.b(a, str3, str3);
                    if (TextUtils.isEmpty(b)) {
                        String.format("LocalPreference::putLocalPreferences failed %s，%s", new Object[]{str3, a});
                    }
                    str3 = b;
                }
                sharedPreferences.edit().putString(str2, str3).apply();
            }
        }

        public static String a() {
            String str;
            try {
                str = a.n.getApplicationContext().getPackageName();
            } catch (Throwable th2) {
                e.a(th2);
                str = "";
            }
            return (str + "0000000000000000000000000000").substring(0, 24);
        }
    }

    public String b() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    private boolean a(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    public void a() {
        e.b(com.alipay.sdk.m.l.a.A, "tid_str: del");
        m();
    }

    public void a(String str, String str2) {
        e.b(com.alipay.sdk.m.l.a.A, "tid_str: save");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.a = str;
            this.b = str2;
            this.c = System.currentTimeMillis();
            n();
            o();
        }
    }

    private void a(String str, String str2, String str3, String str4, Long l2) {
        if (!a(str, str2, str3, str4)) {
            this.a = str;
            this.b = str2;
            this.d = str3;
            this.e = str4;
            if (l2 == null) {
                this.c = System.currentTimeMillis();
            } else {
                this.c = l2.longValue();
            }
            n();
        }
    }
}
