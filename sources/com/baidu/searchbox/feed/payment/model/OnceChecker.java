package com.baidu.searchbox.feed.payment.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/payment/model/OnceChecker;", "Lcom/baidu/searchbox/feed/payment/model/ConditionChecker;", "()V", "triggered", "", "isSatisfied", "load", "", "dataSource", "Lcom/baidu/searchbox/feed/payment/model/DataSource;", "save", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PopupRules.kt */
public final class OnceChecker implements ConditionChecker {
    private boolean triggered;

    public boolean isSatisfied() {
        return !this.triggered;
    }

    public void load(DataSource dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.triggered = dataSource.getTriggered();
    }

    public void save(DataSource dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        dataSource.setTriggered(true);
        this.triggered = true;
    }
}
