package com.baidu.searchbox.rewardsystem.components.status.running;

import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.utils.TaskErrorNoUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.rewardsystem.newtimer.data.TimerDataModel;
import com.baidu.searchbox.rewardsystem.newtimer.status.TimerStatus;
import com.baidu.searchbox.rewardsystem.newtimer.view.ITimerView;
import com.baidu.searchbox.rewardsystem.utils.RewardDebugUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/baidu/bdtask/model/info/TaskInfo;", "errorCode", "", "<anonymous parameter 2>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TaskRunningOPComponent.kt */
final class TaskRunningOPComponent$updateView$1$1 extends Lambda implements Function3<TaskInfo, Integer, String, Unit> {
    final /* synthetic */ TaskRunningOPComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaskRunningOPComponent$updateView$1$1(TaskRunningOPComponent taskRunningOPComponent) {
        super(3);
        this.this$0 = taskRunningOPComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((TaskInfo) p1, ((Number) p2).intValue(), (String) p3);
        return Unit.INSTANCE;
    }

    public final void invoke(TaskInfo taskInfo, int errorCode, String str) {
        Intrinsics.checkNotNullParameter(taskInfo, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
        if (TaskErrorNoUtils.INSTANCE.isDuplicateErrorNo(errorCode)) {
            if (AppConfig.isDebug()) {
                RewardDebugUtils.INSTANCE.debug("isDuplicate;");
            }
            this.this$0.onRunningUpdate(false, false);
            ITimerView view2 = this.this$0.getView();
            TimerDataModel timerDataModel = new TimerDataModel();
            TimerDataModel $this$invoke_u24lambda_u2d0 = timerDataModel;
            $this$invoke_u24lambda_u2d0.setTimerStatus(TimerStatus.FINISHED);
            $this$invoke_u24lambda_u2d0.setTimerFinishedAnimationEnabled(false);
            view2.updateTimerData(timerDataModel);
        }
    }
}
