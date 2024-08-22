package com.alipay.sdk.m.l0;

import java.util.regex.Pattern;

public class f {
    public static final Pattern a = Pattern.compile("([\t\r\n])+");

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m6a(String str) {
        return str == null || str.length() <= 0;
    }

    public static int a(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i2 = 0;
        for (char c : str.toCharArray()) {
            i2 = (i2 * 31) + c;
        }
        return i2;
    }
}
