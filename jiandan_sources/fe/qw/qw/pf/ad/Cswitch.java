package fe.qw.qw.pf.ad;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import fe.qw.qw.p009switch.fe;
import fe.qw.qw.p009switch.i.th;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.pf.de.when;
import fe.qw.qw.rg;
import fe.qw.qw.vvv.de;
import java.util.List;

/* renamed from: fe.qw.qw.pf.ad.switch  reason: invalid class name */
public class Cswitch implements DrawingContent, o, uk, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: ad  reason: collision with root package name */
    public final Path f3341ad = new Path();

    /* renamed from: de  reason: collision with root package name */
    public final rg f3342de;

    /* renamed from: fe  reason: collision with root package name */
    public final qw f3343fe;

    /* renamed from: i  reason: collision with root package name */
    public final when f3344i;

    /* renamed from: o  reason: collision with root package name */
    public de f3345o;
    public final Matrix qw = new Matrix();

    /* renamed from: rg  reason: collision with root package name */
    public final String f3346rg;

    /* renamed from: th  reason: collision with root package name */
    public final boolean f3347th;

    /* renamed from: uk  reason: collision with root package name */
    public final BaseKeyframeAnimation<Float, Float> f3348uk;

    /* renamed from: yj  reason: collision with root package name */
    public final BaseKeyframeAnimation<Float, Float> f3349yj;

    public Cswitch(rg rgVar, qw qwVar, th thVar) {
        this.f3342de = rgVar;
        this.f3343fe = qwVar;
        this.f3346rg = thVar.de();
        this.f3347th = thVar.th();
        BaseKeyframeAnimation<Float, Float> qw2 = thVar.ad().qw();
        this.f3349yj = qw2;
        qwVar.i(qw2);
        this.f3349yj.qw(this);
        BaseKeyframeAnimation<Float, Float> qw3 = thVar.fe().qw();
        this.f3348uk = qw3;
        qwVar.i(qw3);
        this.f3348uk.qw(this);
        when ad2 = thVar.rg().ad();
        this.f3344i = ad2;
        ad2.qw(qwVar);
        this.f3344i.ad(this);
    }

    public void ad(List<Content> list, List<Content> list2) {
        this.f3345o.ad(list, list2);
    }

    public <T> void de(T t, @Nullable de<T> deVar) {
        if (!this.f3344i.de(t, deVar)) {
            if (t == LottieProperty.vvv) {
                this.f3349yj.m1switch(deVar);
            } else if (t == LottieProperty.xxx) {
                this.f3348uk.m1switch(deVar);
            }
        }
    }

    public void fe(fe feVar, int i2, List<fe> list, fe feVar2) {
        fe.qw.qw.ggg.th.m231switch(feVar, i2, list, feVar2, this);
    }

    public String getName() {
        return this.f3346rg;
    }

    public Path getPath() {
        Path path = this.f3345o.getPath();
        this.f3341ad.reset();
        float floatValue = this.f3349yj.uk().floatValue();
        float floatValue2 = this.f3348uk.uk().floatValue();
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.qw.set(this.f3344i.yj(((float) i2) + floatValue2));
            this.f3341ad.addPath(path, this.qw);
        }
        return this.f3341ad;
    }

    public void qw() {
        this.f3342de.invalidateSelf();
    }

    public void rg(RectF rectF, Matrix matrix, boolean z) {
        this.f3345o.rg(rectF, matrix, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0005 A[LOOP:0: B:3:0x0005->B:6:0x000f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void th(java.util.ListIterator<com.airbnb.lottie.animation.content.Content> r9) {
        /*
            r8 = this;
            fe.qw.qw.pf.ad.de r0 = r8.f3345o
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r9.previous()
            if (r0 == r8) goto L_0x0012
            goto L_0x0005
        L_0x0012:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0017:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r9.previous()
            r6.add(r0)
            r9.remove()
            goto L_0x0017
        L_0x0028:
            java.util.Collections.reverse(r6)
            fe.qw.qw.pf.ad.de r9 = new fe.qw.qw.pf.ad.de
            fe.qw.qw.rg r2 = r8.f3342de
            fe.qw.qw.switch.o.qw r3 = r8.f3343fe
            boolean r5 = r8.f3347th
            r7 = 0
            java.lang.String r4 = "Repeater"
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r8.f3345o = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.pf.ad.Cswitch.th(java.util.ListIterator):void");
    }

    public void yj(Canvas canvas, Matrix matrix, int i2) {
        float floatValue = this.f3349yj.uk().floatValue();
        float floatValue2 = this.f3348uk.uk().floatValue();
        float floatValue3 = this.f3344i.i().uk().floatValue() / 100.0f;
        float floatValue4 = this.f3344i.rg().uk().floatValue() / 100.0f;
        for (int i3 = ((int) floatValue) - 1; i3 >= 0; i3--) {
            this.qw.set(matrix);
            float f = (float) i3;
            this.qw.preConcat(this.f3344i.yj(f + floatValue2));
            this.f3345o.yj(canvas, this.qw, (int) (((float) i2) * fe.qw.qw.ggg.th.pf(floatValue3, floatValue4, f / floatValue)));
        }
    }
}
