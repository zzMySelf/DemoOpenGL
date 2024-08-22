package fe.qw.qw.pf.ad;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientType;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import fe.qw.qw.p009switch.i.ad;
import fe.qw.qw.p009switch.i.fe;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.pf.de.ppp;
import fe.qw.qw.rg;
import fe.qw.qw.vvv.de;

public class yj extends qw {
    public final BaseKeyframeAnimation<ad, ad> aaa;
    public final RectF ddd = new RectF();
    public final BaseKeyframeAnimation<PointF, PointF> eee;
    public final boolean ggg;
    public final int mmm;
    public final GradientType nn;
    public final String ppp;
    public final BaseKeyframeAnimation<PointF, PointF> qqq;
    @Nullable
    public ppp rrr;
    public final LongSparseArray<LinearGradient> vvv = new LongSparseArray<>();
    public final LongSparseArray<RadialGradient> xxx = new LongSparseArray<>();

    public yj(rg rgVar, qw qwVar, fe feVar) {
        super(rgVar, qwVar, feVar.ad().toPaintCap(), feVar.yj().toPaintJoin(), feVar.i(), feVar.pf(), feVar.m241switch(), feVar.uk(), feVar.de());
        this.ppp = feVar.o();
        this.nn = feVar.th();
        this.ggg = feVar.when();
        this.mmm = (int) (rgVar.vvv().fe() / 32.0f);
        BaseKeyframeAnimation<ad, ad> qw = feVar.rg().qw();
        this.aaa = qw;
        qw.qw(this);
        qwVar.i(this.aaa);
        BaseKeyframeAnimation<PointF, PointF> qw2 = feVar.m240if().qw();
        this.qqq = qw2;
        qw2.qw(this);
        qwVar.i(this.qqq);
        BaseKeyframeAnimation<PointF, PointF> qw3 = feVar.fe().qw();
        this.eee = qw3;
        qw3.qw(this);
        qwVar.i(this.eee);
    }

    public <T> void de(T t, @Nullable de<T> deVar) {
        super.de(t, deVar);
        if (t == LottieProperty.d) {
            ppp ppp2 = this.rrr;
            if (ppp2 != null) {
                this.f3328th.c(ppp2);
            }
            if (deVar == null) {
                this.rrr = null;
                return;
            }
            ppp ppp3 = new ppp(deVar);
            this.rrr = ppp3;
            ppp3.qw(this);
            this.f3328th.i(this.rrr);
        }
    }

    public String getName() {
        return this.ppp;
    }

    public final int[] i(int[] iArr) {
        ppp ppp2 = this.rrr;
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

    /* renamed from: if  reason: not valid java name */
    public final RadialGradient m234if() {
        long o2 = (long) o();
        RadialGradient radialGradient = this.xxx.get(o2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF uk2 = this.qqq.uk();
        PointF uk3 = this.eee.uk();
        ad uk4 = this.aaa.uk();
        int[] i2 = i(uk4.qw());
        float[] ad2 = uk4.ad();
        float f = uk2.x;
        float f2 = uk2.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot((double) (uk3.x - f), (double) (uk3.y - f2)), i2, ad2, Shader.TileMode.CLAMP);
        this.xxx.put(o2, radialGradient2);
        return radialGradient2;
    }

    public final int o() {
        int round = Math.round(this.qqq.th() * ((float) this.mmm));
        int round2 = Math.round(this.eee.th() * ((float) this.mmm));
        int round3 = Math.round(this.aaa.th() * ((float) this.mmm));
        int i2 = round != 0 ? PayBeanFactory.BEAN_ID_WIDTHDRAW * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    public final LinearGradient pf() {
        long o2 = (long) o();
        LinearGradient linearGradient = this.vvv.get(o2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF uk2 = this.qqq.uk();
        PointF uk3 = this.eee.uk();
        ad uk4 = this.aaa.uk();
        LinearGradient linearGradient2 = new LinearGradient(uk2.x, uk2.y, uk3.x, uk3.y, i(uk4.qw()), uk4.ad(), Shader.TileMode.CLAMP);
        this.vvv.put(o2, linearGradient2);
        return linearGradient2;
    }

    public void yj(Canvas canvas, Matrix matrix, int i2) {
        Shader shader;
        if (!this.ggg) {
            rg(this.ddd, matrix, false);
            if (this.nn == GradientType.LINEAR) {
                shader = pf();
            } else {
                shader = m234if();
            }
            shader.setLocalMatrix(matrix);
            this.f3324i.setShader(shader);
            super.yj(canvas, matrix, i2);
        }
    }
}
