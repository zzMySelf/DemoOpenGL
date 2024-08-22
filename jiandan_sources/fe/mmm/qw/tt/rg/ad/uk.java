package fe.mmm.qw.tt.rg.ad;

import android.animation.ValueAnimator;
import com.tera.scan.scanner.ui.cameranew.FocusIndicatorView;

/* compiled from: lambda */
public final /* synthetic */ class uk implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FocusIndicatorView qw;

    public /* synthetic */ uk(FocusIndicatorView focusIndicatorView) {
        this.qw = focusIndicatorView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        FocusIndicatorView.m918startAnimation$lambda4(this.qw, valueAnimator);
    }
}
