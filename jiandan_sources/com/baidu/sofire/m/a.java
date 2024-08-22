package com.baidu.sofire.m;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.sofire.ac.F;

public class a {
    public static a c;
    public SharedPreferences a;
    public SharedPreferences.Editor b;

    public a(Context context) {
        SharedPreferences platformPrivateSharedPreferences = F.getInstance().getPlatformPrivateSharedPreferences(context);
        this.a = platformPrivateSharedPreferences;
        this.b = platformPrivateSharedPreferences.edit();
    }
}
