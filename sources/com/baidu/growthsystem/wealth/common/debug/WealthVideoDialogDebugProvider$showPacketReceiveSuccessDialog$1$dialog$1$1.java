package com.baidu.growthsystem.wealth.common.debug;

import com.baidu.growthsystem.wealth.packet.ui.IWealthVideoPacketReceiveCallback;
import com.baidu.growthsystem.wealth.packet.ui.WealthVideoPacketReceiveSuccessDialog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/growthsystem/wealth/common/debug/WealthVideoDialogDebugProvider$showPacketReceiveSuccessDialog$1$dialog$1$1", "Lcom/baidu/growthsystem/wealth/packet/ui/IWealthVideoPacketReceiveCallback;", "onDisplay", "", "onViewClick", "viewType", "", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthVideoDialogDebugProvider.kt */
public final class WealthVideoDialogDebugProvider$showPacketReceiveSuccessDialog$1$dialog$1$1 implements IWealthVideoPacketReceiveCallback {
    final /* synthetic */ WealthVideoPacketReceiveSuccessDialog $this_apply;

    WealthVideoDialogDebugProvider$showPacketReceiveSuccessDialog$1$dialog$1$1(WealthVideoPacketReceiveSuccessDialog $receiver) {
        this.$this_apply = $receiver;
    }

    public void onViewClick(int viewType) {
        switch (viewType) {
            case 2:
                this.$this_apply.dismiss();
                return;
            case 3:
                this.$this_apply.dismiss();
                return;
            case 4:
                this.$this_apply.dismiss();
                return;
            default:
                return;
        }
    }

    public void onDisplay() {
    }
}
