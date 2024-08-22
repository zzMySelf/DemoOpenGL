package com.baidu.swan.games.stability;

public class SwanGameUBCManagerImpl_Factory {
    private static volatile SwanGameUBCManagerImpl instance;

    private SwanGameUBCManagerImpl_Factory() {
    }

    public static synchronized SwanGameUBCManagerImpl get() {
        SwanGameUBCManagerImpl swanGameUBCManagerImpl;
        synchronized (SwanGameUBCManagerImpl_Factory.class) {
            if (instance == null) {
                instance = new SwanGameUBCManagerImpl();
            }
            swanGameUBCManagerImpl = instance;
        }
        return swanGameUBCManagerImpl;
    }
}
