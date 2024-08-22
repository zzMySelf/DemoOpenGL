package com.baidu.searchbox.video.feedflow.flow.screenkeepon;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/screenkeepon/ScreenKeepOnState;", "", "keepOn", "Landroidx/lifecycle/MutableLiveData;", "", "isLeftSlideOpen", "(Landroidx/lifecycle/MutableLiveData;Z)V", "()Z", "setLeftSlideOpen", "(Z)V", "getKeepOn", "()Landroidx/lifecycle/MutableLiveData;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenKeepOnState.kt */
public final class ScreenKeepOnState {
    private boolean isLeftSlideOpen;
    private final MutableLiveData<Boolean> keepOn;

    public ScreenKeepOnState() {
        this((MutableLiveData) null, false, 3, (DefaultConstructorMarker) null);
    }

    public ScreenKeepOnState(MutableLiveData<Boolean> keepOn2, boolean isLeftSlideOpen2) {
        Intrinsics.checkNotNullParameter(keepOn2, "keepOn");
        this.keepOn = keepOn2;
        this.isLeftSlideOpen = isLeftSlideOpen2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScreenKeepOnState(MutableLiveData mutableLiveData, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i2 & 2) != 0 ? false : z);
    }

    public final MutableLiveData<Boolean> getKeepOn() {
        return this.keepOn;
    }

    public final boolean isLeftSlideOpen() {
        return this.isLeftSlideOpen;
    }

    public final void setLeftSlideOpen(boolean z) {
        this.isLeftSlideOpen = z;
    }
}
