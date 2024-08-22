package com.baidu.searchbox.socialshare.update;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import org.json.JSONException;
import org.json.JSONObject;

public class SharePlatformCommandListener extends JSONObjectCommandListener {
    public static final String ACTION_SHARE_PLATFORM_SWITCH = "share_platform_switch";
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "SharePlatformListener";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put("share_platform_switch", ShareOperationPreferenceUtils.getPlatformVersion());
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (value == null || value.data == null || !TextUtils.equals(action, "share_platform_switch")) {
            return false;
        }
        if (DEBUG) {
            Log.d(TAG, "action == " + action + "version = " + value.version + " config = " + value.data);
        }
        saveSharePlatformSwitchData((JSONObject) value.data, value.version);
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return ShareOperationPreferenceUtils.getPlatformVersion();
    }

    private void saveSharePlatformSwitchData(JSONObject json, String version) {
        ShareOperationPreferenceUtils.setPlatformVersion(version);
        ShareOperationPreferenceUtils.setPlatfromSwitch(json.optString("on"));
        ShareOperationPreferenceUtils.setAutoLoginWithShare(json.optString("sharelogin"));
        ShareOperationPreferenceUtils.setShowTipsWithShare(json.optString("show_function_tips"));
    }
}
