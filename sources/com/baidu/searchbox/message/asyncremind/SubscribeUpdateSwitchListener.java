package com.baidu.searchbox.message.asyncremind;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.imsdk.ImMsgControl;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import org.json.JSONException;
import org.json.JSONObject;

public class SubscribeUpdateSwitchListener extends JSONObjectCommandListener {
    public static final String ACTION_SEEK_UPDATE_SWITCH = "async_update_dialog";
    private static final String KEY_SEEK_UPDATE_SWITCH = "switch";
    private static final String TAG = "SubscribeUpdateCommandListener";

    public void addPostData(Context context, String s, String s1, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put(ACTION_SEEK_UPDATE_SWITCH, ImMsgControl.getInstance(MessageRuntime.getAppContext()).getSeekUpdateSwitchLocalVersion());
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (value == null || value.data == null || !TextUtils.equals(action, ACTION_SEEK_UPDATE_SWITCH)) {
            return false;
        }
        if (MessageRuntime.GLOBAL_DEBUG) {
            Log.d(TAG, "action == " + action + "version = " + value.version + " config = " + value.data);
        }
        saveSubscribeUpdateSwitchData(value.version, (JSONObject) value.data);
        return true;
    }

    public String getLocalVersion(Context context, String s, String s1) {
        return ImMsgControl.getInstance(context).getSeekUpdateSwitchLocalVersion();
    }

    private void saveSubscribeUpdateSwitchData(String version, JSONObject data) {
        ImMsgControl.getInstance(MessageRuntime.getAppContext()).setSeekUpdateSwitchLocalVersion(version);
        ImMsgControl.getInstance(MessageRuntime.getAppContext()).setSeekUpdateShowSwitch(data.optString("switch"));
    }
}
