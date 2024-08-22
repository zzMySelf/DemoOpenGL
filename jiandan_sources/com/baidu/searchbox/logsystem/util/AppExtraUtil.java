package com.baidu.searchbox.logsystem.util;

import org.json.JSONObject;

public class AppExtraUtil {
    public static volatile AppExtraCall qw;

    public interface AppExtraCall {
        JSONObject qw();
    }

    public static String qw() {
        JSONObject qw2;
        if (qw == null || (qw2 = qw.qw()) == null) {
            return null;
        }
        return qw2.toString();
    }
}
