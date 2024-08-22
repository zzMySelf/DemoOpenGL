package com.baidu.apollon.webmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.base.ApollonBaseActivity;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import java.io.File;
import java.util.Objects;

public class a {
    public static final String a = "AbstractWebViewPage";
    public static final boolean b = (ApollonConstants.DEBUG & false);
    public static final String c = "appcache";
    public static final String d = "databases";
    public static final String e = "geolocation";
    public static final String f = "page load success";
    public static final String g = "page load failure";
    public final View h;

    /* renamed from: i  reason: collision with root package name */
    public final View f725i;
    public ViewGroup j = null;
    public SafeWebView k;
    public boolean l = false;
    public int m = 0;
    public String n = "";

    /* renamed from: o  reason: collision with root package name */
    public ApollonBaseActivity f726o = null;
    public boolean p = false;
    public EventBus q;

    public a(ApollonBaseActivity apollonBaseActivity, ViewGroup viewGroup, View view, View view2, int i2) {
        this.f726o = apollonBaseActivity;
        this.j = viewGroup;
        this.h = view;
        this.f725i = view2;
        this.l = false;
        this.m = i2;
        String[] strArr = {f, g};
        EventBus instance = EventBus.getInstance();
        this.q = instance;
        instance.register((Object) this, strArr, 0, EventBus.ThreadMode.MainThread);
        n();
    }

    private void j() {
        ViewGroup viewGroup;
        View view = this.h;
        if (view != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
            viewGroup.removeView(this.h);
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        View view = this.f725i;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        j();
        View view = this.f725i;
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f725i);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.j.addView(this.f725i, layoutParams);
            this.f725i.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        EventBus eventBus = this.q;
        Objects.requireNonNull(eventBus);
        eventBus.post(new EventBus.Event(f, (Object) null));
    }

