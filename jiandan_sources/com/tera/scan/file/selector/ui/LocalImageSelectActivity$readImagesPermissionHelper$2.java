package com.tera.scan.file.selector.ui;

import com.tera.scan.permission.util.ReadImagesPermissionHelper;
import fe.mmm.qw.pf.qw.ad.qw;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/permission/util/ReadImagesPermissionHelper;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LocalImageSelectActivity$readImagesPermissionHelper$2 extends Lambda implements Function0<ReadImagesPermissionHelper> {
    public final /* synthetic */ LocalImageSelectActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocalImageSelectActivity$readImagesPermissionHelper$2(LocalImageSelectActivity localImageSelectActivity) {
        super(0);
        this.this$0 = localImageSelectActivity;
    }

    @NotNull
    public final ReadImagesPermissionHelper invoke() {
        final LocalImageSelectActivity localImageSelectActivity = this.this$0;
        AnonymousClass1 r3 = new Function0<Unit>() {
            public final void invoke() {
                qw.fe("AlbumPms", "AlbumPms", (String) null, localImageSelectActivity.getUbcSource(), (Map) null, 20, (Object) null);
            }
        };
        final LocalImageSelectActivity localImageSelectActivity2 = this.this$0;
        AnonymousClass2 r4 = new Function0<Unit>() {
            public final void invoke() {
                qw.ad("AlbumPms_A_clk", "AlbumPms", (String) null, localImageSelectActivity2.getUbcSource(), (Map) null, 20, (Object) null);
            }
        };
        final LocalImageSelectActivity localImageSelectActivity3 = this.this$0;
        return new ReadImagesPermissionHelper(localImageSelectActivity, (Function0) null, r3, r4, new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                qw.ad("AlbumPms_R_clk", "AlbumPms", (String) null, localImageSelectActivity3.getUbcSource(), (Map) null, 20, (Object) null);
                if (!z) {
                    localImageSelectActivity3.finish();
                }
            }
        }, 2, (DefaultConstructorMarker) null);
    }
}
