package com.baidu.searchbox.clearcache.bos;

public class ClearCacheFileReporterImpl_Factory {
    private static volatile ClearCacheFileReporterImpl instance;

    private ClearCacheFileReporterImpl_Factory() {
    }

    public static synchronized ClearCacheFileReporterImpl get() {
        ClearCacheFileReporterImpl clearCacheFileReporterImpl;
        synchronized (ClearCacheFileReporterImpl_Factory.class) {
            if (instance == null) {
                instance = new ClearCacheFileReporterImpl();
            }
            clearCacheFileReporterImpl = instance;
        }
        return clearCacheFileReporterImpl;
    }
}
