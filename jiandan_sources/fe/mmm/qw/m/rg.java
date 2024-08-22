package fe.mmm.qw.m;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.aiscan.R;
import com.tera.scan.webview.BaseWebViewFragment;
import com.tera.scan.webview.IPageFinishListener;
import com.tera.scan.webview.IPageStartListener;
import com.tera.scan.webview.ITitleChangeCallBack;
import com.tera.scan.webview.ITitleRightBtnChange;
import com.tera.scan.webview.TeraScanWebView;
import com.tera.scan.webview.hybrid.action.IActionManager;
import fe.mmm.qw.i.qw;
import fe.mmm.qw.m.ggg.ad.fe;
import fe.mmm.qw.m.ggg.fe.ad;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

public abstract class rg extends WebViewClient {

    /* renamed from: ad  reason: collision with root package name */
    public final ITitleChangeCallBack f8059ad;

    /* renamed from: de  reason: collision with root package name */
    public ITitleRightBtnChange f8060de;

    /* renamed from: fe  reason: collision with root package name */
    public final WeakReference<Activity> f8061fe;
    public IActionManager qw;

    /* renamed from: rg  reason: collision with root package name */
    public IPageStartListener f8062rg;

    /* renamed from: th  reason: collision with root package name */
    public IPageFinishListener f8063th;

    public rg(@NonNull Activity activity, @Nullable ITitleChangeCallBack iTitleChangeCallBack, IActionManager iActionManager) {
        this.f8061fe = new WeakReference<>(activity);
        this.f8059ad = iTitleChangeCallBack;
        this.qw = iActionManager;
    }

    public void ad(IPageStartListener iPageStartListener) {
        this.f8062rg = iPageStartListener;
    }

