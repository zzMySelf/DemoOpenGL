package com.baidu.searchbox.feed.model;

import android.text.TextUtils;
import com.baidu.searchbox.feed.base.hot.DynamicBean;
import com.baidu.searchbox.view.MiniVideoAdFormPopupView;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicReasonData implements DynamicBean<DynamicReasonData> {
    public static final String CLICKABLE_TOPIC_DETAIL = "2";
    public static final String CLICKABLE_TOPIC_LIST = "1";
    public String bgColor;
    public String bgNightColor;
    public String cmd;
    public String iconLeftUrl;
    public String iconRightUrl;
    public String reasonType;
    public String title;
    public String titleColor;
    public String titleNightColor;
    public String topicId;
    public String type;

    public boolean isClickableType() {
        return TextUtils.equals(this.type, "1") || TextUtils.equals(this.type, "2");
    }

    public DynamicReasonData toModel(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        this.iconLeftUrl = jsonObject.optString("icon_left");
        this.iconRightUrl = jsonObject.optString("icon_right");
        this.title = jsonObject.optString("title");
        this.titleColor = jsonObject.optString(FeedItemDataHotSearchFooter.TITLE_COLOR);
        this.titleNightColor = jsonObject.optString("title_color_dark");
        this.bgColor = jsonObject.optString(MiniVideoAdFormPopupView.BG_COLOR);
        this.bgNightColor = jsonObject.optString("bg_color_dark");
        this.type = jsonObject.optString("type");
        this.cmd = jsonObject.optString("cmd");
        this.topicId = jsonObject.optString("topic_id");
        this.reasonType = jsonObject.optString("reason_type");
        return this;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("icon_left", this.iconLeftUrl);
            jsonObject.put("icon_right", this.iconRightUrl);
            jsonObject.put("title", this.title);
            jsonObject.put(FeedItemDataHotSearchFooter.TITLE_COLOR, this.titleColor);
            jsonObject.put("title_color_dark", this.titleNightColor);
            jsonObject.put(MiniVideoAdFormPopupView.BG_COLOR, this.bgColor);
            jsonObject.put("bg_color_dark", this.bgNightColor);
            jsonObject.put("type", this.type);
            jsonObject.put("cmd", this.cmd);
            jsonObject.put("topic_id", this.topicId);
            jsonObject.put("reason_type", this.reasonType);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jsonObject;
    }

    public boolean check() {
        return !TextUtils.isEmpty(this.title);
    }
}
