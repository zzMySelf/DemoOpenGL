package com.baidu.searchbox.videopublisher.aipublishergenerate.generateinfo.manager.task;

import android.net.Uri;
import com.baidu.searchbox.ugc.download.ADownLoadStatusListener;
import com.baidu.searchbox.videopublisher.aipublishergenerate.generateinfo.manager.model.AiPublisherPackageQueryData;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ5\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/videopublisher/aipublishergenerate/generateinfo/manager/task/AiPublisherPackageDownloadImageTask$startDownload$1", "Lcom/baidu/searchbox/ugc/download/ADownLoadStatusListener;", "completed", "", "id", "", "url", "", "uri", "Landroid/net/Uri;", "(Ljava/lang/Integer;Ljava/lang/String;Landroid/net/Uri;)V", "onError", "exception", "Ljava/lang/Exception;", "(Ljava/lang/Integer;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/Exception;)V", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiPublisherPackageDownloadImageTask.kt */
public final class AiPublisherPackageDownloadImageTask$startDownload$1 extends ADownLoadStatusListener {
    final /* synthetic */ String $fileName;
    final /* synthetic */ File $parentFile;
    final /* synthetic */ AiPublisherPackageQueryData $queryData;
    final /* synthetic */ AiPublisherPackageDownloadImageTask this$0;

    AiPublisherPackageDownloadImageTask$startDownload$1(File $parentFile2, String $fileName2, AiPublisherPackageQueryData $queryData2, AiPublisherPackageDownloadImageTask $receiver) {
        this.$parentFile = $parentFile2;
        this.$fileName = $fileName2;
        this.$queryData = $queryData2;
        this.this$0 = $receiver;
    }

    public void completed(Integer id, String url, Uri uri) {
        super.completed(id, url, uri);
        String fileLocalPath = this.$parentFile.getAbsolutePath() + File.separator + this.$fileName;
        AiPublisherPackageQueryData aiPublisherPackageQueryData = this.$queryData;
        if (aiPublisherPackageQueryData != null) {
            aiPublisherPackageQueryData.setLocalImageFilePath(fileLocalPath);
        }
        this.this$0.listener.downloadSuccess(this.$queryData);
    }

    public void onError(Integer id, String url, Uri uri, Exception exception) {
        super.onError(id, url, uri, exception);
        this.this$0.onFail(-1, "download image error " + (exception != null ? exception.getMessage() : null), (String) null, this.$queryData);
    }
}
