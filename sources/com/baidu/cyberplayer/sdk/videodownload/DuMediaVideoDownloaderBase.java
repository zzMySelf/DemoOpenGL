package com.baidu.cyberplayer.sdk.videodownload;

public class DuMediaVideoDownloaderBase {

    public interface DownloadListener {
        void onDataTransfer(String str, DuMediaVideoDownloadBean duMediaVideoDownloadBean);

        void operationCallback(String str, int i2, int i3);
    }
}
