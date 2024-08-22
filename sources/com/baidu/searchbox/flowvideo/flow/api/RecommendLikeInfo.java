package com.baidu.searchbox.flowvideo.flow.api;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/flowvideo/flow/api/RecommendLikeInfo;", "Lcom/baidu/searchbox/NoProGuard;", "likeStatus", "", "likeCount", "", "(Ljava/lang/String;I)V", "getLikeCount", "()I", "setLikeCount", "(I)V", "getLikeStatus", "()Ljava/lang/String;", "setLikeStatus", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowListBean.kt */
public final class RecommendLikeInfo implements NoProGuard {
    @SerializedName("count")
    private int likeCount;
    @SerializedName("status")
    private String likeStatus;

    public RecommendLikeInfo() {
        this((String) null, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecommendLikeInfo copy$default(RecommendLikeInfo recommendLikeInfo, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = recommendLikeInfo.likeStatus;
        }
        if ((i3 & 2) != 0) {
            i2 = recommendLikeInfo.likeCount;
        }
        return recommendLikeInfo.copy(str, i2);
    }

    public final String component1() {
        return this.likeStatus;
    }

    public final int component2() {
        return this.likeCount;
    }

    public final RecommendLikeInfo copy(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "likeStatus");
        return new RecommendLikeInfo(str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecommendLikeInfo)) {
            return false;
        }
        RecommendLikeInfo recommendLikeInfo = (RecommendLikeInfo) obj;
        return Intrinsics.areEqual((Object) this.likeStatus, (Object) recommendLikeInfo.likeStatus) && this.likeCount == recommendLikeInfo.likeCount;
    }

    public int hashCode() {
        return (this.likeStatus.hashCode() * 31) + Integer.hashCode(this.likeCount);
    }

    public String toString() {
        return "RecommendLikeInfo(likeStatus=" + this.likeStatus + ", likeCount=" + this.likeCount + ')';
    }

    public RecommendLikeInfo(String likeStatus2, int likeCount2) {
        Intrinsics.checkNotNullParameter(likeStatus2, "likeStatus");
        this.likeStatus = likeStatus2;
        this.likeCount = likeCount2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecommendLikeInfo(String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "0" : str, (i3 & 2) != 0 ? 0 : i2);
    }

    public final String getLikeStatus() {
        return this.likeStatus;
    }

    public final void setLikeStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.likeStatus = str;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final void setLikeCount(int i2) {
        this.likeCount = i2;
    }
}
