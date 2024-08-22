package com.baidu.searchbox.live.goods.detail.impl.task;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.component.buoy.BuoyComponentFactory;
import com.baidu.bdtask.component.buoy.timer.TimerBuoyViewModel;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.ui.components.buoy.TaskBuoyView;
import com.baidu.searchbox.live.goods.detail.interfaces.task.ITaskService;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/live/goods/detail/impl/task/TaskServiceImpl;", "Lcom/baidu/searchbox/live/goods/detail/interfaces/task/ITaskService;", "()V", "addActionWithActionId", "", "actionId", "", "addOnce", "attachToWindow", "viewGroup", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "activeId", "detachFromWindow", "registerTaskWithInfo", "rawTaskStr", "lib-goods-detail-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TaskServiceImpl.kt */
public final class TaskServiceImpl implements ITaskService {
    public void registerTaskWithInfo(String rawTaskStr) {
        Intrinsics.checkNotNullParameter(rawTaskStr, "rawTaskStr");
        BDPTask.INSTANCE.registerTaskWithInfo(rawTaskStr);
    }

    public void addActionWithActionId(String actionId) {
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        BDPTask.INSTANCE.addActionWithActionId(actionId);
    }

    public void addOnce(String actionId) {
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        BDPTask.INSTANCE.addActionWithActionId(actionId);
    }

    public void attachToWindow(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, String activeId) {
        Intrinsics.checkNotNullParameter(activeId, "activeId");
        TaskState findTaskStateByActionId = BDPTask.INSTANCE.findTaskStateByActionId(activeId);
        TaskInfo taskInfo = findTaskStateByActionId != null ? findTaskStateByActionId.getTaskInfo() : null;
        if (viewGroup != null) {
            ViewGroup viewContainer = viewGroup;
            if (taskInfo != null) {
                TaskInfo taskInfo2 = taskInfo;
                if (taskInfo.isClickAction()) {
                    Context applicationContext = viewContainer.getContext().getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "viewContainer.context.applicationContext");
                    BuoyComponentFactory.Companion.createTimesBuoyComponent(new TaskBuoyView(applicationContext), new TimerBuoyViewModel(taskInfo), taskInfo).attachToWindow(viewContainer, layoutParams);
                }
            }
        }
    }

    public void detachFromWindow() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }
}
