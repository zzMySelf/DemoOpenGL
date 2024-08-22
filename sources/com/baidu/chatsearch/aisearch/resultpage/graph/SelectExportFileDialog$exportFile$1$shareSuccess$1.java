package com.baidu.chatsearch.aisearch.resultpage.graph;

import com.baidu.chatsearch.aisearch.resultpage.graph.ShareStatusPopupWindow;
import com.baidu.chatsearch.logger.AppLogger;
import com.baidu.chatsearch.taskdispatcher.TaskDispatcherExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectExportFileDialog.kt */
final class SelectExportFileDialog$exportFile$1$shareSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ShareStatusPopupWindow $shareStatusPopupWindow;
    final /* synthetic */ SelectExportFileDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectExportFileDialog$exportFile$1$shareSuccess$1(SelectExportFileDialog selectExportFileDialog, ShareStatusPopupWindow shareStatusPopupWindow) {
        super(0);
        this.this$0 = selectExportFileDialog;
        this.$shareStatusPopupWindow = shareStatusPopupWindow;
    }

    public final void invoke() {
        if (this.this$0.isDisposed()) {
            AppLogger.v("SelectExportFileDialog", "SelectExportFileDialog download -> isDisposed do nothing..");
            return;
        }
        this.$shareStatusPopupWindow.setShareStatus(ShareStatusPopupWindow.ShareStatus.SHARE_SUCESS);
        final ShareStatusPopupWindow shareStatusPopupWindow = this.$shareStatusPopupWindow;
        TaskDispatcherExtensionKt.runUiThreadDelay(300, new Function0<Unit>() {
            public final void invoke() {
                shareStatusPopupWindow.dismiss();
            }
        });
    }
}
