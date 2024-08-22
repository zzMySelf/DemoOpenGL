package com.baidu.browser.explore.container;

import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.browser.explore.container.searchboxcontainer.data.UrlContainerModel;
import com.baidu.browser.explore.jsbridge.PrefetchInterface;
import com.baidu.browser.explore.mutable.feature.MutableContainerFeature;
import com.baidu.browser.framework.BeeBdFrameView;
import com.baidu.browser.framework.BeeBdWindow;
import com.baidu.browser.prefetch.PrefetchData;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.browserenhanceengine.container.IContainerManager;
import com.baidu.searchbox.lightbrowser.listener.BdPageDialogsHandler;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.toolbar.BaseToolBarItem;
import com.baidu.searchbox.ui.SearchTabInfoHolder;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.util.HashMap;
import java.util.Map;

public interface ISearchBoxContainer {
    boolean canGoBack();

    boolean canNotShowTagToast(String str);

    void closeSelf();

    View contentView();

    void delayCreateTopicBottomView();

    void dismissBrowserMenu();

    void dismissMoreTabLayout();

    void frameContextGoBack();

    void frameContextHideAddHomeScreenBanner();

    View getBottomBar();

    int getBottomViewHeight();

    boolean getCanUseRecycledWebView();

    FrameLayout getContainerFrameLayout();

    String getContainerId();

    IContainerManager getContainerManager();

    UrlContainerModel getContainerModel();

    int getContainerStatus();

    boolean getContainerTextZoomSwitch();

    int getContainerType();

    MutableContainerFeature getCurrentContainerFeature();

    String getCurrentContainerReferer();

    String getCurrentPageType(String str);

    String getCurrentPageUrl();

    String getEqid();

    int getErrorViewMarginTop();

    String getFinalPageType(String str, String str2);

    Rect getFloatViewSafeArea();

    BeeBdFrameView getFrameContext();

    String getH5LandingPageStyleType();

    String getH5LandingPageToolBarInfo();

    String getH5LandingPageType();

    BdPageDialogsHandler getPageDialogsHandler();

    PrefetchInterface getPrefetchInterface();

    String getQueryFromA();

    String getSearchBrowserType();

    SearchTabInfoHolder getSearchTabInfoHolder();

    String getTitle();

    String getUrl();

    String getUrlFromA();

    ViewGroup getWeakNetWorkParent();

    NgWebView getWebView();

    BeeBdWindow getWindow();

    void handleDelayInitSearchBox();

    HashMap<String, String> handleToolBarStat(BaseToolBarItem baseToolBarItem);

    void hideErrorPage();

    void initJavaScriptContainer(NgWebView ngWebView);

    boolean isAdLandingPage();

    boolean isBaseLandingPageContainer();

    boolean isChangeQuery(String str);

    boolean isCommentToolbarContainer();

    boolean isContainerAnimationPlaying();

    boolean isContainerColdBootRestore();

    boolean isCurrentMultiTabAll();

    boolean isEdgeTouch(MotionEvent motionEvent);

    boolean isLandingPageContainer();

    boolean isNaTopTagClick(String str);

    boolean isRestore();

    boolean isResultPageContainer();

    boolean isTabSelected();

    boolean isTagClickUrl(String str);

    boolean isTopicBarPreCreateStatus();

    boolean isWebViewEmpty();

    void loadUrl(String str, Map<String, String> map, PrefetchData prefetchData);

    void netChange(boolean z);

    void onDismissTalosPopupView(boolean z, boolean z2);

    void onErrorPageRefresh();

    void onErrorPageShow(boolean z);

    void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str);

    void onGestureFlingEnded(BdSailorWebView bdSailorWebView, int i2, int i3);

    void onGoBackOrForwardAnimationFinishCallback(BdSailorWebView bdSailorWebView, int i2);

    void onGoBackOrForwardAnimationStartCallback(BdSailorWebView bdSailorWebView, int i2);

    boolean onKeyDown(int i2, KeyEvent keyEvent);

    void onPageCommitVisible(String str);

    void onPageStartWeakNetworkDetect();

    void onPageStarted(BdSailorWebView bdSailorWebView, String str);

    void onPreRenderConfirm(String str, Boolean bool);

    void onReceivedMainResCustomResponseHeaders(String str, Map<String, String> map);

    void onReceivedTitle(BdSailorWebView bdSailorWebView, String str);

    void onScrollChanged(int i2, int i3, int i4, int i5);

    void onUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z, boolean z2, boolean z3);

    void reCreateBottomView();

    void refreshFrameLayoutBgColor();

    void removeTagInfo();

    void resetCanNotShowTagToast();

    void resetNaProtoDispatcher();

    void resetNaProtoDispatcher(boolean z, boolean z2);

    boolean resetRestore();

    void setContainerColdBootRestore(boolean z);

    void setContainerTextZoomSwitch(String str);

    boolean setContainerType(int i2);

    void setRefreshReload(boolean z);

    void setSearchBoxSessionExtraInfoCollectorWebViewStatus(String str);

    void setSiteTypeInfo(String str, String str2);

    boolean shouldBlockMediaRequest(BdSailorWebView bdSailorWebView, String str, String str2);

    WebResourceResponse shouldInterceptWebViewRequest(BdSailorWebView bdSailorWebView, String str, WebResourceRequest webResourceRequest);

    void showErrorPage();

    void showNaResultContainer(String str, String str2, String str3);

    void updateEmbeddedTitleBar(boolean z, boolean z2, boolean z3);
}
