package com.pichillilorenzo.flutter_inappwebview.types;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebMessage;
import android.webkit.WebView;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

public interface InAppWebViewInterface {
    void addWebMessageListener(WebMessageListener webMessageListener);

    void callAsyncJavaScript(String str, Map<String, Object> map, ContentWorld contentWorld, ValueCallback<String> valueCallback);

    boolean canGoBack();

    boolean canGoBackOrForward(int i2);

    boolean canGoForward();

    boolean canScrollHorizontally();

    boolean canScrollVertically();

    void clearAllCache();

    void clearFocus();

    void clearHistory();

    void clearMatches();

    void clearSslPreferences();

    WebMessageChannel createCompatWebMessageChannel();

    WebMessageChannel createWebMessageChannel(ValueCallback<WebMessageChannel> valueCallback);

    void disposeWebMessageChannels();

    void disposeWebMessageListeners();

    void evaluateJavascript(String str, ContentWorld contentWorld, ValueCallback<String> valueCallback);

    void findAllAsync(String str);

    void findNext(boolean z);

    SslCertificate getCertificate();

    int getContentHeight();

    void getContentHeight(ValueCallback<Integer> valueCallback);

    Context getContext();

    Map<String, Object> getContextMenu();

    HashMap<String, Object> getCopyBackForwardList();

    WebView.HitTestResult getHitTestResult();

    void getHitTestResult(ValueCallback<HitTestResult> valueCallback);

    InAppBrowserDelegate getInAppBrowserDelegate();

    Map<String, Object> getOptions();

    String getOriginalUrl();

    InAppWebViewFlutterPlugin getPlugin();

    int getProgress();

    int getScrollX();

    int getScrollY();

    void getSelectedText(ValueCallback<String> valueCallback);

    String getTitle();

    String getUrl();

    UserContentController getUserContentController();

    Map<String, WebMessageChannel> getWebMessageChannels();

    Looper getWebViewLooper();

    float getZoomScale();

    void getZoomScale(ValueCallback<Float> valueCallback);

    void goBack();

    void goBackOrForward(int i2);

    void goForward();

    void injectCSSCode(String str);

    void injectCSSFileFromUrl(String str, Map<String, Object> map);

    void injectJavascriptFileFromUrl(String str, Map<String, Object> map);

    boolean isLoading();

    void isSecureContext(ValueCallback<Boolean> valueCallback);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadFile(String str);

    void loadUrl(URLRequest uRLRequest);

    void onPause();

    void onResume();

    boolean pageDown(boolean z);

    boolean pageUp(boolean z);

    void pauseTimers();

    void postUrl(String str, byte[] bArr);

    void postWebMessage(WebMessage webMessage, Uri uri);

    void postWebMessage(WebMessage webMessage, Uri uri, ValueCallback<String> valueCallback);

    void printCurrentPage();

    void reload();

    Map<String, Object> requestFocusNodeHref();

    Map<String, Object> requestImageRef();

    void resumeTimers();

    void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback);

    void scrollBy(Integer num, Integer num2, Boolean bool);

    void scrollTo(Integer num, Integer num2, Boolean bool);

    void setContextMenu(Map<String, Object> map);

    void setInAppBrowserDelegate(InAppBrowserDelegate inAppBrowserDelegate);

    void setOptions(InAppWebViewOptions inAppWebViewOptions, HashMap<String, Object> hashMap);

    void setPlugin(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin);

    void setUserContentController(UserContentController userContentController);

    void setWebMessageChannels(Map<String, WebMessageChannel> map);

    void stopLoading();

    void takeScreenshot(Map<String, Object> map, MethodChannel.Result result);

    void zoomBy(float f);

    boolean zoomIn();

    boolean zoomOut();
}
