package com.dxmpay.wallet.core;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class Domains implements NoProguard {
    public static final EnumSet<Permission> ALL_PERMISSION;
    public static final String BAIDU = ".baidu.com";
    public static final String BAI_YING_FUND = ".baiyingfund.com";
    public static final Map<String, EnumSet<Permission>> DEFAULT_PERMISSION_CONFIG = new HashMap();
    public static final String DU_XIAO_MAN = ".duxiaoman.com";
    public static final String DU_XIAO_MAN_FUND = ".duxiaomanfund.com";
    public static final String DU_XIAO_MAN_INT = ".duxiaoman-int.com";
    public static final String DU_XIAO_MAN_PAY = ".dxmpay.com";
    public static final String NUOMI = ".nuomi.com";
    public Map<String, EnumSet<Permission>> mDomainsPermissionConfig;

    public static class ad {
        public static final Domains qw = new Domains();
    }

    static {
        EnumSet<Permission> of = EnumSet.of(Permission.NONE, Permission.READ_NORMAL, Permission.READ_PRIVATE, Permission.WRITE, Permission.READ_DEVICE);
        ALL_PERMISSION = of;
        DEFAULT_PERMISSION_CONFIG.put(BAIDU, of);
        DEFAULT_PERMISSION_CONFIG.put(NUOMI, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(DU_XIAO_MAN, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(DU_XIAO_MAN_FUND, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(BAI_YING_FUND, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(DU_XIAO_MAN_PAY, ALL_PERMISSION);
        DEFAULT_PERMISSION_CONFIG.put(DU_XIAO_MAN_INT, ALL_PERMISSION);
    }

    public static final Domains getInstance() {
        return ad.qw;
    }

    public Map<String, EnumSet<Permission>> getDomainsPermissionConfig() {
        Map<String, EnumSet<Permission>> map = this.mDomainsPermissionConfig;
        if (map == null || map.isEmpty()) {
            return DEFAULT_PERMISSION_CONFIG;
        }
        return this.mDomainsPermissionConfig;
    }

    public void setDomainsPermissionConfig(Map<String, EnumSet<Permission>> map) {
        this.mDomainsPermissionConfig = map;
    }

    public Domains() {
    }
}
