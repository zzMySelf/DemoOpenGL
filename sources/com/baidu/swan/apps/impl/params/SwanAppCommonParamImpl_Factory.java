package com.baidu.swan.apps.impl.params;

public class SwanAppCommonParamImpl_Factory {
    private static volatile SwanAppCommonParamImpl instance;

    private SwanAppCommonParamImpl_Factory() {
    }

    public static synchronized SwanAppCommonParamImpl get() {
        SwanAppCommonParamImpl swanAppCommonParamImpl;
        synchronized (SwanAppCommonParamImpl_Factory.class) {
            if (instance == null) {
                instance = new SwanAppCommonParamImpl();
            }
            swanAppCommonParamImpl = instance;
        }
        return swanAppCommonParamImpl;
    }
}
