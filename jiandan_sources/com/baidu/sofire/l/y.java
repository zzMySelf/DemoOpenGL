package com.baidu.sofire.l;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.a.a;

public class y {
    public static String a = "";

    public static String a(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        try {
            a = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable unused) {
            int i2 = a.a;
        }
        return a;
    }
}
