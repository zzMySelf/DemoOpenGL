package com.sdk.s;

import com.sdk.q.b;
import com.sdk.r.e;

public class a {
    public String a(String str) {
        return e.a(str);
    }

    public String a(String str, String str2) {
        return b.b(str, str2);
    }

    public String a(String str, String str2, String str3) {
        return com.sdk.r.a.b(str3, str, str2);
    }

    public String a(String str, String str2, String str3, String str4) {
        return b.a(str3, str);
    }

    public String b(String str, String str2) {
        return com.sdk.r.a.a(str2, str.substring(0, 16), str.substring(16));
    }
}
