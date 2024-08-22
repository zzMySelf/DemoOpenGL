package com.baidu.searchbox.video.feedflow.detail.bottombar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchState;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.VideoItemLayoutState;
import com.baidu.searchbox.video.feedflow.detail.halfscreen.switcher.HalfScreenSwitchConfigKt;
import com.baidu.searchbox.video.feedflow.detail.nextcontent.RecommendNextContentStateKt;
import com.baidu.searchbox.video.feedflow.detail.nextcontent.RecommendShowNextContentConfig;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\"\u0010\u0012\u001a\u00020\u00112\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0014J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001bH\u0002J\u0016\u0010\u001c\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001bH\u0002J\u0016\u0010\u001d\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002J$\u0010\u001f\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/bottombar/DynamicItemBottomBarContainer;", "", "()V", "bottomBanner", "Landroid/widget/FrameLayout;", "bottomBannerAnimatorSet", "Landroid/animation/AnimatorSet;", "bottomBannerContainer", "Landroid/widget/RelativeLayout;", "bottomBannerPlaceHolder", "addView", "", "view", "Landroid/view/View;", "type", "", "clear", "", "inflateView", "inflateComponentView", "Lkotlin/Function2;", "", "init", "container", "Landroid/view/ViewGroup;", "setBottomBarALPHA", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "showBottomBanner", "showBottomBannerAnim", "showBottomBannerInAuthorWork", "subscribe", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "manager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "updateBottomBarPHVisible", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicItemBottomBarContainer.kt */
public final class DynamicItemBottomBarContainer {
    /* access modifiers changed from: private */
    public FrameLayout bottomBanner;
    private AnimatorSet bottomBannerAnimatorSet;
    private RelativeLayout bottomBannerContainer;
    /* access modifiers changed from: private */
    public FrameLayout bottomBannerPlaceHolder;

    public final void init(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View findViewById = container.findViewById(R.id.bottom_banner);
        Intrinsics.checkNotNullExpressionValue(findViewById, "container.findViewById(R.id.bottom_banner)");
        this.bottomBanner = (FrameLayout) findViewById;
        View findViewById2 = container.findViewById(R.id.bottom_banner_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "container.findViewById(R….bottom_banner_container)");
        this.bottomBannerContainer = (RelativeLayout) findViewById2;
        View findViewById3 = container.findViewById(R.id.bottom_banner_place_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "container.findViewById(R…ttom_banner_place_holder)");
        this.bottomBannerPlaceHolder = (FrameLayout) findViewById3;
    }

    public final void inflateView(Function2<? super String, ? super Integer, ? extends View> inflateComponentView) {
        Intrinsics.checkNotNullParameter(inflateComponentView, "inflateComponentView");
        inflateComponentView.invoke("flow_video_recommend_next_content_component", Integer.valueOf(R.id.video_flow_cmp_recommend_next_content));
        inflateComponentView.invoke("flow_video_bottom_banner_place_holder", Integer.valueOf(R.id.video_flow_cmp_bottom_banner_place_holder));
        inflateComponentView.invoke("flow_video_bottom_banner", Integer.valueOf(R.id.video_flow_cmp_bottom_banner));
    }

