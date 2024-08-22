package com.baidu.searchbox.flowvideo.hot.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.flow.api.ListItemBean;
import com.baidu.searchbox.flowvideo.hot.api.HotListBean;
import com.baidu.searchbox.flowvideo.hot.repos.HotListModel;
import com.baidu.searchbox.flowvideo.hot.repos.HotPoliciesModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/flowvideo/hot/mapper/HotListMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/hot/api/HotListBean;", "Lcom/baidu/searchbox/flowvideo/hot/repos/HotListModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotListMapper.kt */
public final class HotListMapper implements Mapper<HotListBean, HotListModel> {
    public static final HotListMapper INSTANCE = new HotListMapper();

    private HotListMapper() {
    }

    public HotListModel map(HotListBean input) {
        HotPoliciesModel hotPoliciesModel;
        List list;
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.getPolicies() != null) {
            hotPoliciesModel = HotPolicesMapper.INSTANCE.map(input.getPolicies());
        } else {
            hotPoliciesModel = null;
        }
        String hasMore = input.getHasMore();
        String hasPrev = input.getHasPrev();
        if (input.getItems() != null) {
            List tmp = new ArrayList();
            for (ListItemBean item : input.getItems()) {
                tmp.add(HotItemMapper.INSTANCE.map(item));
            }
            list = tmp;
        } else {
            list = null;
        }
        return new HotListModel(hotPoliciesModel, hasPrev, hasMore, list, (String) null, input.isOffline(), 16, (DefaultConstructorMarker) null);
    }
}
