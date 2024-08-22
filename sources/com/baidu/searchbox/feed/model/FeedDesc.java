package com.baidu.searchbox.feed.model;

import org.json.JSONException;
import org.json.JSONObject;

public class FeedDesc {
    public String descCmd;
    public String descText;
    public String userCmd;
    public String userText;

    public static JSONObject toJson(FeedDesc feedDesc) {
        if (feedDesc == null) {
            return null;
        }
        JSONObject jsonFeedDesc = new JSONObject();
        try {
            jsonFeedDesc.put("user_text", feedDesc.userText);
            jsonFeedDesc.put("user_text_cmd", feedDesc.userCmd);
            jsonFeedDesc.put("text", feedDesc.descText);
            jsonFeedDesc.put("cmd", feedDesc.descCmd);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jsonFeedDesc;
    }

    public static FeedDesc fromJson(JSONObject jsonFeedDesc) {
        if (jsonFeedDesc == null) {
            return null;
        }
        FeedDesc feedDesc = new FeedDesc();
        feedDesc.userText = jsonFeedDesc.optString("user_text");
        feedDesc.userCmd = jsonFeedDesc.optString("user_text_cmd");
        feedDesc.descText = jsonFeedDesc.optString("text");
        feedDesc.descCmd = jsonFeedDesc.optString("cmd");
        return feedDesc;
    }
}
