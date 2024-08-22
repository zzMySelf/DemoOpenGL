package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.dxmpay.apollon.utils.ResUtils;

public class SuccessImageViewNew extends View {
    public static int ALLDegree = 359;
    public static int StatD = 310;
    public static String TAG = "SuccessImageViewNew";
    public PathMeasure a = new PathMeasure();
    public PathMeasure b = new PathMeasure();
    public Animation c;
    public Animation d;
    public Paint e;
    public float f;
    public float g;
    public float h;

    /* renamed from: i  reason: collision with root package name */
    public float f3632i;
    public final RectF j = new RectF();
    public Path k = new Path();
    public Path l;
    public Path m;
    public int n = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f3633o = (StatD / ALLDegree);
    public a p = null;

    public interface a {
        void a();
    }

    public SuccessImageViewNew(Context context) {
        super(context);
        a();
    }

    public int dip2px(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Path path;
        super.onDraw(canvas);
        if (this.h != 0.0f) {
            if (this.n == 1 && (path = this.m) != null) {
                canvas.drawPath(path, this.e);
            }
            canvas.drawPath(this.k, this.e);
            canvas.save();
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (getMeasuredWidth() > getMeasuredHeight()) {
            this.h = (float) getMeasuredHeight();
        } else {
            this.h = (float) getMeasuredWidth();
        }
        float f2 = this.h;
        this.f = f2 / 2.0f;
        this.g = f2 / 2.0f;
        this.f3632i = (f2 - ((float) dip2px(4.0f))) / 2.0f;
        b();
    }

    public void startAnimation(a aVar) {
        stopAnim();
        this.p = aVar;
        a(0.0f, 1.0f, 250);
    }

    public void stopAnim() {
        clearAnimation();
    }

    private void b() {
        if (this.h != 0.0f) {
            if (this.l == null) {
                RectF rectF = this.j;
                float f2 = this.f;
                float f3 = this.f3632i;
                rectF.left = f2 - f3;
                float f4 = this.g;
                rectF.top = f4 - f3;
                rectF.right = f2 + f3;
                rectF.bottom = f4 + f3;
                Path path = new Path();
                this.l = path;
                path.addArc(this.j, 0.0f, 320.0f);
                this.l.rLineTo(0.0f, 0.0f);
                this.b = new PathMeasure(this.l, false);
            }
            if (this.m == null) {
                PathMeasure pathMeasure = new PathMeasure(this.l, true);
                "path1 len" + pathMeasure.getLength();
                float[] fArr = new float[2];
                pathMeasure.getPosTan((pathMeasure.getLength() * 320.0f) / 359.0f, fArr, (float[]) null);
                "path1 pos" + fArr[0] + "  " + fArr[1];
                Path path2 = new Path();
                this.m = path2;
                float f5 = (this.f3632i * 3.0f) / 7.0f;
                path2.moveTo(this.f - f5, this.g - ((2.0f * f5) / 5.0f));
                this.m.lineTo(this.f, this.g + ((f5 * 3.0f) / 5.0f));
                this.m.rMoveTo(0.0f, 0.0f);
                this.m.lineTo(fArr[0], fArr[1]);
                this.a = new PathMeasure(this.m, false);
            }
        }
    }

    private void a() {
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setColor(ResUtils.getColor(getContext(), "wallet_fp_main_327de7"));
        this.e.setStrokeWidth((float) dip2px(4.0f));
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setStrokeJoin(Paint.Join.ROUND);
        this.e.setStrokeCap(Paint.Cap.ROUND);
    }

    public SuccessImageViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a(float f2, float f3, final long j2) {
        AnonymousClass1 r1 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SuccessImageViewNew successImageViewNew = SuccessImageViewNew.this;
                if (successImageViewNew.c != null) {
                    successImageViewNew.k.reset();
                    float length = SuccessImageViewNew.this.a.getLength();
                    float f2 = f * length;
                    SuccessImageViewNew successImageViewNew2 = SuccessImageViewNew.this;
                    successImageViewNew2.a.getSegment(0.0f, f2, successImageViewNew2.k, true);
                    String str = SuccessImageViewNew.TAG;
                    "length " + length + "currentLength " + f2;
                    SuccessImageViewNew.this.k.rLineTo(0.0f, 0.0f);
                }
                SuccessImageViewNew.this.invalidate();
            }
        };
        this.c = r1;
        r1.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                int unused = SuccessImageViewNew.this.n = 1;
                SuccessImageViewNew.this.b(0.0f, 1.0f, j2);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.c.setInterpolator(new AccelerateDecelerateInterpolator());
        this.c.setDuration(j2);
        this.c.setRepeatCount(0);
        startAnimation(this.c);
    }

    public SuccessImageViewNew(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    /* access modifiers changed from: private */
    public void b(float f2, float f3, long j2) {
        AnonymousClass3 r1 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SuccessImageViewNew successImageViewNew = SuccessImageViewNew.this;
                if (successImageViewNew.d != null) {
                    successImageViewNew.k.reset();
                    float length = SuccessImageViewNew.this.b.getLength();
                    float f2 = f * length;
                    SuccessImageViewNew successImageViewNew2 = SuccessImageViewNew.this;
                    successImageViewNew2.b.getSegment(length - f2, length, successImageViewNew2.k, true);
                    String str = SuccessImageViewNew.TAG;
                    "length " + length + "currentLengthCircle " + f2;
                    SuccessImageViewNew.this.k.rLineTo(0.0f, 0.0f);
                }
                SuccessImageViewNew.this.invalidate();
            }
        };
        this.d = r1;
        r1.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (SuccessImageViewNew.this.p != null) {
                    SuccessImageViewNew.this.p.a();
                    a unused = SuccessImageViewNew.this.p = null;
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.d.setInterpolator(new LinearInterpolator());
        this.d.setDuration(j2);
        this.d.setRepeatCount(0);
        startAnimation(this.d);
    }
}
