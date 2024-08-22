package com.baidu.browser.components.safeurl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.common.logging.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.browser.arch.component.BrowserComponent;
import com.baidu.browser.arch.service.IBrowserServiceManager;
import com.baidu.browser.explore.safeguard.SafeguardPromptManager;
import com.baidu.browser.explore.safeguard.SafeguardType;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.utils.FrequencyControlManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.abtest.CPageErrorViewABTest;
import com.baidu.search.basic.statistic.SearchSpeedUbcManagerKt;
import com.baidu.search.core.utils.BrowserUrlUtils;
import com.baidu.searchbox.hissug.pyramid.IPrivateMode;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.net.SearchBoxCookieManager;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.ng.errorview.rec.model.RecLogExt;
import com.baidu.searchbox.ng.errorview.rec.model.RecReqParams;
import com.baidu.searchbox.ng.errorview.rec.model.RecRequestData;
import com.baidu.searchbox.ng.errorview.rec.model.RecRequestDataKt;
import com.baidu.searchbox.ng.errorview.rec.model.RecRequestManager;
import com.baidu.searchbox.ng.errorview.rec.model.RecResponseData;
import com.baidu.searchbox.ng.errorview.utils.GuessDataCacheUtils;
import com.baidu.searchbox.safeurl.InvokeCallbackParser;
import com.baidu.searchbox.safeurl.SafeUrlLevelInfo;
import com.baidu.searchbox.safeurl.SafeUrlManager;
import com.baidu.searchbox.safeurl.control.MediumRiskAlertControl;
import com.baidu.ubc.bussiness.UBCDurationSearchSession;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewClient;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J<\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\"\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\fH\u0016J \u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010H\u0002J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0007H\u0016J.\u0010$\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010%\u001a\u0004\u0018\u00010\u00102\u0006\u0010&\u001a\u00020'H\u0016J \u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u000eH\u0016J\u001c\u0010-\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010!\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010.\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010/\u001a\u0004\u0018\u00010\u00102\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020\u000eH\u0002J\u0018\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\u0007H\u0016J\u0010\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\fH\u0002J$\u0010;\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020\u0007H\u0002J\u0012\u0010?\u001a\u00020\u000e2\b\u0010@\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010A\u001a\u00020\u000e2\b\u0010@\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010B\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010C\u001a\u00020\u000eH\u0002J\u0010\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\fH\u0016J\b\u0010F\u001a\u00020\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/baidu/browser/components/safeurl/SafeUrlComponent;", "Lcom/baidu/browser/arch/component/BrowserComponent;", "Lcom/baidu/browser/components/safeurl/ISafeUrlService;", "()V", "checkUrlSubscription", "Lrx/Subscription;", "mForbiddenIndex", "", "mFrequencyControlManager", "Lcom/baidu/browser/utils/FrequencyControlManager;", "mLastSafeLevel", "mRiskyForbiddenForward", "", "checkUrlSafe", "", "url", "", "countRiskDialogShow", "doUpdateVisitedHistory", "view", "Lcom/baidu/browser/sailor/BdSailorWebView;", "isReload", "isSameDocument", "fromContentCache", "isBackForward", "getLastSafeLevel", "getRecData", "Lrx/Single;", "Lcom/baidu/searchbox/ng/errorview/rec/model/RecResponseData;", "eventType", "isSecWebEnable", "logTitle", "key", "title", "needForbiddenForward", "urlIndex", "onAbortResourceRequest", "mime", "contentLenght", "", "onContainerAnimationStart", "enter", "goback", "fromGesture", "onDestroy", "onReceivedTitle", "onSecurityCheckResultExt", "aUrl", "securityInfo", "Lcom/baidu/webkit/sdk/WebViewClient$SecurityInfo;", "registerService", "serviceManager", "Lcom/baidu/browser/arch/service/IBrowserServiceManager;", "resetFrequencyControlManager", "setForbiddenForward", "forbiddenForward", "forbiddenIndex", "setIsShowLock", "showLock", "setUrlSafeLevel", "info", "Lcom/baidu/searchbox/safeurl/SafeUrlLevelInfo;", "wsState", "showFakeBaiduDialog", "from", "showRiskyDialog", "triggerCheckUrlSafe", "unsubscribeCheckUrl", "updateUIForNight", "nightMode", "updateUi", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SafeUrlComponent.kt */
public final class SafeUrlComponent extends BrowserComponent implements ISafeUrlService {
    private Subscription checkUrlSubscription;
    private int mForbiddenIndex = -1;
    private FrequencyControlManager mFrequencyControlManager;
    private int mLastSafeLevel;
    private boolean mRiskyForbiddenForward;

