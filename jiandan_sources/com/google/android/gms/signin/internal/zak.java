package com.google.android.gms.signin.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInResponseCreator")
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zaj();
    @SafeParcelable.VersionField(id = 1)
    public final int versionCode;
    @SafeParcelable.Field(getter = "getConnectionResult", id = 2)
    public final ConnectionResult zapo;
    @SafeParcelable.Field(getter = "getResolveAccountResponse", id = 3)
    @Nullable
    public final ResolveAccountResponse zata;

    @SafeParcelable.Constructor
    public zak(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ConnectionResult connectionResult, @SafeParcelable.Param(id = 3) @Nullable ResolveAccountResponse resolveAccountResponse) {
        this.versionCode = i2;
        this.zapo = connectionResult;
        this.zata = resolveAccountResponse;
    }

    public final ConnectionResult getConnectionResult() {
        return this.zapo;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zapo, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zata, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final ResolveAccountResponse zacv() {
        return this.zata;
    }

    public zak(int i2) {
        this(new ConnectionResult(8, (PendingIntent) null), (ResolveAccountResponse) null);
    }

    public zak(ConnectionResult connectionResult, @Nullable ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, (ResolveAccountResponse) null);
    }
}
