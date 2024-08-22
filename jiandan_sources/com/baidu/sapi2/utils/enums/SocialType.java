package com.baidu.sapi2.utils.enums;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.FileUtils;

public enum SocialType {
    UNKNOWN(0, FileUtils.UNKNOW),
    SINA_WEIBO_SSO(2, "新浪微博SSO"),
    QQ_SSO(15, "QQ_SSO"),
    WEIXIN(42, "微信"),
    HUAWEI(45, "华为"),
    HONOR(61, "荣耀"),
    IQIYI(47, "爱奇艺"),
    XIAOMI(49, "小米"),
    MEIZU(50, "魅族"),
    FACEBOOK(55, "facebook"),
    TWITTER(56, "twitter"),
    GOOGLE(57, "google"),
    YY(58, "YY"),
    CFO(60, "CFO"),
    DINGDING(63, "DINGDING"),
    OPPO(64, RomUtils.ROM_OPPO),
    VIVO(65, RomUtils.ROM_VIVO),
    QQ_SSO_BACKGROUND(100015, "QQ_SSO_BACKGROUND"),
    WEIXIN_BACKGROUND(100042, "微信");
    
    public String name;
    public int type;

    /* access modifiers changed from: public */
    SocialType(int i2, String str) {
        this.type = i2;
        this.name = str;
    }

    public static SocialType getSocialType(int i2) {
        if (i2 == 2) {
            return SINA_WEIBO_SSO;
        }
        if (i2 == 15) {
            return QQ_SSO;
        }
        if (i2 == 42) {
            return WEIXIN;
        }
        if (i2 == 45) {
            return HUAWEI;
        }
        if (i2 == 47) {
            return IQIYI;
        }
        if (i2 == 55) {
            return FACEBOOK;
        }
        if (i2 == 49) {
            return XIAOMI;
        }
        if (i2 == 50) {
            return MEIZU;
        }
        if (i2 == 60) {
            return CFO;
        }
        if (i2 != 61) {
            return UNKNOWN;
        }
        return HONOR;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }
}
