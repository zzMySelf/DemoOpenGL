package com.baidu.growthsystem.wealth.packet;

import android.app.Activity;
import com.baidu.growthsystem.wealth.common.constant.WealthVideoYalogConstantKt;
import com.baidu.growthsystem.wealth.common.util.WealthVideoYalogUtilKt;
import com.baidu.growthsystem.wealth.packet.WealthVideoPacketDialogBizManager;
import com.baidu.growthsystem.wealth.packet.model.ReceivePacketRequestParams;
import com.baidu.growthsystem.wealth.packet.util.WealthVideoPacketReceiveDataParserKt;
import com.baidu.growthsystem.wealth.packet.util.WealthVideoPacketYalogUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "data", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthVideoPacketDialogBizManager.kt */
final class WealthVideoPacketDialogBizManager$doRealReceivePacket$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ WealthVideoPacketDialogBizManager.IReceiveCallback $callback;
    final /* synthetic */ ReceivePacketRequestParams $receivePacketRequestParams;
    final /* synthetic */ WealthVideoPacketDialogBizManager.PacketGuideRuntimeState $runtimeState;
    final /* synthetic */ WealthVideoPacketDialogBizManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WealthVideoPacketDialogBizManager$doRealReceivePacket$1(WealthVideoPacketDialogBizManager.IReceiveCallback iReceiveCallback, WealthVideoPacketDialogBizManager wealthVideoPacketDialogBizManager, Activity activity, WealthVideoPacketDialogBizManager.PacketGuideRuntimeState packetGuideRuntimeState, ReceivePacketRequestParams receivePacketRequestParams) {
        super(1);
        this.$callback = iReceiveCallback;
        this.this$0 = wealthVideoPacketDialogBizManager;
        this.$activity = activity;
        this.$runtimeState = packetGuideRuntimeState;
        this.$receivePacketRequestParams = receivePacketRequestParams;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((JSONObject) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(JSONObject data) {
        JSONObject receiveData = data != null ? data.optJSONObject("red_package") : null;
        if (receiveData == null) {
            this.$callback.onReceiveError(this.this$0.getNetworkErrorText(this.$activity));
            WealthVideoPacketYalogUtilKt.logOnReceivePacketDisplayFailure(WealthVideoYalogConstantKt.YALOG_VALUE_ERROR_MSG_INVALID_DATA, WealthVideoYalogUtilKt.toYalogJson(data));
            return;
        }
        this.$runtimeState.setReceiveResult(WealthVideoPacketDialogBizManager.ReceiveResult.UNDEFINED);
        WealthVideoPacketDialogBizManager.PacketGuideRuntimeState packetGuideRuntimeState = this.$runtimeState;
        ReceivePacketRequestParams receivePacketRequestParams = this.$receivePacketRequestParams;
        packetGuideRuntimeState.setFromWeChatLogin(StringsKt.equals$default(receivePacketRequestParams != null ? receivePacketRequestParams.getScene() : null, ReceivePacketRequestParams.DUODUO_REDPACKAGE_WX_LOGIN_EXP, false, 2, (Object) null));
        if (WealthVideoPacketReceiveDataParserKt.isHitAntiCheat(receiveData)) {
            this.this$0.handleHitAntiCheat(this.$activity, this.$runtimeState, this.$callback);
        } else {
            this.this$0.handleNormalReceive(receiveData, this.$activity, this.$runtimeState, this.$callback);
        }
    }
}
