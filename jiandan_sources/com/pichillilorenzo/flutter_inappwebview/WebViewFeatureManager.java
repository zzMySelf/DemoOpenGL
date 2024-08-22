package com.pichillilorenzo.flutter_inappwebview;

import androidx.annotation.Nullable;
import androidx.webkit.WebViewFeature;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class WebViewFeatureManager implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "WebViewFeatureManager";
    public MethodChannel channel;
    @Nullable
    public InAppWebViewFlutterPlugin plugin;

    public WebViewFeatureManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappwebview_android_webviewfeature");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.plugin = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        if (((str.hashCode() == 1329998754 && str.equals("isFeatureSupported")) ? (char) 0 : 65535) != 0) {
            result.notImplemented();
        } else {
            result.success(Boolean.valueOf(WebViewFeature.isFeatureSupported((String) methodCall.argument("feature"))));
        }
    }
}
