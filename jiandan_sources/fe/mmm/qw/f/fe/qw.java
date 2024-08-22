package fe.mmm.qw.f.fe;

import android.animation.ValueAnimator;
import com.tera.scan.ui.widget.BottomDrawerLayout;

/* compiled from: lambda */
public final /* synthetic */ class qw implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BottomDrawerLayout qw;

    public /* synthetic */ qw(BottomDrawerLayout bottomDrawerLayout) {
        this.qw = bottomDrawerLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.qw.qw(valueAnimator);
    }
}
