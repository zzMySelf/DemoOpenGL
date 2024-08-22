package com.baidu.mobstat;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class BaiduStatJSInterface {

    public interface IWebviewPageLoadCallback {
        void onPageFinished(WebView webView, String str, m mVar);

        void onPageStarted(WebView webView, String str, m mVar);
    }

    public static class CustomWebViewClient extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<Context> f15501a;

        /* renamed from: b  reason: collision with root package name */
        private WebViewClient f15502b;

        /* renamed from: c  reason: collision with root package name */
        private IWebviewPageLoadCallback f15503c;

        /* renamed from: d  reason: collision with root package name */
        private m f15504d;

        public CustomWebViewClient(Context context, WebViewClient webViewClient, IWebviewPageLoadCallback iWebviewPageLoadCallback, m mVar) {
            this.f15501a = new WeakReference<>(context);
            this.f15502b = webViewClient;
            this.f15503c = iWebviewPageLoadCallback;
            this.f15504d = mVar;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
                if (!TextUtils.isEmpty(str) && str.startsWith("bmtj:")) {
                    a(str.substring(5));
                    return true;
                }
            } catch (UnsupportedEncodingException | JSONException e2) {
            }
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        private void a(String str) throws JSONException {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("action");
            JSONObject jSONObject2 = jSONObject.getJSONObject("obj");
            Context context = (Context) this.f15501a.get();
            if (context != null) {
                if ("onPageStart".equals(string)) {
                    String string2 = jSONObject2.getString("page");
                    if (!TextUtils.isEmpty(string2)) {
                        BDStatCore.instance().onPageStart(context, string2);
                        return;
                    }
                    return;
                }
                JSONObject jSONObject3 = null;
                if ("onPageEnd".equals(string)) {
                    String string3 = jSONObject2.getString("page");
                    if (!TextUtils.isEmpty(string3)) {
                        BDStatCore.instance().onPageEnd(context, string3, (ExtraInfo) null, true);
                    }
                } else if ("onEvent".equals(string)) {
                    String string4 = jSONObject2.getString(IntentData.KEY_EVENT_ID);
                    String string5 = jSONObject2.getString("label");
                    int i2 = jSONObject2.getInt("acc");
                    if (!TextUtils.isEmpty(string4)) {
                        try {
                            jSONObject3 = (JSONObject) jSONObject2.get("attributes");
                        } catch (Exception e2) {
                        }
                        BDStatCore.instance().onEvent(context, string4, string5, i2, (ExtraInfo) null, (Map<String, String>) a(jSONObject3), false, true);
                    }
                } else if ("onEventStart".equals(string)) {
                    String string6 = jSONObject2.getString(IntentData.KEY_EVENT_ID);
                    String string7 = jSONObject2.getString("label");
                    if (!TextUtils.isEmpty(string6)) {
                        BDStatCore.instance().onEventStart(context, string6, string7, false);
                    }
                } else if ("onEventEnd".equals(string)) {
                    String string8 = jSONObject2.getString(IntentData.KEY_EVENT_ID);
                    String string9 = jSONObject2.getString("label");
                    if (!TextUtils.isEmpty(string8)) {
                        try {
                            jSONObject3 = (JSONObject) jSONObject2.get("attributes");
                        } catch (Exception e3) {
                        }
                        BDStatCore.instance().onEventEnd(context, string8, string9, (ExtraInfo) null, a(jSONObject3), true);
                    }
                } else if ("onEventDuration".equals(string)) {
                    String string10 = jSONObject2.getString(IntentData.KEY_EVENT_ID);
                    String string11 = jSONObject2.getString("label");
                    long j2 = jSONObject2.getLong("duration");
                    if (!TextUtils.isEmpty(string10)) {
                        try {
                            jSONObject3 = (JSONObject) jSONObject2.get("attributes");
                        } catch (Exception e4) {
                        }
                        BDStatCore.instance().onEventDuration(context, string10, string11, j2, (ExtraInfo) null, a(jSONObject3), false, true);
                    }
                }
            }
        }

        private HashMap<String, String> a(JSONObject jSONObject) {
            HashMap<String, String> hashMap = null;
            if (jSONObject == null) {
                return null;
            }
            if (jSONObject.length() != 0) {
                hashMap = new HashMap<>();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    if (hashMap != null) {
                        hashMap.put(next, string);
                    }
                } catch (Exception e2) {
                }
            }
            return hashMap;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onPageStarted(webView, str, bitmap);
            }
        }

        public void onPageFinished(WebView webView, String str) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onPageFinished(webView, str);
            }
        }

        public void onLoadResource(WebView webView, String str) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            }
        }

        @Deprecated
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            }
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            }
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        public void onScaleChanged(WebView webView, float f2, float f3) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f2, f3);
            }
        }

        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public void onPageCommitVisible(WebView webView, String str) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onPageCommitVisible(webView, str);
            }
        }

        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, i2, str, str2);
            }
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            WebViewClient webViewClient = this.f15502b;
            if (webViewClient != null) {
                return webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
    }

    public static class CustomWebChromeViewClient extends WebChromeClient {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<Context> f15496a;

        /* renamed from: b  reason: collision with root package name */
        private WebChromeClient f15497b;

        /* renamed from: c  reason: collision with root package name */
        private ArrayList<IWebviewPageLoadCallback> f15498c;

        /* renamed from: d  reason: collision with root package name */
        private m f15499d;

        /* renamed from: e  reason: collision with root package name */
        private int f15500e = 0;

        public CustomWebChromeViewClient(Context context, WebChromeClient webChromeClient, ArrayList<IWebviewPageLoadCallback> arrayList, m mVar) {
            this.f15496a = new WeakReference<>(context);
            this.f15497b = webChromeClient;
            this.f15498c = arrayList;
            this.f15499d = mVar;
        }

        public void onProgressChanged(WebView webView, int i2) {
            ArrayList<IWebviewPageLoadCallback> arrayList = this.f15498c;
            if (arrayList != null) {
                if (this.f15500e == 0) {
                    Iterator<IWebviewPageLoadCallback> it = arrayList.iterator();
                    while (it.hasNext()) {
                        IWebviewPageLoadCallback next = it.next();
                        if (next != null) {
                            next.onPageStarted(webView, webView.getUrl(), this.f15499d);
                        }
                    }
                }
                this.f15500e = i2;
                if (i2 == 100) {
                    Iterator<IWebviewPageLoadCallback> it2 = this.f15498c.iterator();
                    while (it2.hasNext()) {
                        IWebviewPageLoadCallback next2 = it2.next();
                        if (next2 != null) {
                            next2.onPageFinished(webView, webView.getUrl(), this.f15499d);
                        }
                    }
                }
            }
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onProgressChanged(webView, i2);
            }
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                return webChromeClient.onCreateWindow(webView, z, z2, message);
            }
            return super.onCreateWindow(webView, z, z2, message);
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                return webChromeClient.onJsAlert(webView, str, str2, jsResult);
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                return webChromeClient.onConsoleMessage(consoleMessage);
            }
            return super.onConsoleMessage(consoleMessage);
        }

        @Deprecated
        public void onConsoleMessage(String str, int i2, String str2) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onConsoleMessage(str, i2, str2);
            }
        }

        public void onCloseWindow(WebView webView) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onCloseWindow(webView);
            }
        }

        @Deprecated
        public void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onExceededDatabaseQuota(str, str2, j2, j3, j4, quotaUpdater);
            }
        }

        public void onGeolocationPermissionsHidePrompt() {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onGeolocationPermissionsHidePrompt();
            }
        }

        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        public void onHideCustomView() {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onHideCustomView();
            }
        }

        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                return webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return super.onJsBeforeUnload(webView, str, str2, jsResult);
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                return webChromeClient.onJsConfirm(webView, str, str2, jsResult);
            }
            return super.onJsConfirm(webView, str, str2, jsResult);
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                return webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Deprecated
        public boolean onJsTimeout() {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                return webChromeClient.onJsTimeout();
            }
            return super.onJsTimeout();
        }

        public void onPermissionRequest(PermissionRequest permissionRequest) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onPermissionRequest(permissionRequest);
            }
        }

        public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onPermissionRequestCanceled(permissionRequest);
            }
        }

        @Deprecated
        public void onReachedMaxAppCacheSize(long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onReachedMaxAppCacheSize(j2, j3, quotaUpdater);
            }
        }

        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onReceivedIcon(webView, bitmap);
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onReceivedTitle(webView, str);
            }
        }

        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onReceivedTouchIconUrl(webView, str, z);
            }
        }

        public void onRequestFocus(WebView webView) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onRequestFocus(webView);
            }
        }

        public void onShowCustomView(View view2, WebChromeClient.CustomViewCallback customViewCallback) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onShowCustomView(view2, customViewCallback);
            }
        }

        @Deprecated
        public void onShowCustomView(View view2, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                webChromeClient.onShowCustomView(view2, i2, customViewCallback);
            }
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            WebChromeClient webChromeClient = this.f15497b;
            if (webChromeClient != null) {
                return webChromeClient.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }
    }
}
