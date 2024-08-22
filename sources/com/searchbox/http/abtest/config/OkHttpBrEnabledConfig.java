package com.searchbox.http.abtest.config;

import com.baidu.searchbox.abtest.AbTestManager;

public class OkHttpBrEnabledConfig {
    public static final boolean ENABLE_BR_BY_DOMAIN_DEFAULT_VALUE = false;
    public static final boolean ENABLE_BR_DEFAULT_VALUE = false;
    public static final boolean FILTER_LOW_END_DEVICE_DEFAULT_VALUE = false;
    public static final String KEY_BR_AB_SWITCH = "br_ab_switch";
    public static final String KEY_BR_FILTER_LOW_END_DEVICE_SWITCH = "br_filter_low_end_device";
    public static final String KEY_ENABLE_BR_BY_DOMAIN = "br_enable_by_domain";

    public static boolean enableBR() {
        return AbTestManager.getInstance().getSwitch(KEY_BR_AB_SWITCH, false);
    }

    public static boolean shouldFilterLowEndDevice() {
        return AbTestManager.getInstance().getSwitch(KEY_BR_FILTER_LOW_END_DEVICE_SWITCH, false);
    }

    public static boolean enableBrByDomain() {
        return AbTestManager.getInstance().getSwitch(KEY_ENABLE_BR_BY_DOMAIN, false);
    }
}
