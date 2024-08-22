package com.baidu.searchbox.game.template.model.interactdata;

import com.baidu.searchbox.feed.base.hot.DynamicBean;
import org.json.JSONException;
import org.json.JSONObject;

public class CommunityShare implements DynamicBean<CommunityShare> {
    public String content;
    public String forward;
    public String iconUrl;
    public String linkUrl;
    public String title;

    public CommunityShare toModel(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        this.title = jsonObject.optString("title");
        this.content = jsonObject.optString("content");
        this.linkUrl = jsonObject.optString("linkUrl");
        this.iconUrl = jsonObject.optString("iconUrl");
        this.forward = jsonObject.optString("forward");
        return this;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("title", this.title);
            jsonObject.put("content", this.content);
            jsonObject.put("linkUrl", this.linkUrl);
            jsonObject.put("iconUrl", this.iconUrl);
            jsonObject.put("forward", this.forward);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jsonObject;
    }

    public boolean check() {
        return true;
    }
}
