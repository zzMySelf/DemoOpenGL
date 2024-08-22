package com.sdk.o;

import android.net.Uri;
import com.sdk.f.b;
import com.sdk.r.d;
import java.util.List;

public class b {
    public static com.sdk.f.b a;

    public static com.sdk.f.b a() {
        if (a == null) {
            b();
        }
        return a;
    }

    public static void a(String str) {
        if (a.b(str).booleanValue() && a.a(a.c).booleanValue()) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("sequenceNumber");
            String queryParameter2 = parse.getQueryParameter("ret_url");
            if (a.b(queryParameter2).booleanValue()) {
                queryParameter = Uri.parse(d.a(queryParameter2)).getQueryParameter("seq");
            }
            a.c = queryParameter;
        }
    }

    public static void b() {
        a = new com.sdk.f.b();
    }

    public static void b(String str) {
        try {
            List<String> list = a.b.b;
            list.add(str);
            a.b.b = list;
        } catch (Throwable unused) {
        }
    }

    public static void c(String str) {
        try {
            List<String> list = a.b.c;
            list.add(str);
            a.b.c = list;
        } catch (Throwable unused) {
        }
    }

    public static void d(String str) {
        try {
            a.b.d = str;
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, long j) {
        try {
            a(str);
            List<b.a.C0261a> list = a.b.a;
            b.a.C0261a aVar = new b.a.C0261a();
            aVar.a = str;
            aVar.b = j;
            list.add(aVar);
            a.b.a = list;
        } catch (Throwable unused) {
        }
    }
}
