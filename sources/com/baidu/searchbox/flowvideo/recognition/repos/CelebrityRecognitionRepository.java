package com.baidu.searchbox.flowvideo.recognition.repos;

import com.baidu.searchbox.feed.detail.ext.common.Result;
import com.baidu.searchbox.flowvideo.recognition.api.CelebrityRecognitionRequestParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/flowvideo/recognition/repos/CelebrityRecognitionRepository;", "", "getCelebrityRecognitionData", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "Lcom/baidu/searchbox/flowvideo/recognition/repos/CelebrityRecognitionModel;", "params", "Lcom/baidu/searchbox/flowvideo/recognition/api/CelebrityRecognitionRequestParams;", "(Lcom/baidu/searchbox/flowvideo/recognition/api/CelebrityRecognitionRequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CelebrityRecognitionRepository.kt */
public interface CelebrityRecognitionRepository {
    Object getCelebrityRecognitionData(CelebrityRecognitionRequestParams celebrityRecognitionRequestParams, Continuation<? super Result<CelebrityRecognitionModel>> continuation);
}
