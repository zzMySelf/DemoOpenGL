package com.baidu.searchbox.ugc.model;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/ugc/model/UgcContentInfoModel;", "Lcom/baidu/searchbox/NoProGuard;", "size", "", "long", "mediaId", "", "src", "title", "videoInfo", "Lcom/baidu/searchbox/ugc/model/UgcContentVideoInfoModel;", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/ugc/model/UgcContentVideoInfoModel;)V", "getLong", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMediaId", "()Ljava/lang/String;", "getSize", "getSrc", "getTitle", "getVideoInfo", "()Lcom/baidu/searchbox/ugc/model/UgcContentVideoInfoModel;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/ugc/model/UgcContentVideoInfoModel;)Lcom/baidu/searchbox/ugc/model/UgcContentInfoModel;", "equals", "", "other", "", "hashCode", "", "toString", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UgcVideoArticleModel.kt */
public final class UgcContentInfoModel implements NoProGuard {
    @SerializedName("long")

    /* renamed from: long  reason: not valid java name */
    private final Long f14long;
    @SerializedName("mediaId")
    private final String mediaId;
    @SerializedName("size")
    private final Long size;
    @SerializedName("src")
    private final String src;
    @SerializedName("title")
    private final String title;
    @SerializedName("video")
    private final UgcContentVideoInfoModel videoInfo;

    public static /* synthetic */ UgcContentInfoModel copy$default(UgcContentInfoModel ugcContentInfoModel, Long l, Long l2, String str, String str2, String str3, UgcContentVideoInfoModel ugcContentVideoInfoModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l = ugcContentInfoModel.size;
        }
        if ((i2 & 2) != 0) {
            l2 = ugcContentInfoModel.f14long;
        }
        Long l3 = l2;
        if ((i2 & 4) != 0) {
            str = ugcContentInfoModel.mediaId;
        }
        String str4 = str;
        if ((i2 & 8) != 0) {
            str2 = ugcContentInfoModel.src;
        }
        String str5 = str2;
        if ((i2 & 16) != 0) {
            str3 = ugcContentInfoModel.title;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            ugcContentVideoInfoModel = ugcContentInfoModel.videoInfo;
        }
        return ugcContentInfoModel.copy(l, l3, str4, str5, str6, ugcContentVideoInfoModel);
    }

    public final Long component1() {
        return this.size;
    }

    public final Long component2() {
        return this.f14long;
    }

    public final String component3() {
        return this.mediaId;
    }

    public final String component4() {
        return this.src;
    }

    public final String component5() {
        return this.title;
    }

    public final UgcContentVideoInfoModel component6() {
        return this.videoInfo;
    }

    public final UgcContentInfoModel copy(Long l, Long l2, String str, String str2, String str3, UgcContentVideoInfoModel ugcContentVideoInfoModel) {
        return new UgcContentInfoModel(l, l2, str, str2, str3, ugcContentVideoInfoModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UgcContentInfoModel)) {
            return false;
        }
        UgcContentInfoModel ugcContentInfoModel = (UgcContentInfoModel) obj;
        return Intrinsics.areEqual((Object) this.size, (Object) ugcContentInfoModel.size) && Intrinsics.areEqual((Object) this.f14long, (Object) ugcContentInfoModel.f14long) && Intrinsics.areEqual((Object) this.mediaId, (Object) ugcContentInfoModel.mediaId) && Intrinsics.areEqual((Object) this.src, (Object) ugcContentInfoModel.src) && Intrinsics.areEqual((Object) this.title, (Object) ugcContentInfoModel.title) && Intrinsics.areEqual((Object) this.videoInfo, (Object) ugcContentInfoModel.videoInfo);
    }

    public int hashCode() {
        Long l = this.size;
        int i2 = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.f14long;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str = this.mediaId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.src;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        UgcContentVideoInfoModel ugcContentVideoInfoModel = this.videoInfo;
        if (ugcContentVideoInfoModel != null) {
            i2 = ugcContentVideoInfoModel.hashCode();
        }
        return hashCode5 + i2;
    }

    public String toString() {
        return "UgcContentInfoModel(size=" + this.size + ", long=" + this.f14long + ", mediaId=" + this.mediaId + ", src=" + this.src + ", title=" + this.title + ", videoInfo=" + this.videoInfo + ')';
    }

    public UgcContentInfoModel(Long size2, Long l, String mediaId2, String src2, String title2, UgcContentVideoInfoModel videoInfo2) {
        this.size = size2;
        this.f14long = l;
        this.mediaId = mediaId2;
        this.src = src2;
        this.title = title2;
        this.videoInfo = videoInfo2;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Long getLong() {
        return this.f14long;
    }

    public final String getMediaId() {
        return this.mediaId;
    }

    public final String getSrc() {
        return this.src;
    }

    public final String getTitle() {
        return this.title;
    }

    public final UgcContentVideoInfoModel getVideoInfo() {
        return this.videoInfo;
    }
}
