package com.baidu.searchbox.feed.config;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.feed.biserialdetail.net.DynamicDetailRequestManagerKt;
import com.baidu.searchbox.feed.net.config.FeedH2Util;

public class FeedUrlConfig {
    public static String getFeedBaseUrl() {
        return String.format("%s/searchbox", new Object[]{HostConfig.getSearchboxHostForHttps()});
    }

    public static String getFeedH2BaseUrl() {
        return String.format("%s/searchbox", new Object[]{HostConfig.getSearchBoxH2Host()});
    }

    public static String getFeedDisplayUrl(int length) {
        return String.format("%s/searchbox?action=feed&cmd=109&refresh=0&_report_size=%d", new Object[]{FeedPreferenceUtils.getBoolean(FeedH2Util.KEY_FEED_109_H2_SWITCH, false) ? HostConfig.getSearchBoxH2Host() : HostConfig.getSearchboxHostForHttps(), Integer.valueOf(length)});
    }

    public static String getNotInterestUrl() {
        return String.format("%s/searchbox?action=feed&cmd=102", new Object[]{FeedPreferenceUtils.getBoolean(FeedH2Util.KEY_FEED_102_H2_SWITCH, false) ? HostConfig.getSearchBoxH2Host() : HostConfig.getSearchboxHostForHttps()});
    }

    public static String getFeedPreConnectUrl() {
        return String.format("%s/preconnect", new Object[]{FeedPreferenceUtils.getBoolean(FeedH2Util.KEY_FEED_100_H2_SWITCH, false) ? HostConfig.getSearchBoxH2Host() : HostConfig.getSearchboxHostForHttps()});
    }

    public static String getLikeUrl() {
        return String.format(DynamicDetailRequestManagerKt.PRAISE_URL, new Object[]{HostConfig.getSearchboxHostForHttps()});
    }

    public static String getVideoTabMissionUrl() {
        if (AppConfig.isDebug()) {
            return "http://njjs-sys-replace7002.njjs.baidu.com:8490/gapi/v2/taskscore";
        }
        return String.format("%s/gapi/v2/taskscore", new Object[]{HostConfig.getSearchboxHostForHttps()});
    }

    public static String starComment() {
        return String.format("%s/searchbox?action=comment&cmd=190", new Object[]{HostConfig.getSearchboxHostForHttps()});
    }

    public static String getFollowFindHostUrl() {
        return String.format("%s/webpage?action=find&type=subscribe", new Object[]{HostConfig.getSearchboxHostForHttps()});
    }

    public static String getFollowActionUrl() {
        return String.format("%s/api/subscribe/v1/relation/receive", new Object[]{HostConfig.getExtHostForHttps()});
    }

    public static String getShelfActionUrl(String cmd) {
        return String.format("%s/searchbox?action=shelf&cmd=%s", new Object[]{HostConfig.getSearchboxHostForHttps(), cmd});
    }

    public static String getFeedPreConnectImageUrl() {
        if (HostConfig.isSearchboxUseHttps()) {
            return "https://pics0.baidu.com/feed/preconnect";
        }
        return "http://pics0.baidu.com/feed/preconnect";
    }

    public static String getFeedPreConnectImagePics1Url() {
        if (HostConfig.isSearchboxUseHttps()) {
            return "https://pics1.baidu.com/feed/preconnect";
        }
        return "http://pics1.baidu.com/feed/preconnect";
    }

    public static String getFeedPreConnectImageGimg1Url() {
        if (HostConfig.isSearchboxUseHttps()) {
            return "https://gimg1.baidu.com/feed/preconnect";
        }
        return "http://gimg1.baidu.com/feed/preconnect";
    }

    public static String getVideoPreConnectImageUrl() {
        if (HostConfig.isSearchboxUseHttps()) {
            return "https://pic.rmb.bdstatic.com/feed/preconnect";
        }
        return "http://pic.rmb.bdstatic.com/feed/preconnect";
    }

    public static String getPlayLogUrl() {
        return String.format("%s/feedthirdparty/playlog", new Object[]{HostConfig.getSearchboxHostForHttps()});
    }

    public static String getUFONpsUrl() {
        return "https://ufosdk.baidu.com/?m=Api&a=postNps";
    }
}
