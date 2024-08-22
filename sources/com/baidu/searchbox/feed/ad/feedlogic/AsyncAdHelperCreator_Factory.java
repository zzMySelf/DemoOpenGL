package com.baidu.searchbox.feed.ad.feedlogic;

public class AsyncAdHelperCreator_Factory {
    private static volatile AsyncAdHelperCreator instance;

    private AsyncAdHelperCreator_Factory() {
    }

    public static synchronized AsyncAdHelperCreator get() {
        AsyncAdHelperCreator asyncAdHelperCreator;
        synchronized (AsyncAdHelperCreator_Factory.class) {
            if (instance == null) {
                instance = new AsyncAdHelperCreator();
            }
            asyncAdHelperCreator = instance;
        }
        return asyncAdHelperCreator;
    }
}
