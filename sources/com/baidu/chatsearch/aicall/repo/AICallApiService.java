package com.baidu.chatsearch.aicall.repo;

import com.baidu.chatsearch.aicall.repo.interfaces.EventSourceListenerWrapper;
import com.baidu.chatsearch.aicall.runtime.AICallRuntime;
import com.baidu.searchbox.aicall.yalog.AICallYalog;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.http.sse.EventSource;
import com.baidu.searchbox.http.sse.EventSourceListener;
import com.baidu.searchbox.http.sse.EventSources;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
import rx.Observer;
import rx.SingleSubscriber;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001c\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011H\u0002JT\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u000f0\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000f0\u0019H\u0005J`\u0010\u001a\u001a\u00020\b\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\n2\u0016\u0010\u001b\u001a\u0012\u0012\u000e\b\u0000\u0012\n\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u001d0\u001c2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001f2\u0016\u0010\u0018\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000f0\u0019H\u0005J-\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u000f0\u001d\"\u0004\b\u0000\u0010\u000f2\b\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u0001H\u000fH\u0002¢\u0006\u0002\u0010#J(\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u001d0\u0011\"\u0004\b\u0000\u0010\u000f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u001dH\u0002¨\u0006&"}, d2 = {"Lcom/baidu/chatsearch/aicall/repo/AICallApiService;", "", "()V", "createGetRequest", "Lcom/baidu/searchbox/http/request/GetRequest$GetRequestBuilder;", "url", "", "createSSERequest", "Lcom/baidu/searchbox/http/sse/EventSource;", "body", "Lorg/json/JSONObject;", "sourceListener", "Lcom/baidu/searchbox/http/sse/EventSourceListener;", "isSuccessResult", "", "T", "result", "Lcom/baidu/chatsearch/aicall/repo/AICallApiResult;", "sendGetRequest", "", "params", "", "subscriber", "Lrx/SingleSubscriber;", "parser", "Lkotlin/Function1;", "sendSSERequest", "observer", "Lrx/Observer;", "Lcom/baidu/chatsearch/aicall/repo/AICallSSEResult;", "onOpen", "Lkotlin/Function0;", "wrapperAICallSSEResult", "event", "data", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/baidu/chatsearch/aicall/repo/AICallSSEResult;", "wrapperSuccess", "Companion", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AICallApiService.kt */
public class AICallApiService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final MediaType JSON = MediaType.parse("application/json");
    public static final String KEY_DATA = "data";
    public static final String KEY_MSG = "msg";
    public static final String KEY_STATUS = "status";
    public static final String STATUS_OK = "0";

    /* access modifiers changed from: protected */
    public final <T> void sendGetRequest(String url, Map<String, String> params, SingleSubscriber<? super T> subscriber, Function1<? super JSONObject, ? extends T> parser) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        Intrinsics.checkNotNullParameter(parser, "parser");
        ((GetRequest.GetRequestBuilder) createGetRequest(url).addUrlParams(params)).build().executeAsyncOnUIBack(new AICallApiService$sendGetRequest$1(parser, this, subscriber));
    }

    public static /* synthetic */ EventSource sendSSERequest$default(AICallApiService aICallApiService, String str, JSONObject jSONObject, Observer observer, Function0 function0, Function1 function1, int i2, Object obj) {
        Function0 function02;
        if (obj == null) {
            if ((i2 & 8) != 0) {
                function02 = null;
            } else {
                function02 = function0;
            }
            return aICallApiService.sendSSERequest(str, jSONObject, observer, function02, function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendSSERequest");
    }

    /* access modifiers changed from: protected */
    public final <T> EventSource sendSSERequest(String url, JSONObject params, Observer<? super AICallSSEResult<T>> observer, Function0<Unit> onOpen, Function1<? super JSONObject, ? extends T> parser) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(parser, "parser");
        AICallYalog.INSTANCE.i("AICallApiService", "sendSSERequest url: " + url + " \nbody: " + params);
        return createSSERequest(url, params, new EventSourceListenerWrapper(new AICallApiService$sendSSERequest$1(onOpen, this, parser, observer)));
    }

    /* access modifiers changed from: private */
    public final <T> AICallSSEResult<T> wrapperAICallSSEResult(String event, T data) {
        return new AICallSSEResult<>(event, data);
    }

    /* access modifiers changed from: private */
    public final <T> AICallApiResult<AICallSSEResult<T>> wrapperSuccess(AICallSSEResult<T> data) {
        return new AICallApiResult("0", (String) null, data, (String) null, 10, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final <T> boolean isSuccessResult(AICallApiResult<T> result) {
        return Intrinsics.areEqual((Object) "0", (Object) result.getStatus()) && result.getData() != null;
    }

    private final GetRequest.GetRequestBuilder createGetRequest(String url) {
        HttpRequestBuilder requestSubFrom = ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(url)).cookieManager(AICallRuntime.INSTANCE.getNetworkContext().createCookieManager(false, false))).enableStat(true)).requestFrom(4)).requestSubFrom(1);
        Intrinsics.checkNotNullExpressionValue(requestSubFrom, "getDefault(AppRuntime.ge…tat.SubFrom.SEARCH_FRAME)");
        return (GetRequest.GetRequestBuilder) requestSubFrom;
    }

    private final EventSource createSSERequest(String url, JSONObject body, EventSourceListener sourceListener) {
        String $this$createSSERequest_u24lambda_u2d1_u24lambda_u2d0;
        HttpManager httpManager = HttpManager.getDefault(AppRuntime.getAppContext());
        CookieManager cookieManager = AICallRuntime.INSTANCE.getNetworkContext().createCookieManager(false, false);
        PostBodyRequest.PostBodyRequestBuilder postBodyRequestBuilder = (PostBodyRequest.PostBodyRequestBuilder) httpManager.postRequest().url(url);
        HashMap hashMap = new HashMap();
        HashMap $this$createSSERequest_u24lambda_u2d1 = hashMap;
        if (!(cookieManager == null || ($this$createSSERequest_u24lambda_u2d1_u24lambda_u2d0 = cookieManager.getCookie(url)) == null)) {
            $this$createSSERequest_u24lambda_u2d1.put("Cookie", $this$createSSERequest_u24lambda_u2d1_u24lambda_u2d0);
        }
        EventSource newEventSource = EventSources.createFactory(httpManager.getOkHttpClient()).newEventSource(((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) postBodyRequestBuilder.headers(hashMap)).enableStat(true)).requestFrom(4)).requestSubFrom(1)).requestBody(RequestBody.create(JSON, body.toString()))).build().getOkRequest(), sourceListener);
        Intrinsics.checkNotNullExpressionValue(newEventSource, "createFactory(httpManage…kRequest, sourceListener)");
        return newEventSource;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/chatsearch/aicall/repo/AICallApiService$Companion;", "", "()V", "JSON", "Lokhttp3/MediaType;", "KEY_DATA", "", "KEY_MSG", "KEY_STATUS", "STATUS_OK", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AICallApiService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
