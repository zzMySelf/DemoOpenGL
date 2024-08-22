package com.baidu.searchbox.video.feedflow.di.repos;

import com.baidu.searchbox.common.CommonApi;
import com.baidu.searchbox.feed.detail.ext.common.Result;
import com.baidu.searchbox.flowvideo.kuaishoucommand.KuaishouCommandParam;
import com.baidu.searchbox.flowvideo.kuaishoucommand.KuaishouCommandRepository;
import com.baidu.searchbox.flowvideo.kuaishoucommand.KuaishouDataModel;
import com.baidu.searchbox.flowvideo.kuaishoucommand.api.KuaishouApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/di/repos/KuaishouCommandRepositoryImpl;", "Lcom/baidu/searchbox/flowvideo/kuaishoucommand/KuaishouCommandRepository;", "kuaishouApi", "Lcom/baidu/searchbox/flowvideo/kuaishoucommand/api/KuaishouApi;", "(Lcom/baidu/searchbox/flowvideo/kuaishoucommand/api/KuaishouApi;)V", "getKuaishouCommandData", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "Lcom/baidu/searchbox/flowvideo/kuaishoucommand/KuaishouDataModel;", "param", "Lcom/baidu/searchbox/flowvideo/kuaishoucommand/KuaishouCommandParam;", "(Lcom/baidu/searchbox/flowvideo/kuaishoucommand/KuaishouCommandParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KuaishouCommandRepositoryImpl.kt */
public final class KuaishouCommandRepositoryImpl implements KuaishouCommandRepository {
    private final KuaishouApi kuaishouApi;

    public KuaishouCommandRepositoryImpl(KuaishouApi kuaishouApi2) {
        Intrinsics.checkNotNullParameter(kuaishouApi2, "kuaishouApi");
        this.kuaishouApi = kuaishouApi2;
    }

    public Object getKuaishouCommandData(KuaishouCommandParam param, Continuation<? super Result<KuaishouDataModel>> $completion) {
        SafeContinuation cont = new SafeContinuation(IntrinsicsKt.intercepted($completion));
        CommonApi.DefaultImpls.requestData$default(this.kuaishouApi, param.toDataMap(), (Map) null, new KuaishouCommandRepositoryImpl$getKuaishouCommandData$2$1(cont), 2, (Object) null);
        Object orThrow = cont.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return orThrow;
    }
}
