package com.baidu.searchbox.feed.ioc;

import com.baidu.searchbox.feed.FeedRuntime;

public interface IFeedNews {
    public static final IFeedNews EMPTY = new IFeedNews() {
        public void removeAllNewsCache() {
        }

        public void removeNewsCacheById(String key) {
        }

        public void producePreRenderFroAd(String baseUrl, String data) {
        }

        public String getImageCache(String key, boolean needLog) {
            return null;
        }

        public void triggerPreHeatNewsTpl(boolean hardEnvironment) {
        }
    };

    String getImageCache(String str, boolean z);

    void producePreRenderFroAd(String str, String str2);

    void removeAllNewsCache();

    void removeNewsCacheById(String str);

    void triggerPreHeatNewsTpl(boolean z);

    public static final class Impl {
        private static IFeedNews sFeedNews = FeedRuntime.getFeedNews();

        private Impl() {
        }

        public static IFeedNews get() {
            if (sFeedNews == null) {
                sFeedNews = IFeedNews.EMPTY;
            }
            return sFeedNews;
        }
    }
}
