package com.baidu.searchbox.ad.model;

import com.baidu.searchbox.feed.ui.drawerslide.SlideToFinishActivity;
import com.baidu.searchbox.file.watcher.base.FileWatcher;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u0000 &2\u00020\u0001:\u0001&B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/ad/model/AdNormandyModel;", "", "buttonText", "", "buttonType", "buttonUrl", "finalBackgroundColor", "icon", "iconScale", "subtitle", "title", "transition", "", "Lcom/baidu/searchbox/ad/model/TransitionItem;", "type", "", "url", "hasDisplayed", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Z)V", "getButtonText", "()Ljava/lang/String;", "getButtonType", "getButtonUrl", "getFinalBackgroundColor", "getHasDisplayed", "()Z", "setHasDisplayed", "(Z)V", "getIcon", "getIconScale", "getSubtitle", "getTitle", "getTransition", "()Ljava/util/List;", "getType", "()I", "getUrl", "Companion", "lib-ad_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdNormandyModel.kt */
public final class AdNormandyModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String buttonText;
    private final String buttonType;
    private final String buttonUrl;
    private final String finalBackgroundColor;
    private boolean hasDisplayed;
    private final String icon;
    private final String iconScale;
    private final String subtitle;
    private final String title;
    private final List<TransitionItem> transition;
    private final int type;
    private final String url;

    public AdNormandyModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 0, (String) null, false, FileWatcher.ALL_EVENTS, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final AdNormandyModel fromJson(JSONObject jSONObject) {
        return Companion.fromJson(jSONObject);
    }

    @JvmStatic
    public static final JSONObject toJson(AdNormandyModel adNormandyModel) {
        return Companion.toJson(adNormandyModel);
    }

    public AdNormandyModel(String buttonText2, String buttonType2, String buttonUrl2, String finalBackgroundColor2, String icon2, String iconScale2, String subtitle2, String title2, List<TransitionItem> transition2, int type2, String url2, boolean hasDisplayed2) {
        Intrinsics.checkNotNullParameter(buttonText2, "buttonText");
        Intrinsics.checkNotNullParameter(buttonType2, "buttonType");
        Intrinsics.checkNotNullParameter(buttonUrl2, "buttonUrl");
        Intrinsics.checkNotNullParameter(finalBackgroundColor2, "finalBackgroundColor");
        Intrinsics.checkNotNullParameter(icon2, "icon");
        Intrinsics.checkNotNullParameter(iconScale2, "iconScale");
        Intrinsics.checkNotNullParameter(subtitle2, "subtitle");
        Intrinsics.checkNotNullParameter(title2, "title");
        Intrinsics.checkNotNullParameter(transition2, SlideToFinishActivity.KEY_TRANSITION);
        Intrinsics.checkNotNullParameter(url2, "url");
        this.buttonText = buttonText2;
        this.buttonType = buttonType2;
        this.buttonUrl = buttonUrl2;
        this.finalBackgroundColor = finalBackgroundColor2;
        this.icon = icon2;
        this.iconScale = iconScale2;
        this.subtitle = subtitle2;
        this.title = title2;
        this.transition = transition2;
        this.type = type2;
        this.url = url2;
        this.hasDisplayed = hasDisplayed2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdNormandyModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List list, int i2, String str9, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? "" : str8, (i3 & 256) != 0 ? CollectionsKt.emptyList() : list, (i3 & 512) != 0 ? 2 : i2, (i3 & 1024) != 0 ? "" : str9, (i3 & 2048) != 0 ? false : z);
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getButtonType() {
        return this.buttonType;
    }

    public final String getButtonUrl() {
        return this.buttonUrl;
    }

    public final String getFinalBackgroundColor() {
        return this.finalBackgroundColor;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconScale() {
        return this.iconScale;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<TransitionItem> getTransition() {
        return this.transition;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getHasDisplayed() {
        return this.hasDisplayed;
    }

    public final void setHasDisplayed(boolean z) {
        this.hasDisplayed = z;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/ad/model/AdNormandyModel$Companion;", "", "()V", "fromJson", "Lcom/baidu/searchbox/ad/model/AdNormandyModel;", "jo", "Lorg/json/JSONObject;", "optTransition", "", "Lcom/baidu/searchbox/ad/model/TransitionItem;", "ja", "Lorg/json/JSONArray;", "putTransition", "list", "toJson", "model", "lib-ad_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AdNormandyModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AdNormandyModel fromJson(JSONObject jo) {
            JSONObject jSONObject = jo;
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("buttonText", "");
            Intrinsics.checkNotNullExpressionValue(optString, "jo.optString(\"buttonText\", \"\")");
            String optString2 = jSONObject.optString("buttonType", "");
            Intrinsics.checkNotNullExpressionValue(optString2, "jo.optString(\"buttonType\", \"\")");
            String optString3 = jSONObject.optString("buttonUrl", "");
            Intrinsics.checkNotNullExpressionValue(optString3, "jo.optString(\"buttonUrl\", \"\")");
            String optString4 = jSONObject.optString("finalBackgroundColor", "");
            Intrinsics.checkNotNullExpressionValue(optString4, "jo.optString(\"finalBackgroundColor\", \"\")");
            String optString5 = jSONObject.optString("icon", "");
            Intrinsics.checkNotNullExpressionValue(optString5, "jo.optString(\"icon\", \"\")");
            String optString6 = jSONObject.optString("iconScale", "");
            Intrinsics.checkNotNullExpressionValue(optString6, "jo.optString(\"iconScale\", \"\")");
            String optString7 = jSONObject.optString("subtitle", "");
            Intrinsics.checkNotNullExpressionValue(optString7, "jo.optString(\"subtitle\", \"\")");
            String optString8 = jSONObject.optString("title", "");
            Intrinsics.checkNotNullExpressionValue(optString8, "jo.optString(\"title\", \"\")");
            List<TransitionItem> optTransition = optTransition(jSONObject.optJSONArray(SlideToFinishActivity.KEY_TRANSITION));
            int optInt = jSONObject.optInt("type", 1);
            String optString9 = jSONObject.optString("url", "");
            Intrinsics.checkNotNullExpressionValue(optString9, "jo.optString(\"url\", \"\")");
            return new AdNormandyModel(optString, optString2, optString3, optString4, optString5, optString6, optString7, optString8, optTransition, optInt, optString9, false, 2048, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final JSONObject toJson(AdNormandyModel model) {
            if (model == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject $this$toJson_u24lambda_u2d0 = jSONObject;
                $this$toJson_u24lambda_u2d0.put("buttonText", model.getButtonText());
                $this$toJson_u24lambda_u2d0.put("buttonType", model.getButtonType());
                $this$toJson_u24lambda_u2d0.put("buttonUrl", model.getButtonUrl());
                $this$toJson_u24lambda_u2d0.put("finalBackgroundColor", model.getFinalBackgroundColor());
                $this$toJson_u24lambda_u2d0.put("icon", model.getIcon());
                $this$toJson_u24lambda_u2d0.put("iconScale", model.getIconScale());
                $this$toJson_u24lambda_u2d0.put("subtitle", model.getSubtitle());
                $this$toJson_u24lambda_u2d0.put("title", model.getTitle());
                $this$toJson_u24lambda_u2d0.put(SlideToFinishActivity.KEY_TRANSITION, AdNormandyModel.Companion.putTransition(model.getTransition()));
                $this$toJson_u24lambda_u2d0.put("type", model.getType());
                $this$toJson_u24lambda_u2d0.put("url", model.getUrl());
                return jSONObject;
            } catch (JSONException e2) {
                JSONObject jSONObject2 = null;
                return null;
            }
        }

        private final List<TransitionItem> optTransition(JSONArray ja) {
            TransitionItem it;
            if (ja == null) {
                return CollectionsKt.emptyList();
            }
            List list = new ArrayList();
            int length = ja.length();
            for (int idx = 0; idx < length; idx++) {
                JSONObject jo = ja.optJSONObject(idx);
                if (!(jo == null || (it = TransitionItem.Companion.fromJson(jo)) == null)) {
                    list.add(it);
                }
            }
            return list;
        }

        private final JSONArray putTransition(List<TransitionItem> list) {
            JSONArray ja = new JSONArray();
            for (TransitionItem it : list) {
                ja.put(TransitionItem.Companion.toJson(it));
            }
            return ja;
        }
    }
}
