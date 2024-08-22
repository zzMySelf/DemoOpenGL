package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
@KeepForSdk
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new zzb();
    public IBinder zzdl;

    public BinderWrapper() {
        this.zzdl = null;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.zzdl);
    }

    @KeepForSdk
    public BinderWrapper(IBinder iBinder) {
        this.zzdl = null;
        this.zzdl = iBinder;
    }

    public BinderWrapper(Parcel parcel) {
        this.zzdl = null;
        this.zzdl = parcel.readStrongBinder();
    }

    public /* synthetic */ BinderWrapper(Parcel parcel, zzb zzb) {
        this(parcel);
    }
}
