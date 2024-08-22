package com.baidu.searchbox.flowvideo.collection.repos;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/flowvideo/collection/repos/BaikeContentModel;", "", "nid", "", "index", "", "(Ljava/lang/String;I)V", "getIndex", "()I", "getNid", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionListModel.kt */
public final class BaikeContentModel {
    private final int index;
    private final String nid;

    public BaikeContentModel() {
        this((String) null, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BaikeContentModel copy$default(BaikeContentModel baikeContentModel, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = baikeContentModel.nid;
        }
        if ((i3 & 2) != 0) {
            i2 = baikeContentModel.index;
        }
        return baikeContentModel.copy(str, i2);
    }

    public final String component1() {
        return this.nid;
    }

    public final int component2() {
        return this.index;
    }

    public final BaikeContentModel copy(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "nid");
        return new BaikeContentModel(str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaikeContentModel)) {
            return false;
        }
        BaikeContentModel baikeContentModel = (BaikeContentModel) obj;
        return Intrinsics.areEqual((Object) this.nid, (Object) baikeContentModel.nid) && this.index == baikeContentModel.index;
    }

    public int hashCode() {
        return (this.nid.hashCode() * 31) + Integer.hashCode(this.index);
    }

    public String toString() {
        return "BaikeContentModel(nid=" + this.nid + ", index=" + this.index + ')';
    }

    public BaikeContentModel(String nid2, int index2) {
        Intrinsics.checkNotNullParameter(nid2, "nid");
        this.nid = nid2;
        this.index = index2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaikeContentModel(String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? -1 : i2);
    }

    public final String getNid() {
        return this.nid;
    }

    public final int getIndex() {
        return this.index;
    }
}
