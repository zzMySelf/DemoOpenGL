package com.baidu.nadcore.carousel.vertical;

import android.view.animation.Animation;
import com.baidu.nadcore.carousel.base.NadCarouselBaseView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/baidu/nadcore/carousel/vertical/NadCarouselVerticalView$hidePop$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadCarouselVerticalView.kt */
public final class NadCarouselVerticalView$hidePop$1 implements Animation.AnimationListener {
    final /* synthetic */ boolean $useAlphaAnim;
    final /* synthetic */ NadCarouselVerticalView this$0;

    NadCarouselVerticalView$hidePop$1(NadCarouselVerticalView $receiver, boolean $useAlphaAnim2) {
        this.this$0 = $receiver;
        this.$useAlphaAnim = $useAlphaAnim2;
    }

    public void onAnimationStart(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public void onAnimationEnd(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.setVisibility(8);
        NadCarouselBaseView.IOnActionListener access$getListener = this.this$0.getListener();
        if (access$getListener != null) {
            access$getListener.onHide(true, this.$useAlphaAnim);
        }
    }

    public void onAnimationRepeat(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }
}
