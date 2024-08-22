package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "WakeLockEventCreator")
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
    public long durationMillis;
    @SafeParcelable.VersionField(id = 1)
    public final int versionCode;
    @SafeParcelable.Field(getter = "getTimeMillis", id = 2)
    public final long zzgd;
    @SafeParcelable.Field(getter = "getEventType", id = 11)
    public int zzge;
    @SafeParcelable.Field(getter = "getWakeLockName", id = 4)
    public final String zzgf;
    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", id = 10)
    public final String zzgg;
    @SafeParcelable.Field(getter = "getCodePackage", id = 17)
    public final String zzgh;
    @SafeParcelable.Field(getter = "getWakeLockType", id = 5)
    public final int zzgi;
    @SafeParcelable.Field(getter = "getCallingPackages", id = 6)
    public final List<String> zzgj;
    @SafeParcelable.Field(getter = "getEventKey", id = 12)
    public final String zzgk;
    @SafeParcelable.Field(getter = "getElapsedRealtime", id = 8)
    public final long zzgl;
    @SafeParcelable.Field(getter = "getDeviceState", id = 14)
    public int zzgm;
    @SafeParcelable.Field(getter = "getHostPackage", id = 13)
    public final String zzgn;
    @SafeParcelable.Field(getter = "getBeginPowerPercentage", id = 15)
    public final float zzgo;
    @SafeParcelable.Field(getter = "getTimeout", id = 16)
    public final long zzgp;
    @SafeParcelable.Field(getter = "getAcquiredWithTimeout", id = 18)
    public final boolean zzgq;

    @SafeParcelable.Constructor
    public WakeLockEvent(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 11) int i3, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 8) long j2, @SafeParcelable.Param(id = 14) int i5, @SafeParcelable.Param(id = 10) String str3, @SafeParcelable.Param(id = 13) String str4, @SafeParcelable.Param(id = 15) float f, @SafeParcelable.Param(id = 16) long j3, @SafeParcelable.Param(id = 17) String str5, @SafeParcelable.Param(id = 18) boolean z) {
        this.versionCode = i2;
        this.zzgd = j;
        this.zzge = i3;
        this.zzgf = str;
        this.zzgg = str3;
        this.zzgh = str5;
        this.zzgi = i4;
        this.durationMillis = -1;
        this.zzgj = list;
        this.zzgk = str2;
        this.zzgl = j2;
        this.zzgm = i5;
        this.zzgn = str4;
        this.zzgo = f;
        this.zzgp = j3;
        this.zzgq = z;
    }

    public final int getEventType() {
        return this.zzge;
    }

    public final long getTimeMillis() {
        return this.zzgd;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, getTimeMillis());
        SafeParcelWriter.writeString(parcel, 4, this.zzgf, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzgi);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzgj, false);
        SafeParcelWriter.writeLong(parcel, 8, this.zzgl);
        SafeParcelWriter.writeString(parcel, 10, this.zzgg, false);
        SafeParcelWriter.writeInt(parcel, 11, getEventType());
        SafeParcelWriter.writeString(parcel, 12, this.zzgk, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzgn, false);
        SafeParcelWriter.writeInt(parcel, 14, this.zzgm);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzgo);
        SafeParcelWriter.writeLong(parcel, 16, this.zzgp);
        SafeParcelWriter.writeString(parcel, 17, this.zzgh, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzgq);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final long zzu() {
        return this.durationMillis;
    }

    public final String zzv() {
        String str;
        String str2 = this.zzgf;
        int i2 = this.zzgi;
        List<String> list = this.zzgj;
        String str3 = "";
        if (list == null) {
            str = str3;
        } else {
            str = TextUtils.join(",", list);
        }
        int i3 = this.zzgm;
        String str4 = this.zzgg;
        if (str4 == null) {
            str4 = str3;
        }
        String str5 = this.zzgn;
        if (str5 == null) {
            str5 = str3;
        }
        float f = this.zzgo;
        String str6 = this.zzgh;
        if (str6 != null) {
            str3 = str6;
        }
        boolean z = this.zzgq;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 51 + String.valueOf(str).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str3).length());
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i3);
        sb.append("\t");
        sb.append(str4);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(f);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }

    public WakeLockEvent(long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5, boolean z) {
        this(2, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3, str5, z);
    }
}
