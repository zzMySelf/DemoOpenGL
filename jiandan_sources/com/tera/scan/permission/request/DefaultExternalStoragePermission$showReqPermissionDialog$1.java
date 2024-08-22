package com.tera.scan.permission.request;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.permission.ui.dialog.ScanPermissionDialog;
import fe.mmm.qw.ggg.qw;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DefaultExternalStoragePermission$showReqPermissionDialog$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ScanPermissionDialog $scanPermissionDialog;
    public final /* synthetic */ DefaultExternalStoragePermission this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultExternalStoragePermission$showReqPermissionDialog$1(DefaultExternalStoragePermission defaultExternalStoragePermission, ScanPermissionDialog scanPermissionDialog) {
        super(0);
        this.this$0 = defaultExternalStoragePermission;
        this.$scanPermissionDialog = scanPermissionDialog;
    }

    public final void invoke() {
        Object obj;
        ScanAnalyticsBaseEvent.qw.qw(qw.qw, "require_files_reading_save_dialog_allow_click", (List) null, 2, (Object) null);
        if (Build.VERSION.SDK_INT >= 30) {
            DefaultExternalStoragePermission defaultExternalStoragePermission = this.this$0;
            try {
                Result.Companion companion = Result.Companion;
                Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                intent.setData(Uri.parse("package:" + defaultExternalStoragePermission.qw.getPackageName()));
                defaultExternalStoragePermission.qw.startActivityForResult(intent, 2222);
                obj = Result.m1155constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            DefaultExternalStoragePermission defaultExternalStoragePermission2 = this.this$0;
            Throwable r0 = Result.m1158exceptionOrNullimpl(obj);
            if (r0 != null) {
                defaultExternalStoragePermission2.pf();
                r0.printStackTrace();
                defaultExternalStoragePermission2.f7154yj = false;
            }
        } else {
            this.this$0.th().th(2223);
        }
        this.$scanPermissionDialog.dismiss();
    }
}
