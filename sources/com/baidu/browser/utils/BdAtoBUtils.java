package com.baidu.browser.utils;

import java.util.regex.Pattern;

public class BdAtoBUtils {
    private static String base64hash = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static boolean isMatcher(String inStr, String reg) {
        return Pattern.compile(reg).matcher(inStr).matches();
    }

    public static String btoa(String inStr) {
        if (inStr == null || isMatcher(inStr, "([^\\u0000-\\u00ff])")) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        int mod = 0;
        int prev = 0;
        int length = inStr.length();
        for (int i2 = 0; i2 < length; i2++) {
            int ascii = inStr.charAt(i2);
            mod = i2 % 3;
            switch (mod) {
                case 0:
                    result.append(String.valueOf(base64hash.charAt(ascii >> 2)));
                    break;
                case 1:
                    result.append(String.valueOf(base64hash.charAt(((prev & 3) << 4) | (ascii >> 4))));
                    break;
                case 2:
                    result.append(String.valueOf(base64hash.charAt(((prev & 15) << 2) | (ascii >> 6))));
                    result.append(String.valueOf(base64hash.charAt(ascii & 63)));
                    break;
            }
            prev = ascii;
        }
        if (mod == 0) {
            result.append(String.valueOf(base64hash.charAt((prev & 3) << 4)));
            result.append("==");
        } else if (mod == 1) {
            result.append(String.valueOf(base64hash.charAt((prev & 15) << 2)));
            result.append("=");
        }
        return result.toString();
    }

    public static String atob(String inStr) {
        if (inStr == null) {
            return null;
        }
        String inStr2 = inStr.replaceAll("\\s|=", "");
        StringBuilder result = new StringBuilder();
        int prev = -1;
        int length = inStr2.length();
        for (int i2 = 0; i2 < length; i2++) {
            int cur = base64hash.indexOf(inStr2.charAt(i2));
            switch (i2 % 4) {
                case 1:
                    result.append(String.valueOf((char) ((prev << 2) | (cur >> 4))));
                    break;
                case 2:
                    result.append(String.valueOf((char) (((prev & 15) << 4) | (cur >> 2))));
                    break;
                case 3:
                    result.append(String.valueOf((char) (((prev & 3) << 6) | cur)));
                    break;
            }
            prev = cur;
        }
        return result.toString();
    }
}
