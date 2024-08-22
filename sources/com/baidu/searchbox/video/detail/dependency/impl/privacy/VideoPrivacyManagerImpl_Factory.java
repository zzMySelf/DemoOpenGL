package com.baidu.searchbox.video.detail.dependency.impl.privacy;

public class VideoPrivacyManagerImpl_Factory {
    private static volatile VideoPrivacyManagerImpl instance;

    private VideoPrivacyManagerImpl_Factory() {
    }

    public static synchronized VideoPrivacyManagerImpl get() {
        VideoPrivacyManagerImpl videoPrivacyManagerImpl;
        synchronized (VideoPrivacyManagerImpl_Factory.class) {
            if (instance == null) {
                instance = new VideoPrivacyManagerImpl();
            }
            videoPrivacyManagerImpl = instance;
        }
        return videoPrivacyManagerImpl;
    }
}
