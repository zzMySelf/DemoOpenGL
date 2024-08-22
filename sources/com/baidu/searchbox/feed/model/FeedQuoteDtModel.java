package com.baidu.searchbox.feed.model;

import android.text.TextUtils;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.model.FeedItemDataStar;
import com.baidu.searchbox.feed.model.poi.FeedHotPoiData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedQuoteDtModel extends FeedItemDataStar {
    private static final boolean DEBUG = FeedRuntime.GLOBAL_DEBUG;
    private static final String KEY_CMD = "cmd";
    private static final String KEY_DURATION = "duration";
    private static final String KEY_FEEDBACK = "feedback";
    private static final String KEY_ID = "id";
    private static final String KEY_IMG_NUM = "surplus_img_num";
    private static final String KEY_IMG_ROW_NUM = "img_row_num";
    private static final String KEY_RESOURCE_TYPE = "resource_type";
    private static final String KEY_TITLE = "title";
    private static final String KEY_TITLELINK = "title_link";
    private static final String KEY_TITLE_LINE_NUM = "title_line_num";
    private static final String KEY_TYPE = "type";
    private static final String KEY_UGC_IMMERSIVE = "is_ugc_text_immersive";
    private static final String KEY_USER = "user";
    private static final String TAG = "FeedQuoteDtModel";
    public String cmd;
    public String duration;
    public String feedback;
    public String id;
    public boolean isUgcTextImmersive;
    public FeedItemInsideCard quoteInsideCard;
    public FeedHotPoiData quotePoiData;
    public String resourceType;
    public String title;
    public FeedItemData.TitleLink titleLinkExt;
    public int titleMaxLineNum;
    public String type;

    public JSONObject toJson() {
        JSONObject quoteJson = new JSONObject();
        try {
            quoteJson.put("id", this.id);
            quoteJson.put("title", this.title);
            quoteJson.put(KEY_TITLE_LINE_NUM, this.titleMaxLineNum);
            quoteJson.put("type", this.type);
            quoteJson.put("resource_type", this.resourceType);
            quoteJson.put("duration", this.duration);
            quoteJson.put("cmd", this.cmd);
            quoteJson.put("feedback", this.feedback);
            quoteJson.put(KEY_IMG_NUM, this.surplusImageNum);
            quoteJson.put(KEY_IMG_ROW_NUM, this.rowNum);
            quoteJson.put(KEY_UGC_IMMERSIVE, this.isUgcTextImmersive ? "1" : "0");
            FeedHotPoiData feedHotPoiData = this.quotePoiData;
            if (feedHotPoiData != null) {
                quoteJson.put("poi", feedHotPoiData.toJson());
            }
            FeedItemInsideCard feedItemInsideCard = this.quoteInsideCard;
            if (feedItemInsideCard != null) {
                quoteJson.put(FeedItemDataNews.KEY_INSIDE_CARD, FeedItemInsideCard.toJson(feedItemInsideCard));
            }
            if (this.titleLink != null) {
                quoteJson.put(KEY_TITLELINK, FeedItemData.TitleLink.toJson(this.titleLinkExt));
            }
            if (this.images != null && this.images.size() > 0) {
                if (this.images.size() == 1) {
                    quoteJson.put("image", ((FeedItemDataNews.Image) this.images.get(0)).image);
                } else if (this.images.size() >= 2) {
                    JSONArray array = new JSONArray();
                    for (FeedItemDataNews.Image image : this.images) {
                        array.put(FeedItemDataNews.Image.parseToJSON(image));
                    }
                    quoteJson.put("items", array);
                }
            }
            if (this.hdImagesList != null) {
                quoteJson.put("hd_images", this.hdImagesList);
            }
            if (this.dynamicDiffData != null) {
                quoteJson.put("dynamic_diff", FeedItemDataStar.DynamicDiffData.toJson(this.dynamicDiffData));
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        return quoteJson;
    }

    public FeedQuoteDtModel toModel(JSONObject quoteJson) {
        if (quoteJson == null) {
            return null;
        }
        this.id = quoteJson.optString("id");
        this.title = quoteJson.optString("title");
        this.titleMaxLineNum = quoteJson.optInt(KEY_TITLE_LINE_NUM, 3);
        this.quotePoiData = new FeedHotPoiData().toModel(quoteJson.optJSONObject("poi"));
        if (quoteJson.has(FeedItemDataNews.KEY_INSIDE_CARD)) {
            FeedItemInsideCard fromJson = FeedItemInsideCard.fromJson(quoteJson.optJSONObject(FeedItemDataNews.KEY_INSIDE_CARD));
            this.quoteInsideCard = fromJson;
            fromJson.isRepost = true;
        }
        this.cmd = quoteJson.optString("cmd");
        this.type = quoteJson.optString("type");
        this.resourceType = quoteJson.optString("resource_type");
        this.feedback = quoteJson.optString("feedback");
        this.surplusImageNum = quoteJson.optString(KEY_IMG_NUM);
        this.rowNum = quoteJson.optInt(KEY_IMG_ROW_NUM);
        this.isUgcTextImmersive = TextUtils.equals(quoteJson.optString(KEY_UGC_IMMERSIVE), "1");
        this.titleLinkExt = FeedItemData.TitleLink.fromJson(quoteJson.optJSONObject(KEY_TITLELINK));
        this.feedPrefixTagData = FeedPrefixTagDataKt.prefixDataFromJson(quoteJson.optJSONObject("prefix_tag"));
        this.dynamicDiffData = FeedItemDataStar.DynamicDiffData.toModel(quoteJson.optJSONObject("dynamic_diff"));
        return this;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.id) && !TextUtils.isEmpty(this.title) && !TextUtils.isEmpty(this.type) && this.title.startsWith("@");
    }
}
