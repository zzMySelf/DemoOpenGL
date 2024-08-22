package com.baidu.searchbox.video.feedflow.clearscreen;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.flow.list.FlowModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/clearscreen/ClearScreenNewCollectionAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "ReplaceDataSource", "ReplaceSingleData", "ReturnPlayerHolder", "Lcom/baidu/searchbox/video/feedflow/clearscreen/ClearScreenNewCollectionAction$ReturnPlayerHolder;", "Lcom/baidu/searchbox/video/feedflow/clearscreen/ClearScreenNewCollectionAction$ReplaceDataSource;", "Lcom/baidu/searchbox/video/feedflow/clearscreen/ClearScreenNewCollectionAction$ReplaceSingleData;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearScreenNewActionManifest.kt */
public abstract class ClearScreenNewCollectionAction implements Action {
    public /* synthetic */ ClearScreenNewCollectionAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ClearScreenNewCollectionAction() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/clearscreen/ClearScreenNewCollectionAction$ReturnPlayerHolder;", "Lcom/baidu/searchbox/video/feedflow/clearscreen/ClearScreenNewCollectionAction;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClearScreenNewActionManifest.kt */
    public static final class ReturnPlayerHolder extends ClearScreenNewCollectionAction {
        public static final ReturnPlayerHolder INSTANCE = new ReturnPlayerHolder();

        private ReturnPlayerHolder() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/clearscreen/ClearScreenNewCollectionAction$ReplaceDataSource;", "Lcom/baidu/searchbox/video/feedflow/clearscreen/ClearScreenNewCollectionAction;", "dataSource", "Lcom/baidu/searchbox/video/feedflow/flow/list/FlowModel;", "(Lcom/baidu/searchbox/video/feedflow/flow/list/FlowModel;)V", "getDataSource", "()Lcom/baidu/searchbox/video/feedflow/flow/list/FlowModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClearScreenNewActionManifest.kt */
    public static final class ReplaceDataSource extends ClearScreenNewCollectionAction {
        private final FlowModel dataSource;

        public static /* synthetic */ ReplaceDataSource copy$default(ReplaceDataSource replaceDataSource, FlowModel flowModel, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                flowModel = replaceDataSource.dataSource;
            }
            return replaceDataSource.copy(flowModel);
        }

        public final FlowModel component1() {
            return this.dataSource;
        }

        public final ReplaceDataSource copy(FlowModel flowModel) {
            Intrinsics.checkNotNullParameter(flowModel, "dataSource");
            return new ReplaceDataSource(flowModel);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ReplaceDataSource) && Intrinsics.areEqual((Object) this.dataSource, (Object) ((ReplaceDataSource) obj).dataSource);
        }

        public int hashCode() {
            return this.dataSource.hashCode();
        }

        public String toString() {
            return "ReplaceDataSource(dataSource=" + this.dataSource + ')';
        }

        public final FlowModel getDataSource() {
            return this.dataSource;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ReplaceDataSource(FlowModel dataSource2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(dataSource2, "dataSource");
            this.dataSource = dataSource2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\u0017\u0010\b\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/clearscreen/ClearScreenNewCollectionAction$ReplaceSingleData;", "Lcom/baidu/searchbox/video/feedflow/clearscreen/ClearScreenNewCollectionAction;", "itemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "(Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;)V", "getItemModel", "()Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClearScreenNewActionManifest.kt */
    public static final class ReplaceSingleData extends ClearScreenNewCollectionAction {
        private final ItemModel<?> itemModel;

        public static /* synthetic */ ReplaceSingleData copy$default(ReplaceSingleData replaceSingleData, ItemModel<?> itemModel2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                itemModel2 = replaceSingleData.itemModel;
            }
            return replaceSingleData.copy(itemModel2);
        }

        public final ItemModel<?> component1() {
            return this.itemModel;
        }

        public final ReplaceSingleData copy(ItemModel<?> itemModel2) {
            Intrinsics.checkNotNullParameter(itemModel2, "itemModel");
            return new ReplaceSingleData(itemModel2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ReplaceSingleData) && Intrinsics.areEqual((Object) this.itemModel, (Object) ((ReplaceSingleData) obj).itemModel);
        }

        public int hashCode() {
            return this.itemModel.hashCode();
        }

        public String toString() {
            return "ReplaceSingleData(itemModel=" + this.itemModel + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ReplaceSingleData(ItemModel<?> itemModel2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(itemModel2, "itemModel");
            this.itemModel = itemModel2;
        }

        public final ItemModel<?> getItemModel() {
            return this.itemModel;
        }
    }
}
