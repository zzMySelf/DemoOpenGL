package com.baidu.searchbox.feed.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedDuplicateData implements Jsonable<FeedDuplicateData> {
    private String keepReaded;
    private String noDupDel;

    public boolean isNeedDupDel() {
        return !TextUtils.isEmpty(this.noDupDel) && this.noDupDel.equals("1");
    }

    public boolean isKeepRead() {
        return !TextUtils.isEmpty(this.keepReaded) && this.keepReaded.equals("1");
    }

    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        try {
            object.put("nodup_del", this.noDupDel);
            object.put("keep_readed", this.keepReaded);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return object;
    }

    public FeedDuplicateData toModel(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        this.noDupDel = jsonObject.optString("nodup_del");
        this.keepReaded = jsonObject.optString("keep_readed");
        return this;
    }
}
