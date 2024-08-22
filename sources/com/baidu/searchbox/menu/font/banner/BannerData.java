package com.baidu.searchbox.menu.font.banner;

import com.baidu.searchbox.skin.NightModeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\b\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/menu/font/banner/BannerData;", "", "imageUrl", "", "imageUrlNight", "scheme", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "getImageUrlNight", "setImageUrlNight", "(Ljava/lang/String;)V", "getScheme", "setScheme", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-menu-font_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FontBannerManager.kt */
public final class BannerData {
    private final String imageUrl;
    private String imageUrlNight;
    private String scheme;

    public BannerData() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BannerData copy$default(BannerData bannerData, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bannerData.imageUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = bannerData.imageUrlNight;
        }
        if ((i2 & 4) != 0) {
            str3 = bannerData.scheme;
        }
        return bannerData.copy(str, str2, str3);
    }

    public final String component1() {
        return this.imageUrl;
    }

    public final String component2() {
        return this.imageUrlNight;
    }

    public final String component3() {
        return this.scheme;
    }

    public final BannerData copy(String str, String str2, String str3) {
        return new BannerData(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannerData)) {
            return false;
        }
        BannerData bannerData = (BannerData) obj;
        return Intrinsics.areEqual((Object) this.imageUrl, (Object) bannerData.imageUrl) && Intrinsics.areEqual((Object) this.imageUrlNight, (Object) bannerData.imageUrlNight) && Intrinsics.areEqual((Object) this.scheme, (Object) bannerData.scheme);
    }

    public int hashCode() {
        String str = this.imageUrl;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.imageUrlNight;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.scheme;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "BannerData(imageUrl=" + this.imageUrl + ", imageUrlNight=" + this.imageUrlNight + ", scheme=" + this.scheme + ')';
    }

    public BannerData(String imageUrl2, String imageUrlNight2, String scheme2) {
        this.imageUrl = imageUrl2;
        this.imageUrlNight = imageUrlNight2;
        this.scheme = scheme2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BannerData(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getImageUrlNight() {
        return this.imageUrlNight;
    }

    public final void setImageUrlNight(String str) {
        this.imageUrlNight = str;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final void setScheme(String str) {
        this.scheme = str;
    }

    public final String imageUrl() {
        if (NightModeHelper.isNightMode()) {
            return this.imageUrlNight;
        }
        return this.imageUrl;
    }
}
