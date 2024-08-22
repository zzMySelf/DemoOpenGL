package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzb implements Parcelable.Creator<BinderWrapper> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, (zzb) null);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new BinderWrapper[i2];
    }
}
