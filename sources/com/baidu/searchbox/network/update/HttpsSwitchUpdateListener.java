package com.baidu.searchbox.network.update;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.AbstractCommandListener;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.google.gson.annotations.SerializedName;
import org.json.JSONException;

public class HttpsSwitchUpdateListener extends AbstractCommandListener<HttpsSwitchDataModel> {
    public static final String NETWORK_HTTPS_SWITCH = "network_https_switch";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        String presetVersion = getLocalVersion(context, module, action);
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put(NETWORK_HTTPS_SWITCH, presetVersion);
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<HttpsSwitchDataModel> value) {
        if (value == null || value.data == null || !TextUtils.equals(action, NETWORK_HTTPS_SWITCH)) {
            return false;
        }
        if (TextUtils.equals(value.version, getLocalVersion(context, module, action))) {
            return false;
        }
        QuickPersistConfig.getInstance().putBoolean(QuickPersistConfigConst.KEY_SEARCHBOX_SERVER_USE_HTTPS, ((HttpsSwitchDataModel) value.data).isHttpsOpen);
        PreferenceUtils.setString(NETWORK_HTTPS_SWITCH, value.version);
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return PreferenceUtils.getString(NETWORK_HTTPS_SWITCH, "0");
    }

    class HttpsSwitchDataModel {
        @SerializedName("key_box_use_https")
        public boolean isHttpsOpen = true;

        HttpsSwitchDataModel() {
        }
    }
}
