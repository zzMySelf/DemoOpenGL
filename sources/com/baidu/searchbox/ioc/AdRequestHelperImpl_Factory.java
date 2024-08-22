package com.baidu.searchbox.ioc;

public class AdRequestHelperImpl_Factory {
    private static volatile AdRequestHelperImpl instance;

    private AdRequestHelperImpl_Factory() {
    }

    public static synchronized AdRequestHelperImpl get() {
        AdRequestHelperImpl adRequestHelperImpl;
        synchronized (AdRequestHelperImpl_Factory.class) {
            if (instance == null) {
                instance = new AdRequestHelperImpl();
            }
            adRequestHelperImpl = instance;
        }
        return adRequestHelperImpl;
    }
}
