package com.sdk.a;

public class c extends com.sdk.b.c<String, String> {
    public c(d dVar, int i2) {
        super(i2);
    }

    public int b(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        if (str2 == null) {
            return 0;
        }
        return str2.length();
    }
}
