package com.baidu.swan.apps.api.module.ui.sidebar.view;

import com.baidu.swan.apps.api.module.ui.sidebar.data.SideBarDataModel;
import com.baidu.swan.apps.api.module.ui.sidebar.statistic.SideBarStatisticManager;
import com.baidu.swan.apps.util.SwanAppUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "data", "Lcom/baidu/swan/apps/api/module/ui/sidebar/data/SideBarDataModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FusionSideBarView.kt */
final class FusionSideBarView$show$2 extends Lambda implements Function1<SideBarDataModel, Unit> {
    final /* synthetic */ FusionSideBarView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FusionSideBarView$show$2(FusionSideBarView fusionSideBarView) {
        super(1);
        this.this$0 = fusionSideBarView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SideBarDataModel) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SideBarDataModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        SideBarStatisticManager.INSTANCE.onSlideBarDataReceived(data);
        if (data.isValidServerData()) {
            SwanAppUtils.runOnUiThread(new FusionSideBarView$show$2$$ExternalSyntheticLambda0(this.this$0, data));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m7917invoke$lambda0(FusionSideBarView this$02, SideBarDataModel $data) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter($data, "$data");
        this$02.updateData($data);
    }
}
