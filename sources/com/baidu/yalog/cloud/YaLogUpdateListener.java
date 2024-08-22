package com.baidu.yalog.cloud;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.UniKV;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.yalog.YaLogManager;
import org.json.JSONException;
import org.json.JSONObject;

public class YaLogUpdateListener extends JSONObjectCommandListener {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String SP_YA_LOG_FILE = "sp_yalog";
    private static final String TAG = "YaLogUpdate";
    public static final String YA_LOG_ACTION = "yalog";
    private static final String YA_LOG_VERSION = "yalog_version";
    private static final String YA_LOG_VERSION_DEFAULT = "0";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            String localVersion = getLocalVersion(context, module, action);
            postData.getVersion().put("yalog", localVersion);
            if (DEBUG) {
                Log.d(TAG, "request params: yalog_version = " + localVersion);
            }
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (value == null || !TextUtils.equals(action, "yalog")) {
            return false;
        }
        if (TextUtils.equals(value.version, getLocalVersion(context, module, action))) {
            return false;
        }
        JSONObject jsonObject = (JSONObject) value.data;
        if (DEBUG) {
            Log.d(TAG, "response data: " + ((JSONObject) value.data).toString());
        }
        if (jsonObject != null) {
            ((YaLogManager) ServiceManager.getService(YaLogManager.SERVICE_REFERENCE)).registerConfig(jsonObject);
        }
        sharedPrefsWrapper().putString(YA_LOG_VERSION, value.version);
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return sharedPrefsWrapper().getString(YA_LOG_VERSION, "0");
    }

    private static UniKV sharedPrefsWrapper() {
        return new UniKV(SP_YA_LOG_FILE);
    }
}
