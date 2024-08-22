package com.baidu.searchbox.video.feedflow.detail.guide;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/guide/FlowVideoScaleGestureGuideState;", "", "showGuide", "Landroidx/lifecycle/MutableLiveData;", "", "isGuideShowing", "strategy", "Lcom/baidu/searchbox/video/feedflow/detail/guide/IVideoScaleGestureStrategy;", "(Landroidx/lifecycle/MutableLiveData;ZLcom/baidu/searchbox/video/feedflow/detail/guide/IVideoScaleGestureStrategy;)V", "()Z", "setGuideShowing", "(Z)V", "getShowGuide", "()Landroidx/lifecycle/MutableLiveData;", "getStrategy", "()Lcom/baidu/searchbox/video/feedflow/detail/guide/IVideoScaleGestureStrategy;", "setStrategy", "(Lcom/baidu/searchbox/video/feedflow/detail/guide/IVideoScaleGestureStrategy;)V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoScaleGestureGuideState.kt */
public final class FlowVideoScaleGestureGuideState {
    private boolean isGuideShowing;
    private final MutableLiveData<Boolean> showGuide;
    private IVideoScaleGestureStrategy strategy;

    public FlowVideoScaleGestureGuideState() {
        this((MutableLiveData) null, false, (IVideoScaleGestureStrategy) null, 7, (DefaultConstructorMarker) null);
    }

    public FlowVideoScaleGestureGuideState(MutableLiveData<Boolean> showGuide2, boolean isGuideShowing2, IVideoScaleGestureStrategy strategy2) {
        Intrinsics.checkNotNullParameter(showGuide2, "showGuide");
        Intrinsics.checkNotNullParameter(strategy2, "strategy");
        this.showGuide = showGuide2;
        this.isGuideShowing = isGuideShowing2;
        this.strategy = strategy2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowVideoScaleGestureGuideState(MutableLiveData mutableLiveData, boolean z, IVideoScaleGestureStrategy iVideoScaleGestureStrategy, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? FLowVideoScaleGestureStrategy.INSTANCE : iVideoScaleGestureStrategy);
    }

    public final MutableLiveData<Boolean> getShowGuide() {
        return this.showGuide;
    }

    public final boolean isGuideShowing() {
        return this.isGuideShowing;
    }

    public final void setGuideShowing(boolean z) {
        this.isGuideShowing = z;
    }

    public final IVideoScaleGestureStrategy getStrategy() {
        return this.strategy;
    }

    public final void setStrategy(IVideoScaleGestureStrategy iVideoScaleGestureStrategy) {
        Intrinsics.checkNotNullParameter(iVideoScaleGestureStrategy, "<set-?>");
        this.strategy = iVideoScaleGestureStrategy;
    }
}
