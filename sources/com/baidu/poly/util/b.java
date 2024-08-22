package com.baidu.poly.util;

import android.text.TextUtils;
import android.util.Base64;

/* compiled from: SearchBox */
public class b {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return new String(Base64.decode(str, 0));
    }
}
