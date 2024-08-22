package com.baidu.searchbox.ioc;

public class AdHistoryRuntimeImpl_Factory {
    private static volatile AdHistoryRuntimeImpl instance;

    private AdHistoryRuntimeImpl_Factory() {
    }

    public static synchronized AdHistoryRuntimeImpl get() {
        AdHistoryRuntimeImpl adHistoryRuntimeImpl;
        synchronized (AdHistoryRuntimeImpl_Factory.class) {
            if (instance == null) {
                instance = new AdHistoryRuntimeImpl();
            }
            adHistoryRuntimeImpl = instance;
        }
        return adHistoryRuntimeImpl;
    }
}
