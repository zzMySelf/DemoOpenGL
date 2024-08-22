package com.baidu.searchbox.log.utils;

import android.text.TextUtils;

public class ParseSafeUtil {
    public static String parseString(Object obj) {
        return parseString(obj, "");
    }

    public static String parseString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static double parseDouble(Object obj) {
        return parseDouble(obj, 0.0d);
    }

    public static double parseDouble(Object obj, double defaultValue) {
        double doubleValue = defaultValue;
        if (obj == null) {
            return doubleValue;
        }
        String strValue = parseString(obj);
        if (TextUtils.isEmpty(strValue)) {
            return doubleValue;
        }
        try {
            return Double.parseDouble(strValue);
        } catch (NumberFormatException e2) {
            return defaultValue;
        }
    }

    public static long parseLong(Object obj) {
        return parseLong(obj, 0);
    }

    public static long parseLong(Object obj, long defaultValue) {
        long longValue = defaultValue;
        if (obj == null) {
            return longValue;
        }
        String strValue = parseString(obj);
        if (TextUtils.isEmpty(strValue)) {
            return longValue;
        }
        try {
            return Long.parseLong(strValue);
        } catch (NumberFormatException e2) {
            return defaultValue;
        }
    }

    public static int parseInt(Object obj) {
        return parseInt(obj, 0);
    }

    public static int parseInt(Object obj, int defaultValue) {
        int intValue = defaultValue;
        if (obj == null) {
            return intValue;
        }
        String strValue = parseString(obj);
        if (TextUtils.isEmpty(strValue)) {
            return intValue;
        }
        try {
            return Integer.parseInt(strValue);
        } catch (NumberFormatException e2) {
            return defaultValue;
        }
    }

    public static boolean parseBoolean(Object obj) {
        return parseBoolean(obj, false);
    }

    public static boolean parseBoolean(Object obj, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (obj != null) {
            return Boolean.parseBoolean(parseString(obj));
        }
        return booleanValue;
    }
}
