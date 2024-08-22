package com.baidu.picture.base.proxy;

import com.baidu.searchbox.picture.params.IPictureDownloadEngine;

public class DownloadProxy implements IDownloadPicture {
    private final IDownloadPicture pictureDownloader;

    public DownloadProxy(IDownloadPicture pictureDownloader2) {
        this.pictureDownloader = pictureDownloader2;
    }

    public void startDownload(String url) {
        this.pictureDownloader.startDownload(url);
    }

    public void startDownload(String url, IPictureDownloadEngine.IPictureDownloadListener listener) {
        this.pictureDownloader.startDownload(url, listener);
    }
}
