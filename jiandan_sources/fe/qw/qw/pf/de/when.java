package fe.qw.qw.pf.de;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import fe.qw.qw.p009switch.uk.Cif;
import fe.qw.qw.vvv.de;
import fe.qw.qw.vvv.fe;
import fe.qw.qw.vvv.qw;
import java.util.Collections;

public class when {

    /* renamed from: ad  reason: collision with root package name */
    public final Matrix f3380ad;

    /* renamed from: de  reason: collision with root package name */
    public final Matrix f3381de;

    /* renamed from: fe  reason: collision with root package name */
    public final Matrix f3382fe;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public BaseKeyframeAnimation<Float, Float> f3383i;
    @Nullable

    /* renamed from: if  reason: not valid java name */
    public ad f109if;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    public BaseKeyframeAnimation<Integer, Integer> f3384o;
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public ad f3385pf;
    public final Matrix qw = new Matrix();

    /* renamed from: rg  reason: collision with root package name */
    public final float[] f3386rg;
    @Nullable

    /* renamed from: switch  reason: not valid java name */
    public BaseKeyframeAnimation<?, Float> f110switch;
    @NonNull

    /* renamed from: th  reason: collision with root package name */
    public BaseKeyframeAnimation<PointF, PointF> f3387th;
    @NonNull

    /* renamed from: uk  reason: collision with root package name */
    public BaseKeyframeAnimation<fe, fe> f3388uk;
    @Nullable
    public BaseKeyframeAnimation<?, Float> when;
    @NonNull

    /* renamed from: yj  reason: collision with root package name */
    public BaseKeyframeAnimation<?, PointF> f3389yj;

    public when(Cif ifVar) {
        this.f3387th = ifVar.de() == null ? null : ifVar.de().qw();
        this.f3389yj = ifVar.th() == null ? null : ifVar.th().qw();
        this.f3388uk = ifVar.uk() == null ? null : ifVar.uk().qw();
        this.f3383i = ifVar.yj() == null ? null : ifVar.yj().qw();
        ad adVar = ifVar.i() == null ? null : (ad) ifVar.i().qw();
        this.f3385pf = adVar;
        if (adVar != null) {
            this.f3380ad = new Matrix();
            this.f3381de = new Matrix();
            this.f3382fe = new Matrix();
            this.f3386rg = new float[9];
        } else {
            this.f3380ad = null;
            this.f3381de = null;
            this.f3382fe = null;
            this.f3386rg = null;
        }
        this.f109if = ifVar.o() == null ? null : (ad) ifVar.o().qw();
        if (ifVar.rg() != null) {
            this.f3384o = ifVar.rg().qw();
        }
        if (ifVar.pf() != null) {
            this.f110switch = ifVar.pf().qw();
        } else {
            this.f110switch = null;
        }
        if (ifVar.fe() != null) {
            this.when = ifVar.fe().qw();
        } else {
            this.when = null;
        }
    }

    public void ad(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f3384o;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.qw(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f110switch;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.qw(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.when;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.qw(animationListener);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f3387th;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.qw(animationListener);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f3389yj;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.qw(animationListener);
        }
        BaseKeyframeAnimation<fe, fe> baseKeyframeAnimation6 = this.f3388uk;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.qw(animationListener);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.f3383i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.qw(animationListener);
        }
        ad adVar = this.f3385pf;
        if (adVar != null) {
            adVar.qw(animationListener);
        }
        ad adVar2 = this.f109if;
        if (adVar2 != null) {
            adVar2.qw(animationListener);
        }
    }

