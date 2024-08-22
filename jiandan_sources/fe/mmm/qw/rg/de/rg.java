package fe.mmm.qw.rg.de;

import android.animation.ValueAnimator;
import com.tera.scan.business.textrecognition.TextRecognitionActivity;

/* compiled from: lambda */
public final /* synthetic */ class rg implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ TextRecognitionActivity qw;

    public /* synthetic */ rg(TextRecognitionActivity textRecognitionActivity) {
        this.qw = textRecognitionActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        TextRecognitionActivity.m733progressAnim$lambda1$lambda0(this.qw, valueAnimator);
    }
}
