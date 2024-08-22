package com.google.android.gms.internal.p011authapi;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

/* renamed from: com.google.android.gms.internal.auth-api.zzr  reason: invalid package */
public final class zzr {
    public static PendingIntent zzc(Context context, @Nullable Auth.AuthCredentialsOptions authCredentialsOptions, HintRequest hintRequest, @Nullable String str) {
        String str2;
        String str3;
        Preconditions.checkNotNull(context, "context must not be null");
        Preconditions.checkNotNull(hintRequest, "request must not be null");
        if (authCredentialsOptions == null) {
            str2 = null;
        } else {
            str2 = authCredentialsOptions.zzc();
        }
        if (TextUtils.isEmpty(str)) {
            str3 = zzal.zzr();
        } else {
            str3 = (String) Preconditions.checkNotNull(str);
        }
        Intent putExtra = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("claimedCallingPackage", str2);
        putExtra.putExtra("logSessionId", str3);
        SafeParcelableSerializer.serializeToIntentExtra(hintRequest, putExtra, "com.google.android.gms.credentials.HintRequest");
        return PendingIntent.getActivity(context, 2000, putExtra, 134217728);
    }
}
