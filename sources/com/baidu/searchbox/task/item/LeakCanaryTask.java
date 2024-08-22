package com.baidu.searchbox.task.item;

import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.speed.box.SpeedDependcyRuntime;

public class LeakCanaryTask extends LaunchTask {
    public void execute() {
        if (DEBUG) {
            SpeedDependcyRuntime.getSpeedClient().installLeakCanary();
        }
    }

    public String getName() {
        return SpeedStatsMainTable.LEAKCANARY_TASK;
    }

    public int getProcess() {
        return 3;
    }
}
