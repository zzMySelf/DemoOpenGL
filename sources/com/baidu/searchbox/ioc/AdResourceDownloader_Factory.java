package com.baidu.searchbox.ioc;

public class AdResourceDownloader_Factory {
    private static volatile AdResourceDownloader instance;

    private AdResourceDownloader_Factory() {
    }

    public static synchronized AdResourceDownloader get() {
        AdResourceDownloader adResourceDownloader;
        synchronized (AdResourceDownloader_Factory.class) {
            if (instance == null) {
                instance = new AdResourceDownloader();
            }
            adResourceDownloader = instance;
        }
        return adResourceDownloader;
    }
}
