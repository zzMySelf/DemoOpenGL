package com.baidu.searchbox.feed.util.processor;

import com.baidu.searchbox.http.callback.StringResponseCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/feed/util/processor/PraiseRequestProcessorKt$praiseRequest$callback$1", "Lcom/baidu/searchbox/http/callback/StringResponseCallback;", "onFail", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "response", "", "statusCode", "", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseRequestProcessor.kt */
public final class PraiseRequestProcessorKt$praiseRequest$callback$1 extends StringResponseCallback {
    PraiseRequestProcessorKt$praiseRequest$callback$1() {
    }

    public void onSuccess(String response, int statusCode) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public void onFail(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
    }
}
