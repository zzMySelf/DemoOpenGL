package com.baidu.searchbox.video.feedflow.detail.batch;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.detail.batch.BatchCardAction;
import com.baidu.searchbox.video.feedflow.detail.batch.view.OnBatchItemConsumeListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/batch/BatchCardComponent$onBatchItemConsumeListener$1", "Lcom/baidu/searchbox/video/feedflow/detail/batch/view/OnBatchItemConsumeListener;", "onBatchItemConsumed", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BatchCardComponent.kt */
public final class BatchCardComponent$onBatchItemConsumeListener$1 implements OnBatchItemConsumeListener {
    final /* synthetic */ BatchCardComponent this$0;

    BatchCardComponent$onBatchItemConsumeListener$1(BatchCardComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onBatchItemConsumed() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(BatchCardAction.OnBatchConsume.INSTANCE);
        }
        Store access$getStore2 = this.this$0.getStore();
        if (access$getStore2 != null) {
            access$getStore2.dispatch(BatchCardAction.OnAllAuthorFollowed.INSTANCE);
        }
    }
}
