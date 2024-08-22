package com.cmic.sso.sdk.c.b;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LogReportParameter */
public class f extends g {

    /* renamed from: a  reason: collision with root package name */
    private b f4349a;

    /* renamed from: b  reason: collision with root package name */
    private a f4350b;

    /* compiled from: LogReportParameter */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private JSONObject f4351a;

        public JSONObject a() {
            return this.f4351a;
        }

        public void a(JSONObject jSONObject) {
            this.f4351a = jSONObject;
        }
    }

    /* compiled from: LogReportParameter */
    public static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        private String f4352a;

        /* renamed from: b  reason: collision with root package name */
        private String f4353b;

        /* renamed from: c  reason: collision with root package name */
        private String f4354c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f4355d;

        /* renamed from: e  reason: collision with root package name */
        private String f4356e;

        /* access modifiers changed from: protected */
        public String a_(String str) {
            return this.f4356e + this.f4355d + this.f4354c + this.f4353b + "@Fdiwmxy7CBDDQNUI";
        }

        public JSONObject b() {
            return null;
        }

        public void b(String str) {
            this.f4356e = str;
        }

        public String c() {
            return this.f4356e;
        }

        public String d() {
            return this.f4352a;
        }

        public String e() {
            return this.f4353b;
        }

        public String f() {
            return this.f4354c;
        }

        public String a() {
            return this.f4355d;
        }

        public void c(String str) {
            this.f4355d = str;
        }

        public void d(String str) {
            this.f4352a = str;
        }

        public void e(String str) {
            this.f4353b = str;
        }

        public void f(String str) {
            this.f4354c = str;
        }
    }

    public void a(b bVar) {
        this.f4349a = bVar;
    }

    /* access modifiers changed from: protected */
    public String a_(String str) {
        return null;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.f4349a.d());
            jSONObject2.put("msgid", this.f4349a.e());
            jSONObject2.put("systemtime", this.f4349a.f());
            jSONObject2.put("appid", this.f4349a.a());
            jSONObject2.put("version", this.f4349a.c());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put("log", this.f4350b.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(a aVar) {
        this.f4350b = aVar;
    }

    public String a() {
        return this.f4349a.f4355d;
    }
}
