package com.baidu.searchbox.rewardsystem.components.status.running;

import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.framework.ui.buoy.BaseBuoyView;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.searchbox.rewardsystem.components.base.BaseRewardOPComponent;
import com.baidu.searchbox.rewardsystem.components.base.RewardTimerCoreComponent;
import com.baidu.searchbox.rewardsystem.components.base.RewardTimerView;
import com.baidu.searchbox.rewardsystem.components.status.OPTaskConfig;
import com.baidu.searchbox.rewardsystem.newtimer.view.ITimerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ$\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012H&R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/rewardsystem/components/status/running/BaseRunningOPComponent;", "T", "Lcom/baidu/searchbox/rewardsystem/components/base/BaseRewardOPComponent;", "", "owner", "config", "Lcom/baidu/searchbox/rewardsystem/components/status/OPTaskConfig;", "view", "Lcom/baidu/searchbox/rewardsystem/newtimer/view/ITimerView;", "(Lcom/baidu/searchbox/rewardsystem/components/base/BaseRewardOPComponent;Lcom/baidu/searchbox/rewardsystem/components/status/OPTaskConfig;Lcom/baidu/searchbox/rewardsystem/newtimer/view/ITimerView;)V", "getConfig", "()Lcom/baidu/searchbox/rewardsystem/components/status/OPTaskConfig;", "getOwner", "()Lcom/baidu/searchbox/rewardsystem/components/base/BaseRewardOPComponent;", "Lcom/baidu/searchbox/rewardsystem/components/base/BaseRewardOPComponent;", "getView", "()Lcom/baidu/searchbox/rewardsystem/newtimer/view/ITimerView;", "createRewardTimerCoreComponent", "Lcom/baidu/searchbox/rewardsystem/components/base/RewardTimerCoreComponent;", "Lcom/baidu/bdtask/framework/ui/buoy/BaseBuoyView;", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewData;", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModel;", "taskInfo", "Lcom/baidu/bdtask/model/info/TaskInfo;", "createRewardTimerView", "Lcom/baidu/searchbox/rewardsystem/components/base/RewardTimerView;", "onUpdateViewReshow", "", "taskState", "Lcom/baidu/bdtask/TaskState;", "timerComp", "lib_bdptask_operation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseRunningOPComponent.kt */
public abstract class BaseRunningOPComponent<T extends BaseRewardOPComponent> {
    private final OPTaskConfig config;
    private final T owner;

    /* renamed from: view  reason: collision with root package name */
    private final ITimerView f2822view;

    public abstract RewardTimerCoreComponent createRewardTimerCoreComponent(BaseBuoyView<TaskBuoyViewData, TaskBuoyViewModel> baseBuoyView, TaskInfo taskInfo);

    public abstract RewardTimerView createRewardTimerView();

    public abstract void onUpdateViewReshow(TaskState taskState, RewardTimerCoreComponent rewardTimerCoreComponent);

    public BaseRunningOPComponent(T owner2, OPTaskConfig config2, ITimerView view2) {
        Intrinsics.checkNotNullParameter(owner2, "owner");
        Intrinsics.checkNotNullParameter(config2, "config");
        Intrinsics.checkNotNullParameter(view2, "view");
        this.owner = owner2;
        this.config = config2;
        this.f2822view = view2;
    }

    public final OPTaskConfig getConfig() {
        return this.config;
    }

    public final T getOwner() {
        return this.owner;
    }

    public final ITimerView getView() {
        return this.f2822view;
    }
}
