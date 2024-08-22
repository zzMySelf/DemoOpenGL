package com.baidu.bdtask.ui.components.dialog;

import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.dialog.TaskDialogViewData;
import com.baidu.bdtask.event.transition.TaskBackFlowEvent;
import com.baidu.bdtask.framework.service.router.SchemeService;
import com.baidu.bdtask.service.base.TaskService;
import com.baidu.bdtask.service.business.inner.TaskInnerService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
final class DoubleBtnDialog$initExtraView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TaskDialogViewData $data;
    final /* synthetic */ DoubleBtnDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DoubleBtnDialog$initExtraView$1(DoubleBtnDialog doubleBtnDialog, TaskDialogViewData taskDialogViewData) {
        super(0);
        this.this$0 = doubleBtnDialog;
        this.$data = taskDialogViewData;
    }

    public final void invoke() {
        SchemeService schemeService;
        TaskInnerService taskInnerService;
        TaskInnerService taskInnerService2;
        TaskService serviceManager = BDPTask.INSTANCE.getServiceManager();
        if (!(serviceManager == null || (taskInnerService2 = serviceManager.getTaskInnerService()) == null)) {
            taskInnerService2.dispatchTaskBusinessEvent(this.$data.getTaskInfoSingleKey(), TaskBackFlowEvent.INS.getID());
        }
        TaskService serviceManager2 = BDPTask.INSTANCE.getServiceManager();
        if (!(serviceManager2 == null || (taskInnerService = serviceManager2.getTaskInnerService()) == null)) {
            taskInnerService.cleanTaskNoClickTimes(this.$data.getTaskInfoSingleKey());
        }
        TaskService serviceManager3 = BDPTask.INSTANCE.getServiceManager();
        if (!(serviceManager3 == null || (schemeService = serviceManager3.getSchemeService()) == null)) {
            schemeService.onIntercept(this.$data.getBackBtnSchema(), 1);
        }
        this.this$0.f();
        this.this$0.b();
    }
}
