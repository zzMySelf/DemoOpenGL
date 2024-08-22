package com.baidu.searchbox.feed.dependency.iocimpl;

public class FeedHistoryImpl_Factory {
    private static volatile FeedHistoryImpl instance;

    private FeedHistoryImpl_Factory() {
    }

    public static synchronized FeedHistoryImpl get() {
        FeedHistoryImpl feedHistoryImpl;
        synchronized (FeedHistoryImpl_Factory.class) {
            if (instance == null) {
                instance = new FeedHistoryImpl();
            }
            feedHistoryImpl = instance;
        }
        return feedHistoryImpl;
    }
}
