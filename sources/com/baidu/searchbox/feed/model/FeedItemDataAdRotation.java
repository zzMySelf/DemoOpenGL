package com.baidu.searchbox.feed.model;

import android.text.TextUtils;
import com.baidu.searchbox.feed.parser.FeedFilter;
import com.baidu.searchbox.feed.parser.ValidationResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedItemDataAdRotation extends FeedItemDataNews {
    private static final String TAG = FeedItemDataAdRotation.class.getSimpleName();
    public Map<String, String> mCardCmdMap;
    public List<RotationCardItem> mCardItems;

    public static final class RotationCardItem {
        public String cmd;
        public String pid;
        public int time;
        public int type;
        public String url;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = super.toJson();
        try {
            List<RotationCardItem> list = this.mCardItems;
            if (list != null) {
                jsonObject.put("items", cardItemToJson(list));
            }
            if (this.mCardCmdMap != null) {
                JSONObject cmdJson = new JSONObject();
                for (Map.Entry<String, String> entry : this.mCardCmdMap.entrySet()) {
                    cmdJson.put(entry.getKey(), entry.getValue());
                }
                jsonObject.put("items_cmd_map", cmdJson);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jsonObject;
    }

    public FeedItemData toModel(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        super.toModel(jsonObject);
        this.mCardItems = parserCardItemFromJson(jsonObject);
        JSONObject cmdJson = jsonObject.optJSONObject("items_cmd_map");
        if (cmdJson != null) {
            this.mCardCmdMap = new HashMap();
            Iterator<String> iterator = cmdJson.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = cmdJson.optString(key);
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    this.mCardCmdMap.put(key, value);
                }
            }
        }
        return this;
    }

    public JSONArray cardItemToJson(List<RotationCardItem> items) {
        try {
            JSONArray jsonArray = new JSONArray();
            for (RotationCardItem item : items) {
                if (item != null) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("pid", item.pid);
                    jsonObject.put("type", item.type);
                    jsonObject.put("url", item.url);
                    jsonObject.put("time", item.time);
                    jsonObject.put("cmd", item.cmd);
                    jsonArray.put(jsonObject);
                }
            }
            return jsonArray;
        } catch (JSONException e2) {
            return null;
        }
    }

    public List<RotationCardItem> parserCardItemFromJson(JSONObject jsonObject) {
        JSONArray jsonArray;
        if (jsonObject == null || (jsonArray = jsonObject.optJSONArray("items")) == null || jsonArray.length() <= 0) {
            return null;
        }
        ArrayList<RotationCardItem> arrayList = new ArrayList<>(jsonArray.length());
        for (int i2 = 0; i2 < jsonArray.length(); i2++) {
            RotationCardItem cardItem = new RotationCardItem();
            JSONObject jsonObj = jsonArray.optJSONObject(i2);
            cardItem.pid = jsonObj.optString("pid");
            cardItem.url = jsonObj.optString("url");
            if (!TextUtils.isEmpty(cardItem.url)) {
                cardItem.type = jsonObj.optInt("type");
                cardItem.time = jsonObj.optInt("time");
                cardItem.cmd = jsonObj.optString("cmd");
                if (!TextUtils.isEmpty(cardItem.cmd)) {
                    arrayList.add(cardItem);
                }
            }
        }
        return arrayList;
    }

    public ValidationResult isValidate(FeedBaseModel context) {
        if (!FeedFilter.checkAdFeed(context)) {
            return ValidationResult.ERROR_NO_AD;
        }
        if (TextUtils.isEmpty(this.title)) {
            return ValidationResult.ERROR_MISSING_TITLE;
        }
        if (TextUtils.isEmpty(this.cmd.get())) {
            return ValidationResult.ERROR_MISSING_CMD;
        }
        List<RotationCardItem> list = this.mCardItems;
        if (list == null || list.size() < 3) {
            return ValidationResult.ERROR_MISSING_IMAGE;
        }
        return ValidationResult.ok();
    }

    public static String makeTestJson() {
        return "";
    }
}
