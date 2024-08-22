package com.baidu.searchbox.ioc;

public class AdDownloadManager_Factory {
    private static volatile AdDownloadManager instance;

    private AdDownloadManager_Factory() {
    }

    public static synchronized AdDownloadManager get() {
        AdDownloadManager adDownloadManager;
        synchronized (AdDownloadManager_Factory.class) {
            if (instance == null) {
                instance = new AdDownloadManager();
            }
            adDownloadManager = instance;
        }
        return adDownloadManager;
    }
}
