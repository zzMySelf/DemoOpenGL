package com.baidu.searchbox.video.feedflow.di.repos;

import com.baidu.searchbox.feed.detail.ext.common.OnDataLoaded;
import com.baidu.searchbox.feed.detail.ext.common.Result;
import com.baidu.searchbox.flowvideo.personalizedcontent.api.PersonalizedContentDataBean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/feedflow/di/repos/PersonalizedContentRepositoryImpl$getPersonalizedContentInfo$2$1", "Lcom/baidu/searchbox/feed/detail/ext/common/OnDataLoaded;", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "Lcom/baidu/searchbox/flowvideo/personalizedcontent/api/PersonalizedContentDataBean;", "onDataLoaded", "", "data", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalizedContentRepositoryImpl.kt */
public final class PersonalizedContentRepositoryImpl$getPersonalizedContentInfo$2$1 implements OnDataLoaded<Result<PersonalizedContentDataBean>> {
    final /* synthetic */ Continuation<Result<PersonalizedContentDataBean>> $cont;

    PersonalizedContentRepositoryImpl$getPersonalizedContentInfo$2$1(Continuation<? super Result<PersonalizedContentDataBean>> $cont2) {
        this.$cont = $cont2;
    }

    public void onDataLoaded(Result<PersonalizedContentDataBean> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof Result.Success) {
            Continuation<Result<PersonalizedContentDataBean>> continuation = this.$cont;
            Result.Companion companion = kotlin.Result.Companion;
            continuation.resumeWith(kotlin.Result.m8971constructorimpl(new Result.Success(((Result.Success) data).getData())));
        } else if (data instanceof Result.Failure) {
            Continuation<com.baidu.searchbox.feed.detail.ext.common.Result<PersonalizedContentDataBean>> continuation2 = this.$cont;
            Result.Companion companion2 = kotlin.Result.Companion;
            continuation2.resumeWith(kotlin.Result.m8971constructorimpl(new Result.Failure(((Result.Failure) data).getThrowable())));
        }
    }
}
