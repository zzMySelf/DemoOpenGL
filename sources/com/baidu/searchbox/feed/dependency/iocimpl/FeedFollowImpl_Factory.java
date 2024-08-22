package com.baidu.searchbox.feed.dependency.iocimpl;

public class FeedFollowImpl_Factory {
    private static volatile FeedFollowImpl instance;

    private FeedFollowImpl_Factory() {
    }

    public static synchronized FeedFollowImpl get() {
        FeedFollowImpl feedFollowImpl;
        synchronized (FeedFollowImpl_Factory.class) {
            if (instance == null) {
                instance = new FeedFollowImpl();
            }
            feedFollowImpl = instance;
        }
        return feedFollowImpl;
    }
}
