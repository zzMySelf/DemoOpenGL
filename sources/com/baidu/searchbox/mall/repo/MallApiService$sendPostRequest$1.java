package com.baidu.searchbox.mall.repo;

import com.baidu.searchbox.http.callback.ResponseCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import org.json.JSONObject;
import rx.SingleSubscriber;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u001e\u0010\b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/mall/repo/MallApiService$sendPostRequest$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "Lcom/baidu/searchbox/mall/repo/MallApiResult;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "statusCode", "", "parseResponse", "resp", "Lokhttp3/Response;", "lib-search-mall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MallApiService.kt */
public final class MallApiService$sendPostRequest$1 extends ResponseCallback<MallApiResult<T>> {
    final /* synthetic */ Function1<JSONObject, T> $parser;
    final /* synthetic */ SingleSubscriber<? super T> $subscriber;
    final /* synthetic */ MallApiService this$0;

    MallApiService$sendPostRequest$1(MallApiService $receiver, Function1<? super JSONObject, ? extends T> $parser2, SingleSubscriber<? super T> $subscriber2) {
        this.this$0 = $receiver;
        this.$parser = $parser2;
        this.$subscriber = $subscriber2;
    }

    public MallApiResult<T> parseResponse(Response resp, int statusCode) throws Exception {
        Intrinsics.checkNotNullParameter(resp, "resp");
        return this.this$0.buildMallApiResult(resp, this.$parser);
    }

    public void onSuccess(MallApiResult<T> result, int statusCode) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (!this.this$0.isSuccessResult(result, statusCode) || result.getData() == null) {
            this.$subscriber.onError(new Throwable(result.getMessage()));
        } else {
            this.$subscriber.onSuccess(result.getData());
        }
    }

    public void onFail(Exception e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        this.$subscriber.onError(e2);
    }
}
