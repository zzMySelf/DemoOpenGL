package com.pichillilorenzo.flutter_inappwebview.headless_in_app_webview;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.FlutterWebView;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

public class HeadlessInAppWebViewManager implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "HeadlessInAppWebViewManager";
    public static final Map<String, HeadlessInAppWebView> webViews = new HashMap();
    public MethodChannel channel;
    @Nullable
    public InAppWebViewFlutterPlugin plugin;

    public HeadlessInAppWebViewManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_headless_inappwebview");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        for (HeadlessInAppWebView next : webViews.values()) {
            if (next != null) {
                next.dispose();
            }
        }
        webViews.clear();
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("id");
        String str2 = methodCall.method;
        if (((str2.hashCode() == 113291 && str2.equals("run")) ? (char) 0 : 65535) != 0) {
            result.notImplemented();
            return;
        }
        run(str, (HashMap) methodCall.argument("params"));
        result.success(Boolean.TRUE);
    }

    public void run(String str, HashMap<String, Object> hashMap) {
        Activity activity;
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
        if (inAppWebViewFlutterPlugin != null && (activity = inAppWebViewFlutterPlugin.activity) != null) {
            FlutterWebView flutterWebView = new FlutterWebView(inAppWebViewFlutterPlugin, activity, str, hashMap);
            HeadlessInAppWebView headlessInAppWebView = new HeadlessInAppWebView(this.plugin, str, flutterWebView);
            webViews.put(str, headlessInAppWebView);
            headlessInAppWebView.prepare(hashMap);
            headlessInAppWebView.onWebViewCreated();
            flutterWebView.makeInitialLoad(hashMap);
        }
    }
}
