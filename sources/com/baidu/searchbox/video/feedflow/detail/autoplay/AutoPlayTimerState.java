package com.baidu.searchbox.video.feedflow.detail.autoplay;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bc\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\u0006\u0010\u001c\u001a\u00020\u0004J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003Jg\u0010$\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0006\u0010\f\u001a\u00020\u0004J\u0013\u0010%\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\u0006\u0010)\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\t\u0010+\u001a\u00020,HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0015\"\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000f¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/autoplay/AutoPlayTimerState;", "", "pauseTimer", "Landroidx/lifecycle/MutableLiveData;", "", "resumeTimer", "startTimer", "cancelTimer", "countDownMills", "", "isCanceled", "", "disableCountDown", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;JZZ)V", "getCancelTimer", "()Landroidx/lifecycle/MutableLiveData;", "getCountDownMills", "()J", "setCountDownMills", "(J)V", "getDisableCountDown", "()Z", "setDisableCountDown", "(Z)V", "setCanceled", "getPauseTimer", "getResumeTimer", "getStartTimer", "cancel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "reset", "start", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AutoPlayTimerState.kt */
public final class AutoPlayTimerState {
    private final MutableLiveData<Unit> cancelTimer;
    private long countDownMills;
    private boolean disableCountDown;
    private boolean isCanceled;
    private final MutableLiveData<Unit> pauseTimer;
    private final MutableLiveData<Unit> resumeTimer;
    private final MutableLiveData<Unit> startTimer;

    public AutoPlayTimerState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 0, false, false, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AutoPlayTimerState copy$default(AutoPlayTimerState autoPlayTimerState, MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, MutableLiveData mutableLiveData3, MutableLiveData mutableLiveData4, long j2, boolean z, boolean z2, int i2, Object obj) {
        AutoPlayTimerState autoPlayTimerState2 = autoPlayTimerState;
        return autoPlayTimerState.copy((i2 & 1) != 0 ? autoPlayTimerState2.pauseTimer : mutableLiveData, (i2 & 2) != 0 ? autoPlayTimerState2.resumeTimer : mutableLiveData2, (i2 & 4) != 0 ? autoPlayTimerState2.startTimer : mutableLiveData3, (i2 & 8) != 0 ? autoPlayTimerState2.cancelTimer : mutableLiveData4, (i2 & 16) != 0 ? autoPlayTimerState2.countDownMills : j2, (i2 & 32) != 0 ? autoPlayTimerState2.isCanceled : z, (i2 & 64) != 0 ? autoPlayTimerState2.disableCountDown : z2);
    }

    public final MutableLiveData<Unit> component1() {
        return this.pauseTimer;
    }

    public final MutableLiveData<Unit> component2() {
        return this.resumeTimer;
    }

    public final MutableLiveData<Unit> component3() {
        return this.startTimer;
    }

    public final MutableLiveData<Unit> component4() {
        return this.cancelTimer;
    }

    public final long component5() {
        return this.countDownMills;
    }

    public final boolean component6() {
        return this.isCanceled;
    }

    public final boolean component7() {
        return this.disableCountDown;
    }

