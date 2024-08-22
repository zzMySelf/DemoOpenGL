package fe.p013if.ad.qw;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
import com.github.barteksc.pdfviewer.PDFView;

/* renamed from: fe.if.ad.qw.qw  reason: invalid package */
public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public ValueAnimator f4541ad;

    /* renamed from: de  reason: collision with root package name */
    public OverScroller f4542de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f4543fe = false;
    public PDFView qw;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f4544rg = false;

    /* renamed from: fe.if.ad.qw.qw$ad */
    public class ad extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public ad() {
        }

        public void onAnimationCancel(Animator animator) {
            qw.this.qw.loadPages();
            boolean unused = qw.this.f4544rg = false;
            qw.this.rg();
        }

        public void onAnimationEnd(Animator animator) {
            qw.this.qw.loadPages();
            boolean unused = qw.this.f4544rg = false;
            qw.this.rg();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            qw.this.qw.moveTo(qw.this.qw.getCurrentXOffset(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
            qw.this.qw.loadPageByOffset();
        }
    }

    /* renamed from: fe.if.ad.qw.qw$de */
    public class de implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

        /* renamed from: ad  reason: collision with root package name */
        public final float f4545ad;
        public final float qw;

        public de(float f, float f2) {
            this.qw = f;
            this.f4545ad = f2;
        }

        public void onAnimationCancel(Animator animator) {
            qw.this.qw.loadPages();
            qw.this.rg();
        }

        public void onAnimationEnd(Animator animator) {
            qw.this.qw.loadPages();
            qw.this.qw.performPageSnap();
            qw.this.rg();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            qw.this.qw.zoomCenteredTo(((Float) valueAnimator.getAnimatedValue()).floatValue(), new PointF(this.qw, this.f4545ad));
        }
    }

    /* renamed from: fe.if.ad.qw.qw$qw  reason: collision with other inner class name */
    public class C0199qw extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public C0199qw() {
        }

        public void onAnimationCancel(Animator animator) {
            qw.this.qw.loadPages();
            boolean unused = qw.this.f4544rg = false;
            qw.this.rg();
        }

        public void onAnimationEnd(Animator animator) {
            qw.this.qw.loadPages();
            boolean unused = qw.this.f4544rg = false;
            qw.this.rg();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            qw.this.qw.moveTo(((Float) valueAnimator.getAnimatedValue()).floatValue(), qw.this.qw.getCurrentYOffset());
            qw.this.qw.loadPageByOffset();
        }
    }

    public qw(PDFView pDFView) {
        this.qw = pDFView;
        this.f4542de = new OverScroller(pDFView.getContext());
    }

    public void fe() {
        if (this.f4542de.computeScrollOffset()) {
            this.qw.moveTo((float) this.f4542de.getCurrX(), (float) this.f4542de.getCurrY());
            this.qw.loadPageByOffset();
        } else if (this.f4543fe) {
            this.f4543fe = false;
            this.qw.loadPages();
            rg();
            this.qw.performPageSnap();
        }
    }

    public void i(float f, float f2) {
        m289if();
        this.f4541ad = ValueAnimator.ofFloat(new float[]{f, f2});
        C0199qw qwVar = new C0199qw();
        this.f4541ad.setInterpolator(new DecelerateInterpolator());
        this.f4541ad.addUpdateListener(qwVar);
        this.f4541ad.addListener(qwVar);
        this.f4541ad.setDuration(400);
        this.f4541ad.start();
    }

    /* renamed from: if  reason: not valid java name */
    public void m289if() {
        ValueAnimator valueAnimator = this.f4541ad;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f4541ad = null;
        }
        m290switch();
    }

    public void o(float f, float f2) {
        m289if();
        this.f4541ad = ValueAnimator.ofFloat(new float[]{f, f2});
        ad adVar = new ad();
        this.f4541ad.setInterpolator(new DecelerateInterpolator());
        this.f4541ad.addUpdateListener(adVar);
        this.f4541ad.addListener(adVar);
        this.f4541ad.setDuration(400);
        this.f4541ad.start();
    }

    public void pf(float f, float f2, float f3, float f4) {
        m289if();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f3, f4});
        this.f4541ad = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        de deVar = new de(f, f2);
        this.f4541ad.addUpdateListener(deVar);
        this.f4541ad.addListener(deVar);
        this.f4541ad.setDuration(400);
        this.f4541ad.start();
    }

    public final void rg() {
        if (this.qw.getScrollHandle() != null) {
            this.qw.getScrollHandle().hideDelayed();
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m290switch() {
        this.f4543fe = false;
        this.f4542de.forceFinished(true);
    }

    public boolean th() {
        return this.f4543fe || this.f4544rg;
    }

    public void uk(float f) {
        if (this.qw.isSwipeVertical()) {
            o(this.qw.getCurrentYOffset(), f);
        } else {
            i(this.qw.getCurrentXOffset(), f);
        }
        this.f4544rg = true;
    }

    public void yj(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        m289if();
        this.f4543fe = true;
        this.f4542de.fling(i2, i3, i4, i5, i6, i7, i8, i9);
    }
}
