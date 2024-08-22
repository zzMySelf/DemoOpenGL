package com.tera.scan.pdfedit.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/tera/scan/pdfedit/ui/PdfMergeAdjustFileActivity$closeActivityReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfMergeAdjustFileActivity$closeActivityReceiver$1 extends BroadcastReceiver {
    public final /* synthetic */ PdfMergeAdjustFileActivity qw;

    public PdfMergeAdjustFileActivity$closeActivityReceiver$1(PdfMergeAdjustFileActivity pdfMergeAdjustFileActivity) {
        this.qw = pdfMergeAdjustFileActivity;
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (Intrinsics.areEqual((Object) intent != null ? intent.getAction() : null, (Object) PdfMergeAdjustFileActivity.CLOSE_PDF_MERGE_ADJUST_ACTIVITY)) {
            this.qw.finish();
        }
    }
}