    public final boolean addView(View view2, int type) {
        Intrinsics.checkNotNullParameter(view2, "view");
        FrameLayout frameLayout = null;
        if (type == R.id.video_flow_cmp_recommend_next_content) {
            FrameLayout frameLayout2 = this.bottomBanner;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomBanner");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.addView(view2);
            return true;
        } else if (type == R.id.video_flow_cmp_bottom_banner_place_holder) {
            FrameLayout frameLayout3 = this.bottomBannerPlaceHolder;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomBannerPlaceHolder");
            } else {
                frameLayout = frameLayout3;
            }
            frameLayout.addView(view2);
            return true;
        } else if (type != R.id.video_flow_cmp_bottom_banner) {
            return false;
        } else {
            FrameLayout frameLayout4 = this.bottomBanner;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomBanner");
            } else {
                frameLayout = frameLayout4;
            }
            frameLayout.addView(view2);
            return true;
        }
    }

    public final void subscribe(Store<?> store, LifecycleOwner lifecycleOwner, ComponentArchManager manager) {
        VideoItemLayoutState $this$subscribe_u24lambda_u2d4;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(manager, FeedStatisticConstants.UBC_TYPE_PLUS);
        if (store != null && ($this$subscribe_u24lambda_u2d4 = (VideoItemLayoutState) store.subscribe((Class<T>) VideoItemLayoutState.class)) != null) {
            $this$subscribe_u24lambda_u2d4.getShowBottomBannerContainer().observe(lifecycleOwner, new DynamicItemBottomBarContainer$$ExternalSyntheticLambda0(this, store));
            $this$subscribe_u24lambda_u2d4.getSetBottomBannerAlpha().observe(lifecycleOwner, new DynamicItemBottomBarContainer$$ExternalSyntheticLambda1(this, store));
            $this$subscribe_u24lambda_u2d4.getHideBottomBarPlaceHolder().observe(lifecycleOwner, new DynamicItemBottomBarContainer$$ExternalSyntheticLambda2(this));
            $this$subscribe_u24lambda_u2d4.getUpdateLayoutFromPage().observe(lifecycleOwner, new DynamicItemBottomBarContainer$$ExternalSyntheticLambda3(this, manager));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribe$lambda-4$lambda-0  reason: not valid java name */
    public static final void m10896subscribe$lambda4$lambda0(DynamicItemBottomBarContainer this$0, Store $store, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showBottomBanner($store);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribe$lambda-4$lambda-1  reason: not valid java name */
    public static final void m10897subscribe$lambda4$lambda1(DynamicItemBottomBarContainer this$0, Store $store, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setBottomBarALPHA($store);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribe$lambda-4$lambda-2  reason: not valid java name */
    public static final void m10898subscribe$lambda4$lambda2(DynamicItemBottomBarContainer this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout frameLayout = this$0.bottomBannerPlaceHolder;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBannerPlaceHolder");
            frameLayout = null;
        }
        frameLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribe$lambda-4$lambda-3  reason: not valid java name */
    public static final void m10899subscribe$lambda4$lambda3(DynamicItemBottomBarContainer this$0, ComponentArchManager $manager, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($manager, "$manager");
        this$0.updateBottomBarPHVisible($manager);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        if (r1 != null) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void showBottomBanner(com.baidu.searchbox.feed.detail.frame.Store<?> r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0025
            r1 = r6
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r1.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0010
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0011
        L_0x0010:
            r3 = r0
        L_0x0011:
            if (r3 == 0) goto L_0x001a
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorksState> r4 = com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorksState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x001b
        L_0x001a:
            r3 = r0
        L_0x001b:
            com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorksState r3 = (com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorksState) r3
            if (r3 == 0) goto L_0x0025
            com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorkStatus r1 = r3.getCurStatus()
            if (r1 != 0) goto L_0x0029
        L_0x0025:
            com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorkStatus$Close r1 = com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorkStatus.Close.INSTANCE
            com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorkStatus r1 = (com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorkStatus) r1
        L_0x0029:
            com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorkStatus$Close r2 = com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorkStatus.Close.INSTANCE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x0035
            r5.showBottomBannerInAuthorWork()
            goto L_0x0049
        L_0x0035:
            android.widget.FrameLayout r1 = r5.bottomBannerPlaceHolder
            if (r1 != 0) goto L_0x003f
            java.lang.String r1 = "bottomBannerPlaceHolder"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x0040
        L_0x003f:
            r0 = r1
        L_0x0040:
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0049
            r5.showBottomBannerAnim(r6)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.bottombar.DynamicItemBottomBarContainer.showBottomBanner(com.baidu.searchbox.feed.detail.frame.Store):void");
    }

    private final void showBottomBannerInAuthorWork() {
        FrameLayout frameLayout = this.bottomBannerPlaceHolder;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBannerPlaceHolder");
            frameLayout = null;
        }
        frameLayout.setAlpha(0.0f);
        FrameLayout frameLayout3 = this.bottomBannerPlaceHolder;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBannerPlaceHolder");
        } else {
            frameLayout2 = frameLayout3;
        }
        frameLayout2.setVisibility(8);
    }

    private final void showBottomBannerAnim(Store<?> store) {
        clear();
        this.bottomBannerAnimatorSet = new AnimatorSet();
        FrameLayout frameLayout = this.bottomBannerPlaceHolder;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBannerPlaceHolder");
            frameLayout = null;
        }
        ObjectAnimator placeHolderHideAnim = ObjectAnimator.ofFloat(frameLayout, "alpha", new float[]{1.0f, 0.0f});
        FrameLayout frameLayout3 = this.bottomBanner;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBanner");
            frameLayout3 = null;
        }
        ObjectAnimator bottomBannerAnim = ObjectAnimator.ofFloat(frameLayout3, "alpha", new float[]{0.0f, 1.0f});
        FrameLayout frameLayout4 = this.bottomBanner;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBanner");
            frameLayout4 = null;
        }
        int bottomBannerHeight = frameLayout4.getMeasuredHeight();
        int[] iArr = new int[2];
        FrameLayout frameLayout5 = this.bottomBannerPlaceHolder;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBannerPlaceHolder");
        } else {
            frameLayout2 = frameLayout5;
        }
        iArr[0] = frameLayout2.getMeasuredHeight();
        iArr[1] = bottomBannerHeight;
        ValueAnimator placeHolderHeightAnim = ObjectAnimator.ofInt(iArr);
        placeHolderHeightAnim.addUpdateListener(new DynamicItemBottomBarContainer$$ExternalSyntheticLambda4(this));
        AnimatorSet animatorSet = this.bottomBannerAnimatorSet;
        if (animatorSet != null) {
            animatorSet.playTogether(new Animator[]{placeHolderHideAnim, bottomBannerAnim, placeHolderHeightAnim});
        }
        AnimatorSet animatorSet2 = this.bottomBannerAnimatorSet;
        if (animatorSet2 != null) {
            animatorSet2.addListener(new DynamicItemBottomBarContainer$showBottomBannerAnim$2(this, store));
        }
        AnimatorSet animatorSet3 = this.bottomBannerAnimatorSet;
        if (animatorSet3 != null) {
            animatorSet3.setDuration(240);
        }
        AnimatorSet animatorSet4 = this.bottomBannerAnimatorSet;
        if (animatorSet4 != null) {
            animatorSet4.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showBottomBannerAnim$lambda-6  reason: not valid java name */
    public static final void m10895showBottomBannerAnim$lambda6(DynamicItemBottomBarContainer this$0, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        FrameLayout frameLayout = null;
        Integer height = animatedValue instanceof Integer ? (Integer) animatedValue : null;
        FrameLayout frameLayout2 = this$0.bottomBannerPlaceHolder;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBannerPlaceHolder");
            frameLayout2 = null;
        }
        ViewGroup.LayoutParams prams = frameLayout2.getLayoutParams();
        if (prams != null) {
            prams.height = height != null ? height.intValue() : 0;
        }
        FrameLayout frameLayout3 = this$0.bottomBannerPlaceHolder;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBannerPlaceHolder");
        } else {
            frameLayout = frameLayout3;
        }
        frameLayout.setLayoutParams(prams);
    }

    private final void setBottomBarALPHA(Store<?> store) {
        FrameLayout frameLayout = null;
        Object state = store != null ? store.getState() : null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        boolean z = false;
        if (commonState != null && CommonStateExtKt.isFirstJump$default(commonState, (ItemModel) null, 1, (Object) null)) {
            z = true;
        }
        if (z) {
            FrameLayout frameLayout2 = this.bottomBanner;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomBanner");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.setAlpha(0.0f);
        }
    }

    private final void updateBottomBarPHVisible(ComponentArchManager manager) {
        RecommendShowNextContentConfig recommendConfig;
        FlowSwitchState flowSwitchState;
        Store store = manager.getStore();
        if (store == null || (flowSwitchState = FlowSwitchStateKt.flowSwitchState((Store<?>) store)) == null || (recommendConfig = flowSwitchState.getRecommendNextContentConfig()) == null) {
            recommendConfig = new RecommendShowNextContentConfig(false, false, false, 0, 0.0f, 0, 0, 0, 0, (String) null, (String) null, (String) null, 0, 0, false, false, 0, false, 0, 0, 1048575, (DefaultConstructorMarker) null);
        }
        FrameLayout frameLayout = null;
        AbsState absState = store != null ? (AbsState) store.getState() : null;
        if (RecommendNextContentStateKt.canShowBelongFromAndPage(absState instanceof CommonState ? (CommonState) absState : null, recommendConfig.getSourcePage())) {
            AbsState absState2 = store != null ? (AbsState) store.getState() : null;
            if (RecommendNextContentStateKt.canShowBelongPd(absState2 instanceof CommonState ? (CommonState) absState2 : null, recommendConfig.getPdString()) && !HalfScreenSwitchConfigKt.getHalfScreenConfigSwitch(store)) {
                return;
            }
        }
        FrameLayout frameLayout2 = this.bottomBannerPlaceHolder;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBannerPlaceHolder");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.setVisibility(8);
    }

    public final void clear() {
        AnimatorSet animatorSet = this.bottomBannerAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.bottomBannerAnimatorSet;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
        }
        this.bottomBannerAnimatorSet = null;
    }
}
