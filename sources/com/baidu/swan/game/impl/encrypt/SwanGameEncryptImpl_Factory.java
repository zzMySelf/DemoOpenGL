package com.baidu.swan.game.impl.encrypt;

public class SwanGameEncryptImpl_Factory {
    private static volatile SwanGameEncryptImpl instance;

    private SwanGameEncryptImpl_Factory() {
    }

    public static synchronized SwanGameEncryptImpl get() {
        SwanGameEncryptImpl swanGameEncryptImpl;
        synchronized (SwanGameEncryptImpl_Factory.class) {
            if (instance == null) {
                instance = new SwanGameEncryptImpl();
            }
            swanGameEncryptImpl = instance;
        }
        return swanGameEncryptImpl;
    }
}
