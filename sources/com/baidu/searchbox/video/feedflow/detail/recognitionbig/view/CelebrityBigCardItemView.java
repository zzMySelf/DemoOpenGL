package com.baidu.searchbox.video.feedflow.detail.recognitionbig.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\rH\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\rH\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\rH\u0016J\u0012\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u001aH\u0014J\u0006\u0010(\u001a\u00020\u001aJ\u0006\u0010)\u001a\u00020\u001aJ\u001e\u0010*\u001a\u00020\u001a2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,J\u0010\u0010.\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u000100J\u0006\u00101\u001a\u00020\u001aJ\b\u00102\u001a\u00020\u001aH\u0002R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00063"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/recognitionbig/view/CelebrityBigCardItemView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroid/animation/Animator$AnimatorListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animatorList", "", "Landroid/animation/Animator;", "getAnimatorList", "()Ljava/util/List;", "animatorList$delegate", "Lkotlin/Lazy;", "celebrityIconView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "loadingView", "Lcom/airbnb/lottie/LottieAnimationView;", "nameTextView", "Landroid/widget/TextView;", "onClickListener", "Lkotlin/Function0;", "", "getOnClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onAnimationCancel", "animation", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onClick", "v", "Landroid/view/View;", "onDetachedFromWindow", "play", "release", "setData", "icon", "", "name", "setLottieComposition", "lottie", "Lcom/airbnb/lottie/LottieComposition;", "setRealName", "switchToAvatar", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CelebrityBigCardItemView.kt */
public final class CelebrityBigCardItemView extends FrameLayout implements View.OnClickListener, Animator.AnimatorListener {
    private final Lazy animatorList$delegate;
    private final SimpleDraweeView celebrityIconView;
    private final LottieAnimationView loadingView;
    private final TextView nameTextView;
    private Function0<Unit> onClickListener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CelebrityBigCardItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CelebrityBigCardItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CelebrityBigCardItemView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CelebrityBigCardItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.animatorList$delegate = BdPlayerUtils.lazyNone(CelebrityBigCardItemView$animatorList$2.INSTANCE);
        LayoutInflater.from(context).inflate(R.layout.video_flow_celebrity_recognition_big_card_item_view, this);
        View findViewById = findViewById(R.id.celebrity_icon_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.celebrity_icon_view)");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById;
        this.celebrityIconView = simpleDraweeView;
        ((GenericDraweeHierarchy) simpleDraweeView.getHierarchy()).setUseGlobalColorFilter(false);
        View findViewById2 = findViewById(R.id.celebrity_icon_lottie);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.celebrity_icon_lottie)");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById2;
        this.loadingView = lottieAnimationView;
        View findViewById3 = findViewById(R.id.celebrity_name_view);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.celebrity_name_view)");
        TextView textView = (TextView) findViewById3;
        this.nameTextView = textView;
        simpleDraweeView.setOnClickListener(this);
        textView.setOnClickListener(this);
        lottieAnimationView.addAnimatorListener(this);
    }

    public final Function0<Unit> getOnClickListener() {
        return this.onClickListener;
    }

    public final void setOnClickListener(Function0<Unit> function0) {
        this.onClickListener = function0;
    }

    private final List<Animator> getAnimatorList() {
        return (List) this.animatorList$delegate.getValue();
    }

    public static /* synthetic */ void setData$default(CelebrityBigCardItemView celebrityBigCardItemView, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        celebrityBigCardItemView.setData(str, str2);
    }

    public final void setData(String icon, String name) {
        CharSequence charSequence = icon;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            this.celebrityIconView.setImageURI(icon);
        }
        CharSequence charSequence2 = name;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            z = true;
        }
        if (!z) {
            this.nameTextView.setTag(name);
        }
    }

    public final CelebrityBigCardItemView setLottieComposition(LottieComposition lottie) {
        CelebrityBigCardItemView $this$setLottieComposition_u24lambda_u2d0 = this;
        if (lottie != null) {
            $this$setLottieComposition_u24lambda_u2d0.loadingView.setComposition(lottie);
        }
        return this;
    }

    public final void play() {
        this.loadingView.playAnimation();
    }

    public void onClick(View v) {
        Function0<Unit> function0;
        if ((Intrinsics.areEqual((Object) v, (Object) this.celebrityIconView) || Intrinsics.areEqual((Object) v, (Object) this.nameTextView)) && (function0 = this.onClickListener) != null) {
            function0.invoke();
        }
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        setRealName();
        switchToAvatar();
        release();
    }

    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    private final void switchToAvatar() {
        getAnimatorList().clear();
        List<Animator> animatorList = getAnimatorList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.loadingView, View.ALPHA, new float[]{1.0f, 0.0f});
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(loadingView, View.ALPHA, 1f, 0f)");
        animatorList.add(ofFloat);
        List<Animator> animatorList2 = getAnimatorList();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.celebrityIconView, View.ALPHA, new float[]{0.5f, 1.0f});
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(celebrityIconView, View.ALPHA, 0.5f, 1f)");
        animatorList2.add(ofFloat2);
        this.celebrityIconView.setVisibility(0);
        AnimatorSet $this$switchToAvatar_u24lambda_u2d1 = new AnimatorSet();
        $this$switchToAvatar_u24lambda_u2d1.setDuration(240);
        $this$switchToAvatar_u24lambda_u2d1.playTogether(getAnimatorList());
        $this$switchToAvatar_u24lambda_u2d1.start();
    }

    public final void setRealName() {
        String it;
        Object tag = this.nameTextView.getTag();
        if (tag != null && (it = tag.toString()) != null) {
            this.nameTextView.setText(it);
        }
    }

    public final void release() {
        this.loadingView.cancelAnimation();
        this.loadingView.removeAnimatorListener(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }
}
