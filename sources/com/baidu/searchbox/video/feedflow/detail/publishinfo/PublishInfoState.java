package com.baidu.searchbox.video.feedflow.detail.publishinfo;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.flowvideo.detail.repos.PublishInfoModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B_\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/publishinfo/PublishInfoState;", "", "publishInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/flowvideo/detail/repos/PublishInfoModel;", "isShowOrHideAnim", "", "changeVisible", "onNightChangeMode", "", "isShow", "isCanShow", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;ZLandroidx/lifecycle/MutableLiveData;)V", "getChangeVisible", "()Landroidx/lifecycle/MutableLiveData;", "setCanShow", "(Landroidx/lifecycle/MutableLiveData;)V", "()Z", "setShow", "(Z)V", "getOnNightChangeMode", "getPublishInfo", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PublishInfoState.kt */
public final class PublishInfoState {
    private final MutableLiveData<Boolean> changeVisible;
    private MutableLiveData<Boolean> isCanShow;
    private boolean isShow;
    private final MutableLiveData<Boolean> isShowOrHideAnim;
    private final MutableLiveData<Unit> onNightChangeMode;
    private final MutableLiveData<PublishInfoModel> publishInfo;

    public PublishInfoState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, false, (MutableLiveData) null, 63, (DefaultConstructorMarker) null);
    }

    public PublishInfoState(MutableLiveData<PublishInfoModel> publishInfo2, MutableLiveData<Boolean> isShowOrHideAnim2, MutableLiveData<Boolean> changeVisible2, MutableLiveData<Unit> onNightChangeMode2, boolean isShow2, MutableLiveData<Boolean> isCanShow2) {
        Intrinsics.checkNotNullParameter(publishInfo2, "publishInfo");
        Intrinsics.checkNotNullParameter(isShowOrHideAnim2, "isShowOrHideAnim");
        Intrinsics.checkNotNullParameter(changeVisible2, "changeVisible");
        Intrinsics.checkNotNullParameter(onNightChangeMode2, "onNightChangeMode");
        Intrinsics.checkNotNullParameter(isCanShow2, "isCanShow");
        this.publishInfo = publishInfo2;
        this.isShowOrHideAnim = isShowOrHideAnim2;
        this.changeVisible = changeVisible2;
        this.onNightChangeMode = onNightChangeMode2;
        this.isShow = isShow2;
        this.isCanShow = isCanShow2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PublishInfoState(androidx.lifecycle.MutableLiveData r5, androidx.lifecycle.MutableLiveData r6, androidx.lifecycle.MutableLiveData r7, androidx.lifecycle.MutableLiveData r8, boolean r9, androidx.lifecycle.MutableLiveData r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0009
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
        L_0x0009:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x0014
            androidx.lifecycle.MutableLiveData r6 = new androidx.lifecycle.MutableLiveData
            r6.<init>()
            r12 = r6
            goto L_0x0015
        L_0x0014:
            r12 = r6
        L_0x0015:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0020
            androidx.lifecycle.MutableLiveData r7 = new androidx.lifecycle.MutableLiveData
            r7.<init>()
            r0 = r7
            goto L_0x0021
        L_0x0020:
            r0 = r7
        L_0x0021:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x002c
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            r1 = r8
            goto L_0x002d
        L_0x002c:
            r1 = r8
        L_0x002d:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0034
            r9 = 0
            r2 = r9
            goto L_0x0035
        L_0x0034:
            r2 = r9
        L_0x0035:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0040
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            r3 = r10
            goto L_0x0041
        L_0x0040:
            r3 = r10
        L_0x0041:
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.publishinfo.PublishInfoState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, boolean, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<PublishInfoModel> getPublishInfo() {
        return this.publishInfo;
    }

    public final MutableLiveData<Boolean> isShowOrHideAnim() {
        return this.isShowOrHideAnim;
    }

    public final MutableLiveData<Boolean> getChangeVisible() {
        return this.changeVisible;
    }

    public final MutableLiveData<Unit> getOnNightChangeMode() {
        return this.onNightChangeMode;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final void setShow(boolean z) {
        this.isShow = z;
    }

    public final MutableLiveData<Boolean> isCanShow() {
        return this.isCanShow;
    }

    public final void setCanShow(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.isCanShow = mutableLiveData;
    }
}
