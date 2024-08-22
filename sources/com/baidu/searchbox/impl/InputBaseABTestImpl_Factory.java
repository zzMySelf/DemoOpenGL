package com.baidu.searchbox.impl;

public class InputBaseABTestImpl_Factory {
    private static volatile InputBaseABTestImpl instance;

    private InputBaseABTestImpl_Factory() {
    }

    public static synchronized InputBaseABTestImpl get() {
        InputBaseABTestImpl inputBaseABTestImpl;
        synchronized (InputBaseABTestImpl_Factory.class) {
            if (instance == null) {
                instance = new InputBaseABTestImpl();
            }
            inputBaseABTestImpl = instance;
        }
        return inputBaseABTestImpl;
    }
}
