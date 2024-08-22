package com.baidu.searchbox.widget.guide;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isSuccess", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OneOneWidgetDialogManager.kt */
final class OneOneWidgetDialogManager$showVivoGuideWhenHomeVisibleIfNeed$1$execute$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ int $widgetType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OneOneWidgetDialogManager$showVivoGuideWhenHomeVisibleIfNeed$1$execute$1(int i2) {
        super(1);
        this.$widgetType = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isSuccess) {
        if (isSuccess) {
            WidgetGuideDialogStatsUtils.ubcEvent$default(WidgetGuideDialogStatsUtils.INSTANCE, "vivo_new", this.$widgetType == 10 ? "1*1icon" : "4*1search", (String) null, "show", 4, (Object) null);
        }
    }
}
