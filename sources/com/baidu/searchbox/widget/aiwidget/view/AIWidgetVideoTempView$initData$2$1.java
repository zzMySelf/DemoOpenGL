package com.baidu.searchbox.widget.aiwidget.view;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AIWidgetVideoTempView.kt */
final class AIWidgetVideoTempView$initData$2$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Throwable $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AIWidgetVideoTempView$initData$2$1(Throwable th2) {
        super(0);
        this.$it = th2;
    }

    public final String invoke() {
        return "color  error: " + this.$it.getMessage();
    }
}
