package com.dxmpay.wallet.paysdk.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.core.net.MailTo;
import com.alipay.sdk.m.s.a;
import com.baidu.sapi2.SapiWebView;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.webmanager.SafeWebView;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.BdActionBar;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.NFCUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.storage.HtmlDataCache;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.ActionBroadcastReceiver;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
public class WebViewActivity extends BaseActivity {
    public static final String CHANNEL_DISCOUNT_PARAMS = "channel_discount_params";
    public static final String EXTRA_PARAM = "extra_param";
    public static final String HTML_DATA_FROM_SCENE = "html_data_from_scene";
    public static final String JUMP_URL = "jump_url";
    public static final String TAG = WebViewActivity.class.getSimpleName();
    public static final int WEBVIEW_RESULT_FINISH = 1;
    public static final String WEBVIEW_TITLE = "webview_title";
    public static final String WEBVIEW_TITLE_STRING = "webview_title_string";
    public static RouterCallback mH5RouterCallback;
    public static WebViewActivity mInstance;
    public String mHtml;
    public String mHtmlFromScene;
    public SafeWebView mWebView;

    public class ad implements View.OnClickListener {
        public ad() {
        }

        public void onClick(View view) {
            WebViewActivity.this.addFinishCallback();
            WebViewActivity.this.finish();
        }
    }

    public class de extends SafeWebView.SafeChromeClient {
        public de() {
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            WebViewActivity webViewActivity = WebViewActivity.this;
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(WebViewActivity.this.getActivity(), "dxm_ebpay_wallet");
            }
            webViewActivity.initActionBar(str);
        }

