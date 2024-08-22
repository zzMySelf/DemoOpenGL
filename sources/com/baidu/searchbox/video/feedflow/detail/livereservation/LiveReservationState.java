package com.baidu.searchbox.video.feedflow.detail.livereservation;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.flowvideo.detail.repos.LiveReservationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001Bg\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\fJ\u0006\u0010\u0005\u001a\u00020\u0006R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/livereservation/LiveReservationState;", "", "data", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/flowvideo/detail/repos/LiveReservationModel;", "isCanShow", "", "isShowOrHideAnim", "liveReservationStatus", "joinText", "", "isVisible", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getData", "()Landroidx/lifecycle/MutableLiveData;", "setCanShow", "(Landroidx/lifecycle/MutableLiveData;)V", "getJoinText", "getLiveReservationStatus", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveReservationState.kt */
public final class LiveReservationState {
    private final MutableLiveData<LiveReservationModel> data;
    private MutableLiveData<Boolean> isCanShow;
    private final MutableLiveData<Boolean> isShowOrHideAnim;
    private final MutableLiveData<Boolean> isVisible;
    private final MutableLiveData<String> joinText;
    private final MutableLiveData<Boolean> liveReservationStatus;

    public LiveReservationState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 63, (DefaultConstructorMarker) null);
    }

    public LiveReservationState(MutableLiveData<LiveReservationModel> data2, MutableLiveData<Boolean> isCanShow2, MutableLiveData<Boolean> isShowOrHideAnim2, MutableLiveData<Boolean> liveReservationStatus2, MutableLiveData<String> joinText2, MutableLiveData<Boolean> isVisible2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        Intrinsics.checkNotNullParameter(isCanShow2, "isCanShow");
        Intrinsics.checkNotNullParameter(isShowOrHideAnim2, "isShowOrHideAnim");
        Intrinsics.checkNotNullParameter(liveReservationStatus2, "liveReservationStatus");
        Intrinsics.checkNotNullParameter(joinText2, "joinText");
        Intrinsics.checkNotNullParameter(isVisible2, "isVisible");
        this.data = data2;
        this.isCanShow = isCanShow2;
        this.isShowOrHideAnim = isShowOrHideAnim2;
        this.liveReservationStatus = liveReservationStatus2;
        this.joinText = joinText2;
        this.isVisible = isVisible2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LiveReservationState(androidx.lifecycle.MutableLiveData r5, androidx.lifecycle.MutableLiveData r6, androidx.lifecycle.MutableLiveData r7, androidx.lifecycle.MutableLiveData r8, androidx.lifecycle.MutableLiveData r9, androidx.lifecycle.MutableLiveData r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0009
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
        L_0x0009:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x0019
            androidx.lifecycle.MutableLiveData r6 = new androidx.lifecycle.MutableLiveData
            r12 = 0
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            r6.<init>(r12)
            r12 = r6
            goto L_0x001a
        L_0x0019:
            r12 = r6
        L_0x001a:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0025
            androidx.lifecycle.MutableLiveData r7 = new androidx.lifecycle.MutableLiveData
            r7.<init>()
            r0 = r7
            goto L_0x0026
        L_0x0025:
            r0 = r7
        L_0x0026:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x0031
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            r1 = r8
            goto L_0x0032
        L_0x0031:
            r1 = r8
        L_0x0032:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x003d
            androidx.lifecycle.MutableLiveData r9 = new androidx.lifecycle.MutableLiveData
            r9.<init>()
            r2 = r9
            goto L_0x003e
        L_0x003d:
            r2 = r9
        L_0x003e:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0049
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            r3 = r10
            goto L_0x004a
        L_0x0049:
            r3 = r10
        L_0x004a:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.livereservation.LiveReservationState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<LiveReservationModel> getData() {
        return this.data;
    }

    public final MutableLiveData<Boolean> isCanShow() {
        return this.isCanShow;
    }

    public final void setCanShow(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.isCanShow = mutableLiveData;
    }

    public final MutableLiveData<Boolean> isShowOrHideAnim() {
        return this.isShowOrHideAnim;
    }

    public final MutableLiveData<Boolean> getLiveReservationStatus() {
        return this.liveReservationStatus;
    }

    public final MutableLiveData<String> getJoinText() {
        return this.joinText;
    }

    public final MutableLiveData<Boolean> isVisible() {
        return this.isVisible;
    }

    /* renamed from: isCanShow  reason: collision with other method in class */
    public final boolean m11677isCanShow() {
        Boolean value = this.isCanShow.getValue();
        if (value == null) {
            return false;
        }
        return value.booleanValue();
    }
}
