package com.tera.scan.scanner.ui.cameranew;

import com.mars.kotlin.extension.LoggerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FocusIndicatorView$show$2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ long $viewId;
    public final /* synthetic */ FocusIndicatorView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FocusIndicatorView$show$2(long j, FocusIndicatorView focusIndicatorView) {
        super(0);
        this.$viewId = j;
        this.this$0 = focusIndicatorView;
    }

    public final void invoke() {
        LoggerKt.d$default("View animation finished: " + this.$viewId + ", remove view", (Object) null, 1, (Object) null);
        this.this$0.tryRemove(Long.valueOf(this.$viewId));
    }
}
