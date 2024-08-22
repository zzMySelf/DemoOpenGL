package com.baidu.searchbox.feed.model;

import android.text.TextUtils;
import com.baidu.searchbox.comment.BDCommentConstants;
import com.baidu.searchbox.feed.ad.model.AdExt;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedTopAuthorInfo;
import com.baidu.searchbox.feed.model.outcomment.FeedHotOutCommentData;
import com.baidu.searchbox.feed.template.origin.IOriginDecoderFactory;
import com.baidu.searchbox.feed.template.tplinterface.IPrefetch;
import com.baidu.searchbox.feed.util.DynamicPrefetchUtil;
import com.baidu.searchbox.prefetch.base.PrefetchItemData;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class DynamicItemPostData extends DynamicItemData implements IPrefetch {
    public static final String CLOSE_OUT_COMMENT = "0";
    public static final String IMMERSIVE_TEMPLATE_STYLE = "1";
    public static final String MODE_ATLAS = "image";
    public static final String MODE_DYNAMIC = "dynamic";
    public static final String MODE_SMART_APP = "smartapp";
    public static final String MODE_VIDEO = "video";
    public static final String OPEN_OUT_COMMENT = "1";
    public int beforeMoreLayout;
    public String commentConf;
    public String commentTips;
    public DynamicPrefetchData dynamicPrefetchData;
    public AdExt ext;
    public String feedFloorType;
    public String hasOutComment = "0";
    public FeedItemInsideCard insideCardData;
    public boolean isFakeToppingType = false;
    public boolean isFirstCard;
    public boolean isUnfolded = false;
    private IOriginDecoderFactory mOriginDecoderFactory;
    public String mode;
    public DynamicItemData originData;
    protected JSONObject originDataJson;
    public FeedHotOutCommentData outCommentData;
    public String templateStyle;

    public void setOriginDecoderFactory(IOriginDecoderFactory originDecoderFactory) {
        this.mOriginDecoderFactory = originDecoderFactory;
    }

    public void parse2Model(JSONObject jsonObject) {
        super.parse2Model(jsonObject);
    }

    public DynamicItemPostData toModel(JSONObject jsonObject) {
        parse2Model(jsonObject);
        return this;
    }

    public JSONObject toJson() {
        return super.toJson();
    }

    /* access modifiers changed from: protected */
    public final void applyDataJson(JSONObject dataJson) {
        JSONObject outCommentObj;
        IOriginDecoderFactory iOriginDecoderFactory;
        if (dataJson != null) {
            this.topAuthorInfo.followInfo = FeedItemData.AdditionalInfo.fromJson(dataJson.optJSONObject("follow"));
            JSONObject tmp = dataJson.optJSONObject("user");
            if (tmp != null) {
                this.topAuthorInfo.user = FeedTopAuthorInfo.FeedStarSubdataProfile.fromJson(tmp);
            }
            JSONObject tmp2 = dataJson.optJSONObject("pendant");
            if (tmp2 != null) {
                this.topAuthorInfo.pendantInfo = FeedTopAuthorInfo.PendantInfo.fromJson(tmp2);
            }
            this.topAuthorInfo.fromTopAuthorInfoNode = true;
            this.isFakeToppingType = dataJson.optBoolean("isFakeToppingType");
            this.mode = dataJson.optString("mode");
            this.dynamicPrefetchData = DynamicPrefetchData.toModel(dataJson);
            JSONObject optJSONObject = dataJson.optJSONObject("origin_data");
            this.originDataJson = optJSONObject;
            if (!(optJSONObject == null || (iOriginDecoderFactory = this.mOriginDecoderFactory) == null)) {
                this.originData = iOriginDecoderFactory.buildOriginModel().toOriginModel(this.originDataJson);
            }
            String optString = dataJson.optString("have_out_comment", "0");
            this.hasOutComment = optString;
            if (TextUtils.equals(optString, "1") && (outCommentObj = dataJson.optJSONObject("out_comment")) != null) {
                this.outCommentData = new FeedHotOutCommentData().toModel(outCommentObj);
            }
            this.commentConf = dataJson.optString(BDCommentConstants.KEY_COMMENT_INPUT_CONF);
            this.commentTips = dataJson.optString("comment_tips");
            this.insideCardData = FeedItemInsideCard.fromJson(dataJson.optJSONObject(FeedItemDataNews.KEY_INSIDE_CARD));
            this.feedFloorType = dataJson.optString("feed_floor_type");
            this.ext = AdExt.fromJson(dataJson.optJSONObject("extra_info"));
            this.templateStyle = dataJson.optString("style");
            this.isFirstCard = dataJson.optBoolean("is_first_card", false);
            this.beforeMoreLayout = dataJson.optInt("before_more_layout");
        }
        super.applyDataJson(dataJson);
    }

    /* access modifiers changed from: protected */
    public final void parseModel2DataJson(JSONObject dataJson) throws JSONException {
        super.parseModel2DataJson(dataJson);
        if (this.topAuthorInfo.followInfo != null) {
            dataJson.put("follow", FeedItemData.AdditionalInfo.toJson(this.topAuthorInfo.followInfo));
        }
        if (this.topAuthorInfo.user != null) {
            dataJson.put("user", FeedTopAuthorInfo.FeedStarSubdataProfile.toJson(this.topAuthorInfo.user));
        }
        if (this.topAuthorInfo.pendantInfo != null) {
            dataJson.put("pendant", FeedTopAuthorInfo.PendantInfo.toJson(this.topAuthorInfo.pendantInfo));
        }
        DynamicPrefetchData dynamicPrefetchData2 = this.dynamicPrefetchData;
        if (dynamicPrefetchData2 != null) {
            dynamicPrefetchData2.saveToJson(dataJson);
        }
        JSONObject jSONObject = this.originDataJson;
        if (jSONObject != null) {
            dataJson.put("origin_data", jSONObject);
        }
        dataJson.put("mode", this.mode);
        dataJson.put("have_out_comment", this.hasOutComment);
        FeedHotOutCommentData feedHotOutCommentData = this.outCommentData;
        if (feedHotOutCommentData != null && feedHotOutCommentData.check()) {
            dataJson.put("out_comment", this.outCommentData.toJson());
        }
        dataJson.put(BDCommentConstants.KEY_COMMENT_INPUT_CONF, this.commentConf);
        dataJson.put("comment_tips", this.commentTips);
        FeedItemInsideCard feedItemInsideCard = this.insideCardData;
        if (feedItemInsideCard != null) {
            dataJson.put(FeedItemDataNews.KEY_INSIDE_CARD, FeedItemInsideCard.toJson(feedItemInsideCard));
        }
        dataJson.put("feed_floor_type", this.feedFloorType);
        dataJson.put("extra_info", AdExt.toJson(this.ext));
        dataJson.put("style", this.templateStyle);
        dataJson.put("is_first_card", this.isFirstCard);
        dataJson.put("before_more_layout", this.beforeMoreLayout);
    }

    public List<PrefetchItemData> generatePrefetchData(FeedBaseModel baseModel, boolean isClick) {
        return DynamicPrefetchUtil.generatePrefetchData(baseModel, isClick, this);
    }

    public List<PrefetchItemData> generateVideoPrefetchData(FeedBaseModel baseModel, boolean isClick) {
        return DynamicPrefetchUtil.generateVideoPrefetchData(baseModel, isClick, this);
    }
}
