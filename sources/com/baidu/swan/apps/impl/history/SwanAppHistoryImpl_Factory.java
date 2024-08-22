package com.baidu.swan.apps.impl.history;

public class SwanAppHistoryImpl_Factory {
    private static volatile SwanAppHistoryImpl instance;

    private SwanAppHistoryImpl_Factory() {
    }

    public static synchronized SwanAppHistoryImpl get() {
        SwanAppHistoryImpl swanAppHistoryImpl;
        synchronized (SwanAppHistoryImpl_Factory.class) {
            if (instance == null) {
                instance = new SwanAppHistoryImpl();
            }
            swanAppHistoryImpl = instance;
        }
        return swanAppHistoryImpl;
    }
}
