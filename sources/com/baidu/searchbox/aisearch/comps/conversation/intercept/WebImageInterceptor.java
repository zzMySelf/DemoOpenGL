package com.baidu.searchbox.aisearch.comps.conversation.intercept;

import android.net.Uri;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.aisearch.statistic.AISearchStats;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0002J\"\u0010\u0017\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R7\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversation/intercept/WebImageInterceptor;", "Lcom/baidu/searchbox/aisearch/comps/conversation/intercept/IWebResourceInterceptInterface;", "aiSearchStats", "Lcom/baidu/searchbox/aisearch/statistic/AISearchStats;", "(Lcom/baidu/searchbox/aisearch/statistic/AISearchStats;)V", "errorCode", "", "responseHeader", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getResponseHeader", "()Ljava/util/HashMap;", "responseHeader$delegate", "Lkotlin/Lazy;", "webImageFileCache", "Lcom/baidu/searchbox/aisearch/comps/conversation/intercept/IWebResourceCacheInterface;", "getWebImageFileCache", "()Lcom/baidu/searchbox/aisearch/comps/conversation/intercept/IWebResourceCacheInterface;", "webImageFileCache$delegate", "createErrorResponse", "Lcom/baidu/webkit/sdk/WebResourceResponse;", "url", "createStatsErrorInfo", "Lorg/json/JSONObject;", "errorType", "createWebResourceResponse", "code", "destroy", "", "interceptRequest", "webView", "Lcom/baidu/browser/sailor/BdSailorWebView;", "request", "Lcom/baidu/webkit/sdk/WebResourceRequest;", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebImageInterceptor.kt */
public final class WebImageInterceptor implements IWebResourceInterceptInterface {
    private final AISearchStats aiSearchStats;
    private final int errorCode = 404;
    private final Lazy responseHeader$delegate = LazyKt.lazy(WebImageInterceptor$responseHeader$2.INSTANCE);
    private final Lazy webImageFileCache$delegate = LazyKt.lazy(WebImageInterceptor$webImageFileCache$2.INSTANCE);

    public WebImageInterceptor(AISearchStats aiSearchStats2) {
        this.aiSearchStats = aiSearchStats2;
    }

    private final IWebResourceCacheInterface getWebImageFileCache() {
        return (IWebResourceCacheInterface) this.webImageFileCache$delegate.getValue();
    }

    private final HashMap<String, String> getResponseHeader() {
        return (HashMap) this.responseHeader$delegate.getValue();
    }

    public WebResourceResponse interceptRequest(BdSailorWebView webView, WebResourceRequest request) {
        if ((request != null ? request.getUrl() : null) != null) {
            WebImageInterceptConfig webImageInterceptConfig = WebImageInterceptConfig.INSTANCE;
            Uri url = request.getUrl();
            if (webImageInterceptConfig.shouldIntercept$lib_aisearch_impl_release(url != null ? url.toString() : null)) {
                try {
                    Result.Companion companion = Result.Companion;
                    InputStream $this$interceptRequest_u24lambda_u2d2_u24lambda_u2d1 = getWebImageFileCache().getInputStreamFromCache(request);
                    if ($this$interceptRequest_u24lambda_u2d2_u24lambda_u2d1 == null) {
                        return createErrorResponse(request.getUrl().toString());
                    }
                    String mimeType = WebImageInterceptConfig.INSTANCE.getMimeTypeFromUrl$lib_aisearch_impl_release(request.getUrl().toString());
                    if (mimeType == null) {
                        mimeType = URLConnection.guessContentTypeFromStream($this$interceptRequest_u24lambda_u2d2_u24lambda_u2d1);
                    }
                    WebResourceResponse webResourceResponse = new WebResourceResponse(mimeType, Charsets.UTF_8.name(), $this$interceptRequest_u24lambda_u2d2_u24lambda_u2d1);
                    WebResourceResponse $this$interceptRequest_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 = webResourceResponse;
                    if ($this$interceptRequest_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.getResponseHeaders() == null) {
                        $this$interceptRequest_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.setResponseHeaders(new HashMap());
                    }
                    Map<String, String> responseHeaders = $this$interceptRequest_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.getResponseHeaders();
                    if (responseHeaders != null) {
                        responseHeaders.putAll(getResponseHeader());
                    }
                    return webResourceResponse;
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Object r0 = Result.m8971constructorimpl(ResultKt.createFailure(th2));
                    WebResourceResponse createErrorResponse = createErrorResponse(request.getUrl().toString());
                    if (Result.m8977isFailureimpl(r0)) {
                        r0 = createErrorResponse;
                    }
                    return (WebResourceResponse) r0;
                }
            }
        }
        return null;
    }

    private final WebResourceResponse createErrorResponse(String url) {
        String filePath = WebImageInterceptConfig.INSTANCE.parseImagePath$lib_aisearch_impl_release(url);
        CharSequence charSequence = filePath;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            AISearchStats aISearchStats = this.aiSearchStats;
            if (aISearchStats != null) {
                aISearchStats.onWebResourceInterceptError(createStatsErrorInfo(url, this.errorCode, "filePath nil"));
            }
            return createWebResourceResponse(this.errorCode, "filePath nil");
        } else if (!WebImageInterceptConfig.INSTANCE.isValidateFilePath$lib_aisearch_impl_release(filePath)) {
            AISearchStats aISearchStats2 = this.aiSearchStats;
            if (aISearchStats2 != null) {
                aISearchStats2.onWebResourceInterceptError(createStatsErrorInfo(url, this.errorCode, "filePath invalid"));
            }
            return createWebResourceResponse(this.errorCode, "filePath invalid");
        } else {
            AISearchStats aISearchStats3 = this.aiSearchStats;
            if (aISearchStats3 != null) {
                aISearchStats3.onWebResourceInterceptError(createStatsErrorInfo(url, this.errorCode, "read invalid"));
            }
            return createWebResourceResponse(this.errorCode, "read invalid");
        }
    }

    private final JSONObject createStatsErrorInfo(String url, int errorCode2, String errorType) {
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$createStatsErrorInfo_u24lambda_u2d3 = jSONObject;
        $this$createStatsErrorInfo_u24lambda_u2d3.put("url", url);
        $this$createStatsErrorInfo_u24lambda_u2d3.put("code", errorCode2);
        $this$createStatsErrorInfo_u24lambda_u2d3.put("reason", errorType);
        return jSONObject;
    }

    private final WebResourceResponse createWebResourceResponse(int code, String errorType) {
        return new WebResourceResponse("image/*", Charsets.UTF_8.name(), code, errorType, getResponseHeader(), (InputStream) null);
    }

    public void destroy() {
    }
}
