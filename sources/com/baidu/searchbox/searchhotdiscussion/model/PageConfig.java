package com.baidu.searchbox.searchhotdiscussion.model;

import com.baidu.searchbox.hotdiscussion.ubc.TCStatisticHelper;
import com.baidu.searchbox.search.tab.tagsearch.SearchVideoTagParser;
import org.json.JSONObject;

public class PageConfig {
    public ClickInfo clickInfo;
    public int hasMoreResult;
    public InnerConfig innerConfig;
    public String nextPn;
    public String urlSign;

    public static PageConfig parse(JSONObject jsonObject) {
        PageConfig model = new PageConfig();
        if (jsonObject != null) {
            model.hasMoreResult = jsonObject.optInt("hasMoreResult", 0);
            model.nextPn = jsonObject.optString("nextPn");
            model.urlSign = jsonObject.optString("urlSign", "");
            model.innerConfig = InnerConfig.parse(jsonObject.optJSONObject("innerConfig"));
            model.clickInfo = ClickInfo.parse(jsonObject.optJSONObject(SearchVideoTagParser.CLICK_INFO));
        }
        return model;
    }

    public static class InnerConfig {
        public String publishScheme;

        public static InnerConfig parse(JSONObject jsonObject) {
            InnerConfig model = new InnerConfig();
            if (jsonObject != null) {
                model.publishScheme = jsonObject.optString("publishScheme");
            }
            return model;
        }
    }

    public static class ClickInfo {
        public String applid;
        public String lid;
        public String logUrl;
        public String query;
        public String referlid;
        public String xcxId;

        public static ClickInfo parse(JSONObject jsonObject) {
            ClickInfo model = new ClickInfo();
            if (jsonObject != null) {
                model.xcxId = jsonObject.optString(TCStatisticHelper.KEY_XCXID);
                model.query = jsonObject.optString("q");
                model.lid = jsonObject.optString("lid");
                model.applid = jsonObject.optString("applid");
                model.logUrl = jsonObject.optString("logUrl");
                model.referlid = jsonObject.optString(TCStatisticHelper.KEY_REFERLID);
            }
            return model;
        }
    }
}
