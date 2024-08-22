package com.baidu.searchbox.video.feedflow.ad.position;

import com.baidu.searchbox.ad.position.strategy.AdPosStrategyManager;
import com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a$\u0012\u0010\u0012\u000e\u0012\u0002\b\u00030\u0002j\u0006\u0012\u0002\b\u0003`\u0003\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0001H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/ad/position/strategy/AdPosStrategyManager;", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "Lcom/baidu/searchbox/video/feedflow/ad/FlowItem;", "Lcom/baidu/searchbox/video/feedflow/ad/flow/AdItemModel;", "Lcom/baidu/searchbox/video/feedflow/flow/list/VideoItemModel;", "Lcom/baidu/searchbox/video/feedflow/ad/FlowVideoItemModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdPositionPlugin.kt */
final class AdPositionPlugin$posMgrPortrait$2 extends Lambda implements Function0<AdPosStrategyManager<ItemModel<?>, AdItemModel, VideoItemModel>> {
    final /* synthetic */ AdPositionPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdPositionPlugin$posMgrPortrait$2(AdPositionPlugin adPositionPlugin) {
        super(0);
        this.this$0 = adPositionPlugin;
    }

    public final AdPosStrategyManager<ItemModel<?>, AdItemModel, VideoItemModel> invoke() {
        AdPosStrategyManager adPosStrategyManager = new AdPosStrategyManager(this.this$0.getHelperPortrait());
        AdPositionPlugin adPositionPlugin = this.this$0;
        AdPosStrategyManager $this$invoke_u24lambda_u2d0 = adPosStrategyManager;
        $this$invoke_u24lambda_u2d0.setRequestCallback(adPositionPlugin.requestCb);
        $this$invoke_u24lambda_u2d0.setInsertCallback(adPositionPlugin.insertCb);
        return adPosStrategyManager;
    }
}
