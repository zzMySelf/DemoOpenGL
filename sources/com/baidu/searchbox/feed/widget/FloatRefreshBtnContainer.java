package com.baidu.searchbox.feed.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.nadcore.model.NadRotationPopModelKt;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.statistic.FeedStatisticCenter;
import com.baidu.searchbox.feed.tab.FeedNavigationAdapter;
import com.baidu.searchbox.feed.tab.interaction.tts.TTSPlayerAnimEvent;
import com.baidu.searchbox.feed.tab.interaction.tts.TTSPlayerEvent;
import com.baidu.searchbox.feed.tab.model.TabController;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import com.baidu.searchbox.music.MiniPlayerView;
import com.baidu.searchbox.rewardsystem.newtimer.constants.NewTimerConstants;
import com.baidu.webkit.internal.utils.NetWorkUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0006\u0010 \u001a\u00020\u001dJ\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\u0006\u0010$\u001a\u00020\u001dJ\u0006\u0010%\u001a\u00020\u001dJ\u000e\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u001dH\u0002J\u0006\u0010.\u001a\u00020\u001dJ\b\u0010/\u001a\u00020\u001dH\u0002J\b\u00100\u001a\u00020\u001dH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/baidu/searchbox/feed/widget/FloatRefreshBtnContainer;", "", "context", "Landroid/content/Context;", "tabAdapter", "Lcom/baidu/searchbox/feed/tab/FeedNavigationAdapter;", "(Landroid/content/Context;Lcom/baidu/searchbox/feed/tab/FeedNavigationAdapter;)V", "btnAvoidTtsOffset", "", "btnInAnim", "Landroid/animation/ObjectAnimator;", "btnInAnimDuration", "", "btnOnTtsDismissAnim", "btnOnTtsShowAnim", "btnOutAnim", "btnOutAnimDuration", "btnRefreshAnim", "btnRefreshAnimDuration", "btnTtsAnimDuration", "getContext", "()Landroid/content/Context;", "floatContainerView", "Landroid/view/View;", "floatRefreshImg", "Landroid/widget/ImageView;", "isTtsPanelShow", "", "attachToRootView", "", "rootView", "Landroid/view/ViewGroup;", "hide", "initAnim", "notifyFloatBtnRefresh", "onBtnClick", "onFontSizeChange", "onNightModeChanged", "onTtsPlayerAnimEvent", "ttsPlayerAnimEvent", "Lcom/baidu/searchbox/feed/tab/interaction/tts/TTSPlayerAnimEvent;", "onTtsPlayerEvent", "ttsPlayerEvent", "Lcom/baidu/searchbox/feed/tab/interaction/tts/TTSPlayerEvent;", "isShow", "resetTranslation", "show", "updateFontSize", "updateUi", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FloatRefreshBtnContainer.kt */
public final class FloatRefreshBtnContainer {
    private final float btnAvoidTtsOffset = ((float) FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.feed_float_refresh_btn_avoid_tts_offset));
    private ObjectAnimator btnInAnim;
    private final long btnInAnimDuration = 400;
    private ObjectAnimator btnOnTtsDismissAnim;
    private ObjectAnimator btnOnTtsShowAnim;
    private ObjectAnimator btnOutAnim;
    private final long btnOutAnimDuration = 240;
    private ObjectAnimator btnRefreshAnim;
    private final long btnRefreshAnimDuration = 800;
    private final long btnTtsAnimDuration = 300;
    private final Context context;
    /* access modifiers changed from: private */
    public final View floatContainerView;
    private final ImageView floatRefreshImg;
    private boolean isTtsPanelShow;
    private final FeedNavigationAdapter tabAdapter;

    public FloatRefreshBtnContainer(Context context2, FeedNavigationAdapter tabAdapter2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(tabAdapter2, "tabAdapter");
        this.context = context2;
        this.tabAdapter = tabAdapter2;
        View inflate = View.inflate(context2, R.layout.feed_float_refresh_btn, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou…_float_refresh_btn, null)");
        this.floatContainerView = inflate;
        View findViewById = inflate.findViewById(R.id.feed_float_refresh_img);
        Intrinsics.checkNotNullExpressionValue(findViewById, "floatContainerView.findV…d.feed_float_refresh_img)");
        this.floatRefreshImg = (ImageView) findViewById;
        updateUi();
        initAnim();
        inflate.setOnClickListener(new FloatRefreshBtnContainer$$ExternalSyntheticLambda0(this));
    }

    public final Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m19739_init_$lambda0(FloatRefreshBtnContainer this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBtnClick();
    }

    private final void initAnim() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.floatContainerView, "alpha", new float[]{1.0f});
        ObjectAnimator $this$initAnim_u24lambda_u2d1 = ofFloat;
        $this$initAnim_u24lambda_u2d1.setDuration(this.btnInAnimDuration);
        $this$initAnim_u24lambda_u2d1.addListener(new FloatRefreshBtnContainer$initAnim$1$1(this));
        this.btnInAnim = ofFloat;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.floatContainerView, "alpha", new float[]{0.0f});
        ObjectAnimator $this$initAnim_u24lambda_u2d2 = ofFloat2;
        $this$initAnim_u24lambda_u2d2.setDuration(this.btnOutAnimDuration);
        $this$initAnim_u24lambda_u2d2.addListener(new FloatRefreshBtnContainer$initAnim$2$1(this));
        this.btnOutAnim = ofFloat2;
        ObjectAnimator $this$initAnim_u24lambda_u2d3 = ObjectAnimator.ofFloat(this.floatRefreshImg, NadRotationPopModelKt.ROTATION, new float[]{0.0f, 720.0f});
        $this$initAnim_u24lambda_u2d3.setDuration(this.btnRefreshAnimDuration);
        this.btnRefreshAnim = $this$initAnim_u24lambda_u2d3;
        ObjectAnimator $this$initAnim_u24lambda_u2d4 = ObjectAnimator.ofFloat(this.floatContainerView, NewTimerConstants.NEWTIMER_ANIMATION_TRANSLATIONY, new float[]{-this.btnAvoidTtsOffset});
        $this$initAnim_u24lambda_u2d4.setDuration(this.btnTtsAnimDuration);
        this.btnOnTtsShowAnim = $this$initAnim_u24lambda_u2d4;
        if (MiniPlayerView.getInstance().isShow()) {
            this.floatContainerView.setTranslationY(-this.btnAvoidTtsOffset);
            this.isTtsPanelShow = true;
        }
        if (FeedUtil.isTabletBasic()) {
            this.floatContainerView.setTranslationX(-FeedRuntime.getAppContext().getResources().getDimension(R.dimen.dimens_21dp));
        }
        ObjectAnimator $this$initAnim_u24lambda_u2d5 = ObjectAnimator.ofFloat(this.floatContainerView, NewTimerConstants.NEWTIMER_ANIMATION_TRANSLATIONY, new float[]{0.0f});
        $this$initAnim_u24lambda_u2d5.setDuration(this.btnTtsAnimDuration);
        this.btnOnTtsDismissAnim = $this$initAnim_u24lambda_u2d5;
    }

    private final void onBtnClick() {
        ObjectAnimator objectAnimator = this.btnRefreshAnim;
        if (!(objectAnimator != null ? objectAnimator.isRunning() : false)) {
            ObjectAnimator objectAnimator2 = this.btnRefreshAnim;
            if (objectAnimator2 != null) {
                objectAnimator2.start();
            }
            notifyFloatBtnRefresh();
            if (NetWorkUtils.getIsOnline()) {
                FeedStatisticCenter.ubcFloatRefresh(TabController.INSTANCE.getCurrentChannelId(), "click_btn");
            }
        }
    }

    private final void notifyFloatBtnRefresh() {
        int currentPos = TabController.INSTANCE.getCurrentPosition();
        String currentChannelId = TabController.INSTANCE.getCurrentChannelId();
        this.tabAdapter.notifyTabClickPullRefresh(currentPos, "21");
    }

    public final void show() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = this.btnInAnim;
        boolean isHideAnimRunning = false;
        boolean isShowAnimRunning = objectAnimator2 != null ? objectAnimator2.isRunning() : false;
        ObjectAnimator objectAnimator3 = this.btnOutAnim;
        if (objectAnimator3 != null) {
            isHideAnimRunning = objectAnimator3.isRunning();
        }
        if (isHideAnimRunning && (objectAnimator = this.btnOutAnim) != null) {
            objectAnimator.cancel();
        }
        if (this.floatContainerView.getVisibility() != 0 && !isShowAnimRunning) {
            resetTranslation();
            ObjectAnimator objectAnimator4 = this.btnInAnim;
            if (objectAnimator4 != null) {
                objectAnimator4.start();
            }
        }
        if (NetWorkUtils.getIsOnline()) {
            FeedStatisticCenter.ubcFloatRefresh(TabController.INSTANCE.getCurrentChannelId(), "show_btn");
        }
    }

    public final void hide() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        ObjectAnimator objectAnimator3 = this.btnOutAnim;
        boolean isShowAnimRunning = false;
        boolean isHideAnimRunning = objectAnimator3 != null ? objectAnimator3.isRunning() : false;
        ObjectAnimator objectAnimator4 = this.btnInAnim;
        if (objectAnimator4 != null) {
            isShowAnimRunning = objectAnimator4.isRunning();
        }
        if (isShowAnimRunning && (objectAnimator2 = this.btnInAnim) != null) {
            objectAnimator2.cancel();
        }
        if (this.floatContainerView.getVisibility() != 8 && !isHideAnimRunning && (objectAnimator = this.btnOutAnim) != null) {
            objectAnimator.start();
        }
    }

    public final void attachToRootView(ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        int marginBottom = ViewExtensionsKt.getDimensionPixelSize(this.floatContainerView, R.dimen.feed_float_refresh_btn_margin_bottom);
        int marginRight = ViewExtensionsKt.getDimensionPixelSize(this.floatContainerView, R.dimen.feed_float_refresh_btn_margin_right);
        int size = ViewExtensionsKt.getDimensionPixelSize(this.floatContainerView, R.dimen.feed_float_refresh_btn_size);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(size, size);
        FrameLayout.LayoutParams $this$attachToRootView_u24lambda_u2d6 = lp;
        $this$attachToRootView_u24lambda_u2d6.gravity = 85;
        $this$attachToRootView_u24lambda_u2d6.bottomMargin = marginBottom;
        $this$attachToRootView_u24lambda_u2d6.rightMargin = marginRight;
        rootView.addView(this.floatContainerView, lp);
        updateFontSize();
    }

    public final void onNightModeChanged() {
        updateUi();
    }

    public final void onTtsPlayerAnimEvent(TTSPlayerAnimEvent ttsPlayerAnimEvent) {
        Intrinsics.checkNotNullParameter(ttsPlayerAnimEvent, "ttsPlayerAnimEvent");
        onTtsPlayerEvent(ttsPlayerAnimEvent.ttsPlayerState == 2);
    }

    public final void onTtsPlayerEvent(TTSPlayerEvent ttsPlayerEvent) {
        Intrinsics.checkNotNullParameter(ttsPlayerEvent, "ttsPlayerEvent");
        onTtsPlayerEvent(ttsPlayerEvent.ttsPlayerState == 2);
    }

    private final void onTtsPlayerEvent(boolean isShow) {
        if (isShow && !this.isTtsPanelShow) {
            ObjectAnimator objectAnimator = this.btnOnTtsShowAnim;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
            this.isTtsPanelShow = true;
        } else if (!isShow && this.isTtsPanelShow) {
            ObjectAnimator objectAnimator2 = this.btnOnTtsDismissAnim;
            if (objectAnimator2 != null) {
                objectAnimator2.start();
            }
            this.isTtsPanelShow = false;
        }
    }

    private final void resetTranslation() {
        if (this.isTtsPanelShow) {
            this.floatContainerView.setTranslationY(-this.btnAvoidTtsOffset);
        } else {
            this.floatContainerView.setTranslationY(0.0f);
        }
    }

    private final void updateUi() {
        ViewExtensionsKt.setBackgroundRes(this.floatContainerView, R.drawable.feed_float_refresh_btn_bg);
        ViewExtensionsKt.setDrawableRes(this.floatRefreshImg, R.drawable.feed_float_refresh_btn);
    }

    private final void updateFontSize() {
        View view2 = this.floatContainerView;
        ViewGroup.LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = view2 != null ? view2.getLayoutParams() : null;
        if (layoutParams2 != null) {
            layoutParams2.width = (int) FontSizeHelper.getScaledSize(0, (float) this.context.getResources().getDimensionPixelSize(R.dimen.feed_float_refresh_btn_size));
        }
        View view3 = this.floatContainerView;
        ViewGroup.LayoutParams layoutParams3 = view3 != null ? view3.getLayoutParams() : null;
        if (layoutParams3 != null) {
            layoutParams3.height = (int) FontSizeHelper.getScaledSize(0, (float) this.context.getResources().getDimensionPixelSize(R.dimen.feed_float_refresh_btn_size));
        }
        ImageView imageView = this.floatRefreshImg;
        ViewGroup.LayoutParams layoutParams4 = imageView != null ? imageView.getLayoutParams() : null;
        if (layoutParams4 != null) {
            layoutParams4.width = (int) FontSizeHelper.getScaledSize(0, (float) this.context.getResources().getDimensionPixelSize(R.dimen.feed_float_refresh_img_size));
        }
        ImageView imageView2 = this.floatRefreshImg;
        if (imageView2 != null) {
            layoutParams = imageView2.getLayoutParams();
        }
        if (layoutParams != null) {
            layoutParams.height = (int) FontSizeHelper.getScaledSize(0, (float) this.context.getResources().getDimensionPixelSize(R.dimen.feed_float_refresh_img_size));
        }
    }

    public final void onFontSizeChange() {
        updateFontSize();
    }
}
