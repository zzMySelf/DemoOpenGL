package com.baidu.ubctool;

import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;

public class UbcUtils {
    private static final String DEFAULT_NAME = "process";

    private UbcUtils() {
    }

    public static String processFileName(String name) {
        if (TextUtils.isEmpty(name)) {
            name = "process";
        }
        try {
            return new String(Base64.encode(name.getBytes("UTF-8"), 0), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
