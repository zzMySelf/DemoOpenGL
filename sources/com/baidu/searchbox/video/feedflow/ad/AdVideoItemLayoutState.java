package com.baidu.searchbox.video.feedflow.ad;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\u0018\u00002\u00020\u0001B¯\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0007\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0004R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0013\"\u0004\b\u0016\u0010\u0017R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0013\"\u0004\b\u0018\u0010\u0017R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/AdVideoItemLayoutState;", "", "switchLayoutStyle", "Landroidx/lifecycle/MutableLiveData;", "", "updateLayoutFromPage", "weakAnimEnable", "weakAnimShow", "updateBottomBarLayout", "", "alphaHide", "", "isShowAuthorFollow", "isShowAuthorFollowL", "onKernelPivotReset", "changePortraitContainerVisible", "changeLandscapeContainerVisible", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;ZLandroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getAlphaHide", "()Landroidx/lifecycle/MutableLiveData;", "getChangeLandscapeContainerVisible", "getChangePortraitContainerVisible", "setShowAuthorFollow", "(Landroidx/lifecycle/MutableLiveData;)V", "setShowAuthorFollowL", "getOnKernelPivotReset", "getSwitchLayoutStyle", "getUpdateBottomBarLayout", "getUpdateLayoutFromPage", "getWeakAnimEnable", "()Z", "setWeakAnimEnable", "(Z)V", "getWeakAnimShow", "isShow", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdVideoItemLayoutState.kt */
public final class AdVideoItemLayoutState {
    private final MutableLiveData<Long> alphaHide;
    private final MutableLiveData<Boolean> changeLandscapeContainerVisible;
    private final MutableLiveData<Boolean> changePortraitContainerVisible;
    private MutableLiveData<Boolean> isShowAuthorFollow;
    private MutableLiveData<Boolean> isShowAuthorFollowL;
    private final MutableLiveData<Unit> onKernelPivotReset;
    private final MutableLiveData<Boolean> switchLayoutStyle;
    private final MutableLiveData<Unit> updateBottomBarLayout;
    private final MutableLiveData<Boolean> updateLayoutFromPage;
    private boolean weakAnimEnable;
    private final MutableLiveData<Boolean> weakAnimShow;

    public AdVideoItemLayoutState() {
        this((MutableLiveData) null, (MutableLiveData) null, false, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 2047, (DefaultConstructorMarker) null);
    }

