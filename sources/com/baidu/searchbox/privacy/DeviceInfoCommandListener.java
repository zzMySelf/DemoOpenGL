package com.baidu.searchbox.privacy;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceInfoCommandListener extends JSONObjectCommandListener {
    private static final String ACTION = "device_info_sdk";
    private static final long CACHE_EXPIRE_TIME_DEFAULT = 86400;
    private static final String PARAM_CACHE_EXPIRE_TIME = "cache_expire";
    private static final String SP_CACHE_EXPIRE_TIME = "device_info_cache_expire";
    private static final String SP_VERSION = "device_info_sdk_version";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        postData.getVersion().put(action, getLocalVersion(context, module, action));
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (TextUtils.isEmpty(value.version) || !TextUtils.equals(action, ACTION)) {
            return false;
        }
        if (value.data != null) {
            try {
                long cacheExpireTime = ((JSONObject) value.data).optLong(PARAM_CACHE_EXPIRE_TIME, -1);
                if (cacheExpireTime >= 0) {
                    PreferenceUtils.setLong(SP_CACHE_EXPIRE_TIME, cacheExpireTime);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        PreferenceUtils.setString(SP_VERSION, value.version);
        return true;
    }

    public String getLocalVersion(Context context, String s, String s1) {
        return PreferenceUtils.getString(SP_VERSION, "0");
    }

    public static long getCacheExpireTime() {
        return PreferenceUtils.getLong(SP_CACHE_EXPIRE_TIME, 86400);
    }
}