    public final AutoPlayTimerState copy(MutableLiveData<Unit> mutableLiveData, MutableLiveData<Unit> mutableLiveData2, MutableLiveData<Unit> mutableLiveData3, MutableLiveData<Unit> mutableLiveData4, long j2, boolean z, boolean z2) {
        MutableLiveData<Unit> mutableLiveData5 = mutableLiveData;
        Intrinsics.checkNotNullParameter(mutableLiveData, "pauseTimer");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "resumeTimer");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "startTimer");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "cancelTimer");
        return new AutoPlayTimerState(mutableLiveData, mutableLiveData2, mutableLiveData3, mutableLiveData4, j2, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutoPlayTimerState)) {
            return false;
        }
        AutoPlayTimerState autoPlayTimerState = (AutoPlayTimerState) obj;
        return Intrinsics.areEqual((Object) this.pauseTimer, (Object) autoPlayTimerState.pauseTimer) && Intrinsics.areEqual((Object) this.resumeTimer, (Object) autoPlayTimerState.resumeTimer) && Intrinsics.areEqual((Object) this.startTimer, (Object) autoPlayTimerState.startTimer) && Intrinsics.areEqual((Object) this.cancelTimer, (Object) autoPlayTimerState.cancelTimer) && this.countDownMills == autoPlayTimerState.countDownMills && this.isCanceled == autoPlayTimerState.isCanceled && this.disableCountDown == autoPlayTimerState.disableCountDown;
    }

    public int hashCode() {
        int hashCode = ((((((((this.pauseTimer.hashCode() * 31) + this.resumeTimer.hashCode()) * 31) + this.startTimer.hashCode()) * 31) + this.cancelTimer.hashCode()) * 31) + Long.hashCode(this.countDownMills)) * 31;
        boolean z = this.isCanceled;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.disableCountDown;
        if (!z3) {
            z2 = z3;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "AutoPlayTimerState(pauseTimer=" + this.pauseTimer + ", resumeTimer=" + this.resumeTimer + ", startTimer=" + this.startTimer + ", cancelTimer=" + this.cancelTimer + ", countDownMills=" + this.countDownMills + ", isCanceled=" + this.isCanceled + ", disableCountDown=" + this.disableCountDown + ')';
    }

    public AutoPlayTimerState(MutableLiveData<Unit> pauseTimer2, MutableLiveData<Unit> resumeTimer2, MutableLiveData<Unit> startTimer2, MutableLiveData<Unit> cancelTimer2, long countDownMills2, boolean isCanceled2, boolean disableCountDown2) {
        Intrinsics.checkNotNullParameter(pauseTimer2, "pauseTimer");
        Intrinsics.checkNotNullParameter(resumeTimer2, "resumeTimer");
        Intrinsics.checkNotNullParameter(startTimer2, "startTimer");
        Intrinsics.checkNotNullParameter(cancelTimer2, "cancelTimer");
        this.pauseTimer = pauseTimer2;
        this.resumeTimer = resumeTimer2;
        this.startTimer = startTimer2;
        this.cancelTimer = cancelTimer2;
        this.countDownMills = countDownMills2;
        this.isCanceled = isCanceled2;
        this.disableCountDown = disableCountDown2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AutoPlayTimerState(androidx.lifecycle.MutableLiveData r10, androidx.lifecycle.MutableLiveData r11, androidx.lifecycle.MutableLiveData r12, androidx.lifecycle.MutableLiveData r13, long r14, boolean r16, boolean r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18 & 1
            if (r0 == 0) goto L_0x000a
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            goto L_0x000b
        L_0x000a:
            r0 = r10
        L_0x000b:
            r1 = r18 & 2
            if (r1 == 0) goto L_0x0015
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            goto L_0x0016
        L_0x0015:
            r1 = r11
        L_0x0016:
            r2 = r18 & 4
            if (r2 == 0) goto L_0x0020
            androidx.lifecycle.MutableLiveData r2 = new androidx.lifecycle.MutableLiveData
            r2.<init>()
            goto L_0x0021
        L_0x0020:
            r2 = r12
        L_0x0021:
            r3 = r18 & 8
            if (r3 == 0) goto L_0x002b
            androidx.lifecycle.MutableLiveData r3 = new androidx.lifecycle.MutableLiveData
            r3.<init>()
            goto L_0x002c
        L_0x002b:
            r3 = r13
        L_0x002c:
            r4 = r18 & 16
            if (r4 == 0) goto L_0x0033
            r4 = 0
            goto L_0x0034
        L_0x0033:
            r4 = r14
        L_0x0034:
            r6 = r18 & 32
            r7 = 0
            if (r6 == 0) goto L_0x003b
            r6 = r7
            goto L_0x003d
        L_0x003b:
            r6 = r16
        L_0x003d:
            r8 = r18 & 64
            if (r8 == 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r7 = r17
        L_0x0044:
            r10 = r0
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r16 = r6
            r17 = r7
            r9.<init>(r10, r11, r12, r13, r14, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, long, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<Unit> getPauseTimer() {
        return this.pauseTimer;
    }

    public final MutableLiveData<Unit> getResumeTimer() {
        return this.resumeTimer;
    }

    public final MutableLiveData<Unit> getStartTimer() {
        return this.startTimer;
    }

    public final MutableLiveData<Unit> getCancelTimer() {
        return this.cancelTimer;
    }

    public final long getCountDownMills() {
        return this.countDownMills;
    }

    public final void setCountDownMills(long j2) {
        this.countDownMills = j2;
    }

    public final boolean isCanceled() {
        return this.isCanceled;
    }

    public final void setCanceled(boolean z) {
        this.isCanceled = z;
    }

    public final boolean getDisableCountDown() {
        return this.disableCountDown;
    }

    public final void setDisableCountDown(boolean z) {
        this.disableCountDown = z;
    }

    public final void start(long countDownMills2) {
        this.isCanceled = false;
        this.countDownMills = countDownMills2;
        this.startTimer.setValue(Unit.INSTANCE);
    }

    public final void cancel() {
        this.cancelTimer.setValue(Unit.INSTANCE);
        this.isCanceled = true;
    }

    public final void disableCountDown() {
        this.disableCountDown = true;
        this.cancelTimer.setValue(Unit.INSTANCE);
    }

    public final void reset() {
        this.disableCountDown = false;
        this.isCanceled = false;
    }
}
