package com.baidu.searchbox.aisearch.utils.download;

import com.baidu.searchbox.aisearch.utils.download.interfaces.DownloadSpeedBridgeCallback;
import com.baidu.searchbox.bddownload.DownloadTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/aisearch/utils/download/AISearchDownloadHelper;", "", "()V", "startTask", "", "task", "Lcom/baidu/searchbox/bddownload/DownloadTask;", "callback", "Lcom/baidu/searchbox/aisearch/utils/download/interfaces/DownloadSpeedBridgeCallback;", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AISearchDownloadHelper.kt */
public final class AISearchDownloadHelper {
    public static final AISearchDownloadHelper INSTANCE = new AISearchDownloadHelper();

    private AISearchDownloadHelper() {
    }

    public final void startTask(DownloadTask task, DownloadSpeedBridgeCallback callback) {
        if (task != null) {
            task.enqueue(new AISearchDownloadHelper$startTask$1(callback));
        }
    }
}
