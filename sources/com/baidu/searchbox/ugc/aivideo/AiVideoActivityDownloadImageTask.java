package com.baidu.searchbox.ugc.aivideo;

import com.baidu.searchbox.ugc.download.ADownLoadStatusListener;
import com.baidu.searchbox.ugc.download.DownloadUtil;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.ugc.utils.LogUtil;
import com.baidu.searchbox.ugc.utils.UgcPerformanceUbcUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002J\u001e\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\bJ\u0018\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\bJ\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/ugc/aivideo/AiVideoActivityDownloadImageTask;", "Lcom/baidu/searchbox/ugc/aivideo/IAiVideoActivityHttpTask;", "listener", "Lcom/baidu/searchbox/ugc/aivideo/AiVideoActivityDownloadImageTask$OnDownloadImageResultListener;", "(Lcom/baidu/searchbox/ugc/aivideo/AiVideoActivityDownloadImageTask$OnDownloadImageResultListener;)V", "downloadListener", "Lcom/baidu/searchbox/ugc/download/ADownLoadStatusListener;", "imageUrl", "", "ubcStartTime", "", "getFileExtension", "url", "onFail", "", "toastMsg", "errorMsg", "parseJsonFindDownloadFile", "Ljava/io/File;", "dataJson", "release", "startDownload", "startDownloadVideo", "stopTask", "ubcGenerateSuccess", "Companion", "OnDownloadImageResultListener", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiVideoActivityDownloadImageTask.kt */
public final class AiVideoActivityDownloadImageTask implements IAiVideoActivityHttpTask {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_DOWNLOAD_DIR_PATH = "downloadDirPath";
    private ADownLoadStatusListener downloadListener;
    private String imageUrl;
    /* access modifiers changed from: private */
    public final OnDownloadImageResultListener listener;
    private long ubcStartTime;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/ugc/aivideo/AiVideoActivityDownloadImageTask$OnDownloadImageResultListener;", "", "downloadFail", "", "errorMsg", "", "toastMsg", "downloadSuccess", "fileLocalPath", "type", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AiVideoActivityDownloadImageTask.kt */
    public interface OnDownloadImageResultListener {
        void downloadFail(String str, String str2);

        void downloadSuccess(String str, String str2);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/ugc/aivideo/AiVideoActivityDownloadImageTask$Companion;", "", "()V", "KEY_DOWNLOAD_DIR_PATH", "", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AiVideoActivityDownloadImageTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AiVideoActivityDownloadImageTask(OnDownloadImageResultListener listener2) {
        Intrinsics.checkNotNullParameter(listener2, "listener");
        this.listener = listener2;
    }

    public final void startDownload(String dataJson, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.imageUrl = url;
        if (url.length() == 0) {
            onFail(AiVideoActivityCreatingManager.INSTANCE.getERROR_TOAST(), "download image url empty");
            return;
        }
        this.ubcStartTime = System.currentTimeMillis();
        String fileName = System.currentTimeMillis() + ".jpg";
        Ref.ObjectRef parentFile = new Ref.ObjectRef();
        parentFile.element = parseJsonFindDownloadFile(dataJson);
        if (parentFile.element == null) {
            parentFile.element = new File(FileUtils.getUgcFilesRootDir(), "image_download");
        }
        if (this.downloadListener == null) {
            this.downloadListener = new AiVideoActivityDownloadImageTask$startDownload$1(this, parentFile, fileName);
        }
        DownloadUtil.INSTANCE.download(url, fileName, (File) parentFile.element, this.downloadListener);
    }

    private final String getFileExtension(String url) {
        String filename = url != null ? StringsKt.substringAfterLast$default(url, "/", (String) null, 2, (Object) null) : null;
        if (filename != null) {
            return StringsKt.substringAfterLast(filename, ".", "");
        }
        return null;
    }

    public final void startDownloadVideo(String dataJson, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.imageUrl = url;
        if (url.length() == 0) {
            onFail(AiVideoActivityCreatingManager.INSTANCE.getERROR_TOAST(), "download video url empty");
            return;
        }
        StringBuilder append = new StringBuilder().append(System.currentTimeMillis()).append('.');
        String fileExtension = getFileExtension(url);
        if (fileExtension == null) {
            fileExtension = "mp4";
        }
        String fileName = append.append(fileExtension).toString();
        Ref.ObjectRef parentFile = new Ref.ObjectRef();
        parentFile.element = parseJsonFindDownloadFile(dataJson);
        if (parentFile.element == null) {
            parentFile.element = new File(FileUtils.getUgcFilesRootDir(), "image_download");
        }
        if (this.downloadListener == null) {
            this.downloadListener = new AiVideoActivityDownloadImageTask$startDownloadVideo$1(parentFile, fileName, this);
        }
        DownloadUtil.INSTANCE.download(url, fileName, (File) parentFile.element, this.downloadListener);
    }

    private final File parseJsonFindDownloadFile(String dataJson) {
        CharSequence charSequence = dataJson;
        boolean z = false;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String downloadDirPath = null;
        try {
            downloadDirPath = new JSONObject(dataJson).optString(KEY_DOWNLOAD_DIR_PATH);
        } catch (Throwable e2) {
            LogUtil.e(e2);
        }
        CharSequence charSequence2 = downloadDirPath;
        if (charSequence2 == null || charSequence2.length() == 0) {
            z = true;
        }
        if (z) {
            return null;
        }
        return new File(downloadDirPath);
    }

    static /* synthetic */ void onFail$default(AiVideoActivityDownloadImageTask aiVideoActivityDownloadImageTask, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        aiVideoActivityDownloadImageTask.onFail(str, str2);
    }

    /* access modifiers changed from: private */
    public final void onFail(String toastMsg, String errorMsg) {
        this.listener.downloadFail(errorMsg == null ? "" : errorMsg, toastMsg);
    }

    public void stopTask() {
        release();
    }

    public void release() {
        this.downloadListener = null;
        if (this.imageUrl != null) {
            DownloadUtil.INSTANCE.cancel(this.imageUrl);
        }
        this.imageUrl = null;
        this.ubcStartTime = 0;
    }

    /* access modifiers changed from: private */
    public final void ubcGenerateSuccess() {
        long duration = System.currentTimeMillis() - this.ubcStartTime;
        UgcUBCUtils.ugcCaptureUbcEventStatisticsWithSource(UgcUBCUtils.UGC_AI_VIDEO_ACTIVITY_PAGE, AiVideoActivityCreatingManager.INSTANCE.getActivityId(), "image_download", String.valueOf(duration), (JSONObject) null);
        AiVideoActivityUbcProducer producer = new AiVideoActivityUbcProducer(UgcPerformanceUbcUtils.UGC_AI_VIDEO_ACTIVITY_TYPE_DOWNLOAD);
        AiVideoActivityUbcProducer $this$ubcGenerateSuccess_u24lambda_u2d1 = producer;
        $this$ubcGenerateSuccess_u24lambda_u2d1.setProducerSubType(AiVideoActivityCreatingManager.INSTANCE.getActivityId());
        $this$ubcGenerateSuccess_u24lambda_u2d1.setResult("success");
        $this$ubcGenerateSuccess_u24lambda_u2d1.setCostTime(duration);
        UgcPerformanceUbcUtils.ugcAiEditorPerformanceProducer(producer);
    }
}
