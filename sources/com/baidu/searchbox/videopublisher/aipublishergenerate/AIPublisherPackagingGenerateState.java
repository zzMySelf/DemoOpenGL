package com.baidu.searchbox.videopublisher.aipublishergenerate;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.videopublisher.aipublishergenerate.generateinfo.manager.model.AiPublisherPackageQueryData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R0\u0010\u0003\u001a\u001e\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/videopublisher/aipublishergenerate/AIPublisherPackagingGenerateState;", "", "()V", "genCoverTitleResultState", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Lkotlin/Result;", "", "Lcom/baidu/searchbox/videopublisher/aipublishergenerate/generateinfo/manager/model/AiPublisherPackageQueryData;", "getGenCoverTitleResultState", "()Landroidx/lifecycle/MutableLiveData;", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AIPublisherPackagingGenerateState.kt */
public final class AIPublisherPackagingGenerateState {
    private final MutableLiveData<Pair<Result<Integer>, AiPublisherPackageQueryData>> genCoverTitleResultState = new MutableLiveData<>();

    public final MutableLiveData<Pair<Result<Integer>, AiPublisherPackageQueryData>> getGenCoverTitleResultState() {
        return this.genCoverTitleResultState;
    }
}
