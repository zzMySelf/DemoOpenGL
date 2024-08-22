package com.baidu.searchbox.video.detail.dependency.impl.scheme;

public class VideoSenderImpl_Factory {
    private static volatile VideoSenderImpl instance;

    private VideoSenderImpl_Factory() {
    }

    public static synchronized VideoSenderImpl get() {
        VideoSenderImpl videoSenderImpl;
        synchronized (VideoSenderImpl_Factory.class) {
            if (instance == null) {
                instance = new VideoSenderImpl();
            }
            videoSenderImpl = instance;
        }
        return videoSenderImpl;
    }
}
