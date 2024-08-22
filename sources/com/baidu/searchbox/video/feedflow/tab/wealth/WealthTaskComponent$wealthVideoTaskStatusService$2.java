package com.baidu.searchbox.video.feedflow.tab.wealth;

import com.baidu.growthsystem.bridge.BDWealthTaskManager;
import com.baidu.growthsystem.wealth.video.service.WealthVideoTaskStatusService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/growthsystem/wealth/video/service/WealthVideoTaskStatusService;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthTaskComponent.kt */
final class WealthTaskComponent$wealthVideoTaskStatusService$2 extends Lambda implements Function0<WealthVideoTaskStatusService> {
    public static final WealthTaskComponent$wealthVideoTaskStatusService$2 INSTANCE = new WealthTaskComponent$wealthVideoTaskStatusService$2();

    WealthTaskComponent$wealthVideoTaskStatusService$2() {
        super(0);
    }

    public final WealthVideoTaskStatusService invoke() {
        return BDWealthTaskManager.INSTANCE.getWealthVideoTaskStatusService();
    }
}
