package com.baidu.searchbox.video.feedflow.detail.barragesetting;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/BarrageSettingState;", "", "panelStatus", "Landroidx/lifecycle/MutableLiveData;", "", "screenChange", "", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getPanelStatus", "()Landroidx/lifecycle/MutableLiveData;", "getScreenChange", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BarrageSettingState.kt */
public final class BarrageSettingState {
    private final MutableLiveData<Boolean> panelStatus;
    private final MutableLiveData<Unit> screenChange;

    public BarrageSettingState() {
        this((MutableLiveData) null, (MutableLiveData) null, 3, (DefaultConstructorMarker) null);
    }

    public BarrageSettingState(MutableLiveData<Boolean> panelStatus2, MutableLiveData<Unit> screenChange2) {
        Intrinsics.checkNotNullParameter(panelStatus2, "panelStatus");
        Intrinsics.checkNotNullParameter(screenChange2, "screenChange");
        this.panelStatus = panelStatus2;
        this.screenChange = screenChange2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BarrageSettingState(MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i2 & 2) != 0 ? new MutableLiveData() : mutableLiveData2);
    }

    public final MutableLiveData<Boolean> getPanelStatus() {
        return this.panelStatus;
    }

    public final MutableLiveData<Unit> getScreenChange() {
        return this.screenChange;
    }
}
