package com.baidu.searchbox.sniffer.panel.view.cloud;

import com.baidu.searchbox.sniffer.SnifferSourceInfo;
import com.baidu.searchbox.sniffer.panel.SnifferFileStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnifferFileCloudSaveButton.kt */
final class SnifferFileCloudSaveButton$onSnifferFileInfoCompactUpdated$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SnifferSourceInfo $fileInfoCompact;
    final /* synthetic */ SnifferFileCloudSaveButton this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnifferFileCloudSaveButton$onSnifferFileInfoCompactUpdated$1(SnifferSourceInfo snifferSourceInfo, SnifferFileCloudSaveButton snifferFileCloudSaveButton) {
        super(0);
        this.$fileInfoCompact = snifferSourceInfo;
        this.this$0 = snifferFileCloudSaveButton;
    }

    public final void invoke() {
        this.$fileInfoCompact.setCloudSaveStatus(SnifferFileStatus.COMPLETE);
        this.this$0.onSnifferFileInfoCompactUpdated(this.$fileInfoCompact);
    }
}
