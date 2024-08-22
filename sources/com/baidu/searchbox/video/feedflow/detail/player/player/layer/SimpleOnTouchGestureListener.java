package com.baidu.searchbox.video.feedflow.detail.player.player.layer;

import com.baidu.searchbox.video.feedflow.detail.player.player.layer.OnTouchGestureListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/SimpleOnTouchGestureListener;", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/OnTouchGestureListener;", "()V", "onIntelligentFillScreenOpen", "", "isOpen", "", "isFreedom", "onIntelligentScaleStatusChange", "style", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/GesturesScaleType;", "large", "onResetPivot", "onRestoreScreenBtnClick", "onScaleBegin", "onTouchBegin", "onTouchEnd", "hasScale", "enlarge", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoKernelGesturePlugin.kt */
public class SimpleOnTouchGestureListener implements OnTouchGestureListener {
    public void onReturnPlayer(float touchBeginScale, float touchEndScale) {
        OnTouchGestureListener.DefaultImpls.onReturnPlayer(this, touchBeginScale, touchEndScale);
    }

    public void onTouchBegin() {
    }

    public void onTouchEnd(boolean hasScale, boolean enlarge) {
    }

    public void onScaleBegin() {
    }

    public void onIntelligentScaleStatusChange(GesturesScaleType style, boolean large) {
        Intrinsics.checkNotNullParameter(style, "style");
    }

    public void onIntelligentFillScreenOpen(boolean isOpen, boolean isFreedom) {
    }

    public void onRestoreScreenBtnClick() {
    }

    public void onResetPivot() {
    }
}
