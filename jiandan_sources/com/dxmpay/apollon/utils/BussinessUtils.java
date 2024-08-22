package com.dxmpay.apollon.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.common.base.Ascii;

public final class BussinessUtils {

    /* renamed from: ad  reason: collision with root package name */
    public static String f4075ad;
    public static String qw;

    public static String getUA(Context context) {
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(qw) || TextUtils.isEmpty(f4075ad)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0)) == null)) {
                    qw = packageInfo.versionName;
                    f4075ad = packageInfo.versionCode + "";
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
        sb.append(qw);
        sb.append('_');
        sb.append(f4075ad);
        return sb.toString();
    }
}
