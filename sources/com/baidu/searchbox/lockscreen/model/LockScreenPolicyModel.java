package com.baidu.searchbox.lockscreen.model;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.lockscreen.util.LockScreenPreferenceUtils;
import com.baidu.searchbox.lockscreen.util.LockScreenUtil;
import org.json.JSONObject;

public class LockScreenPolicyModel {
    public static boolean DEBUG = LockScreenUtil.GLOBAL_DEBUG;
    public static final int DEFAULT_SCROLL_FEEDBACK_INTERVAL = 30;
    private static final String TAG = "LockScreenPolicyModel";
    public static final String VIDEO_AUTO_PLAY_SP_KEY = "video_auto_play";
    public boolean isAutoPLay = true;
    public long scrollFeedbackInterval;

    public static LockScreenPolicyModel parse(JSONObject originalJson) {
        if (DEBUG) {
            Log.i(TAG, "LockScreenPolicyModel parse:" + originalJson);
        }
        if (originalJson == null) {
            return null;
        }
        LockScreenPolicyModel model = new LockScreenPolicyModel();
        if (originalJson != null) {
            long scrollFeedbackInterval2 = originalJson.optLong(LockScreenProtocol.SCROLL_FEEDBACK_INTERVAL);
            if (scrollFeedbackInterval2 <= 0) {
                scrollFeedbackInterval2 = 30;
            }
            model.scrollFeedbackInterval = 1000 * scrollFeedbackInterval2;
            String videoAutoPlayStr = originalJson.optString("video_auto_play");
            if (TextUtils.equals(videoAutoPlayStr, "1")) {
                model.isAutoPLay = true;
                putIsVideoAutoPlay(true);
            } else if (TextUtils.equals(videoAutoPlayStr, "0")) {
                model.isAutoPLay = false;
                putIsVideoAutoPlay(false);
            }
        }
        return model;
    }

    public static boolean getIsVideoAutoPlay() {
        return LockScreenPreferenceUtils.getBoolean("video_auto_play", true);
    }

    public static void putIsVideoAutoPlay(boolean value) {
        LockScreenPreferenceUtils.putBoolean("video_auto_play", value);
    }
}
