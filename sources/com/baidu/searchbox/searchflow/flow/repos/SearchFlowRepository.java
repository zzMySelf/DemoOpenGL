package com.baidu.searchbox.searchflow.flow.repos;

import com.baidu.searchbox.feed.detail.ext.common.Result;
import com.baidu.searchbox.searchflow.flow.api.SearchFlowListBean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/searchflow/flow/repos/SearchFlowRepository;", "", "getFlowListData", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "Lcom/baidu/searchbox/searchflow/flow/api/SearchFlowListBean;", "listParam", "Lcom/baidu/searchbox/searchflow/flow/repos/SearchFlowRecListParam;", "(Lcom/baidu/searchbox/searchflow/flow/repos/SearchFlowRecListParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchFlowRepository.kt */
public interface SearchFlowRepository {
    Object getFlowListData(SearchFlowRecListParam searchFlowRecListParam, Continuation<? super Result<SearchFlowListBean>> continuation);
}
