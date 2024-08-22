package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.dxmpay.apollon.utils.ResUtils;

public class PayLoadingImageViewNew extends View {
    public static String TAG = "PayLoadingImageViewNew";
    public PathMeasure a;
    public Paint b;
    public Paint c;
    public Path d;
    public int e;
    public int f;
    public int flag = 0;
    public int g;
    public final RectF h = new RectF();

    /* renamed from: i  reason: collision with root package name */
    public Path f3631i = new Path();
    public Animation j;
    public Handler k;
    public int strokeWidth = 4;

    public PayLoadingImageViewNew(Context context) {
        super(context);
        a();
    }

    public int dip2px(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i2 = this.g;
        if (i2 != 0) {
            if (this.d == null) {
                float dip2px = ((float) (i2 - dip2px((float) this.strokeWidth))) / 2.0f;
                RectF rectF = this.h;
                int i3 = this.e;
                rectF.left = ((float) i3) - dip2px;
                int i4 = this.f;
                rectF.top = ((float) i4) - dip2px;
                rectF.right = ((float) i3) + dip2px;
                rectF.bottom = ((float) i4) + dip2px;
                Path path = new Path();
                this.d = path;
                path.addArc(this.h, 225.0f, 359.9f);
                this.d.rLineTo(0.0f, 0.0f);
                this.a = new PathMeasure(this.d, false);
            }
            canvas.drawPath(this.f3631i, this.b);
            canvas.save();
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (getMeasuredWidth() > getHeight()) {
            this.g = getMeasuredHeight();
        } else {
            this.g = getMeasuredWidth();
        }
        int i4 = this.g;
        this.e = i4 / 2;
        this.f = i4 / 2;
    }

    public void startAnimation() {
        stopAnimation();
        this.flag = 0;
        a(0.0f, 1.0f, 800);
    }

    public void stopAnimation() {
        clearAnimation();
    }

    private void a() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setColor(ResUtils.getColor(getContext(), "wallet_fp_main_327de7"));
        this.b.setStrokeWidth((float) dip2px((float) this.strokeWidth));
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeJoin(Paint.Join.ROUND);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.c = paint2;
        paint2.setAntiAlias(true);
        this.c.setColor(-16777216);
        this.c.setStrokeWidth((float) dip2px((float) this.strokeWidth));
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeJoin(Paint.Join.ROUND);
        this.c.setStrokeCap(Paint.Cap.ROUND);
        this.k = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                PayLoadingImageViewNew.this.j.start();
                String str = PayLoadingImageViewNew.TAG;
            }
        };
    }

    public PayLoadingImageViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PayLoadingImageViewNew(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private Animation a(float f2, float f3, long j2) {
        AnonymousClass2 r1 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                PayLoadingImageViewNew payLoadingImageViewNew = PayLoadingImageViewNew.this;
                if (payLoadingImageViewNew.a != null) {
                    payLoadingImageViewNew.f3631i.reset();
                    float length = PayLoadingImageViewNew.this.a.getLength() * f;
                    PayLoadingImageViewNew payLoadingImageViewNew2 = PayLoadingImageViewNew.this;
                    if (payLoadingImageViewNew2.flag % 2 == 0) {
                        PathMeasure pathMeasure = payLoadingImageViewNew2.a;
                        pathMeasure.getSegment(pathMeasure.getLength() - length, PayLoadingImageViewNew.this.a.getLength(), PayLoadingImageViewNew.this.f3631i, true);
                    } else {
                        payLoadingImageViewNew2.a.getSegment(0.0f, length, payLoadingImageViewNew2.f3631i, true);
                    }
                    String str = PayLoadingImageViewNew.TAG;
                    "currentLength " + length;
                    PayLoadingImageViewNew.this.f3631i.rLineTo(0.0f, 0.0f);
                }
                PayLoadingImageViewNew.this.invalidate();
            }
        };
        this.j = r1;
        r1.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
                PayLoadingImageViewNew.this.flag++;
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.j.setInterpolator(new LinearInterpolator());
        this.j.setDuration(j2);
        this.j.setRepeatMode(2);
        this.j.setRepeatCount(-1);
        startAnimation(this.j);
        return this.j;
    }
}
