package com.baidu.searchbox.rewardsystem.newtimer.net;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthStatusInfoRequester.kt */
final class BoxWealthTaskDataRepo$requestPaymentTask$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $failureCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoxWealthTaskDataRepo$requestPaymentTask$2(Function0<Unit> function0) {
        super(0);
        this.$failureCallback = function0;
    }

    public final void invoke() {
        Function0<Unit> function0 = this.$failureCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
