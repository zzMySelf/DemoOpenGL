package com.baidu.searchbox.video.flow.provider.creator;

public class VideoHotArchCreatorImpl_Factory {
    private static volatile VideoHotArchCreatorImpl instance;

    private VideoHotArchCreatorImpl_Factory() {
    }

    public static synchronized VideoHotArchCreatorImpl get() {
        VideoHotArchCreatorImpl videoHotArchCreatorImpl;
        synchronized (VideoHotArchCreatorImpl_Factory.class) {
            if (instance == null) {
                instance = new VideoHotArchCreatorImpl();
            }
            videoHotArchCreatorImpl = instance;
        }
        return videoHotArchCreatorImpl;
    }
}
