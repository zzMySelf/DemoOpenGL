package com.baidu.swan.apps.ioc.impl;

public class SwanNetworkImpl_Factory {
    private static volatile SwanNetworkImpl instance;

    private SwanNetworkImpl_Factory() {
    }

    public static synchronized SwanNetworkImpl get() {
        SwanNetworkImpl swanNetworkImpl;
        synchronized (SwanNetworkImpl_Factory.class) {
            if (instance == null) {
                instance = new SwanNetworkImpl();
            }
            swanNetworkImpl = instance;
        }
        return swanNetworkImpl;
    }
}
