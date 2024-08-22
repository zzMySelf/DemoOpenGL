package com.baidu.searchbox.combinepublisher;

import android.animation.Animator;
import android.view.View;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/combinepublisher/CombinePublisherLayoutManagerService$showBottomBar$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "p0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "lib-publisher-dynamic_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CombinePublisherLayoutManagerService.kt */
public final class CombinePublisherLayoutManagerService$showBottomBar$1 implements Animator.AnimatorListener {
    final /* synthetic */ View $flBottomBar;
    final /* synthetic */ boolean $isShow;

    CombinePublisherLayoutManagerService$showBottomBar$1(boolean $isShow2, View $flBottomBar2) {
        this.$isShow = $isShow2;
        this.$flBottomBar = $flBottomBar2;
    }

    public void onAnimationStart(Animator p0) {
        Intrinsics.checkNotNullParameter(p0, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
        if (this.$isShow) {
            this.$flBottomBar.setVisibility(0);
        }
    }

    public void onAnimationEnd(Animator p0) {
        Intrinsics.checkNotNullParameter(p0, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
        if (!this.$isShow) {
            this.$flBottomBar.setVisibility(8);
        }
    }

    public void onAnimationCancel(Animator p0) {
        Intrinsics.checkNotNullParameter(p0, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
    }

    public void onAnimationRepeat(Animator p0) {
        Intrinsics.checkNotNullParameter(p0, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
    }
}
