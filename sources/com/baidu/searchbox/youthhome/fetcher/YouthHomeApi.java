package com.baidu.searchbox.youthhome.fetcher;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.home.feed.CeilingScene;
import com.baidu.searchbox.home.ioc.HomeRuntime;
import com.baidu.searchbox.homepage.extend.HomeBackgroundSkinInfo;
import com.baidu.searchbox.homepage.extend.IHomeFun;
import com.baidu.searchbox.kmm.home.youth.YouthHomeLv1TabMgr;
import com.baidu.searchbox.kmm.home.youth.YouthHomeLv1TabModel;
import com.baidu.searchbox.kmm.home.youth.YouthHomeSwitchMgr;
import com.baidu.searchbox.youthhome.IYouthHomeApi;
import com.baidu.searchbox.youthhome.IYouthHomeEventListener;
import com.baidu.searchbox.youthhome.YouthHomeMgr;
import com.baidu.searchbox.youthhome.ioc.YouthHomeRuntime;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\tH\u0017J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017J\b\u0010\f\u001a\u00020\rH\u0017J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0017J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\tH\u0017J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\tH\u0017J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\tH\u0017J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0017J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\u0016H\u0017J\b\u0010&\u001a\u00020\u0016H\u0016J\b\u0010'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020\u0016H\u0016J\b\u0010)\u001a\u00020\u0016H\u0016J\b\u0010*\u001a\u00020\u0016H\u0016J\b\u0010+\u001a\u00020\u0004H\u0016J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0016H\u0016J\u0010\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\rH\u0016J\u0010\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\rH\u0017J\b\u00103\u001a\u00020\u0004H\u0016¨\u00064"}, d2 = {"Lcom/baidu/searchbox/youthhome/fetcher/YouthHomeApi;", "Lcom/baidu/searchbox/youthhome/IYouthHomeApi;", "()V", "addYouthHomeEventListener", "", "listener", "Lcom/baidu/searchbox/youthhome/IYouthHomeEventListener;", "checkApiUseError", "getCeilingScene", "Lcom/baidu/searchbox/home/feed/CeilingScene;", "getCurrentTabId", "", "getHomeState", "", "getHomeView", "Landroid/widget/FrameLayout;", "getScrollEventSource", "getSearchBoxHeight", "getV1TabHeight", "getYouthHomeScrollState", "goHome", "anim", "", "params", "goHomeForExitRetention", "goToFeed", "ceilingSource", "goToFeedWithAnim", "goToFeedWithoutAnim", "goToFeedWithoutAnimOnlyInHome", "goToV1TabDefault", "isForce", "gotoHome", "gotoTopWithoutAnim", "homeShowUbcEvent", "isCurrentRecommendTab", "isHaveConfirmUseMobileData", "isHeaderVisible", "isHomePageVisible", "isHomeTabShow", "isRestored", "isUIReady", "isYouthHome", "onWarmPermissionDialogConfirm", "removeYouthHomeEventListener", "setHasConfirmUseMobileData", "hasConfirmUseMobileData", "setHomeState", "homeState", "setScrollEventSource", "eventSource", "setYouthModeInfo", "youth-home-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: YouthHomeApi.kt */
public final class YouthHomeApi implements IYouthHomeApi {
    public static final YouthHomeApi INSTANCE = new YouthHomeApi();

    private YouthHomeApi() {
    }

    @Deprecated(message = "年轻化首页，不能添加view")
    public void addView(View view2, FrameLayout.LayoutParams layoutParams) {
        IYouthHomeApi.DefaultImpls.addView(this, view2, layoutParams);
    }

    @Deprecated(message = "年轻化首页，背景固定")
    public View getHomeBackground() {
        return IYouthHomeApi.DefaultImpls.getHomeBackground(this);
    }

    @Deprecated(message = "年轻化首页，页面无需此状态")
    public View getHomeContainer() {
        return IYouthHomeApi.DefaultImpls.getHomeContainer(this);
    }

    @Deprecated(message = "年轻化首页，页面无需此状态")
    public int getHomeHeaderHeight() {
        return IYouthHomeApi.DefaultImpls.getHomeHeaderHeight(this);
    }

    @Deprecated(message = "年轻化首页，页面无需此状态")
    public IHomeFun.IHomeHeaderHeightChangeListener getHomeHeaderHeightChangeListener() {
        return IYouthHomeApi.DefaultImpls.getHomeHeaderHeightChangeListener(this);
    }

