package fe.qw.qw.pf.ad;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import fe.qw.qw.ggg.th;
import fe.qw.qw.p009switch.fe;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.pf.de.ad;
import fe.qw.qw.rg;
import fe.qw.qw.vvv.de;
import java.util.List;

/* renamed from: fe.qw.qw.pf.ad.if  reason: invalid class name */
public class Cif implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, o {

    /* renamed from: ad  reason: collision with root package name */
    public final RectF f3302ad = new RectF();

    /* renamed from: de  reason: collision with root package name */
    public final String f3303de;

    /* renamed from: fe  reason: collision with root package name */
    public final boolean f3304fe;

    /* renamed from: i  reason: collision with root package name */
    public ad f3305i = new ad();

    /* renamed from: o  reason: collision with root package name */
    public boolean f3306o;
    public final Path qw = new Path();

    /* renamed from: rg  reason: collision with root package name */
    public final rg f3307rg;

    /* renamed from: th  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, PointF> f3308th;

    /* renamed from: uk  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, Float> f3309uk;

    /* renamed from: yj  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, PointF> f3310yj;

    public Cif(rg rgVar, qw qwVar, fe.qw.qw.p009switch.i.rg rgVar2) {
        this.f3303de = rgVar2.de();
        this.f3304fe = rgVar2.th();
        this.f3307rg = rgVar;
        this.f3308th = rgVar2.fe().qw();
        this.f3310yj = rgVar2.rg().qw();
        this.f3309uk = rgVar2.ad().qw();
        qwVar.i(this.f3308th);
        qwVar.i(this.f3310yj);
        qwVar.i(this.f3309uk);
        this.f3308th.qw(this);
        this.f3310yj.qw(this);
        this.f3309uk.qw(this);
    }

    public void ad(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Content content = list.get(i2);
            if (content instanceof ggg) {
                ggg ggg = (ggg) content;
                if (ggg.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f3305i.qw(ggg);
                    ggg.de(this);
                }
            }
        }
    }

    public <T> void de(T t, @Nullable de<T> deVar) {
        if (t == LottieProperty.f562uk) {
            this.f3310yj.m1switch(deVar);
        } else if (t == LottieProperty.f558o) {
            this.f3308th.m1switch(deVar);
        } else if (t == LottieProperty.f557i) {
            this.f3309uk.m1switch(deVar);
        }
    }

    public void fe(fe feVar, int i2, List<fe> list, fe feVar2) {
        th.m231switch(feVar, i2, list, feVar2, this);
    }

    public String getName() {
        return this.f3303de;
    }

    public Path getPath() {
        float f;
        if (this.f3306o) {
            return this.qw;
        }
        this.qw.reset();
        if (this.f3304fe) {
            this.f3306o = true;
            return this.qw;
        }
        PointF uk2 = this.f3310yj.uk();
        float f2 = uk2.x / 2.0f;
        float f3 = uk2.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f3309uk;
        if (baseKeyframeAnimation == null) {
            f = 0.0f;
        } else {
            f = ((ad) baseKeyframeAnimation).ppp();
        }
        float min = Math.min(f2, f3);
        if (f > min) {
            f = min;
        }
        PointF uk3 = this.f3308th.uk();
        this.qw.moveTo(uk3.x + f2, (uk3.y - f3) + f);
        this.qw.lineTo(uk3.x + f2, (uk3.y + f3) - f);
        int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i2 > 0) {
            RectF rectF = this.f3302ad;
            float f4 = uk3.x;
            float f5 = f * 2.0f;
            float f6 = uk3.y;
            rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
            this.qw.arcTo(this.f3302ad, 0.0f, 90.0f, false);
        }
        this.qw.lineTo((uk3.x - f2) + f, uk3.y + f3);
        if (i2 > 0) {
            RectF rectF2 = this.f3302ad;
            float f7 = uk3.x;
            float f8 = uk3.y;
            float f9 = f * 2.0f;
            rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
            this.qw.arcTo(this.f3302ad, 90.0f, 90.0f, false);
        }
        this.qw.lineTo(uk3.x - f2, (uk3.y - f3) + f);
        if (i2 > 0) {
            RectF rectF3 = this.f3302ad;
            float f10 = uk3.x;
            float f11 = uk3.y;
            float f12 = f * 2.0f;
            rectF3.set(f10 - f2, f11 - f3, (f10 - f2) + f12, (f11 - f3) + f12);
            this.qw.arcTo(this.f3302ad, 180.0f, 90.0f, false);
        }
        this.qw.lineTo((uk3.x + f2) - f, uk3.y - f3);
        if (i2 > 0) {
            RectF rectF4 = this.f3302ad;
            float f13 = uk3.x;
            float f14 = f * 2.0f;
            float f15 = uk3.y;
            rectF4.set((f13 + f2) - f14, f15 - f3, f13 + f2, (f15 - f3) + f14);
            this.qw.arcTo(this.f3302ad, 270.0f, 90.0f, false);
        }
        this.qw.close();
        this.f3305i.ad(this.qw);
        this.f3306o = true;
        return this.qw;
    }

    public void qw() {
        th();
    }

    public final void th() {
        this.f3306o = false;
        this.f3307rg.invalidateSelf();
    }
}
