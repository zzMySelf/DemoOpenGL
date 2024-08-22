package com.baidu.searchbox.video.plugin.videoplayer.logo;

import android.text.TextUtils;
import com.baidu.searchbox.video.flow.VideoAutoLandscapeListener;
import com.baidu.talos.core.render.ViewProps;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoAnimLogoInfo {
    private int mHeight;
    private String mJson;
    private String mLocalPatch;
    private String mLottieUrl;
    private int mMarginRight;
    private int mMarginTop;
    private int mMaxNumPerDay = 1;
    private float mPercentOfShow = 0.1f;
    private boolean mTotalSwitch = true;
    private String mVersion = "0";
    private int mWidth;

    public static VideoAnimLogoInfo parseContent(String content, String version) {
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        try {
            JSONObject contentJson = new JSONObject(content);
            VideoAnimLogoInfo entity = new VideoAnimLogoInfo();
            entity.mJson = content;
            entity.mTotalSwitch = contentJson.optInt(VideoAutoLandscapeListener.VIDEO_AUTO_LANDSCAPE_TOTALSWITCH, 1) == 1;
            entity.mMaxNumPerDay = contentJson.optInt("maxNumPerDay", 1);
            entity.mPercentOfShow = ((float) contentJson.optInt("percentOfShow", 10)) / 100.0f;
            entity.mLottieUrl = contentJson.optString("jsonUrl", (String) null);
            JSONObject contenerSize = contentJson.optJSONObject("containerSize");
            if (contenerSize != null) {
                entity.mWidth = contenerSize.optInt("width", 0);
                entity.mHeight = contenerSize.optInt("height", 0);
                entity.mMarginTop = contenerSize.optInt(ViewProps.MARGIN_TOP, 0);
                entity.mMarginRight = contenerSize.optInt(ViewProps.MARGIN_RIGHT, 0);
            }
            entity.mVersion = version;
            return entity;
        } catch (JSONException e2) {
            return null;
        }
    }

    public boolean isTotalSwitch() {
        return this.mTotalSwitch;
    }

    public void setTotalSwitch(boolean mTotalSwitch2) {
        this.mTotalSwitch = mTotalSwitch2;
    }

    public int getMaxNumPerDay() {
        return this.mMaxNumPerDay;
    }

    public void setMaxNumPerDay(int mMaxNumPerDay2) {
        this.mMaxNumPerDay = mMaxNumPerDay2;
    }

    public float getPercentOfShow() {
        return this.mPercentOfShow;
    }

    public void setPercentOfShow(float mPercentOfShow2) {
        this.mPercentOfShow = mPercentOfShow2;
    }

    public String getLottieUrl() {
        return this.mLottieUrl;
    }

    public void setLottieUrl(String mJsonUrl) {
        this.mLottieUrl = mJsonUrl;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int mWidth2) {
        this.mWidth = mWidth2;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int mHeight2) {
        this.mHeight = mHeight2;
    }

    public int getMarginTop() {
        return this.mMarginTop;
    }

    public void setMarginTop(int mMarginTop2) {
        this.mMarginTop = mMarginTop2;
    }

    public int getMarginRight() {
        return this.mMarginRight;
    }

    public void setMarginRight(int mMarginRight2) {
        this.mMarginRight = mMarginRight2;
    }

    public String getLocalPatch() {
        return this.mLocalPatch;
    }

    public void setLocalPatch(String mLocalPatch2) {
        this.mLocalPatch = mLocalPatch2;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setVersion(String mVersion2) {
        this.mVersion = mVersion2;
    }
}
