package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SafeParcelable.Class(creator = "CredentialPickerConfigCreator")
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zze();
    @SafeParcelable.Field(getter = "shouldShowCancelButton", id = 2)
    public final boolean mShowCancelButton;
    @SafeParcelable.Field(id = 1000)
    public final int zzv;
    @SafeParcelable.Field(getter = "shouldShowAddAccountButton", id = 1)
    public final boolean zzw;
    @SafeParcelable.Field(getter = "isForNewAccount", id = 3)
    @Deprecated
    public final boolean zzx;
    @SafeParcelable.Field(getter = "getPromptInternalId", id = 4)
    public final int zzy;

    public static class Builder {
        public boolean mShowCancelButton = true;
        public boolean zzw = false;
        public int zzz = 1;

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig(this);
        }

        @Deprecated
        public Builder setForNewAccount(boolean z) {
            this.zzz = z ? 3 : 1;
            return this;
        }

        public Builder setPrompt(int i2) {
            this.zzz = i2;
            return this;
        }

        public Builder setShowAddAccountButton(boolean z) {
            this.zzw = z;
            return this;
        }

        public Builder setShowCancelButton(boolean z) {
            this.mShowCancelButton = z;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Prompt {
        public static final int CONTINUE = 1;
        public static final int SIGN_IN = 2;
        public static final int SIGN_UP = 3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: int} */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CredentialPickerConfig(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1000) int r2, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) boolean r3, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) boolean r4, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) boolean r5, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) int r6) {
        /*
            r1 = this;
            r1.<init>()
            r1.zzv = r2
            r1.zzw = r3
            r1.mShowCancelButton = r4
            r3 = 1
            r4 = 3
            r0 = 2
            if (r2 >= r0) goto L_0x0016
            r1.zzx = r5
            if (r5 == 0) goto L_0x0013
            r3 = 3
        L_0x0013:
            r1.zzy = r3
            return
        L_0x0016:
            if (r6 != r4) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r3 = 0
        L_0x001a:
            r1.zzx = r3
            r1.zzy = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.credentials.CredentialPickerConfig.<init>(int, boolean, boolean, boolean, int):void");
    }

    @Deprecated
    public final boolean isForNewAccount() {
        return this.zzy == 3;
    }

    public final boolean shouldShowAddAccountButton() {
        return this.zzw;
    }

    public final boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, shouldShowAddAccountButton());
        SafeParcelWriter.writeBoolean(parcel, 2, shouldShowCancelButton());
        SafeParcelWriter.writeBoolean(parcel, 3, isForNewAccount());
        SafeParcelWriter.writeInt(parcel, 4, this.zzy);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzv);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public CredentialPickerConfig(Builder builder) {
        this(2, builder.zzw, builder.mShowCancelButton, false, builder.zzz);
    }
}
