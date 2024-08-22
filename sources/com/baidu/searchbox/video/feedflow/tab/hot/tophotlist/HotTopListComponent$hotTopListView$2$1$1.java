package com.baidu.searchbox.video.feedflow.tab.hot.tophotlist;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.component.router.RouterAction;
import com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemDataModel;
import com.baidu.searchbox.video.feedflow.flow.comonlistpanel.HotListItemModel;
import com.baidu.searchbox.video.feedflow.tab.hot.tophotlist.HotTopListAction;
import com.baidu.searchbox.video.feedflow.tab.hot.tophotlist.HotTopListAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/video/feedflow/tab/hot/tophotlist/HotTopListComponent$hotTopListView$2$1$1", "Lcom/baidu/searchbox/video/feedflow/tab/hot/tophotlist/HotTopListAdapter$IOnItemClickListener;", "onItemClicked", "", "position", "", "itemModel", "Lcom/baidu/searchbox/video/feedflow/flow/comonlistpanel/HotListItemModel;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotTopListComponent.kt */
public final class HotTopListComponent$hotTopListView$2$1$1 implements HotTopListAdapter.IOnItemClickListener {
    final /* synthetic */ HotTopListComponent this$0;

    HotTopListComponent$hotTopListView$2$1$1(HotTopListComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onItemClicked(int position, HotListItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        HotListItemDataModel $this$onItemClicked_u24lambda_u2d0 = itemModel.getData();
        if ($this$onItemClicked_u24lambda_u2d0 != null) {
            HotTopListComponent hotTopListComponent = this.this$0;
            Store access$getStore = hotTopListComponent.getStore();
            if (access$getStore != null) {
                StoreExtKt.post(access$getStore, new RouterAction($this$onItemClicked_u24lambda_u2d0.getCmd()));
            }
            Store access$getStore2 = hotTopListComponent.getStore();
            if (access$getStore2 != null) {
                StoreExtKt.post(access$getStore2, new HotTopListAction.OnPanelItemClick(position, itemModel));
            }
        }
    }
}
