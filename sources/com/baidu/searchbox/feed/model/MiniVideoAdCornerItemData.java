package com.baidu.searchbox.feed.model;

import android.text.TextUtils;
import com.baidu.searchbox.feed.parser.ValidationResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniVideoAdCornerItemData extends FeedItemData {
    public int adAutoShowTime;
    public String mEntryTag;
    public String mEntryTitle;
    public String mExt;
    public String mFloatTitle;
    public List<AdCornerDataItem> mItemList;
    public String mVid;

    public JSONObject toJson() {
        JSONObject jsonObject = super.parse2Json();
        try {
            jsonObject.put("vid", this.mVid);
            jsonObject.put("entry_tag", this.mEntryTag);
            jsonObject.put("entry_title", this.mEntryTitle);
            jsonObject.put("float_title", this.mFloatTitle);
            jsonObject.put("ext", this.mExt);
            jsonObject.put("ad_show_time", this.adAutoShowTime);
            JSONArray jsonArray = new JSONArray();
            List<AdCornerDataItem> list = this.mItemList;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.mItemList.size(); i2++) {
                    jsonArray.put(AdCornerDataItem.toJson(this.mItemList.get(i2)));
                }
            }
            jsonObject.put("item_list", jsonArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jsonObject;
    }

    public FeedItemData toModel(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        super.parse2Model(jsonObject, this);
        this.mVid = jsonObject.optString("vid");
        this.mEntryTag = jsonObject.optString("entry_tag");
        this.mEntryTitle = jsonObject.optString("entry_title");
        this.mFloatTitle = jsonObject.optString("float_title");
        this.mExt = jsonObject.optString("ext");
        this.adAutoShowTime = jsonObject.optInt("ad_show_time", 0);
        JSONArray jsonArray = jsonObject.optJSONArray("item_list");
        if (jsonArray == null) {
            return this;
        }
        ArrayList<AdCornerDataItem> itemArrayList = new ArrayList<>();
        for (int i2 = 0; i2 < jsonArray.length(); i2++) {
            try {
                AdCornerDataItem adCornerDataItem = AdCornerDataItem.fromJson(jsonArray.getJSONObject(i2));
                if (adCornerDataItem != null && !TextUtils.isEmpty(adCornerDataItem.mImg) && !TextUtils.isEmpty(adCornerDataItem.mTitle) && adCornerDataItem.mButton != null) {
                    if (!TextUtils.isEmpty(adCornerDataItem.mButton.cmd)) {
                        itemArrayList.add(adCornerDataItem);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.mItemList = itemArrayList;
        return this;
    }

    public static class AdCornerDataItem {
        public Button mButton;
        public String mImg;
        public String mSubTitle;
        public String mTitle;

        public static AdCornerDataItem fromJson(JSONObject jsonObject) {
            if (jsonObject == null) {
                return null;
            }
            AdCornerDataItem adCornerDataItem = new AdCornerDataItem();
            adCornerDataItem.mImg = jsonObject.optString("img");
            adCornerDataItem.mTitle = jsonObject.optString("title");
            adCornerDataItem.mSubTitle = jsonObject.optString("sub_title");
            JSONObject object = jsonObject.optJSONObject("button");
            if (object != null) {
                adCornerDataItem.mButton = Button.fromJson(object);
            }
            return adCornerDataItem;
        }

        public static JSONObject toJson(AdCornerDataItem adCornerDataItem) {
            if (adCornerDataItem == null) {
                return null;
            }
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("img", adCornerDataItem.mImg);
                jsonObject.put("title", adCornerDataItem.mTitle);
                jsonObject.put("sub_title", adCornerDataItem.mSubTitle);
                jsonObject.put("button", Button.toJson(adCornerDataItem.mButton));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jsonObject;
        }

        public static class Button {
            public String cmd;
            public String text;
            public String type;

            public static Button fromJson(JSONObject jsonObject) {
                if (jsonObject == null) {
                    return null;
                }
                Button button = new Button();
                button.type = jsonObject.optString("type");
                button.text = jsonObject.optString("text");
                button.cmd = jsonObject.optString("cmd");
                return button;
            }

            public static JSONObject toJson(Button button) {
                if (button == null) {
                    return null;
                }
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("type", button.type);
                    jsonObject.put("text", button.text);
                    jsonObject.put("cmd", button.cmd);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jsonObject;
            }
        }
    }

    public ValidationResult isValidate(FeedBaseModel context) {
        if (TextUtils.isEmpty(this.mEntryTitle)) {
            return ValidationResult.ERROR_MISSING_TITLE;
        }
        List<AdCornerDataItem> list = this.mItemList;
        if (list == null || list.size() == 0) {
            return ValidationResult.ERROR_PARSER_ERROR;
        }
        return ValidationResult.ok();
    }
}
