package com.baidu.searchbox.prefetch;

public class AdPrefetchImpl_Factory {
    private static volatile AdPrefetchImpl instance;

    private AdPrefetchImpl_Factory() {
    }

    public static synchronized AdPrefetchImpl get() {
        AdPrefetchImpl adPrefetchImpl;
        synchronized (AdPrefetchImpl_Factory.class) {
            if (instance == null) {
                instance = new AdPrefetchImpl();
            }
            adPrefetchImpl = instance;
        }
        return adPrefetchImpl;
    }
}
