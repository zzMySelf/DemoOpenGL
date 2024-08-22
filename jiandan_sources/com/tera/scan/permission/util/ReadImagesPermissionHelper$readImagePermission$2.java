package com.tera.scan.permission.util;

import androidx.fragment.app.FragmentActivity;
import com.tera.scan.permission.request.ReadImagePermission;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/permission/request/ReadImagePermission;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ReadImagesPermissionHelper$readImagePermission$2 extends Lambda implements Function0<ReadImagePermission> {
    public final /* synthetic */ ReadImagesPermissionHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReadImagesPermissionHelper$readImagePermission$2(ReadImagesPermissionHelper readImagesPermissionHelper) {
        super(0);
        this.this$0 = readImagesPermissionHelper;
    }

    @NotNull
    public final ReadImagePermission invoke() {
        FragmentActivity qw = this.this$0.qw;
        Function0<Unit> fe2 = this.this$0.fe();
        Function0<Unit> de2 = this.this$0.de();
        Function1<Boolean, Unit> rg2 = this.this$0.rg();
        final ReadImagesPermissionHelper readImagesPermissionHelper = this.this$0;
        return new ReadImagePermission(qw, fe2, de2, rg2, new Function0<Unit>() {
            public final void invoke() {
                readImagesPermissionHelper.ad().invoke();
            }
        });
    }
}
