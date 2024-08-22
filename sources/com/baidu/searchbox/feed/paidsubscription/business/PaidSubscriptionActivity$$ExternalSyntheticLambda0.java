package com.baidu.searchbox.feed.paidsubscription.business;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.feed.payment.widget.StickyFrame;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PaidSubscriptionActivity$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ PaidSubscriptionActivity f$0;
    public final /* synthetic */ StickyFrame f$1;

    public /* synthetic */ PaidSubscriptionActivity$$ExternalSyntheticLambda0(PaidSubscriptionActivity paidSubscriptionActivity, StickyFrame stickyFrame) {
        this.f$0 = paidSubscriptionActivity;
        this.f$1 = stickyFrame;
    }

    public final void onChanged(Object obj) {
        PaidSubscriptionActivity.m18849makeUi$lambda4(this.f$0, this.f$1, (Integer) obj);
    }
}
