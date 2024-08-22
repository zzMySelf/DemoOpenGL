package com.baidu.searchbox.aisearch.comps.h5halfpanel;

import android.view.View;
import com.baidu.searchbox.aisearch.runtime.IAISearchSpeedStat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: H5HalfPanelComp.kt */
final class H5HalfPanelComp$halfCloseBt$1$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ H5HalfPanelComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    H5HalfPanelComp$halfCloseBt$1$1(H5HalfPanelComp h5HalfPanelComp) {
        super(1);
        this.this$0 = h5HalfPanelComp;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((View) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        IAISearchSpeedStat.Companion.getImpl().updateStatistic(this.this$0.statPage, "isBackExit", "1");
        Function1<Function0<Unit>, Unit> dismissPanel = this.this$0.getDismissPanel();
        if (dismissPanel != null) {
            dismissPanel.invoke(null);
        }
    }
}
