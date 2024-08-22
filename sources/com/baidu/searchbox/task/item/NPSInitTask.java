package com.baidu.searchbox.task.item;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.nps.init.PluginInitManager;
import com.baidu.searchbox.performance.speed.task.LaunchTask;

public class NPSInitTask extends LaunchTask {
    private static final String TASK_NAME = "NPS_init_task";

    public int getProcess() {
        return -1;
    }

    public void execute() {
        PluginInitManager.getInstance().init(AppRuntime.getAppContext());
    }

    public String getName() {
        return TASK_NAME;
    }
}
