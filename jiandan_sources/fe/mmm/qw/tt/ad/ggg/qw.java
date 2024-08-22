package fe.mmm.qw.tt.ad.ggg;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tera.scan.scanner.ocr.extension.ImageViewKt$animateToDoneView$1;
import kotlin.jvm.functions.Function0;

/* compiled from: lambda */
public final /* synthetic */ class qw implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ Rect f8397ad;

    /* renamed from: de  reason: collision with root package name */
    public final /* synthetic */ ImageView f8398de;

    /* renamed from: fe  reason: collision with root package name */
    public final /* synthetic */ Function0 f8399fe;
    public final /* synthetic */ Rect qw;

    public /* synthetic */ qw(Rect rect, Rect rect2, ImageView imageView, Function0 function0) {
        this.qw = rect;
        this.f8397ad = rect2;
        this.f8398de = imageView;
        this.f8399fe = function0;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ImageViewKt$animateToDoneView$1.m908invoke$lambda0(this.qw, this.f8397ad, this.f8398de, this.f8399fe, valueAnimator);
    }
}
