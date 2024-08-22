package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "BeginSignInRequestCreator")
public final class BeginSignInRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BeginSignInRequest> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getPasswordRequestOptions", id = 1)
    public final PasswordRequestOptions zzas;
    @SafeParcelable.Field(getter = "getGoogleIdTokenRequestOptions", id = 2)
    public final GoogleIdTokenRequestOptions zzat;
    @SafeParcelable.Field(getter = "getSessionId", id = 3)
    @Nullable
    public final String zzau;

    public static final class Builder {
        public PasswordRequestOptions zzas = PasswordRequestOptions.builder().setSupported(false).build();
        public GoogleIdTokenRequestOptions zzat = GoogleIdTokenRequestOptions.builder().setSupported(false).build();
        @Nullable
        public String zzau;

        public final BeginSignInRequest build() {
            return new BeginSignInRequest(this.zzas, this.zzat, this.zzau);
        }

        public final Builder setGoogleIdTokenRequestOptions(@NonNull GoogleIdTokenRequestOptions googleIdTokenRequestOptions) {
            this.zzat = (GoogleIdTokenRequestOptions) Preconditions.checkNotNull(googleIdTokenRequestOptions);
            return this;
        }

        public final Builder setPasswordRequestOptions(@NonNull PasswordRequestOptions passwordRequestOptions) {
            this.zzas = (PasswordRequestOptions) Preconditions.checkNotNull(passwordRequestOptions);
            return this;
        }

        public final Builder zzd(@NonNull String str) {
            this.zzau = str;
            return this;
        }
    }

    @SafeParcelable.Class(creator = "GoogleIdTokenRequestOptionsCreator")
    public static final class GoogleIdTokenRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<GoogleIdTokenRequestOptions> CREATOR = new zzd();
        @SafeParcelable.Field(getter = "isSupported", id = 1)
        public final boolean zzav;
        @SafeParcelable.Field(getter = "getServerClientId", id = 2)
        @Nullable
        public final String zzaw;
        @SafeParcelable.Field(getter = "getNonce", id = 3)
        @Nullable
        public final String zzax;
        @SafeParcelable.Field(getter = "filterByAuthorizedAccounts", id = 4)
        public final boolean zzay;

        public static final class Builder {
            public boolean zzav = false;
            @Nullable
            public String zzaw = null;
            @Nullable
            public String zzax = null;
            public boolean zzay = true;

            public final GoogleIdTokenRequestOptions build() {
                return new GoogleIdTokenRequestOptions(this.zzav, this.zzaw, this.zzax, this.zzay);
            }

            public final Builder setFilterByAuthorizedAccounts(boolean z) {
                this.zzay = z;
                return this;
            }

            public final Builder setNonce(@Nullable String str) {
                this.zzax = str;
                return this;
            }

            public final Builder setServerClientId(@NonNull String str) {
                this.zzaw = Preconditions.checkNotEmpty(str);
                return this;
            }

            public final Builder setSupported(boolean z) {
                this.zzav = z;
                return this;
            }
        }

        @SafeParcelable.Constructor
        public GoogleIdTokenRequestOptions(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) @Nullable String str, @SafeParcelable.Param(id = 3) @Nullable String str2, @SafeParcelable.Param(id = 4) boolean z2) {
            this.zzav = z;
            if (z) {
                Preconditions.checkNotNull(str, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.zzaw = str;
            this.zzax = str2;
            this.zzay = z2;
        }

        public static Builder builder() {
            return new Builder();
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof GoogleIdTokenRequestOptions)) {
                return false;
            }
            GoogleIdTokenRequestOptions googleIdTokenRequestOptions = (GoogleIdTokenRequestOptions) obj;
            if (this.zzav != googleIdTokenRequestOptions.zzav || !Objects.equal(this.zzaw, googleIdTokenRequestOptions.zzaw) || !Objects.equal(this.zzax, googleIdTokenRequestOptions.zzax) || this.zzay != googleIdTokenRequestOptions.zzay) {
                return false;
            }
            return true;
        }

        public final boolean filterByAuthorizedAccounts() {
            return this.zzay;
        }

        @Nullable
        public final String getNonce() {
            return this.zzax;
        }

        @Nullable
        public final String getServerClientId() {
            return this.zzaw;
        }

        public final int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.zzav), this.zzaw, this.zzax, Boolean.valueOf(this.zzay));
        }

        public final boolean isSupported() {
            return this.zzav;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, isSupported());
            SafeParcelWriter.writeString(parcel, 2, getServerClientId(), false);
            SafeParcelWriter.writeString(parcel, 3, getNonce(), false);
            SafeParcelWriter.writeBoolean(parcel, 4, filterByAuthorizedAccounts());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @SafeParcelable.Class(creator = "PasswordRequestOptionsCreator")
    public static final class PasswordRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<PasswordRequestOptions> CREATOR = new zzf();
        @SafeParcelable.Field(getter = "isSupported", id = 1)
        public final boolean zzav;

        public static final class Builder {
            public boolean zzav = false;

            public final PasswordRequestOptions build() {
                return new PasswordRequestOptions(this.zzav);
            }

            public final Builder setSupported(boolean z) {
                this.zzav = z;
                return this;
            }
        }

        @SafeParcelable.Constructor
        public PasswordRequestOptions(@SafeParcelable.Param(id = 1) boolean z) {
            this.zzav = z;
        }

        public static Builder builder() {
            return new Builder();
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof PasswordRequestOptions) && this.zzav == ((PasswordRequestOptions) obj).zzav) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.zzav));
        }

        public final boolean isSupported() {
            return this.zzav;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, isSupported());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @SafeParcelable.Constructor
    public BeginSignInRequest(@SafeParcelable.Param(id = 1) PasswordRequestOptions passwordRequestOptions, @SafeParcelable.Param(id = 2) GoogleIdTokenRequestOptions googleIdTokenRequestOptions, @SafeParcelable.Param(id = 3) @Nullable String str) {
        this.zzas = (PasswordRequestOptions) Preconditions.checkNotNull(passwordRequestOptions);
        this.zzat = (GoogleIdTokenRequestOptions) Preconditions.checkNotNull(googleIdTokenRequestOptions);
        this.zzau = str;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder zzc(BeginSignInRequest beginSignInRequest) {
        Preconditions.checkNotNull(beginSignInRequest);
        Builder passwordRequestOptions = builder().setGoogleIdTokenRequestOptions(beginSignInRequest.getGoogleIdTokenRequestOptions()).setPasswordRequestOptions(beginSignInRequest.getPasswordRequestOptions());
        String str = beginSignInRequest.zzau;
        if (str != null) {
            passwordRequestOptions.zzd(str);
        }
        return passwordRequestOptions;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof BeginSignInRequest)) {
            return false;
        }
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) obj;
        if (!Objects.equal(this.zzas, beginSignInRequest.zzas) || !Objects.equal(this.zzat, beginSignInRequest.zzat) || !Objects.equal(this.zzau, beginSignInRequest.zzau)) {
            return false;
        }
        return true;
    }

    public final GoogleIdTokenRequestOptions getGoogleIdTokenRequestOptions() {
        return this.zzat;
    }

    public final PasswordRequestOptions getPasswordRequestOptions() {
        return this.zzas;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzas, this.zzat, this.zzau);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getPasswordRequestOptions(), i2, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getGoogleIdTokenRequestOptions(), i2, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzau, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
