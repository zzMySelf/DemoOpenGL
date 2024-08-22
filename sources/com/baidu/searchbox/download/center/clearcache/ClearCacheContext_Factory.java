package com.baidu.searchbox.download.center.clearcache;

public class ClearCacheContext_Factory {
    private static volatile ClearCacheContext instance;

    private ClearCacheContext_Factory() {
    }

    public static synchronized ClearCacheContext get() {
        ClearCacheContext clearCacheContext;
        synchronized (ClearCacheContext_Factory.class) {
            if (instance == null) {
                instance = new ClearCacheContext();
            }
            clearCacheContext = instance;
        }
        return clearCacheContext;
    }
}
