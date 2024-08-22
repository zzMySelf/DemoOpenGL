package com.baidu.wallet.personal.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.tera.scan.app.R$styleable;

public class ScanningRoundView extends View {
    public int a;
    public Bitmap b;
    public Bitmap c;
    public Paint d;
    public Paint e;
    public float f;
    public float g;
    public float h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f3647i;
    public PorterDuffXfermode j;
    public int k;
    public int l;
    public int m;
    public long n;

    public ScanningRoundView(Context context) {
        super(context);
        this.a = 1000;
        this.m = -1;
        this.n = 0;
        b();
    }

    public ScanningRoundView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanningRoundView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 1000;
        this.m = -1;
        this.n = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScanningRoundView);
        this.k = obtainStyledAttributes.getResourceId(1, ResUtils.drawable(context, "button_blink"));
        this.l = obtainStyledAttributes.getDimensionPixelOffset(2, 7);
        this.a = obtainStyledAttributes.getInteger(0, this.a);
        obtainStyledAttributes.recycle();
        b();
    }

    private void a() {
        int width = getWidth();
        int height = getHeight();
        if (width == 0) {
            width = DisplayUtils.dip2px(getContext(), 208.0f);
        }
        if (height == 0) {
            height = DisplayUtils.dip2px(getContext(), 52.0f);
        }
        this.c = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        new Canvas(this.c).drawRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), (float) DisplayUtils.dip2px(getContext(), (float) this.l), (float) DisplayUtils.dip2px(getContext(), (float) this.l), this.e);
    }

    private void b() {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.k);
        this.b = decodeResource;
        float f2 = (float) (-decodeResource.getWidth());
        this.g = f2;
        this.f = f2;
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setDither(true);
        this.d.setFilterBitmap(true);
        Paint paint2 = new Paint(1);
        this.e = paint2;
        paint2.setDither(true);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setColor(-1);
        this.e.setFilterBitmap(true);
        this.j = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    /* access modifiers changed from: private */
    public void c() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.g, this.h});
        this.f3647i = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f3647i.setDuration((long) this.a);
        this.f3647i.setRepeatCount(this.m);
        this.f3647i.setStartDelay(this.n);
        this.f3647i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = ScanningRoundView.this.f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ScanningRoundView.this.postInvalidate();
            }
        });
    }

    public void a(int i2, int i3) {
        Bitmap bitmap = this.b;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = this.b.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(((float) i2) / ((float) width), ((float) i3) / ((float) height));
            this.b = Bitmap.createBitmap(this.b, 0, 0, width, height, matrix, true);
        }
    }

    public void a(final AnimatorListenerAdapter animatorListenerAdapter) {
        post(new Runnable() {
            public void run() {
                if (ScanningRoundView.this.f3647i == null) {
                    ScanningRoundView.this.c();
                } else if (ScanningRoundView.this.f3647i.isRunning()) {
                    ScanningRoundView.this.f3647i.cancel();
                }
                ScanningRoundView.this.f3647i.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                        AnimatorListenerAdapter animatorListenerAdapter = animatorListenerAdapter;
                        if (animatorListenerAdapter != null) {
                            animatorListenerAdapter.onAnimationCancel(animator);
                        }
                    }

                    public void onAnimationEnd(Animator animator) {
                        AnimatorListenerAdapter animatorListenerAdapter = animatorListenerAdapter;
                        if (animatorListenerAdapter != null) {
                            animatorListenerAdapter.onAnimationEnd(animator);
                        }
                    }

                    public void onAnimationRepeat(Animator animator) {
                        AnimatorListenerAdapter animatorListenerAdapter = animatorListenerAdapter;
                        if (animatorListenerAdapter != null) {
                            animatorListenerAdapter.onAnimationRepeat(animator);
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        AnimatorListenerAdapter animatorListenerAdapter = animatorListenerAdapter;
                        if (animatorListenerAdapter != null) {
                            animatorListenerAdapter.onAnimationStart(animator);
                        }
                    }
                });
                ScanningRoundView.this.f3647i.start();
            }
        });
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f3647i;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f3647i.cancel();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.d, 31);
        canvas.drawBitmap(this.b, this.f, 0.0f, this.d);
        this.d.setXfermode(this.j);
        canvas.drawBitmap(this.c, 0.0f, 0.0f, this.d);
        this.d.setXfermode((Xfermode) null);
        canvas.restoreToCount(saveLayer);
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a();
        this.h = (float) i2;
    }

    public void setAnimatorDuration(int i2) {
        this.a = i2;
    }

    public void setBlinkRepeatCount(int i2) {
        this.m = i2;
    }

    public void setBlinkStartDelay(long j2) {
        this.n = j2;
    }
}
