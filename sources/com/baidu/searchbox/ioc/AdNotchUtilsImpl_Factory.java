package com.baidu.searchbox.ioc;

public class AdNotchUtilsImpl_Factory {
    private static volatile AdNotchUtilsImpl instance;

    private AdNotchUtilsImpl_Factory() {
    }

    public static synchronized AdNotchUtilsImpl get() {
        AdNotchUtilsImpl adNotchUtilsImpl;
        synchronized (AdNotchUtilsImpl_Factory.class) {
            if (instance == null) {
                instance = new AdNotchUtilsImpl();
            }
            adNotchUtilsImpl = instance;
        }
        return adNotchUtilsImpl;
    }
}
