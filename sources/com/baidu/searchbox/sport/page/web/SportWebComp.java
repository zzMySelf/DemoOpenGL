package com.baidu.searchbox.sport.page.web;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.ng.errorview.ErrorConstants;
import com.baidu.searchbox.sport.event.ClosePageEvent;
import com.baidu.searchbox.sport.event.OpenUrlEvent;
import com.baidu.searchbox.sport.ioc.ISportRenderStat;
import com.baidu.searchbox.sport.model.TabInfo;
import com.baidu.searchbox.sport.statistic.SportStats;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import org.json.JSONObject;

public class SportWebComp extends AbsSportWebComp<SportWebViewModel> {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "SportWebComp";
    /* access modifiers changed from: private */
    public final String page;
    /* access modifiers changed from: private */
    public final TabInfo tabInfo;
    /* access modifiers changed from: private */
    public final UniqueId token;

    public SportWebComp(UniqueId token2, View view2, TabInfo tabInfo2) {
        super(view2);
        this.token = token2;
        this.tabInfo = tabInfo2;
        onNightModeChange(false);
        ((SportWebViewModel) getViewModel()).setTabInfo(tabInfo2);
        this.page = SportStats.of(token2).getPage();
    }

    /* access modifiers changed from: protected */
    public NgWebView onFindWebView(View view2) {
        return (NgWebView) view2;
    }

    /* access modifiers changed from: protected */
    public boolean handleGoBack() {
        BdEventBus.Companion.getDefault().post(new ClosePageEvent(this.token));
        return true;
    }

    public SportWebViewModel onCreateViewModel() {
        return (SportWebViewModel) ViewModelProviders.of((LifecycleComponent) this).get(SportWebViewModel.class);
    }

    /* access modifiers changed from: protected */
    public void onInitWebView(NgWebView webView) {
        super.onInitWebView(webView);
        setTextZoom(getCurrentTextZoom());
    }

    /* access modifiers changed from: protected */
    public void onStartLoadUrl(String url) {
        if (this.tabInfo.isDefault()) {
            ISportRenderStat.Companion.getImpl().updateStatistic(this.page, "loadUrl");
        }
        super.onStartLoadUrl(url);
    }

