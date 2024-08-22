package com.baidu.talos.core.render.views.rncwebview;

import android.app.DownloadManager;
import android.net.Uri;

class WebViewDownloadRequest extends DownloadManager.Request {
    private DownLoadCallback callback;
    private String url;

    interface DownLoadCallback {
        void onDownloadFinish(String str);
    }

    public WebViewDownloadRequest(Uri uri) {
        super(uri);
        this.url = uri.toString();
    }

    public String getUrl() {
        return this.url;
    }

    public void setCallback(DownLoadCallback callback2) {
        this.callback = callback2;
    }

    public DownLoadCallback getCallback() {
        return this.callback;
    }
}
