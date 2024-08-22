package com.baidu.sapi2.views.loadingview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tera.scan.app.R$styleable;
import org.apache.commons.lang3.StringUtils;

public class ShimmerFrameLayout extends FrameLayout {
    public static final String r = "ShimmerFrameLayout";
    public static final PorterDuffXfermode s = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    public Paint a;
    public Paint b;
    public d c;
    public e d;
    public Bitmap e;
    public Bitmap f;
    public boolean g;
    public int h;

    /* renamed from: i  reason: collision with root package name */
    public int f969i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;

    /* renamed from: o  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f970o;
    public ValueAnimator p;
    public Bitmap q;

    public enum MaskAngle {
        CW_0,
        CW_90,
        CW_180,
        CW_270
    }

    public enum MaskShape {
        LINEAR,
        RADIAL,
        WHITE_LINEAR
    }

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            boolean a2 = ShimmerFrameLayout.this.n;
            ShimmerFrameLayout.this.g();
            if (ShimmerFrameLayout.this.g || a2) {
                ShimmerFrameLayout.this.d();
            }
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            ShimmerFrameLayout shimmerFrameLayout = ShimmerFrameLayout.this;
            float f = 1.0f - max;
            shimmerFrameLayout.setMaskOffsetX((int) ((((float) shimmerFrameLayout.d.a) * f) + (((float) ShimmerFrameLayout.this.d.c) * max)));
            ShimmerFrameLayout shimmerFrameLayout2 = ShimmerFrameLayout.this;
            shimmerFrameLayout2.setMaskOffsetY((int) ((((float) shimmerFrameLayout2.d.b) * f) + (((float) ShimmerFrameLayout.this.d.d) * max)));
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        static {
            /*
                com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$MaskAngle[] r0 = com.baidu.sapi2.views.loadingview.ShimmerFrameLayout.MaskAngle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r1 = 1
                com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$MaskAngle r2 = com.baidu.sapi2.views.loadingview.ShimmerFrameLayout.MaskAngle.CW_0     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$MaskAngle r3 = com.baidu.sapi2.views.loadingview.ShimmerFrameLayout.MaskAngle.CW_90     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$MaskAngle r4 = com.baidu.sapi2.views.loadingview.ShimmerFrameLayout.MaskAngle.CW_180     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$MaskAngle r4 = com.baidu.sapi2.views.loadingview.ShimmerFrameLayout.MaskAngle.CW_270     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$MaskShape[] r3 = com.baidu.sapi2.views.loadingview.ShimmerFrameLayout.MaskShape.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                a = r3
                com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$MaskShape r4 = com.baidu.sapi2.views.loadingview.ShimmerFrameLayout.MaskShape.LINEAR     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$MaskShape r3 = com.baidu.sapi2.views.loadingview.ShimmerFrameLayout.MaskShape.RADIAL     // Catch:{ NoSuchFieldError -> 0x004e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$MaskShape r1 = com.baidu.sapi2.views.loadingview.ShimmerFrameLayout.MaskShape.WHITE_LINEAR     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.views.loadingview.ShimmerFrameLayout.c.<clinit>():void");
        }
    }

    public static class d {
        public static final int j = 1;
        public static final int k = 0;
        public MaskAngle a;
        public float b;
        public float c;
        public int d;
        public int e;
        public float f;
        public float g;
        public float h;

        /* renamed from: i  reason: collision with root package name */
        public MaskShape f971i;

        public d() {
        }

        public int a(int i2) {
            int i3 = this.e;
            return i3 > 0 ? i3 : (int) (((float) i2) * this.h);
        }

        public int b(int i2) {
            int i3 = this.d;
            return i3 > 0 ? i3 : (int) (((float) i2) * this.g);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }

        public int[] a() {
            int i2 = c.a[this.f971i.ordinal()];
            if (i2 == 2) {
                return new int[]{-16777216, -16777216, 0};
            }
            if (i2 != 3) {
                return new int[]{0, -16777216, -16777216, 0};
            }
            return new int[]{-16777216, 0, 0, -16777216};
        }

