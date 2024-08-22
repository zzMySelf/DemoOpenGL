package com.baidu.bdtask.ioc;

public class BDPTaskImpl_Factory {
    private static volatile BDPTaskImpl instance;

    private BDPTaskImpl_Factory() {
    }

    public static synchronized BDPTaskImpl get() {
        BDPTaskImpl bDPTaskImpl;
        synchronized (BDPTaskImpl_Factory.class) {
            if (instance == null) {
                instance = new BDPTaskImpl();
            }
            bDPTaskImpl = instance;
        }
        return bDPTaskImpl;
    }
}
