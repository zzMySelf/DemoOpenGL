package com.baidu.searchbox.feed.payment.core.manager.payPanel;

import com.baidu.searchbox.feed.payment.PayResponseCallback;
import com.baidu.searchbox.feed.payment.core.model.PayInfo;
import com.baidu.searchbox.feed.payment.model.SubscriptionPanelData;
import kotlin.jvm.functions.Function3;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PayPanelManager$$ExternalSyntheticLambda0 implements PayResponseCallback {
    public final /* synthetic */ PayPanelManager f$0;
    public final /* synthetic */ PayInfo f$1;
    public final /* synthetic */ Function3 f$2;

    public /* synthetic */ PayPanelManager$$ExternalSyntheticLambda0(PayPanelManager payPanelManager, PayInfo payInfo, Function3 function3) {
        this.f$0 = payPanelManager;
        this.f$1 = payInfo;
        this.f$2 = function3;
    }

    public final void onResponse(boolean z, Object obj, Exception exc) {
        PayPanelManager.m19125getSubscriptionPanelDataAsync$lambda1(this.f$0, this.f$1, this.f$2, z, (SubscriptionPanelData) obj, exc);
    }
}
