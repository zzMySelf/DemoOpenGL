package com.tera.scan.scanner.ocr.control;

import com.tera.scan.vip.model.PrivilegeType;
import com.tera.scan.vip.ui.dialog.VipRightsIntroduceDialog;
import fe.mmm.qw.tt.ad.when.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tera/scan/vip/ui/dialog/VipRightsIntroduceDialog;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OCRAiTranslateControl$vipRightsIntroduceDialog$2 extends Lambda implements Function0<VipRightsIntroduceDialog> {
    public final /* synthetic */ d this$0;

    public static final class qw implements VipRightsIntroduceDialog.VipRightsIntroduceCallback {
        public final /* synthetic */ d qw;

        public qw(d dVar) {
            this.qw = dVar;
        }

        public void qw(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "result");
            if (Intrinsics.areEqual((Object) str, (Object) "1")) {
                d dVar = this.qw;
                dVar.d(dVar.f8440i);
            }
            this.qw.e();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OCRAiTranslateControl$vipRightsIntroduceDialog$2(d dVar) {
        super(0);
        this.this$0 = dVar;
    }

    @NotNull
    public final VipRightsIntroduceDialog invoke() {
        VipRightsIntroduceDialog vipRightsIntroduceDialog = new VipRightsIntroduceDialog();
        d dVar = this.this$0;
        vipRightsIntroduceDialog.ad(PrivilegeType.imageAiTranslate.getValue());
        vipRightsIntroduceDialog.fe("photo");
        vipRightsIntroduceDialog.de(new qw(dVar));
        return vipRightsIntroduceDialog;
    }
}
