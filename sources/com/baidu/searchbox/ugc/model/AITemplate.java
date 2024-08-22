package com.baidu.searchbox.ugc.model;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/ugc/model/AITemplate;", "Lcom/baidu/searchbox/NoProGuard;", "type", "", "tipName", "placeHolder", "tipIcon", "tipDarkIcon", "tipSelectedIcon", "tipDarkSelectedIcon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isSelected", "", "()Z", "setSelected", "(Z)V", "getPlaceHolder", "()Ljava/lang/String;", "setPlaceHolder", "(Ljava/lang/String;)V", "getTipDarkIcon", "setTipDarkIcon", "getTipDarkSelectedIcon", "setTipDarkSelectedIcon", "getTipIcon", "setTipIcon", "getTipName", "setTipName", "getTipSelectedIcon", "setTipSelectedIcon", "getType", "setType", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfigModel.kt */
public final class AITemplate implements NoProGuard {
    private boolean isSelected;
    @SerializedName("place_holder")
    private String placeHolder;
    @SerializedName("dark_icon")
    private String tipDarkIcon;
    @SerializedName("dark_selected_icon")
    private String tipDarkSelectedIcon;
    @SerializedName("icon")
    private String tipIcon;
    @SerializedName("name")
    private String tipName;
    @SerializedName("selected_icon")
    private String tipSelectedIcon;
    @SerializedName("type")
    private String type;

    public AITemplate(String type2, String tipName2, String placeHolder2, String tipIcon2, String tipDarkIcon2, String tipSelectedIcon2, String tipDarkSelectedIcon2) {
        this.type = type2;
        this.tipName = tipName2;
        this.placeHolder = placeHolder2;
        this.tipIcon = tipIcon2;
        this.tipDarkIcon = tipDarkIcon2;
        this.tipSelectedIcon = tipSelectedIcon2;
        this.tipDarkSelectedIcon = tipDarkSelectedIcon2;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getTipName() {
        return this.tipName;
    }

    public final void setTipName(String str) {
        this.tipName = str;
    }

    public final String getPlaceHolder() {
        return this.placeHolder;
    }

    public final void setPlaceHolder(String str) {
        this.placeHolder = str;
    }

    public final String getTipIcon() {
        return this.tipIcon;
    }

    public final void setTipIcon(String str) {
        this.tipIcon = str;
    }

    public final String getTipDarkIcon() {
        return this.tipDarkIcon;
    }

    public final void setTipDarkIcon(String str) {
        this.tipDarkIcon = str;
    }

    public final String getTipSelectedIcon() {
        return this.tipSelectedIcon;
    }

    public final void setTipSelectedIcon(String str) {
        this.tipSelectedIcon = str;
    }

    public final String getTipDarkSelectedIcon() {
        return this.tipDarkSelectedIcon;
    }

    public final void setTipDarkSelectedIcon(String str) {
        this.tipDarkSelectedIcon = str;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
