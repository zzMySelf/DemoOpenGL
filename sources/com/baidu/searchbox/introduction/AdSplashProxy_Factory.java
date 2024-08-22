package com.baidu.searchbox.introduction;

public class AdSplashProxy_Factory {
    private static volatile AdSplashProxy instance;

    private AdSplashProxy_Factory() {
    }

    public static synchronized AdSplashProxy get() {
        AdSplashProxy adSplashProxy;
        synchronized (AdSplashProxy_Factory.class) {
            if (instance == null) {
                instance = new AdSplashProxy();
            }
            adSplashProxy = instance;
        }
        return adSplashProxy;
    }
}
