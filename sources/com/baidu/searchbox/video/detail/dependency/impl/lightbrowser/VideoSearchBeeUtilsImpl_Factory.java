package com.baidu.searchbox.video.detail.dependency.impl.lightbrowser;

public class VideoSearchBeeUtilsImpl_Factory {
    private static volatile VideoSearchBeeUtilsImpl instance;

    private VideoSearchBeeUtilsImpl_Factory() {
    }

    public static synchronized VideoSearchBeeUtilsImpl get() {
        VideoSearchBeeUtilsImpl videoSearchBeeUtilsImpl;
        synchronized (VideoSearchBeeUtilsImpl_Factory.class) {
            if (instance == null) {
                instance = new VideoSearchBeeUtilsImpl();
            }
            videoSearchBeeUtilsImpl = instance;
        }
        return videoSearchBeeUtilsImpl;
    }
}
