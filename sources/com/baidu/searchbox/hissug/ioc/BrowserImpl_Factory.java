package com.baidu.searchbox.hissug.ioc;

public class BrowserImpl_Factory {
    private static volatile BrowserImpl instance;

    private BrowserImpl_Factory() {
    }

    public static synchronized BrowserImpl get() {
        BrowserImpl browserImpl;
        synchronized (BrowserImpl_Factory.class) {
            if (instance == null) {
                instance = new BrowserImpl();
            }
            browserImpl = instance;
        }
        return browserImpl;
    }
}
