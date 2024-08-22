package com.pichillilorenzo.flutter_inappwebview.in_app_webview;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.biometric.BiometricPrompt;
import androidx.browser.trusted.sharing.ShareTarget;
import com.alipay.sdk.m.p.e;
import com.baidu.android.common.others.lang.StringUtil;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.pichillilorenzo.flutter_inappwebview.Util;
import com.pichillilorenzo.flutter_inappwebview.credential_database.CredentialDatabase;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import com.pichillilorenzo.flutter_inappwebview.in_app_browser.InAppBrowserDelegate;
import com.pichillilorenzo.flutter_inappwebview.plugin_scripts_js.JavaScriptBridgeJS;
import com.pichillilorenzo.flutter_inappwebview.types.ClientCertChallenge;
import com.pichillilorenzo.flutter_inappwebview.types.HttpAuthenticationChallenge;
import com.pichillilorenzo.flutter_inappwebview.types.NavigationAction;
import com.pichillilorenzo.flutter_inappwebview.types.NavigationActionPolicy;
import com.pichillilorenzo.flutter_inappwebview.types.ServerTrustChallenge;
import com.pichillilorenzo.flutter_inappwebview.types.URLCredential;
import com.pichillilorenzo.flutter_inappwebview.types.URLProtectionSpace;
import com.pichillilorenzo.flutter_inappwebview.types.URLRequest;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InAppWebViewClient extends WebViewClient {
    public static final String LOG_TAG = "IAWebViewClient";
    public static List<URLCredential> credentialsProposed;
    public static int previousAuthRequestFailureCount;
    public final MethodChannel channel;
    public InAppBrowserDelegate inAppBrowserDelegate;

    /* renamed from: com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewClient$7  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        public static final /* synthetic */ int[] $SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$NavigationActionPolicy;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.pichillilorenzo.flutter_inappwebview.types.NavigationActionPolicy[] r0 = com.pichillilorenzo.flutter_inappwebview.types.NavigationActionPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$NavigationActionPolicy = r0
                com.pichillilorenzo.flutter_inappwebview.types.NavigationActionPolicy r1 = com.pichillilorenzo.flutter_inappwebview.types.NavigationActionPolicy.ALLOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$NavigationActionPolicy     // Catch:{ NoSuchFieldError -> 0x001d }
                com.pichillilorenzo.flutter_inappwebview.types.NavigationActionPolicy r1 = com.pichillilorenzo.flutter_inappwebview.types.NavigationActionPolicy.CANCEL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewClient.AnonymousClass7.<clinit>():void");
        }
    }

    public InAppWebViewClient(MethodChannel methodChannel, InAppBrowserDelegate inAppBrowserDelegate2) {
        this.channel = methodChannel;
        this.inAppBrowserDelegate = inAppBrowserDelegate2;
    }

    /* access modifiers changed from: private */
    public void allowShouldOverrideUrlLoading(WebView webView, String str, Map<String, String> map, boolean z) {
        if (!z) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            webView.loadUrl(str, map);
        } else {
            webView.loadUrl(str);
        }
    }

    public void dispose() {
        if (this.inAppBrowserDelegate != null) {
            this.inAppBrowserDelegate = null;
        }
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
        String url = webView.getUrl();
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.didUpdateVisitedHistory(url);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", url);
        hashMap.put("androidIsReload", Boolean.valueOf(z));
        this.channel.invokeMethod("onUpdateVisitedHistory", hashMap);
    }

    public void loadCustomJavaScriptOnPageFinished(WebView webView) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        String generateWrappedCodeForDocumentEnd = inAppWebView.userContentController.generateWrappedCodeForDocumentEnd();
        if (Build.VERSION.SDK_INT >= 19) {
            inAppWebView.evaluateJavascript(generateWrappedCodeForDocumentEnd, (ValueCallback) null);
            return;
        }
        inAppWebView.loadUrl("javascript:" + generateWrappedCodeForDocumentEnd.replaceAll("[\r\n]+", ""));
    }

    public void loadCustomJavaScriptOnPageStarted(WebView webView) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        String generateWrappedCodeForDocumentStart = inAppWebView.userContentController.generateWrappedCodeForDocumentStart();
        if (Build.VERSION.SDK_INT >= 19) {
            inAppWebView.evaluateJavascript(generateWrappedCodeForDocumentStart, (ValueCallback) null);
            return;
        }
        inAppWebView.loadUrl("javascript:" + generateWrappedCodeForDocumentStart.replaceAll("[\r\n]+", ""));
    }

    public void onFormResubmission(final WebView webView, final Message message, final Message message2) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", webView.getUrl());
        this.channel.invokeMethod("onFormResubmission", hashMap, new MethodChannel.Result() {
            public void error(String str, @Nullable String str2, @Nullable Object obj) {
                "ERROR: " + str + " " + str2;
            }

            public void notImplemented() {
                InAppWebViewClient.super.onFormResubmission(webView, message, message2);
            }

            public void success(@Nullable Object obj) {
                Integer num;
                if (obj == null || (num = (Integer) ((Map) obj).get("action")) == null) {
                    InAppWebViewClient.super.onFormResubmission(webView, message, message2);
                } else if (num.intValue() != 0) {
                    message.sendToTarget();
                } else {
                    message2.sendToTarget();
                }
            }
        });
    }

    public void onPageCommitVisible(WebView webView, String str) {
        super.onPageCommitVisible(webView, str);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        this.channel.invokeMethod("onPageCommitVisible", hashMap);
    }

    public void onPageFinished(WebView webView, String str) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        inAppWebView.isLoading = false;
        loadCustomJavaScriptOnPageFinished(inAppWebView);
        previousAuthRequestFailureCount = 0;
        credentialsProposed = null;
        super.onPageFinished(webView, str);
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.didFinishNavigation(str);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().flush();
        } else {
            CookieSyncManager.getInstance().sync();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            inAppWebView.evaluateJavascript(JavaScriptBridgeJS.PLATFORM_READY_JS_SOURCE, (ValueCallback) null);
        } else {
            inAppWebView.loadUrl("javascript:" + JavaScriptBridgeJS.PLATFORM_READY_JS_SOURCE.replaceAll("[\r\n]+", ""));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        this.channel.invokeMethod("onLoadStop", hashMap);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        inAppWebView.isLoading = true;
        inAppWebView.disposeWebMessageChannels();
        inAppWebView.userContentController.resetContentWorlds();
        loadCustomJavaScriptOnPageStarted(inAppWebView);
        super.onPageStarted(webView, str, bitmap);
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.didStartNavigation(str);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        this.channel.invokeMethod("onLoadStart", hashMap);
    }

    @RequiresApi(api = 21)
    public void onReceivedClientCertRequest(final WebView webView, final ClientCertRequest clientCertRequest) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        try {
            this.channel.invokeMethod("onReceivedClientCertRequest", new ClientCertChallenge(new URLProtectionSpace(clientCertRequest.getHost(), new URI(webView.getUrl()).getScheme(), (String) null, clientCertRequest.getPort(), webView.getCertificate(), (SslError) null), clientCertRequest.getPrincipals(), clientCertRequest.getKeyTypes()).toMap(), new MethodChannel.Result() {
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
                    InAppWebViewClient.super.onReceivedClientCertRequest(webView, clientCertRequest);
                }

                public void success(Object obj) {
                    if (obj != null) {
                        Map map = (Map) obj;
                        Integer num = (Integer) map.get("action");
                        if (num != null) {
                            int intValue = num.intValue();
                            if (intValue == 1) {
                                Util.PrivateKeyAndCertificates loadPrivateKeyAndCertificate = Util.loadPrivateKeyAndCertificate(((InAppWebView) webView).plugin, (String) map.get("certificatePath"), (String) map.get("certificatePassword"), (String) map.get("androidKeyStoreType"));
                                clientCertRequest.proceed(loadPrivateKeyAndCertificate.privateKey, loadPrivateKeyAndCertificate.certificates);
                                return;
                            } else if (intValue != 2) {
                                clientCertRequest.cancel();
                                return;
                            } else {
                                clientCertRequest.ignore();
                                return;
                            }
                        }
                    }
                    InAppWebViewClient.super.onReceivedClientCertRequest(webView, clientCertRequest);
                }
            });
        } catch (URISyntaxException e) {
            e.printStackTrace();
            clientCertRequest.cancel();
        }
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        if (inAppWebView.options.disableDefaultErrorPage.booleanValue()) {
            inAppWebView.stopLoading();
            inAppWebView.loadUrl("about:blank");
        }
        inAppWebView.isLoading = false;
        previousAuthRequestFailureCount = 0;
        credentialsProposed = null;
        InAppBrowserDelegate inAppBrowserDelegate2 = this.inAppBrowserDelegate;
        if (inAppBrowserDelegate2 != null) {
            inAppBrowserDelegate2.didFailNavigation(str2, i2, str);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str2);
        hashMap.put("code", Integer.valueOf(i2));
        hashMap.put("message", str);
        this.channel.invokeMethod("onLoadError", hashMap);
        super.onReceivedError(webView, i2, str, str2);
    }

    @RequiresApi(api = 23)
    public void onReceivedError(WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        String str3 = str;
        String str4 = str2;
        URLCredential uRLCredential = null;
        try {
            URI uri = new URI(webView.getUrl());
            String scheme = uri.getScheme();
            int port = uri.getPort();
            previousAuthRequestFailureCount++;
            HashMap hashMap = new HashMap();
            hashMap.put("host", str3);
            hashMap.put("protocol", scheme);
            hashMap.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM, str4);
            hashMap.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT, Integer.valueOf(port));
            hashMap.put("previousFailureCount", Integer.valueOf(previousAuthRequestFailureCount));
            if (credentialsProposed == null) {
                credentialsProposed = CredentialDatabase.getInstance(webView.getContext()).getHttpAuthCredentials(str3, scheme, str4, Integer.valueOf(port));
            }
            List<URLCredential> list = credentialsProposed;
            if (list != null && list.size() > 0) {
                uRLCredential = credentialsProposed.get(0);
            }
            final WebView webView2 = webView;
            final String str5 = str;
            final String str6 = scheme;
            final String str7 = str2;
            final int i2 = port;
            final HttpAuthHandler httpAuthHandler2 = httpAuthHandler;
            this.channel.invokeMethod("onReceivedHttpAuthRequest", new HttpAuthenticationChallenge(new URLProtectionSpace(str, scheme, str2, port, webView.getCertificate(), (SslError) null), previousAuthRequestFailureCount, uRLCredential).toMap(), new MethodChannel.Result() {
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
                    InAppWebViewClient.super.onReceivedHttpAuthRequest(webView2, httpAuthHandler2, str5, str7);
                }

                public void success(Object obj) {
                    if (obj != null) {
                        Map map = (Map) obj;
                        Integer num = (Integer) map.get("action");
                        if (num != null) {
                            int intValue = num.intValue();
                            if (intValue == 1) {
                                String str = (String) map.get("username");
                                String str2 = (String) map.get("password");
                                Boolean bool = (Boolean) map.get("permanentPersistence");
                                if (bool != null && bool.booleanValue()) {
                                    CredentialDatabase.getInstance(webView2.getContext()).setHttpAuthCredential(str5, str6, str7, Integer.valueOf(i2), str, str2);
                                }
                                httpAuthHandler2.proceed(str, str2);
                                return;
                            } else if (intValue != 2) {
                                List unused = InAppWebViewClient.credentialsProposed = null;
                                int unused2 = InAppWebViewClient.previousAuthRequestFailureCount = 0;
                                httpAuthHandler2.cancel();
                                return;
                            } else if (InAppWebViewClient.credentialsProposed.size() > 0) {
                                URLCredential uRLCredential = (URLCredential) InAppWebViewClient.credentialsProposed.remove(0);
                                httpAuthHandler2.proceed(uRLCredential.getUsername(), uRLCredential.getPassword());
                                return;
                            } else {
                                httpAuthHandler2.cancel();
                                return;
                            }
                        }
                    }
                    InAppWebViewClient.super.onReceivedHttpAuthRequest(webView2, httpAuthHandler2, str5, str7);
                }
            });
        } catch (URISyntaxException e) {
            e.printStackTrace();
            credentialsProposed = null;
            previousAuthRequestFailureCount = 0;
            httpAuthHandler.cancel();
        }
    }

    @RequiresApi(api = 23)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webResourceRequest.isForMainFrame()) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", webResourceRequest.getUrl().toString());
            hashMap.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, Integer.valueOf(webResourceResponse.getStatusCode()));
            hashMap.put(BiometricPrompt.KEY_DESCRIPTION, webResourceResponse.getReasonPhrase());
            this.channel.invokeMethod("onLoadHttpError", hashMap);
        }
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM, str);
        hashMap.put("account", str2);
        hashMap.put("args", str3);
        this.channel.invokeMethod("onReceivedLoginRequest", hashMap);
    }

    public void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
        try {
            URI uri = new URI(sslError.getUrl());
            this.channel.invokeMethod("onReceivedServerTrustAuthRequest", new ServerTrustChallenge(new URLProtectionSpace(uri.getHost(), uri.getScheme(), (String) null, uri.getPort(), sslError.getCertificate(), sslError)).toMap(), new MethodChannel.Result() {
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
                    InAppWebViewClient.super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }

                public void success(Object obj) {
                    Integer num;
                    if (obj == null || (num = (Integer) ((Map) obj).get("action")) == null) {
                        InAppWebViewClient.super.onReceivedSslError(webView, sslErrorHandler, sslError);
                    } else if (num.intValue() != 1) {
                        sslErrorHandler.cancel();
                    } else {
                        sslErrorHandler.proceed();
                    }
                }
            });
        } catch (URISyntaxException e) {
            e.printStackTrace();
            sslErrorHandler.cancel();
        }
    }

    @RequiresApi(api = 26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (!((InAppWebView) webView).options.useOnRenderProcessGone.booleanValue()) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        Boolean valueOf = Boolean.valueOf(renderProcessGoneDetail.didCrash());
        Integer valueOf2 = Integer.valueOf(renderProcessGoneDetail.rendererPriorityAtExit());
        HashMap hashMap = new HashMap();
        hashMap.put("didCrash", valueOf);
        hashMap.put("rendererPriorityAtExit", valueOf2);
        this.channel.invokeMethod("onRenderProcessGone", hashMap);
        return true;
    }

    @RequiresApi(api = 27)
    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i2, SafeBrowsingResponse safeBrowsingResponse) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", webResourceRequest.getUrl().toString());
        hashMap.put("threatType", Integer.valueOf(i2));
        final SafeBrowsingResponse safeBrowsingResponse2 = safeBrowsingResponse;
        final WebView webView2 = webView;
        final WebResourceRequest webResourceRequest2 = webResourceRequest;
        final int i3 = i2;
        this.channel.invokeMethod("onSafeBrowsingHit", hashMap, new MethodChannel.Result() {
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
                InAppWebViewClient.super.onSafeBrowsingHit(webView2, webResourceRequest2, i3, safeBrowsingResponse2);
            }

            public void success(Object obj) {
                if (obj != null) {
                    Map map = (Map) obj;
                    Boolean bool = (Boolean) map.get("report");
                    Integer num = (Integer) map.get("action");
                    Boolean valueOf = Boolean.valueOf(bool != null ? bool.booleanValue() : true);
                    if (num != null) {
                        int intValue = num.intValue();
                        if (intValue == 0) {
                            safeBrowsingResponse2.backToSafety(valueOf.booleanValue());
                            return;
                        } else if (intValue != 1) {
                            safeBrowsingResponse2.showInterstitial(valueOf.booleanValue());
                            return;
                        } else {
                            safeBrowsingResponse2.proceed(valueOf.booleanValue());
                            return;
                        }
                    }
                }
                InAppWebViewClient.super.onSafeBrowsingHit(webView2, webResourceRequest2, i3, safeBrowsingResponse2);
            }
        });
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        super.onScaleChanged(webView, f, f2);
        InAppWebView inAppWebView = (InAppWebView) webView;
        inAppWebView.zoomScale = f2 / Util.getPixelDensity(inAppWebView.getContext());
        HashMap hashMap = new HashMap();
        hashMap.put("oldScale", Float.valueOf(f));
        hashMap.put("newScale", Float.valueOf(f2));
        this.channel.invokeMethod("onZoomScaleChanged", hashMap);
    }

    public WebResourceResponse onShouldInterceptRequest(Object obj) {
        Map<String, String> map;
        boolean z;
        Object obj2;
        ByteArrayInputStream byteArrayInputStream = null;
        String str = obj instanceof String ? (String) obj : null;
        boolean z2 = true;
        boolean z3 = false;
        if (Build.VERSION.SDK_INT < 21 || !(obj instanceof WebResourceRequest)) {
            map = null;
            z = false;
        } else {
            WebResourceRequest webResourceRequest = (WebResourceRequest) obj;
            str = webResourceRequest.getUrl().toString();
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            z = webResourceRequest.hasGesture();
            boolean isForMainFrame = webResourceRequest.isForMainFrame();
            if (Build.VERSION.SDK_INT >= 24) {
                z3 = webResourceRequest.isRedirect();
            }
            map = requestHeaders;
            z2 = isForMainFrame;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put(e.s, ShareTarget.METHOD_GET);
        hashMap.put("headers", map);
        hashMap.put("isForMainFrame", Boolean.valueOf(z2));
        hashMap.put("hasGesture", Boolean.valueOf(z));
        hashMap.put("isRedirect", Boolean.valueOf(z3));
        try {
            Util.WaitFlutterResult invokeMethodAndWait = Util.invokeMethodAndWait(this.channel, "shouldInterceptRequest", hashMap);
            if (invokeMethodAndWait.error != null || (obj2 = invokeMethodAndWait.result) == null) {
                return null;
            }
            Map map2 = (Map) obj2;
            String str2 = (String) map2.get("contentType");
            String str3 = (String) map2.get("contentEncoding");
            byte[] bArr = (byte[]) map2.get("data");
            Map map3 = (Map) map2.get("headers");
            Integer num = (Integer) map2.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE);
            String str4 = (String) map2.get("reasonPhrase");
            if (bArr != null) {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
            }
            ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
            return (!(map3 == null && num == null && str4 == null) && Build.VERSION.SDK_INT >= 21) ? new WebResourceResponse(str2, str3, num.intValue(), str4, map3, byteArrayInputStream2) : new WebResourceResponse(str2, str3, byteArrayInputStream2);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void onShouldOverrideUrlLoading(InAppWebView inAppWebView, String str, String str2, Map<String, String> map, boolean z, boolean z2, boolean z3) {
        final InAppWebView inAppWebView2 = inAppWebView;
        final String str3 = str;
        final Map<String, String> map2 = map;
        final boolean z4 = z;
        this.channel.invokeMethod("shouldOverrideUrlLoading", new NavigationAction(new URLRequest(str, str2, (byte[]) null, map), z, z2, z3).toMap(), new MethodChannel.Result() {
            public void error(String str, @Nullable String str2, @Nullable Object obj) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(str2);
                sb.toString();
                InAppWebViewClient.this.allowShouldOverrideUrlLoading(inAppWebView2, str3, map2, z4);
            }

            public void notImplemented() {
                InAppWebViewClient.this.allowShouldOverrideUrlLoading(inAppWebView2, str3, map2, z4);
            }

            public void success(Object obj) {
                if (obj != null) {
                    Integer num = (Integer) ((Map) obj).get("action");
                    NavigationActionPolicy fromValue = NavigationActionPolicy.fromValue(Integer.valueOf(num != null ? num.intValue() : NavigationActionPolicy.CANCEL.rawValue()).intValue());
                    if (fromValue == null || AnonymousClass7.$SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$NavigationActionPolicy[fromValue.ordinal()] != 1) {
                        return;
                    }
                }
                InAppWebViewClient.this.allowShouldOverrideUrlLoading(inAppWebView2, str3, map2, z4);
            }
        });
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
    }

    @RequiresApi(api = 21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return ((InAppWebView) webView).options.useShouldInterceptRequest.booleanValue() ? onShouldInterceptRequest(webResourceRequest) : shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        URI uri;
        Object obj;
        InAppWebView inAppWebView = (InAppWebView) webView;
        if (inAppWebView.options.useShouldInterceptRequest.booleanValue()) {
            return onShouldInterceptRequest(str);
        }
        WebResourceResponse webResourceResponse = null;
        try {
            uri = new URI(str);
        } catch (URISyntaxException unused) {
            String str2 = str.split(":")[0];
            try {
                URL url = new URL(str.replace(str2, "https"));
                uri = new URI(str2, url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        String scheme = uri.getScheme();
        List<String> list = inAppWebView.options.resourceCustomSchemes;
        if (list != null && list.contains(scheme)) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            try {
                Util.WaitFlutterResult invokeMethodAndWait = Util.invokeMethodAndWait(this.channel, "onLoadResourceCustomScheme", hashMap);
                if (invokeMethodAndWait.error == null && (obj = invokeMethodAndWait.result) != null) {
                    Map map = (Map) obj;
                    try {
                        webResourceResponse = inAppWebView.contentBlockerHandler.checkUrl(inAppWebView, str, map.get("contentType").toString());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return webResourceResponse != null ? webResourceResponse : new WebResourceResponse(map.get("contentType").toString(), map.get("contentEncoding").toString(), new ByteArrayInputStream((byte[]) map.get("data")));
                }
            } catch (InterruptedException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        if (inAppWebView.contentBlockerHandler.getRuleList().size() <= 0) {
            return null;
        }
        try {
            return inAppWebView.contentBlockerHandler.checkUrl(inAppWebView, str);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @TargetApi(21)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        if (!inAppWebView.options.useShouldOverrideUrlLoading.booleanValue()) {
            return false;
        }
        onShouldOverrideUrlLoading(inAppWebView, webResourceRequest.getUrl().toString(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders(), webResourceRequest.isForMainFrame(), webResourceRequest.hasGesture(), Build.VERSION.SDK_INT >= 24 ? webResourceRequest.isRedirect() : false);
        if (inAppWebView.regexToCancelSubFramesLoadingCompiled == null) {
            return webResourceRequest.isForMainFrame();
        }
        if (webResourceRequest.isForMainFrame()) {
            return true;
        }
        return inAppWebView.regexToCancelSubFramesLoadingCompiled.matcher(webResourceRequest.getUrl().toString()).matches();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InAppWebView inAppWebView = (InAppWebView) webView;
        if (!inAppWebView.options.useShouldOverrideUrlLoading.booleanValue()) {
            return false;
        }
        onShouldOverrideUrlLoading(inAppWebView, str, ShareTarget.METHOD_GET, (Map<String, String>) null, true, false, false);
        return true;
    }
}
