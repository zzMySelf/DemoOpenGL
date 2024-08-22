package com.cmic.sso.sdk.a;

import android.text.TextUtils;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.cmic.sso.sdk.a.a;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.c.c.d;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.n;
import org.json.JSONObject;

public class b {
    public static b c;
    public a a;
    public final a b;
    public volatile boolean d = false;
    public a e;

    public interface a {
        void a(a aVar);
    }

    public b(boolean z) {
        a a2 = new a.C0177a().a();
        this.b = a2;
        if (!z) {
            this.a = d();
        } else {
            this.a = a2;
        }
    }

    /* access modifiers changed from: private */
    public a d() {
        return new a.C0177a().a(d.b(this.b.a())).c(d.a(this.b.c())).b(d.b(this.b.b())).d(d.c(this.b.d())).d(d.a(this.b.h())).e(d.b(this.b.i())).a(d.e(this.b.e())).b(d.d(this.b.f())).c(d.c(this.b.g())).f(d.f(this.b.j())).a(d.a(this.b.k())).b(d.b(this.b.l())).a();
    }

    /* access modifiers changed from: private */
    public void b(com.cmic.sso.sdk.a aVar) {
        if (this.d) {
            c.a("UmcConfigHandle", "正在获取配置中...");
            return;
        }
        this.d = true;
        com.cmic.sso.sdk.c.c.a.a().a(false, aVar, (d) new d() {
            public void a(String str, String str2, JSONObject jSONObject) {
                try {
                    if ("103000".equals(str)) {
                        b.this.a(jSONObject);
                        k.a("sdk_config_version", AuthnHelper.SDK_VERSION);
                        b bVar = b.this;
                        a unused = bVar.a = bVar.d();
                        if (b.this.e != null) {
                            b.this.e.a(b.this.a);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                boolean unused2 = b.this.d = false;
            }
        });
    }

    public void c() {
        k.a b2 = k.b("sso_config_xf");
        b2.c();
        b2.b();
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public a b() {
        return this.a;
    }

    public static b a(boolean z) {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b(z);
                }
            }
        }
        return c;
    }

    public a a() {
        return this.b;
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        k.a b2 = k.b("sso_config_xf");
        try {
            if (jSONObject2.has("client_valid")) {
                b2.a("client_valid", System.currentTimeMillis() + (((long) Integer.parseInt(jSONObject2.getString("client_valid"))) * 60 * 60 * 1000));
            }
            if (jSONObject2.has("Configlist")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("Configlist");
                if (jSONObject3.has("CHANGE_HOST")) {
                    String string = jSONObject3.getString("CHANGE_HOST");
                    if (string.contains("M007")) {
                        String a2 = a(string, "M007");
                        if (!TextUtils.isEmpty(a2)) {
                            b2.a("logHost", a2);
                        }
                    }
                    if (string.contains("M008")) {
                        String a3 = a(string, "M008");
                        if (!TextUtils.isEmpty(a3)) {
                            b2.a("https_get_phone_scrip_host", a3);
                        }
                    }
                    if (string.contains("M009")) {
                        String a4 = a(string, "M009");
                        if (!TextUtils.isEmpty(a4)) {
                            b2.a("config_host", a4);
                        }
                    }
                } else {
                    b2.a("logHost");
                    b2.a("https_get_phone_scrip_host");
                    b2.a("config_host");
                }
                a(jSONObject3, "CLOSE_FRIEND_WAPKS", "0", b2);
                a(jSONObject3, "CLOSE_LOGS_VERSION", "0", b2);
                a(jSONObject3, "CLOSE_IPV4_LIST", "0", b2);
                a(jSONObject3, "CLOSE_IPV6_LIST", "0", b2);
                a(jSONObject3, "CLOSE_M008_SDKVERSION_LIST", "0", b2);
                a(jSONObject3, "CLOSE_M008_APPID_LIST", "0", b2);
                if (jSONObject3.has("LOGS_CONTROL")) {
                    String[] split = jSONObject3.getString("LOGS_CONTROL").replace("h", "").split(com.alipay.sdk.m.s.a.n);
                    if (split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                        try {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            b2.a("maxFailedLogTimes", parseInt);
                            b2.a("pauseTime", parseInt2);
                        } catch (Exception unused) {
                            c.a("UmcConfigHandle", "解析日志上报限制时间次数异常");
                        }
                    }
                } else {
                    b2.a("maxFailedLogTimes");
                    b2.a("pauseTime");
                }
            }
            b2.b();
        } catch (Exception e2) {
            c.a("UmcConfigHandle", "配置项异常，配置失效");
            e2.printStackTrace();
        }
    }

    private String a(String str, String str2) {
        String str3;
        String[] split = str.split(com.alipay.sdk.m.s.a.n);
        int length = split.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str3 = "";
                break;
            }
            str3 = split[i2];
            if (str3.contains(str2)) {
                break;
            }
            i2++;
        }
        return !TextUtils.isEmpty(str3) ? str3.substring(str3.lastIndexOf("=") + 1) : str3;
    }

    private void a(JSONObject jSONObject, String str, String str2, k.a aVar) {
        if (jSONObject.has(str)) {
            String optString = jSONObject.optString(str, str2);
            if (!"CLOSE_FRIEND_WAPKS".equals(str)) {
                if (!"0".equals(optString) && !"1".equals(optString)) {
                    return;
                }
            } else if (TextUtils.isEmpty(optString)) {
                return;
            } else {
                if (!optString.contains(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC) && !optString.contains(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC) && !optString.contains(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                    return;
                }
            }
            aVar.a(str, jSONObject.optString(str, str2));
            return;
        }
        aVar.a(str);
    }

    public void a(final com.cmic.sso.sdk.a aVar) {
        if (d.a()) {
            n.a(new n.a() {
                public void a() {
                    c.b("UmcConfigHandle", "开始拉取配置..");
                    b.this.b(aVar);
                }
            });
        }
    }
}
