package com.baidu.searchbox.video.feedflow.livedetail;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u000bJ\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0003R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/livedetail/LiveItemLayoutState;", "", "weakAnimEnable", "", "showSummaryParentAnim", "Landroidx/lifecycle/MutableLiveData;", "updateBottomBarLayout", "", "weakAnimShow", "showLiveFollowGuideParent", "showLiveBannerParent", "(ZLandroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getShowLiveBannerParent", "()Landroidx/lifecycle/MutableLiveData;", "getShowLiveFollowGuideParent", "getShowSummaryParentAnim", "getUpdateBottomBarLayout", "getWeakAnimEnable", "()Z", "setWeakAnimEnable", "(Z)V", "getWeakAnimShow", "isShow", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveItemLayoutState.kt */
public final class LiveItemLayoutState {
    private final MutableLiveData<Boolean> showLiveBannerParent;
    private final MutableLiveData<Boolean> showLiveFollowGuideParent;
    private final MutableLiveData<Boolean> showSummaryParentAnim;
    private final MutableLiveData<Unit> updateBottomBarLayout;
    private boolean weakAnimEnable;
    private final MutableLiveData<Boolean> weakAnimShow;

    public LiveItemLayoutState() {
        this(false, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 63, (DefaultConstructorMarker) null);
    }

    public LiveItemLayoutState(boolean weakAnimEnable2, MutableLiveData<Boolean> showSummaryParentAnim2, MutableLiveData<Unit> updateBottomBarLayout2, MutableLiveData<Boolean> weakAnimShow2, MutableLiveData<Boolean> showLiveFollowGuideParent2, MutableLiveData<Boolean> showLiveBannerParent2) {
        Intrinsics.checkNotNullParameter(showSummaryParentAnim2, "showSummaryParentAnim");
        Intrinsics.checkNotNullParameter(updateBottomBarLayout2, "updateBottomBarLayout");
        Intrinsics.checkNotNullParameter(weakAnimShow2, "weakAnimShow");
        Intrinsics.checkNotNullParameter(showLiveFollowGuideParent2, "showLiveFollowGuideParent");
        Intrinsics.checkNotNullParameter(showLiveBannerParent2, "showLiveBannerParent");
        this.weakAnimEnable = weakAnimEnable2;
        this.showSummaryParentAnim = showSummaryParentAnim2;
        this.updateBottomBarLayout = updateBottomBarLayout2;
        this.weakAnimShow = weakAnimShow2;
        this.showLiveFollowGuideParent = showLiveFollowGuideParent2;
        this.showLiveBannerParent = showLiveBannerParent2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LiveItemLayoutState(boolean r5, androidx.lifecycle.MutableLiveData r6, androidx.lifecycle.MutableLiveData r7, androidx.lifecycle.MutableLiveData r8, androidx.lifecycle.MutableLiveData r9, androidx.lifecycle.MutableLiveData r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0005
            r5 = 1
        L_0x0005:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x0010
            androidx.lifecycle.MutableLiveData r6 = new androidx.lifecycle.MutableLiveData
            r6.<init>()
            r12 = r6
            goto L_0x0011
        L_0x0010:
            r12 = r6
        L_0x0011:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x001c
            androidx.lifecycle.MutableLiveData r7 = new androidx.lifecycle.MutableLiveData
            r7.<init>()
            r0 = r7
            goto L_0x001d
        L_0x001c:
            r0 = r7
        L_0x001d:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x0028
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            r1 = r8
            goto L_0x0029
        L_0x0028:
            r1 = r8
        L_0x0029:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0034
            androidx.lifecycle.MutableLiveData r9 = new androidx.lifecycle.MutableLiveData
            r9.<init>()
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.livedetail.LiveItemLayoutState.<init>(boolean, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean getWeakAnimEnable() {
        return this.weakAnimEnable;
    }

    public final void setWeakAnimEnable(boolean z) {
        this.weakAnimEnable = z;
    }

    public final MutableLiveData<Boolean> getShowSummaryParentAnim() {
        return this.showSummaryParentAnim;
    }

    public final MutableLiveData<Unit> getUpdateBottomBarLayout() {
        return this.updateBottomBarLayout;
    }

    public final MutableLiveData<Boolean> getWeakAnimShow() {
        return this.weakAnimShow;
    }

    public final MutableLiveData<Boolean> getShowLiveFollowGuideParent() {
        return this.showLiveFollowGuideParent;
    }

    public final MutableLiveData<Boolean> getShowLiveBannerParent() {
        return this.showLiveBannerParent;
    }

    public final void weakAnimShow(boolean isShow) {
        if (this.weakAnimEnable) {
            this.weakAnimShow.setValue(Boolean.valueOf(isShow));
        }
    }
}
