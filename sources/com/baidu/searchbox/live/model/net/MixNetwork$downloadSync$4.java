package com.baidu.searchbox.live.model.net;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: MixNetwork.kt */
final class MixNetwork$downloadSync$4 implements Runnable {
    final /* synthetic */ MixNetDownloadCallback $callback;
    final /* synthetic */ Object $key;

    MixNetwork$downloadSync$4(MixNetDownloadCallback mixNetDownloadCallback, Object obj) {
        this.$callback = mixNetDownloadCallback;
        this.$key = obj;
    }

    public final void run() {
        MixNetDownloadCallback mixNetDownloadCallback = this.$callback;
        if (mixNetDownloadCallback != null) {
            mixNetDownloadCallback.onFileDownloaded(this.$key, -1, -1, "env error 3");
        }
    }
}
