package com.baidu.searchbox.hissug.searchable.bean;

import org.json.JSONObject;

public class CustomSuggestion extends Suggestion {
    protected String brief;
    protected String img;
    protected String link;
    protected String name;
    protected String tag;

    public CustomSuggestion(JSONObject sug) {
        this.name = sug.optString("name");
        this.img = sug.optString("img");
        this.brief = sug.optString("brief");
        this.tag = sug.optString("tag");
        this.link = sug.optString("link");
        setSourceName("web");
    }

    public String getName() {
        return this.name;
    }

    public String getImg() {
        return this.img;
    }

    public String getBrief() {
        return this.brief;
    }

    public String getTag() {
        return this.tag;
    }

    public String getLink() {
        return this.link;
    }
}
