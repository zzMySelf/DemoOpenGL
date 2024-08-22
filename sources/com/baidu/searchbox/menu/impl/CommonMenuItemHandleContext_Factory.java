package com.baidu.searchbox.menu.impl;

public class CommonMenuItemHandleContext_Factory {
    private static volatile CommonMenuItemHandleContext instance;

    private CommonMenuItemHandleContext_Factory() {
    }

    public static synchronized CommonMenuItemHandleContext get() {
        CommonMenuItemHandleContext commonMenuItemHandleContext;
        synchronized (CommonMenuItemHandleContext_Factory.class) {
            if (instance == null) {
                instance = new CommonMenuItemHandleContext();
            }
            commonMenuItemHandleContext = instance;
        }
        return commonMenuItemHandleContext;
    }
}