    @Deprecated(message = "年轻化首页，页面不能滚动")
    public int getHomeScrollRange() {
        return IYouthHomeApi.DefaultImpls.getHomeScrollRange(this);
    }

    @Deprecated(message = "年轻化首页，页面不能滚动")
    public int getHomeScrollY() {
        return IYouthHomeApi.DefaultImpls.getHomeScrollY(this);
    }

    @Deprecated(message = "年轻化首页，页面不能滚动")
    public int getScrollRangeHomeToFeed() {
        return IYouthHomeApi.DefaultImpls.getScrollRangeHomeToFeed(this);
    }

    @Deprecated(message = "年轻化首页，页面不能滚动")
    public int getScrollState() {
        return IYouthHomeApi.DefaultImpls.getScrollState(this);
    }

    @Deprecated(message = "年轻化首页，没有皮肤")
    public boolean hasFeedDrawable() {
        return IYouthHomeApi.DefaultImpls.hasFeedDrawable(this);
    }

    public boolean isCurrentChannelImmersion() {
        return IYouthHomeApi.DefaultImpls.isCurrentChannelImmersion(this);
    }

    @Deprecated(message = "年轻化首页，目前没有RN页面")
    public boolean isCurrentTabRN() {
        return IYouthHomeApi.DefaultImpls.isCurrentTabRN(this);
    }

    @Deprecated(message = "年轻化首页，无皮肤")
    public boolean isHomeLightBg() {
        return IYouthHomeApi.DefaultImpls.isHomeLightBg(this);
    }

    public boolean isYouthModeSupportFontSize() {
        return IYouthHomeApi.DefaultImpls.isYouthModeSupportFontSize(this);
    }

    public boolean isYouthModeSupportNightMode() {
        return IYouthHomeApi.DefaultImpls.isYouthModeSupportNightMode(this);
    }

    @Deprecated(message = "年轻化首页，没有皮肤")
    public void setFeedBannerDrawable(Drawable feedDrawable, boolean isAnim, HomeBackgroundSkinInfo skinInfo) {
        IYouthHomeApi.DefaultImpls.setFeedBannerDrawable(this, feedDrawable, isAnim, skinInfo);
    }

    @Deprecated(message = "年轻化首页，页面无需此状态")
    public void setHomeHeaderHeightChangeListener(IHomeFun.IHomeHeaderHeightChangeListener listener) {
        IYouthHomeApi.DefaultImpls.setHomeHeaderHeightChangeListener(this, listener);
    }

    public boolean tryScrollFromImmersionToFeed(int scrollState, float scrollProgress) {
        return IYouthHomeApi.DefaultImpls.tryScrollFromImmersionToFeed(this, scrollState, scrollProgress);
    }

    public boolean isYouthHome() {
        return YouthHomeSwitchMgr.INSTANCE.isYouthHome();
    }

    public void addYouthHomeEventListener(IYouthHomeEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        YouthHomeMgr.INSTANCE.addYouthHomeEventListener(listener);
    }

    public void removeYouthHomeEventListener(IYouthHomeEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        YouthHomeMgr.INSTANCE.removeYouthHomeEventListener(listener);
    }

    public boolean isHomePageVisible() {
        return YouthHomeMgr.INSTANCE.isHomePageVisible();
    }

    public boolean isHomeTabShow() {
        return YouthHomeMgr.INSTANCE.isHomeTabShow();
    }

    public boolean isCurrentRecommendTab() {
        YouthHomeLv1TabModel currentSelectedTab = YouthHomeLv1TabMgr.INSTANCE.getCurrentSelectedTab();
        return Intrinsics.areEqual((Object) currentSelectedTab != null ? currentSelectedTab.getTabId() : null, (Object) "215");
    }

    public boolean gotoHome() {
        return YouthHomeMgr.INSTANCE.goToHome();
    }

    public void goToFeed(CeilingScene ceilingSource) {
        YouthHomeMgr.INSTANCE.goToFeed();
    }

    public void goHome(boolean anim, String params) {
        YouthHomeMgr.INSTANCE.goHome(anim, params);
    }

    public void goToV1TabDefault(boolean isForce) {
        YouthHomeMgr.INSTANCE.goToV1TabDefault(isForce);
    }

