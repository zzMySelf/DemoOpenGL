package com.baidu.searchbox.logsystem.exceptionhandler.box;

import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.IExceptionHandlerContext;

public class ExceptionHandlerContext implements IExceptionHandlerContext {
    public long getAppLaunchStartTimeStamp() {
        return SpeedStatsManager.getInstance().getAppLaunchStartTimeStamp();
    }
}
