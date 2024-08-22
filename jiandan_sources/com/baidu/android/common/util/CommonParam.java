package com.baidu.android.common.util;

import android.content.Context;

@Deprecated
public class CommonParam {
    public static final boolean a = false;
    public static final String b = "CommonParam";

    @Deprecated
    public static String getCUID(Context context) {
        return DeviceId.getCUID(context);
    }
}
