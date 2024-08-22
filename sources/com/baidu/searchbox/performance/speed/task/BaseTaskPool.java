package com.baidu.searchbox.performance.speed.task;

import java.util.List;

public abstract class BaseTaskPool {
    public abstract List<LaunchTask> onAppCreate(boolean z);

    public abstract List<LaunchTask> onUiReady(boolean z);

    public List<LaunchTask> getTaskList(int lifeCycle, boolean isAsync) {
        switch (lifeCycle) {
            case 1:
                return onAppCreate(isAsync);
            case 3:
                return onUiReady(isAsync);
            default:
                return null;
        }
    }
}
