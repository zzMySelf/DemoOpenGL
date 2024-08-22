package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.link.LinkHandler;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnEndTipShowListener;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnLongPressListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.github.barteksc.pdfviewer.util.SnapEdge;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;
import fe.p013if.ad.qw.de;
import fe.p013if.ad.qw.fe;
import fe.p013if.ad.qw.rg;
import fe.p013if.ad.qw.th;
import fe.p013if.ad.qw.uk;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PDFView extends RelativeLayout {
    public static final float DEFAULT_MAX_SCALE = 3.0f;
    public static final float DEFAULT_MID_SCALE = 1.75f;
    public static final float DEFAULT_MIN_SCALE = 1.0f;
    public static final String TAG = PDFView.class.getSimpleName();
    public fe.p013if.ad.qw.qw animationManager;
    public boolean annotationRendering = false;
    public PaintFlagsDrawFilter antialiasFilter = new PaintFlagsDrawFilter(0, 3);
    public boolean autoSpacing = false;
    public boolean bestQuality = false;
    public fe.p013if.ad.qw.ad cacheManager;
    public fe.p013if.ad.qw.o.qw callbacks = new fe.p013if.ad.qw.o.qw();
    public int currentPage;
    public float currentXOffset = 0.0f;
    public float currentYOffset = 0.0f;
    public Paint debugPaint;
    public de decodingAsyncTask;
    public int defaultPage = 0;
    public boolean doubletapEnabled = true;
    public fe dragPinchManager;
    public boolean enableAntialiasing = true;
    public boolean enableSwipe = true;
    public View endTipView;
    public boolean fitEachPage = false;
    public boolean hasSize = false;
    public boolean isEndTipVisible = false;
    public boolean isScrollHandleInit = false;
    public PDFThumb mPDFThumb;
    public float maxZoom = 3.0f;
    public float midZoom = 1.75f;
    public float minZoom = 1.0f;
    public boolean nightMode = false;
    public List<Integer> onDrawPagesNums = new ArrayList(10);
    public FitPolicy pageFitPolicy = FitPolicy.WIDTH;
    public boolean pageFling = true;
    public boolean pageSnap = true;
    public rg pagesLoader;
    public Paint paint;
    public th pdfFile;
    public PdfiumCore pdfiumCore;
    public boolean recycled = true;
    public boolean renderDuringScale = false;
    public uk renderingHandler;
    public HandlerThread renderingHandlerThread = new HandlerThread("PDF renderer");
    public ScrollDir scrollDir = ScrollDir.NONE;
    public ScrollHandle scrollHandle;
    public int spacingPx = 0;
    public State state = State.DEFAULT;
    public boolean swipeVertical = true;
    public ad waitingDocumentConfigurator;
    public float zoom = 1.0f;

    public enum ScrollDir {
        NONE,
        START,
        END
    }

    public enum State {
        DEFAULT,
        LOADED,
        SHOWN,
        ERROR
    }

    public class ad {
        public boolean a;
        public boolean aaa;

        /* renamed from: ad  reason: collision with root package name */
        public int[] f4401ad;
        public boolean b;
        public boolean c;
        public View d;
        public boolean ddd;

        /* renamed from: de  reason: collision with root package name */
        public boolean f4402de;
        public boolean eee;

        /* renamed from: fe  reason: collision with root package name */
        public boolean f4403fe;
        public LinkHandler ggg;

        /* renamed from: i  reason: collision with root package name */
        public OnPageChangeListener f4404i;

        /* renamed from: if  reason: not valid java name */
        public OnTapListener f165if;
        public ScrollHandle mmm;
        public String nn;

        /* renamed from: o  reason: collision with root package name */
        public OnPageScrollListener f4405o;

        /* renamed from: pf  reason: collision with root package name */
        public OnRenderListener f4406pf;
        public OnEndTipShowListener ppp;
        public int qqq;
        public final DocumentSource qw;

        /* renamed from: rg  reason: collision with root package name */
        public OnDrawListener f4407rg;
        public FitPolicy rrr;

        /* renamed from: switch  reason: not valid java name */
        public OnLongPressListener f166switch;

        /* renamed from: th  reason: collision with root package name */
        public OnDrawListener f4408th;
        public boolean tt;

        /* renamed from: uk  reason: collision with root package name */
        public OnErrorListener f4409uk;
        public int vvv;
        public OnPageErrorListener when;
        public boolean xxx;

        /* renamed from: yj  reason: collision with root package name */
        public OnLoadCompleteListener f4410yj;

        public ad ad(int i2) {
            this.vvv = i2;
            return this;
        }

        public ad ddd(ScrollHandle scrollHandle) {
            this.mmm = scrollHandle;
            return this;
        }

        public ad de(boolean z) {
            this.ddd = z;
            return this;
        }

        public ad fe(boolean z) {
            this.aaa = z;
            return this;
        }

        public ad ggg(boolean z) {
            this.a = z;
            return this;
        }

        public ad i(OnEndTipShowListener onEndTipShowListener) {
            this.ppp = onEndTipShowListener;
            return this;
        }

        /* renamed from: if  reason: not valid java name */
        public ad m277if(OnLongPressListener onLongPressListener) {
            this.f166switch = onLongPressListener;
            return this;
        }

        public ad mmm(boolean z) {
            this.xxx = z;
            return this;
        }

        public ad nn(int i2) {
            this.qqq = i2;
            return this;
        }

        public ad o(OnErrorListener onErrorListener) {
            this.f4409uk = onErrorListener;
            return this;
        }

        public ad pf(OnLoadCompleteListener onLoadCompleteListener) {
            this.f4410yj = onLoadCompleteListener;
            return this;
        }

        public ad ppp(OnTapListener onTapListener) {
            this.f165if = onTapListener;
            return this;
        }

        public ad qw(boolean z) {
            this.eee = z;
            return this;
        }

        public ad rg(boolean z) {
            this.f4403fe = z;
            return this;
        }

        /* renamed from: switch  reason: not valid java name */
        public ad m278switch(OnPageChangeListener onPageChangeListener) {
            this.f4404i = onPageChangeListener;
            return this;
        }

        public ad th(boolean z) {
            this.f4402de = z;
            return this;
        }

        public void uk() {
            if (!PDFView.this.hasSize) {
                ad unused = PDFView.this.waitingDocumentConfigurator = this;
                return;
            }
            PDFView.this.recycle();
            PDFView.this.callbacks.xxx(this.f4410yj);
            PDFView.this.callbacks.vvv(this.f4409uk);
            PDFView.this.callbacks.when(this.f4407rg);
            PDFView.this.callbacks.ppp(this.f4408th);
            PDFView.this.callbacks.nn(this.f4404i);
            PDFView.this.callbacks.aaa(this.f4405o);
            PDFView.this.callbacks.qqq(this.f4406pf);
            PDFView.this.callbacks.eee(this.f165if);
            PDFView.this.callbacks.ddd(this.f166switch);
            PDFView.this.callbacks.mmm(this.when);
            PDFView.this.callbacks.ggg(this.ppp);
            PDFView.this.callbacks.m288switch(this.ggg);
            PDFView.this.setSwipeEnabled(this.f4402de);
            PDFView.this.setNightMode(this.c);
            PDFView.this.enableDoubletap(this.f4403fe);
            PDFView.this.setDefaultPage(this.vvv);
            PDFView.this.setSwipeVertical(!this.xxx);
            PDFView.this.enableAnnotationRendering(this.ddd);
            PDFView.this.setScrollHandle(this.mmm);
            PDFView.this.enableAntialiasing(this.aaa);
            PDFView.this.setSpacing(this.qqq);
            PDFView.this.setAutoSpacing(this.eee);
            PDFView.this.setPageFitPolicy(this.rrr);
            PDFView.this.setFitEachPage(this.tt);
            PDFView.this.setPageSnap(this.b);
            PDFView.this.setPageFling(this.a);
            PDFView.this.setEndTipView(this.d);
            int[] iArr = this.f4401ad;
            if (iArr != null) {
                PDFView.this.load(this.qw, this.nn, iArr);
            } else {
                PDFView.this.load(this.qw, this.nn);
            }
        }

        public ad vvv(boolean z) {
            this.b = z;
            return this;
        }

        public ad when(OnRenderListener onRenderListener) {
            this.f4406pf = onRenderListener;
            return this;
        }

        public ad xxx(String str) {
            this.nn = str;
            return this;
        }

        public ad yj(View view) {
            this.d = view;
            if (view != null) {
                view.setWillNotDraw(false);
            }
            return this;
        }

        public ad(DocumentSource documentSource) {
            this.f4401ad = null;
            this.f4402de = true;
            this.f4403fe = true;
            this.ggg = new fe.p013if.ad.qw.i.qw(PDFView.this);
            this.vvv = 0;
            this.xxx = false;
            this.ddd = false;
            this.nn = null;
            this.mmm = null;
            this.aaa = true;
            this.qqq = 0;
            this.eee = false;
            this.rrr = FitPolicy.WIDTH;
            this.tt = false;
            this.a = false;
            this.b = false;
            this.c = false;
            this.d = null;
            this.qw = documentSource;
        }
    }

    public PDFView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            this.cacheManager = new fe.p013if.ad.qw.ad();
            fe.p013if.ad.qw.qw qwVar = new fe.p013if.ad.qw.qw(this);
            this.animationManager = qwVar;
            this.dragPinchManager = new fe(this, qwVar);
            this.pagesLoader = new rg(this);
            this.paint = new Paint();
            Paint paint2 = new Paint();
            this.debugPaint = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            this.pdfiumCore = new PdfiumCore(context);
            setWillNotDraw(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0069, code lost:
        if (r0 < ((float) getWidth())) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
        if (r2 < r1) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void drawEndTip(android.graphics.Canvas r9) {
        /*
            r8 = this;
            android.view.View r0 = r8.endTipView
            if (r0 == 0) goto L_0x008f
            fe.if.ad.qw.th r0 = r8.pdfFile
            if (r0 != 0) goto L_0x000a
            goto L_0x008f
        L_0x000a:
            int r0 = r8.getWidth()
            float r0 = (float) r0
            int r1 = r8.getHeight()
            float r1 = (float) r1
            boolean r2 = r8.swipeVertical
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1073741824(0x40000000, float:2.0)
            if (r2 == 0) goto L_0x003b
            int r2 = r8.getEndTipViewWidth()
            float r2 = (float) r2
            float r0 = r0 - r2
            float r0 = r0 / r6
            float r2 = r8.currentYOffset
            fe.if.ad.qw.th r6 = r8.pdfFile
            float r7 = r8.zoom
            float r6 = r6.rg(r7)
            float r2 = r2 + r6
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0039
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0039
        L_0x0037:
            r1 = 1
            goto L_0x006c
        L_0x0039:
            r1 = 0
            goto L_0x006c
        L_0x003b:
            float r0 = r8.currentXOffset
            fe.if.ad.qw.th r1 = r8.pdfFile
            float r2 = r8.zoom
            float r1 = r1.rg(r2)
            float r0 = r0 + r1
            int r1 = r8.getWidth()
            int r2 = r8.getEndTipViewWidth()
            int r1 = r1 - r2
            float r1 = (float) r1
            float r1 = r1 / r6
            float r0 = r0 + r1
            int r1 = r8.getHeight()
            int r2 = r8.getEndTipViewHeight()
            int r1 = r1 - r2
            float r1 = (float) r1
            float r2 = r1 / r6
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0039
            int r1 = r8.getWidth()
            float r1 = (float) r1
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0039
            goto L_0x0037
        L_0x006c:
            if (r1 == 0) goto L_0x007b
            r9.translate(r0, r2)
            android.view.View r3 = r8.endTipView
            r3.draw(r9)
            float r0 = -r0
            float r2 = -r2
            r9.translate(r0, r2)
        L_0x007b:
            if (r1 == 0) goto L_0x0089
            boolean r9 = r8.isEndTipVisible
            if (r9 != 0) goto L_0x008f
            r8.isEndTipVisible = r4
            fe.if.ad.qw.o.qw r9 = r8.callbacks
            r9.ad()
            goto L_0x008f
        L_0x0089:
            boolean r9 = r8.isEndTipVisible
            if (r9 == 0) goto L_0x008f
            r8.isEndTipVisible = r5
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PDFView.drawEndTip(android.graphics.Canvas):void");
    }

    private void drawPart(Canvas canvas, fe.p013if.ad.qw.pf.ad adVar) {
        float f;
        float f2;
        RectF de2 = adVar.de();
        Bitmap fe2 = adVar.fe();
        if (!fe2.isRecycled()) {
            SizeF when = this.pdfFile.when(adVar.ad());
            if (this.swipeVertical) {
                f = this.pdfFile.m292switch(adVar.ad(), this.zoom);
                f2 = toCurrentScale(this.pdfFile.uk() - when.getWidth()) / 2.0f;
            } else {
                f2 = this.pdfFile.m292switch(adVar.ad(), this.zoom);
                f = toCurrentScale(this.pdfFile.th() - when.getHeight()) / 2.0f;
            }
            canvas.translate(f2, f);
            Rect rect = new Rect(0, 0, fe2.getWidth(), fe2.getHeight());
            float currentScale = toCurrentScale(de2.left * when.getWidth());
            float currentScale2 = toCurrentScale(de2.top * when.getHeight());
            RectF rectF = new RectF((float) ((int) currentScale), (float) ((int) currentScale2), (float) ((int) (currentScale + toCurrentScale(de2.width() * when.getWidth()))), (float) ((int) (currentScale2 + toCurrentScale(de2.height() * when.getHeight()))));
            float f3 = this.currentXOffset + f2;
            float f4 = this.currentYOffset + f;
            if (rectF.left + f3 >= ((float) getWidth()) || f3 + rectF.right <= 0.0f || rectF.top + f4 >= ((float) getHeight()) || f4 + rectF.bottom <= 0.0f) {
                canvas.translate(-f2, -f);
                return;
            }
            canvas.drawBitmap(fe2, rect, rectF, this.paint);
            canvas.translate(-f2, -f);
        }
    }

    private void drawWithListener(Canvas canvas, int i2, OnDrawListener onDrawListener) {
        float f;
        if (onDrawListener != null) {
            float f2 = 0.0f;
            if (this.swipeVertical) {
                f = this.pdfFile.m292switch(i2, this.zoom);
            } else {
                f2 = this.pdfFile.m292switch(i2, this.zoom);
                f = 0.0f;
            }
            canvas.translate(f2, f);
            SizeF when = this.pdfFile.when(i2);
            onDrawListener.qw(canvas, toCurrentScale(when.getWidth()), toCurrentScale(when.getHeight()), i2);
            canvas.translate(-f2, -f);
        }
    }

    private View findClickedView(View view, float f, float f2) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View findClickedView = findClickedView(viewGroup.getChildAt(i2), f - ((float) rect.left), f2 - ((float) rect.top));
                    if (findClickedView != null) {
                        return findClickedView;
                    }
                }
            }
            if (((float) rect.left) >= f || ((float) rect.top) >= f2 || ((float) rect.right) <= f || ((float) rect.bottom) <= f2 || !view.isClickable()) {
                return null;
            }
            return view;
        } else if (((float) rect.left) >= f || ((float) rect.top) >= f2 || ((float) rect.right) <= f || ((float) rect.bottom) <= f2 || !view.isClickable()) {
            return null;
        } else {
            return view;
        }
    }

    private void layoutEndTipView() {
        View view = this.endTipView;
        if (view != null) {
            try {
                view.layout(0, 0, getEndTipViewWidth(), getEndTipViewHeight());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void load(DocumentSource documentSource, String str) {
        load(documentSource, str, (int[]) null);
    }

    private void measureEndTipView() {
        int i2;
        View view = this.endTipView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
            int i3 = layoutParams.height;
            if (i3 > 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            } else {
                i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            try {
                this.endTipView.measure(childMeasureSpec, i2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void setAutoSpacing(boolean z) {
        this.autoSpacing = z;
    }

    /* access modifiers changed from: private */
    public void setDefaultPage(int i2) {
        this.defaultPage = i2;
    }

    /* access modifiers changed from: private */
    public void setFitEachPage(boolean z) {
        this.fitEachPage = z;
    }

    /* access modifiers changed from: private */
    public void setPageFitPolicy(FitPolicy fitPolicy) {
        this.pageFitPolicy = fitPolicy;
    }

    /* access modifiers changed from: private */
    public void setScrollHandle(ScrollHandle scrollHandle2) {
        this.scrollHandle = scrollHandle2;
    }

    /* access modifiers changed from: private */
    public void setSpacing(int i2) {
        this.spacingPx = fe.p013if.ad.qw.p015switch.fe.qw(getContext(), i2);
    }

    /* access modifiers changed from: private */
    public void setSwipeVertical(boolean z) {
        this.swipeVertical = z;
    }

    public boolean canScrollHorizontally(int i2) {
        if (this.pdfFile == null) {
            return true;
        }
        if (this.swipeVertical) {
            if (i2 < 0 && this.currentXOffset < 0.0f) {
                return true;
            }
            if (i2 <= 0 || this.currentXOffset + toCurrentScale(this.pdfFile.uk()) <= ((float) getWidth())) {
                return false;
            }
            return true;
        } else if (i2 < 0 && this.currentXOffset < 0.0f) {
            return true;
        } else {
            if (i2 <= 0 || this.currentXOffset + this.pdfFile.rg(this.zoom) <= ((float) getWidth())) {
                return false;
            }
            return true;
        }
    }

    public boolean canScrollVertically(int i2) {
        if (this.pdfFile == null) {
            return true;
        }
        if (this.swipeVertical) {
            if (i2 < 0 && this.currentYOffset < 0.0f) {
                return true;
            }
            if (i2 <= 0 || this.currentYOffset + this.pdfFile.rg(this.zoom) + ((float) getEndTipViewHeight()) <= ((float) getHeight())) {
                return false;
            }
            return true;
        } else if (i2 < 0 && this.currentYOffset < 0.0f) {
            return true;
        } else {
            if (i2 <= 0 || this.currentYOffset + toCurrentScale(this.pdfFile.th()) <= ((float) getHeight())) {
                return false;
            }
            return true;
        }
    }

    public void computeScroll() {
        super.computeScroll();
        if (!isInEditMode()) {
            this.animationManager.fe();
        }
    }

    public boolean doRenderDuringScale() {
        return this.renderDuringScale;
    }

    public boolean documentFitsView() {
        float rg2 = this.pdfFile.rg(1.0f);
        if (this.swipeVertical) {
            if (rg2 < ((float) getHeight())) {
                return true;
            }
            return false;
        } else if (rg2 < ((float) getWidth())) {
            return true;
        } else {
            return false;
        }
    }

    public void enableAnnotationRendering(boolean z) {
        this.annotationRendering = z;
    }

    public void enableAntialiasing(boolean z) {
        this.enableAntialiasing = z;
    }

    public void enableDoubletap(boolean z) {
        this.doubletapEnabled = z;
    }

    public void enableRenderDuringScale(boolean z) {
        this.renderDuringScale = z;
    }

    public int findFocusPage(float f, float f2) {
        if (this.swipeVertical) {
            f = f2;
        }
        float height = (float) (this.swipeVertical ? getHeight() : getWidth());
        if (f > -1.0f) {
            return 0;
        }
        if (!this.swipeVertical && f < (-this.pdfFile.rg(this.zoom)) + 1.0f) {
            return this.pdfFile.ggg();
        }
        if (f < (-this.pdfFile.rg(this.zoom)) + height + 1.0f) {
            return this.pdfFile.ggg() - 1;
        }
        return this.pdfFile.o(-(f - (height / 2.0f)), this.zoom);
    }

    public SnapEdge findSnapEdge(int i2) {
        if (!this.pageSnap || i2 < 0) {
            return SnapEdge.NONE;
        }
        float f = this.swipeVertical ? this.currentYOffset : this.currentXOffset;
        float f2 = -this.pdfFile.m292switch(i2, this.zoom);
        int height = this.swipeVertical ? getHeight() : getWidth();
        float pf2 = this.pdfFile.pf(i2, this.zoom);
        float f3 = (float) height;
        if (f3 >= pf2) {
            return SnapEdge.CENTER;
        }
        if (f >= f2) {
            return SnapEdge.START;
        }
        if (f2 - pf2 > f - f3) {
            return SnapEdge.END;
        }
        return SnapEdge.NONE;
    }

    public void fitToWidth(int i2) {
        if (this.state == State.SHOWN) {
            zoomTo(((float) getWidth()) / this.pdfFile.when(i2).getWidth());
            jumpTo(i2);
        }
    }

    public ad fromAsset(String str) {
        return new ad(new fe.p013if.ad.qw.p014if.qw(str));
    }

    public ad fromBytes(byte[] bArr) {
        return new ad(new fe.p013if.ad.qw.p014if.ad(bArr));
    }

    public ad fromFile(File file) {
        return new ad(new fe.p013if.ad.qw.p014if.de(file));
    }

    public ad fromSource(DocumentSource documentSource) {
        return new ad(documentSource);
    }

    public ad fromStream(InputStream inputStream) {
        return new ad(new fe.p013if.ad.qw.p014if.fe(inputStream));
    }

    public ad fromUri(Uri uri) {
        return new ad(new fe.p013if.ad.qw.p014if.rg(uri));
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public float getCurrentXOffset() {
        return this.currentXOffset;
    }

    public float getCurrentYOffset() {
        return this.currentYOffset;
    }

    public PdfDocument.Meta getDocumentMeta() {
        th thVar = this.pdfFile;
        if (thVar == null) {
            return null;
        }
        return thVar.i();
    }

    public int getEndTipViewHeight() {
        View view = this.endTipView;
        if (view == null) {
            return 0;
        }
        return view.getMeasuredHeight();
    }

    public int getEndTipViewWidth() {
        View view = this.endTipView;
        if (view == null) {
            return 0;
        }
        return view.getMeasuredWidth();
    }

    public List<PdfDocument.Link> getLinks(int i2) {
        th thVar = this.pdfFile;
        if (thVar == null) {
            return Collections.emptyList();
        }
        return thVar.m291if(i2);
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMidZoom() {
        return this.midZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public PDFThumb getPDFThumb() {
        PDFThumb pDFThumb = this.mPDFThumb;
        if (pDFThumb != null) {
            return pDFThumb;
        }
        if (this.pdfFile == null || !this.renderingHandlerThread.isAlive()) {
            return null;
        }
        PDFThumb pDFThumb2 = new PDFThumb(this.renderingHandlerThread.getLooper(), this.pdfFile);
        this.mPDFThumb = pDFThumb2;
        return pDFThumb2;
    }

    public int getPageAtPositionOffset(float f) {
        th thVar = this.pdfFile;
        return thVar.o(thVar.rg(this.zoom) * f, this.zoom);
    }

    public int getPageCount() {
        th thVar = this.pdfFile;
        if (thVar == null) {
            return 0;
        }
        return thVar.ggg();
    }

    public FitPolicy getPageFitPolicy() {
        return this.pageFitPolicy;
    }

    public SizeF getPageSize(int i2) {
        th thVar = this.pdfFile;
        if (thVar == null) {
            return new SizeF(0.0f, 0.0f);
        }
        return thVar.when(i2);
    }

    public float getPositionOffset() {
        int i2;
        float f;
        float f2;
        if (this.swipeVertical) {
            f2 = -this.currentYOffset;
            f = this.pdfFile.rg(this.zoom) + ((float) getEndTipViewHeight());
            i2 = getHeight();
        } else {
            f2 = -this.currentXOffset;
            f = this.pdfFile.rg(this.zoom) + ((float) getEndTipViewWidth());
            i2 = getWidth();
        }
        return fe.p013if.ad.qw.p015switch.ad.de(f2 / (f - ((float) i2)), 0.0f, 1.0f);
    }

    public ScrollHandle getScrollHandle() {
        return this.scrollHandle;
    }

    public int getSpacingPx() {
        return this.spacingPx;
    }

    public List<PdfDocument.Bookmark> getTableOfContents() {
        th thVar = this.pdfFile;
        if (thVar == null) {
            return Collections.emptyList();
        }
        return thVar.fe();
    }

    public float getZoom() {
        return this.zoom;
    }

    public boolean isAnnotationRendering() {
        return this.annotationRendering;
    }

    public boolean isAntialiasing() {
        return this.enableAntialiasing;
    }

    public boolean isAutoSpacingEnabled() {
        return this.autoSpacing;
    }

    public boolean isBestQuality() {
        return this.bestQuality;
    }

    public boolean isDoubletapEnabled() {
        return this.doubletapEnabled;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0060, code lost:
        if (r0 > 0.0f) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
        if (r3 < r2) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0065 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEndTipHandleClick(android.view.MotionEvent r9) {
        /*
            r8 = this;
            android.view.View r0 = r8.endTipView
            r1 = 0
            if (r0 == 0) goto L_0x007e
            fe.if.ad.qw.th r0 = r8.pdfFile
            if (r0 != 0) goto L_0x000b
            goto L_0x007e
        L_0x000b:
            int r0 = r8.getWidth()
            float r0 = (float) r0
            int r2 = r8.getHeight()
            float r2 = (float) r2
            boolean r3 = r8.swipeVertical
            r4 = 0
            r5 = 1
            r6 = 1073741824(0x40000000, float:2.0)
            if (r3 == 0) goto L_0x003b
            int r3 = r8.getEndTipViewWidth()
            float r3 = (float) r3
            float r0 = r0 - r3
            float r0 = r0 / r6
            float r3 = r8.currentYOffset
            fe.if.ad.qw.th r6 = r8.pdfFile
            float r7 = r8.zoom
            float r6 = r6.rg(r7)
            float r3 = r3 + r6
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0039
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0039
        L_0x0037:
            r2 = 1
            goto L_0x0063
        L_0x0039:
            r2 = 0
            goto L_0x0063
        L_0x003b:
            float r0 = r8.currentXOffset
            fe.if.ad.qw.th r2 = r8.pdfFile
            float r3 = r8.zoom
            float r2 = r2.rg(r3)
            float r0 = r0 + r2
            int r2 = r8.getWidth()
            int r3 = r8.getEndTipViewWidth()
            int r2 = r2 - r3
            float r2 = (float) r2
            float r2 = r2 / r6
            float r0 = r0 + r2
            int r2 = r8.getHeight()
            int r3 = r8.getEndTipViewHeight()
            int r2 = r2 - r3
            float r2 = (float) r2
            float r3 = r2 / r6
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0039
            goto L_0x0037
        L_0x0063:
            if (r2 != 0) goto L_0x0066
            return r1
        L_0x0066:
            float r2 = r9.getX()
            float r2 = r2 - r0
            float r9 = r9.getY()
            float r9 = r9 - r3
            android.view.View r0 = r8.endTipView
            android.view.View r9 = r8.findClickedView(r0, r2, r9)
            if (r9 == 0) goto L_0x007b
            r9.performClick()
        L_0x007b:
            if (r9 == 0) goto L_0x007e
            r1 = 1
        L_0x007e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PDFView.isEndTipHandleClick(android.view.MotionEvent):boolean");
    }

    public boolean isFitEachPage() {
        return this.fitEachPage;
    }

    public boolean isPageFlingEnabled() {
        return this.pageFling;
    }

    public boolean isPageSnap() {
        return this.pageSnap;
    }

    public boolean isRecycled() {
        return this.recycled;
    }

    public boolean isSwipeEnabled() {
        return this.enableSwipe;
    }

    public boolean isSwipeVertical() {
        return this.swipeVertical;
    }

    public boolean isZooming() {
        return this.zoom != this.minZoom;
    }

    public void jumpTo(int i2, boolean z) {
        float f;
        th thVar = this.pdfFile;
        if (thVar != null) {
            int qw2 = thVar.qw(i2);
            if (qw2 == 0) {
                f = 0.0f;
            } else {
                f = -this.pdfFile.m292switch(qw2, this.zoom);
            }
            if (this.swipeVertical) {
                if (z) {
                    this.animationManager.o(this.currentYOffset, f);
                } else {
                    moveTo(this.currentXOffset, f);
                }
            } else if (z) {
                this.animationManager.i(this.currentXOffset, f);
            } else {
                moveTo(f, this.currentYOffset);
            }
            showPage(qw2);
        }
    }

    public void loadComplete(th thVar) {
        this.state = State.LOADED;
        this.pdfFile = thVar;
        if (!this.renderingHandlerThread.isAlive()) {
            this.renderingHandlerThread.start();
        }
        uk ukVar = new uk(this.renderingHandlerThread.getLooper(), this);
        this.renderingHandler = ukVar;
        ukVar.rg();
        ScrollHandle scrollHandle2 = this.scrollHandle;
        if (scrollHandle2 != null) {
            scrollHandle2.setupLayout(this);
            this.isScrollHandleInit = true;
        }
        this.dragPinchManager.fe();
        this.callbacks.de(thVar.ggg());
        jumpTo(this.defaultPage, false);
    }

    public void loadError(Throwable th2) {
        this.state = State.ERROR;
        OnErrorListener onErrorListener = this.callbacks.m287if();
        recycle();
        invalidate();
        if (onErrorListener != null) {
            onErrorListener.onError(th2);
        }
    }

    public void loadPageByOffset() {
        int i2;
        float f;
        th thVar = this.pdfFile;
        if (thVar != null && thVar.ggg() != 0) {
            if (this.swipeVertical) {
                f = this.currentYOffset;
                i2 = getHeight();
            } else {
                f = this.currentXOffset;
                i2 = getWidth();
            }
            int o2 = this.pdfFile.o(-(f - (((float) i2) / 2.0f)), this.zoom);
            if (o2 < 0 || o2 > this.pdfFile.ggg() - 1 || o2 == getCurrentPage()) {
                loadPages();
            } else {
                showPage(o2);
            }
            ScrollHandle scrollHandle2 = this.scrollHandle;
            if (scrollHandle2 != null && scrollHandle2.shown()) {
                this.scrollHandle.hideDelayed();
            }
        }
    }

    public void loadPages() {
        uk ukVar;
        if (this.pdfFile != null && (ukVar = this.renderingHandler) != null) {
            ukVar.removeMessages(1);
            this.cacheManager.i();
            this.pagesLoader.th();
            redraw();
        }
    }

    public void moveRelativeTo(float f, float f2) {
        moveTo(this.currentXOffset + f, this.currentYOffset + f2);
    }

    public void moveTo(float f, float f2) {
        moveTo(f, f2, true);
    }

    public void onBitmapRendered(fe.p013if.ad.qw.pf.ad adVar) {
        if (this.state == State.LOADED) {
            this.state = State.SHOWN;
            this.callbacks.uk(this.pdfFile.ggg());
        }
        if (adVar.rg()) {
            this.cacheManager.de(adVar);
        } else {
            this.cacheManager.ad(adVar);
        }
        redraw();
    }

    public void onDetachedFromWindow() {
        recycle();
        PDFThumb pDFThumb = this.mPDFThumb;
        if (pDFThumb != null) {
            pDFThumb.de();
        }
        HandlerThread handlerThread = this.renderingHandlerThread;
        if (handlerThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                handlerThread.quitSafely();
            } else {
                handlerThread.quit();
            }
            this.renderingHandlerThread = null;
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        if (!isInEditMode()) {
            if (this.enableAntialiasing) {
                canvas.setDrawFilter(this.antialiasFilter);
            }
            Drawable background = getBackground();
            if (background == null) {
                canvas.drawColor(this.nightMode ? -16777216 : -1);
            } else {
                background.draw(canvas);
            }
            if (!this.recycled && this.state == State.SHOWN) {
                float f = this.currentXOffset;
                float f2 = this.currentYOffset;
                canvas.translate(f, f2);
                for (fe.p013if.ad.qw.pf.ad drawPart : this.cacheManager.yj()) {
                    drawPart(canvas, drawPart);
                }
                for (fe.p013if.ad.qw.pf.ad next : this.cacheManager.th()) {
                    drawPart(canvas, next);
                    if (this.callbacks.pf() != null && !this.onDrawPagesNums.contains(Integer.valueOf(next.ad()))) {
                        this.onDrawPagesNums.add(Integer.valueOf(next.ad()));
                    }
                }
                for (Integer intValue : this.onDrawPagesNums) {
                    drawWithListener(canvas, intValue.intValue(), this.callbacks.pf());
                }
                this.onDrawPagesNums.clear();
                drawWithListener(canvas, this.currentPage, this.callbacks.o());
                canvas.translate(-f, -f2);
                drawEndTip(canvas);
            }
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        layoutEndTipView();
    }

    public void onMeasure(int i2, int i3) {
        measureEndTipView();
        super.onMeasure(i2, i3);
    }

    public void onPageError(PageRenderingException pageRenderingException) {
        if (!this.callbacks.th(pageRenderingException.getPage(), pageRenderingException.getCause())) {
            "Cannot open page " + pageRenderingException.getPage();
            pageRenderingException.getCause();
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        float f;
        float f2;
        this.hasSize = true;
        ad adVar = this.waitingDocumentConfigurator;
        if (adVar != null) {
            adVar.uk();
        }
        if (!isInEditMode() && this.state == State.SHOWN) {
            float f3 = (-this.currentXOffset) + (((float) i4) * 0.5f);
            float f4 = (-this.currentYOffset) + (((float) i5) * 0.5f);
            if (this.swipeVertical) {
                f2 = f3 / this.pdfFile.uk();
                f = this.pdfFile.rg(this.zoom);
            } else {
                f2 = f3 / this.pdfFile.rg(this.zoom);
                f = this.pdfFile.th();
            }
            float f5 = f4 / f;
            this.animationManager.m289if();
            this.pdfFile.rrr(new Size(i2, i3));
            if (this.swipeVertical) {
                this.currentXOffset = ((-f2) * this.pdfFile.uk()) + (((float) i2) * 0.5f);
                this.currentYOffset = ((-f5) * this.pdfFile.rg(this.zoom)) + (((float) i3) * 0.5f);
            } else {
                this.currentXOffset = ((-f2) * this.pdfFile.rg(this.zoom)) + (((float) i2) * 0.5f);
                this.currentYOffset = ((-f5) * this.pdfFile.th()) + (((float) i3) * 0.5f);
            }
            moveTo(this.currentXOffset, this.currentYOffset);
            loadPageByOffset();
        }
    }

    public boolean pageFillsScreen() {
        float f = -this.pdfFile.m292switch(this.currentPage, this.zoom);
        float pf2 = f - this.pdfFile.pf(this.currentPage, this.zoom);
        if (isSwipeVertical()) {
            float f2 = this.currentYOffset;
            if (f <= f2 || pf2 >= f2 - ((float) getHeight())) {
                return false;
            }
            return true;
        }
        float f3 = this.currentXOffset;
        if (f <= f3 || pf2 >= f3 - ((float) getWidth())) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = findFocusPage(r3.currentXOffset, r3.currentYOffset);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void performPageSnap() {
        /*
            r3 = this;
            boolean r0 = r3.pageSnap
            if (r0 == 0) goto L_0x0039
            fe.if.ad.qw.th r0 = r3.pdfFile
            if (r0 == 0) goto L_0x0039
            int r0 = r0.ggg()
            if (r0 != 0) goto L_0x000f
            goto L_0x0039
        L_0x000f:
            float r0 = r3.currentXOffset
            float r1 = r3.currentYOffset
            int r0 = r3.findFocusPage(r0, r1)
            com.github.barteksc.pdfviewer.util.SnapEdge r1 = r3.findSnapEdge(r0)
            com.github.barteksc.pdfviewer.util.SnapEdge r2 = com.github.barteksc.pdfviewer.util.SnapEdge.NONE
            if (r1 != r2) goto L_0x0020
            return
        L_0x0020:
            float r0 = r3.snapOffsetForPage(r0, r1)
            boolean r1 = r3.swipeVertical
            if (r1 == 0) goto L_0x0031
            fe.if.ad.qw.qw r1 = r3.animationManager
            float r2 = r3.currentYOffset
            float r0 = -r0
            r1.o(r2, r0)
            goto L_0x0039
        L_0x0031:
            fe.if.ad.qw.qw r1 = r3.animationManager
            float r2 = r3.currentXOffset
            float r0 = -r0
            r1.i(r2, r0)
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PDFView.performPageSnap():void");
    }

    public void recycle() {
        this.waitingDocumentConfigurator = null;
        this.animationManager.m289if();
        this.dragPinchManager.de();
        uk ukVar = this.renderingHandler;
        if (ukVar != null) {
            ukVar.th();
            this.renderingHandler.removeMessages(1);
        }
        de deVar = this.decodingAsyncTask;
        if (deVar != null) {
            deVar.cancel(true);
        }
        this.cacheManager.o();
        ScrollHandle scrollHandle2 = this.scrollHandle;
        if (scrollHandle2 != null && this.isScrollHandleInit) {
            scrollHandle2.destroyLayout();
        }
        PDFThumb pDFThumb = this.mPDFThumb;
        if (pDFThumb != null) {
            pDFThumb.de();
            this.mPDFThumb = null;
        }
        th thVar = this.pdfFile;
        if (thVar != null) {
            thVar.ad();
            this.pdfFile = null;
        }
        this.renderingHandler = null;
        this.scrollHandle = null;
        this.isScrollHandleInit = false;
        this.currentYOffset = 0.0f;
        this.currentXOffset = 0.0f;
        this.zoom = 1.0f;
        this.recycled = true;
        this.callbacks = new fe.p013if.ad.qw.o.qw();
        this.state = State.DEFAULT;
    }

    public void redraw() {
        invalidate();
    }

    public void resetZoom() {
        zoomTo(this.minZoom);
    }

    public void resetZoomWithAnimation() {
        zoomWithAnimation(this.minZoom);
    }

    public void setEndTipView(View view) {
        this.endTipView = view;
    }

    public void setMaxZoom(float f) {
        this.maxZoom = f;
    }

    public void setMidZoom(float f) {
        this.midZoom = f;
    }

    public void setMinZoom(float f) {
        this.minZoom = f;
    }

    public void setNightMode(boolean z) {
        this.nightMode = z;
        if (z) {
            this.paint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f})));
            return;
        }
        this.paint.setColorFilter((ColorFilter) null);
    }

    public void setPageFling(boolean z) {
        this.pageFling = z;
    }

    public void setPageSnap(boolean z) {
        this.pageSnap = z;
    }

    public void setPositionOffset(float f, boolean z) {
        if (this.swipeVertical) {
            moveTo(this.currentXOffset, (((-this.pdfFile.rg(this.zoom)) - ((float) getEndTipViewHeight())) + ((float) getHeight())) * f, z);
        } else {
            moveTo((((-this.pdfFile.rg(this.zoom)) - ((float) getEndTipViewWidth())) + ((float) getWidth())) * f, this.currentYOffset, z);
        }
        loadPageByOffset();
    }

    public void setSwipeEnabled(boolean z) {
        this.enableSwipe = z;
    }

    public void showPage(int i2) {
        if (!this.recycled) {
            this.currentPage = this.pdfFile.qw(i2);
            loadPages();
            if (this.scrollHandle != null && !documentFitsView()) {
                this.scrollHandle.setPageNum(this.currentPage + 1);
            }
            this.callbacks.rg(this.currentPage, this.pdfFile.ggg());
        }
    }

    public float snapOffsetForPage(int i2, SnapEdge snapEdge) {
        float f;
        float f2 = this.pdfFile.m292switch(i2, this.zoom);
        float height = (float) (this.swipeVertical ? getHeight() : getWidth());
        float pf2 = this.pdfFile.pf(i2, this.zoom);
        if (i2 >= getPageCount()) {
            return this.pdfFile.rg(this.zoom);
        }
        if (snapEdge == SnapEdge.CENTER) {
            f = f2 - (height / 2.0f);
            pf2 /= 2.0f;
        } else if (snapEdge != SnapEdge.END) {
            return f2;
        } else {
            f = f2 - height;
        }
        return f + pf2;
    }

    public void stopFling() {
        this.animationManager.m290switch();
    }

    public float toCurrentScale(float f) {
        return f * this.zoom;
    }

    public float toRealScale(float f) {
        return f / this.zoom;
    }

    public void useBestQuality(boolean z) {
        this.bestQuality = z;
    }

    public void zoomCenteredRelativeTo(float f, PointF pointF) {
        zoomCenteredTo(this.zoom * f, pointF);
    }

    public void zoomCenteredTo(float f, PointF pointF) {
        float f2 = f / this.zoom;
        zoomTo(f);
        float f3 = pointF.x;
        float f4 = pointF.y;
        moveTo((this.currentXOffset * f2) + (f3 - (f3 * f2)), (this.currentYOffset * f2) + (f4 - (f2 * f4)));
    }

    public void zoomTo(float f) {
        this.zoom = f;
    }

    public void zoomWithAnimation(float f, float f2, float f3) {
        this.animationManager.pf(f, f2, this.zoom, f3);
    }

    /* access modifiers changed from: private */
    public void load(DocumentSource documentSource, String str, int[] iArr) {
        if (this.recycled) {
            this.recycled = false;
            de deVar = new de(documentSource, str, iArr, this, this.pdfiumCore);
            this.decodingAsyncTask = deVar;
            deVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        throw new IllegalStateException("Don't call load on a PDF View without recycling it first.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void moveTo(float r6, float r7, boolean r8) {
        /*
            r5 = this;
            fe.if.ad.qw.th r0 = r5.pdfFile
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r1 = r5.swipeVertical
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 0
            if (r1 == 0) goto L_0x0091
            float r0 = r0.uk()
            float r0 = r5.toCurrentScale(r0)
            int r1 = r5.getWidth()
            float r1 = (float) r1
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0027
            int r6 = r5.getWidth()
            int r6 = r6 / 2
            float r6 = (float) r6
            float r0 = r0 / r2
        L_0x0025:
            float r6 = r6 - r0
            goto L_0x003e
        L_0x0027:
            int r1 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x002d
            r6 = 0
            goto L_0x003e
        L_0x002d:
            float r1 = r6 + r0
            int r4 = r5.getWidth()
            float r4 = (float) r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x003e
            int r6 = r5.getWidth()
            float r6 = (float) r6
            goto L_0x0025
        L_0x003e:
            int r0 = r5.getEndTipViewHeight()
            fe.if.ad.qw.th r1 = r5.pdfFile
            float r4 = r5.zoom
            float r1 = r1.rg(r4)
            float r0 = (float) r0
            float r1 = r1 + r0
            int r0 = r5.getHeight()
            float r0 = (float) r0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x005d
            int r7 = r5.getHeight()
            float r7 = (float) r7
            float r7 = r7 - r1
            float r7 = r7 / r2
            goto L_0x0075
        L_0x005d:
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0063
            r7 = 0
            goto L_0x0075
        L_0x0063:
            float r0 = r7 + r1
            int r2 = r5.getHeight()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0075
            float r7 = -r1
            int r0 = r5.getHeight()
            float r0 = (float) r0
            float r7 = r7 + r0
        L_0x0075:
            float r0 = r5.currentYOffset
            int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0081
            com.github.barteksc.pdfviewer.PDFView$ScrollDir r0 = com.github.barteksc.pdfviewer.PDFView.ScrollDir.END
            r5.scrollDir = r0
            goto L_0x0118
        L_0x0081:
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008b
            com.github.barteksc.pdfviewer.PDFView$ScrollDir r0 = com.github.barteksc.pdfviewer.PDFView.ScrollDir.START
            r5.scrollDir = r0
            goto L_0x0118
        L_0x008b:
            com.github.barteksc.pdfviewer.PDFView$ScrollDir r0 = com.github.barteksc.pdfviewer.PDFView.ScrollDir.NONE
            r5.scrollDir = r0
            goto L_0x0118
        L_0x0091:
            float r0 = r0.th()
            float r0 = r5.toCurrentScale(r0)
            int r1 = r5.getHeight()
            float r1 = (float) r1
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ac
            int r7 = r5.getHeight()
            int r7 = r7 / 2
            float r7 = (float) r7
            float r0 = r0 / r2
        L_0x00aa:
            float r7 = r7 - r0
            goto L_0x00c3
        L_0x00ac:
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x00b2
            r7 = 0
            goto L_0x00c3
        L_0x00b2:
            float r1 = r7 + r0
            int r4 = r5.getHeight()
            float r4 = (float) r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00c3
            int r7 = r5.getHeight()
            float r7 = (float) r7
            goto L_0x00aa
        L_0x00c3:
            android.view.View r0 = r5.endTipView
            if (r0 != 0) goto L_0x00c9
            r0 = 0
            goto L_0x00cd
        L_0x00c9:
            int r0 = r5.getWidth()
        L_0x00cd:
            fe.if.ad.qw.th r1 = r5.pdfFile
            float r4 = r5.zoom
            float r1 = r1.rg(r4)
            float r0 = (float) r0
            float r1 = r1 + r0
            int r0 = r5.getWidth()
            float r0 = (float) r0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x00e8
            int r6 = r5.getWidth()
            float r6 = (float) r6
            float r6 = r6 - r1
            float r6 = r6 / r2
            goto L_0x0100
        L_0x00e8:
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ee
            r6 = 0
            goto L_0x0100
        L_0x00ee:
            float r0 = r6 + r1
            int r2 = r5.getWidth()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0100
            float r6 = -r1
            int r0 = r5.getWidth()
            float r0 = (float) r0
            float r6 = r6 + r0
        L_0x0100:
            float r0 = r5.currentXOffset
            int r1 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x010b
            com.github.barteksc.pdfviewer.PDFView$ScrollDir r0 = com.github.barteksc.pdfviewer.PDFView.ScrollDir.END
            r5.scrollDir = r0
            goto L_0x0118
        L_0x010b:
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0114
            com.github.barteksc.pdfviewer.PDFView$ScrollDir r0 = com.github.barteksc.pdfviewer.PDFView.ScrollDir.START
            r5.scrollDir = r0
            goto L_0x0118
        L_0x0114:
            com.github.barteksc.pdfviewer.PDFView$ScrollDir r0 = com.github.barteksc.pdfviewer.PDFView.ScrollDir.NONE
            r5.scrollDir = r0
        L_0x0118:
            r5.currentXOffset = r6
            r5.currentYOffset = r7
            float r6 = r5.getPositionOffset()
            if (r8 == 0) goto L_0x0131
            com.github.barteksc.pdfviewer.scroll.ScrollHandle r7 = r5.scrollHandle
            if (r7 == 0) goto L_0x0131
            boolean r7 = r5.documentFitsView()
            if (r7 != 0) goto L_0x0131
            com.github.barteksc.pdfviewer.scroll.ScrollHandle r7 = r5.scrollHandle
            r7.setScroll(r6)
        L_0x0131:
            fe.if.ad.qw.o.qw r7 = r5.callbacks
            int r8 = r5.getCurrentPage()
            r7.yj(r8, r6)
            r5.redraw()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PDFView.moveTo(float, float, boolean):void");
    }

    public void zoomWithAnimation(float f) {
        this.animationManager.pf((float) (getWidth() / 2), (float) (getHeight() / 2), this.zoom, f);
    }

    public void setPositionOffset(float f) {
        setPositionOffset(f, true);
    }

    public void jumpTo(int i2) {
        jumpTo(i2, false);
    }
}
