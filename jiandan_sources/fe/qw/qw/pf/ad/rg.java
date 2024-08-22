package fe.qw.qw.pf.ad;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import fe.qw.qw.ad;
import fe.qw.qw.ggg.th;
import fe.qw.qw.p009switch.fe;
import fe.qw.qw.p009switch.i.uk;
import fe.qw.qw.pf.de.ppp;
import fe.qw.qw.pf.qw;
import fe.qw.qw.vvv.de;
import java.util.ArrayList;
import java.util.List;

public class rg implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: ad  reason: collision with root package name */
    public final Paint f3332ad = new qw(1);

    /* renamed from: de  reason: collision with root package name */
    public final fe.qw.qw.p009switch.o.qw f3333de;

    /* renamed from: fe  reason: collision with root package name */
    public final String f3334fe;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> f3335i;

    /* renamed from: o  reason: collision with root package name */
    public final fe.qw.qw.rg f3336o;
    public final Path qw = new Path();

    /* renamed from: rg  reason: collision with root package name */
    public final boolean f3337rg;

    /* renamed from: th  reason: collision with root package name */
    public final List<o> f3338th = new ArrayList();

    /* renamed from: uk  reason: collision with root package name */
    public final BaseKeyframeAnimation<Integer, Integer> f3339uk;

    /* renamed from: yj  reason: collision with root package name */
    public final BaseKeyframeAnimation<Integer, Integer> f3340yj;

    public rg(fe.qw.qw.rg rgVar, fe.qw.qw.p009switch.o.qw qwVar, uk ukVar) {
        this.f3333de = qwVar;
        this.f3334fe = ukVar.fe();
        this.f3337rg = ukVar.th();
        this.f3336o = rgVar;
        if (ukVar.ad() == null || ukVar.rg() == null) {
            this.f3340yj = null;
            this.f3339uk = null;
            return;
        }
        this.qw.setFillType(ukVar.de());
        BaseKeyframeAnimation<Integer, Integer> qw2 = ukVar.ad().qw();
        this.f3340yj = qw2;
        qw2.qw(this);
        qwVar.i(this.f3340yj);
        BaseKeyframeAnimation<Integer, Integer> qw3 = ukVar.rg().qw();
        this.f3339uk = qw3;
        qw3.qw(this);
        qwVar.i(this.f3339uk);
    }

    public void ad(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            Content content = list2.get(i2);
            if (content instanceof o) {
                this.f3338th.add((o) content);
            }
        }
    }

    public <T> void de(T t, @Nullable de<T> deVar) {
        if (t == LottieProperty.qw) {
            this.f3340yj.m1switch(deVar);
        } else if (t == LottieProperty.f556fe) {
            this.f3339uk.m1switch(deVar);
        } else if (t == LottieProperty.c) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f3335i;
            if (baseKeyframeAnimation != null) {
                this.f3333de.c(baseKeyframeAnimation);
            }
            if (deVar == null) {
                this.f3335i = null;
                return;
            }
            ppp ppp = new ppp(deVar);
            this.f3335i = ppp;
            ppp.qw(this);
            this.f3333de.i(this.f3335i);
        }
    }

    public void fe(fe feVar, int i2, List<fe> list, fe feVar2) {
        th.m231switch(feVar, i2, list, feVar2, this);
    }

    public String getName() {
        return this.f3334fe;
    }

    public void qw() {
        this.f3336o.invalidateSelf();
    }

    public void rg(RectF rectF, Matrix matrix, boolean z) {
        this.qw.reset();
        for (int i2 = 0; i2 < this.f3338th.size(); i2++) {
            this.qw.addPath(this.f3338th.get(i2).getPath(), matrix);
        }
        this.qw.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public void yj(Canvas canvas, Matrix matrix, int i2) {
        if (!this.f3337rg) {
            ad.qw("FillContent#draw");
            this.f3332ad.setColor(((fe.qw.qw.pf.de.qw) this.f3340yj).ppp());
            this.f3332ad.setAlpha(th.fe((int) ((((((float) i2) / 255.0f) * ((float) this.f3339uk.uk().intValue())) / 100.0f) * 255.0f), 0, 255));
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f3335i;
            if (baseKeyframeAnimation != null) {
                this.f3332ad.setColorFilter(baseKeyframeAnimation.uk());
            }
            this.qw.reset();
            for (int i3 = 0; i3 < this.f3338th.size(); i3++) {
                this.qw.addPath(this.f3338th.get(i3).getPath(), matrix);
            }
            canvas.drawPath(this.qw, this.f3332ad);
            ad.ad("FillContent#draw");
        }
    }
}
