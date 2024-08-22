package com.baidu.searchbox.picture.ioc;

public class BarCodeImpl_Factory {
    private static volatile BarCodeImpl instance;

    private BarCodeImpl_Factory() {
    }

    public static synchronized BarCodeImpl get() {
        BarCodeImpl barCodeImpl;
        synchronized (BarCodeImpl_Factory.class) {
            if (instance == null) {
                instance = new BarCodeImpl();
            }
            barCodeImpl = instance;
        }
        return barCodeImpl;
    }
}
