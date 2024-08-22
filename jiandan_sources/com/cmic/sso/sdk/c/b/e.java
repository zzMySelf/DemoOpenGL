package com.cmic.sso.sdk.c.b;

import android.util.Base64;
import com.cmic.sso.sdk.e.a;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends g {
    public a a;
    public byte[] b;
    public String c;
    public byte[] d;
    public String e;
    public boolean f = false;

    public void a(boolean z) {
        this.f = z;
    }

    public String a_(String str) {
        return null;
    }

    public void b(String str) {
        this.e = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void a(byte[] bArr) {
        this.b = bArr;
    }

    public void b(byte[] bArr) {
        this.d = bArr;
    }

    public a c() {
        return this.a;
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        if (this.f) {
            try {
                jSONObject.put("encrypted", this.c);
                jSONObject.put("encryptedIV", Base64.encodeToString(this.d, 0));
                jSONObject.put("reqdata", a.a(this.b, this.a.toString(), this.d));
                jSONObject.put("securityreinforce", this.e);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public String a() {
        return this.a.a();
    }
}
