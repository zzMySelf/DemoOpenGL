package com.cmic.sso.sdk.auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.c.c.d;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.e;
import com.cmic.sso.sdk.e.h;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.l;
import java.util.UUID;
import org.json.JSONObject;

public class a {
    @SuppressLint({"StaticFieldLeak"})
    public static a c;
    public final com.cmic.sso.sdk.c.c.a a;
    public final Context b;
    public final Object d = new Object();

    public a(Context context) {
        this.b = context.getApplicationContext();
        this.a = com.cmic.sso.sdk.c.c.a.a();
    }

    private void b(final com.cmic.sso.sdk.a aVar, final b bVar) {
        c.b("AuthnBusiness", "getScripAndToken start");
        boolean b2 = aVar.b("isGotScrip", false);
        c.b("AuthnBusiness", "isGotScrip = " + b2);
        if (!b2) {
            b(aVar);
            if (!aVar.b("isCacheScrip", false)) {
                c(aVar);
                if (aVar.c("networktype") == 3 && aVar.c("logintype") != 3) {
                    aVar.a("isRisk", true);
                }
            }
            if (aVar.c("logintype") == 1) {
                aVar.a("userCapaid", "200");
            } else if (aVar.c("logintype") == 0) {
                aVar.a("userCapaid", "50");
            }
        }
        this.a.a(aVar, new d() {
            public void a(String str, String str2, JSONObject jSONObject) {
                a.this.a(aVar, bVar, str, str2, jSONObject);
            }
        });
    }

