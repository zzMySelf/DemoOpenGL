package com.baidu.searchbox.feed.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedDynamicLabel;", "", "()V", "cmd", "", "ext", "firstText", "firstTextColor", "firstTextColorNight", "iconUrl", "iconUrlNight", "iconWidth", "", "type", "isFirstTextValid", "", "isIconValid", "isValid", "Companion", "lib-feed-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedDynamicLabel.kt */
public final class FeedDynamicLabel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public String cmd = "";
    public String ext = "";
    public String firstText = "";
    public String firstTextColor = "";
    public String firstTextColorNight = "";
    public String iconUrl = "";
    public String iconUrlNight = "";
    public int iconWidth;
    public String type = "";

    @JvmStatic
    public static final FeedDynamicLabel fromJson(JSONObject jSONObject) {
        return Companion.fromJson(jSONObject);
    }

    @JvmStatic
    public static final JSONObject toJson(FeedDynamicLabel feedDynamicLabel) {
        return Companion.toJson(feedDynamicLabel);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/model/FeedDynamicLabel$Companion;", "", "()V", "fromJson", "Lcom/baidu/searchbox/feed/model/FeedDynamicLabel;", "json", "Lorg/json/JSONObject;", "toJson", "label", "lib-feed-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedDynamicLabel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FeedDynamicLabel fromJson(JSONObject json) {
            if (json == null) {
                return null;
            }
            JSONObject jSONObject = json;
            FeedDynamicLabel feedDynamicLabel = new FeedDynamicLabel();
            FeedDynamicLabel $this$fromJson_u24lambda_u2d1_u24lambda_u2d0 = feedDynamicLabel;
            String optString = json.optString("type", "");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"type\", \"\")");
            $this$fromJson_u24lambda_u2d1_u24lambda_u2d0.type = optString;
            String optString2 = json.optString("icon_url", "");
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"icon_url\", \"\")");
            $this$fromJson_u24lambda_u2d1_u24lambda_u2d0.iconUrl = optString2;
            String optString3 = json.optString("icon_url_night", "");
            Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"icon_url_night\", \"\")");
            $this$fromJson_u24lambda_u2d1_u24lambda_u2d0.iconUrlNight = optString3;
            $this$fromJson_u24lambda_u2d1_u24lambda_u2d0.iconWidth = json.optInt("icon_width", 0);
            String optString4 = json.optString("text", "");
            Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"text\", \"\")");
            $this$fromJson_u24lambda_u2d1_u24lambda_u2d0.firstText = optString4;
            String optString5 = json.optString("text_color", "");
            Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(\"text_color\", \"\")");
            $this$fromJson_u24lambda_u2d1_u24lambda_u2d0.firstTextColor = optString5;
            String optString6 = json.optString("text_color_night", "");
            Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(\"text_color_night\", \"\")");
            $this$fromJson_u24lambda_u2d1_u24lambda_u2d0.firstTextColorNight = optString6;
            String optString7 = json.optString("cmd", "");
            Intrinsics.checkNotNullExpressionValue(optString7, "json.optString(\"cmd\", \"\")");
            $this$fromJson_u24lambda_u2d1_u24lambda_u2d0.cmd = optString7;
            String optString8 = json.optString("ext", "");
            Intrinsics.checkNotNullExpressionValue(optString8, "json.optString(\"ext\", \"\")");
            $this$fromJson_u24lambda_u2d1_u24lambda_u2d0.ext = optString8;
            return feedDynamicLabel;
        }

        @JvmStatic
        public final JSONObject toJson(FeedDynamicLabel label) {
            if (label == null) {
                return null;
            }
            FeedDynamicLabel feedDynamicLabel = label;
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject $this$toJson_u24lambda_u2d3_u24lambda_u2d2 = jSONObject;
                $this$toJson_u24lambda_u2d3_u24lambda_u2d2.put("type", label.type);
                $this$toJson_u24lambda_u2d3_u24lambda_u2d2.put("icon_url", label.iconUrl);
                $this$toJson_u24lambda_u2d3_u24lambda_u2d2.put("icon_url_night", label.iconUrlNight);
                $this$toJson_u24lambda_u2d3_u24lambda_u2d2.put("icon_width", label.iconWidth);
                $this$toJson_u24lambda_u2d3_u24lambda_u2d2.put("text", label.firstText);
                $this$toJson_u24lambda_u2d3_u24lambda_u2d2.put("text_color", label.firstTextColor);
                $this$toJson_u24lambda_u2d3_u24lambda_u2d2.put("text_color_night", label.firstTextColorNight);
                $this$toJson_u24lambda_u2d3_u24lambda_u2d2.put("cmd", label.cmd);
                $this$toJson_u24lambda_u2d3_u24lambda_u2d2.put("ext", label.ext);
                return jSONObject;
            } catch (JSONException e2) {
                JSONObject jSONObject2 = null;
                return null;
            }
        }
    }

    public final boolean isValid() {
        String str = this.type;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    return isFirstTextValid();
                }
                break;
            case 50:
                if (str.equals("2")) {
                    return isIconValid();
                }
                break;
            case 51:
                if (str.equals("3") && isIconValid() && isFirstTextValid()) {
                    return true;
                }
                return false;
        }
        return false;
    }

    public final boolean isIconValid() {
        return (StringsKt.isBlank(this.iconUrl) ^ true) && (StringsKt.isBlank(this.iconUrlNight) ^ true) && this.iconWidth > 0;
    }

    public final boolean isFirstTextValid() {
        return (StringsKt.isBlank(this.firstText) ^ true) && (StringsKt.isBlank(this.firstTextColor) ^ true) && (StringsKt.isBlank(this.firstTextColorNight) ^ true);
    }
}
