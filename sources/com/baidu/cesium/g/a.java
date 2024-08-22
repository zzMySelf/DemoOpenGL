package com.baidu.cesium.g;

import android.text.TextUtils;
import com.baidu.cesium.d.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f11489a = {"REVEMEFGREIxQUQwQ0M0Q0E5NzRENUVCQTAxNjUxNDE=", "Qzc3RDVEMDREOTRGNUY1NkM4QTBBNkRDM0RCRjI0MEE="};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f11490b = {"MDAwMDAwMDAwMDAwMDAwMA=="};

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String c2 : f11489a) {
            if (str.equalsIgnoreCase(c(c2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String c2 : f11490b) {
            if (TextUtils.equals(c(c2), str)) {
                return false;
            }
        }
        return true;
    }

    private static String c(String str) {
        return new String(b.a(str.getBytes()));
    }
}
