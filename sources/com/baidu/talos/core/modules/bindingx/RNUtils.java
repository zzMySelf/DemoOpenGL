package com.baidu.talos.core.modules.bindingx;

public class RNUtils {
    public static int getInt(Object value, int defaultValue) {
        if (value == null || !(value instanceof String)) {
            return defaultValue;
        }
        try {
            return Integer.parseInt((String) value);
        } catch (Exception e2) {
            return defaultValue;
        }
    }

    public static String getString(Object value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof String) {
            return (String) value;
        }
        return value.toString();
    }
}
