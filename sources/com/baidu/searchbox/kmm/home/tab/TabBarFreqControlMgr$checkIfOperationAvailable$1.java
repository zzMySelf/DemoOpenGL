package com.baidu.searchbox.kmm.home.tab;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabBarFreqControlMgr.kt */
final class TabBarFreqControlMgr$checkIfOperationAvailable$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function2<Boolean, Integer, Unit> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabBarFreqControlMgr$checkIfOperationAvailable$1(Function2<? super Boolean, ? super Integer, Unit> function2) {
        super(0);
        this.$callback = function2;
    }

    public final void invoke() {
        this.$callback.invoke(false, -1);
    }
}
