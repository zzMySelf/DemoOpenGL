package com.baidu.searchbox.video.detail.dependency.impl.devices;

public class VideoApkStateImpl_Factory {
    private static volatile VideoApkStateImpl instance;

    private VideoApkStateImpl_Factory() {
    }

    public static synchronized VideoApkStateImpl get() {
        VideoApkStateImpl videoApkStateImpl;
        synchronized (VideoApkStateImpl_Factory.class) {
            if (instance == null) {
                instance = new VideoApkStateImpl();
            }
            videoApkStateImpl = instance;
        }
        return videoApkStateImpl;
    }
}
