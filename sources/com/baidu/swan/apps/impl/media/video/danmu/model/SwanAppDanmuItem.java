package com.baidu.swan.apps.impl.media.video.danmu.model;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppLibConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppDanmuItem {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String KEY_COLOR = "color";
    private static final String KEY_SELF = "isSelf";
    public static final String KEY_TEXT = "text";
    private static final String KEY_TIME = "time";
    private static final String KEY_VID = "videoId";
    private static final int MAX_LENGTH = 20;
    private String color;
    private String content;
    private boolean isSelf;
    private String playTime;

    public String getContent() {
        return this.content;
    }

    public void setContent(String content2) {
        this.content = content2;
    }

    public String getPlayTime() {
        return this.playTime;
    }

    public void setPlayTime(String playTime2) {
        this.playTime = playTime2;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    public void setSelf(boolean self) {
        this.isSelf = self;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color2) {
        this.color = color2;
    }

    public boolean validateContent() {
        return !TextUtils.isEmpty(this.content) && this.content.length() <= 20;
    }

    public static SwanAppDanmuItem fromJson(String data) {
        if (TextUtils.isEmpty(data)) {
            return null;
        }
        try {
            SwanAppDanmuItem danmaItem = new SwanAppDanmuItem();
            JSONObject danmaJson = new JSONObject(data);
            danmaItem.setContent(danmaJson.optString("text"));
            danmaItem.setColor(danmaJson.optString("color"));
            danmaItem.setPlayTime(danmaJson.optString("time"));
            danmaItem.setSelf(danmaJson.optBoolean(KEY_SELF));
            return danmaItem;
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static JSONObject toJson(String vid, String content2, String color2, long time) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.putOpt(KEY_VID, vid);
            jsonObject.putOpt("text", content2);
            jsonObject.putOpt("color", color2);
            jsonObject.putOpt("time", Long.valueOf(time));
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        return jsonObject;
    }
}