    public void registerService(IBrowserServiceManager serviceManager) {
        Intrinsics.checkNotNullParameter(serviceManager, "serviceManager");
        serviceManager.registerService(ISafeUrlService.class, new SafeUrlComponent$registerService$1(this));
    }

    public void onContainerAnimationStart(boolean enter, boolean goback, boolean fromGesture) {
        resetFrequencyControlManager();
    }

    public void onDestroy() {
        super.onDestroy();
        unsubscribeCheckUrl();
    }

    public void updateUIForNight(boolean nightMode) {
        updateUi();
    }

    public void doUpdateVisitedHistory(BdSailorWebView view2, String url, boolean isReload, boolean isSameDocument, boolean fromContentCache, boolean isBackForward) {
    }

    public void onAbortResourceRequest(BdSailorWebView view2, String url, String mime, long contentLenght) {
        showRiskyDialog("zeus");
        setIsShowLock(true);
        getManager().getPageViewContext().onUrlSafeLevelChange(2);
    }

    public void onSecurityCheckResultExt(BdSailorWebView view2, String aUrl, WebViewClient.SecurityInfo securityInfo) {
        WebViewClient.SecurityLevel level = securityInfo != null ? securityInfo.getSecurityLevel() : null;
        if (level != null) {
            WebViewClient.WebSiteType type = securityInfo.getWebSiteInfo().getWebSiteType();
            if (level == WebViewClient.SecurityLevel.FORBIDDEN && type == WebViewClient.WebSiteType.FAKEBAIDU) {
                setIsShowLock(false);
                showFakeBaiduDialog("zeus");
                getManager().getPageViewContext().onUrlSafeLevelChange(2);
            }
        }
    }

    public void onReceivedTitle(BdSailorWebView view2, String title) {
        String url;
        if (isSecWebEnable() && title != null && (url = getManager().getPageViewContext().getUrl()) != null) {
            logTitle(String.valueOf(getManager().getPageViewContext().hashCode()), url, title);
        }
    }

    public int getLastSafeLevel() {
        return this.mLastSafeLevel;
    }

    private final void resetFrequencyControlManager() {
        FrequencyControlManager frequencyControlManager = this.mFrequencyControlManager;
        if (frequencyControlManager != null) {
            frequencyControlManager.reset();
        }
    }

