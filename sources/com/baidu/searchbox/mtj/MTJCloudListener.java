package com.baidu.searchbox.mtj;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import org.json.JSONException;
import org.json.JSONObject;

public class MTJCloudListener extends JSONObjectCommandListener {
    private static final String CLOUD_MTJ_ONLINE = "0";
    private static final String CLOUD_MTJ_ONLINE_ACTION = "mtj_sdk_online";
    private static final String CLOUD_MTJ_ONLINE_AUTH = "auth";
    private static final String CLOUD_MTJ_ONLINE_AUTH_OPEN = "1";
    private static final String SP_DEFAULT_VERSION_CODE = "0";
    public static final String SP_MTJ_ONLINE_SWITCHER = "mtj_online_switcher";
    private static final String SP_MTJ_ONLINE_VERSION = "mtj_online_version";
    private static final String TAG = "MTJ_Online_Config";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put(action, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (value == null || value.data == null || !TextUtils.equals(action, CLOUD_MTJ_ONLINE_ACTION)) {
            return false;
        }
        if (AppConfig.isDebug()) {
            Log.d(TAG, "executeCommand: " + ((JSONObject) value.data).toString());
        }
        String version = value.version;
        JSONObject data = (JSONObject) value.data;
        if (TextUtils.isEmpty(version) || data == null || data.length() == 0 || getLocalVersion(context, module, action).equals(version)) {
            return false;
        }
        String auth = data.optString("auth");
        if ("1".equals(auth)) {
            MtjWrapper.sMtjPreferences.putString(SP_MTJ_ONLINE_VERSION, version);
            MtjWrapper.sMtjPreferences.putBoolean(SP_MTJ_ONLINE_SWITCHER, true);
            return true;
        }
        if ("0".equals(auth)) {
            MtjWrapper.sMtjPreferences.putString(SP_MTJ_ONLINE_VERSION, version);
            MtjWrapper.sMtjPreferences.putBoolean(SP_MTJ_ONLINE_SWITCHER, false);
            return true;
        }
        return false;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return MtjWrapper.sMtjPreferences.getString(SP_MTJ_ONLINE_VERSION, "0");
    }
}
