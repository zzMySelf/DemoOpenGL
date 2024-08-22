package com.baidu.searchbox.feed.video.videofullrecommend.bean;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0003\u001a\u0004\u0018\u00018\u00008\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/feed/video/videofullrecommend/bean/RecommendDataBean;", "T", "Lcom/baidu/searchbox/NoProGuard;", "cmdCode", "(Ljava/lang/Object;)V", "getCmdCode", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/baidu/searchbox/feed/video/videofullrecommend/bean/RecommendDataBean;", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFullRecommendBean.kt */
public final class RecommendDataBean<T> implements NoProGuard {
    @SerializedName("352")
    private final T cmdCode;

    public RecommendDataBean() {
        this((Object) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecommendDataBean copy$default(RecommendDataBean recommendDataBean, T t, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            t = recommendDataBean.cmdCode;
        }
        return recommendDataBean.copy(t);
    }

    public final T component1() {
        return this.cmdCode;
    }

    public final RecommendDataBean<T> copy(T t) {
        return new RecommendDataBean<>(t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RecommendDataBean) && Intrinsics.areEqual((Object) this.cmdCode, (Object) ((RecommendDataBean) obj).cmdCode);
    }

    public int hashCode() {
        T t = this.cmdCode;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public String toString() {
        return "RecommendDataBean(cmdCode=" + this.cmdCode + ')';
    }

    public RecommendDataBean(T cmdCode2) {
        this.cmdCode = cmdCode2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecommendDataBean(Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : obj);
    }

    public final T getCmdCode() {
        return this.cmdCode;
    }
}