    private void c(com.cmic.sso.sdk.a aVar) {
        byte[] bArr = new byte[0];
        if (aVar.b("use2048PublicKey", false)) {
            c.a("AuthnBusiness", "使用2048公钥对应的对称秘钥生成方式");
            bArr = com.cmic.sso.sdk.e.a.a();
        } else {
            c.a("AuthnBusiness", "使用1024公钥对应的对称秘钥生成方式");
            try {
                bArr = UUID.randomUUID().toString().substring(0, 16).getBytes(com.baidu.apollon.heartbeat.a.h);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        byte[] a2 = com.cmic.sso.sdk.e.a.a();
        aVar.a(b.a.a, bArr);
        aVar.a(b.a.b, a2);
        aVar.a("authType", "3");
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }

    public void a(com.cmic.sso.sdk.a aVar, b bVar) {
        if (!e.a(aVar.b("traceId"))) {
            c.b("AuthnBusiness", "LoginCheck method start");
            if (a(aVar)) {
                c.b("AuthnBusiness", "LoginCheck method start");
                int c2 = aVar.c("logintype");
                if (aVar.b("isCacheScrip", false)) {
                    String b2 = aVar.b("securityphone", "");
                    if (c2 == 3) {
                        bVar.a("103000", "true", aVar, c.a(b2));
                    } else {
                        b(aVar, bVar);
                    }
                } else {
                    b(aVar, bVar);
                }
            } else {
                bVar.a("102103", "无数据网络", aVar, (JSONObject) null);
            }
        }
    }

    private void b(com.cmic.sso.sdk.a aVar) {
        String packageName = this.b.getPackageName();
        String a2 = com.cmic.sso.sdk.e.d.a(l.a(this.b, packageName));
        aVar.a("apppackage", packageName);
        aVar.a("appsign", a2);
    }

    private boolean a(com.cmic.sso.sdk.a aVar) {
        boolean a2;
        synchronized (this.d) {
            a2 = h.a(aVar);
            if (a2) {
                aVar.a("securityphone", k.b("securityphone", ""));
                if (3 != aVar.c("logintype")) {
                    String a3 = h.a(this.b);
                    StringBuilder sb = new StringBuilder();
                    sb.append("解密phoneScript ");
                    sb.append(!TextUtils.isEmpty(a3));
                    c.b("AuthnBusiness", sb.toString());
                    if (!TextUtils.isEmpty(a3)) {
                        aVar.a("phonescrip", a3);
                    } else {
                        a2 = false;
                    }
                    h.a(true, false);
                }
            }
            aVar.a("isCacheScrip", a2);
            c.b("AuthnBusiness", "isCachePhoneScrip = " + a2);
        }
        if (aVar.c("networktype") == 2) {
            return a2;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.cmic.sso.sdk.a r21, com.cmic.sso.sdk.auth.b r22, java.lang.String r23, java.lang.String r24, org.json.JSONObject r25) {
        /*
            r20 = this;
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r0 = r25
            java.lang.String r5 = "openId"
            java.lang.String r6 = "phonescrip"
            java.lang.String r7 = "securityphone"
            java.lang.String r8 = "103000"
            boolean r8 = r8.equals(r3)
            java.lang.String r9 = "true"
            r10 = 3
            java.lang.String r11 = "logintype"
            if (r8 == 0) goto L_0x0113
            java.lang.String r8 = "resultdata"
            java.lang.String r8 = r0.optString(r8)
            boolean r12 = android.text.TextUtils.isEmpty(r8)
            if (r12 == 0) goto L_0x002e
            java.lang.String r0 = r25.toString()
            goto L_0x003e
        L_0x002e:
            java.lang.String r0 = com.cmic.sso.sdk.b.a.a
            byte[] r0 = r1.a((java.lang.String) r0)
            java.lang.String r12 = com.cmic.sso.sdk.b.a.b
            byte[] r12 = r1.a((java.lang.String) r12)
            java.lang.String r0 = com.cmic.sso.sdk.e.a.b(r0, r8, r12)
        L_0x003e:
            r8 = 0
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0075 }
            r12.<init>(r0)     // Catch:{ JSONException -> 0x0075 }
            java.lang.String r13 = r12.optString(r6)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r14 = r12.optString(r7)     // Catch:{ JSONException -> 0x006a }
            java.lang.String r8 = r12.optString(r5)     // Catch:{ JSONException -> 0x0062 }
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x0062 }
            if (r0 == 0) goto L_0x005c
            java.lang.String r0 = "pcid"
            java.lang.String r8 = r12.optString(r0)     // Catch:{ JSONException -> 0x0062 }
        L_0x005c:
            com.cmic.sso.sdk.e.k.a((java.lang.String) r7, (java.lang.String) r14)     // Catch:{ JSONException -> 0x0062 }
            r0 = r14
            r14 = r13
            goto L_0x0083
        L_0x0062:
            r0 = move-exception
            r19 = r13
            r13 = r0
            r0 = r8
            r8 = r19
            goto L_0x007a
        L_0x006a:
            r0 = move-exception
            r14 = r8
            r8 = r13
            r13 = r0
            r0 = r14
            goto L_0x007a
        L_0x0070:
            r0 = move-exception
            r13 = r0
            r0 = r8
            r14 = r0
            goto L_0x007a
        L_0x0075:
            r0 = move-exception
            r13 = r0
            r0 = r8
            r12 = r0
            r14 = r12
        L_0x007a:
            r13.printStackTrace()
            r19 = r8
            r8 = r0
            r0 = r14
            r14 = r19
        L_0x0083:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r15 = "securityPhone  = "
            r13.append(r15)
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.String r15 = "AuthnBusiness"
            com.cmic.sso.sdk.e.c.b(r15, r13)
            r1.a((java.lang.String) r5, (java.lang.String) r8)
            r1.a((java.lang.String) r6, (java.lang.String) r14)
            r1.a((java.lang.String) r7, (java.lang.String) r0)
            if (r12 == 0) goto L_0x00f7
            java.lang.String r5 = "isRisk"
            r6 = 0
            boolean r7 = r1.b((java.lang.String) r5, (boolean) r6)
            if (r7 != 0) goto L_0x00cf
            r7 = r20
            android.content.Context r13 = r7.b
            java.lang.String r8 = "scripExpiresIn"
            java.lang.String r15 = "0"
            java.lang.String r8 = r12.optString(r8, r15)
            long r15 = java.lang.Long.parseLong(r8)
            java.lang.String r8 = "scripKey"
            java.lang.String r6 = ""
            java.lang.String r17 = r1.b((java.lang.String) r8, (java.lang.String) r6)
            java.lang.String r8 = "scripType"
            java.lang.String r18 = r1.b((java.lang.String) r8, (java.lang.String) r6)
            com.cmic.sso.sdk.e.h.a(r13, r14, r15, r17, r18)
            goto L_0x00d1
        L_0x00cf:
            r7 = r20
        L_0x00d1:
            int r6 = r1.c(r11)
            if (r6 != r10) goto L_0x00df
            org.json.JSONObject r0 = com.cmic.sso.sdk.auth.c.a(r0)
            r2.a(r3, r9, r1, r0)
            goto L_0x0126
        L_0x00df:
            r0 = 0
            boolean r6 = r1.b((java.lang.String) r5, (boolean) r0)
            if (r6 == 0) goto L_0x00f3
            r1.a((java.lang.String) r5, (boolean) r0)
            r0 = 1
            java.lang.String r3 = "isGotScrip"
            r1.a((java.lang.String) r3, (boolean) r0)
            r20.b(r21, r22)
            goto L_0x0126
        L_0x00f3:
            r2.a(r3, r4, r1, r12)
            goto L_0x0126
        L_0x00f7:
            r7 = r20
            java.lang.String r0 = "返回103000，但是数据解析出错"
            com.cmic.sso.sdk.e.c.a(r15, r0)
            r0 = 102223(0x18f4f, float:1.43245E-40)
            java.lang.String r3 = java.lang.String.valueOf(r0)
            java.lang.String r4 = "数据解析异常"
            org.json.JSONObject r3 = com.cmic.sso.sdk.auth.c.a(r3, r4)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.a(r0, r4, r1, r3)
            return
        L_0x0113:
            r7 = r20
            int r5 = r1.c(r11)
            if (r5 != r10) goto L_0x0123
            org.json.JSONObject r0 = com.cmic.sso.sdk.auth.c.b(r23, r24)
            r2.a(r3, r9, r1, r0)
            goto L_0x0126
        L_0x0123:
            r2.a(r3, r4, r1, r0)
        L_0x0126:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.sso.sdk.auth.a.a(com.cmic.sso.sdk.a, com.cmic.sso.sdk.auth.b, java.lang.String, java.lang.String, org.json.JSONObject):void");
    }
}
