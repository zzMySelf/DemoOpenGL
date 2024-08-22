package com.baidu.searchbox.feed.news.diverse.inner;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.android.common.menu.CommonMenuItem;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.feed.news.NewsDetailContainer;
import com.baidu.searchbox.feed.news.diverse.guide.NewsGuideViewController;
import com.baidu.searchbox.feed.news.leftslide.LeftSlideDrawerController;
import com.baidu.searchbox.feed.news.leftslide.LeftSlidePersonalPageController;
import com.baidu.searchbox.feed.news.leftslide.LeftSlidePersonalPageGuideView;
import com.baidu.searchbox.feed.pinchsummary.FeedPinchSummaryManager;
import com.baidu.searchbox.feed.statistic.FeedUBCWrapper;
import com.baidu.searchbox.feed.ui.drawerslide.DynamicSlideDrawerLayout;
import com.baidu.searchbox.lightbrowser.schemedispatch.UnitedSchemeEasyBrowserDynamicDispatcher;
import com.baidu.searchbox.lightbrowser.view.LightBrowserViewKt;
import com.baidu.searchbox.unitedscheme.UnitedSchemePriorityDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0011J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0006H\u0014J\b\u0010#\u001a\u00020\u0006H\u0014J\u0006\u0010$\u001a\u00020\u0011J\u0006\u0010%\u001a\u00020\u0011J\b\u0010&\u001a\u00020\u0011H\u0002J\u0006\u0010'\u001a\u00020\u0006J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020!H\u0016J\u0018\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0014J\u0010\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u0011H\u0016J\u0006\u00104\u001a\u00020\u0011J\u0006\u00105\u001a\u00020\u0011J\u0010\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u000208H\u0016J\u0006\u00109\u001a\u00020\u0011J\u0010\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020\u0011H\u0002J\b\u0010>\u001a\u00020\u0011H\u0002J\b\u0010?\u001a\u00020\u0011H\u0002J\u0010\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/baidu/searchbox/feed/news/diverse/inner/PushFlowFullNewsContainer;", "Lcom/baidu/searchbox/feed/news/NewsDetailContainer;", "frameContext", "Lcom/baidu/searchbox/feed/news/diverse/inner/IPushFlowAdapter;", "(Lcom/baidu/searchbox/feed/news/diverse/inner/IPushFlowAdapter;)V", "mDidShowUbc", "", "mGuideViewController", "Lcom/baidu/searchbox/feed/news/diverse/guide/NewsGuideViewController;", "mIsBottomState", "mPageFinished", "mReceivedShowGuide", "personalPageController", "Lcom/baidu/searchbox/feed/news/leftslide/LeftSlidePersonalPageController;", "videoData", "Lcom/baidu/searchbox/feed/news/diverse/inner/VideoContainerFirstItemData;", "addSpeedLogOnCreateBegin", "", "intent", "Landroid/content/Intent;", "addSubListener", "dispatcher", "Lcom/baidu/searchbox/lightbrowser/schemedispatch/UnitedSchemeEasyBrowserDynamicDispatcher;", "canSlideDrawer", "event", "Landroid/view/MotionEvent;", "changeSelfSelfElementWhenDrag", "checkAndHandleGuidViewState", "fontSizeChanged", "Lcom/baidu/searchbox/config/eventmessage/FontSizeChangeMessage;", "hideGuideViewImmediate", "initLeftSlidePersonalPage", "scheme", "", "isDrawerEnabled", "isNa", "markContainerSelected", "markContainerUnSelected", "mountGuidView", "notIntercept", "notifyPageFinished", "webView", "Lcom/baidu/browser/sailor/BdSailorWebView;", "url", "notifyScrollLayoutMoving", "scrollY", "", "oldScrollY", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onDrawerClosed", "onDrawerOpened", "onFloatWindowClick", "item", "Lcom/baidu/android/common/menu/CommonMenuItem;", "onLeftSlideBegin", "showGuideView", "guideView", "Lcom/baidu/searchbox/feed/news/leftslide/LeftSlidePersonalPageGuideView;", "showGuideViewWithAnim", "switchGuidView2NormalState", "switchGuidView2TipDragState", "ubcGuideView", "type", "lib-feed-news_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PushFlowFullNewsContainer.kt */
public final class PushFlowFullNewsContainer extends NewsDetailContainer {
    /* access modifiers changed from: private */
    public final IPushFlowAdapter frameContext;
    /* access modifiers changed from: private */
    public boolean mDidShowUbc;
    /* access modifiers changed from: private */
    public NewsGuideViewController mGuideViewController;
    /* access modifiers changed from: private */
    public boolean mIsBottomState;
    private boolean mPageFinished;
    /* access modifiers changed from: private */
    public boolean mReceivedShowGuide;
    private LeftSlidePersonalPageController personalPageController;
    private VideoContainerFirstItemData videoData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PushFlowFullNewsContainer(IPushFlowAdapter frameContext2) {
        super(frameContext2);
        Intrinsics.checkNotNullParameter(frameContext2, "frameContext");
        this.frameContext = frameContext2;
    }

