package com.baidu.wallet.lightapp.business;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.m.p.e;
import com.baidu.aiscan.R;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.api.BaiduWallet;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.BdHalfActionBar;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.base.widget.PromptDialog;
import com.baidu.wallet.base.widget.dialog.SelectNumberDialog;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.ActivityStackManager;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.lightapp.ability.b.b;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.lightapp.base.LightappBaseActivity;
import com.baidu.wallet.lightapp.base.LightappWebView;
import com.baidu.wallet.lightapp.base.c;
import com.baidu.wallet.lightapp.base.datamodel.LightAppShareModel;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.TitleBarParams;
import com.baidu.wallet.lightapp.business.datamodel.LightAppCommonModel;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.lightapp.business.presenter.ContactInfoPresenter;
import com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor;
import com.baidu.wallet.lightapp.multipage.LangbridgeActivity;
import com.baidu.wallet.lightapp.multipage.LangbridgeSettings;
import com.baidu.wallet.lightapp.multipage.h;
import com.baidu.wallet.lightapp.widget.BdLightAppActionBar;
import com.baidu.wallet.lightapp.widget.LangBridgeMenuDialog;
import com.baidu.wallet.lightapp.widget.NoNetView;
import com.baidu.wallet.paysdk.datamodel.RpaConfig;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import com.baidu.wallet.utils.ContactUtils;
import com.baidu.wallet.utils.RpaProcessor;
import com.baidu.wallet.utils.StringUtil;
import com.baidu.wallet.utils.URLUtil;
import com.baidu.wallet.utils.UUIDGenerator;
import com.baidu.wallet.utils.ViewUtils;
import com.baidu.wallet.view.RoundLinearLayout;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.google.common.net.InternetDomainName;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
public class LightappBrowseActivity extends LightappBaseActivity implements ComponentCallbacks2, NoProguard, IBeanResponseCallback, com.baidu.wallet.lightapp.multipage.a, NoNetView.a {
    public static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
    public static final String LANGBRIDGE_HASH = "LANGBRIDGE_HASH";
    public static final String LIGHT_SHOW_SHARE = "shwoshare";
    public static final String TITLE = "title";
    public static int d;
    public static final Pattern r = Pattern.compile("^(https?://|file:///android_asset/).*");
    public LangBrigdeSlideLayout A;
    public NoNetView B;
    public View C;
    public LinearLayout D;
    public FrameLayout E;
    public FrameLayout F;
    public BdHalfActionBar G;
    public String H;
    public String I;
    public String J;
    public boolean K = false;
    public String L = "wallet_base_multi_window_close";
    public boolean M = false;
    public boolean N = false;
    public Handler O = null;
    public TextView P;
    public ContactInfoPresenter Q;
    public com.baidu.wallet.lightapp.business.presenter.a R;
    public String S;
    public boolean T = false;
    public boolean U;
    public boolean V = false;
    public List W;
    public com.baidu.wallet.lightapp.base.utils.a X;
    public Handler Y = new Handler() {
        public long b = 0;
        public long c = 0;

        public void handleMessage(@NonNull Message message) {
            int i2 = message.what;
            RpaConfig.RpaSenseStrategy rpaSenseStrategy = null;
            if (i2 == 1) {
                Object obj = message.obj;
                if (obj != null) {
                    try {
                        rpaSenseStrategy = (RpaConfig.RpaSenseStrategy) obj;
                    } catch (Exception unused) {
                    }
                }
                if (rpaSenseStrategy != null && TextUtils.equals(rpaSenseStrategy.type, "1") && System.currentTimeMillis() - this.b > ((long) (message.arg1 * 1000))) {
                    this.b = System.currentTimeMillis();
                    if (TextUtils.equals(rpaSenseStrategy.action, "1")) {
                        LightappBrowseActivity.this.e(rpaSenseStrategy.rpaUrl);
                    } else if (TextUtils.equals(rpaSenseStrategy.action, "2")) {
                        DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_PAGE_UPDATE, Arrays.asList(new String[]{rpaSenseStrategy.rpaUrl}));
                    }
                }
            } else if (i2 == 2) {
                Object obj2 = message.obj;
                if (obj2 != null) {
                    try {
                        rpaSenseStrategy = (RpaConfig.RpaSenseStrategy) obj2;
                    } catch (Exception unused2) {
                    }
                }
                if (rpaSenseStrategy != null && TextUtils.equals(rpaSenseStrategy.type, "3")) {
                    if (TextUtils.equals(rpaSenseStrategy.action, "1")) {
                        LightappBrowseActivity.this.e(rpaSenseStrategy.rpaUrl);
                    } else if (TextUtils.equals(rpaSenseStrategy.action, "2")) {
                        DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_PAGE_PROHIBIT, Arrays.asList(new String[]{rpaSenseStrategy.rpaUrl}));
                    }
                    Message obtain = Message.obtain();
                    obtain.arg1 = message.arg1;
                    obtain.obj = rpaSenseStrategy;
                    obtain.what = 2;
                    LightappBrowseActivity.this.Y.sendMessageDelayed(obtain, (long) (message.arg1 * 1000));
                }
            } else if (i2 == 3) {
                LightappBrowseActivity.this.Y.removeMessages(4);
                Message obtain2 = Message.obtain();
                obtain2.copyFrom(message);
                obtain2.what = 4;
                LightappBrowseActivity.this.Y.sendMessageDelayed(obtain2, 1000);
            } else if (i2 == 4) {
                Object obj3 = message.obj;
                if (obj3 != null) {
                    try {
                        rpaSenseStrategy = (RpaConfig.RpaSenseStrategy) obj3;
                    } catch (Exception unused3) {
                    }
                }
                if (rpaSenseStrategy != null && TextUtils.equals(rpaSenseStrategy.type, "2") && System.currentTimeMillis() - this.c > ((long) (message.arg1 * 1000))) {
                    this.c = System.currentTimeMillis();
                    if (TextUtils.equals(rpaSenseStrategy.action, "1")) {
                        LightappBrowseActivity.this.e(rpaSenseStrategy.rpaUrl);
                    } else if (TextUtils.equals(rpaSenseStrategy.action, "2")) {
                        DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_PAGE_POPUP, Arrays.asList(new String[]{rpaSenseStrategy.rpaUrl}));
                    }
                }
            }
        }
    };
    public LangbridgeBarParams Z = new LangbridgeBarParams();
    public boolean a = false;
    public LinearLayout b;
    public int c = 0;
    public int currentProgress;
    public LightappBusinessClient e;
    public int f = -1;
    public View fullScreenview;
    public Vector<Application.ActivityLifecycleCallbacks> g = new Vector<>();
    public String h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f3563i;
    public boolean interceptSSLError = true;
    public WebChromeClient.CustomViewCallback j;
    public String k;
    public double l;
    public String m;
    public Vector<LoadTimeLine> mLoadTimeLine;
    public boolean n;

    /* renamed from: o  reason: collision with root package name */
    public RelativeLayout f3564o;
    public FrameLayout p;
    public RoundLinearLayout q;
    public boolean s = false;
    public boolean t = true;
    public boolean u = true;
    public WebviewMenu v;
    public a w;
    public BdActionBar x;
    public FrameLayout y;
    public FrameLayout z;

    /* renamed from: com.baidu.wallet.lightapp.business.LightappBrowseActivity$19  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass19 {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.baidu.wallet.lightapp.business.LightappBrowseActivity$LifeCycleCbName[] r0 = com.baidu.wallet.lightapp.business.LightappBrowseActivity.LifeCycleCbName.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.baidu.wallet.lightapp.business.LightappBrowseActivity$LifeCycleCbName r1 = com.baidu.wallet.lightapp.business.LightappBrowseActivity.LifeCycleCbName.OnCreated     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.wallet.lightapp.business.LightappBrowseActivity$LifeCycleCbName r1 = com.baidu.wallet.lightapp.business.LightappBrowseActivity.LifeCycleCbName.OnStarted     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.wallet.lightapp.business.LightappBrowseActivity$LifeCycleCbName r1 = com.baidu.wallet.lightapp.business.LightappBrowseActivity.LifeCycleCbName.OnResumed     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.baidu.wallet.lightapp.business.LightappBrowseActivity$LifeCycleCbName r1 = com.baidu.wallet.lightapp.business.LightappBrowseActivity.LifeCycleCbName.OnPaused     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.baidu.wallet.lightapp.business.LightappBrowseActivity$LifeCycleCbName r1 = com.baidu.wallet.lightapp.business.LightappBrowseActivity.LifeCycleCbName.OnStopped     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.baidu.wallet.lightapp.business.LightappBrowseActivity$LifeCycleCbName r1 = com.baidu.wallet.lightapp.business.LightappBrowseActivity.LifeCycleCbName.OnSaveInstanceState     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.baidu.wallet.lightapp.business.LightappBrowseActivity$LifeCycleCbName r1 = com.baidu.wallet.lightapp.business.LightappBrowseActivity.LifeCycleCbName.OnDestroyed     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.business.LightappBrowseActivity.AnonymousClass19.<clinit>():void");
        }
    }

    public class CustomChromeClient extends LightappBaseActivity.BaseCustomChromeClient implements NoProguard {
        public CustomChromeClient() {
            super();
        }

        public View getVideoLoadingProgressView() {
            LogUtil.i("LightappBrowseActivityTAG", "getVideoLoadingProgressView");
            FrameLayout frameLayout = new FrameLayout(LightappBrowseActivity.this.getActivity());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return frameLayout;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage == null) {
                return super.onConsoleMessage(consoleMessage);
            }
            ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
            if (messageLevel == ConsoleMessage.MessageLevel.ERROR) {
                String sourceId = consoleMessage.sourceId();
                if (TextUtils.equals(sourceId, LightappBrowseActivity.this.S) || TextUtils.isEmpty(sourceId)) {
                    sourceId = "";
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("level", messageLevel.name());
                linkedHashMap.put("message", consoleMessage.message());
                linkedHashMap.put("lineNo", String.valueOf(consoleMessage.lineNumber()));
                linkedHashMap.put("sourceId", sourceId);
                linkedHashMap.put(LightAppStatEvent.PAGE_URL, LightappBrowseActivity.this.S);
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LightappBrowseActivity.this.S).toString());
                LightappBrowseActivity.this.upToSensor(consoleMessage.message(), Arrays.asList(new String[]{LightappBrowseActivity.this.S, messageLevel.name()}));
                Tracker.send(LightAppStatEvent.WEB_VIEW_CONSOLE, (Map<String, String>) linkedHashMap, (Context) LightappBrowseActivity.this);
            }
            return super.onConsoleMessage(consoleMessage);
        }

        public void onHideCustomView() {
            LogUtil.i("LightappBrowseActivityTAG", "onHideCustomView");
            LightappBrowseActivity.this.g();
        }

        public void onPermissionRequest(PermissionRequest permissionRequest) {
            LightappBrowserWebView lightappBrowserWebView;
            if (!(permissionRequest == null || (lightappBrowserWebView = LightappBrowseActivity.this.mWebView) == null || TextUtils.isEmpty(lightappBrowserWebView.getUrl()))) {
                String str = SdkInitResponse.getInstance().permissionAllowDomainList;
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split(",");
                    int length = split.length;
                    int i2 = 0;
                    while (i2 < length) {
                        String str2 = split[i2];
                        if (TextUtils.isEmpty(str2) || !LightappBrowseActivity.this.mWebView.getUrl().contains(str2.trim())) {
                            i2++;
                        } else {
                            permissionRequest.grant(permissionRequest.getResources());
                            return;
                        }
                    }
                }
            }
            super.onPermissionRequest(permissionRequest);
        }

        public void onProgressChanged(WebView webView, int i2) {
            super.onProgressChanged(webView, i2);
            LogUtil.d("LightappBrowseActivityTAG", "onProgressChanged:newProgress   " + i2);
            LightappBrowseActivity.this.a(i2);
            LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
            lightappBrowseActivity.currentProgress = i2;
            if (i2 == 100) {
                lightappBrowseActivity.dismissLoadingProgress();
                if (!LightappBrowseActivity.this.a) {
                    LogUtil.d("LightappBrowseActivityTAG", "onProgressChanged.hideErrorPage");
                    LightappBrowseActivity.this.h();
                }
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (LightappBrowseActivity.this.x != null) {
                String str2 = " ";
                if (!TextUtils.isEmpty(LightappBrowseActivity.this.I) && !NetworkUtils.isNetworkConnected(LightappBrowseActivity.this.getActivity())) {
                    str2 = LightappBrowseActivity.this.I;
                    LightappBrowseActivity.this.x.setTitleCenterSafeTipText("");
                } else if (LightappBrowseActivity.this.J != null) {
                    str2 = LightappBrowseActivity.this.J;
                } else if (!TextUtils.isEmpty(LightappBrowseActivity.this.h)) {
                    str2 = LightappBrowseActivity.this.h;
                } else if (!TextUtils.isEmpty(str) && !LightappBrowseActivity.r.matcher(str).matches()) {
                    if (("http://" + str).equals(LightappBrowseActivity.this.k)) {
                        str = str2;
                    }
                    str2 = str;
                }
                LightappBrowseActivity.this.c(str2);
            }
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            LogUtil.i("LightappBrowseActivityTAG", "onShowCustomView");
            if (LightappBrowseActivity.this.getActivity() != null && LightappBrowseActivity.this.isActiveCell()) {
                LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
                if (lightappBrowseActivity.fullScreenview != null) {
                    customViewCallback.onCustomViewHidden();
                    return;
                }
                FrameLayout frameLayout = (FrameLayout) lightappBrowseActivity.getActivity().getWindow().getDecorView();
                FrameLayout unused = LightappBrowseActivity.this.f3563i = new b(LightappBrowseActivity.this.getActivity());
                if (LightappBrowseActivity.this.getApplicationInfo().targetSdkVersion < 26 || Build.VERSION.SDK_INT != 26) {
                    if (LightappBrowseActivity.this.V) {
                        LightappBrowseActivity.this.getActivity().setRequestedOrientation(1);
                        LightappBrowseActivity.this.f3563i.setPadding(0, 0, 0, LightappBaseActivity.getNavigationBarHeight(LightappBrowseActivity.this.getContext()));
                    } else {
                        LightappBrowseActivity.this.getActivity().setRequestedOrientation(0);
                    }
                }
                LightappBrowseActivity.this.f3563i.addView(view, LightappBrowseActivity.COVER_SCREEN_PARAMS);
                frameLayout.addView(LightappBrowseActivity.this.f3563i, LightappBrowseActivity.COVER_SCREEN_PARAMS);
                LightappBrowseActivity lightappBrowseActivity2 = LightappBrowseActivity.this;
                lightappBrowseActivity2.fullScreenview = view;
                lightappBrowseActivity2.d(false);
                LogUtil.i("LightappBrowseActivityTAG", "fullscreen");
                WebChromeClient.CustomViewCallback unused2 = LightappBrowseActivity.this.j = customViewCallback;
                DXMSdkSAUtils.onEventWithValues("#webviewVedioFullScreen", Arrays.asList(new String[]{LightappBrowseActivity.this.k}));
            }
        }
    }

    public class CustomWebViewClient extends LightappBaseActivity.BaseCustomWebViewClient implements NoProguard {
        public Pattern c = Pattern.compile("\\s*https?://.*");
        public String d;

        public CustomWebViewClient() {
            super();
        }

        private boolean a(String str, String str2) {
            return TextUtils.equals(str, str2);
        }

        public void onPageFinished(WebView webView, String str) {
            RpaProcessor.getInstance().uploadRpaPageLoadMills(str, System.currentTimeMillis());
            Vector<LoadTimeLine> vector = LightappBrowseActivity.this.mLoadTimeLine;
            if (vector != null) {
                vector.add(new LoadTimeLine(str, "onPageFinished", String.valueOf(System.currentTimeMillis())));
            }
            LightappBrowseActivity.this.dismissLoadingProgress();
            int unused = LightappBrowseActivity.this.f = com.baidu.wallet.lightapp.base.a.a().a(LightappBrowseActivity.this.getActivity(), str, LightappBrowseActivity.this.f);
            String unused2 = LightappBrowseActivity.this.k = str;
            String host = Uri.parse(str).getHost();
            this.d = str;
            if (TextUtils.isEmpty(host)) {
                LightappBrowseActivity.this.P.setVisibility(8);
            } else {
                LightappBrowseActivity.this.P.setVisibility(0);
                LightappBrowseActivity.this.P.setText(LightappBrowseActivity.this.getResources().getString(ResUtils.string(LightappBrowseActivity.this.getActivity(), "wallet_lightapp_url_outer"), new Object[]{host}));
            }
            String title = LightappBrowseActivity.this.x.getTitle();
            if (title != null && title.equals(LightappBrowseActivity.this.I)) {
                String title2 = webView.getTitle();
                if (title2 == null || this.c.matcher(title2).matches()) {
                    LightappBrowseActivity.this.c((String) null);
                } else {
                    LightappBrowseActivity.this.c(title2);
                }
            }
            if (webView.getProgress() != 100) {
                LightappBrowseActivity.this.a = true;
            }
            LogUtil.d("LightappBrowseActivityTAG", "onPageFinished.finishedError:  " + LightappBrowseActivity.this.a);
            super.onPageFinished(webView, str);
            if (webView.getProgress() == 100) {
                WhiteScreenMonitor.a().a((WebView) LightappBrowseActivity.this.mWebView, WhiteScreenMonitor.PageStates.FINISH);
            }
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_END_lOAD, Arrays.asList(new String[]{CheckUtils.stripUrlParams(LightappBrowseActivity.this.k), "" + LightappBrowseActivity.d, "", "", "", URLUtil.getHost(LightappBrowseActivity.this.k)}));
            LangbridgeCacheManager.getInstance().handleFinishPage(str);
            LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
            if (lightappBrowseActivity.mWebView != null && !lightappBrowseActivity.mNeedClearHistory) {
                LightappBrowseActivity lightappBrowseActivity2 = LightappBrowseActivity.this;
                if (lightappBrowseActivity2.showCloseIcon(lightappBrowseActivity2.mWebView) && LightappBrowseActivity.this.x.setCloseButtonVisibility(0) != 0) {
                    LightappBrowseActivity.this.x.setCloseOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            GlobalUtils.hideKeyboard(LightappBrowseActivity.this.getActivity());
                            LightappBrowseActivity.this.l();
                        }
                    });
                }
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            RpaConfig targetRpaConfig;
            RpaConfig.RpaSenseStrategy[] rpaSenseStrategyArr;
            if (RpaProcessor.getInstance().isValid(SdkInitResponse.getInstance().rpa_pages_config) && (targetRpaConfig = RpaProcessor.getInstance().getTargetRpaConfig(SdkInitResponse.getInstance().rpa_pages_config, str)) != null && TextUtils.equals("1", targetRpaConfig.rpa_type) && (rpaSenseStrategyArr = targetRpaConfig.rpa_sense_strategy) != null && rpaSenseStrategyArr.length > 0) {
                for (RpaConfig.RpaSenseStrategy rpaSenseStrategy : rpaSenseStrategyArr) {
                    if (TextUtils.equals(rpaSenseStrategy.type, "4")) {
                        RpaProcessor.getInstance().storePageStartedMills(str, System.currentTimeMillis());
                    } else if (TextUtils.equals(rpaSenseStrategy.type, "1") || TextUtils.equals(rpaSenseStrategy.type, "2") || TextUtils.equals(rpaSenseStrategy.type, "3")) {
                        LightappBrowseActivity.this.executeJsFunction("(function() {\n    var originalRequestAnimationFrame = window.requestAnimationFrame;\n    let oldElementStringData;\n    function successFn(ret) {}\n\n    function failFn(argument) {\n    }\n    window.requestAnimationFrame = function(callback) {\n        var elements = document.getElementsByClassName('el-overlay');\n        if (elements.length > 0) {\n            var elementString = elements[0].outerHTML;\n            \n            if (oldElementStringData !== undefined) {//判断多次弹窗逻辑\n              // oldElementStringData 已被赋值\n                if (oldElementStringData != elementString) {\n                    window.BLightApp.invokeBdWalletNative(JSON.stringify(\n                                          {\n                                          \"method_name\": \"rpaPerception\",\n                                          \"msg\": \"popUpReturnFlag\",\n                                          }), 'successFn', 'failFn')\n                    oldElementStringData = elementString;\n                } else {\n                    //弹窗内容无变化\n                }\n            } else {\n              // oldElementStringData 未被赋值\n                window.BLightApp.invokeBdWalletNative(JSON.stringify(\n                                          {\n                                          \"method_name\": \"rpaPerception\",\n                                          \"msg\": \"popUpReturnFlag\",\n                                          }), 'successFn', 'failFn')\n                oldElementStringData = elementString;\n            }\n        }\n        if (window.find('keywordsSearchedByStringName')) {//字符串查找\n            window.BLightApp.invokeBdWalletNative(JSON.stringify(\n                                          {\n                                          \"method_name\": \"rpaPerception\",\n                                          \"msg\": \"keywordsSearchedByStringName\",\n                                          }), 'successFn', 'failFn')\n        }\n        return originalRequestAnimationFrame.apply(this, arguments);\n    };\n    return 0;\n})();\n\nfunction successFn(ret) {}\n\nfunction failFn(argument) {\n}\n\n\nvar observer = new MutationObserver(function(mutations) {\n    mutations.forEach(function(mutation) {\n            window.BLightApp.invokeBdWalletNative(JSON.stringify(\n                                          {\n                                          \"method_name\": \"rpaPerception\",\n                                          \"msg\": \"domTreeChangeReturnFlag\",\n                                          }), 'successFn', 'failFn');\n    });\n});\n\nvar config = { attributes: true, childList: true, subtree: true };\nobserver.observe(document, config);", (String) null, new ValueCallback<String>() {
                            /* renamed from: a */
                            public void onReceiveValue(String str) {
                            }
                        });
                    }
                }
            }
            LogUtil.d("onPageStarted", "url = " + str);
            LogUtil.d("onPageStarted", "clear query url = " + URLUtil.clearQuery(str));
            Vector<LoadTimeLine> vector = LightappBrowseActivity.this.mLoadTimeLine;
            if (vector != null) {
                vector.add(new LoadTimeLine(str, "onPageStarted", String.valueOf(System.currentTimeMillis())));
            }
            String unused = LightappBrowseActivity.this.S = str;
            if (TextUtils.isEmpty(str) || (!str.contains("isInitTitleBar=0") && !str.contains("isInitTitleBar%3d0"))) {
                LightappBrowseActivity.this.setFullScreenInMainThread(false, a(str, this.d) && (LightappBrowseActivity.this.Z != null && LightappBrowseActivity.this.Z.isHideTitle), false, false, "", "");
            }
            LightappBrowseActivity.this.f();
            if (LangbridgeCacheManager.getInstance().showProgressLine(str)) {
                LightappBrowseActivity.this.showLoadingProgress();
            }
            LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
            lightappBrowseActivity.c(lightappBrowseActivity.I);
            LightappBrowseActivity.this.x.setTitleCenterSafeTipText("");
            LightappBrowseActivity.this.x.setRightImgZone1Enable(false);
            if (LightappBrowseActivity.this.x.getRightZone1View().getVisibility() == 0) {
                LightappBrowseActivity.this.x.setRightImgZone1Visibility(8);
                LightappBrowseActivity.this.x.hideBubble(false);
            }
            if (LightappBrowseActivity.this.x.getRightImgZone2NotifyView().getVisibility() == 0) {
                LightappBrowseActivity.this.x.setRightImgZone2Visibility(0);
                ViewUtils.visibleView(LightappBrowseActivity.this.x.getRightImgZone2ImgView());
                LightappBrowseActivity.this.x.setRightImgZone2NotifyVisibility(8);
            }
            LightappBrowseActivity.this.x.showLeftZone();
            a unused2 = LightappBrowseActivity.this.w = null;
            if (LightappBrowseActivity.this.e != null) {
                LightappBrowseActivity.this.e.setH5BackCb((ILightappInvokerCallback) null);
            }
            String unused3 = LightappBrowseActivity.this.J = null;
            super.onPageStarted(webView, str, bitmap);
            WhiteScreenMonitor.a().a((WebView) LightappBrowseActivity.this.mWebView, WhiteScreenMonitor.PageStates.START);
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD, Arrays.asList(new String[]{URLUtil.clearQuery(LightappBrowseActivity.this.k), "" + LightappBrowseActivity.d, "", "", "", URLUtil.getHost(LightappBrowseActivity.this.k), URLUtil.wholeUrl(LightappBrowseActivity.this.k)}));
            LangbridgeCacheManager.getInstance().handleStartPage(str);
            boolean isOfflineCacheReady = LangbridgeCacheManager.getInstance().isOfflineCacheReady(str);
            if (!NetworkUtils.isNetworkAvailable(LightappBrowseActivity.this.getActivity()) && !isOfflineCacheReady) {
                LightappBrowseActivity.this.d(str);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_SHOW_ERROR, Arrays.asList(new String[]{CheckUtils.stripUrlParams(str)}));
            }
            if (!a(str, this.d)) {
                c.a(LightappBrowseActivity.this.getActivity());
            }
            if (LightappBrowseActivity.this.X != null) {
                LightappBrowseActivity.this.X.a(URLUtil.clearQuery(str));
            }
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (Build.VERSION.SDK_INT < 23 || webResourceError == null) {
                linkedHashMap.put("errorCode", String.valueOf(Integer.MIN_VALUE));
            } else {
                linkedHashMap.put("errorCode", String.valueOf(webResourceError.getErrorCode()));
            }
            if (Build.VERSION.SDK_INT >= 21 && webResourceRequest != null) {
                linkedHashMap.put("url", String.valueOf(webResourceRequest.getUrl()));
                linkedHashMap.put(e.s, webResourceRequest.getMethod());
                linkedHashMap.put("reqHeaders", String.valueOf(a(webResourceRequest.getRequestHeaders())));
            }
            if (Build.VERSION.SDK_INT >= 23 && webResourceError != null) {
                linkedHashMap.put("reasonPhrase", String.valueOf(webResourceError.getDescription()));
            }
            linkedHashMap.put(LightAppStatEvent.PAGE_URL, LightappBrowseActivity.this.S);
            linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LightappBrowseActivity.this.S).toString());
            Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, (Map<String, String>) linkedHashMap, (Context) LightappBrowseActivity.this);
            if (webResourceError != null && webResourceRequest != null && -10 != webResourceError.getErrorCode() && webResourceRequest.isForMainFrame()) {
                LightappBrowseActivity.this.a = true;
                if (-1 != webResourceError.getErrorCode() || LightappBrowseActivity.this.W == null || !LightappBrowseActivity.this.W.contains(String.valueOf(webResourceRequest.getUrl()))) {
                    if (LightappBrowseActivity.this.B != null) {
                        LightappBrowseActivity.this.B.setFailureCause(webResourceError.getErrorCode(), false);
                    }
                    LightappBrowseActivity.this.d(webResourceRequest.getUrl().toString());
                } else {
                    LightappBrowseActivity.this.W.remove(String.valueOf(webResourceRequest.getUrl()));
                }
                DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(new String[]{String.valueOf(webResourceError.getErrorCode()), String.valueOf(webResourceRequest.getUrl())}));
            }
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (Build.VERSION.SDK_INT >= 21) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (!(webResourceRequest == null || webResourceResponse == null)) {
                    linkedHashMap.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, String.valueOf(webResourceResponse.getStatusCode()));
                    linkedHashMap.put("url", String.valueOf(webResourceRequest.getUrl()));
                    linkedHashMap.put(e.s, webResourceRequest.getMethod());
                    linkedHashMap.put("reqHeaders", String.valueOf(a(webResourceRequest.getRequestHeaders())));
                    linkedHashMap.put("respHeaders", String.valueOf(webResourceResponse.getResponseHeaders()));
                    linkedHashMap.put("reasonPhrase", webResourceResponse.getReasonPhrase());
                    linkedHashMap.put(LightAppStatEvent.PAGE_URL, LightappBrowseActivity.this.S);
                }
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LightappBrowseActivity.this.S).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_HTTP_ERROR, (Map<String, String>) linkedHashMap, (Context) LightappBrowseActivity.this);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (sslError != null) {
                linkedHashMap.put("errorCode", String.valueOf(sslError.getPrimaryError()));
                linkedHashMap.put("url", sslError.getUrl());
                linkedHashMap.put(OCRTakePhotoActivity.ROUTER_INIT_TAB_CERTIFICATE, String.valueOf(sslError.getCertificate()));
                linkedHashMap.put(LightAppStatEvent.PAGE_URL, LightappBrowseActivity.this.S);
            }
            linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LightappBrowseActivity.this.S).toString());
            Tracker.send(LightAppStatEvent.WEB_VIEW_SSL_ERROR, (Map<String, String>) linkedHashMap, (Context) LightappBrowseActivity.this);
            int primaryError = sslError == null ? NoNetView.ERROR_SSL_GENERAL : sslError.getPrimaryError();
            if (sslError == null) {
                str = null;
            } else {
                str = sslError.getUrl();
            }
            LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
            if (!lightappBrowseActivity.interceptSSLError) {
                sslErrorHandler.proceed();
                LightappBrowseActivity lightappBrowseActivity2 = LightappBrowseActivity.this;
                lightappBrowseActivity2.a = false;
                if (lightappBrowseActivity2.currentProgress == 100) {
                    lightappBrowseActivity2.interceptSSLError = true;
                    return;
                }
                return;
            }
            lightappBrowseActivity.a = true;
            if (lightappBrowseActivity.B != null) {
                LightappBrowseActivity.this.B.setFailureCause(primaryError, true);
            }
            LightappBrowseActivity.this.d(str);
            DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(new String[]{primaryError + "", str}));
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            LogUtil.d("LightappBrowseActivityTAG", "onRenderProcessGone WebView 出现Crash");
            try {
                if (LightappBrowseActivity.this.mWebView != null && webView == LightappBrowseActivity.this.mWebView) {
                    if (!renderProcessGoneDetail.didCrash()) {
                        LogUtil.d("LightappBrowseActivityTAG", "WebView 出现OOM了，手动GC");
                        System.gc();
                    }
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_SHOW_ERROR, Arrays.asList(new String[]{"onRenderProcessGone1", LightappBrowseActivity.this.k, "" + renderProcessGoneDetail.didCrash()}));
                    return true;
                }
            } catch (Exception e) {
                LogUtil.d("LightappBrowseActivityTAG", "onRenderProcessGone 异常：" + e.getMessage());
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (LightappBrowseActivity.this.mNeedOverrideUrl) {
                LangbridgeCacheManager.getInstance().handleLoadUrl(LightappBrowseActivity.this.mLangbridgeHash, webResourceRequest.getUrl().toString());
                boolean unused = LightappBrowseActivity.this.mNeedOverrideUrl = false;
            }
            return LangbridgeCacheManager.getInstance().interceptRequest(webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
        }

        private Map a(Map<String, String> map) {
            if (map == null || map.isEmpty()) {
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap(map);
            Iterator it = hashMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    if ("Cookie".equalsIgnoreCase((String) ((Map.Entry) it.next()).getKey())) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            return hashMap;
        }

        @Deprecated
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("errorCode", String.valueOf(i2));
            linkedHashMap.put("url", str2);
            linkedHashMap.put("reasonPhrase", str);
            linkedHashMap.put(LightAppStatEvent.PAGE_URL, LightappBrowseActivity.this.S);
            linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LightappBrowseActivity.this.S).toString());
            Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, (Map<String, String>) linkedHashMap, (Context) LightappBrowseActivity.this);
            if (-10 != i2) {
                LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
                lightappBrowseActivity.a = true;
                if (lightappBrowseActivity.B != null) {
                    LightappBrowseActivity.this.B.setFailureCause(i2, false);
                }
                LightappBrowseActivity.this.d(str2);
                super.onReceivedError(webView, i2, str, str2);
            }
        }
    }

    public enum LifeCycleCbName {
        OnCreated,
        OnStarted,
        OnResumed,
        OnPaused,
        OnStopped,
        OnSaveInstanceState,
        OnDestroyed
    }

    public static class LoadTimeLine implements NoProguard {
        public String event;
        public String time;
        public String url;

        public LoadTimeLine(String str, String str2, String str3) {
            this.url = str;
            this.event = str2;
            this.time = str3;
        }
    }

    public static class ShareCallbackImpl implements ILightappInvokerCallback {
        public ArrayList<String> a;

        public void addStatics(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (this.a == null) {
                    this.a = new ArrayList<>();
                }
                this.a.add(str);
            }
        }

        public void onResult(int i2, String str) {
            if (i2 == 0) {
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_SUCCESS, this.a);
            } else if (i2 == 1) {
                String str2 = "";
                if (TextUtils.isEmpty(str)) {
                    str = str2;
                }
                if (this.a.size() >= 2) {
                    this.a.add(1, str);
                } else {
                    this.a.add(str);
                }
                try {
                    str2 = ((LightAppCommonModel) JsonUtils.fromJson(str, LightAppCommonModel.class)).cnt.errCode;
                } catch (Exception unused) {
                }
                this.a.add(str2);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, this.a);
            }
        }
    }

    public class WebviewMenu extends LangBridgeMenuDialog implements NoProguard {
        public static final int MENU_ITEM_INDEX_CLOSE = 34;
        public static final int MENU_ITEM_INDEX_REFRESH = 33;
        public static final int MENU_ITEM_INDEX_SHARE = 32;

        public WebviewMenu(Context context) {
            super(context);
            add(33, (CharSequence) ResUtils.getString(context, "wallet_lightapp_refresh"), ResUtils.getDrawable(context, "wallet_langbrige_icon_refresh"));
            if (LightappBrowseActivity.this.s) {
                add(32, (CharSequence) ResUtils.getString(context, "wallet_lightapp_share"), ResUtils.getDrawable(context, "wallet_langbrige_icon_share"));
            }
            add(34, (CharSequence) ResUtils.getString(context, "wallet_lightapp_close"), ResUtils.getDrawable(context, "wallet_langbrige_icon_close"));
            layoutMenu();
        }
    }

    public class a extends LangBridgeMenuDialog implements NoProguard {

        /* renamed from: com.baidu.wallet.lightapp.business.LightappBrowseActivity$a$a  reason: collision with other inner class name */
        public class C0156a {
            public String a;
            public String b;
            public String c;

            public C0156a() {
            }
        }

        public a(Context context, JSONArray jSONArray) {
            super(context);
            final ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                Pattern compile = Pattern.compile("[一-龥\\d\\w]{1,10}+");
                try {
                    int length = jSONArray.length();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        if (!jSONArray.isNull(i2)) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            if (jSONObject.has("title") && jSONObject.has("icon")) {
                                if (jSONObject.has("callback")) {
                                    C0156a aVar = new C0156a();
                                    aVar.a = jSONObject.optString("title", (String) null);
                                    aVar.b = jSONObject.optString("icon", (String) null);
                                    aVar.c = jSONObject.optString("callback", (String) null);
                                    if (compile.matcher(aVar.a).matches() && !TextUtils.isEmpty(aVar.b)) {
                                        if (!TextUtils.isEmpty(aVar.c)) {
                                            if (5 <= arrayList.size()) {
                                                break;
                                            }
                                            arrayList.add(aVar);
                                        }
                                    }
                                }
                            }
                        }
                        i2++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            final int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0156a aVar2 = (C0156a) arrayList.get(i3);
                add(i3 + 256, (CharSequence) aVar2.a, aVar2.b);
            }
            add((int) InternetDomainName.MAX_LENGTH, (CharSequence) ResUtils.getString(context, "wallet_lightapp_refresh"), ResUtils.getDrawable(context, "wallet_langbrige_icon_refresh"));
            if (LightappBrowseActivity.this.s) {
                add(254, (CharSequence) ResUtils.getString(context, "wallet_lightapp_share"), ResUtils.getDrawable(context, "wallet_langbrige_icon_share"));
            }
            add(255, (CharSequence) ResUtils.getString(context, "wallet_lightapp_close"), ResUtils.getDrawable(context, "wallet_langbrige_icon_close"));
            setMenuItemClickListener(new BdMenuItem.OnItemClickListener(LightappBrowseActivity.this) {
                public void onClick(BdMenuItem bdMenuItem) {
                    int itemId = bdMenuItem.getItemId();
                    if (255 == itemId) {
                        LightappBrowseActivity.this.l();
                        if (LightappBrowseActivity.this.c == 12) {
                            LightappBrowseActivity.this.a(2, "实名认证取消");
                        }
                        LightappBrowseActivity.this.finish();
                    } else if (254 == itemId) {
                        DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(new String[]{CheckUtils.stripUrlParams(LightappBrowseActivity.this.k)}));
                        ShareCallbackImpl shareCallbackImpl = new ShareCallbackImpl();
                        shareCallbackImpl.addStatics(LightappBrowseActivity.this.k);
                        LightAppWrapper.getInstance().callShare(LightappBrowseActivity.this.getActivity(), new LightAppShareModel(LightappBrowseActivity.this.mWebView.getTitle(), LightappBrowseActivity.this.mWebView.getTitle(), LightappBrowseActivity.this.mWebView.getUrl(), (String) null), shareCallbackImpl);
                    } else if (253 == itemId) {
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(new String[]{CheckUtils.stripUrlParams(LightappBrowseActivity.this.k)}));
                        LangbridgeCacheManager.getInstance().onLangbridgeRefresh(LightappBrowseActivity.this.getActivity(), LightappBrowseActivity.this.k);
                        LightappBrowseActivity.this.mWebView.reload();
                        LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
                        String unused = lightappBrowseActivity.k = lightappBrowseActivity.mWebView.getUrl();
                        LightappBrowseActivity.this.a = false;
                    } else {
                        int i2 = itemId + InputDeviceCompat.SOURCE_ANY;
                        if (i2 <= size) {
                            LightappBrowseActivity.this.executeJsFunction(((C0156a) arrayList.get(i2)).c, "");
                        }
                    }
                }
            });
            layoutMenu();
        }
    }

    public static class b extends FrameLayout {
        public b(Context context) {
            super(context);
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            LogUtil.i("LightappBrowseActivityTAG", "onTouchEvent " + motionEvent.getAction());
            return true;
        }
    }

    public static int getCurrentColor(float f2, int i2, int i3) {
        int red = Color.red(i2);
        int blue = Color.blue(i2);
        int green = Color.green(i2);
        int alpha = Color.alpha(i2);
        int red2 = Color.red(i3);
        int blue2 = Color.blue(i3);
        int i4 = red2 - red;
        int i5 = blue2 - blue;
        int green2 = (int) (((float) green) + (((float) (Color.green(i3) - green)) * f2));
        return Color.argb((int) (((float) alpha) + (f2 * ((float) (Color.alpha(i3) - alpha)))), (int) (((float) red) + (((float) i4) * f2)), green2, (int) (((float) blue) + (((float) i5) * f2)));
    }

    public static Intent getStartIntent(Context context, String str, boolean z2, boolean z3, Double d2, String str2) {
        return a(context, str, (String) null, z2, z3, d2, str2);
    }

    public static void startLightApp(Context context, String str, String str2, boolean z2, boolean z3, Double d2, String str3) {
        startLightApp(context, str, str2, z2, z3, d2, str3, (Bundle) null);
    }

    public void checkClodDown(String str, List<String> list, String str2) {
    }

    public void closeTopWebview() {
    }

    public void closeWindow() {
        if (this.c == 12) {
            a(2, "实名认证取消");
        }
        finish();
    }

    public void customNaviBar(final TitleBarParams titleBarParams) {
        runOnUiThread(new Runnable() {
            public void run() {
                if (LightappBrowseActivity.this.x != null && titleBarParams != null) {
                    LightappBrowseActivity.this.c(true);
                    TitleBarParams.c cVar = titleBarParams.leftParams;
                    if (cVar != null) {
                        LightappBrowseActivity.this.c(cVar.a());
                    }
                    LightappBrowseActivity.this.b(false);
                    TitleBarParams.a aVar = titleBarParams.barParams;
                    if (aVar != null) {
                        LightappBrowseActivity.this.b(aVar.a());
                    }
                    LightappBrowseActivity.this.a(titleBarParams.showMoreDefault(), titleBarParams);
                }
            }
        });
    }

    public void dismissLoadingProgress() {
        j();
    }

    public void doNetworkTomography(String str, Map<String, String> map) {
        com.baidu.wallet.lightapp.ability.b.b.a().a(str, new b.a() {
            public boolean a = false;

            public void a(int i2) {
                if (!this.a) {
                    WalletGlobalUtils.showLoadingDialog(LightappBrowseActivity.this.getActivity());
                    this.a = true;
                }
            }

            public void a(String str) {
                WalletGlobalUtils.DismissLoadingDialog();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.optBoolean("isOnline", true)) {
                        GlobalUtils.toast(LightappBrowseActivity.this.getContext(), ResUtils.getString(LightappBrowseActivity.this.getActivity(), "network_no_connected"));
                    } else if (!jSONObject.optBoolean("isInternetConnected", true)) {
                        GlobalUtils.toast(LightappBrowseActivity.this.getContext(), ResUtils.getString(LightappBrowseActivity.this.getActivity(), "network_no_internet_connected"));
                    } else {
                        GlobalUtils.toast(LightappBrowseActivity.this.getContext(), ResUtils.getString(LightappBrowseActivity.this.getActivity(), "network_tomography_done"));
                    }
                } catch (JSONException unused) {
                }
            }
        }, getContext(), map);
    }

    public String exeSSCommand(String str, String str2, String str3) {
        return null;
    }

    public void executeJsFunction(String str, String str2, ValueCallback valueCallback) {
        if (this.mWebView != null && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder(str);
                sb.append("(\"");
                if (str2 != null) {
                    sb.append(LightappUtils.formatJSONForWebViewCallback(str2));
                }
                sb.append("\")");
                if (Build.VERSION.SDK_INT >= 19) {
                    this.mWebView.evaluateJavascript(sb.toString(), valueCallback);
                    return;
                }
                LightappBrowserWebView lightappBrowserWebView = this.mWebView;
                lightappBrowserWebView.loadUrl("javascript:" + sb.toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f A[Catch:{ all -> 0x0081 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void executeJsFunctionBase64(java.lang.String r4, T r5) {
        /*
            r3 = this;
            com.baidu.wallet.lightapp.business.LightappBrowserWebView r0 = r3.mWebView
            if (r0 == 0) goto L_0x0081
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x000c
            goto L_0x0081
        L_0x000c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r0.<init>(r4)     // Catch:{ all -> 0x0081 }
            java.lang.String r4 = "(\""
            r0.append(r4)     // Catch:{ all -> 0x0081 }
            r4 = 0
            if (r5 == 0) goto L_0x0052
            boolean r1 = r5 instanceof java.lang.String     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0031
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0081 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0081 }
            if (r1 != 0) goto L_0x0048
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0081 }
            byte[] r5 = r5.getBytes()     // Catch:{ all -> 0x0081 }
            java.lang.String r5 = com.baidu.apollon.utils.Base64Utils.encodeToString(r5)     // Catch:{ all -> 0x0081 }
            goto L_0x0049
        L_0x0031:
            java.lang.Class r1 = r5.getClass()     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "[B"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0081 }
            boolean r1 = r2.equals(r1)     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0048
            byte[] r5 = (byte[]) r5     // Catch:{ all -> 0x0081 }
            java.lang.String r5 = com.baidu.apollon.utils.Base64Utils.encodeToString(r5)     // Catch:{ all -> 0x0081 }
            goto L_0x0049
        L_0x0048:
            r5 = r4
        L_0x0049:
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0081 }
            if (r1 != 0) goto L_0x0052
            r0.append(r5)     // Catch:{ all -> 0x0081 }
        L_0x0052:
            java.lang.String r5 = "\")"
            r0.append(r5)     // Catch:{ all -> 0x0081 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0081 }
            r1 = 19
            if (r5 < r1) goto L_0x0067
            com.baidu.wallet.lightapp.business.LightappBrowserWebView r5 = r3.mWebView     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0081 }
            r5.evaluateJavascript(r0, r4)     // Catch:{ all -> 0x0081 }
            goto L_0x0081
        L_0x0067:
            com.baidu.wallet.lightapp.business.LightappBrowserWebView r4 = r3.mWebView     // Catch:{ all -> 0x0081 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r5.<init>()     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "javascript:"
            r5.append(r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0081 }
            r5.append(r0)     // Catch:{ all -> 0x0081 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0081 }
            r4.loadUrl(r5)     // Catch:{ all -> 0x0081 }
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.business.LightappBrowseActivity.executeJsFunctionBase64(java.lang.String, java.lang.Object):void");
    }

    public com.baidu.wallet.lightapp.multipage.a getBusinessImpl() {
        return this;
    }

    public String getCanceledMsg() {
        return "取消";
    }

    public String getCellHashStamps() {
        return null;
    }

    public String getContentLayoutId() {
        return "wallet_langbrige_webview";
    }

    public Context getContext() {
        return DxmApplicationContextImpl.getApplicationContext(this);
    }

    public LightappBrowserWebView getCurrentWebView() {
        return this.mWebView;
    }

    public String getErrMsg() {
        return ResUtils.getString(getActivity(), "wallet_base_select_phone_fail");
    }

    public String getLightappWebviewId() {
        return "cust_webview";
    }

    public String getLoadTimeLine() {
        return JsonUtils.toJson(this.mLoadTimeLine);
    }

    public Activity getNextActivity() {
        return BaseActivity.getNextActivity(getActivity());
    }

    public boolean getShowShareForIntent() {
        return getIntent().getBooleanExtra("shwoshare", false);
    }

    public void historyGo(int i2) {
    }

    public void insertPhoneNumToAddressBook(String str, String str2) {
        ContactUtils.insertPhoneNumToAddressBook(getActivity(), str, str2, 8);
    }

    public boolean isActiveCell() {
        return true;
    }

    public boolean isPreloaded() {
        return false;
    }

    public boolean isWindowNightMode() {
        return false;
    }

    public void loadAlubm(String str) {
        this.R = new com.baidu.wallet.lightapp.business.presenter.a(getActivity(), this.e, str);
        Intent intent = new Intent();
        if (!"nubia".equals(Build.BRAND) || !"NX595J".equals(Build.MODEL)) {
            intent.addCategory("android.intent.category.OPENABLE");
            if (Build.VERSION.SDK_INT < 19) {
                intent.setAction("android.intent.action.GET_CONTENT");
            } else {
                intent.setAction("android.intent.action.OPEN_DOCUMENT");
            }
        } else {
            intent.setAction("android.intent.action.PICK");
        }
        intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
        try {
            getActivity().startActivityForResult(Intent.createChooser(intent, "选择图片"), 5);
        } catch (ActivityNotFoundException e2) {
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL, Arrays.asList(new String[]{LightappBusinessClient.MTD_CALL_NATIVE_PHOTO}));
            e2.printStackTrace();
        }
    }

    public void messageForwarding(Context context, final String str) {
        LogUtil.d("LightappBrowseActivityTAG", "messageForwarding，content：" + str);
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    BaseActivity a2 = BaseActivity.getTopActivity();
                    BaseActivity a3 = BaseActivity.getNextActivity(LightappBrowseActivity.this.getActivity());
                    LogUtil.d("LightappBrowseActivityTAG", "messageForwarding，nextActivity：" + a3);
                    if ((a2 instanceof LightappBrowseActivity) && (a3 instanceof LightappBrowseActivity)) {
                        LightappBrowserWebView currentWebView = ((LightappBrowseActivity) a3).getCurrentWebView();
                        if ((LightappBrowseActivity.this.e != null ? LightappBrowseActivity.this.e.getAcceptMessageFlag() : null) != null && currentWebView != null) {
                            LightappUtils.executeJsFunction(currentWebView, LightappBusinessClient.MTD_ACCEPT_MESSAGE_FROM_LANGBRIDGE, str);
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_ACCEPT_MESSAGE_FROM_LANG, Arrays.asList(new String[]{CheckUtils.stripUrlParams(currentWebView.getUrl())}));
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    public boolean needKeyboardAdjust() {
        return true;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        ContactInfoPresenter contactInfoPresenter;
        if (i2 == 4) {
            if (i3 != -1) {
                LightappBusinessClient lightappBusinessClient = this.e;
                if (lightappBusinessClient != null) {
                    lightappBusinessClient.onContactsSelected("", 1, (String[]) null, getCanceledMsg(), "0");
                }
            } else if (intent != null && intent.getData() != null && (contactInfoPresenter = this.Q) != null) {
                contactInfoPresenter.a(intent.getData());
            }
        } else if (i2 == 5) {
            LogUtil.d("LightappBrowseActivityTAG", "onActivityResult resultCode = " + i3);
            JSONObject jSONObject = new JSONObject();
            if (i3 != -1) {
                try {
                    jSONObject.put("errCode", "10005");
                    jSONObject.put("des", "用户取消选择");
                    this.e.setAlubmPhotoData(1, jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else if (intent != null && intent.getData() != null) {
                this.R.a(intent, jSONObject);
            }
        } else if (i2 == 8) {
            LightappBusinessClient lightappBusinessClient2 = this.e;
            if (lightappBusinessClient2 != null) {
                if (i3 == -1) {
                    lightappBusinessClient2.onInsertPhoneNumToAddressBookResult(0, "", "");
                } else {
                    lightappBusinessClient2.onInsertPhoneNumToAddressBookResult(1, "10005", "用户取消");
                }
            }
        } else {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onBackPressed() {
        LogUtil.d("LightappBrowseActivityTAG", "onBackPressed");
        if (!(this.fullScreenview == null && this.f3563i == null) && !this.n) {
            g();
            return;
        }
        BdActionBar bdActionBar = this.x;
        if (bdActionBar != null) {
            bdActionBar.removeTitleFloatView();
        }
        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_BACK, Arrays.asList(new String[]{CheckUtils.stripUrlParams(this.k), "" + d}));
        LightappBusinessClient lightappBusinessClient = this.e;
        if ((lightappBusinessClient != null ? lightappBusinessClient.getH5BackCb() : null) != null) {
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_BD_WALLET_PAGE_BACK, Arrays.asList(new String[]{CheckUtils.stripUrlParams(this.k), "" + d}));
            executeJsFunction(LightappBusinessClient.MTD_H5GOBCK, (String) null);
        } else {
            if (this.c == 12 && !this.mWebView.canGoBack()) {
                a(2, "实名认证取消");
            }
            super.onBackPressed();
        }
        LightappBrowserWebView lightappBrowserWebView = this.mWebView;
        if (lightappBrowserWebView != null) {
            this.k = lightappBrowserWebView.getUrl();
        }
    }

    public void onBeanExecFailure(int i2, int i3, String str) {
        this.O.post(new Runnable() {
            public void run() {
            }
        });
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        this.O.post(new Runnable() {
            public void run() {
            }
        });
    }

    public void onContinueClick(String str) {
        LightappBrowserWebView lightappBrowserWebView = this.mWebView;
        if (lightappBrowserWebView != null) {
            this.interceptSSLError = false;
            this.a = false;
            lightappBrowserWebView.loadUrl(str);
        }
    }

    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        int i2 = d;
        if (i2 < 2) {
            d = i2 + 1;
        }
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        this.l = -0.0d;
        this.m = null;
        if (extras != null) {
            try {
                this.c = extras.getInt("baidu.wallet.lightapp.biztype", 0);
                this.k = extras.getString("jump_url");
                this.h = extras.getString("title");
                this.mLangbridgeHash = extras.getLong("LANGBRIDGE_HASH", 0);
                this.l = extras.getDouble(Constants.HALF_LIGHTBRIDGE_HEIGHT, -0.0d);
                this.m = extras.getString(Constants.HALF_LIGHTBRIDGE_TRANSLUCENCY_COLOR);
                LogUtil.d("LightappBrowseActivityTAG", "接收mHalfHeight：" + this.l + " ,mHalfColor:" + this.m);
                if (extras.containsKey("lifecycleLsnr") && (activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) extras.get("lifecycleLsnr")) != null) {
                    a(activityLifecycleCallbacks);
                }
            } catch (Exception unused) {
            }
        }
        if (Build.VERSION.SDK_INT >= 11) {
            requestWindowFeature(10);
        }
        if (bundle != null) {
            this.k = bundle.getString("jump_url");
            this.s = bundle.getBoolean("shwoshare", false);
            this.t = bundle.getBoolean(LangbridgeActivity.IS_SHOW_NATIVE_ERROR_PAGE, true);
            this.u = bundle.getBoolean(LangbridgeActivity.IS_SHOW_TITLE_BAR, true);
            this.h = bundle.getString("title");
        }
        super.onCreate(bundle);
        if (this.mWebView == null || TextUtils.isEmpty(this.k)) {
            finish();
            return;
        }
        this.X = new com.baidu.wallet.lightapp.base.utils.a();
        LangbridgeCacheManager.getInstance().handleCreateLangbirdge(this.k, this.mWebView);
        a(this.k);
        setIsShowMultiWindowTips(true);
        setIsMultiWindowAvailable(false);
        boolean z2 = this.l != -0.0d;
        this.n = z2;
        if (z2) {
            getWindow().getDecorView().setBackgroundColor(0);
        } else {
            getWindow().getDecorView().setBackgroundColor(-1);
        }
        this.O = new Handler(getMainLooper());
        this.s = getShowShareForIntent();
        if (this.k.contains("showShare=1") || this.k.contains("showShare%3d1")) {
            this.s = true;
        }
        if (this.k.contains("hideShare=1") || this.k.contains("hideShare%3d1")) {
            this.s = false;
        }
        if (this.k.contains("hideNativeErrorPage=1") || this.k.contains("hideNativeErrorPage%3d1")) {
            this.t = false;
        }
        if (this.k.contains("hideTitleBar")) {
            this.u = false;
        }
        String userAgentString = this.mWebView.getSettings().getUserAgentString();
        LogUtil.logd("ua=" + userAgentString);
        if (userAgentString != null && !userAgentString.contains(BaiduWallet.TAG)) {
            userAgentString = userAgentString + " " + BussinessUtils.getUA(getActivity());
            this.mWebView.getSettings().setUserAgentString(userAgentString);
        }
        if (!TextUtils.isEmpty(userAgentString)) {
            LangbridgeCacheManager.getInstance().setLangbridgeUA(userAgentString);
        }
        LogUtil.logd("ua2=" + this.mWebView.getSettings().getUserAgentString());
        this.mWebView.setWebViewClient(new CustomWebViewClient());
        this.mWebView.setWebChromeClient(new CustomChromeClient());
        this.mWebView.setDownloadListener(new DownloadListener() {
            public Pattern a;
            public Matcher b;

            {
                Pattern compile = Pattern.compile(".*");
                this.a = compile;
                this.b = compile.matcher("");
            }

            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (LightappBrowseActivity.this.W == null) {
                    List unused = LightappBrowseActivity.this.W = new LinkedList();
                }
                LightappBrowseActivity.this.W.add(str);
                try {
                    if (!TextUtils.isEmpty(str)) {
                        LightappBrowseActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    }
                } catch (Exception e) {
                    LogUtil.e("LightappBrowseActivityTAG", "Download Error", e);
                    GlobalUtils.toast(LightappBrowseActivity.this.getActivity(), "下载出现异常");
                }
            }
        });
        com.baidu.wallet.lightapp.base.a.a().a(getActivity());
        this.I = "";
        this.H = ResUtils.getString(this, "ebpay_loading");
        this.C = findViewById(ResUtils.id(getActivity(), "progress_line"));
        this.x = a(getIntent().getExtras().getBoolean("long_title", true));
        this.B = (NoNetView) findViewById(ResUtils.id(getActivity(), "nonet_view"));
        this.A = (LangBrigdeSlideLayout) findViewById(ResUtils.id(getActivity(), "bd_langbridge_slide"));
        this.y = (FrameLayout) findViewById(ResUtils.id(getActivity(), "bd_ab_container"));
        this.E = (FrameLayout) findViewById(ResUtils.id(getActivity(), "bd_trans_container"));
        this.z = (FrameLayout) findViewById(ResUtils.id(getActivity(), "progress_line_container"));
        this.F = (FrameLayout) findViewById(ResUtils.id(getActivity(), "progress_trans_container"));
        this.f3564o = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "langbridge_root"));
        this.p = (FrameLayout) findViewById(ResUtils.id(getActivity(), "content_frame_layout"));
        this.q = (RoundLinearLayout) findViewById(ResUtils.id(getActivity(), "round_linear_layout"));
        this.D = (LinearLayout) findViewById(ResUtils.id(getActivity(), "trans_layout"));
        this.G = (BdHalfActionBar) findViewById(ResUtils.id(getActivity(), "rv_half_action_bar"));
        View view = new View(getActivity());
        this.C = view;
        view.setVisibility(8);
        setActionBarTransparent(false);
        WebviewMenu webviewMenu = new WebviewMenu(getActivity());
        this.v = webviewMenu;
        webviewMenu.setMenuItemClickListener(new BdMenuItem.OnItemClickListener() {
            public void onClick(BdMenuItem bdMenuItem) {
                switch (bdMenuItem.getItemId()) {
                    case 32:
                        DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(new String[]{CheckUtils.stripUrlParams(LightappBrowseActivity.this.k)}));
                        ShareCallbackImpl shareCallbackImpl = new ShareCallbackImpl();
                        shareCallbackImpl.addStatics(LightappBrowseActivity.this.k);
                        LightAppWrapper.getInstance().callShare(LightappBrowseActivity.this.getActivity(), new LightAppShareModel(LightappBrowseActivity.this.mWebView.getTitle(), LightappBrowseActivity.this.mWebView.getTitle(), LightappBrowseActivity.this.mWebView.getUrl(), (String) null), shareCallbackImpl);
                        return;
                    case 33:
                        ILightappInvokerCallback h5Refresh = LightappBrowseActivity.this.e != null ? LightappBrowseActivity.this.e.getH5Refresh() : null;
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(new String[]{CheckUtils.stripUrlParams(LightappBrowseActivity.this.k)}));
                        if (h5Refresh != null) {
                            LightappBrowseActivity.this.executeJsFunction(LightappBusinessClient.MTD_H5REFRESH, (String) null);
                            return;
                        }
                        LangbridgeCacheManager.getInstance().onLangbridgeRefresh(LightappBrowseActivity.this.getActivity(), LightappBrowseActivity.this.k);
                        LightappBrowseActivity.this.mWebView.reload();
                        LightappBrowseActivity.this.a = false;
                        return;
                    case 34:
                        LightappBrowseActivity.this.l();
                        return;
                    default:
                        return;
                }
            }
        });
        this.e = (LightappBusinessClient) this.mLightappJsClient.getLightappBusiness();
        b(this.I);
        this.b = (LinearLayout) findViewById(ResUtils.id(getActivity(), "walelt_app_host_background"));
        this.P = (TextView) findViewById(ResUtils.id(getActivity(), "walelt_base_light_app_host"));
        d();
        try {
            if (!r.matcher(this.k).matches()) {
                this.k = "https://" + this.k;
            }
            this.mWebView.loadUrl(this.k.trim());
            this.a = false;
        } catch (Exception unused2) {
            LogUtil.d("Url error");
            finish();
        }
        this.mLoadTimeLine = new Vector<>();
        if (!TextUtils.isEmpty(this.k)) {
            this.mLoadTimeLine.add(new LoadTimeLine(this.k.trim(), "onCreate", String.valueOf(System.currentTimeMillis())));
        }
        f("common");
    }

    @Nullable
    public Dialog onCreateDialog(int i2) {
        if (1000 == i2) {
            return new PromptDialog(getActivity());
        }
        return super.onCreateDialog(i2);
    }

    public void onDestroy() {
        super.onDestroy();
        UUIDGenerator.generateUUID();
        this.V = false;
        if (!(this.fullScreenview == null && this.f3563i == null)) {
            this.f3563i = null;
            this.fullScreenview = null;
            this.j.onCustomViewHidden();
            this.j = null;
        }
        LangbridgeCacheManager.getInstance().handleFinishLangbirdge(this.mLangbridgeHash);
        Handler handler = this.O;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        Handler handler2 = this.Y;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
        WhiteScreenMonitor.a().b();
        this.e = null;
        if (this.c == 12) {
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(this)).route(this, new RouterRequest().provider("dxmPay").action("enterClearRnAuthBack"), (RouterCallback) null);
        }
        a(LifeCycleCbName.OnDestroyed, (Bundle) null);
        com.baidu.wallet.lightapp.base.utils.a aVar = this.X;
        if (aVar != null) {
            aVar.a();
        }
    }

    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z2) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.onMultiWindowModeChanged(z2);
            if (z2 && this.M) {
                if (this.K) {
                    GlobalUtils.toast(this, ResUtils.getString(getActivity(), this.L), -1, 1);
                }
                if (!this.N) {
                    finish();
                }
            }
        }
    }

    public void onPause() {
        super.onPause();
        WhiteScreenMonitor.a().b();
        this.f = com.baidu.wallet.lightapp.base.a.a().a(getActivity(), this.k, this.f);
        if (this.mLoadTimeLine != null && !TextUtils.isEmpty(this.k)) {
            this.mLoadTimeLine.add(new LoadTimeLine(this.k.trim(), "onPause", String.valueOf(System.currentTimeMillis())));
        }
        this.M = false;
        BdActionBar bdActionBar = this.x;
        if (bdActionBar != null && !this.U) {
            bdActionBar.hideBubble(true);
        }
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        if (1000 == i2) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage(ResUtils.string(DxmApplicationContextImpl.getApplicationContext(this), "bd_wallet_download_prompt"));
            promptDialog.setCanceledOnTouchOutside(true);
            promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_confirm"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    Activity activity = LightappBrowseActivity.this.getActivity();
                    if (activity != null && !activity.isFinishing()) {
                        activity.removeDialog(1000);
                    }
                }
            });
            promptDialog.hideNegativeButton();
            return;
        }
        super.onPrepareDialog(i2, dialog);
    }

    public void onReloadClick(String str) {
        if (!NetworkUtils.isNetworkAvailable(DxmApplicationContextImpl.getApplicationContext(this))) {
            GlobalUtils.toast(getActivity(), ResUtils.getString(DxmApplicationContextImpl.getApplicationContext(this), "ebpay_no_network"));
            return;
        }
        LightappBrowserWebView lightappBrowserWebView = this.mWebView;
        if (lightappBrowserWebView != null) {
            lightappBrowserWebView.reload();
            this.a = false;
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        LightappBusinessClient lightappBusinessClient = this.e;
        if (lightappBusinessClient != null) {
            lightappBusinessClient.onRequestPermissionsResult(this.S, i2, strArr, iArr);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.T) {
            this.e.checkPermission();
            this.T = false;
        }
        if (this.mLoadTimeLine != null && !TextUtils.isEmpty(this.k)) {
            this.mLoadTimeLine.add(new LoadTimeLine(this.k.trim(), "onResume", String.valueOf(System.currentTimeMillis())));
        }
        k();
        this.M = true;
    }

    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        LogUtil.d("LangBridgeActivity", "onTrimMemory level = " + i2);
        if (i2 == 20) {
            Activity realTopActivity = ActivityStackManager.getInstance().getRealTopActivity();
            LogUtil.d("LangBridgeActivity", "onTrimMemory level HIDDEN TopActivity = " + realTopActivity);
            if (realTopActivity != null && realTopActivity.equals(this)) {
                LogUtil.d("LangBridgeActivity", "onTrimMemory level HIDDEN url = " + this.k);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_ENTER_BACKGROUND, Arrays.asList(new String[]{this.k, String.valueOf(0)}));
            }
        }
    }

    public void onWebViewBack() {
        this.a = false;
    }

    public void openInNewWebView(final String str, final String str2) {
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        LightappBrowseActivity.this.mWebView.loadUrl(str2.trim());
                    } else {
                        LightappBrowseActivity.this.mWebView.loadUrl(str.trim());
                    }
                    LightappBrowseActivity.this.a = false;
                } catch (Exception unused) {
                    LightappBrowseActivity.this.finish();
                }
            }
        });
    }

    public void preLoadException(String str) {
    }

    public void preLoadUrl(ArrayList<String> arrayList, int i2) {
    }

    public void prepareSelectNumDialog(List<String> list, AdapterView.OnItemClickListener onItemClickListener) {
        SelectNumberDialog selectNumberDialog = new SelectNumberDialog(getActivity());
        selectNumberDialog.setOnItemClickListener(onItemClickListener);
        selectNumberDialog.setData(list);
        selectNumberDialog.show();
    }

    public void removeLifeCycleListener(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.g.removeElement(activityLifecycleCallbacks);
    }

    public void rmFromPreloadPool() {
    }

    public void rpaPerception(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        RpaConfig targetRpaConfig;
        RpaConfig.RpaSenseStrategy[] rpaSenseStrategyArr;
        if (RpaProcessor.getInstance().isValid(SdkInitResponse.getInstance().rpa_pages_config) && (targetRpaConfig = RpaProcessor.getInstance().getTargetRpaConfig(SdkInitResponse.getInstance().rpa_pages_config, str2)) != null && TextUtils.equals("1", targetRpaConfig.rpa_type) && (rpaSenseStrategyArr = targetRpaConfig.rpa_sense_strategy) != null && rpaSenseStrategyArr.length > 0) {
            for (RpaConfig.RpaSenseStrategy rpaSenseStrategy : rpaSenseStrategyArr) {
                if (TextUtils.equals(rpaSenseStrategy.type, "1") && str.contains("domTreeChangeReturnFlag")) {
                    int intValue = RpaProcessor.getIntValue(rpaSenseStrategy.timeInterval);
                    if (intValue > 0) {
                        rpaSenseStrategy.url = str2;
                        rpaSenseStrategy.rpaUrl = targetRpaConfig.rpa_url;
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        obtain.arg1 = intValue;
                        obtain.obj = rpaSenseStrategy;
                        this.Y.sendMessage(obtain);
                    }
                } else if (TextUtils.equals(rpaSenseStrategy.type, "2") && str.contains("domTreeChangeReturnFlag")) {
                    this.Y.post(new Runnable() {
                        public void run() {
                            LightappBrowseActivity.this.executeJsFunction("(function() {\n    var originalRequestAnimationFrame = window.requestAnimationFrame;\n    let oldElementStringData;\n    function successFn(ret) {}\n\n    function failFn(argument) {\n    }\n    window.requestAnimationFrame = function(callback) {\n        var elements = document.getElementsByClassName('el-overlay');\n        if (elements.length > 0) {\n            var elementString = elements[0].outerHTML;\n            \n            if (oldElementStringData !== undefined) {//判断多次弹窗逻辑\n              // oldElementStringData 已被赋值\n                if (oldElementStringData != elementString) {\n                    window.BLightApp.invokeBdWalletNative(JSON.stringify(\n                                          {\n                                          \"method_name\": \"rpaPerception\",\n                                          \"msg\": \"popUpReturnFlag\",\n                                          }), 'successFn', 'failFn')\n                    oldElementStringData = elementString;\n                } else {\n                    //弹窗内容无变化\n                }\n            } else {\n              // oldElementStringData 未被赋值\n                window.BLightApp.invokeBdWalletNative(JSON.stringify(\n                                          {\n                                          \"method_name\": \"rpaPerception\",\n                                          \"msg\": \"popUpReturnFlag\",\n                                          }), 'successFn', 'failFn')\n                oldElementStringData = elementString;\n            }\n        }\n        if (window.find('keywordsSearchedByStringName')) {//字符串查找\n            window.BLightApp.invokeBdWalletNative(JSON.stringify(\n                                          {\n                                          \"method_name\": \"rpaPerception\",\n                                          \"msg\": \"keywordsSearchedByStringName\",\n                                          }), 'successFn', 'failFn')\n        }\n        return originalRequestAnimationFrame.apply(this, arguments);\n    };\n    return 0;\n})();", (String) null, new ValueCallback<String>() {
                                /* renamed from: a */
                                public void onReceiveValue(String str) {
                                }
                            });
                        }
                    });
                } else if (TextUtils.equals(rpaSenseStrategy.type, "2") && str.contains("popUpReturnFlag")) {
                    int intValue2 = RpaProcessor.getIntValue(rpaSenseStrategy.timeInterval);
                    if (intValue2 > 0) {
                        rpaSenseStrategy.url = str2;
                        rpaSenseStrategy.rpaUrl = targetRpaConfig.rpa_url;
                        Message obtain2 = Message.obtain();
                        obtain2.what = 3;
                        obtain2.arg1 = intValue2;
                        obtain2.obj = rpaSenseStrategy;
                        this.Y.sendMessage(obtain2);
                    }
                } else if (TextUtils.equals(rpaSenseStrategy.type, "3")) {
                    if (str.contains("domTreeChangeReturnFlag")) {
                        this.Y.removeMessages(2);
                    }
                    int intValue3 = RpaProcessor.getIntValue(rpaSenseStrategy.timeInterval);
                    if (intValue3 > 0) {
                        rpaSenseStrategy.url = str2;
                        rpaSenseStrategy.rpaUrl = targetRpaConfig.rpa_url;
                        Message obtain3 = Message.obtain();
                        obtain3.what = 2;
                        obtain3.arg1 = intValue3;
                        obtain3.obj = rpaSenseStrategy;
                        this.Y.sendMessageDelayed(obtain3, (long) (intValue3 * 1000));
                    }
                }
            }
        }
    }

    public void selectPhoneFromAddressBook() {
        this.Q = new ContactInfoPresenter(getActivity(), this.e);
        ContactManager.getIContactsImpl().pickContactsByPhoneContentType(getActivity(), 4);
    }

    public void setActionBarTransparent(boolean z2) {
        LogUtil.d("LightappBrowseActivityTAG", "setActionBarTransparent:" + z2);
        FrameLayout frameLayout = z2 ? this.y : this.E;
        FrameLayout frameLayout2 = z2 ? this.E : this.y;
        FrameLayout frameLayout3 = z2 ? this.z : this.F;
        FrameLayout frameLayout4 = z2 ? this.F : this.z;
        if (this.x != null && frameLayout2.getChildCount() == 0 && this.C != null && frameLayout4.getChildCount() == 0) {
            frameLayout.removeAllViews();
            frameLayout3.removeAllViews();
            frameLayout2.addView(this.x);
            frameLayout4.addView(this.C, new ViewGroup.LayoutParams(DisplayUtils.dip2px(this, 10.0f), DisplayUtils.dip2px(this, 2.0f)));
        }
    }

    public JSONObject setFullScreenInMainThread(boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2) {
        final boolean z6 = z5;
        final boolean z7 = z4;
        final boolean z8 = z2;
        final String str3 = str2;
        final String str4 = str;
        final boolean z9 = z3;
        runOnUiThread(new Runnable() {
            private void a() {
                LightappBrowseActivity.this.Z.isFullScreen = z8;
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        LightappBrowseActivity.this.Z.fullScreenTitleColor = Color.parseColor(str3);
                    } catch (Throwable th2) {
                        LogUtil.d(SapiUtils.KEY_QR_LOGIN_ERROR, th2.toString());
                        LightappBrowseActivity.this.Z.fullScreenTitleColor = 0;
                    }
                } else {
                    LightappBrowseActivity.this.Z.fullScreenTitleColor = 0;
                }
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        LightappBrowseActivity.this.Z.fullScreenActionBarColor = Color.parseColor(str4);
                    } catch (Throwable unused) {
                        LightappBrowseActivity.this.Z.fullScreenActionBarColor = -1;
                    }
                } else {
                    LightappBrowseActivity.this.Z.fullScreenActionBarColor = -1;
                }
                LightappBrowseActivity.this.Z.isHideTitle = z9;
                LightappBrowseActivity.this.Z.isIconWhite = z6;
            }

            private void b() {
                if (LightappBrowseActivity.this.Z.fullScreenTitleColor != 0) {
                    LightappBrowseActivity.this.x.setFullScreenTextColor(LightappBrowseActivity.this.Z.fullScreenTitleColor);
                } else {
                    LightappBrowseActivity.this.x.resetFullScreenTextColor();
                }
            }

            private void c() {
                boolean z = true;
                if (LightappBrowseActivity.this.Z.fullScreenActionBarColor != -1) {
                    LightappBrowseActivity.this.x.setTitlebgColor(LightappBrowseActivity.this.Z.fullScreenActionBarColor);
                    LightappBrowseActivity.this.x.setBottomSeperatorvisible(false);
                    LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
                    if (Color.alpha(lightappBrowseActivity.Z.fullScreenActionBarColor) == 255) {
                        z = false;
                    }
                    lightappBrowseActivity.setActionBarTransparent(z);
                    return;
                }
                LightappBrowseActivity.this.x.setTitlebgColor(ResUtils.getColor(LightappBrowseActivity.this.getActivity(), "wallet_extend_color_actionbar_bg"));
                LightappBrowseActivity.this.x.setBottomSeperatorvisible(true);
                LightappBrowseActivity.this.setActionBarTransparent(false);
            }

            private void d() {
                if (LightappBrowseActivity.this.Z.fullScreenActionBarColor == -1 || (LightappBrowseActivity.this.Z.fullScreenActionBarColor | -16777216) == -1) {
                    LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
                    lightappBrowseActivity.b.setBackgroundColor(ResUtils.getColor(lightappBrowseActivity.getActivity(), "wallet_base_background1_color_7f"));
                } else {
                    LightappBrowseActivity lightappBrowseActivity2 = LightappBrowseActivity.this;
                    lightappBrowseActivity2.b.setBackgroundColor(lightappBrowseActivity2.Z.fullScreenActionBarColor);
                }
                if (LightappBrowseActivity.this.Z.fullScreenTitleColor != 0) {
                    LightappBrowseActivity.this.P.setTextColor(LightappBrowseActivity.this.Z.fullScreenTitleColor);
                } else {
                    LightappBrowseActivity.this.P.setTextColor(ResUtils.getColor(LightappBrowseActivity.this.getActivity(), "wallet_base_font_text4Color"));
                }
            }

            public void run() {
                a();
                LightappBrowseActivity.this.x.setIconFlag(z6, LightappBrowseActivity.this.Z.isIconIsolate);
                if (LightappBrowseActivity.this.A != null) {
                    LightappBrowseActivity.this.A.setSupportPullDown(!z7);
                }
                c();
                b();
                LightappBrowseActivity.this.e();
                d();
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("actionBarHeight", DisplayUtils.px2dip(DxmApplicationContextImpl.getApplicationContext(this), (float) this.x.getActionBarHeight()));
            jSONObject.put("statusBarHeight", DisplayUtils.px2dip(DxmApplicationContextImpl.getApplicationContext(this), (float) this.x.getStatusBarHeight()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void setHalfLightBridgeStyle(Context context, final Double d2, final String str, final int i2) {
        if (this.n) {
            LogUtil.d("LightappBrowseActivityTAG", "setHalfLightBridgeStyle，halfHeight：" + d2 + ",halfColor:" + str + ",visible:" + i2);
            runOnUiThread(new Runnable() {
                public void run() {
                    LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
                    Double d2 = d2;
                    lightappBrowseActivity.a(d2 == null ? -0.0d : d2.doubleValue(), str, i2, true);
                }
            });
        }
    }

    public void setIsCheckPermission(boolean z2) {
        this.T = z2;
    }

    public void setIsMultiWindowAvailable(boolean z2) {
        if (z2 != this.N) {
            this.N = z2;
        }
    }

    public void setIsShowMultiWindowTips(boolean z2) {
        if (z2 != this.K) {
            this.K = z2;
        }
    }

    public void setMenuInMainThread(final JSONArray jSONArray) {
        runOnUiThread(new Runnable() {
            public void run() {
                if (LightappBrowseActivity.this.x.getRightZoneView() != null) {
                    LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
                    LightappBrowseActivity lightappBrowseActivity2 = LightappBrowseActivity.this;
                    a unused = lightappBrowseActivity.w = new a(lightappBrowseActivity2.getActivity(), jSONArray);
                    LightappBrowseActivity.this.x.setRightImgZone2OnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (LightappBrowseActivity.this.w != null) {
                                LightappBrowseActivity.this.w.show();
                            } else if (LightappBrowseActivity.this.v != null) {
                                LightappBrowseActivity.this.v.show();
                            }
                        }
                    });
                }
            }
        });
    }

    public void setMultiWindowTipsId(String str) {
        this.L = str;
    }

    public void setScreenVertical(boolean z2) {
        this.V = z2;
    }

    public void setSubMenu(String str, String str2, String str3, int i2, String str4, String str5, int i3, int i4) {
        final RelativeLayout relativeLayout = (RelativeLayout) this.x.getRightZone1View();
        final NetImageView netImageView = (NetImageView) this.x.getRightImgZone1ImgView();
        boolean z2 = !TextUtils.isEmpty(str5);
        this.U = z2;
        final String str6 = z2 ? "新样式" : "老样式";
        LogUtil.d("bubble", "当前页面的mCurUrl:" + this.k);
        StringBuilder sb = new StringBuilder();
        sb.append("bubbleAnimation:");
        final int i5 = i4;
        sb.append(i5);
        sb.append(" ,bubbleVisibility:");
        final int i6 = i3;
        sb.append(i6);
        sb.append(",visibility:");
        final int i7 = i2;
        sb.append(i7);
        LogUtil.d("bubble", sb.toString());
        final String str7 = str;
        final String str8 = str2;
        final String str9 = str4;
        final String str10 = str5;
        final String str11 = str3;
        runOnUiThread(new Runnable() {
            public void run() {
                if (i7 == 4) {
                    LightappBrowseActivity.this.x.hideBubble(false);
                } else if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                    netImageView.setEnabled(true);
                    ImageLoader.getInstance(LightappBrowseActivity.this.getActivity()).getBitmap(str7, new ImageLoader.OnGetBitmapListener() {
                        public boolean needCancel(String str, Object obj) {
                            return false;
                        }

                        public void onError(String str, Object obj) {
                            LogUtil.d("bubble", "icon getFail error = " + str);
                        }

                        public void onGetBitmap(String str, Object obj, final Bitmap bitmap) {
                            if (bitmap != null && !TextUtils.isEmpty(str8)) {
                                LightappBrowseActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        String str;
                                        LightappBrowseActivity.this.x.setRightImgZone1Visibility(i7);
                                        AnonymousClass13 r0 = AnonymousClass13.this;
                                        netImageView.setVisibility(i7);
                                        if (!netImageView.isEnabled()) {
                                            LogUtil.d("bubble", "icon getSuccess但页面发生已变：" + LightappBrowseActivity.this.k);
                                            return;
                                        }
                                        boolean z = false;
                                        LightappBrowseActivity.this.x.setRightImgZone1Visibility(0);
                                        int i2 = 1;
                                        LightappBrowseActivity.this.x.setRightImgZone1Enable(true);
                                        netImageView.setImageDrawable(new BitmapDrawable(bitmap));
                                        LightappBrowseActivity.this.Z.isIconIsolate = TextUtils.equals("1", str9);
                                        if (!LightappBrowseActivity.this.Z.isIconWhite || !LightappBrowseActivity.this.x.isIconWhite() || LightappBrowseActivity.this.Z.isIconIsolate) {
                                            netImageView.clearColorFilter();
                                        } else {
                                            netImageView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
                                        }
                                        AnonymousClass13 r3 = AnonymousClass13.this;
                                        DXMSdkSAUtils.onShowEvent(StatServiceEvent.EVENT_KEY_SET_SUBMENU_ICON, Arrays.asList(new String[]{str6, LightappBrowseActivity.this.k}));
                                        netImageView.setVisibility(0);
                                        if (relativeLayout.getVisibility() == 0) {
                                            if (LightappBrowseActivity.this.U) {
                                                AnonymousClass13 r02 = AnonymousClass13.this;
                                                str = str10;
                                                int i3 = i5;
                                                if (i6 == 4) {
                                                    BdActionBar g = LightappBrowseActivity.this.x;
                                                    if (i5 == 1) {
                                                        z = true;
                                                    }
                                                    g.hideBubble(z);
                                                    return;
                                                }
                                                i2 = i3;
                                            } else {
                                                str = str11;
                                            }
                                            LightappBrowseActivity.this.x.showBubble(str, i2, LightappBrowseActivity.this.U, LightappBrowseActivity.this.k);
                                        }
                                    }
                                });
                            }
                        }
                    }, (Object) null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
                    LightappBrowseActivity.this.x.setRightImgZone1OnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            LogUtil.d("bubble", "执行js");
                            if (!LightappBrowseActivity.this.U) {
                                LightappBrowseActivity.this.x.hideBubble(true);
                            }
                            AnonymousClass13 r5 = AnonymousClass13.this;
                            LightappBrowseActivity.this.executeJsFunction(str8, (String) null);
                            AnonymousClass13 r2 = AnonymousClass13.this;
                            DXMSdkSAUtils.onClickEvent(StatServiceEvent.EVENT_KEY_SET_SUBMENU_ICON, Arrays.asList(new String[]{str6, LightappBrowseActivity.this.k}));
                        }
                    });
                    if (LightappBrowseActivity.this.U) {
                        LightappBrowseActivity.this.x.setBubbleImageOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                LogUtil.d("bubble", "图片气泡执行js");
                                AnonymousClass13 r4 = AnonymousClass13.this;
                                LightappBrowseActivity.this.executeJsFunction(str8, (String) null);
                                AnonymousClass13 r0 = AnonymousClass13.this;
                                DXMSdkSAUtils.onClickEvent(StatServiceEvent.EVENT_KEY_SET_SUBMENU_BUBBLE, Arrays.asList(new String[]{str6, LightappBrowseActivity.this.k}));
                            }
                        });
                    }
                }
            }
        });
    }

    @SuppressLint({"NewApi"})
    public void setSupportZoom() {
        super.setSupportZoom();
    }

    public void setTitlesInMainThread(final String str, final String str2, final boolean z2) {
        runOnUiThread(new Runnable() {
            public void run() {
                String str;
                if (LightappBrowseActivity.this.x != null) {
                    if (!NetworkUtils.isNetworkConnected(LightappBrowseActivity.this.getActivity())) {
                        str = LightappBrowseActivity.this.I;
                        LightappBrowseActivity.this.x.setTitleCenterSafeTipText("");
                    } else if (TextUtils.isEmpty(str)) {
                        if (TextUtils.isEmpty(LightappBrowseActivity.this.mWebView.getTitle()) || LightappBrowseActivity.r.matcher(LightappBrowseActivity.this.mWebView.getTitle()).matches()) {
                            String unused = LightappBrowseActivity.this.J = null;
                            str = "";
                        } else {
                            str = LightappBrowseActivity.this.mWebView.getTitle();
                            LightappBrowseActivity lightappBrowseActivity = LightappBrowseActivity.this;
                            String unused2 = lightappBrowseActivity.J = lightappBrowseActivity.mWebView.getTitle();
                        }
                        LogUtil.d("mWebView.getTitle =", LightappBrowseActivity.this.mWebView.getTitle());
                        LightappBrowseActivity.this.x.setTitleCenterSafeTipText("");
                    } else {
                        str = str;
                        String unused3 = LightappBrowseActivity.this.J = str;
                        if (!TextUtils.isEmpty(str2)) {
                            String trim = str2.trim();
                            if (!TextUtils.isEmpty(trim)) {
                                LightappBrowseActivity.this.x.setTitleCenterSafeTipText(trim);
                            }
                        } else {
                            LightappBrowseActivity.this.x.setTitleCenterSafeTipText("");
                        }
                    }
                    LightappBrowseActivity.this.c(str);
                    int[] titleSizeRange = LightappBrowseActivity.this.x.getTitleSizeRange();
                    int i2 = titleSizeRange[0];
                    int i3 = titleSizeRange[1];
                    if (z2) {
                        int mainTitleViewWidth = LightappBrowseActivity.this.x.getMainTitleViewWidth();
                        float f = (float) i2;
                        float stringWidth = StringUtil.getStringWidth(LightappBrowseActivity.this.x.getTitle(), f);
                        LightappBrowseActivity.this.x.setTitleEllipsize(TextUtils.TruncateAt.END);
                        float f2 = (float) mainTitleViewWidth;
                        if (stringWidth <= f2) {
                            LightappBrowseActivity.this.x.setTitleSize(i2);
                            return;
                        }
                        float f3 = f2 / stringWidth;
                        if (1.0f <= f3 || ((float) i3) / f > f3) {
                            LightappBrowseActivity.this.x.setTitleSize(i3);
                            return;
                        }
                        LightappBrowseActivity.this.x.setTitleSize(Math.round(f * f3));
                        return;
                    }
                    LightappBrowseActivity.this.x.setTitleSize(i2);
                }
            }
        });
    }

    public void showLoadingProgress() {
        i();
    }

    public void showTitleFloatView(final boolean z2, final String str) {
        runOnUiThread(new Runnable() {
            public void run() {
                if (LightappBrowseActivity.this.x != null) {
                    LightappBrowseActivity.this.x.showTitleFloatView(z2, false, str);
                }
            }
        });
    }

    public void startNewLightApp(Context context, String str, String str2, boolean z2, boolean z3, Double d2, String str3) {
        final Context context2 = context;
        final String str4 = str;
        final String str5 = str2;
        final boolean z4 = z2;
        final boolean z5 = z3;
        final Double d3 = d2;
        final String str6 = str3;
        runOnUiThread(new Runnable() {
            public void run() {
                LightappBrowseActivity.startLightApp(context2, str4, str5, z4, z5, d3, str6);
            }
        });
    }

    public ArrayList<String> statExtraDatasForPause() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.k);
        return arrayList;
    }

    public void upToSensor(String str, List<String> list) {
        if (!TextUtils.isEmpty(str)) {
            LangbridgeSettings.ConsoleMsgBehaviour[] consoleMsgBehaviourArr = h.a().a((Context) this).MW_CONSOLE_MESSAGE_BEHAVAIOUR;
            int i2 = 0;
            while (consoleMsgBehaviourArr != null && i2 < consoleMsgBehaviourArr.length) {
                if (str.equals(consoleMsgBehaviourArr[i2].mConsoleString)) {
                    String[] strArr = new String[2];
                    String str2 = "1";
                    strArr[0] = h.a().b(getContext()).MW_ON ? str2 : "0";
                    if (!h.a().b(getContext()).MW_USE_OLD) {
                        str2 = "0";
                    }
                    strArr[1] = str2;
                    new ArrayList(Arrays.asList(strArr)).addAll(list);
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_CONSOLE_ERROR, list);
                }
                i2++;
            }
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        LogUtil.i("LightappBrowseActivityTAG", "hideCustomView");
        if (this.fullScreenview != null && getActivity() != null && this.j != null) {
            d(true);
            ((FrameLayout) getActivity().getWindow().getDecorView()).removeView(this.f3563i);
            this.f3563i = null;
            this.fullScreenview = null;
            this.j.onCustomViewHidden();
            if (getApplicationInfo().targetSdkVersion < 26 || Build.VERSION.SDK_INT != 26) {
                getActivity().setRequestedOrientation(1);
            }
            DXMSdkSAUtils.onEventWithValues("#webviewVedioNotFullScreen", Arrays.asList(new String[]{this.k}));
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        NoNetView noNetView = this.B;
        if (noNetView != null) {
            noNetView.notifyUrlFinish();
        }
        LightappBrowserWebView lightappBrowserWebView = this.mWebView;
        if (lightappBrowserWebView != null) {
            lightappBrowserWebView.setVisibility(0);
        }
    }

    private void i() {
        this.C.setVisibility(0);
        this.C.setBackgroundColor(ResUtils.getColor(getActivity(), "ebpay_blue"));
        a(5);
    }

    private void j() {
        this.C.setBackgroundColor(ResUtils.getColor(getActivity(), "ebpay_transparent"));
    }

    @TargetApi(24)
    private void k() {
        if (Build.VERSION.SDK_INT >= 24) {
            if (this.K && isInMultiWindowMode()) {
                GlobalUtils.toast(this, ResUtils.getString(getActivity(), this.L), -1, 1);
            }
            if (!this.N && isInMultiWindowMode()) {
                finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        LightappBusinessClient lightappBusinessClient = this.e;
        ILightappInvokerCallback h5Close = lightappBusinessClient != null ? lightappBusinessClient.getH5Close() : null;
        LogUtil.d("closeEvent", "handleCloseEvent closeCallback = " + h5Close);
        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(new String[]{CheckUtils.stripUrlParams(this.k), "" + d}));
        if (h5Close != null) {
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_BD_WALLET_PAGE_CLOSE, Arrays.asList(new String[]{CheckUtils.stripUrlParams(this.k), "" + d}));
            executeJsFunction(LightappBusinessClient.MTD_H5ClOSE, (String) null);
            return;
        }
        closeWindow();
    }

    public static void startLightApp(Context context, String str, String str2, boolean z2, boolean z3, Bundle bundle) {
        startLightApp(context, str, str2, z2, z3, (Double) null, "", bundle);
    }

    /* access modifiers changed from: private */
    public void e() {
        BdActionBar bdActionBar = this.x;
        if (bdActionBar != null) {
            if (this.Z.isHideTitle) {
                bdActionBar.setTitleTextColorAlpha(0);
            } else {
                bdActionBar.setTitleTextColorAlpha(255);
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        runOnUiThread(new Runnable() {
            public void run() {
                LightappBrowseActivity.this.mWebView.setOnMyScrollChangeListener(new LightappWebView.a() {
                    public void a(int i2) {
                        if (!LightappBrowseActivity.this.U) {
                            LightappBrowseActivity.this.x.hideBubble(true);
                        }
                        if (LightappBrowseActivity.this.Z.isFullScreen) {
                            int height = LightappBrowseActivity.this.x.getHeight();
                            float f = ((float) (height - i2)) / ((float) height);
                            if (f > 0.0f) {
                                if (LightappBrowseActivity.this.Z.fullScreenTitleColor != 0) {
                                    LightappBrowseActivity.this.x.setFullScreenTextColor(LightappBrowseActivity.this.Z.fullScreenTitleColor);
                                }
                                float f2 = 1.0f - f;
                                int i3 = (int) (255.0f * f2);
                                if (LightappBrowseActivity.this.Z.isHideTitle) {
                                    if (i3 >= 255) {
                                        LightappBrowseActivity.this.x.setTitleTextColorAlpha(i3);
                                    } else {
                                        LightappBrowseActivity.this.x.setTitleTextColorAlpha(0);
                                    }
                                }
                                if (LightappBrowseActivity.this.Z.isIconWhite) {
                                    LightappBrowseActivity.this.x.setIconFlag(true, LightappBrowseActivity.this.Z.isIconIsolate);
                                }
                                if (LightappBrowseActivity.this.Z.fullScreenActionBarColor != -1) {
                                    LightappBrowseActivity.this.x.setTitlebgColor(LightappBrowseActivity.getCurrentColor(f2, LightappBrowseActivity.this.Z.fullScreenActionBarColor, ResUtils.getColor(LightappBrowseActivity.this.getActivity(), "wallet_extend_color_actionbar_bg")));
                                    return;
                                }
                                return;
                            }
                            if (LightappBrowseActivity.this.Z.isHideTitle) {
                                LightappBrowseActivity.this.x.setTitleTextColorAlpha(255);
                            }
                            if (LightappBrowseActivity.this.Z.isIconWhite) {
                                LightappBrowseActivity.this.x.setIconFlag(false, LightappBrowseActivity.this.Z.isIconIsolate);
                            }
                            LightappBrowseActivity.this.x.setTitlebgColor(ResUtils.getColor(LightappBrowseActivity.this.getActivity(), "wallet_extend_color_actionbar_bg"));
                            LightappBrowseActivity.this.x.resetFullScreenTextColor();
                            return;
                        }
                        int height2 = LightappBrowseActivity.this.x.getHeight();
                        float f3 = ((float) (height2 - i2)) / ((float) height2);
                        if (f3 > 0.0f) {
                            int i4 = (int) ((1.0f - f3) * 255.0f);
                            if (!LightappBrowseActivity.this.Z.isHideTitle) {
                                return;
                            }
                            if (i4 >= 255) {
                                LightappBrowseActivity.this.x.setTitleTextColorAlpha(i4);
                            } else {
                                LightappBrowseActivity.this.x.setTitleTextColorAlpha(0);
                            }
                        } else if (LightappBrowseActivity.this.Z.isHideTitle) {
                            LightappBrowseActivity.this.x.setTitleTextColorAlpha(255);
                        }
                    }
                });
            }
        });
    }

    public static void startLightApp(Context context, String str, String str2, boolean z2, boolean z3, Double d2, String str3, Bundle bundle) {
        Intent a2 = a(context, str, str2, z2, z3, d2, str3, bundle);
        if (a2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            a2.putExtra("LANGBRIDGE_HASH", currentTimeMillis);
            LangbridgeCacheManager.getInstance().handleStartLangbirdge(currentTimeMillis, str);
            context.startActivity(a2);
            boolean z4 = ((d2 == null || d2.doubleValue() == -0.0d) && (bundle == null || bundle.getDouble(Constants.HALF_LIGHTBRIDGE_HEIGHT) == -0.0d)) ? false : true;
            if (!(context instanceof Activity)) {
                return;
            }
            if (z4) {
                BaseActivity.startActivityDownUpAnim(context);
            } else if (z2) {
                BaiduWalletUtils.startActivityAnim(context);
            } else {
                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
            }
        }
    }

    private void d() {
        LogUtil.d("LightappBrowseActivityTAG", "isHalfLightBridge：" + this.n);
        if (this.n) {
            a(this.l, this.m, 0, false);
        } else {
            RoundLinearLayout roundLinearLayout = this.q;
            if (roundLinearLayout != null) {
                roundLinearLayout.setRoundPath(RoundLinearLayout.RECT_RADII);
            }
            RelativeLayout relativeLayout = this.f3564o;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.wallet_base_whiteColor));
            }
        }
        LangBrigdeSlideLayout langBrigdeSlideLayout = this.A;
        if (langBrigdeSlideLayout != null) {
            langBrigdeSlideLayout.setPullRefreshEnabled(!this.n);
        }
        NoNetView noNetView = this.B;
        if (noNetView != null) {
            if (this.n) {
                noNetView.setBackground(R.drawable.wallet_base_top_round_white);
            } else {
                noNetView.setBackground(R.color.bd_wallet_white);
            }
        }
        ViewUtils.setVisibility(this.G, this.n);
        ViewUtils.setVisibility(this.b, !this.n);
        ViewUtils.setVisibility(this.D, !this.n);
        ViewUtils.setVisibility(this.y, !this.n);
        ViewUtils.setVisibility(this.z, !this.n);
        if (this.n) {
            ViewUtils.setVisibility(this.x, false);
        } else if (!this.u) {
            ViewUtils.setVisibility(this.x, false);
        } else {
            ViewUtils.setVisibility(this.x, true);
        }
    }

    private void f(String str) {
        LightappBrowserWebView lightappBrowserWebView;
        String[] b2 = a.b(str);
        LogUtil.d("LightappBrowseActivityTAG", "OLD to add Js Hook groupName = " + str + "\n filesName=" + Arrays.toString(b2));
        if (b2 != null && b2.length > 0) {
            for (String str2 : b2) {
                if (!TextUtils.isEmpty(str2)) {
                    String a2 = a.a(str2);
                    if (!TextUtils.isEmpty(a2) && (lightappBrowserWebView = this.mWebView) != null) {
                        lightappBrowserWebView.addJsCode(str2, a2);
                        LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "OLD toAdd COMMON JSFile = " + a2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(boolean z2) {
        if (z2) {
            this.x.showLeftZone();
        } else {
            this.x.hideLeftZone();
        }
    }

    private void b(String str) {
        BdActionBar bdActionBar = this.x;
        if (bdActionBar != null) {
            if (!this.u) {
                bdActionBar.setVisibility(8);
            }
            c(this.I);
            this.x.setLeftZoneOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(LightappBrowseActivity.this.getActivity());
                    LightappBrowseActivity.this.onBackPressed();
                }
            });
            if (this.v != null) {
                this.x.setRightImgZone2Visibility(0);
                this.x.setRightImgZone2Enable(true);
                this.x.setRightImgZone2Src(ResUtils.drawable(getActivity(), "wallet_langbridge_actionbar_more"), ResUtils.getString(getActivity(), "wallet_base_bdaction_more"));
                this.x.setRightImgZone2OnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        LightappBrowseActivity.this.v.show();
                    }
                });
                this.x.setOnlyIcons(getIntent().getExtras().getBoolean("only_icons"));
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        if (this.x != null) {
            e();
            this.x.setTitle(str);
        }
    }

    /* access modifiers changed from: private */
    public void e(final String str) {
        executeJsFunction("(function() {\n     return document.documentElement.outerHTML;\n})", (String) null, new ValueCallback<String>() {
            /* renamed from: a */
            public void onReceiveValue(String str) {
                if (!TextUtils.isEmpty(str)) {
                    DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_GET_DOM_SCRIPT, Arrays.asList(new String[]{str, "1"}));
                    RpaProcessor.getInstance().writeHtmlToFile(LightappBrowseActivity.this.getContext(), str, System.currentTimeMillis(), str);
                    return;
                }
                DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_GET_DOM_SCRIPT, Arrays.asList(new String[]{str, "0"}));
            }
        });
    }

    public void executeJsFunction(String str, String str2) {
        if (this.mWebView != null && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder(str);
                sb.append("(\"");
                if (str2 != null) {
                    sb.append(LightappUtils.formatJSONForWebViewCallback(str2));
                }
                sb.append("\")");
                if (Build.VERSION.SDK_INT >= 19) {
                    this.mWebView.evaluateJavascript(sb.toString(), (ValueCallback) null);
                    return;
                }
                LightappBrowserWebView lightappBrowserWebView = this.mWebView;
                lightappBrowserWebView.loadUrl("javascript:" + sb.toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(double d2, String str, int i2, boolean z2) {
        int displayHeight = DisplayUtils.getDisplayHeight(getContext());
        int dip2px = DisplayUtils.dip2px(getContext(), 100.0f);
        double d3 = (double) displayHeight;
        int i3 = (int) (0.9d * d3);
        if (!(this.l == d2 || d2 == -0.0d) || !z2) {
            if (d2 > 0.0d && d2 < 1.0d) {
                d2 *= d3;
            }
            double d4 = (double) i3;
            if (d2 >= d4) {
                d2 = d4;
            } else {
                double d5 = (double) dip2px;
                if (d2 <= d5) {
                    d2 = d5;
                }
            }
            if (this.p != null) {
                LogUtil.d("LightappBrowseActivityTAG", "屏幕的高度：" + displayHeight + ",halfHeight:" + d2);
                a((View) this.p, d2);
            }
            NoNetView noNetView = this.B;
            if (noNetView != null) {
                a((View) noNetView, d2);
                this.B.setVisibilityByContentHeight((int) d2);
            }
        }
        RoundLinearLayout roundLinearLayout = this.q;
        if (roundLinearLayout != null) {
            roundLinearLayout.setRoundPath(RoundLinearLayout.HALF_RADII);
        }
        int color = ContextCompat.getColor(getContext(), R.color.half_wallet_bg_color);
        if (z2) {
            RelativeLayout relativeLayout = this.f3564o;
            if (!(relativeLayout == null || str == null)) {
                relativeLayout.setBackgroundColor(ViewUtils.parseColor(str, color));
            }
        } else {
            RelativeLayout relativeLayout2 = this.f3564o;
            if (relativeLayout2 != null) {
                relativeLayout2.setBackgroundColor(ViewUtils.parseColor(str, color));
            }
        }
        BdHalfActionBar bdHalfActionBar = this.G;
        if (bdHalfActionBar != null) {
            ViewUtils.setVisibility(bdHalfActionBar, ((double) i2) != 1.0d);
            this.G.setIconBack(new View.OnClickListener() {
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(LightappBrowseActivity.this.getActivity());
                    LightappBrowseActivity.this.onBackPressed();
                }
            });
            this.G.setIconClose(new View.OnClickListener() {
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(LightappBrowseActivity.this.getActivity());
                    LightappBrowseActivity.this.l();
                }
            });
        }
    }

    public static void startLightApp(Context context, String str, boolean z2) {
        startLightApp(context, str, (String) null, true, z2, (Double) null, (String) null);
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        this.x.setTitleTextColorAlpha(z2 ? 255 : 0);
    }

    /* access modifiers changed from: private */
    public void d(boolean z2) {
        getActivity().getWindow().setFlags(z2 ? 0 : 1024, 1024);
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        if (this.t) {
            NoNetView noNetView = this.B;
            if (noNetView != null) {
                noNetView.show(str, this);
            }
            LightappBrowserWebView lightappBrowserWebView = this.mWebView;
            if (lightappBrowserWebView != null) {
                lightappBrowserWebView.setVisibility(8);
            }
        }
    }

    private void a(View view, double d2) {
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.addRule(12);
            layoutParams.height = (int) d2;
            view.setLayoutParams(layoutParams);
        } catch (Exception e2) {
            LogUtil.d("LightappBrowseActivityTAG", "异常" + e2.getMessage());
        }
    }

    private void a(String str) {
        if (TextUtils.equals("1", new UrlQuerySanitizer(str).getValue(LangbridgeActivity.KEY_DISABLE_SCREENSHOT))) {
            BdWalletUtils.addFlagsSecure(getActivity());
        }
    }

    private BdActionBar a(boolean z2) {
        LogUtil.d("LightappBrowseActivityTAG", "createActionBar,longTitle:" + z2);
        if (z2) {
            return new BdLightAppActionBar(getActivity());
        }
        return new BdActionBar(getActivity());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:8|9|10|11|12|13|(1:24)(2:17|25)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r4, com.baidu.wallet.lightapp.business.TitleBarParams r5) {
        /*
            r3 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 8
            r1 = 0
            if (r4 == 0) goto L_0x0021
            com.baidu.wallet.base.widget.BdActionBar r4 = r3.x     // Catch:{ Exception -> 0x0073 }
            r4.setRightImgZone2Visibility(r1)     // Catch:{ Exception -> 0x0073 }
            r4 = 1
            android.view.View[] r4 = new android.view.View[r4]     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.base.widget.BdActionBar r5 = r3.x     // Catch:{ Exception -> 0x0073 }
            android.view.View r5 = r5.getRightImgZone2ImgView()     // Catch:{ Exception -> 0x0073 }
            r4[r1] = r5     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.utils.ViewUtils.visibleView(r4)     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.base.widget.BdActionBar r4 = r3.x     // Catch:{ Exception -> 0x0073 }
            r4.setRightImgZone2NotifyVisibility(r0)     // Catch:{ Exception -> 0x0073 }
            goto L_0x007d
        L_0x0021:
            java.util.List<com.baidu.wallet.lightapp.business.TitleBarParams$d> r4 = r5.rightParams     // Catch:{ Exception -> 0x0073 }
            boolean r4 = com.baidu.apollon.utils.CollectionUtils.isEmpty((java.util.Collection<?>) r4)     // Catch:{ Exception -> 0x0073 }
            if (r4 != 0) goto L_0x007d
            java.util.List<com.baidu.wallet.lightapp.business.TitleBarParams$d> r4 = r5.rightParams     // Catch:{ Exception -> 0x0073 }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.lightapp.business.TitleBarParams$d r4 = (com.baidu.wallet.lightapp.business.TitleBarParams.d) r4     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.base.widget.BdActionBar r5 = r3.x     // Catch:{ all -> 0x003d }
            java.lang.String r1 = r4.c     // Catch:{ all -> 0x003d }
            int r1 = android.graphics.Color.parseColor(r1)     // Catch:{ all -> 0x003d }
            r5.setRightImgZone2NotifyTextColor(r1)     // Catch:{ all -> 0x003d }
            goto L_0x004c
        L_0x003d:
            com.baidu.wallet.base.widget.BdActionBar r5 = r3.x     // Catch:{ Exception -> 0x0073 }
            android.content.Context r1 = r3.getContext()     // Catch:{ Exception -> 0x0073 }
            java.lang.String r2 = "wallet_base_click_text2color_selector"
            int r1 = com.baidu.apollon.utils.ResUtils.getColor(r1, r2)     // Catch:{ Exception -> 0x0073 }
            r5.setRightImgZone2NotifyTextColor(r1)     // Catch:{ Exception -> 0x0073 }
        L_0x004c:
            java.lang.String r5 = r4.a     // Catch:{ Exception -> 0x0073 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0073 }
            if (r5 != 0) goto L_0x007d
            java.lang.String r5 = r4.b     // Catch:{ Exception -> 0x0073 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0073 }
            if (r5 != 0) goto L_0x007d
            com.baidu.wallet.base.widget.BdActionBar r5 = r3.x     // Catch:{ Exception -> 0x0073 }
            java.lang.String r1 = r4.a     // Catch:{ Exception -> 0x0073 }
            r5.setRightImgZone2NotifyText(r1)     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.base.widget.BdActionBar r5 = r3.x     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.lightapp.business.LightappBrowseActivity$7 r1 = new com.baidu.wallet.lightapp.business.LightappBrowseActivity$7     // Catch:{ Exception -> 0x0073 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0073 }
            r5.setRightImgZone2NotifyClickListener(r1)     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.base.widget.BdActionBar r4 = r3.x     // Catch:{ Exception -> 0x0073 }
            r4.setRightImgZone2Visibility(r0)     // Catch:{ Exception -> 0x0073 }
            goto L_0x007d
        L_0x0073:
            r4 = move-exception
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "LightappBrowseActivityTAG"
            com.baidu.wallet.core.utils.LogUtil.d(r5, r4)
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.business.LightappBrowseActivity.a(boolean, com.baidu.wallet.lightapp.business.TitleBarParams):void");
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        layoutParams.width = (int) (((float) (DisplayUtils.getDisplayWidth(getActivity()) * i2)) / 100.0f);
        this.C.setLayoutParams(layoutParams);
    }

    public static Intent a(Context context, String str, String str2, boolean z2, boolean z3, Double d2, String str3) {
        return a(context, str, str2, z2, z3, d2, str3, (Bundle) null);
    }

    public static Intent a(Context context, String str, String str2, boolean z2, boolean z3, Double d2, String str3, Bundle bundle) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(context, LightappBrowseActivity.class);
        intent.putExtra("jump_url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        intent.putExtra("with_anim", z2);
        intent.putExtra("shwoshare", z3);
        if (!(d2 == null || d2.doubleValue() == -0.0d)) {
            intent.putExtra(Constants.HALF_LIGHTBRIDGE_HEIGHT, d2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra(Constants.HALF_LIGHTBRIDGE_TRANSLUCENCY_COLOR, str3);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (context instanceof Activity) {
            LogUtil.d("LightappBrowseActivityTAG", "context is activity!");
        } else {
            intent.setFlags(268435456);
        }
        return intent;
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(this)).route(this, new RouterRequest().provider("dxmPay").action("enterSetRnAuthResult").data(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, Integer.valueOf(i2)).data("desc", str), (RouterCallback) null);
    }

    private void a(LifeCycleCbName lifeCycleCbName, Bundle bundle) {
        Object[] array = this.g.toArray();
        Activity activity = getActivity();
        switch (AnonymousClass19.a[lifeCycleCbName.ordinal()]) {
            case 1:
                for (int length = array.length - 1; length >= 0; length--) {
                    ((Application.ActivityLifecycleCallbacks) array[length]).onActivityCreated(activity, bundle);
                }
                return;
            case 2:
                for (int length2 = array.length - 1; length2 >= 0; length2--) {
                    ((Application.ActivityLifecycleCallbacks) array[length2]).onActivityStarted(activity);
                }
                return;
            case 3:
                for (int length3 = array.length - 1; length3 >= 0; length3--) {
                    ((Application.ActivityLifecycleCallbacks) array[length3]).onActivityResumed(activity);
                }
                return;
            case 4:
                for (int length4 = array.length - 1; length4 >= 0; length4--) {
                    ((Application.ActivityLifecycleCallbacks) array[length4]).onActivityPaused(activity);
                }
                return;
            case 5:
                for (int length5 = array.length - 1; length5 >= 0; length5--) {
                    ((Application.ActivityLifecycleCallbacks) array[length5]).onActivityStopped(activity);
                }
                return;
            case 6:
                for (int length6 = array.length - 1; length6 >= 0; length6--) {
                    ((Application.ActivityLifecycleCallbacks) array[length6]).onActivitySaveInstanceState(activity, bundle);
                }
                return;
            case 7:
                for (int length7 = array.length - 1; length7 >= 0; length7--) {
                    ((Application.ActivityLifecycleCallbacks) array[length7]).onActivityDestroyed(activity);
                }
                return;
            default:
                return;
        }
    }

    private void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null && !this.g.contains(activityLifecycleCallbacks)) {
            this.g.addElement(activityLifecycleCallbacks);
        }
    }
}
