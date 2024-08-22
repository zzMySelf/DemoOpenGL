package com.baidu.searchbox.feed.payment.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/payment/model/DeadlineChecker;", "Lcom/baidu/searchbox/feed/payment/model/DecoratedConditionChecker;", "incrementalCondition", "Lcom/baidu/searchbox/feed/payment/model/ConditionChecker;", "timeMillis", "", "(Lcom/baidu/searchbox/feed/payment/model/ConditionChecker;J)V", "necessaryCondition", "", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PopupRules.kt */
public final class DeadlineChecker extends DecoratedConditionChecker {
    private final long timeMillis;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeadlineChecker(ConditionChecker incrementalCondition, long timeMillis2) {
        super(incrementalCondition);
        Intrinsics.checkNotNullParameter(incrementalCondition, "incrementalCondition");
        this.timeMillis = timeMillis2;
    }

    public boolean necessaryCondition() {
        return System.currentTimeMillis() < this.timeMillis;
    }
}
