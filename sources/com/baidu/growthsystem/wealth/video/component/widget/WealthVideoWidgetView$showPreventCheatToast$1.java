package com.baidu.growthsystem.wealth.video.component.widget;

import com.baidu.growthsystem.wealth.video.component.widget.sidetoast.view.WealthWidgetTipToastListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/growthsystem/wealth/video/component/widget/WealthVideoWidgetView$showPreventCheatToast$1", "Lcom/baidu/growthsystem/wealth/video/component/widget/sidetoast/view/WealthWidgetTipToastListener;", "onDismiss", "", "onShow", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthVideoWidgetView.kt */
public final class WealthVideoWidgetView$showPreventCheatToast$1 implements WealthWidgetTipToastListener {
    final /* synthetic */ Function0<Unit> $action;

    WealthVideoWidgetView$showPreventCheatToast$1(Function0<Unit> $action2) {
        this.$action = $action2;
    }

    public void onShow() {
        Function0<Unit> function0 = this.$action;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onDismiss() {
    }
}
