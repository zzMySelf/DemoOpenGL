package fe.qw.qw.p009switch.o;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.layer.Layer;
import fe.qw.qw.pf.de.ppp;
import fe.qw.qw.pf.qw;
import fe.qw.qw.rg;
import fe.qw.qw.vvv.de;

/* renamed from: fe.qw.qw.switch.o.th  reason: invalid package */
public class th extends qw {
    public final Paint a = new qw();
    public final float[] b = new float[8];
    public final Path c = new Path();
    public final Layer d;
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> e;
    public final RectF tt = new RectF();

    public th(rg rgVar, Layer layer) {
        super(rgVar, layer);
        this.d = layer;
        this.a.setAlpha(0);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(layer.m3switch());
    }

    public <T> void de(T t, @Nullable de<T> deVar) {
        super.de(t, deVar);
        if (t != LottieProperty.c) {
            return;
        }
        if (deVar == null) {
            this.e = null;
        } else {
            this.e = new ppp(deVar);
        }
    }

    public void nn(Canvas canvas, Matrix matrix, int i2) {
        int alpha = Color.alpha(this.d.m3switch());
        if (alpha != 0) {
            int intValue = (int) ((((float) i2) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) (this.aaa.uk() == null ? 100 : this.aaa.uk().uk().intValue()))) / 100.0f) * 255.0f);
            this.a.setAlpha(intValue);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.e;
            if (baseKeyframeAnimation != null) {
                this.a.setColorFilter(baseKeyframeAnimation.uk());
            }
            if (intValue > 0) {
                float[] fArr = this.b;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.d.ppp();
                float[] fArr2 = this.b;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.d.ppp();
                this.b[5] = (float) this.d.when();
                float[] fArr3 = this.b;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.d.when();
                matrix.mapPoints(this.b);
                this.c.reset();
                Path path = this.c;
                float[] fArr4 = this.b;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.c;
                float[] fArr5 = this.b;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.c;
                float[] fArr6 = this.b;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.c;
                float[] fArr7 = this.b;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.c;
                float[] fArr8 = this.b;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.c.close();
                canvas.drawPath(this.c, this.a);
            }
        }
    }

    public void rg(RectF rectF, Matrix matrix, boolean z) {
        super.rg(rectF, matrix, z);
        this.tt.set(0.0f, 0.0f, (float) this.d.ppp(), (float) this.d.when());
        this.f118switch.mapRect(this.tt);
        rectF.set(this.tt);
    }
}