    public <T> boolean de(T t, @Nullable de<T> deVar) {
        ad adVar;
        ad adVar2;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.f560rg) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation3 = this.f3387th;
            if (baseKeyframeAnimation3 == null) {
                this.f3387th = new ppp(deVar, new PointF());
                return true;
            }
            baseKeyframeAnimation3.m1switch(deVar);
            return true;
        } else if (t == LottieProperty.f561th) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.f3389yj;
            if (baseKeyframeAnimation4 == null) {
                this.f3389yj = new ppp(deVar, new PointF());
                return true;
            }
            baseKeyframeAnimation4.m1switch(deVar);
            return true;
        } else if (t == LottieProperty.f559pf) {
            BaseKeyframeAnimation<fe, fe> baseKeyframeAnimation5 = this.f3388uk;
            if (baseKeyframeAnimation5 == null) {
                this.f3388uk = new ppp(deVar, new fe());
                return true;
            }
            baseKeyframeAnimation5.m1switch(deVar);
            return true;
        } else if (t == LottieProperty.f0if) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.f3383i;
            if (baseKeyframeAnimation6 == null) {
                this.f3383i = new ppp(deVar, Float.valueOf(0.0f));
                return true;
            }
            baseKeyframeAnimation6.m1switch(deVar);
            return true;
        } else if (t == LottieProperty.f555de) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.f3384o;
            if (baseKeyframeAnimation7 == null) {
                this.f3384o = new ppp(deVar, 100);
                return true;
            }
            baseKeyframeAnimation7.m1switch(deVar);
            return true;
        } else if (t != LottieProperty.rrr || (baseKeyframeAnimation2 = this.f110switch) == null) {
            if (t != LottieProperty.tt || (baseKeyframeAnimation = this.when) == null) {
                if (t == LottieProperty.f1switch && (adVar2 = this.f3385pf) != null) {
                    if (adVar2 == null) {
                        this.f3385pf = new ad(Collections.singletonList(new qw(Float.valueOf(0.0f))));
                    }
                    this.f3385pf.m1switch(deVar);
                    return true;
                } else if (t != LottieProperty.when || (adVar = this.f109if) == null) {
                    return false;
                } else {
                    if (adVar == null) {
                        this.f109if = new ad(Collections.singletonList(new qw(Float.valueOf(0.0f))));
                    }
                    this.f109if.m1switch(deVar);
                    return true;
                }
            } else if (baseKeyframeAnimation == null) {
                this.when = new ppp(deVar, 100);
                return true;
            } else {
                baseKeyframeAnimation.m1switch(deVar);
                return true;
            }
        } else if (baseKeyframeAnimation2 == null) {
            this.f110switch = new ppp(deVar, 100);
            return true;
        } else {
            baseKeyframeAnimation2.m1switch(deVar);
            return true;
        }
    }

    public final void fe() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.f3386rg[i2] = 0.0f;
        }
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> i() {
        return this.f110switch;
    }

    public void o(float f) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f3384o;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.m0if(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f110switch;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.m0if(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.when;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.m0if(f);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f3387th;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.m0if(f);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f3389yj;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.m0if(f);
        }
        BaseKeyframeAnimation<fe, fe> baseKeyframeAnimation6 = this.f3388uk;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.m0if(f);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.f3383i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.m0if(f);
        }
        ad adVar = this.f3385pf;
        if (adVar != null) {
            adVar.m0if(f);
        }
        ad adVar2 = this.f109if;
        if (adVar2 != null) {
            adVar2.m0if(f);
        }
    }

    public void qw(fe.qw.qw.p009switch.o.qw qwVar) {
        qwVar.i(this.f3384o);
        qwVar.i(this.f110switch);
        qwVar.i(this.when);
        qwVar.i(this.f3387th);
        qwVar.i(this.f3389yj);
        qwVar.i(this.f3388uk);
        qwVar.i(this.f3383i);
        qwVar.i(this.f3385pf);
        qwVar.i(this.f109if);
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> rg() {
        return this.when;
    }

    public Matrix th() {
        float f;
        this.qw.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f3389yj;
        if (baseKeyframeAnimation != null) {
            PointF uk2 = baseKeyframeAnimation.uk();
            if (!(uk2.x == 0.0f && uk2.y == 0.0f)) {
                this.qw.preTranslate(uk2.x, uk2.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f3383i;
        if (baseKeyframeAnimation2 != null) {
            if (baseKeyframeAnimation2 instanceof ppp) {
                f = baseKeyframeAnimation2.uk().floatValue();
            } else {
                f = ((ad) baseKeyframeAnimation2).ppp();
            }
            if (f != 0.0f) {
                this.qw.preRotate(f);
            }
        }
        if (this.f3385pf != null) {
            ad adVar = this.f109if;
            float cos = adVar == null ? 0.0f : (float) Math.cos(Math.toRadians((double) ((-adVar.ppp()) + 90.0f)));
            ad adVar2 = this.f109if;
            float sin = adVar2 == null ? 1.0f : (float) Math.sin(Math.toRadians((double) ((-adVar2.ppp()) + 90.0f)));
            fe();
            float[] fArr = this.f3386rg;
            fArr[0] = cos;
            fArr[1] = sin;
            float f2 = -sin;
            fArr[3] = f2;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f3380ad.setValues(fArr);
            fe();
            float[] fArr2 = this.f3386rg;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians((double) this.f3385pf.ppp()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f3381de.setValues(fArr2);
            fe();
            float[] fArr3 = this.f3386rg;
            fArr3[0] = cos;
            fArr3[1] = f2;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f3382fe.setValues(fArr3);
            this.f3381de.preConcat(this.f3380ad);
            this.f3382fe.preConcat(this.f3381de);
            this.qw.preConcat(this.f3382fe);
        }
        BaseKeyframeAnimation<fe, fe> baseKeyframeAnimation3 = this.f3388uk;
        if (baseKeyframeAnimation3 != null) {
            fe uk3 = baseKeyframeAnimation3.uk();
            if (!(uk3.ad() == 1.0f && uk3.de() == 1.0f)) {
                this.qw.preScale(uk3.ad(), uk3.de());
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f3387th;
        if (baseKeyframeAnimation4 != null) {
            PointF uk4 = baseKeyframeAnimation4.uk();
            if (!(uk4.x == 0.0f && uk4.y == 0.0f)) {
                this.qw.preTranslate(-uk4.x, -uk4.y);
            }
        }
        return this.qw;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Integer> uk() {
        return this.f3384o;
    }

    public Matrix yj(float f) {
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f3389yj;
        PointF pointF = null;
        PointF uk2 = baseKeyframeAnimation == null ? null : baseKeyframeAnimation.uk();
        BaseKeyframeAnimation<fe, fe> baseKeyframeAnimation2 = this.f3388uk;
        fe uk3 = baseKeyframeAnimation2 == null ? null : baseKeyframeAnimation2.uk();
        this.qw.reset();
        if (uk2 != null) {
            this.qw.preTranslate(uk2.x * f, uk2.y * f);
        }
        if (uk3 != null) {
            double d = (double) f;
            this.qw.preScale((float) Math.pow((double) uk3.ad(), d), (float) Math.pow((double) uk3.de(), d));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.f3383i;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = baseKeyframeAnimation3.uk().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f3387th;
            if (baseKeyframeAnimation4 != null) {
                pointF = baseKeyframeAnimation4.uk();
            }
            Matrix matrix = this.qw;
            float f2 = floatValue * f;
            float f3 = 0.0f;
            float f4 = pointF == null ? 0.0f : pointF.x;
            if (pointF != null) {
                f3 = pointF.y;
            }
            matrix.preRotate(f2, f4, f3);
        }
        return this.qw;
    }
}
