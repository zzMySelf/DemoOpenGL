package com.tera.scan.flutter.plugin.account;

import com.baidu.netdisk.trade.privilege.TradeAccount;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AccountChannelPluginProxy$onMethodCall$1 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ MethodChannel.Result $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountChannelPluginProxy$onMethodCall$1(MethodChannel.Result result) {
        super(1);
        this.$result = result;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            TradeAccount tradeAccount = TradeAccount.f913rg;
            final MethodChannel.Result result = this.$result;
            tradeAccount.ppp(new Function0<Unit>() {
                public final void invoke() {
                    result.success(Boolean.TRUE);
                }
            });
            return;
        }
        this.$result.error("101", (String) null, (Object) null);
    }
}
