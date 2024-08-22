package com.baidu.searchbox.video.feedflow.flow.payment.secondJump;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/payment/secondJump/PaymentSecondJumpGlobalState;", "", "consume", "", "(Z)V", "getConsume", "()Z", "setConsume", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSecondJumpGlobalState.kt */
public final class PaymentSecondJumpGlobalState {
    private boolean consume;

    public PaymentSecondJumpGlobalState() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public PaymentSecondJumpGlobalState(boolean consume2) {
        this.consume = consume2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentSecondJumpGlobalState(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z);
    }

    public final boolean getConsume() {
        return this.consume;
    }

    public final void setConsume(boolean z) {
        this.consume = z;
    }
}
