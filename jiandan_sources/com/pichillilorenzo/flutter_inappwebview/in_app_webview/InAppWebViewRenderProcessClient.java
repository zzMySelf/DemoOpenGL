package com.pichillilorenzo.flutter_inappwebview.in_app_webview;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.WebViewFeature;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;
import com.baidu.android.common.others.lang.StringUtil;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

public class InAppWebViewRenderProcessClient extends WebViewRenderProcessClient {
    public static final String LOG_TAG = "IAWRenderProcessClient";
    public final MethodChannel channel;

    public InAppWebViewRenderProcessClient(MethodChannel methodChannel) {
        this.channel = methodChannel;
    }

    public void dispose() {
    }

    public void onRenderProcessResponsive(@NonNull WebView webView, @Nullable final WebViewRenderProcess webViewRenderProcess) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", webView.getUrl());
        this.channel.invokeMethod("onRenderProcessResponsive", hashMap, new MethodChannel.Result() {
            public void error(String str, @Nullable String str2, @Nullable Object obj) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(str2);
                sb.toString();
            }

            public void notImplemented() {
            }

            public void success(@Nullable Object obj) {
                Integer num;
                if (obj != null && (num = (Integer) ((Map) obj).get("action")) != null && webViewRenderProcess != null && num.intValue() == 0 && WebViewFeature.isFeatureSupported("WEB_VIEW_RENDERER_TERMINATE")) {
                    webViewRenderProcess.terminate();
                }
            }
        });
    }

    public void onRenderProcessUnresponsive(@NonNull WebView webView, @Nullable final WebViewRenderProcess webViewRenderProcess) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", webView.getUrl());
        this.channel.invokeMethod("onRenderProcessUnresponsive", hashMap, new MethodChannel.Result() {
            public void error(String str, @Nullable String str2, @Nullable Object obj) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(str2);
                sb.toString();
            }

            public void notImplemented() {
            }

            public void success(@Nullable Object obj) {
                Integer num;
                if (obj != null && (num = (Integer) ((Map) obj).get("action")) != null && webViewRenderProcess != null && num.intValue() == 0 && WebViewFeature.isFeatureSupported("WEB_VIEW_RENDERER_TERMINATE")) {
                    webViewRenderProcess.terminate();
                }
            }
        });
    }
}
