package com.baidu.searchbox.ioc;

public class NadDownloadInfoReservedImpl_Factory {
    private static volatile NadDownloadInfoReservedImpl instance;

    private NadDownloadInfoReservedImpl_Factory() {
    }

    public static synchronized NadDownloadInfoReservedImpl get() {
        NadDownloadInfoReservedImpl nadDownloadInfoReservedImpl;
        synchronized (NadDownloadInfoReservedImpl_Factory.class) {
            if (instance == null) {
                instance = new NadDownloadInfoReservedImpl();
            }
            nadDownloadInfoReservedImpl = instance;
        }
        return nadDownloadInfoReservedImpl;
    }
}
