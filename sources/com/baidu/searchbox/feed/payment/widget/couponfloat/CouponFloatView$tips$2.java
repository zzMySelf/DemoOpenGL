package com.baidu.searchbox.feed.payment.widget.couponfloat;

import com.baidu.searchbox.feed.feedpay.widget.R;
import com.baidu.searchbox.ui.UnifyTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/ui/UnifyTextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CouponFloatView.kt */
final class CouponFloatView$tips$2 extends Lambda implements Function0<UnifyTextView> {
    final /* synthetic */ CouponFloatView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CouponFloatView$tips$2(CouponFloatView couponFloatView) {
        super(0);
        this.this$0 = couponFloatView;
    }

    public final UnifyTextView invoke() {
        return (UnifyTextView) this.this$0.findViewById(R.id.feed_pay_coupon_float_tips);
    }
}
