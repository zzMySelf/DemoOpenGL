package com.baidu.browser.components.commonmenu.impl;

import android.webkit.ValueCallback;
import com.baidu.browser.arch.callback.IBrowserPageViewContext;
import com.baidu.browser.arch.component.IBrowserComponentManager;
import com.baidu.browser.components.commonmenu.core.CommonMenuClickBridger;
import com.baidu.browser.components.videotranscoding.IVideoTransService;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.core.utils.IncognitoModeUtil;
import com.baidu.searchbox.multiwindowinterface.MultiWindowInterface;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.search.pyramid.FavorPlayModel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\u0012\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\nH\u0016J$\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\n2\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/browser/components/commonmenu/impl/CommonMenuItemClickBridger;", "Lcom/baidu/browser/components/commonmenu/core/CommonMenuClickBridger;", "browserContext", "Lcom/baidu/browser/arch/callback/IBrowserPageViewContext;", "(Lcom/baidu/browser/arch/callback/IBrowserPageViewContext;)V", "fullScreenSwitchWithAnim", "", "b", "", "getCurrentUrl", "", "getDurationExtraInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getH5LandingPageBottomBarType", "getH5LandingPageScheme", "getLandingAdFaverData", "getLandingUri", "getMultiWindowCount", "", "getReferer", "getSearchBrowserType", "getSearchMovieFavorAGG", "Lcom/baidu/searchbox/search/pyramid/FavorPlayModel;", "pageUrl", "getShowState", "getTitle", "getType", "getUrl", "getViewHeight", "getWebPageTitle", "isIncognito", "loadJavaScript", "jsString", "callback", "Landroid/webkit/ValueCallback;", "switchToMultiWindow", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonMenuItemClickBridger.kt */
public final class CommonMenuItemClickBridger implements CommonMenuClickBridger {
    private final IBrowserPageViewContext browserContext;

    public CommonMenuItemClickBridger(IBrowserPageViewContext browserContext2) {
        Intrinsics.checkNotNullParameter(browserContext2, "browserContext");
        this.browserContext = browserContext2;
    }

    public void loadJavaScript(String jsString) {
        this.browserContext.loadJavaScript(jsString);
    }

    public void loadJavaScript(String jsString, ValueCallback<String> callback) {
        this.browserContext.loadJavaScript(jsString, callback);
    }

    public void fullScreenSwitchWithAnim(boolean b2) {
        this.browserContext.frameContextFullScreenSwitchWithAnim(b2);
    }

    public String getUrl() {
        String url = this.browserContext.getUrl();
        return url == null ? "" : url;
    }

    public String getCurrentUrl() {
        String currentUrl = this.browserContext.getCurrentUrl();
        return currentUrl == null ? "" : currentUrl;
    }

    public String getReferer() {
        String currentReferer = this.browserContext.getCurrentReferer();
        return currentReferer == null ? "" : currentReferer;
    }

    public String getTitle() {
        String title = this.browserContext.getTitle();
        return title == null ? "" : title;
    }

    public int getViewHeight() {
        return this.browserContext.getFrameContextViewHeight();
    }

    public void switchToMultiWindow() {
        this.browserContext.switchToMultiWindow();
    }

    public int getMultiWindowCount() {
        MultiWindowInterface multiWindowInterface = (MultiWindowInterface) ServiceManager.getService(MultiWindowInterface.SERVICE_REFERENCE);
        if (multiWindowInterface != null) {
            return multiWindowInterface.size(IncognitoModeUtil.isIncognitoSwitchOn());
        }
        return 1;
    }

    public String getType() {
        return "0";
    }

    public boolean isIncognito() {
        return IncognitoModeUtil.isIncognitoSwitchOn();
    }

    public String getSearchBrowserType() {
        return this.browserContext.getSearchBrowserType();
    }

    public int getShowState() {
        return this.browserContext.getShowState();
    }

    public String getLandingAdFaverData() {
        return this.browserContext.getLandingAdFaverData();
    }

    public String getH5LandingPageScheme() {
        return this.browserContext.getH5LandingPageScheme();
    }

    public String getH5LandingPageBottomBarType() {
        return this.browserContext.getH5LandingPageBottomBarType();
    }

    public String getLandingUri() {
        return this.browserContext.getLandingUri();
    }

    public HashMap<String, String> getDurationExtraInfo() {
        return this.browserContext.getDurationExtraInfo();
    }

    public FavorPlayModel getSearchMovieFavorAGG(String pageUrl) {
        IVideoTransService videoTransService = (IVideoTransService) this.browserContext.getComponentManager().getService(IVideoTransService.class);
        if (videoTransService == null) {
            return null;
        }
        return videoTransService.getSearchMovieFavorAGG(pageUrl);
    }

    public String getWebPageTitle() {
        IBrowserPageViewContext pageViewContext;
        NgWebView webView;
        IBrowserComponentManager componentManager = this.browserContext.getComponentManager();
        if (componentManager == null || (pageViewContext = componentManager.getPageViewContext()) == null || (webView = pageViewContext.getWebView()) == null) {
            return null;
        }
        return webView.getTitle();
    }
}
