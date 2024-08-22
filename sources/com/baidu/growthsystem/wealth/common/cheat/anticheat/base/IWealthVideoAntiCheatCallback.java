package com.baidu.growthsystem.wealth.common.cheat.anticheat.base;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Lcom/baidu/growthsystem/wealth/common/cheat/anticheat/base/IWealthVideoAntiCheatCallback;", "", "onDismissed", "", "onDisplayed", "onFailed", "errorCode", "", "errorMsg", "", "onSchemeInvoked", "onViewClicked", "viewType", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IWealthVideoAntiCheatCallback.kt */
public interface IWealthVideoAntiCheatCallback {
    void onDismissed();

    void onDisplayed();

    void onFailed(int i2, String str);

    void onSchemeInvoked();

    void onViewClicked(int i2);
}
