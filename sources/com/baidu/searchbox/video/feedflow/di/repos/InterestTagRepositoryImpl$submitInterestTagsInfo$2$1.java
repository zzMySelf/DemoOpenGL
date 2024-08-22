package com.baidu.searchbox.video.feedflow.di.repos;

import com.baidu.searchbox.feed.detail.ext.common.OnDataLoaded;
import com.baidu.searchbox.feed.detail.ext.common.Result;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/feedflow/di/repos/InterestTagRepositoryImpl$submitInterestTagsInfo$2$1", "Lcom/baidu/searchbox/feed/detail/ext/common/OnDataLoaded;", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "", "onDataLoaded", "", "data", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InterestTagRepositoryImpl.kt */
public final class InterestTagRepositoryImpl$submitInterestTagsInfo$2$1 implements OnDataLoaded<Result<String>> {
    final /* synthetic */ Continuation<Result<String>> $cont;

    InterestTagRepositoryImpl$submitInterestTagsInfo$2$1(Continuation<? super Result<String>> $cont2) {
        this.$cont = $cont2;
    }

    public void onDataLoaded(Result<String> data) {
        String $this$onDataLoaded_u24lambda_u2d0;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof Result.Failure) {
            Result.Failure newData = new Result.Failure(new Throwable(((Result.Failure) data).getThrowable()));
            Continuation<Result<String>> continuation = this.$cont;
            Result.Companion companion = kotlin.Result.Companion;
            continuation.resumeWith(kotlin.Result.m8971constructorimpl(newData));
            return;
        }
        Result.Success success = data instanceof Result.Success ? (Result.Success) data : null;
        if (success == null || ($this$onDataLoaded_u24lambda_u2d0 = (String) success.getData()) == null) {
            Continuation<com.baidu.searchbox.feed.detail.ext.common.Result<String>> continuation2 = this.$cont;
            InterestTagRepositoryImpl$submitInterestTagsInfo$2$1 interestTagRepositoryImpl$submitInterestTagsInfo$2$1 = this;
            Result.Failure newData2 = new Result.Failure(new Throwable());
            Result.Companion companion2 = kotlin.Result.Companion;
            continuation2.resumeWith(kotlin.Result.m8971constructorimpl(newData2));
            return;
        }
        Continuation<com.baidu.searchbox.feed.detail.ext.common.Result<String>> continuation3 = this.$cont;
        Result.Success newDate = new Result.Success($this$onDataLoaded_u24lambda_u2d0);
        Result.Companion companion3 = kotlin.Result.Companion;
        continuation3.resumeWith(kotlin.Result.m8971constructorimpl(newDate));
    }
}
