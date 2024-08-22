package com.baidu.growthsystem.wealth.common.cheat.anticheat.ui;

import android.content.Context;
import com.baidu.growthsystem.wealth.common.cheat.anticheat.base.IWealthVideoAntiCheatCallback;
import com.baidu.growthsystem.wealth.common.ubc.WealthVideoSceneUBCUtilKt;
import com.baidu.growthsystem.wealth.common.util.WealthVideoDialogUbcUtilKt;
import com.baidu.searchbox.Router;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"com/baidu/growthsystem/wealth/common/cheat/anticheat/ui/WealthVideoAntiCheatDialog$buildContentView$1$1", "Lcom/baidu/growthsystem/wealth/common/cheat/anticheat/base/IWealthVideoAntiCheatCallback;", "onDismissed", "", "onDisplayed", "onFailed", "errorCode", "", "errorMsg", "", "onSchemeInvoked", "onViewClicked", "viewType", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthVideoAntiCheatDialog.kt */
public final class WealthVideoAntiCheatDialog$buildContentView$1$1 implements IWealthVideoAntiCheatCallback {
    final /* synthetic */ Context $context;
    final /* synthetic */ WealthVideoAntiCheatView $this_apply;
    final /* synthetic */ WealthVideoAntiCheatDialog this$0;

    WealthVideoAntiCheatDialog$buildContentView$1$1(WealthVideoAntiCheatDialog $receiver, Context $context2, WealthVideoAntiCheatView $receiver2) {
        this.this$0 = $receiver;
        this.$context = $context2;
        this.$this_apply = $receiver2;
    }

    public void onViewClicked(int viewType) {
        IWealthVideoAntiCheatCallback callback;
        switch (viewType) {
            case 2:
                WealthVideoDialogUbcUtilKt.ubcOnDialogClickButton(this.this$0.config.getSource(), WealthVideoSceneUBCUtilKt.getUbcPage(this.this$0.config.getSceneModel()), WealthVideoDialogUbcUtilKt.getUbcExtWithLoginStatus(this.this$0.config.getSceneModel()));
                String scheme = this.this$0.model.getButtonScheme();
                if ((scheme.length() > 0) && Router.invoke(this.$context, scheme) && (callback = this.$this_apply.getCallback()) != null) {
                    callback.onSchemeInvoked();
                }
                this.this$0.dismiss();
                break;
            case 3:
                WealthVideoDialogUbcUtilKt.ubcOnDialogClickClose(this.this$0.config.getSource(), WealthVideoSceneUBCUtilKt.getUbcPage(this.this$0.config.getSceneModel()), WealthVideoDialogUbcUtilKt.getUbcExtWithLoginStatus(this.this$0.config.getSceneModel()));
                this.this$0.dismiss();
                break;
            case 4:
                this.this$0.dismiss();
                break;
        }
        IWealthVideoAntiCheatCallback callback2 = this.this$0.getCallback();
        if (callback2 != null) {
            callback2.onViewClicked(viewType);
        }
    }

    public void onDisplayed() {
        WealthVideoDialogUbcUtilKt.ubcOnDialogDisplay(this.this$0.config.getSource(), WealthVideoSceneUBCUtilKt.getUbcPage(this.this$0.config.getSceneModel()), WealthVideoDialogUbcUtilKt.getUbcExtWithLoginStatus(this.this$0.config.getSceneModel()));
        IWealthVideoAntiCheatCallback callback = this.this$0.getCallback();
        if (callback != null) {
            callback.onDisplayed();
        }
    }

    public void onFailed(int errorCode, String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
    }

    public void onSchemeInvoked() {
        IWealthVideoAntiCheatCallback callback = this.this$0.getCallback();
        if (callback != null) {
            callback.onSchemeInvoked();
        }
    }

    public void onDismissed() {
    }
}
