package com.baidu.growthsystem.wealth.payment.aps;

import com.baidu.searchbox.pms.init.PmsManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"triggerPMSRetry", "", "wealth-task-business_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthPaymentTaskChannel.kt */
public final class WealthPaymentTaskChannelKt {
    public static final void triggerPMSRetry() {
        PmsManager.getInstance().deletePackageInfo("336", WealthPaymentTaskLottieManagerKt.WEALTH_PAYMENT_TASK_LOTTIE_PACKAGE_NAME);
    }
}
