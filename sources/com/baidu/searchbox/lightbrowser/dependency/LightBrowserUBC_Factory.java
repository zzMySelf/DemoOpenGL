package com.baidu.searchbox.lightbrowser.dependency;

public class LightBrowserUBC_Factory {
    private static volatile LightBrowserUBC instance;

    private LightBrowserUBC_Factory() {
    }

    public static synchronized LightBrowserUBC get() {
        LightBrowserUBC lightBrowserUBC;
        synchronized (LightBrowserUBC_Factory.class) {
            if (instance == null) {
                instance = new LightBrowserUBC();
            }
            lightBrowserUBC = instance;
        }
        return lightBrowserUBC;
    }
}
