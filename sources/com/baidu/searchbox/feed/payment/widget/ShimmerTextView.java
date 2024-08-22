package com.baidu.searchbox.feed.payment.widget;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.baidu.searchbox.feed.payment.R;
import com.baidu.searchbox.ui.SelectorTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001c\u001a\u00020\u001aH\u0014J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J(\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0014J\u0006\u0010\u0018\u001a\u00020\u001aJ\u0006\u0010&\u001a\u00020\u001aJ\b\u0010'\u001a\u00020\u001aH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/baidu/searchbox/feed/payment/widget/ShimmerTextView;", "Lcom/baidu/searchbox/ui/SelectorTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "aspectRatio", "", "destRect", "Landroid/graphics/RectF;", "end", "expectedShimmerWidth", "marginSpan", "getMarginSpan", "()F", "marginSpan$delegate", "Lkotlin/Lazy;", "shimmerAnimator", "Landroid/animation/ValueAnimator;", "shimmerBitmap", "Landroid/graphics/Bitmap;", "shimmerPaint", "Landroid/graphics/Paint;", "start", "initAnimator", "", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "", "h", "oldw", "oldh", "stop", "stopAnimator", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShimmerTextView.kt */
public final class ShimmerTextView extends SelectorTextView {
    private float aspectRatio;
    private RectF destRect;
    private float end;
    private float expectedShimmerWidth;
    private final Lazy marginSpan$delegate;
    private ValueAnimator shimmerAnimator;
    private Bitmap shimmerBitmap;
    private Paint shimmerPaint;
    private float start;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShimmerTextView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShimmerTextView(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShimmerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint $this$shimmerPaint_u24lambda_u2d0 = new Paint(1);
        $this$shimmerPaint_u24lambda_u2d0.setDither(true);
        this.shimmerPaint = $this$shimmerPaint_u24lambda_u2d0;
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.feed_pay_ic_shimmer);
        Intrinsics.checkNotNullExpressionValue(decodeResource, "decodeResource(resources…able.feed_pay_ic_shimmer)");
        this.shimmerBitmap = decodeResource;
        this.destRect = new RectF();
        this.marginSpan$delegate = LazyKt.lazy(ShimmerTextView$marginSpan$2.INSTANCE);
        this.aspectRatio = ((float) this.shimmerBitmap.getWidth()) / ((float) this.shimmerBitmap.getHeight());
    }

    private final float getMarginSpan() {
        return ((Number) this.marginSpan$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        float f2 = ((float) h2) * this.aspectRatio;
        this.expectedShimmerWidth = f2;
        this.start = -f2;
        this.end = ((float) w) + f2;
        this.destRect.bottom = (float) h2;
    }

    private final void initAnimator() {
        PropertyValuesHolder leftPropVH = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, new Keyframe[]{Keyframe.ofFloat(0.0f, this.start), Keyframe.ofFloat(0.642f, this.end), Keyframe.ofFloat(1.0f, this.end)});
        Intrinsics.checkNotNullExpressionValue(leftPropVH, "ofKeyframe(\n            …fFloat(1f, end)\n        )");
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{leftPropVH});
        ValueAnimator $this$initAnimator_u24lambda_u2d2 = ofPropertyValuesHolder;
        $this$initAnimator_u24lambda_u2d2.setInterpolator(new AccelerateDecelerateInterpolator());
        $this$initAnimator_u24lambda_u2d2.setDuration(ShimmerTextViewKt.ANIMATOR_DURATION);
        $this$initAnimator_u24lambda_u2d2.setRepeatCount(-1);
        $this$initAnimator_u24lambda_u2d2.setRepeatMode(1);
        $this$initAnimator_u24lambda_u2d2.addUpdateListener(new ShimmerTextView$$ExternalSyntheticLambda1(this));
        this.shimmerAnimator = ofPropertyValuesHolder;
    }

    /* access modifiers changed from: private */
    /* renamed from: initAnimator$lambda-2$lambda-1  reason: not valid java name */
    public static final void m19325initAnimator$lambda2$lambda1(ShimmerTextView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue != null) {
            float left = ((Float) animatedValue).floatValue();
            this$0.destRect.left = left;
            this$0.destRect.right = this$0.expectedShimmerWidth + left;
            this$0.postInvalidate();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public final void start() {
        post(new ShimmerTextView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: start$lambda-3  reason: not valid java name */
    public static final void m19326start$lambda3(ShimmerTextView this$0) {
        ValueAnimator valueAnimator;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ValueAnimator valueAnimator2 = this$0.shimmerAnimator;
        if (valueAnimator2 == null) {
            this$0.initAnimator();
        } else {
            boolean z = true;
            if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
                z = false;
            }
            if (z && (valueAnimator = this$0.shimmerAnimator) != null) {
                valueAnimator.cancel();
            }
        }
        ValueAnimator valueAnimator3 = this$0.shimmerAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }

    public final void stop() {
        stopAnimator();
        this.start = -this.expectedShimmerWidth;
        this.end = ((float) getWidth()) + this.expectedShimmerWidth;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.shimmerAnimator != null) {
            int sc = canvas.saveLayer(getMarginSpan(), 0.0f, ((float) getWidth()) - getMarginSpan(), (float) getHeight(), this.shimmerPaint);
            canvas.drawBitmap(this.shimmerBitmap, (Rect) null, this.destRect, this.shimmerPaint);
            canvas.restoreToCount(sc);
        }
    }

    private final void stopAnimator() {
        ValueAnimator valueAnimator = this.shimmerAnimator;
        boolean z = true;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            z = false;
        }
        if (z) {
            ValueAnimator valueAnimator2 = this.shimmerAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllUpdateListeners();
            }
            ValueAnimator valueAnimator3 = this.shimmerAnimator;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
            }
        }
        this.shimmerAnimator = null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimator();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        start();
    }
}
