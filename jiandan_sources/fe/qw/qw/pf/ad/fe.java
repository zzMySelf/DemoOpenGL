package fe.qw.qw.pf.ad;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import fe.qw.qw.ggg.th;
import fe.qw.qw.p009switch.i.qw;
import fe.qw.qw.rg;
import fe.qw.qw.vvv.de;
import java.util.List;

public class fe implements o, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: ad  reason: collision with root package name */
    public final String f3284ad;

    /* renamed from: de  reason: collision with root package name */
    public final rg f3285de;

    /* renamed from: fe  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, PointF> f3286fe;
    public final Path qw = new Path();

    /* renamed from: rg  reason: collision with root package name */
    public final BaseKeyframeAnimation<?, PointF> f3287rg;

    /* renamed from: th  reason: collision with root package name */
    public final qw f3288th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f3289uk;

    /* renamed from: yj  reason: collision with root package name */
    public ad f3290yj = new ad();

    public fe(rg rgVar, fe.qw.qw.p009switch.o.qw qwVar, qw qwVar2) {
        this.f3284ad = qwVar2.ad();
        this.f3285de = rgVar;
        this.f3286fe = qwVar2.fe().qw();
        this.f3287rg = qwVar2.de().qw();
        this.f3288th = qwVar2;
        qwVar.i(this.f3286fe);
        qwVar.i(this.f3287rg);
        this.f3286fe.qw(this);
        this.f3287rg.qw(this);
    }

    public void ad(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Content content = list.get(i2);
            if (content instanceof ggg) {
                ggg ggg = (ggg) content;
                if (ggg.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f3290yj.qw(ggg);
                    ggg.de(this);
                }
            }
        }
    }

    public <T> void de(T t, @Nullable de<T> deVar) {
        if (t == LottieProperty.f563yj) {
            this.f3286fe.m1switch(deVar);
        } else if (t == LottieProperty.f558o) {
            this.f3287rg.m1switch(deVar);
        }
    }

    public void fe(fe.qw.qw.p009switch.fe feVar, int i2, List<fe.qw.qw.p009switch.fe> list, fe.qw.qw.p009switch.fe feVar2) {
        th.m231switch(feVar, i2, list, feVar2, this);
    }

    public String getName() {
        return this.f3284ad;
    }

    public Path getPath() {
        if (this.f3289uk) {
            return this.qw;
        }
        this.qw.reset();
        if (this.f3288th.rg()) {
            this.f3289uk = true;
            return this.qw;
        }
        PointF uk2 = this.f3286fe.uk();
        float f = uk2.x / 2.0f;
        float f2 = uk2.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.qw.reset();
        if (this.f3288th.th()) {
            float f5 = -f2;
            this.qw.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.qw.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            float f10 = f5;
            this.qw.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f11 = f3 + 0.0f;
            this.qw.cubicTo(f11, f2, f, f9, f, 0.0f);
            this.qw.cubicTo(f, f8, f11, f10, 0.0f, f10);
        } else {
            float f12 = -f2;
            this.qw.moveTo(0.0f, f12);
            float f13 = f3 + 0.0f;
            float f14 = 0.0f - f4;
            this.qw.cubicTo(f13, f12, f, f14, f, 0.0f);
            float f15 = f4 + 0.0f;
            this.qw.cubicTo(f, f15, f13, f2, 0.0f, f2);
            float f16 = 0.0f - f3;
            float f17 = -f;
            this.qw.cubicTo(f16, f2, f17, f15, f17, 0.0f);
            float f18 = f12;
            this.qw.cubicTo(f17, f14, f16, f18, 0.0f, f18);
        }
        PointF uk3 = this.f3287rg.uk();
        this.qw.offset(uk3.x, uk3.y);
        this.qw.close();
        this.f3290yj.ad(this.qw);
        this.f3289uk = true;
        return this.qw;
    }

    public void qw() {
        th();
    }

    public final void th() {
        this.f3289uk = false;
        this.f3285de.invalidateSelf();
    }
}
