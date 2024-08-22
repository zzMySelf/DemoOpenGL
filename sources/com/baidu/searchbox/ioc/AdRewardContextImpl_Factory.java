package com.baidu.searchbox.ioc;

public class AdRewardContextImpl_Factory {
    private static volatile AdRewardContextImpl instance;

    private AdRewardContextImpl_Factory() {
    }

    public static synchronized AdRewardContextImpl get() {
        AdRewardContextImpl adRewardContextImpl;
        synchronized (AdRewardContextImpl_Factory.class) {
            if (instance == null) {
                instance = new AdRewardContextImpl();
            }
            adRewardContextImpl = instance;
        }
        return adRewardContextImpl;
    }
}
