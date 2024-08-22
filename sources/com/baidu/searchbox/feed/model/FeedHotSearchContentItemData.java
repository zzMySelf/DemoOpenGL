package com.baidu.searchbox.feed.model;

import com.baidu.searchbox.feed.parser.ValidationResult;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000206H\u0016J\u0014\u00107\u001a\u0004\u0018\u00010\u00012\b\u00108\u001a\u0004\u0018\u000106H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\n0(j\b\u0012\u0004\u0012\u00020\n`)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001d¨\u00069"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedHotSearchContentItemData;", "Lcom/baidu/searchbox/feed/model/FeedItemData;", "()V", "hotIndexBean", "Lcom/baidu/searchbox/feed/model/FeedHotIndexBean;", "getHotIndexBean", "()Lcom/baidu/searchbox/feed/model/FeedHotIndexBean;", "setHotIndexBean", "(Lcom/baidu/searchbox/feed/model/FeedHotIndexBean;)V", "hotNum", "", "getHotNum", "()Ljava/lang/String;", "setHotNum", "(Ljava/lang/String;)V", "hotNumTitle", "getHotNumTitle", "setHotNumTitle", "hotStateImg", "getHotStateImg", "setHotStateImg", "hotStateNightImg", "getHotStateNightImg", "setHotStateNightImg", "imgTplWidth", "", "getImgTplWidth", "()D", "setImgTplWidth", "(D)V", "imgUrl", "getImgUrl", "setImgUrl", "multiLines", "", "getMultiLines", "()Z", "setMultiLines", "(Z)V", "showContent", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getShowContent", "()Ljava/util/ArrayList;", "setShowContent", "(Ljava/util/ArrayList;)V", "whRatio", "getWhRatio", "setWhRatio", "isValidate", "Lcom/baidu/searchbox/feed/parser/ValidationResult;", "context", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "toJson", "Lorg/json/JSONObject;", "toModel", "jsonObject", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedHotSearchContentItemData.kt */
public final class FeedHotSearchContentItemData extends FeedItemData {
    private FeedHotIndexBean hotIndexBean = new FeedHotIndexBean();
    private String hotNum = "";
    private String hotNumTitle = "";
    private String hotStateImg = "";
    private String hotStateNightImg = "";
    private double imgTplWidth;
    private String imgUrl = "";
    private boolean multiLines;
    private ArrayList<String> showContent = new ArrayList<>();
    private double whRatio = 1.0d;

    public final String getImgUrl() {
        return this.imgUrl;
    }

    public final void setImgUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imgUrl = str;
    }

    public final double getImgTplWidth() {
        return this.imgTplWidth;
    }

    public final void setImgTplWidth(double d2) {
        this.imgTplWidth = d2;
    }

    public final double getWhRatio() {
        return this.whRatio;
    }

    public final void setWhRatio(double d2) {
        this.whRatio = d2;
    }

    public final String getHotNum() {
        return this.hotNum;
    }

    public final void setHotNum(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hotNum = str;
    }

    public final FeedHotIndexBean getHotIndexBean() {
        return this.hotIndexBean;
    }

    public final void setHotIndexBean(FeedHotIndexBean feedHotIndexBean) {
        Intrinsics.checkNotNullParameter(feedHotIndexBean, "<set-?>");
        this.hotIndexBean = feedHotIndexBean;
    }

    public final ArrayList<String> getShowContent() {
        return this.showContent;
    }

    public final void setShowContent(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.showContent = arrayList;
    }

    public final String getHotStateImg() {
        return this.hotStateImg;
    }

    public final void setHotStateImg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hotStateImg = str;
    }

    public final String getHotStateNightImg() {
        return this.hotStateNightImg;
    }

    public final void setHotStateNightImg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hotStateNightImg = str;
    }

    public final boolean getMultiLines() {
        return this.multiLines;
    }

    public final void setMultiLines(boolean z) {
        this.multiLines = z;
    }

    public final String getHotNumTitle() {
        return this.hotNumTitle;
    }

    public final void setHotNumTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.hotNumTitle = str;
    }

    public JSONObject toJson() {
        JSONObject obj = super.parse2Json();
        try {
            obj.put("img_tpl_w_and", this.imgTplWidth);
            obj.put("w_h_ratio", this.whRatio);
            obj.put("image", this.imgUrl);
            FeedHotIndexBean feedHotIndexBean = this.hotIndexBean;
            Intrinsics.checkNotNullExpressionValue(obj, "obj");
            obj = feedHotIndexBean.toJson(obj);
            obj.put("hot_num", this.hotNum);
            JSONArray contentArr = new JSONArray();
            int size = this.showContent.size();
            for (int i2 = 0; i2 < size; i2++) {
                contentArr.put(this.showContent.get(i2));
            }
            obj.put("show", contentArr);
            obj.put("hot_state_image", this.hotStateImg);
            obj.put("hot_state_night_image", this.hotStateNightImg);
            obj.put("is_multiple_lines", this.multiLines ? "1" : "0");
            obj.put("hot_score_intro_title", this.hotNumTitle);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        Intrinsics.checkNotNullExpressionValue(obj, "obj");
        return obj;
    }

    public FeedItemData toModel(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        super.parse2Model(jsonObject, this);
        this.imgTplWidth = jsonObject.optDouble("img_tpl_w_and", 0.0d);
        this.whRatio = jsonObject.optDouble("w_h_ratio", 1.0d);
        String optString = jsonObject.optString("image");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"image\")");
        this.imgUrl = optString;
        JSONArray contentArr = jsonObject.optJSONArray("show");
        if (contentArr != null) {
            JSONArray it = contentArr;
            int length = it.length();
            for (int i2 = 0; i2 < length; i2++) {
                this.showContent.add(it.getString(i2));
            }
        }
        this.hotIndexBean = this.hotIndexBean.toModel(jsonObject);
        String optString2 = jsonObject.optString("hot_num");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"hot_num\")");
        this.hotNum = optString2;
        String optString3 = jsonObject.optString("hot_state_image");
        Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(\"hot_state_image\")");
        this.hotStateImg = optString3;
        String optString4 = jsonObject.optString("hot_state_night_image");
        Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(\"hot_state_night_image\")");
        this.hotStateNightImg = optString4;
        this.multiLines = Intrinsics.areEqual((Object) jsonObject.optString("is_multiple_lines", "0"), (Object) "1");
        String optString5 = jsonObject.optString("hot_score_intro_title", "");
        Intrinsics.checkNotNullExpressionValue(optString5, "jsonObject.optString(\"hot_score_intro_title\", \"\")");
        this.hotNumTitle = optString5;
        return this;
    }

    public ValidationResult isValidate(FeedBaseModel context) {
        String str;
        ValidationResult validationResult;
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence charSequence = this.title;
        if (charSequence == null || charSequence.length() == 0) {
            validationResult = ValidationResult.error();
            str = "error()";
        } else {
            validationResult = ValidationResult.ok();
            str = "ok()";
        }
        Intrinsics.checkNotNullExpressionValue(validationResult, str);
        return validationResult;
    }
}
