package com.baidu.sofire.k;

import com.baidu.sofire.xclient.frd.FDM;

public class a {
    public static Boolean a;

    public static boolean a() {
        if (a == null) {
            try {
                FDM.class.toString();
                a = Boolean.TRUE;
                return true;
            } catch (Throwable unused) {
                a = Boolean.FALSE;
            }
        }
        Boolean bool = a;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean b() {
        if (!a()) {
            return false;
        }
        try {
            return FDM.isEnable();
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return false;
        }
    }
}
