package com.baidu.searchbox.flowvideo.detail.api;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/api/TopOperationRetentionBean;", "Lcom/baidu/searchbox/NoProGuard;", "title", "", "subTitle", "(Ljava/lang/String;Ljava/lang/String;)V", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "getTitle", "setTitle", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailBean.kt */
public final class TopOperationRetentionBean implements NoProGuard {
    private String subTitle;
    private String title;

    public TopOperationRetentionBean() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TopOperationRetentionBean copy$default(TopOperationRetentionBean topOperationRetentionBean, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = topOperationRetentionBean.title;
        }
        if ((i2 & 2) != 0) {
            str2 = topOperationRetentionBean.subTitle;
        }
        return topOperationRetentionBean.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final TopOperationRetentionBean copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subTitle");
        return new TopOperationRetentionBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TopOperationRetentionBean)) {
            return false;
        }
        TopOperationRetentionBean topOperationRetentionBean = (TopOperationRetentionBean) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) topOperationRetentionBean.title) && Intrinsics.areEqual((Object) this.subTitle, (Object) topOperationRetentionBean.subTitle);
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.subTitle.hashCode();
    }

    public String toString() {
        return "TopOperationRetentionBean(title=" + this.title + ", subTitle=" + this.subTitle + ')';
    }

    public TopOperationRetentionBean(String title2, String subTitle2) {
        Intrinsics.checkNotNullParameter(title2, "title");
        Intrinsics.checkNotNullParameter(subTitle2, "subTitle");
        this.title = title2;
        this.subTitle = subTitle2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopOperationRetentionBean(String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2);
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
}
