package com.baidu.searchbox.account.userinfo.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003JM\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/data/PPJustWatchVideosResult;", "", "isSuccess", "", "hasAscMore", "ascCTime", "", "hasDesMore", "desCTime", "videos", "", "Lcom/baidu/searchbox/account/userinfo/data/PPVideoEntity;", "(ZZLjava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "getAscCTime", "()Ljava/lang/String;", "setAscCTime", "(Ljava/lang/String;)V", "getDesCTime", "setDesCTime", "getHasAscMore", "()Z", "setHasAscMore", "(Z)V", "getHasDesMore", "setHasDesMore", "setSuccess", "getVideos", "()Ljava/util/List;", "setVideos", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PPJustWatchVideosResult.kt */
public final class PPJustWatchVideosResult {
    private String ascCTime;
    private String desCTime;
    private boolean hasAscMore;
    private boolean hasDesMore;
    private boolean isSuccess;
    private List<PPVideoEntity> videos;

    public PPJustWatchVideosResult() {
        this(false, false, (String) null, false, (String) null, (List) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PPJustWatchVideosResult copy$default(PPJustWatchVideosResult pPJustWatchVideosResult, boolean z, boolean z2, String str, boolean z3, String str2, List<PPVideoEntity> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = pPJustWatchVideosResult.isSuccess;
        }
        if ((i2 & 2) != 0) {
            z2 = pPJustWatchVideosResult.hasAscMore;
        }
        boolean z4 = z2;
        if ((i2 & 4) != 0) {
            str = pPJustWatchVideosResult.ascCTime;
        }
        String str3 = str;
        if ((i2 & 8) != 0) {
            z3 = pPJustWatchVideosResult.hasDesMore;
        }
        boolean z5 = z3;
        if ((i2 & 16) != 0) {
            str2 = pPJustWatchVideosResult.desCTime;
        }
        String str4 = str2;
        if ((i2 & 32) != 0) {
            list = pPJustWatchVideosResult.videos;
        }
        return pPJustWatchVideosResult.copy(z, z4, str3, z5, str4, list);
    }

    public final boolean component1() {
        return this.isSuccess;
    }

    public final boolean component2() {
        return this.hasAscMore;
    }

    public final String component3() {
        return this.ascCTime;
    }

    public final boolean component4() {
        return this.hasDesMore;
    }

    public final String component5() {
        return this.desCTime;
    }

    public final List<PPVideoEntity> component6() {
        return this.videos;
    }

    public final PPJustWatchVideosResult copy(boolean z, boolean z2, String str, boolean z3, String str2, List<PPVideoEntity> list) {
        Intrinsics.checkNotNullParameter(str, "ascCTime");
        Intrinsics.checkNotNullParameter(str2, "desCTime");
        return new PPJustWatchVideosResult(z, z2, str, z3, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PPJustWatchVideosResult)) {
            return false;
        }
        PPJustWatchVideosResult pPJustWatchVideosResult = (PPJustWatchVideosResult) obj;
        return this.isSuccess == pPJustWatchVideosResult.isSuccess && this.hasAscMore == pPJustWatchVideosResult.hasAscMore && Intrinsics.areEqual((Object) this.ascCTime, (Object) pPJustWatchVideosResult.ascCTime) && this.hasDesMore == pPJustWatchVideosResult.hasDesMore && Intrinsics.areEqual((Object) this.desCTime, (Object) pPJustWatchVideosResult.desCTime) && Intrinsics.areEqual((Object) this.videos, (Object) pPJustWatchVideosResult.videos);
    }

    public int hashCode() {
        boolean z = this.isSuccess;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.hasAscMore;
        if (z3) {
            z3 = true;
        }
        int hashCode = (((i2 + (z3 ? 1 : 0)) * 31) + this.ascCTime.hashCode()) * 31;
        boolean z4 = this.hasDesMore;
        if (!z4) {
            z2 = z4;
        }
        int hashCode2 = (((hashCode + (z2 ? 1 : 0)) * 31) + this.desCTime.hashCode()) * 31;
        List<PPVideoEntity> list = this.videos;
        return hashCode2 + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "PPJustWatchVideosResult(isSuccess=" + this.isSuccess + ", hasAscMore=" + this.hasAscMore + ", ascCTime=" + this.ascCTime + ", hasDesMore=" + this.hasDesMore + ", desCTime=" + this.desCTime + ", videos=" + this.videos + ')';
    }

    public PPJustWatchVideosResult(boolean isSuccess2, boolean hasAscMore2, String ascCTime2, boolean hasDesMore2, String desCTime2, List<PPVideoEntity> videos2) {
        Intrinsics.checkNotNullParameter(ascCTime2, "ascCTime");
        Intrinsics.checkNotNullParameter(desCTime2, "desCTime");
        this.isSuccess = isSuccess2;
        this.hasAscMore = hasAscMore2;
        this.ascCTime = ascCTime2;
        this.hasDesMore = hasDesMore2;
        this.desCTime = desCTime2;
        this.videos = videos2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PPJustWatchVideosResult(boolean z, boolean z2, String str, boolean z3, String str2, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? false : z3, (i2 & 16) != 0 ? "" : str2, (i2 & 32) != 0 ? null : list);
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final void setSuccess(boolean z) {
        this.isSuccess = z;
    }

    public final boolean getHasAscMore() {
        return this.hasAscMore;
    }

    public final void setHasAscMore(boolean z) {
        this.hasAscMore = z;
    }

    public final String getAscCTime() {
        return this.ascCTime;
    }

    public final void setAscCTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ascCTime = str;
    }

    public final boolean getHasDesMore() {
        return this.hasDesMore;
    }

    public final void setHasDesMore(boolean z) {
        this.hasDesMore = z;
    }

    public final String getDesCTime() {
        return this.desCTime;
    }

    public final void setDesCTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desCTime = str;
    }

    public final List<PPVideoEntity> getVideos() {
        return this.videos;
    }

    public final void setVideos(List<PPVideoEntity> list) {
        this.videos = list;
    }
}
