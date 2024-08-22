package com.baidu.searchbox.flowvideo.detail.api;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/api/RecommendNextContentBean;", "Lcom/baidu/searchbox/NoProGuard;", "title", "", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailBean.kt */
public final class RecommendNextContentBean implements NoProGuard {
    private String title;

    public RecommendNextContentBean() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecommendNextContentBean copy$default(RecommendNextContentBean recommendNextContentBean, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = recommendNextContentBean.title;
        }
        return recommendNextContentBean.copy(str);
    }

    public final String component1() {
        return this.title;
    }

    public final RecommendNextContentBean copy(String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new RecommendNextContentBean(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RecommendNextContentBean) && Intrinsics.areEqual((Object) this.title, (Object) ((RecommendNextContentBean) obj).title);
    }

    public int hashCode() {
        return this.title.hashCode();
    }

    public String toString() {
        return "RecommendNextContentBean(title=" + this.title + ')';
    }

    public RecommendNextContentBean(String title2) {
        Intrinsics.checkNotNullParameter(title2, "title");
        this.title = title2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecommendNextContentBean(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
