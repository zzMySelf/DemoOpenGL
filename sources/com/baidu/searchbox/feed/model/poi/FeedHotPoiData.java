package com.baidu.searchbox.feed.model.poi;

import android.text.TextUtils;
import com.baidu.searchbox.feed.model.FeedPrefixTagDataKt;
import com.baidu.searchbox.feed.model.Jsonable;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedHotPoiData implements Jsonable<FeedHotPoiData> {
    public static final String CLICKABLE_TYPE = "1";
    public static final String NO_CLICKABLE_TYPE = "0";
    public String arrowIcon;
    public String arrowIconNight;
    public String bgColor;
    public String bgColorNight;
    public String ext;
    public String isClick;
    public String leftIcon;
    public String leftIconNight;
    public String poiExpend;
    public String schema;
    public String text;
    public String textColor;
    public String textColorNight;

    public FeedHotPoiData toModel(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        this.text = jsonObject.optString("text");
        this.textColor = jsonObject.optString("text_color");
        this.textColorNight = jsonObject.optString("text_color_deep");
        this.bgColor = jsonObject.optString(FeedPrefixTagDataKt.KEY_BG_COLOR);
        this.bgColorNight = jsonObject.optString("background_color_deep");
        this.leftIcon = jsonObject.optString("left_icon");
        this.leftIconNight = jsonObject.optString("left_icon_deep");
        this.arrowIcon = jsonObject.optString("arrow_icon");
        this.arrowIconNight = jsonObject.optString("arrow_icon_deep");
        this.schema = jsonObject.optString("schema");
        this.isClick = jsonObject.optString("is_click");
        this.ext = jsonObject.optString("ext");
        this.poiExpend = jsonObject.optString("poi_expand");
        return this;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("text", this.text);
            jsonObject.put("text_color", this.textColor);
            jsonObject.put("text_color_deep", this.textColorNight);
            jsonObject.put(FeedPrefixTagDataKt.KEY_BG_COLOR, this.bgColor);
            jsonObject.put("background_color_deep", this.bgColorNight);
            jsonObject.put("left_icon", this.leftIcon);
            jsonObject.put("left_icon_deep", this.leftIconNight);
            jsonObject.put("arrow_icon", this.arrowIcon);
            jsonObject.put("arrow_icon_deep", this.arrowIconNight);
            jsonObject.put("schema", this.schema);
            jsonObject.put("is_click", this.isClick);
            jsonObject.put("ext", this.ext);
            jsonObject.put("poi_expand", this.poiExpend);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jsonObject;
    }

    public boolean check() {
        return !TextUtils.isEmpty(this.text) && ((TextUtils.equals(this.isClick, "1") && !TextUtils.isEmpty(this.schema)) || TextUtils.equals(this.isClick, "0"));
    }

    public boolean isClickableType() {
        return TextUtils.equals(this.isClick, "1");
    }

    public JSONObject toJson(FeedHotPoiData poiData) {
        JSONObject jsonObject = new JSONObject();
        if (poiData == null) {
            return jsonObject;
        }
        try {
            jsonObject.put("text", poiData.text);
            jsonObject.put("text_color", poiData.textColor);
            jsonObject.put("text_color_deep", poiData.textColorNight);
            jsonObject.put(FeedPrefixTagDataKt.KEY_BG_COLOR, poiData.bgColor);
            jsonObject.put("background_color_deep", poiData.bgColorNight);
            jsonObject.put("left_icon", poiData.leftIcon);
            jsonObject.put("left_icon_deep", poiData.leftIconNight);
            jsonObject.put("arrow_icon", poiData.arrowIcon);
            jsonObject.put("arrow_icon_deep", poiData.arrowIconNight);
            jsonObject.put("schema", poiData.schema);
            jsonObject.put("is_click", poiData.isClick);
            jsonObject.put("ext", poiData.ext);
            jsonObject.put("poi_expand", poiData.poiExpend);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jsonObject;
    }
}
