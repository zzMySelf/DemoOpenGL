package com.baidu.searchbox.video.feedflow.detail.payment.guide;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/guide/PaymentGuideState;", "", "guideShowing", "", "autoPlayTips", "Landroidx/lifecycle/MutableLiveData;", "", "hide", "", "(ZLandroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getAutoPlayTips", "()Landroidx/lifecycle/MutableLiveData;", "getGuideShowing", "()Z", "setGuideShowing", "(Z)V", "getHide", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentGuideState.kt */
public final class PaymentGuideState {
    private final MutableLiveData<String> autoPlayTips;
    private boolean guideShowing;
    private final MutableLiveData<Unit> hide;

    public PaymentGuideState() {
        this(false, (MutableLiveData) null, (MutableLiveData) null, 7, (DefaultConstructorMarker) null);
    }

    public PaymentGuideState(boolean guideShowing2, MutableLiveData<String> autoPlayTips2, MutableLiveData<Unit> hide2) {
        Intrinsics.checkNotNullParameter(autoPlayTips2, "autoPlayTips");
        Intrinsics.checkNotNullParameter(hide2, "hide");
        this.guideShowing = guideShowing2;
        this.autoPlayTips = autoPlayTips2;
        this.hide = hide2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentGuideState(boolean z, MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? new MutableLiveData() : mutableLiveData, (i2 & 4) != 0 ? new MutableLiveData() : mutableLiveData2);
    }

    public final boolean getGuideShowing() {
        return this.guideShowing;
    }

    public final void setGuideShowing(boolean z) {
        this.guideShowing = z;
    }

    public final MutableLiveData<String> getAutoPlayTips() {
        return this.autoPlayTips;
    }

    public final MutableLiveData<Unit> getHide() {
        return this.hide;
    }
}
