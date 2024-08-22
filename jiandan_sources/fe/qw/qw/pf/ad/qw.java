package fe.qw.qw.pf.ad;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import fe.qw.qw.ggg.th;
import fe.qw.qw.ggg.yj;
import fe.qw.qw.p009switch.uk.fe;
import fe.qw.qw.pf.de.ppp;
import fe.qw.qw.rg;
import fe.qw.qw.vvv.de;
import java.util.ArrayList;
import java.util.List;

public abstract class qw implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {

    /* renamed from: ad  reason: collision with root package name */
    public final Path f3321ad = new Path();

    /* renamed from: de  reason: collision with root package name */
    public final Path f3322de = new Path();

    /* renamed from: fe  reason: collision with root package name */
    public final RectF f3323fe = new RectF();

    /* renamed from: i  reason: collision with root package name */
    public final Paint f3324i;

    /* renamed from: if  reason: not valid java name */
    public final List<BaseKeyframeAnimation<?, Float>> f104if;

    /* renamed from: o  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, Float> f3325o;

    /* renamed from: pf  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, Integer> f3326pf;
    public final PathMeasure qw = new PathMeasure();

    /* renamed from: rg  reason: collision with root package name */
    public final rg f3327rg;
    @Nullable

    /* renamed from: switch  reason: not valid java name */
    public final BaseKeyframeAnimation<?, Float> f105switch;

    /* renamed from: th  reason: collision with root package name */
    public final fe.qw.qw.p009switch.o.qw f3328th;

    /* renamed from: uk  reason: collision with root package name */
    public final float[] f3329uk;
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> when;

    /* renamed from: yj  reason: collision with root package name */
    public final List<ad> f3330yj = new ArrayList();

    public static final class ad {
        @Nullable

        /* renamed from: ad  reason: collision with root package name */
        public final ggg f3331ad;
        public final List<o> qw;

        public ad(@Nullable ggg ggg) {
            this.qw = new ArrayList();
            this.f3331ad = ggg;
        }
    }

