package com.baidu.searchbox.feed.payment.column;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "id", "", "success", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnActivity.kt */
final class SpColumnActivity$registerDataChannel$1 extends Lambda implements Function2<String, Boolean, Unit> {
    final /* synthetic */ SpColumnActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpColumnActivity$registerDataChannel$1(SpColumnActivity spColumnActivity) {
        super(2);
        this.this$0 = spColumnActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((String) p1, ((Boolean) p2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String id, boolean success) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (success && Intrinsics.areEqual((Object) id, (Object) this.this$0.getFeedId())) {
            this.this$0.refreshUiWithDataUpdate(false);
            this.this$0.getDetailViewModel().invokeAddTabCmd(this.this$0);
        }
    }
}
