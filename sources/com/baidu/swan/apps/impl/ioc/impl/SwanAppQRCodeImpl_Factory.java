package com.baidu.swan.apps.impl.ioc.impl;

public class SwanAppQRCodeImpl_Factory {
    private static volatile SwanAppQRCodeImpl instance;

    private SwanAppQRCodeImpl_Factory() {
    }

    public static synchronized SwanAppQRCodeImpl get() {
        SwanAppQRCodeImpl swanAppQRCodeImpl;
        synchronized (SwanAppQRCodeImpl_Factory.class) {
            if (instance == null) {
                instance = new SwanAppQRCodeImpl();
            }
            swanAppQRCodeImpl = instance;
        }
        return swanAppQRCodeImpl;
    }
}
