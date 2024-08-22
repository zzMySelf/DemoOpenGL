package com.baidu.searchbox.flowvideo.paymentpanel.api;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/flowvideo/paymentpanel/api/PaymentAuthorBean;", "Lcom/baidu/searchbox/NoProGuard;", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentDetailPanelBean.kt */
public final class PaymentAuthorBean implements NoProGuard {
    private final String id;

    public PaymentAuthorBean() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PaymentAuthorBean copy$default(PaymentAuthorBean paymentAuthorBean, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paymentAuthorBean.id;
        }
        return paymentAuthorBean.copy(str);
    }

    public final String component1() {
        return this.id;
    }

    public final PaymentAuthorBean copy(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new PaymentAuthorBean(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PaymentAuthorBean) && Intrinsics.areEqual((Object) this.id, (Object) ((PaymentAuthorBean) obj).id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return "PaymentAuthorBean(id=" + this.id + ')';
    }

    public PaymentAuthorBean(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        this.id = id2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentAuthorBean(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str);
    }

    public final String getId() {
        return this.id;
    }
}
