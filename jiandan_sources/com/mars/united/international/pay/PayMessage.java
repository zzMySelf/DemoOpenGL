package com.mars.united.international.pay;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u001d\u001a\u00020\u0019J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006$"}, d2 = {"Lcom/mars/united/international/pay/PayMessage;", "Landroid/os/Parcelable;", "code", "", "message", "", "accountId", "serverOrderId", "originalJson", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountId", "()Ljava/lang/String;", "getCode", "()I", "getMessage", "getOriginalJson", "getServerOrderId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "isSuccess", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "pay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PayMessage implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<PayMessage> CREATOR = new qw();
    @Nullable
    public final String accountId;
    public final int code;
    @Nullable
    public final String message;
    @Nullable
    public final String originalJson;
    @Nullable
    public final String serverOrderId;

    public static final class qw implements Parcelable.Creator<PayMessage> {
        @NotNull
        /* renamed from: ad */
        public final PayMessage[] newArray(int i2) {
            return new PayMessage[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final PayMessage createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PayMessage(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }
    }

    public PayMessage(int i2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.code = i2;
        this.message = str;
        this.accountId = str2;
        this.serverOrderId = str3;
        this.originalJson = str4;
    }

    public static /* synthetic */ PayMessage copy$default(PayMessage payMessage, int i2, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = payMessage.code;
        }
        if ((i3 & 2) != 0) {
            str = payMessage.message;
        }
        String str5 = str;
        if ((i3 & 4) != 0) {
            str2 = payMessage.accountId;
        }
        String str6 = str2;
        if ((i3 & 8) != 0) {
            str3 = payMessage.serverOrderId;
        }
        String str7 = str3;
        if ((i3 & 16) != 0) {
            str4 = payMessage.originalJson;
        }
        return payMessage.copy(i2, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.code;
    }

    @Nullable
    public final String component2() {
        return this.message;
    }

    @Nullable
    public final String component3() {
        return this.accountId;
    }

    @Nullable
    public final String component4() {
        return this.serverOrderId;
    }

    @Nullable
    public final String component5() {
        return this.originalJson;
    }

    @NotNull
    public final PayMessage copy(int i2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new PayMessage(i2, str, str2, str3, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayMessage)) {
            return false;
        }
        PayMessage payMessage = (PayMessage) obj;
        return this.code == payMessage.code && Intrinsics.areEqual((Object) this.message, (Object) payMessage.message) && Intrinsics.areEqual((Object) this.accountId, (Object) payMessage.accountId) && Intrinsics.areEqual((Object) this.serverOrderId, (Object) payMessage.serverOrderId) && Intrinsics.areEqual((Object) this.originalJson, (Object) payMessage.originalJson);
    }

    @Nullable
    public final String getAccountId() {
        return this.accountId;
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getOriginalJson() {
        return this.originalJson;
    }

    @Nullable
    public final String getServerOrderId() {
        return this.serverOrderId;
    }

    public int hashCode() {
        int i2 = this.code * 31;
        String str = this.message;
        int i3 = 0;
        int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.accountId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.serverOrderId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.originalJson;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return hashCode3 + i3;
    }

    public final boolean isSuccess() {
        return this.code == 0;
    }

    @NotNull
    public String toString() {
        return "PayMessage(code=" + this.code + ", message=" + this.message + ", accountId=" + this.accountId + ", serverOrderId=" + this.serverOrderId + ", originalJson=" + this.originalJson + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.code);
        parcel.writeString(this.message);
        parcel.writeString(this.accountId);
        parcel.writeString(this.serverOrderId);
        parcel.writeString(this.originalJson);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PayMessage(int i2, String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : str4);
    }
}
