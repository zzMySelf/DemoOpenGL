package com.baidu.searchbox.download.center.ui.fusion;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.videoplayer.interfaces.CyberDeleteEvent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/download/center/ui/fusion/FileManagerActivity$registListener$2", "Lcom/baidu/searchbox/bdeventbus/Action;", "Lcom/baidu/searchbox/videoplayer/interfaces/CyberDeleteEvent;", "call", "", "cyberDeleteEvent", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileManagerActivity.kt */
public final class FileManagerActivity$registListener$2 implements Action<CyberDeleteEvent> {
    final /* synthetic */ FileManagerActivity this$0;

    FileManagerActivity$registListener$2(FileManagerActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void call(CyberDeleteEvent cyberDeleteEvent) {
        Intrinsics.checkNotNullParameter(cyberDeleteEvent, "cyberDeleteEvent");
        if (cyberDeleteEvent.isSuccess()) {
            Pair<Boolean, Boolean> recentDatasContains = this.this$0.getFileManagerAdapter().recentDatasContains(CollectionsKt.listOf(Long.valueOf(cyberDeleteEvent.getDownloadId())));
            boolean downloadContains = recentDatasContains.component1().booleanValue();
            boolean openContains = recentDatasContains.component2().booleanValue();
            if (downloadContains && openContains) {
                this.this$0.refreshRecentAll();
            } else if (downloadContains) {
                this.this$0.refreshRecentDownload();
            } else if (openContains) {
                this.this$0.refreshRecentOpen();
            }
        }
    }
}
