package fe.mmm.qw.tt.rg.ad;

import android.animation.ValueAnimator;
import com.tera.scan.scanner.ui.cameranew.FocusIndicatorView;

/* compiled from: lambda */
public final /* synthetic */ class ad implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FocusIndicatorView qw;

    public /* synthetic */ ad(FocusIndicatorView focusIndicatorView) {
        this.qw = focusIndicatorView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        FocusIndicatorView.m917startAnimation$lambda3(this.qw, valueAnimator);
    }
}
