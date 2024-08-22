package com.baidu.wallet.lightapp.multipage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.net.MailTo;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.m.p.e;
import com.baidu.aiscan.R;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.StringUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.api.BaiduWallet;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.BdHalfActionBar;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.base.widget.dialog.SelectNumberDialog;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.lightapp.ability.b.b;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.lightapp.base.LightappBaseActivity;
import com.baidu.wallet.lightapp.base.LightappJsClient;
import com.baidu.wallet.lightapp.base.LightappWebView;
import com.baidu.wallet.lightapp.base.LightappWebViewCenter;
import com.baidu.wallet.lightapp.base.c;
import com.baidu.wallet.lightapp.base.datamodel.LightAppShareModel;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.LangbridgeBarParams;
import com.baidu.wallet.lightapp.business.LightappBrowseActivity;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.lightapp.business.TitleBarParams;
import com.baidu.wallet.lightapp.business.datamodel.LightAppCommonModel;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.lightapp.business.presenter.ContactInfoPresenter;
import com.baidu.wallet.lightapp.monitor.WhiteScreenMonitor;
import com.baidu.wallet.lightapp.multipage.LangbridgeSettings;
import com.baidu.wallet.lightapp.widget.BdLightAppActionBar;
import com.baidu.wallet.lightapp.widget.LangBridgeMenuDialog;
import com.baidu.wallet.lightapp.widget.NoNetView;
import com.baidu.wallet.paysdk.datamodel.RpaConfig;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.permission.CommonPermissionCallback;
import com.baidu.wallet.utils.ContactUtils;
import com.baidu.wallet.utils.RpaProcessor;
import com.baidu.wallet.utils.StringUtil;
import com.baidu.wallet.utils.URLUtil;
import com.baidu.wallet.utils.ViewUtils;
import com.baidu.wallet.view.RoundLinearLayout;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.google.android.material.badge.BadgeDrawable;
import com.google.common.net.InternetDomainName;
import com.tera.scan.scanner.ocr.OCRTakePhotoActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LangbridgeCell implements a, c, NoNetView.a {
    public static final Pattern T = Pattern.compile("^(https?://|file:///android_asset/).*");
    public static final FrameLayout.LayoutParams s = new FrameLayout.LayoutParams(-1, -1);
    public boolean A = true;
    public int B;
    public JSONArray C;
    public String D;
    public String E;
    public List<String> F;
    public ContactInfoPresenter G;
    public Vector<LoadTimeLine> H;
    public FrameLayout I;
    public WebChromeClient.CustomViewCallback J;
    public FrameLayout K;
    public FrameLayout L;
    public FrameLayout M;
    public FrameLayout N;
    public Intent O = null;
    public int P = -1;
    public String Q = null;
    public boolean R = false;
    public boolean S = false;
    public com.baidu.wallet.lightapp.business.presenter.a U;
    public String V;
    public int W = -1;
    public List X;
    public String Y;
    public CommonPermissionCallback Z;
    public String a;
    public CommonPermissionCallback aa;
    public com.baidu.wallet.lightapp.base.utils.a ab;
    public double ac;

    /* renamed from: ad  reason: collision with root package name */
    public String f3573ad;
    public boolean ae;
    public RelativeLayout af;
    public LinearLayout ag;
    public FrameLayout ah;
    public RoundLinearLayout ai;
    public BdHalfActionBar aj;
    public boolean ak = true;
    public boolean al;
    public boolean am = false;
    public Handler an = new Handler() {
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
                        LangbridgeCell.this.e(rpaSenseStrategy.rpaUrl);
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
                        LangbridgeCell.this.e(rpaSenseStrategy.rpaUrl);
                    } else if (TextUtils.equals(rpaSenseStrategy.action, "2")) {
                        DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_PAGE_PROHIBIT, Arrays.asList(new String[]{rpaSenseStrategy.rpaUrl}));
                    }
                    Message obtain = Message.obtain();
                    obtain.arg1 = message.arg1;
                    obtain.obj = rpaSenseStrategy;
                    obtain.what = 2;
                    LangbridgeCell.this.an.sendMessageDelayed(obtain, (long) (message.arg1 * 1000));
                }
            } else if (i2 == 3) {
                LangbridgeCell.this.an.removeMessages(4);
                Message obtain2 = Message.obtain();
                obtain2.copyFrom(message);
                obtain2.what = 4;
                LangbridgeCell.this.an.sendMessageDelayed(obtain2, 1000);
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
                        LangbridgeCell.this.e(rpaSenseStrategy.rpaUrl);
                    } else if (TextUtils.equals(rpaSenseStrategy.action, "2")) {
                        DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_PAGE_POPUP, Arrays.asList(new String[]{rpaSenseStrategy.rpaUrl}));
                    }
                }
            }
        }
    };
    public LangbridgeBarParams ao = new LangbridgeBarParams();
    public LangbridgeBarParams ap = null;
    public Uri aq;
    public WeakReference<d> b;
    public LightappJsClient c;
    public LightappBusinessClient d;
    public ValueCallback<Uri> e;
    public ValueCallback<Uri[]> f;
    public boolean g = true;
    public boolean h = false;

    /* renamed from: i  reason: collision with root package name */
    public View f3574i;
    public Context j;
    public LangbridgeSlideLayout k;
    public LightappBrowserWebView l;
    public Bundle m = new Bundle();
    public b n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3575o = false;
    public boolean p = false;
    public NoNetView q;
    public View r;
    public View t;
    public WebviewMenu u;
    public a v;
    public BdActionBar w;
    public LinearLayout x;
    public TextView y;
    public boolean z = false;

    public class CustomWebViewClient extends SafeWebView.SafeWebViewClient implements NoProguard {
        public Pattern b = Pattern.compile("\\s*https?://.*");
        public String c;

        public CustomWebViewClient() {
        }

        private boolean a(String str, String str2) {
            return TextUtils.equals(str, str2);
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            super.doUpdateVisitedHistory(webView, str, z);
            LangbridgeCell langbridgeCell = LangbridgeCell.this;
            if (langbridgeCell.g) {
                langbridgeCell.l.clearHistory();
                if (str != null && !str.contains("about:blank")) {
                    LangbridgeCell.this.g = false;
                }
            }
        }

        public void onPageFinished(WebView webView, String str) {
            RpaProcessor.getInstance().uploadRpaPageLoadMills(str, System.currentTimeMillis());
            Vector<LoadTimeLine> vector = LangbridgeCell.this.H;
            if (vector != null) {
                vector.add(new LoadTimeLine(str, "onPageFinished", String.valueOf(System.currentTimeMillis())));
            }
            LangbridgeCell.this.v();
            LangbridgeCell langbridgeCell = LangbridgeCell.this;
            com.baidu.wallet.lightapp.base.a a2 = com.baidu.wallet.lightapp.base.a.a();
            LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
            int unused = langbridgeCell.W = a2.a(langbridgeCell2.j, str, langbridgeCell2.W);
            LangbridgeCell.this.D = str;
            String host = Uri.parse(str).getHost();
            this.c = str;
            if (TextUtils.isEmpty(host)) {
                LangbridgeCell.this.y.setVisibility(8);
            } else {
                LangbridgeCell.this.y.setVisibility(0);
                LangbridgeCell langbridgeCell3 = LangbridgeCell.this;
                langbridgeCell3.y.setText(langbridgeCell3.j.getResources().getString(ResUtils.string(LangbridgeCell.this.j, "wallet_langbridge_url_outer"), new Object[]{host}));
            }
            String title = LangbridgeCell.this.w.getTitle();
            if (title != null && title.equals("")) {
                String title2 = webView.getTitle();
                if (title2 == null || this.b.matcher(title2).matches()) {
                    LangbridgeCell.this.d((String) null);
                } else {
                    LangbridgeCell.this.d(title2);
                }
            }
            if (webView.getProgress() != 100) {
                LangbridgeCell.this.z = true;
            }
            LogUtil.d("LangbridgeCell", "onPageFinished.finishedError:  " + LangbridgeCell.this.z + " url: " + str);
            super.onPageFinished(webView, str);
            LangbridgeCell.this.a(0, SmsLoginView.f.k, str);
            String[] strArr = new String[6];
            strArr[0] = CheckUtils.stripUrlParams(LangbridgeCell.this.D);
            strArr[1] = LangbridgeCell.this.t();
            String str2 = "1";
            strArr[2] = LangbridgeCell.this.z ? str2 : "0";
            if (!LangbridgeCell.this.isPreloaded()) {
                str2 = "0";
            }
            strArr[3] = str2;
            strArr[4] = "";
            strArr[5] = URLUtil.getHost(LangbridgeCell.this.D);
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_END_lOAD, Arrays.asList(strArr));
            if (LangbridgeCell.this.isActiveCell()) {
                if (webView.getProgress() == 100) {
                    WhiteScreenMonitor.a().a((WebView) LangbridgeCell.this.l, WhiteScreenMonitor.PageStates.FINISH);
                }
                LangbridgeCacheManager.getInstance().handleFinishPage(str);
            }
            String str3 = h.a().a(LangbridgeCell.this.getContext()).MW_JSCALL_ONACTIVE;
            if (LangbridgeCell.this.isActiveCell() && !TextUtils.isEmpty(str3)) {
                LangbridgeCell.this.executeJsFunction(str3, (String) null);
            }
            LangbridgeCell langbridgeCell4 = LangbridgeCell.this;
            if (langbridgeCell4.l != null && !langbridgeCell4.g && langbridgeCell4.r() != null && LangbridgeCell.this.r().controlCloseIcon(LangbridgeCell.this.l)) {
                LangbridgeCell.this.y();
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            boolean z;
            RpaConfig targetRpaConfig;
            RpaConfig.RpaSenseStrategy[] rpaSenseStrategyArr;
            String str2 = "1";
            if (RpaProcessor.getInstance().isValid(SdkInitResponse.getInstance().rpa_pages_config) && (targetRpaConfig = RpaProcessor.getInstance().getTargetRpaConfig(SdkInitResponse.getInstance().rpa_pages_config, str)) != null && TextUtils.equals(str2, targetRpaConfig.rpa_type) && (rpaSenseStrategyArr = targetRpaConfig.rpa_sense_strategy) != null && rpaSenseStrategyArr.length > 0) {
                for (RpaConfig.RpaSenseStrategy rpaSenseStrategy : rpaSenseStrategyArr) {
                    if (TextUtils.equals(rpaSenseStrategy.type, "4")) {
                        RpaProcessor.getInstance().storePageStartedMills(str, System.currentTimeMillis());
                    } else if (TextUtils.equals(rpaSenseStrategy.type, str2) || TextUtils.equals(rpaSenseStrategy.type, "2") || TextUtils.equals(rpaSenseStrategy.type, "3")) {
                        LangbridgeCell.this.a("(function() {\n    var originalRequestAnimationFrame = window.requestAnimationFrame;\n    let oldElementStringData;\n    function successFn(ret) {}\n\n    function failFn(argument) {\n    }\n    window.requestAnimationFrame = function(callback) {\n        var elements = document.getElementsByClassName('el-overlay');\n        if (elements.length > 0) {\n            var elementString = elements[0].outerHTML;\n            \n            if (oldElementStringData !== undefined) {//判断多次弹窗逻辑\n              // oldElementStringData 已被赋值\n                if (oldElementStringData != elementString) {\n                    window.BLightApp.invokeBdWalletNative(JSON.stringify(\n                                          {\n                                          \"method_name\": \"rpaPerception\",\n                                          \"msg\": \"popUpReturnFlag\",\n                                          }), 'successFn', 'failFn')\n                    oldElementStringData = elementString;\n                } else {\n                    //弹窗内容无变化\n                }\n            } else {\n              // oldElementStringData 未被赋值\n                window.BLightApp.invokeBdWalletNative(JSON.stringify(\n                                          {\n                                          \"method_name\": \"rpaPerception\",\n                                          \"msg\": \"popUpReturnFlag\",\n                                          }), 'successFn', 'failFn')\n                oldElementStringData = elementString;\n            }\n        }\n        if (window.find('keywordsSearchedByStringName')) {//字符串查找\n            window.BLightApp.invokeBdWalletNative(JSON.stringify(\n                                          {\n                                          \"method_name\": \"rpaPerception\",\n                                          \"msg\": \"keywordsSearchedByStringName\",\n                                          }), 'successFn', 'failFn')\n        }\n        return originalRequestAnimationFrame.apply(this, arguments);\n    };\n    return 0;\n})();\n\nfunction successFn(ret) {}\n\nfunction failFn(argument) {\n}\n\n\nvar observer = new MutationObserver(function(mutations) {\n    mutations.forEach(function(mutation) {\n            window.BLightApp.invokeBdWalletNative(JSON.stringify(\n                                          {\n                                          \"method_name\": \"rpaPerception\",\n                                          \"msg\": \"domTreeChangeReturnFlag\",\n                                          }), 'successFn', 'failFn');\n    });\n});\n\nvar config = { attributes: true, childList: true, subtree: true };\nobserver.observe(document, config);", (String) null, (ValueCallback) new ValueCallback<String>() {
                            /* renamed from: a */
                            public void onReceiveValue(String str) {
                            }
                        });
                    }
                }
            }
            LogUtil.d("onPageStarted", "url = " + str);
            LogUtil.d("onPageStarted", "clear query url = " + URLUtil.clearQuery(str));
            Vector<LoadTimeLine> vector = LangbridgeCell.this.H;
            if (vector != null) {
                vector.add(new LoadTimeLine(str, "onPageStarted", String.valueOf(System.currentTimeMillis())));
            }
            LangbridgeCell.this.E = str;
            if (TextUtils.isEmpty(str) || (!str.contains("isInitTitleBar=0") && !str.contains("isInitTitleBar%3d0"))) {
                LangbridgeCell.this.setFullScreenInMainThread(false, a(str, this.c) && (LangbridgeCell.this.ao != null && LangbridgeCell.this.ao.isHideTitle), false, false, "", "");
            } else if (LangbridgeCell.this.ap != null && !LangbridgeCell.this.ap.equals(LangbridgeCell.this.ao)) {
                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                langbridgeCell.setFullScreenInMainThread(langbridgeCell.ap.isFullScreen, LangbridgeCell.this.ap.isHideTitle, LangbridgeCell.this.ap.isHideHost, LangbridgeCell.this.ap.isIconWhite, StringUtil.getHexColorStr(LangbridgeCell.this.ap.fullScreenActionBarColor), StringUtil.getHexColorStr(LangbridgeCell.this.ap.fullScreenTitleColor));
                LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
                LangbridgeBarParams unused = langbridgeCell2.ap = langbridgeCell2.ao;
            }
            LangbridgeCell.this.D();
            if (!LangbridgeCell.this.isActiveCell() || LangbridgeCacheManager.getInstance().showProgressLine(str)) {
                LangbridgeCell.this.u();
            }
            LangbridgeCell.this.d("");
            LangbridgeCell.this.w.setTitleCenterSafeTipText("");
            LangbridgeCell.this.w.setRightImgZone1Enable(false);
            if (LangbridgeCell.this.w.getRightZone1View().getVisibility() == 0) {
                LangbridgeCell.this.w.setRightImgZone1Visibility(8);
                LangbridgeCell.this.w.hideBubble(false);
            }
            if (LangbridgeCell.this.w.getRightImgZone2NotifyView().getVisibility() == 0) {
                LangbridgeCell.this.w.setRightImgZone2Visibility(0);
                ViewUtils.visibleView(LangbridgeCell.this.w.getRightImgZone2ImgView());
                LangbridgeCell.this.w.setRightImgZone2NotifyVisibility(8);
            }
            LangbridgeCell.this.w.showLeftZone();
            LangbridgeCell langbridgeCell3 = LangbridgeCell.this;
            langbridgeCell3.v = null;
            LightappBusinessClient lightappBusinessClient = langbridgeCell3.d;
            if (lightappBusinessClient != null) {
                lightappBusinessClient.setH5BackCb((ILightappInvokerCallback) null);
            }
            LangbridgeCell langbridgeCell4 = LangbridgeCell.this;
            langbridgeCell4.a = null;
            langbridgeCell4.c.setUrlLocal(str);
            super.onPageStarted(webView, str, bitmap);
            LightappUtils.insertAppSessionIdJs(LangbridgeCell.this.l);
            String[] strArr = new String[7];
            strArr[0] = URLUtil.clearQuery(LangbridgeCell.this.D);
            strArr[1] = LangbridgeCell.this.t();
            if (!LangbridgeCell.this.isPreloaded()) {
                str2 = "0";
            }
            strArr[2] = str2;
            strArr[3] = "";
            strArr[4] = "";
            strArr[5] = URLUtil.getHost(LangbridgeCell.this.D);
            strArr[6] = URLUtil.wholeUrl(LangbridgeCell.this.D);
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_BEGIN_LOAD, Arrays.asList(strArr));
            if (LangbridgeCell.this.isActiveCell()) {
                WhiteScreenMonitor.a().a((WebView) LangbridgeCell.this.l, WhiteScreenMonitor.PageStates.START);
                LangbridgePreloadCellCenter.getInstance(LangbridgeCell.this.getContext()).setAllCellsEnable(false);
                LangbridgeCacheManager.getInstance().handleStartPage(str);
                z = LangbridgeCacheManager.getInstance().isOfflineCacheReady(str);
            } else {
                z = false;
            }
            if (!NetworkUtils.isNetworkAvailable(LangbridgeCell.this.j) && !z) {
                LangbridgeCell.this.c(str);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_SHOW_ERROR, Arrays.asList(new String[]{CheckUtils.stripUrlParams(str)}));
            }
            if (!a(str, this.c)) {
                c.a(LangbridgeCell.this.getActivity());
            }
            if (LangbridgeCell.this.ab != null) {
                LangbridgeCell.this.ab.a(str);
            }
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            String str;
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
            linkedHashMap.put(LightAppStatEvent.PAGE_URL, LangbridgeCell.this.E);
            linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LangbridgeCell.this.E).toString());
            Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, (Map<String, String>) linkedHashMap, LangbridgeCell.this.getContext());
            if (webResourceError != null && webResourceRequest != null && -10 != webResourceError.getErrorCode() && webResourceRequest.isForMainFrame()) {
                LangbridgeCell.this.z = true;
                if (-1 != webResourceError.getErrorCode() || LangbridgeCell.this.X == null || !LangbridgeCell.this.X.contains(String.valueOf(webResourceRequest.getUrl()))) {
                    NoNetView noNetView = LangbridgeCell.this.q;
                    if (noNetView != null) {
                        noNetView.setFailureCause(webResourceError.getErrorCode(), false);
                    }
                    LangbridgeCell.this.c(webResourceRequest.getUrl().toString());
                } else {
                    LangbridgeCell.this.X.remove(String.valueOf(webResourceRequest.getUrl()));
                }
                LightappWebViewCenter.getInstance().startAutoChecker();
                LangbridgeCell.this.a(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), webResourceRequest.getUrl().toString());
                LogUtil.d("LangbridgeCell", "onReceivedError2.showErrorPage，getErrorCode：" + webResourceError.getErrorCode());
                String[] strArr = new String[4];
                strArr[0] = String.valueOf(webResourceError.getErrorCode());
                strArr[1] = String.valueOf(webResourceRequest.getUrl());
                LightappBrowserWebView b2 = LangbridgeCell.this.b();
                String str2 = com.baidu.android.common.others.lang.StringUtil.NULL_STRING;
                if (b2 == null) {
                    str = str2;
                } else {
                    str = LangbridgeCell.this.b().hashCode() + "";
                }
                strArr[2] = str;
                if (LangbridgeCell.this.c != null) {
                    str2 = LangbridgeCell.this.c.hashCode() + "";
                }
                strArr[3] = str2;
                DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(strArr));
            }
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (Build.VERSION.SDK_INT >= 21) {
                String mimeType = webResourceResponse.getMimeType();
                int statusCode = webResourceResponse.getStatusCode();
                String uri = webResourceRequest.getUrl().toString();
                if (mimeType.contains(SapiWebView.DATA_MIME_TYPE) && 400 <= statusCode && statusCode < 600 && !uri.contains("favicon.ico")) {
                    LightappWebViewCenter.getInstance().startAutoChecker();
                    LangbridgeCell.this.a(statusCode, webResourceResponse.getReasonPhrase(), uri);
                    LogUtil.d("LangbridgeCell", "onReceivedHttpError2,callback");
                }
            }
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
                    linkedHashMap.put(LightAppStatEvent.PAGE_URL, LangbridgeCell.this.E);
                }
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LangbridgeCell.this.E).toString());
                Tracker.send(LightAppStatEvent.WEB_VIEW_HTTP_ERROR, (Map<String, String>) linkedHashMap, LangbridgeCell.this.getContext());
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (sslError != null) {
                linkedHashMap.put("errorCode", String.valueOf(sslError.getPrimaryError()));
                linkedHashMap.put("url", sslError.getUrl());
                linkedHashMap.put(OCRTakePhotoActivity.ROUTER_INIT_TAB_CERTIFICATE, String.valueOf(sslError.getCertificate()));
                linkedHashMap.put(LightAppStatEvent.PAGE_URL, LangbridgeCell.this.E);
            }
            linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LangbridgeCell.this.E).toString());
            Tracker.send(LightAppStatEvent.WEB_VIEW_SSL_ERROR, (Map<String, String>) linkedHashMap, LangbridgeCell.this.getContext());
            int primaryError = sslError == null ? NoNetView.ERROR_SSL_GENERAL : sslError.getPrimaryError();
            if (sslError == null) {
                str = null;
            } else {
                str = sslError.getUrl();
            }
            LogUtil.d("LangbridgeCell", "onReceivedSslError，：" + sslError + ",getPrimaryError:" + sslError.getPrimaryError() + " ,interceptSSLError:" + LangbridgeCell.this.A);
            LangbridgeCell langbridgeCell = LangbridgeCell.this;
            if (!langbridgeCell.A) {
                sslErrorHandler.proceed();
                LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
                langbridgeCell2.z = false;
                if (langbridgeCell2.B == 100) {
                    langbridgeCell2.A = true;
                    return;
                }
                return;
            }
            langbridgeCell.z = true;
            NoNetView noNetView = langbridgeCell.q;
            if (noNetView != null) {
                noNetView.setFailureCause(primaryError, true);
            }
            LangbridgeCell.this.c(str);
            LightappWebViewCenter.getInstance().startAutoChecker();
            LangbridgeCell.this.a(primaryError, sslError.getCertificate().toString(), sslError.getUrl());
            DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(new String[]{primaryError + "", str}));
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            LogUtil.d("LangbridgeCell", "onRenderProcessGone WebView 出现Crash");
            try {
                if (LangbridgeCell.this.l != null && webView == LangbridgeCell.this.l) {
                    if (!renderProcessGoneDetail.didCrash()) {
                        LogUtil.d("LangbridgeCell", "WebView 出现OOM了，手动GC");
                        System.gc();
                    }
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_WEBVIEW_SHOW_ERROR, Arrays.asList(new String[]{"onRenderProcessGone2", LangbridgeCell.this.D, "" + renderProcessGoneDetail.didCrash()}));
                    return true;
                }
            } catch (Exception e) {
                LogUtil.d("LangbridgeCell", "onRenderProcessGone 异常：" + e.getMessage());
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (LangbridgeCell.this.isActiveCell() && LangbridgeCell.this.h) {
                LangbridgeCacheManager.getInstance().handleLoadUrl(LangbridgeCell.this.r().getLangbridgeHash(), webResourceRequest.getUrl().toString());
                LangbridgeCell.this.h = false;
            }
            if (LangbridgeCell.this.isActiveCell()) {
                return LangbridgeCacheManager.getInstance().interceptRequest(webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
            }
            return null;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            LogUtil.d("LangbridgeCell", "OriginalUrl : " + webView.getOriginalUrl());
            LogUtil.d("LangbridgeCell", "shouldOverrideUrlLoading url = " + str);
            if (str.startsWith("tel:")) {
                try {
                    LangbridgeCell.this.a(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (str.startsWith(MailTo.MAILTO_SCHEME)) {
                try {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{str.replace(MailTo.MAILTO_SCHEME, "")});
                    LangbridgeCell.this.a(intent);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    GlobalUtils.toast(LangbridgeCell.this.j, "请先配置邮箱");
                }
            } else if (str.toLowerCase(Locale.CHINA).startsWith("http") || str.toLowerCase(Locale.CHINA).startsWith("https") || str.toLowerCase(Locale.CHINA).startsWith("file")) {
                if (webView.getOriginalUrl() != null && !webView.getOriginalUrl().equals("about:blank") && h.a().a(LangbridgeCell.this.j).MW_ON && !h.a().a(LangbridgeCell.this.j).MW_USE_OLD && h.a().a(LangbridgeCell.this.j).MW_HOLDLINK_ON && h.a().a(LangbridgeCell.this.j).MW_MULTI_ON && LangbridgeCell.this.isActiveCell()) {
                    LangbridgePreloadCellCenter.getInstance(LangbridgeCell.this.getContext());
                    if (LangbridgePreloadCellCenter.needNewWebviewOpen(str)) {
                        LangbridgeCell.this.r().createLangbridgeCell(str, false, false, "");
                        DXMSdkSAUtils.onEventWithValues("#linkHoldPreloadPage", Arrays.asList(new String[]{str}));
                        return true;
                    }
                }
                return super.shouldOverrideUrlLoading(webView, str);
            } else {
                try {
                    Intent parseUri = Intent.parseUri(str, 1);
                    parseUri.addCategory("android.intent.category.BROWSABLE");
                    parseUri.setComponent((ComponentName) null);
                    if (Build.VERSION.SDK_INT >= 15) {
                        parseUri.setSelector((Intent) null);
                    }
                    LangbridgeCell.this.a(parseUri);
                    return true;
                } catch (Exception e3) {
                    com.baidu.apollon.utils.LogUtil.d("LangbridgeCell", e3.getMessage());
                }
            }
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
            String str3;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("errorCode", String.valueOf(i2));
            linkedHashMap.put("url", str2);
            linkedHashMap.put("reasonPhrase", str);
            linkedHashMap.put(LightAppStatEvent.PAGE_URL, LangbridgeCell.this.E);
            linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LangbridgeCell.this.E).toString());
            Tracker.send(LightAppStatEvent.WEB_VIEW_ERROR, (Map<String, String>) linkedHashMap, LangbridgeCell.this.getContext());
            if (-10 != i2) {
                LogUtil.d("LangbridgeCell", "onReceivedError1.errorCode：" + i2);
                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                langbridgeCell.z = true;
                NoNetView noNetView = langbridgeCell.q;
                if (noNetView != null) {
                    noNetView.setFailureCause(i2, false);
                }
                LangbridgeCell.this.c(str2);
                LightappWebViewCenter.getInstance().startAutoChecker();
                LangbridgeCell.this.a(i2, str, str2);
                String[] strArr = new String[4];
                strArr[0] = i2 + "";
                strArr[1] = str2;
                if (LangbridgeCell.this.b() == null) {
                    str3 = com.baidu.android.common.others.lang.StringUtil.NULL_STRING;
                } else {
                    str3 = LangbridgeCell.this.b().hashCode() + "";
                }
                strArr[2] = str3;
                strArr[3] = LangbridgeCell.this.c.hashCode() + "";
                DXMSdkSAUtils.onEventWithValues("#LightApp_Load_Failed", Arrays.asList(strArr));
                LogUtil.d("LangbridgeCell", "onReceivedError1.showErrorPage");
                super.onReceivedError(webView, i2, str, str2);
            }
        }
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
            if (LangbridgeCell.this.m.getBoolean("lang_showshare", false)) {
                add(32, (CharSequence) ResUtils.getString(context, "wallet_lightapp_share"), ResUtils.getDrawable(context, "wallet_langbrige_icon_share"));
            }
            add(34, (CharSequence) ResUtils.getString(context, "wallet_lightapp_close"), ResUtils.getDrawable(context, "wallet_langbrige_icon_close"));
            layoutMenu();
        }
    }

    public class a extends LangBridgeMenuDialog implements NoProguard {

        /* renamed from: com.baidu.wallet.lightapp.multipage.LangbridgeCell$a$a  reason: collision with other inner class name */
        public class C0158a {
            public String a;
            public String b;
            public String c;

            public C0158a() {
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
                                    C0158a aVar = new C0158a();
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
                C0158a aVar2 = (C0158a) arrayList.get(i3);
                add(i3 + 256, (CharSequence) aVar2.a, aVar2.b);
            }
            add((int) InternetDomainName.MAX_LENGTH, (CharSequence) ResUtils.getString(context, "wallet_lightapp_refresh"), ResUtils.getDrawable(context, "wallet_langbrige_icon_refresh"));
            if (LangbridgeCell.this.m.getBoolean("lang_showshare", false)) {
                add(254, (CharSequence) ResUtils.getString(context, "wallet_lightapp_share"), ResUtils.getDrawable(context, "wallet_langbrige_icon_share"));
            }
            add(255, (CharSequence) ResUtils.getString(context, "wallet_lightapp_close"), ResUtils.getDrawable(context, "wallet_langbrige_icon_close"));
            setMenuItemClickListener(new BdMenuItem.OnItemClickListener(LangbridgeCell.this) {
                public void onClick(BdMenuItem bdMenuItem) {
                    int itemId = bdMenuItem.getItemId();
                    if (255 == itemId) {
                        if (LangbridgeCell.this.isActiveCell()) {
                            LangbridgeCell.this.F();
                        }
                    } else if (254 == itemId) {
                        DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(new String[]{CheckUtils.stripUrlParams(LangbridgeCell.this.D)}));
                        LightappBrowseActivity.ShareCallbackImpl shareCallbackImpl = new LightappBrowseActivity.ShareCallbackImpl();
                        shareCallbackImpl.addStatics(LangbridgeCell.this.D);
                        LightAppWrapper.getInstance().callShare(LangbridgeCell.this.getActivity(), new LightAppShareModel(LangbridgeCell.this.l.getTitle(), LangbridgeCell.this.l.getTitle(), LangbridgeCell.this.l.getUrl(), (String) null), shareCallbackImpl);
                    } else if (253 == itemId) {
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(new String[]{CheckUtils.stripUrlParams(LangbridgeCell.this.D)}));
                        if (LangbridgeCell.this.isActiveCell()) {
                            LangbridgeCacheManager.getInstance().onLangbridgeRefresh(LangbridgeCell.this.getActivity(), LangbridgeCell.this.D);
                        }
                        LangbridgeCell.this.l.reload();
                        LangbridgeCell langbridgeCell = LangbridgeCell.this;
                        langbridgeCell.D = langbridgeCell.l.getUrl();
                        LangbridgeCell.this.z = false;
                    } else {
                        int i2 = itemId + InputDeviceCompat.SOURCE_ANY;
                        if (i2 <= size) {
                            LangbridgeCell.this.executeJsFunction(((C0158a) arrayList.get(i2)).c, "");
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
            LogUtil.i("LangbridgeCell", "onTouchEvent " + motionEvent.getAction());
            return true;
        }
    }

    public LangbridgeCell(Context context, LightappBrowserWebView lightappBrowserWebView, String str, String str2) {
        this.j = DxmApplicationContextImpl.getApplicationContext(context);
        this.l = lightappBrowserWebView;
        this.V = str;
        if (LangbridgePreloadCellCenter.PRELOAD_POOL_TAG_FROM_NA.equals(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append((toString() + System.currentTimeMillis()).hashCode());
            sb.append("");
            this.Y = sb.toString();
            LogUtil.i("LangbridgeCell", "cellHashStamp form myself " + this.Y);
        } else {
            this.Y = str2;
            LogUtil.i("LangbridgeCell", "cellHashStamp form outer " + this.Y);
        }
        m();
    }

    private void A() {
        LogUtil.d("LangbridgeCell", "isHalfLightBridge：" + this.ae);
        if (this.ae) {
            a(this.ac, this.f3573ad, 0, false);
        } else {
            RoundLinearLayout roundLinearLayout = this.ai;
            if (roundLinearLayout != null) {
                roundLinearLayout.setRoundPath(RoundLinearLayout.RECT_RADII);
            }
            RelativeLayout relativeLayout = this.af;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.wallet_base_whiteColor));
            }
        }
        LangbridgeSlideLayout langbridgeSlideLayout = this.k;
        if (langbridgeSlideLayout != null) {
            langbridgeSlideLayout.setPullRefreshEnabled(!this.ae);
        }
        NoNetView noNetView = this.q;
        if (noNetView != null) {
            if (this.ae) {
                noNetView.setBackground(R.drawable.wallet_base_top_round_white);
            } else {
                noNetView.setBackground(R.color.bd_wallet_white);
            }
        }
        ViewUtils.setVisibility(this.aj, this.ae);
        ViewUtils.setVisibility(this.x, !this.ae);
        ViewUtils.setVisibility(this.ag, !this.ae);
        ViewUtils.setVisibility(this.M, !this.ae);
        ViewUtils.setVisibility(this.K, !this.ae);
        if (this.ae) {
            ViewUtils.setVisibility(this.w, false);
        } else if (!this.ak) {
            ViewUtils.setVisibility(this.w, false);
        } else {
            ViewUtils.setVisibility(this.w, true);
        }
    }

    /* access modifiers changed from: private */
    public void B() {
        NoNetView noNetView = this.q;
        if (noNetView != null) {
            noNetView.notifyUrlFinish();
        }
        LightappBrowserWebView lightappBrowserWebView = this.l;
        if (lightappBrowserWebView != null) {
            lightappBrowserWebView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void C() {
        BdActionBar bdActionBar = this.w;
        if (bdActionBar != null) {
            if (this.ao.isHideTitle) {
                bdActionBar.setTitleTextColorAlpha(0);
            } else {
                bdActionBar.setTitleTextColorAlpha(255);
            }
        }
    }

    /* access modifiers changed from: private */
    public void D() {
        a((Runnable) new Runnable() {
            public void run() {
                LangbridgeCell.this.l.setOnMyScrollChangeListener(new LightappWebView.a() {
                    public void a(int i2) {
                        if (!LangbridgeCell.this.al) {
                            LangbridgeCell.this.w.hideBubble(true);
                        }
                        if (LangbridgeCell.this.ao.isFullScreen) {
                            int height = LangbridgeCell.this.w.getHeight();
                            float f = ((float) (height - i2)) / ((float) height);
                            if (f > 0.0f) {
                                if (LangbridgeCell.this.ao.fullScreenTitleColor != 0) {
                                    LangbridgeCell langbridgeCell = LangbridgeCell.this;
                                    langbridgeCell.w.setFullScreenTextColor(langbridgeCell.ao.fullScreenTitleColor);
                                }
                                float f2 = 1.0f - f;
                                int i3 = (int) (255.0f * f2);
                                if (LangbridgeCell.this.ao.isHideTitle) {
                                    if (i3 >= 255) {
                                        LangbridgeCell.this.w.setTitleTextColorAlpha(i3);
                                    } else {
                                        LangbridgeCell.this.w.setTitleTextColorAlpha(0);
                                    }
                                }
                                if (LangbridgeCell.this.ao.isIconWhite) {
                                    LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
                                    langbridgeCell2.w.setIconFlag(true, langbridgeCell2.ao.isIconIsolate);
                                }
                                if (LangbridgeCell.this.ao.fullScreenActionBarColor != -1) {
                                    LangbridgeCell langbridgeCell3 = LangbridgeCell.this;
                                    langbridgeCell3.w.setTitlebgColor(LangbridgeCell.a(f2, langbridgeCell3.ao.fullScreenActionBarColor, ResUtils.getColor(LangbridgeCell.this.j, "wallet_extend_color_actionbar_bg")));
                                    return;
                                }
                                return;
                            }
                            if (LangbridgeCell.this.ao.isHideTitle) {
                                LangbridgeCell.this.w.setTitleTextColorAlpha(255);
                            }
                            if (LangbridgeCell.this.ao.isIconWhite) {
                                LangbridgeCell langbridgeCell4 = LangbridgeCell.this;
                                langbridgeCell4.w.setIconFlag(false, langbridgeCell4.ao.isIconIsolate);
                            }
                            LangbridgeCell langbridgeCell5 = LangbridgeCell.this;
                            langbridgeCell5.w.setTitlebgColor(ResUtils.getColor(langbridgeCell5.j, "wallet_extend_color_actionbar_bg"));
                            LangbridgeCell.this.w.resetFullScreenTextColor();
                            return;
                        }
                        int height2 = LangbridgeCell.this.w.getHeight();
                        float f3 = ((float) (height2 - i2)) / ((float) height2);
                        if (f3 > 0.0f) {
                            int i4 = (int) ((1.0f - f3) * 255.0f);
                            if (!LangbridgeCell.this.ao.isHideTitle) {
                                return;
                            }
                            if (i4 >= 255) {
                                LangbridgeCell.this.w.setTitleTextColorAlpha(i4);
                            } else {
                                LangbridgeCell.this.w.setTitleTextColorAlpha(0);
                            }
                        } else if (LangbridgeCell.this.ao.isHideTitle) {
                            LangbridgeCell.this.w.setTitleTextColorAlpha(255);
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void E() {
        LogUtil.i("LangbridgeCell", "hideCustomView");
        if (this.r != null && getActivity() != null && this.J != null) {
            e(true);
            ((FrameLayout) getActivity().getWindow().getDecorView()).removeView(this.I);
            this.I = null;
            this.r = null;
            this.J.onCustomViewHidden();
            if (getActivity().getApplicationInfo().targetSdkVersion < 26 || Build.VERSION.SDK_INT != 26) {
                getActivity().setRequestedOrientation(1);
            }
            DXMSdkSAUtils.onEventWithValues("#webviewVedioNotFullScreen", Arrays.asList(new String[]{this.D}));
        }
    }

    /* access modifiers changed from: private */
    public void F() {
        LightappBusinessClient lightappBusinessClient = this.d;
        ILightappInvokerCallback h5Close = lightappBusinessClient != null ? lightappBusinessClient.getH5Close() : null;
        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE, Arrays.asList(new String[]{CheckUtils.stripUrlParams(this.D), t()}));
        if (h5Close != null) {
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_BD_WALLET_PAGE_CLOSE, Arrays.asList(new String[]{CheckUtils.stripUrlParams(this.D), t()}));
            executeJsFunction(LightappBusinessClient.MTD_H5ClOSE, (String) null);
            return;
        }
        r().setRnAuthResult(2, "实名认证取消");
        r().closeWindow();
    }

    private void x() {
        WebviewMenu webviewMenu = new WebviewMenu(q());
        this.u = webviewMenu;
        webviewMenu.setMenuItemClickListener(new BdMenuItem.OnItemClickListener() {
            public void onClick(BdMenuItem bdMenuItem) {
                switch (bdMenuItem.getItemId()) {
                    case 32:
                        DXMSdkSAUtils.onEventWithValues("#callShare", Arrays.asList(new String[]{CheckUtils.stripUrlParams(LangbridgeCell.this.D)}));
                        LightappBrowseActivity.ShareCallbackImpl shareCallbackImpl = new LightappBrowseActivity.ShareCallbackImpl();
                        shareCallbackImpl.addStatics(LangbridgeCell.this.D);
                        LightAppWrapper.getInstance().callShare(LangbridgeCell.this.getActivity(), new LightAppShareModel(LangbridgeCell.this.l.getTitle(), LangbridgeCell.this.l.getTitle(), LangbridgeCell.this.l.getUrl(), (String) null), shareCallbackImpl);
                        return;
                    case 33:
                        LightappBusinessClient lightappBusinessClient = LangbridgeCell.this.d;
                        ILightappInvokerCallback h5Refresh = lightappBusinessClient != null ? lightappBusinessClient.getH5Refresh() : null;
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_REFRESH, Arrays.asList(new String[]{CheckUtils.stripUrlParams(LangbridgeCell.this.D)}));
                        if (h5Refresh != null) {
                            LangbridgeCell.this.executeJsFunction(LightappBusinessClient.MTD_H5REFRESH, (String) null);
                            return;
                        }
                        if (LangbridgeCell.this.isActiveCell()) {
                            LangbridgeCacheManager.getInstance().onLangbridgeRefresh(LangbridgeCell.this.getActivity(), LangbridgeCell.this.D);
                        }
                        LangbridgeCell.this.l.reload();
                        LangbridgeCell.this.z = false;
                        return;
                    case 34:
                        if (LangbridgeCell.this.isActiveCell()) {
                            LangbridgeCell.this.F();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void y() {
        if (!"baiduapp".equals(BeanConstants.CHANNEL_ID) && this.w.setCloseButtonVisibility(0) != 0) {
            this.w.setCloseOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (LangbridgeCell.this.isActiveCell()) {
                        GlobalUtils.hideKeyboard(LangbridgeCell.this.r().getControllerActivity());
                        LangbridgeCell.this.F();
                    }
                }
            });
        }
    }

    private void z() {
        this.ac = this.m.getDouble(Constants.HALF_LIGHTBRIDGE_HEIGHT, -0.0d);
        this.f3573ad = this.m.getString(Constants.HALF_LIGHTBRIDGE_TRANSLUCENCY_COLOR);
        this.ae = this.ac != -0.0d;
    }

    public void checkClodDown(String str, List<String> list, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            LangbridgeSettings.ConsoleMsgBehaviour[] consoleMsgBehaviourArr = h.a().a(getContext()).MW_CONSOLE_MESSAGE_BEHAVAIOUR;
            int i2 = 0;
            while (consoleMsgBehaviourArr != null && i2 < consoleMsgBehaviourArr.length) {
                if (consoleMsgBehaviourArr[i2] != null && str.equals(consoleMsgBehaviourArr[i2].mConsoleString)) {
                    String[] strArr = new String[2];
                    String str3 = "1";
                    strArr[0] = h.a().b(getContext()).MW_ON ? str3 : "0";
                    if (!h.a().b(getContext()).MW_USE_OLD) {
                        str3 = "0";
                    }
                    strArr[1] = str3;
                    ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
                    arrayList.addAll(list);
                    try {
                        int parseInt = !TextUtils.isEmpty(consoleMsgBehaviourArr[i2].mScore) ? Integer.parseInt(consoleMsgBehaviourArr[i2].mScore) : 0;
                        e a2 = e.a();
                        Context context = getContext();
                        if (parseInt < 0) {
                            parseInt = 0;
                        }
                        a2.a(context, parseInt, str2, arrayList);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        e.a().a(getContext(), 0, str2, arrayList);
                    }
                }
                i2++;
            }
        }
    }

    public void closeTopWebview() {
        a((Runnable) new Runnable() {
            public void run() {
                if (LangbridgeCell.this.isActiveCell()) {
                    LangbridgeCell.this.r().closeTopWebview();
                }
            }
        });
    }

    public void closeWindow() {
        if (isActiveCell()) {
            r().closeWindow();
        }
    }

    public void customNaviBar(final TitleBarParams titleBarParams) {
        LightappUtils.runOnUiThread(new Runnable() {
            public void run() {
                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                if (langbridgeCell.w != null && titleBarParams != null) {
                    langbridgeCell.d(true);
                    TitleBarParams.c cVar = titleBarParams.leftParams;
                    if (cVar != null) {
                        LangbridgeCell.this.d(cVar.a());
                    }
                    LangbridgeCell.this.c(false);
                    TitleBarParams.a aVar = titleBarParams.barParams;
                    if (aVar != null) {
                        LangbridgeCell.this.c(aVar.a());
                    }
                    LangbridgeCell.this.a(titleBarParams.showMoreDefault(), titleBarParams);
                }
            }
        });
    }

    public void doNetworkTomography(String str, Map<String, String> map) {
        com.baidu.wallet.lightapp.ability.b.b.a().a(str, new b.a() {
            public boolean a = false;

            public void a(int i2) {
                if (!this.a) {
                    WalletGlobalUtils.showLoadingDialog(LangbridgeCell.this.getActivity());
                    this.a = true;
                }
            }

            public void a(String str) {
                WalletGlobalUtils.DismissLoadingDialog();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.optBoolean("isOnline", true)) {
                        GlobalUtils.toast(LangbridgeCell.this.getContext(), ResUtils.getString(LangbridgeCell.this.getActivity(), "network_no_connected"));
                    } else if (!jSONObject.optBoolean("isInternetConnected", true)) {
                        GlobalUtils.toast(LangbridgeCell.this.getContext(), ResUtils.getString(LangbridgeCell.this.getActivity(), "network_no_internet_connected"));
                    } else {
                        GlobalUtils.toast(LangbridgeCell.this.getContext(), ResUtils.getString(LangbridgeCell.this.getActivity(), "network_tomography_done"));
                    }
                } catch (JSONException unused) {
                }
            }
        }, getContext(), map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String exeSSCommand(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            java.lang.String r1 = ""
            r0.<init>(r1)
            java.lang.String r2 = r6.p()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r3 = "+"
            if (r2 != 0) goto L_0x0036
            java.lang.String r2 = r6.p()
            java.lang.String r4 = "PRELOAD"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0036
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r6.p()
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            goto L_0x0050
        L_0x0036:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r6.toString()
            int r4 = r4.hashCode()
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
        L_0x0050:
            java.lang.String r2 = r6.D
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 != 0) goto L_0x0065
            java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0061 }
            java.lang.String r4 = r6.D     // Catch:{ MalformedURLException -> 0x0061 }
            r2.<init>(r4)     // Catch:{ MalformedURLException -> 0x0061 }
            goto L_0x0066
        L_0x0061:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0065:
            r2 = r3
        L_0x0066:
            if (r2 == 0) goto L_0x009c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r2.getProtocol()
            r4.append(r5)
            java.lang.String r5 = r2.getHost()
            r4.append(r5)
            int r2 = r2.getPort()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            int r2 = r2.hashCode()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            r0.append(r1)
        L_0x009c:
            boolean r1 = com.baidu.wallet.lightapp.multipage.g.a(r7)
            if (r1 != 0) goto L_0x00a3
            return r3
        L_0x00a3:
            com.baidu.wallet.lightapp.multipage.g r1 = com.baidu.wallet.lightapp.multipage.g.a()
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]
            r3 = 0
            r2[r3] = r8
            r8 = 1
            r2[r8] = r9
            r8 = 2
            java.lang.String r9 = r0.toString()
            r2[r8] = r9
            java.lang.String r7 = r1.a((java.lang.String) r7, (java.lang.String[]) r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.multipage.LangbridgeCell.exeSSCommand(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public void executeJsFunction(String str, String str2) {
        if (this.l != null && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder(str);
                sb.append("(\"");
                if (str2 != null) {
                    sb.append(LightappUtils.formatJSONForWebViewCallback(str2));
                }
                sb.append("\")");
                if (Build.VERSION.SDK_INT >= 19) {
                    this.l.evaluateJavascript(sb.toString(), (ValueCallback) null);
                    return;
                }
                LightappBrowserWebView lightappBrowserWebView = this.l;
                lightappBrowserWebView.loadUrl("javascript:" + sb.toString());
            } catch (Throwable unused) {
            }
        }
    }

    public Activity getActivity() {
        if (r() != null) {
            return r().getControllerActivity();
        }
        return null;
    }

    public String getCellHashStamps() {
        return this.Y;
    }

    public Context getContext() {
        return this.j;
    }

    public String getLoadTimeLine() {
        return JsonUtils.toJson(this.H);
    }

    public void historyGo(final int i2) {
        a((Runnable) new Runnable() {
            public void run() {
                if (LangbridgeCell.this.isActiveCell()) {
                    LangbridgeCell.this.r().historyGo(i2);
                }
            }
        });
    }

    public void insertPhoneNumToAddressBook(String str, String str2) {
        ContactUtils.insertPhoneNumToAddressBook(getActivity(), str, str2, 8);
    }

    public boolean isActiveCell() {
        WeakReference<d> weakReference = this.b;
        return (weakReference == null || weakReference.get() == null || ((d) this.b.get()).getControllerActivity() == null || !((d) this.b.get()).isActiveCell(this)) ? false : true;
    }

    public boolean isPreloaded() {
        return this.p;
    }

    public void loadAlubm(String str) {
        if (getActivity() != null) {
            this.U = new com.baidu.wallet.lightapp.business.presenter.a(getActivity(), this.d, str);
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
    }

    public void messageForwarding(Context context, final String str) {
        LogUtil.d("LangbridgeCell", "messageForwarding，content：" + str);
        LightappUtils.runOnUiThread(new Runnable() {
            public void run() {
                LightappBrowserWebView b2;
                try {
                    Activity activity = LangbridgeCell.this.getActivity();
                    Activity o2 = LangbridgeCell.this.o();
                    LogUtil.d("LangbridgeCell", "messageForwarding，currentTopActivity：" + activity + " ,nextTopActivity:" + o2);
                    if ((activity instanceof LangbridgeActivity) && (o2 instanceof LangbridgeActivity)) {
                        c currentCell = ((LangbridgeActivity) o2).getCurrentCell();
                        String acceptMessageFlag = LangbridgeCell.this.d != null ? LangbridgeCell.this.d.getAcceptMessageFlag() : null;
                        if (currentCell != null && acceptMessageFlag != null && (b2 = currentCell.b()) != null) {
                            LightappUtils.executeJsFunction(b2, LightappBusinessClient.MTD_ACCEPT_MESSAGE_FROM_LANGBRIDGE, str);
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_NA_ACCEPT_MESSAGE_FROM_LANG, Arrays.asList(new String[]{CheckUtils.stripUrlParams(b2.getUrl())}));
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    public void onContinueClick(String str) {
        LightappBrowserWebView lightappBrowserWebView = this.l;
        if (lightappBrowserWebView != null) {
            this.A = false;
            this.z = false;
            lightappBrowserWebView.loadUrl(str);
        }
    }

    public void onReloadClick(String str) {
        if (!NetworkUtils.isNetworkAvailable(this.j)) {
            GlobalUtils.toast(q(), ResUtils.getString(this.j, "ebpay_no_network"));
            return;
        }
        LightappBrowserWebView lightappBrowserWebView = this.l;
        if (lightappBrowserWebView != null) {
            lightappBrowserWebView.reload();
            this.z = false;
        }
    }

    public void openInNewWebView(final String str, final String str2) {
        a((Runnable) new Runnable() {
            public void run() {
                if (LangbridgeCell.this.isActiveCell()) {
                    String str = LangbridgeCell.this.D;
                    if (str == null || (str.equals(str) && LangbridgeCell.this.D.equals(str2))) {
                        LightappBrowserWebView lightappBrowserWebView = LangbridgeCell.this.l;
                        if (lightappBrowserWebView != null) {
                            lightappBrowserWebView.reload();
                            LangbridgeCell.this.z = false;
                            return;
                        }
                        return;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        LangbridgeCacheManager.getInstance().handleLoadUrl(LangbridgeCell.this.r().getLangbridgeHash(), str2);
                    } else {
                        LangbridgeCacheManager.getInstance().handleLoadUrl(LangbridgeCell.this.r().getLangbridgeHash(), str);
                    }
                    if (LangbridgeCell.this.r().createLangbridgeCell(str, false, false, str2)) {
                        LangbridgeCell.this.y();
                    }
                }
            }
        });
    }

    public String p() {
        return this.V;
    }

    public void preLoadException(String str) {
        a(1101, str, this.D);
    }

    public void preLoadUrl(final ArrayList<String> arrayList, final int i2) {
        a((Runnable) new Runnable() {
            public void run() {
                if (!LangbridgeCell.this.isActiveCell()) {
                    return;
                }
                if (i2 == -1) {
                    LangbridgePreloadCellCenter.getInstance(LangbridgeCell.this.getContext()).preload(arrayList, LangbridgeCell.this.r().getOwnerTag(), LangbridgeCell.this.r().getLangbridgeStamp());
                } else {
                    LangbridgePreloadCellCenter.getInstance(LangbridgeCell.this.getContext()).preload(arrayList, i2, LangbridgeCell.this.r().getOwnerTag(), LangbridgeCell.this.r().getLangbridgeStamp());
                }
            }
        });
    }

    public Context q() {
        return getActivity() != null ? getActivity() : getContext();
    }

    public d r() {
        WeakReference<d> weakReference = this.b;
        if (weakReference != null) {
            return (d) weakReference.get();
        }
        return null;
    }

    public void rmFromPreloadPool() {
        LangbridgePreloadCellCenter.getInstance(this.j).removeCellByCell(this);
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
                        this.an.sendMessage(obtain);
                    }
                } else if (TextUtils.equals(rpaSenseStrategy.type, "2") && str.contains("domTreeChangeReturnFlag")) {
                    this.an.post(new Runnable() {
                        public void run() {
                            LangbridgeCell.this.a("(function() {\n    var originalRequestAnimationFrame = window.requestAnimationFrame;\n    let oldElementStringData;\n    function successFn(ret) {}\n\n    function failFn(argument) {\n    }\n    window.requestAnimationFrame = function(callback) {\n        var elements = document.getElementsByClassName('el-overlay');\n        if (elements.length > 0) {\n            var elementString = elements[0].outerHTML;\n            \n            if (oldElementStringData !== undefined) {//判断多次弹窗逻辑\n              // oldElementStringData 已被赋值\n                if (oldElementStringData != elementString) {\n                    window.BLightApp.invokeBdWalletNative(JSON.stringify(\n                                          {\n                                          \"method_name\": \"rpaPerception\",\n                                          \"msg\": \"popUpReturnFlag\",\n                                          }), 'successFn', 'failFn')\n                    oldElementStringData = elementString;\n                } else {\n                    //弹窗内容无变化\n                }\n            } else {\n              // oldElementStringData 未被赋值\n                window.BLightApp.invokeBdWalletNative(JSON.stringify(\n                                          {\n                                          \"method_name\": \"rpaPerception\",\n                                          \"msg\": \"popUpReturnFlag\",\n                                          }), 'successFn', 'failFn')\n                oldElementStringData = elementString;\n            }\n        }\n        if (window.find('keywordsSearchedByStringName')) {//字符串查找\n            window.BLightApp.invokeBdWalletNative(JSON.stringify(\n                                          {\n                                          \"method_name\": \"rpaPerception\",\n                                          \"msg\": \"keywordsSearchedByStringName\",\n                                          }), 'successFn', 'failFn')\n        }\n        return originalRequestAnimationFrame.apply(this, arguments);\n    };\n    return 0;\n})();", (String) null, (ValueCallback) new ValueCallback<String>() {
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
                        this.an.sendMessage(obtain2);
                    }
                } else if (TextUtils.equals(rpaSenseStrategy.type, "3")) {
                    if (str.contains("domTreeChangeReturnFlag")) {
                        this.an.removeMessages(2);
                    }
                    int intValue3 = RpaProcessor.getIntValue(rpaSenseStrategy.timeInterval);
                    if (intValue3 > 0) {
                        rpaSenseStrategy.url = str2;
                        rpaSenseStrategy.rpaUrl = targetRpaConfig.rpa_url;
                        Message obtain3 = Message.obtain();
                        obtain3.what = 2;
                        obtain3.arg1 = intValue3;
                        obtain3.obj = rpaSenseStrategy;
                        this.an.sendMessageDelayed(obtain3, (long) (intValue3 * 1000));
                    }
                }
            }
        }
    }

    public boolean s() {
        return r() != null && r().isBottomCell(this);
    }

    public void selectPhoneFromAddressBook() {
        if (isActiveCell()) {
            this.G = new ContactInfoPresenter(getActivity(), this.d);
            ContactManager.getIContactsImpl().pickContactsByPhoneContentType(getActivity(), 4);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("LangBridgeCell is not active");
        arrayList.add("selectPhoneFromAddressBook");
        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, arrayList);
    }

    public JSONObject setFullScreenInMainThread(boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2) {
        final boolean z6 = z5;
        final boolean z7 = z4;
        final boolean z8 = z2;
        final String str3 = str2;
        final String str4 = str;
        final boolean z9 = z3;
        a((Runnable) new Runnable() {
            private void a() {
                LangbridgeCell.this.ao.isFullScreen = z8;
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        LangbridgeCell.this.ao.fullScreenTitleColor = Color.parseColor(str3);
                    } catch (Throwable th2) {
                        LogUtil.d(SapiUtils.KEY_QR_LOGIN_ERROR, th2.toString());
                        LangbridgeCell.this.ao.fullScreenTitleColor = 0;
                    }
                } else {
                    LangbridgeCell.this.ao.fullScreenTitleColor = 0;
                }
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        LangbridgeCell.this.ao.fullScreenActionBarColor = Color.parseColor(str4);
                    } catch (Throwable unused) {
                        LangbridgeCell.this.ao.fullScreenActionBarColor = -1;
                    }
                } else {
                    LangbridgeCell.this.ao.fullScreenActionBarColor = -1;
                }
                LangbridgeCell.this.ao.isHideTitle = z9;
                LangbridgeCell.this.ao.isIconWhite = z6;
                LangbridgeCell.this.ao.isHideHost = z7;
            }

            private void b() {
                if (LangbridgeCell.this.ao.fullScreenTitleColor != 0) {
                    LangbridgeCell langbridgeCell = LangbridgeCell.this;
                    langbridgeCell.w.setFullScreenTextColor(langbridgeCell.ao.fullScreenTitleColor);
                    return;
                }
                LangbridgeCell.this.w.resetFullScreenTextColor();
            }

            private void c() {
                boolean z = false;
                if (LangbridgeCell.this.ao.fullScreenActionBarColor != -1) {
                    LangbridgeCell langbridgeCell = LangbridgeCell.this;
                    langbridgeCell.w.setTitlebgColor(langbridgeCell.ao.fullScreenActionBarColor);
                    LangbridgeCell.this.w.setBottomSeperatorvisible(false);
                    LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
                    if (Color.alpha(langbridgeCell2.ao.fullScreenActionBarColor) != 255) {
                        z = true;
                    }
                    langbridgeCell2.a(z);
                    return;
                }
                LangbridgeCell langbridgeCell3 = LangbridgeCell.this;
                langbridgeCell3.w.setTitlebgColor(ResUtils.getColor(langbridgeCell3.j, "wallet_extend_color_actionbar_bg"));
                LangbridgeCell.this.w.setBottomSeperatorvisible(true);
                LangbridgeCell langbridgeCell4 = LangbridgeCell.this;
                if (Color.alpha(langbridgeCell4.ao.fullScreenActionBarColor) != 255) {
                    z = true;
                }
                langbridgeCell4.a(z);
            }

            private void d() {
                if (LangbridgeCell.this.ao.fullScreenActionBarColor == -1 || (LangbridgeCell.this.ao.fullScreenActionBarColor | -16777216) == -1) {
                    LangbridgeCell langbridgeCell = LangbridgeCell.this;
                    langbridgeCell.x.setBackgroundColor(ResUtils.getColor(langbridgeCell.j, "wallet_base_background1_color_7f"));
                } else {
                    LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
                    langbridgeCell2.x.setBackgroundColor(langbridgeCell2.ao.fullScreenActionBarColor);
                }
                if (LangbridgeCell.this.ao.fullScreenTitleColor != 0) {
                    LangbridgeCell langbridgeCell3 = LangbridgeCell.this;
                    langbridgeCell3.y.setTextColor(langbridgeCell3.ao.fullScreenTitleColor);
                    return;
                }
                LangbridgeCell langbridgeCell4 = LangbridgeCell.this;
                langbridgeCell4.y.setTextColor(ResUtils.getColor(langbridgeCell4.j, "wallet_base_font_text4Color"));
            }

            public void run() {
                a();
                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                langbridgeCell.w.setIconFlag(z6, langbridgeCell.ao.isIconIsolate);
                LangbridgeSlideLayout langbridgeSlideLayout = LangbridgeCell.this.k;
                if (langbridgeSlideLayout != null) {
                    langbridgeSlideLayout.setSupportPullDown(!z7);
                }
                c();
                b();
                LangbridgeCell.this.C();
                d();
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("actionBarHeight", DisplayUtils.px2dip(this.j, (float) this.w.getActionBarHeight()));
            jSONObject.put("statusBarHeight", DisplayUtils.px2dip(this.j, (float) this.w.getStatusBarHeight()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void setHalfLightBridgeStyle(Context context, final Double d2, final String str, final int i2) {
        if (this.ae) {
            LogUtil.d("LangbridgeCell", "setHalfLightBridgeStyle，halfHeight：" + d2 + ",halfColor:" + str + ",visible:" + i2);
            LightappUtils.runOnUiThread(new Runnable() {
                public void run() {
                    LangbridgeCell langbridgeCell = LangbridgeCell.this;
                    Double d2 = d2;
                    langbridgeCell.a(d2 == null ? -0.0d : d2.doubleValue(), str, i2, true);
                }
            });
        }
    }

    public void setIsCheckPermission(boolean z2) {
        this.S = z2;
    }

    public void setMenuInMainThread(final JSONArray jSONArray) {
        this.C = jSONArray;
        a((Runnable) new Runnable() {
            public void run() {
                if (LangbridgeCell.this.w.getRightZoneView() != null) {
                    LangbridgeCell langbridgeCell = LangbridgeCell.this;
                    LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
                    langbridgeCell.v = new a(langbridgeCell2.q(), jSONArray);
                    LangbridgeCell.this.w.setRightImgZone2OnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            LangbridgeCell langbridgeCell = LangbridgeCell.this;
                            a aVar = langbridgeCell.v;
                            if (aVar != null) {
                                aVar.show();
                                return;
                            }
                            WebviewMenu webviewMenu = langbridgeCell.u;
                            if (webviewMenu != null) {
                                webviewMenu.show();
                            }
                        }
                    });
                }
            }
        });
    }

    public void setScreenVertical(boolean z2) {
        this.am = z2;
    }

    public void setSubMenu(String str, String str2, String str3, int i2, String str4, String str5, int i3, int i4) {
        final RelativeLayout relativeLayout = (RelativeLayout) this.w.getRightZone1View();
        final NetImageView netImageView = (NetImageView) this.w.getRightImgZone1ImgView();
        boolean z2 = !TextUtils.isEmpty(str5);
        this.al = z2;
        final String str6 = z2 ? "新样式" : "老样式";
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
        a((Runnable) new Runnable() {
            public void run() {
                if (i7 == 4) {
                    LangbridgeCell.this.w.hideBubble(false);
                } else if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                    netImageView.setEnabled(true);
                    ImageLoader.getInstance(LangbridgeCell.this.j).getBitmap(str7, new ImageLoader.OnGetBitmapListener() {
                        public boolean needCancel(String str, Object obj) {
                            return false;
                        }

                        public void onError(String str, Object obj) {
                            LogUtil.d("bubble", "icon getFail error = " + str);
                        }

                        public void onGetBitmap(String str, Object obj, final Bitmap bitmap) {
                            if (bitmap != null && !TextUtils.isEmpty(str8)) {
                                LightappUtils.runOnUiThread(new Runnable() {
                                    public void run() {
                                        String str;
                                        AnonymousClass22 r0 = AnonymousClass22.this;
                                        LangbridgeCell.this.w.setRightImgZone1Visibility(i7);
                                        AnonymousClass22 r02 = AnonymousClass22.this;
                                        netImageView.setVisibility(i7);
                                        if (!netImageView.isEnabled()) {
                                            LogUtil.d("bubble", "icon getSuccess caller，页面发生其它加载：" + LangbridgeCell.this.D);
                                            return;
                                        }
                                        boolean z = false;
                                        LangbridgeCell.this.w.setRightImgZone1Visibility(0);
                                        int i2 = 1;
                                        LangbridgeCell.this.w.setRightImgZone1Enable(true);
                                        netImageView.setImageDrawable(new BitmapDrawable(bitmap));
                                        LangbridgeCell.this.ao.isIconIsolate = TextUtils.equals("1", str9);
                                        if (!LangbridgeCell.this.ao.isIconWhite || !LangbridgeCell.this.w.isIconWhite() || LangbridgeCell.this.ao.isIconIsolate) {
                                            netImageView.clearColorFilter();
                                        } else {
                                            netImageView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
                                        }
                                        AnonymousClass22 r3 = AnonymousClass22.this;
                                        DXMSdkSAUtils.onShowEvent(StatServiceEvent.EVENT_KEY_SET_SUBMENU_ICON, Arrays.asList(new String[]{str6, LangbridgeCell.this.D}));
                                        netImageView.setVisibility(0);
                                        if (relativeLayout.getVisibility() == 0) {
                                            if (LangbridgeCell.this.al) {
                                                AnonymousClass22 r03 = AnonymousClass22.this;
                                                str = str10;
                                                int i3 = i5;
                                                if (i6 == 4) {
                                                    BdActionBar bdActionBar = LangbridgeCell.this.w;
                                                    if (i3 == 1) {
                                                        z = true;
                                                    }
                                                    bdActionBar.hideBubble(z);
                                                    return;
                                                }
                                                i2 = i3;
                                            } else {
                                                str = str11;
                                            }
                                            LangbridgeCell langbridgeCell = LangbridgeCell.this;
                                            langbridgeCell.w.showBubble(str, i2, langbridgeCell.al, LangbridgeCell.this.D);
                                        }
                                    }
                                });
                            }
                        }
                    }, (Object) null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
                    LangbridgeCell.this.w.setRightImgZone1OnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            LogUtil.d("bubble", "执行js");
                            if (!LangbridgeCell.this.al) {
                                LangbridgeCell.this.w.hideBubble(true);
                            }
                            AnonymousClass22 r5 = AnonymousClass22.this;
                            LangbridgeCell.this.executeJsFunction(str8, (String) null);
                            AnonymousClass22 r2 = AnonymousClass22.this;
                            DXMSdkSAUtils.onClickEvent(StatServiceEvent.EVENT_KEY_SET_SUBMENU_ICON, Arrays.asList(new String[]{str6, LangbridgeCell.this.D}));
                        }
                    });
                    if (LangbridgeCell.this.al) {
                        LangbridgeCell.this.w.setBubbleImageOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                LogUtil.d("bubble", "图片气泡执行js");
                                AnonymousClass22 r4 = AnonymousClass22.this;
                                LangbridgeCell.this.executeJsFunction(str8, (String) null);
                                AnonymousClass22 r0 = AnonymousClass22.this;
                                DXMSdkSAUtils.onClickEvent(StatServiceEvent.EVENT_KEY_SET_SUBMENU_BUBBLE, Arrays.asList(new String[]{str6, LangbridgeCell.this.D}));
                            }
                        });
                    }
                }
            }
        });
    }

    public void setTitlesInMainThread(final String str, final String str2, final boolean z2) {
        a((Runnable) new Runnable() {
            public void run() {
                String str;
                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                if (langbridgeCell.w != null) {
                    String str2 = "";
                    if (!NetworkUtils.isNetworkConnected(langbridgeCell.j)) {
                        LangbridgeCell.this.w.setTitleCenterSafeTipText(str2);
                    } else {
                        if (TextUtils.isEmpty(str)) {
                            if (TextUtils.isEmpty(LangbridgeCell.this.l.getTitle()) || LangbridgeCell.T.matcher(LangbridgeCell.this.l.getTitle()).matches()) {
                                LangbridgeCell.this.a = null;
                                str = str2;
                            } else {
                                str = LangbridgeCell.this.l.getTitle();
                                LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
                                langbridgeCell2.a = langbridgeCell2.l.getTitle();
                            }
                            LogUtil.d("mWebView.getTitle =", LangbridgeCell.this.l.getTitle());
                            LangbridgeCell.this.w.setTitleCenterSafeTipText(str2);
                        } else {
                            str = str;
                            LangbridgeCell.this.a = str;
                            if (!TextUtils.isEmpty(str2)) {
                                String trim = str2.trim();
                                if (!TextUtils.isEmpty(trim)) {
                                    LangbridgeCell.this.w.setTitleCenterSafeTipText(trim);
                                }
                            } else {
                                LangbridgeCell.this.w.setTitleCenterSafeTipText(str2);
                            }
                        }
                        str2 = str;
                    }
                    LangbridgeCell.this.d(str2);
                    int[] titleSizeRange = LangbridgeCell.this.w.getTitleSizeRange();
                    int i2 = titleSizeRange[0];
                    int i3 = titleSizeRange[1];
                    if (z2) {
                        int mainTitleViewWidth = LangbridgeCell.this.w.getMainTitleViewWidth();
                        float f = (float) i2;
                        float stringWidth = StringUtil.getStringWidth(LangbridgeCell.this.w.getTitle(), f);
                        LangbridgeCell.this.w.setTitleEllipsize(TextUtils.TruncateAt.END);
                        float f2 = (float) mainTitleViewWidth;
                        if (stringWidth <= f2) {
                            LangbridgeCell.this.w.setTitleSize(i2);
                            return;
                        }
                        float f3 = f2 / stringWidth;
                        if (1.0f <= f3 || ((float) i3) / f > f3) {
                            LangbridgeCell.this.w.setTitleSize(i3);
                            return;
                        }
                        LangbridgeCell.this.w.setTitleSize(Math.round(f * f3));
                        return;
                    }
                    LangbridgeCell.this.w.setTitleSize(i2);
                }
            }
        });
    }

    public void showTitleFloatView(final boolean z2, final String str) {
        LightappUtils.runOnUiThread(new Runnable() {
            public void run() {
                BdActionBar bdActionBar = LangbridgeCell.this.w;
                if (bdActionBar != null) {
                    bdActionBar.showTitleFloatView(z2, false, str);
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
        a((Runnable) new Runnable() {
            public void run() {
                LangbridgeActivity.startLangbridge(context2, str4, str5, z4, z5, d3, str6);
            }
        });
    }

    public String t() {
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(str);
        Object obj = str;
        if (r() != null) {
            obj = Integer.valueOf(r().getLangbridgeStatus());
        }
        sb.append(obj);
        return sb.toString();
    }

    public void u() {
        this.t.setVisibility(0);
        this.t.setBackgroundColor(ResUtils.getColor(this.j, "ebpay_blue"));
        a(5);
    }

    public void v() {
        this.t.setBackgroundColor(ResUtils.getColor(this.j, "ebpay_transparent"));
    }

    public void d() {
        this.p = false;
        if (!s()) {
            y();
        }
        String str = h.a().a(getContext()).MW_JSCALL_ONACTIVE;
        if (!TextUtils.isEmpty(this.D) && !TextUtils.isEmpty(str)) {
            executeJsFunction(str, (String) null);
        }
        LightappBrowserWebView lightappBrowserWebView = this.l;
        if (lightappBrowserWebView != null && !TextUtils.isEmpty(lightappBrowserWebView.getUrl())) {
            WhiteScreenMonitor.a().a((WebView) this.l, WhiteScreenMonitor.PageStates.ACTIVE);
        }
        BdActionBar bdActionBar = this.w;
        if (bdActionBar != null) {
            bdActionBar.setTopStatusWhite(bdActionBar.isIconWhite());
        }
    }

    public void e() {
        String str = h.a().a(getContext()).MW_JSCALL_ONNEGATIVE;
        if (!TextUtils.isEmpty(this.D) && !TextUtils.isEmpty(str)) {
            executeJsFunction(str, (String) null);
        }
    }

    public void f() {
        this.z = false;
        this.h = true;
    }

    public void g() {
        if (this.S) {
            this.d.checkPermission();
            this.S = false;
        }
        if (this.H != null && !TextUtils.isEmpty(this.D)) {
            this.H.add(new LoadTimeLine(this.D.trim(), "onResume", String.valueOf(System.currentTimeMillis())));
        }
    }

    public void h() {
        if (this.H != null && !TextUtils.isEmpty(this.D)) {
            this.H.add(new LoadTimeLine(this.D.trim(), "onPause", String.valueOf(System.currentTimeMillis())));
        }
        this.W = com.baidu.wallet.lightapp.base.a.a().a(getActivity(), this.D, this.W);
        LightappUtils.runOnUiThread(new Runnable() {
            public void run() {
                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                if (langbridgeCell.w != null && !langbridgeCell.al) {
                    LangbridgeCell.this.w.hideBubble(true);
                }
            }
        });
    }

    public void i() {
        Handler handler = this.an;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        LightappJsClient lightappJsClient = this.c;
        if (lightappJsClient != null) {
            lightappJsClient.destroy();
        }
        this.am = false;
        if (!(this.r == null && this.I == null)) {
            this.I = null;
            this.r = null;
            this.J.onCustomViewHidden();
            this.J = null;
        }
        if (this.l != null) {
            WeakReference<d> weakReference = this.b;
            if (weakReference == null || weakReference.get() == null || ((d) this.b.get()).getControllerActivity() == null) {
                LightappWebViewCenter.getInstance().releaseLightappWebView2Pool((Activity) null, this.l);
            } else {
                LightappWebViewCenter.getInstance().releaseLightappWebView2Pool(((d) this.b.get()).getControllerActivity(), this.l);
            }
            this.k.setTarget((LightappBrowserWebView) null);
        }
        this.p = false;
        com.baidu.wallet.lightapp.base.utils.a aVar = this.ab;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void j() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                LangbridgeCell.this.i();
            }
        }, (long) ResUtils.getInteger(getContext(), "wallet_langbridge_slide_duration"));
    }

    public String k() {
        return this.Y;
    }

    public LangbridgeBarParams l() {
        return this.ao;
    }

    public void m() {
        this.ab = new com.baidu.wallet.lightapp.base.utils.a();
        n();
        a((LightappWebView) this.l);
        this.d = (LightappBusinessClient) this.c.getLightappBusiness();
        z();
        A();
    }

    public void n() {
        View inflate = LayoutInflater.from(this.j).inflate(ResUtils.layout(this.j, "wallet_langbrige_cell"), (ViewGroup) null);
        this.f3574i = inflate;
        LangbridgeSlideLayout langbridgeSlideLayout = (LangbridgeSlideLayout) inflate.findViewById(ResUtils.id(this.j, "bd_langbridge_slide"));
        this.k = langbridgeSlideLayout;
        langbridgeSlideLayout.setTarget(this.l);
        this.M = (FrameLayout) this.f3574i.findViewById(ResUtils.id(this.j, "bd_ab_container"));
        this.N = (FrameLayout) this.f3574i.findViewById(ResUtils.id(this.j, "bd_trans_container"));
        this.K = (FrameLayout) this.f3574i.findViewById(ResUtils.id(this.j, "progress_line_container"));
        this.L = (FrameLayout) this.f3574i.findViewById(ResUtils.id(this.j, "progress_trans_container"));
        View view = new View(this.j);
        this.t = view;
        view.setVisibility(8);
        this.w = b(this.m.getBoolean("lang_longtitle", true));
        this.q = (NoNetView) this.f3574i.findViewById(ResUtils.id(this.j, "nonet_view"));
        a(false);
        x();
        b("");
        this.x = (LinearLayout) this.f3574i.findViewById(ResUtils.id(this.j, "walelt_app_host_background"));
        this.y = (TextView) this.f3574i.findViewById(ResUtils.id(this.j, "walelt_base_light_app_host"));
        this.af = (RelativeLayout) this.f3574i.findViewById(ResUtils.id(this.j, "langbridge_root"));
        this.ah = (FrameLayout) this.f3574i.findViewById(ResUtils.id(this.j, "content_frame_layout"));
        this.ai = (RoundLinearLayout) this.f3574i.findViewById(ResUtils.id(this.j, "round_linear_layout"));
        this.ag = (LinearLayout) this.f3574i.findViewById(ResUtils.id(this.j, "trans_layout"));
        this.aj = (BdHalfActionBar) this.f3574i.findViewById(ResUtils.id(this.j, "rv_half_action_bar"));
    }

    public Activity o() {
        if (r() != null) {
            return r().getNextActivity();
        }
        return null;
    }

    private void f(String str) {
        LightappBrowserWebView lightappBrowserWebView;
        String[] b2 = com.baidu.wallet.lightapp.business.a.b(str);
        LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "CELL add Js Hook groupName = " + str + "\n filesName=" + Arrays.toString(b2));
        if (b2 != null && b2.length > 0) {
            for (String str2 : b2) {
                if (!TextUtils.isEmpty(str2)) {
                    String a2 = com.baidu.wallet.lightapp.business.a.a(str2);
                    LogUtil.d(BeanConstants.WEB_VIEW_CACHE_TAG, "CELL to Add COMMON JSFile = " + a2);
                    if (!TextUtils.isEmpty(a2) && (lightappBrowserWebView = this.l) != null) {
                        lightappBrowserWebView.addJsCode(str2, a2);
                    }
                }
            }
        }
    }

    public boolean c() {
        LogUtil.d("LangbridgeCell", "handleBackPressed ");
        if (this.r == null && this.I == null) {
            BdActionBar bdActionBar = this.w;
            if (bdActionBar != null) {
                bdActionBar.removeTitleFloatView();
            }
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_BACK, Arrays.asList(new String[]{CheckUtils.stripUrlParams(this.D), "" + t()}));
            LightappBusinessClient lightappBusinessClient = this.d;
            if ((lightappBusinessClient != null ? lightappBusinessClient.getH5BackCb() : null) != null) {
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_BD_WALLET_PAGE_BACK, Arrays.asList(new String[]{CheckUtils.stripUrlParams(this.D), "" + t()}));
                executeJsFunction(LightappBusinessClient.MTD_H5GOBCK, (String) null);
                return true;
            }
            LightappBrowserWebView lightappBrowserWebView = this.l;
            if (lightappBrowserWebView == null || !lightappBrowserWebView.canGoBack()) {
                return false;
            }
            LogUtil.d("LangbridgeCell", "cangoback:  " + this.l.getUrl());
            this.l.goBack();
            f();
            this.D = this.l.getUrl();
            return true;
        }
        E();
        return true;
    }

    private BdActionBar b(boolean z2) {
        if (z2) {
            return new BdLightAppActionBar(q());
        }
        return new BdActionBar(q());
    }

    /* access modifiers changed from: private */
    public void e(boolean z2) {
        getActivity().getWindow().setFlags(z2 ? 0 : 1024, 1024);
    }

    public class CustomChromeClient extends SafeWebView.SafeChromeClient implements NoProguard {
        public CustomChromeClient() {
        }

        public View getVideoLoadingProgressView() {
            LogUtil.i("LangbridgeCell", "getVideoLoadingProgressView");
            FrameLayout frameLayout = new FrameLayout(LangbridgeCell.this.getActivity());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return frameLayout;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String str;
            if (consoleMessage == null) {
                return super.onConsoleMessage(consoleMessage);
            }
            ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
            if (messageLevel == ConsoleMessage.MessageLevel.ERROR) {
                String sourceId = consoleMessage.sourceId();
                if (TextUtils.equals(sourceId, LangbridgeCell.this.E) || TextUtils.isEmpty(sourceId)) {
                    sourceId = "";
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("level", messageLevel.name());
                linkedHashMap.put("message", consoleMessage.message());
                linkedHashMap.put("lineNo", String.valueOf(consoleMessage.lineNumber()));
                linkedHashMap.put("sourceId", sourceId);
                linkedHashMap.put(LightAppStatEvent.PAGE_URL, LangbridgeCell.this.E);
                linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(LangbridgeCell.this.E).toString());
                if (!TextUtils.isEmpty(consoleMessage.message()) && consoleMessage.message().contains(LightappJsClient.LIGHTAPP_JS_NAME)) {
                    linkedHashMap.put("owner", LangbridgeCell.this.p());
                    if (!(LangbridgeCell.this.b() == null || LangbridgeCell.this.b().getJsBridge() == null)) {
                        linkedHashMap.put("webview", LangbridgeCell.this.b().hashCode() + "");
                        if (LangbridgeCell.this.c == null) {
                            str = com.baidu.android.common.others.lang.StringUtil.NULL_STRING;
                        } else {
                            str = LangbridgeCell.this.c.hashCode() + "";
                        }
                        linkedHashMap.put("jsclient", str);
                    }
                }
                LogUtil.i("LangbridgeCell", "console message:" + consoleMessage.message());
                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                String message = consoleMessage.message();
                String[] strArr = new String[3];
                strArr[0] = LangbridgeCell.this.E;
                strArr[1] = messageLevel.name();
                strArr[2] = LangbridgeCell.this.p ? "1" : "0";
                langbridgeCell.checkClodDown(message, Arrays.asList(strArr), "webview_console");
                Tracker.send(LightAppStatEvent.WEB_VIEW_CONSOLE, (Map<String, String>) linkedHashMap, LangbridgeCell.this.getContext());
            }
            return super.onConsoleMessage(consoleMessage);
        }

        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }

        public void onHideCustomView() {
            LogUtil.i("LangbridgeCell", "onHideCustomView");
            LangbridgeCell.this.E();
        }

        public void onPermissionRequest(PermissionRequest permissionRequest) {
            LightappBrowserWebView lightappBrowserWebView;
            if (!(permissionRequest == null || (lightappBrowserWebView = LangbridgeCell.this.l) == null || TextUtils.isEmpty(lightappBrowserWebView.getUrl()))) {
                String str = SdkInitResponse.getInstance().permissionAllowDomainList;
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split(",");
                    int length = split.length;
                    int i2 = 0;
                    while (i2 < length) {
                        String str2 = split[i2];
                        if (TextUtils.isEmpty(str2) || !LangbridgeCell.this.l.getUrl().contains(str2.trim())) {
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
            LogUtil.d("LangbridgeCell", "onProgressChanged:newProgress   " + i2);
            LangbridgeCell.this.a(i2);
            LangbridgeCell langbridgeCell = LangbridgeCell.this;
            langbridgeCell.B = i2;
            if (i2 == 100) {
                langbridgeCell.v();
                if (!LangbridgeCell.this.z) {
                    LogUtil.d("LangbridgeCell", "onProgressChanged.hideErrorPage");
                    LangbridgeCell.this.B();
                }
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (LangbridgeCell.this.w != null) {
                String str2 = "";
                if (TextUtils.isEmpty(str2) || NetworkUtils.isNetworkConnected(LangbridgeCell.this.j)) {
                    LangbridgeCell langbridgeCell = LangbridgeCell.this;
                    String str3 = langbridgeCell.a;
                    if (str3 != null) {
                        str2 = str3;
                    } else if (!TextUtils.isEmpty(langbridgeCell.m.getString("lang_customtitle"))) {
                        str2 = LangbridgeCell.this.m.getString("lang_customtitle");
                    } else if (TextUtils.isEmpty(str) || LangbridgeCell.T.matcher(str).matches()) {
                        str2 = " ";
                    } else {
                        if (("http://" + str).equals(LangbridgeCell.this.D)) {
                            str = " ";
                        }
                        str2 = str;
                    }
                } else {
                    LangbridgeCell.this.w.setTitleCenterSafeTipText(str2);
                }
                LangbridgeCell.this.d(str2);
            }
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            LogUtil.i("LangbridgeCell", "onShowCustomView");
            if (LangbridgeCell.this.getActivity() != null && LangbridgeCell.this.isActiveCell()) {
                LangbridgeCell langbridgeCell = LangbridgeCell.this;
                if (langbridgeCell.r != null) {
                    customViewCallback.onCustomViewHidden();
                    return;
                }
                FrameLayout frameLayout = (FrameLayout) langbridgeCell.getActivity().getWindow().getDecorView();
                FrameLayout unused = LangbridgeCell.this.I = new b(LangbridgeCell.this.getActivity());
                if (LangbridgeCell.this.getActivity().getApplicationInfo().targetSdkVersion < 26 || Build.VERSION.SDK_INT != 26) {
                    if (LangbridgeCell.this.am) {
                        LangbridgeCell.this.getActivity().setRequestedOrientation(1);
                        LangbridgeCell.this.I.setPadding(0, 0, 0, LightappBaseActivity.getNavigationBarHeight(LangbridgeCell.this.getContext()));
                    } else {
                        LangbridgeCell.this.getActivity().setRequestedOrientation(0);
                    }
                }
                LangbridgeCell.this.I.addView(view, LangbridgeCell.s);
                frameLayout.addView(LangbridgeCell.this.I, LangbridgeCell.s);
                LangbridgeCell langbridgeCell2 = LangbridgeCell.this;
                langbridgeCell2.r = view;
                langbridgeCell2.e(false);
                LogUtil.i("LangbridgeCell", "fullscreen");
                WebChromeClient.CustomViewCallback unused2 = LangbridgeCell.this.J = customViewCallback;
                DXMSdkSAUtils.onEventWithValues("#webviewVedioFullScreen", Arrays.asList(new String[]{LangbridgeCell.this.D}));
            }
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            String[] acceptTypes;
            LangbridgeCell.this.f = valueCallback;
            if (webView != null && !TextUtils.isEmpty(webView.getUrl())) {
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_INPUT_FILE, Arrays.asList(new String[]{webView.getUrl()}));
            }
            if (fileChooserParams != null && (acceptTypes = fileChooserParams.getAcceptTypes()) != null && acceptTypes.length > 0 && !TextUtils.isEmpty(acceptTypes[0])) {
                LangbridgeCell.this.a(acceptTypes[0], fileChooserParams.isCaptureEnabled(), 2);
            }
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            LangbridgeCell.this.e = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            try {
                LangbridgeCell.this.a(Intent.createChooser(intent, "File Chooser"), 1);
            } catch (ActivityNotFoundException unused) {
                DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL);
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            LangbridgeCell.this.e = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(str);
            try {
                LangbridgeCell.this.a(Intent.createChooser(intent, "File Browser"), 1);
            } catch (ActivityNotFoundException unused) {
                DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_FILE_CHOOSER_INTENT_FAIL);
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            LangbridgeCell.this.e = valueCallback;
            if (!TextUtils.isEmpty(str)) {
                LangbridgeCell.this.a(str, !TextUtils.isEmpty(str2), 1);
            }
        }
    }

    /* access modifiers changed from: private */
    public void e(final String str) {
        a("(function() {\n     return document.documentElement.outerHTML;\n})", (String) null, (ValueCallback) new ValueCallback<String>() {
            /* renamed from: a */
            public void onReceiveValue(String str) {
                if (!TextUtils.isEmpty(str)) {
                    DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_GET_DOM_SCRIPT, Arrays.asList(new String[]{str, "1"}));
                    RpaProcessor.getInstance().writeHtmlToFile(LangbridgeCell.this.getContext(), str, System.currentTimeMillis(), str);
                    return;
                }
                DXMSdkSAUtils.onEventWithValues(RpaProcessor.RPA_GET_DOM_SCRIPT, Arrays.asList(new String[]{str, "0"}));
            }
        });
    }

    private void b(String str) {
        if (this.w != null) {
            boolean z2 = this.m.getBoolean("lang_showtitle", true);
            this.ak = z2;
            if (!z2) {
                this.w.setVisibility(8);
            }
            d("");
            this.w.setLeftZoneOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (LangbridgeCell.this.isActiveCell()) {
                        GlobalUtils.hideKeyboard(LangbridgeCell.this.r().getControllerActivity());
                        LangbridgeCell.this.r().backPressed();
                    }
                }
            });
            if (this.u != null) {
                this.w.setRightImgZone2Visibility(0);
                this.w.setRightImgZone2Enable(true);
                this.w.setRightImgZone2Src(ResUtils.drawable(this.j, "wallet_langbridge_actionbar_more"), ResUtils.getString(this.j, "wallet_base_bdaction_more"));
                this.w.setRightImgZone2OnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        LangbridgeCell.this.u.show();
                    }
                });
                this.w.setOnlyIcons(this.m.getBoolean("lang_icontitle", false));
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(boolean z2) {
        if (z2) {
            this.w.showLeftZone();
        } else {
            this.w.hideLeftZone();
        }
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        if (this.w != null) {
            C();
            this.w.setTitle(str);
        }
    }

    public void a(LightappWebView lightappWebView) {
        WebSettings settings = lightappWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setGeolocationDatabasePath(this.j.getDir("database", 0).getPath());
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setTextZoom(100);
        settings.setGeolocationEnabled(true);
        String userAgentString = settings.getUserAgentString();
        if (userAgentString != null && !userAgentString.contains(BaiduWallet.TAG)) {
            userAgentString = userAgentString + " " + BussinessUtils.getUA(q());
            settings.setUserAgentString(userAgentString);
        }
        if (!TextUtils.isEmpty(userAgentString)) {
            LangbridgeCacheManager.getInstance().setLangbridgeUA(userAgentString);
        }
        lightappWebView.setScrollBarStyle(0);
        lightappWebView.clearCache(false);
        lightappWebView.resumeTimers();
        if (Build.VERSION.SDK_INT >= 11) {
            lightappWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            lightappWebView.removeJavascriptInterface("accessibility");
            lightappWebView.removeJavascriptInterface("accessibilityTraversal");
        }
        LightappJsClient lightappJsClient = new LightappJsClient(this, this.l);
        this.c = lightappJsClient;
        lightappWebView.addJavascriptInterface(lightappJsClient, LightappJsClient.LIGHTAPP_JS_NAME);
        DXMSdkSAUtils.onEventWithValues("#injectJavaObject", Arrays.asList(new String[]{p(), this.c.hashCode() + "", lightappWebView.hashCode() + ""}));
        LangbridgeSettings a2 = h.a().a(this.j);
        if (a2.MW_ON && a2.MW_INJECTJS_FOR_HS) {
            lightappWebView.addJsCode(LangbridgeSettings.MW_JSHOOK_HISTORY_NAME, h.a().a(LangbridgeSettings.MW_JSHOOK_HISTORY_NAME, a2.MW_JSHOOK_HISTORY));
        }
        if (a2.MW_ON && a2.MW_INJECTJS_FOR_SS) {
            lightappWebView.addJsCode(LangbridgeSettings.MW_JSHOOK_SESSION_NAME, h.a().a(LangbridgeSettings.MW_JSHOOK_SESSION_NAME, a2.MW_JSHOOK_SESSION));
        }
        f("common");
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(lightappWebView, true);
        }
        lightappWebView.setWebViewClient(new CustomWebViewClient());
        lightappWebView.setWebChromeClient(new CustomChromeClient());
        lightappWebView.setDownloadListener(new DownloadListener() {
            public Pattern a;
            public Matcher b;

            {
                Pattern compile = Pattern.compile(".*");
                this.a = compile;
                this.b = compile.matcher("");
            }

            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (LangbridgeCell.this.X == null) {
                    List unused = LangbridgeCell.this.X = new LinkedList();
                }
                LangbridgeCell.this.X.add(str);
                try {
                    if (!TextUtils.isEmpty(str)) {
                        LangbridgeCell.this.a(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    }
                } catch (Exception e) {
                    LogUtil.e("LangbridgeCell", "Download Error", e);
                    GlobalUtils.toast(LangbridgeCell.this.j, "下载出现异常");
                }
            }
        });
        this.H = new Vector<>();
        if (!TextUtils.isEmpty(this.D)) {
            this.H.add(new LoadTimeLine(this.D.trim(), "onCreate", String.valueOf(System.currentTimeMillis())));
        }
    }

    public LightappBrowserWebView b() {
        return this.l;
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        if (this.m.getBoolean("lang_showerror", true)) {
            NoNetView noNetView = this.q;
            if (noNetView != null) {
                noNetView.show(str, this);
            }
            LightappBrowserWebView lightappBrowserWebView = this.l;
            if (lightappBrowserWebView != null) {
                lightappBrowserWebView.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(boolean z2) {
        this.w.setTitleTextColorAlpha(z2 ? 255 : 0);
    }

    public LangbridgeCell(d dVar, Bundle bundle, LightappBrowserWebView lightappBrowserWebView, String str) {
        this.j = DxmApplicationContextImpl.getApplicationContext(dVar.getControllerActivity());
        this.l = lightappBrowserWebView;
        this.V = str;
        if (bundle != null) {
            this.m = bundle;
            LangbridgeBarParams langbridgeBarParams = (LangbridgeBarParams) bundle.get("lang_prebarparams");
            if (langbridgeBarParams != null) {
                this.ap = langbridgeBarParams;
            }
        }
        a(dVar);
        this.Y = dVar.getLangbridgeStamp();
        LogUtil.i("LangbridgeCell", "cellHashStamp form Controller " + this.Y);
        m();
    }

    public void a(final String str, final b bVar, final boolean z2) {
        this.D = str;
        this.n = bVar;
        this.f3575o = false;
        a((Runnable) new Runnable() {
            public void run() {
                try {
                    if (!LangbridgeCell.T.matcher(LangbridgeCell.this.D).matches()) {
                        LangbridgeCell langbridgeCell = LangbridgeCell.this;
                        langbridgeCell.D = "https://" + LangbridgeCell.this.D;
                    }
                    LangbridgeCell.this.p = z2;
                    LangbridgeCell.this.l.loadUrl(LangbridgeCell.this.D.trim());
                    LangbridgeCell.this.z = false;
                } catch (Exception e) {
                    LogUtil.d("Url error");
                    LangbridgeCell.this.p = false;
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.a(1102, e.toString(), str);
                    }
                    if (LangbridgeCell.this.isActiveCell()) {
                        LangbridgeCell.this.r().closeWindow();
                    }
                }
            }
        });
    }

    public void a(d dVar, Bundle bundle, String str) {
        a(dVar);
        if (LangbridgePreloadCellCenter.PRELOAD_POOL_TAG_FROM_NA.equals(p()) && !str.equals(p())) {
            g a2 = g.a();
            a2.a("transfer", new String[]{toString().hashCode() + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, str + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX});
            a(str);
            dVar.setLangbridgeStamp(this.Y);
        }
        if (bundle != null) {
            this.m = bundle;
            LangbridgeBarParams langbridgeBarParams = (LangbridgeBarParams) bundle.get("lang_prebarparams");
            if (langbridgeBarParams != null) {
                this.ap = langbridgeBarParams;
            }
        }
        this.n = null;
        this.l.setBaseContext(getActivity());
        this.w.setTop(getActivity());
        this.w.setVisibility(this.m.getBoolean("lang_showtitle", true) ? 0 : 8);
        this.w.setOnlyIcons(this.m.getBoolean("lang_icontitle", false));
        x();
        JSONArray jSONArray = this.C;
        if (jSONArray != null) {
            setMenuInMainThread(jSONArray);
        }
        z();
        A();
    }

    /* access modifiers changed from: private */
    public void a(double d2, String str, int i2, boolean z2) {
        int displayHeight = DisplayUtils.getDisplayHeight(getContext());
        int dip2px = DisplayUtils.dip2px(getContext(), 100.0f);
        double d3 = (double) displayHeight;
        int i3 = (int) (0.9d * d3);
        if (!(this.ac == d2 || d2 == -0.0d) || !z2) {
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
            if (this.ah != null) {
                LogUtil.d("LangbridgeCell", "屏幕的高度：" + displayHeight + ",halfHeight:" + d2);
                a((View) this.ah, d2);
            }
            NoNetView noNetView = this.q;
            if (noNetView != null) {
                a((View) noNetView, d2);
                this.q.setVisibilityByContentHeight((int) d2);
            }
        }
        RoundLinearLayout roundLinearLayout = this.ai;
        if (roundLinearLayout != null) {
            roundLinearLayout.setRoundPath(RoundLinearLayout.HALF_RADII);
        }
        int color = ContextCompat.getColor(getContext(), R.color.half_wallet_bg_color);
        if (z2) {
            RelativeLayout relativeLayout = this.af;
            if (!(relativeLayout == null || str == null)) {
                relativeLayout.setBackgroundColor(ViewUtils.parseColor(str, color));
            }
        } else {
            RelativeLayout relativeLayout2 = this.af;
            if (relativeLayout2 != null) {
                relativeLayout2.setBackgroundColor(ViewUtils.parseColor(str, color));
            }
        }
        BdHalfActionBar bdHalfActionBar = this.aj;
        if (bdHalfActionBar != null) {
            ViewUtils.setVisibility(bdHalfActionBar, ((double) i2) != 1.0d);
            this.aj.setIconBack(new View.OnClickListener() {
                public void onClick(View view) {
                    if (LangbridgeCell.this.isActiveCell()) {
                        GlobalUtils.hideKeyboard(LangbridgeCell.this.r().getControllerActivity());
                        LangbridgeCell.this.r().backPressed();
                    }
                }
            });
            this.aj.setIconClose(new View.OnClickListener() {
                public void onClick(View view) {
                    if (LangbridgeCell.this.isActiveCell()) {
                        GlobalUtils.hideKeyboard(LangbridgeCell.this.r().getControllerActivity());
                        LangbridgeCell.this.F();
                    }
                }
            });
        }
    }

    private void a(View view, double d2) {
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.addRule(12);
            layoutParams.height = (int) d2;
            view.setLayoutParams(layoutParams);
        } catch (Exception e2) {
            LogUtil.d("LangbridgeCell", "异常" + e2.getMessage());
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.b = new WeakReference<>(dVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r5, @androidx.annotation.NonNull java.lang.String[] r6, @androidx.annotation.NonNull int[] r7) {
        /*
            r4 = this;
            com.baidu.wallet.lightapp.base.LightappJsClient r0 = r4.c
            r0.onRequestPermissionsResultLocal(r5, r6, r7)
            com.baidu.wallet.lightapp.business.LightappBusinessClient r0 = r4.d
            if (r0 == 0) goto L_0x000e
            java.lang.String r1 = r4.E
            r0.onRequestPermissionsResult(r1, r5, r6, r7)
        L_0x000e:
            if (r7 == 0) goto L_0x0086
            int r0 = r7.length
            if (r0 <= 0) goto L_0x0086
            r0 = 101(0x65, float:1.42E-43)
            r1 = 1
            r2 = 0
            r3 = 0
            if (r5 == r0) goto L_0x004b
            r0 = 102(0x66, float:1.43E-43)
            if (r5 == r0) goto L_0x001f
            goto L_0x0061
        L_0x001f:
            com.baidu.wallet.permission.CommonPermissionCallback r0 = r4.Z
            if (r0 == 0) goto L_0x0028
            r0.onRequestPermissionsResult(r5, r6, r7)
            r4.Z = r3
        L_0x0028:
            int r5 = r7.length
            r6 = 0
        L_0x002a:
            if (r6 >= r5) goto L_0x0035
            r0 = r7[r6]
            if (r0 == 0) goto L_0x0032
            r5 = 1
            goto L_0x0036
        L_0x0032:
            int r6 = r6 + 1
            goto L_0x002a
        L_0x0035:
            r5 = 0
        L_0x0036:
            if (r5 != 0) goto L_0x0064
            java.lang.String r6 = r4.Q
            boolean r7 = r4.R
            int r0 = r4.P
            r4.a((java.lang.String) r6, (boolean) r7, (int) r0)
            java.lang.String r6 = ""
            r4.Q = r6
            r4.R = r2
            r6 = -1
            r4.P = r6
            goto L_0x0064
        L_0x004b:
            com.baidu.wallet.permission.CommonPermissionCallback r0 = r4.aa
            if (r0 == 0) goto L_0x0054
            r0.onRequestPermissionsResult(r5, r6, r7)
            r4.aa = r3
        L_0x0054:
            r5 = r7[r2]
            if (r5 != 0) goto L_0x0063
            android.content.Intent r5 = r4.O
            if (r5 == 0) goto L_0x0061
            int r6 = r4.P
            r4.a((android.content.Intent) r5, (int) r6)
        L_0x0061:
            r5 = 0
            goto L_0x0064
        L_0x0063:
            r5 = 1
        L_0x0064:
            if (r5 == 0) goto L_0x0086
            int r5 = r4.P
            if (r5 != r1) goto L_0x0076
            android.webkit.ValueCallback<android.net.Uri> r5 = r4.e
            if (r5 == 0) goto L_0x0073
            r5.onReceiveValue(r3)
            r4.e = r3
        L_0x0073:
            r4.aq = r3
            goto L_0x0086
        L_0x0076:
            r6 = 2
            if (r5 != r6) goto L_0x0086
            android.webkit.ValueCallback<android.net.Uri[]> r5 = r4.f
            if (r5 == 0) goto L_0x0084
            android.net.Uri[] r6 = new android.net.Uri[r2]
            r5.onReceiveValue(r6)
            r4.f = r3
        L_0x0084:
            r4.aq = r3
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.multipage.LangbridgeCell.a(int, java.lang.String[], int[]):void");
    }

    public void a(int i2, int i3, Intent intent) {
        LightappBusinessClient lightappBusinessClient;
        ContactInfoPresenter contactInfoPresenter;
        this.O = null;
        this.P = -1;
        if (i2 != 4) {
            boolean z2 = true;
            if (i2 == 5) {
                LogUtil.d("LangbridgeCell", "onActivityResult resultCode = " + i3);
                JSONObject jSONObject = new JSONObject();
                if (i3 != -1) {
                    try {
                        jSONObject.put("errCode", "10005");
                        jSONObject.put("des", "用户取消选择");
                        this.d.setAlubmPhotoData(1, jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                } else if (intent != null && intent.getData() != null) {
                    this.U.a(intent, jSONObject);
                }
            } else if (i2 == 1) {
                if (this.e != null) {
                    Uri data = (intent == null || i3 != -1) ? null : intent.getData();
                    if (data != null) {
                        this.e.onReceiveValue(data);
                    } else {
                        this.e.onReceiveValue(this.aq);
                    }
                    this.e = null;
                    this.aq = null;
                }
            } else if (i2 == 2) {
                if (this.f != null) {
                    Uri data2 = (intent == null || i3 != -1) ? null : intent.getData();
                    if (data2 != null) {
                        this.f.onReceiveValue(new Uri[]{data2});
                    } else {
                        Uri uri = this.aq;
                        if (uri != null) {
                            this.f.onReceiveValue(new Uri[]{uri});
                        } else {
                            this.f.onReceiveValue(new Uri[0]);
                        }
                    }
                    this.f = null;
                    this.aq = null;
                }
            } else if (i2 == 3) {
                if (i3 == -1) {
                    this.c.onCallCameraPicCallbackLocal();
                }
            } else if (i2 == 4) {
                if (i3 == -1) {
                    if (!(intent == null || intent.getData() == null)) {
                        List<String> loadRawPhone = ContactManager.getIContactsImpl().loadRawPhone(intent.getData(), this.j);
                        this.F = loadRawPhone;
                        if (loadRawPhone != null && loadRawPhone.size() > 1) {
                            if (this.F.size() == 2) {
                                String str = this.F.get(0);
                                String str2 = this.F.get(1);
                                if (!TextUtils.isEmpty(str) && str.equals(str2)) {
                                    str = "";
                                }
                                this.c.onContactsSelectedLocal(0, new String[]{str, StringUtils.trimAll(str2)}, "");
                                return;
                            }
                            a(this.F, (AdapterView.OnItemClickListener) new AdapterView.OnItemClickListener() {
                                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                                    if (i2 > 0 && i2 < LangbridgeCell.this.F.size()) {
                                        String replace = LangbridgeCell.this.F.get(i2).replace(" ", "").replace("-", "");
                                        LangbridgeCell langbridgeCell = LangbridgeCell.this;
                                        langbridgeCell.c.onContactsSelectedLocal(0, new String[]{langbridgeCell.F.get(0), replace}, "");
                                    }
                                }
                            });
                            return;
                        }
                    }
                    this.c.onContactsSelectedLocal(1, (String[]) null, ResUtils.getString(this.j, "wallet_base_select_phone_fail"));
                }
            } else if (i2 == 6) {
                LightappJsClient lightappJsClient = this.c;
                if (i3 != -1) {
                    z2 = false;
                }
                lightappJsClient.onInsertCalendarEventDone(z2);
            } else if (i2 == 7) {
                this.c.onFileFetchDone(i2, i3, intent);
            } else if (i2 == 8 && (lightappBusinessClient = this.d) != null) {
                if (i3 == -1) {
                    lightappBusinessClient.onInsertPhoneNumToAddressBookResult(0, "", "");
                } else {
                    lightappBusinessClient.onInsertPhoneNumToAddressBookResult(1, "10005", "用户取消");
                }
            }
        } else if (i3 != -1) {
            LightappBusinessClient lightappBusinessClient2 = this.d;
            if (lightappBusinessClient2 != null) {
                lightappBusinessClient2.onContactsSelected("", 1, (String[]) null, "取消", "0");
            }
        } else if (intent != null && intent.getData() != null && (contactInfoPresenter = this.G) != null) {
            contactInfoPresenter.a(intent.getData());
        }
    }

    public View a() {
        return this.f3574i;
    }

    public void a(String str) {
        this.V = str;
    }

    public void a(Intent intent, int i2) {
        if (isActiveCell()) {
            r().getControllerActivity().startActivityForResult(intent, i2);
        }
    }

    public void a(Intent intent) {
        if (isActiveCell()) {
            r().getControllerActivity().startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        ViewGroup.LayoutParams layoutParams = this.t.getLayoutParams();
        layoutParams.width = (int) (((float) (DisplayUtils.getDisplayWidth(this.j) * i2)) / 100.0f);
        this.t.setLayoutParams(layoutParams);
    }

    public void a(List<String> list, AdapterView.OnItemClickListener onItemClickListener) {
        SelectNumberDialog selectNumberDialog = new SelectNumberDialog(q());
        selectNumberDialog.setOnItemClickListener(onItemClickListener);
        selectNumberDialog.setData(list);
        selectNumberDialog.show();
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
            com.baidu.wallet.base.widget.BdActionBar r4 = r3.w     // Catch:{ Exception -> 0x0073 }
            r4.setRightImgZone2Visibility(r1)     // Catch:{ Exception -> 0x0073 }
            r4 = 1
            android.view.View[] r4 = new android.view.View[r4]     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.base.widget.BdActionBar r5 = r3.w     // Catch:{ Exception -> 0x0073 }
            android.view.View r5 = r5.getRightImgZone2ImgView()     // Catch:{ Exception -> 0x0073 }
            r4[r1] = r5     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.utils.ViewUtils.visibleView(r4)     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.base.widget.BdActionBar r4 = r3.w     // Catch:{ Exception -> 0x0073 }
            r4.setRightImgZone2NotifyVisibility(r0)     // Catch:{ Exception -> 0x0073 }
            goto L_0x007d
        L_0x0021:
            java.util.List<com.baidu.wallet.lightapp.business.TitleBarParams$d> r4 = r5.rightParams     // Catch:{ Exception -> 0x0073 }
            boolean r4 = com.baidu.apollon.utils.CollectionUtils.isEmpty((java.util.Collection<?>) r4)     // Catch:{ Exception -> 0x0073 }
            if (r4 != 0) goto L_0x007d
            java.util.List<com.baidu.wallet.lightapp.business.TitleBarParams$d> r4 = r5.rightParams     // Catch:{ Exception -> 0x0073 }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.lightapp.business.TitleBarParams$d r4 = (com.baidu.wallet.lightapp.business.TitleBarParams.d) r4     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.base.widget.BdActionBar r5 = r3.w     // Catch:{ all -> 0x003d }
            java.lang.String r1 = r4.c     // Catch:{ all -> 0x003d }
            int r1 = android.graphics.Color.parseColor(r1)     // Catch:{ all -> 0x003d }
            r5.setRightImgZone2NotifyTextColor(r1)     // Catch:{ all -> 0x003d }
            goto L_0x004c
        L_0x003d:
            com.baidu.wallet.base.widget.BdActionBar r5 = r3.w     // Catch:{ Exception -> 0x0073 }
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
            com.baidu.wallet.base.widget.BdActionBar r5 = r3.w     // Catch:{ Exception -> 0x0073 }
            java.lang.String r1 = r4.a     // Catch:{ Exception -> 0x0073 }
            r5.setRightImgZone2NotifyText(r1)     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.base.widget.BdActionBar r5 = r3.w     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.lightapp.multipage.LangbridgeCell$16 r1 = new com.baidu.wallet.lightapp.multipage.LangbridgeCell$16     // Catch:{ Exception -> 0x0073 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0073 }
            r5.setRightImgZone2NotifyClickListener(r1)     // Catch:{ Exception -> 0x0073 }
            com.baidu.wallet.base.widget.BdActionBar r4 = r3.w     // Catch:{ Exception -> 0x0073 }
            r4.setRightImgZone2Visibility(r0)     // Catch:{ Exception -> 0x0073 }
            goto L_0x007d
        L_0x0073:
            r4 = move-exception
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "LangbridgeCell"
            com.baidu.wallet.core.utils.LogUtil.d(r5, r4)
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.multipage.LangbridgeCell.a(boolean, com.baidu.wallet.lightapp.business.TitleBarParams):void");
    }

    public void a(String str, String str2, ValueCallback valueCallback) {
        if (this.l != null && !TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder(str);
                sb.append("(\"");
                if (str2 != null) {
                    sb.append(LightappUtils.formatJSONForWebViewCallback(str2));
                }
                sb.append("\")");
                if (Build.VERSION.SDK_INT >= 19) {
                    this.l.evaluateJavascript(sb.toString(), valueCallback);
                    return;
                }
                LightappBrowserWebView lightappBrowserWebView = this.l;
                lightappBrowserWebView.loadUrl("javascript:" + sb.toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str, String str2) {
        if (this.n != null && !this.f3575o) {
            if (i2 != 0) {
                this.f3575o = true;
            }
            this.n.a(i2, str, str2);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a2, code lost:
        if (r2.equals(com.google.common.net.MediaType.IMAGE_TYPE) != false) goto L_0x00b0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0195  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r17, boolean r18, int r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            r3 = r19
            android.app.Activity r4 = r16.getActivity()
            java.lang.String r5 = "android.permission.READ_EXTERNAL_STORAGE"
            boolean r4 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r4, r5)
            java.lang.String r5 = ""
            if (r4 != 0) goto L_0x003c
            android.app.Activity r4 = r16.getActivity()
            java.lang.String r6 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r4 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r4, r6)
            if (r4 != 0) goto L_0x003c
            r1.Q = r0
            r1.R = r2
            r1.P = r3
            android.app.Activity r0 = r16.getActivity()
            java.lang.String[] r2 = new java.lang.String[]{r6}
            com.baidu.wallet.lightapp.multipage.LangbridgeCell$24 r4 = new com.baidu.wallet.lightapp.multipage.LangbridgeCell$24
            r4.<init>(r3)
            com.baidu.wallet.permission.CommonPermissionCallback r0 = com.baidu.wallet.core.utils.BaiduWalletUtils.requestPermissionsDialog(r5, r0, r2, r4)
            r1.Z = r0
            return
        L_0x003c:
            java.io.File r4 = new java.io.File
            java.lang.String r6 = android.os.Environment.DIRECTORY_PICTURES
            java.io.File r6 = android.os.Environment.getExternalStoragePublicDirectory(r6)
            android.content.Context r7 = r16.getContext()
            java.lang.String r7 = r7.getPackageName()
            r4.<init>(r6, r7)
            boolean r6 = r4.exists()
            if (r6 != 0) goto L_0x0058
            r4.mkdirs()
        L_0x0058:
            android.content.Context r6 = r16.getContext()
            r6.getPackageManager()
            java.lang.String r6 = "/"
            java.lang.String[] r6 = r0.split(r6)
            if (r6 == 0) goto L_0x0266
            int r7 = r6.length
            if (r7 <= 0) goto L_0x0266
            r7 = 0
            r8 = r6[r7]
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x0075
            goto L_0x0266
        L_0x0075:
            java.lang.String r8 = "android.intent.action.GET_CONTENT"
            if (r2 == 0) goto L_0x0255
            r2 = r6[r7]
            r6 = -1
            int r9 = r2.hashCode()
            r10 = 93166550(0x58d9bd6, float:1.3316821E-35)
            r11 = 2
            r12 = 1
            if (r9 == r10) goto L_0x00a5
            r10 = 100313435(0x5faa95b, float:2.3572098E-35)
            if (r9 == r10) goto L_0x009c
            r7 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r9 == r7) goto L_0x0092
            goto L_0x00af
        L_0x0092:
            java.lang.String r7 = "video"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x00af
            r7 = 1
            goto L_0x00b0
        L_0x009c:
            java.lang.String r9 = "image"
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x00af
            goto L_0x00b0
        L_0x00a5:
            java.lang.String r7 = "audio"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x00af
            r7 = 2
            goto L_0x00b0
        L_0x00af:
            r7 = -1
        L_0x00b0:
            java.lang.String r2 = "output"
            java.lang.String r9 = "FileProviderCalledInSearchboxPlugin"
            java.lang.String r10 = ".langbrigeProvider"
            java.lang.String r13 = ".fileprovider"
            java.lang.String r14 = "tieba"
            java.lang.String r15 = "iqiyi"
            java.lang.String r6 = "android.permission.CAMERA"
            if (r7 == 0) goto L_0x0195
            if (r7 == r12) goto L_0x00d7
            if (r7 == r11) goto L_0x00ce
            android.content.Intent r2 = new android.content.Intent
            r2.<init>(r8)
            r2.setType(r0)
            goto L_0x025d
        L_0x00ce:
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r0 = "android.provider.MediaStore.RECORD_SOUND"
            r2.<init>(r0)
            goto L_0x025d
        L_0x00d7:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            java.lang.String r4 = java.io.File.separator
            r7.append(r4)
            java.lang.String r4 = "video_"
            r7.append(r4)
            long r11 = java.lang.System.currentTimeMillis()
            r7.append(r11)
            java.lang.String r4 = ".mp4"
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r0.<init>(r4)
            java.lang.String r4 = com.baidu.wallet.core.beans.BeanConstants.CHANNEL_ID
            boolean r4 = r15.equals(r4)
            if (r4 == 0) goto L_0x0128
            android.content.Context r4 = r16.q()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            android.content.Context r8 = r16.q()
            java.lang.String r8 = r8.getPackageName()
            r7.append(r8)
            r7.append(r13)
            java.lang.String r7 = r7.toString()
            android.net.Uri r0 = androidx.core.content.FileProvider.getUriForFile(r4, r7, r0)
            r1.aq = r0
            goto L_0x0155
        L_0x0128:
            java.lang.String r4 = com.baidu.wallet.core.beans.BeanConstants.CHANNEL_ID
            boolean r4 = r14.equals(r4)
            if (r4 == 0) goto L_0x0134
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEvent(r9)
            return
        L_0x0134:
            android.content.Context r4 = r16.q()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            android.content.Context r8 = r16.q()
            java.lang.String r8 = r8.getPackageName()
            r7.append(r8)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            android.net.Uri r0 = androidx.core.content.FileProvider.getUriForFile(r4, r7, r0)
            r1.aq = r0
        L_0x0155:
            android.content.Context r0 = r16.q()
            android.content.Context r4 = r16.q()
            java.lang.String r4 = r4.getPackageName()
            android.net.Uri r7 = r1.aq
            r8 = 3
            r0.grantUriPermission(r4, r7, r8)
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r4 = "android.media.action.VIDEO_CAPTURE"
            r0.<init>(r4)
            android.net.Uri r4 = r1.aq
            r0.putExtra(r2, r4)
            android.app.Activity r2 = r16.getActivity()
            boolean r2 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r2, r6)
            if (r2 != 0) goto L_0x0253
            r1.O = r0
            r1.P = r3
            android.app.Activity r0 = r16.getActivity()
            java.lang.String[] r2 = new java.lang.String[]{r6}
            com.baidu.wallet.lightapp.multipage.LangbridgeCell$26 r3 = new com.baidu.wallet.lightapp.multipage.LangbridgeCell$26
            r3.<init>()
            com.baidu.wallet.permission.CommonPermissionCallback r0 = com.baidu.wallet.core.utils.BaiduWalletUtils.requestPermissionsDialog(r5, r0, r2, r3)
            r1.aa = r0
            return
        L_0x0195:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            java.lang.String r4 = java.io.File.separator
            r7.append(r4)
            java.lang.String r4 = "IMG_"
            r7.append(r4)
            long r11 = java.lang.System.currentTimeMillis()
            r7.append(r11)
            java.lang.String r4 = ".jpg"
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r0.<init>(r4)
            java.lang.String r4 = com.baidu.wallet.core.beans.BeanConstants.CHANNEL_ID
            boolean r4 = r15.equals(r4)
            if (r4 == 0) goto L_0x01e6
            android.content.Context r4 = r16.q()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            android.content.Context r8 = r16.q()
            java.lang.String r8 = r8.getPackageName()
            r7.append(r8)
            r7.append(r13)
            java.lang.String r7 = r7.toString()
            android.net.Uri r0 = androidx.core.content.FileProvider.getUriForFile(r4, r7, r0)
            r1.aq = r0
            goto L_0x0213
        L_0x01e6:
            java.lang.String r4 = com.baidu.wallet.core.beans.BeanConstants.CHANNEL_ID
            boolean r4 = r14.equals(r4)
            if (r4 == 0) goto L_0x01f2
            com.baidu.wallet.base.statistics.DXMSdkSAUtils.onEvent(r9)
            return
        L_0x01f2:
            android.app.Activity r4 = r16.getActivity()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            android.content.Context r8 = r16.q()
            java.lang.String r8 = r8.getPackageName()
            r7.append(r8)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            android.net.Uri r0 = androidx.core.content.FileProvider.getUriForFile(r4, r7, r0)
            r1.aq = r0
        L_0x0213:
            android.content.Context r0 = r16.q()
            android.content.Context r4 = r16.q()
            java.lang.String r4 = r4.getPackageName()
            android.net.Uri r7 = r1.aq
            r8 = 3
            r0.grantUriPermission(r4, r7, r8)
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r4 = "android.media.action.IMAGE_CAPTURE"
            r0.<init>(r4)
            android.net.Uri r4 = r1.aq
            r0.putExtra(r2, r4)
            android.app.Activity r2 = r16.getActivity()
            boolean r2 = com.baidu.apollon.permission.PermissionManager.checkCallingPermission(r2, r6)
            if (r2 != 0) goto L_0x0253
            r1.O = r0
            r1.P = r3
            android.app.Activity r0 = r16.getActivity()
            java.lang.String[] r2 = new java.lang.String[]{r6}
            com.baidu.wallet.lightapp.multipage.LangbridgeCell$25 r3 = new com.baidu.wallet.lightapp.multipage.LangbridgeCell$25
            r3.<init>()
            com.baidu.wallet.permission.CommonPermissionCallback r0 = com.baidu.wallet.core.utils.BaiduWalletUtils.requestPermissionsDialog(r5, r0, r2, r3)
            r1.aa = r0
            return
        L_0x0253:
            r2 = r0
            goto L_0x025d
        L_0x0255:
            android.content.Intent r2 = new android.content.Intent
            r2.<init>(r8)
            r2.setType(r0)
        L_0x025d:
            r1.a((android.content.Intent) r2, (int) r3)     // Catch:{ Exception -> 0x0261 }
            goto L_0x0266
        L_0x0261:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x0266:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.lightapp.multipage.LangbridgeCell.a(java.lang.String, boolean, int):void");
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        }
    }

    public static int a(float f2, int i2, int i3) {
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

    public void a(boolean z2) {
        LogUtil.d("LangbridgeCell", "setActionBarTransparent:" + z2);
        FrameLayout frameLayout = z2 ? this.M : this.N;
        FrameLayout frameLayout2 = z2 ? this.N : this.M;
        FrameLayout frameLayout3 = z2 ? this.K : this.L;
        FrameLayout frameLayout4 = z2 ? this.L : this.K;
        if (this.w != null && frameLayout2.getChildCount() == 0 && this.t != null && frameLayout4.getChildCount() == 0) {
            frameLayout.removeAllViews();
            frameLayout3.removeAllViews();
            frameLayout2.addView(this.w);
            frameLayout4.addView(this.t, new ViewGroup.LayoutParams(DisplayUtils.dip2px(this.j, 10.0f), DisplayUtils.dip2px(this.j, 2.0f)));
        }
    }
}