        public /* synthetic */ de(WebViewActivity webViewActivity, qw qwVar) {
            this();
        }
    }

    public class fe extends SafeWebView.SafeWebViewClient {
        public fe() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WalletGlobalUtils.safeDismissDialog(WebViewActivity.this, -1);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            int primaryError = sslError == null ? 5000 : sslError.getPrimaryError();
            if (sslError == null) {
                str = null;
            } else {
                str = sslError.getUrl();
            }
            StatisticManager.onEventWithValues("#web_view_ssl_error", Arrays.asList(new String[]{primaryError + "", str}));
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("tel:")) {
                try {
                    WebViewActivity.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                } catch (Exception e) {
                    LogUtil.e(WebViewActivity.TAG, e.getMessage(), e);
                }
                return true;
            } else if (!str.startsWith(MailTo.MAILTO_SCHEME)) {
                return super.shouldOverrideUrlLoading(webView, str);
            } else {
                try {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str.substring(0, str.indexOf("?"))));
                    intent.putExtra(ActionBroadcastReceiver.KEY_URL_TITLE, Uri.parse(str.replace(MailTo.MAILTO_SCHEME, "mailto://")).getQueryParameter(MailTo.SUBJECT));
                    WebViewActivity.this.startActivity(intent);
                } catch (Exception e2) {
                    LogUtil.e(WebViewActivity.TAG, e2.getMessage(), e2);
                    GlobalUtils.toast(WebViewActivity.this.getActivity(), "请先配置邮箱");
                }
                return true;
            }
        }

        public /* synthetic */ fe(WebViewActivity webViewActivity, qw qwVar) {
            this();
        }
    }

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            GlobalUtils.hideKeyboard(WebViewActivity.this.getActivity());
            WebViewActivity.this.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public void addFinishCallback() {
        if (mH5RouterCallback != null) {
            StatisticManager.onEventWithValue(StatServiceEvent.DXMPAY_WEBVIEW_FINISH_LISTENER, "");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("isFinish", 1);
                mH5RouterCallback.onResult(0, fe.i.ad.rg.ad.qw.qw.de(true, jSONObject));
                mH5RouterCallback = null;
            } catch (JSONException e) {
                StatisticManager.onEventWithValue(StatServiceEvent.DXMPAY_WEBVIEW_ERROR, e.getMessage());
                mH5RouterCallback.onResult(1, fe.i.ad.rg.ad.qw.qw.qw(1, e.getMessage()));
            }
        }
    }

    public static void closeDxmpayWebviewActivity(RouterCallback routerCallback) {
        WebViewActivity webViewActivity = mInstance;
        if (webViewActivity != null) {
            webViewActivity.finish();
        }
        if (routerCallback != null) {
            routerCallback.onResult(0, fe.i.ad.rg.ad.qw.qw.ad(true, ""));
        }
    }

    /* access modifiers changed from: private */
    public void initActionBar(String str) {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        if (bdActionBar != null) {
            bdActionBar.setTitle(str);
            bdActionBar.setLeftZoneOnClickListener(new qw());
            if (mH5RouterCallback != null) {
                bdActionBar.setCloseButtonVisibility(0);
                bdActionBar.setCloseOnClickListener(new ad());
            }
        }
    }

    public static void setRouterCallback(RouterCallback routerCallback) {
        if (routerCallback != null) {
            mH5RouterCallback = routerCallback;
        }
    }

    public void onBackPressed() {
        SafeWebView safeWebView = this.mWebView;
        if (safeWebView == null || !safeWebView.canGoBack()) {
            addFinishCallback();
            super.onBackPressed();
            return;
        }
        this.mWebView.goBack();
    }

    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        super.onCreate(bundle);
        setContentView(ResUtils.layout(getActivity(), "dxm_wallet_base_webview_layout"));
        mInstance = this;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString("webview_title");
            if (TextUtils.isEmpty(string)) {
                str2 = extras.getString("webview_title_string");
            } else {
                str2 = ResUtils.getString(getActivity(), string);
            }
            str = extras.getString("jump_url");
            String string2 = extras.getString("bank_type");
            String string3 = extras.getString("channel_discount_params");
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(string2)) {
                    str = str + "?bank_type=" + string2;
                }
                if (!TextUtils.isEmpty(string3)) {
                    str = str + string3;
                }
            } else {
                str = DomainConfig.getInstance().getAppPayHost() + "/content/resource/HTML5/eptos.html";
            }
        } else {
            str = DomainConfig.getInstance().getAppPayHost() + "/content/resource/HTML5/eptos.html";
            str2 = "";
        }
        String ua = BussinessUtils.getUA(this);
        if (!TextUtils.isEmpty(str)) {
            if (str.contains("?")) {
                str3 = str + "&ua=" + ua;
            } else {
                str3 = str + "?ua=" + ua;
            }
            str = str3;
            if (extras != null) {
                String string4 = extras.getString("extra_param");
                if (!TextUtils.isEmpty(string4)) {
                    str = str + a.n + string4;
                }
            }
        }
        WalletGlobalUtils.safeShowDialog(this, -1, "");
        SafeWebView safeWebView = (SafeWebView) findViewById(ResUtils.id(getActivity(), "dxm_cust_webview"));
        this.mWebView = safeWebView;
        safeWebView.setWebViewClient(new fe(this, (qw) null));
        if (TextUtils.isEmpty(str2)) {
            this.mWebView.setWebChromeClient(new de(this, (qw) null));
        }
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setTextZoom(100);
        if (Build.VERSION.SDK_INT <= 18) {
            this.mWebView.getSettings().setSavePassword(false);
        }
        this.mWebView.setScrollBarStyle(0);
        this.mWebView.clearCache(false);
        this.mWebView.resumeTimers();
        if (Build.VERSION.SDK_INT >= 11) {
            this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.mWebView.removeJavascriptInterface("accessibility");
            this.mWebView.removeJavascriptInterface("accessibilityTraversal");
        }
        String html = HtmlDataCache.getInstance().getHtml();
        this.mHtml = html;
        if (!TextUtils.isEmpty(html)) {
            this.mHtmlFromScene = extras.getString(HTML_DATA_FROM_SCENE);
            HashMap hashMap = new HashMap();
            hashMap.put(StatServiceEvent.FROM_SCENE, this.mHtmlFromScene);
            StatHelper.statServiceEvent(StatServiceEvent.ENTER_H5_HTML_PAGE, hashMap, new String[0]);
            this.mWebView.loadDataWithBaseURL((String) null, this.mHtml, SapiWebView.DATA_MIME_TYPE, com.baidu.apollon.heartbeat.a.h, (String) null);
        } else {
            this.mWebView.loadUrl(str);
        }
        initActionBar(str2);
    }

    public void onDestroy() {
        super.onDestroy();
        if (!TextUtils.isEmpty(this.mHtml)) {
            HashMap hashMap = new HashMap();
            hashMap.put(StatServiceEvent.FROM_SCENE, this.mHtmlFromScene);
            StatHelper.statServiceEvent(StatServiceEvent.CLOSE_H5_HTML_PAGE, hashMap, new String[0]);
            HtmlDataCache.getInstance().clearData();
            this.mHtml = null;
        }
        if (mH5RouterCallback != null) {
            addFinishCallback();
            mH5RouterCallback = null;
        }
        if (mInstance != null) {
            mInstance = null;
        }
    }

    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
    }

    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
    }
}
