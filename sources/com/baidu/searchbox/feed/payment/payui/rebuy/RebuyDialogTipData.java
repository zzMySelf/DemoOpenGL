package com.baidu.searchbox.feed.payment.payui.rebuy;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/feed/payment/payui/rebuy/RebuyDialogTipData;", "", "text", "", "bold", "color", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RebuyCouponDialogManager.kt */
public final class RebuyDialogTipData {
    @SerializedName("bold")
    public final String bold;
    @SerializedName("color")
    public final String color;
    @SerializedName("text")
    public String text;

    public RebuyDialogTipData() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RebuyDialogTipData copy$default(RebuyDialogTipData rebuyDialogTipData, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rebuyDialogTipData.text;
        }
        if ((i2 & 2) != 0) {
            str2 = rebuyDialogTipData.bold;
        }
        if ((i2 & 4) != 0) {
            str3 = rebuyDialogTipData.color;
        }
        return rebuyDialogTipData.copy(str, str2, str3);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.bold;
    }

    public final String component3() {
        return this.color;
    }

    public final RebuyDialogTipData copy(String str, String str2, String str3) {
        return new RebuyDialogTipData(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RebuyDialogTipData)) {
            return false;
        }
        RebuyDialogTipData rebuyDialogTipData = (RebuyDialogTipData) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) rebuyDialogTipData.text) && Intrinsics.areEqual((Object) this.bold, (Object) rebuyDialogTipData.bold) && Intrinsics.areEqual((Object) this.color, (Object) rebuyDialogTipData.color);
    }

    public int hashCode() {
        String str = this.text;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.bold;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.color;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "RebuyDialogTipData(text=" + this.text + ", bold=" + this.bold + ", color=" + this.color + ')';
    }

    public RebuyDialogTipData(String text2, String bold2, String color2) {
        this.text = text2;
        this.bold = bold2;
        this.color = color2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RebuyDialogTipData(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }
}
