package com.baidu.searchbox.video.feedflow.di.repos;

import com.baidu.searchbox.common.CommonApi;
import com.baidu.searchbox.feed.detail.ext.common.Result;
import com.baidu.searchbox.flowvideo.simulate.VideoSimulateApi;
import com.baidu.searchbox.flowvideo.simulate.VideoSimulateBean;
import com.baidu.searchbox.flowvideo.simulate.VideoSimulateRepository;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/di/repos/VideoSimulateRepositoryImpl;", "Lcom/baidu/searchbox/flowvideo/simulate/VideoSimulateRepository;", "videoSimulateApi", "Lcom/baidu/searchbox/flowvideo/simulate/VideoSimulateApi;", "(Lcom/baidu/searchbox/flowvideo/simulate/VideoSimulateApi;)V", "getVideoSimulateModel", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "Lcom/baidu/searchbox/flowvideo/simulate/VideoSimulateBean;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSimulateRepositoryImpl.kt */
public final class VideoSimulateRepositoryImpl implements VideoSimulateRepository {
    private final VideoSimulateApi videoSimulateApi;

    public VideoSimulateRepositoryImpl(VideoSimulateApi videoSimulateApi2) {
        Intrinsics.checkNotNullParameter(videoSimulateApi2, "videoSimulateApi");
        this.videoSimulateApi = videoSimulateApi2;
    }

    public Object getVideoSimulateModel(Continuation<? super Result<VideoSimulateBean>> $completion) {
        SafeContinuation cont = new SafeContinuation(IntrinsicsKt.intercepted($completion));
        CommonApi.DefaultImpls.requestData$default(this.videoSimulateApi, new HashMap(), (Map) null, new VideoSimulateRepositoryImpl$getVideoSimulateModel$2$1(cont), 2, (Object) null);
        Object orThrow = cont.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return orThrow;
    }
}
