package com.baidu.searchbox.video.feedflow.di.repos;

import com.baidu.searchbox.feed.detail.ext.common.OnDataLoaded;
import com.baidu.searchbox.feed.detail.ext.common.Result;
import com.baidu.searchbox.flowvideo.theater.api.TheaterTopBean;
import com.baidu.searchbox.flowvideo.theater.mapper.TheaterTopMapper;
import com.baidu.searchbox.flowvideo.theater.repos.TheaterTopModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/feedflow/di/repos/TheaterFlowRepositoryImpl$getTheaterTopData$2$1", "Lcom/baidu/searchbox/feed/detail/ext/common/OnDataLoaded;", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "Lcom/baidu/searchbox/flowvideo/theater/api/TheaterTopBean;", "onDataLoaded", "", "data", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TheaterFlowRepositoryImpl.kt */
public final class TheaterFlowRepositoryImpl$getTheaterTopData$2$1 implements OnDataLoaded<Result<TheaterTopBean>> {
    final /* synthetic */ Continuation<Result<TheaterTopModel>> $cont;

    TheaterFlowRepositoryImpl$getTheaterTopData$2$1(Continuation<? super Result<TheaterTopModel>> $cont2) {
        this.$cont = $cont2;
    }

    public void onDataLoaded(Result<TheaterTopBean> data) {
        Unit unit;
        Throwable th2;
        Intrinsics.checkNotNullParameter(data, "data");
        Result.Failure failure = null;
        if ((data instanceof Result.Success ? (Result.Success) data : null) != null) {
            Continuation<Result<TheaterTopModel>> continuation = this.$cont;
            TheaterTopModel model = TheaterTopMapper.INSTANCE.map((TheaterTopBean) ((Result.Success) data).getData());
            Result.Companion companion = kotlin.Result.Companion;
            continuation.resumeWith(kotlin.Result.m8971constructorimpl(new Result.Success(model)));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Continuation<com.baidu.searchbox.feed.detail.ext.common.Result<TheaterTopModel>> continuation2 = this.$cont;
            TheaterFlowRepositoryImpl$getTheaterTopData$2$1 theaterFlowRepositoryImpl$getTheaterTopData$2$1 = this;
            if (data instanceof Result.Failure) {
                failure = (Result.Failure) data;
            }
            if (failure == null || (th2 = failure.getThrowable()) == null) {
                th2 = new Throwable();
            }
            Result.Failure failure2 = new Result.Failure(th2);
            Result.Companion companion2 = kotlin.Result.Companion;
            continuation2.resumeWith(kotlin.Result.m8971constructorimpl(failure2));
        }
    }
}
