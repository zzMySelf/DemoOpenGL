package com.dlife.ctaccountapi;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.tera.scan.component.base.ui.dialog.CustomListAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class b {
    public String a = "1.1";
    public String b;
    public String c = "";
    public String d;
    public String e = "";
    public String f;
    public String g;
    public String h;

    /* renamed from: i  reason: collision with root package name */
    public String f3779i;
    public String j;
    public String k;
    public String l;
    public String m = "";
    public String n = "";

    /* renamed from: o  reason: collision with root package name */
    public int f3780o;
    public String p = "";
    public long q;
    public long r;
    public String s;
    public StringBuffer t = new StringBuffer();
    public long u;
    public long v;
    public String w;

    public b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.u = currentTimeMillis;
        this.b = a(currentTimeMillis);
        this.d = "";
        this.f = "";
        this.g = Build.BRAND;
        this.h = Build.MODEL;
        this.f3779i = "Android";
        this.j = Build.VERSION.RELEASE;
        this.k = "SDK-JJ-v4.5.0";
        this.l = str;
        this.s = "0";
        this.w = "";
    }

    public static String a(long j2) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA).format(new Date(j2));
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public b a(int i2) {
        this.f3780o = i2;
        return this;
    }

    public b a(String str) {
        StringBuffer stringBuffer = this.t;
        stringBuffer.append(str);
        stringBuffer.append(StringUtils.LF);
        return this;
    }

    public b b(long j2) {
        this.q = j2;
        return this;
    }

    public b b(String str) {
        this.w = str;
        return this;
    }

    public b c(String str) {
        this.m = str;
        return this;
    }

    public b d(String str) {
        this.d = str;
        return this;
    }

    public b e(String str) {
        this.e = str;
        return this;
    }

    public b f(String str) {
        this.p = str;
        return this;
    }

    public b g(String str) {
        this.f = str;
        return this;
    }

    public b h(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.s = str;
        }
        return this;
    }

    public b i(String str) {
        this.n = str;
        return this;
    }

    public String toString() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.v = currentTimeMillis;
            this.r = currentTimeMillis - this.u;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(v.d, this.a);
            jSONObject.put(t.a, this.b);
            jSONObject.put(CustomListAdapter.VIEW_TAG, this.c);
            jSONObject.put("ai", this.d);
            jSONObject.put("di", this.e);
            jSONObject.put("ns", this.f);
            jSONObject.put("br", this.g);
            jSONObject.put("ml", this.h);
            jSONObject.put(UrlOcrConfig.IdCardKey.OS, this.f3779i);
            jSONObject.put("ov", this.j);
            jSONObject.put(a.t, this.k);
            jSONObject.put("ri", this.l);
            jSONObject.put("api", this.m);
            jSONObject.put("p", this.n);
            jSONObject.put("rt", this.f3780o);
            jSONObject.put("msg", this.p);
            jSONObject.put("st", this.q);
            jSONObject.put("tt", this.r);
            jSONObject.put("ot", this.s);
            jSONObject.put("ep", this.t.toString());
            jSONObject.put("aip", this.w);
            return jSONObject.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }
}
