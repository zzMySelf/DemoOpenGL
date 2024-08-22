package fe.qw.qw.p009switch.o;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.layer.Layer;
import fe.qw.qw.ggg.yj;
import fe.qw.qw.pf.de.ppp;
import fe.qw.qw.pf.qw;
import fe.qw.qw.rg;

/* renamed from: fe.qw.qw.switch.o.de  reason: invalid package */
public class de extends qw {
    public final Rect a = new Rect();
    public final Rect b = new Rect();
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> c;
    public final Paint tt = new qw(3);

    public de(rg rgVar, Layer layer) {
        super(rgVar, layer);
    }

    public <T> void de(T t, @Nullable fe.qw.qw.vvv.de<T> deVar) {
        super.de(t, deVar);
        if (t != LottieProperty.c) {
            return;
        }
        if (deVar == null) {
            this.c = null;
        } else {
            this.c = new ppp(deVar);
        }
    }

    @Nullable
    public final Bitmap l() {
        return this.when.mmm(this.ppp.pf());
    }

    public void nn(@NonNull Canvas canvas, Matrix matrix, int i2) {
        Bitmap l = l();
        if (l != null && !l.isRecycled()) {
            float rg2 = yj.rg();
            this.tt.setAlpha(i2);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.c;
            if (baseKeyframeAnimation != null) {
                this.tt.setColorFilter(baseKeyframeAnimation.uk());
            }
            canvas.save();
            canvas.concat(matrix);
            this.a.set(0, 0, l.getWidth(), l.getHeight());
            this.b.set(0, 0, (int) (((float) l.getWidth()) * rg2), (int) (((float) l.getHeight()) * rg2));
            canvas.drawBitmap(l, this.a, this.b, this.tt);
            canvas.restore();
        }
    }

    public void rg(RectF rectF, Matrix matrix, boolean z) {
        super.rg(rectF, matrix, z);
        Bitmap l = l();
        if (l != null) {
            rectF.set(0.0f, 0.0f, ((float) l.getWidth()) * yj.rg(), ((float) l.getHeight()) * yj.rg());
            this.f118switch.mapRect(rectF);
        }
    }
}
