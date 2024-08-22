package com.baidu.clientupdate.a;

import java.io.Serializable;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;

public class a implements Serializable {
    public String a;
    public String b;
    public String c;
    public String d;
    public JSONArray e;
    public JSONArray f;
    public JSONArray g;
    public JSONArray h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f746i;

    public a() {
    }

    public a(String str, String str2, String str3, String str4, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4, JSONArray jSONArray5) {
        this.b = str;
        this.d = str2;
        this.a = str3;
        this.c = str4;
        this.e = jSONArray;
        this.f = jSONArray2;
        this.g = jSONArray3;
        this.h = jSONArray4;
        this.f746i = jSONArray5;
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.c;
    }

    public JSONArray c() {
        return this.e;
    }

    public JSONArray d() {
        return this.f;
    }

    public JSONArray e() {
        return this.g;
    }

    public JSONArray f() {
        return this.h;
    }

    public JSONArray g() {
        return this.f746i;
    }

    public String toString() {
        return "LogModel{sessioninfo='" + this.a + ExtendedMessageFormat.QUOTE + ", ug='" + this.b + ExtendedMessageFormat.QUOTE + ", nm='" + this.c + ExtendedMessageFormat.QUOTE + ", flag='" + this.d + ExtendedMessageFormat.QUOTE + ", stm=" + this.e + ", sc=" + this.f + ", etm=" + this.g + ", mg=" + this.h + ", ex=" + this.f746i + ExtendedMessageFormat.END_FE;
    }
}
