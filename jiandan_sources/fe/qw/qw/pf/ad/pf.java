package fe.qw.qw.pf.ad;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import fe.qw.qw.ggg.th;
import fe.qw.qw.p009switch.fe;
import fe.qw.qw.rg;
import fe.qw.qw.vvv.de;
import java.util.List;

public class pf implements o, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: ad  reason: collision with root package name */
    public final String f3311ad;

    /* renamed from: de  reason: collision with root package name */
    public final rg f3312de;

    /* renamed from: fe  reason: collision with root package name */
    public final PolystarShape.Type f3313fe;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, Float> f3314i;

    /* renamed from: if  reason: not valid java name */
    public final BaseKeyframeAnimation<?, Float> f102if;

    /* renamed from: o  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, Float> f3315o;
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, Float> f3316pf;
    public final Path qw = new Path();

    /* renamed from: rg  reason: collision with root package name */
    public final boolean f3317rg;

    /* renamed from: switch  reason: not valid java name */
    public ad f103switch = new ad();

    /* renamed from: th  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, Float> f3318th;

    /* renamed from: uk  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, Float> f3319uk;
    public boolean when;

    /* renamed from: yj  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, PointF> f3320yj;

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.content.PolystarShape$Type[] r0 = com.airbnb.lottie.model.content.PolystarShape.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.airbnb.lottie.model.content.PolystarShape$Type r1 = com.airbnb.lottie.model.content.PolystarShape.Type.STAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.PolystarShape$Type r1 = com.airbnb.lottie.model.content.PolystarShape.Type.POLYGON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.pf.ad.pf.qw.<clinit>():void");
        }
    }

    public pf(rg rgVar, fe.qw.qw.p009switch.o.qw qwVar, PolystarShape polystarShape) {
        this.f3312de = rgVar;
        this.f3311ad = polystarShape.fe();
        this.f3313fe = polystarShape.o();
        this.f3317rg = polystarShape.pf();
        this.f3318th = polystarShape.yj().qw();
        this.f3320yj = polystarShape.uk().qw();
        this.f3319uk = polystarShape.i().qw();
        this.f3315o = polystarShape.rg().qw();
        this.f102if = polystarShape.th().qw();
        if (this.f3313fe == PolystarShape.Type.STAR) {
            this.f3314i = polystarShape.ad().qw();
            this.f3316pf = polystarShape.de().qw();
        } else {
            this.f3314i = null;
            this.f3316pf = null;
        }
        qwVar.i(this.f3318th);
        qwVar.i(this.f3320yj);
        qwVar.i(this.f3319uk);
        qwVar.i(this.f3315o);
        qwVar.i(this.f102if);
        if (this.f3313fe == PolystarShape.Type.STAR) {
            qwVar.i(this.f3314i);
            qwVar.i(this.f3316pf);
        }
        this.f3318th.qw(this);
        this.f3320yj.qw(this);
        this.f3319uk.qw(this);
        this.f3315o.qw(this);
        this.f102if.qw(this);
        if (this.f3313fe == PolystarShape.Type.STAR) {
            this.f3314i.qw(this);
            this.f3316pf.qw(this);
        }
    }

    public void ad(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Content content = list.get(i2);
            if (content instanceof ggg) {
                ggg ggg = (ggg) content;
                if (ggg.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f103switch.qw(ggg);
                    ggg.de(this);
                }
            }
        }
    }

    public <T> void de(T t, @Nullable de<T> deVar) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.ddd) {
            this.f3318th.m1switch(deVar);
        } else if (t == LottieProperty.nn) {
            this.f3319uk.m1switch(deVar);
        } else if (t == LottieProperty.f558o) {
            this.f3320yj.m1switch(deVar);
        } else if (t == LottieProperty.mmm && (baseKeyframeAnimation2 = this.f3314i) != null) {
            baseKeyframeAnimation2.m1switch(deVar);
        } else if (t == LottieProperty.aaa) {
            this.f3315o.m1switch(deVar);
        } else if (t == LottieProperty.qqq && (baseKeyframeAnimation = this.f3316pf) != null) {
            baseKeyframeAnimation.m1switch(deVar);
        } else if (t == LottieProperty.eee) {
            this.f102if.m1switch(deVar);
        }
    }

    public void fe(fe feVar, int i2, List<fe> list, fe feVar2) {
        th.m231switch(feVar, i2, list, feVar2, this);
    }

    public String getName() {
        return this.f3311ad;
    }

    public Path getPath() {
        if (this.when) {
            return this.qw;
        }
        this.qw.reset();
        if (this.f3317rg) {
            this.when = true;
            return this.qw;
        }
        int i2 = qw.qw[this.f3313fe.ordinal()];
        if (i2 == 1) {
            uk();
        } else if (i2 == 2) {
            th();
        }
        this.qw.close();
        this.f103switch.ad(this.qw);
        this.when = true;
        return this.qw;
    }

    public final void i() {
        this.when = false;
        this.f3312de.invalidateSelf();
    }

    public void qw() {
        i();
    }

    public final void th() {
        double d;
        double d2;
        double d3;
        int i2;
        int floor = (int) Math.floor((double) this.f3318th.uk().floatValue());
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f3319uk;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? 0.0d : (double) baseKeyframeAnimation.uk().floatValue()) - 90.0d);
        double d4 = (double) floor;
        float floatValue = this.f102if.uk().floatValue() / 100.0f;
        float floatValue2 = this.f3315o.uk().floatValue();
        double d5 = (double) floatValue2;
        float cos = (float) (Math.cos(radians) * d5);
        float sin = (float) (Math.sin(radians) * d5);
        this.qw.moveTo(cos, sin);
        double d6 = (double) ((float) (6.283185307179586d / d4));
        double d7 = radians + d6;
        double ceil = Math.ceil(d4);
        int i3 = 0;
        while (((double) i3) < ceil) {
            float cos2 = (float) (Math.cos(d7) * d5);
            double d8 = ceil;
            float sin2 = (float) (d5 * Math.sin(d7));
            if (floatValue != 0.0f) {
                d3 = d5;
                i2 = i3;
                d2 = d7;
                double atan2 = (double) ((float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d));
                float cos3 = (float) Math.cos(atan2);
                d = d6;
                double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                float f = floatValue2 * floatValue * 0.25f;
                this.qw.cubicTo(cos - (cos3 * f), sin - (((float) Math.sin(atan2)) * f), cos2 + (((float) Math.cos(atan22)) * f), sin2 + (f * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d2 = d7;
                d3 = d5;
                d = d6;
                i2 = i3;
                this.qw.lineTo(cos2, sin2);
            }
            d7 = d2 + d;
            i3 = i2 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d8;
            d5 = d3;
            d6 = d;
        }
        PointF uk2 = this.f3320yj.uk();
        this.qw.offset(uk2.x, uk2.y);
        this.qw.close();
    }

    public final void uk() {
        double d;
        int i2;
        float f;
        float f2;
        float f3;
        double d2;
        float f4;
        float f5;
        double d3;
        float f6;
        float f7;
        float f8;
        float f9;
        float floatValue = this.f3318th.uk().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f3319uk;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? 0.0d : (double) baseKeyframeAnimation.uk().floatValue()) - 90.0d);
        double d4 = (double) floatValue;
        float f10 = (float) (6.283185307179586d / d4);
        float f11 = f10 / 2.0f;
        float f12 = floatValue - ((float) ((int) floatValue));
        int i3 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (double) ((1.0f - f12) * f11);
        }
        float floatValue2 = this.f3315o.uk().floatValue();
        float floatValue3 = this.f3314i.uk().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f3316pf;
        float floatValue4 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.uk().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f102if;
        float floatValue5 = baseKeyframeAnimation3 != null ? baseKeyframeAnimation3.uk().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f = ((floatValue2 - floatValue3) * f12) + floatValue3;
            i2 = i3;
            double d5 = (double) f;
            d = d4;
            f3 = (float) (d5 * Math.cos(radians));
            f2 = (float) (d5 * Math.sin(radians));
            this.qw.moveTo(f3, f2);
            d2 = radians + ((double) ((f10 * f12) / 2.0f));
        } else {
            d = d4;
            i2 = i3;
            double d6 = (double) floatValue2;
            float cos = (float) (Math.cos(radians) * d6);
            float sin = (float) (d6 * Math.sin(radians));
            this.qw.moveTo(cos, sin);
            d2 = radians + ((double) f11);
            f3 = cos;
            f2 = sin;
            f = 0.0f;
        }
        double ceil = Math.ceil(d) * 2.0d;
        float f13 = floatValue2;
        float f14 = floatValue3;
        int i4 = 0;
        boolean z = false;
        while (true) {
            double d7 = (double) i4;
            if (d7 < ceil) {
                float f15 = z ? f13 : f14;
                int i5 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i5 == 0 || d7 != ceil - 2.0d) {
                    f4 = f10;
                    f5 = f11;
                } else {
                    f4 = f10;
                    f5 = (f10 * f12) / 2.0f;
                }
                if (i5 == 0 || d7 != ceil - 1.0d) {
                    f6 = f11;
                    d3 = d7;
                    f7 = f15;
                } else {
                    f6 = f11;
                    d3 = d7;
                    f7 = f;
                }
                double d8 = (double) f7;
                double d9 = ceil;
                float cos2 = (float) (d8 * Math.cos(d2));
                float sin2 = (float) (d8 * Math.sin(d2));
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.qw.lineTo(cos2, sin2);
                    f9 = floatValue4;
                    f8 = f;
                } else {
                    f9 = floatValue4;
                    f8 = f;
                    double atan2 = (double) ((float) (Math.atan2((double) f2, (double) f3) - 1.5707963267948966d));
                    float sin3 = (float) Math.sin(atan2);
                    float cos3 = (float) Math.cos(atan2);
                    double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f16 = z ? f9 : floatValue5;
                    float f17 = z ? floatValue5 : f9;
                    float f18 = (z ? f14 : f13) * f16 * 0.47829f;
                    float f19 = cos3 * f18;
                    float f20 = f18 * sin3;
                    float f21 = (z ? f13 : f14) * f17 * 0.47829f;
                    float f22 = cos4 * f21;
                    float f23 = f21 * sin4;
                    if (i2 != 0) {
                        if (i4 == 0) {
                            f19 *= f12;
                            f20 *= f12;
                        } else if (d3 == d9 - 1.0d) {
                            f22 *= f12;
                            f23 *= f12;
                        }
                    }
                    this.qw.cubicTo(f3 - f19, f2 - f20, cos2 + f22, sin2 + f23, cos2, sin2);
                }
                d2 += (double) f5;
                z = !z;
                i4++;
                f3 = cos2;
                f2 = sin2;
                floatValue4 = f9;
                f = f8;
                f11 = f6;
                f10 = f4;
                ceil = d9;
            } else {
                PointF uk2 = this.f3320yj.uk();
                this.qw.offset(uk2.x, uk2.y);
                this.qw.close();
                return;
            }
        }
    }
}
