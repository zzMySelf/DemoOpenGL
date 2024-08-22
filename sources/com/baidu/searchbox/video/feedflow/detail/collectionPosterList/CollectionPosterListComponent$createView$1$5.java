package com.baidu.searchbox.video.feedflow.detail.collectionPosterList;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListAction;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/collectionPosterList/CollectionPosterListComponent$createView$1$5", "Lcom/baidu/searchbox/video/feedflow/detail/collectionPosterList/OnRecyclerScrollListener;", "onRecyclerScrollEnd", "", "onRecyclerScrollStart", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionPosterListComponent.kt */
public final class CollectionPosterListComponent$createView$1$5 implements OnRecyclerScrollListener {
    final /* synthetic */ CollectionPosterListComponent this$0;

    CollectionPosterListComponent$createView$1$5(CollectionPosterListComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onRecyclerScrollStart() {
        if (!this.this$0.scrollActionSend) {
            this.this$0.scrollActionSend = true;
        }
    }

    public void onRecyclerScrollEnd() {
        if (this.this$0.scrollActionSend) {
            CollectionPosterListComponent.requestVisibleItemDetailData$default(this.this$0, 0, 1, (Object) null);
            Store access$getStore = this.this$0.getStore();
            if (access$getStore != null) {
                StoreExtKt.post(access$getStore, CollectionPosterListAction.UploadShowStatistic.INSTANCE);
            }
            this.this$0.scrollActionSend = false;
        }
    }
}
