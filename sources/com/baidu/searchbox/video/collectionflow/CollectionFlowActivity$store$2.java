package com.baidu.searchbox.video.collectionflow;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsStore;
import com.baidu.searchbox.video.assemble.creator.CollectionArchCreator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionFlowActivity.kt */
final class CollectionFlowActivity$store$2 extends Lambda implements Function0<AbsStore<CommonState>> {
    final /* synthetic */ CollectionFlowActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectionFlowActivity$store$2(CollectionFlowActivity collectionFlowActivity) {
        super(0);
        this.this$0 = collectionFlowActivity;
    }

    public final AbsStore<CommonState> invoke() {
        return CollectionArchCreator.Impl.INSTANCE.get().createStore(this.this$0.getVideoBusiness());
    }
}
