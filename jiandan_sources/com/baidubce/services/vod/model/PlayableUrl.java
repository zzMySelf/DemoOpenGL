package com.baidubce.services.vod.model;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayableUrl {
    public String transcodingPresetName;
    public String url;

    public static PlayableUrl formatFromJson(JSONObject jSONObject) throws JSONException {
        PlayableUrl playableUrl = new PlayableUrl();
        playableUrl.setUrl(jSONObject.getString("url"));
        playableUrl.setTranscodingPresetName(jSONObject.optString("transcodingPresetName"));
        return playableUrl;
    }

    public String getTranscodingPresetName() {
        return this.transcodingPresetName;
    }

    public String getUrl() {
        return this.url;
    }

    public void setTranscodingPresetName(String str) {
        this.transcodingPresetName = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "PlayableUrl { \n" + "   transcodingPresetName = " + this.transcodingPresetName + StringUtils.LF + "   url = " + this.url + StringUtils.LF + "  }\n";
    }
}