    public void goHomeForExitRetention(boolean anim, String params) {
        YouthHomeMgr.INSTANCE.goHomeForExitRetention(anim, params);
    }

    public FrameLayout getHomeView() {
        return YouthHomeMgr.INSTANCE.getHomeView();
    }

    public void onWarmPermissionDialogConfirm() {
        YouthHomeMgr.INSTANCE.onWarmPermissionDialogConfirm();
    }

    public boolean isUIReady() {
        return YouthHomeMgr.INSTANCE.isUIReady();
    }

    public boolean isHaveConfirmUseMobileData() {
        return YouthHomeMgr.INSTANCE.isHaveConfirmUseMobileData();
    }

    public void setHasConfirmUseMobileData(boolean hasConfirmUseMobileData) {
        YouthHomeMgr.INSTANCE.setHasConfirmUseMobileData(hasConfirmUseMobileData);
    }

    @Deprecated(message = "年轻化首页无此状态，不建议使用")
    public int getHomeState() {
        return YouthHomeMgr.INSTANCE.getHomeState();
    }

    public int getSearchBoxHeight() {
        return YouthHomeMgr.INSTANCE.getSearchBoxHeight();
    }

    public int getV1TabHeight() {
        return YouthHomeMgr.INSTANCE.getV1TabHeight();
    }

    public void setHomeState(int homeState) {
        YouthHomeMgr.INSTANCE.setHomeState(homeState);
    }

    public int getYouthHomeScrollState() {
        return YouthHomeMgr.INSTANCE.getYouthHomeScrollState();
    }

    public void homeShowUbcEvent() {
        HomeRuntime.INSTANCE.getHomeSupportContext().homeShowUbcEvent();
    }

    public boolean isRestored() {
        return YouthHomeMgr.INSTANCE.isRestored();
    }

    public void setYouthModeInfo() {
        YouthHomeRuntime.INSTANCE.getHomeAppContext().setYouthModeInfoToCookie();
    }

    @Deprecated(message = "年轻化首页，没有feed tab")
    public String getCurrentTabId() {
        return YouthHomeMgr.INSTANCE.getCurrentTabId();
    }

    @Deprecated(message = "年轻化首页无此状态，不建议使用")
    public void setScrollEventSource(int eventSource) {
        YouthHomeMgr.INSTANCE.setScrollEventSource(eventSource);
    }

    @Deprecated(message = "年轻化首页无此状态，不建议使用")
    public int getScrollEventSource() {
        return YouthHomeMgr.INSTANCE.getScrollEventSource();
    }

    @Deprecated(message = "年轻化首页无此状态，不建议使用")
    public boolean gotoTopWithoutAnim() {
        return YouthHomeMgr.INSTANCE.goToHome();
    }

    @Deprecated(message = "年轻化首页无此状态，不建议使用")
    public void goToFeedWithoutAnim(CeilingScene ceilingSource) {
        Intrinsics.checkNotNullParameter(ceilingSource, "ceilingSource");
        YouthHomeMgr.INSTANCE.goToFeedWithoutAnim(ceilingSource);
    }

    @Deprecated(message = "年轻化首页无此状态，不建议使用")
    public void goToFeedWithoutAnimOnlyInHome(CeilingScene ceilingSource) {
        Intrinsics.checkNotNullParameter(ceilingSource, "ceilingSource");
        YouthHomeMgr.INSTANCE.goToFeedWithoutAnimOnlyInHome(ceilingSource);
    }

    @Deprecated(message = "年轻化首页无此状态，不建议使用")
    public void goToFeedWithAnim(CeilingScene ceilingSource) {
        Intrinsics.checkNotNullParameter(ceilingSource, "ceilingSource");
        YouthHomeMgr.INSTANCE.goToFeedWithoutAnim(ceilingSource);
    }

    @Deprecated(message = "年轻化首页无此状态，请勿使用")
    public CeilingScene getCeilingScene() {
        return YouthHomeMgr.INSTANCE.getCeilingScene();
    }

    @Deprecated(message = "年轻化首页无此状态，请勿使用")
    public boolean isHeaderVisible() {
        return YouthHomeMgr.INSTANCE.isHeaderVisible();
    }

    public void checkApiUseError() {
        if (AppConfig.isDebug()) {
            throw new DebugException("年轻化首页默认下不支持该API");
        }
    }
}