    public boolean de(WebView webView, String str) {
        String str2;
        String originalUrl = webView.getOriginalUrl();
        qw.ad("BaseClient", "origin url: " + originalUrl);
        try {
            str2 = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            qw.th("BaseClient", e.getMessage(), e);
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        qw.ad("BaseClient", "decode url: " + str2);
        Uri parse = Uri.parse(str2);
        String scheme = parse.getScheme();
        if (this.qw == null || !"bdwpin".equals(scheme) || !this.qw.qw(originalUrl)) {
            return false;
        }
        ad qw2 = new fe.mmm.qw.m.ggg.rg.ad().qw(str);
        fe.mmm.qw.m.ggg.qw.qw ad2 = this.qw.ad(qw2.qw.qw);
        if (ad2 != null) {
            fe.mmm.qw.m.ppp.qw.qw.qw(str2, qw2);
            ad2.onAction(qw2);
            return true;
        }
        fe.qw(webView, new fe.mmm.qw.m.ggg.ad.rg("handleError", qw2.f8045ad, parse.getAuthority(), qw2.f8046de));
        qw.ad("BaseClient", "not found hybrid action");
        return true;
    }

    public final void fe(WebView webView, boolean z) {
        BaseWebViewFragment webViewFragment = ((TeraScanWebView) webView).getWebViewFragment();
        if (webViewFragment != null) {
            rg(webView, webViewFragment, z);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        Activity activity = (Activity) this.f8061fe.get();
        if (activity != null && !activity.isFinishing()) {
            super.onPageFinished(webView, str);
            BaseWebViewFragment webViewFragment = ((TeraScanWebView) webView).getWebViewFragment();
            if (webViewFragment != null) {
                webViewFragment.setUrlLoadEndTime();
                webViewFragment.getTextLoading().setVisibility(8);
                webViewFragment.getProgressBar().setVisibility(4);
                if (!webViewFragment.isError()) {
                    webView.setVisibility(0);
                }
                ITitleChangeCallBack iTitleChangeCallBack = this.f8059ad;
                if (iTitleChangeCallBack != null) {
                    iTitleChangeCallBack.onTitleChange(str, webView.getTitle());
                }
                IPageFinishListener iPageFinishListener = this.f8063th;
                if (iPageFinishListener != null) {
                    iPageFinishListener.onPageFinished(str);
                }
                qw.ad("BaseClient", "onPageFinished url = " + str);
            }
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        BaseWebViewFragment webViewFragment;
        super.onPageStarted(webView, str, bitmap);
        qw.ad("BaseClient", "onPageStarted url:" + str);
        try {
            String host = new URL(str).getHost();
            qw.ad("BaseClient", "url " + str);
            qw.ad("BaseClient", "host " + host);
            qw.ad("BaseClient", "cookie " + CookieManager.getInstance().getCookie(host));
        } catch (MalformedURLException e) {
            qw.rg("BaseClient", e.getMessage());
        }
        ITitleChangeCallBack iTitleChangeCallBack = this.f8059ad;
        if (iTitleChangeCallBack != null) {
            iTitleChangeCallBack.onTitleChange(str, webView.getTitle());
        }
        ITitleRightBtnChange iTitleRightBtnChange = this.f8060de;
        if (iTitleRightBtnChange != null) {
            iTitleRightBtnChange.qw(false);
        }
        IPageStartListener iPageStartListener = this.f8062rg;
        if (iPageStartListener != null) {
            iPageStartListener.onPageStarted(str);
        }
        if ((webView instanceof TeraScanWebView) && (webViewFragment = ((TeraScanWebView) webView).getWebViewFragment()) != null) {
            webViewFragment.setUrlLoadStartTime();
        }
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        qw.ad("BaseClient", "onReceivedError errorCode = " + i2 + " description = " + str + " failingUrl = " + str2);
        Activity activity = (Activity) this.f8061fe.get();
        if (activity != null && !activity.isFinishing()) {
            super.onReceivedError(webView, i2, str, str2);
            if (i2 != -1) {
                fe(webView, true);
            }
            if (webView instanceof TeraScanWebView) {
                BaseWebViewFragment webViewFragment = ((TeraScanWebView) webView).getWebViewFragment();
                String originalUrl = webView.getOriginalUrl();
                if (webViewFragment == null) {
                    return;
                }
                if (TextUtils.isEmpty(originalUrl) || originalUrl.equals(str2)) {
                    webViewFragment.setErrorInfo(i2, str);
                }
            }
        }
    }

    @RequiresApi(api = 23)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webView != null && webResourceRequest != null && webResourceRequest.getUrl() != null) {
            String uri = webResourceRequest.getUrl().toString();
            if (webView instanceof TeraScanWebView) {
                BaseWebViewFragment webViewFragment = ((TeraScanWebView) webView).getWebViewFragment();
                String originalUrl = webView.getOriginalUrl();
                if (webViewFragment == null) {
                    return;
                }
                if (originalUrl == null || originalUrl.equals(uri)) {
                    webView.getOriginalUrl();
                    webViewFragment.setErrorInfo(webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase());
                }
            }
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        qw.m973switch("BaseClient", "https error !" + sslError.toString());
        Activity activity = (Activity) this.f8061fe.get();
        if (activity != null && !activity.isFinishing()) {
            sslErrorHandler.cancel();
            fe(webView, true);
        }
    }

    @RequiresApi(api = 26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (renderProcessGoneDetail == null || !renderProcessGoneDetail.didCrash()) {
            return true;
        }
        try {
            fe(webView, false);
            return true;
        } catch (Throwable th2) {
            qw.th("BaseClient", th2.getMessage(), th2);
            return true;
        }
    }

    public void qw(IPageFinishListener iPageFinishListener) {
        this.f8063th = iPageFinishListener;
    }

    public void rg(WebView webView, BaseWebViewFragment baseWebViewFragment, boolean z) {
        try {
            baseWebViewFragment.getEmptyView().setLoadError(R.string.wap_load_error);
            baseWebViewFragment.getEmptyView().setRefreshVisibility(z ? 0 : 8);
            baseWebViewFragment.getEmptyView().setVisibility(0);
            baseWebViewFragment.setError(true);
            webView.setVisibility(4);
            baseWebViewFragment.getTextLoading().setVisibility(8);
            baseWebViewFragment.getProgressBar().setVisibility(4);
        } catch (Exception e) {
            qw.rg("BaseClient", e.getMessage());
        }
    }

    public abstract boolean shouldOverrideUrlLoading(WebView webView, String str);
}
