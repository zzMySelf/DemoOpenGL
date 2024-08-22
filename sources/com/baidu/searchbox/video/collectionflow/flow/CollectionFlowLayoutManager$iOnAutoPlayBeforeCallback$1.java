package com.baidu.searchbox.video.collectionflow.flow;

import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.autoplay.IOnAutoPlayBeforeCallback;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/video/collectionflow/flow/CollectionFlowLayoutManager$iOnAutoPlayBeforeCallback$1", "Lcom/baidu/searchbox/video/component/autoplay/IOnAutoPlayBeforeCallback;", "onPlayNextBefore", "", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionFlowLayoutManager.kt */
public final class CollectionFlowLayoutManager$iOnAutoPlayBeforeCallback$1 implements IOnAutoPlayBeforeCallback {
    final /* synthetic */ CollectionFlowLayoutManager this$0;

    CollectionFlowLayoutManager$iOnAutoPlayBeforeCallback$1(CollectionFlowLayoutManager $receiver) {
        this.this$0 = $receiver;
    }

    public void onPlayNextBefore() {
        IFlowComponentService iFlowComponentService = (IFlowComponentService) this.this$0.getManager().getService(IFlowComponentService.class);
        if (iFlowComponentService != null) {
            int curPosition = iFlowComponentService.getCurItemPosition();
            IFlowComponentService iFlowComponentService2 = (IFlowComponentService) this.this$0.getManager().getService(IFlowComponentService.class);
            if (BdPlayerUtils.orFalse(iFlowComponentService2 != null ? Boolean.valueOf(iFlowComponentService2.isRealLastOne(curPosition)) : null) && this.this$0.isSupportSimilarCollection()) {
                this.this$0.insertAndScrollSimilarCollectionData(false);
            }
        }
    }
}
