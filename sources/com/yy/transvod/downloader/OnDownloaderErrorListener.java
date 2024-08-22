package com.yy.transvod.downloader;

public interface OnDownloaderErrorListener {
    public static final int DOWNLOADER_ERROR_CONNECT_ERROR = 1002;
    public static final int DOWNLOADER_ERROR_CONNECT_TIMEOUT_ERROR = 1004;
    public static final int DOWNLOADER_ERROR_DNSRESOLVE_ERROR = 1003;
    public static final int DOWNLOADER_ERROR_HTTP_ERROR = 1001;
    public static final int DOWNLOADER_ERROR_RESPONSE_TIMEOUT_ERROR = 1005;
    public static final int DOWNLOADER_ERROR_REV_DATA_TIMEOUT_ERROR = 1006;

    void onDownloaderError(MediaDownloader mediaDownloader, String str, int i2, int i3);
}
