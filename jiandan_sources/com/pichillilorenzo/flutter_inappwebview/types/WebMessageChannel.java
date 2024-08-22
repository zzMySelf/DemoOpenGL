package com.pichillilorenzo.flutter_inappwebview.types;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.baidu.sapi2.share.ShareCallPacking;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebMessageChannel implements MethodChannel.MethodCallHandler {
    public static final String LOG_TAG = "WebMessageChannel";
    public MethodChannel channel;
    public final List<WebMessagePortCompat> compatPorts;
    public String id;
    public final List<WebMessagePort> ports;
    public InAppWebViewInterface webView;

    public WebMessageChannel(@NonNull String str, @NonNull InAppWebViewInterface inAppWebViewInterface) {
        this.id = str;
        BinaryMessenger binaryMessenger = inAppWebViewInterface.getPlugin().messenger;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.pichillilorenzo/flutter_inappwebview_web_message_channel_" + str);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        if (inAppWebViewInterface instanceof InAppWebView) {
            this.compatPorts = new ArrayList(Arrays.asList(WebViewCompat.createWebMessageChannel((InAppWebView) inAppWebViewInterface)));
            this.ports = new ArrayList();
        } else {
            this.ports = Arrays.asList(new WebMessagePort[]{new WebMessagePort("port1", this), new WebMessagePort("port2", this)});
            this.compatPorts = new ArrayList();
        }
        this.webView = inAppWebViewInterface;
    }

    private void closeForInAppWebView(Integer num, @NonNull MethodChannel.Result result) {
        if (this.webView == null || this.compatPorts.size() <= 0 || !WebViewFeature.isFeatureSupported("WEB_MESSAGE_PORT_CLOSE")) {
            result.success(Boolean.TRUE);
            return;
        }
        try {
            this.compatPorts.get(num.intValue()).close();
            result.success(Boolean.TRUE);
        } catch (Exception e) {
            result.error(LOG_TAG, e.getMessage(), (Object) null);
        }
    }

    private void postMessageForInAppWebView(Integer num, Map<String, Object> map, @NonNull MethodChannel.Result result) {
        if (this.webView == null || this.compatPorts.size() <= 0 || !WebViewFeature.isFeatureSupported("WEB_MESSAGE_PORT_POST_MESSAGE")) {
            result.success(Boolean.TRUE);
            return;
        }
        WebMessagePortCompat webMessagePortCompat = this.compatPorts.get(num.intValue());
        ArrayList arrayList = new ArrayList();
        List<Map> list = (List) map.get("ports");
        if (list != null) {
            for (Map map2 : list) {
                Integer num2 = (Integer) map2.get(ShareCallPacking.StatModel.KEY_INDEX);
                WebMessageChannel webMessageChannel = this.webView.getWebMessageChannels().get((String) map2.get("webMessageChannelId"));
                if (webMessageChannel != null) {
                    arrayList.add(webMessageChannel.compatPorts.get(num2.intValue()));
                }
            }
        }
        try {
            webMessagePortCompat.postMessage(new WebMessageCompat((String) map.get("data"), (WebMessagePortCompat[]) arrayList.toArray(new WebMessagePortCompat[0])));
            result.success(Boolean.TRUE);
        } catch (Exception e) {
            result.error(LOG_TAG, e.getMessage(), (Object) null);
        }
    }

    private void setWebMessageCallbackForInAppWebView(final Integer num, @NonNull MethodChannel.Result result) {
        if (this.webView == null || this.compatPorts.size() <= 0 || !WebViewFeature.isFeatureSupported("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK")) {
            result.success(Boolean.TRUE);
            return;
        }
        try {
            this.compatPorts.get(num.intValue()).setWebMessageCallback(new WebMessagePortCompat.WebMessageCallbackCompat() {
                public void onMessage(@NonNull WebMessagePortCompat webMessagePortCompat, @Nullable WebMessageCompat webMessageCompat) {
                    super.onMessage(webMessagePortCompat, webMessageCompat);
                    HashMap hashMap = new HashMap();
                    hashMap.put(ShareCallPacking.StatModel.KEY_INDEX, num);
                    hashMap.put("message", webMessageCompat != null ? webMessageCompat.getData() : null);
                    WebMessageChannel.this.channel.invokeMethod("onMessage", hashMap);
                }
            });
            result.success(Boolean.TRUE);
        } catch (Exception e) {
            result.error(LOG_TAG, e.getMessage(), (Object) null);
        }
    }

    public void dispose() {
        if (WebViewFeature.isFeatureSupported("WEB_MESSAGE_PORT_CLOSE")) {
            for (WebMessagePortCompat close : this.compatPorts) {
                try {
                    close.close();
                } catch (Exception unused) {
                }
            }
        }
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.compatPorts.clear();
        this.webView = null;
    }

    public void initJsInstance(InAppWebViewInterface inAppWebViewInterface, final ValueCallback<WebMessageChannel> valueCallback) {
        if (inAppWebViewInterface != null) {
            inAppWebViewInterface.evaluateJavascript("(function() {window.flutter_inappwebview._webMessageChannels['" + this.id + "'] = new MessageChannel();})();", (ContentWorld) null, new ValueCallback<String>() {
                public void onReceiveValue(String str) {
                    valueCallback.onReceiveValue(this);
                }
            });
            return;
        }
        valueCallback.onReceiveValue(this);
    }

    public void onMessage(Integer num, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(ShareCallPacking.StatModel.KEY_INDEX, num);
        hashMap.put("message", str);
        this.channel.invokeMethod("onMessage", hashMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r6, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r7) {
        /*
            r5 = this;
            java.lang.String r0 = r6.method
            int r1 = r0.hashCode()
            r2 = 1
            r3 = 2
            r4 = 94756344(0x5a5ddf8, float:1.5598064E-35)
            if (r1 == r4) goto L_0x002c
            r4 = 556190586(0x2126cb7a, float:5.6512287E-19)
            if (r1 == r4) goto L_0x0022
            r4 = 1490029383(0x58d00b47, float:1.82997484E15)
            if (r1 == r4) goto L_0x0018
            goto L_0x0036
        L_0x0018:
            java.lang.String r1 = "postMessage"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0022:
            java.lang.String r1 = "setWebMessageCallback"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 0
            goto L_0x0037
        L_0x002c:
            java.lang.String r1 = "close"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 2
            goto L_0x0037
        L_0x0036:
            r0 = -1
        L_0x0037:
            java.lang.String r1 = "index"
            if (r0 == 0) goto L_0x006b
            if (r0 == r2) goto L_0x0053
            if (r0 == r3) goto L_0x0043
            r7.notImplemented()
            goto L_0x0080
        L_0x0043:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r5.webView
            boolean r0 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r0 == 0) goto L_0x007b
            java.lang.Object r6 = r6.argument(r1)
            java.lang.Integer r6 = (java.lang.Integer) r6
            r5.closeForInAppWebView(r6, r7)
            goto L_0x0080
        L_0x0053:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r5.webView
            boolean r0 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r0 == 0) goto L_0x007b
            java.lang.Object r0 = r6.argument(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            java.lang.String r1 = "message"
            java.lang.Object r6 = r6.argument(r1)
            java.util.Map r6 = (java.util.Map) r6
            r5.postMessageForInAppWebView(r0, r6, r7)
            goto L_0x0080
        L_0x006b:
            com.pichillilorenzo.flutter_inappwebview.types.InAppWebViewInterface r0 = r5.webView
            boolean r0 = r0 instanceof com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView
            if (r0 == 0) goto L_0x007b
            java.lang.Object r6 = r6.argument(r1)
            java.lang.Integer r6 = (java.lang.Integer) r6
            r5.setWebMessageCallbackForInAppWebView(r6, r7)
            goto L_0x0080
        L_0x007b:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r7.success(r6)
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.types.WebMessageChannel.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("id", this.id);
        return hashMap;
    }
}
