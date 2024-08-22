package com.baidu.searchbox.feed.payment.combinationbuy;

import com.baidu.searchbox.feed.payment.model.PayStats1078;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CbProToolBarFacet.kt */
final class CbProToolBarFacet$createView$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CbProToolBarFacet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CbProToolBarFacet$createView$1$2(CbProToolBarFacet cbProToolBarFacet) {
        super(0);
        this.this$0 = cbProToolBarFacet;
    }

    public final void invoke() {
        CombinationBuyViewModel viewModel = this.this$0.cbContext.getViewModel();
        String columnId = this.this$0.cbContext.getColumnId();
        CombinationBuyViewModel viewModel2 = this.this$0.cbContext.getViewModel();
        CombinationBuyResponseData access$getData$p = this.this$0.data;
        new PayStats1078(viewModel.makePayInfo(columnId, viewModel2.getSelectedColumnIds(access$getData$p != null ? access$getData$p.columnList : null), this.this$0.cbContext.getServerTransit())).recordMergeBuyClick();
        if (this.this$0.isEnableBuy) {
            this.this$0.triggerPayAction();
        }
    }
}
