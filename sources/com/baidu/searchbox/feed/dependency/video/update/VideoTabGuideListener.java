package com.baidu.searchbox.feed.dependency.video.update;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.video.util.VideoPreferenceUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoTabGuideListener extends JSONObjectCommandListener {
    private static final boolean DEBUG = FeedRuntime.GLOBAL_DEBUG;
    private static final String DEFAULT_VERSION = "0";
    public static final String FEED_GUIDE_KEY = "feed";
    private static final String TAG = "VideoTabGuideListener";
    public static final String VIDEO_GUIDE_KEY = "video";
    public static final String VIDEO_TAB_GUIDE_ACTION = "video_tab_guide";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            if (DEBUG) {
                Log.d(TAG, "post data version : " + getLocalVersion(context, module, action));
            }
            postData.getVersion().put(VIDEO_TAB_GUIDE_ACTION, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if (value == null || value.data == null || !TextUtils.equals(action, VIDEO_TAB_GUIDE_ACTION)) {
            return false;
        }
        if (!TextUtils.isEmpty(value.version)) {
            VideoPreferenceUtils.putString(VIDEO_TAB_GUIDE_ACTION, value.version, 0);
            if (DEBUG) {
                Log.d(TAG, "executeCommand data version : " + value.version);
            }
        }
        String feedContent = ((JSONObject) value.data).optString("feed");
        if (!TextUtils.isEmpty(feedContent)) {
            VideoPreferenceUtils.putString("pref_video_tab_guide_feed", feedContent, 0);
            if (DEBUG) {
                Log.d(TAG, "feedContent : " + feedContent);
            }
        }
        String videoContent = ((JSONObject) value.data).optString("video");
        if (TextUtils.isEmpty(videoContent)) {
            return true;
        }
        VideoPreferenceUtils.putString(VideoPreferenceUtils.PREF_VIDEO_TAB_GUIDE_VIDEO, videoContent, 0);
        if (!DEBUG) {
            return true;
        }
        Log.d(TAG, "videoContent : " + videoContent);
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return VideoPreferenceUtils.getString(VIDEO_TAB_GUIDE_ACTION, "0", 0);
    }
}
