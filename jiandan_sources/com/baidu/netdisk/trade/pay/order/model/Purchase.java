package com.baidu.netdisk.trade.pay.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003JY\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006("}, d2 = {"Lcom/baidu/netdisk/trade/pay/order/model/Purchase;", "Landroid/os/Parcelable;", "requestId", "", "purchaseInfo", "", "errorCode", "", "errorMsg", "monitorData", "payChannel", "(Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;Ljava/lang/String;I)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "getMonitorData", "getPayChannel", "getPurchaseInfo", "()Ljava/util/Map;", "getRequestId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "orderpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Purchase implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<Purchase> CREATOR = new qw();
    @SerializedName("request_id")
    @Nullable

    /* renamed from: _  reason: collision with root package name */
    public final String f908_;
    @SerializedName("purchase")
    @Nullable
    public final Map<String, String> __;
    @SerializedName("error_code")
    public final int ___;
    @SerializedName("error_msg")
    @Nullable
    public final String ____;
    @SerializedName("monitor_data")
    @Nullable
    public final String _____;
    @SerializedName("netdisk_pay_channel")
    public final int ______;

    public static final class qw implements Parcelable.Creator<Purchase> {
        @NotNull
        /* renamed from: ad */
        public final Purchase[] newArray(int i2) {
            return new Purchase[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final Purchase createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt);
                for (int i2 = 0; i2 != readInt; i2++) {
                    linkedHashMap2.put(parcel.readString(), parcel.readString());
                }
                linkedHashMap = linkedHashMap2;
            }
            return new Purchase(readString, linkedHashMap, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt());
        }
    }

    public Purchase() {
        this((String) null, (Map) null, 0, (String) null, (String) null, 0, 63, (DefaultConstructorMarker) null);
    }

    public Purchase(@Nullable String str, @Nullable Map<String, String> map, int i2, @Nullable String str2, @Nullable String str3, int i3) {
        this.f908_ = str;
        this.__ = map;
        this.___ = i2;
        this.____ = str2;
        this._____ = str3;
        this.______ = i3;
    }

    @Nullable
    public final Map<String, String> _() {
        return this.__;
    }

    public final int __() {
        return this.______;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return Intrinsics.areEqual((Object) this.f908_, (Object) purchase.f908_) && Intrinsics.areEqual((Object) this.__, (Object) purchase.__) && this.___ == purchase.___ && Intrinsics.areEqual((Object) this.____, (Object) purchase.____) && Intrinsics.areEqual((Object) this._____, (Object) purchase._____) && this.______ == purchase.______;
    }

    public int hashCode() {
        String str = this.f908_;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Map<String, String> map = this.__;
        int hashCode2 = (((hashCode + (map == null ? 0 : map.hashCode())) * 31) + this.___) * 31;
        String str2 = this.____;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this._____;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((hashCode3 + i2) * 31) + this.______;
    }

    @NotNull
    public String toString() {
        return "Purchase(requestId=" + this.f908_ + ", purchaseInfo=" + this.__ + ", errorCode=" + this.___ + ", errorMsg=" + this.____ + ", monitorData=" + this._____ + ", payChannel=" + this.______ + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.f908_);
        Map<String, String> map = this.__;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeString((String) next.getValue());
            }
        }
        parcel.writeInt(this.___);
        parcel.writeString(this.____);
        parcel.writeString(this._____);
        parcel.writeInt(this.______);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Purchase(java.lang.String r5, java.util.Map r6, int r7, java.lang.String r8, java.lang.String r9, int r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            r0 = 0
            if (r12 == 0) goto L_0x0007
            r12 = r0
            goto L_0x0008
        L_0x0007:
            r12 = r5
        L_0x0008:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r11 & 4
            r6 = 0
            if (r5 == 0) goto L_0x0016
            r2 = 0
            goto L_0x0017
        L_0x0016:
            r2 = r7
        L_0x0017:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r8
        L_0x001e:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r0 = r9
        L_0x0024:
            r5 = r11 & 32
            if (r5 == 0) goto L_0x002a
            r11 = 0
            goto L_0x002b
        L_0x002a:
            r11 = r10
        L_0x002b:
            r5 = r4
            r6 = r12
            r7 = r1
            r8 = r2
            r9 = r3
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.netdisk.trade.pay.order.model.Purchase.<init>(java.lang.String, java.util.Map, int, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
