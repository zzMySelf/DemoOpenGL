package com.baidu.searchbox.rewardsystem.components.status.running;

import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.searchbox.taskapi.business.common.TaskSdkData;
import com.baidu.searchbox.taskapi.core.ITaskStatusCallback;
import com.baidu.searchbox.taskapi.core.config.TaskConfig;
import com.baidu.searchbox.taskapi.core.util.TaskDebugUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "taskInfo", "Lcom/baidu/bdtask/model/info/TaskInfo;", "taskStatus", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TaskRunningOPComponent.kt */
final class TaskRunningOPComponent$taskBuoyView$1$2 extends Lambda implements Function2<TaskInfo, TaskStatus, Unit> {
    final /* synthetic */ TaskConfig $taskConfig;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TaskRunningOPComponent$taskBuoyView$1$2(TaskConfig taskConfig) {
        super(2);
        this.$taskConfig = taskConfig;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((TaskInfo) p1, (TaskStatus) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(TaskInfo taskInfo, TaskStatus taskStatus) {
        ITaskStatusCallback taskStatusCallback;
        ITaskStatusCallback taskStatusCallback2;
        ITaskStatusCallback taskStatusCallback3;
        ITaskStatusCallback taskStatusCallback4;
        ITaskStatusCallback taskStatusCallback5;
        if (taskInfo != null && taskStatus != null) {
            TaskSdkData taskSdkData = null;
            TaskState findTaskStateByActionId = BDPTask.INSTANCE.findTaskStateByActionId(taskInfo.getActionId());
            TaskInfo bdpTaskInfo = findTaskStateByActionId != null ? findTaskStateByActionId.getTaskInfo() : null;
            if (bdpTaskInfo != null) {
                taskSdkData = TaskSdkData.Companion.createData(bdpTaskInfo, taskStatus);
            }
            if (taskStatus.isRunning()) {
                TaskDebugUtil.debugLog("【TaskRunningOPComponent】[onTaskRunning] [回调] ");
                TaskConfig taskConfig = this.$taskConfig;
                if (!(taskConfig == null || (taskStatusCallback5 = taskConfig.getTaskStatusCallback()) == null)) {
                    taskStatusCallback5.onTaskRunning(taskSdkData);
                }
            }
            if (taskStatus.isInterrupted()) {
                TaskDebugUtil.debugLog("【TaskRunningOPComponent】[onTaskInterrupted] [回调]");
                TaskConfig taskConfig2 = this.$taskConfig;
                if (!(taskConfig2 == null || (taskStatusCallback4 = taskConfig2.getTaskStatusCallback()) == null)) {
                    taskStatusCallback4.onTaskInterrupted();
                }
            }
            if (taskStatus.isDuplicated()) {
                TaskDebugUtil.debugLog("【TaskRunningOPComponent】[onTaskDuplicated] [回调]");
                TaskConfig taskConfig3 = this.$taskConfig;
                if (!(taskConfig3 == null || (taskStatusCallback3 = taskConfig3.getTaskStatusCallback()) == null)) {
                    taskStatusCallback3.onTaskDuplicated();
                }
            } else if (taskStatus.isFinished()) {
                TaskDebugUtil.debugLog("【TaskRunningOPComponent】[onOnceTaskIsFinish] [回调]");
                TaskConfig taskConfig4 = this.$taskConfig;
                if (!(taskConfig4 == null || (taskStatusCallback2 = taskConfig4.getTaskStatusCallback()) == null)) {
                    taskStatusCallback2.onOnceTaskIsFinish(taskSdkData);
                }
            }
            if (taskInfo.isDone()) {
                TaskDebugUtil.debugLog("【TaskRunningOPComponent】[onAllTaskIsFinish] [回调]");
                TaskConfig taskConfig5 = this.$taskConfig;
                if (taskConfig5 != null && (taskStatusCallback = taskConfig5.getTaskStatusCallback()) != null) {
                    taskStatusCallback.onAllTaskIsFinish(taskSdkData);
                }
            }
        }
    }
}
