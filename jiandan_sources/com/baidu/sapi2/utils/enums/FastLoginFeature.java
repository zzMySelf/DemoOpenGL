package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;

public enum FastLoginFeature {
    TX_WEIXIN_SSO(SSOLoginType.WEIXIN),
    SINA_WEIBO_SSO(SSOLoginType.SINA_SSO),
    SINA_WEIBO_WEBVIEW("tsina"),
    TX_QQ_SSO(SSOLoginType.QQ),
    QR_LOGIN(SSOLoginType.QR_APP_LOGIN),
    HUAWEI_LOGIN(SSOLoginType.HUAWEI),
    HONOR_LOGIN(SSOLoginType.HONOR),
    MEIZU_SSO(SSOLoginType.MEIZU),
    XIAOMI_SSO(SSOLoginType.XIAOMI),
    YY_SSO(SSOLoginType.YY),
    DINGDING_SSO(SSOLoginType.DINGDING_SSO),
    OPPO_SSO(SSOLoginType.OPPO_SSO),
    VIVO_SSO(SSOLoginType.VIVO_SSO),
    CF_SSO(SSOLoginType.CF);
    
    public String mStrValue;

    public interface SSOLoginType {
        public static final String CF = "cfmoto_login";
        public static final String DINGDING_SSO = "dingding_sso";
        public static final String HONOR = "glory_login";
        public static final String HUAWEI = "huawei_login";
        public static final String MEIZU = "meizu_sso";
        public static final String OPPO_SSO = "oppo_sso";
        public static final String QQ = "qq_sso";
        public static final String QR_APP_LOGIN = "qr_app_login";
        public static final String SINA_SSO = "tsina_sso";
        public static final String SINA_WEB = "tsina";
        public static final String VIVO_SSO = "vivo_sso";
        public static final String WEIXIN = "tweixin_sso";
        public static final String XIAOMI = "xiaomi_sso";
        public static final String YY = "yy";
    }

    /* access modifiers changed from: public */
    FastLoginFeature(String str) {
        this.mStrValue = str;
    }

    public static FastLoginFeature getDefault() {
        return SINA_WEIBO_SSO;
    }

    public static FastLoginFeature mapStrToValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return getDefault();
        }
        for (FastLoginFeature fastLoginFeature : values()) {
            if (str.equals(fastLoginFeature.getStrValue())) {
                return fastLoginFeature;
            }
        }
        return getDefault();
    }

    public String getStrValue() {
        return this.mStrValue;
    }
}
