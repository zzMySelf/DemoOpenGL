package com.baidu.searchbox.video.feedflow.detail.nextbigcard;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\rJ\u0006\u0010\u001f\u001a\u00020\tJ\u0006\u0010 \u001a\u00020\tR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0012\"\u0004\b\u0015\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0012\"\u0004\b\u0019\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001a\u0010\u001c\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/nextbigcard/NextBigCardState;", "", "isListSuccess", "", "isDetailsNetSuc", "isPageSelected", "isPanelDragging", "showCountDownGuide", "Landroidx/lifecycle/MutableLiveData;", "", "isCountDownGuideShow", "firstVideoUpdateNextVideoInfo", "hidePanel", "(ZZZZLandroidx/lifecycle/MutableLiveData;ZLandroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getFirstVideoUpdateNextVideoInfo", "()Landroidx/lifecycle/MutableLiveData;", "getHidePanel", "isAnimShowing", "()Z", "setAnimShowing", "(Z)V", "setCountDownGuideShow", "setDetailsNetSuc", "setListSuccess", "setPageSelected", "setPanelDragging", "isPanelHasShown", "setPanelHasShown", "isPanelShowing", "setPanelShowing", "getShowCountDownGuide", "reset", "showNetSuccess", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NextBigCardState.kt */
public final class NextBigCardState {
    private final MutableLiveData<Unit> firstVideoUpdateNextVideoInfo;
    private final MutableLiveData<Unit> hidePanel;
    private boolean isAnimShowing;
    private boolean isCountDownGuideShow;
    private boolean isDetailsNetSuc;
    private boolean isListSuccess;
    private boolean isPageSelected;
    private boolean isPanelDragging;
    private boolean isPanelHasShown;
    private boolean isPanelShowing;
    private final MutableLiveData<Unit> showCountDownGuide;

    public NextBigCardState() {
        this(false, false, false, false, (MutableLiveData) null, false, (MutableLiveData) null, (MutableLiveData) null, 255, (DefaultConstructorMarker) null);
    }

    public NextBigCardState(boolean isListSuccess2, boolean isDetailsNetSuc2, boolean isPageSelected2, boolean isPanelDragging2, MutableLiveData<Unit> showCountDownGuide2, boolean isCountDownGuideShow2, MutableLiveData<Unit> firstVideoUpdateNextVideoInfo2, MutableLiveData<Unit> hidePanel2) {
        Intrinsics.checkNotNullParameter(showCountDownGuide2, "showCountDownGuide");
        Intrinsics.checkNotNullParameter(firstVideoUpdateNextVideoInfo2, "firstVideoUpdateNextVideoInfo");
        Intrinsics.checkNotNullParameter(hidePanel2, "hidePanel");
        this.isListSuccess = isListSuccess2;
        this.isDetailsNetSuc = isDetailsNetSuc2;
        this.isPageSelected = isPageSelected2;
        this.isPanelDragging = isPanelDragging2;
        this.showCountDownGuide = showCountDownGuide2;
        this.isCountDownGuideShow = isCountDownGuideShow2;
        this.firstVideoUpdateNextVideoInfo = firstVideoUpdateNextVideoInfo2;
        this.hidePanel = hidePanel2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NextBigCardState(boolean z, boolean z2, boolean z3, boolean z4, MutableLiveData mutableLiveData, boolean z5, MutableLiveData mutableLiveData2, MutableLiveData mutableLiveData3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z3, (i2 & 8) != 0 ? false : z4, (i2 & 16) != 0 ? new MutableLiveData() : mutableLiveData, (i2 & 32) != 0 ? false : z5, (i2 & 64) != 0 ? new MutableLiveData() : mutableLiveData2, (i2 & 128) != 0 ? new MutableLiveData() : mutableLiveData3);
    }

    public final boolean isListSuccess() {
        return this.isListSuccess;
    }

    public final void setListSuccess(boolean z) {
        this.isListSuccess = z;
    }

    public final boolean isDetailsNetSuc() {
        return this.isDetailsNetSuc;
    }

    public final void setDetailsNetSuc(boolean z) {
        this.isDetailsNetSuc = z;
    }

    public final boolean isPageSelected() {
        return this.isPageSelected;
    }

    public final void setPageSelected(boolean z) {
        this.isPageSelected = z;
    }

    public final boolean isPanelDragging() {
        return this.isPanelDragging;
    }

    public final void setPanelDragging(boolean z) {
        this.isPanelDragging = z;
    }

    public final MutableLiveData<Unit> getShowCountDownGuide() {
        return this.showCountDownGuide;
    }

    public final boolean isCountDownGuideShow() {
        return this.isCountDownGuideShow;
    }

    public final void setCountDownGuideShow(boolean z) {
        this.isCountDownGuideShow = z;
    }

    public final MutableLiveData<Unit> getFirstVideoUpdateNextVideoInfo() {
        return this.firstVideoUpdateNextVideoInfo;
    }

    public final MutableLiveData<Unit> getHidePanel() {
        return this.hidePanel;
    }

    public final boolean isPanelShowing() {
        return this.isPanelShowing;
    }

    public final void setPanelShowing(boolean z) {
        this.isPanelShowing = z;
    }

    public final boolean isPanelHasShown() {
        return this.isPanelHasShown;
    }

    public final void setPanelHasShown(boolean z) {
        this.isPanelHasShown = z;
    }

    public final boolean isAnimShowing() {
        return this.isAnimShowing;
    }

    public final void setAnimShowing(boolean z) {
        this.isAnimShowing = z;
    }

    public final void showNetSuccess() {
        if (!this.isDetailsNetSuc) {
            return;
        }
        if ((this.isListSuccess || this.isPageSelected) && !this.isPanelHasShown) {
            this.firstVideoUpdateNextVideoInfo.setValue(Unit.INSTANCE);
        }
    }

    public final void reset() {
        this.isListSuccess = false;
        this.isDetailsNetSuc = false;
        this.isPageSelected = false;
        this.isPanelDragging = false;
        this.isPanelShowing = false;
        this.isPanelHasShown = false;
        this.isCountDownGuideShow = false;
        this.isAnimShowing = false;
    }
}
