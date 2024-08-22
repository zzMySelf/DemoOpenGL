package com.tera.scan.permission.request;

import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.permission.ui.dialog.ScanPermissionDialog;
import fe.mmm.qw.ggg.qw;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DefaultExternalStoragePermission$showReqPermissionDialog$2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ScanPermissionDialog $scanPermissionDialog;
    public final /* synthetic */ DefaultExternalStoragePermission this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultExternalStoragePermission$showReqPermissionDialog$2(DefaultExternalStoragePermission defaultExternalStoragePermission, ScanPermissionDialog scanPermissionDialog) {
        super(0);
        this.this$0 = defaultExternalStoragePermission;
        this.$scanPermissionDialog = scanPermissionDialog;
    }

    public final void invoke() {
        ScanAnalyticsBaseEvent.qw.qw(qw.qw, "require_files_reading_save_dialog_deny_click", (List) null, 2, (Object) null);
        this.this$0.pf();
        this.$scanPermissionDialog.dismiss();
        this.this$0.rg().invoke();
    }
}
