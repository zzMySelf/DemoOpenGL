package com.baidu.searchbox.video.feedflow.detail.payment.pay;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/pay/PaymentPayStatusState;", "", "addTabCmd", "", "alumId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAddTabCmd", "()Ljava/lang/String;", "setAddTabCmd", "(Ljava/lang/String;)V", "getAlumId", "setAlumId", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentPayStatusState.kt */
public final class PaymentPayStatusState {
    private String addTabCmd;
    private String alumId;

    public PaymentPayStatusState() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public PaymentPayStatusState(String addTabCmd2, String alumId2) {
        Intrinsics.checkNotNullParameter(addTabCmd2, "addTabCmd");
        Intrinsics.checkNotNullParameter(alumId2, "alumId");
        this.addTabCmd = addTabCmd2;
        this.alumId = alumId2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentPayStatusState(String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2);
    }

    public final String getAddTabCmd() {
        return this.addTabCmd;
    }

    public final String getAlumId() {
        return this.alumId;
    }

    public final void setAddTabCmd(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.addTabCmd = str;
    }

    public final void setAlumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.alumId = str;
    }
}
