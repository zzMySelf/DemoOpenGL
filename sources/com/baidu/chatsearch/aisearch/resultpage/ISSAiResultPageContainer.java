package com.baidu.chatsearch.aisearch.resultpage;

import android.view.View;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J0\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017H&J\u001c\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010!\u001a\u00020\u000bH&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H\u0016J\u001e\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010+\u001a\u00020\u0003H\u0016J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\tH\u0016J\b\u0010.\u001a\u00020\u0003H&J\b\u0010/\u001a\u00020\u0003H&¨\u00060"}, d2 = {"Lcom/baidu/chatsearch/aisearch/resultpage/ISSAiResultPageContainer;", "", "doBackAction", "", "doBackHomeAction", "getAPageLid", "", "getContainerId", "getContainerState", "", "handleJumpToTab", "", "params", "handleMultiTabInfo", "handleTransportDurationParams", "extClickParams", "hideErrorPage", "hideMaskView", "jumpToLandingPage", "view", "Lcom/baidu/browser/sailor/BdSailorWebView;", "url", "extra", "", "onGraphEvent", "webView", "Lorg/json/JSONObject;", "onReceivedError", "errorCode", "description", "failingUrl", "onResultPageLog", "jsonObject", "parentIsCurrentWindow", "setTabMaskAlpha", "alpha", "", "setTabMaskClickListener", "listener", "Landroid/view/View$OnClickListener;", "shouldInterceptRequest", "Lcom/baidu/webkit/sdk/WebResourceResponse;", "p0", "showErrorPage", "showMaskView", "colorRes", "startSearch", "updateForwardView", "lib-chatsearch-resultpage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ISSAiResultPageContainer.kt */
public interface ISSAiResultPageContainer {
    void doBackAction();

    void doBackHomeAction();

    String getAPageLid();

    String getContainerId();

    int getContainerState();

    boolean handleJumpToTab(String str);

    boolean handleMultiTabInfo(String str);

    void handleTransportDurationParams(String str);

    void hideErrorPage();

    void hideMaskView();

    boolean jumpToLandingPage(BdSailorWebView bdSailorWebView, String str, Map<String, ? extends Object> map);

    void onGraphEvent(BdSailorWebView bdSailorWebView, JSONObject jSONObject);

    void onReceivedError(int i2, String str, String str2);

    void onResultPageLog(JSONObject jSONObject);

    boolean parentIsCurrentWindow();

    void setTabMaskAlpha(float f2);

    void setTabMaskClickListener(View.OnClickListener onClickListener);

    WebResourceResponse shouldInterceptRequest(BdSailorWebView bdSailorWebView, String str);

    void showErrorPage();

    void showMaskView(int i2);

    void startSearch();

    void updateForwardView();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ISSAiResultPageContainer.kt */
    public static final class DefaultImpls {
        public static void onReceivedError(ISSAiResultPageContainer iSSAiResultPageContainer, int errorCode, String description, String failingUrl) {
        }

        public static void showErrorPage(ISSAiResultPageContainer iSSAiResultPageContainer) {
        }

        public static void hideErrorPage(ISSAiResultPageContainer iSSAiResultPageContainer) {
        }

        public static WebResourceResponse shouldInterceptRequest(ISSAiResultPageContainer iSSAiResultPageContainer, BdSailorWebView p0, String url) {
            return null;
        }

        public static void showMaskView(ISSAiResultPageContainer iSSAiResultPageContainer, int colorRes) {
        }

        public static void hideMaskView(ISSAiResultPageContainer iSSAiResultPageContainer) {
        }

        public static void setTabMaskAlpha(ISSAiResultPageContainer iSSAiResultPageContainer, float alpha) {
        }

        public static void setTabMaskClickListener(ISSAiResultPageContainer iSSAiResultPageContainer, View.OnClickListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        public static void onGraphEvent(ISSAiResultPageContainer iSSAiResultPageContainer, BdSailorWebView webView, JSONObject params) {
        }

        public static void handleTransportDurationParams(ISSAiResultPageContainer iSSAiResultPageContainer, String extClickParams) {
        }

        public static boolean handleJumpToTab(ISSAiResultPageContainer iSSAiResultPageContainer, String params) {
            return false;
        }

        public static boolean handleMultiTabInfo(ISSAiResultPageContainer iSSAiResultPageContainer, String params) {
            return false;
        }

        public static void onResultPageLog(ISSAiResultPageContainer iSSAiResultPageContainer, JSONObject jsonObject) {
        }

        public static String getAPageLid(ISSAiResultPageContainer iSSAiResultPageContainer) {
            return null;
        }
    }
}
