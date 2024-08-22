package com.baidu.searchbox.feed.biserial.bean;

import com.baidu.browser.explore.toptip.TopTipConstantKt;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.parser.ValidationResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0012\u0010\u0019\u001a\u00020\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/feed/biserial/bean/FeedItemNotePublishData;", "Lcom/baidu/searchbox/feed/model/FeedItemData;", "dataJson", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "button", "", "getButton", "()Ljava/lang/String;", "setButton", "(Ljava/lang/String;)V", "image", "getImage", "setImage", "mainTitle", "getMainTitle", "setMainTitle", "subTitle", "getSubTitle", "setSubTitle", "isValidate", "Lcom/baidu/searchbox/feed/parser/ValidationResult;", "context", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "toJson", "toModel", "jsonObject", "lib-feed-biserial_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedItemNotePublishData.kt */
public final class FeedItemNotePublishData extends FeedItemData {
    private String button = "";
    private String image = "";
    private String mainTitle = "";
    private String subTitle = "";

    public FeedItemNotePublishData(JSONObject dataJson) {
        Intrinsics.checkNotNullParameter(dataJson, TopTipConstantKt.DATA_JSON);
        toModel(dataJson);
    }

    public final String getMainTitle() {
        return this.mainTitle;
    }

    public final void setMainTitle(String str) {
        this.mainTitle = str;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(String str) {
        this.subTitle = str;
    }

    public final String getButton() {
        return this.button;
    }

    public final void setButton(String str) {
        this.button = str;
    }

    public final String getImage() {
        return this.image;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public JSONObject toJson() {
        JSONObject dataObj = super.parse2Json();
        try {
            Result.Companion companion = Result.Companion;
            JSONObject $this$toJson_u24lambda_u2d1_u24lambda_u2d0 = dataObj;
            $this$toJson_u24lambda_u2d1_u24lambda_u2d0.put("title", this.mainTitle);
            $this$toJson_u24lambda_u2d1_u24lambda_u2d0.put("sub_title", this.subTitle);
            $this$toJson_u24lambda_u2d1_u24lambda_u2d0.put("button_text", this.button);
            $this$toJson_u24lambda_u2d1_u24lambda_u2d0.put("image", this.image);
            Result.m8971constructorimpl(dataObj);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Intrinsics.checkNotNullExpressionValue(dataObj, "dataObj");
        return dataObj;
    }

    public FeedItemData toModel(JSONObject jsonObject) {
        super.parse2Model(jsonObject, this);
        if (jsonObject != null) {
            JSONObject it = jsonObject;
            this.mainTitle = it.optString("title");
            this.subTitle = it.optString("sub_title");
            this.button = it.optString("button_text");
            this.image = it.optString("image");
        }
        return this;
    }

    public ValidationResult isValidate(FeedBaseModel context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ValidationResult ok = ValidationResult.ok();
        Intrinsics.checkNotNullExpressionValue(ok, "ok()");
        return ok;
    }
}
