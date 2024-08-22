package com.baidu.searchbox.searchflow.secondpage;

import com.baidu.searchbox.feed.detail.ext.common.OnDataLoaded;
import com.baidu.searchbox.feed.detail.ext.common.Result;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002JZ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0018\u00010\rH&¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/searchflow/secondpage/SearchFlowSecondPageApi;", "T", "", "requestData", "", "requestType", "", "path", "", "post", "", "get", "callback", "Lcom/baidu/searchbox/feed/detail/ext/common/OnDataLoaded;", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchFlowSecondPageApi.kt */
public interface SearchFlowSecondPageApi<T> {
    void requestData(int i2, String str, Map<String, String> map, Map<String, String> map2, OnDataLoaded<Result<T>> onDataLoaded);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchFlowSecondPageApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void requestData$default(SearchFlowSecondPageApi searchFlowSecondPageApi, int i2, String str, Map map, Map map2, OnDataLoaded onDataLoaded, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    map2 = null;
                }
                searchFlowSecondPageApi.requestData(i2, str, map, map2, onDataLoaded);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestData");
        }
    }
}
