package com.tera.scan.vip.ui.dialog;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tera.scan.vip.ui.dialog.VipRightsIntroduceDialog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"com/tera/scan/vip/ui/dialog/VipRightsIntroduceDialog$show$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VipRightsIntroduceDialog$show$1 extends ResultReceiver {
    public final /* synthetic */ VipRightsIntroduceDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VipRightsIntroduceDialog$show$1(VipRightsIntroduceDialog vipRightsIntroduceDialog, Handler handler) {
        super(handler);
        this.this$0 = vipRightsIntroduceDialog;
    }

    public void onReceiveResult(int i2, @Nullable Bundle bundle) {
        String str = "0";
        if (i2 == 1) {
            str = "1";
        } else if (i2 != 2) {
        }
        VipRightsIntroduceDialog.VipRightsIntroduceCallback qw = this.this$0.f7465ad;
        if (qw != null) {
            qw.qw(str);
        }
    }
}
