package com.baidu.searchbox.video.feedflow.tab.recommend;

import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecommendFlowComponentRegister.kt */
final class RecommendFlowComponentRegister$collectPlugin$2 extends Lambda implements Function0<IPlugin> {
    final /* synthetic */ RecommendFlowComponentRegister this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecommendFlowComponentRegister$collectPlugin$2(RecommendFlowComponentRegister recommendFlowComponentRegister) {
        super(0);
        this.this$0 = recommendFlowComponentRegister;
    }

    public final IPlugin invoke() {
        return this.this$0.provider.getRecommendFlowDataSourceSwitchUnit().createPlugin();
    }
}
