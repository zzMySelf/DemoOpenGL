package com.baidu.searchbox.video.feedflow.flow.offlinecache;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BE\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003JI\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheState;", "", "onItemSelected", "Landroidx/lifecycle/MutableLiveData;", "", "onListFetchFailed", "onPlayStart", "noDataInsert", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getNoDataInsert", "()Landroidx/lifecycle/MutableLiveData;", "getOnItemSelected", "getOnListFetchFailed", "getOnPlayStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowOfflineCacheState.kt */
public final class FlowOfflineCacheState {
    private final MutableLiveData<Unit> noDataInsert;
    private final MutableLiveData<Unit> onItemSelected;
    private final MutableLiveData<Unit> onListFetchFailed;
    private final MutableLiveData<Unit> onPlayStart;

    public FlowOfflineCacheState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FlowOfflineCacheState copy$default(FlowOfflineCacheState flowOfflineCacheState, MutableLiveData<Unit> mutableLiveData, MutableLiveData<Unit> mutableLiveData2, MutableLiveData<Unit> mutableLiveData3, MutableLiveData<Unit> mutableLiveData4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mutableLiveData = flowOfflineCacheState.onItemSelected;
        }
        if ((i2 & 2) != 0) {
            mutableLiveData2 = flowOfflineCacheState.onListFetchFailed;
        }
        if ((i2 & 4) != 0) {
            mutableLiveData3 = flowOfflineCacheState.onPlayStart;
        }
        if ((i2 & 8) != 0) {
            mutableLiveData4 = flowOfflineCacheState.noDataInsert;
        }
        return flowOfflineCacheState.copy(mutableLiveData, mutableLiveData2, mutableLiveData3, mutableLiveData4);
    }

    public final MutableLiveData<Unit> component1() {
        return this.onItemSelected;
    }

    public final MutableLiveData<Unit> component2() {
        return this.onListFetchFailed;
    }

    public final MutableLiveData<Unit> component3() {
        return this.onPlayStart;
    }

    public final MutableLiveData<Unit> component4() {
        return this.noDataInsert;
    }

    public final FlowOfflineCacheState copy(MutableLiveData<Unit> mutableLiveData, MutableLiveData<Unit> mutableLiveData2, MutableLiveData<Unit> mutableLiveData3, MutableLiveData<Unit> mutableLiveData4) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "onItemSelected");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "onListFetchFailed");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "onPlayStart");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "noDataInsert");
        return new FlowOfflineCacheState(mutableLiveData, mutableLiveData2, mutableLiveData3, mutableLiveData4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowOfflineCacheState)) {
            return false;
        }
        FlowOfflineCacheState flowOfflineCacheState = (FlowOfflineCacheState) obj;
        return Intrinsics.areEqual((Object) this.onItemSelected, (Object) flowOfflineCacheState.onItemSelected) && Intrinsics.areEqual((Object) this.onListFetchFailed, (Object) flowOfflineCacheState.onListFetchFailed) && Intrinsics.areEqual((Object) this.onPlayStart, (Object) flowOfflineCacheState.onPlayStart) && Intrinsics.areEqual((Object) this.noDataInsert, (Object) flowOfflineCacheState.noDataInsert);
    }

    public int hashCode() {
        return (((((this.onItemSelected.hashCode() * 31) + this.onListFetchFailed.hashCode()) * 31) + this.onPlayStart.hashCode()) * 31) + this.noDataInsert.hashCode();
    }

    public String toString() {
        return "FlowOfflineCacheState(onItemSelected=" + this.onItemSelected + ", onListFetchFailed=" + this.onListFetchFailed + ", onPlayStart=" + this.onPlayStart + ", noDataInsert=" + this.noDataInsert + ')';
    }

    public FlowOfflineCacheState(MutableLiveData<Unit> onItemSelected2, MutableLiveData<Unit> onListFetchFailed2, MutableLiveData<Unit> onPlayStart2, MutableLiveData<Unit> noDataInsert2) {
        Intrinsics.checkNotNullParameter(onItemSelected2, "onItemSelected");
        Intrinsics.checkNotNullParameter(onListFetchFailed2, "onListFetchFailed");
        Intrinsics.checkNotNullParameter(onPlayStart2, "onPlayStart");
        Intrinsics.checkNotNullParameter(noDataInsert2, "noDataInsert");
        this.onItemSelected = onItemSelected2;
        this.onListFetchFailed = onListFetchFailed2;
        this.onPlayStart = onPlayStart2;
        this.noDataInsert = noDataInsert2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowOfflineCacheState(MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, MutableLiveData mutableLiveData3, MutableLiveData mutableLiveData4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i2 & 2) != 0 ? new MutableLiveData() : mutableLiveData2, (i2 & 4) != 0 ? new MutableLiveData() : mutableLiveData3, (i2 & 8) != 0 ? new MutableLiveData() : mutableLiveData4);
    }

    public final MutableLiveData<Unit> getOnItemSelected() {
        return this.onItemSelected;
    }

    public final MutableLiveData<Unit> getOnListFetchFailed() {
        return this.onListFetchFailed;
    }

    public final MutableLiveData<Unit> getOnPlayStart() {
        return this.onPlayStart;
    }

    public final MutableLiveData<Unit> getNoDataInsert() {
        return this.noDataInsert;
    }
}
