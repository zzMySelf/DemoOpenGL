package fe.p013if.ad.qw;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.util.SizeF;
import fe.p013if.ad.qw.pf.qw;

/* renamed from: fe.if.ad.qw.fe  reason: invalid package */
public class fe implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {

    /* renamed from: ad  reason: collision with root package name */
    public PDFView f4519ad;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4520i = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f4521o = false;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f4522pf = false;

    /* renamed from: th  reason: collision with root package name */
    public qw f4523th;

    /* renamed from: uk  reason: collision with root package name */
    public ScaleGestureDetector f4524uk;

    /* renamed from: yj  reason: collision with root package name */
    public GestureDetector f4525yj;

    public fe(PDFView pDFView, qw qwVar) {
        this.f4519ad = pDFView;
        this.f4523th = qwVar;
        this.f4525yj = new GestureDetector(pDFView.getContext(), this);
        this.f4524uk = new ScaleGestureDetector(pDFView.getContext(), this);
        pDFView.setOnTouchListener(this);
    }

    public final boolean ad(float f, float f2) {
        int i2;
        int i3;
        PDFView pDFView = this.f4519ad;
        th thVar = pDFView.pdfFile;
        if (thVar == null) {
            return false;
        }
        float f3 = (-pDFView.getCurrentXOffset()) + f;
        float f4 = (-this.f4519ad.getCurrentYOffset()) + f2;
        int o2 = thVar.o(this.f4519ad.isSwipeVertical() ? f4 : f3, this.f4519ad.getZoom());
        SizeF vvv = thVar.vvv(o2, this.f4519ad.getZoom());
        if (this.f4519ad.isSwipeVertical()) {
            i3 = (int) thVar.xxx(o2, this.f4519ad.getZoom());
            i2 = (int) thVar.m292switch(o2, this.f4519ad.getZoom());
        } else {
            i2 = (int) thVar.xxx(o2, this.f4519ad.getZoom());
            i3 = (int) thVar.m292switch(o2, this.f4519ad.getZoom());
        }
        int i4 = i3;
        int i5 = i2;
        for (PdfDocument.Link next : thVar.m291if(o2)) {
            RectF ddd = thVar.ddd(o2, i4, i5, (int) vvv.getWidth(), (int) vvv.getHeight(), next.getBounds());
            ddd.sort();
            if (ddd.contains(f3, f4)) {
                this.f4519ad.callbacks.qw(new qw(f, f2, f3, f4, ddd, next));
                return true;
            }
        }
        return false;
    }

    public void de() {
        this.f4522pf = false;
    }

