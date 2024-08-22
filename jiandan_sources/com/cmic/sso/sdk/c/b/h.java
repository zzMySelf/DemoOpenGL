package com.cmic.sso.sdk.c.b;

import com.alipay.sdk.m.s.a;
import org.json.JSONException;
import org.json.JSONObject;

public class h extends a {
    public String y = "";
    public String z = "";

    public void a(String str) {
        this.v = t(str);
    }

    public String a_(String str) {
        return this.b + this.c + this.d + this.e + this.f + this.g + this.h + this.f3774i + this.j + this.m + this.n + str + this.f3775o + this.q + this.r + this.s + this.t + this.u + this.v + this.y + this.z + this.w + this.x;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.a);
            jSONObject.put("sdkver", this.b);
            jSONObject.put("appid", this.c);
            jSONObject.put("imsi", this.d);
            jSONObject.put("operatortype", this.e);
            jSONObject.put("networktype", this.f);
            jSONObject.put("mobilebrand", this.g);
            jSONObject.put("mobilemodel", this.h);
            jSONObject.put("mobilesystem", this.f3774i);
            jSONObject.put("clienttype", this.j);
            jSONObject.put("interfacever", this.k);
            jSONObject.put("expandparams", this.l);
            jSONObject.put("msgid", this.m);
            jSONObject.put("timestamp", this.n);
            jSONObject.put("subimsi", this.f3775o);
            jSONObject.put("sign", this.p);
            jSONObject.put("apppackage", this.q);
            jSONObject.put("appsign", this.r);
            jSONObject.put("ipv4_list", this.s);
            jSONObject.put("ipv6_list", this.t);
            jSONObject.put("sdkType", this.u);
            jSONObject.put("tempPDR", this.v);
            jSONObject.put("scrip", this.y);
            jSONObject.put("userCapaid", this.z);
            jSONObject.put("funcType", this.w);
            jSONObject.put("socketip", this.x);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return this.a + a.n + this.b + a.n + this.c + a.n + this.d + a.n + this.e + a.n + this.f + a.n + this.g + a.n + this.h + a.n + this.f3774i + a.n + this.j + a.n + this.k + a.n + this.l + a.n + this.m + a.n + this.n + a.n + this.f3775o + a.n + this.p + a.n + this.q + a.n + this.r + "&&" + this.s + a.n + this.t + a.n + this.u + a.n + this.v + a.n + this.y + a.n + this.z + a.n + this.w + a.n + this.x;
    }

    public void w(String str) {
        this.y = t(str);
    }

    public void x(String str) {
        this.z = t(str);
    }
}
