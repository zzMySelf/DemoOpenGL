package com.baidu.searchbox.taskapi.core.strategy.find.impl;

import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.taskapi.core.config.TaskConfig;
import com.baidu.searchbox.taskapi.core.config.TaskType;
import com.baidu.searchbox.taskapi.core.strategy.TaskIsExistStrategy;
import com.baidu.searchbox.taskapi.core.util.ICallback;
import com.baidu.searchbox.taskapi.core.util.TaskDebugUtil;

public class GlobalTaskFindStep extends BaseFindStep {
    public /* bridge */ /* synthetic */ void setNextStep(BaseFindStep baseFindStep) {
        super.setNextStep(baseFindStep);
    }

    public /* bridge */ /* synthetic */ void startFindTask() {
        super.startFindTask();
    }

    public GlobalTaskFindStep(ICallback<TaskType> callback, TaskConfig mConfig, boolean callbackToUI) {
        super(callback, mConfig, callbackToUI);
    }

    public void findTask() {
        TaskDebugUtil.debugLog("【FindStep】start find '全局计时器' ");
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                boolean isExist = TaskIsExistStrategy.globalTaskIsExist();
                TaskDebugUtil.insertSpeedTimeLog("[查找'计时器'] [结束] isExist: " + isExist);
                GlobalTaskFindStep.this.doFindTaskResult(isExist);
            }
        }, "findTask", 1);
    }

    /* access modifiers changed from: package-private */
    public TaskType getTaskType() {
        return TaskType.TASK_GLOBAL;
    }
}
