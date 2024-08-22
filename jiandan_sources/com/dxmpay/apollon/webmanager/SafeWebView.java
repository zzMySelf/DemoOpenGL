package com.dxmpay.apollon.webmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.android.util.io.FileUtils;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.NoProguard;
import fe.i.qw.yj.qw;
import java.io.InputStream;

public class SafeWebView extends WebView {
    public static final boolean a = (ApollonConstants.DEBUG & true);
    public volatile qw b = null;

    public static class SafeChromeClient extends WebChromeClient implements NoProguard {
        public boolean a;

        private void a(WebView webView) {
            if (webView instanceof SafeWebView) {
                ((SafeWebView) webView).impactJavascriptInterfaces();
            }
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (SafeWebView.a) {
                "onJsPrompt: " + str;
                "msg: " + str2;
                "defaultValue" + str3;
            }
            if (!(webView instanceof SafeWebView) || !((SafeWebView) webView).jsCallJava(str, str2, str3, jsPromptResult)) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return true;
        }

        public void onProgressChanged(WebView webView, int i2) {
            if (i2 <= 25) {
                this.a = false;
            } else if (!this.a) {
                a(webView);
                this.a = true;
                if (SafeWebView.a) {
                    " inject js interface completely on progress " + i2;
                }
            }
            super.onProgressChanged(webView, i2);
        }

        public void onReceivedTitle(WebView webView, String str) {
            if (!this.a) {
                this.a = false;
                if (SafeWebView.a) {
                    "onReceivedTitle: " + str;
                }
                a(webView);
                super.onReceivedTitle(webView, str);
                this.a = true;
            }
        }
    }

    public static class SafeWebViewClient extends WebViewClient implements NoProguard {
        public boolean a;

        private void a(WebView webView) {
            if (webView instanceof SafeWebView) {
                ((SafeWebView) webView).impactJavascriptInterfaces();
            }
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            if (!this.a) {
                this.a = false;
                if (SafeWebView.a) {
                    "doUpdateVisitedHistory: " + str;
                }
                a(webView);
                super.doUpdateVisitedHistory(webView, str, z);
                this.a = true;
            }
        }

        public void onLoadResource(WebView webView, String str) {
            if (!this.a) {
                this.a = false;
                if (SafeWebView.a) {
                    "onLoadResource: " + str;
                }
                super.onLoadResource(webView, str);
                this.a = true;
            }
        }

        public void onPageFinished(WebView webView, String str) {
            if (!this.a) {
                this.a = false;
                if (SafeWebView.a) {
                    "onPageFinished: " + str;
                }
                a(webView);
                super.onPageFinished(webView, str);
                this.a = false;
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (!this.a) {
                this.a = false;
                if (SafeWebView.a) {
                    "onPageStarted: " + str;
                }
                a(webView);
                super.onPageStarted(webView, str, bitmap);
                this.a = true;
            }
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }

        @SuppressLint({"NewApi"})
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            boolean z;
            String str2;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 14 && i2 < 16) {
                try {
                    z = webView.getSettings().getAllowFileAccess();
                } catch (Exception unused) {
                    z = false;
                }
                if (str == null) {
                    str2 = null;
                } else {
                    str2 = str.toLowerCase();
                }
                if (str2 != null && !str2.startsWith("file:///android_asset/") && !str2.startsWith("file:///android_res/") && !z && str2.startsWith(FileUtils.FILE_SCHEMA)) {
                    return new WebResourceResponse((String) null, (String) null, (InputStream) null);
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }
    }

    @SuppressLint({"NewApi"})
    public SafeWebView(Context context, AttributeSet attributeSet, int i2, boolean z) {
        super(context, attributeSet, i2, z);
        a(context);
    }

    @SuppressLint({"NewApi"})
    private boolean b() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 11 || i2 >= 17) {
            return false;
        }
        super.removeJavascriptInterface("searchBoxJavaBridge_");
        super.removeJavascriptInterface("accessibility");
        super.removeJavascriptInterface("accessibilityTraversal");
        return true;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.addJavascriptInterface(obj, str);
        } else {
            getJsBridge().fe(obj, str);
        }
    }

    public void addJsCode(String str, String str2) {
        getJsBridge().th(str, str2);
    }

    public void clearJsCode() {
        getJsBridge().de();
    }

    public void destroy() {
        getJsBridge().m286switch();
        super.destroy();
    }

    public qw getJsBridge() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new qw();
                }
            }
        }
        return this.b;
    }

    public void impactJavascriptInterfaces() {
        String o2 = getJsBridge().o();
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                evaluateJavascript(o2.substring(11), (ValueCallback) null);
            } else {
                super.loadUrl(o2);
            }
        } catch (Throwable unused) {
        }
        boolean z = a;
    }

    public boolean jsCallJava(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return getJsBridge().i(str, str2, str3, jsPromptResult);
    }

    @SuppressLint({"NewApi"})
    public void removeJavascriptInterface(String str) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.removeJavascriptInterface(str);
        } else {
            getJsBridge().rg(str);
        }
    }

    public void removeJsCode(String str) {
        getJsBridge().pf(str);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (webChromeClient == null || (webChromeClient instanceof SafeChromeClient)) {
            super.setWebChromeClient(webChromeClient);
            return;
        }
        throw new RuntimeException("WebChromeClient must be extended from SecureWebChromeClient!!");
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient == null || (webViewClient instanceof SafeWebViewClient)) {
            super.setWebViewClient(webViewClient);
            return;
        }
        throw new RuntimeException("WebViewClient must be extended from SafeWebViewClient!!");
    }

    private void a(Context context) {
        setWebChromeClient(new SafeChromeClient());
        setWebViewClient(new SafeWebViewClient());
        getSettings().setAllowFileAccess(false);
        getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT <= 18) {
            getSettings().setSavePassword(false);
        }
        b();
    }

    public SafeWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    public SafeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public SafeWebView(Context context) {
        super(context);
        a(context);
    }
}
