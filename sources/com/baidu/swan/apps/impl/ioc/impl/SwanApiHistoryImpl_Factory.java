package com.baidu.swan.apps.impl.ioc.impl;

public class SwanApiHistoryImpl_Factory {
    private static volatile SwanApiHistoryImpl instance;

    private SwanApiHistoryImpl_Factory() {
    }

    public static synchronized SwanApiHistoryImpl get() {
        SwanApiHistoryImpl swanApiHistoryImpl;
        synchronized (SwanApiHistoryImpl_Factory.class) {
            if (instance == null) {
                instance = new SwanApiHistoryImpl();
            }
            swanApiHistoryImpl = instance;
        }
        return swanApiHistoryImpl;
    }
}
