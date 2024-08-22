package com.baidu.searchbox.feed.payment.column;

import androidx.lifecycle.Observer;
import kotlin.Pair;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SpColumnActivity$$ExternalSyntheticLambda4 implements Observer {
    public final /* synthetic */ SpColumnActivity f$0;

    public /* synthetic */ SpColumnActivity$$ExternalSyntheticLambda4(SpColumnActivity spColumnActivity) {
        this.f$0 = spColumnActivity;
    }

    public final void onChanged(Object obj) {
        SpColumnActivity.m18985registerViewModel$lambda17(this.f$0, (Pair) obj);
    }
}
