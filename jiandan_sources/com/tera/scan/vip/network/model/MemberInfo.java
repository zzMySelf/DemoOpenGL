package com.tera.scan.vip.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001dHÖ\u0001R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR \u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006#"}, d2 = {"Lcom/tera/scan/vip/network/model/MemberInfo;", "Landroid/os/Parcelable;", "()V", "expiredTime", "", "getExpiredTime", "()Ljava/lang/Long;", "setExpiredTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isAutoRenew", "", "()Ljava/lang/Boolean;", "setAutoRenew", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "platform", "", "getPlatform", "()Ljava/lang/String;", "setPlatform", "(Ljava/lang/String;)V", "renewTime", "getRenewTime", "setRenewTime", "vipStatus", "getVipStatus", "setVipStatus", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MemberInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<MemberInfo> CREATOR = new qw();
    @SerializedName("expired_time")
    @Nullable
    public Long expiredTime;
    @SerializedName("is_auto_renew")
    @Nullable
    public Boolean isAutoRenew;
    @SerializedName("platform")
    @Nullable
    public String platform;
    @SerializedName("renew_time")
    @Nullable
    public Long renewTime;
    @SerializedName("is_vip")
    @Nullable
    public String vipStatus;

    public static final class qw implements Parcelable.Creator<MemberInfo> {
        @NotNull
        /* renamed from: ad */
        public final MemberInfo[] newArray(int i2) {
            return new MemberInfo[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final MemberInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new MemberInfo();
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Long getExpiredTime() {
        return this.expiredTime;
    }

    @Nullable
    public final String getPlatform() {
        return this.platform;
    }

    @Nullable
    public final Long getRenewTime() {
        return this.renewTime;
    }

    @Nullable
    public final String getVipStatus() {
        return this.vipStatus;
    }

    @Nullable
    public final Boolean isAutoRenew() {
        return this.isAutoRenew;
    }

    public final void setAutoRenew(@Nullable Boolean bool) {
        this.isAutoRenew = bool;
    }

    public final void setExpiredTime(@Nullable Long l) {
        this.expiredTime = l;
    }

    public final void setPlatform(@Nullable String str) {
        this.platform = str;
    }

    public final void setRenewTime(@Nullable Long l) {
        this.renewTime = l;
    }

    public final void setVipStatus(@Nullable String str) {
        this.vipStatus = str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
