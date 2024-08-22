package com.baidu.wallet.paysdk.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.baidu.android.lbspay.activity.WapPayActivity;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity;
import com.baidu.wallet.paysdk.ui.widget.DxmNoNetView;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.NetworkUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.webmanager.SafeWebView;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.BdActionBar;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.utils.HttpsCertVerifyUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.net.URLEncoder;
import java.util.Arrays;

@SuppressLint({"SetJavaScriptEnabled"})
public abstract class BaseWebViewActivity extends DxmPayBaseActivity {
    public static final String CHANNEL_DISCOUNT_PARAMS = "channel_discount_params";
    public static final String EXTRA_PARAM = "extra_param";
    public static final String JUMP_URL = "jump_url";
    public static final String WEBVIEW_TITLE = "webview_title";
    public static final String WEBVIEW_TITLE_STRING = "webview_title_string";
    public static final String a = BaseWebViewActivity.class.getSimpleName();
    public SafeWebView b;
    public DxmNoNetView c;
    public boolean mIsSuccessFlag = false;

    public class a extends SafeWebView.SafeChromeClient {
        public boolean b;

        public a() {
        }

        public void onProgressChanged(WebView webView, int i2) {
            if (i2 <= 25) {
                this.b = false;
            } else if (!this.b) {
                BaseWebViewActivity.this.b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
                this.b = true;
                if (DxmPayBeanConstants.DEBUG) {
                    String unused = BaseWebViewActivity.a;
                    " inject js interface completely on progress " + i2;
                }
            }
            super.onProgressChanged(webView, i2);
        }

