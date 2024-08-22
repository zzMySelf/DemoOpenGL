package com.baidu.searchbox.feed.payment.account;

import com.baidu.searchbox.account.ITokenListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuation;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/payment/account/SpColumnAccountDataManager$getToken$2$1", "Lcom/baidu/searchbox/account/ITokenListener;", "onGetTokenComplete", "", "tokenJsonObject", "Lorg/json/JSONObject;", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnAccountDataManager.kt */
public final class SpColumnAccountDataManager$getToken$2$1 implements ITokenListener {
    final /* synthetic */ CancellableContinuation<String> $cancellableContinuation;

    SpColumnAccountDataManager$getToken$2$1(CancellableContinuation<? super String> $cancellableContinuation2) {
        this.$cancellableContinuation = $cancellableContinuation2;
    }

    public void onGetTokenComplete(JSONObject tokenJsonObject) {
        String str = null;
        Integer errno = tokenJsonObject != null ? Integer.valueOf(tokenJsonObject.optInt("errno")) : null;
        Integer code = tokenJsonObject != null ? Integer.valueOf(tokenJsonObject.optInt("code")) : null;
        if (errno != null && errno.intValue() == 0 && code != null && code.intValue() == 0) {
            Continuation continuation = this.$cancellableContinuation;
            Result.Companion companion = Result.Companion;
            if (tokenJsonObject != null) {
                str = tokenJsonObject.optString("token");
            }
            continuation.resumeWith(Result.m8971constructorimpl(str));
            return;
        }
        Result.Companion companion2 = Result.Companion;
        this.$cancellableContinuation.resumeWith(Result.m8971constructorimpl((Object) null));
    }
}
