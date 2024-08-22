package com.baidu.searchbox.bridge;

public class ApsBusinessImpl_Factory {
    private static volatile ApsBusinessImpl instance;

    private ApsBusinessImpl_Factory() {
    }

    public static synchronized ApsBusinessImpl get() {
        ApsBusinessImpl apsBusinessImpl;
        synchronized (ApsBusinessImpl_Factory.class) {
            if (instance == null) {
                instance = new ApsBusinessImpl();
            }
            apsBusinessImpl = instance;
        }
        return apsBusinessImpl;
    }
}
