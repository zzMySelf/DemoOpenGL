package com.baidu.sapi2.views;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.sapi2.utils.SapiUtils;

public class ClipBoxView extends View {
    public static int H = 0;
    public static int I = 1;
    public static final int J = 1;
    public static final int K = 20;
    public static final int L = 4;
    public static final int M = -1;
    public static final int N = 1;
    public static final int O = 2;
    public static final int P = 3;
    public static final int Q = 4;
    public static final int R = 5;
    public static final int S = 6;
    public static final int T = 7;
    public static final int U = 8;
    public static final float V = 50.0f;
    public static final float W = 50.0f;
    public static final float a0 = 1.01f;
    public static final float b0 = 0.99f;
    public static ClipBoxView c0;
    public float A;
    public float B;
    public float C;
    public boolean D;
    public int E;
    public boolean F;
    public Context G;
    public Paint a;
    public Paint b;
    public int c;
    public int d;
    public RectF e;
    public RectF f;
    public float g;
    public float h;

    /* renamed from: i  reason: collision with root package name */
    public int f961i;
    public int j;
    public int k;
    public int l;
    public int m;
    public float n;

    /* renamed from: o  reason: collision with root package name */
    public ValueAnimator f962o;
    public float p;
    public float q;
    public float r;
    public float s;
    public boolean t;
    public float u;
    public float v;
    public float w;
    public float x;
    public float y;
    public float z;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float unused = ClipBoxView.this.n = Float.parseFloat(String.valueOf(valueAnimator.getAnimatedValue()));
            ClipBoxView.this.invalidate();
            ClipBoxView.this.c();
        }
    }

    public ClipBoxView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static void b() {
        c0 = null;
    }

    private boolean c(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        int i2 = this.l;
        if (i2 == 1) {
            float x2 = motionEvent.getX() - this.e.left;
            float y2 = motionEvent.getY();
            RectF rectF = this.e;
            float f2 = rectF.top;
            float f3 = (x2 + (y2 - f2)) / 2.0f;
            b(rectF.left + f3, f2 + f3, rectF.right, rectF.bottom);
        } else if (i2 == 2) {
            float x3 = this.e.right - motionEvent.getX();
            float y3 = motionEvent.getY();
            RectF rectF2 = this.e;
            float f4 = rectF2.top;
            float f5 = (x3 + (y3 - f4)) / 2.0f;
            b(rectF2.left, f4 + f5, rectF2.right - f5, rectF2.bottom);
        } else if (i2 == 3) {
            float x4 = motionEvent.getX();
            RectF rectF3 = this.e;
            float y4 = ((x4 - rectF3.left) + (rectF3.bottom - motionEvent.getY())) / 2.0f;
            RectF rectF4 = this.e;
            b(rectF4.left + y4, rectF4.top, rectF4.right, rectF4.bottom - y4);
        } else if (i2 != 4) {
            return false;
        } else {
            float x5 = ((this.e.right - motionEvent.getX()) + (this.e.bottom - motionEvent.getY())) / 2.0f;
            RectF rectF5 = this.e;
            b(rectF5.left, rectF5.top, rectF5.right - x5, rectF5.bottom - x5);
        }
        return true;
    }

    @TargetApi(11)
    private void d() {
        setLayerType(1, (Paint) null);
        this.a = new Paint();
        this.b = new Paint();
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth((float) SapiUtils.dip2px(getContext(), 1.0f));
        this.a.setAntiAlias(true);
        this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.b.setAntiAlias(true);
        this.c = SapiUtils.dip2px(getContext(), 20.0f);
        this.d = SapiUtils.dip2px(getContext(), 4.0f);
        this.f961i = SapiUtils.dip2px(getContext(), (float) this.f961i);
        this.k = SapiUtils.dip2px(getContext(), (float) this.k);
        this.m = SapiUtils.dip2px(getContext(), (float) this.m);
        this.e = new RectF();
        this.f = new RectF();
        this.E = I;
        this.F = true;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f962o = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f962o.addUpdateListener(new a());
    }

    public static ClipBoxView getInstance() {
        ClipBoxView clipBoxView = c0;
        if (clipBoxView != null) {
            return clipBoxView;
        }
        return null;
    }

    public Rect getmFrameRectF() {
        Rect rect = new Rect();
        RectF rectF = this.e;
        rect.left = (int) rectF.left;
        rect.right = (int) rectF.right;
        rect.top = (int) rectF.top;
        rect.bottom = (int) rectF.bottom;
        return rect;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int argb = Color.argb(180, 0, 0, 0);
        this.a.setStrokeWidth((float) SapiUtils.dip2px(getContext(), 1.0f));
        canvas.drawColor(argb);
        b(canvas);
        if (this.n == 1.0f) {
            this.t = false;
            this.D = false;
            this.n = 0.0f;
        }
        canvas.drawRect(this.e, this.b);
        if (this.D) {
            a(canvas);
        }
        c(canvas);
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Context context = this.G;
        if (context == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int dip2px = SapiUtils.dip2px(getContext(), 22.0f);
            this.f961i = dip2px;
            int i6 = i2 - (dip2px * 2);
            int i7 = (i3 - i6) / 2;
            this.j = i7;
            RectF rectF = this.e;
            float f2 = (float) dip2px;
            rectF.left = f2;
            float f3 = (float) i7;
            rectF.top = f3;
            float f4 = (float) i6;
            rectF.right = f2 + f4;
            rectF.bottom = f3 + f4;
            return;
        }
        int dip2px2 = SapiUtils.dip2px(getContext(), 0.0f);
        this.j = dip2px2;
        int dip2px3 = (i2 - ((i3 - (dip2px2 * 2)) - SapiUtils.dip2px(getContext(), 26.0f))) / 2;
        this.f961i = dip2px3;
        RectF rectF2 = this.e;
        float f5 = (float) dip2px3;
        rectF2.left = f5;
        float f6 = (float) this.j;
        rectF2.top = f6;
        float f7 = (float) (i2 - (dip2px3 * 2));
        rectF2.right = f5 + f7;
        rectF2.bottom = f6 + f7;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        if (r0 != 3) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            int r0 = r11.getAction()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x0039
            if (r0 == r5) goto L_0x0022
            if (r0 == r3) goto L_0x0012
            if (r0 == r2) goto L_0x0022
            goto L_0x0038
        L_0x0012:
            int r0 = r10.E
            int r1 = H
            if (r0 != r1) goto L_0x001d
            boolean r11 = r10.b((android.view.MotionEvent) r11)
            return r11
        L_0x001d:
            boolean r11 = r10.c((android.view.MotionEvent) r11)
            return r11
        L_0x0022:
            int r11 = r10.l
            if (r11 < r5) goto L_0x0030
            if (r11 > r1) goto L_0x0030
            boolean r11 = r10.F
            if (r11 == 0) goto L_0x0030
            r10.a()
            goto L_0x0035
        L_0x0030:
            r10.D = r4
            r10.invalidate()
        L_0x0035:
            r11 = -1
            r10.l = r11
        L_0x0038:
            return r4
        L_0x0039:
            r10.D = r5
            android.graphics.RectF r0 = r10.f
            float r6 = r11.getX()
            int r7 = r10.c
            float r7 = (float) r7
            float r6 = r6 - r7
            float r7 = r11.getY()
            int r8 = r10.c
            float r8 = (float) r8
            float r7 = r7 - r8
            float r8 = r11.getX()
            int r9 = r10.c
            float r9 = (float) r9
            float r8 = r8 + r9
            float r11 = r11.getY()
            int r9 = r10.c
            float r9 = (float) r9
            float r11 = r11 + r9
            r0.set(r6, r7, r8, r11)
            android.graphics.RectF r11 = r10.f
            android.graphics.RectF r0 = r10.e
            float r6 = r0.left
            float r0 = r0.top
            boolean r11 = r11.contains(r6, r0)
            if (r11 == 0) goto L_0x0071
            r10.l = r5
            return r5
        L_0x0071:
            android.graphics.RectF r11 = r10.f
            android.graphics.RectF r0 = r10.e
            float r6 = r0.right
            float r0 = r0.top
            boolean r11 = r11.contains(r6, r0)
            if (r11 == 0) goto L_0x0082
            r10.l = r3
            return r5
        L_0x0082:
            android.graphics.RectF r11 = r10.f
            android.graphics.RectF r0 = r10.e
            float r3 = r0.left
            float r0 = r0.bottom
            boolean r11 = r11.contains(r3, r0)
            if (r11 == 0) goto L_0x0093
            r10.l = r2
            return r5
        L_0x0093:
            android.graphics.RectF r11 = r10.f
            android.graphics.RectF r0 = r10.e
            float r2 = r0.right
            float r0 = r0.bottom
            boolean r11 = r11.contains(r2, r0)
            if (r11 == 0) goto L_0x00a4
            r10.l = r1
            return r5
        L_0x00a4:
            android.graphics.RectF r11 = r10.f
            android.graphics.RectF r0 = r10.e
            float r1 = r0.left
            float r2 = r0.top
            float r0 = r0.right
            boolean r11 = r11.intersect(r1, r2, r0, r2)
            if (r11 == 0) goto L_0x00b8
            r11 = 5
            r10.l = r11
            return r5
        L_0x00b8:
            android.graphics.RectF r11 = r10.f
            android.graphics.RectF r0 = r10.e
            float r1 = r0.left
            float r2 = r0.top
            float r0 = r0.bottom
            boolean r11 = r11.intersect(r1, r2, r1, r0)
            if (r11 == 0) goto L_0x00cc
            r11 = 6
            r10.l = r11
            return r5
        L_0x00cc:
            android.graphics.RectF r11 = r10.f
            android.graphics.RectF r0 = r10.e
            float r1 = r0.right
            float r2 = r0.top
            float r0 = r0.bottom
            boolean r11 = r11.intersect(r1, r2, r1, r0)
            if (r11 == 0) goto L_0x00e0
            r11 = 7
            r10.l = r11
            return r5
        L_0x00e0:
            android.graphics.RectF r11 = r10.f
            android.graphics.RectF r0 = r10.e
            float r1 = r0.left
            float r2 = r0.bottom
            float r0 = r0.right
            boolean r11 = r11.intersect(r1, r2, r0, r2)
            if (r11 == 0) goto L_0x00f5
            r11 = 8
            r10.l = r11
            return r5
        L_0x00f5:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.views.ClipBoxView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public ClipBoxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean b(MotionEvent motionEvent) {
        switch (this.l) {
            case 1:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                RectF rectF = this.e;
                b(x2, y2, rectF.right, rectF.bottom);
                return true;
            case 2:
                b(this.e.left, motionEvent.getY(), motionEvent.getX(), this.e.bottom);
                return true;
            case 3:
                float x3 = motionEvent.getX();
                RectF rectF2 = this.e;
                b(x3, rectF2.top, rectF2.right, motionEvent.getY());
                return true;
            case 4:
                RectF rectF3 = this.e;
                b(rectF3.left, rectF3.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 5:
                float f2 = this.e.left;
                float y3 = motionEvent.getY();
                RectF rectF4 = this.e;
                b(f2, y3, rectF4.right, rectF4.bottom);
                return true;
            case 6:
                float x4 = motionEvent.getX();
                RectF rectF5 = this.e;
                b(x4, rectF5.top, rectF5.right, rectF5.bottom);
                return true;
            case 7:
                RectF rectF6 = this.e;
                b(rectF6.left, rectF6.top, motionEvent.getX(), this.e.bottom);
                return true;
            case 8:
                RectF rectF7 = this.e;
                b(rectF7.left, rectF7.top, rectF7.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    public ClipBoxView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f961i = 22;
        this.k = 2;
        this.l = -1;
        this.m = 20;
        this.n = 0.0f;
        this.p = 0.0f;
        this.q = 0.0f;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = false;
        this.u = 0.0f;
        this.v = 0.0f;
        this.w = 0.0f;
        this.x = 0.0f;
        this.D = false;
        this.G = context;
        if (c0 == null) {
            c0 = this;
        }
        d();
    }

    public void a(Canvas canvas) {
        RectF rectF = this.e;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float f4 = rectF.right;
        float f5 = rectF.bottom;
        float f6 = (f5 - f3) / 3.0f;
        float f7 = f3 + f6;
        Canvas canvas2 = canvas;
        float f8 = f2;
        float f9 = f4;
        canvas2.drawLine(f8, f7, f9, f7, this.a);
        float f10 = f3 + (f6 * 2.0f);
        canvas2.drawLine(f8, f10, f9, f10, this.a);
        float f11 = (f4 - f2) / 3.0f;
        float f12 = f2 + f11;
        float f13 = f3;
        float f14 = f5;
        canvas2.drawLine(f12, f13, f12, f14, this.a);
        float f15 = f2 + (f11 * 2.0f);
        canvas2.drawLine(f15, f13, f15, f14, this.a);
    }

    private void a(float f2, float f3, float f4, float f5) {
        ZoomImageView instance = ZoomImageView.getInstance();
        if (instance != null) {
            RectF matrixRectF = instance.getMatrixRectF();
            f2 = Math.max(Math.max((float) this.m, f2), matrixRectF.left);
            f3 = Math.max(Math.max((float) this.m, f3), matrixRectF.top);
            f4 = Math.min(Math.min((float) (getWidth() - this.m), f4), matrixRectF.right);
            f5 = Math.min(Math.min((float) (getHeight() - this.m), f5), matrixRectF.bottom);
        }
        this.q = this.u - f3;
        this.s = f5 - this.v;
        this.p = this.w - f2;
        this.r = f4 - this.x;
        this.e.set(f2, f3, f4, f5);
    }

    private void b(float f2, float f3, float f4, float f5) {
        if (f5 - f3 < 50.0f) {
            RectF rectF = this.e;
            float f6 = rectF.top;
            f5 = rectF.bottom;
            f3 = f6;
        }
        if (f4 - f2 < 50.0f) {
            RectF rectF2 = this.e;
            float f7 = rectF2.left;
            f4 = rectF2.right;
            f2 = f7;
        }
        a(f2, f3, f4, f5);
        invalidate();
    }

    private void c(Canvas canvas) {
        this.a.setStrokeWidth((float) this.d);
        RectF rectF = this.e;
        float f2 = rectF.left;
        float f3 = rectF.top;
        canvas.drawLine(f2 - ((float) this.k), f3, f2 + ((float) this.c), f3, this.a);
        RectF rectF2 = this.e;
        float f4 = rectF2.left;
        float f5 = rectF2.top;
        canvas.drawLine(f4, f5, f4, f5 + ((float) this.c), this.a);
        RectF rectF3 = this.e;
        float f6 = rectF3.right;
        float f7 = rectF3.top;
        canvas.drawLine(f6 + ((float) this.k), f7, f6 - ((float) this.c), f7, this.a);
        RectF rectF4 = this.e;
        float f8 = rectF4.right;
        float f9 = rectF4.top;
        canvas.drawLine(f8, f9, f8, f9 + ((float) this.c), this.a);
        RectF rectF5 = this.e;
        float f10 = rectF5.left;
        float f11 = rectF5.bottom;
        canvas.drawLine(f10 - ((float) this.k), f11, f10 + ((float) this.c), f11, this.a);
        RectF rectF6 = this.e;
        float f12 = rectF6.left;
        float f13 = rectF6.bottom;
        canvas.drawLine(f12, f13, f12, f13 - ((float) this.c), this.a);
        RectF rectF7 = this.e;
        float f14 = rectF7.right;
        float f15 = rectF7.bottom;
        canvas.drawLine(f14 + ((float) this.k), f15, f14 - ((float) this.c), f15, this.a);
        RectF rectF8 = this.e;
        float f16 = rectF8.right;
        float f17 = rectF8.bottom;
        canvas.drawLine(f16, f17, f16, f17 - ((float) this.c), this.a);
    }

    private void b(Canvas canvas) {
        if (this.t) {
            RectF rectF = this.e;
            float f2 = this.w;
            float f3 = this.n;
            rectF.left = f2 - (this.p * f3);
            rectF.top = this.u - (this.q * f3);
            rectF.right = this.x + (this.r * f3);
            rectF.bottom = this.v + (f3 * this.s);
            canvas.drawRect(rectF, this.a);
            return;
        }
        canvas.drawRect(this.e, this.a);
    }

    private void a(float f2, float f3, float f4, float f5, float f6) {
        ZoomImageView instance = ZoomImageView.getInstance();
        if (instance != null) {
            RectF matrixRectF = instance.getMatrixRectF();
            f2 = Math.max(Math.max((float) this.m, f2), matrixRectF.left);
            f3 = Math.max(Math.max((float) this.m, f3), matrixRectF.top);
            f4 = Math.min(Math.min((float) (getWidth() - this.m), f4), matrixRectF.right);
            f5 = Math.min(Math.min((float) (getHeight() - this.m), f5), matrixRectF.bottom);
        }
        float f7 = f4 - f2;
        float f8 = f5 - f3;
        float f9 = f7 / f8;
        if (f9 > f6) {
            while (f9 / f6 > 1.01f) {
                f4 -= 1.0f;
                f2 += 1.0f;
                f9 = (f4 - f2) / f8;
            }
        } else {
            while (f9 / f6 < 0.99f) {
                f5 -= 1.0f;
                f3 += 1.0f;
                f9 = f7 / (f5 - f3);
            }
        }
        this.q = this.u - f3;
        this.s = f5 - this.v;
        this.p = this.w - f2;
        this.r = f4 - this.x;
        this.e.set(f2, f3, f4, f5);
    }

    /* access modifiers changed from: private */
    public void c() {
        ZoomImageView instance = ZoomImageView.getInstance();
        if (this.t && instance != null && instance.getScale() <= 12.0f) {
            float f2 = ((this.y - 1.0f) / 20.0f) + 1.0f;
            instance.e.postTranslate(this.B / 20.0f, this.C / 20.0f);
            Matrix matrix = instance.e;
            RectF rectF = this.e;
            matrix.postScale(f2, f2, (rectF.left + rectF.right) / 2.0f, (rectF.top + rectF.bottom) / 2.0f);
            RectF rectF2 = this.e;
            instance.a((rectF2.left + rectF2.right) / 2.0f, (rectF2.top + rectF2.bottom) / 2.0f);
            instance.setImageMatrix(instance.e);
        }
    }

    @TargetApi(11)
    private void a() {
        int width = getWidth() - (this.f961i * 2);
        RectF rectF = this.e;
        float f2 = rectF.right;
        float f3 = rectF.left;
        float f4 = f2 - f3;
        float f5 = (float) width;
        if (f4 < f5) {
            float f6 = rectF.top;
            this.u = f6;
            float f7 = rectF.bottom;
            this.v = f7;
            this.w = f3;
            this.x = f2;
            float f8 = (f2 - f3) / (f7 - f6);
            this.z = f5 / f4;
            RectF rectF2 = this.e;
            float height = ((float) (getHeight() - (this.m * 2))) / (rectF2.bottom - rectF2.top);
            this.A = height;
            float min = Math.min(this.z, height);
            this.y = min;
            float f9 = 1.0f;
            float f10 = min - 1.0f;
            if (f10 <= 1.0f) {
                f9 = f10;
            }
            RectF rectF3 = this.e;
            this.B = (((float) (getWidth() / 2)) - ((rectF3.left + rectF3.right) / 2.0f)) * f9;
            RectF rectF4 = this.e;
            float f11 = rectF4.top;
            float f12 = rectF4.bottom;
            this.C = (((float) (getHeight() / 2)) - ((f11 + f12) / 2.0f)) * f9;
            float f13 = rectF4.left;
            float f14 = this.y;
            float f15 = f13 / f14;
            rectF4.left = f15;
            float f16 = f11 / f14;
            rectF4.top = f16;
            float f17 = rectF4.right * f14;
            rectF4.right = f17;
            float f18 = f12 * f14;
            rectF4.bottom = f18;
            if (this.E == H) {
                a(f15, f16, f17, f18, f8);
            } else {
                int i2 = this.f961i;
                int i3 = this.j;
                a((float) i2, (float) i3, (float) (i2 + width), (float) (i3 + width));
            }
            this.f962o.setDuration(500).start();
            this.t = true;
            return;
        }
        this.D = false;
        invalidate();
    }

    private boolean a(MotionEvent motionEvent) {
        int width = getWidth() - (this.f961i * 2);
        RectF rectF = this.e;
        float f2 = (float) width;
        if (rectF.right - rectF.left < f2 || rectF.bottom - rectF.top < f2) {
            return false;
        }
        return motionEvent.getX() < ((float) this.f961i) || motionEvent.getX() > ((float) (this.f961i + width)) || motionEvent.getY() < ((float) this.j) || motionEvent.getY() > ((float) (this.j + width));
    }
}
