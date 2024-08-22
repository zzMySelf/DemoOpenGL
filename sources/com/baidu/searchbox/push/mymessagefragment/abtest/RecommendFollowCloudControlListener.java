package com.baidu.searchbox.push.mymessagefragment.abtest;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.IMSharedPrefsWrapper;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import org.json.JSONException;
import org.json.JSONObject;

public class RecommendFollowCloudControlListener extends JSONObjectCommandListener {
    public static final String ACTION_RECOMMEND_FOLLOW = "im_center_recommend_exit";
    private static final String KEY_CLICK_FOR_ATTENTION_BTN = "clickForAttentionBtn";
    private static final String KEY_CONTINUITY_CLICK_FOR_CHECKALL = "continuityClickForCheckALL";
    private static final String KEY_CONTINUITY_CLICK_FOR_CLOSE = "continuityClickForClose";
    private static final String KEY_DETAIL_INFO = "detail_info";
    private static final String KEY_EXIT_DAY = "exitDay";
    private static final String KEY_OPEN_SWITCH = "open_switch";
    public static final String SP_KEY_CLICK_FOR_ATTENTION_BTN = "im_center_recommend_follow_clickForAttentionBtn";
    public static final String SP_KEY_CONTINUITY_CLICK_FOR_CHECKALL = "im_center_recommend_follow_continuityClickForCheckALL";
    public static final String SP_KEY_CONTINUITY_CLICK_FOR_CLOSE = "im_center_recommend_follow_continuityClickForClose";
    public static final String SP_KEY_EXIT_DAY = "im_center_recommend_follow_exitDay";
    public static final String SP_KEY_OPEN_SWITCH = "im_center_recommend_follow_open_switch";
    private static final String TAG = "RecommendFollowCloud";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put(ACTION_RECOMMEND_FOLLOW, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (value == null || value.data == null || !TextUtils.equals(action, ACTION_RECOMMEND_FOLLOW)) {
            return false;
        }
        if (MessageRuntime.GLOBAL_DEBUG) {
            Log.d(TAG, "action == " + action + "version = " + value.version + " config = " + value.data);
        }
        IMSharedPrefsWrapper.getInstance().putString(ACTION_RECOMMEND_FOLLOW, value.version);
        IMSharedPrefsWrapper.getInstance().putInt(SP_KEY_OPEN_SWITCH, ((JSONObject) value.data).optInt(KEY_OPEN_SWITCH, 0));
        JSONObject detailInfo = ((JSONObject) value.data).optJSONObject(KEY_DETAIL_INFO);
        if (detailInfo == null) {
            return true;
        }
        IMSharedPrefsWrapper.getInstance().putInt(SP_KEY_EXIT_DAY, detailInfo.optInt(KEY_EXIT_DAY, 10));
        IMSharedPrefsWrapper.getInstance().putInt(SP_KEY_CONTINUITY_CLICK_FOR_CLOSE, detailInfo.optInt(KEY_CONTINUITY_CLICK_FOR_CLOSE, 2));
        IMSharedPrefsWrapper.getInstance().putInt(SP_KEY_CONTINUITY_CLICK_FOR_CHECKALL, detailInfo.optInt(KEY_CONTINUITY_CLICK_FOR_CHECKALL, 5));
        IMSharedPrefsWrapper.getInstance().putInt(SP_KEY_CLICK_FOR_ATTENTION_BTN, detailInfo.optInt(KEY_CLICK_FOR_ATTENTION_BTN, 0));
        return true;
    }

    public String getLocalVersion(Context context, String s, String s1) {
        return IMSharedPrefsWrapper.getInstance().getString(ACTION_RECOMMEND_FOLLOW, "0");
    }
}