    public qw(rg rgVar, fe.qw.qw.p009switch.o.qw qwVar, Paint.Cap cap, Paint.Join join, float f, fe feVar, fe.qw.qw.p009switch.uk.ad adVar, List<fe.qw.qw.p009switch.uk.ad> list, fe.qw.qw.p009switch.uk.ad adVar2) {
        fe.qw.qw.pf.qw qwVar2 = new fe.qw.qw.pf.qw(1);
        this.f3324i = qwVar2;
        this.f3327rg = rgVar;
        this.f3328th = qwVar;
        qwVar2.setStyle(Paint.Style.STROKE);
        this.f3324i.setStrokeCap(cap);
        this.f3324i.setStrokeJoin(join);
        this.f3324i.setStrokeMiter(f);
        this.f3326pf = feVar.qw();
        this.f3325o = adVar.qw();
        if (adVar2 == null) {
            this.f105switch = null;
        } else {
            this.f105switch = adVar2.qw();
        }
        this.f104if = new ArrayList(list.size());
        this.f3329uk = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f104if.add(list.get(i2).qw());
        }
        qwVar.i(this.f3326pf);
        qwVar.i(this.f3325o);
        for (int i3 = 0; i3 < this.f104if.size(); i3++) {
            qwVar.i(this.f104if.get(i3));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f105switch;
        if (baseKeyframeAnimation != null) {
            qwVar.i(baseKeyframeAnimation);
        }
        this.f3326pf.qw(this);
        this.f3325o.qw(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f104if.get(i4).qw(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f105switch;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.qw(this);
        }
    }

    public void ad(List<Content> list, List<Content> list2) {
        ggg ggg = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof ggg) {
                ggg ggg2 = (ggg) content;
                if (ggg2.i() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    ggg = ggg2;
                }
            }
        }
        if (ggg != null) {
            ggg.de(this);
        }
        ad adVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof ggg) {
                ggg ggg3 = (ggg) content2;
                if (ggg3.i() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (adVar != null) {
                        this.f3330yj.add(adVar);
                    }
                    adVar = new ad(ggg3);
                    ggg3.de(this);
                }
            }
            if (content2 instanceof o) {
                if (adVar == null) {
                    adVar = new ad(ggg);
                }
                adVar.qw.add((o) content2);
            }
        }
        if (adVar != null) {
            this.f3330yj.add(adVar);
        }
    }

    @CallSuper
    public <T> void de(T t, @Nullable de<T> deVar) {
        if (t == LottieProperty.f556fe) {
            this.f3326pf.m1switch(deVar);
        } else if (t == LottieProperty.ppp) {
            this.f3325o.m1switch(deVar);
        } else if (t == LottieProperty.c) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.when;
            if (baseKeyframeAnimation != null) {
                this.f3328th.c(baseKeyframeAnimation);
            }
            if (deVar == null) {
                this.when = null;
                return;
            }
            ppp ppp = new ppp(deVar);
            this.when = ppp;
            ppp.qw(this);
            this.f3328th.i(this.when);
        }
    }

    public void fe(fe.qw.qw.p009switch.fe feVar, int i2, List<fe.qw.qw.p009switch.fe> list, fe.qw.qw.p009switch.fe feVar2) {
        th.m231switch(feVar, i2, list, feVar2, this);
    }

    public void qw() {
        this.f3327rg.invalidateSelf();
    }

    public void rg(RectF rectF, Matrix matrix, boolean z) {
        fe.qw.qw.ad.qw("StrokeContent#getBounds");
        this.f3321ad.reset();
        for (int i2 = 0; i2 < this.f3330yj.size(); i2++) {
            ad adVar = this.f3330yj.get(i2);
            for (int i3 = 0; i3 < adVar.qw.size(); i3++) {
                this.f3321ad.addPath(((o) adVar.qw.get(i3)).getPath(), matrix);
            }
        }
        this.f3321ad.computeBounds(this.f3323fe, false);
        float ppp = ((fe.qw.qw.pf.de.ad) this.f3325o).ppp();
        RectF rectF2 = this.f3323fe;
        float f = ppp / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.f3323fe);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        fe.qw.qw.ad.ad("StrokeContent#getBounds");
    }

    public final void th(Matrix matrix) {
        fe.qw.qw.ad.qw("StrokeContent#applyDashPattern");
        if (this.f104if.isEmpty()) {
            fe.qw.qw.ad.ad("StrokeContent#applyDashPattern");
            return;
        }
        float yj2 = yj.yj(matrix);
        for (int i2 = 0; i2 < this.f104if.size(); i2++) {
            this.f3329uk[i2] = ((Float) this.f104if.get(i2).uk()).floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.f3329uk;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f3329uk;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.f3329uk;
            fArr3[i2] = fArr3[i2] * yj2;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f105switch;
        this.f3324i.setPathEffect(new DashPathEffect(this.f3329uk, baseKeyframeAnimation == null ? 0.0f : yj2 * baseKeyframeAnimation.uk().floatValue()));
        fe.qw.qw.ad.ad("StrokeContent#applyDashPattern");
    }

    public final void uk(Canvas canvas, ad adVar, Matrix matrix) {
        fe.qw.qw.ad.qw("StrokeContent#applyTrimPath");
        if (adVar.f3331ad == null) {
            fe.qw.qw.ad.ad("StrokeContent#applyTrimPath");
            return;
        }
        this.f3321ad.reset();
        for (int size = adVar.qw.size() - 1; size >= 0; size--) {
            this.f3321ad.addPath(((o) adVar.qw.get(size)).getPath(), matrix);
        }
        this.qw.setPath(this.f3321ad, false);
        float length = this.qw.getLength();
        while (this.qw.nextContour()) {
            length += this.qw.getLength();
        }
        float floatValue = (adVar.f3331ad.th().uk().floatValue() * length) / 360.0f;
        float floatValue2 = ((adVar.f3331ad.uk().uk().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((adVar.f3331ad.fe().uk().floatValue() * length) / 100.0f) + floatValue;
        float f = 0.0f;
        for (int size2 = adVar.qw.size() - 1; size2 >= 0; size2--) {
            this.f3322de.set(((o) adVar.qw.get(size2)).getPath());
            this.f3322de.transform(matrix);
            this.qw.setPath(this.f3322de, false);
            float length2 = this.qw.getLength();
            float f2 = 1.0f;
            if (floatValue3 > length) {
                float f3 = floatValue3 - length;
                if (f3 < f + length2 && f < f3) {
                    yj.qw(this.f3322de, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f3322de, this.f3324i);
                    f += length2;
                }
            }
            float f4 = f + length2;
            if (f4 >= floatValue2 && f <= floatValue3) {
                if (f4 > floatValue3 || floatValue2 >= f) {
                    float f5 = floatValue2 < f ? 0.0f : (floatValue2 - f) / length2;
                    if (floatValue3 <= f4) {
                        f2 = (floatValue3 - f) / length2;
                    }
                    yj.qw(this.f3322de, f5, f2, 0.0f);
                    canvas.drawPath(this.f3322de, this.f3324i);
                } else {
                    canvas.drawPath(this.f3322de, this.f3324i);
                }
            }
            f += length2;
        }
        fe.qw.qw.ad.ad("StrokeContent#applyTrimPath");
    }

    public void yj(Canvas canvas, Matrix matrix, int i2) {
        fe.qw.qw.ad.qw("StrokeContent#draw");
        if (yj.uk(matrix)) {
            fe.qw.qw.ad.ad("StrokeContent#draw");
            return;
        }
        this.f3324i.setAlpha(th.fe((int) ((((((float) i2) / 255.0f) * ((float) ((fe.qw.qw.pf.de.fe) this.f3326pf).ppp())) / 100.0f) * 255.0f), 0, 255));
        this.f3324i.setStrokeWidth(((fe.qw.qw.pf.de.ad) this.f3325o).ppp() * yj.yj(matrix));
        if (this.f3324i.getStrokeWidth() <= 0.0f) {
            fe.qw.qw.ad.ad("StrokeContent#draw");
            return;
        }
        th(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.when;
        if (baseKeyframeAnimation != null) {
            this.f3324i.setColorFilter(baseKeyframeAnimation.uk());
        }
        for (int i3 = 0; i3 < this.f3330yj.size(); i3++) {
            ad adVar = this.f3330yj.get(i3);
            if (adVar.f3331ad != null) {
                uk(canvas, adVar, matrix);
            } else {
                fe.qw.qw.ad.qw("StrokeContent#buildPath");
                this.f3321ad.reset();
                for (int size = adVar.qw.size() - 1; size >= 0; size--) {
                    this.f3321ad.addPath(((o) adVar.qw.get(size)).getPath(), matrix);
                }
                fe.qw.qw.ad.ad("StrokeContent#buildPath");
                fe.qw.qw.ad.qw("StrokeContent#drawPath");
                canvas.drawPath(this.f3321ad, this.f3324i);
                fe.qw.qw.ad.ad("StrokeContent#drawPath");
            }
        }
        fe.qw.qw.ad.ad("StrokeContent#draw");
    }
}
