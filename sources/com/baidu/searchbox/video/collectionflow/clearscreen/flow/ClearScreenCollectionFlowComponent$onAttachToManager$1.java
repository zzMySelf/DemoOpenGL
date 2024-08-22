package com.baidu.searchbox.video.collectionflow.clearscreen.flow;

import com.baidu.searchbox.video.component.autoplay.service.IAutoPlayService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/video/collectionflow/clearscreen/flow/ClearScreenCollectionFlowComponent$onAttachToManager$1", "Lcom/baidu/searchbox/video/component/autoplay/service/IAutoPlayService;", "playNext", "", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearScreenCollectionFlowComponent.kt */
public final class ClearScreenCollectionFlowComponent$onAttachToManager$1 implements IAutoPlayService {
    final /* synthetic */ ClearScreenCollectionFlowComponent this$0;

    ClearScreenCollectionFlowComponent$onAttachToManager$1(ClearScreenCollectionFlowComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void playNext() {
        this.this$0.scrollToNext();
    }
}
