package com.baidu.searchbox.messagebusiness;

public class DeprecationAppImpl_Factory {
    private static volatile DeprecationAppImpl instance;

    private DeprecationAppImpl_Factory() {
    }

    public static synchronized DeprecationAppImpl get() {
        DeprecationAppImpl deprecationAppImpl;
        synchronized (DeprecationAppImpl_Factory.class) {
            if (instance == null) {
                instance = new DeprecationAppImpl();
            }
            deprecationAppImpl = instance;
        }
        return deprecationAppImpl;
    }
}
