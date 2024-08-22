package com.baidu.swan.apps.impl.extension;

public class SwanAppExtensionImpl_Factory {
    private static volatile SwanAppExtensionImpl instance;

    private SwanAppExtensionImpl_Factory() {
    }

    public static synchronized SwanAppExtensionImpl get() {
        SwanAppExtensionImpl swanAppExtensionImpl;
        synchronized (SwanAppExtensionImpl_Factory.class) {
            if (instance == null) {
                instance = new SwanAppExtensionImpl();
            }
            swanAppExtensionImpl = instance;
        }
        return swanAppExtensionImpl;
    }
}
