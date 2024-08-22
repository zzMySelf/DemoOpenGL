package com.baidu.searchbox.video.feedflow.ad.nextcontent;

import android.util.AttributeSet;
import android.view.ViewGroup;
import com.baidu.searchbox.video.feedflow.detail.nextcontent.RecommendNextContentView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/detail/nextcontent/RecommendNextContentView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadRecommendNextContentComponent.kt */
final class NadRecommendNextContentComponent$recommendNextContentView$2 extends Lambda implements Function0<RecommendNextContentView> {
    final /* synthetic */ NadRecommendNextContentComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadRecommendNextContentComponent$recommendNextContentView$2(NadRecommendNextContentComponent nadRecommendNextContentComponent) {
        super(0);
        this.this$0 = nadRecommendNextContentComponent;
    }

    public final RecommendNextContentView invoke() {
        RecommendNextContentView recommendNextContentView = new RecommendNextContentView(this.this$0.getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        NadRecommendNextContentComponent nadRecommendNextContentComponent = this.this$0;
        RecommendNextContentView $this$invoke_u24lambda_u2d0 = recommendNextContentView;
        $this$invoke_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        $this$invoke_u24lambda_u2d0.setVisibility(8);
        $this$invoke_u24lambda_u2d0.setIRecommendNextContentViewClickListener(new NadRecommendNextContentComponent$recommendNextContentView$2$1$1(nadRecommendNextContentComponent));
        $this$invoke_u24lambda_u2d0.setRecommendShowNextContentIconShow(nadRecommendNextContentComponent.isRecommendShowNextContentIconShow());
        return recommendNextContentView;
    }
}
