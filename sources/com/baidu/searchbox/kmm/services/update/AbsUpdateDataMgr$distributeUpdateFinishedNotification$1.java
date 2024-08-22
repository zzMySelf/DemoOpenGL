package com.baidu.searchbox.kmm.services.update;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: UpdateDataMgr.kt */
final class AbsUpdateDataMgr$distributeUpdateFinishedNotification$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AbsUpdateDataMgr this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbsUpdateDataMgr$distributeUpdateFinishedNotification$1(AbsUpdateDataMgr absUpdateDataMgr) {
        super(0);
        this.this$0 = absUpdateDataMgr;
    }

    public final void invoke() {
        for (Function0 it : this.this$0.updateFinishedCallback) {
            it.invoke();
        }
    }
}
