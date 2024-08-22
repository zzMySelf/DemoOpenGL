package com.baidu.swan.games.stability;

public class SwanGameErrorManagerImpl_Factory {
    private static volatile SwanGameErrorManagerImpl instance;

    private SwanGameErrorManagerImpl_Factory() {
    }

    public static synchronized SwanGameErrorManagerImpl get() {
        SwanGameErrorManagerImpl swanGameErrorManagerImpl;
        synchronized (SwanGameErrorManagerImpl_Factory.class) {
            if (instance == null) {
                instance = new SwanGameErrorManagerImpl();
            }
            swanGameErrorManagerImpl = instance;
        }
        return swanGameErrorManagerImpl;
    }
}