    /* access modifiers changed from: protected */
    public BdSailorWebViewClient onCreateWebViewClient() {
        return new SportWebViewClient((AbsSportWebViewModel) getViewModel(), getWebView(), getSchemeMainDispatcher()) {
            public boolean shouldOverrideUrlLoading(BdSailorWebView webView, String url) {
                if (super.shouldOverrideUrlLoading(webView, url)) {
                    return true;
                }
                if (url == null || url.equals(webView.getUrl())) {
                    return false;
                }
                if (!url.startsWith("https://") && !url.startsWith("http://")) {
                    return false;
                }
                BdEventBus.Companion.getDefault().post(new OpenUrlEvent(SportWebComp.this.token, url));
                return true;
            }

            public void onPageStarted(BdSailorWebView bdSailorWebView, String s, Bitmap bitmap) {
                if (SportWebComp.DEBUG) {
                    Log.d(SportWebComp.TAG, "onPageStarted");
                }
                if (SportWebComp.this.tabInfo.isDefault()) {
                    ISportRenderStat.Companion.getImpl().updateStatistic(SportWebComp.this.page, "onPageStarted");
                }
                super.onPageStarted(bdSailorWebView, s, bitmap);
                SportWebComp.this.showLoading();
            }

            public void onPageFinished(BdSailorWebView bdSailorWebView, String s) {
                if (SportWebComp.DEBUG) {
                    Log.d(SportWebComp.TAG, "onPageFinished");
                }
                if (SportWebComp.this.tabInfo.isDefault()) {
                    ISportRenderStat.Companion.getImpl().updateStatistic(SportWebComp.this.page, "onPageFinished");
                }
                super.onPageFinished(bdSailorWebView, s);
                SportWebComp.this.hideLoading();
            }

            public void onReceivedError(BdSailorWebView webView, int errorCode, String desc, String failingUrl) {
                String str;
                if (SportWebComp.DEBUG) {
                    Log.d(SportWebComp.TAG, "onReceivedError");
                }
                super.onReceivedError(webView, errorCode, desc, failingUrl);
                if (SportWebComp.this.tabInfo.isDefault()) {
                    JSONObject json = new JSONObject();
                    try {
                        json.put("errorCode", errorCode);
                        json.put("desc", desc);
                        json.put("failingUrl", failingUrl);
                    } catch (Throwable t) {
                        if (SportWebComp.DEBUG) {
                            t.printStackTrace();
                        }
                    }
                    ISportRenderStat.Companion.getImpl().updateStatistic(SportWebComp.this.page, "errorInfo", json.toString());
                    ISportRenderStat impl = ISportRenderStat.Companion.getImpl();
                    String access$300 = SportWebComp.this.page;
                    if (NetWorkUtils.isNetworkConnected()) {
                        str = "3";
                    } else {
                        str = "2";
                    }
                    impl.changeStatus(access$300, str);
                    ISportRenderStat.Companion.getImpl().uploadStatistic(SportWebComp.this.page);
                }
            }

            public void onReceivedHttpError(BdSailorWebView webView, WebResourceRequest request, WebResourceResponse response) {
                String str;
                if (SportWebComp.DEBUG) {
                    Log.d(SportWebComp.TAG, "onReceivedHttpError");
                }
                super.onReceivedHttpError(webView, request, response);
                if (SportWebComp.this.tabInfo.isDefault() && ErrorConstants.HTTP_ERROR_CODE_SET.contains(Integer.valueOf(response.getStatusCode())) && request.isForMainFrame()) {
                    JSONObject json = new JSONObject();
                    try {
                        json.put("statusCode", response.getStatusCode());
                        json.put("requestUrl", request.getUrl());
                    } catch (Throwable t) {
                        if (SportWebComp.DEBUG) {
                            t.printStackTrace();
                        }
                    }
                    ISportRenderStat.Companion.getImpl().updateStatistic(SportWebComp.this.page, "errorInfo", json.toString());
                    ISportRenderStat impl = ISportRenderStat.Companion.getImpl();
                    String access$300 = SportWebComp.this.page;
                    if (NetWorkUtils.isNetworkConnected()) {
                        str = "0";
                    } else {
                        str = "2";
                    }
                    impl.changeStatus(access$300, str);
                    ISportRenderStat.Companion.getImpl().uploadStatistic(SportWebComp.this.page);
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public BdSailorWebViewClientExt onCreateWebViewClientExt() {
        return new BdSailorWebViewClientExt() {
            public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String s) {
                if (SportWebComp.DEBUG) {
                    Log.d(SportWebComp.TAG, "onFirstPaintDidExt");
                }
                if (SportWebComp.this.tabInfo.isDefault()) {
                    ISportRenderStat.Companion.getImpl().updateStatistic(SportWebComp.this.page, "onFirstPaintDidExt");
                }
                SportWebComp.this.hideLoading();
                super.onFirstPaintDidExt(bdSailorWebView, s);
            }

            public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String s) {
                if (SportWebComp.DEBUG) {
                    Log.d(SportWebComp.TAG, "onFirstContentfulPaintExt");
                }
                if (SportWebComp.this.tabInfo.isDefault()) {
                    ISportRenderStat.Companion.getImpl().updateStatistic(SportWebComp.this.page, "onFirstContentfulPaintExt");
                }
                SportWebComp.this.hideLoading();
                super.onFirstContentfulPaintExt(bdSailorWebView, s);
            }

            public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String s, BdSailorWebViewClientExt.FirstScreenInfo firstScreenInfo) {
                if (SportWebComp.DEBUG) {
                    Log.d(SportWebComp.TAG, "onFirstScreenPaintFinishedExt");
                }
                if (SportWebComp.this.tabInfo.isDefault()) {
                    ISportRenderStat.Companion.getImpl().updateStatistic(SportWebComp.this.page, "onFirstScreenPaintFinishedExt");
                    if (!TextUtils.isEmpty(ISportRenderStat.Companion.getImpl().getStatistic(SportWebComp.this.page, SportStats.HEAD_SHOW))) {
                        ISportRenderStat.Companion.getImpl().updateStatistic(SportWebComp.this.page, "onPageShow");
                        ISportRenderStat.Companion.getImpl().uploadStatistic(SportWebComp.this.page);
                    }
                }
                SportWebComp.this.hideLoading();
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, s, firstScreenInfo);
            }
        };
    }
}
