package com.baidu.growthsystem.wealth.scrollguide;

import com.baidu.growthsystem.wealth.common.cheat.anticheat.base.IWealthVideoAntiCheatCallback;
import com.baidu.growthsystem.wealth.common.popup.base.biz.IWealthVideoDialogBizCallback;
import com.baidu.growthsystem.wealth.common.util.WealthVideoYalogUtilKt;
import com.baidu.growthsystem.wealth.scrollguide.util.WealthVideoScrollUpGuideYalogUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"com/baidu/growthsystem/wealth/scrollguide/WealthVideoScrollUpGuideBizManager$handleHitAntiCheat$antiCheatCallback$1", "Lcom/baidu/growthsystem/wealth/common/cheat/anticheat/base/IWealthVideoAntiCheatCallback;", "onDismissed", "", "onDisplayed", "onFailed", "errorCode", "", "errorMsg", "", "onSchemeInvoked", "onViewClicked", "viewType", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthVideoScrollUpGuideBizManager.kt */
public final class WealthVideoScrollUpGuideBizManager$handleHitAntiCheat$antiCheatCallback$1 implements IWealthVideoAntiCheatCallback {
    final /* synthetic */ WealthVideoScrollUpGuideBizManager this$0;

    WealthVideoScrollUpGuideBizManager$handleHitAntiCheat$antiCheatCallback$1(WealthVideoScrollUpGuideBizManager $receiver) {
        this.this$0 = $receiver;
    }

    public void onViewClicked(int viewType) {
    }

    public void onDisplayed() {
    }

    public void onFailed(int errorCode, String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        WealthVideoScrollUpGuideBizManager wealthVideoScrollUpGuideBizManager = this.this$0;
        wealthVideoScrollUpGuideBizManager.handleRewardReceiveFailed(wealthVideoScrollUpGuideBizManager.getReceiveFailedText());
        this.this$0.markGuideDismissed();
        this.this$0.handleScrollGuideFinished(IWealthVideoDialogBizCallback.ActionCode.CANCEL);
        WealthVideoScrollUpGuideYalogUtilKt.logOnScrollUpReceiveDisplayFailure("others", WealthVideoYalogUtilKt.toYalogJson("code = " + errorCode + ", errorMsg = " + errorMsg));
    }

    public void onSchemeInvoked() {
    }

    public void onDismissed() {
        this.this$0.markGuideDismissed();
        this.this$0.handleScrollGuideFinished(IWealthVideoDialogBizCallback.ActionCode.CANCEL);
    }
}
