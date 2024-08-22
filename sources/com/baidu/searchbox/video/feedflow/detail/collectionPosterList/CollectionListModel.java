package com.baidu.searchbox.video.feedflow.detail.collectionPosterList;

import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0012\u0010\u0002\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0015\u0010\u000e\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/collectionPosterList/CollectionListModel;", "", "data", "", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "hasPre", "", "hasMore", "(Ljava/util/List;ZZ)V", "getData", "()Ljava/util/List;", "getHasMore", "()Z", "getHasPre", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionPosterListView.kt */
public final class CollectionListModel {
    private final List<ItemModel<?>> data;
    private final boolean hasMore;
    private final boolean hasPre;

    public static /* synthetic */ CollectionListModel copy$default(CollectionListModel collectionListModel, List<ItemModel<?>> list, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = collectionListModel.data;
        }
        if ((i2 & 2) != 0) {
            z = collectionListModel.hasPre;
        }
        if ((i2 & 4) != 0) {
            z2 = collectionListModel.hasMore;
        }
        return collectionListModel.copy(list, z, z2);
    }

    public final List<ItemModel<?>> component1() {
        return this.data;
    }

    public final boolean component2() {
        return this.hasPre;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final CollectionListModel copy(List<ItemModel<?>> list, boolean z, boolean z2) {
        return new CollectionListModel(list, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CollectionListModel)) {
            return false;
        }
        CollectionListModel collectionListModel = (CollectionListModel) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) collectionListModel.data) && this.hasPre == collectionListModel.hasPre && this.hasMore == collectionListModel.hasMore;
    }

    public int hashCode() {
        List<ItemModel<?>> list = this.data;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        boolean z = this.hasPre;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.hasMore;
        if (!z3) {
            z2 = z3;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "CollectionListModel(data=" + this.data + ", hasPre=" + this.hasPre + ", hasMore=" + this.hasMore + ')';
    }

    public CollectionListModel(List<ItemModel<?>> data2, boolean hasPre2, boolean hasMore2) {
        this.data = data2;
        this.hasPre = hasPre2;
        this.hasMore = hasMore2;
    }

    public final List<ItemModel<?>> getData() {
        return this.data;
    }

    public final boolean getHasPre() {
        return this.hasPre;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }
}
