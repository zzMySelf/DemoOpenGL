package com.baidu.bdtask.ui.components.toast;

import android.content.Context;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.toast.TaskToastViewData;
import com.baidu.bdtask.event.transition.TaskBackFlowEvent;
import com.baidu.bdtask.framework.service.router.SchemeService;
import com.baidu.bdtask.framework.ui.mvvm.data.Observer;
import com.baidu.bdtask.service.base.TaskService;
import com.baidu.bdtask.service.business.inner.TaskInnerService;
import com.baidu.bdtask.ui.components.toast.UniversalToast;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/bdtask/component/toast/TaskToastViewData;", "onChanged"}, k = 3, mv = {1, 1, 9})
final class TaskToastView$onViewModelBind$1<T> implements Observer<TaskToastViewData> {
    final /* synthetic */ TaskToastView this$0;

    TaskToastView$onViewModelBind$1(TaskToastView taskToastView) {
        this.this$0 = taskToastView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00c4, code lost:
        r0 = r0.getEnvService();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(com.baidu.bdtask.component.toast.TaskToastViewData r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x011f
            com.baidu.bdtask.ui.components.toast.TaskToastView r0 = r3.this$0
            com.baidu.bdtask.ui.components.toast.UniversalToast r0 = r0.toast
            com.baidu.bdtask.ui.components.toast.TaskToastView r1 = r3.this$0
            int r1 = r1.MAX_LINE
            r0.a((int) r1)
            com.baidu.bdtask.ui.components.toast.TaskToastView r0 = r3.this$0
            com.baidu.bdtask.ui.components.toast.UniversalToast r0 = r0.toast
            java.lang.String r1 = r4.getMessage()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.a((java.lang.CharSequence) r1)
            com.baidu.bdtask.ui.components.toast.TaskToastView r0 = r3.this$0
            com.baidu.bdtask.ui.components.toast.UniversalToast r0 = r0.toast
            java.lang.String r1 = r4.getBackColor()
            r0.a((java.lang.String) r1)
            com.baidu.bdtask.ui.components.toast.TaskToastView r0 = r3.this$0
            com.baidu.bdtask.ui.components.toast.UniversalToast r0 = r0.toast
            int r1 = r4.getDuration()
            r0.b((int) r1)
            com.baidu.bdtask.ui.components.toast.TaskToastView r0 = r3.this$0
            com.baidu.bdtask.ui.components.toast.UniversalToast r0 = r0.toast
            java.lang.String r1 = r4.getTxtColor()
            r0.b((java.lang.String) r1)
            com.baidu.bdtask.ui.components.toast.TaskToastView r0 = r3.this$0
            com.baidu.bdtask.ui.components.toast.UniversalToast r0 = r0.toast
            com.baidu.bdtask.framework.ui.toast.ToastLayoutParams r1 = r4.getToastLayoutParams()
            r0.a((com.baidu.bdtask.framework.ui.toast.ToastLayoutParams) r1)
            com.baidu.bdtask.ui.components.toast.TaskToastView r0 = r3.this$0
            com.baidu.bdtask.ui.components.toast.UniversalToast r0 = r0.toast
            java.lang.String r1 = r4.getBgUrl()
            r0.f(r1)
            java.lang.String r0 = r4.getBackBtnBgUrl()
            if (r0 == 0) goto L_0x0070
            com.baidu.bdtask.ui.components.toast.TaskToastView r1 = r3.this$0
            com.baidu.bdtask.ui.components.toast.UniversalToast r1 = r1.toast
            r1.d(r0)
        L_0x0070:
            java.lang.String r0 = r4.getBackBtnColor()
            if (r0 == 0) goto L_0x0080
            com.baidu.bdtask.ui.components.toast.TaskToastView r1 = r3.this$0
            com.baidu.bdtask.ui.components.toast.UniversalToast r1 = r1.toast
            r1.c((java.lang.String) r0)
        L_0x0080:
            java.lang.String r0 = r4.getBackBtnSchema()
            if (r0 == 0) goto L_0x0098
            com.baidu.bdtask.ui.components.toast.TaskToastView r1 = r3.this$0
            com.baidu.bdtask.ui.components.toast.UniversalToast r1 = r1.toast
            com.baidu.bdtask.ui.components.toast.TaskToastView$onViewModelBind$1$a r2 = new com.baidu.bdtask.ui.components.toast.TaskToastView$onViewModelBind$1$a
            r2.<init>(r0, r4, r3, r4)
            com.baidu.bdtask.ui.components.toast.UniversalToast$ToastCallback r2 = (com.baidu.bdtask.ui.components.toast.UniversalToast.ToastCallback) r2
            r1.a((com.baidu.bdtask.ui.components.toast.UniversalToast.ToastCallback) r2)
        L_0x0098:
            java.lang.String r0 = r4.getBackBtnTxt()
            if (r0 == 0) goto L_0x00aa
            com.baidu.bdtask.ui.components.toast.TaskToastView r1 = r3.this$0
            com.baidu.bdtask.ui.components.toast.UniversalToast r1 = r1.toast
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.b((java.lang.CharSequence) r0)
        L_0x00aa:
            java.lang.String r0 = r4.getBackBtnTxtColor()
            if (r0 == 0) goto L_0x00ba
            com.baidu.bdtask.ui.components.toast.TaskToastView r1 = r3.this$0
            com.baidu.bdtask.ui.components.toast.UniversalToast r1 = r1.toast
            r1.e(r0)
        L_0x00ba:
            com.baidu.bdtask.BDPTask$INSTANCE r0 = com.baidu.bdtask.BDPTask.INSTANCE
            com.baidu.bdtask.service.base.TaskService r0 = r0.getServiceManager()
            r1 = 0
            if (r0 == 0) goto L_0x00cf
            com.baidu.bdtask.framework.service.env.EnvService r0 = r0.getEnvService()
            if (r0 == 0) goto L_0x00cf
            android.content.Context r0 = r0.getAppContext()
            goto L_0x00d0
        L_0x00cf:
            r0 = r1
        L_0x00d0:
            com.baidu.bdtask.BDPTask$INSTANCE r2 = com.baidu.bdtask.BDPTask.INSTANCE
            com.baidu.bdtask.service.base.TaskService r2 = r2.getServiceManager()
            if (r2 == 0) goto L_0x00e2
            com.baidu.bdtask.framework.service.env.EnvService r2 = r2.getEnvService()
            if (r2 == 0) goto L_0x00e2
            android.app.Activity r1 = r2.getCurActivity()
        L_0x00e2:
            if (r1 == 0) goto L_0x00e7
            android.content.Context r1 = (android.content.Context) r1
            goto L_0x00e8
        L_0x00e7:
            r1 = r0
        L_0x00e8:
            if (r1 == 0) goto L_0x011f
            int r2 = r4.getShowType()
            switch(r2) {
                case 1: goto L_0x0103;
                case 2: goto L_0x00f2;
                default: goto L_0x00f1;
            }
        L_0x00f1:
            goto L_0x0110
        L_0x00f2:
            com.baidu.bdtask.ui.components.toast.TaskToastView$onViewModelBind$1$b r0 = new com.baidu.bdtask.ui.components.toast.TaskToastView$onViewModelBind$1$b
            r0.<init>(r1, r3, r4)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            com.baidu.bdtask.ui.components.toast.TaskToastView r1 = r3.this$0
            long r1 = r1.DEFAULT_DELAY
            com.baidu.bdtask.framework.utils.UiThreadUtil.runOnUiThread(r0, r1)
            goto L_0x0110
        L_0x0103:
            if (r0 == 0) goto L_0x010f
            com.baidu.bdtask.ui.components.toast.TaskToastView r1 = r3.this$0
            com.baidu.bdtask.ui.components.toast.UniversalToast r1 = r1.toast
            r1.a((android.content.Context) r0)
        L_0x010f:
        L_0x0110:
            com.baidu.bdtask.ui.components.toast.TaskToastView r0 = r3.this$0
            com.baidu.bdtask.model.info.TaskInfo r1 = r4.getTaskInfo()
            com.baidu.bdtask.ctrl.model.TaskStatus r2 = r4.getTaskStatus()
            r0.toastShowUbc(r1, r2)
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.bdtask.ui.components.toast.TaskToastView$onViewModelBind$1.onChanged(com.baidu.bdtask.component.toast.TaskToastViewData):void");
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onToastClick"}, k = 3, mv = {1, 1, 9})
    static final class a implements UniversalToast.ToastCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f11034a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TaskToastViewData f11035b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TaskToastView$onViewModelBind$1 f11036c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TaskToastViewData f11037d;

        a(String str, TaskToastViewData taskToastViewData, TaskToastView$onViewModelBind$1 taskToastView$onViewModelBind$1, TaskToastViewData taskToastViewData2) {
            this.f11034a = str;
            this.f11035b = taskToastViewData;
            this.f11036c = taskToastView$onViewModelBind$1;
            this.f11037d = taskToastViewData2;
        }

        public final void onToastClick() {
            SchemeService schemeService;
            TaskInnerService taskInnerService;
            TaskInnerService taskInnerService2;
            TaskService serviceManager = BDPTask.INSTANCE.getServiceManager();
            if (!(serviceManager == null || (taskInnerService2 = serviceManager.getTaskInnerService()) == null)) {
                taskInnerService2.dispatchTaskBusinessEvent(this.f11035b.getTaskInfoSingleKey(), TaskBackFlowEvent.INS.getID());
            }
            TaskService serviceManager2 = BDPTask.INSTANCE.getServiceManager();
            if (!(serviceManager2 == null || (taskInnerService = serviceManager2.getTaskInnerService()) == null)) {
                taskInnerService.cleanTaskNoClickTimes(this.f11035b.getTaskInfoSingleKey());
            }
            TaskService serviceManager3 = BDPTask.INSTANCE.getServiceManager();
            if (!(serviceManager3 == null || (schemeService = serviceManager3.getSchemeService()) == null)) {
                schemeService.onIntercept(this.f11034a, 2);
            }
            this.f11036c.this$0.toastClickUbc(this.f11035b.getTaskInfo());
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f11038a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TaskToastView$onViewModelBind$1 f11039b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TaskToastViewData f11040c;

        b(Context context, TaskToastView$onViewModelBind$1 taskToastView$onViewModelBind$1, TaskToastViewData taskToastViewData) {
            this.f11038a = context;
            this.f11039b = taskToastView$onViewModelBind$1;
            this.f11040c = taskToastViewData;
        }

        public final void run() {
            this.f11039b.this$0.toast.b(this.f11038a);
        }
    }
}
