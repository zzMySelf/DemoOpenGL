package com.baidu.searchbox.feed.payment.core.manager;

import com.baidu.searchbox.feed.payment.payui.guide.model.PayGuideData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/payment/core/manager/TrainingGuideManager;", "", "()V", "getWeakGuideTips", "", "isEnterCamp", "", "updateWeakGuide", "", "weakGuide", "Lcom/baidu/searchbox/feed/payment/payui/guide/model/PayGuideData$TrainingWeakGuide;", "lib-feedpay-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TrainingGuideManager.kt */
public final class TrainingGuideManager {
    public final String getWeakGuideTips(boolean isEnterCamp) {
        return "2.点这里进入群聊一起学习";
    }

    public final void updateWeakGuide(PayGuideData.TrainingWeakGuide weakGuide) {
        PayGuideData.TrainingWeakGuide trainingWeakGuide = weakGuide;
    }
}
