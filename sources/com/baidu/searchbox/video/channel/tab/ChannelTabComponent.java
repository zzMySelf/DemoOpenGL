package com.baidu.searchbox.video.channel.tab;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.video.channel.abtest.ChannelAbTestManager;
import com.baidu.searchbox.video.channel.flow.pageview.IChannelFlowPageService;
import com.baidu.searchbox.video.channel.flow.pageview.IChannelStatusBarService;
import com.baidu.searchbox.video.channel.flow.utils.VideoChannelUtilsKt;
import com.baidu.searchbox.video.feedflow.channel.ChannelPageExtParamStateKt;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.tab.TabComponent;
import com.baidu.searchbox.video.feedflow.tab.TabInfoModel;
import com.baidu.searchbox.video.feedflow.tab.TabState;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowPadUtilsKt;
import com.baidu.searchbox.video.feedflow.view.TopCoverView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0014J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0014J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\u0016\u0010\u001c\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0014J\b\u0010 \u001a\u00020\u0006H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/video/channel/tab/ChannelTabComponent;", "Lcom/baidu/searchbox/video/feedflow/tab/TabComponent;", "()V", "hasPostScroll", "", "changeNaTabCoverVisible", "", "needAnim", "handleNavigationBarStyle", "theme", "", "isFromPreCreate", "needShowPadStyle", "onAttachToManager", "onPageSelected", "position", "", "model", "Lcom/baidu/searchbox/video/feedflow/tab/TabInfoModel;", "onResume", "scrollToTab", "isSmoothScroll", "setTopCoverStyle", "style", "Lcom/baidu/searchbox/video/feedflow/view/TopCoverView$TopCoverViewStyle;", "setTopCoverVisible", "visible", "tryFullScrollEnd", "tryPostScroll", "callback", "Lkotlin/Function0;", "updateStatusBarStyle", "updateTabStyle", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelTabComponent.kt */
public final class ChannelTabComponent extends TabComponent {
    private boolean hasPostScroll;

