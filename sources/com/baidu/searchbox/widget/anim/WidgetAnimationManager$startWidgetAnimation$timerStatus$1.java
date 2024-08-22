package com.baidu.searchbox.widget.anim;

import com.baidu.searchbox.widget.WidgetYaLogManager;
import com.baidu.searchbox.widget.debug.WidgetDebugKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WidgetAnimationManager.kt */
final class WidgetAnimationManager$startWidgetAnimation$timerStatus$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $onStart;
    final /* synthetic */ WidgetAnimationManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WidgetAnimationManager$startWidgetAnimation$timerStatus$1(WidgetAnimationManager widgetAnimationManager, Function0<Unit> function0) {
        super(0);
        this.this$0 = widgetAnimationManager;
        this.$onStart = function0;
    }

    public final void invoke() {
        this.this$0.isDoingCountDown = true;
        WidgetYaLogManager.INSTANCE.yaLogD(WidgetDebugKt.TAG_WIDGET_ANIMATION, "onStart");
        Function0<Unit> function0 = this.$onStart;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
