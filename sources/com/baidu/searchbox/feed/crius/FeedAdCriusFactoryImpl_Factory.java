package com.baidu.searchbox.feed.crius;

public class FeedAdCriusFactoryImpl_Factory {
    private static volatile FeedAdCriusFactoryImpl instance;

    private FeedAdCriusFactoryImpl_Factory() {
    }

    public static synchronized FeedAdCriusFactoryImpl get() {
        FeedAdCriusFactoryImpl feedAdCriusFactoryImpl;
        synchronized (FeedAdCriusFactoryImpl_Factory.class) {
            if (instance == null) {
                instance = new FeedAdCriusFactoryImpl();
            }
            feedAdCriusFactoryImpl = instance;
        }
        return feedAdCriusFactoryImpl;
    }
}
