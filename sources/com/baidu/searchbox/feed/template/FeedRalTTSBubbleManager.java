package com.baidu.searchbox.feed.template;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;

public class FeedRalTTSBubbleManager {
    public static final String HAS_SHOWN_BUBBLE = "feed_has_shown_bubble";
    public static final String HAS_SHOWN_BUBBLE_SPECIAL = "feed_has_shown_bubble_special";
    private static final String TAG = "TTS_TASK_FeedRalBubble";
    public static final String TTS_BUBBLE_SP_PREFIX = "tts_task_bubble_";
    public static final String TTS_ONLY_SHOW_ON_ONE_BUTTON = "tts_only_show_on_one_button";
    public static final String TTS_SILENT_USER_TYPE = "tts_silent_user_awaken_type";
    private String mFrom = "";
    private boolean mIsSpecialBubble = false;
    private TTSNewsTaskData mTTSNewsTaskData;
    private String mType = "";

    public static class TTSNewsTaskData {
        public String token;
        public String typeId;
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final FeedRalTTSBubbleManager INSTANCE = new FeedRalTTSBubbleManager();

        private Holder() {
        }
    }

    public static FeedRalTTSBubbleManager getInstance() {
        return Holder.INSTANCE;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFrom(String from) {
        this.mFrom = from;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public void setIsSpecialBubble(boolean isSpecialBubble) {
        this.mIsSpecialBubble = isSpecialBubble;
    }

    public boolean getIsSpecialBubble() {
        return this.mIsSpecialBubble;
    }

    public boolean getSPBoolean(String type) {
        return PreferenceUtils.getBoolean(type, false);
    }

    public void setSPBoolean(String type, boolean flag) {
        PreferenceUtils.setBoolean(type, flag);
    }

    public void setTTSNewsTaskData(TTSNewsTaskData ttsNewsTaskData) {
        this.mTTSNewsTaskData = ttsNewsTaskData;
    }

    public TTSNewsTaskData getTTSNewsTaskData() {
        return this.mTTSNewsTaskData;
    }

    public boolean isFromTTSNewsTask() {
        if (this.mTTSNewsTaskData == null) {
            return false;
        }
        if (TTSRuntime.DEBUG) {
            Log.d(TAG, "isFromTTSNewsTask: " + this.mTTSNewsTaskData.token + " " + this.mTTSNewsTaskData.typeId);
        }
        if (TextUtils.isEmpty(this.mTTSNewsTaskData.token) || TextUtils.isEmpty(this.mTTSNewsTaskData.typeId)) {
            return false;
        }
        return true;
    }
}