    public void onAttachToManager() {
        ChannelTabState $this$onAttachToManager_u24lambda_u2d2;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && ($this$onAttachToManager_u24lambda_u2d2 = (ChannelTabState) $this$subscribe$iv.subscribe(ChannelTabState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d2.getChangeTopViewVisible().observe(this, new ChannelTabComponent$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-2$lambda-1  reason: not valid java name */
    public static final void m4958onAttachToManager$lambda2$lambda1(ChannelTabComponent this$0, Boolean visible) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(visible, "visible");
        if (visible.booleanValue()) {
            this$0.getTabContainer().setVisibility(0);
            VideoFlowPadUtilsKt.topCoverPadStyle(this$0.getTopCover());
            ValueAnimator topComponentAlphaAnim = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
            topComponentAlphaAnim.setDuration(300);
            topComponentAlphaAnim.addUpdateListener(new ChannelTabComponent$$ExternalSyntheticLambda1(this$0));
            topComponentAlphaAnim.start();
            DIFactory.INSTANCE.post(new ChannelTabComponent$onAttachToManager$1$1$2(this$0));
            return;
        }
        this$0.getTabContainer().setVisibility(8);
        this$0.getTopCover().setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m4959onAttachToManager$lambda2$lambda1$lambda0(ChannelTabComponent this$0, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        if (animatedValue != null) {
            float value = ((Float) animatedValue).floatValue();
            if (this$0.getTabContainer().getVisibility() == 0) {
                this$0.getTabContainer().setAlpha(value);
            }
            if (this$0.getTopCover().getVisibility() == 0) {
                this$0.getTopCover().setAlpha(value);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* access modifiers changed from: protected */
    public boolean isFromPreCreate() {
        return ChannelPageExtParamStateKt.isFromPreCreate((Store<?>) getStore());
    }

    /* access modifiers changed from: protected */
    public void changeNaTabCoverVisible(boolean needAnim) {
        if (DIFactory.INSTANCE.isPadStyle()) {
            TopCoverView.setCoverVisible$default(getTopCover(), false, false, 2, (Object) null);
        } else {
            super.changeNaTabCoverVisible(needAnim);
        }
    }

    /* access modifiers changed from: protected */
    public void onPageSelected(int position, TabInfoModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        super.onPageSelected(position, model);
        if (ChannelAbTestManager.INSTANCE.getBottomBarCanSwitchTheme()) {
            if (!isFromPreCreate() || ChannelPageExtParamStateKt.isUsedPreCreate((Store<?>) getStore())) {
                handleNavigationBarStyle(model.getTabStyle().getPreferredTheme());
                String preferredTheme = model.getTabStyle().getPreferredTheme();
                IChannelFlowPageService iChannelFlowPageService = (IChannelFlowPageService) getManager().getService(IChannelFlowPageService.class);
                VideoChannelUtilsKt.handleHomeTabStyle(preferredTheme, iChannelFlowPageService != null ? iChannelFlowPageService.getHomeBottomBar() : null);
            }
        }
    }

    public void onResume() {
        TabInfoModel model;
        super.onResume();
        Store $this$select$iv = getStore();
        View view2 = null;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            TabState tabState = (TabState) (commonState != null ? commonState.select(TabState.class) : null);
            if (tabState != null) {
                model = tabState.getCurrentTabInfo();
                if (isFromPreCreate() && model != null) {
                    handleNavigationBarStyle(model.getTabStyle().getPreferredTheme());
                    String preferredTheme = model.getTabStyle().getPreferredTheme();
                    IChannelFlowPageService iChannelFlowPageService = (IChannelFlowPageService) getManager().getService(IChannelFlowPageService.class);
                    if (iChannelFlowPageService != null) {
                        view2 = iChannelFlowPageService.getHomeBottomBar();
                    }
                    VideoChannelUtilsKt.handleHomeTabStyle(preferredTheme, view2);
                    return;
                }
            }
        }
        model = null;
        if (isFromPreCreate()) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r0.getSelected() == true) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void tryFullScrollEnd() {
        /*
            r7 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002f
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r6 = 0
            if (r5 == 0) goto L_0x0015
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0016
        L_0x0015:
            r4 = r6
        L_0x0016:
            if (r4 == 0) goto L_0x001e
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r5 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r6 = r4.select(r5)
        L_0x001e:
            com.baidu.searchbox.video.feedflow.tab.TabState r6 = (com.baidu.searchbox.video.feedflow.tab.TabState) r6
            if (r6 == 0) goto L_0x002f
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r0 = r6.getLastItem()
            if (r0 == 0) goto L_0x002f
            boolean r0 = r0.getSelected()
            if (r0 != r1) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r1 = r2
        L_0x0030:
            if (r1 == 0) goto L_0x003b
            com.baidu.searchbox.video.feedflow.tab.tablayout.TabLayoutView r0 = r7.getTabView()
            r1 = 66
            r0.fullScroll(r1)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.tab.ChannelTabComponent.tryFullScrollEnd():void");
    }

    /* access modifiers changed from: protected */
    public void updateTabStyle() {
        super.updateTabStyle();
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            TabState $this$updateTabStyle_u24lambda_u2d3 = (TabState) (commonState != null ? commonState.select(TabState.class) : null);
            if ($this$updateTabStyle_u24lambda_u2d3 != null) {
                handleNavigationBarStyle(TabState.findTabStyle$default($this$updateTabStyle_u24lambda_u2d3, (String) null, 1, (Object) null));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateStatusBarStyle() {
        Store $this$select$iv = getStore();
        boolean z = false;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(TabState.class);
            }
            TabState tabState = (TabState) obj;
            if (tabState != null && !tabState.isSetWhiteFontStatusBar()) {
                z = true;
            }
        }
        if (z) {
            IChannelStatusBarService iChannelStatusBarService = (IChannelStatusBarService) getManager().getService(IChannelStatusBarService.class);
            if (iChannelStatusBarService != null) {
                iChannelStatusBarService.setLightStatusBar();
                return;
            }
            return;
        }
        IChannelStatusBarService iChannelStatusBarService2 = (IChannelStatusBarService) getManager().getService(IChannelStatusBarService.class);
        if (iChannelStatusBarService2 != null) {
            iChannelStatusBarService2.setDarkStatusBar();
        }
    }

    /* access modifiers changed from: protected */
    public void scrollToTab(boolean isSmoothScroll, int position) {
        tryPostScroll(new ChannelTabComponent$scrollToTab$1(this, isSmoothScroll, position));
    }

    private final void tryPostScroll(Function0<Unit> callback) {
        if (!this.hasPostScroll) {
            this.hasPostScroll = true;
            DIFactory.INSTANCE.post(new ChannelTabComponent$tryPostScroll$1(callback));
            return;
        }
        callback.invoke();
    }

    private final void handleNavigationBarStyle(String theme) {
        if (NightModeHelper.isNightMode()) {
            IChannelStatusBarService iChannelStatusBarService = (IChannelStatusBarService) getManager().getService(IChannelStatusBarService.class);
            if (iChannelStatusBarService != null) {
                iChannelStatusBarService.setNavigationBarColor(false);
            }
        } else if (Intrinsics.areEqual((Object) theme, (Object) "light")) {
            IChannelStatusBarService iChannelStatusBarService2 = (IChannelStatusBarService) getManager().getService(IChannelStatusBarService.class);
            if (iChannelStatusBarService2 != null) {
                iChannelStatusBarService2.setNavigationBarColor(true);
            }
        } else {
            IChannelStatusBarService iChannelStatusBarService3 = (IChannelStatusBarService) getManager().getService(IChannelStatusBarService.class);
            if (iChannelStatusBarService3 != null) {
                iChannelStatusBarService3.setNavigationBarColor(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean needShowPadStyle() {
        return DIFactory.INSTANCE.isPadStyle();
    }

    public void setTopCoverStyle(TopCoverView.TopCoverViewStyle style, boolean needAnim) {
        Intrinsics.checkNotNullParameter(style, "style");
        if (!DIFactory.INSTANCE.isPadStyle()) {
            super.setTopCoverStyle(style, needAnim);
        }
    }

    /* access modifiers changed from: protected */
    public void setTopCoverVisible(boolean visible, boolean needAnim) {
        if (!DIFactory.INSTANCE.isPadStyle()) {
            super.setTopCoverVisible(visible, needAnim);
        } else {
            super.setTopCoverVisible(false, false);
        }
    }
}
