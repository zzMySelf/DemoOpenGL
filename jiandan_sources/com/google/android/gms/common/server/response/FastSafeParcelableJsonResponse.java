package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
@KeepForSdk
public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastJsonResponse fastJsonResponse = (FastJsonResponse) obj;
        for (FastJsonResponse.Field next : getFieldMappings().values()) {
            if (isFieldSet(next)) {
                if (!fastJsonResponse.isFieldSet(next) || !getFieldValue(next).equals(fastJsonResponse.getFieldValue(next))) {
                    return false;
                }
            } else if (fastJsonResponse.isFieldSet(next)) {
                return false;
            }
        }
        return true;
    }

    @VisibleForTesting
    public Object getValueObject(String str) {
        return null;
    }

    public int hashCode() {
        int i2 = 0;
        for (FastJsonResponse.Field next : getFieldMappings().values()) {
            if (isFieldSet(next)) {
                i2 = (i2 * 31) + getFieldValue(next).hashCode();
            }
        }
        return i2;
    }

    @VisibleForTesting
    public boolean isPrimitiveFieldSet(String str) {
        return false;
    }

    @KeepForSdk
    public byte[] toByteArray() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
