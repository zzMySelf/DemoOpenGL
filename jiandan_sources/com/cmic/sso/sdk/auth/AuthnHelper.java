package com.cmic.sso.sdk.auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.cmic.sso.sdk.c;
import com.cmic.sso.sdk.e.b;
import com.cmic.sso.sdk.e.e;
import com.cmic.sso.sdk.e.h;
import com.cmic.sso.sdk.e.j;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.m;
import com.cmic.sso.sdk.e.n;
import com.cmic.sso.sdk.e.o;
import com.cmic.sso.sdk.e.q;
import com.cmic.sso.sdk.e.r;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthnHelper {
    public static final String SDK_VERSION = "quick_login_android_9.5.5.2";
    @SuppressLint({"StaticFieldLeak"})
    public static AuthnHelper c;
    public final a a;
    public final Context b;
    public long d;
    public final Handler e;
    public String f;
    public final c g;

    public class a implements Runnable {
        public final com.cmic.sso.sdk.a b;

        public a(com.cmic.sso.sdk.a aVar) {
            this.b = aVar;
        }

        public void run() {
            JSONObject jSONObject;
            if (r.a(AuthnHelper.this.b).a() || !this.b.b("doNetworkSwitch", false)) {
                jSONObject = c.a("200023", "登录超时");
            } else {
                jSONObject = c.a("102508", "数据网络切换失败");
            }
            AuthnHelper.this.callBackResult(jSONObject.optString("resultCode", "200023"), jSONObject.optString("desc", "登录超时"), this.b, jSONObject);
        }
    }

    public AuthnHelper(Context context) {
        this.d = 8000;
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.e = new Handler(applicationContext.getMainLooper());
        this.a = a.a(applicationContext);
        r.a(applicationContext);
        k.a(applicationContext);
        j.a(applicationContext);
        this.g = new c();
        n.a(new n.a() {
            public void a() {
                String b = k.b("AID", "");
                com.cmic.sso.sdk.e.c.b("AuthnHelper", "aid = " + b);
                if (TextUtils.isEmpty(b)) {
                    AuthnHelper.this.a();
                }
                if (b.a(AuthnHelper.this.b, true)) {
                    com.cmic.sso.sdk.e.c.b("AuthnHelper", "生成androidkeystore成功");
                } else {
                    com.cmic.sso.sdk.e.c.b("AuthnHelper", "生成androidkeystore失败");
                }
            }
        });
    }

    public static AuthnHelper getInstance(Context context) {
        if (c == null) {
            synchronized (AuthnHelper.class) {
                if (c == null) {
                    c = new AuthnHelper(context);
                }
            }
        }
        return c;
    }

    public static void setDebugMode(boolean z) {
        com.cmic.sso.sdk.e.c.a(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r7.a("systemEndTime", android.os.SystemClock.elapsedRealtime());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r7.a("endtime", com.cmic.sso.sdk.e.o.a());
        r0 = r7.c("logintype");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        if (r8 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        r8 = com.cmic.sso.sdk.auth.c.a(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r0 != 3) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        r6 = com.cmic.sso.sdk.auth.c.a(r5, r7, r8);
        r4.g.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r6 = com.cmic.sso.sdk.auth.c.a(r5, r6, r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r6.put("scripExpiresIn", java.lang.String.valueOf(com.cmic.sso.sdk.e.h.a()));
        r4.e.post(new com.cmic.sso.sdk.auth.AuthnHelper.AnonymousClass6(r4));
        com.cmic.sso.sdk.a.c.a(r4.b).a(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0070, code lost:
        if (r7.b().j() != false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007a, code lost:
        if (com.cmic.sso.sdk.e.q.a(r7.b()) != false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        a(r4.b, r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        if (com.cmic.sso.sdk.e.e.a() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0087, code lost:
        com.cmic.sso.sdk.e.n.a(new com.cmic.sso.sdk.auth.AuthnHelper.AnonymousClass7(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void callBackResult(java.lang.String r5, java.lang.String r6, com.cmic.sso.sdk.a r7, org.json.JSONObject r8) {
        /*
            r4 = this;
            java.lang.String r0 = "traceId"
            java.lang.String r0 = r7.b(r0)     // Catch:{ Exception -> 0x0093 }
            boolean r1 = com.cmic.sso.sdk.e.e.a(r0)     // Catch:{ Exception -> 0x0093 }
            if (r1 != 0) goto L_0x0097
            monitor-enter(r4)     // Catch:{ Exception -> 0x0093 }
            com.cmic.sso.sdk.auth.TokenListener r1 = com.cmic.sso.sdk.e.e.c(r0)     // Catch:{ all -> 0x0090 }
            com.cmic.sso.sdk.e.e.b(r0)     // Catch:{ all -> 0x0090 }
            if (r1 != 0) goto L_0x0018
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            return
        L_0x0018:
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = "systemEndTime"
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0093 }
            r7.a((java.lang.String) r0, (long) r2)     // Catch:{ Exception -> 0x0093 }
            java.lang.String r0 = "endtime"
            java.lang.String r2 = com.cmic.sso.sdk.e.o.a()     // Catch:{ Exception -> 0x0093 }
            r7.a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x0093 }
            java.lang.String r0 = "logintype"
            int r0 = r7.c(r0)     // Catch:{ Exception -> 0x0093 }
            if (r8 != 0) goto L_0x0037
            org.json.JSONObject r8 = com.cmic.sso.sdk.auth.c.a(r5, r6)     // Catch:{ Exception -> 0x0093 }
        L_0x0037:
            r2 = 3
            if (r0 != r2) goto L_0x0044
            org.json.JSONObject r6 = com.cmic.sso.sdk.auth.c.a(r5, r7, r8)     // Catch:{ Exception -> 0x0093 }
            com.cmic.sso.sdk.c r8 = r4.g     // Catch:{ Exception -> 0x0093 }
            r8.a()     // Catch:{ Exception -> 0x0093 }
            goto L_0x0048
        L_0x0044:
            org.json.JSONObject r6 = com.cmic.sso.sdk.auth.c.a(r5, r6, r7, r8)     // Catch:{ Exception -> 0x0093 }
        L_0x0048:
            java.lang.String r8 = "scripExpiresIn"
            long r2 = com.cmic.sso.sdk.e.h.a()     // Catch:{ Exception -> 0x0093 }
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0093 }
            r6.put(r8, r0)     // Catch:{ Exception -> 0x0093 }
            android.os.Handler r8 = r4.e     // Catch:{ Exception -> 0x0093 }
            com.cmic.sso.sdk.auth.AuthnHelper$6 r0 = new com.cmic.sso.sdk.auth.AuthnHelper$6     // Catch:{ Exception -> 0x0093 }
            r0.<init>(r1, r6)     // Catch:{ Exception -> 0x0093 }
            r8.post(r0)     // Catch:{ Exception -> 0x0093 }
            android.content.Context r6 = r4.b     // Catch:{ Exception -> 0x0093 }
            com.cmic.sso.sdk.a.c r6 = com.cmic.sso.sdk.a.c.a((android.content.Context) r6)     // Catch:{ Exception -> 0x0093 }
            r6.a((com.cmic.sso.sdk.a) r7)     // Catch:{ Exception -> 0x0093 }
            com.cmic.sso.sdk.a.a r6 = r7.b()     // Catch:{ Exception -> 0x0093 }
            boolean r6 = r6.j()     // Catch:{ Exception -> 0x0093 }
            if (r6 != 0) goto L_0x0081
            com.cmic.sso.sdk.a.a r6 = r7.b()     // Catch:{ Exception -> 0x0093 }
            boolean r6 = com.cmic.sso.sdk.e.q.a((com.cmic.sso.sdk.a.a) r6)     // Catch:{ Exception -> 0x0093 }
            if (r6 != 0) goto L_0x0081
            android.content.Context r6 = r4.b     // Catch:{ Exception -> 0x0093 }
            r4.a((android.content.Context) r6, (java.lang.String) r5, (com.cmic.sso.sdk.a) r7)     // Catch:{ Exception -> 0x0093 }
        L_0x0081:
            boolean r5 = com.cmic.sso.sdk.e.e.a()     // Catch:{ Exception -> 0x0093 }
            if (r5 == 0) goto L_0x0097
            com.cmic.sso.sdk.auth.AuthnHelper$7 r5 = new com.cmic.sso.sdk.auth.AuthnHelper$7     // Catch:{ Exception -> 0x0093 }
            r5.<init>()     // Catch:{ Exception -> 0x0093 }
            com.cmic.sso.sdk.e.n.a(r5)     // Catch:{ Exception -> 0x0093 }
            goto L_0x0097
        L_0x0090:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0090 }
            throw r5     // Catch:{ Exception -> 0x0093 }
        L_0x0093:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.sso.sdk.auth.AuthnHelper.callBackResult(java.lang.String, java.lang.String, com.cmic.sso.sdk.a, org.json.JSONObject):void");
    }

    public void delScrip() {
        try {
            h.a(true, true);
            com.cmic.sso.sdk.e.c.b("AuthnHelper", "删除scrip");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public JSONObject getNetworkType(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean a2 = m.a(this.b);
            com.cmic.sso.sdk.b.a.a().a(context, a2);
            String a3 = j.a().a((String) null);
            int a4 = m.a(context, a2, new com.cmic.sso.sdk.a(1));
            jSONObject.put("operatortype", a3);
            jSONObject.put("networktype", a4 + "");
            com.cmic.sso.sdk.e.c.b("AuthnHelper", "网络类型: " + a4);
            com.cmic.sso.sdk.e.c.b("AuthnHelper", "运营商类型: " + a3);
            return jSONObject;
        } catch (Exception unused) {
            try {
                jSONObject.put("errorDes", "发生未知错误");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    public void getPhoneInfo(String str, String str2, TokenListener tokenListener) {
        final com.cmic.sso.sdk.a a2 = a(tokenListener);
        final a aVar = new a(a2);
        this.e.postDelayed(aVar, this.d);
        final String str3 = str;
        final String str4 = str2;
        final TokenListener tokenListener2 = tokenListener;
        n.a(new n.a(this.b, a2) {
            public void a() {
                if (AuthnHelper.this.a(a2, str3, str4, "preGetMobile", 3, tokenListener2)) {
                    AuthnHelper.this.g.a(AuthnHelper.this.d);
                    AuthnHelper.this.a(a2, aVar);
                }
            }
        });
    }

    public void loginAuth(String str, String str2, TokenListener tokenListener) {
        final com.cmic.sso.sdk.a a2 = a(tokenListener);
        final a aVar = new a(a2);
        this.e.postDelayed(aVar, this.d);
        final String str3 = str;
        final String str4 = str2;
        final TokenListener tokenListener2 = tokenListener;
        n.a(new n.a(this.b, a2) {
            public void a() {
                if (AuthnHelper.this.a(a2, str3, str4, "loginAuth", 1, tokenListener2)) {
                    AuthnHelper.this.a(a2, aVar);
                }
            }
        });
    }

    public void mobileAuth(String str, String str2, TokenListener tokenListener) {
        final com.cmic.sso.sdk.a a2 = a(tokenListener);
        final a aVar = new a(a2);
        this.e.postDelayed(aVar, this.d);
        final String str3 = str;
        final String str4 = str2;
        final TokenListener tokenListener2 = tokenListener;
        n.a(new n.a(this.b, a2) {
            public void a() {
                if (AuthnHelper.this.a(a2, str3, str4, "mobileAuth", 0, tokenListener2)) {
                    AuthnHelper.this.a(a2, aVar);
                }
            }
        });
    }

    public void setOverTime(long j) {
        this.d = j;
    }

    /* access modifiers changed from: private */
    public void a() {
        String str = "%" + q.b();
        com.cmic.sso.sdk.e.c.b("AuthnHelper", "generate aid = " + str);
        k.a("AID", str);
    }

    private com.cmic.sso.sdk.a a(TokenListener tokenListener) {
        com.cmic.sso.sdk.a aVar = new com.cmic.sso.sdk.a(64);
        String c2 = q.c();
        aVar.a(new com.cmic.sso.sdk.d.a());
        aVar.a("traceId", c2);
        com.cmic.sso.sdk.e.c.a("traceId", c2);
        if (tokenListener != null) {
            e.a(c2, tokenListener);
        }
        return aVar;
    }

    public static AuthnHelper getInstance(Context context, String str) {
        if (c == null) {
            synchronized (AuthnHelper.class) {
                if (c == null) {
                    c = new AuthnHelper(context, str);
                }
            }
        }
        return c;
    }

    public AuthnHelper(Context context, String str) {
        this(context);
        this.f = str;
    }

    /* access modifiers changed from: private */
    public void a(com.cmic.sso.sdk.a aVar, final a aVar2) {
        this.a.a(aVar, new b() {
            public void a(String str, String str2, com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
                AuthnHelper.this.e.removeCallbacks(aVar2);
                AuthnHelper.this.callBackResult(str, str2, aVar, jSONObject);
            }
        });
    }

    /* access modifiers changed from: private */
    public synchronized boolean a(com.cmic.sso.sdk.a aVar, String str, String str2, String str3, int i2, TokenListener tokenListener) {
        String str4;
        String str5;
        com.cmic.sso.sdk.a.a a2 = com.cmic.sso.sdk.a.c.a(this.b).a();
        com.cmic.sso.sdk.e.c.b("AuthnHelper", "umcConfigBean = " + a2.toString());
        aVar.a(a2);
        aVar.a("use2048PublicKey", "rsa2048".equals(this.f));
        aVar.a("systemStartTime", SystemClock.elapsedRealtime());
        aVar.a("starttime", o.a());
        aVar.a("loginMethod", str3);
        aVar.a(com.alipay.sdk.m.s.a.r, str2);
        aVar.a("appid", str);
        aVar.a("timeOut", String.valueOf(this.d));
        boolean a3 = m.a(this.b);
        com.cmic.sso.sdk.b.a.a().a(this.b, a3);
        String b2 = j.a().b();
        String c2 = j.a().c();
        String a4 = j.a().a(c2);
        aVar.a("operator", c2);
        aVar.a("operatortype", a4);
        aVar.a("logintype", i2);
        com.cmic.sso.sdk.e.c.b("AuthnHelper", "subId = " + b2);
        if (!TextUtils.isEmpty(b2)) {
            com.cmic.sso.sdk.e.c.a("AuthnHelper", "使用subId作为缓存key = " + b2);
            aVar.a("scripType", "subid");
            aVar.a("scripKey", b2);
        } else if (!TextUtils.isEmpty(c2)) {
            com.cmic.sso.sdk.e.c.a("AuthnHelper", "使用operator作为缓存key = " + c2);
            aVar.a("scripType", "operator");
            aVar.a("scripKey", c2);
        }
        int a5 = m.a(this.b, a3, aVar);
        aVar.a("networktype", a5);
        if (!a3) {
            aVar.a("authType", String.valueOf(0));
            callBackResult("200010", "无法识别sim卡或没有sim卡", aVar, (JSONObject) null);
            return false;
        } else if (tokenListener == null) {
            callBackResult("102203", "listener不能为空", aVar, (JSONObject) null);
            return false;
        } else if (a2.g()) {
            callBackResult("200082", "服务器繁忙，请稍后重试", aVar, (JSONObject) null);
            return false;
        } else {
            if (str == null) {
                str4 = "";
            } else {
                str4 = str.trim();
            }
            if (TextUtils.isEmpty(str4)) {
                callBackResult("102203", "appId 不能为空", aVar, (JSONObject) null);
                return false;
            }
            if (str2 == null) {
                str5 = "";
            } else {
                str5 = str2.trim();
            }
            if (TextUtils.isEmpty(str5)) {
                callBackResult("102203", "appkey不能为空", aVar, (JSONObject) null);
                return false;
            } else if (a5 == 0) {
                callBackResult("102101", "未检测到网络", aVar, (JSONObject) null);
                return false;
            } else if ("2".equals(a4) && a2.f()) {
                callBackResult("200082", "服务器繁忙，请稍后重试", aVar, (JSONObject) null);
                return false;
            } else if (!"3".equals(a4) || !a2.e()) {
                return true;
            } else {
                callBackResult("200082", "服务器繁忙，请稍后重试", aVar, (JSONObject) null);
                return false;
            }
        }
    }

    private void a(final Context context, final String str, final com.cmic.sso.sdk.a aVar) {
        n.a(new n.a() {
            public void a() {
                if ("200023".equals(str)) {
                    SystemClock.sleep(10000);
                }
                new com.cmic.sso.sdk.d.b().a(context, str, aVar);
            }
        });
    }
}
