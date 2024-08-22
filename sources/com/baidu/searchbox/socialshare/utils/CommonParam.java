package com.baidu.searchbox.socialshare.utils;

import android.content.Context;
import android.util.DisplayMetrics;

public class CommonParam extends com.baidu.android.common.util.CommonParam {
    public static String getUA(Context context, String componentName, String io, String versionName) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        int density = dm.densityDpi;
        String appName = context.getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append(width).append("_").append(height).append("_").append(density).append("_").append("android").append("_").append(componentName).append("_").append(io).append("_").append(versionName).append("_").append(appName);
        return sb.toString();
    }
}
