package com.baidu.searchbox.feed.widget.newsfeedback.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.home.tabs.extend.IHomeTabFun;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\u001a\u0010\u001f\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0003J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0003J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020\u00152\b\u0010)\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0010H\u0014J\u000e\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/baidu/searchbox/feed/widget/newsfeedback/view/BiserialFeedbackPopupView;", "Lcom/baidu/searchbox/feed/widget/newsfeedback/view/CommonFeedbackPopupView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "anchorPosition", "", "imgArrow", "Landroid/widget/ImageView;", "imgArrowHeight", "", "indicatorHeight", "indicatorView", "Lcom/baidu/searchbox/feed/widget/newsfeedback/view/FeedBiserialDislikeIndicator;", "indicatorWidth", "isUpArrow", "", "paramsArrow", "Landroid/widget/LinearLayout$LayoutParams;", "popViewHeight", "addToPopView", "", "popupViewHeight", "ctx", "popupView", "Landroid/widget/LinearLayout;", "getIndicatorAnimation", "Landroid/view/animation/Animation;", "getRightDirection", "getX", "getY", "initImgArrow", "initIndicatorView", "layoutLeft", "layoutRight", "onCreateContentView", "Landroid/view/View;", "anchor", "inflater", "Landroid/view/LayoutInflater;", "onStartContentViewAnimation", "enterAnim", "prepareAnimation", "Landroid/view/animation/AnimationSet;", "enter", "setAnchorLocationOnScreen", "locationOnScreen", "Companion", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BiserialFeedbackPopupView.kt */
public class BiserialFeedbackPopupView extends CommonFeedbackPopupView {
    private static final long ANIMATION_DURATION = 240;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int RIGHT_MARGIN_THRESHOLD = DeviceUtils.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 2.0f);
    private int[] anchorPosition = new int[2];
    private ImageView imgArrow;
    private int imgArrowHeight;
    private int indicatorHeight;
    private FeedBiserialDislikeIndicator indicatorView;
    private int indicatorWidth;
    private boolean isUpArrow = true;
    private LinearLayout.LayoutParams paramsArrow;
    private int popViewHeight;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/feed/widget/newsfeedback/view/BiserialFeedbackPopupView$Companion;", "", "()V", "ANIMATION_DURATION", "", "RIGHT_MARGIN_THRESHOLD", "", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BiserialFeedbackPopupView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BiserialFeedbackPopupView(Context context) {
        super(context);
    }

    public final void setAnchorLocationOnScreen(int[] locationOnScreen) {
        Intrinsics.checkNotNullParameter(locationOnScreen, "locationOnScreen");
        this.anchorPosition = locationOnScreen;
    }

    public View onCreateContentView(View anchor, LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context ctx = inflater.getContext();
        LinearLayout popupView = onCreateMainContentView(inflater);
        Intrinsics.checkNotNullExpressionValue(popupView, "popupView");
        initImgArrow(ctx, popupView);
        Intrinsics.checkNotNullExpressionValue(ctx, "ctx");
        initIndicatorView(ctx, popupView);
        popupView.measure(-2, -2);
        addToPopView(popupView.getMeasuredHeight(), ctx, popupView);
        ImageView imageView = this.imgArrow;
        if (imageView != null) {
            imageView.setLayoutParams(this.paramsArrow);
        }
        return popupView;
    }

    private final void addToPopView(int popupViewHeight, Context ctx, LinearLayout popupView) {
        IHomeTabFun it;
        int totalHeight = this.indicatorHeight + this.imgArrowHeight + popupViewHeight + ctx.getResources().getDimensionPixelOffset(R.dimen.dimens_6dp);
        this.popViewHeight = totalHeight;
        int screenHeight = DeviceUtils.ScreenInfo.getDisplayHeight(getContext());
        if (this.mIgnoreTabBar && (it = (IHomeTabFun) ServiceManager.getService(IHomeTabFun.SERVICE_REFERENCE)) != null) {
            screenHeight -= it.getBottomTabHeight();
        }
        if (totalHeight < screenHeight - this.anchorPosition[1]) {
            this.isUpArrow = true;
            ImageView imageView = this.imgArrow;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.feed_dislike_arrow_down);
            }
            if (getRightDirection()) {
                layoutRight(popupView);
            } else {
                layoutLeft(popupView);
            }
            LinearLayout.LayoutParams layoutParams = this.paramsArrow;
            if (layoutParams != null) {
                layoutParams.topMargin = ctx.getResources().getDimensionPixelOffset(R.dimen.dimens_6dp);
            }
            popupView.addView(this.imgArrow, 0);
            popupView.addView(this.indicatorView, 0);
            return;
        }
        this.isUpArrow = false;
        ImageView imageView2 = this.imgArrow;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.feed_dislike_arrow_up);
        }
        if (getRightDirection()) {
            layoutRight(popupView);
        } else {
            layoutLeft(popupView);
        }
        LinearLayout.LayoutParams layoutParams2 = this.paramsArrow;
        if (layoutParams2 != null) {
            layoutParams2.bottomMargin = ctx.getResources().getDimensionPixelOffset(R.dimen.dimens_6dp);
        }
        popupView.addView(this.imgArrow);
        popupView.addView(this.indicatorView);
    }

    private final boolean getRightDirection() {
        return this.anchorPosition[0] > DeviceUtils.ScreenInfo.getDisplayWidth(getContext()) / 2;
    }

    private final void layoutLeft(LinearLayout popupView) {
        LinearLayout.LayoutParams layoutParams = this.paramsArrow;
        Intrinsics.checkNotNull(layoutParams);
        layoutParams.gravity = 3;
        LinearLayout.LayoutParams layoutParams2 = this.paramsArrow;
        Intrinsics.checkNotNull(layoutParams2);
        layoutParams2.leftMargin = ((this.anchorPosition[0] - popupView.getPaddingLeft()) - (this.indicatorWidth / 2)) + RIGHT_MARGIN_THRESHOLD;
    }

    private final void layoutRight(LinearLayout popupView) {
        LinearLayout.LayoutParams layoutParams = this.paramsArrow;
        Intrinsics.checkNotNull(layoutParams);
        layoutParams.gravity = 5;
        LinearLayout.LayoutParams layoutParams2 = this.paramsArrow;
        Intrinsics.checkNotNull(layoutParams2);
        layoutParams2.rightMargin = (((DeviceUtils.ScreenInfo.getDisplayWidth(getContext()) - this.anchorPosition[0]) - popupView.getPaddingRight()) - (this.indicatorWidth / 2)) + RIGHT_MARGIN_THRESHOLD;
    }

    private final void initImgArrow(Context ctx, LinearLayout popupView) {
        ImageView imageView = new ImageView(ctx);
        this.imgArrow = imageView;
        Intrinsics.checkNotNull(imageView);
        imageView.setImageResource(R.drawable.feed_popup_arrow_up);
        ImageView imageView2 = this.imgArrow;
        Intrinsics.checkNotNull(imageView2);
        imageView2.measure(0, 0);
        ImageView imageView3 = this.imgArrow;
        Intrinsics.checkNotNull(imageView3);
        this.imgArrowHeight = imageView3.getMeasuredHeight();
        this.paramsArrow = new LinearLayout.LayoutParams(-2, -2);
    }

    private final void initIndicatorView(Context ctx, LinearLayout popupView) {
        FeedBiserialDislikeIndicator feedBiserialDislikeIndicator = new FeedBiserialDislikeIndicator(ctx);
        this.indicatorView = feedBiserialDislikeIndicator;
        Intrinsics.checkNotNull(feedBiserialDislikeIndicator);
        feedBiserialDislikeIndicator.measure(0, 0);
        FeedBiserialDislikeIndicator feedBiserialDislikeIndicator2 = this.indicatorView;
        Intrinsics.checkNotNull(feedBiserialDislikeIndicator2);
        this.indicatorHeight = feedBiserialDislikeIndicator2.getMeasuredHeight();
        FeedBiserialDislikeIndicator feedBiserialDislikeIndicator3 = this.indicatorView;
        Intrinsics.checkNotNull(feedBiserialDislikeIndicator3);
        this.indicatorWidth = feedBiserialDislikeIndicator3.getMeasuredWidth();
        LinearLayout.LayoutParams paramsIndicator = new LinearLayout.LayoutParams(-2, -2);
        paramsIndicator.gravity = 3;
        paramsIndicator.leftMargin = (this.anchorPosition[0] - popupView.getPaddingLeft()) - (this.indicatorWidth / 2);
        FeedBiserialDislikeIndicator feedBiserialDislikeIndicator4 = this.indicatorView;
        Intrinsics.checkNotNull(feedBiserialDislikeIndicator4);
        feedBiserialDislikeIndicator4.setLayoutParams(paramsIndicator);
    }

    /* access modifiers changed from: protected */
    public void onStartContentViewAnimation(Animation enterAnim) {
        if (enterAnim != null && getContentView() != null) {
            getContentView().clearAnimation();
            getContentView().startAnimation(enterAnim);
            FeedBiserialDislikeIndicator feedBiserialDislikeIndicator = this.indicatorView;
            if (feedBiserialDislikeIndicator != null) {
                feedBiserialDislikeIndicator.clearAnimation();
            }
            FeedBiserialDislikeIndicator feedBiserialDislikeIndicator2 = this.indicatorView;
            if (feedBiserialDislikeIndicator2 != null) {
                feedBiserialDislikeIndicator2.startAnimation(getIndicatorAnimation());
            }
        }
    }

    /* access modifiers changed from: protected */
    public AnimationSet prepareAnimation(boolean enter) {
        if (this.anchorPosition != null) {
            return createFeedStylePopupAnimation(enter, ((float) this.anchorPosition[0]) / ((float) DeviceUtils.ScreenInfo.getDisplayWidth(getContext())), this.isUpArrow ? 0.0f : 1.0f, enter ? 200 : 300);
        }
        AnimationSet animationSet = null;
        return null;
    }

    public int getY() {
        if (this.isUpArrow) {
            return this.anchorPosition[1] - (this.indicatorHeight / 2);
        }
        return (this.anchorPosition[1] - this.popViewHeight) + (this.indicatorHeight / 2);
    }

    public int getX() {
        return this.anchorPosition[0];
    }

    private final Animation getIndicatorAnimation() {
        AnimationSet animSet = new AnimationSet(false);
        ScaleAnimation animationScale = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, 1, 0.5f, 1, 0.5f);
        animationScale.setDuration(240);
        animSet.addAnimation(animationScale);
        AlphaAnimation animationAlpha = new AlphaAnimation(0.5f, 1.0f);
        animationAlpha.setDuration(240);
        animSet.addAnimation(animationAlpha);
        return animSet;
    }
}
