package com.baidu.searchbox.video.detail.dependency.impl.ad;

public class VideoAdUtilsImpl_Factory {
    private static volatile VideoAdUtilsImpl instance;

    private VideoAdUtilsImpl_Factory() {
    }

    public static synchronized VideoAdUtilsImpl get() {
        VideoAdUtilsImpl videoAdUtilsImpl;
        synchronized (VideoAdUtilsImpl_Factory.class) {
            if (instance == null) {
                instance = new VideoAdUtilsImpl();
            }
            videoAdUtilsImpl = instance;
        }
        return videoAdUtilsImpl;
    }
}
