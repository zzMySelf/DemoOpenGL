package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zza implements Parcelable.Creator<ProxyRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        byte[] bArr = null;
        Bundle bundle = null;
        long j = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 2) {
                i3 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 3) {
                j = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 4) {
                bArr = SafeParcelReader.createByteArray(parcel, readHeader);
            } else if (fieldId == 5) {
                bundle = SafeParcelReader.createBundle(parcel, readHeader);
            } else if (fieldId != 1000) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                i2 = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ProxyRequest(i2, str, i3, j, bArr, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new ProxyRequest[i2];
    }
}
