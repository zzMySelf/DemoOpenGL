package com.sdk.o;

import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;

public class a {
    public static int a(String str, String str2, Boolean bool) {
        if (str2 == null) {
            str2 = "";
        }
        if (bool.booleanValue()) {
            return Log.e(str, str2);
        }
        return -1;
    }

    public static Boolean a(String str) {
        return (str == null || str.length() == 0 || str.trim().length() == 0 || StringUtil.NULL_STRING.equals(str)) ? Boolean.TRUE : Boolean.FALSE;
    }

    public static int b(String str, String str2, Boolean bool) {
        if (str2 == null) {
            str2 = "";
        }
        if (bool.booleanValue()) {
            return Log.i(str, str2);
        }
        return -1;
    }

    public static Boolean b(String str) {
        return (str == null || str.length() == 0 || str.trim().length() == 0 || StringUtil.NULL_STRING.equals(str) || str.equals("")) ? Boolean.FALSE : Boolean.TRUE;
    }

    public static int c(String str, String str2, Boolean bool) {
        if (str2 == null) {
            str2 = "";
        }
        if (bool.booleanValue()) {
            return Log.w(str, str2);
        }
        return -1;
    }
}
