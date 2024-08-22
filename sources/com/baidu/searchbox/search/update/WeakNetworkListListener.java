package com.baidu.searchbox.search.update;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.browser.BrowserRuntime;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.ng.browser.util.WeakNetworkManager;
import org.json.JSONException;
import org.json.JSONObject;

public class WeakNetworkListListener extends JSONObjectCommandListener {
    public static final String ACTION = "search_weak_network";
    public static final String DEFAULT_VERSION = "0";
    public static final int SWITCH_OPEN = 1;
    private static final String TAG = "WeakNetworkListListener";
    public static final String WEAK_NETWORK_DELAY_VERSION = "weak_network_version";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put(ACTION, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        boolean z = false;
        if (value == null || value.data == null || !TextUtils.equals(action, ACTION)) {
            return false;
        }
        if (BrowserRuntime.GLOBAL_DEBUG) {
            Log.d(TAG, "executeCommand: " + ((JSONObject) value.data).toString());
        }
        DefaultSharedPrefsWrapper.getInstance().putInt(WeakNetworkManager.KEY_DETECT_DELAY, ((JSONObject) value.data).optInt(WeakNetworkManager.KEY_DETECT_DELAY, 3));
        DefaultSharedPrefsWrapper.getInstance().putInt(WeakNetworkManager.KEY_TIMEOUT_DURATION, ((JSONObject) value.data).optInt(WeakNetworkManager.KEY_TIMEOUT_DURATION, 14));
        DefaultSharedPrefsWrapper instance = DefaultSharedPrefsWrapper.getInstance();
        if (((JSONObject) value.data).optInt(WeakNetworkManager.KEY_WEAK_NETWORK_SWITCH, 1) == 1) {
            z = true;
        }
        instance.putBoolean(WeakNetworkManager.KEY_WEAK_NETWORK_SWITCH, z);
        DefaultSharedPrefsWrapper.getInstance().putString(WEAK_NETWORK_DELAY_VERSION, value.version);
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return DefaultSharedPrefsWrapper.getInstance().getString(WEAK_NETWORK_DELAY_VERSION, "0");
    }
}
