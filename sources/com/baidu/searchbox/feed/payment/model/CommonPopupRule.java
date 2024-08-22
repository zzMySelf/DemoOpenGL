package com.baidu.searchbox.feed.payment.model;

import com.baidu.searchbox.feed.payment.PopupRule;
import com.baidu.searchbox.feed.payment.TargetPopupUi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/payment/model/CommonPopupRule;", "Lcom/baidu/searchbox/feed/payment/PopupRule;", "popupUi", "Lcom/baidu/searchbox/feed/payment/TargetPopupUi;", "conditionChecker", "Lcom/baidu/searchbox/feed/payment/model/ConditionChecker;", "dataSource", "Lcom/baidu/searchbox/feed/payment/model/DataSource;", "(Lcom/baidu/searchbox/feed/payment/TargetPopupUi;Lcom/baidu/searchbox/feed/payment/model/ConditionChecker;Lcom/baidu/searchbox/feed/payment/model/DataSource;)V", "show", "", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PopupRules.kt */
public final class CommonPopupRule implements PopupRule {
    private final ConditionChecker conditionChecker;
    private final DataSource dataSource;
    private final TargetPopupUi popupUi;

    public CommonPopupRule(TargetPopupUi popupUi2, ConditionChecker conditionChecker2, DataSource dataSource2) {
        Intrinsics.checkNotNullParameter(popupUi2, "popupUi");
        Intrinsics.checkNotNullParameter(conditionChecker2, "conditionChecker");
        Intrinsics.checkNotNullParameter(dataSource2, "dataSource");
        this.popupUi = popupUi2;
        this.conditionChecker = conditionChecker2;
        this.dataSource = dataSource2;
    }

    public void show() {
        this.conditionChecker.load(this.dataSource);
        if (this.conditionChecker.isSatisfied()) {
            this.popupUi.show();
            this.conditionChecker.save(this.dataSource);
            this.dataSource.commit();
        }
    }
}
