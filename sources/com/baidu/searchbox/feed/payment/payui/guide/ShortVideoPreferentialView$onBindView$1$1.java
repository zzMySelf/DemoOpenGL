package com.baidu.searchbox.feed.payment.payui.guide;

import com.baidu.searchbox.feed.payment.R;
import com.baidu.searchbox.feed.payment.widget.Time;
import com.baidu.searchbox.feed.payment.widget.TimerViewKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "prefix", "remainTime", "Lcom/baidu/searchbox/feed/payment/widget/Time;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortVideoPreferentialView.kt */
final class ShortVideoPreferentialView$onBindView$1$1 extends Lambda implements Function2<String, Time, String> {
    final /* synthetic */ ShortVideoPreferentialView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShortVideoPreferentialView$onBindView$1$1(ShortVideoPreferentialView shortVideoPreferentialView) {
        super(2);
        this.this$0 = shortVideoPreferentialView;
    }

    public final String invoke(String prefix, Time remainTime) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(remainTime, "remainTime");
        String format = String.format("%s %s:%s:%s %s", Arrays.copyOf(new Object[]{prefix, TimerViewKt.digit2Time(remainTime.getHour()), TimerViewKt.digit2Time(remainTime.getMinute()), TimerViewKt.digit2Time(remainTime.getSecond()), this.this$0.getContext().getString(R.string.short_discount_countdown_right_text)}, 5));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return format;
    }
}
