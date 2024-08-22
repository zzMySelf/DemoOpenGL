package com.baidu.searchbox.kmm.paywall.api;

import com.baidu.searchbox.kmm.foundation.common.ErrorInfo;
import com.baidu.searchbox.kmm.foundation.concurrent.BackgroundTaskUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "code", "", "msg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaywallApi.kt */
final class PaywallApiKt$doBookShelfGETRequest$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ Function1<ErrorInfo, Unit> $failedCB;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaywallApiKt$doBookShelfGETRequest$1(Function1<? super ErrorInfo, Unit> function1) {
        super(2);
        this.$failedCB = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Number) p1).intValue(), (String) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(final int code, final String msg) {
        final Function1<ErrorInfo, Unit> function1 = this.$failedCB;
        BackgroundTaskUtilsKt.mainWork(new Function0<Unit>() {
            public final void invoke() {
                Function1<ErrorInfo, Unit> function1 = function1;
                if (function1 != null) {
                    function1.invoke(new ErrorInfo(code, msg));
                }
            }
        });
    }
}
