package com.baidu.nadcore.fullscreen.view;

import android.animation.ValueAnimator;
import com.baidu.nadcore.model.NadFullScreenModel;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NadFullScreenView$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ NadFullScreenView f$0;
    public final /* synthetic */ NadFullScreenModel f$1;

    public /* synthetic */ NadFullScreenView$$ExternalSyntheticLambda1(NadFullScreenView nadFullScreenView, NadFullScreenModel nadFullScreenModel) {
        this.f$0 = nadFullScreenView;
        this.f$1 = nadFullScreenModel;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        NadFullScreenView.m14042getAnimationUpdateListener$lambda1(this.f$0, this.f$1, valueAnimator);
    }
}
