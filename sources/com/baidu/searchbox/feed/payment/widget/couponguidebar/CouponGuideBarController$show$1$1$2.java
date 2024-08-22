package com.baidu.searchbox.feed.payment.widget.couponguidebar;

import com.baidu.searchbox.feed.feedpay.widget.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CouponGuideBarController.kt */
final class CouponGuideBarController$show$1$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CouponGuideBar $this_run;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CouponGuideBarController$show$1$1$2(CouponGuideBar couponGuideBar) {
        super(0);
        this.$this_run = couponGuideBar;
    }

    public final void invoke() {
        CouponGuideBar couponGuideBar = this.$this_run;
        String string = couponGuideBar.getContext().getString(R.string.feed_pay_guide_bar_end_time_tips);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…_guide_bar_end_time_tips)");
        couponGuideBar.setGuideTips(string);
    }
}
