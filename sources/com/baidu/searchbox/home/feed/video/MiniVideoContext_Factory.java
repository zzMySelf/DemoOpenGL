package com.baidu.searchbox.home.feed.video;

public class MiniVideoContext_Factory {
    private static volatile MiniVideoContext instance;

    private MiniVideoContext_Factory() {
    }

    public static synchronized MiniVideoContext get() {
        MiniVideoContext miniVideoContext;
        synchronized (MiniVideoContext_Factory.class) {
            if (instance == null) {
                instance = new MiniVideoContext();
            }
            miniVideoContext = instance;
        }
        return miniVideoContext;
    }
}
