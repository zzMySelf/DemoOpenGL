package com.baidu.sso.u;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.google.android.material.internal.ManufacturerUtils;

public enum a {
    UNSUPPORT(-1, "unsupport"),
    HUA_WEI(0, "HUAWEI"),
    d(1, "Xiaomi"),
    e(2, RomUtils.MANUFACTURER_VIVO),
    f(3, RomUtils.MANUFACTURER_OPPO),
    MOTO(4, "motorola"),
    LENOVO(5, "lenovo"),
    ASUS(6, "asus"),
    SAMSUNG(7, ManufacturerUtils.SAMSUNG),
    MEIZU(8, "meizu"),
    ALPS(9, "alps"),
    m(10, "nubia");
    
    public String a;

    /* access modifiers changed from: public */
    a(int i2, String str) {
        this.a = str;
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNSUPPORT;
        }
        for (a aVar : values()) {
            if (aVar.a.equalsIgnoreCase(str)) {
                return aVar;
            }
        }
        return UNSUPPORT;
    }
}
