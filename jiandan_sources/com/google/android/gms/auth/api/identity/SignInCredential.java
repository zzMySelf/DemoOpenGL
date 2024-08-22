package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInCredentialCreator")
public final class SignInCredential extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInCredential> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getId", id = 1)
    public final String zzba;
    @SafeParcelable.Field(getter = "getDisplayName", id = 2)
    @Nullable
    public final String zzbb;
    @SafeParcelable.Field(getter = "getGivenName", id = 3)
    @Nullable
    public final String zzbc;
    @SafeParcelable.Field(getter = "getFamilyName", id = 4)
    @Nullable
    public final String zzbd;
    @SafeParcelable.Field(getter = "getProfilePictureUri", id = 5)
    @Nullable
    public final Uri zzbe;
    @SafeParcelable.Field(getter = "getPassword", id = 6)
    @Nullable
    public final String zzbf;
    @SafeParcelable.Field(getter = "getGoogleIdToken", id = 7)
    @Nullable
    public final String zzbg;

    @SafeParcelable.Constructor
    public SignInCredential(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) @Nullable String str2, @SafeParcelable.Param(id = 3) @Nullable String str3, @SafeParcelable.Param(id = 4) @Nullable String str4, @SafeParcelable.Param(id = 5) @Nullable Uri uri, @SafeParcelable.Param(id = 6) @Nullable String str5, @SafeParcelable.Param(id = 7) @Nullable String str6) {
        this.zzba = Preconditions.checkNotEmpty(str);
        this.zzbb = str2;
        this.zzbc = str3;
        this.zzbd = str4;
        this.zzbe = uri;
        this.zzbf = str5;
        this.zzbg = str6;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SignInCredential)) {
            return false;
        }
        SignInCredential signInCredential = (SignInCredential) obj;
        if (!Objects.equal(this.zzba, signInCredential.zzba) || !Objects.equal(this.zzbb, signInCredential.zzbb) || !Objects.equal(this.zzbc, signInCredential.zzbc) || !Objects.equal(this.zzbd, signInCredential.zzbd) || !Objects.equal(this.zzbe, signInCredential.zzbe) || !Objects.equal(this.zzbf, signInCredential.zzbf) || !Objects.equal(this.zzbg, signInCredential.zzbg)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzbb;
    }

    @Nullable
    public final String getFamilyName() {
        return this.zzbd;
    }

    @Nullable
    public final String getGivenName() {
        return this.zzbc;
    }

    @Nullable
    public final String getGoogleIdToken() {
        return this.zzbg;
    }

    public final String getId() {
        return this.zzba;
    }

    @Nullable
    public final String getPassword() {
        return this.zzbf;
    }

    @Nullable
    public final Uri getProfilePictureUri() {
        return this.zzbe;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzba, this.zzbb, this.zzbc, this.zzbd, this.zzbe, this.zzbf, this.zzbg);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 3, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 4, getFamilyName(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getProfilePictureUri(), i2, false);
        SafeParcelWriter.writeString(parcel, 6, getPassword(), false);
        SafeParcelWriter.writeString(parcel, 7, getGoogleIdToken(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
