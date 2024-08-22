package com.baidu.swan.apps.impl.config;

public class SwanAppRuntimeConfigImpl_Factory {
    private static volatile SwanAppRuntimeConfigImpl instance;

    private SwanAppRuntimeConfigImpl_Factory() {
    }

    public static synchronized SwanAppRuntimeConfigImpl get() {
        SwanAppRuntimeConfigImpl swanAppRuntimeConfigImpl;
        synchronized (SwanAppRuntimeConfigImpl_Factory.class) {
            if (instance == null) {
                instance = new SwanAppRuntimeConfigImpl();
            }
            swanAppRuntimeConfigImpl = instance;
        }
        return swanAppRuntimeConfigImpl;
    }
}
