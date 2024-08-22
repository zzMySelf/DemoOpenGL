package com.baidu.searchbox.feed.flow.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import org.json.JSONException;
import org.json.JSONObject;

public class FlowListPageItemNotifyListener extends JSONObjectCommandListener {
    private static final String DEFAULT_VERSION = "0";
    public static final String KEY_FEED_FLOW_LIST_NOTIFY_OPTI_SWITCH = "feed_flow_list_notify_opti_switch";
    public static final String VALUE_ACTION = "feed_flow_list_notify_opti";
    private static final String VALUE_VERSION = "feed_flow_list_notify_opti_v";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put(VALUE_ACTION, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (value == null || value.data == null || !TextUtils.equals(action, VALUE_ACTION)) {
            return false;
        }
        if (TextUtils.equals(value.version, getLocalVersion(context, module, action))) {
            return false;
        }
        FeedPreferenceUtils.putBoolean(KEY_FEED_FLOW_LIST_NOTIFY_OPTI_SWITCH, TextUtils.equals(((JSONObject) value.data).optString("switch", "0"), "1"));
        FeedPreferenceUtils.putString(VALUE_VERSION, value.version);
        return true;
    }

    public String getLocalVersion(Context context, String s, String s1) {
        return FeedPreferenceUtils.getString(VALUE_VERSION, "0");
    }
}
