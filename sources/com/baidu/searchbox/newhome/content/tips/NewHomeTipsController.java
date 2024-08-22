package com.baidu.searchbox.newhome.content.tips;

import android.content.Context;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.android.common.ui.style.R;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.briefhome.IBriefHomeApi;
import com.baidu.searchbox.config.eventmessage.HomeTabClickEvent;
import com.baidu.searchbox.feed.event.TabStateChangeEvent;
import com.baidu.searchbox.home.IHomeApi;
import com.baidu.searchbox.home.tips.HomeTipsController;
import com.baidu.searchbox.home.tips.HomeTipsItemModel;
import com.baidu.searchbox.home.tips.HomeTipsStatusManager;
import com.baidu.searchbox.homepage.extend.HomeBackgroundSkinInfo;
import com.baidu.searchbox.newhome.INewHomeEventListener;
import com.baidu.searchbox.newhome.content.widget.scroll.NewHomeScrollContainer;
import com.baidu.searchbox.newhome.extend.INewHomeApi;
import com.baidu.searchbox.newhome.inter.IHomeScrollSkinChangeEventListener;
import com.baidu.searchbox.newhome.tab.IHomeV1TabApi;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\rH\u0014J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\nH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020!2\u0006\u0010&\u001a\u00020\nH\u0016J@\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.H\u0016J$\u00101\u001a\u00020!2\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001032\u0006\u00105\u001a\u00020.H\u0016J \u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020\nH\u0016J\b\u0010:\u001a\u00020!H\u0016J\u0010\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020\nH\u0016J\b\u0010=\u001a\u00020!H\u0002J\u000e\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020\u0014J\u0010\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020\nH\u0016J\u0006\u0010B\u001a\u00020!R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/baidu/searchbox/newhome/content/tips/NewHomeTipsController;", "Lcom/baidu/searchbox/home/tips/HomeTipsController;", "Lcom/baidu/searchbox/newhome/INewHomeEventListener;", "Lcom/baidu/searchbox/newhome/inter/IHomeScrollSkinChangeEventListener;", "context", "Landroid/content/Context;", "container", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "defaultTabShowingTips", "", "Ljava/lang/Boolean;", "forbidRecoverPreviousStateSwitch", "", "getForbidRecoverPreviousStateSwitch", "()I", "forbidRecoverPreviousStateSwitch$delegate", "Lkotlin/Lazy;", "isFirstShowPage", "mHomeFeedContainer", "Lcom/baidu/searchbox/newhome/content/widget/scroll/NewHomeScrollContainer;", "mV1TabApi", "Lcom/baidu/searchbox/newhome/tab/IHomeV1TabApi;", "kotlin.jvm.PlatformType", "checkHomeStatusReady", "getContainerHeight", "getCurrOperation", "Lcom/baidu/searchbox/home/tips/HomeTipsItemModel;", "getFeedContentCurrentState", "getTopMargin", "isForbidRecoverPreviousState", "isTipsShowingToUser", "onContentSelectedChange", "", "isRecommendTab", "onDestroy", "onFontSizeChanged", "onHomeHeaderVisible", "visible", "onHomePageVisible", "onHomeScrollChange", "curX", "curY", "oldX", "oldY", "scrollYPct", "", "scrollYPctFromLogoTop", "scrollYPctFromSearchBoxTop", "onHomeScrollSkinChange", "fromSkinInfo", "Lcom/baidu/searchbox/homepage/extend/HomeBackgroundSkinInfo;", "toSkinInfo", "fromProgress", "onHomeStateChanged", "oldState", "newState", "byTouch", "onLazyUiReady", "onNightModeChanged", "isNight", "registerEvent", "setParent", "homeFeedContainer", "setTipsShowing", "isShowing", "ubcEventIfNeed", "new-home-content_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewHomeTipsController.kt */
public final class NewHomeTipsController extends HomeTipsController implements INewHomeEventListener, IHomeScrollSkinChangeEventListener {
    private Boolean defaultTabShowingTips;
    private final Lazy forbidRecoverPreviousStateSwitch$delegate = LazyKt.lazy(NewHomeTipsController$forbidRecoverPreviousStateSwitch$2.INSTANCE);
    private boolean isFirstShowPage = true;
    private NewHomeScrollContainer mHomeFeedContainer;
    private IHomeV1TabApi mV1TabApi = ((IHomeV1TabApi) ServiceManager.getService(IHomeV1TabApi.Companion.getSERVICE_REFERENCE()));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewHomeTipsController(Context context, ViewGroup container) {
        super(context, container);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        registerEvent();
    }

    public boolean onFragmentKeyDown(int keyCode, KeyEvent event) {
        return INewHomeEventListener.DefaultImpls.onFragmentKeyDown(this, keyCode, event);
    }

