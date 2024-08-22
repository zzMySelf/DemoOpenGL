package com.baidu.searchbox.aisearch.comps.inspiration;

import android.graphics.Bitmap;
import android.util.Log;
import com.baidu.android.ext.widget.toast.ToastLocation;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.aisearch.R;
import com.baidu.searchbox.aisearch.comps.conversation.ConversationErrorComponentKt;
import com.baidu.searchbox.aisearch.comps.web.SimpleWebViewClient;
import com.baidu.searchbox.aisearch.comps.web.SimpleWebViewModel;
import com.baidu.searchbox.aisearch.comps.web.WebViewLoadErrorStateKt;
import com.baidu.searchbox.aisearch.config.inspiration.InspirationConfig;
import com.baidu.searchbox.aisearch.runtime.IAISearchSpeedStat;
import com.baidu.searchbox.aisearch.statistic.AISearchStats;
import com.baidu.searchbox.aisearch.utils.LinkUtilsKt;
import com.baidu.searchbox.aisearch.yalog.AISearchYalog;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.nacomp.extension.lifecycle.LifecycleKt;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.ng.browser.cache.NgWebViewCacheManager;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.webkit.sdk.RenderProcessGoneDetail;
import com.baidu.webkit.sdk.WebResourceError;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0019"}, d2 = {"com/baidu/searchbox/aisearch/comps/inspiration/InspirationComp$onCreateWebViewClient$1", "Lcom/baidu/searchbox/aisearch/comps/web/SimpleWebViewClient;", "onPageCommitVisible", "", "webView", "Lcom/baidu/browser/sailor/BdSailorWebView;", "url", "", "onPageFinished", "onPageStarted", "icon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Lcom/baidu/webkit/sdk/WebResourceRequest;", "error", "Lcom/baidu/webkit/sdk/WebResourceError;", "onReceivedHttpError", "errorResponse", "Lcom/baidu/webkit/sdk/WebResourceResponse;", "onRenderProcessGone", "", "detail", "Lcom/baidu/webkit/sdk/RenderProcessGoneDetail;", "shouldOverrideUrlLoading", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InspirationComp.kt */
public final class InspirationComp$onCreateWebViewClient$1 extends SimpleWebViewClient {
    final /* synthetic */ InspirationComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InspirationComp$onCreateWebViewClient$1(InspirationComp $receiver, UnitedSchemeMainDispatcher $super_call_param$1, NgWebView $super_call_param$2) {
        super($super_call_param$1, $super_call_param$2);
        this.this$0 = $receiver;
    }

