package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.aiscan.R;
import com.baidu.apollon.utils.ResUtils;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class StringResourceValueReader {
    public final Resources zzfi;
    public final String zzfj;

    public StringResourceValueReader(Context context) {
        Preconditions.checkNotNull(context);
        Resources resources = context.getResources();
        this.zzfi = resources;
        this.zzfj = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    @KeepForSdk
    public String getString(String str) {
        int identifier = this.zzfi.getIdentifier(str, ResUtils.b, this.zzfj);
        if (identifier == 0) {
            return null;
        }
        return this.zzfi.getString(identifier);
    }
}
