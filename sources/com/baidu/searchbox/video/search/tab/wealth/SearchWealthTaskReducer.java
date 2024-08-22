package com.baidu.searchbox.video.search.tab.wealth;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.tab.wealth.WealthTaskReducer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/search/tab/wealth/SearchWealthTaskReducer;", "Lcom/baidu/searchbox/video/feedflow/tab/wealth/WealthTaskReducer;", "()V", "isCacheVideo", "", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "itemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "isNeedAvoidFirstVideo", "search-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchWealthTaskReducer.kt */
public final class SearchWealthTaskReducer extends WealthTaskReducer {
    public boolean isNeedAvoidFirstVideo(CommonState state, ItemModel<?> itemModel) {
        Intrinsics.checkNotNullParameter(state, "state");
        return CommonStateExtKt.isFirstJump(state, itemModel);
    }

    public boolean isCacheVideo(CommonState state, ItemModel<?> itemModel) {
        Intrinsics.checkNotNullParameter(state, "state");
        return false;
    }
}
