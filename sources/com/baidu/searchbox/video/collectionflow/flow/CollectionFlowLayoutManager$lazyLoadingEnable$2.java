package com.baidu.searchbox.video.collectionflow.flow;

import com.baidu.searchbox.feed.detail.arch.anno.Level;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionFlowLayoutManager.kt */
final class CollectionFlowLayoutManager$lazyLoadingEnable$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ CollectionFlowLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectionFlowLayoutManager$lazyLoadingEnable$2(CollectionFlowLayoutManager collectionFlowLayoutManager) {
        super(0);
        this.this$0 = collectionFlowLayoutManager;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(FlowSwitchStateKt.componentLazyLoadingSwitch((Store<?>) this.this$0.getManager().getStore(), Level.TAB));
    }
}
