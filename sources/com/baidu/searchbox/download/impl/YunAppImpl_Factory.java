package com.baidu.searchbox.download.impl;

public class YunAppImpl_Factory {
    private static volatile YunAppImpl instance;

    private YunAppImpl_Factory() {
    }

    public static synchronized YunAppImpl get() {
        YunAppImpl yunAppImpl;
        synchronized (YunAppImpl_Factory.class) {
            if (instance == null) {
                instance = new YunAppImpl();
            }
            yunAppImpl = instance;
        }
        return yunAppImpl;
    }
}
