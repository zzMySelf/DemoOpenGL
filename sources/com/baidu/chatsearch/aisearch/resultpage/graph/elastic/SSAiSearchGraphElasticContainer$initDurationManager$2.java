package com.baidu.chatsearch.aisearch.resultpage.graph.elastic;

import com.baidu.chatsearch.aisearch.resultpage.SSAiResultPageBrowserView;
import com.baidu.chatsearch.model.ubc.LidData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/chatsearch/model/ubc/LidData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SSAiSearchGraphElasticContainer.kt */
final class SSAiSearchGraphElasticContainer$initDurationManager$2 extends Lambda implements Function0<LidData> {
    final /* synthetic */ SSAiSearchGraphElasticContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SSAiSearchGraphElasticContainer$initDurationManager$2(SSAiSearchGraphElasticContainer sSAiSearchGraphElasticContainer) {
        super(0);
        this.this$0 = sSAiSearchGraphElasticContainer;
    }

    public final LidData invoke() {
        SSAiResultPageBrowserView browserView = this.this$0.getBrowserView();
        if (browserView != null) {
            return browserView.getLidData();
        }
        return null;
    }
}
