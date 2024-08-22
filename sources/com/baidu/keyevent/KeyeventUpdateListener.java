package com.baidu.keyevent;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import org.json.JSONException;
import org.json.JSONObject;

public class KeyeventUpdateListener extends JSONObjectCommandListener {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String KEY_UPDATE_VERSION = "keyevent_update_version";
    private static final String TAG = "KeyeventUpdateListener";
    private static final String UPDATE_ACTION = "keyevent_config";

    public void addPostData(Context c2, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put(UPDATE_ACTION, getLocalVersion(c2, module, action));
            if (DEBUG) {
                Log.d(TAG, "post version " + postData.getVersion().toString());
            }
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "executeCommand: " + module + " content " + value);
        }
        if (value == null || value.data == null || TextUtils.isEmpty(value.version)) {
            return false;
        }
        boolean success = KeyeventConfig.updateConfig((JSONObject) value.data);
        if (success) {
            QuickPersistConfig.getInstance().putString(KEY_UPDATE_VERSION, value.version);
        }
        if (!z) {
            return true;
        }
        Log.d(TAG, "version " + value.version + " content " + ((JSONObject) value.data).toString() + " success:" + success);
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return QuickPersistConfig.getInstance().getString(KEY_UPDATE_VERSION, "0");
    }
}
