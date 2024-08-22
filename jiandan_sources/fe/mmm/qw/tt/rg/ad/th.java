package fe.mmm.qw.tt.rg.ad;

import android.animation.ValueAnimator;
import com.tera.scan.scanner.ui.cameranew.AutoScanRectView;

/* compiled from: lambda */
public final /* synthetic */ class th implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ boolean f8476ad;
    public final /* synthetic */ AutoScanRectView qw;

    public /* synthetic */ th(AutoScanRectView autoScanRectView, boolean z) {
        this.qw = autoScanRectView;
        this.f8476ad = z;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AutoScanRectView.m911show$lambda2$lambda1(this.qw, this.f8476ad, valueAnimator);
    }
}
