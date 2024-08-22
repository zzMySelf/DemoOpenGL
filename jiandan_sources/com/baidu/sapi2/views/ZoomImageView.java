package com.baidu.sapi2.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.baidu.sapi2.utils.Log;

@TargetApi(8)
public class ZoomImageView extends ImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: o  reason: collision with root package name */
    public static final String f967o = "ZoomImageView";
    public static final float p = 12.0f;
    public static ZoomImageView q;
    public float a;
    public final float[] b;
    public boolean c;
    public ScaleGestureDetector d;
    public final Matrix e;
    public int f;
    public float g;
    public float h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f968i;
    public double j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;

    public ZoomImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void b() {
        Rect rect;
        RectF matrixRectF = getMatrixRectF();
        ClipBoxView instance = ClipBoxView.getInstance();
        if (instance != null) {
            rect = instance.getmFrameRectF();
        } else {
            rect = new Rect();
        }
        getWidth();
        getHeight();
        float f2 = matrixRectF.top;
        float f3 = (float) rect.top;
        float f4 = 0.0f;
        float f5 = (f2 <= f3 || !this.l) ? 0.0f : -(f2 - f3);
        float f6 = matrixRectF.bottom;
        float f7 = (float) rect.bottom;
        if (f6 < f7 && this.l) {
            f5 = f7 - f6;
        }
        float f8 = matrixRectF.left;
        float f9 = (float) rect.left;
        if (f8 > f9 && this.k) {
            f4 = -(f8 - f9);
        }
        float f10 = matrixRectF.right;
        float f11 = (float) rect.right;
        if (f10 < f11 && this.k) {
            f4 = f11 - f10;
        }
        this.e.postTranslate(f4, f5);
    }

    public static void c() {
        q = null;
    }

    public static ZoomImageView getInstance() {
        ZoomImageView zoomImageView = q;
        if (zoomImageView != null) {
            return zoomImageView;
        }
        return null;
    }

    public void a(float f2, float f3) {
        Rect rect;
        float f4;
        RectF matrixRectF = getMatrixRectF();
        ClipBoxView instance = ClipBoxView.getInstance();
        if (instance != null) {
            rect = instance.getmFrameRectF();
        } else {
            rect = new Rect();
        }
        int i2 = rect.right - rect.left;
        int i3 = rect.bottom - rect.top;
        float f5 = (float) i2;
        float f6 = 0.0f;
        if (matrixRectF.width() >= f5) {
            float f7 = matrixRectF.left;
            float f8 = (float) rect.left;
            f4 = f7 > f8 ? -(f7 - f8) : 0.0f;
            float f9 = matrixRectF.right;
            float f10 = (float) rect.right;
            if (f9 < f10) {
                f4 = f10 - f9;
            }
        } else {
            f4 = 0.0f;
        }
        float f11 = (float) i3;
        if (matrixRectF.height() >= f11) {
            float f12 = matrixRectF.top;
            float f13 = (float) rect.top;
            if (f12 > f13) {
                f6 = -(f12 - f13);
            }
            float f14 = matrixRectF.bottom;
            float f15 = (float) rect.bottom;
            if (f14 < f15) {
                f6 = f15 - f14;
            }
        }
        this.e.postTranslate(f4, f6);
        if (matrixRectF.width() < f5 || matrixRectF.height() < f11) {
            float max = Math.max(f5 / matrixRectF.width(), f11 / matrixRectF.height());
            this.e.postScale(max, max, f2, f3);
        }
    }

    public RectF getMatrixRectF() {
        Matrix matrix = this.e;
        RectF rectF = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    public final float getScale() {
        this.e.getValues(this.b);
        return this.b[0];
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    public void onGlobalLayout() {
        Drawable drawable;
        float f2;
        float height;
        float f3;
        if (this.c && (drawable = getDrawable()) != null) {
            this.m = (int) TypedValue.applyDimension(1, (float) this.m, getResources().getDisplayMetrics());
            this.n = (getHeight() - (getWidth() - (this.m * 2))) / 2;
            int width = getWidth();
            int height2 = getHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth < getWidth() - (this.m * 2) && intrinsicHeight > getHeight() - (this.n * 2)) {
                height = (((float) getWidth()) * 1.0f) - ((float) (this.m * 2));
                f3 = (float) intrinsicWidth;
            } else if (intrinsicHeight >= getHeight() - (this.n * 2) || intrinsicWidth <= getWidth() - (this.m * 2)) {
                f2 = Math.max(((((float) getWidth()) * 1.0f) - ((float) (this.m * 2))) / ((float) intrinsicWidth), ((((float) getHeight()) * 1.0f) - ((float) (this.n * 2))) / ((float) intrinsicHeight));
                this.a = f2;
                this.e.postTranslate((float) ((width - intrinsicWidth) / 2), (float) ((height2 - intrinsicHeight) / 2));
                this.e.postScale(f2, f2, (float) (width / 2), (float) (height2 / 2));
                setImageMatrix(this.e);
                this.c = false;
            } else {
                height = (((float) getHeight()) * 1.0f) - ((float) (this.n * 2));
                f3 = (float) intrinsicHeight;
            }
            f2 = height / f3;
            this.a = f2;
            this.e.postTranslate((float) ((width - intrinsicWidth) / 2), (float) ((height2 - intrinsicHeight) / 2));
            this.e.postScale(f2, f2, (float) (width / 2), (float) (height2 / 2));
            setImageMatrix(this.e);
            this.c = false;
        }
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scale = getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (getDrawable() == null) {
            return true;
        }
        if ((scale < 12.0f && scaleFactor > 1.0f) || scaleFactor < 1.0f) {
            if (scaleFactor * scale > 12.0f) {
                scaleFactor = 12.0f / scale;
            }
            this.e.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            a(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            setImageMatrix(this.e);
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r11 != 3) goto L_0x00b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            android.view.ScaleGestureDetector r11 = r10.d
            r11.onTouchEvent(r12)
            int r11 = r12.getPointerCount()
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x000e:
            if (r2 >= r11) goto L_0x001d
            float r5 = r12.getX(r2)
            float r4 = r4 + r5
            float r5 = r12.getY(r2)
            float r3 = r3 + r5
            int r2 = r2 + 1
            goto L_0x000e
        L_0x001d:
            float r2 = (float) r11
            float r4 = r4 / r2
            float r3 = r3 / r2
            int r2 = r10.f
            if (r11 == r2) goto L_0x002a
            r10.f968i = r1
            r10.g = r4
            r10.h = r3
        L_0x002a:
            r10.f = r11
            int r11 = r12.getAction()
            r12 = 1
            if (r11 == r12) goto L_0x00b3
            r2 = 2
            if (r11 == r2) goto L_0x003b
            r0 = 3
            if (r11 == r0) goto L_0x00b3
            goto L_0x00b5
        L_0x003b:
            float r11 = r10.g
            float r11 = r4 - r11
            float r2 = r10.h
            float r2 = r3 - r2
            boolean r5 = r10.f968i
            if (r5 != 0) goto L_0x005c
            float r5 = r11 * r11
            float r6 = r2 * r2
            float r5 = r5 + r6
            double r5 = (double) r5
            double r5 = java.lang.Math.sqrt(r5)
            double r7 = r10.j
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x0059
            r5 = 1
            goto L_0x005a
        L_0x0059:
            r5 = 0
        L_0x005a:
            r10.f968i = r5
        L_0x005c:
            boolean r5 = r10.f968i
            if (r5 == 0) goto L_0x00ae
            android.graphics.RectF r5 = r10.getMatrixRectF()
            android.graphics.drawable.Drawable r6 = r10.getDrawable()
            if (r6 == 0) goto L_0x00ae
            r10.k = r12
            r10.l = r12
            com.baidu.sapi2.views.ClipBoxView r6 = com.baidu.sapi2.views.ClipBoxView.getInstance()
            if (r6 == 0) goto L_0x0079
            android.graphics.Rect r6 = r6.getmFrameRectF()
            goto L_0x007e
        L_0x0079:
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
        L_0x007e:
            float r7 = r5.width()
            int r8 = r6.right
            int r9 = r6.left
            int r8 = r8 - r9
            float r8 = (float) r8
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x008f
            r10.k = r1
            r11 = 0
        L_0x008f:
            float r5 = r5.height()
            int r7 = r6.bottom
            int r6 = r6.top
            int r7 = r7 - r6
            float r6 = (float) r7
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x00a0
            r10.l = r1
            goto L_0x00a1
        L_0x00a0:
            r0 = r2
        L_0x00a1:
            android.graphics.Matrix r1 = r10.e
            r1.postTranslate(r11, r0)
            r10.b()
            android.graphics.Matrix r11 = r10.e
            r10.setImageMatrix(r11)
        L_0x00ae:
            r10.g = r4
            r10.h = r3
            goto L_0x00b5
        L_0x00b3:
            r10.f = r1
        L_0x00b5:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.views.ZoomImageView.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public ZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 1.0f;
        this.b = new float[9];
        this.c = true;
        this.e = new Matrix();
        this.f = 0;
        this.g = 0.0f;
        this.h = 0.0f;
        this.m = 22;
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.d = new ScaleGestureDetector(context, this);
        this.j = (double) ViewConfiguration.get(context).getScaledTouchSlop();
        setOnTouchListener(this);
        if (q == null) {
            q = this;
        }
    }

    public Bitmap a() {
        int width = getWidth();
        int max = Math.max(getHeight(), 0);
        Bitmap createBitmap = Bitmap.createBitmap(Math.max(width, 0), max, Bitmap.Config.ARGB_8888);
        draw(new Canvas(createBitmap));
        if (ClipBoxView.getInstance() == null) {
            return null;
        }
        Rect rect = ClipBoxView.getInstance().getmFrameRectF();
        int i2 = rect.left;
        int i3 = rect.top;
        int max2 = Math.max(i3, 0);
        int width2 = rect.width();
        int height = rect.height();
        int min = Math.min(Math.max(height, 0), max - max2);
        Log.e("ZoomImageView", String.format("second origin: (%d,%d,%d,%d); fix: (%d,%d,%d,%d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(width2), Integer.valueOf(height), Integer.valueOf(Math.max(i2, 0)), Integer.valueOf(max2), Integer.valueOf(Math.max(width2, 0)), Integer.valueOf(min)}));
        return Bitmap.createBitmap(createBitmap, Math.max(i2, 0), max2, Math.max(width2, 0), min);
    }
}
