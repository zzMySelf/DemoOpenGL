package com.baidu.searchbox.feed.payment.payui.payPanel;

import com.baidu.searchbox.feed.payment.model.ProductsItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/searchbox/feed/payment/model/ProductsItem;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PayProPanelView.kt */
final class PayProPanelView$updateSpView$3$2 extends Lambda implements Function1<ProductsItem, Unit> {
    final /* synthetic */ PayProPanelView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PayProPanelView$updateSpView$3$2(PayProPanelView payProPanelView) {
        super(1);
        this.this$0 = payProPanelView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ProductsItem) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(ProductsItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.this$0.getViewModel().onProRadioButtonSelected(this.this$0.getViewSpModel().isAutoPayProduct(it), it);
    }
}
