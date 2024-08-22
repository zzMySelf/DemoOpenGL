package com.baidu.searchbox.video.feedflow.detail.error;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/error/NetErrorState;", "", "isNetErrorVisible", "Landroidx/lifecycle/MutableLiveData;", "", "refreshView", "", "updateStyle", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "()Landroidx/lifecycle/MutableLiveData;", "getRefreshView", "getUpdateStyle", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetErrorState.kt */
public final class NetErrorState {
    private final MutableLiveData<Boolean> isNetErrorVisible;
    private final MutableLiveData<Unit> refreshView;
    private final MutableLiveData<Boolean> updateStyle;

    public NetErrorState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 7, (DefaultConstructorMarker) null);
    }

    public NetErrorState(MutableLiveData<Boolean> isNetErrorVisible2, MutableLiveData<Unit> refreshView2, MutableLiveData<Boolean> updateStyle2) {
        Intrinsics.checkNotNullParameter(isNetErrorVisible2, "isNetErrorVisible");
        Intrinsics.checkNotNullParameter(refreshView2, "refreshView");
        Intrinsics.checkNotNullParameter(updateStyle2, "updateStyle");
        this.isNetErrorVisible = isNetErrorVisible2;
        this.refreshView = refreshView2;
        this.updateStyle = updateStyle2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetErrorState(MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, MutableLiveData mutableLiveData3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i2 & 2) != 0 ? new MutableLiveData() : mutableLiveData2, (i2 & 4) != 0 ? new MutableLiveData() : mutableLiveData3);
    }

    public final MutableLiveData<Boolean> isNetErrorVisible() {
        return this.isNetErrorVisible;
    }

    public final MutableLiveData<Unit> getRefreshView() {
        return this.refreshView;
    }

    public final MutableLiveData<Boolean> getUpdateStyle() {
        return this.updateStyle;
    }
}
