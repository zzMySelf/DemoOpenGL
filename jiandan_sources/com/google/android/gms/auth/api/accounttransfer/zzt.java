package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArraySet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "AuthenticatorTransferInfoCreator")
public class zzt extends zzaz {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();
    public static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaz;
    @SafeParcelable.Indicator
    public final Set<Integer> zzba;
    @SafeParcelable.Field(getter = "getAccountType", id = 2)
    public String zzbn;
    @SafeParcelable.Field(getter = "getStatus", id = 3)
    public int zzbo;
    @SafeParcelable.Field(getter = "getTransferBytes", id = 4)
    public byte[] zzbp;
    @SafeParcelable.Field(getter = "getPendingIntent", id = 5)
    public PendingIntent zzbq;
    @SafeParcelable.Field(getter = "getDeviceMetaData", id = 6)
    public DeviceMetaData zzbr;
    @SafeParcelable.VersionField(id = 1)
    public final int zzv;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        zzaz = hashMap;
        hashMap.put("accountType", FastJsonResponse.Field.forString("accountType", 2));
        zzaz.put("status", FastJsonResponse.Field.forInteger("status", 3));
        zzaz.put("transferBytes", FastJsonResponse.Field.forBase64("transferBytes", 4));
    }

    @SafeParcelable.Constructor
    public zzt(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) PendingIntent pendingIntent, @SafeParcelable.Param(id = 6) DeviceMetaData deviceMetaData) {
        this.zzba = set;
        this.zzv = i2;
        this.zzbn = str;
        this.zzbo = i3;
        this.zzbp = bArr;
        this.zzbq = pendingIntent;
        this.zzbr = deviceMetaData;
    }

    public /* synthetic */ Map getFieldMappings() {
        return zzaz;
    }

    public Object getFieldValue(FastJsonResponse.Field field) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 1) {
            return Integer.valueOf(this.zzv);
        }
        if (safeParcelableFieldId == 2) {
            return this.zzbn;
        }
        if (safeParcelableFieldId == 3) {
            return Integer.valueOf(this.zzbo);
        }
        if (safeParcelableFieldId == 4) {
            return this.zzbp;
        }
        int safeParcelableFieldId2 = field.getSafeParcelableFieldId();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(safeParcelableFieldId2);
        throw new IllegalStateException(sb.toString());
    }

    public boolean isFieldSet(FastJsonResponse.Field field) {
        return this.zzba.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    public void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 4) {
            this.zzbp = bArr;
            this.zzba.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        StringBuilder sb = new StringBuilder(59);
        sb.append("Field with id=");
        sb.append(safeParcelableFieldId);
        sb.append(" is not known to be an byte array.");
        throw new IllegalArgumentException(sb.toString());
    }

    public void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 3) {
            this.zzbo = i2;
            this.zzba.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        StringBuilder sb = new StringBuilder(52);
        sb.append("Field with id=");
        sb.append(safeParcelableFieldId);
        sb.append(" is not known to be an int.");
        throw new IllegalArgumentException(sb.toString());
    }

    public void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 2) {
            this.zzbn = str2;
            this.zzba.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[]{Integer.valueOf(safeParcelableFieldId)}));
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.zzba;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.zzv);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeString(parcel, 2, this.zzbn, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeInt(parcel, 3, this.zzbo);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeByteArray(parcel, 4, this.zzbp, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.writeParcelable(parcel, 5, this.zzbq, i2, true);
        }
        if (set.contains(6)) {
            SafeParcelWriter.writeParcelable(parcel, 6, this.zzbr, i2, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzt() {
        this.zzba = new ArraySet(3);
        this.zzv = 1;
    }
}
