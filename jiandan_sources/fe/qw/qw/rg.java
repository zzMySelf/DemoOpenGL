package fe.qw.qw;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.PerformanceTracker;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.baidu.android.common.others.IStringUtil;
import fe.qw.qw.ppp.ddd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class rg extends Drawable implements Drawable.Callback, Animatable {
    public int aaa;

    /* renamed from: ad  reason: collision with root package name */
    public final Matrix f3406ad = new Matrix();
    @Nullable
    public o ddd;
    public boolean e;
    public boolean eee;
    @Nullable
    public ImageAssetDelegate ggg;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3407i = true;

    /* renamed from: if  reason: not valid java name */
    public final ValueAnimator.AnimatorUpdateListener f113if;
    @Nullable
    public fe.qw.qw.p009switch.o.ad mmm;
    public boolean nn;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3408o = false;

    /* renamed from: pf  reason: collision with root package name */
    public final ArrayList<vvv> f3409pf;
    @Nullable
    public String ppp;
    public boolean qqq;
    public boolean rrr;
    @Nullable

    /* renamed from: switch  reason: not valid java name */
    public ImageView.ScaleType f114switch;

    /* renamed from: th  reason: collision with root package name */
    public de f3410th;
    public boolean tt;

    /* renamed from: uk  reason: collision with root package name */
    public float f3411uk = 1.0f;
    @Nullable
    public fe.qw.qw.p008if.qw vvv;
    @Nullable
    public fe.qw.qw.p008if.ad when;
    @Nullable
    public qw xxx;

    /* renamed from: yj  reason: collision with root package name */
    public final LottieValueAnimator f3412yj = new LottieValueAnimator();

    public class ad implements vvv {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f3413ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ boolean f3414de;
        public final /* synthetic */ String qw;

        public ad(String str, String str2, boolean z) {
            this.qw = str;
            this.f3413ad = str2;
            this.f3414de = z;
        }

        public void qw(de deVar) {
            rg.this.K(this.qw, this.f3413ad, this.f3414de);
        }
    }

    public class de implements vvv {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f3416ad;
        public final /* synthetic */ int qw;

        public de(int i2, int i3) {
            this.qw = i2;
            this.f3416ad = i3;
        }

        public void qw(de deVar) {
            rg.this.I(this.qw, this.f3416ad);
        }
    }

    public class fe implements vvv {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ float f3418ad;
        public final /* synthetic */ float qw;

        public fe(float f, float f2) {
            this.qw = f;
            this.f3418ad = f2;
        }

        public void qw(de deVar) {
            rg.this.L(this.qw, this.f3418ad);
        }
    }

    public class ggg implements vvv {
        public final /* synthetic */ String qw;

        public ggg(String str) {
            this.qw = str;
        }

        public void qw(de deVar) {
            rg.this.G(this.qw);
        }
    }

    public class i implements vvv {
        public i() {
        }

        public void qw(de deVar) {
            rg.this.q();
        }
    }

    /* renamed from: fe.qw.qw.rg$if  reason: invalid class name */
    public class Cif implements vvv {
        public final /* synthetic */ float qw;

        public Cif(float f) {
            this.qw = f;
        }

        public void qw(de deVar) {
            rg.this.O(this.qw);
        }
    }

    public class o implements vvv {
        public o() {
        }

        public void qw(de deVar) {
            rg.this.x();
        }
    }

    public class pf implements vvv {
        public final /* synthetic */ int qw;

        public pf(int i2) {
            this.qw = i2;
        }

        public void qw(de deVar) {
            rg.this.M(this.qw);
        }
    }

    public class ppp implements vvv {
        public final /* synthetic */ String qw;

        public ppp(String str) {
            this.qw = str;
        }

        public void qw(de deVar) {
            rg.this.N(this.qw);
        }
    }

    public class qw implements vvv {
        public final /* synthetic */ String qw;

        public qw(String str) {
            this.qw = str;
        }

        public void qw(de deVar) {
            rg.this.J(this.qw);
        }
    }

    /* renamed from: fe.qw.qw.rg$rg  reason: collision with other inner class name */
    public class C0150rg implements vvv {
        public final /* synthetic */ int qw;

        public C0150rg(int i2) {
            this.qw = i2;
        }

        public void qw(de deVar) {
            rg.this.C(this.qw);
        }
    }

    /* renamed from: fe.qw.qw.rg$switch  reason: invalid class name */
    public class Cswitch implements vvv {
        public final /* synthetic */ int qw;

        public Cswitch(int i2) {
            this.qw = i2;
        }

        public void qw(de deVar) {
            rg.this.F(this.qw);
        }
    }

    public class th implements vvv {
        public final /* synthetic */ float qw;

        public th(float f) {
            this.qw = f;
        }

        public void qw(de deVar) {
            rg.this.R(this.qw);
        }
    }

    public class uk implements ValueAnimator.AnimatorUpdateListener {
        public uk() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (rg.this.mmm != null) {
                rg.this.mmm.h(rg.this.f3412yj.getAnimatedValueAbsolute());
            }
        }
    }

    public interface vvv {
        void qw(de deVar);
    }

    public class when implements vvv {
        public final /* synthetic */ float qw;

        public when(float f) {
            this.qw = f;
        }

        public void qw(de deVar) {
            rg.this.H(this.qw);
        }
    }

    public class yj implements vvv {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Object f3429ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ fe.qw.qw.vvv.de f3430de;
        public final /* synthetic */ fe.qw.qw.p009switch.fe qw;

        public yj(fe.qw.qw.p009switch.fe feVar, Object obj, fe.qw.qw.vvv.de deVar) {
            this.qw = feVar;
            this.f3429ad = obj;
            this.f3430de = deVar;
        }

        public void qw(de deVar) {
            rg.this.th(this.qw, this.f3429ad, this.f3430de);
        }
    }

    static {
        Class<rg> cls = rg.class;
    }

    public rg() {
        new HashSet();
        this.f3409pf = new ArrayList<>();
        uk ukVar = new uk();
        this.f113if = ukVar;
        this.aaa = 255;
        this.tt = true;
        this.e = false;
        this.f3412yj.addUpdateListener(ukVar);
    }

    public boolean A(de deVar) {
        if (this.f3410th == deVar) {
            return false;
        }
        this.e = false;
        i();
        this.f3410th = deVar;
        yj();
        this.f3412yj.setComposition(deVar);
        R(this.f3412yj.getAnimatedFraction());
        V(this.f3411uk);
        b0();
        Iterator it = new ArrayList(this.f3409pf).iterator();
        while (it.hasNext()) {
            ((vvv) it.next()).qw(deVar);
            it.remove();
        }
        this.f3409pf.clear();
        deVar.mmm(this.qqq);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable((Drawable) null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void B(qw qwVar) {
        this.xxx = qwVar;
        fe.qw.qw.p008if.qw qwVar2 = this.vvv;
        if (qwVar2 != null) {
            qwVar2.de(qwVar);
        }
    }

    public void C(int i2) {
        if (this.f3410th == null) {
            this.f3409pf.add(new C0150rg(i2));
        } else {
            this.f3412yj.setFrame((float) i2);
        }
    }

    public void D(ImageAssetDelegate imageAssetDelegate) {
        this.ggg = imageAssetDelegate;
        fe.qw.qw.p008if.ad adVar = this.when;
        if (adVar != null) {
            adVar.fe(imageAssetDelegate);
        }
    }

    public void E(@Nullable String str) {
        this.ppp = str;
    }

    public void F(int i2) {
        if (this.f3410th == null) {
            this.f3409pf.add(new Cswitch(i2));
        } else {
            this.f3412yj.setMaxFrame(((float) i2) + 0.99f);
        }
    }

    public void G(String str) {
        de deVar = this.f3410th;
        if (deVar == null) {
            this.f3409pf.add(new ggg(str));
            return;
        }
        fe.qw.qw.p009switch.th pf2 = deVar.pf(str);
        if (pf2 != null) {
            F((int) (pf2.f3497ad + pf2.f3498de));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + IStringUtil.CURRENT_PATH);
    }

    public void H(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        de deVar = this.f3410th;
        if (deVar == null) {
            this.f3409pf.add(new when(f));
        } else {
            F((int) fe.qw.qw.ggg.th.pf(deVar.ppp(), this.f3410th.th(), f));
        }
    }

    public void I(int i2, int i3) {
        if (this.f3410th == null) {
            this.f3409pf.add(new de(i2, i3));
        } else {
            this.f3412yj.setMinAndMaxFrames((float) i2, ((float) i3) + 0.99f);
        }
    }

    public void J(String str) {
        de deVar = this.f3410th;
        if (deVar == null) {
            this.f3409pf.add(new qw(str));
            return;
        }
        fe.qw.qw.p009switch.th pf2 = deVar.pf(str);
        if (pf2 != null) {
            int i2 = (int) pf2.f3497ad;
            I(i2, ((int) pf2.f3498de) + i2);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + IStringUtil.CURRENT_PATH);
    }

    public void K(String str, String str2, boolean z) {
        de deVar = this.f3410th;
        if (deVar == null) {
            this.f3409pf.add(new ad(str, str2, z));
            return;
        }
        fe.qw.qw.p009switch.th pf2 = deVar.pf(str);
        if (pf2 != null) {
            int i2 = (int) pf2.f3497ad;
            fe.qw.qw.p009switch.th pf3 = this.f3410th.pf(str2);
            if (str2 != null) {
                I(i2, (int) (pf3.f3497ad + (z ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + IStringUtil.CURRENT_PATH);
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + IStringUtil.CURRENT_PATH);
    }

    public void L(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        de deVar = this.f3410th;
        if (deVar == null) {
            this.f3409pf.add(new fe(f, f2));
        } else {
            I((int) fe.qw.qw.ggg.th.pf(deVar.ppp(), this.f3410th.th(), f), (int) fe.qw.qw.ggg.th.pf(this.f3410th.ppp(), this.f3410th.th(), f2));
        }
    }

    public void M(int i2) {
        if (this.f3410th == null) {
            this.f3409pf.add(new pf(i2));
        } else {
            this.f3412yj.setMinFrame(i2);
        }
    }

    public void N(String str) {
        de deVar = this.f3410th;
        if (deVar == null) {
            this.f3409pf.add(new ppp(str));
            return;
        }
        fe.qw.qw.p009switch.th pf2 = deVar.pf(str);
        if (pf2 != null) {
            M((int) pf2.f3497ad);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + IStringUtil.CURRENT_PATH);
    }

    public void O(float f) {
        de deVar = this.f3410th;
        if (deVar == null) {
            this.f3409pf.add(new Cif(f));
        } else {
            M((int) fe.qw.qw.ggg.th.pf(deVar.ppp(), this.f3410th.th(), f));
        }
    }

    public void P(boolean z) {
        if (this.eee != z) {
            this.eee = z;
            fe.qw.qw.p009switch.o.ad adVar = this.mmm;
            if (adVar != null) {
                adVar.f(z);
            }
        }
    }

    public void Q(boolean z) {
        this.qqq = z;
        de deVar = this.f3410th;
        if (deVar != null) {
            deVar.mmm(z);
        }
    }

    public void R(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.f3410th == null) {
            this.f3409pf.add(new th(f));
            return;
        }
        ad.qw("Drawable#setProgress");
        this.f3412yj.setFrame(fe.qw.qw.ggg.th.pf(this.f3410th.ppp(), this.f3410th.th(), f));
        ad.ad("Drawable#setProgress");
    }

    public void S(int i2) {
        this.f3412yj.setRepeatCount(i2);
    }

    public void T(int i2) {
        this.f3412yj.setRepeatMode(i2);
    }

    public void U(boolean z) {
        this.f3408o = z;
    }

    public void V(float f) {
        this.f3411uk = f;
        b0();
    }

    public void W(ImageView.ScaleType scaleType) {
        this.f114switch = scaleType;
    }

    public void X(float f) {
        this.f3412yj.setSpeed(f);
    }

    public void Y(Boolean bool) {
        this.f3407i = bool.booleanValue();
    }

    public void Z(o oVar) {
        this.ddd = oVar;
    }

    @Nullable
    public PerformanceTracker a() {
        de deVar = this.f3410th;
        if (deVar != null) {
            return deVar.m227switch();
        }
        return null;
    }

    @Nullable
    public Bitmap a0(String str, @Nullable Bitmap bitmap) {
        fe.qw.qw.p008if.ad aaa2 = aaa();
        if (aaa2 == null) {
            fe.qw.qw.ggg.fe.de("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap rg2 = aaa2.rg(str, bitmap);
        invalidateSelf();
        return rg2;
    }

    public final fe.qw.qw.p008if.ad aaa() {
        if (getCallback() == null) {
            return null;
        }
        fe.qw.qw.p008if.ad adVar = this.when;
        if (adVar != null && !adVar.ad(xxx())) {
            this.when = null;
        }
        if (this.when == null) {
            this.when = new fe.qw.qw.p008if.ad(getCallback(), this.ppp, this.ggg, this.f3410th.i());
        }
        return this.when;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float b() {
        return this.f3412yj.getAnimatedValueAbsolute();
    }

    public final void b0() {
        if (this.f3410th != null) {
            float e2 = e();
            setBounds(0, 0, (int) (((float) this.f3410th.ad().width()) * e2), (int) (((float) this.f3410th.ad().height()) * e2));
        }
    }

    public int c() {
        return this.f3412yj.getRepeatCount();
    }

    public boolean c0() {
        return this.ddd == null && this.f3410th.de().size() > 0;
    }

    public int d() {
        return this.f3412yj.getRepeatMode();
    }

    public final fe.qw.qw.p008if.qw ddd() {
        if (getCallback() == null) {
            return null;
        }
        if (this.vvv == null) {
            this.vvv = new fe.qw.qw.p008if.qw(getCallback(), this.xxx);
        }
        return this.vvv;
    }

    public void de(Animator.AnimatorListener animatorListener) {
        this.f3412yj.addListener(animatorListener);
    }

    public void draw(@NonNull Canvas canvas) {
        this.e = false;
        ad.qw("Drawable#draw");
        if (this.f3408o) {
            try {
                pf(canvas);
            } catch (Throwable th2) {
                fe.qw.qw.ggg.fe.ad("Lottie crashed in draw!", th2);
            }
        } else {
            pf(canvas);
        }
        ad.ad("Drawable#draw");
    }

    public float e() {
        return this.f3411uk;
    }

    public float eee() {
        return this.f3412yj.getMaxFrame();
    }

    public float f() {
        return this.f3412yj.getSpeed();
    }

    @RequiresApi(api = 19)
    public void fe(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f3412yj.addPauseListener(animatorPauseListener);
    }

    @Nullable
    public o g() {
        return this.ddd;
    }

    public int getAlpha() {
        return this.aaa;
    }

    public int getIntrinsicHeight() {
        de deVar = this.f3410th;
        if (deVar == null) {
            return -1;
        }
        return (int) (((float) deVar.ad().height()) * e());
    }

    public int getIntrinsicWidth() {
        de deVar = this.f3410th;
        if (deVar == null) {
            return -1;
        }
        return (int) (((float) deVar.ad().width()) * e());
    }

    public int getOpacity() {
        return -3;
    }

    @MainThread
    public void ggg() {
        this.f3409pf.clear();
        this.f3412yj.endAnimation();
    }

    @Nullable
    public Typeface h(String str, String str2) {
        fe.qw.qw.p008if.qw ddd2 = ddd();
        if (ddd2 != null) {
            return ddd2.ad(str, str2);
        }
        return null;
    }

    public void i() {
        if (this.f3412yj.isRunning()) {
            this.f3412yj.cancel();
        }
        this.f3410th = null;
        this.mmm = null;
        this.when = null;
        this.f3412yj.clearComposition();
        invalidateSelf();
    }

    /* renamed from: if  reason: not valid java name */
    public final void m238if(Canvas canvas) {
        float f;
        if (this.mmm != null) {
            int i2 = -1;
            Rect bounds = getBounds();
            float width = ((float) bounds.width()) / ((float) this.f3410th.ad().width());
            float height = ((float) bounds.height()) / ((float) this.f3410th.ad().height());
            if (this.tt) {
                float min = Math.min(width, height);
                if (min < 1.0f) {
                    f = 1.0f / min;
                    width /= f;
                    height /= f;
                } else {
                    f = 1.0f;
                }
                if (f > 1.0f) {
                    i2 = canvas.save();
                    float width2 = ((float) bounds.width()) / 2.0f;
                    float height2 = ((float) bounds.height()) / 2.0f;
                    float f2 = width2 * min;
                    float f3 = min * height2;
                    canvas.translate(width2 - f2, height2 - f3);
                    canvas.scale(f, f, f2, f3);
                }
            }
            this.f3406ad.reset();
            this.f3406ad.preScale(width, height);
            this.mmm.yj(canvas, this.f3406ad, this.aaa);
            if (i2 > 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void invalidateSelf() {
        if (!this.e) {
            this.e = true;
            Drawable.Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public boolean isRunning() {
        return l();
    }

    public boolean j() {
        fe.qw.qw.p009switch.o.ad adVar = this.mmm;
        return adVar != null && adVar.l();
    }

    public boolean k() {
        fe.qw.qw.p009switch.o.ad adVar = this.mmm;
        return adVar != null && adVar.m();
    }

    public boolean l() {
        LottieValueAnimator lottieValueAnimator = this.f3412yj;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    public boolean m() {
        return this.rrr;
    }

    @Nullable
    public Bitmap mmm(String str) {
        fe.qw.qw.p008if.ad aaa2 = aaa();
        if (aaa2 != null) {
            return aaa2.qw(str);
        }
        return null;
    }

    public boolean n() {
        return this.nn;
    }

    public int nn() {
        return (int) this.f3412yj.getFrame();
    }

    public void o() {
        this.tt = false;
    }

    public void p() {
        this.f3409pf.clear();
        this.f3412yj.pauseAnimation();
    }

    public final void pf(@NonNull Canvas canvas) {
        if (ImageView.ScaleType.FIT_XY == this.f114switch) {
            m238if(canvas);
        } else {
            m239switch(canvas);
        }
    }

    public boolean ppp() {
        return this.nn;
    }

    @MainThread
    public void q() {
        if (this.mmm == null) {
            this.f3409pf.add(new i());
            return;
        }
        if (this.f3407i || c() == 0) {
            this.f3412yj.playAnimation();
        }
        if (!this.f3407i) {
            C((int) (f() < 0.0f ? tt() : eee()));
            this.f3412yj.endAnimation();
        }
    }

    @Nullable
    public String qqq() {
        return this.ppp;
    }

    public void r() {
        this.f3412yj.removeAllListeners();
    }

    public void rg(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f3412yj.addUpdateListener(animatorUpdateListener);
    }

    public final float rrr(@NonNull Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) this.f3410th.ad().width()), ((float) canvas.getHeight()) / ((float) this.f3410th.ad().height()));
    }

    public void s() {
        this.f3412yj.removeAllUpdateListeners();
        this.f3412yj.addUpdateListener(this.f113if);
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.aaa = i2;
        invalidateSelf();
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        fe.qw.qw.ggg.fe.de("Use addColorFilter instead.");
    }

    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && !((View) callback).isInEditMode()) {
            q();
        }
    }

    @MainThread
    public void stop() {
        ggg();
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m239switch(Canvas canvas) {
        float f;
        if (this.mmm != null) {
            float f2 = this.f3411uk;
            float rrr2 = rrr(canvas);
            if (f2 > rrr2) {
                f = this.f3411uk / rrr2;
            } else {
                rrr2 = f2;
                f = 1.0f;
            }
            int i2 = -1;
            if (f > 1.0f) {
                i2 = canvas.save();
                float width = ((float) this.f3410th.ad().width()) / 2.0f;
                float height = ((float) this.f3410th.ad().height()) / 2.0f;
                float f3 = width * rrr2;
                float f4 = height * rrr2;
                canvas.translate((e() * width) - f3, (e() * height) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.f3406ad.reset();
            this.f3406ad.preScale(rrr2, rrr2);
            this.mmm.yj(canvas, this.f3406ad, this.aaa);
            if (i2 > 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    public void t(Animator.AnimatorListener animatorListener) {
        this.f3412yj.removeListener(animatorListener);
    }

    public <T> void th(fe.qw.qw.p009switch.fe feVar, T t, fe.qw.qw.vvv.de<T> deVar) {
        fe.qw.qw.p009switch.o.ad adVar = this.mmm;
        if (adVar == null) {
            this.f3409pf.add(new yj(feVar, t, deVar));
            return;
        }
        boolean z = true;
        if (feVar == fe.qw.qw.p009switch.fe.f3438de) {
            adVar.de(t, deVar);
        } else if (feVar.fe() != null) {
            feVar.fe().de(t, deVar);
        } else {
            List<fe.qw.qw.p009switch.fe> w = w(feVar);
            for (int i2 = 0; i2 < w.size(); i2++) {
                w.get(i2).fe().de(t, deVar);
            }
            z = true ^ w.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == LottieProperty.a) {
                R(b());
            }
        }
    }

    public float tt() {
        return this.f3412yj.getMinFrame();
    }

    @RequiresApi(api = 19)
    public void u(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f3412yj.removePauseListener(animatorPauseListener);
    }

    public void uk() {
        this.f3409pf.clear();
        this.f3412yj.cancel();
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f3412yj.removeUpdateListener(animatorUpdateListener);
    }

    public de vvv() {
        return this.f3410th;
    }

    public List<fe.qw.qw.p009switch.fe> w(fe.qw.qw.p009switch.fe feVar) {
        if (this.mmm == null) {
            fe.qw.qw.ggg.fe.de("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.mmm.fe(feVar, 0, arrayList, new fe.qw.qw.p009switch.fe(new String[0]));
        return arrayList;
    }

    public void when(boolean z) {
        if (this.nn != z) {
            if (Build.VERSION.SDK_INT < 19) {
                fe.qw.qw.ggg.fe.de("Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.nn = z;
            if (this.f3410th != null) {
                yj();
            }
        }
    }

    @MainThread
    public void x() {
        if (this.mmm == null) {
            this.f3409pf.add(new o());
            return;
        }
        if (this.f3407i || c() == 0) {
            this.f3412yj.resumeAnimation();
        }
        if (!this.f3407i) {
            C((int) (f() < 0.0f ? tt() : eee()));
            this.f3412yj.endAnimation();
        }
    }

    @Nullable
    public final Context xxx() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void y() {
        this.f3412yj.reverseAnimationSpeed();
    }

    public final void yj() {
        fe.qw.qw.p009switch.o.ad adVar = new fe.qw.qw.p009switch.o.ad(this, ddd.qw(this.f3410th), this.f3410th.o(), this.f3410th);
        this.mmm = adVar;
        if (this.eee) {
            adVar.f(true);
        }
    }

    public void z(boolean z) {
        this.rrr = z;
    }
}
