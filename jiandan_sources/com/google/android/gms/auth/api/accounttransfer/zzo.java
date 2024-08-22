package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.alipay.sdk.m.u.h;
import com.baidu.sapi2.views.SmsLoginView;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SafeParcelable.Class(creator = "AccountTransferProgressCreator")
public class zzo extends zzaz {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    public static final ArrayMap<String, FastJsonResponse.Field<?, ?>> zzbe;
    @SafeParcelable.Field(getter = "getRegisteredAccountTypes", id = 2)
    public List<String> zzbf;
    @SafeParcelable.Field(getter = "getInProgressAccountTypes", id = 3)
    public List<String> zzbg;
    @SafeParcelable.Field(getter = "getSuccessAccountTypes", id = 4)
    public List<String> zzbh;
    @SafeParcelable.Field(getter = "getFailedAccountTypes", id = 5)
    public List<String> zzbi;
    @SafeParcelable.Field(getter = "getEscrowedAccountTypes", id = 6)
    public List<String> zzbj;
    @SafeParcelable.VersionField(id = 1)
    public final int zzv;

    static {
        ArrayMap<String, FastJsonResponse.Field<?, ?>> arrayMap = new ArrayMap<>();
        zzbe = arrayMap;
        arrayMap.put("registered", FastJsonResponse.Field.forStrings("registered", 2));
        zzbe.put("in_progress", FastJsonResponse.Field.forStrings("in_progress", 3));
        zzbe.put(SmsLoginView.f.k, FastJsonResponse.Field.forStrings(SmsLoginView.f.k, 4));
        zzbe.put(h.f684i, FastJsonResponse.Field.forStrings(h.f684i, 5));
        zzbe.put("escrowed", FastJsonResponse.Field.forStrings("escrowed", 6));
    }

    public zzo() {
        this.zzv = 1;
    }

    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        return zzbe;
    }

    public Object getFieldValue(FastJsonResponse.Field field) {
        switch (field.getSafeParcelableFieldId()) {
            case 1:
                return Integer.valueOf(this.zzv);
            case 2:
                return this.zzbf;
            case 3:
                return this.zzbg;
            case 4:
                return this.zzbh;
            case 5:
                return this.zzbi;
            case 6:
                return this.zzbj;
            default:
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unknown SafeParcelable id=");
                sb.append(safeParcelableFieldId);
                throw new IllegalStateException(sb.toString());
        }
    }

    public boolean isFieldSet(FastJsonResponse.Field field) {
        return true;
    }

    public void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 2) {
            this.zzbf = arrayList;
        } else if (safeParcelableFieldId == 3) {
            this.zzbg = arrayList;
        } else if (safeParcelableFieldId == 4) {
            this.zzbh = arrayList;
        } else if (safeParcelableFieldId == 5) {
            this.zzbi = arrayList;
        } else if (safeParcelableFieldId == 6) {
            this.zzbj = arrayList;
        } else {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", new Object[]{Integer.valueOf(safeParcelableFieldId)}));
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzv);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzbf, false);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzbg, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.zzbh, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzbi, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzbj, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) @Nullable List<String> list, @SafeParcelable.Param(id = 3) @Nullable List<String> list2, @SafeParcelable.Param(id = 4) @Nullable List<String> list3, @SafeParcelable.Param(id = 5) @Nullable List<String> list4, @SafeParcelable.Param(id = 6) @Nullable List<String> list5) {
        this.zzv = i2;
        this.zzbf = list;
        this.zzbg = list2;
        this.zzbh = list3;
        this.zzbi = list4;
        this.zzbj = list5;
    }
}
