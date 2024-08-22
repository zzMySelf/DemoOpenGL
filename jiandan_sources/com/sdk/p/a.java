package com.sdk.p;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.sdk.f.f;
import com.sdk.p.f;

public class a {
    public static final String a = "com.sdk.p.a";
    public static final Boolean b = Boolean.valueOf(f.a);

    public static f.a a(Context context) {
        f.a aVar;
        f.a aVar2 = f.a.UNKNOW;
        if (context == null) {
            return aVar2;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return aVar2;
            }
            String typeName = activeNetworkInfo.getTypeName();
            if ("MOBILE".equalsIgnoreCase(typeName)) {
                aVar = f.a.NET;
            } else if (!"WIFI".equalsIgnoreCase(typeName)) {
                return aVar2;
            } else {
                aVar = f.a.WIFI;
            }
            return aVar;
        } catch (Throwable th2) {
            com.sdk.o.a.a(a, th2.getMessage(), b);
            return aVar2;
        }
    }
}
