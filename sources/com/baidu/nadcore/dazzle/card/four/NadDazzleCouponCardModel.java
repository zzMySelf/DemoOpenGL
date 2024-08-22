package com.baidu.nadcore.dazzle.card.four;

import android.text.TextUtils;
import com.baidu.nadcore.dazzle.card.CardType;
import com.baidu.nadcore.dazzle.card.NadDazzleBaseCardModel;
import com.baidu.nadcore.download.model.AdDownloadCopy;
import com.baidu.searchbox.home.tabs.constants.HomeTabIconBubbleConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001!B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001fH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006\""}, d2 = {"Lcom/baidu/nadcore/dazzle/card/four/NadDazzleCouponCardModel;", "Lcom/baidu/nadcore/dazzle/card/NadDazzleBaseCardModel;", "title", "", "subTitle", "copy", "Lcom/baidu/nadcore/download/model/AdDownloadCopy;", "button", "Lcom/baidu/nadcore/dazzle/card/four/NadDazzleCouponCardModel$Button;", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/nadcore/download/model/AdDownloadCopy;Lcom/baidu/nadcore/dazzle/card/four/NadDazzleCouponCardModel$Button;)V", "getButton", "()Lcom/baidu/nadcore/dazzle/card/four/NadDazzleCouponCardModel$Button;", "setButton", "(Lcom/baidu/nadcore/dazzle/card/four/NadDazzleCouponCardModel$Button;)V", "getCopy", "()Lcom/baidu/nadcore/download/model/AdDownloadCopy;", "setCopy", "(Lcom/baidu/nadcore/download/model/AdDownloadCopy;)V", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "getTitle", "setTitle", "isValid", "", "updateData", "", "json", "Lorg/json/JSONObject;", "info", "", "", "Button", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadDazzleCouponCardModel.kt */
public final class NadDazzleCouponCardModel extends NadDazzleBaseCardModel {
    private Button button;
    private AdDownloadCopy copy;
    private String subTitle;
    private String title;

    public NadDazzleCouponCardModel() {
        this((String) null, (String) null, (AdDownloadCopy) null, (Button) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NadDazzleCouponCardModel(String str, String str2, AdDownloadCopy adDownloadCopy, Button button2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? null : adDownloadCopy, (i2 & 8) != 0 ? null : button2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitle = str;
    }

    public final AdDownloadCopy getCopy() {
        return this.copy;
    }

    public final void setCopy(AdDownloadCopy adDownloadCopy) {
        this.copy = adDownloadCopy;
    }

    public final Button getButton() {
        return this.button;
    }

    public final void setButton(Button button2) {
        this.button = button2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NadDazzleCouponCardModel(String title2, String subTitle2, AdDownloadCopy copy2, Button button2) {
        super((CardType) null, (String) null, 3, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(title2, "title");
        Intrinsics.checkNotNullParameter(subTitle2, "subTitle");
        this.title = title2;
        this.subTitle = subTitle2;
        this.copy = copy2;
        this.button = button2;
    }

    public void updateData(JSONObject json, Map<String, ? extends Object> info) {
        Intrinsics.checkNotNullParameter(json, "json");
        super.updateData(json, info);
        String optString = json.optString("title");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"title\")");
        this.title = optString;
        String optString2 = json.optString("sub_title");
        Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"sub_title\")");
        this.subTitle = optString2;
        this.copy = AdDownloadCopy.fromJson(json.optJSONObject("copy"));
        Button.Companion companion = Button.Companion;
        JSONObject optJSONObject = json.optJSONObject("button");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        this.button = companion.fromJson(optJSONObject);
    }

    public boolean isValid() {
        if (!TextUtils.isEmpty(this.title) && !TextUtils.isEmpty(this.subTitle)) {
            Button button2 = this.button;
            if (button2 != null && button2.isValid()) {
                return true;
            }
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0006\u0010\u0018\u001a\u00020\u0019R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/baidu/nadcore/dazzle/card/four/NadDazzleCouponCardModel$Button;", "", "text", "", "textClicked", "textColor", "textColorClicked", "background", "backgroundClicked", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackground", "()Ljava/lang/String;", "setBackground", "(Ljava/lang/String;)V", "getBackgroundClicked", "setBackgroundClicked", "getText", "setText", "getTextClicked", "setTextClicked", "getTextColor", "setTextColor", "getTextColorClicked", "setTextColorClicked", "isValid", "", "Companion", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NadDazzleCouponCardModel.kt */
    public static final class Button {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String background;
        private String backgroundClicked;
        private String text;
        private String textClicked;
        private String textColor;
        private String textColorClicked;

        public Button() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public static final Button fromJson(JSONObject jSONObject) {
            return Companion.fromJson(jSONObject);
        }

        public Button(String text2, String textClicked2, String textColor2, String textColorClicked2, String background2, String backgroundClicked2) {
            Intrinsics.checkNotNullParameter(text2, "text");
            Intrinsics.checkNotNullParameter(textClicked2, "textClicked");
            Intrinsics.checkNotNullParameter(textColor2, HomeTabIconBubbleConstants.BUBBLE_TEXT_COLOR);
            Intrinsics.checkNotNullParameter(textColorClicked2, "textColorClicked");
            Intrinsics.checkNotNullParameter(background2, "background");
            Intrinsics.checkNotNullParameter(backgroundClicked2, "backgroundClicked");
            this.text = text2;
            this.textClicked = textClicked2;
            this.textColor = textColor2;
            this.textColorClicked = textColorClicked2;
            this.background = background2;
            this.backgroundClicked = backgroundClicked2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Button(String str, String str2, String str3, String str4, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6);
        }

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }

        public final String getTextClicked() {
            return this.textClicked;
        }

        public final void setTextClicked(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.textClicked = str;
        }

        public final String getTextColor() {
            return this.textColor;
        }

        public final void setTextColor(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.textColor = str;
        }

        public final String getTextColorClicked() {
            return this.textColorClicked;
        }

        public final void setTextColorClicked(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.textColorClicked = str;
        }

        public final String getBackground() {
            return this.background;
        }

        public final void setBackground(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.background = str;
        }

        public final String getBackgroundClicked() {
            return this.backgroundClicked;
        }

        public final void setBackgroundClicked(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.backgroundClicked = str;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/nadcore/dazzle/card/four/NadDazzleCouponCardModel$Button$Companion;", "", "()V", "fromJson", "Lcom/baidu/nadcore/dazzle/card/four/NadDazzleCouponCardModel$Button;", "json", "Lorg/json/JSONObject;", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: NadDazzleCouponCardModel.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Button fromJson(JSONObject json) {
                Intrinsics.checkNotNullParameter(json, "json");
                Button button = new Button((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
                String optString = json.optString("text");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"text\")");
                button.setText(optString);
                String optString2 = json.optString("text_clicked");
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"text_clicked\")");
                button.setTextClicked(optString2);
                String optString3 = json.optString("text_color");
                Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"text_color\")");
                button.setTextColor(optString3);
                String optString4 = json.optString("text_color_clicked");
                Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"text_color_clicked\")");
                button.setTextColorClicked(optString4);
                String optString5 = json.optString("background");
                Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(\"background\")");
                button.setBackground(optString5);
                String optString6 = json.optString("background_clicked");
                Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(\"background_clicked\")");
                button.setBackgroundClicked(optString6);
                return button;
            }
        }

        public final boolean isValid() {
            return !TextUtils.isEmpty(this.text);
        }
    }
}
