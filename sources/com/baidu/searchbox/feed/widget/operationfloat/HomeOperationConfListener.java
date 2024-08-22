package com.baidu.searchbox.feed.widget.operationfloat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.feed.event.OperationDataEvent;
import com.baidu.searchbox.feed.log.OnLineLogs;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeOperationConfListener extends JSONObjectCommandListener {
    public static final String ACTION_FEED_OPERATION_CONF = "feed_operation_conf";
    public static final String KEY_FEED_OPERATION_JSON = "feed_operation_json";
    private static final String TAG = "FeedOperationConfListen";
    public static final String VERSION_FEED_OPERATION_CONF = "feed_operation_conf_v";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put(ACTION_FEED_OPERATION_CONF, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (value == null || value.data == null || !TextUtils.equals(action, ACTION_FEED_OPERATION_CONF)) {
            OnLineLogs.getOperationFloat().e("update executeCommand 不匹配");
            return false;
        }
        String localVersion = getLocalVersion(context, module, action);
        if (TextUtils.equals(value.version, localVersion)) {
            OnLineLogs.getOperationFloat().e("update executeCommand version not change :" + localVersion);
            return false;
        }
        JSONObject jsonObject = (JSONObject) value.data;
        OnLineLogs.getOperationFloat().d("update executeCommand data:" + jsonObject);
        if (jsonObject != null) {
            FeedPreferenceUtils.putString(VERSION_FEED_OPERATION_CONF, value.version);
            FeedPreferenceUtils.putString(KEY_FEED_OPERATION_JSON, jsonObject.toString());
            BdEventBus.Companion.getDefault().post(new OperationDataEvent(1));
        }
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return FeedPreferenceUtils.getString(VERSION_FEED_OPERATION_CONF, "0");
    }
}