    public void notifyPageFinished(BdSailorWebView webView, String url) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(url, "url");
        super.notifyPageFinished(webView, url);
        this.mPageFinished = true;
        mountGuidView();
    }

    /* access modifiers changed from: protected */
    public boolean isNa() {
        return false;
    }

    public void onFloatWindowClick(CommonMenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        super.onFloatWindowClick(item);
    }

    public void addSpeedLogOnCreateBegin(Intent intent) {
        super.addSpeedLogOnCreateBegin(intent);
        this.mFrameSource = "push";
        this.mSubFrameSource = "newsFlow";
    }

    /* access modifiers changed from: protected */
    public boolean fontSizeChanged(FontSizeChangeMessage event) {
        NewsGuideViewController newsGuideViewController = this.mGuideViewController;
        if (newsGuideViewController != null) {
            newsGuideViewController.fontSizeChanged();
        }
        return super.fontSizeChanged(event);
    }

    public void onDestroy() {
        NewsGuideViewController newsGuideViewController = this.mGuideViewController;
        if (newsGuideViewController != null) {
            newsGuideViewController.onDestroy();
        }
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        showGuideViewWithAnim();
        super.onConfigurationChanged(newConfig);
    }

    /* access modifiers changed from: protected */
    public void addSubListener(UnitedSchemeEasyBrowserDynamicDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, UnitedSchemePriorityDispatcher.SCHEME_PATH_DISPATCHER);
        super.addSubListener(dispatcher);
        dispatcher.setPushGuideViewListener(new PushFlowFullNewsContainer$addSubListener$1(this));
    }

    /* access modifiers changed from: protected */
    public void notifyScrollLayoutMoving(int scrollY, int oldScrollY) {
        NewsGuideViewController newsGuideViewController;
        super.notifyScrollLayoutMoving(scrollY, oldScrollY);
        if (getBrowserView() != null) {
            boolean z = !getBrowserView().canScrollInVertical(1);
            this.mIsBottomState = z;
            if (z) {
                this.frameContext.notifyLinkageReachBottom();
                VideoContainerFirstItemData firstVideoData = this.frameContext.getFirstVideoData();
                this.videoData = firstVideoData;
                if (this.mReceivedShowGuide && (newsGuideViewController = this.mGuideViewController) != null) {
                    newsGuideViewController.switchNewsGuideWithAnim(firstVideoData);
                }
            }
            checkAndHandleGuidViewState();
        }
    }

    private final void mountGuidView() {
        if (this.mGuideViewController == null) {
            this.mGuideViewController = new NewsGuideViewController(getActivity());
        }
        NewsGuideViewController newsGuideViewController = this.mGuideViewController;
        if (newsGuideViewController != null) {
            newsGuideViewController.initNewsGuideView(getRootView());
        }
        NewsGuideViewController newsGuideViewController2 = this.mGuideViewController;
        if (newsGuideViewController2 != null) {
            newsGuideViewController2.setOnNewsGuideClickListener(new PushFlowFullNewsContainer$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mountGuidView$lambda-0  reason: not valid java name */
    public static final void m18808mountGuidView$lambda0(PushFlowFullNewsContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ubcGuideView("click");
        this$0.frameContext.requestScrollToNext();
    }

    /* access modifiers changed from: private */
    public final void checkAndHandleGuidViewState() {
        if (this.mIsBottomState) {
            switchGuidView2TipDragState();
        } else {
            switchGuidView2NormalState();
        }
    }

    private final void switchGuidView2TipDragState() {
        NewsGuideViewController newsGuideViewController = this.mGuideViewController;
        if (newsGuideViewController != null) {
            newsGuideViewController.updateGuideState("2");
        }
    }

    private final void switchGuidView2NormalState() {
        NewsGuideViewController newsGuideViewController = this.mGuideViewController;
        if (newsGuideViewController != null) {
            newsGuideViewController.updateGuideState("1");
        }
    }

    private final void hideGuideViewImmediate() {
        NewsGuideViewController newsGuideViewController = this.mGuideViewController;
        if (newsGuideViewController != null) {
            newsGuideViewController.goneNewsGuide();
        }
    }

    /* access modifiers changed from: private */
    public final void showGuideViewWithAnim() {
        VideoContainerFirstItemData firstVideoData = this.frameContext.getFirstVideoData();
        this.videoData = firstVideoData;
        NewsGuideViewController newsGuideViewController = this.mGuideViewController;
        if (newsGuideViewController != null) {
            newsGuideViewController.showNewsGuide(true, firstVideoData);
        }
    }

    /* access modifiers changed from: private */
    public final void ubcGuideView(String type) {
        JSONObject map = new JSONObject();
        try {
            JSONObject ext = new JSONObject();
            ext.put("push_rid", getNid());
            VideoContainerFirstItemData videoContainerFirstItemData = this.videoData;
            String str = null;
            ext.put("rid", videoContainerFirstItemData != null ? videoContainerFirstItemData.getNid() : null);
            map.put("from", "feed");
            map.put("source", "push");
            map.put("type", type);
            NewsGuideViewController newsGuideViewController = this.mGuideViewController;
            String currentGuideState = newsGuideViewController != null ? newsGuideViewController.getCurrentGuideState() : null;
            String str2 = "1";
            if (currentGuideState == null) {
                currentGuideState = str2;
            }
            map.put("page", currentGuideState);
            NewsGuideViewController newsGuideViewController2 = this.mGuideViewController;
            if (newsGuideViewController2 != null) {
                str = newsGuideViewController2.getCurrentViewState();
            }
            if (str != null) {
                str2 = str;
            }
            map.put("value", str2);
            map.put("ext", ext);
            FeedUBCWrapper.ubcOnEvent("5819", map);
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }

    public final void markContainerUnSelected() {
        hideGuideViewImmediate();
    }

    public final void markContainerSelected() {
        LeftSlidePersonalPageController leftSlidePersonalPageController;
        if (this.mReceivedShowGuide) {
            checkAndHandleGuidViewState();
            showGuideViewWithAnim();
            if (LeftSlideDrawerController.Companion.cloudAllowLeftSlide() && (leftSlidePersonalPageController = this.personalPageController) != null) {
                leftSlidePersonalPageController.getPersonalPageView();
            }
        }
    }

    public final void changeSelfSelfElementWhenDrag() {
        checkAndHandleGuidViewState();
    }

    public final boolean notIntercept() {
        return this.mIsBottomState && this.mPageFinished;
    }

    /* access modifiers changed from: protected */
    public boolean isDrawerEnabled() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void initLeftSlidePersonalPage(String scheme) {
        if (LeftSlideDrawerController.Companion.cloudAllowLeftSlide() && this.personalPageController == null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            LeftSlidePersonalPageController leftSlidePersonalPageController = new LeftSlidePersonalPageController(activity, new PushFlowFullNewsContainer$initLeftSlidePersonalPage$1(this), scheme);
            this.personalPageController = leftSlidePersonalPageController;
            String nid = getNid();
            Intrinsics.checkNotNullExpressionValue(nid, "nid");
            LeftSlidePersonalPageGuideView guideView = leftSlidePersonalPageController.getGuideViewIfNeed(nid);
            if (guideView != null) {
                if (FeedPinchSummaryManager.Companion.isSupportPinchSummary(getActivity())) {
                    FeedPinchSummaryManager.Companion companion = FeedPinchSummaryManager.Companion;
                    String nid2 = getNid();
                    Intrinsics.checkNotNullExpressionValue(nid2, "nid");
                    companion.getGuideStrategyContext(nid2).executeGuideStrategy(new PushFlowFullNewsContainer$initLeftSlidePersonalPage$2(this, guideView));
                } else {
                    showGuideView(guideView);
                }
            }
            this.frameContext.setLeftSlideEnabled(true);
        }
    }

    /* access modifiers changed from: private */
    public final void showGuideView(LeftSlidePersonalPageGuideView guideView) {
        if (!ActivityUtils.isDestroyed(getActivity())) {
            ViewParent parent = ((ViewGroup) getActivity().findViewById(16908290)).getParent();
            ViewGroup viewParent = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewParent != null) {
                viewParent.addView(guideView, new ViewGroup.LayoutParams(-1, -1));
            }
            String nid = getNid();
            Intrinsics.checkNotNullExpressionValue(nid, "nid");
            guideView.playAnim(nid);
        }
    }

    public final void onLeftSlideBegin() {
        LeftSlidePersonalPageController leftSlidePersonalPageController;
        LeftSlidePersonalPageController leftSlidePersonalPageController2 = this.personalPageController;
        if (leftSlidePersonalPageController2 != null) {
            boolean z = false;
            if (leftSlidePersonalPageController2 != null && !leftSlidePersonalPageController2.getGotPersonalView()) {
                z = true;
            }
            if (z && (leftSlidePersonalPageController = this.personalPageController) != null) {
                leftSlidePersonalPageController.getPersonalPageView();
            }
        }
    }

    public final void onDrawerOpened() {
        LeftSlidePersonalPageController leftSlidePersonalPageController = this.personalPageController;
        if (leftSlidePersonalPageController != null) {
            leftSlidePersonalPageController.onDrawerOpened();
        }
        FeedPinchSummaryManager.Companion companion = FeedPinchSummaryManager.Companion;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        companion.savePinchSummaryStatus(activity);
    }

    public final void onDrawerClosed() {
        LeftSlidePersonalPageController leftSlidePersonalPageController = this.personalPageController;
        if (leftSlidePersonalPageController != null) {
            leftSlidePersonalPageController.onDrawerClosed();
        }
        FeedPinchSummaryManager.Companion companion = FeedPinchSummaryManager.Companion;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        companion.resetPinchSummaryStatus(activity);
    }

    public final boolean canSlideDrawer(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!DynamicSlideDrawerLayout.Companion.getDrawerInterceptAbSwitch()) {
            LeftSlidePersonalPageController leftSlidePersonalPageController = this.personalPageController;
            return leftSlidePersonalPageController != null && !leftSlidePersonalPageController.isGuideViewAnimPlaying();
        } else if (!this.frameContext.isDrawerClosed()) {
            return true;
        } else {
            LeftSlidePersonalPageController leftSlidePersonalPageController2 = this.personalPageController;
            if (!(leftSlidePersonalPageController2 != null && !leftSlidePersonalPageController2.isGuideViewAnimPlaying()) || !LightBrowserViewKt.isValid(this.mBrowserView) || !this.mBrowserView.canSlide(event)) {
                return false;
            }
            return true;
        }
    }
}
