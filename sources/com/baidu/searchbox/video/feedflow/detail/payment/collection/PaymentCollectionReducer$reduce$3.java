package com.baidu.searchbox.video.feedflow.detail.payment.collection;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.video.feedflow.detail.payment.player.PaymentPlayerState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentCollectionReducer.kt */
final class PaymentCollectionReducer$reduce$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CommonState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentCollectionReducer$reduce$3(CommonState commonState) {
        super(0);
        this.$state = commonState;
    }

    public final void invoke() {
        PaymentPlayerState paymentPlayerState = (PaymentPlayerState) this.$state.select(PaymentPlayerState.class);
        MutableLiveData<Integer> switchToHalf = paymentPlayerState != null ? paymentPlayerState.getSwitchToHalf() : null;
        if (switchToHalf != null) {
            switchToHalf.setValue(-1);
        }
    }
}
