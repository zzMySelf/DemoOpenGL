package com.baidu.searchbox.searchflow.detail.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.detail.mapper.FlowDetailQueryModelMapper;
import com.baidu.searchbox.flowvideo.detail.mapper.FlowDetailSearchMapper;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailQueryModel;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailSearchModel;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailTopBarModel;
import com.baidu.searchbox.searchflow.detail.api.QueryBean;
import com.baidu.searchbox.searchflow.detail.api.SearchFlowTopBarBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/searchflow/detail/mapper/SearchFlowDetailTopBarMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/searchflow/detail/api/SearchFlowTopBarBean;", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailTopBarModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchFlowDetailTopBarMapper.kt */
public final class SearchFlowDetailTopBarMapper implements Mapper<SearchFlowTopBarBean, FlowDetailTopBarModel> {
    public static final SearchFlowDetailTopBarMapper INSTANCE = new SearchFlowDetailTopBarMapper();

    private SearchFlowDetailTopBarMapper() {
    }

    public FlowDetailTopBarModel map(SearchFlowTopBarBean input) {
        QueryBean queryBean = null;
        FlowDetailTopBarModel flowDetailTopBarModel = new FlowDetailTopBarModel((FlowDetailSearchModel) null, (FlowDetailQueryModel) null, 3, (DefaultConstructorMarker) null);
        FlowDetailTopBarModel $this$map_u24lambda_u2d0 = flowDetailTopBarModel;
        $this$map_u24lambda_u2d0.setSearch(FlowDetailSearchMapper.INSTANCE.map(input != null ? input.getSearch() : null));
        FlowDetailQueryModelMapper flowDetailQueryModelMapper = FlowDetailQueryModelMapper.INSTANCE;
        if (input != null) {
            queryBean = input.getQuery();
        }
        $this$map_u24lambda_u2d0.setQuery(flowDetailQueryModelMapper.map(queryBean));
        return flowDetailTopBarModel;
    }
}