    public boolean onFragmentKeyUp(int keyCode, KeyEvent event) {
        return INewHomeEventListener.DefaultImpls.onFragmentKeyUp(this, keyCode, event);
    }

    private final int getForbidRecoverPreviousStateSwitch() {
        return ((Number) this.forbidRecoverPreviousStateSwitch$delegate.getValue()).intValue();
    }

    public void onNightModeChanged(boolean isNight) {
        super.onNightModeChanged(isNight);
    }

    public void onHomeHeaderVisible(boolean visible) {
        super.onHomeHeaderVisible(visible);
    }

    public void onHomeStateChanged(int oldState, int newState, boolean byTouch) {
        NewHomeScrollContainer newHomeScrollContainer;
        if (oldState == INewHomeApi.Companion.getSTATE_FEED() && newState == INewHomeApi.Companion.getSTATE_HOME() && HomeViewToolsKt.isFeedMain() && (newHomeScrollContainer = this.mHomeFeedContainer) != null) {
            newHomeScrollContainer.showTips();
        }
    }

    public void onFontSizeChanged() {
    }

    public void setTipsShowing(boolean isShowing) {
        NewHomeScrollContainer newHomeScrollContainer;
        super.setTipsShowing(isShowing);
        if (!isShowing && (newHomeScrollContainer = this.mHomeFeedContainer) != null) {
            newHomeScrollContainer.removeTips();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public void onLazyUiReady() {
    }

    public void onHomePageVisible(boolean visible) {
        if (visible) {
            updateTipsView();
            if (this.isFirstShowPage) {
                this.isFirstShowPage = false;
            } else {
                ubcEventIfNeed();
            }
        }
    }

    public void onHomeScrollChange(int curX, int curY, int oldX, int oldY, float scrollYPct, float scrollYPctFromLogoTop, float scrollYPctFromSearchBoxTop) {
    }

    public boolean checkHomeStatusReady() {
        if (!this.mV1TabApi.isCurrentRecommendTab()) {
            return false;
        }
        INewHomeApi mNewHomeApi = HomeViewToolsKt.getMNewHomeApi();
        if ((mNewHomeApi != null && mNewHomeApi.isHomePageVisible()) && HomeViewToolsKt.isFeedMain()) {
            return true;
        }
        return false;
    }

    private final void registerEvent() {
        BdEventBus.Companion.getDefault().register(this, TabStateChangeEvent.class, 1, new NewHomeTipsController$$ExternalSyntheticLambda0(this));
        BdEventBus.Companion.getDefault().register(this, HomeTabClickEvent.class, 1, new NewHomeTipsController$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* renamed from: registerEvent$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1593registerEvent$lambda0(com.baidu.searchbox.newhome.content.tips.NewHomeTipsController r5, com.baidu.searchbox.feed.event.TabStateChangeEvent r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r5.isForbidRecoverPreviousState()
            r1 = -1
            if (r0 != 0) goto L_0x002a
            java.lang.Boolean r0 = r5.defaultTabShowingTips
            if (r0 != 0) goto L_0x002a
            int r0 = r6.pageScrollState
            if (r0 != r1) goto L_0x002a
            boolean r0 = com.baidu.searchbox.newhome.content.tips.HomeViewToolsKt.isFeedMain()
            if (r0 != 0) goto L_0x002a
            boolean r0 = r5.isTipsShowingToUser()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r5.defaultTabShowingTips = r0
        L_0x002a:
            boolean r0 = com.baidu.searchbox.newhome.content.tips.HomeViewToolsKt.isFeedMain()
            r2 = 1
            if (r0 != 0) goto L_0x0051
            com.baidu.searchbox.newhome.extend.INewHomeApi$Companion r0 = com.baidu.searchbox.newhome.extend.INewHomeApi.Companion
            com.baidu.searchbox.newhome.extend.INewHomeApi r0 = r0.getNewHomeApi()
            r3 = 0
            if (r0 == 0) goto L_0x0047
            int r0 = r0.getHomeState()
            com.baidu.searchbox.newhome.extend.INewHomeApi$Companion r4 = com.baidu.searchbox.newhome.extend.INewHomeApi.Companion
            int r4 = r4.getSTATE_FEED()
            if (r0 != r4) goto L_0x0047
            r3 = r2
        L_0x0047:
            if (r3 == 0) goto L_0x0051
            com.baidu.searchbox.newhome.content.widget.scroll.NewHomeScrollContainer r0 = r5.mHomeFeedContainer
            if (r0 == 0) goto L_0x0075
            r0.hideTips()
            goto L_0x0075
        L_0x0051:
            int r0 = r5.updateTipsView()
            boolean r3 = r5.isForbidRecoverPreviousState()
            if (r3 != 0) goto L_0x0075
            r3 = 2
            if (r0 != r3) goto L_0x0075
            int r3 = r6.pageScrollState
            if (r3 != r1) goto L_0x0075
            java.lang.Boolean r3 = r5.defaultTabShowingTips
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0075
            com.baidu.searchbox.newhome.content.widget.scroll.NewHomeScrollContainer r2 = r5.mHomeFeedContainer
            if (r2 == 0) goto L_0x0075
            r2.showTips()
        L_0x0075:
            boolean r0 = r5.isForbidRecoverPreviousState()
            if (r0 != 0) goto L_0x0088
            int r0 = r6.pageScrollState
            if (r0 != r1) goto L_0x0088
            boolean r0 = com.baidu.searchbox.newhome.content.tips.HomeViewToolsKt.isFeedMain()
            if (r0 == 0) goto L_0x0088
            r0 = 0
            r5.defaultTabShowingTips = r0
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.newhome.content.tips.NewHomeTipsController.m1593registerEvent$lambda0(com.baidu.searchbox.newhome.content.tips.NewHomeTipsController, com.baidu.searchbox.feed.event.TabStateChangeEvent):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: registerEvent$lambda-1  reason: not valid java name */
    public static final void m1594registerEvent$lambda1(NewHomeTipsController this$0, HomeTabClickEvent it) {
        NewHomeScrollContainer newHomeScrollContainer;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        INewHomeApi mNewHomeApi = HomeViewToolsKt.getMNewHomeApi();
        boolean z = true;
        if (mNewHomeApi == null || !mNewHomeApi.isHomePageVisible()) {
            z = false;
        }
        if (z && HomeViewToolsKt.homeTabReClick(it) && (newHomeScrollContainer = this$0.mHomeFeedContainer) != null) {
            newHomeScrollContainer.showTips();
        }
    }

    private final boolean isForbidRecoverPreviousState() {
        return getForbidRecoverPreviousStateSwitch() == 1;
    }

    private final boolean isTipsShowingToUser() {
        if (getTipsView() == null || getTipsView().getVisibility() != 0) {
            return false;
        }
        NewHomeScrollContainer newHomeScrollContainer = this.mHomeFeedContainer;
        int scrollY = newHomeScrollContainer != null ? newHomeScrollContainer.getScrollY() : 0;
        NewHomeScrollContainer newHomeScrollContainer2 = this.mHomeFeedContainer;
        if (scrollY < (newHomeScrollContainer2 != null ? newHomeScrollContainer2.getTipsHeight() : 0)) {
            return true;
        }
        return false;
    }

    public int getContainerHeight() {
        return this.mContext.getResources().getDimensionPixelSize(R.dimen.dimen_ui_42);
    }

    public int getTopMargin() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.dimen_ui_3);
    }

    public void onContentSelectedChange(boolean isRecommendTab) {
        if (isRecommendTab) {
            updateTipsView();
            ubcEventIfNeed();
        }
    }

    public final void ubcEventIfNeed() {
        NewHomeScrollContainer newHomeScrollContainer = this.mHomeFeedContainer;
        boolean z = true;
        if (newHomeScrollContainer == null || !newHomeScrollContainer.isScrollTop()) {
            z = false;
        }
        if (z && HomeTipsStatusManager.INSTANCE.isTipsShowing() && this.mTipsView != null && this.mTipsView.getVisibility() == 0) {
            homeTipsUbcShow();
        }
    }

    /* access modifiers changed from: protected */
    public int getFeedContentCurrentState() {
        NewHomeScrollContainer newHomeScrollContainer = this.mHomeFeedContainer;
        if (newHomeScrollContainer != null) {
            return newHomeScrollContainer.getFeedContentCurrentState();
        }
        return 0;
    }

    public void onHomeScrollSkinChange(HomeBackgroundSkinInfo fromSkinInfo, HomeBackgroundSkinInfo toSkinInfo, float fromProgress) {
        super.onHomeScrollSkinChange(fromSkinInfo, toSkinInfo, fromProgress);
    }

    /* access modifiers changed from: protected */
    public HomeTipsItemModel getCurrOperation() {
        if (!IHomeApi.Companion.getHomeApi().isBriefHome() || !IBriefHomeApi.Companion.getBriefHomeApi().isThickBriefHomeStyle()) {
            return super.getCurrOperation();
        }
        return null;
    }

    public final void setParent(NewHomeScrollContainer homeFeedContainer) {
        Intrinsics.checkNotNullParameter(homeFeedContainer, "homeFeedContainer");
        this.mHomeFeedContainer = homeFeedContainer;
    }
}
