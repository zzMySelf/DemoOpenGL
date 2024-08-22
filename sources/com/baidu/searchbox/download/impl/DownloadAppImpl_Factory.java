package com.baidu.searchbox.download.impl;

public class DownloadAppImpl_Factory {
    private static volatile DownloadAppImpl instance;

    private DownloadAppImpl_Factory() {
    }

    public static synchronized DownloadAppImpl get() {
        DownloadAppImpl downloadAppImpl;
        synchronized (DownloadAppImpl_Factory.class) {
            if (instance == null) {
                instance = new DownloadAppImpl();
            }
            downloadAppImpl = instance;
        }
        return downloadAppImpl;
    }
}
