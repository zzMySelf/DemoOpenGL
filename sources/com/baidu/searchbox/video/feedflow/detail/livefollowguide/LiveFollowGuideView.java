package com.baidu.searchbox.video.feedflow.detail.livefollowguide;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.detail.followguide.FollowGuideUtil;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\u001dJ\u0015\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010$R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u0019\u0010\u0016R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/livefollowguide/LiveFollowGuideView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgChangeAnimator", "Landroid/animation/ValueAnimator;", "hideAnimator", "mCornerRadius", "", "getMCornerRadius", "()F", "mCornerRadius$delegate", "Lkotlin/Lazy;", "mGradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "mHeight", "getMHeight", "()I", "mHeight$delegate", "mTopMargin", "getMTopMargin", "mTopMargin$delegate", "showAnimator", "changeBackgroundWithAnim", "", "hideWithAnim", "resetView", "setFollowedStyle", "showWithAnim", "updateWidth", "summaryWidth", "(Ljava/lang/Integer;)V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveFollowGuideView.kt */
public final class LiveFollowGuideView extends AppCompatTextView {
    private ValueAnimator bgChangeAnimator;
    private ValueAnimator hideAnimator;
    private final Lazy mCornerRadius$delegate;
    private GradientDrawable mGradientDrawable;
    private final Lazy mHeight$delegate;
    private final Lazy mTopMargin$delegate;
    private ValueAnimator showAnimator;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LiveFollowGuideView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LiveFollowGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LiveFollowGuideView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveFollowGuideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mHeight$delegate = BdPlayerUtils.lazyNone(new LiveFollowGuideView$mHeight$2(context));
        this.mTopMargin$delegate = BdPlayerUtils.lazyNone(new LiveFollowGuideView$mTopMargin$2(context));
        this.mCornerRadius$delegate = BdPlayerUtils.lazyNone(new LiveFollowGuideView$mCornerRadius$2(context));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setGravity(17);
        setHeight(getMHeight());
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
        setTextSize(0, context.getResources().getDimension(R.dimen.F_T_X003));
        setTextColor(ContextCompat.getColor(context, R.color.FC410));
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable $this$_init__u24lambda_u2d0 = gradientDrawable;
        this.mGradientDrawable = $this$_init__u24lambda_u2d0;
        $this$_init__u24lambda_u2d0.setCornerRadius(getMCornerRadius());
        $this$_init__u24lambda_u2d0.setColor(ContextCompat.getColor(context, R.color.FC413));
        setBackground(gradientDrawable);
    }

    private final int getMHeight() {
        return ((Number) this.mHeight$delegate.getValue()).intValue();
    }

    private final int getMTopMargin() {
        return ((Number) this.mTopMargin$delegate.getValue()).intValue();
    }

    private final float getMCornerRadius() {
        return ((Number) this.mCornerRadius$delegate.getValue()).floatValue();
    }

    public final void setFollowedStyle() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.bgChangeAnimator;
        boolean z = true;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            z = false;
        }
        if (z && (valueAnimator = this.bgChangeAnimator) != null) {
            valueAnimator.cancel();
        }
        GradientDrawable gradientDrawable = this.mGradientDrawable;
        if (gradientDrawable != null) {
            GradientDrawable $this$setFollowedStyle_u24lambda_u2d1 = gradientDrawable;
            $this$setFollowedStyle_u24lambda_u2d1.setCornerRadius(getMCornerRadius());
            $this$setFollowedStyle_u24lambda_u2d1.setColor(ContextCompat.getColor(getContext(), R.color.FC413));
        } else {
            gradientDrawable = null;
        }
        setBackground(gradientDrawable);
    }

    public final void showWithAnim() {
        setVisibility(0);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = getMTopMargin();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ValueAnimator it = ofFloat;
        it.setDuration(800);
        it.addUpdateListener(new LiveFollowGuideView$$ExternalSyntheticLambda1(this));
        this.showAnimator = it;
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: showWithAnim$lambda-4$lambda-3  reason: not valid java name */
    public static final void m11648showWithAnim$lambda4$lambda3(LiveFollowGuideView this$0, ValueAnimator animation) {
        String obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue != null && (obj = animatedValue.toString()) != null) {
            float value = Float.parseFloat(obj);
            LiveFollowGuideView $this$showWithAnim_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2 = this$0;
            $this$showWithAnim_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.setTranslationY(((float) $this$showWithAnim_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.getMHeight()) - (((float) $this$showWithAnim_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.getMHeight()) * value));
            $this$showWithAnim_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.setHeight((int) (((float) $this$showWithAnim_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.getMHeight()) * value));
            ViewGroup.LayoutParams layoutParams = $this$showWithAnim_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((float) $this$showWithAnim_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.getMTopMargin()) * value);
            }
            $this$showWithAnim_u24lambda_u2d4_u24lambda_u2d3_u24lambda_u2d2.setAlpha(value);
        }
    }

    public final void hideWithAnim() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.showAnimator;
        boolean z = true;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            z = false;
        }
        if (z && (valueAnimator = this.showAnimator) != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ValueAnimator it = ofFloat;
        it.setStartDelay(300);
        it.setDuration(240);
        it.addUpdateListener(new LiveFollowGuideView$$ExternalSyntheticLambda0(this));
        this.hideAnimator = it;
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: hideWithAnim$lambda-8$lambda-7  reason: not valid java name */
    public static final void m11647hideWithAnim$lambda8$lambda7(LiveFollowGuideView this$0, ValueAnimator animation) {
        String obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue != null && (obj = animatedValue.toString()) != null) {
            float value = Float.parseFloat(obj);
            LiveFollowGuideView $this$hideWithAnim_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d6 = this$0;
            $this$hideWithAnim_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d6.setHeight((int) (((float) $this$hideWithAnim_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d6.getMHeight()) * value));
            ViewGroup.LayoutParams layoutParams = $this$hideWithAnim_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d6.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((float) $this$hideWithAnim_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d6.getMTopMargin()) * value);
            }
            if (value == 0.0f) {
                $this$hideWithAnim_u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d6.setVisibility(8);
            }
        }
    }

    public final void changeBackgroundWithAnim() {
        int startColor = ContextCompat.getColor(getContext(), com.baidu.searchbox.video.feedflow.component.R.color.video_flow_follow_btn_bg_start_color);
        int endColor = ContextCompat.getColor(getContext(), com.baidu.searchbox.video.feedflow.component.R.color.video_flow_follow_btn_bg_end_color);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ValueAnimator it = ofFloat;
        it.setDuration(600);
        it.addUpdateListener(new LiveFollowGuideView$$ExternalSyntheticLambda2(this, startColor, endColor));
        this.bgChangeAnimator = it;
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: changeBackgroundWithAnim$lambda-12$lambda-11  reason: not valid java name */
    public static final void m11646changeBackgroundWithAnim$lambda12$lambda11(LiveFollowGuideView this$0, int $startColor, int $endColor, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue != null) {
            float currentValue = ((Float) animatedValue).floatValue();
            GradientDrawable $this$changeBackgroundWithAnim_u24lambda_u2d12_u24lambda_u2d11_u24lambda_u2d10 = this$0.mGradientDrawable;
            if ($this$changeBackgroundWithAnim_u24lambda_u2d12_u24lambda_u2d11_u24lambda_u2d10 != null) {
                $this$changeBackgroundWithAnim_u24lambda_u2d12_u24lambda_u2d11_u24lambda_u2d10.setColor(FollowGuideUtil.INSTANCE.getCurrentColor(currentValue, $startColor, $endColor));
            } else {
                $this$changeBackgroundWithAnim_u24lambda_u2d12_u24lambda_u2d11_u24lambda_u2d10 = null;
            }
            this$0.setBackground($this$changeBackgroundWithAnim_u24lambda_u2d12_u24lambda_u2d11_u24lambda_u2d10);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public final void updateWidth(Integer summaryWidth) {
        if (summaryWidth != null && summaryWidth.intValue() > 0) {
            ViewGroup.LayoutParams $this$updateWidth_u24lambda_u2d14 = getLayoutParams();
            $this$updateWidth_u24lambda_u2d14.width = summaryWidth.intValue();
            setLayoutParams($this$updateWidth_u24lambda_u2d14);
        }
    }

    public final void resetView() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        ValueAnimator valueAnimator3;
        ValueAnimator valueAnimator4 = this.showAnimator;
        boolean z = true;
        if ((valueAnimator4 != null && valueAnimator4.isRunning()) && (valueAnimator3 = this.showAnimator) != null) {
            valueAnimator3.cancel();
        }
        ValueAnimator valueAnimator5 = this.hideAnimator;
        if ((valueAnimator5 != null && valueAnimator5.isRunning()) && (valueAnimator2 = this.hideAnimator) != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimator6 = this.bgChangeAnimator;
        if (valueAnimator6 == null || !valueAnimator6.isRunning()) {
            z = false;
        }
        if (z && (valueAnimator = this.bgChangeAnimator) != null) {
            valueAnimator.cancel();
        }
        GradientDrawable gradientDrawable = this.mGradientDrawable;
        if (gradientDrawable != null) {
            GradientDrawable $this$resetView_u24lambda_u2d15 = gradientDrawable;
            $this$resetView_u24lambda_u2d15.setCornerRadius(getMCornerRadius());
            $this$resetView_u24lambda_u2d15.setColor(ContextCompat.getColor(getContext(), R.color.FC413));
        } else {
            gradientDrawable = null;
        }
        setBackground(gradientDrawable);
    }
}
