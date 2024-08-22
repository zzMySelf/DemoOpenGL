package com.baidu.searchbox.video.feedflow.detail.statusbar;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/statusbar/StatusBarMaskState;", "", "setVisible", "Landroidx/lifecycle/MutableLiveData;", "", "(Landroidx/lifecycle/MutableLiveData;)V", "getSetVisible", "()Landroidx/lifecycle/MutableLiveData;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StatusBarMaskState.kt */
public final class StatusBarMaskState {
    private final MutableLiveData<Boolean> setVisible;

    public StatusBarMaskState() {
        this((MutableLiveData) null, 1, (DefaultConstructorMarker) null);
    }

    public StatusBarMaskState(MutableLiveData<Boolean> setVisible2) {
        Intrinsics.checkNotNullParameter(setVisible2, "setVisible");
        this.setVisible = setVisible2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StatusBarMaskState(MutableLiveData mutableLiveData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData() : mutableLiveData);
    }

    public final MutableLiveData<Boolean> getSetVisible() {
        return this.setVisible;
    }
}
