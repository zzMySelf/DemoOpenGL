package com.baidu.searchbox.hissug.searchable.bean;

import org.json.JSONObject;

public class EntitySuggestion extends Suggestion {
    protected String brief;
    protected String image;
    protected String query;

    public EntitySuggestion(JSONObject sug) {
        this.query = sug.optString("query");
        this.brief = sug.optString("brief");
        this.image = sug.optString("img");
        setBtnKuangText(this.query);
        setSourceName("web");
        setUserQuery(this.query);
    }

    public EntitySuggestion() {
        this.query = "query";
        this.brief = "brief";
        this.image = "";
        setSourceName("web");
        setUserQuery(this.query);
    }

    public String getBrief() {
        return this.brief;
    }

    public String getQuery() {
        return this.query;
    }

    public String getImage() {
        return this.image;
    }
}
