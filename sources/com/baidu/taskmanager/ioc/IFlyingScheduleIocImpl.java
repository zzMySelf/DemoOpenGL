package com.baidu.taskmanager.ioc;

import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.unitedscheme.IFlyingScheduleIoc;
import com.baidu.taskmanager.FlyTaskManager;

public final class IFlyingScheduleIocImpl implements IFlyingScheduleIoc {
    public boolean enableFlyingSchedule() {
        return QuickPersistConfig.getInstance().getBoolean(FlyTaskManager.SCHEME_PRIORITY_ENABLE_KEY, true);
    }
}
