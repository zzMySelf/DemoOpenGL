package com.alipay.sdk.m.a0;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    public static final Map<String, a> a = new ConcurrentHashMap();

    public static class a {
        public String a;
        public long b;
        public long c;
    }

    public static String a(String str) {
        a aVar;
        String str2;
        Map<String, a> map = a;
        if (map == null || (aVar = map.get(str)) == null) {
            return null;
        }
        if ((System.currentTimeMillis() - aVar.b < aVar.c) && (str2 = aVar.a) != null) {
            return str2;
        }
        a.remove(str);
        return null;
    }

    public static void a(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        a aVar = a.get(str);
        if (aVar == null) {
            aVar = new a();
        }
        aVar.a = str2;
        aVar.c = 86400000;
        aVar.b = System.currentTimeMillis();
        a.put(str, aVar);
    }
}
