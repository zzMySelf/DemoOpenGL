package com.pichillilorenzo.flutter_inappwebview.types;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.baidu.android.common.others.lang.StringUtil;
import com.pichillilorenzo.flutter_inappwebview.Util;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView;
import com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.JavaScriptBridgeJS;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.CertificatePinner;

public class WebMessageListener implements MethodChannel.MethodCallHandler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String LOG_TAG = "WebMessageListener";
    public Set<String> allowedOriginRules;
    public MethodChannel channel;
    public String jsObjectName;
    public WebViewCompat.WebMessageListener listener;
    public JavaScriptReplyProxy replyProxy;
    public InAppWebViewInterface webView;

    public WebMessageListener(@NonNull InAppWebViewInterface inAppWebViewInterface, @NonNull BinaryMessenger binaryMessenger, @NonNull String str, @NonNull Set<String> set) {
        this.webView = inAppWebViewInterface;
        this.jsObjectName = str;
        this.allowedOriginRules = set;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.pichillilorenzo/flutter_inappwebview_web_message_listener_" + this.jsObjectName);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        if (this.webView instanceof InAppWebView) {
            this.listener = new WebViewCompat.WebMessageListener() {
                public void onPostMessage(@NonNull WebView webView, @NonNull WebMessageCompat webMessageCompat, @NonNull Uri uri, boolean z, @NonNull JavaScriptReplyProxy javaScriptReplyProxy) {
                    WebMessageListener.this.replyProxy = javaScriptReplyProxy;
                    this.onPostMessage(webMessageCompat.getData(), uri, z);
                }
            };
        }
    }

    @Nullable
    public static WebMessageListener fromMap(@NonNull InAppWebViewInterface inAppWebViewInterface, @NonNull BinaryMessenger binaryMessenger, @Nullable Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new WebMessageListener(inAppWebViewInterface, binaryMessenger, (String) map.get("jsObjectName"), new HashSet((List) map.get("allowedOriginRules")));
    }

    private void postMessageForInAppWebView(String str, @NonNull MethodChannel.Result result) {
        if (this.replyProxy != null && WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER")) {
            this.replyProxy.postMessage(str);
        }
        result.success(Boolean.TRUE);
    }

    public void assertOriginRulesValid() {
        int i2 = 0;
        for (String next : this.allowedOriginRules) {
            if (next == null) {
                throw new Exception("allowedOriginRules[" + i2 + "] is null");
            } else if (next.isEmpty()) {
                throw new Exception("allowedOriginRules[" + i2 + "] is empty");
            } else if (!"*".equals(next)) {
                Uri parse = Uri.parse(next);
                String scheme = parse.getScheme();
                String host = parse.getHost();
                String path = parse.getPath();
                int port = parse.getPort();
                if (scheme == null) {
                    throw new Exception("allowedOriginRules " + next + " is invalid");
                } else if (("http".equals(scheme) || "https".equals(scheme)) && (host == null || host.isEmpty())) {
                    throw new Exception("allowedOriginRules " + next + " is invalid");
                } else if (!"http".equals(scheme) && !"https".equals(scheme) && (host != null || port != -1)) {
                    throw new Exception("allowedOriginRules " + next + " is invalid");
                } else if ((host == null || host.isEmpty()) && port != -1) {
                    throw new Exception("allowedOriginRules " + next + " is invalid");
                } else if (path.isEmpty()) {
                    if (host != null) {
                        int indexOf = host.indexOf("*");
                        if (indexOf != 0 || (indexOf == 0 && !host.startsWith(CertificatePinner.Pin.WILDCARD))) {
                            throw new Exception("allowedOriginRules " + next + " is invalid");
                        } else if (host.startsWith("[")) {
                            if (!host.endsWith("]")) {
                                throw new Exception("allowedOriginRules " + next + " is invalid");
                            } else if (!Util.isIPv6(host.substring(1, host.length() - 1))) {
                                throw new Exception("allowedOriginRules " + next + " is invalid");
                            }
                        }
                    }
                    i2++;
                } else {
                    throw new Exception("allowedOriginRules " + next + " is invalid");
                }
            }
        }
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.listener = null;
        this.replyProxy = null;
        this.webView = null;
    }

    public void initJsInstance() {
        String str;
        String sb;
        if (this.webView != null) {
            String replaceAll = Util.replaceAll(this.jsObjectName, "'", "\\'");
            ArrayList arrayList = new ArrayList();
            for (String next : this.allowedOriginRules) {
                if ("*".equals(next)) {
                    sb = "'*'";
                } else {
                    Uri parse = Uri.parse(next);
                    String host = parse.getHost();
                    Object obj = StringUtil.NULL_STRING;
                    if (host != null) {
                        str = "'" + Util.replaceAll(parse.getHost(), "'", "\\'") + "'";
                    } else {
                        str = obj;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("{scheme: '");
                    sb2.append(parse.getScheme());
                    sb2.append("', host: ");
                    sb2.append(str);
                    sb2.append(", port: ");
                    Object obj2 = obj;
                    if (parse.getPort() != -1) {
                        obj2 = Integer.valueOf(parse.getPort());
                    }
                    sb2.append(obj2);
                    sb2.append("}");
                    sb = sb2.toString();
                }
                arrayList.add(sb);
            }
            String str2 = "(function() {  var allowedOriginRules = [" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, arrayList) + "];  var isPageBlank = window.location.href === 'about:blank';  var scheme = !isPageBlank ? window.location.protocol.replace(':', '') : null;  var host = !isPageBlank ? window.location.hostname : null;  var port = !isPageBlank ? window.location.port : null;  if (window." + JavaScriptBridgeJS.JAVASCRIPT_BRIDGE_NAME + "._isOriginAllowed(allowedOriginRules, scheme, host, port)) {      window['" + replaceAll + "'] = new FlutterInAppWebViewWebMessageListener('" + replaceAll + "');  }})();";
            this.webView.getUserContentController().addPluginScript(new PluginScript("WebMessageListener-" + this.jsObjectName, str2, UserScriptInjectionTime.AT_DOCUMENT_START, (ContentWorld) null, false));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isOriginAllowed(java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r11 = this;
            java.util.Set<java.lang.String> r0 = r11.allowedOriginRules
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x00ff
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r3 = "*"
            boolean r4 = r3.equals(r1)
            r5 = 1
            if (r4 == 0) goto L_0x001d
            return r5
        L_0x001d:
            if (r12 == 0) goto L_0x0006
            boolean r4 = r12.isEmpty()
            if (r4 == 0) goto L_0x0026
            goto L_0x0006
        L_0x0026:
            r4 = -1
            if (r12 == 0) goto L_0x002f
            boolean r6 = r12.isEmpty()
            if (r6 == 0) goto L_0x003c
        L_0x002f:
            if (r13 == 0) goto L_0x0037
            boolean r6 = r13.isEmpty()
            if (r6 == 0) goto L_0x003c
        L_0x0037:
            if (r14 == 0) goto L_0x0006
            if (r14 != r4) goto L_0x003c
            goto L_0x0006
        L_0x003c:
            android.net.Uri r1 = android.net.Uri.parse(r1)
            int r6 = r1.getPort()
            r7 = 443(0x1bb, float:6.21E-43)
            r8 = 80
            java.lang.String r9 = "https"
            if (r6 == r4) goto L_0x0058
            int r6 = r1.getPort()
            if (r6 != 0) goto L_0x0053
            goto L_0x0058
        L_0x0053:
            int r6 = r1.getPort()
            goto L_0x0067
        L_0x0058:
            java.lang.String r6 = r1.getScheme()
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L_0x0065
            r6 = 443(0x1bb, float:6.21E-43)
            goto L_0x0067
        L_0x0065:
            r6 = 80
        L_0x0067:
            if (r14 == 0) goto L_0x006e
            if (r14 != r4) goto L_0x006c
            goto L_0x006e
        L_0x006c:
            r7 = r14
            goto L_0x0077
        L_0x006e:
            boolean r4 = r9.equals(r12)
            if (r4 == 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r7 = 80
        L_0x0077:
            java.lang.String r4 = r1.getHost()
            r8 = 0
            if (r4 == 0) goto L_0x00a0
            java.lang.String r4 = r1.getHost()
            java.lang.String r9 = "["
            boolean r4 = r4.startsWith(r9)
            if (r4 == 0) goto L_0x00a0
            java.lang.String r4 = r1.getHost()     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r9 = r1.getHost()     // Catch:{ Exception -> 0x00a0 }
            int r9 = r9.length()     // Catch:{ Exception -> 0x00a0 }
            int r9 = r9 - r5
            java.lang.String r4 = r4.substring(r5, r9)     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r4 = com.pichillilorenzo.flutter_inappwebview.Util.normalizeIPv6(r4)     // Catch:{ Exception -> 0x00a0 }
            goto L_0x00a1
        L_0x00a0:
            r4 = r8
        L_0x00a1:
            java.lang.String r8 = com.pichillilorenzo.flutter_inappwebview.Util.normalizeIPv6(r13)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00a7
        L_0x00a6:
        L_0x00a7:
            java.lang.String r9 = r1.getScheme()
            boolean r9 = r9.equals(r12)
            java.lang.String r10 = r1.getHost()
            if (r10 == 0) goto L_0x00f4
            java.lang.String r10 = r1.getHost()
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x00f4
            java.lang.String r10 = r1.getHost()
            boolean r10 = r10.equals(r13)
            if (r10 != 0) goto L_0x00f4
            java.lang.String r10 = r1.getHost()
            boolean r3 = r10.startsWith(r3)
            if (r3 == 0) goto L_0x00e7
            if (r13 == 0) goto L_0x00e7
            java.lang.String r1 = r1.getHost()
            java.lang.String r3 = "\\*"
            java.lang.String[] r1 = r1.split(r3)
            r1 = r1[r5]
            boolean r1 = r13.contains(r1)
            if (r1 != 0) goto L_0x00f4
        L_0x00e7:
            if (r8 == 0) goto L_0x00f2
            if (r4 == 0) goto L_0x00f2
            boolean r1 = r8.equals(r4)
            if (r1 == 0) goto L_0x00f2
            goto L_0x00f4
        L_0x00f2:
            r1 = 0
            goto L_0x00f5
        L_0x00f4:
            r1 = 1
        L_0x00f5:
            if (r6 != r7) goto L_0x00f8
            r2 = 1
        L_0x00f8:
            if (r9 == 0) goto L_0x0006
            if (r1 == 0) goto L_0x0006
            if (r2 == 0) goto L_0x0006
            return r5
        L_0x00ff:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.types.WebMessageListener.isOriginAllowed(java.lang.String, java.lang.String, int):boolean");
    }

    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        String str = methodCall.method;
        if (((str.hashCode() == 1490029383 && str.equals("postMessage")) ? (char) 0 : 65535) != 0) {
            result.notImplemented();
        } else if (this.webView instanceof InAppWebView) {
            postMessageForInAppWebView((String) methodCall.argument("message"), result);
        } else {
            result.success(Boolean.TRUE);
        }
    }

    public void onPostMessage(String str, Uri uri, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", str);
        hashMap.put("sourceOrigin", uri.toString().equals(StringUtil.NULL_STRING) ? null : uri.toString());
        hashMap.put("isMainFrame", Boolean.valueOf(z));
        this.channel.invokeMethod("onPostMessage", hashMap);
    }
}
