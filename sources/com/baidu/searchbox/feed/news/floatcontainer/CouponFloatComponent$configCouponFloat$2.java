package com.baidu.searchbox.feed.news.floatcontainer;

import com.baidu.searchbox.feed.payment.widget.couponfloat.ReceiveCouponCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/news/floatcontainer/CouponFloatComponent$configCouponFloat$2", "Lcom/baidu/searchbox/feed/payment/widget/couponfloat/ReceiveCouponCallback;", "onResult", "", "refreshData", "", "lib-feed-news_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CouponFloatComponent.kt */
public final class CouponFloatComponent$configCouponFloat$2 implements ReceiveCouponCallback {
    final /* synthetic */ CouponFloatComponent this$0;

    CouponFloatComponent$configCouponFloat$2(CouponFloatComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onResult(String refreshData) {
        IFloatCallback floatCallback = this.this$0.getFloatCallback();
        if (floatCallback != null) {
            floatCallback.callback("0", "result", refreshData);
        }
    }
}
