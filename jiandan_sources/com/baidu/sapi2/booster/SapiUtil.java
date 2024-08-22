package com.baidu.sapi2.booster;

import android.text.TextUtils;
import com.baidu.sapi2.BaseCommand;
import com.baidu.sapi2.utils.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SapiUtil {
    public static final String CHECK_METHOD_SUPPOT = "sapi_action_check_method_support";
    public static final String H5_RESULT_FAIL = "window.sapi_bridge.callbackError(key, result)";
    public static final String H5_RESULT_SUCCESS = "window.sapi_bridge.callbackSuccess(key, result)";
    public static final String HTML = "javascript:(function() { javaScript })()";
    public static final List<String> SUCCESS_NO_RESULT_LIST;

    public static class Command extends BaseCommand {
        public static Command parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                Command command = new Command();
                String[] split = str.split("/");
                String str2 = split[2];
                JSONObject jSONObject = new JSONObject(split[3]);
                if (str2 != null) {
                    command.actionName = str2;
                    for (int i2 = 0; i2 < jSONObject.length(); i2++) {
                        String obj = jSONObject.names().get(i2).toString();
                        String optString = jSONObject.optString(obj);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(obj, optString);
                        command.actionParams.add(jSONObject2.toString());
                    }
                }
                command.key = split[4];
                command.isUpgrade = true;
                command.originCommand = str;
                return command;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        SUCCESS_NO_RESULT_LIST = arrayList;
        arrayList.add("switch_style_for_close_btn_and_status_bar");
        SUCCESS_NO_RESULT_LIST.add("finish");
    }

    public static String fail(String str, String str2) {
        return H5_RESULT_FAIL.replace("key", str).replace("result", str2);
    }

    public static String packUrl(String str) {
        return HTML.replace("javaScript", str);
    }

    public static String success(String str, String str2) {
        return H5_RESULT_SUCCESS.replace("key", str).replace("result", str2);
    }
}