        public float[] b() {
            if (c.a[this.f971i.ordinal()] != 2) {
                return new float[]{Math.max(((1.0f - this.f) - this.c) / 2.0f, 0.0f), Math.max((1.0f - this.f) / 2.0f, 0.0f), Math.min((this.f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f + 1.0f) + this.c) / 2.0f, 1.0f)};
            }
            return new float[]{0.0f, Math.min(this.f, 1.0f), Math.min(this.f + this.c, 1.0f)};
        }
    }

    public static class e {
        public int a;
        public int b;
        public int c;
        public int d;

        public e() {
        }

        public void a(int i2, int i3, int i4, int i5) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.d = i5;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public ShimmerFrameLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    /* access modifiers changed from: private */
    public void g() {
        e();
        h();
        i();
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        return new a();
    }

    /* JADX WARNING: type inference failed for: r19v0 */
    /* JADX WARNING: type inference failed for: r9v11, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r11v2, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap getMaskBitmap() {
        /*
            r20 = this;
            r0 = r20
            android.graphics.Bitmap r1 = r0.q
            if (r1 == 0) goto L_0x0007
            return r1
        L_0x0007:
            com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$d r1 = r0.c
            int r2 = r20.getWidth()
            int r1 = r1.b(r2)
            com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$d r2 = r0.c
            int r3 = r20.getHeight()
            int r2 = r2.a(r3)
            android.graphics.Bitmap r3 = a((int) r1, (int) r2)     // Catch:{ OutOfMemoryError -> 0x00cc }
            r0.q = r3     // Catch:{ OutOfMemoryError -> 0x00cc }
            android.graphics.Canvas r4 = new android.graphics.Canvas
            android.graphics.Bitmap r3 = r0.q
            r4.<init>(r3)
            int[] r3 = com.baidu.sapi2.views.loadingview.ShimmerFrameLayout.c.a
            com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$d r5 = r0.c
            com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$MaskShape r5 = r5.f971i
            int r5 = r5.ordinal()
            r3 = r3[r5]
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            r7 = 2
            if (r3 == r7) goto L_0x0075
            int[] r3 = com.baidu.sapi2.views.loadingview.ShimmerFrameLayout.c.b
            com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$d r8 = r0.c
            com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$MaskAngle r8 = r8.a
            int r8 = r8.ordinal()
            r3 = r3[r8]
            r8 = 0
            if (r3 == r7) goto L_0x0058
            r9 = 3
            if (r3 == r9) goto L_0x0053
            r9 = 4
            if (r3 == r9) goto L_0x0051
            r9 = r1
            r3 = 0
            goto L_0x0056
        L_0x0051:
            r3 = r2
            goto L_0x0055
        L_0x0053:
            r8 = r1
            r3 = 0
        L_0x0055:
            r9 = 0
        L_0x0056:
            r10 = 0
            goto L_0x005b
        L_0x0058:
            r10 = r2
            r3 = 0
            r9 = 0
        L_0x005b:
            android.graphics.LinearGradient r19 = new android.graphics.LinearGradient
            float r12 = (float) r8
            float r13 = (float) r3
            float r14 = (float) r9
            float r15 = (float) r10
            com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$d r3 = r0.c
            int[] r16 = r3.a()
            com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$d r3 = r0.c
            float[] r17 = r3.b()
            android.graphics.Shader$TileMode r18 = android.graphics.Shader.TileMode.REPEAT
            r11 = r19
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
            goto L_0x009b
        L_0x0075:
            int r3 = r1 / 2
            int r8 = r2 / 2
            android.graphics.RadialGradient r19 = new android.graphics.RadialGradient
            float r10 = (float) r3
            float r11 = (float) r8
            int r3 = java.lang.Math.max(r1, r2)
            double r8 = (double) r3
            double r12 = java.lang.Math.sqrt(r5)
            double r8 = r8 / r12
            float r12 = (float) r8
            com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$d r3 = r0.c
            int[] r13 = r3.a()
            com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$d r3 = r0.c
            float[] r14 = r3.b()
            android.graphics.Shader$TileMode r15 = android.graphics.Shader.TileMode.REPEAT
            r9 = r19
            r9.<init>(r10, r11, r12, r13, r14, r15)
        L_0x009b:
            r3 = r19
            com.baidu.sapi2.views.loadingview.ShimmerFrameLayout$d r8 = r0.c
            float r8 = r8.b
            int r9 = r1 / 2
            float r9 = (float) r9
            int r10 = r2 / 2
            float r10 = (float) r10
            r4.rotate(r8, r9, r10)
            android.graphics.Paint r9 = new android.graphics.Paint
            r9.<init>()
            r9.setShader(r3)
            double r5 = java.lang.Math.sqrt(r5)
            int r3 = java.lang.Math.max(r1, r2)
            double r10 = (double) r3
            double r5 = r5 * r10
            int r3 = (int) r5
            int r3 = r3 / r7
            int r5 = -r3
            float r6 = (float) r5
            int r1 = r1 + r3
            float r7 = (float) r1
            int r2 = r2 + r3
            float r8 = (float) r2
            r5 = r6
            r4.drawRect(r5, r6, r7, r8, r9)
            android.graphics.Bitmap r1 = r0.q
            return r1
        L_0x00cc:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.views.loadingview.ShimmerFrameLayout.getMaskBitmap():android.graphics.Bitmap");
    }

    private Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        int width = getWidth();
        int height = getHeight();
        int i2 = c.a[this.c.f971i.ordinal()];
        int i3 = c.b[this.c.a.ordinal()];
        if (i3 == 2) {
            this.d.a(0, -height, 0, height);
        } else if (i3 == 3) {
            this.d.a(width, 0, -width, 0);
        } else if (i3 != 4) {
            this.d.a(-width, 0, width, 0);
        } else {
            this.d.a(0, height, 0, -height);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, (((float) this.j) / ((float) this.h)) + 1.0f});
        this.p = ofFloat;
        ofFloat.setDuration((long) (this.h + this.j));
        this.p.setRepeatCount(this.f969i);
        this.p.setRepeatMode(this.k);
        this.p.addUpdateListener(new b());
        return this.p;
    }

    private void h() {
        Bitmap bitmap = this.q;
        if (bitmap != null) {
            bitmap.recycle();
            this.q = null;
        }
    }

    private void i() {
        Bitmap bitmap = this.f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f = null;
        }
        Bitmap bitmap2 = this.e;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.e = null;
        }
    }

    private Bitmap j() {
        int width = getWidth();
        int height = getHeight();
        try {
            return a(width, height);
        } catch (OutOfMemoryError unused) {
            StringBuilder sb = new StringBuilder("ShimmerFrameLayout failed to create working bitmap");
            sb.append(" (width = ");
            sb.append(width);
            sb.append(", height = ");
            sb.append(height);
            sb.append(")\n\n");
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append(StringUtils.LF);
            }
            sb.toString();
            return null;
        }
    }

    private Bitmap k() {
        if (this.e == null) {
            this.e = j();
        }
        return this.e;
    }

    private Bitmap l() {
        if (this.f == null) {
            this.f = j();
        }
        return this.f;
    }

    /* access modifiers changed from: private */
    public void setMaskOffsetX(int i2) {
        if (this.l != i2) {
            this.l = i2;
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public void setMaskOffsetY(int i2) {
        if (this.m != i2) {
            this.m = i2;
            invalidate();
        }
    }

    public void dispatchDraw(Canvas canvas) {
        if (!this.n || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            a(canvas);
        }
    }

    public void e() {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.p.removeAllUpdateListeners();
            this.p.cancel();
        }
        this.p = null;
        this.n = false;
    }

    public void f() {
        setDuration(1200);
        setRepeatCount(-1);
        setRepeatDelay(0);
        setRepeatMode(1);
        d dVar = this.c;
        dVar.a = MaskAngle.CW_0;
        dVar.f971i = MaskShape.LINEAR;
        dVar.c = 0.5f;
        dVar.d = 0;
        dVar.e = 0;
        dVar.f = 0.0f;
        dVar.g = 1.0f;
        dVar.h = 1.0f;
        dVar.b = 340.0f;
        this.d = new e((a) null);
        setBaseAlpha(1.0f);
        g();
    }

    public MaskAngle getAngle() {
        return this.c.a;
    }

    public float getBaseAlpha() {
        return ((float) this.a.getAlpha()) / 255.0f;
    }

    public float getDropoff() {
        return this.c.c;
    }

    public int getDuration() {
        return this.h;
    }

    public int getFixedHeight() {
        return this.c.e;
    }

    public int getFixedWidth() {
        return this.c.d;
    }

    public float getIntensity() {
        return this.c.f;
    }

    public MaskShape getMaskShape() {
        return this.c.f971i;
    }

    public float getRelativeHeight() {
        return this.c.h;
    }

    public float getRelativeWidth() {
        return this.c.g;
    }

    public int getRepeatCount() {
        return this.f969i;
    }

    public int getRepeatDelay() {
        return this.j;
    }

    public int getRepeatMode() {
        return this.k;
    }

    public float getTilt() {
        return this.c.b;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f970o == null) {
            this.f970o = getLayoutListener();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f970o);
    }

    public void onDetachedFromWindow() {
        e();
        if (this.f970o != null) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.f970o);
            this.f970o = null;
        }
        super.onDetachedFromWindow();
    }

    public void setAngle(MaskAngle maskAngle) {
        this.c.a = maskAngle;
        g();
    }

    public void setAutoStart(boolean z) {
        this.g = z;
        g();
    }

    public void setBaseAlpha(float f2) {
        this.a.setAlpha((int) (a(0.0f, 1.0f, f2) * 255.0f));
        g();
    }

    public void setDropoff(float f2) {
        this.c.c = f2;
        g();
    }

    public void setDuration(int i2) {
        this.h = i2;
        g();
    }

    public void setFixedHeight(int i2) {
        this.c.e = i2;
        g();
    }

    public void setFixedWidth(int i2) {
        this.c.d = i2;
        g();
    }

    public void setIntensity(float f2) {
        this.c.f = f2;
        g();
    }

    public void setMaskShape(MaskShape maskShape) {
        this.c.f971i = maskShape;
        g();
    }

    public void setRelativeHeight(int i2) {
        this.c.h = (float) i2;
        g();
    }

    public void setRelativeWidth(int i2) {
        this.c.g = (float) i2;
        g();
    }

    public void setRepeatCount(int i2) {
        this.f969i = i2;
        g();
    }

    public void setRepeatDelay(int i2) {
        this.j = i2;
        g();
    }

    public void setRepeatMode(int i2) {
        this.k = i2;
        g();
    }

    public void setTilt(float f2) {
        this.c.b = f2;
        g();
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean c() {
        return this.g;
    }

    public void d() {
        if (!this.n) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300);
            this.n = true;
        }
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setWillNotDraw(false);
        this.c = new d((a) null);
        this.a = new Paint();
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setFilterBitmap(true);
        this.b.setXfermode(s);
        f();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShimmerFrameLayout, 0, 0);
            try {
                if (obtainStyledAttributes.hasValue(1)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(1, false));
                }
                if (obtainStyledAttributes.hasValue(2)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(2, 0.0f));
                }
                if (obtainStyledAttributes.hasValue(4)) {
                    setDuration(obtainStyledAttributes.getInt(4, 0));
                }
                if (obtainStyledAttributes.hasValue(10)) {
                    setRepeatCount(obtainStyledAttributes.getInt(10, 0));
                }
                if (obtainStyledAttributes.hasValue(11)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(11, 0));
                }
                if (obtainStyledAttributes.hasValue(12)) {
                    setRepeatMode(obtainStyledAttributes.getInt(12, 0));
                }
                if (obtainStyledAttributes.hasValue(0)) {
                    int i3 = obtainStyledAttributes.getInt(0, 0);
                    if (i3 == 90) {
                        this.c.a = MaskAngle.CW_90;
                    } else if (i3 == 180) {
                        this.c.a = MaskAngle.CW_180;
                    } else if (i3 != 270) {
                        this.c.a = MaskAngle.CW_0;
                    } else {
                        this.c.a = MaskAngle.CW_270;
                    }
                }
                if (obtainStyledAttributes.hasValue(13)) {
                    if (obtainStyledAttributes.getInt(13, 0) != 1) {
                        this.c.f971i = MaskShape.LINEAR;
                    } else {
                        this.c.f971i = MaskShape.RADIAL;
                    }
                }
                if (obtainStyledAttributes.hasValue(3)) {
                    this.c.c = obtainStyledAttributes.getFloat(3, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(6)) {
                    this.c.d = obtainStyledAttributes.getDimensionPixelSize(6, 0);
                }
                if (obtainStyledAttributes.hasValue(5)) {
                    this.c.e = obtainStyledAttributes.getDimensionPixelSize(5, 0);
                }
                if (obtainStyledAttributes.hasValue(7)) {
                    this.c.f = obtainStyledAttributes.getFloat(7, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(9)) {
                    this.c.g = obtainStyledAttributes.getFloat(9, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(8)) {
                    this.c.h = obtainStyledAttributes.getFloat(8, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(14)) {
                    this.c.b = obtainStyledAttributes.getFloat(14, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void c(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.dispatchDraw(canvas);
    }

    public void a(long j2) {
        if (!this.n) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(j2);
            this.n = true;
        }
    }

    public boolean b() {
        return this.n;
    }

    private void b(Canvas canvas) {
        Bitmap maskBitmap = getMaskBitmap();
        if (maskBitmap != null) {
            int i2 = this.l;
            canvas.clipRect(i2, this.m, maskBitmap.getWidth() + i2, this.m + maskBitmap.getHeight());
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(maskBitmap, (float) this.l, (float) this.m, this.b);
        }
    }

    public static float a(float f2, float f3, float f4) {
        return Math.min(f3, Math.max(f2, f4));
    }

    private boolean a(Canvas canvas) {
        Bitmap l2 = l();
        Bitmap k2 = k();
        if (l2 == null || k2 == null) {
            return false;
        }
        c(new Canvas(l2));
        canvas.drawBitmap(l2, 0.0f, 0.0f, this.a);
        b(new Canvas(k2));
        canvas.drawBitmap(k2, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    public static Bitmap a(int i2, int i3) {
        try {
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
    }
}