    public void fe() {
        this.f4522pf = true;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.f4519ad.isDoubletapEnabled()) {
            return false;
        }
        if (this.f4519ad.getZoom() < this.f4519ad.getMidZoom()) {
            this.f4519ad.zoomWithAnimation(motionEvent.getX(), motionEvent.getY(), this.f4519ad.getMidZoom());
            return true;
        } else if (this.f4519ad.getZoom() < this.f4519ad.getMaxZoom()) {
            this.f4519ad.zoomWithAnimation(motionEvent.getX(), motionEvent.getY(), this.f4519ad.getMaxZoom());
            return true;
        } else {
            this.f4519ad.resetZoomWithAnimation();
            return true;
        }
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.f4523th.m290switch();
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float f3;
        float f4;
        int i2;
        if (!this.f4519ad.isSwipeEnabled()) {
            return false;
        }
        if (this.f4519ad.isPageFlingEnabled()) {
            if (this.f4519ad.pageFillsScreen()) {
                th(f, f2);
            } else {
                uk(motionEvent, motionEvent2, f, f2);
            }
            return true;
        }
        int currentXOffset = (int) this.f4519ad.getCurrentXOffset();
        int currentYOffset = (int) this.f4519ad.getCurrentYOffset();
        PDFView pDFView = this.f4519ad;
        th thVar = pDFView.pdfFile;
        if (pDFView.isSwipeVertical()) {
            f4 = -(this.f4519ad.toCurrentScale(thVar.uk()) - ((float) this.f4519ad.getWidth()));
            f3 = thVar.rg(this.f4519ad.getZoom() + ((float) this.f4519ad.getEndTipViewHeight()));
            i2 = this.f4519ad.getHeight();
        } else {
            f4 = -thVar.rg(this.f4519ad.getZoom());
            f3 = this.f4519ad.toCurrentScale(thVar.th());
            i2 = this.f4519ad.getHeight();
        }
        this.f4523th.yj(currentXOffset, currentYOffset, (int) f, (int) f2, (int) f4, 0, (int) (-(f3 - ((float) i2))), 0);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.f4519ad.callbacks.fe(motionEvent);
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float zoom = this.f4519ad.getZoom() * scaleFactor;
        float min = Math.min(1.0f, this.f4519ad.getMinZoom());
        float min2 = Math.min(10.0f, this.f4519ad.getMaxZoom());
        if (zoom < min) {
            scaleFactor = min / this.f4519ad.getZoom();
        } else if (zoom > min2) {
            scaleFactor = min2 / this.f4519ad.getZoom();
        }
        this.f4519ad.zoomCenteredRelativeTo(scaleFactor, new PointF(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()));
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.f4521o = true;
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.f4519ad.loadPages();
        rg();
        this.f4521o = false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f4520i = true;
        if (this.f4519ad.isZooming() || this.f4519ad.isSwipeEnabled()) {
            this.f4519ad.moveRelativeTo(-f, -f2);
        }
        if (!this.f4521o || this.f4519ad.doRenderDuringScale()) {
            this.f4519ad.loadPageByOffset();
        }
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        ScrollHandle scrollHandle;
        if (this.f4519ad.isEndTipHandleClick(motionEvent)) {
            return true;
        }
        boolean i2 = this.f4519ad.callbacks.i(motionEvent);
        boolean ad2 = ad(motionEvent.getX(), motionEvent.getY());
        if (!i2 && !ad2 && (scrollHandle = this.f4519ad.getScrollHandle()) != null && !this.f4519ad.documentFitsView()) {
            if (!scrollHandle.shown()) {
                scrollHandle.show();
            } else {
                scrollHandle.hide();
            }
        }
        this.f4519ad.performClick();
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f4522pf) {
            return false;
        }
        boolean z = this.f4525yj.onTouchEvent(motionEvent) || this.f4524uk.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.f4520i) {
            this.f4520i = false;
            yj(motionEvent);
        }
        return z;
    }

    public final boolean qw(float f, float f2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if (this.f4519ad.isSwipeVertical()) {
            if (abs2 > abs) {
                return true;
            }
        } else if (abs > abs2) {
            return true;
        }
        return false;
    }

    public final void rg() {
        ScrollHandle scrollHandle = this.f4519ad.getScrollHandle();
        if (scrollHandle != null && scrollHandle.shown()) {
            scrollHandle.hideDelayed();
        }
    }

    public final void th(float f, float f2) {
        float f3;
        float f4;
        int currentXOffset = (int) this.f4519ad.getCurrentXOffset();
        int currentYOffset = (int) this.f4519ad.getCurrentYOffset();
        PDFView pDFView = this.f4519ad;
        th thVar = pDFView.pdfFile;
        float f5 = -thVar.m292switch(pDFView.getCurrentPage(), this.f4519ad.getZoom());
        float pf2 = f5 - thVar.pf(this.f4519ad.getCurrentPage(), this.f4519ad.getZoom());
        float f6 = 0.0f;
        if (this.f4519ad.isSwipeVertical()) {
            f4 = -(this.f4519ad.toCurrentScale(thVar.uk()) - ((float) this.f4519ad.getWidth()));
            f3 = pf2 + ((float) this.f4519ad.getHeight());
            f6 = f5;
            f5 = 0.0f;
        } else {
            float width = pf2 + ((float) this.f4519ad.getWidth());
            f3 = -(this.f4519ad.toCurrentScale(thVar.th()) - ((float) this.f4519ad.getHeight()));
            f4 = width;
        }
        this.f4523th.yj(currentXOffset, currentYOffset, (int) f, (int) f2, (int) f4, (int) f5, (int) f3, (int) f6);
    }

    public final void uk(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float f3;
        float f4;
        if (qw(f, f2)) {
            int i2 = -1;
            if (!this.f4519ad.isSwipeVertical() ? f <= 0.0f : f2 <= 0.0f) {
                i2 = 1;
            }
            if (this.f4519ad.isSwipeVertical()) {
                f3 = motionEvent2.getY();
                f4 = motionEvent.getY();
            } else {
                f3 = motionEvent2.getX();
                f4 = motionEvent.getX();
            }
            float f5 = f3 - f4;
            int max = Math.max(0, Math.min((this.f4519ad.isSwipeVertical() || i2 <= 0 || this.f4519ad.getMeasuredWidth() <= 0) ? this.f4519ad.getPageCount() - 1 : this.f4519ad.getPageCount(), this.f4519ad.findFocusPage(this.f4519ad.getCurrentXOffset() - (this.f4519ad.getZoom() * f5), this.f4519ad.getCurrentYOffset() - (f5 * this.f4519ad.getZoom())) + i2));
            this.f4523th.uk(-this.f4519ad.snapOffsetForPage(max, this.f4519ad.findSnapEdge(max)));
        }
    }

    public final void yj(MotionEvent motionEvent) {
        this.f4519ad.loadPages();
        rg();
        if (!this.f4523th.th()) {
            this.f4519ad.performPageSnap();
        }
    }
}