        public void onReceivedTitle(WebView webView, String str) {
            if (!this.b) {
                if (DxmPayBeanConstants.DEBUG) {
                    String unused = BaseWebViewActivity.a;
                    "onReceivedTitle: " + str;
                }
                BaseWebViewActivity.this.b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
            }
            super.onReceivedTitle(webView, str);
            this.b = true;
            BaseWebViewActivity baseWebViewActivity = BaseWebViewActivity.this;
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(BaseWebViewActivity.this.getActivity(), "ebpay_bd_my_wallet");
            }
            baseWebViewActivity.a(str);
        }
    }

    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public abstract void notifyResultMsg();

    public void onBackPressed() {
        SafeWebView safeWebView = this.b;
        if (safeWebView == null || !safeWebView.canGoBack()) {
            notifyResultMsg();
            super.onBackPressed();
            return;
        }
        this.b.goBack();
    }

    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        super.onCreate(bundle);
        setContentView(ResUtils.layout(getActivity(), "dxm_wallet_base_webview_layout"));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString("webview_title");
            if (TextUtils.isEmpty(string)) {
                str2 = extras.getString("webview_title_string");
            } else {
                str2 = ResUtils.getString(getActivity(), string);
            }
            str = extras.getString("jump_url");
        } else {
            str = DomainConfig.getInstance().getAppPayHost() + "/content/resource/HTML5/eptos.html";
            str2 = "";
        }
        this.mIsSuccessFlag = false;
        String ua = BussinessUtils.getUA(this);
        if (!TextUtils.isEmpty(str)) {
            if (str.contains("?")) {
                str3 = str + "&ua=" + ua;
            } else {
                str3 = str + "?ua=" + ua;
            }
            String encryptProxy = SecurePay.getInstance().encryptProxy(PayUtils.getCookie(this));
            if (!TextUtils.isEmpty(encryptProxy)) {
                str4 = URLEncoder.encode(encryptProxy);
            } else {
                str4 = "";
            }
            str = str3 + "&atbc=" + str4 + "&key=" + URLEncoder.encode(SecurePay.getInstance().getpwProxy());
            if (extras != null) {
                String string2 = extras.getString("extra_param");
                if (!TextUtils.isEmpty(string2)) {
                    str = str + com.alipay.sdk.m.s.a.n + string2;
                }
            }
        }
        WalletGlobalUtils.safeShowDialog(this, -1, "");
        SafeWebView safeWebView = (SafeWebView) findViewById(ResUtils.id(getActivity(), "dxm_cust_webview"));
        this.b = safeWebView;
        safeWebView.setWebViewClient(new b());
        if (TextUtils.isEmpty(str2)) {
            this.b.setWebChromeClient(new a());
        }
        this.b.getSettings().setJavaScriptEnabled(true);
        this.b.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT <= 18) {
            this.b.getSettings().setSavePassword(false);
        }
        this.b.setScrollBarStyle(0);
        this.b.clearCache(false);
        this.b.resumeTimers();
        if (Build.VERSION.SDK_INT >= 11) {
            this.b.removeJavascriptInterface("searchBoxJavaBridge_");
            this.b.removeJavascriptInterface("accessibility");
            this.b.removeJavascriptInterface("accessibilityTraversal");
        }
        if (TextUtils.isEmpty(str)) {
            finish();
            return;
        }
        try {
            this.b.loadUrl(str.trim());
        } catch (Exception unused) {
            finish();
        }
        a(str2);
        this.c = (DxmNoNetView) findViewById(ResUtils.id(getActivity(), "dxm_nonet_view"));
    }

    /* access modifiers changed from: private */
    public void b() {
        DxmNoNetView dxmNoNetView = this.c;
        if (dxmNoNetView != null) {
            dxmNoNetView.notifyUrlFinish();
        }
        SafeWebView safeWebView = this.b;
        if (safeWebView != null) {
            safeWebView.setVisibility(0);
        }
    }

    public class b extends SafeWebView.SafeWebViewClient {
        public boolean b;

        public b() {
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            if (!this.b) {
                if (DxmPayBeanConstants.DEBUG) {
                    String unused = BaseWebViewActivity.a;
                    "doUpdateVisitedHistory: " + str;
                }
                BaseWebViewActivity.this.b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
            }
            super.doUpdateVisitedHistory(webView, str, z);
            this.b = true;
        }

        public void onLoadResource(WebView webView, String str) {
            if (!this.b && DxmPayBeanConstants.DEBUG) {
                String unused = BaseWebViewActivity.a;
                "onLoadResource: " + str;
            }
            super.onLoadResource(webView, str);
            this.b = true;
        }

        public void onPageFinished(WebView webView, String str) {
            if (!this.b) {
                if (DxmPayBeanConstants.DEBUG) {
                    String unused = BaseWebViewActivity.a;
                    "onPageFinished: " + str;
                }
                BaseWebViewActivity.this.b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
            }
            super.onPageFinished(webView, str);
            WalletGlobalUtils.safeDismissDialog(BaseWebViewActivity.this, -1);
            this.b = false;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (!this.b) {
                if (DxmPayBeanConstants.DEBUG) {
                    String unused = BaseWebViewActivity.a;
                    "onPageStarted: " + str;
                }
                BaseWebViewActivity.this.b.loadUrl("javascript:window._SIGN_FROM_BAIDUWALLETSIMPLEPAY=1");
            }
            super.onPageStarted(webView, str, bitmap);
            this.b = true;
            if (!NetworkUtils.isNetworkAvailable(BaseWebViewActivity.this)) {
                BaseWebViewActivity.this.a(str, -8, (SslErrorHandler) null);
            } else {
                BaseWebViewActivity.this.b();
            }
        }

        @RequiresApi(api = 23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webResourceError != null && webResourceRequest != null && webResourceError.getErrorCode() != -10 && webResourceRequest.isForMainFrame()) {
                BaseWebViewActivity.this.a(webResourceRequest.getUrl().toString(), webResourceError.getErrorCode(), (SslErrorHandler) null);
            }
        }

        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            int i2;
            String str;
            WalletGlobalUtils.safeDismissDialog(BaseWebViewActivity.this, -1);
            if (sslError == null) {
                i2 = 5000;
            } else {
                i2 = sslError.getPrimaryError();
            }
            if (sslError == null) {
                str = null;
            } else {
                str = sslError.getUrl();
            }
            StatisticManager.onEventWithValues("#h5_cashier_ssl_error", Arrays.asList(new String[]{i2 + "", str}));
            if (HttpsCertVerifyUtil.isWhiteListVerificationPassed(sslError)) {
                sslErrorHandler.proceed();
            } else {
                BaseWebViewActivity.this.a(str, i2, sslErrorHandler);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String host;
            Uri parse = Uri.parse(str);
            if (parse == null || !"baiduwalletsimplepay".equals(parse.getScheme()) || (host = parse.getHost()) == null) {
                return false;
            }
            if (host.startsWith(WapPayActivity.SUCCESS_NOTIFY_METHOD)) {
                BaseWebViewActivity.this.mIsSuccessFlag = true;
            } else if (host.startsWith(WapPayActivity.CLOSE_VIEW_METHOD)) {
                BaseWebViewActivity.this.notifyResultMsg();
            }
            return true;
        }

        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            if (i2 != -10) {
                BaseWebViewActivity.this.a(str2, i2, (SslErrorHandler) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        if (bdActionBar != null) {
            bdActionBar.setTitle(str);
            bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(BaseWebViewActivity.this.getActivity());
                    BaseWebViewActivity.this.onBackPressed();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(final String str, final int i2, final SslErrorHandler sslErrorHandler) {
        if (this.c != null) {
            boolean z = false;
            StatisticManager.onEventWithValues(StatServiceEvent.SHOW_NETWORK_ERR_VIEW, Arrays.asList(new String[]{i2 + "", str}));
            if (sslErrorHandler != null) {
                z = true;
            }
            this.c.show(str, z, new DxmNoNetView.a() {
                public void a(String str) {
                    StatisticManager.onEventWithValues(StatServiceEvent.CLICK_NETWORK_ERR_RELOAD, Arrays.asList(new String[]{i2 + "", str}));
                    if (!NetworkUtils.isNetworkAvailable(BaseWebViewActivity.this)) {
                        GlobalUtils.toast(BaseWebViewActivity.this.getActivity(), ResUtils.getString(BaseWebViewActivity.this.getApplicationContext(), "dxm_ebpay_no_network"));
                    } else if (BaseWebViewActivity.this.b != null) {
                        BaseWebViewActivity.this.b.reload();
                    }
                }

                public void a() {
                    StatisticManager.onEventWithValues(StatServiceEvent.CLICK_NETWORK_ERR_CONTINUE_LOAD, Arrays.asList(new String[]{i2 + "", str}));
                    if (!NetworkUtils.isNetworkAvailable(BaseWebViewActivity.this)) {
                        GlobalUtils.toast(BaseWebViewActivity.this.getActivity(), ResUtils.getString(BaseWebViewActivity.this.getApplicationContext(), "dxm_ebpay_no_network"));
                        return;
                    }
                    SslErrorHandler sslErrorHandler = sslErrorHandler;
                    if (sslErrorHandler != null) {
                        sslErrorHandler.proceed();
                    }
                }
            });
        }
        SafeWebView safeWebView = this.b;
        if (safeWebView != null) {
            safeWebView.setVisibility(8);
        }
    }
}
