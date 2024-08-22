package com.baidu.searchbox.feed.payment.widget;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "remainTime", "Lcom/baidu/searchbox/feed/payment/widget/Time;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortVideoBotTimerView.kt */
final class ShortVideoBotTimerView$onBindView$1$1 extends Lambda implements Function2<String, Time, String> {
    public static final ShortVideoBotTimerView$onBindView$1$1 INSTANCE = new ShortVideoBotTimerView$onBindView$1$1();

    ShortVideoBotTimerView$onBindView$1$1() {
        super(2);
    }

    public final String invoke(String str, Time remainTime) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(remainTime, "remainTime");
        String format = String.format("%s:%s:%s", Arrays.copyOf(new Object[]{TimerViewKt.digit2Time(remainTime.getHour()), TimerViewKt.digit2Time(remainTime.getMinute()), TimerViewKt.digit2Time(remainTime.getSecond())}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return format;
    }
}
