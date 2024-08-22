package com.baidu.searchbox.flowvideo.interest.api;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/flowvideo/interest/api/InterestTagsBgInfoBean;", "Lcom/baidu/searchbox/NoProGuard;", "type", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InterestTagsDataBean.kt */
public final class InterestTagsBgInfoBean implements NoProGuard {
    private final String type;
    private final String url;

    public InterestTagsBgInfoBean() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ InterestTagsBgInfoBean copy$default(InterestTagsBgInfoBean interestTagsBgInfoBean, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = interestTagsBgInfoBean.type;
        }
        if ((i2 & 2) != 0) {
            str2 = interestTagsBgInfoBean.url;
        }
        return interestTagsBgInfoBean.copy(str, str2);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.url;
    }

    public final InterestTagsBgInfoBean copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "url");
        return new InterestTagsBgInfoBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterestTagsBgInfoBean)) {
            return false;
        }
        InterestTagsBgInfoBean interestTagsBgInfoBean = (InterestTagsBgInfoBean) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) interestTagsBgInfoBean.type) && Intrinsics.areEqual((Object) this.url, (Object) interestTagsBgInfoBean.url);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.url.hashCode();
    }

    public String toString() {
        return "InterestTagsBgInfoBean(type=" + this.type + ", url=" + this.url + ')';
    }

    public InterestTagsBgInfoBean(String type2, String url2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(url2, "url");
        this.type = type2;
        this.url = url2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InterestTagsBgInfoBean(String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2);
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }
}
