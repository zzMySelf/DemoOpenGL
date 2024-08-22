package com.baidu.searchbox.flowvideo.similarcollection.mapper;

import com.baidu.searchbox.flowvideo.collection.repos.CollectionItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/flowvideo/similarcollection/mapper/SimilarCollectionListModel;", "", "items", "", "Lcom/baidu/searchbox/flowvideo/collection/repos/CollectionItemModel;", "catalogue", "", "hasMore", "", "(Ljava/util/List;Ljava/lang/String;Z)V", "getCatalogue", "()Ljava/lang/String;", "getHasMore", "()Z", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimilarCollectionListModel.kt */
public final class SimilarCollectionListModel {
    private final String catalogue;
    private final boolean hasMore;
    private final List<CollectionItemModel> items;

    public SimilarCollectionListModel() {
        this((List) null, (String) null, false, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SimilarCollectionListModel copy$default(SimilarCollectionListModel similarCollectionListModel, List<CollectionItemModel> list, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = similarCollectionListModel.items;
        }
        if ((i2 & 2) != 0) {
            str = similarCollectionListModel.catalogue;
        }
        if ((i2 & 4) != 0) {
            z = similarCollectionListModel.hasMore;
        }
        return similarCollectionListModel.copy(list, str, z);
    }

    public final List<CollectionItemModel> component1() {
        return this.items;
    }

    public final String component2() {
        return this.catalogue;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final SimilarCollectionListModel copy(List<CollectionItemModel> list, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "catalogue");
        return new SimilarCollectionListModel(list, str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimilarCollectionListModel)) {
            return false;
        }
        SimilarCollectionListModel similarCollectionListModel = (SimilarCollectionListModel) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) similarCollectionListModel.items) && Intrinsics.areEqual((Object) this.catalogue, (Object) similarCollectionListModel.catalogue) && this.hasMore == similarCollectionListModel.hasMore;
    }

    public int hashCode() {
        List<CollectionItemModel> list = this.items;
        int hashCode = (((list == null ? 0 : list.hashCode()) * 31) + this.catalogue.hashCode()) * 31;
        boolean z = this.hasMore;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "SimilarCollectionListModel(items=" + this.items + ", catalogue=" + this.catalogue + ", hasMore=" + this.hasMore + ')';
    }

    public SimilarCollectionListModel(List<CollectionItemModel> items2, String catalogue2, boolean hasMore2) {
        Intrinsics.checkNotNullParameter(catalogue2, "catalogue");
        this.items = items2;
        this.catalogue = catalogue2;
        this.hasMore = hasMore2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimilarCollectionListModel(List list, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? false : z);
    }

    public final List<CollectionItemModel> getItems() {
        return this.items;
    }

    public final String getCatalogue() {
        return this.catalogue;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }
}
