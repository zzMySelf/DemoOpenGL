package com.baidu.searchbox.video.feedflow.flow.payment.pay;

import androidx.lifecycle.Observer;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PayPlugin$$ExternalSyntheticLambda4 implements Observer {
    public final /* synthetic */ PayState f$0;
    public final /* synthetic */ PayPlugin f$1;

    public /* synthetic */ PayPlugin$$ExternalSyntheticLambda4(PayState payState, PayPlugin payPlugin) {
        this.f$0 = payState;
        this.f$1 = payPlugin;
    }

    public final void onChanged(Object obj) {
        PayPlugin.m6577onAttachToManager$lambda6$lambda3(this.f$0, this.f$1, (Map) obj);
    }
}
