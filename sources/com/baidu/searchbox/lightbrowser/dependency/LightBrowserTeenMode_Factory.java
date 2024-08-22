package com.baidu.searchbox.lightbrowser.dependency;

public class LightBrowserTeenMode_Factory {
    private static volatile LightBrowserTeenMode instance;

    private LightBrowserTeenMode_Factory() {
    }

    public static synchronized LightBrowserTeenMode get() {
        LightBrowserTeenMode lightBrowserTeenMode;
        synchronized (LightBrowserTeenMode_Factory.class) {
            if (instance == null) {
                instance = new LightBrowserTeenMode();
            }
            lightBrowserTeenMode = instance;
        }
        return lightBrowserTeenMode;
    }
}
