package com.tera.scan.permission.util;

import androidx.fragment.app.FragmentActivity;
import com.tera.scan.permission.request.DefaultExternalStoragePermission;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/permission/request/DefaultExternalStoragePermission;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ManageAppAllFilesAccessHelper$externalStoragePermission$2 extends Lambda implements Function0<DefaultExternalStoragePermission> {
    public final /* synthetic */ ManageAppAllFilesAccessHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ManageAppAllFilesAccessHelper$externalStoragePermission$2(ManageAppAllFilesAccessHelper manageAppAllFilesAccessHelper) {
        super(0);
        this.this$0 = manageAppAllFilesAccessHelper;
    }

    @NotNull
    public final DefaultExternalStoragePermission invoke() {
        FragmentActivity qw = this.this$0.qw;
        Function0<Unit> rg2 = this.this$0.rg();
        Function0<Unit> fe2 = this.this$0.fe();
        Function0<Unit> th2 = this.this$0.th();
        final ManageAppAllFilesAccessHelper manageAppAllFilesAccessHelper = this.this$0;
        return new DefaultExternalStoragePermission(qw, rg2, fe2, th2, new Function0<Unit>() {
            public final void invoke() {
                manageAppAllFilesAccessHelper.de().invoke();
            }
        });
    }
}
