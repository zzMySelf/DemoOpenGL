package fe.qw.qw.p009switch.o;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import fe.qw.qw.de;
import fe.qw.qw.ggg.fe;
import fe.qw.qw.p009switch.i.yj;
import fe.qw.qw.pf.de.th;
import fe.qw.qw.pf.de.when;
import fe.qw.qw.rg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: fe.qw.qw.switch.o.qw  reason: invalid package */
public abstract class qw implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    public final when aaa;

    /* renamed from: ad  reason: collision with root package name */
    public final Matrix f3482ad = new Matrix();
    @Nullable
    public qw ddd;

    /* renamed from: de  reason: collision with root package name */
    public final Paint f3483de = new fe.qw.qw.pf.qw(1);
    public boolean eee;

    /* renamed from: fe  reason: collision with root package name */
    public final Paint f3484fe = new fe.qw.qw.pf.qw(1, PorterDuff.Mode.DST_IN);
    @Nullable
    public th ggg;

    /* renamed from: i  reason: collision with root package name */
    public final RectF f3485i = new RectF();

    /* renamed from: if  reason: not valid java name */
    public final String f117if;
    public final List<BaseKeyframeAnimation<?, ?>> mmm = new ArrayList();
    public List<qw> nn;

    /* renamed from: o  reason: collision with root package name */
    public final RectF f3486o = new RectF();

    /* renamed from: pf  reason: collision with root package name */
    public final RectF f3487pf = new RectF();
    public final Layer ppp;
    public boolean qqq = true;
    public final Path qw = new Path();

    /* renamed from: rg  reason: collision with root package name */
    public final Paint f3488rg = new fe.qw.qw.pf.qw(1, PorterDuff.Mode.DST_OUT);
    @Nullable
    public Paint rrr;

    /* renamed from: switch  reason: not valid java name */
    public final Matrix f118switch = new Matrix();

    /* renamed from: th  reason: collision with root package name */
    public final Paint f3489th = new fe.qw.qw.pf.qw(1);

    /* renamed from: uk  reason: collision with root package name */
    public final RectF f3490uk = new RectF();
    @Nullable
    public fe.qw.qw.pf.de.ad vvv;
    public final rg when;
    @Nullable
    public qw xxx;

    /* renamed from: yj  reason: collision with root package name */
    public final Paint f3491yj = new fe.qw.qw.pf.qw(PorterDuff.Mode.CLEAR);

    /* renamed from: fe.qw.qw.switch.o.qw$ad */
    public static /* synthetic */ class ad {

        /* renamed from: ad  reason: collision with root package name */
        public static final /* synthetic */ int[] f3492ad;
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        static {
            /*
                com.airbnb.lottie.model.content.Mask$MaskMode[] r0 = com.airbnb.lottie.model.content.Mask.MaskMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3492ad = r0
                r1 = 1
                com.airbnb.lottie.model.content.Mask$MaskMode r2 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f3492ad     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.Mask$MaskMode r3 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_SUBTRACT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f3492ad     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.content.Mask$MaskMode r4 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_INTERSECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f3492ad     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.airbnb.lottie.model.content.Mask$MaskMode r5 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_ADD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.airbnb.lottie.model.layer.Layer$LayerType[] r4 = com.airbnb.lottie.model.layer.Layer.LayerType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                qw = r4
                com.airbnb.lottie.model.layer.Layer$LayerType r5 = com.airbnb.lottie.model.layer.Layer.LayerType.SHAPE     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = qw     // Catch:{ NoSuchFieldError -> 0x004e }
                com.airbnb.lottie.model.layer.Layer$LayerType r4 = com.airbnb.lottie.model.layer.Layer.LayerType.PRE_COMP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.SOLID     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.IMAGE     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x006d }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.NULL     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.TEXT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0083 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.p009switch.o.qw.ad.<clinit>():void");
        }
    }

    /* renamed from: fe.qw.qw.switch.o.qw$qw  reason: collision with other inner class name */
    public class C0151qw implements BaseKeyframeAnimation.AnimationListener {
        public C0151qw() {
        }

        public void qw() {
            qw qwVar = qw.this;
            qwVar.j(qwVar.vvv.ppp() == 1.0f);
        }
    }

    public qw(rg rgVar, Layer layer) {
        this.when = rgVar;
        this.ppp = layer;
        this.f117if = layer.yj() + "#draw";
        if (layer.th() == Layer.MatteType.INVERT) {
            this.f3489th.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.f3489th.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        when ad2 = layer.mmm().ad();
        this.aaa = ad2;
        ad2.ad(this);
        if (layer.rg() != null && !layer.rg().isEmpty()) {
            th thVar = new th(layer.rg());
            this.ggg = thVar;
            for (BaseKeyframeAnimation<yj, Path> qw2 : thVar.qw()) {
                qw2.qw(this);
            }
            for (BaseKeyframeAnimation next : this.ggg.de()) {
                i(next);
                next.qw(this);
            }
        }
        k();
    }

    @Nullable
    public static qw mmm(Layer layer, rg rgVar, de deVar) {
        switch (ad.qw[layer.fe().ordinal()]) {
            case 1:
                return new rg(rgVar, layer);
            case 2:
                return new ad(rgVar, layer, deVar.when(layer.pf()), deVar);
            case 3:
                return new th(rgVar, layer);
            case 4:
                return new de(rgVar, layer);
            case 5:
                return new fe(rgVar, layer);
            case 6:
                return new yj(rgVar, layer);
            default:
                fe.de("Unknown layer type " + layer.fe());
                return null;
        }
    }

    public final void a() {
        this.when.invalidateSelf();
    }

    public Layer aaa() {
        return this.ppp;
    }

    public void ad(List<Content> list, List<Content> list2) {
    }

    public final void b(float f) {
        this.when.vvv().m227switch().qw(this.ppp.yj(), f);
    }

    public void c(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.mmm.remove(baseKeyframeAnimation);
    }

    public void d(fe.qw.qw.p009switch.fe feVar, int i2, List<fe.qw.qw.p009switch.fe> list, fe.qw.qw.p009switch.fe feVar2) {
    }

    public final void ddd(Canvas canvas) {
        fe.qw.qw.ad.qw("Layer#clearLayer");
        RectF rectF = this.f3490uk;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f3491yj);
        fe.qw.qw.ad.ad("Layer#clearLayer");
    }

    @CallSuper
    public <T> void de(T t, @Nullable fe.qw.qw.vvv.de<T> deVar) {
        this.aaa.de(t, deVar);
    }

    public void e(@Nullable qw qwVar) {
        this.xxx = qwVar;
    }

    public boolean eee() {
        return this.xxx != null;
    }

    public void f(boolean z) {
        if (z && this.rrr == null) {
            this.rrr = new fe.qw.qw.pf.qw();
        }
        this.eee = z;
    }

    public void fe(fe.qw.qw.p009switch.fe feVar, int i2, List<fe.qw.qw.p009switch.fe> list, fe.qw.qw.p009switch.fe feVar2) {
        if (feVar.yj(getName(), i2)) {
            if (!"__container".equals(getName())) {
                feVar2 = feVar2.qw(getName());
                if (feVar.de(getName(), i2)) {
                    list.add(feVar2.i(this));
                }
            }
            if (feVar.uk(getName(), i2)) {
                d(feVar, i2 + feVar.rg(getName(), i2), list, feVar2);
            }
        }
    }

    public void g(@Nullable qw qwVar) {
        this.ddd = qwVar;
    }

    public String getName() {
        return this.ppp.yj();
    }

    public final void ggg(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<yj, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.qw.set(baseKeyframeAnimation.uk());
        this.qw.transform(matrix);
        canvas.drawPath(this.qw, this.f3488rg);
    }

    public void h(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.aaa.o(f);
        if (this.ggg != null) {
            for (int i2 = 0; i2 < this.ggg.qw().size(); i2++) {
                this.ggg.qw().get(i2).m0if(f);
            }
        }
        if (this.ppp.nn() != 0.0f) {
            f /= this.ppp.nn();
        }
        fe.qw.qw.pf.de.ad adVar = this.vvv;
        if (adVar != null) {
            adVar.m0if(f / this.ppp.nn());
        }
        qw qwVar = this.xxx;
        if (qwVar != null) {
            this.xxx.h(qwVar.ppp.nn() * f);
        }
        for (int i3 = 0; i3 < this.mmm.size(); i3++) {
            this.mmm.get(i3).m0if(f);
        }
    }

    public void i(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation != null) {
            this.mmm.add(baseKeyframeAnimation);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m242if(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<yj, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        fe.qw.qw.ggg.yj.m233switch(canvas, this.f3490uk, this.f3483de);
        canvas.drawRect(this.f3490uk, this.f3483de);
        this.qw.set(baseKeyframeAnimation.uk());
        this.qw.transform(matrix);
        this.f3483de.setAlpha((int) (((float) baseKeyframeAnimation2.uk().intValue()) * 2.55f));
        canvas.drawPath(this.qw, this.f3488rg);
        canvas.restore();
    }

    public final void j(boolean z) {
        if (z != this.qqq) {
            this.qqq = z;
            a();
        }
    }

    public final void k() {
        boolean z = true;
        if (!this.ppp.de().isEmpty()) {
            fe.qw.qw.pf.de.ad adVar = new fe.qw.qw.pf.de.ad(this.ppp.de());
            this.vvv = adVar;
            adVar.pf();
            this.vvv.qw(new C0151qw());
            if (((Float) this.vvv.uk()).floatValue() != 1.0f) {
                z = false;
            }
            j(z);
            i(this.vvv);
            return;
        }
        j(true);
    }

    public abstract void nn(Canvas canvas, Matrix matrix, int i2);

    public final void o(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<yj, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.qw.set(baseKeyframeAnimation.uk());
        this.qw.transform(matrix);
        this.f3483de.setAlpha((int) (((float) baseKeyframeAnimation2.uk().intValue()) * 2.55f));
        canvas.drawPath(this.qw, this.f3483de);
    }

    public final void pf(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<yj, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        fe.qw.qw.ggg.yj.m233switch(canvas, this.f3490uk, this.f3484fe);
        this.qw.set(baseKeyframeAnimation.uk());
        this.qw.transform(matrix);
        this.f3483de.setAlpha((int) (((float) baseKeyframeAnimation2.uk().intValue()) * 2.55f));
        canvas.drawPath(this.qw, this.f3483de);
        canvas.restore();
    }

    public final void ppp(Canvas canvas, Matrix matrix) {
        fe.qw.qw.ad.qw("Layer#saveLayer");
        fe.qw.qw.ggg.yj.when(canvas, this.f3490uk, this.f3484fe, 19);
        if (Build.VERSION.SDK_INT < 28) {
            ddd(canvas);
        }
        fe.qw.qw.ad.ad("Layer#saveLayer");
        for (int i2 = 0; i2 < this.ggg.ad().size(); i2++) {
            Mask mask = this.ggg.ad().get(i2);
            BaseKeyframeAnimation baseKeyframeAnimation = this.ggg.qw().get(i2);
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.ggg.de().get(i2);
            int i3 = ad.f3492ad[mask.qw().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    if (i2 == 0) {
                        this.f3483de.setColor(-16777216);
                        this.f3483de.setAlpha(255);
                        canvas.drawRect(this.f3490uk, this.f3483de);
                    }
                    if (mask.fe()) {
                        when(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        ggg(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    }
                } else if (i3 != 3) {
                    if (i3 == 4) {
                        if (mask.fe()) {
                            m242if(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                        } else {
                            o(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                        }
                    }
                } else if (mask.fe()) {
                    m243switch(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                } else {
                    pf(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                }
            } else if (vvv()) {
                this.f3483de.setAlpha(255);
                canvas.drawRect(this.f3490uk, this.f3483de);
            }
        }
        fe.qw.qw.ad.qw("Layer#restoreLayer");
        canvas.restore();
        fe.qw.qw.ad.ad("Layer#restoreLayer");
    }

    public boolean qqq() {
        th thVar = this.ggg;
        return thVar != null && !thVar.qw().isEmpty();
    }

    public void qw() {
        a();
    }

    @CallSuper
    public void rg(RectF rectF, Matrix matrix, boolean z) {
        this.f3490uk.set(0.0f, 0.0f, 0.0f, 0.0f);
        xxx();
        this.f118switch.set(matrix);
        if (z) {
            List<qw> list = this.nn;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f118switch.preConcat(this.nn.get(size).aaa.th());
                }
            } else {
                qw qwVar = this.ddd;
                if (qwVar != null) {
                    this.f118switch.preConcat(qwVar.aaa.th());
                }
            }
        }
        this.f118switch.preConcat(this.aaa.th());
    }

    public final void rrr(RectF rectF, Matrix matrix) {
        this.f3485i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (qqq()) {
            int size = this.ggg.ad().size();
            int i2 = 0;
            while (i2 < size) {
                Mask mask = this.ggg.ad().get(i2);
                this.qw.set((Path) this.ggg.qw().get(i2).uk());
                this.qw.transform(matrix);
                int i3 = ad.f3492ad[mask.qw().ordinal()];
                if (i3 != 1 && i3 != 2) {
                    if ((i3 != 3 && i3 != 4) || !mask.fe()) {
                        this.qw.computeBounds(this.f3487pf, false);
                        if (i2 == 0) {
                            this.f3485i.set(this.f3487pf);
                        } else {
                            RectF rectF2 = this.f3485i;
                            rectF2.set(Math.min(rectF2.left, this.f3487pf.left), Math.min(this.f3485i.top, this.f3487pf.top), Math.max(this.f3485i.right, this.f3487pf.right), Math.max(this.f3485i.bottom, this.f3487pf.bottom));
                        }
                        i2++;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!rectF.intersect(this.f3485i)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m243switch(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<yj, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        fe.qw.qw.ggg.yj.m233switch(canvas, this.f3490uk, this.f3484fe);
        canvas.drawRect(this.f3490uk, this.f3483de);
        this.f3488rg.setAlpha((int) (((float) baseKeyframeAnimation2.uk().intValue()) * 2.55f));
        this.qw.set(baseKeyframeAnimation.uk());
        this.qw.transform(matrix);
        canvas.drawPath(this.qw, this.f3488rg);
        canvas.restore();
    }

    public final void tt(RectF rectF, Matrix matrix) {
        if (eee() && this.ppp.th() != Layer.MatteType.INVERT) {
            this.f3486o.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.xxx.rg(this.f3486o, matrix, true);
            if (!rectF.intersect(this.f3486o)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    public final boolean vvv() {
        if (this.ggg.qw().isEmpty()) {
            return false;
        }
        for (int i2 = 0; i2 < this.ggg.ad().size(); i2++) {
            if (this.ggg.ad().get(i2).qw() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public final void when(Canvas canvas, Matrix matrix, Mask mask, BaseKeyframeAnimation<yj, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        fe.qw.qw.ggg.yj.m233switch(canvas, this.f3490uk, this.f3488rg);
        canvas.drawRect(this.f3490uk, this.f3483de);
        this.f3488rg.setAlpha((int) (((float) baseKeyframeAnimation2.uk().intValue()) * 2.55f));
        this.qw.set(baseKeyframeAnimation.uk());
        this.qw.transform(matrix);
        canvas.drawPath(this.qw, this.f3488rg);
        canvas.restore();
    }

    public final void xxx() {
        if (this.nn == null) {
            if (this.ddd == null) {
                this.nn = Collections.emptyList();
                return;
            }
            this.nn = new ArrayList();
            for (qw qwVar = this.ddd; qwVar != null; qwVar = qwVar.ddd) {
                this.nn.add(qwVar);
            }
        }
    }

    public void yj(Canvas canvas, Matrix matrix, int i2) {
        Paint paint;
        fe.qw.qw.ad.qw(this.f117if);
        if (!this.qqq || this.ppp.aaa()) {
            fe.qw.qw.ad.ad(this.f117if);
            return;
        }
        xxx();
        fe.qw.qw.ad.qw("Layer#parentMatrix");
        this.f3482ad.reset();
        this.f3482ad.set(matrix);
        for (int size = this.nn.size() - 1; size >= 0; size--) {
            this.f3482ad.preConcat(this.nn.get(size).aaa.th());
        }
        fe.qw.qw.ad.ad("Layer#parentMatrix");
        int intValue = (int) ((((((float) i2) / 255.0f) * ((float) (this.aaa.uk() == null ? 100 : this.aaa.uk().uk().intValue()))) / 100.0f) * 255.0f);
        if (eee() || qqq()) {
            fe.qw.qw.ad.qw("Layer#computeBounds");
            rg(this.f3490uk, this.f3482ad, false);
            tt(this.f3490uk, matrix);
            this.f3482ad.preConcat(this.aaa.th());
            rrr(this.f3490uk, this.f3482ad);
            if (!this.f3490uk.intersect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight())) {
                this.f3490uk.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            fe.qw.qw.ad.ad("Layer#computeBounds");
            if (!this.f3490uk.isEmpty()) {
                fe.qw.qw.ad.qw("Layer#saveLayer");
                this.f3483de.setAlpha(255);
                fe.qw.qw.ggg.yj.m233switch(canvas, this.f3490uk, this.f3483de);
                fe.qw.qw.ad.ad("Layer#saveLayer");
                ddd(canvas);
                fe.qw.qw.ad.qw("Layer#drawLayer");
                nn(canvas, this.f3482ad, intValue);
                fe.qw.qw.ad.ad("Layer#drawLayer");
                if (qqq()) {
                    ppp(canvas, this.f3482ad);
                }
                if (eee()) {
                    fe.qw.qw.ad.qw("Layer#drawMatte");
                    fe.qw.qw.ad.qw("Layer#saveLayer");
                    fe.qw.qw.ggg.yj.when(canvas, this.f3490uk, this.f3489th, 19);
                    fe.qw.qw.ad.ad("Layer#saveLayer");
                    ddd(canvas);
                    this.xxx.yj(canvas, matrix, intValue);
                    fe.qw.qw.ad.qw("Layer#restoreLayer");
                    canvas.restore();
                    fe.qw.qw.ad.ad("Layer#restoreLayer");
                    fe.qw.qw.ad.ad("Layer#drawMatte");
                }
                fe.qw.qw.ad.qw("Layer#restoreLayer");
                canvas.restore();
                fe.qw.qw.ad.ad("Layer#restoreLayer");
            }
            if (this.eee && (paint = this.rrr) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.rrr.setColor(-251901);
                this.rrr.setStrokeWidth(4.0f);
                canvas.drawRect(this.f3490uk, this.rrr);
                this.rrr.setStyle(Paint.Style.FILL);
                this.rrr.setColor(1357638635);
                canvas.drawRect(this.f3490uk, this.rrr);
            }
            b(fe.qw.qw.ad.ad(this.f117if));
            return;
        }
        this.f3482ad.preConcat(this.aaa.th());
        fe.qw.qw.ad.qw("Layer#drawLayer");
        nn(canvas, this.f3482ad, intValue);
        fe.qw.qw.ad.ad("Layer#drawLayer");
        b(fe.qw.qw.ad.ad(this.f117if));
    }
}
