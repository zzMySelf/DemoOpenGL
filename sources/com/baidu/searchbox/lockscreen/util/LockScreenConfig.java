package com.baidu.searchbox.lockscreen.util;

import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.feed.biserialdetail.net.DynamicDetailRequestManagerKt;

public class LockScreenConfig {
    public static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Linux; Android 4.4.2; Nexus 5 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36";

    public static String getFeedDisplayUrl(int length) {
        return String.format("%s/searchbox?action=feed&cmd=109&refresh=0&_report_size=%d", new Object[]{HostConfig.getSearchboxHostForHttps(), Integer.valueOf(length)});
    }

    public static String getLikeUrl() {
        return String.format(DynamicDetailRequestManagerKt.PRAISE_URL, new Object[]{HostConfig.getSearchboxHostForHttps()});
    }

    public static String getNotInterestUrl() {
        return String.format("%s/searchbox?action=feed&cmd=102", new Object[]{HostConfig.getSearchboxHostForHttps()});
    }

    public static String getLockScreenPictures() {
        return String.format("%s/searchbox?action=feed&cmd=203", new Object[]{HostConfig.getSearchboxHostForHttps()});
    }

    public static String getLockScreenBaseUrl() {
        return String.format("%s/searchbox", new Object[]{HostConfig.getSearchboxHostForHttps()});
    }

    public static String getLockScreenVoiceSearchUrl() {
        if (HostConfig.isSearchboxUseHttps()) {
            return "https://secr.baidu.com/zeroui/lock_search?word=";
        }
        return "http://secr.baidu.com/zeroui/lock_search?word=";
    }
}
