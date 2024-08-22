package com.baidu.searchbox.video.feedflow.flow.list;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\r\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/list/InsertData;", "", "position", "", "itemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "(ILcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;)V", "getItemModel", "()Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "getPosition", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowState.kt */
public final class InsertData {
    private final ItemModel<?> itemModel;
    private final int position;

    public static /* synthetic */ InsertData copy$default(InsertData insertData, int i2, ItemModel<?> itemModel2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = insertData.position;
        }
        if ((i3 & 2) != 0) {
            itemModel2 = insertData.itemModel;
        }
        return insertData.copy(i2, itemModel2);
    }

    public final int component1() {
        return this.position;
    }

    public final ItemModel<?> component2() {
        return this.itemModel;
    }

    public final InsertData copy(int i2, ItemModel<?> itemModel2) {
        Intrinsics.checkNotNullParameter(itemModel2, "itemModel");
        return new InsertData(i2, itemModel2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsertData)) {
            return false;
        }
        InsertData insertData = (InsertData) obj;
        return this.position == insertData.position && Intrinsics.areEqual((Object) this.itemModel, (Object) insertData.itemModel);
    }

    public int hashCode() {
        return (Integer.hashCode(this.position) * 31) + this.itemModel.hashCode();
    }

    public InsertData(int position2, ItemModel<?> itemModel2) {
        Intrinsics.checkNotNullParameter(itemModel2, "itemModel");
        this.position = position2;
        this.itemModel = itemModel2;
    }

    public final ItemModel<?> getItemModel() {
        return this.itemModel;
    }

    public final int getPosition() {
        return this.position;
    }

    public String toString() {
        return "InsertData: position = " + this.position;
    }
}
