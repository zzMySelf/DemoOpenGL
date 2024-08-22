package com.baidu.swan.card.render.jscontainer.interfaces;

import android.view.View;
import android.webkit.ValueCallback;

public interface ISwanAppWebView extends JSContainer {
    public static final String APP_CACHE_PATH = "appcache";
    public static final String APP_DATABASE_PATH = "databases";
    public static final String APP_GEO_PATH = "geolocation";
    public static final int AUTO_FILL_SIZE = Integer.MIN_VALUE;

    void addJavascriptInterface(Object obj, String str);

    boolean canGoBack();

    View covertToView();

    void destroy();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    int getContentHeight();

    View getCurrentWebView();

    String getOriginalUrl();

    float getScale();

    int getWebViewScrollX();

    int getWebViewScrollY();

    void goBack();

    void setDefaultViewSize(int i2, int i3, String str);

    void setOnCommonEventHandler(OnCommonEventHandler onCommonEventHandler);

    void setOnWebViewHookHandler(OnWebViewHookHandler onWebViewHookHandler);

    void webViewScrollBy(int i2, int i3);

    void webViewScrollTo(int i2, int i3);
}
