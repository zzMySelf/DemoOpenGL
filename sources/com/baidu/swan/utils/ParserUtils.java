package com.baidu.swan.utils;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class ParserUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "ParserUtils";
    public static final String UBC_KEY_PRE_APP_ID = "pre_appid";
    public static final String UBC_KEY_PRE_SOURCE = "pre_source";
    public static final String UBC_VALUE_NA = "NA";

    public static String parse(JSONObject jsonObject, String key, String defaultValue) {
        return jsonObject == null ? defaultValue : jsonObject.optString(key, defaultValue);
    }

    public static JSONObject parseUBC(String from, JSONObject ubc) {
        if (TextUtils.isEmpty(from)) {
            from = "NA";
        }
        JSONObject ubcObject = ubc == null ? new JSONObject() : ubc;
        try {
            if (TextUtils.isEmpty(parse(ubcObject, "pre_source", (String) null))) {
                ubcObject.put("pre_source", from);
            }
            if (TextUtils.isEmpty(parse(ubcObject, "pre_appid", (String) null))) {
                ubcObject.put("pre_appid", "NA");
            }
        } catch (JSONException e2) {
        }
        return ubcObject;
    }
}
