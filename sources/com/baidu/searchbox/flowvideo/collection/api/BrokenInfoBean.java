package com.baidu.searchbox.flowvideo.collection.api;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/flowvideo/collection/api/BrokenInfoBean;", "Lcom/baidu/searchbox/NoProGuard;", "isBroken", "", "brokenDesc", "", "(ILjava/lang/String;)V", "getBrokenDesc", "()Ljava/lang/String;", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionListBean.kt */
public final class BrokenInfoBean implements NoProGuard {
    private final String brokenDesc;
    private final int isBroken;

    public BrokenInfoBean() {
        this(0, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BrokenInfoBean copy$default(BrokenInfoBean brokenInfoBean, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = brokenInfoBean.isBroken;
        }
        if ((i3 & 2) != 0) {
            str = brokenInfoBean.brokenDesc;
        }
        return brokenInfoBean.copy(i2, str);
    }

    public final int component1() {
        return this.isBroken;
    }

    public final String component2() {
        return this.brokenDesc;
    }

    public final BrokenInfoBean copy(int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "brokenDesc");
        return new BrokenInfoBean(i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrokenInfoBean)) {
            return false;
        }
        BrokenInfoBean brokenInfoBean = (BrokenInfoBean) obj;
        return this.isBroken == brokenInfoBean.isBroken && Intrinsics.areEqual((Object) this.brokenDesc, (Object) brokenInfoBean.brokenDesc);
    }

    public int hashCode() {
        return (Integer.hashCode(this.isBroken) * 31) + this.brokenDesc.hashCode();
    }

    public String toString() {
        return "BrokenInfoBean(isBroken=" + this.isBroken + ", brokenDesc=" + this.brokenDesc + ')';
    }

    public BrokenInfoBean(int isBroken2, String brokenDesc2) {
        Intrinsics.checkNotNullParameter(brokenDesc2, "brokenDesc");
        this.isBroken = isBroken2;
        this.brokenDesc = brokenDesc2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BrokenInfoBean(int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? "" : str);
    }

    public final int isBroken() {
        return this.isBroken;
    }

    public final String getBrokenDesc() {
        return this.brokenDesc;
    }
}
