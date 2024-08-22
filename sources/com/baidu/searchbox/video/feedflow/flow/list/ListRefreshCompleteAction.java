package com.baidu.searchbox.video.feedflow.flow.list;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u001b\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/list/ListRefreshCompleteAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "direction", "", "isFirst", "", "itemDataList", "", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "curFlowModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/FlowModel;", "(Ljava/lang/String;ZLjava/util/List;Lcom/baidu/searchbox/video/feedflow/flow/list/FlowModel;)V", "getCurFlowModel", "()Lcom/baidu/searchbox/video/feedflow/flow/list/FlowModel;", "getDirection", "()Ljava/lang/String;", "()Z", "getItemDataList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: FlowActionManifest.kt */
public final class ListRefreshCompleteAction implements Action {
    private final FlowModel curFlowModel;
    private final String direction;
    private final boolean isFirst;
    private final List<ItemModel<?>> itemDataList;

    public static /* synthetic */ ListRefreshCompleteAction copy$default(ListRefreshCompleteAction listRefreshCompleteAction, String str, boolean z, List<ItemModel<?>> list, FlowModel flowModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = listRefreshCompleteAction.direction;
        }
        if ((i2 & 2) != 0) {
            z = listRefreshCompleteAction.isFirst;
        }
        if ((i2 & 4) != 0) {
            list = listRefreshCompleteAction.itemDataList;
        }
        if ((i2 & 8) != 0) {
            flowModel = listRefreshCompleteAction.curFlowModel;
        }
        return listRefreshCompleteAction.copy(str, z, list, flowModel);
    }

    public final String component1() {
        return this.direction;
    }

    public final boolean component2() {
        return this.isFirst;
    }

    public final List<ItemModel<?>> component3() {
        return this.itemDataList;
    }

    public final FlowModel component4() {
        return this.curFlowModel;
    }

    public final ListRefreshCompleteAction copy(String str, boolean z, List<ItemModel<?>> list, FlowModel flowModel) {
        Intrinsics.checkNotNullParameter(str, "direction");
        Intrinsics.checkNotNullParameter(list, "itemDataList");
        return new ListRefreshCompleteAction(str, z, list, flowModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListRefreshCompleteAction)) {
            return false;
        }
        ListRefreshCompleteAction listRefreshCompleteAction = (ListRefreshCompleteAction) obj;
        return Intrinsics.areEqual((Object) this.direction, (Object) listRefreshCompleteAction.direction) && this.isFirst == listRefreshCompleteAction.isFirst && Intrinsics.areEqual((Object) this.itemDataList, (Object) listRefreshCompleteAction.itemDataList) && Intrinsics.areEqual((Object) this.curFlowModel, (Object) listRefreshCompleteAction.curFlowModel);
    }

    public int hashCode() {
        int hashCode = this.direction.hashCode() * 31;
        boolean z = this.isFirst;
        if (z) {
            z = true;
        }
        int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + this.itemDataList.hashCode()) * 31;
        FlowModel flowModel = this.curFlowModel;
        return hashCode2 + (flowModel == null ? 0 : flowModel.hashCode());
    }

    public String toString() {
        return "ListRefreshCompleteAction(direction=" + this.direction + ", isFirst=" + this.isFirst + ", itemDataList=" + this.itemDataList + ", curFlowModel=" + this.curFlowModel + ')';
    }

    public ListRefreshCompleteAction(String direction2, boolean isFirst2, List<ItemModel<?>> itemDataList2, FlowModel curFlowModel2) {
        Intrinsics.checkNotNullParameter(direction2, "direction");
        Intrinsics.checkNotNullParameter(itemDataList2, "itemDataList");
        this.direction = direction2;
        this.isFirst = isFirst2;
        this.itemDataList = itemDataList2;
        this.curFlowModel = curFlowModel2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListRefreshCompleteAction(String str, boolean z, List list, FlowModel flowModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, list, (i2 & 8) != 0 ? null : flowModel);
    }

    public final String getDirection() {
        return this.direction;
    }

    public final boolean isFirst() {
        return this.isFirst;
    }

    public final List<ItemModel<?>> getItemDataList() {
        return this.itemDataList;
    }

    public final FlowModel getCurFlowModel() {
        return this.curFlowModel;
    }
}
