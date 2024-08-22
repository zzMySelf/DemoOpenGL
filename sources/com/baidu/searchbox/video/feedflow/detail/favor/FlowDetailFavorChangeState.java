package com.baidu.searchbox.video.feedflow.detail.favor;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/favor/FlowDetailFavorChangeState;", "", "data", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/video/feedflow/detail/favor/FavorStateChangeModel;", "(Landroidx/lifecycle/MutableLiveData;)V", "getData", "()Landroidx/lifecycle/MutableLiveData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailFavorState.kt */
public final class FlowDetailFavorChangeState {
    private final MutableLiveData<FavorStateChangeModel> data;

    public FlowDetailFavorChangeState() {
        this((MutableLiveData) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FlowDetailFavorChangeState copy$default(FlowDetailFavorChangeState flowDetailFavorChangeState, MutableLiveData<FavorStateChangeModel> mutableLiveData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mutableLiveData = flowDetailFavorChangeState.data;
        }
        return flowDetailFavorChangeState.copy(mutableLiveData);
    }

    public final MutableLiveData<FavorStateChangeModel> component1() {
        return this.data;
    }

    public final FlowDetailFavorChangeState copy(MutableLiveData<FavorStateChangeModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "data");
        return new FlowDetailFavorChangeState(mutableLiveData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FlowDetailFavorChangeState) && Intrinsics.areEqual((Object) this.data, (Object) ((FlowDetailFavorChangeState) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "FlowDetailFavorChangeState(data=" + this.data + ')';
    }

    public FlowDetailFavorChangeState(MutableLiveData<FavorStateChangeModel> data2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        this.data = data2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowDetailFavorChangeState(MutableLiveData mutableLiveData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData() : mutableLiveData);
    }

    public final MutableLiveData<FavorStateChangeModel> getData() {
        return this.data;
    }
}
