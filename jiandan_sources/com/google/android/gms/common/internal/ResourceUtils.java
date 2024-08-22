package com.google.android.gms.common.internal;

import android.net.Uri;
import com.baidu.apollon.utils.ResUtils;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class ResourceUtils {
    public static final Uri zzfh = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath(ResUtils.e).build();
}
