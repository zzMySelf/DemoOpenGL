package com.baidu.growthsystem.wealth.packet;

import com.baidu.growthsystem.wealth.packet.model.WealthVideoPacketReceiveConfig;
import com.baidu.growthsystem.wealth.packet.model.WealthVideoPacketViewClickConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthVideoPacketDialogBizManager.kt */
final class WealthVideoPacketDialogBizManager$buildPacketGuideDialog$1$1$onViewClick$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ WealthVideoPacketViewClickConfig $config;
    final /* synthetic */ WealthVideoPacketDialogBizManager$buildPacketGuideDialog$1$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WealthVideoPacketDialogBizManager$buildPacketGuideDialog$1$1$onViewClick$4(WealthVideoPacketViewClickConfig wealthVideoPacketViewClickConfig, WealthVideoPacketDialogBizManager$buildPacketGuideDialog$1$1 wealthVideoPacketDialogBizManager$buildPacketGuideDialog$1$1) {
        super(0);
        this.$config = wealthVideoPacketViewClickConfig;
        this.this$0 = wealthVideoPacketDialogBizManager$buildPacketGuideDialog$1$1;
    }

    public final void invoke() {
        this.this$0.onReceivePacket(new WealthVideoPacketReceiveConfig.Builder().setActionType(2).setRequestParams(this.$config.getRequestParams()).build());
    }
}
