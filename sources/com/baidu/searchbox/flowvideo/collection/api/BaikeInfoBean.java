package com.baidu.searchbox.flowvideo.collection.api;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/flowvideo/collection/api/BaikeInfoBean;", "Lcom/baidu/searchbox/NoProGuard;", "lemmaTitle", "", "lemmaAbstract", "lemmaDesc", "lemmaUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLemmaAbstract", "()Ljava/lang/String;", "getLemmaDesc", "getLemmaTitle", "getLemmaUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionListBean.kt */
public final class BaikeInfoBean implements NoProGuard {
    private final String lemmaAbstract;
    private final String lemmaDesc;
    private final String lemmaTitle;
    private final String lemmaUrl;

    public BaikeInfoBean() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BaikeInfoBean copy$default(BaikeInfoBean baikeInfoBean, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = baikeInfoBean.lemmaTitle;
        }
        if ((i2 & 2) != 0) {
            str2 = baikeInfoBean.lemmaAbstract;
        }
        if ((i2 & 4) != 0) {
            str3 = baikeInfoBean.lemmaDesc;
        }
        if ((i2 & 8) != 0) {
            str4 = baikeInfoBean.lemmaUrl;
        }
        return baikeInfoBean.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.lemmaTitle;
    }

    public final String component2() {
        return this.lemmaAbstract;
    }

    public final String component3() {
        return this.lemmaDesc;
    }

    public final String component4() {
        return this.lemmaUrl;
    }

    public final BaikeInfoBean copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "lemmaTitle");
        Intrinsics.checkNotNullParameter(str2, "lemmaAbstract");
        Intrinsics.checkNotNullParameter(str3, "lemmaDesc");
        Intrinsics.checkNotNullParameter(str4, "lemmaUrl");
        return new BaikeInfoBean(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaikeInfoBean)) {
            return false;
        }
        BaikeInfoBean baikeInfoBean = (BaikeInfoBean) obj;
        return Intrinsics.areEqual((Object) this.lemmaTitle, (Object) baikeInfoBean.lemmaTitle) && Intrinsics.areEqual((Object) this.lemmaAbstract, (Object) baikeInfoBean.lemmaAbstract) && Intrinsics.areEqual((Object) this.lemmaDesc, (Object) baikeInfoBean.lemmaDesc) && Intrinsics.areEqual((Object) this.lemmaUrl, (Object) baikeInfoBean.lemmaUrl);
    }

    public int hashCode() {
        return (((((this.lemmaTitle.hashCode() * 31) + this.lemmaAbstract.hashCode()) * 31) + this.lemmaDesc.hashCode()) * 31) + this.lemmaUrl.hashCode();
    }

    public String toString() {
        return "BaikeInfoBean(lemmaTitle=" + this.lemmaTitle + ", lemmaAbstract=" + this.lemmaAbstract + ", lemmaDesc=" + this.lemmaDesc + ", lemmaUrl=" + this.lemmaUrl + ')';
    }

    public BaikeInfoBean(String lemmaTitle2, String lemmaAbstract2, String lemmaDesc2, String lemmaUrl2) {
        Intrinsics.checkNotNullParameter(lemmaTitle2, "lemmaTitle");
        Intrinsics.checkNotNullParameter(lemmaAbstract2, "lemmaAbstract");
        Intrinsics.checkNotNullParameter(lemmaDesc2, "lemmaDesc");
        Intrinsics.checkNotNullParameter(lemmaUrl2, "lemmaUrl");
        this.lemmaTitle = lemmaTitle2;
        this.lemmaAbstract = lemmaAbstract2;
        this.lemmaDesc = lemmaDesc2;
        this.lemmaUrl = lemmaUrl2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaikeInfoBean(String str, String str2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4);
    }

    public final String getLemmaTitle() {
        return this.lemmaTitle;
    }

    public final String getLemmaAbstract() {
        return this.lemmaAbstract;
    }

    public final String getLemmaDesc() {
        return this.lemmaDesc;
    }

    public final String getLemmaUrl() {
        return this.lemmaUrl;
    }
}
