package com.baidu.searchbox.video.feedflow.detail.collectonselectset;

import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/detail/player/service/IPlayerComponentService;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionSelectSetsComponent.kt */
final class CollectionSelectSetsComponent$playerService$2 extends Lambda implements Function0<IPlayerComponentService> {
    final /* synthetic */ CollectionSelectSetsComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectionSelectSetsComponent$playerService$2(CollectionSelectSetsComponent collectionSelectSetsComponent) {
        super(0);
        this.this$0 = collectionSelectSetsComponent;
    }

    public final IPlayerComponentService invoke() {
        return (IPlayerComponentService) this.this$0.getManager().getService(IPlayerComponentService.class);
    }
}
