package com.baidu.searchbox.ad.lp.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.baidu.searchbox.ad.lp.reward.R;
import com.baidu.searchbox.ad.lp.reward.data.RewardData;
import com.baidu.searchbox.ad.lp.reward.util.MultipleStartCountDownTime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ui.RoundProgressBar;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ.\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\n2\f\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0016J\u0006\u0010:\u001a\u00020\nJ\u0012\u0010;\u001a\u0002022\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0010\u0010>\u001a\u0002022\u0006\u0010?\u001a\u00020@H\u0016J \u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u0002002\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u0002022\u0006\u0010G\u001a\u00020=H\u0016J\b\u0010H\u001a\u000202H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b)\u0010&R\u0014\u0010+\u001a\u00020,8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/baidu/searchbox/ad/lp/reward/view/AdVideoRewardFloatView;", "Lcom/baidu/searchbox/ad/lp/reward/view/AbsRewardCountDownView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "countDownFinished", "", "ivArrow", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getIvArrow", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "ivArrow$delegate", "Lkotlin/Lazy;", "ivBubbleIcon", "getIvBubbleIcon", "ivBubbleIcon$delegate", "llBubbleContainer", "Landroid/widget/LinearLayout;", "getLlBubbleContainer", "()Landroid/widget/LinearLayout;", "llBubbleContainer$delegate", "lottieView", "Lcom/airbnb/lottie/LottieAnimationView;", "getLottieView", "()Lcom/airbnb/lottie/LottieAnimationView;", "lottieView$delegate", "progressBar", "Lcom/baidu/searchbox/ui/RoundProgressBar;", "getProgressBar", "()Lcom/baidu/searchbox/ui/RoundProgressBar;", "progressBar$delegate", "tvBubble", "Landroid/widget/TextView;", "getTvBubble", "()Landroid/widget/TextView;", "tvBubble$delegate", "tvTime", "getTvTime", "tvTime$delegate", "viewType", "Lcom/baidu/searchbox/ad/lp/reward/view/CountDownViewType;", "getViewType", "()Lcom/baidu/searchbox/ad/lp/reward/view/CountDownViewType;", "welfareData", "Lcom/baidu/searchbox/ad/lp/reward/data/RewardData;", "attachToViewGroup", "", "viewGroup", "Landroid/view/ViewGroup;", "index", "animation", "lp", "Lkotlin/Function0;", "Landroid/view/ViewGroup$MarginLayoutParams;", "isCountDownFinished", "loadLottieAnimation", "url", "", "setCountDownClickListener", "listener", "Landroid/view/View$OnClickListener;", "setData", "taskDuration", "rewardData", "callback", "Lcom/baidu/searchbox/ad/lp/reward/view/ICountDownCallback;", "showRewardTips", "tips", "updateUi", "lib-ad-lp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdVideoRewardFloatView.kt */
public final class AdVideoRewardFloatView extends AbsRewardCountDownView {
    public Map<Integer, View> _$_findViewCache;
    /* access modifiers changed from: private */
    public boolean countDownFinished;
    private final Lazy ivArrow$delegate;
    private final Lazy ivBubbleIcon$delegate;
    private final Lazy llBubbleContainer$delegate;
    private final Lazy lottieView$delegate;
    private final Lazy progressBar$delegate;
    private final Lazy tvBubble$delegate;
    private final Lazy tvTime$delegate;
    private RewardData welfareData;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdVideoRewardFloatView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdVideoRewardFloatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdVideoRewardFloatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.tvBubble$delegate = LazyKt.lazy(new AdVideoRewardFloatView$tvBubble$2(this));
        this.ivBubbleIcon$delegate = LazyKt.lazy(new AdVideoRewardFloatView$ivBubbleIcon$2(this));
        this.llBubbleContainer$delegate = LazyKt.lazy(new AdVideoRewardFloatView$llBubbleContainer$2(this));
        this.lottieView$delegate = LazyKt.lazy(new AdVideoRewardFloatView$lottieView$2(this));
        this.progressBar$delegate = LazyKt.lazy(new AdVideoRewardFloatView$progressBar$2(this));
        this.ivArrow$delegate = LazyKt.lazy(new AdVideoRewardFloatView$ivArrow$2(this));
        this.tvTime$delegate = LazyKt.lazy(new AdVideoRewardFloatView$tvTime$2(this));
        LayoutInflater.from(context).inflate(R.layout.ad_video_welfare_float, this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdVideoRewardFloatView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final TextView getTvBubble() {
        Object value = this.tvBubble$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvBubble>(...)");
        return (TextView) value;
    }

    private final SimpleDraweeView getIvBubbleIcon() {
        Object value = this.ivBubbleIcon$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ivBubbleIcon>(...)");
        return (SimpleDraweeView) value;
    }

    private final LinearLayout getLlBubbleContainer() {
        Object value = this.llBubbleContainer$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-llBubbleContainer>(...)");
        return (LinearLayout) value;
    }

    private final LottieAnimationView getLottieView() {
        Object value = this.lottieView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-lottieView>(...)");
        return (LottieAnimationView) value;
    }

    /* access modifiers changed from: private */
    public final RoundProgressBar getProgressBar() {
        Object value = this.progressBar$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-progressBar>(...)");
        return (RoundProgressBar) value;
    }

    private final SimpleDraweeView getIvArrow() {
        Object value = this.ivArrow$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ivArrow>(...)");
        return (SimpleDraweeView) value;
    }

    /* access modifiers changed from: private */
    public final TextView getTvTime() {
        Object value = this.tvTime$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvTime>(...)");
        return (TextView) value;
    }

    public CountDownViewType getViewType() {
        return CountDownViewType.CIRCLE;
    }

    public void setData(int taskDuration, RewardData rewardData, ICountDownCallback callback) {
        Intrinsics.checkNotNullParameter(rewardData, "rewardData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (taskDuration <= 0) {
            setVisibility(8);
            return;
        }
        setCountDownCallback(callback);
        this.welfareData = rewardData;
        long taskDurationMillis = TimeUnit.SECONDS.toMillis((long) taskDuration);
        getProgressBar().setMax((int) taskDurationMillis);
        getProgressBar().setProgress(0);
        this.countDownFinished = false;
        setCountDownTime(new AdVideoRewardFloatView$setData$1(taskDurationMillis, this).start());
        updateUi();
        setVisibility(0);
    }

    public final boolean isCountDownFinished() {
        if (getCountDownTime() == null) {
            return true;
        }
        MultipleStartCountDownTime countDownTime = getCountDownTime();
        Intrinsics.checkNotNull(countDownTime);
        if (countDownTime.getMillisUntilFinishedSubStartProgress() <= 0) {
            return true;
        }
        return false;
    }

    public void showRewardTips(String tips) {
        Intrinsics.checkNotNullParameter(tips, "tips");
        RewardData data = this.welfareData;
        String str = null;
        try {
            LinearLayout llBubbleContainer = getLlBubbleContainer();
            GradientDrawable gradientDrawable = new GradientDrawable();
            GradientDrawable $this$showRewardTips_u24lambda_u2d0 = gradientDrawable;
            $this$showRewardTips_u24lambda_u2d0.setCornerRadius(30.0f);
            int bgColor = Color.parseColor(data != null ? data.getBubbleBgColor() : null);
            $this$showRewardTips_u24lambda_u2d0.setColors(new int[]{bgColor, bgColor});
            llBubbleContainer.setBackground(gradientDrawable);
            TextView $this$showRewardTips_u24lambda_u2d1 = getTvBubble();
            $this$showRewardTips_u24lambda_u2d1.setText(tips);
            $this$showRewardTips_u24lambda_u2d1.setTextColor(Color.parseColor(data != null ? data.getBubbleTextColor() : null));
            getLlBubbleContainer().setVisibility(0);
            postDelayed(new AdVideoRewardFloatView$$ExternalSyntheticLambda0(this), 3000);
        } catch (Exception e2) {
            getLlBubbleContainer().setVisibility(4);
            if (AppConfig.isDebug()) {
                Toast.makeText(getContext(), "解析气泡数据失败：" + e2.getMessage(), 1).show();
            }
        }
        getIvArrow().setImageURI(data != null ? data.getBubbleArrow() : null);
        SimpleDraweeView ivBubbleIcon = getIvBubbleIcon();
        if (data != null) {
            str = data.getBubbleFrontIcon();
        }
        ivBubbleIcon.setImageURI(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: showRewardTips$lambda-2  reason: not valid java name */
    public static final void m14769showRewardTips$lambda2(AdVideoRewardFloatView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLlBubbleContainer().setVisibility(4);
        this$0.getIvArrow().setVisibility(4);
    }

    public void setCountDownClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getProgressBar().setOnClickListener(new AdVideoRewardFloatView$$ExternalSyntheticLambda1(listener));
    }

    /* access modifiers changed from: private */
    /* renamed from: setCountDownClickListener$lambda-3  reason: not valid java name */
    public static final void m14768setCountDownClickListener$lambda3(View.OnClickListener $listener, View it) {
        Intrinsics.checkNotNullParameter($listener, "$listener");
        $listener.onClick(it);
    }

    public void attachToViewGroup(ViewGroup viewGroup, int index, boolean animation, Function0<? extends ViewGroup.MarginLayoutParams> lp) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(lp, "lp");
        super.attachToViewGroup(viewGroup, index, animation, new AdVideoRewardFloatView$attachToViewGroup$1(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e A[Catch:{ Exception -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053 A[Catch:{ Exception -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059 A[Catch:{ Exception -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0066 A[Catch:{ Exception -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b A[Catch:{ Exception -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0076 A[Catch:{ Exception -> 0x00dd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateUi() {
        /*
            r12 = this;
            java.lang.String r0 = "context"
            r1 = 8
            r2 = 1
            com.baidu.searchbox.ad.lp.reward.data.RewardData r3 = r12.welfareData     // Catch:{ Exception -> 0x00dd }
            com.baidu.searchbox.ui.RoundProgressBar r4 = r12.getProgressBar()     // Catch:{ Exception -> 0x00dd }
            android.content.Context r5 = r12.getContext()     // Catch:{ Exception -> 0x00dd }
            int r6 = com.baidu.searchbox.ad.lp.reward.R.color.ad_welfare_countdown_progress_transparent     // Catch:{ Exception -> 0x00dd }
            int r5 = androidx.core.content.ContextCompat.getColor(r5, r6)     // Catch:{ Exception -> 0x00dd }
            r4.setCircleColor(r5)     // Catch:{ Exception -> 0x00dd }
            com.baidu.searchbox.ui.RoundProgressBar r4 = r12.getProgressBar()     // Catch:{ Exception -> 0x00dd }
            r5 = 0
            if (r3 == 0) goto L_0x0024
            java.lang.String r6 = r3.getProgressColor()     // Catch:{ Exception -> 0x00dd }
            goto L_0x0025
        L_0x0024:
            r6 = r5
        L_0x0025:
            int r6 = android.graphics.Color.parseColor(r6)     // Catch:{ Exception -> 0x00dd }
            r4.setCircleProgressColor(r6)     // Catch:{ Exception -> 0x00dd }
            boolean r4 = r12.countDownFinished     // Catch:{ Exception -> 0x00dd }
            if (r4 == 0) goto L_0x0038
            if (r3 == 0) goto L_0x003f
            java.lang.String r4 = r3.getCompleteLottieUrl()     // Catch:{ Exception -> 0x00dd }
            goto L_0x0040
        L_0x0038:
            if (r3 == 0) goto L_0x003f
            java.lang.String r4 = r3.getProgressLottieUrl()     // Catch:{ Exception -> 0x00dd }
            goto L_0x0040
        L_0x003f:
            r4 = r5
        L_0x0040:
            r12.loadLottieAnimation(r4)     // Catch:{ Exception -> 0x00dd }
            android.widget.TextView r4 = r12.getTvTime()     // Catch:{ Exception -> 0x00dd }
            android.view.View r4 = (android.view.View) r4     // Catch:{ Exception -> 0x00dd }
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L_0x0053
            java.lang.String r8 = r3.getCapsuleCompleteText()     // Catch:{ Exception -> 0x00dd }
            goto L_0x0054
        L_0x0053:
            r8 = r5
        L_0x0054:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x00dd }
            r9 = 0
            if (r8 == 0) goto L_0x0062
            int r8 = r8.length()     // Catch:{ Exception -> 0x00dd }
            if (r8 != 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r8 = r9
            goto L_0x0063
        L_0x0062:
            r8 = r2
        L_0x0063:
            r8 = r8 ^ r2
            if (r8 == 0) goto L_0x006b
            r4.setVisibility(r9)     // Catch:{ Exception -> 0x00dd }
            r5 = r4
            goto L_0x0071
        L_0x006b:
            r4.setVisibility(r1)     // Catch:{ Exception -> 0x00dd }
            r7 = r5
            android.view.View r7 = (android.view.View) r7     // Catch:{ Exception -> 0x00dd }
        L_0x0071:
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x00dd }
            if (r5 == 0) goto L_0x00d8
            r4 = r5
            r5 = 0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ Exception -> 0x00dd }
            int r6 = r3.getCapsuleTextColor()     // Catch:{ Exception -> 0x00dd }
            r4.setTextColor(r6)     // Catch:{ Exception -> 0x00dd }
            boolean r6 = r12.countDownFinished     // Catch:{ Exception -> 0x00dd }
            if (r6 == 0) goto L_0x0090
            java.lang.String r6 = r3.getCapsuleCompleteText()     // Catch:{ Exception -> 0x00dd }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00dd }
            r4.setText(r6)     // Catch:{ Exception -> 0x00dd }
        L_0x0090:
            android.graphics.drawable.GradientDrawable r6 = new android.graphics.drawable.GradientDrawable     // Catch:{ Exception -> 0x00dd }
            r6.<init>()     // Catch:{ Exception -> 0x00dd }
            r7 = r6
            r8 = 0
            android.graphics.drawable.GradientDrawable$Orientation r10 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT     // Catch:{ Exception -> 0x00dd }
            r7.setOrientation(r10)     // Catch:{ Exception -> 0x00dd }
            r10 = 2
            int[] r10 = new int[r10]     // Catch:{ Exception -> 0x00dd }
            int r11 = r3.getCapsuleStartColor()     // Catch:{ Exception -> 0x00dd }
            r10[r9] = r11     // Catch:{ Exception -> 0x00dd }
            int r11 = r3.getCapsuleEndColor()     // Catch:{ Exception -> 0x00dd }
            r10[r2] = r11     // Catch:{ Exception -> 0x00dd }
            r7.setColors(r10)     // Catch:{ Exception -> 0x00dd }
            r10 = 9
            android.content.Context r11 = r4.getContext()     // Catch:{ Exception -> 0x00dd }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)     // Catch:{ Exception -> 0x00dd }
            int r10 = com.baidu.searchbox.ad.util.ExtensionsKt.px(r10, r11)     // Catch:{ Exception -> 0x00dd }
            float r10 = (float) r10     // Catch:{ Exception -> 0x00dd }
            r7.setCornerRadius(r10)     // Catch:{ Exception -> 0x00dd }
            android.content.Context r10 = r4.getContext()     // Catch:{ Exception -> 0x00dd }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)     // Catch:{ Exception -> 0x00dd }
            int r0 = com.baidu.searchbox.ad.util.ExtensionsKt.px(r2, r10)     // Catch:{ Exception -> 0x00dd }
            int r10 = r3.getCapsuleBorderColor()     // Catch:{ Exception -> 0x00dd }
            r7.setStroke(r0, r10)     // Catch:{ Exception -> 0x00dd }
            android.graphics.drawable.Drawable r6 = (android.graphics.drawable.Drawable) r6     // Catch:{ Exception -> 0x00dd }
            r4.setBackground(r6)     // Catch:{ Exception -> 0x00dd }
        L_0x00d8:
            r12.setVisibility(r9)     // Catch:{ Exception -> 0x00dd }
            goto L_0x010c
        L_0x00dd:
            r0 = move-exception
            r12.setVisibility(r1)
            boolean r1 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r1 == 0) goto L_0x010c
            android.content.Context r1 = r12.getContext()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "解析进度条数据失败："
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = r0.getMessage()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            android.widget.Toast r1 = android.widget.Toast.makeText(r1, r3, r2)
            r1.show()
        L_0x010c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.ad.lp.reward.view.AdVideoRewardFloatView.updateUi():void");
    }

    private final void loadLottieAnimation(String url) {
        CharSequence charSequence = url;
        if (charSequence == null || charSequence.length() == 0) {
            getLottieView().setVisibility(8);
        } else {
            LottieCompositionFactory.fromUrl(getContext(), url, String.valueOf(url.hashCode())).addListener(new AdVideoRewardFloatView$$ExternalSyntheticLambda2(this)).addFailureListener(new AdVideoRewardFloatView$$ExternalSyntheticLambda3(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadLottieAnimation$lambda-7  reason: not valid java name */
    public static final void m14766loadLottieAnimation$lambda7(AdVideoRewardFloatView this$0, LottieComposition it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLottieView().setComposition(it);
        this$0.getLottieView().playAnimation();
        this$0.getLottieView().setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadLottieAnimation$lambda-8  reason: not valid java name */
    public static final void m14767loadLottieAnimation$lambda8(AdVideoRewardFloatView this$0, Throwable it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLottieView().setVisibility(8);
    }
}
