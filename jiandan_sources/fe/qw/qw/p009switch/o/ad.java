package fe.qw.qw.p009switch.o;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.layer.Layer;
import fe.qw.qw.de;
import fe.qw.qw.ggg.yj;
import fe.qw.qw.p009switch.fe;
import fe.qw.qw.pf.de.ppp;
import fe.qw.qw.rg;
import java.util.ArrayList;
import java.util.List;

/* renamed from: fe.qw.qw.switch.o.ad  reason: invalid package */
public class ad extends qw {
    public final List<qw> a = new ArrayList();
    public final RectF b = new RectF();
    public final RectF c = new RectF();
    public Paint d = new Paint();
    @Nullable
    public Boolean e;
    @Nullable
    public Boolean f;
    @Nullable
    public BaseKeyframeAnimation<Float, Float> tt;

    /* renamed from: fe.qw.qw.switch.o.ad$qw */
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
                com.airbnb.lottie.model.layer.Layer$MatteType[] r0 = com.airbnb.lottie.model.layer.Layer.MatteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.ADD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.INVERT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.qw.qw.p009switch.o.ad.qw.<clinit>():void");
        }
    }

    public ad(rg rgVar, Layer layer, List<Layer> list, de deVar) {
        super(rgVar, layer);
        int i2;
        qw qwVar;
        fe.qw.qw.p009switch.uk.ad ddd = layer.ddd();
        if (ddd != null) {
            BaseKeyframeAnimation<Float, Float> qw2 = ddd.qw();
            this.tt = qw2;
            i(qw2);
            this.tt.qw(this);
        } else {
            this.tt = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(deVar.o().size());
        int size = list.size() - 1;
        qw qwVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            qw mmm = qw.mmm(layer2, rgVar, deVar);
            if (mmm != null) {
                longSparseArray.put(mmm.aaa().ad(), mmm);
                if (qwVar2 != null) {
                    qwVar2.e(mmm);
                    qwVar2 = null;
                } else {
                    this.a.add(0, mmm);
                    int i3 = qw.qw[layer2.th().ordinal()];
                    if (i3 == 1 || i3 == 2) {
                        qwVar2 = mmm;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < longSparseArray.size(); i2++) {
            qw qwVar3 = (qw) longSparseArray.get(longSparseArray.keyAt(i2));
            if (!(qwVar3 == null || (qwVar = (qw) longSparseArray.get(qwVar3.aaa().uk())) == null)) {
                qwVar3.g(qwVar);
            }
        }
    }

    public void d(fe feVar, int i2, List<fe> list, fe feVar2) {
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            this.a.get(i3).fe(feVar, i2, list, feVar2);
        }
    }

    public <T> void de(T t, @Nullable fe.qw.qw.vvv.de<T> deVar) {
        super.de(t, deVar);
        if (t != LottieProperty.a) {
            return;
        }
        if (deVar == null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.tt;
            if (baseKeyframeAnimation != null) {
                baseKeyframeAnimation.m1switch((fe.qw.qw.vvv.de<Float>) null);
                return;
            }
            return;
        }
        ppp ppp = new ppp(deVar);
        this.tt = ppp;
        ppp.qw(this);
        i(this.tt);
    }

    public void f(boolean z) {
        super.f(z);
        for (qw f2 : this.a) {
            f2.f(z);
        }
    }

    public void h(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        super.h(f2);
        if (this.tt != null) {
            f2 = ((this.tt.uk().floatValue() * this.ppp.qw().uk()) - this.ppp.qw().ppp()) / (this.when.vvv().rg() + 0.01f);
        }
        if (this.tt == null) {
            f2 -= this.ppp.ggg();
        }
        if (this.ppp.nn() != 0.0f) {
            f2 /= this.ppp.nn();
        }
        for (int size = this.a.size() - 1; size >= 0; size--) {
            this.a.get(size).h(f2);
        }
    }

    public boolean l() {
        if (this.f == null) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                qw qwVar = this.a.get(size);
                if (qwVar instanceof rg) {
                    if (qwVar.qqq()) {
                        this.f = Boolean.TRUE;
                        return true;
                    }
                } else if ((qwVar instanceof ad) && ((ad) qwVar).l()) {
                    this.f = Boolean.TRUE;
                    return true;
                }
            }
            this.f = Boolean.FALSE;
        }
        return this.f.booleanValue();
    }

    public boolean m() {
        if (this.e == null) {
            if (eee()) {
                this.e = Boolean.TRUE;
                return true;
            }
            for (int size = this.a.size() - 1; size >= 0; size--) {
                if (this.a.get(size).eee()) {
                    this.e = Boolean.TRUE;
                    return true;
                }
            }
            this.e = Boolean.FALSE;
        }
        return this.e.booleanValue();
    }

    public void nn(Canvas canvas, Matrix matrix, int i2) {
        fe.qw.qw.ad.qw("CompositionLayer#draw");
        this.c.set(0.0f, 0.0f, (float) this.ppp.o(), (float) this.ppp.i());
        matrix.mapRect(this.c);
        boolean z = this.when.m() && this.a.size() > 1 && i2 != 255;
        if (z) {
            this.d.setAlpha(i2);
            yj.m233switch(canvas, this.c, this.d);
        } else {
            canvas.save();
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (!this.c.isEmpty() ? canvas.clipRect(this.c) : true) {
                this.a.get(size).yj(canvas, matrix, i2);
            }
        }
        canvas.restore();
        fe.qw.qw.ad.ad("CompositionLayer#draw");
    }

    public void rg(RectF rectF, Matrix matrix, boolean z) {
        super.rg(rectF, matrix, z);
        for (int size = this.a.size() - 1; size >= 0; size--) {
            this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.a.get(size).rg(this.b, this.f118switch, true);
            rectF.union(this.b);
        }
    }
}
