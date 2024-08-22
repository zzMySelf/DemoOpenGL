package com.baidu.searchbox.video.feedflow.di.repos;

import com.baidu.searchbox.feed.detail.ext.common.OnDataLoaded;
import com.baidu.searchbox.feed.detail.ext.common.Result;
import com.baidu.searchbox.flowvideo.thirdparty.api.ThirdPartyBean;
import com.baidu.searchbox.flowvideo.thirdparty.map.ThirdPartyMapper;
import com.baidu.searchbox.flowvideo.thirdparty.repos.ThirdPartyModel;
import com.baidu.searchbox.flowvideo.thirdparty.repos.ThirdPartyParam;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/feedflow/di/repos/ThirdPartyRepositoryImpl$getThirdPartyData$2$1", "Lcom/baidu/searchbox/feed/detail/ext/common/OnDataLoaded;", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "Lcom/baidu/searchbox/flowvideo/thirdparty/api/ThirdPartyBean;", "onDataLoaded", "", "data", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThirdPartyRepositoryImpl.kt */
public final class ThirdPartyRepositoryImpl$getThirdPartyData$2$1 implements OnDataLoaded<Result<ThirdPartyBean>> {
    final /* synthetic */ Continuation<Result<ThirdPartyModel>> $cont;
    final /* synthetic */ ThirdPartyParam $param;

    ThirdPartyRepositoryImpl$getThirdPartyData$2$1(ThirdPartyParam $param2, Continuation<? super Result<ThirdPartyModel>> $cont2) {
        this.$param = $param2;
        this.$cont = $cont2;
    }

    public void onDataLoaded(Result<ThirdPartyBean> data) {
        ThirdPartyBean $this$onDataLoaded_u24lambda_u2d0;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof Result.Failure) {
            Result.Failure newData = new Result.Failure(new Throwable(this.$param.getNid(), ((Result.Failure) data).getThrowable()));
            Continuation<Result<ThirdPartyModel>> continuation = this.$cont;
            Result.Companion companion = kotlin.Result.Companion;
            continuation.resumeWith(kotlin.Result.m8971constructorimpl(newData));
            return;
        }
        Result.Success success = data instanceof Result.Success ? (Result.Success) data : null;
        if (success == null || ($this$onDataLoaded_u24lambda_u2d0 = (ThirdPartyBean) success.getData()) == null) {
            ThirdPartyParam thirdPartyParam = this.$param;
            Continuation<com.baidu.searchbox.feed.detail.ext.common.Result<ThirdPartyModel>> continuation2 = this.$cont;
            ThirdPartyRepositoryImpl$getThirdPartyData$2$1 thirdPartyRepositoryImpl$getThirdPartyData$2$1 = this;
            Result.Failure newData2 = new Result.Failure(new Throwable(thirdPartyParam.getNid()));
            Result.Companion companion2 = kotlin.Result.Companion;
            continuation2.resumeWith(kotlin.Result.m8971constructorimpl(newData2));
            return;
        }
        Continuation<com.baidu.searchbox.feed.detail.ext.common.Result<ThirdPartyModel>> continuation3 = this.$cont;
        Result.Success newDate = new Result.Success(ThirdPartyMapper.INSTANCE.map($this$onDataLoaded_u24lambda_u2d0));
        Result.Companion companion3 = kotlin.Result.Companion;
        continuation3.resumeWith(kotlin.Result.m8971constructorimpl(newDate));
    }
}
