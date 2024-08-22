package com.baidu.searchbox.feed.biserialdetail;

import com.baidu.searchbox.datachannel.NAReceiverCallback;
import com.baidu.searchbox.feed.biserialdetail.base.util.DynamicUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/feed/biserialdetail/FeedDynamicDetailActivity$registerEvent$2", "Lcom/baidu/searchbox/datachannel/NAReceiverCallback;", "onReceive", "", "action", "", "params", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedDynamicDetailActivity.kt */
public final class FeedDynamicDetailActivity$registerEvent$2 extends NAReceiverCallback {
    final /* synthetic */ FeedDynamicDetailActivity this$0;

    FeedDynamicDetailActivity$registerEvent$2(FeedDynamicDetailActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onReceive(String action, String params) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(params, "params");
        this.this$0.closeLiveAni = DynamicUtilsKt.processExtraInfoParse(params);
        this.this$0.processPraiseActionIfNeeded(params);
    }
}
