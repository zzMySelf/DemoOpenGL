package com.baidu.searchbox.ad.lp.reward.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/ad/lp/reward/data/WelfareDialogButtonData;", "", "jsonObj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "btnBackground", "", "getBtnBackground", "()Ljava/lang/String;", "setBtnBackground", "(Ljava/lang/String;)V", "btnCmd", "getBtnCmd", "setBtnCmd", "btnRightIcon", "getBtnRightIcon", "setBtnRightIcon", "btnText", "getBtnText", "setBtnText", "textColor", "getTextColor", "setTextColor", "lib-ad-lp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WelfareDialogButtonData.kt */
public final class WelfareDialogButtonData {
    private String btnBackground;
    private String btnCmd;
    private String btnRightIcon;
    private String btnText;
    private String textColor;

    public WelfareDialogButtonData(JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        JSONObject $this$_init__u24lambda_u2d0 = jsonObj;
        this.btnText = $this$_init__u24lambda_u2d0.optString("button_text");
        this.textColor = $this$_init__u24lambda_u2d0.optString("text_color");
        this.btnBackground = $this$_init__u24lambda_u2d0.optString("button_image");
        this.btnCmd = $this$_init__u24lambda_u2d0.optString("button_cmd");
        this.btnRightIcon = $this$_init__u24lambda_u2d0.optString("button_icon");
    }

    public final String getBtnText() {
        return this.btnText;
    }

    public final void setBtnText(String str) {
        this.btnText = str;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(String str) {
        this.textColor = str;
    }

    public final String getBtnBackground() {
        return this.btnBackground;
    }

    public final void setBtnBackground(String str) {
        this.btnBackground = str;
    }

    public final String getBtnCmd() {
        return this.btnCmd;
    }

    public final void setBtnCmd(String str) {
        this.btnCmd = str;
    }

    public final String getBtnRightIcon() {
        return this.btnRightIcon;
    }

    public final void setBtnRightIcon(String str) {
        this.btnRightIcon = str;
    }
}
