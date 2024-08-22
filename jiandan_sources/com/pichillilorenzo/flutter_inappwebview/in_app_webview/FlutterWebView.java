package com.pichillilorenzo.flutter_inappwebview.in_app_webview;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import androidx.webkit.WebViewRenderProcessClient;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler;
import com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.JavaScriptBridgeJS;
import com.pichillilorenzo.flutter_inappwebview.pull_to_refresh.PullToRefreshLayout;
import com.pichillilorenzo.flutter_inappwebview.pull_to_refresh.PullToRefreshOptions;
import com.pichillilorenzo.flutter_inappwebview.types.PlatformWebView;
import com.pichillilorenzo.flutter_inappwebview.types.URLRequest;
import com.pichillilorenzo.flutter_inappwebview.types.UserScript;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.http2.Http2ExchangeCodec;

public class FlutterWebView implements PlatformWebView {
    public static final String LOG_TAG = "IAWFlutterWebView";
    public final MethodChannel channel;
    public InAppWebViewMethodHandler methodCallDelegate;
    public PullToRefreshLayout pullToRefreshLayout;
    public InAppWebView webView;

    public FlutterWebView(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, Context context, Object obj, HashMap<String, Object> hashMap) {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin2 = inAppWebViewFlutterPlugin;
        HashMap<String, Object> hashMap2 = hashMap;
        BinaryMessenger binaryMessenger = inAppWebViewFlutterPlugin2.messenger;
        this.channel = new MethodChannel(binaryMessenger, "com.pichillilorenzo/flutter_inappwebview_" + obj);
        DisplayListenerProxy displayListenerProxy = new DisplayListenerProxy();
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        displayListenerProxy.onPreWebViewInitialization(displayManager);
        Map map = (Map) hashMap2.get("contextMenu");
        Integer num = (Integer) hashMap2.get("windowId");
        List<Map> list = (List) hashMap2.get("initialUserScripts");
        Map map2 = (Map) hashMap2.get("pullToRefreshOptions");
        InAppWebViewOptions inAppWebViewOptions = new InAppWebViewOptions();
        inAppWebViewOptions.parse((Map) hashMap2.get("initialOptions"));
        if (inAppWebViewFlutterPlugin2 != null && inAppWebViewFlutterPlugin2.activity != null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (Map fromMap : list) {
                    arrayList.add(UserScript.fromMap(fromMap));
                }
            }
            InAppWebView inAppWebView = r1;
            InAppWebViewOptions inAppWebViewOptions2 = inAppWebViewOptions;
            Map map3 = map2;
            InAppWebView inAppWebView2 = new InAppWebView(context, inAppWebViewFlutterPlugin, this.channel, obj, num, inAppWebViewOptions, map, inAppWebViewOptions.useHybridComposition.booleanValue() ? null : inAppWebViewFlutterPlugin2.flutterView, arrayList);
            this.webView = inAppWebView;
            displayListenerProxy.onPostWebViewInitialization(displayManager);
            if (inAppWebViewOptions2.useHybridComposition.booleanValue()) {
                this.webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                BinaryMessenger binaryMessenger2 = inAppWebViewFlutterPlugin2.messenger;
                MethodChannel methodChannel = new MethodChannel(binaryMessenger2, "com.pichillilorenzo/flutter_inappwebview_pull_to_refresh_" + obj);
                PullToRefreshOptions pullToRefreshOptions = new PullToRefreshOptions();
                pullToRefreshOptions.parse(map3);
                PullToRefreshLayout pullToRefreshLayout2 = new PullToRefreshLayout(context, methodChannel, pullToRefreshOptions);
                this.pullToRefreshLayout = pullToRefreshLayout2;
                pullToRefreshLayout2.addView(this.webView);
                this.pullToRefreshLayout.prepare();
            }
            InAppWebViewMethodHandler inAppWebViewMethodHandler = new InAppWebViewMethodHandler(this.webView);
            this.methodCallDelegate = inAppWebViewMethodHandler;
            this.channel.setMethodCallHandler(inAppWebViewMethodHandler);
            this.webView.prepare();
        }
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        InAppWebViewMethodHandler inAppWebViewMethodHandler = this.methodCallDelegate;
        if (inAppWebViewMethodHandler != null) {
            inAppWebViewMethodHandler.dispose();
            this.methodCallDelegate = null;
        }
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            inAppWebView.removeJavascriptInterface(JavaScriptBridgeJS.JAVASCRIPT_BRIDGE_NAME);
            if (Build.VERSION.SDK_INT >= 29 && WebViewFeature.isFeatureSupported("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE")) {
                WebViewCompat.setWebViewRenderProcessClient(this.webView, (WebViewRenderProcessClient) null);
            }
            this.webView.setWebChromeClient(new WebChromeClient());
            this.webView.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView webView, String str) {
                    InAppWebViewRenderProcessClient inAppWebViewRenderProcessClient = FlutterWebView.this.webView.inAppWebViewRenderProcessClient;
                    if (inAppWebViewRenderProcessClient != null) {
                        inAppWebViewRenderProcessClient.dispose();
                    }
                    FlutterWebView.this.webView.inAppWebViewChromeClient.dispose();
                    FlutterWebView.this.webView.inAppWebViewClient.dispose();
                    FlutterWebView.this.webView.javaScriptBridgeInterface.dispose();
                    FlutterWebView.this.webView.dispose();
                    FlutterWebView.this.webView.destroy();
                    FlutterWebView flutterWebView = FlutterWebView.this;
                    flutterWebView.webView = null;
                    PullToRefreshLayout pullToRefreshLayout = flutterWebView.pullToRefreshLayout;
                    if (pullToRefreshLayout != null) {
                        pullToRefreshLayout.dispose();
                        FlutterWebView.this.pullToRefreshLayout = null;
                    }
                }
            });
            this.webView.getSettings().setJavaScriptEnabled(false);
            this.webView.loadUrl("about:blank");
        }
    }

    public View getView() {
        PullToRefreshLayout pullToRefreshLayout2 = this.pullToRefreshLayout;
        return pullToRefreshLayout2 != null ? pullToRefreshLayout2 : this.webView;
    }

    public void makeInitialLoad(HashMap<String, Object> hashMap) {
        Integer num = (Integer) hashMap.get("windowId");
        Map map = (Map) hashMap.get("initialUrlRequest");
        String str = (String) hashMap.get("initialFile");
        Map map2 = (Map) hashMap.get("initialData");
        if (num != null) {
            Message message = InAppWebViewChromeClient.windowWebViewMessages.get(num);
            if (message != null) {
                ((WebView.WebViewTransport) message.obj).setWebView(this.webView);
                message.sendToTarget();
            }
        } else if (str != null) {
            try {
                this.webView.loadFile(str);
            } catch (IOException e) {
                e.printStackTrace();
                str + " asset file cannot be found!";
            }
        } else if (map2 != null) {
            this.webView.loadDataWithBaseURL((String) map2.get("baseUrl"), (String) map2.get("data"), (String) map2.get("mimeType"), (String) map2.get(Http2ExchangeCodec.ENCODING), (String) map2.get("historyUrl"));
        } else if (map != null) {
            this.webView.loadUrl(URLRequest.fromMap(map));
        }
    }

    public void onFlutterViewAttached(@NonNull View view) {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null && !inAppWebView.options.useHybridComposition.booleanValue()) {
            this.webView.setContainerView(view);
        }
    }

    public void onFlutterViewDetached() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null && !inAppWebView.options.useHybridComposition.booleanValue()) {
            this.webView.setContainerView((View) null);
        }
    }

    public void onInputConnectionLocked() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null && inAppWebView.inAppBrowserDelegate == null && !inAppWebView.options.useHybridComposition.booleanValue()) {
            this.webView.lockInputConnection();
        }
    }

    public void onInputConnectionUnlocked() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null && inAppWebView.inAppBrowserDelegate == null && !inAppWebView.options.useHybridComposition.booleanValue()) {
            this.webView.unlockInputConnection();
        }
    }
}
