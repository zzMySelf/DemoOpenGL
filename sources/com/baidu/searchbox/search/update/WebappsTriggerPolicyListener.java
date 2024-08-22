package com.baidu.searchbox.search.update;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.browser.BrowserRuntime;
import com.baidu.searchbox.browser.webapps.model.WebAppsTriggerPolicyData;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import org.json.JSONException;
import org.json.JSONObject;

public class WebappsTriggerPolicyListener extends JSONObjectCommandListener {
    public static final String DEFAULT_VERSION = "0";
    public static final String SEARCH_WEBAPPS_TRIGGER_POLICY_VERSION = "search_webapps_trigger_policy_version";
    private static final String TAG = "WebappsTriggerPolicy";
    public static final String WEBAPPS_TRIGGER_POLICY_ACTION = "webapps_trigger_policy";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put(WEBAPPS_TRIGGER_POLICY_ACTION, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (value == null || value.data == null || !TextUtils.equals(action, WEBAPPS_TRIGGER_POLICY_ACTION)) {
            return false;
        }
        if (BrowserRuntime.GLOBAL_DEBUG) {
            Log.d(TAG, "executeCommand: " + ((JSONObject) value.data).toString());
        }
        WebAppsTriggerPolicyData.savePolicyData(((JSONObject) value.data).toString());
        DefaultSharedPrefsWrapper.getInstance().putString(SEARCH_WEBAPPS_TRIGGER_POLICY_VERSION, value.version);
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return DefaultSharedPrefsWrapper.getInstance().getString(SEARCH_WEBAPPS_TRIGGER_POLICY_VERSION, "0");
    }
}
