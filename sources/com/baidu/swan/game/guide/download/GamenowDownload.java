package com.baidu.swan.game.guide.download;

import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.game.ad.downloader.model.DownloadState;

public class GamenowDownload {
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String NO_PROGRESS = "0";
    private String gamenowApkId;
    public String name;
    public int percent = Integer.parseInt("0");
    public DownloadState status = DownloadState.NOT_START;
    public String url;

    private GamenowDownload() {
    }

    public static GamenowDownload create(String url2, String packageName) {
        GamenowDownload extra = new GamenowDownload();
        extra.url = url2;
        extra.name = packageName;
        return extra;
    }

    public String getGamenowApkId() {
        return this.gamenowApkId;
    }

    public void setGamenowApkId(String gamenowApkId2) {
        this.gamenowApkId = gamenowApkId2;
    }
}
