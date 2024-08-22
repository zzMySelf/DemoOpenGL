package com.baidu.searchbox.video.feedflow.tab.taskservicetip;

import com.baidu.searchbox.video.feedflow.detail.intercept.service.IInterceptStateService;
import com.baidu.searchbox.video.service.guidepriority.GuidePriorityService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "time", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TaskServiceTipPlugin.kt */
final class TaskServiceTipPlugin$taskServiceTimer$2$1$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ TaskServiceTipPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaskServiceTipPlugin$taskServiceTimer$2$1$1(TaskServiceTipPlugin taskServiceTipPlugin) {
        super(1);
        this.this$0 = taskServiceTipPlugin;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float time) {
        if (time >= 10.0f) {
            IInterceptStateService iInterceptStateService = (IInterceptStateService) this.this$0.getManager().getService(IInterceptStateService.class);
            boolean z = true;
            if (!(iInterceptStateService != null && iInterceptStateService.isInterceptAutoShowPanel())) {
                GuidePriorityService guidePriorityService = (GuidePriorityService) this.this$0.getManager().getService(GuidePriorityService.class);
                if (guidePriorityService == null || !guidePriorityService.isGuideShowing()) {
                    z = false;
                }
                if (!z) {
                    this.this$0.showDialog();
                }
            }
        }
    }
}
