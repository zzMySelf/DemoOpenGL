package com.baidu.searchbox.feed.payment.column;

import com.baidu.searchbox.feed.payment.column.facets.SpBackToolBarFacet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "itemId", "consumedCount", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnActivity.kt */
final class SpColumnActivity$registerDataChannel$3 extends Lambda implements Function3<String, String, Integer, Unit> {
    final /* synthetic */ SpColumnActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpColumnActivity$registerDataChannel$3(SpColumnActivity spColumnActivity) {
        super(3);
        this.this$0 = spColumnActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((String) p1, (String) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String str, String itemId, int consumedCount) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        this.this$0.getDetailViewModel().consumeTrialCount(consumedCount);
        SpBackToolBarFacet access$getBackToolBarFacet$p = this.this$0.backToolBarFacet;
        if (access$getBackToolBarFacet$p != null) {
            access$getBackToolBarFacet$p.refreshTrialInfoBar();
        }
        Function1<String, Unit> markReadAndUpdateListIfNeedsFunc = this.this$0.getMarkReadAndUpdateListIfNeedsFunc();
        if (markReadAndUpdateListIfNeedsFunc != null) {
            markReadAndUpdateListIfNeedsFunc.invoke(itemId);
        }
    }
}
