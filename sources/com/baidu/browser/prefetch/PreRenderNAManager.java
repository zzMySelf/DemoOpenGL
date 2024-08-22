package com.baidu.browser.prefetch;

import android.content.Context;
import com.baidu.browser.explore.network.NaRequestConstantFileKt;
import com.baidu.browser.explore.network.NaRequestManager;
import com.baidu.browser.explore.network.prefetch.PrefetchParams;
import com.baidu.browser.explore.network.prefetch.PrefetchReqCallback;
import com.baidu.browser.explore.network.prefetch.PrefetchReqManager;
import com.baidu.search.basic.utils.SearchABTestUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jz\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u00132\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0006\u0010\u0019\u001a\u00020\u0010J\u0006\u0010\u001a\u001a\u00020\u0010J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dJ6\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0012j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u000eJ\u0006\u0010!\u001a\u00020\fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/browser/prefetch/PreRenderNAManager;", "", "()V", "PREFETCH_REQ_CALLBACK", "Lcom/baidu/browser/explore/network/prefetch/PrefetchReqCallback;", "getPREFETCH_REQ_CALLBACK", "()Lcom/baidu/browser/explore/network/prefetch/PrefetchReqCallback;", "PREFETCH_REQ_CALLBACK$delegate", "Lkotlin/Lazy;", "currentPreRenderEffectiveTimes", "Ljava/util/concurrent/atomic/AtomicInteger;", "addSugAndPrefetchRequestParams", "", "query", "", "type", "", "prefetchParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "searchSource", "searchParams", "startPrepareTime", "", "createSearchPrefetchCallback", "getAndClearEffectiveTimes", "incrementAndGetEffectiveTime", "initSugAndPrefetch2In1", "context", "Landroid/content/Context;", "parseHeaders", "jsonValue", "url", "uninitSugAndPrefetch2In1", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreRenderNAManager.kt */
public final class PreRenderNAManager {
    public static final PreRenderNAManager INSTANCE = new PreRenderNAManager();
    private static final Lazy PREFETCH_REQ_CALLBACK$delegate = LazyKt.lazy(PreRenderNAManager$PREFETCH_REQ_CALLBACK$2.INSTANCE);
    private static AtomicInteger currentPreRenderEffectiveTimes = new AtomicInteger(0);

    private PreRenderNAManager() {
    }

    private final PrefetchReqCallback getPREFETCH_REQ_CALLBACK() {
        return (PrefetchReqCallback) PREFETCH_REQ_CALLBACK$delegate.getValue();
    }

    public final void uninitSugAndPrefetch2In1() {
        PrefetchReqManager.INSTANCE.unregisterSearchResultCallback(getPREFETCH_REQ_CALLBACK());
    }

    public final void initSugAndPrefetch2In1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PrefetchReqManager.INSTANCE.registerSearchPrefetchCallback(context, getPREFETCH_REQ_CALLBACK());
    }

    public final HashMap<String, String> parseHeaders(String jsonValue, String url) throws JSONException {
        String str = jsonValue;
        String str2 = url;
        HashMap<String, String> hashMap = new HashMap<>();
        if (str == null) {
            return hashMap;
        }
        JSONObject headerObj = new JSONObject(str);
        Iterator iterator = headerObj.keys();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = headerObj.get(key);
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String keyValue = key.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(keyValue, "this as java.lang.String).toLowerCase(locale)");
            boolean z = true;
            if (Intrinsics.areEqual((Object) keyValue, (Object) NaRequestConstantFileKt.HEADER_KEY_SET_COOKIE)) {
                List cookieList = new ArrayList();
                String setCookieValue = value.toString();
                if (value instanceof JSONArray) {
                    JSONArray cookieArray = new JSONArray(setCookieValue);
                    int length = cookieArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        cookieList.add(cookieArray.get(i2).toString());
                    }
                    String substring = setCookieValue.substring(1, setCookieValue.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    hashMap.put(keyValue, substring);
                } else {
                    cookieList.add(setCookieValue);
                    hashMap.put(keyValue, setCookieValue);
                }
                if (cookieList.size() > 0) {
                    CharSequence charSequence = str2;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        z = false;
                    }
                    if (!z) {
                        NaRequestManager.INSTANCE.setCookieAsync(str2, cookieList);
                    }
                }
            } else if (value instanceof JSONArray) {
                String valueList = value.toString();
                String substring2 = valueList.substring(1, valueList.length() - 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                hashMap.put(keyValue, substring2);
            } else {
                hashMap.put(keyValue, value.toString());
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public final PrefetchReqCallback createSearchPrefetchCallback() {
        return new PreRenderNAManager$createSearchPrefetchCallback$1();
    }

    public final void addSugAndPrefetchRequestParams(String query, int type, HashMap<String, String> prefetchParams, String searchSource, HashMap<String, String> searchParams, long startPrepareTime) {
        if (query != null && prefetchParams != null) {
            if (PrefetchReqManager.INSTANCE.getDegradeToJson()) {
                prefetchParams.put("degrade", "1");
            }
            if (SearchABTestUtils.isResultPagePreRender()) {
            }
            PrefetchParams searchPrefetchParams = new PrefetchParams(query, type, prefetchParams, searchSource, searchParams);
            searchPrefetchParams.setStartToPrepareTime(startPrepareTime);
            searchPrefetchParams.setStartToLaunchTime(System.currentTimeMillis());
            PrefetchReqManager.INSTANCE.addSearchPrefetchParams(query, searchPrefetchParams);
        }
    }

    public final int incrementAndGetEffectiveTime() {
        return currentPreRenderEffectiveTimes.incrementAndGet();
    }

    public final int getAndClearEffectiveTimes() {
        return currentPreRenderEffectiveTimes.getAndSet(0);
    }
}
