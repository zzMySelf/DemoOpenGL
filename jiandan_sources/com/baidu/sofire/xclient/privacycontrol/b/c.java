package com.baidu.sofire.xclient.privacycontrol.b;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;

public class c {
    public static final long m = TimeUnit.DAYS.toMinutes(1);
    public static final /* synthetic */ int n = 0;
    public int a = 1;
    public ArrayList<String> b;
    public ArrayList<String> c;
    public boolean d = true;
    public boolean e = true;
    public boolean f = false;
    public boolean g = false;
    public long h = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1097i = false;
    public ArrayList<String> j;
    public ArrayList<String> k;
    public ArrayList<String> l;

    public static c a() {
        c cVar = new c();
        cVar.d = false;
        cVar.a = 0;
        return cVar;
    }

    public static ArrayList<String> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add(jSONArray.optString(i2));
        }
        return arrayList;
    }

    public String toString() {
        return "ControlPolicy{state=" + this.a + ", controlPkgList=" + this.b + ", blackPkgList=" + this.c + ", onlyForeground=" + this.e + ", cacheInterval=" + this.h + ", isReportStack=" + this.f1097i + ", reportStackPkgList=" + this.j + ", stackMd5List=" + this.k + ", isReport=" + this.d + ExtendedMessageFormat.END_FE;
    }
}
