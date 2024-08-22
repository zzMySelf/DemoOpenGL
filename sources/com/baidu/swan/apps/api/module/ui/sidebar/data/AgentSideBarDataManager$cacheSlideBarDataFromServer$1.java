package com.baidu.swan.apps.api.module.ui.sidebar.data;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "data", "Lcom/baidu/swan/apps/api/module/ui/sidebar/data/SideBarDataModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AgentSideBarDataManager.kt */
final class AgentSideBarDataManager$cacheSlideBarDataFromServer$1 extends Lambda implements Function1<SideBarDataModel, Unit> {
    public static final AgentSideBarDataManager$cacheSlideBarDataFromServer$1 INSTANCE = new AgentSideBarDataManager$cacheSlideBarDataFromServer$1();

    AgentSideBarDataManager$cacheSlideBarDataFromServer$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SideBarDataModel) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SideBarDataModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        AgentSideBarDataManager agentSideBarDataManager = AgentSideBarDataManager.INSTANCE;
        AgentSideBarDataManager.cachedModel = data;
    }
}