    private void n() {
        Context applicationContext = DxmApplicationContextImpl.getApplicationContext(this.f726o);
        if (applicationContext != null) {
            this.k = new SafeWebView(applicationContext);
            if (this.l) {
                File file = new File(applicationContext.getCacheDir(), "webviewCacheChromium");
                if (!file.exists()) {
                    file = new File(applicationContext.getCacheDir(), "webviewCache");
                }
                if (!file.exists()) {
                    this.k.getSettings().setCacheMode(1);
                } else if (NetworkUtils.isNetworkConnected(applicationContext)) {
                    this.k.getSettings().setCacheMode(-1);
                } else {
                    this.k.getSettings().setCacheMode(1);
                }
            }
            this.k.setScrollBarStyle(0);
            this.k.getSettings().setBlockNetworkImage(true);
            this.k.setLongClickable(true);
            a(this.k);
            this.k.setWebViewClient(new SafeWebView.SafeWebViewClient() {
                public void onLoadResource(WebView webView, String str) {
                    super.onLoadResource(webView, str);
                    if (a.b) {
                        "onLoadResource is called, url is " + str;
                    }
                }

                public void onPageFinished(WebView webView, String str) {
                    int i2;
                    if (a.b) {
                        "onPageFinished, url is " + str + " original url is " + webView.getOriginalUrl();
                    }
                    super.onPageFinished(webView, str);
                    Object tag = webView.getTag(a.this.m);
                    if (tag == null) {
                        i2 = 0;
                    } else {
                        i2 = ((Integer) tag).intValue();
                    }
                    if (a.b) {
                        "onPageFinished errorTagCode is " + i2;
                    }
                    if (TextUtils.equals(str, a.this.n) || TextUtils.equals(webView.getOriginalUrl(), a.this.n) || (str != null && str.contains(a.this.n))) {
                        if (i2 == 0) {
                            a.this.m();
                        } else {
                            a.this.b(i2);
                        }
                    }
                    a.this.k();
                    a.this.k.getSettings().setBlockNetworkImage(false);
                }

                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    super.onPageStarted(webView, str, bitmap);
                    if (a.b) {
                        "onPageStarted is called, url is " + str;
                    }
                    if (a.this.p) {
                        a.this.k.getSettings().setBlockNetworkImage(true);
                        if (Build.VERSION.SDK_INT >= 16) {
                            a.this.k.clearView();
                        }
                    }
                    boolean unused = a.this.p = false;
                    String unused2 = a.this.n = str;
                    WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
                    if (a.this.h != null && a.this.h.getVisibility() == 0) {
                        return;
                    }
                    if (copyBackForwardList == null || copyBackForwardList.getCurrentIndex() == copyBackForwardList.getSize() - 1) {
                        a.this.l();
                    }
                }

                public void onReceivedError(WebView webView, int i2, String str, String str2) {
                    if (a.b) {
                        "onReceivedError is called, errorCode is  " + i2 + " failingUrl is " + str2;
                    }
                    webView.setTag(a.this.m, Integer.valueOf(i2));
                }

                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    if (a.b) {
                        "shouldOverrideUrlLoading, url is " + str;
                    }
                    boolean unused = a.this.p = true;
                    String unused2 = a.this.n = str;
                    a.this.l();
                    return false;
                }
            });
            this.k.setWebChromeClient(new SafeWebView.SafeChromeClient() {
                public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
                    quotaUpdater.updateQuota(j * 2);
                }
            });
        }
    }

    public void b() {
        this.k.goBack();
        this.p = true;
    }

    public void c() {
        this.k.goForward();
        this.p = true;
    }

    public boolean d() {
        return this.k.canGoBack();
    }

    @SuppressLint({"NewApi"})
    public void e() {
        SafeWebView safeWebView;
        if (Build.VERSION.SDK_INT >= 11 && (safeWebView = this.k) != null) {
            safeWebView.onPause();
        }
    }

    @SuppressLint({"NewApi"})
    public void f() {
        SafeWebView safeWebView;
        if (Build.VERSION.SDK_INT >= 11 && (safeWebView = this.k) != null) {
            safeWebView.onResume();
        }
    }

    public void g() {
        ViewGroup viewGroup = (ViewGroup) this.k.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.k);
        }
        this.k.destroy();
        this.k = null;
    }

    public void h() {
        String str = Uri.parse(this.n).getScheme() + "://" + Uri.parse(this.n).getHost();
        if (b) {
            "delOrigin is " + str;
        }
        if (!TextUtils.isEmpty(str)) {
            WebStorage.getInstance().deleteOrigin(str);
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (b) {
                "delOrigin is " + str;
            }
            WebStorage.getInstance().deleteOrigin(str);
        }
    }

    public SafeWebView a() {
        return this.k;
    }

    public void a(String str) {
        this.n = str;
        this.p = true;
        this.k.loadUrl(str);
        l();
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        EventBus eventBus = this.q;
        Objects.requireNonNull(eventBus);
        eventBus.post(new EventBus.Event(g, Integer.valueOf(i2)));
    }

    public void a(EventBus.Event event) {
        if (event.mEventKey.equals(f)) {
            j();
            k();
            this.k.setVisibility(0);
        } else if (event.mEventKey.equals(g)) {
            a(((Integer) event.mEventObj).intValue());
            this.k.setVisibility(8);
        }
    }

    public a(ApollonBaseActivity apollonBaseActivity, ViewGroup viewGroup, View view, View view2, boolean z, int i2) {
        this.f726o = apollonBaseActivity;
        this.j = viewGroup;
        this.h = view;
        this.f725i = view2;
        this.l = z;
        this.m = i2;
        n();
    }

    private void a(int i2) {
        if (i2 == 0) {
            j();
            return;
        }
        k();
        View view = this.h;
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.h);
            }
            this.j.addView(this.h, this.j.getLayoutParams());
            this.h.setVisibility(0);
        }
    }

    private void a(SafeWebView safeWebView) {
        Context applicationContext = DxmApplicationContextImpl.getApplicationContext(this.f726o);
        if (applicationContext != null) {
            WebSettings settings = safeWebView.getSettings();
            if (this.l) {
                settings.setDomStorageEnabled(true);
                settings.setDatabaseEnabled(true);
                settings.setDomStorageEnabled(true);
                settings.setGeolocationEnabled(true);
                settings.setDatabasePath(applicationContext.getDir(d, 0).getPath());
                if (this.l) {
                    settings.setAppCacheEnabled(true);
                    settings.setAppCachePath(applicationContext.getDir("appcache", 0).getPath());
                }
            }
            settings.setGeolocationDatabasePath(applicationContext.getDir(e, 0).getPath());
            settings.setNeedInitialFocus(false);
            settings.setBuiltInZoomControls(true);
            settings.setSupportZoom(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
        }
    }
}
