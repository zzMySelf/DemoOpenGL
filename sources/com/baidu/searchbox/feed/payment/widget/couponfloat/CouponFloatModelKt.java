package com.baidu.searchbox.feed.payment.widget.couponfloat;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"isValid", "", "Lcom/baidu/searchbox/feed/payment/widget/couponfloat/CouponFloatModel;", "lib-feedpay-widget_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CouponFloatModel.kt */
public final class CouponFloatModelKt {
    public static final boolean isValid(CouponFloatModel $this$isValid) {
        if ($this$isValid != null) {
            CharSequence title = $this$isValid.getTitle();
            if (!(title == null || title.length() == 0)) {
                CharSequence discountNum = $this$isValid.getDiscountNum();
                if (!(discountNum == null || discountNum.length() == 0)) {
                    CharSequence tips = $this$isValid.getTips();
                    if (!(tips == null || tips.length() == 0)) {
                        CharSequence deadline = $this$isValid.getDeadline();
                        if (!(deadline == null || deadline.length() == 0)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
