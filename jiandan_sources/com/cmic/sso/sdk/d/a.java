package com.cmic.sso.sdk.d;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.wallet.api.IWalletLoginListener;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.c.b.g;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends g {
    public String A;
    public CopyOnWriteArrayList<Throwable> a = new CopyOnWriteArrayList<>();
    public String b = null;
    public String c = null;
    public String d = null;
    public String e = null;
    public String f = null;
    public String g = null;
    public String h = null;

    /* renamed from: i  reason: collision with root package name */
    public String f3777i = null;
    public String j = null;
    public String k = "";
    public String l = null;
    public String m = null;
    public String n = null;

    /* renamed from: o  reason: collision with root package name */
    public JSONArray f3778o;
    public String p = null;
    public String q = null;
    public String r = null;
    public String s = null;
    public String t = null;
    public String u = null;
    public String v = null;
    public String w = null;
    public String x;
    public String y;
    public String z;

    public void A(String str) {
        this.A = str;
    }

    public String a() {
        return null;
    }

    public void a(JSONArray jSONArray) {
        this.f3778o = jSONArray;
    }

    public String a_(String str) {
        return null;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.v = str;
    }

    public void d(String str) {
        this.w = str;
    }

    public void e(String str) {
        this.r = str;
    }

    public void f(String str) {
        this.m = str;
    }

    public void g(String str) {
        this.l = str;
    }

    public void h(String str) {
        this.k = str;
    }

    public void i(String str) {
        this.d = str;
    }

    public void j(String str) {
        this.e = str;
    }

    public void k(String str) {
        this.f = str;
    }

    public void l(String str) {
        this.f3777i = str;
    }

    public void m(String str) {
        this.u = str;
    }

    public void n(String str) {
        this.p = str;
    }

    public void o(String str) {
        this.s = str;
    }

    public void p(String str) {
        this.t = str;
    }

    public void q(String str) {
        this.n = str;
    }

    public void r(String str) {
        this.c = str;
    }

    public void s(String str) {
        this.g = str;
    }

    public void t(String str) {
        this.h = str;
    }

    public void u(String str) {
        this.j = str;
    }

    public void w(String str) {
        this.q = str;
    }

    public void x(String str) {
        this.x = str;
    }

    public void y(String str) {
        this.y = str;
    }

    public void z(String str) {
        this.z = str;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.b);
            jSONObject.put("traceId", this.c);
            jSONObject.put("appName", this.d);
            jSONObject.put("appVersion", this.e);
            jSONObject.put("sdkVersion", AuthnHelper.SDK_VERSION);
            jSONObject.put("clientType", SapiDeviceInfo.OS_TYPE);
            jSONObject.put("timeOut", this.f);
            jSONObject.put("requestTime", this.g);
            jSONObject.put("responseTime", this.h);
            jSONObject.put("elapsedTime", this.f3777i);
            jSONObject.put("requestType", this.j);
            jSONObject.put("interfaceType", this.k);
            jSONObject.put("interfaceCode", this.l);
            jSONObject.put("interfaceElasped", this.m);
            jSONObject.put(IWalletLoginListener.KEY_LOGIN_TYPE, this.n);
            jSONObject.put("exceptionStackTrace", this.f3778o);
            jSONObject.put("operatorType", this.p);
            jSONObject.put("networkType", this.q);
            jSONObject.put(UrlOcrConfig.IdCardKey.OS_BRAND, this.r);
            jSONObject.put("reqDevice", this.s);
            jSONObject.put("reqSystem", this.t);
            jSONObject.put("simCardNum", this.u);
            jSONObject.put("imsiState", this.v);
            jSONObject.put("resultCode", this.w);
            jSONObject.put("AID", this.x);
            jSONObject.put("sysOperType", this.y);
            jSONObject.put("scripType", this.z);
            if (!TextUtils.isEmpty(this.A)) {
                jSONObject.put("networkTypeByAPI", this.A);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
