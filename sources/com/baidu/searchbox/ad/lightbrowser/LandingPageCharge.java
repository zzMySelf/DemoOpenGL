package com.baidu.searchbox.ad.lightbrowser;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.browser.BrowserType;
import com.baidu.searchbox.ad.ILightBrowserProxy;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.feed.ad.model.ExtData;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.DefaultResponseCallback;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.util.BaiduIdentityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u001e\u0010\f\u001a\u00020\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0002\b\u0003\u0018\u00010\u0010j\b\u0012\u0002\b\u0003\u0018\u0001`\u0011J\u0010\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0014\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J$\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bJ\u001a\u0010\u0017\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J0\u0010\u0017\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/ad/lightbrowser/LandingPageCharge;", "", "()V", "AD_LOAD_PARAM_UA", "", "mLightBrowserProxy", "Lcom/baidu/searchbox/ad/ILightBrowserProxy;", "buildGetRequest", "Lcom/baidu/searchbox/http/request/GetRequest;", "url", "headerMap", "", "deferCharge", "", "onAreaDeferUrl", "monitorUrls", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "parallelCharge", "chargeUrl", "requestCharge", "requestPv", "lpUrl", "requestUrl", "responseCallback", "Lcom/baidu/searchbox/http/callback/DefaultResponseCallback;", "lib-ad_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandingPageCharge.kt */
public final class LandingPageCharge {
    private static final String AD_LOAD_PARAM_UA = "User-Agent";
    public static final LandingPageCharge INSTANCE = new LandingPageCharge();
    private static final ILightBrowserProxy mLightBrowserProxy;

    private LandingPageCharge() {
    }

    static {
        ILightBrowserProxy adLightBrowserProxy = AdRuntimeHolder.getAdLightBrowserProxy();
        Intrinsics.checkNotNullExpressionValue(adLightBrowserProxy, "getAdLightBrowserProxy()");
        mLightBrowserProxy = adLightBrowserProxy;
    }

    public final void deferCharge(ArrayList<?> monitorUrls) {
        String url;
        if (monitorUrls != null) {
            Iterator<?> it = monitorUrls.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if ((next instanceof ExtData.MonitorUrl) && (url = ((ExtData.MonitorUrl) next).deferUrl) != null) {
                    INSTANCE.requestCharge(url);
                }
            }
        }
    }

    public final void deferCharge(String onAreaDeferUrl) {
        requestCharge(onAreaDeferUrl);
    }

    public final void parallelCharge(String chargeUrl) {
        requestUrl(chargeUrl, new LandingPageCharge$parallelCharge$1());
    }

    public final void requestCharge(String chargeUrl) {
        requestUrl(chargeUrl, new LandingPageCharge$requestCharge$1());
    }

    public final void requestPv(String lpUrl) {
        requestUrl(lpUrl, new LandingPageCharge$requestPv$1());
    }

    public final void requestPv(String lpUrl, Map<String, String> headerMap) {
        Intrinsics.checkNotNullParameter(headerMap, "headerMap");
        requestUrl(lpUrl, headerMap, new LandingPageCharge$requestPv$2());
    }

    private final void requestUrl(String url, DefaultResponseCallback responseCallback) {
        try {
            GetRequest buildGetRequest = buildGetRequest(url, (Map<String, String>) null);
            if (buildGetRequest != null) {
                buildGetRequest.executeAsync(responseCallback);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void requestUrl(String url, Map<String, String> headerMap, DefaultResponseCallback responseCallback) {
        try {
            GetRequest buildGetRequest = buildGetRequest(url, headerMap);
            if (buildGetRequest != null) {
                buildGetRequest.executeAsync(responseCallback);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final GetRequest buildGetRequest(String url, Map<String, String> headerMap) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        Context context = AdRuntimeHolder.getAdRuntime().context();
        return ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) HttpManager.getDefault(context).getRequest().addHeader("User-Agent", BaiduIdentityManager.getInstance().processUserAgent(mLightBrowserProxy.getDefaultUserAgent(context), BrowserType.LIGHT))).addHeaders(headerMap)).url(url)).cookieManager(AdRuntimeHolder.getAdRuntime().newCookieManagerInstance(true, false))).build();
    }
}
