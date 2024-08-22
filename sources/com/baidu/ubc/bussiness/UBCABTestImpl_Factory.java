package com.baidu.ubc.bussiness;

public class UBCABTestImpl_Factory {
    private static volatile UBCABTestImpl instance;

    private UBCABTestImpl_Factory() {
    }

    public static synchronized UBCABTestImpl get() {
        UBCABTestImpl uBCABTestImpl;
        synchronized (UBCABTestImpl_Factory.class) {
            if (instance == null) {
                instance = new UBCABTestImpl();
            }
            uBCABTestImpl = instance;
        }
        return uBCABTestImpl;
    }
}
