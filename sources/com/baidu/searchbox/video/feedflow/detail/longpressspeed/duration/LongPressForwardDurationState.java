package com.baidu.searchbox.video.feedflow.detail.longpressspeed.duration;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tJ\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/longpressspeed/duration/LongPressForwardDurationState;", "", "startOrStopLongPressDuration", "Landroidx/lifecycle/MutableLiveData;", "", "startPosition", "", "endPosition", "isForWard", "(Landroidx/lifecycle/MutableLiveData;IIZ)V", "getEndPosition", "()I", "setEndPosition", "(I)V", "()Z", "setForWard", "(Z)V", "getStartOrStopLongPressDuration", "()Landroidx/lifecycle/MutableLiveData;", "getStartPosition", "setStartPosition", "reset", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressForwardDurationState.kt */
public final class LongPressForwardDurationState {
    private int endPosition;
    private boolean isForWard;
    private final MutableLiveData<Boolean> startOrStopLongPressDuration;
    private int startPosition;

    public LongPressForwardDurationState() {
        this((MutableLiveData) null, 0, 0, false, 15, (DefaultConstructorMarker) null);
    }

    public LongPressForwardDurationState(MutableLiveData<Boolean> startOrStopLongPressDuration2, int startPosition2, int endPosition2, boolean isForWard2) {
        Intrinsics.checkNotNullParameter(startOrStopLongPressDuration2, "startOrStopLongPressDuration");
        this.startOrStopLongPressDuration = startOrStopLongPressDuration2;
        this.startPosition = startPosition2;
        this.endPosition = endPosition2;
        this.isForWard = isForWard2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LongPressForwardDurationState(MutableLiveData mutableLiveData, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i4 & 2) != 0 ? -1 : i2, (i4 & 4) != 0 ? -1 : i3, (i4 & 8) != 0 ? false : z);
    }

    public final MutableLiveData<Boolean> getStartOrStopLongPressDuration() {
        return this.startOrStopLongPressDuration;
    }

    public final int getStartPosition() {
        return this.startPosition;
    }

    public final void setStartPosition(int i2) {
        this.startPosition = i2;
    }

    public final int getEndPosition() {
        return this.endPosition;
    }

    public final void setEndPosition(int i2) {
        this.endPosition = i2;
    }

    public final boolean isForWard() {
        return this.isForWard;
    }

    public final void setForWard(boolean z) {
        this.isForWard = z;
    }

    public final void reset() {
        this.startPosition = -1;
        this.endPosition = -1;
        this.isForWard = false;
    }
}
