package com.baidu.searchbox.pms.init;

public class PmsManagerImpl_Factory {
    private static volatile PmsManagerImpl instance;

    private PmsManagerImpl_Factory() {
    }

    public static synchronized PmsManagerImpl get() {
        PmsManagerImpl pmsManagerImpl;
        synchronized (PmsManagerImpl_Factory.class) {
            if (instance == null) {
                instance = new PmsManagerImpl();
            }
            pmsManagerImpl = instance;
        }
        return pmsManagerImpl;
    }
}
