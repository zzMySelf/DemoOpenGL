package com.baidu.searchbox.lightbrowser.dependency;

public class LightBrowserVideo_Factory {
    private static volatile LightBrowserVideo instance;

    private LightBrowserVideo_Factory() {
    }

    public static synchronized LightBrowserVideo get() {
        LightBrowserVideo lightBrowserVideo;
        synchronized (LightBrowserVideo_Factory.class) {
            if (instance == null) {
                instance = new LightBrowserVideo();
            }
            lightBrowserVideo = instance;
        }
        return lightBrowserVideo;
    }
}
