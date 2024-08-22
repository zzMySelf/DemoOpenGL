package com.baidu.searchbox.bigimage.model;

import com.baidu.searchbox.http.callback.ResponseCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;
import rx.SingleSubscriber;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016J\u001d\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u0004\u0018\u00018\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"com/baidu/searchbox/bigimage/model/BigImageApiService$sendGetRequest$2", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "statusCode", "", "(Ljava/lang/Object;I)V", "parseResponse", "resp", "Lokhttp3/Response;", "(Lokhttp3/Response;I)Ljava/lang/Object;", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BigImageApiService.kt */
public final class BigImageApiService$sendGetRequest$2 extends ResponseCallback<T> {
    final /* synthetic */ Function1<String, T> $parser;
    final /* synthetic */ SingleSubscriber<T> $subscriber;

    BigImageApiService$sendGetRequest$2(Function1<? super String, ? extends T> $parser2, SingleSubscriber<T> $subscriber2) {
        this.$parser = $parser2;
        this.$subscriber = $subscriber2;
    }

    public T parseResponse(Response resp, int statusCode) throws Exception {
        if (resp == null || !resp.isSuccessful() || resp.body() == null) {
            return null;
        }
        Function1<String, T> function1 = this.$parser;
        ResponseBody body = resp.body();
        Intrinsics.checkNotNull(body);
        return function1.invoke(body.string());
    }

    public void onSuccess(T result, int statusCode) {
        this.$subscriber.onSuccess(result);
    }

    public void onFail(Exception e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        this.$subscriber.onError(e2);
    }
}