    public AdVideoItemLayoutState(MutableLiveData<Boolean> switchLayoutStyle2, MutableLiveData<Boolean> updateLayoutFromPage2, boolean weakAnimEnable2, MutableLiveData<Boolean> weakAnimShow2, MutableLiveData<Unit> updateBottomBarLayout2, MutableLiveData<Long> alphaHide2, MutableLiveData<Boolean> isShowAuthorFollow2, MutableLiveData<Boolean> isShowAuthorFollowL2, MutableLiveData<Unit> onKernelPivotReset2, MutableLiveData<Boolean> changePortraitContainerVisible2, MutableLiveData<Boolean> changeLandscapeContainerVisible2) {
        Intrinsics.checkNotNullParameter(switchLayoutStyle2, "switchLayoutStyle");
        Intrinsics.checkNotNullParameter(updateLayoutFromPage2, "updateLayoutFromPage");
        Intrinsics.checkNotNullParameter(weakAnimShow2, "weakAnimShow");
        Intrinsics.checkNotNullParameter(updateBottomBarLayout2, "updateBottomBarLayout");
        Intrinsics.checkNotNullParameter(alphaHide2, "alphaHide");
        Intrinsics.checkNotNullParameter(isShowAuthorFollow2, "isShowAuthorFollow");
        Intrinsics.checkNotNullParameter(isShowAuthorFollowL2, "isShowAuthorFollowL");
        Intrinsics.checkNotNullParameter(onKernelPivotReset2, "onKernelPivotReset");
        Intrinsics.checkNotNullParameter(changePortraitContainerVisible2, "changePortraitContainerVisible");
        Intrinsics.checkNotNullParameter(changeLandscapeContainerVisible2, "changeLandscapeContainerVisible");
        this.switchLayoutStyle = switchLayoutStyle2;
        this.updateLayoutFromPage = updateLayoutFromPage2;
        this.weakAnimEnable = weakAnimEnable2;
        this.weakAnimShow = weakAnimShow2;
        this.updateBottomBarLayout = updateBottomBarLayout2;
        this.alphaHide = alphaHide2;
        this.isShowAuthorFollow = isShowAuthorFollow2;
        this.isShowAuthorFollowL = isShowAuthorFollowL2;
        this.onKernelPivotReset = onKernelPivotReset2;
        this.changePortraitContainerVisible = changePortraitContainerVisible2;
        this.changeLandscapeContainerVisible = changeLandscapeContainerVisible2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdVideoItemLayoutState(androidx.lifecycle.MutableLiveData r13, androidx.lifecycle.MutableLiveData r14, boolean r15, androidx.lifecycle.MutableLiveData r16, androidx.lifecycle.MutableLiveData r17, androidx.lifecycle.MutableLiveData r18, androidx.lifecycle.MutableLiveData r19, androidx.lifecycle.MutableLiveData r20, androidx.lifecycle.MutableLiveData r21, androidx.lifecycle.MutableLiveData r22, androidx.lifecycle.MutableLiveData r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            goto L_0x000d
        L_0x000c:
            r1 = r13
        L_0x000d:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0017
            androidx.lifecycle.MutableLiveData r2 = new androidx.lifecycle.MutableLiveData
            r2.<init>()
            goto L_0x0018
        L_0x0017:
            r2 = r14
        L_0x0018:
            r3 = r0 & 4
            r4 = 1
            if (r3 == 0) goto L_0x001f
            r3 = r4
            goto L_0x0020
        L_0x001f:
            r3 = r15
        L_0x0020:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x002a
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
            goto L_0x002c
        L_0x002a:
            r5 = r16
        L_0x002c:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0036
            androidx.lifecycle.MutableLiveData r6 = new androidx.lifecycle.MutableLiveData
            r6.<init>()
            goto L_0x0038
        L_0x0036:
            r6 = r17
        L_0x0038:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0042
            androidx.lifecycle.MutableLiveData r7 = new androidx.lifecycle.MutableLiveData
            r7.<init>()
            goto L_0x0044
        L_0x0042:
            r7 = r18
        L_0x0044:
            r8 = r0 & 64
            r9 = 0
            if (r8 == 0) goto L_0x0053
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r9)
            r8.<init>(r10)
            goto L_0x0055
        L_0x0053:
            r8 = r19
        L_0x0055:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0063
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            r10.<init>(r9)
            goto L_0x0065
        L_0x0063:
            r10 = r20
        L_0x0065:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x006f
            androidx.lifecycle.MutableLiveData r9 = new androidx.lifecycle.MutableLiveData
            r9.<init>()
            goto L_0x0071
        L_0x006f:
            r9 = r21
        L_0x0071:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x007f
            androidx.lifecycle.MutableLiveData r11 = new androidx.lifecycle.MutableLiveData
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r11.<init>(r4)
            goto L_0x0081
        L_0x007f:
            r11 = r22
        L_0x0081:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x008b
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            goto L_0x008d
        L_0x008b:
            r0 = r23
        L_0x008d:
            r13 = r1
            r14 = r2
            r15 = r3
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r10
            r21 = r9
            r22 = r11
            r23 = r0
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.AdVideoItemLayoutState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, boolean, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<Boolean> getSwitchLayoutStyle() {
        return this.switchLayoutStyle;
    }

    public final MutableLiveData<Boolean> getUpdateLayoutFromPage() {
        return this.updateLayoutFromPage;
    }

    public final boolean getWeakAnimEnable() {
        return this.weakAnimEnable;
    }

    public final void setWeakAnimEnable(boolean z) {
        this.weakAnimEnable = z;
    }

    public final MutableLiveData<Boolean> getWeakAnimShow() {
        return this.weakAnimShow;
    }

    public final MutableLiveData<Unit> getUpdateBottomBarLayout() {
        return this.updateBottomBarLayout;
    }

    public final MutableLiveData<Long> getAlphaHide() {
        return this.alphaHide;
    }

    public final MutableLiveData<Boolean> isShowAuthorFollow() {
        return this.isShowAuthorFollow;
    }

    public final void setShowAuthorFollow(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.isShowAuthorFollow = mutableLiveData;
    }

    public final MutableLiveData<Boolean> isShowAuthorFollowL() {
        return this.isShowAuthorFollowL;
    }

    public final void setShowAuthorFollowL(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.isShowAuthorFollowL = mutableLiveData;
    }

    public final MutableLiveData<Unit> getOnKernelPivotReset() {
        return this.onKernelPivotReset;
    }

    public final MutableLiveData<Boolean> getChangePortraitContainerVisible() {
        return this.changePortraitContainerVisible;
    }

    public final MutableLiveData<Boolean> getChangeLandscapeContainerVisible() {
        return this.changeLandscapeContainerVisible;
    }

    public final void weakAnimShow(boolean isShow) {
        if (this.weakAnimEnable) {
            this.weakAnimShow.setValue(Boolean.valueOf(isShow));
        }
    }
}
