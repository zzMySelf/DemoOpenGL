package com.baidu.growthsystem.wealth.common.cheat.anticheat;

import com.baidu.growthsystem.wealth.common.cheat.anticheat.base.IWealthVideoAntiCheatDialog;
import com.baidu.growthsystem.wealth.common.cheat.anticheat.base.WealthVideoAntiCheatConfig;
import com.baidu.growthsystem.wealth.common.cheat.anticheat.ui.WealthVideoAntiCheatDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u001b\u0010\u0002\u001a\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"com/baidu/growthsystem/wealth/common/cheat/anticheat/WealthVideoAntiCheatService$buildAntiChatDialog$1", "Lcom/baidu/growthsystem/wealth/common/cheat/anticheat/base/IWealthVideoAntiCheatDialog;", "dialog", "Lcom/baidu/growthsystem/wealth/common/cheat/anticheat/ui/WealthVideoAntiCheatDialog;", "getDialog", "()Lcom/baidu/growthsystem/wealth/common/cheat/anticheat/ui/WealthVideoAntiCheatDialog;", "dialog$delegate", "Lkotlin/Lazy;", "dismiss", "", "isShowing", "", "show", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthVideoAntiCheatService.kt */
public final class WealthVideoAntiCheatService$buildAntiChatDialog$1 implements IWealthVideoAntiCheatDialog {
    private final Lazy dialog$delegate;

    WealthVideoAntiCheatService$buildAntiChatDialog$1(WealthVideoAntiCheatConfig $config) {
        this.dialog$delegate = LazyKt.lazy(new WealthVideoAntiCheatService$buildAntiChatDialog$1$dialog$2($config));
    }

    private final WealthVideoAntiCheatDialog getDialog() {
        return (WealthVideoAntiCheatDialog) this.dialog$delegate.getValue();
    }

    public void show() {
        getDialog().show();
    }

    public boolean isShowing() {
        return getDialog().isShowing();
    }

    public void dismiss() {
        getDialog().dismiss();
    }
}
