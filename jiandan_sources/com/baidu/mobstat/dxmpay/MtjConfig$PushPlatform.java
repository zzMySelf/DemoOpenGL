package com.baidu.mobstat.dxmpay;

import com.baidu.android.util.devices.RomUtils;

public enum MtjConfig$PushPlatform {
    BAIDUYUN("baiduyun", 0),
    JIGUANG("jiguang", 1),
    GETUI("getui", 2),
    HUAWEI(RomUtils.MANUFACTURER_HUAWEI, 3),
    XIAOMI(RomUtils.MANUFACTURER_XIAOMI, 4),
    UMENG("umeng", 5),
    XINGE("xinge", 6),
    ALIYUN("aliyun", 7),
    OPPO(RomUtils.MANUFACTURER_OPPO, 8),
    MEIZU("meizu", 9);
    
    public String a;
    public int b;

    /* access modifiers changed from: public */
    MtjConfig$PushPlatform(String str, int i2) {
        this.a = str;
        this.b = i2;
    }

    public String showName() {
        return this.a;
    }

    public String value() {
        return "p" + this.b;
    }
}
