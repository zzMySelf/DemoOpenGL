package com.baidu.searchbox.creative.impl;

public class IUIViewHelperImpl_Factory {
    private static volatile IUIViewHelperImpl instance;

    private IUIViewHelperImpl_Factory() {
    }

    public static synchronized IUIViewHelperImpl get() {
        IUIViewHelperImpl iUIViewHelperImpl;
        synchronized (IUIViewHelperImpl_Factory.class) {
            if (instance == null) {
                instance = new IUIViewHelperImpl();
            }
            iUIViewHelperImpl = instance;
        }
        return iUIViewHelperImpl;
    }
}
