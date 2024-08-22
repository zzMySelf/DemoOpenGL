package com.cmic.sso.sdk.c.b;

import androidx.core.net.MailTo;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends g {
    public b a;
    public a b;

    public static class a {
        public JSONObject a;

        public JSONObject a() {
            return this.a;
        }

        public void a(JSONObject jSONObject) {
            this.a = jSONObject;
        }
    }

    public static class b extends g {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;

        public String a_(String str) {
            return this.e + this.d + this.c + this.b + "@Fdiwmxy7CBDDQNUI";
        }

        public JSONObject b() {
            return null;
        }

        public void b(String str) {
            this.e = str;
        }

        public String c() {
            return this.e;
        }

        public String d() {
            return this.a;
        }

        public String e() {
            return this.b;
        }

        public String f() {
            return this.c;
        }

        public String a() {
            return this.d;
        }

        public void c(String str) {
            this.d = str;
        }

        public void d(String str) {
            this.a = str;
        }

        public void e(String str) {
            this.b = str;
        }

        public void f(String str) {
            this.c = str;
        }
    }

    public void a(b bVar) {
        this.a = bVar;
    }

    public String a_(String str) {
        return null;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.a.d());
            jSONObject2.put("msgid", this.a.e());
            jSONObject2.put("systemtime", this.a.f());
            jSONObject2.put("appid", this.a.a());
            jSONObject2.put("version", this.a.c());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put("log", this.b.a());
            jSONObject.put(MailTo.BODY, jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public String a() {
        return this.a.d;
    }
}
