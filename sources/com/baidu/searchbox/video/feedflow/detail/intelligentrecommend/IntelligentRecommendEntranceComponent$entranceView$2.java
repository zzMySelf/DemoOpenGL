package com.baidu.searchbox.video.feedflow.detail.intelligentrecommend;

import com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.view.IIntelligentRecommendEntranceView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/detail/intelligentrecommend/view/IIntelligentRecommendEntranceView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntelligentRecommendEntranceComponent.kt */
final class IntelligentRecommendEntranceComponent$entranceView$2 extends Lambda implements Function0<IIntelligentRecommendEntranceView> {
    final /* synthetic */ IntelligentRecommendEntranceComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntelligentRecommendEntranceComponent$entranceView$2(IntelligentRecommendEntranceComponent intelligentRecommendEntranceComponent) {
        super(0);
        this.this$0 = intelligentRecommendEntranceComponent;
    }

    public final IIntelligentRecommendEntranceView invoke() {
        IIntelligentRecommendEntranceView $this$invoke_u24lambda_u2d0 = this.this$0.createEntranceView();
        $this$invoke_u24lambda_u2d0.getView().setVisibility(8);
        return $this$invoke_u24lambda_u2d0;
    }
}
