package com.baidu.taskmanager.ioc;

import com.baidu.taskmanager.ITaskManager;

public interface ILaunchTaskManagerIOC {
    public static final ILaunchTaskManagerIOC EMPTY = new ILaunchTaskManagerIOC() {
        public ITaskManager getAsyncTaskManager() {
            return null;
        }

        public ITaskManager getIdleTaskManager() {
            return null;
        }

        public ITaskManager getSmartTaskManager() {
            return null;
        }
    };

    ITaskManager getAsyncTaskManager();

    ITaskManager getIdleTaskManager();

    ITaskManager getSmartTaskManager();
}