    public boolean shouldOverrideUrlLoading(BdSailorWebView webView, String url) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        if (super.shouldOverrideUrlLoading(webView, url)) {
            return true;
        }
        if (url == null || Intrinsics.areEqual((Object) url, (Object) webView.getUrl()) || !LinkUtilsKt.isWebUrl(url)) {
            return false;
        }
        if (LinkUtilsKt.isHttpToHttps(webView.getUrl(), url)) {
            if (InspirationCompKt.DEBUG) {
                Log.i("Inspiration", "http->https, url=" + url);
            }
            AISearchYalog.INSTANCE.i("Inspiration", "http->https, url=" + url);
            return false;
        }
        this.this$0.openUrlWithBrowser(url);
        return true;
    }

    public void onPageStarted(BdSailorWebView webView, String url, Bitmap icon) {
        super.onPageStarted(webView, url, icon);
        AISearchYalog.INSTANCE.i("Inspiration", "onPageStarted");
        IAISearchSpeedStat.Companion.getImpl().updateStatistic(this.this$0.page, "pageStart");
        IAISearchSpeedStat.Companion.getImpl().updateStatistic(this.this$0.page, "pageStartTime", String.valueOf(this.this$0.getCurrentTime()));
        this.this$0.showLoading$lib_aisearch_impl_release();
        this.this$0.setPageFinished(false);
    }

    public void onPageCommitVisible(BdSailorWebView webView, String url) {
        super.onPageCommitVisible(webView, url);
        AISearchYalog.INSTANCE.i("Inspiration", "onPageCommitVisible");
        IAISearchSpeedStat.Companion.getImpl().updateStatistic(this.this$0.page, "commitVisible");
    }

    public void onReceivedError(BdSailorWebView webView, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(webView, request, error);
        if (webView != null && request != null && error != null) {
            if (InspirationCompKt.DEBUG) {
                Log.w("Inspiration", "onReceivedError, error=" + error);
            }
            AISearchYalog.INSTANCE.w("Inspiration", "onReceivedError, url=" + request.getUrl() + ", errorCode=" + error.getErrorCode() + ", originErrorCode=" + error.getOriginErrorCode() + ", description=" + error.getDescription());
            if (request.isForMainFrame()) {
                ((SimpleWebViewModel) this.this$0.getViewModel()).setWebResourceError(error.getErrorCode());
            }
        }
    }

    public void onReceivedHttpError(BdSailorWebView webView, WebResourceRequest request, WebResourceResponse errorResponse) {
        super.onReceivedHttpError(webView, request, errorResponse);
        if (webView != null && request != null && errorResponse != null) {
            if (InspirationCompKt.DEBUG) {
                Log.w("Inspiration", "onReceivedHttpError, errorResponse=" + errorResponse);
            }
            AISearchYalog.INSTANCE.w("Inspiration", "onReceivedHttpError, url=" + request.getUrl() + ", statusCode=" + errorResponse.getStatusCode());
            if (!WebViewLoadErrorStateKt.getHTTP_ERROR_CODES().contains(Integer.valueOf(errorResponse.getStatusCode())) || !request.isForMainFrame()) {
                AISearchYalog.INSTANCE.w("Inspiration", "onReceivedHttpError, url=" + request.getUrl() + ", statusCode=" + errorResponse.getStatusCode());
                return;
            }
            AISearchYalog.INSTANCE.e("Inspiration", "onReceivedHttpError, url=" + request.getUrl() + ", statusCode=" + errorResponse.getStatusCode());
            ((SimpleWebViewModel) this.this$0.getViewModel()).setMainFrameHttpError(errorResponse.getStatusCode());
        }
    }

    public boolean onRenderProcessGone(BdSailorWebView webView, RenderProcessGoneDetail detail) {
        Integer num = null;
        if (detail != null) {
            AISearchStats.onRenderProcessGone$default(this.this$0.getAiSearchStats(), detail, (String) null, 2, (Object) null);
        }
        boolean autoReload = InspirationConfig.INSTANCE.getReloadWhenTerminate();
        AISearchYalog aISearchYalog = AISearchYalog.INSTANCE;
        StringBuilder append = new StringBuilder().append("onRenderProcessGone, didCrash=").append(detail != null ? Boolean.valueOf(detail.didCrash()) : null).append(", priority=");
        if (detail != null) {
            num = Integer.valueOf(detail.rendererPriorityAtExit());
        }
        aISearchYalog.e("Inspiration", append.append(num).append(", autoReload=").append(autoReload).toString());
        if (LifecycleKt.isResumed(this.this$0) && autoReload) {
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.aisearch_conversation_render_crash_msg).setLocation(ToastLocation.BOTTOM).show();
        }
        this.this$0.hasFatalError = true;
        ((SimpleWebViewModel) this.this$0.getViewModel()).setWebViewErrorState(ConversationErrorComponentKt.getERROR_RENDERER_GONE());
        if (!autoReload) {
            return false;
        }
        NgWebViewCacheManager.getInstance().onRenderProcessGone();
        return true;
    }

    public void onPageFinished(BdSailorWebView webView, String url) {
        super.onPageFinished(webView, url);
        AISearchYalog.INSTANCE.i("Inspiration", "onPageFinished");
        this.this$0.ubcFirstPageShow();
        this.this$0.hideLoading$lib_aisearch_impl_release();
        this.this$0.setPageFinished(true);
        Function0<Unit> onPageFinished = this.this$0.getOnPageFinished();
        if (onPageFinished != null) {
            onPageFinished.invoke();
        }
    }
}
