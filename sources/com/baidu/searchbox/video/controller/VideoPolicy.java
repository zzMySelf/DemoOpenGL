package com.baidu.searchbox.video.controller;

import android.text.TextUtils;
import com.baidu.searchbox.video.util.VideoPreferenceUtils;

class VideoPolicy {
    public static final long CLEAR_CACHE_INTERVAL_TIME = 1555200000;
    private static final int CLEAR_CACHE_LIMIT = 20;
    private static final int DEFAULT_DISPLAY_FEEDBACK_LIMIT = 15;
    private static final long DEFAULT_SCROLL_FEEDBACK_INTERVAL = 60000;
    private static final int FEED_LIST_PRELOAD_POSITION = 0;
    private static final String KEY_DISPLAY_FEEDBACK_LIMIT = "key_display_feedback_limit";
    private static final String KEY_FEED_CLEAR_CACHE_INTERVAL_TIME = "key_feed_clear_cache_interval_time";
    private static final String KEY_FEED_CLEAR_CACHE_LIMIT = "key_feed_clear_cache_limit";
    private static final String KEY_FEED_CLEAR_CACHE_VERSION = "key_feed_clear_cache_version";
    private static final String KEY_FEED_FILTER_LIST_TIMESTAMP = "key_feed_filter_list_timestamp";
    private static final String KEY_FEED_LIST_PRELOAD_POSITION = "key_feed_list_preload_position";
    private static final String KEY_FEED_REFRESH_INTERVAL_TIME = "key_feed_refresh_interval_time";
    private static final String KEY_MINIVIDEO_TOPIC_PAGE = "key_minivideo_topic_page";
    private static final String KEY_PREFETCH_SWITCH = "key_prefetch_switch";
    private static final String KEY_RM_DUPLICATE_SWITCH = "key_rm_duplicate_switch";
    private static final String KEY_SCROLL_FEEDBACK_INTERVAL = "key_scroll_feedback_interval";
    private static final int MINI_VIDEO_FEED_LIST_PRELOAD_POSITION = 4;
    static final long MIN_REFRESH_INTERVAL = 300000;
    static final long MIN_SCROLL_FEEDBACK_INTERVAL = 5000;
    static final String PREFETCH_SWITCH_ENABLE = "1";
    public static final long REFRESH_INTERVAL_TIME = 7200000;
    static final String RM_DUPLICATE_ENABLE = "1";

    VideoPolicy() {
    }

    public static void saveRefreshIntervalTime(long refreshInterval, int type) {
        VideoPreferenceUtils.putLong(KEY_FEED_REFRESH_INTERVAL_TIME, refreshInterval, type);
    }

    public static long getRefreshIntervalTime(int type) {
        return VideoPreferenceUtils.getLong(KEY_FEED_REFRESH_INTERVAL_TIME, 7200000, type);
    }

    public static void saveClearCacheIntervalTime(long refreshInterval, int type) {
        VideoPreferenceUtils.putLong(KEY_FEED_CLEAR_CACHE_INTERVAL_TIME, refreshInterval, type);
    }

    public static long getClearCacheIntervalTime(int type) {
        return VideoPreferenceUtils.getLong(KEY_FEED_CLEAR_CACHE_INTERVAL_TIME, CLEAR_CACHE_INTERVAL_TIME, type);
    }

    public static void saveClearCacheFlagVersion(String version, int type) {
        if (!TextUtils.isEmpty(version)) {
            VideoPreferenceUtils.putString(KEY_FEED_CLEAR_CACHE_VERSION, version, type);
        }
    }

    public static String getClearCacheFlagVersion(int type) {
        return VideoPreferenceUtils.getString(KEY_FEED_CLEAR_CACHE_VERSION, "0", type);
    }

    public static void saveFeedFilterTimeStamp(String timeStamp, int type) {
        if (!TextUtils.isEmpty(timeStamp)) {
            VideoPreferenceUtils.putString(KEY_FEED_FILTER_LIST_TIMESTAMP, timeStamp, type);
        }
    }

    public static String getFeedFilterTimeStamp(int type) {
        return VideoPreferenceUtils.getString(KEY_FEED_FILTER_LIST_TIMESTAMP, "0", type);
    }

    public static void saveClearCacheLimit(int limit, int type) {
        VideoPreferenceUtils.putInt(KEY_FEED_CLEAR_CACHE_LIMIT, limit, type);
    }

    public static int getClearCacheLimit(int type) {
        return VideoPreferenceUtils.getInt(KEY_FEED_CLEAR_CACHE_LIMIT, 20, type);
    }

    public static void saveScrollFeedbackInterval(long interval, int type) {
        VideoPreferenceUtils.putLong(KEY_SCROLL_FEEDBACK_INTERVAL, interval, type);
    }

    public static long getScrollFeedbackInterval(int type) {
        return VideoPreferenceUtils.getLong(KEY_SCROLL_FEEDBACK_INTERVAL, 60000, type);
    }

    public static void saveDisplayFeedbackLimit(int limit, int type) {
        VideoPreferenceUtils.putInt(KEY_DISPLAY_FEEDBACK_LIMIT, limit, type);
    }

    public static int getDisplayFeedbackLimit(int type) {
        return VideoPreferenceUtils.getInt(KEY_DISPLAY_FEEDBACK_LIMIT, 15, type);
    }

    public static String getRemoveDuplicateSwitch(int type) {
        return VideoPreferenceUtils.getString(KEY_RM_DUPLICATE_SWITCH, "1", type);
    }

    public static void saveRemoveDuplicateSwitch(String switchValue, int type) {
        VideoPreferenceUtils.putString(KEY_RM_DUPLICATE_SWITCH, switchValue, type);
    }

    public static String getPrefetchSwitch(int type) {
        return VideoPreferenceUtils.getString(KEY_PREFETCH_SWITCH, "1", type);
    }

    public static void savePrefetchSwitch(String switchValue, int type) {
        VideoPreferenceUtils.putString(KEY_PREFETCH_SWITCH, switchValue, type);
    }

    public static void saveFeedPreLoadPosition(int preLoadPosition, int type) {
        VideoPreferenceUtils.putInt(KEY_FEED_LIST_PRELOAD_POSITION, preLoadPosition, type);
    }

    public static int getFeedPreLoadPosition(int type) {
        int defaultPreLoadPosition;
        if (type == 0) {
            defaultPreLoadPosition = 0;
        } else {
            defaultPreLoadPosition = 4;
        }
        return VideoPreferenceUtils.getInt(KEY_FEED_LIST_PRELOAD_POSITION, defaultPreLoadPosition, type);
    }

    public static String getMiniVideoTopicPage(int type) {
        return VideoPreferenceUtils.getString(KEY_MINIVIDEO_TOPIC_PAGE, "", type);
    }

    public static void saveMiniVideoTopicPage(String topicPage, int type) {
        VideoPreferenceUtils.putString(KEY_MINIVIDEO_TOPIC_PAGE, topicPage, type);
    }
}
