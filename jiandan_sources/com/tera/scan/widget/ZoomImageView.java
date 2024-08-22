package com.tera.scan.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ZoomImageView extends ImageView {
    public static final int BOTTOM_EDGE = 8;
    public static final int LEFT_EDGE = 1;
    public static final int NONE = 0;
    public static final int RIGHT_EDGE = 2;
    public static final float SCALE_RATE = 1.25f;
    public static final String TAG = "ZoomImageView";
    public static final int TOP_EDGE = 4;
    public Matrix mBaseMatrix = new Matrix();
    public final fe mBitmapDisplayed = new fe((Bitmap) null);
    public View.OnClickListener mClickListener;
    public final Matrix mDisplayMatrix = new Matrix();
    public boolean mInViewPager;
    public RectF mMapRect = new RectF();
    public final float[] mMatrixValues = new float[9];
    public float mMaxZoom;
    public Recycler mRecycler;
    public rg mSetImageTask = null;
    public Matrix mSuppMatrix = new Matrix();
    public int mThisHeight = -1;
    public int mThisWidth = -1;
    public fe.mmm.qw.n.ad mTouchDetector;
    public boolean mZoomable = true;

    public interface Recycler {
        void qw(Bitmap bitmap);
    }

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ float f7495ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PointF f7496i;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ float f7497o;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ long f7499th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ float f7500uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ PointF f7501yj;

        public ad(float f, long j, PointF pointF, float f2, PointF pointF2, float f3) {
            this.f7495ad = f;
            this.f7499th = j;
            this.f7501yj = pointF;
            this.f7500uk = f2;
            this.f7496i = pointF2;
            this.f7497o = f3;
        }

        public void run() {
            float min = Math.min(this.f7495ad, (float) (System.currentTimeMillis() - this.f7499th));
            PointF pointF = this.f7501yj;
            float f = pointF.x + (this.f7500uk * min);
            PointF pointF2 = this.f7496i;
            float f2 = f - pointF2.x;
            float f3 = (pointF.y + (this.f7497o * min)) - pointF2.y;
            ZoomImageView.this.postTranslate(f2, f3);
            ZoomImageView zoomImageView = ZoomImageView.this;
            zoomImageView.setImageMatrix(zoomImageView.getImageViewMatrix());
            PointF pointF3 = this.f7496i;
            pointF3.x += f2;
            pointF3.y += f3;
            if (min < this.f7495ad) {
                ZoomImageView.this.post(this);
            }
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ float f7502ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ float f7503i;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ float f7504o;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ long f7506th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ float f7507uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ float f7508yj;

        public de(float f, long j, float f2, float f3, float f4, float f5) {
            this.f7502ad = f;
            this.f7506th = j;
            this.f7508yj = f2;
            this.f7507uk = f3;
            this.f7503i = f4;
            this.f7504o = f5;
        }

        public void run() {
            float min = Math.min(this.f7502ad, (float) (System.currentTimeMillis() - this.f7506th));
            ZoomImageView.this.zoomTo(this.f7508yj + (this.f7507uk * min), this.f7503i, this.f7504o);
            if (min < this.f7502ad) {
                ZoomImageView.this.post(this);
            }
        }
    }

    public static class fe {

        /* renamed from: ad  reason: collision with root package name */
        public int f7509ad = 0;
        public Bitmap qw;

        public fe(Bitmap bitmap) {
            this.qw = bitmap;
        }

        public int ad() {
            if (th()) {
                return this.qw.getWidth();
            }
            return this.qw.getHeight();
        }

        public Matrix de() {
            Bitmap bitmap;
            Matrix matrix = new Matrix();
            if (!(this.f7509ad == 0 || (bitmap = this.qw) == null)) {
                matrix.preTranslate((float) (-(bitmap.getWidth() / 2)), (float) (-(this.qw.getHeight() / 2)));
                matrix.postRotate((float) this.f7509ad);
                matrix.postTranslate(((float) rg()) / 2.0f, ((float) ad()) / 2.0f);
            }
            return matrix;
        }

        public int fe() {
            return this.f7509ad;
        }

        public Bitmap qw() {
            return this.qw;
        }

        public int rg() {
            if (th()) {
                return this.qw.getHeight();
            }
            return this.qw.getWidth();
        }

        public boolean th() {
            return (this.f7509ad / 90) % 2 != 0;
        }

        public void uk(int i2) {
            this.f7509ad = i2;
        }

        public void yj(Bitmap bitmap) {
            this.qw = bitmap;
        }
    }

    public class qw implements rg {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ boolean f7510ad;
        public final /* synthetic */ fe qw;

        public qw(fe feVar, boolean z) {
            this.qw = feVar;
            this.f7510ad = z;
        }

        public void qw() {
            ZoomImageView.this.setImageRotateBitmapResetBase(this.qw, this.f7510ad);
        }
    }

    public interface rg {
        void qw();
    }

    public ZoomImageView(Context context) {
        super(context);
        init();
    }

    private void createSetImageTask(fe feVar, boolean z) {
        this.mSetImageTask = new qw(feVar, z);
    }

    private void init() {
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mTouchDetector = new fe.mmm.qw.n.ad(getContext(), this);
    }

    private void setImageBitmapResetBase(Bitmap bitmap, boolean z) {
        setImageRotateBitmapResetBase(new fe(bitmap), z);
    }

    /* access modifiers changed from: private */
    public void setImageRotateBitmapResetBase(fe feVar, boolean z) {
        if (getWidth() <= 0) {
            createSetImageTask(feVar, z);
            return;
        }
        if (feVar.qw() != null) {
            getProperBaseMatrix(feVar, this.mBaseMatrix);
            setImageBitmap(feVar.qw(), feVar.fe());
        } else {
            this.mBaseMatrix.reset();
            setImageBitmap((Bitmap) null, 0);
        }
        if (z) {
            this.mSuppMatrix.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.mMaxZoom = maxZoom();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int center(boolean r8, boolean r9) {
        /*
            r7 = this;
            com.tera.scan.widget.ZoomImageView$fe r0 = r7.mBitmapDisplayed
            android.graphics.Bitmap r0 = r0.qw()
            if (r0 != 0) goto L_0x000b
            r8 = 15
            return r8
        L_0x000b:
            android.graphics.RectF r0 = r7.getMapRect()
            float r1 = r0.height()
            float r2 = r0.width()
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 0
            if (r9 == 0) goto L_0x0048
            int r9 = r7.getHeight()
            float r9 = (float) r9
            int r6 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r6 > 0) goto L_0x002e
            float r9 = r9 - r1
            float r9 = r9 / r4
            float r1 = r0.top
            float r9 = r9 - r1
            r3 = 12
            goto L_0x0049
        L_0x002e:
            float r1 = r0.top
            int r6 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r6 < 0) goto L_0x0037
            float r9 = -r1
            r3 = 4
            goto L_0x0049
        L_0x0037:
            float r1 = r0.bottom
            int r9 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r9 > 0) goto L_0x0048
            int r9 = r7.getHeight()
            float r9 = (float) r9
            float r1 = r0.bottom
            float r9 = r9 - r1
            r3 = 8
            goto L_0x0049
        L_0x0048:
            r9 = 0
        L_0x0049:
            if (r8 == 0) goto L_0x0071
            int r8 = r7.getWidth()
            float r8 = (float) r8
            int r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r1 > 0) goto L_0x005d
            float r8 = r8 - r2
            float r8 = r8 / r4
            float r0 = r0.left
            float r5 = r8 - r0
            r3 = r3 | 3
            goto L_0x0071
        L_0x005d:
            float r1 = r0.left
            int r2 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r2 < 0) goto L_0x0067
            float r5 = -r1
            r3 = r3 | 1
            goto L_0x0071
        L_0x0067:
            float r0 = r0.right
            int r1 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r1 > 0) goto L_0x0071
            float r5 = r8 - r0
            r3 = r3 | 2
        L_0x0071:
            r7.postTranslate(r5, r9)
            android.graphics.Matrix r8 = r7.getImageViewMatrix()
            r7.setImageMatrix(r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.widget.ZoomImageView.center(boolean, boolean):int");
    }

    public void clear() {
        setImageBitmapResetBase((Bitmap) null, true);
    }

    public void computeScroll() {
        super.computeScroll();
        this.mTouchDetector.i(this);
    }

    public Bitmap getDisplayBitmap() {
        return this.mBitmapDisplayed.qw();
    }

    public Matrix getImageViewMatrix() {
        this.mDisplayMatrix.set(this.mBaseMatrix);
        this.mDisplayMatrix.postConcat(this.mSuppMatrix);
        return this.mDisplayMatrix;
    }

    public RectF getMapRect() {
        this.mMapRect.setEmpty();
        if (this.mBitmapDisplayed.qw() == null) {
            return this.mMapRect;
        }
        Matrix imageViewMatrix = getImageViewMatrix();
        this.mMapRect.set(0.0f, 0.0f, (float) this.mBitmapDisplayed.qw().getWidth(), (float) this.mBitmapDisplayed.qw().getHeight());
        imageViewMatrix.mapRect(this.mMapRect);
        return this.mMapRect;
    }

    public float getMaxZoom() {
        return this.mMaxZoom;
    }

    public void getProperBaseMatrix(fe feVar, Matrix matrix) {
        float width = (float) getWidth();
        float height = (float) getHeight();
        float rg2 = (float) feVar.rg();
        float ad2 = (float) feVar.ad();
        matrix.reset();
        float f = ad2 * width > rg2 * height ? height / ad2 : width / rg2;
        matrix.postConcat(feVar.de());
        matrix.postScale(f, f);
        float f2 = (width - (rg2 * f)) / 2.0f;
        float f3 = (height - (ad2 * f)) / 2.0f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        matrix.postTranslate(f2, f3);
    }

    public float getScale(Matrix matrix) {
        return getValue(matrix, 0);
    }

    public ImageView.ScaleType getScaleType() {
        return ImageView.ScaleType.FIT_CENTER;
    }

    public float getTransX() {
        return getTransX(this.mSuppMatrix);
    }

    public float getTransY(Matrix matrix) {
        return getValue(matrix, 5);
    }

    public float getValue(Matrix matrix, int i2) {
        matrix.getValues(this.mMatrixValues);
        if (i2 < 0) {
            return 0.0f;
        }
        float[] fArr = this.mMatrixValues;
        if (i2 < fArr.length) {
            return fArr[i2];
        }
        return 0.0f;
    }

    public boolean inViewPager() {
        return this.mInViewPager;
    }

    public boolean isReady() {
        return this.mBitmapDisplayed.qw() != null;
    }

    public float maxZoom() {
        float f = this.mMaxZoom;
        if (f > 0.0f) {
            return f;
        }
        if (this.mBitmapDisplayed.qw() == null) {
            return 1.0f;
        }
        return Math.max(Math.max(((float) this.mBitmapDisplayed.rg()) / ((float) this.mThisWidth), ((float) this.mBitmapDisplayed.ad()) / ((float) this.mThisHeight)) * 4.0f, 1.0f);
    }

    public void onClick() {
        View.OnClickListener onClickListener = this.mClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.mThisWidth = i4 - i2;
        this.mThisHeight = i5 - i3;
        rg rgVar = this.mSetImageTask;
        if (rgVar != null) {
            this.mSetImageTask = null;
            rgVar.qw();
        }
        if (this.mBitmapDisplayed.qw() != null) {
            getProperBaseMatrix(this.mBitmapDisplayed, this.mBaseMatrix);
            setImageMatrix(getImageViewMatrix());
            center(true, true);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 5) {
            ((ViewGroup) getParent()).requestDisallowInterceptTouchEvent(motionEvent.getPointerCount() >= 2 || getScale() != 1.0f);
        }
        return this.mTouchDetector.m986switch(motionEvent);
    }

    public void panBy(float f, float f2) {
        postTranslate(f, f2);
        setImageMatrix(getImageViewMatrix());
    }

    public void postTranslate(float f, float f2) {
        this.mSuppMatrix.postTranslate(f, f2);
    }

    public int postTranslateCenter(float f, float f2) {
        postTranslate(f, f2);
        return center(true, true);
    }

    public void resetImageView() {
        setImageBitmap(getDisplayBitmap());
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmapResetBase(bitmap, true);
    }

    public void setImageResource(int i2) {
        setImageBitmap(BitmapFactory.decodeResource(getResources(), i2));
    }

    public void setInViewPager(boolean z) {
        this.mInViewPager = z;
    }

    public void setMaxZoom(float f) {
        this.mMaxZoom = f;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setRecycler(Recycler recycler) {
        this.mRecycler = recycler;
    }

    public void setZoomable(boolean z) {
        this.mZoomable = z;
    }

    public void zoomIn() {
        zoomIn(1.25f);
    }

    public void zoomOut() {
        zoomOut(1.25f);
    }

    public void zoomTo(float f, float f2, float f3) {
        if (this.mZoomable) {
            float scale = f / getScale();
            this.mSuppMatrix.postScale(scale, scale, f2, f3);
            setImageMatrix(getImageViewMatrix());
            center(true, true);
        }
    }

    private void setImageBitmap(Bitmap bitmap, int i2) {
        Recycler recycler;
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap qw2 = this.mBitmapDisplayed.qw();
        this.mBitmapDisplayed.yj(bitmap);
        this.mBitmapDisplayed.uk(i2);
        if (qw2 != null && qw2 != bitmap && (recycler = this.mRecycler) != null) {
            recycler.qw(qw2);
        }
    }

    public float getScale() {
        return getScale(this.mSuppMatrix);
    }

    public float getTransX(Matrix matrix) {
        return getValue(matrix, 2);
    }

    public float getTransY() {
        return getTransY(this.mSuppMatrix);
    }

    public void zoomIn(float f) {
        if (getScale() < this.mMaxZoom && this.mBitmapDisplayed.qw() != null) {
            this.mSuppMatrix.postScale(f, f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void zoomOut(float f) {
        if (this.mBitmapDisplayed.qw() != null) {
            float width = ((float) getWidth()) / 2.0f;
            float height = ((float) getHeight()) / 2.0f;
            Matrix matrix = new Matrix(this.mSuppMatrix);
            float f2 = 1.0f / f;
            matrix.postScale(f2, f2, width, height);
            if (getScale(matrix) < 1.0f) {
                this.mSuppMatrix.setScale(1.0f, 1.0f, width, height);
            } else {
                this.mSuppMatrix.postScale(f2, f2, width, height);
            }
            setImageMatrix(getImageViewMatrix());
            center(true, true);
        }
    }

    public void zoomTo(float f, float f2, float f3, float f4) {
        float scale = getScale();
        float f5 = f4;
        post(new de(f5, System.currentTimeMillis(), scale, (f - getScale()) / f4, f2, f3));
    }

    public void zoomTo(float f) {
        zoomTo(f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, 200.0f);
    }

    public ZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void center(boolean r12, boolean r13, float r14) {
        /*
            r11 = this;
            com.tera.scan.widget.ZoomImageView$fe r0 = r11.mBitmapDisplayed
            android.graphics.Bitmap r0 = r0.qw()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            android.graphics.Matrix r0 = r11.getImageViewMatrix()
            android.graphics.RectF r1 = new android.graphics.RectF
            com.tera.scan.widget.ZoomImageView$fe r2 = r11.mBitmapDisplayed
            android.graphics.Bitmap r2 = r2.qw()
            int r2 = r2.getWidth()
            float r2 = (float) r2
            com.tera.scan.widget.ZoomImageView$fe r3 = r11.mBitmapDisplayed
            android.graphics.Bitmap r3 = r3.qw()
            int r3 = r3.getHeight()
            float r3 = (float) r3
            r4 = 0
            r1.<init>(r4, r4, r2, r3)
            r0.mapRect(r1)
            float r0 = r1.height()
            float r2 = r1.width()
            android.graphics.PointF r5 = new android.graphics.PointF
            r5.<init>()
            android.graphics.PointF r7 = new android.graphics.PointF
            r7.<init>()
            r3 = 1073741824(0x40000000, float:2.0)
            if (r13 == 0) goto L_0x006f
            int r6 = r11.getHeight()
            float r6 = (float) r6
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0053
            float r6 = r6 - r0
            float r6 = r6 / r3
            float r0 = r1.top
            float r6 = r6 - r0
            r5.y = r0
            goto L_0x0070
        L_0x0053:
            float r0 = r1.top
            int r8 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x005d
            float r6 = -r0
            r5.y = r0
            goto L_0x0070
        L_0x005d:
            float r0 = r1.bottom
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x006f
            int r0 = r11.getHeight()
            float r0 = (float) r0
            float r6 = r1.bottom
            float r0 = r0 - r6
            r5.y = r6
            r6 = r0
            goto L_0x0070
        L_0x006f:
            r6 = 0
        L_0x0070:
            if (r12 == 0) goto L_0x0098
            int r0 = r11.getWidth()
            float r0 = (float) r0
            int r8 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x0084
            float r0 = r0 - r2
            float r0 = r0 / r3
            float r1 = r1.left
            float r4 = r0 - r1
            r5.x = r1
            goto L_0x0098
        L_0x0084:
            float r2 = r1.left
            int r3 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x008e
            float r4 = -r2
            r5.x = r2
            goto L_0x0098
        L_0x008e:
            float r1 = r1.right
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0098
            float r4 = r0 - r1
            r5.x = r1
        L_0x0098:
            r7.set(r5)
            float r8 = r4 / r14
            float r9 = r6 / r14
            long r3 = java.lang.System.currentTimeMillis()
            com.tera.scan.widget.ZoomImageView$ad r10 = new com.tera.scan.widget.ZoomImageView$ad
            r0 = r10
            r1 = r11
            r2 = r14
            r6 = r8
            r8 = r9
            r0.<init>(r2, r3, r5, r6, r7, r8)
            r11.post(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.widget.ZoomImageView.center(boolean, boolean, float):void");
    }

    public ZoomImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
