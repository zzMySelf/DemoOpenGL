package com.baidu.spswitch.emotion.bean;

import android.text.TextUtils;
import org.json.JSONObject;

public class EmojiFavorItemGifInfo {
    private static final String KEY_GIF_ID = "gif_id";
    private static final String KEY_MINI_URL = "mini_url";
    private static final String KEY_URL = "url";
    public int mGifHeight;
    public String mGifId;
    public int mGifMiniHeight;
    public int mGifMiniWidth;
    public int mGifWidth;
    public String mMiniUrl;
    public String mUrl;

    public static EmojiFavorItemGifInfo parseFromJson(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        EmojiFavorItemGifInfo gifInfo = new EmojiFavorItemGifInfo();
        gifInfo.mGifId = jsonObject.optString("gif_id", "");
        gifInfo.mUrl = jsonObject.optString("url", "");
        gifInfo.mMiniUrl = jsonObject.optString(KEY_MINI_URL, "");
        gifInfo.mGifWidth = jsonObject.optInt("width", 0);
        gifInfo.mGifHeight = jsonObject.optInt("height", 0);
        gifInfo.mGifMiniWidth = jsonObject.optInt("mini_width", 0);
        gifInfo.mGifMiniHeight = jsonObject.optInt("mini_height", 0);
        return gifInfo;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mGifId) && !TextUtils.isEmpty(this.mUrl) && this.mGifWidth > 0 && this.mGifHeight > 0;
    }
}
