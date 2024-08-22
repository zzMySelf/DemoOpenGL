package com.baidu.searchbox.feed.payment.payui.payPanel;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.feed.payment.model.PayPanelData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/Observer;", "Lcom/baidu/searchbox/feed/payment/model/PayPanelData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PayPanelViewDialog.kt */
final class PayPanelViewDialog$payPanelObserver$2 extends Lambda implements Function0<Observer<PayPanelData>> {
    final /* synthetic */ PayPanelViewDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PayPanelViewDialog$payPanelObserver$2(PayPanelViewDialog payPanelViewDialog) {
        super(0);
        this.this$0 = payPanelViewDialog;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m19224invoke$lambda0(PayPanelViewDialog this$02, PayPanelData payPanelData) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullExpressionValue(payPanelData, "payPanelData");
        this$02.updateView(payPanelData);
    }

    public final Observer<PayPanelData> invoke() {
        return new PayPanelViewDialog$payPanelObserver$2$$ExternalSyntheticLambda0(this.this$0);
    }
}
