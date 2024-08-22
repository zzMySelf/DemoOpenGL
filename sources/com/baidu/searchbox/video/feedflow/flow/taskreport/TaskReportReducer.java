package com.baidu.searchbox.video.feedflow.flow.taskreport;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.flow.operation.element.FlowOperationAction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/taskreport/TaskReportReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TaskReportReducer.kt */
public final class TaskReportReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof FlowOperationAction.ReportFlowTimerTaskAction) {
            TaskReportState taskReportState = (TaskReportState) state.select(TaskReportState.class);
            MutableLiveData<Pair<String, ?>> reportTask = taskReportState != null ? taskReportState.getReportTask() : null;
            if (reportTask != null) {
                reportTask.setValue(((FlowOperationAction.ReportFlowTimerTaskAction) action).getSendData());
            }
        }
        return state;
    }
}
