package com.baidu.searchbox.feed.listpage.domain;

public class RefreshPropertyNames {
    private static final String DESCRIPTOR_NAME = "refresh_policy";
    public static final String KEY_LAST_REFRESH_TIME = "last_refresh_time";
    private static final String SEPARATOR = "/";

    public static String descriptorNameWith(String suffix) {
        return "refresh_policy/" + suffix;
    }

    public static String[] descriptorNameAndSuffix(String composedName) {
        return composedName.split("/");
    }
}
