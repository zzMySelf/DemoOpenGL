package com.baidu.wallet.lightapp.business;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ZoomButtonsController;
import androidx.annotation.Nullable;
import androidx.core.net.MailTo;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase;
import com.baidu.wallet.core.BaseFragment;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.utils.HttpsCertVerifyUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.lightapp.ability.b.b;
import com.baidu.wallet.lightapp.base.LightappJsClient;
import com.baidu.wallet.lightapp.base.LightappWebView;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.multipage.a;
import com.baidu.wallet.lightapp.widget.NoNetView;
import com.baidu.wallet.lightapp.widget.PullToRefreshWebview;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LightappBrowserFragment extends BaseFragment implements NoProguard, a, NoNetView.a {
    public static final String JUMP_URL = "jump_url";
    public static Pattern b = Pattern.compile("^(https?://|file:///android_asset/).*");
    public static final String sTag = LightappBrowserFragment.class.getSimpleName();
    public boolean a = false;
    public String c;
    public LightappWebView d;
    public PullToRefreshWebview e;
    public LightappJsClient f;
    public boolean g = true;
    public DownloadListener h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3566i = true;
    public NoNetView j;
    public View k;
    public String l;
    public boolean m = true;
    public LayoutInflater mInflater;
    public String n;

    /* renamed from: o  reason: collision with root package name */
    public String f3567o;
    public boolean p = false;
    public String q = "wallet_base_multi_window_tips";
    public boolean r = false;
    public ViewGroup s;

    public class BaseCustomChromeClient extends SafeWebView.SafeChromeClient implements NoProguard {
        public BaseCustomChromeClient() {
        }

        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    public class BaseCustomWebViewClient extends SafeWebView.SafeWebViewClient implements NoProguard {
        public BaseCustomWebViewClient() {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_lOAD_START);
            LightappBrowserFragment.this.f.setUrlLocal(str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Deprecated
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(new String[]{i2 + "", str2}));
            LogUtil.d(LightappBrowserFragment.sTag, "onReceivedError.showErrorPage");
            super.onReceivedError(webView, i2, str, str2);
        }

        @TargetApi(15)
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String str2 = LightappBrowserFragment.sTag;
            LogUtil.d(str2, "OriginalUrl : " + webView.getOriginalUrl());
            String str3 = LightappBrowserFragment.sTag;
            LogUtil.d(str3, "shouldOverrideUrlLoading url = " + str);
            if (str.startsWith("tel:")) {
                LightappBrowserFragment.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                return true;
            } else if (str.startsWith(MailTo.MAILTO_SCHEME)) {
                try {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{str.replace(MailTo.MAILTO_SCHEME, "")});
                    LightappBrowserFragment.this.startActivity(intent);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    GlobalUtils.toast(LightappBrowserFragment.this.getActivity(), "请先配置邮箱");
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            } else if (!str.toLowerCase(Locale.CHINA).startsWith("http") && !str.toLowerCase(Locale.CHINA).startsWith("https") && !str.toLowerCase(Locale.CHINA).startsWith("file")) {
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent2.addCategory("android.intent.category.BROWSABLE");
                    intent2.setComponent((ComponentName) null);
                    intent2.setSelector((Intent) null);
                    LightappBrowserFragment.this.startActivity(intent2);
                    return true;
                } catch (Exception e2) {
                    LogUtil.d(LightappBrowserFragment.sTag, e2.getMessage());
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            } else if (!LightappBrowserFragment.this.f3566i || TextUtils.isEmpty(LightappBrowserFragment.this.c) || str.equals(LightappBrowserFragment.this.c)) {
                return false;
            } else {
                BaiduWalletDelegate.getInstance().openH5Module(LightappBrowserFragment.this.getActivity(), str, true);
                return true;
            }
        }
    }

    public class CustomChromeClient extends BaseCustomChromeClient implements NoProguard {
        public CustomChromeClient() {
            super();
        }

        public void onProgressChanged(WebView webView, int i2) {
            if (LightappBrowserFragment.this.m) {
                LightappBrowserFragment.this.a(i2);
            }
            if (i2 == 100) {
                if (LightappBrowserFragment.this.m) {
                    LightappBrowserFragment.this.e();
                }
                if (!LightappBrowserFragment.this.a) {
                    LogUtil.d(LightappBrowserFragment.sTag, "onProgressChanged.hideErrorPage");
                    LightappBrowserFragment.this.f();
                }
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (TextUtils.isEmpty(LightappBrowserFragment.this.n) || NetworkUtils.isNetworkConnected(LightappBrowserFragment.this.getActivity())) {
                String unused = LightappBrowserFragment.this.f3567o;
            }
        }
    }

    public class CustomWebViewClient extends BaseCustomWebViewClient implements NoProguard {
        public CustomWebViewClient() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            if (LightappBrowserFragment.this.m) {
                LightappBrowserFragment.this.e();
            }
            LightappBrowserFragment.this.a(str);
            if (webView.getProgress() != 100) {
                LightappBrowserFragment.this.a = true;
            }
            String str2 = LightappBrowserFragment.sTag;
            LogUtil.d(str2, "onPageFinished.finishedError:  " + LightappBrowserFragment.this.a);
            super.onPageFinished(webView, str);
            DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_END_lOAD);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (LightappBrowserFragment.this.m) {
                LightappBrowserFragment.this.d();
            }
            String unused = LightappBrowserFragment.this.f3567o = null;
            super.onPageStarted(webView, str, bitmap);
            DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD);
        }

        @Deprecated
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            if (-10 != i2) {
                LightappBrowserFragment lightappBrowserFragment = LightappBrowserFragment.this;
                lightappBrowserFragment.a = true;
                if (lightappBrowserFragment.j != null) {
                    LightappBrowserFragment.this.j.setFailureCause(i2, false);
                }
                LightappBrowserFragment.this.b(str2);
                super.onReceivedError(webView, i2, str, str2);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            int primaryError = sslError == null ? NoNetView.ERROR_SSL_GENERAL : sslError.getPrimaryError();
            if (sslError == null) {
                str = null;
            } else {
                str = sslError.getUrl();
            }
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BROWSER_FRAGMENT_SSL_ERROR, Arrays.asList(new String[]{primaryError + "", str}));
            if (HttpsCertVerifyUtil.isWhiteListVerificationPassed(sslError)) {
                sslErrorHandler.proceed();
                return;
            }
            LightappBrowserFragment lightappBrowserFragment = LightappBrowserFragment.this;
            lightappBrowserFragment.a = true;
            if (lightappBrowserFragment.j != null) {
                LightappBrowserFragment.this.j.setFailureCause(primaryError, true);
            }
            LightappBrowserFragment.this.b(str);
            DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(new String[]{primaryError + "", str}));
            String environment = DebugConfig.getInstance(LightappBrowserFragment.this.getActivity()).getEnvironment();
            if ("QA".equals(environment) || "RD".equals(environment)) {
                sslErrorHandler.proceed();
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }
    }

    public void checkClodDown(String str, List<String> list, String str2) {
    }

    public void closeTopWebview() {
    }

    public void closeWindow() {
        getActivity().finish();
    }

    public void customNaviBar(TitleBarParams titleBarParams) {
    }

    public void doNetworkTomography(String str, Map<String, String> map) {
        b.a().a(str, new b.a() {
            public boolean a = false;

            public void a(int i2) {
                if (!this.a) {
                    WalletGlobalUtils.showLoadingDialog(LightappBrowserFragment.this.getActivity());
                }
            }

            public void a(String str) {
                WalletGlobalUtils.DismissLoadingDialog();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.optBoolean("isOnline", true)) {
                        GlobalUtils.toast(LightappBrowserFragment.this.getContext(), ResUtils.getString(LightappBrowserFragment.this.getActivity(), "network_no_connected"));
                    } else if (!jSONObject.optBoolean("isInternetConnected", true)) {
                        GlobalUtils.toast(LightappBrowserFragment.this.getContext(), ResUtils.getString(LightappBrowserFragment.this.getActivity(), "network_no_internet_connected"));
                    } else {
                        GlobalUtils.toast(LightappBrowserFragment.this.getContext(), ResUtils.getString(LightappBrowserFragment.this.getActivity(), "network_tomography_done"));
                    }
                } catch (JSONException unused) {
                }
            }
        }, getContext(), map);
    }

    public void enableProgressStripe(boolean z) {
        this.m = z;
    }

    public String exeSSCommand(String str, String str2, String str3) {
        return null;
    }

    public void executeJsFunction(String str, String str2) {
        if (this.d != null && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder(str);
                sb.append("(\"");
                if (str2 != null) {
                    sb.append(LightappUtils.formatJSONForWebViewCallback(str2));
                }
                sb.append("\")");
                if (Build.VERSION.SDK_INT >= 19) {
                    this.d.evaluateJavascript(sb.toString(), (ValueCallback) null);
                    return;
                }
                LightappWebView lightappWebView = this.d;
                lightappWebView.loadUrl("javascript:" + sb.toString());
            } catch (Throwable unused) {
            }
        }
    }

    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    public String getCellHashStamps() {
        return null;
    }

    public String getLoadTimeLine() {
        return null;
    }

    public Activity getNextActivity() {
        return null;
    }

    public void historyGo(int i2) {
    }

    public void insertPhoneNumToAddressBook(String str, String str2) {
    }

    public boolean isActiveCell() {
        return true;
    }

    public boolean isPreloaded() {
        return false;
    }

    public void loadAlubm(String str) {
    }

    public void messageForwarding(Context context, String str) {
    }

    public void onBackPressed() {
        if (this.d.canGoBack()) {
            String str = sTag;
            LogUtil.d(str, "cangoback:  " + this.d.getUrl());
            this.d.goBack();
        }
    }

    public void onContinueClick(String str) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setIsShowMultiWindowTips(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.mInflater = layoutInflater;
        return a();
    }

    public void onDestroy() {
        super.onDestroy();
        LightappJsClient lightappJsClient = this.f;
        if (lightappJsClient != null) {
            lightappJsClient.destroy();
        }
        LightappWebView lightappWebView = this.d;
        if (lightappWebView != null) {
            ViewGroup viewGroup = (ViewGroup) lightappWebView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.d);
            }
            this.d.removeAllViews();
            this.d.destroy();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (!isDetached() && !isRemoving()) {
            try {
                getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onReloadClick(String str) {
        refresh(str);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.f.onRequestPermissionsResultLocal(i2, strArr, iArr);
    }

    public void onResume() {
        LightappWebView lightappWebView = this.d;
        if (lightappWebView != null) {
            lightappWebView.setDownloadListener(this.h);
        }
        super.onResume();
    }

    public void openInNewWebView(String str, String str2) {
    }

    public void preLoadException(String str) {
    }

    public void preLoadUrl(ArrayList<String> arrayList, int i2) {
    }

    public void refresh(String str) {
        Context applicationContext = DxmApplicationContextImpl.getApplicationContext(getActivity());
        if (!NetworkUtils.isNetworkAvailable(applicationContext)) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(applicationContext, "ebpay_no_network"));
        } else if (this.d != null) {
            if (!TextUtils.isEmpty(str) && !b.matcher(str).matches()) {
                str = "https://" + str;
            }
            if (TextUtils.isEmpty(str)) {
                this.d.reload();
            } else {
                this.c = str;
                this.d.loadUrl(str);
            }
            this.a = false;
        }
    }

    public void rmFromPreloadPool() {
    }

    public void rpaPerception(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
    }

    public void selectPhoneFromAddressBook() {
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.h = downloadListener;
    }

    public JSONObject setFullScreenInMainThread(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2) {
        return null;
    }

    public void setHalfLightBridgeStyle(Context context, Double d2, String str, int i2) {
    }

    public void setIsCheckPermission(boolean z) {
    }

    public void setIsShowMultiWindowTips(boolean z) {
        if (z != this.p) {
            this.p = z;
        }
    }

    public void setMenuInMainThread(JSONArray jSONArray) {
    }

    public void setMultiWindowTipsId(String str) {
        this.q = str;
    }

    public void setScreenVertical(boolean z) {
    }

    public void setSubMenu(String str, String str2, String str3, int i2, String str4, String str5, int i3, int i4) {
    }

    @SuppressLint({"NewApi"})
    public void setSupportZoom() {
        this.d.getSettings().setSupportZoom(true);
        this.d.getSettings().setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= 11) {
            this.d.getSettings().setDisplayZoomControls(false);
        } else {
            setZoomControlGone(this.d);
        }
        this.d.getSettings().setUseWideViewPort(true);
    }

    public void setTitlesInMainThread(String str, String str2, boolean z) {
    }

    public void setZoomControlGone(View view) {
        try {
            Field declaredField = WebView.class.getDeclaredField("mZoomButtonsController");
            declaredField.setAccessible(true);
            ZoomButtonsController zoomButtonsController = new ZoomButtonsController(view);
            zoomButtonsController.getZoomControls().setVisibility(8);
            try {
                declaredField.set(view, zoomButtonsController);
            } catch (IllegalArgumentException e2) {
                LogUtil.d(e2.getMessage());
            } catch (IllegalAccessException e3) {
                LogUtil.d(e3.getMessage());
            }
        } catch (SecurityException e4) {
            LogUtil.d(e4.getMessage());
        } catch (NoSuchFieldException e5) {
            LogUtil.d(e5.getMessage());
        }
    }

    public void setmOpenUrlInNewWindow(boolean z) {
        this.f3566i = z;
    }

    public void showTitleFloatView(boolean z, String str) {
    }

    public void startNewLightApp(Context context, String str, String str2, boolean z, boolean z2, Double d2, String str3) {
    }

    /* access modifiers changed from: private */
    public void d() {
        b();
    }

    /* access modifiers changed from: private */
    public void e() {
        c();
    }

    /* access modifiers changed from: private */
    public void f() {
        NoNetView noNetView = this.j;
        if (noNetView != null) {
            noNetView.notifyUrlFinish();
        }
        LightappWebView lightappWebView = this.d;
        if (lightappWebView != null) {
            lightappWebView.setVisibility(0);
        }
    }

    private void b() {
        this.k.setVisibility(0);
        this.k.setBackgroundColor(ResUtils.getColor(getActivity(), "ebpay_blue"));
        a(5);
    }

    private void c() {
        this.k.setBackgroundColor(ResUtils.getColor(getActivity(), "ebpay_transparent"));
    }

    private View a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.c = arguments.getString("jump_url");
        }
        if (TextUtils.isEmpty(this.c)) {
            return null;
        }
        String trim = this.c.trim();
        this.c = trim;
        if (!b.matcher(trim).matches()) {
            this.c = "https://" + this.c;
        }
        if (this.c.contains("hideNativeErrorPage=1") || this.c.contains("hideNativeErrorPage%3d1")) {
            this.g = false;
        }
        this.n = "";
        this.l = ResUtils.getString(getActivity(), "ebpay_loading");
        ViewGroup viewGroup = (ViewGroup) this.mInflater.inflate(ResUtils.layout(getActivity(), "wallet_base_lightapp_webview_fragment"), (ViewGroup) null);
        this.s = viewGroup;
        this.e = (PullToRefreshWebview) viewGroup.findViewById(ResUtils.id(getActivity(), "cust_webview"));
        this.e.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<LightappWebView>() {
            public Handler a = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message message) {
                    if (1 == message.what) {
                        PullToRefreshBase pullToRefreshBase = (PullToRefreshBase) message.obj;
                        if (pullToRefreshBase != null) {
                            pullToRefreshBase.onPullDownRefreshComplete();
                        }
                        removeMessages(1);
                    }
                }
            };
            public final int c = 1;

            public void onPullDownToRefresh(PullToRefreshBase<LightappWebView> pullToRefreshBase) {
                pullToRefreshBase.getRefreshableView().reload();
                Message obtain = Message.obtain();
                obtain.obj = pullToRefreshBase;
                obtain.what = 1;
                this.a.sendMessageDelayed(obtain, 600);
            }

            public void onPullUpToRefresh(PullToRefreshBase<LightappWebView> pullToRefreshBase) {
            }
        });
        this.e.setPullRefreshEnabled(true);
        this.e.setLoadingAnimationStyle(LoadingLayout.AnimationStyle.ROTATE);
        this.d = (LightappWebView) this.e.getRefreshableView();
        this.j = (NoNetView) this.s.findViewById(ResUtils.id(getActivity(), "nonet_view"));
        this.k = this.s.findViewById(ResUtils.id(getActivity(), "progress_line"));
        String userAgentString = this.d.getSettings().getUserAgentString();
        LogUtil.logd("ua=" + userAgentString);
        WebSettings settings = this.d.getSettings();
        settings.setUserAgentString(userAgentString + " " + BussinessUtils.getUA(getActivity()));
        StringBuilder sb = new StringBuilder();
        sb.append("ua2=");
        sb.append(this.d.getSettings().getUserAgentString());
        LogUtil.logd(sb.toString());
        this.d.setWebViewClient(new CustomWebViewClient());
        this.d.setWebChromeClient(new CustomChromeClient());
        this.d.getSettings().setJavaScriptEnabled(true);
        this.d.getSettings().setDomStorageEnabled(true);
        this.d.getSettings().setDatabaseEnabled(true);
        this.d.getSettings().setGeolocationDatabasePath(DxmApplicationContextImpl.getApplicationContext(getActivity()).getDir("database", 0).getPath());
        setSupportZoom();
        this.d.getSettings().setTextZoom(100);
        this.d.getSettings().setGeolocationEnabled(true);
        this.d.setScrollBarStyle(0);
        this.d.clearCache(false);
        this.d.resumeTimers();
        if (Build.VERSION.SDK_INT >= 11) {
            this.d.removeJavascriptInterface("searchBoxJavaBridge_");
            this.d.removeJavascriptInterface("accessibility");
            this.d.removeJavascriptInterface("accessibilityTraversal");
        }
        LightappJsClient lightappJsClient = new LightappJsClient(this, this.d);
        this.f = lightappJsClient;
        this.d.addJavascriptInterface(lightappJsClient, LightappJsClient.LIGHTAPP_JS_NAME);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.d, true);
        }
        this.d.loadUrl(this.c);
        this.a = false;
        return this.s;
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (this.g) {
            NoNetView noNetView = this.j;
            if (noNetView != null) {
                noNetView.show(str, this);
            }
            LightappWebView lightappWebView = this.d;
            if (lightappWebView != null) {
                lightappWebView.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        WalletLoginHelper.getInstance().syncH5LoginStatus(getActivity(), str);
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        layoutParams.width = (int) (((float) (DisplayUtils.getDisplayWidth(getActivity()) * i2)) / 100.0f);
        this.k.setLayoutParams(layoutParams);
    }
}
