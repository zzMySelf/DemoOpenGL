package com.baidu.searchbox.video.feedflow.flow.list;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.arch.ext.ForeverAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005HÆ\u0003J#\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/list/ListDataChanged;", "Lcom/baidu/searchbox/feed/detail/arch/ext/ForeverAction;", "isInsertData", "", "lastVideoItemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "(ZLcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;)V", "()Z", "getLastVideoItemModel", "()Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: FlowActionManifest.kt */
public final class ListDataChanged implements ForeverAction {
    private final boolean isInsertData;
    private final ItemModel<?> lastVideoItemModel;

    public static /* synthetic */ ListDataChanged copy$default(ListDataChanged listDataChanged, boolean z, ItemModel<?> itemModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = listDataChanged.isInsertData;
        }
        if ((i2 & 2) != 0) {
            itemModel = listDataChanged.lastVideoItemModel;
        }
        return listDataChanged.copy(z, itemModel);
    }

    public final boolean component1() {
        return this.isInsertData;
    }

    public final ItemModel<?> component2() {
        return this.lastVideoItemModel;
    }

    public final ListDataChanged copy(boolean z, ItemModel<?> itemModel) {
        return new ListDataChanged(z, itemModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListDataChanged)) {
            return false;
        }
        ListDataChanged listDataChanged = (ListDataChanged) obj;
        return this.isInsertData == listDataChanged.isInsertData && Intrinsics.areEqual((Object) this.lastVideoItemModel, (Object) listDataChanged.lastVideoItemModel);
    }

    public int hashCode() {
        boolean z = this.isInsertData;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        ItemModel<?> itemModel = this.lastVideoItemModel;
        return i2 + (itemModel == null ? 0 : itemModel.hashCode());
    }

    public String toString() {
        return "ListDataChanged(isInsertData=" + this.isInsertData + ", lastVideoItemModel=" + this.lastVideoItemModel + ')';
    }

    public ListDataChanged(boolean isInsertData2, ItemModel<?> lastVideoItemModel2) {
        this.isInsertData = isInsertData2;
        this.lastVideoItemModel = lastVideoItemModel2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListDataChanged(boolean z, ItemModel itemModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i2 & 2) != 0 ? null : itemModel);
    }

    public final ItemModel<?> getLastVideoItemModel() {
        return this.lastVideoItemModel;
    }

    public final boolean isInsertData() {
        return this.isInsertData;
    }
}
