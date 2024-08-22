package com.baidu.searchbox.feed.payment.payui.payPanel;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/payment/payui/payPanel/SubscriptionPanelViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PayProPanelView.kt */
final class PayProPanelView$viewSpModel$2 extends Lambda implements Function0<SubscriptionPanelViewModel> {
    final /* synthetic */ PayProPanelView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PayProPanelView$viewSpModel$2(PayProPanelView payProPanelView) {
        super(0);
        this.this$0 = payProPanelView;
    }

    public final SubscriptionPanelViewModel invoke() {
        return new SubscriptionPanelViewModel(this.this$0.ctx, this.this$0.payPanelManager, this.this$0.payInfo, this.this$0.payConfig);
    }
}
