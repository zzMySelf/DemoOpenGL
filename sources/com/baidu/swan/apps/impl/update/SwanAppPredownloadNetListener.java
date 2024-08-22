package com.baidu.swan.apps.impl.update;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.storage.sp.SwanAppSpHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppPredownloadNetListener extends JSONObjectCommandListener {
    public static final String ACTION_NAME = "bbasp_network";
    public static final String AUTH_KEY = "auth";
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String MODULE_NAME = "miniapp";
    public static final String PREDOWNLOAD_NETWORK_SWITCH = "predownload_network_switch";
    public static final String PREDOWNLOAD_NETWORK_VERSION = "predownload_network_version";
    public static final String TAG = "SwanPredwnNetListener";

    public void addPostData(Context context, String s, String s1, CommandPostData commandPostData) throws JSONException {
        if (commandPostData != null && commandPostData.getVersion() != null) {
            String localVersion = getLocalVersion(context, s, s1);
            commandPostData.getVersion().put(s1, localVersion);
            if (DEBUG) {
                Log.d(TAG, "requestVersion=" + localVersion);
            }
        }
    }

    public boolean executeCommand(Context context, String s, String s1, ActionData<JSONObject> actionData) {
        if (!TextUtils.equals(s1, ACTION_NAME) || actionData == null || actionData.data == null || TextUtils.equals(getLocalVersion(context, s, s1), actionData.version)) {
            return false;
        }
        if (DEBUG) {
            Log.d(TAG, "executeCommand: data " + ((JSONObject) actionData.data).toString());
            Log.d(TAG, "executeCommand: version " + actionData.version);
        }
        SwanAppSpHelper.getInstance().putString("predownload_network_switch", ((JSONObject) actionData.data).optString("auth"));
        SwanAppSpHelper.getInstance().putString(PREDOWNLOAD_NETWORK_VERSION, actionData.version);
        return true;
    }

    public String getLocalVersion(Context context, String s, String s1) {
        return SwanAppSpHelper.getInstance().getString(PREDOWNLOAD_NETWORK_VERSION, "0");
    }
}
