package com.baidu.live.feed.search.model.data;

import org.json.JSONObject;

public class LiveSearchSuggestion {
    public String question = "";
    public String type = "";

    public void parseJSONObj(JSONObject obj) {
        this.type = obj.optString("type");
        this.question = obj.optString("q");
    }
}
