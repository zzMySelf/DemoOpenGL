package com.baidu.searchbox.video.feedflow.detail.appdownload;

import android.net.Uri;
import com.baidu.searchbox.download.DownloadFileCallBack;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VideoAppDownloadManager$$ExternalSyntheticLambda1 implements DownloadFileCallBack {
    public final /* synthetic */ VideoAppDownloadManager f$0;

    public /* synthetic */ VideoAppDownloadManager$$ExternalSyntheticLambda1(VideoAppDownloadManager videoAppDownloadManager) {
        this.f$0 = videoAppDownloadManager;
    }

    public final void onResult(Uri uri, File file) {
        VideoAppDownloadManager.m10587installApp$lambda2(this.f$0, uri, file);
    }
}
