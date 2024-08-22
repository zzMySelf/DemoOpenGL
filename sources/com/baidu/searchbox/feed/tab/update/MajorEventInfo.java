package com.baidu.searchbox.feed.tab.update;

import com.baidu.searchbox.feed.tab.navigation.pbfile.MultiTabItemDataProto;
import org.json.JSONException;
import org.json.JSONObject;

public class MajorEventInfo {
    private static final String RESPONSE_FALSE = "0";
    private static final String RESPONSE_TRUE = "1";
    public boolean isResponse;
    public boolean isTextLightColor;
    public String tabBarBgColor;
    public String tabBarBgNightColor;

    public static MajorEventInfo fromJson(JSONObject jsonObject) {
        MajorEventInfo majorEventInfo = new MajorEventInfo();
        majorEventInfo.isResponse = "1".equals(jsonObject.optString("enable_response"));
        majorEventInfo.isTextLightColor = "1".equals(jsonObject.optString("tabbar_font_color"));
        majorEventInfo.tabBarBgColor = jsonObject.optString("tabbar_bg");
        majorEventInfo.tabBarBgNightColor = jsonObject.optString("night_tabbar_bg");
        return majorEventInfo;
    }

    public static JSONObject toJson(JSONObject obj, MajorEventInfo majorEventInfo) {
        if (majorEventInfo == null) {
            return null;
        }
        try {
            String str = "1";
            obj.put("enable_response", majorEventInfo.isResponse ? str : "0");
            if (!majorEventInfo.isTextLightColor) {
                str = "0";
            }
            obj.put("tabbar_font_color", str);
            obj.put("tabbar_bg", majorEventInfo.tabBarBgColor);
            obj.put("night_tabbar_bg", majorEventInfo.tabBarBgNightColor);
        } catch (JSONException e2) {
        }
        return obj;
    }

    public static MajorEventInfo fromProtoObj(MultiTabItemDataProto.MultiTabItemData.MajorEventInfo protoInfo) {
        if (protoInfo == null) {
            return null;
        }
        MajorEventInfo majorEventInfo = new MajorEventInfo();
        majorEventInfo.isResponse = protoInfo.getIsResponse();
        majorEventInfo.isTextLightColor = protoInfo.getIsTextLightColor();
        majorEventInfo.tabBarBgColor = protoInfo.getTabBarBgColor();
        majorEventInfo.tabBarBgNightColor = protoInfo.getTabBarBgNightColor();
        return majorEventInfo;
    }
}
