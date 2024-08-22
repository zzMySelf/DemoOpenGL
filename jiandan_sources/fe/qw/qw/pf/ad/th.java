package fe.qw.qw.pf.ad;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientType;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import fe.qw.qw.p009switch.fe;
import fe.qw.qw.p009switch.i.ad;
import fe.qw.qw.p009switch.i.de;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.pf.de.ppp;
import fe.qw.qw.rg;
import java.util.ArrayList;
import java.util.List;

public class th implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f3350ad;

    /* renamed from: de  reason: collision with root package name */
    public final qw f3351de;

    /* renamed from: fe  reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f3352fe = new LongSparseArray<>();
    @Nullable
    public ppp ggg;

    /* renamed from: i  reason: collision with root package name */
    public final List<o> f3353i = new ArrayList();

    /* renamed from: if  reason: not valid java name */
    public final BaseKeyframeAnimation<Integer, Integer> f106if;

    /* renamed from: o  reason: collision with root package name */
    public final GradientType f3354o;

    /* renamed from: pf  reason: collision with root package name */
    public final BaseKeyframeAnimation<ad, ad> f3355pf;
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> ppp;
    @NonNull
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f3356rg = new LongSparseArray<>();

    /* renamed from: switch  reason: not valid java name */
    public final BaseKeyframeAnimation<PointF, PointF> f107switch;

    /* renamed from: th  reason: collision with root package name */
    public final Path f3357th = new Path();

    /* renamed from: uk  reason: collision with root package name */
    public final RectF f3358uk = new RectF();
    public final rg vvv;
    public final BaseKeyframeAnimation<PointF, PointF> when;
    public final int xxx;

    /* renamed from: yj  reason: collision with root package name */
    public final Paint f3359yj = new fe.qw.qw.pf.qw(1);

    public th(rg rgVar, qw qwVar, de deVar) {
        this.f3351de = qwVar;
        this.qw = deVar.th();
        this.f3350ad = deVar.i();
        this.vvv = rgVar;
        this.f3354o = deVar.rg();
        this.f3357th.setFillType(deVar.de());
        this.xxx = (int) (rgVar.vvv().fe() / 32.0f);
        BaseKeyframeAnimation<ad, ad> qw2 = deVar.fe().qw();
        this.f3355pf = qw2;
        qw2.qw(this);
        qwVar.i(this.f3355pf);
        BaseKeyframeAnimation<Integer, Integer> qw3 = deVar.yj().qw();
        this.f106if = qw3;
        qw3.qw(this);
        qwVar.i(this.f106if);
        BaseKeyframeAnimation<PointF, PointF> qw4 = deVar.uk().qw();
        this.f107switch = qw4;
        qw4.qw(this);
        qwVar.i(this.f107switch);
        BaseKeyframeAnimation<PointF, PointF> qw5 = deVar.ad().qw();
        this.when = qw5;
        qw5.qw(this);
        qwVar.i(this.when);
    }

    public void ad(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            Content content = list2.get(i2);
            if (content instanceof o) {
                this.f3353i.add((o) content);
            }
        }
    }

    public <T> void de(T t, @Nullable fe.qw.qw.vvv.de<T> deVar) {
        if (t == LottieProperty.f556fe) {
            this.f106if.m1switch(deVar);
        } else if (t == LottieProperty.c) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.ppp;
            if (baseKeyframeAnimation != null) {
                this.f3351de.c(baseKeyframeAnimation);
            }
            if (deVar == null) {
                this.ppp = null;
                return;
            }
            ppp ppp2 = new ppp(deVar);
            this.ppp = ppp2;
            ppp2.qw(this);
            this.f3351de.i(this.ppp);
        } else if (t == LottieProperty.d) {
            ppp ppp3 = this.ggg;
            if (ppp3 != null) {
                this.f3351de.c(ppp3);
            }
            if (deVar == null) {
                this.ggg = null;
                return;
            }
            this.f3352fe.clear();
            this.f3356rg.clear();
            ppp ppp4 = new ppp(deVar);
            this.ggg = ppp4;
            ppp4.qw(this);
            this.f3351de.i(this.ggg);
        }
    }

    public void fe(fe feVar, int i2, List<fe> list, fe feVar2) {
        fe.qw.qw.ggg.th.m231switch(feVar, i2, list, feVar2, this);
    }

    public String getName() {
        return this.qw;
    }

    public final LinearGradient i() {
        long uk2 = (long) uk();
        LinearGradient linearGradient = this.f3352fe.get(uk2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF uk3 = this.f107switch.uk();
        PointF uk4 = this.when.uk();
        ad uk5 = this.f3355pf.uk();
        LinearGradient linearGradient2 = new LinearGradient(uk3.x, uk3.y, uk4.x, uk4.y, th(uk5.qw()), uk5.ad(), Shader.TileMode.CLAMP);
        this.f3352fe.put(uk2, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient o() {
        long uk2 = (long) uk();
        RadialGradient radialGradient = this.f3356rg.get(uk2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF uk3 = this.f107switch.uk();
        PointF uk4 = this.when.uk();
        ad uk5 = this.f3355pf.uk();
        int[] th2 = th(uk5.qw());
        float[] ad2 = uk5.ad();
        float f = uk3.x;
        float f2 = uk3.y;
        float hypot = (float) Math.hypot((double) (uk4.x - f), (double) (uk4.y - f2));
        RadialGradient radialGradient2 = new RadialGradient(f, f2, hypot <= 0.0f ? 0.001f : hypot, th2, ad2, Shader.TileMode.CLAMP);
        this.f3356rg.put(uk2, radialGradient2);
        return radialGradient2;
    }

    public void qw() {
        this.vvv.invalidateSelf();
    }

    public void rg(RectF rectF, Matrix matrix, boolean z) {
        this.f3357th.reset();
        for (int i2 = 0; i2 < this.f3353i.size(); i2++) {
            this.f3357th.addPath(this.f3353i.get(i2).getPath(), matrix);
        }
        this.f3357th.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public final int[] th(int[] iArr) {
        ppp ppp2 = this.ggg;
        if (ppp2 != null) {
            Integer[] numArr = (Integer[]) ppp2.uk();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    public final int uk() {
        int round = Math.round(this.f107switch.th() * ((float) this.xxx));
        int round2 = Math.round(this.when.th() * ((float) this.xxx));
        int round3 = Math.round(this.f3355pf.th() * ((float) this.xxx));
        int i2 = round != 0 ? PayBeanFactory.BEAN_ID_WIDTHDRAW * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    public void yj(Canvas canvas, Matrix matrix, int i2) {
        Shader shader;
        if (!this.f3350ad) {
            fe.qw.qw.ad.qw("GradientFillContent#draw");
            this.f3357th.reset();
            for (int i3 = 0; i3 < this.f3353i.size(); i3++) {
                this.f3357th.addPath(this.f3353i.get(i3).getPath(), matrix);
            }
            this.f3357th.computeBounds(this.f3358uk, false);
            if (this.f3354o == GradientType.LINEAR) {
                shader = i();
            } else {
                shader = o();
            }
            shader.setLocalMatrix(matrix);
            this.f3359yj.setShader(shader);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.ppp;
            if (baseKeyframeAnimation != null) {
                this.f3359yj.setColorFilter(baseKeyframeAnimation.uk());
            }
            this.f3359yj.setAlpha(fe.qw.qw.ggg.th.fe((int) ((((((float) i2) / 255.0f) * ((float) this.f106if.uk().intValue())) / 100.0f) * 255.0f), 0, 255));
            canvas.drawPath(this.f3357th, this.f3359yj);
            fe.qw.qw.ad.ad("GradientFillContent#draw");
        }
    }
}
