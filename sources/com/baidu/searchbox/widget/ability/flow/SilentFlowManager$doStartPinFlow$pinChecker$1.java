package com.baidu.searchbox.widget.ability.flow;

import com.baidu.searchbox.widget.ability.pin.AbsWidgetLibDownloadCheckerProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/widget/ability/flow/SilentFlowManager$doStartPinFlow$pinChecker$1", "Lcom/baidu/searchbox/widget/ability/pin/AbsWidgetLibDownloadCheckerProvider;", "provideChecker", "", "Lkotlin/Function0;", "", "lib-widget-ability-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SilentFlowManager.kt */
public final class SilentFlowManager$doStartPinFlow$pinChecker$1 extends AbsWidgetLibDownloadCheckerProvider {
    SilentFlowManager$doStartPinFlow$pinChecker$1() {
    }

    public List<Function0<Boolean>> provideChecker() {
        return CollectionsKt.listOf(SilentFlowManager$doStartPinFlow$pinChecker$1$provideChecker$1.INSTANCE, SilentFlowManager$doStartPinFlow$pinChecker$1$provideChecker$2.INSTANCE);
    }
}
