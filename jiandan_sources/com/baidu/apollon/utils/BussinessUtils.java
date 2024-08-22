package com.baidu.apollon.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.common.base.Ascii;

public final class BussinessUtils {
    public static String a = "";
    public static String b = "";

    public static String getUA(Context context) {
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0)) == null)) {
                    a = packageInfo.versionName;
                    b = packageInfo.versionCode + "";
                }
            } catch (Exception unused) {
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        StringBuilder sb = new StringBuilder();
        sb.append(ChannelUtils.getSDKVersion());
        sb.append('_');
        sb.append(displayMetrics.widthPixels);
        sb.append('_');
        sb.append(displayMetrics.heightPixels);
        sb.append('_');
        sb.append((Build.MODEL + '-' + Build.DEVICE).replace(Ascii.CASE_MASK, '-').replace('_', '-'));
        sb.append('_');
        sb.append(Build.VERSION.SDK);
        sb.append('_');
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str)) {
            str = str.replace(Ascii.CASE_MASK, '-').replace('_', '-');
        }
        sb.append(str);
        sb.append('_');
        sb.append(a);
        sb.append('_');
        sb.append(b);
        return sb.toString();
    }
}
