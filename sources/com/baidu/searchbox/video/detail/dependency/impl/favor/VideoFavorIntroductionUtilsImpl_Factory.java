package com.baidu.searchbox.video.detail.dependency.impl.favor;

public class VideoFavorIntroductionUtilsImpl_Factory {
    private static volatile VideoFavorIntroductionUtilsImpl instance;

    private VideoFavorIntroductionUtilsImpl_Factory() {
    }

    public static synchronized VideoFavorIntroductionUtilsImpl get() {
        VideoFavorIntroductionUtilsImpl videoFavorIntroductionUtilsImpl;
        synchronized (VideoFavorIntroductionUtilsImpl_Factory.class) {
            if (instance == null) {
                instance = new VideoFavorIntroductionUtilsImpl();
            }
            videoFavorIntroductionUtilsImpl = instance;
        }
        return videoFavorIntroductionUtilsImpl;
    }
}
