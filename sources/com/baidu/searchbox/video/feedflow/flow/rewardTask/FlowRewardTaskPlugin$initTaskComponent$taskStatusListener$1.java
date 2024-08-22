package com.baidu.searchbox.video.feedflow.flow.rewardTask;

import com.baidu.searchbox.taskapi.business.common.TaskSdkData;
import com.baidu.searchbox.taskapi.core.ITaskStatusCallback;
import com.baidu.searchbox.taskapi.core.strategy.ITaskAnimatorCallback;
import com.baidu.searchbox.taskapi.core.strategy.TaskAnimatorMutexStrategy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/flow/rewardTask/FlowRewardTaskPlugin$initTaskComponent$taskStatusListener$1", "Lcom/baidu/searchbox/taskapi/core/ITaskStatusCallback$Adapter;", "onOnceTaskIsFinish", "", "taskSdkData", "Lcom/baidu/searchbox/taskapi/business/common/TaskSdkData;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowRewardTaskPlugin.kt */
public final class FlowRewardTaskPlugin$initTaskComponent$taskStatusListener$1 extends ITaskStatusCallback.Adapter {
    final /* synthetic */ FlowRewardTaskPlugin this$0;

    FlowRewardTaskPlugin$initTaskComponent$taskStatusListener$1(FlowRewardTaskPlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void onOnceTaskIsFinish(TaskSdkData taskSdkData) {
        super.onOnceTaskIsFinish(taskSdkData);
        this.this$0.animCallback = new FlowRewardTaskPlugin$initTaskComponent$taskStatusListener$1$onOnceTaskIsFinish$1(this.this$0, taskSdkData);
        ITaskAnimatorCallback $this$onOnceTaskIsFinish_u24lambda_u2d0 = this.this$0.animCallback;
        if ($this$onOnceTaskIsFinish_u24lambda_u2d0 != null) {
            TaskAnimatorMutexStrategy.INSTANCE.startAnimator($this$onOnceTaskIsFinish_u24lambda_u2d0);
        }
    }
}
