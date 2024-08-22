package com.baidu.searchbox.floating.animator;

import android.animation.ValueAnimator;
import android.view.WindowManager;
import java.lang.ref.WeakReference;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultFloatViewAnimator$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WindowManager.LayoutParams f$0;
    public final /* synthetic */ WeakReference f$1;
    public final /* synthetic */ WindowManager f$2;

    public /* synthetic */ DefaultFloatViewAnimator$$ExternalSyntheticLambda1(WindowManager.LayoutParams layoutParams, WeakReference weakReference, WindowManager windowManager) {
        this.f$0 = layoutParams;
        this.f$1 = weakReference;
        this.f$2 = windowManager;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        DefaultFloatViewAnimator.m19822enterAnim$lambda0(this.f$0, this.f$1, this.f$2, valueAnimator);
    }
}
