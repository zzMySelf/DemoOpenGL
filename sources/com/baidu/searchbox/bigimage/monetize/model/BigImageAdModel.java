package com.baidu.searchbox.bigimage.monetize.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0013\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\u0006\u0010(\u001a\u00020%J\u0006\u0010)\u001a\u00020%J\t\u0010*\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u0004R\u001a\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001c¨\u0006+"}, d2 = {"Lcom/baidu/searchbox/bigimage/monetize/model/BigImageAdModel;", "", "tplType", "", "(I)V", "extraLog", "", "getExtraLog", "()Ljava/lang/String;", "setExtraLog", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", "imageUrl", "getImageUrl", "setImageUrl", "intro", "getIntro", "setIntro", "landingUrl", "getLandingUrl", "setLandingUrl", "parallelChargeUrl", "getParallelChargeUrl", "setParallelChargeUrl", "position", "getPosition", "()I", "setPosition", "title", "getTitle", "setTitle", "getTplType", "component1", "copy", "equals", "", "other", "hashCode", "isDownload", "isLink", "toString", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BigImageAdModel.kt */
public final class BigImageAdModel {
    private String extraLog = "";
    private String iconUrl = "";
    private String imageUrl = "";
    private String intro = "";
    private String landingUrl = "";
    private String parallelChargeUrl = "";
    private int position;
    private String title = "";
    private final int tplType;

    public static /* synthetic */ BigImageAdModel copy$default(BigImageAdModel bigImageAdModel, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = bigImageAdModel.tplType;
        }
        return bigImageAdModel.copy(i2);
    }

    public final int component1() {
        return this.tplType;
    }

    public final BigImageAdModel copy(int i2) {
        return new BigImageAdModel(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BigImageAdModel) && this.tplType == ((BigImageAdModel) obj).tplType;
    }

    public int hashCode() {
        return Integer.hashCode(this.tplType);
    }

    public String toString() {
        return "BigImageAdModel(tplType=" + this.tplType + ')';
    }

    public BigImageAdModel(int tplType2) {
        this.tplType = tplType2;
    }

    public final int getTplType() {
        return this.tplType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getIntro() {
        return this.intro;
    }

    public final void setIntro(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.intro = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }

    public final String getLandingUrl() {
        return this.landingUrl;
    }

    public final void setLandingUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.landingUrl = str;
    }

    public final String getParallelChargeUrl() {
        return this.parallelChargeUrl;
    }

    public final void setParallelChargeUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.parallelChargeUrl = str;
    }

    public final String getExtraLog() {
        return this.extraLog;
    }

    public final void setExtraLog(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extraLog = str;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i2) {
        this.position = i2;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconUrl = str;
    }

    public final boolean isLink() {
        return this.tplType == 1;
    }

    public final boolean isDownload() {
        return this.tplType == 2;
    }
}
