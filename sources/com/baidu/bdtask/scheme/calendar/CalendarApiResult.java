package com.baidu.bdtask.scheme.calendar;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.unitedscheme.core.R;
import org.json.JSONException;
import org.json.JSONObject;

public class CalendarApiResult {
    public static final boolean DEBUG = AppConfig.isDebug();
    public JSONObject data;
    private boolean mIsDataEncode = false;
    public String message;
    public int status;

    public CalendarApiResult(int statusCode) {
        this.status = statusCode;
    }

    public CalendarApiResult(int statusCode, String message2) {
        this.status = statusCode;
        this.message = message2;
    }

    public CalendarApiResult(int statusCode, JSONObject data2) {
        this.status = statusCode;
        this.data = data2;
    }

    public void putData(String key, Object value) {
        if (this.data == null) {
            this.data = new JSONObject();
        }
        try {
            this.data.put(key, value);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public boolean isSuccess() {
        return this.status == 0;
    }

    public JSONObject toJsonResult() {
        JSONObject result = new JSONObject();
        try {
            result.put("status", String.valueOf(this.status));
            if (TextUtils.isEmpty(this.message)) {
                this.message = getErrMessage(this.status);
            }
            result.put("message", this.message);
            JSONObject jSONObject = this.data;
            if (jSONObject != null) {
                Object obj = jSONObject;
                if (this.mIsDataEncode) {
                    obj = Uri.encode(jSONObject.toString());
                }
                result.put("data", obj);
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    private static String getErrMessage(int statusCode) {
        switch (statusCode) {
            case 0:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_ok);
            case 101:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_not_support);
            case 201:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_parse_fail);
            case 202:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_params_parse_fail);
            case 301:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_module_notfound);
            case 302:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_notfound);
            case 401:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_sec_check_fail);
            case 402:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_acl_check_fail);
            case 403:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_allow_close);
            case 10001:
                return AppRuntime.getAppContext().getString(com.baidu.bdptask.R.string.err_calendar_invalid_parameter);
            case 10002:
                return AppRuntime.getAppContext().getString(com.baidu.bdptask.R.string.err_calendar_permission_none);
            case 10003:
                return AppRuntime.getAppContext().getString(com.baidu.bdptask.R.string.err_calendar_duplicate);
            default:
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_parse_fail);
        }
    }
}
