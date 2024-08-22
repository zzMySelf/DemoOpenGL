package com.baidu.searchbox.push.vsubscribe;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.push.PushPreferenceUtils;
import com.baidu.searchbox.push.subscribe.PushSubscribeUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class PushVivoSubscribeSwitchListener extends JSONObjectCommandListener {
    public static final String ACTION_PUSH_VIVO_SUBSCRIBE_SWITCH = "vivo_v_subscription_switch";
    private static final String SWITCH_VIVO_V_SUBSCRIPTION_SWITCH_CLOSE = "0";
    private static final String SWITCH_VIVO_V_SUBSCRIPTION_SWITCH_OPEN = "1";
    private static final String TAG = "VivoSubscribeSwitch";
    public static final String VERSION_PUSH_VIVO_SUBSCRIBE_SWITCH = "version_push_vivo_subscribe_switch";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put(ACTION_PUSH_VIVO_SUBSCRIBE_SWITCH, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (value == null || value.data == null || !TextUtils.equals(action, ACTION_PUSH_VIVO_SUBSCRIBE_SWITCH)) {
            return false;
        }
        if (MessageRuntime.GLOBAL_DEBUG) {
            Log.d(TAG, "action == " + action + "version = " + value.version + " config = " + value.data);
        }
        PushPreferenceUtils.getInstance().putString(VERSION_PUSH_VIVO_SUBSCRIBE_SWITCH, value.version);
        VSubscribeUtils.setVSubscribeUseful(((JSONObject) value.data).optString("vivo_v_subscription", "0").equals("1"));
        PushSubscribeUtils.setPushSubscribeSwitch(((JSONObject) value.data).optString("push_subscription_switch", "0").equals("1"));
        return true;
    }

    public String getLocalVersion(Context context, String s, String s1) {
        return PushPreferenceUtils.getInstance().getString(VERSION_PUSH_VIVO_SUBSCRIBE_SWITCH, "0");
    }
}
