package com.baidu.searchbox.video.feedflow.detail.payment.seekbar;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.flowvideo.detail.repos.PaymentModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/seekbar/PaymentSeekBarState;", "", "paymentModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/flowvideo/detail/repos/PaymentModel;", "reset", "", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getPaymentModel", "()Landroidx/lifecycle/MutableLiveData;", "getReset", "setReset", "(Landroidx/lifecycle/MutableLiveData;)V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSeekBarState.kt */
public final class PaymentSeekBarState {
    private final MutableLiveData<PaymentModel> paymentModel;
    private MutableLiveData<Unit> reset;

    public PaymentSeekBarState() {
        this((MutableLiveData) null, (MutableLiveData) null, 3, (DefaultConstructorMarker) null);
    }

    public PaymentSeekBarState(MutableLiveData<PaymentModel> paymentModel2, MutableLiveData<Unit> reset2) {
        Intrinsics.checkNotNullParameter(paymentModel2, "paymentModel");
        Intrinsics.checkNotNullParameter(reset2, "reset");
        this.paymentModel = paymentModel2;
        this.reset = reset2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentSeekBarState(MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MutableLiveData() : mutableLiveData, (i2 & 2) != 0 ? new MutableLiveData() : mutableLiveData2);
    }

    public final MutableLiveData<PaymentModel> getPaymentModel() {
        return this.paymentModel;
    }

    public final MutableLiveData<Unit> getReset() {
        return this.reset;
    }

    public final void setReset(MutableLiveData<Unit> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.reset = mutableLiveData;
    }
}
