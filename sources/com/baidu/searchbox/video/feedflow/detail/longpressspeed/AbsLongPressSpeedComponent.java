package com.baidu.searchbox.video.feedflow.detail.longpressspeed;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.player.guide.config.LongPressSpeedConfigKt;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.clearscreen.service.IClearScreenPluginService;
import com.baidu.searchbox.video.feedflow.detail.halfscreen.switcher.HalfScreenSwitchConfigKt;
import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.model.NewMoreMenuDataTranUtilsKt;
import com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedView;
import com.baidu.searchbox.video.feedflow.flow.fontsize.FontSizeState;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0006\u0010\u0019\u001a\u00020\fJ\b\u0010\u001a\u001a\u00020\fH&J\b\u0010\u001b\u001a\u00020\fH&J\b\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH&J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\fH\u0002J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\fH\u0002J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\fH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006("}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/longpressspeed/AbsLongPressSpeedComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "longPressSpeedView", "Lcom/baidu/searchbox/video/feedflow/detail/longpressspeed/LongPressSpeedView;", "getLongPressSpeedView", "()Lcom/baidu/searchbox/video/feedflow/detail/longpressspeed/LongPressSpeedView;", "longPressSpeedView$delegate", "Lkotlin/Lazy;", "cancelAnim", "", "consumeEvent", "", "event", "Landroid/view/MotionEvent;", "createView", "Landroid/view/View;", "getBottomStatusBarHeight", "", "getDefaultSpeedSetting", "", "guideHide", "guideShow", "initLongPressSpeedView", "injectService", "isAnimRunning", "isCanShow", "isShownGuide", "onAttachToManager", "onDestroy", "setGuideHasShown", "showOrHideGuide", "isVisible", "startOrStopBackwardAnim", "isStart", "startOrStopForwardAnim", "forwardEvent", "Lcom/baidu/searchbox/video/feedflow/detail/longpressspeed/ForwardEvent;", "tryShowSpeedMenuGuideView", "inClearScreen", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbsLongPressSpeedComponent.kt */
public abstract class AbsLongPressSpeedComponent extends LiveDataComponent {
    private final Lazy longPressSpeedView$delegate = LazyKt.lazy(new AbsLongPressSpeedComponent$longPressSpeedView$2(this));

    public abstract boolean isCanShow();

    public abstract boolean isShownGuide();

    public abstract void setGuideHasShown();

    private final LongPressSpeedView getLongPressSpeedView() {
        return (LongPressSpeedView) this.longPressSpeedView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LongPressSpeedView initLongPressSpeedView() {
        LongPressSpeedView $this$initLongPressSpeedView_u24lambda_u2d0 = new LongPressSpeedView(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$initLongPressSpeedView_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        $this$initLongPressSpeedView_u24lambda_u2d0.setShowOrHideListener(new AbsLongPressSpeedComponent$initLongPressSpeedView$1$1(this));
        $this$initLongPressSpeedView_u24lambda_u2d0.setBottomHeightListener(new AbsLongPressSpeedComponent$initLongPressSpeedView$1$2(this));
        $this$initLongPressSpeedView_u24lambda_u2d0.setSpeedSelectedListener(new AbsLongPressSpeedComponent$initLongPressSpeedView$1$3($this$initLongPressSpeedView_u24lambda_u2d0, this));
        return $this$initLongPressSpeedView_u24lambda_u2d0;
    }

    public View createView() {
        return getLongPressSpeedView();
    }

    public void onAttachToManager() {
        FontSizeState fontSizeState;
        MutableLiveData<Unit> action;
        LongPressSpeedState $this$onAttachToManager_u24lambda_u2d7;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if (!($this$subscribe$iv == null || ($this$onAttachToManager_u24lambda_u2d7 = (LongPressSpeedState) $this$subscribe$iv.subscribe(LongPressSpeedState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d7.getGuideVisible().observe(this, new AbsLongPressSpeedComponent$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d7.getForwardAnim().observe(this, new AbsLongPressSpeedComponent$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d7.getBackwardAnim().observe(this, new AbsLongPressSpeedComponent$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d7.getUpdateUiStyle().observe(this, new AbsLongPressSpeedComponent$$ExternalSyntheticLambda3(this));
            $this$onAttachToManager_u24lambda_u2d7.getCancelAnim().observe(this, new AbsLongPressSpeedComponent$$ExternalSyntheticLambda4(this));
            $this$onAttachToManager_u24lambda_u2d7.getRefreshView().observe(this, new AbsLongPressSpeedComponent$$ExternalSyntheticLambda5(this));
        }
        Store $this$subscribe$iv2 = getStore();
        if ($this$subscribe$iv2 != null && (fontSizeState = (FontSizeState) $this$subscribe$iv2.subscribe(FontSizeState.class)) != null && (action = fontSizeState.getAction()) != null) {
            action.observe(this, new AbsLongPressSpeedComponent$$ExternalSyntheticLambda6(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7$lambda-1  reason: not valid java name */
    public static final void m11735onAttachToManager$lambda7$lambda1(AbsLongPressSpeedComponent this$0, Boolean isVisible) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isVisible, "isVisible");
        this$0.showOrHideGuide(isVisible.booleanValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7$lambda-2  reason: not valid java name */
    public static final void m11736onAttachToManager$lambda7$lambda2(AbsLongPressSpeedComponent this$0, ForwardEvent forwardEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(forwardEvent, "forwardEvent");
        this$0.startOrStopForwardAnim(forwardEvent);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7$lambda-3  reason: not valid java name */
    public static final void m11737onAttachToManager$lambda7$lambda3(AbsLongPressSpeedComponent this$0, Boolean isStart) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isStart, "isStart");
        this$0.startOrStopBackwardAnim(isStart.booleanValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7$lambda-4  reason: not valid java name */
    public static final void m11738onAttachToManager$lambda7$lambda4(AbsLongPressSpeedComponent this$0, LongPressSpeedView.UiStyle uiStyle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LongPressSpeedView longPressSpeedView = this$0.getLongPressSpeedView();
        Intrinsics.checkNotNullExpressionValue(uiStyle, "uiStyle");
        longPressSpeedView.updateUiStyle(uiStyle);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7$lambda-5  reason: not valid java name */
    public static final void m11739onAttachToManager$lambda7$lambda5(AbsLongPressSpeedComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cancelAnim();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7$lambda-6  reason: not valid java name */
    public static final void m11740onAttachToManager$lambda7$lambda6(AbsLongPressSpeedComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoFlowUtilsKt.updateViewBottomMargingForBottomBar(this$0.getManager(), this$0.getLongPressSpeedView().getGuideForwardContainerView());
        VideoFlowUtilsKt.updateViewBottomMargingForBottomBar(this$0.getManager(), this$0.getLongPressSpeedView().getGuideBackwardContainerView());
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8  reason: not valid java name */
    public static final void m11741onAttachToManager$lambda8(AbsLongPressSpeedComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLongPressSpeedView().setFontAndPictureSize();
    }

    private final void showOrHideGuide(boolean isVisible) {
        if (isVisible && isCanShow()) {
            getLongPressSpeedView().setForwardBackToastViewLayout(NewMoreMenuDataTranUtilsKt.getLongPressSpeedMenuSwitch(getStore()), HalfScreenSwitchConfigKt.canShowHalfScreen$default((Store) getStore(), false, 1, (Object) null), HalfScreenSwitchConfigKt.getHalfScreenModeScreenUpHeight(getStore()));
            getLongPressSpeedView().showGuide();
            setGuideHasShown();
        } else if (!isVisible && getLongPressSpeedView().isShowingGuide()) {
            getLongPressSpeedView().hideGuide();
        }
    }

    public void startOrStopForwardAnim(ForwardEvent forwardEvent) {
        float useSpeed;
        Intrinsics.checkNotNullParameter(forwardEvent, "forwardEvent");
        if (NewMoreMenuDataTranUtilsKt.getLongPressSpeedMenuSwitch(getStore())) {
            useSpeed = LongPressSpeedConfigKt.getLastLongPressSpeed();
        } else {
            useSpeed = getDefaultSpeedSetting();
        }
        if (forwardEvent.isStartForwardAnim()) {
            IClearScreenPluginService iClearScreenPluginService = (IClearScreenPluginService) getManager().getService(IClearScreenPluginService.class);
            boolean inClearScreen = BdPlayerUtils.orFalse(iClearScreenPluginService != null ? Boolean.valueOf(iClearScreenPluginService.isInClearScreen()) : null);
            getLongPressSpeedView().updateSpeedContainerLayout(inClearScreen);
            if (NewMoreMenuDataTranUtilsKt.getLongPressSpeedMenuSwitch(getStore())) {
                getLongPressSpeedView().showSpeedMenu(true, useSpeed, forwardEvent.getPressArea(), forwardEvent.getMotionEvent());
                getLongPressSpeedView().startForwardAnim(true, useSpeed);
                tryShowSpeedMenuGuideView(true);
            } else {
                getLongPressSpeedView().startForwardAnim(inClearScreen, useSpeed);
            }
            VideoFlowUtilsKt.vibrateStart$default(0, 1, (Object) null);
            if (!isShownGuide()) {
                setGuideHasShown();
            }
        } else {
            getLongPressSpeedView().stopForwardAnim();
            getLongPressSpeedView().hideSpeedMenu();
            getLongPressSpeedView().hideSpeedMenuGuideView();
        }
        Store<AbsState> store = getStore();
        if (store != null) {
            store.dispatch(new LongPressSpeedAnim(true, forwardEvent.isStartForwardAnim(), useSpeed));
        }
    }

    private final void tryShowSpeedMenuGuideView(boolean inClearScreen) {
        int shownCount = LongPressSpeedConfigKt.getLongPressSpeedMenuGuideShowCount();
        if (shownCount < 3) {
            getLongPressSpeedView().showSpeedMenuGuideView(inClearScreen);
            LongPressSpeedConfigKt.saveLongPressSpeedMenuGuideShowCount(shownCount + 1);
        }
    }

    private final void startOrStopBackwardAnim(boolean isStart) {
        float speed = getDefaultSpeedSetting();
        if (isStart) {
            IClearScreenPluginService iClearScreenPluginService = (IClearScreenPluginService) getManager().getService(IClearScreenPluginService.class);
            boolean inClearScreen = BdPlayerUtils.orFalse(iClearScreenPluginService != null ? Boolean.valueOf(iClearScreenPluginService.isInClearScreen()) : null);
            getLongPressSpeedView().updateSpeedContainerLayout(inClearScreen);
            getLongPressSpeedView().startBackwardAnim(inClearScreen, speed);
            VideoFlowUtilsKt.vibrateStart$default(0, 1, (Object) null);
            if (!isShownGuide()) {
                setGuideHasShown();
            }
        } else {
            getLongPressSpeedView().stopBackwardAnim();
        }
        Store<AbsState> store = getStore();
        if (store != null) {
            store.dispatch(new LongPressSpeedAnim(false, isStart, speed));
        }
    }

    private final float getDefaultSpeedSetting() {
        return 3.0f;
    }

    /* access modifiers changed from: private */
    public final int getBottomStatusBarHeight() {
        Object obj;
        Window window;
        Context context = getContext();
        ViewGroup viewGroup = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
        ViewGroup decorView2 = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (decorView2 == null) {
            return 0;
        }
        try {
            Result.Companion companion = Result.Companion;
            View childAt = decorView2.getChildAt(0);
            obj = Result.m8971constructorimpl(childAt instanceof ViewGroup ? (ViewGroup) childAt : null);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (!Result.m8977isFailureimpl(obj)) {
            viewGroup = obj;
        }
        ViewGroup firstChildView = viewGroup;
        if (firstChildView == null) {
            return 0;
        }
        return decorView2.getHeight() - firstChildView.getBottom();
    }

    public final boolean isAnimRunning() {
        return getLongPressSpeedView().isAnimRunning();
    }

    public void injectService() {
        super.injectService();
        getManager().registerServices(ILongPressSpeedService.class, new LongPressSpeedServiceImpl(this));
    }

    private final void cancelAnim() {
        getLongPressSpeedView().stopBackwardAnim();
        getLongPressSpeedView().stopForwardAnim();
        getLongPressSpeedView().hideSpeedMenu();
        getLongPressSpeedView().hideSpeedMenuGuideView();
    }

    public void onDestroy() {
        super.onDestroy();
        getLongPressSpeedView().release();
        getLongPressSpeedView().setBottomHeightListener((LongPressSpeedView.IGetSafeSpaceListener) null);
    }

    public void guideShow() {
    }

    public void guideHide() {
    }

    public final boolean consumeEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isAnimRunning() || event.getAction() != 2) {
            return false;
        }
        getLongPressSpeedView().dispatchTouchEvent(event);
        return true;
    }
}
