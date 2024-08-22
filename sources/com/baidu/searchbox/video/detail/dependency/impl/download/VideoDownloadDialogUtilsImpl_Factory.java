package com.baidu.searchbox.video.detail.dependency.impl.download;

public class VideoDownloadDialogUtilsImpl_Factory {
    private static volatile VideoDownloadDialogUtilsImpl instance;

    private VideoDownloadDialogUtilsImpl_Factory() {
    }

    public static synchronized VideoDownloadDialogUtilsImpl get() {
        VideoDownloadDialogUtilsImpl videoDownloadDialogUtilsImpl;
        synchronized (VideoDownloadDialogUtilsImpl_Factory.class) {
            if (instance == null) {
                instance = new VideoDownloadDialogUtilsImpl();
            }
            videoDownloadDialogUtilsImpl = instance;
        }
        return videoDownloadDialogUtilsImpl;
    }
}
