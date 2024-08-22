package com.baidu.searchbox.sniffer.utils;

import com.baidu.searchbox.sniffer.SnifferSourceInfo;
import com.baidu.searchbox.sniffer.panel.SnifferFileStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/sniffer/SnifferSourceInfo;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnifferSaveNetUtils.kt */
final class SnifferSaveNetUtilsKt$updateFilesStatusAfterQuery$2$2 extends Lambda implements Function1<SnifferSourceInfo, Unit> {
    final /* synthetic */ float $progress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnifferSaveNetUtilsKt$updateFilesStatusAfterQuery$2$2(float f2) {
        super(1);
        this.$progress = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SnifferSourceInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SnifferSourceInfo $this$handleSnifferInfoUpdate) {
        Intrinsics.checkNotNullParameter($this$handleSnifferInfoUpdate, "$this$handleSnifferInfoUpdate");
        $this$handleSnifferInfoUpdate.setCloudSaveProgress(Float.valueOf(this.$progress));
        $this$handleSnifferInfoUpdate.setCloudSaveStatus(SnifferFileStatus.UPLOADING);
    }
}
