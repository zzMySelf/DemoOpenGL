package com.baidu.searchbox.sport.page.olympic.schedule.filter;

import com.baidu.searchbox.sport.page.olympic.schedule.filter.panel.ScheduleFilterPanelComp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/panel/ScheduleFilterPanelComp;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScheduleFilterRootComp.kt */
final class ScheduleFilterRootComp$filterPanelComp$2 extends Lambda implements Function0<ScheduleFilterPanelComp> {
    final /* synthetic */ ScheduleFilterRootComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScheduleFilterRootComp$filterPanelComp$2(ScheduleFilterRootComp scheduleFilterRootComp) {
        super(0);
        this.this$0 = scheduleFilterRootComp;
    }

    public final ScheduleFilterPanelComp invoke() {
        return this.this$0.createFilterPanel();
    }
}
