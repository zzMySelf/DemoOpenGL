package fe.mmm.qw.n;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.tera.scan.widget.ZoomImageView;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public PointF f8068ad = new PointF();

    /* renamed from: de  reason: collision with root package name */
    public float f8069de = 1.0f;

    /* renamed from: fe  reason: collision with root package name */
    public Scroller f8070fe;
    public PointF qw = new PointF();

    /* renamed from: rg  reason: collision with root package name */
    public Runnable f8071rg;

    /* renamed from: th  reason: collision with root package name */
    public ScaleGestureDetector f8072th;

    /* renamed from: uk  reason: collision with root package name */
    public ZoomImageView f8073uk;

    /* renamed from: yj  reason: collision with root package name */
    public GestureDetector f8074yj;

    /* renamed from: fe.mmm.qw.n.ad$ad  reason: collision with other inner class name */
    public class C0286ad extends GestureDetector.SimpleOnGestureListener {
        public C0286ad() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (ad.this.f8073uk.getScale() > 1.0f) {
                ad.this.f8073uk.zoomTo(1.0f);
                return true;
            }
            ad.this.f8073uk.zoomTo(2.0f);
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            ad adVar = ad.this;
            adVar.pf(adVar.f8073uk, (int) (-f), (int) (-f2));
            return false;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            int postTranslateCenter = ad.this.f8073uk.postTranslateCenter(-f, -f2);
            if (!ad.this.f8073uk.inViewPager()) {
                return true;
            }
            if ((postTranslateCenter & 3) != 0 || ((postTranslateCenter & 1) != 0 && f < 0.0f) || ((postTranslateCenter & 2) != 0 && f > 0.0f)) {
                ((ViewGroup) ad.this.f8073uk.getParent()).requestDisallowInterceptTouchEvent(false);
            }
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            ad.this.f8073uk.onClick();
            return true;
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ ZoomImageView f8076ad;

        public de(ZoomImageView zoomImageView) {
            this.f8076ad = zoomImageView;
        }

        public void run() {
            if (ad.this.f8070fe.computeScrollOffset()) {
                float currX = ((float) ad.this.f8070fe.getCurrX()) - ad.this.qw.x;
                float currY = ((float) ad.this.f8070fe.getCurrY()) - ad.this.qw.y;
                ad.this.qw.set((float) ad.this.f8070fe.getCurrX(), (float) ad.this.f8070fe.getCurrY());
                this.f8076ad.postTranslateCenter(-currX, -currY);
                this.f8076ad.post(this);
                return;
            }
            ad.this.o(this.f8076ad);
        }
    }

    public class qw implements ScaleGestureDetector.OnScaleGestureListener {
        public qw() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            ad.this.f8073uk.zoomTo(ad.this.f8069de * scaleGestureDetector.getScaleFactor(), ad.this.f8068ad.x, ad.this.f8068ad.y);
            return false;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            ad adVar = ad.this;
            float unused = adVar.f8069de = adVar.f8073uk.getScale();
            ad.this.f8068ad.set(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            float scale = ad.this.f8073uk.getScale();
            if (scale < 1.0f) {
                ad.this.f8073uk.zoomTo(1.0f, ad.this.f8068ad.x, ad.this.f8068ad.y, 200.0f);
            } else if (scale >= ad.this.f8073uk.getMaxZoom()) {
                ad.this.f8073uk.zoomTo(ad.this.f8073uk.getMaxZoom(), ad.this.f8068ad.x, ad.this.f8068ad.y, 200.0f);
            }
        }
    }

    public ad(Context context, ZoomImageView zoomImageView) {
        this.f8073uk = zoomImageView;
        this.f8070fe = new Scroller(context);
        m985if(context);
    }

    public void i(ZoomImageView zoomImageView) {
    }

    /* renamed from: if  reason: not valid java name */
    public final void m985if(Context context) {
        this.f8072th = new ScaleGestureDetector(context, new qw());
        this.f8074yj = new GestureDetector(context, new C0286ad());
    }

    public final void o(ZoomImageView zoomImageView) {
        this.f8070fe.forceFinished(true);
        Runnable runnable = this.f8071rg;
        if (runnable != null) {
            zoomImageView.removeCallbacks(runnable);
            this.f8071rg = null;
        }
    }

    public final void pf(ZoomImageView zoomImageView, int i2, int i3) {
        int i4;
        int i5;
        RectF mapRect = zoomImageView.getMapRect();
        if (i2 >= 0) {
            i4 = 0;
        } else {
            i4 = -((int) Math.max(0.0f, mapRect.width() - ((float) zoomImageView.getWidth())));
        }
        int max = i2 > 0 ? (int) Math.max(0.0f, mapRect.width() - ((float) zoomImageView.getWidth())) : 0;
        if (i3 > 0) {
            i5 = 0;
        } else {
            i5 = -((int) Math.max(0.0f, mapRect.height() - ((float) zoomImageView.getHeight())));
        }
        int max2 = i3 > 0 ? (int) Math.max(0.0f, mapRect.height() - ((float) zoomImageView.getHeight())) : 0;
        float f = (float) 0;
        this.qw.set(f, f);
        this.f8070fe.fling(0, 0, i2, i3, i4, max, i5, max2);
        de deVar = new de(zoomImageView);
        this.f8071rg = deVar;
        zoomImageView.post(deVar);
        zoomImageView.invalidate();
    }

    /* renamed from: switch  reason: not valid java name */
    public boolean m986switch(MotionEvent motionEvent) {
        this.f8072th.onTouchEvent(motionEvent);
        this.f8074yj.onTouchEvent(motionEvent);
        return true;
    }
}
