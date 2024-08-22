package com.sdk.n;

import com.sdk.base.module.manager.SDKManager;
import com.sdk.f.f;
import java.util.Properties;

public class a {
    public static final String a = "a";
    public static final boolean b = f.a;

    public static String a(String str, String str2) {
        if (com.sdk.o.a.a(str2).booleanValue()) {
            return null;
        }
        Properties properties = new Properties();
        try {
            properties.load(SDKManager.mContext.getAssets().open(str));
        } catch (Exception unused) {
            String str3 = a;
            com.sdk.o.a.a(str3, "域名读取失败！《" + str2 + "+》", Boolean.valueOf(b));
        }
        return properties.getProperty(str2);
    }
}
