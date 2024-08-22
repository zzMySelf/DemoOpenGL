package com.bun.miitmdid;

import androidx.annotation.Keep;
import com.baidu.android.util.devices.RomUtils;
import com.google.android.material.internal.ManufacturerUtils;

@Keep
public enum c {
    UNSUPPORT(-1, "unsupport"),
    HUAWEI(0, "HUAWEI"),
    d(1, "Xiaomi"),
    e(2, RomUtils.MANUFACTURER_VIVO),
    f(3, RomUtils.MANUFACTURER_OPPO),
    MOTO(4, "motorola"),
    LENOVO(5, "lenovo"),
    ASUS(6, "asus"),
    SAMSUNG(7, ManufacturerUtils.SAMSUNG),
    MEIZU(8, "meizu"),
    l(10, "nubia"),
    ZTE(11, "ZTE"),
    ONEPLUS(12, "OnePlus"),
    BLACKSHARK(13, "blackshark"),
    FREEMEOS(30, "freemeos"),
    PRIZE(32, "prize"),
    REALME(33, "realme"),
    HONOR(34, "honor"),
    COOLPAD(35, "coolpad"),
    EEBBK(36, "EEBBK"),
    CHUANGLIAN(37, "ChuangLian"),
    CHINATELECOM(38, "ChinaTelecom");
    
    @Keep
    public String a;

    /* access modifiers changed from: public */
    c(int i2, String str) {
        this.a = str;
    }

    @Keep
    public static native c a(String str);
}