    public void triggerCheckUrlSafe(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        SafeUrlManager.getInstance().cancelLowRiskTips();
        if (!(url.length() == 0)) {
            try {
                String host = Uri.parse(url).getHost();
                if (host == null) {
                    host = "";
                }
                if (SafeUrlComponentKt.DEBUG) {
                    Log.d("SafeUrlComponent", "triggerCheckUrlSafe host = " + host);
                }
                if (TextUtils.isEmpty(host) || Intrinsics.areEqual((Object) host, (Object) "baidu.com") || StringsKt.endsWith$default(host, ".baidu.com", false, 2, (Object) null)) {
                    setUrlSafeLevel(url, (SafeUrlLevelInfo) null, -1);
                } else {
                    checkUrlSafe(url);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (SafeUrlComponentKt.DEBUG) {
                    Log.e("SafeUrlComponent", "triggerCheckUrlSafe error:", e2);
                }
                setUrlSafeLevel(url, (SafeUrlLevelInfo) null, -1);
            }
        }
    }

    public boolean isSecWebEnable() {
        return SafeUrlManager.isSecWebEnable();
    }

    private final void checkUrlSafe(String url) {
        if (SafeUrlComponentKt.DEBUG) {
            Log.d("SafeUrlComponent", "checkUrlSafe safe url:" + url);
        }
        if (isSecWebEnable()) {
            unsubscribeCheckUrl();
            this.checkUrlSubscription = SafeUrlManager.getInstance().checkUrlSafeRx(url).flatMap(new SafeUrlComponent$$ExternalSyntheticLambda5()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SafeUrlComponent$$ExternalSyntheticLambda6(this, url), (Action1<Throwable>) new SafeUrlComponent$$ExternalSyntheticLambda7(this, url));
        } else if (SafeUrlComponentKt.DEBUG) {
            Log.d("SafeUrlComponent", "checkUrlSafe isSecWebEnable:false so return");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: checkUrlSafe$lambda-1  reason: not valid java name */
    public static final Observable m12713checkUrlSafe$lambda1(String result) {
        return SafeUrlManager.getInstance().checkWeishiStateRx().map(new SafeUrlComponent$$ExternalSyntheticLambda0(InvokeCallbackParser.parseCheckUrlSafeResult(0, result)));
    }

    /* access modifiers changed from: private */
    /* renamed from: checkUrlSafe$lambda-1$lambda-0  reason: not valid java name */
    public static final SafeUrlLevelInfo m12714checkUrlSafe$lambda1$lambda0(SafeUrlLevelInfo $info, String s) {
        if ($info == null) {
            return null;
        }
        $info.weishiState = InvokeCallbackParser.parseWeishiState(0, s);
        return $info;
    }

    /* access modifiers changed from: private */
    /* renamed from: checkUrlSafe$lambda-2  reason: not valid java name */
    public static final void m12715checkUrlSafe$lambda2(SafeUrlComponent this$0, String $url, SafeUrlLevelInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (info != null) {
            this$0.setUrlSafeLevel($url, info, info.weishiState);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: checkUrlSafe$lambda-3  reason: not valid java name */
    public static final void m12716checkUrlSafe$lambda3(SafeUrlComponent this$0, String $url, Throwable throwable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (SafeUrlComponentKt.DEBUG) {
            throwable.printStackTrace();
        }
        this$0.setUrlSafeLevel($url, (SafeUrlLevelInfo) null, -1);
    }

    private final void unsubscribeCheckUrl() {
        Subscription $this$unsubscribeCheckUrl_u24lambda_u2d4 = this.checkUrlSubscription;
        if ($this$unsubscribeCheckUrl_u24lambda_u2d4 != null && !$this$unsubscribeCheckUrl_u24lambda_u2d4.isUnsubscribed()) {
            $this$unsubscribeCheckUrl_u24lambda_u2d4.unsubscribe();
        }
    }

    private final void setUrlSafeLevel(String url, SafeUrlLevelInfo info, int wsState) {
        int level;
        if (!UiThreadUtils.isOnUiThread()) {
            UiThreadUtils.runOnUiThread(new SafeUrlComponent$$ExternalSyntheticLambda1(this, url, info, wsState));
            return;
        }
        String windowHashCode = String.valueOf(getManager().getPageViewContext().hashCode());
        if (this.mFrequencyControlManager == null) {
            if (SafeUrlComponentKt.DEBUG) {
                Log.e("SafeUrlComponent", "setUrlSafeLevel frequencyControlManager = null");
            }
            this.mFrequencyControlManager = new FrequencyControlManager();
        }
        FrequencyControlManager frequencyControlManager = this.mFrequencyControlManager;
        if (frequencyControlManager != null) {
            frequencyControlManager.updateDomain(url);
            if (info == null) {
                level = 0;
            } else {
                SafeUrlManager.getInstance().logSafeLevel(windowHashCode, url, info.safeLevel);
                level = SafeUrlManager.transferSafeLevel(info);
            }
            if (SafeUrlComponentKt.DEBUG) {
                Log.d("SafeUrlComponent", "setUrlSafeLevel level = " + level + " url = " + url);
            }
            if (getManager().getPageViewContext().parentIsCurrentWindow()) {
                if (SafeUrlComponentKt.DEBUG) {
                    Log.d("SafeUrlComponent", "setUrlSafeLevel set level " + level + " on box");
                }
                if (!(level == 0 || level == 1)) {
                    getManager().getPageViewContext().searchSpeedUbcManagerSetExtra(SearchSpeedUbcManagerKt.EXT_SAFE_LEVEL, String.valueOf(level));
                }
                Context context = getManager().getContext();
                if (level == 101 || level == 100 || level == 102) {
                    if (frequencyControlManager.needShowDialog()) {
                        getRecData(url, RecRequestDataKt.EVENT_TYPE_HIGH_RISK).subscribe(new SafeUrlComponent$$ExternalSyntheticLambda2(context, level, this));
                    }
                } else if (level != 103 || MediumRiskAlertControl.INSTANCE.isPornographiNoAlert()) {
                    if (level != 104 || MediumRiskAlertControl.INSTANCE.isGamblingNoAlert()) {
                        if (level == 105) {
                            if (frequencyControlManager.needShowDialog()) {
                                NgWebView webView = getManager().getPageViewContext().getWebView();
                                WebView webView2 = webView != null ? webView.getCurrentWebView() : null;
                                if (webView2 != null) {
                                    SafeUrlManager.getInstance().showLowRiskTips(context, webView2);
                                }
                            }
                        } else if (level == 2) {
                            if (info == null || !info.isFakeBaidu()) {
                                showRiskyDialog("tool");
                            } else {
                                showFakeBaiduDialog("tool");
                            }
                        } else if (level == 3) {
                            String checkUrl = url;
                            if (TextUtils.isEmpty(checkUrl)) {
                                checkUrl = getManager().getPageViewContext().getCurrentPageUrl();
                            }
                            getManager().getPageViewContext().showBlockPage(0, checkUrl);
                        } else if (level != this.mLastSafeLevel) {
                            SafeUrlManager.getInstance().dismissPopup();
                            if (level == 1) {
                                SafeUrlManager.getInstance().showUrlSafePopup(getManager().getPageViewContext().getSearchBoxView(), true, wsState);
                            }
                        }
                    } else if (frequencyControlManager.needShowDialog()) {
                        getRecData(url, RecRequestDataKt.EVENT_TYPE_MEDIUM_RISK).subscribe(new SafeUrlComponent$$ExternalSyntheticLambda4(context, level, this));
                    }
                } else if (frequencyControlManager.needShowDialog()) {
                    getRecData(url, RecRequestDataKt.EVENT_TYPE_MEDIUM_RISK).subscribe(new SafeUrlComponent$$ExternalSyntheticLambda3(context, level, this));
                }
            } else if (SafeUrlComponentKt.DEBUG) {
                Log.d("SafeUrlComponent", "setUrlSafeLevel save level " + level + " in window");
            }
            this.mLastSafeLevel = level;
            getManager().getPageViewContext().onUrlSafeLevelChange(level);
            if (getManager().getPageViewContext().curPageIsLastInBackForwardList()) {
                this.mForbiddenIndex = -1;
                this.mRiskyForbiddenForward = false;
            }
            if (SafeUrlComponentKt.DEBUG) {
                Log.d("SafeUrlComponent", "setUrlSafeLevel mRiskyForbiddenForward:" + this.mRiskyForbiddenForward);
                Log.d("SafeUrlComponent", "setUrlSafeLevel mForbiddenIndex:" + this.mForbiddenIndex);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setUrlSafeLevel$lambda-5  reason: not valid java name */
    public static final void m12719setUrlSafeLevel$lambda5(SafeUrlComponent this$0, String $url, SafeUrlLevelInfo $info, int $wsState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setUrlSafeLevel($url, $info, $wsState);
    }

    /* access modifiers changed from: private */
    /* renamed from: setUrlSafeLevel$lambda-6  reason: not valid java name */
    public static final void m12720setUrlSafeLevel$lambda6(Context $context, int $level, SafeUrlComponent this$0, RecResponseData it) {
        Intrinsics.checkNotNullParameter($context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SafeUrlManager.getInstance().showHighRiskDialog($context, $level, it);
        this$0.countRiskDialogShow();
    }

    /* access modifiers changed from: private */
    /* renamed from: setUrlSafeLevel$lambda-7  reason: not valid java name */
    public static final void m12721setUrlSafeLevel$lambda7(Context $context, int $level, SafeUrlComponent this$0, RecResponseData it) {
        Intrinsics.checkNotNullParameter($context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SafeUrlManager.getInstance().showMediumRiskDialog($context, $level, it);
        this$0.countRiskDialogShow();
    }

    /* access modifiers changed from: private */
    /* renamed from: setUrlSafeLevel$lambda-8  reason: not valid java name */
    public static final void m12722setUrlSafeLevel$lambda8(Context $context, int $level, SafeUrlComponent this$0, RecResponseData it) {
        Intrinsics.checkNotNullParameter($context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SafeUrlManager.getInstance().showMediumRiskDialog($context, $level, it);
        this$0.countRiskDialogShow();
    }

    private final Single<RecResponseData> getRecData(String url, String eventType) {
        Single<RecResponseData> onErrorReturn = Single.create(new SafeUrlComponent$$ExternalSyntheticLambda8(this, url, eventType)).timeout(1000, TimeUnit.MILLISECONDS, Single.just(null)).onErrorReturn(new SafeUrlComponent$$ExternalSyntheticLambda9());
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "create<RecResponseData?>…ErrorReturn { _ -> null }");
        return onErrorReturn;
    }

    /* access modifiers changed from: private */
    /* renamed from: getRecData$lambda-10  reason: not valid java name */
    public static final void m12717getRecData$lambda10(SafeUrlComponent this$0, String $url, String $eventType, SingleSubscriber it) {
        boolean z;
        int privateMode;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($eventType, "$eventType");
        IPrivateMode iPrivateMode = (IPrivateMode) ServiceManager.getService(IPrivateMode.Companion.getSERVICE_REFERENCE());
        if (iPrivateMode != null) {
            z = iPrivateMode.isPrivateMode(this$0.getManager().getContext());
        } else {
            z = false;
        }
        if (z) {
            privateMode = 1;
        } else {
            privateMode = 0;
        }
        String guessData = GuessDataCacheUtils.INSTANCE.getGuessString();
        CookieManager searchBoxCookieManager = new SearchBoxCookieManager(false, false);
        RecReqParams recReqParams = new RecReqParams(this$0.getManager().getPageViewContext().getErrorViewRecQuery(), $url, 3, 3, CPageErrorViewABTest.INSTANCE.getRec(), guessData, privateMode, $eventType);
        String urlFromA = this$0.getManager().getPageViewContext().getUrlFromA();
        if (urlFromA == null) {
            urlFromA = "";
        }
        RecRequestManager.INSTANCE.requestData(new RecRequestData(4, 0, searchBoxCookieManager, recReqParams, new RecLogExt(BrowserUrlUtils.getParamsFromSearchUrl(urlFromA, "sa"), UBCDurationSearchSession.getLid())), new SafeUrlComponent$getRecData$1$1(it));
    }

    /* access modifiers changed from: private */
    /* renamed from: getRecData$lambda-11  reason: not valid java name */
    public static final RecResponseData m12718getRecData$lambda11(Throwable th2) {
        return null;
    }

    private final void countRiskDialogShow() {
        SafeguardPromptManager.INSTANCE.addSafeguardCount(SafeguardType.SAFE_CAUTION, 1);
    }

    public boolean needForbiddenForward(int urlIndex) {
        if (!isSecWebEnable() || !this.mRiskyForbiddenForward || urlIndex + 1 != this.mForbiddenIndex) {
            return false;
        }
        return true;
    }

    public void setForbiddenForward(boolean forbiddenForward, int forbiddenIndex) {
        this.mForbiddenIndex = forbiddenIndex;
        this.mRiskyForbiddenForward = forbiddenForward;
    }

    private final void showFakeBaiduDialog(String from) {
        SafeUrlManager.getInstance().showUrlRiskyDialog((View) null, getManager().getContext(), 1, "https://m.baidu.com", from);
        countRiskDialogShow();
    }

    private final void showRiskyDialog(String from) {
        SafeUrlManager.getInstance().showUrlRiskyDialog((View) null, getManager().getContext(), 0, (String) null, from);
        countRiskDialogShow();
    }

    private final void updateUi() {
        SafeUrlManager.getInstance().updateUi();
    }

    private final void logTitle(String key, String url, String title) {
        SafeUrlManager.getInstance().logTitle(key, url, title);
    }

    private final void setIsShowLock(boolean showLock) {
        SafeUrlManager.getInstance().setIsShowLock(showLock);
    }
}
