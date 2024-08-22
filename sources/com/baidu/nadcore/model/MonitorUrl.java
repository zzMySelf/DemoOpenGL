package com.baidu.nadcore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class MonitorUrl implements Serializable {
    public final String clickUrl;
    public final String showUrl;

    public MonitorUrl(String showUrl2, String clickUrl2) {
        this.showUrl = showUrl2;
        this.clickUrl = clickUrl2;
    }

    public static List<MonitorUrl> fromJson(JSONArray array) {
        List<MonitorUrl> monitorUrls = new ArrayList<>();
        if (array == null) {
            return monitorUrls;
        }
        for (int i2 = 0; i2 < array.length(); i2++) {
            JSONObject o = array.optJSONObject(i2);
            if (o != null) {
                monitorUrls.add(new MonitorUrl(o.optString("show_url"), o.optString("show_url")));
            }
        }
        return monitorUrls;
    }
}
