package com.baidu.searchbox.feed.ad.hscrollcard;

public class NadMiniVideoHScrollCardHelperImpl_Factory {
    private static volatile NadMiniVideoHScrollCardHelperImpl instance;

    private NadMiniVideoHScrollCardHelperImpl_Factory() {
    }

    public static synchronized NadMiniVideoHScrollCardHelperImpl get() {
        NadMiniVideoHScrollCardHelperImpl nadMiniVideoHScrollCardHelperImpl;
        synchronized (NadMiniVideoHScrollCardHelperImpl_Factory.class) {
            if (instance == null) {
                instance = new NadMiniVideoHScrollCardHelperImpl();
            }
            nadMiniVideoHScrollCardHelperImpl = instance;
        }
        return nadMiniVideoHScrollCardHelperImpl;
    }
}
