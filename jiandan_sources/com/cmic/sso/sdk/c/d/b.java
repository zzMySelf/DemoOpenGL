package com.cmic.sso.sdk.c.d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b {
    public int a;
    public Map<String, List<String>> b;
    public String c;

    public b(int i2, Map<String, List<String>> map, String str) {
        this.a = i2;
        this.b = map;
        this.c = str;
    }

    public int a() {
        return this.a;
    }

    public Map<String, List<String>> b() {
        Map<String, List<String>> map = this.b;
        return map == null ? new HashMap() : map;
    }

    public String c() {
        String str = this.c;
        return str == null ? "" : str;
    }

    public boolean d() {
        int i2 = this.a;
        return i2 == 302 || i2 == 301;
    }
}
