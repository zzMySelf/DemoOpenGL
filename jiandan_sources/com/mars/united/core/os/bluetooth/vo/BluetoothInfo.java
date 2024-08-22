package com.mars.united.core.os.bluetooth.vo;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0000H\u0002J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/mars/united/core/os/bluetooth/vo/BluetoothInfo;", "", "Landroid/os/Parcelable;", "deviceName", "", "rssi", "", "timeMill", "", "(Ljava/lang/String;IJ)V", "getDeviceName", "()Ljava/lang/String;", "getRssi", "()I", "getTimeMill", "()J", "compareTo", "other", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BluetoothInfo implements Comparable<BluetoothInfo>, Parcelable {
    @NotNull
    public static final Parcelable.Creator<BluetoothInfo> CREATOR = new qw();
    @NotNull
    public final String deviceName;
    public final int rssi;
    public final long timeMill;

    public static final class qw implements Parcelable.Creator<BluetoothInfo> {
        @NotNull
        /* renamed from: ad */
        public final BluetoothInfo[] newArray(int i2) {
            return new BluetoothInfo[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final BluetoothInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BluetoothInfo(parcel.readString(), parcel.readInt(), parcel.readLong());
        }
    }

    public BluetoothInfo(@NotNull String str, int i2, long j) {
        Intrinsics.checkNotNullParameter(str, "deviceName");
        this.deviceName = str;
        this.rssi = i2;
        this.timeMill = j;
    }

    public static /* synthetic */ BluetoothInfo copy$default(BluetoothInfo bluetoothInfo, String str, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = bluetoothInfo.deviceName;
        }
        if ((i3 & 2) != 0) {
            i2 = bluetoothInfo.rssi;
        }
        if ((i3 & 4) != 0) {
            j = bluetoothInfo.timeMill;
        }
        return bluetoothInfo.copy(str, i2, j);
    }

    @NotNull
    public final String component1() {
        return this.deviceName;
    }

    public final int component2() {
        return this.rssi;
    }

    public final long component3() {
        return this.timeMill;
    }

    @NotNull
    public final BluetoothInfo copy(@NotNull String str, int i2, long j) {
        Intrinsics.checkNotNullParameter(str, "deviceName");
        return new BluetoothInfo(str, i2, j);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BluetoothInfo)) {
            return false;
        }
        BluetoothInfo bluetoothInfo = (BluetoothInfo) obj;
        return Intrinsics.areEqual((Object) this.deviceName, (Object) bluetoothInfo.deviceName) && this.rssi == bluetoothInfo.rssi && this.timeMill == bluetoothInfo.timeMill;
    }

    @NotNull
    public final String getDeviceName() {
        return this.deviceName;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final long getTimeMill() {
        return this.timeMill;
    }

    public int hashCode() {
        return (((this.deviceName.hashCode() * 31) + this.rssi) * 31) + defpackage.qw.qw(this.timeMill);
    }

    @NotNull
    public String toString() {
        return "BluetoothInfo(deviceName=" + this.deviceName + ", rssi=" + this.rssi + ", timeMill=" + this.timeMill + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.deviceName);
        parcel.writeInt(this.rssi);
        parcel.writeLong(this.timeMill);
    }

    public int compareTo(@NotNull BluetoothInfo bluetoothInfo) {
        Intrinsics.checkNotNullParameter(bluetoothInfo, "other");
        return this.rssi - bluetoothInfo.rssi;
    }
}
