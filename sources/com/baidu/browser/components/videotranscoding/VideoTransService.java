package com.baidu.browser.components.videotranscoding;

import com.baidu.browser.BrowserInfo;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.search.pyramid.FavorPlayModel;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001dH\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)H\u0016J6\u0010*\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010\t2\b\u0010,\u001a\u0004\u0018\u00010\t2\u0006\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020%H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/baidu/browser/components/videotranscoding/VideoTransService;", "Lcom/baidu/browser/components/videotranscoding/IVideoTransService;", "component", "Lcom/baidu/browser/components/videotranscoding/VideoTransComponent;", "(Lcom/baidu/browser/components/videotranscoding/VideoTransComponent;)V", "clearPlayUbcData", "", "getH5PlayUbcData", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getOriginUrl", "url", "getSearchMovieFavorAGG", "Lcom/baidu/searchbox/search/pyramid/FavorPlayModel;", "pageUrl", "getTitle", "getVideoTransStatistics", "Lcom/baidu/browser/components/videotranscoding/VideoTransStatistics;", "handleCommonJsMessage", "message", "Lorg/json/JSONObject;", "interceptWebViewRequest", "Lcom/baidu/webkit/sdk/WebResourceResponse;", "webView", "Lcom/baidu/browser/sailor/BdSailorWebView;", "request", "Lcom/baidu/webkit/sdk/WebResourceRequest;", "isFirstTrans", "", "isFirstTransLoadingShow", "isVideoTransNaShown", "setBrowserInfo", "browserInfo", "Lcom/baidu/browser/BrowserInfo;", "setVideoTrans", "transcoding", "", "shouldInjectTransNaJavaScript", "updatePlayStartTime", "startTime", "", "videoPrefetch", "videoUrl", "source", "prefetchSize", "prefetchDuration", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTransService.kt */
public final class VideoTransService implements IVideoTransService {
    private final VideoTransComponent component;

    public VideoTransService(VideoTransComponent component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        this.component = component2;
    }

    public WebResourceResponse interceptWebViewRequest(BdSailorWebView webView, WebResourceRequest request) {
        return this.component.interceptWebViewRequest(webView, request);
    }

    public void setVideoTrans(int transcoding) {
        this.component.setVideoTrans(transcoding);
    }

    public VideoTransStatistics getVideoTransStatistics(String url) {
        return this.component.getVideoTransStatistics(url);
    }

    public boolean shouldInjectTransNaJavaScript() {
        return this.component.shouldInjectTransNaJavaScript();
    }

    public void handleCommonJsMessage(JSONObject message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.component.handleCommonJsMessage(message);
    }

    public boolean isVideoTransNaShown(BdSailorWebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return this.component.isVideoTransNaShown(webView);
    }

    public void setBrowserInfo(BrowserInfo browserInfo) {
        Intrinsics.checkNotNullParameter(browserInfo, "browserInfo");
        this.component.setBrowserInfo(browserInfo);
    }

    public ConcurrentHashMap<String, Object> getH5PlayUbcData() {
        return this.component.getH5PlayUbcData();
    }

    public void clearPlayUbcData() {
        this.component.clearPlayUbcData();
    }

    public void updatePlayStartTime(long startTime) {
        this.component.updatePlayStartTime(startTime);
    }

    public String getOriginUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return this.component.getOriginUrl(url);
    }

    public void videoPrefetch(String pageUrl, String videoUrl, String source, int prefetchSize, int prefetchDuration) {
        this.component.videoPrefetch(pageUrl, videoUrl, source, prefetchSize, prefetchDuration);
    }

    public boolean isFirstTrans(String pageUrl) {
        return this.component.isFirstTrans(pageUrl);
    }

    public FavorPlayModel getSearchMovieFavorAGG(String pageUrl) {
        return this.component.getSearchMovieFavorAGG(pageUrl);
    }

    public boolean isFirstTransLoadingShow(BdSailorWebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return this.component.isFirstTransLoadingShow(webView);
    }

    public String getTitle(String pageUrl) {
        return this.component.getTitle(pageUrl);
    }
}
