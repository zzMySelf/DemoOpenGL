package com.baidu.searchbox.feed.payment.column;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.feed.payment.SpDetailUpdateEvent;
import com.baidu.searchbox.feed.payment.column.viewmodel.SpColumnDetailViewModel;
import com.baidu.searchbox.feed.payment.model.PayServerTransit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/payment/column/SpColumnActivity$registerEventBus$2", "Lcom/baidu/searchbox/bdeventbus/Action;", "Lcom/baidu/searchbox/feed/payment/SpDetailUpdateEvent;", "call", "", "type", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnActivity.kt */
public final class SpColumnActivity$registerEventBus$2 implements Action<SpDetailUpdateEvent> {
    final /* synthetic */ SpColumnActivity this$0;

    SpColumnActivity$registerEventBus$2(SpColumnActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void call(SpDetailUpdateEvent type) {
        PayServerTransit serverTransit;
        Intrinsics.checkNotNullParameter(type, "type");
        String feedId = type.getFeedId();
        if (feedId != null && (serverTransit = type.getServerTransit()) != null && !StringsKt.isBlank(feedId)) {
            SpColumnDetailViewModel.loadDetailData$default(this.this$0.getDetailViewModel(), feedId, serverTransit, (String) null, 4, (Object) null);
            this.this$0._feedId = feedId;
            this.this$0.isFromEvent = true;
        }
    }
}
