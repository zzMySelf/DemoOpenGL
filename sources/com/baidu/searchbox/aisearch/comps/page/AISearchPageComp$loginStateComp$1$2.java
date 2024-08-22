package com.baidu.searchbox.aisearch.comps.page;

import com.baidu.searchbox.aisearch.utils.LoginUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "oldStatus", "", "newStatus", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AISearchPageComp.kt */
final class AISearchPageComp$loginStateComp$1$2 extends Lambda implements Function2<Boolean, Boolean, Unit> {
    final /* synthetic */ AISearchPageComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AISearchPageComp$loginStateComp$1$2(AISearchPageComp aISearchPageComp) {
        super(2);
        this.this$0 = aISearchPageComp;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), ((Boolean) p2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean oldStatus, boolean newStatus) {
        LoginUtilsKt.dispatchLoginStateChanged(this.this$0, oldStatus, newStatus);
    }
}
