package com.baidu.searchbox.taskmanager;

import com.baidu.launch.LaunchABUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.performance.speed.task.BaseTaskPool;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.task.item.ABInitTask;
import com.baidu.searchbox.task.item.CheckRepackagingTask;
import com.baidu.searchbox.task.item.DeviceInfoAsyncTask;
import com.baidu.searchbox.task.item.DeviceInfoSyncTask;
import com.baidu.searchbox.task.item.DeviceScoreTask;
import com.baidu.searchbox.task.item.DisableClassVerifierTask;
import com.baidu.searchbox.task.item.FeedPreloadTask;
import com.baidu.searchbox.task.item.FetchDnsTask;
import com.baidu.searchbox.task.item.FrescoTask;
import com.baidu.searchbox.task.item.GcOptTask;
import com.baidu.searchbox.task.item.InitExcutorTask;
import com.baidu.searchbox.task.item.InitReceiverTask;
import com.baidu.searchbox.task.item.LeakCanaryTask;
import com.baidu.searchbox.task.item.LokiMonitorUploadTask;
import com.baidu.searchbox.task.item.MainLooperOptTask;
import com.baidu.searchbox.task.item.NPSInitTask;
import com.baidu.searchbox.task.item.OAIDPreloadTask;
import com.baidu.searchbox.task.item.PluginInitTask;
import com.baidu.searchbox.task.item.PreloadClassTask;
import com.baidu.searchbox.task.item.PreloadSplashBgTask;
import com.baidu.searchbox.task.item.RNSoloadTask;
import com.baidu.searchbox.task.item.RemoteConfigInitTask;
import com.baidu.searchbox.task.item.SkinTask;
import com.baidu.searchbox.task.item.SpOptTask;
import com.baidu.searchbox.task.item.StrictModeTask;
import com.baidu.searchbox.task.item.SysThreadScheduleTask;
import com.baidu.searchbox.task.item.VirturalRuntimeCheckTask;
import com.baidu.searchbox.task.item.WebkitTask;
import com.baidu.searchbox.tools.performance.MemorySnapShotMonitorTask;
import java.util.ArrayList;
import java.util.List;

public class ApplicationTaskPool extends BaseTaskPool {
    public List<LaunchTask> onAppCreate(boolean isAsync) {
        List<LaunchTask> taskList = new ArrayList<>();
        if (isAsync) {
            taskList.add(new GcOptTask());
            taskList.add(new DeviceInfoAsyncTask());
            taskList.add(new PreloadSplashBgTask());
            taskList.add(new PreloadClassTask());
            taskList.add(new MainLooperOptTask());
            taskList.add(new FetchDnsTask());
            taskList.add(new ABInitTask());
            taskList.add(new OAIDPreloadTask());
            taskList.add(new RNSoloadTask());
            taskList.add(new VirturalRuntimeCheckTask());
            taskList.add(new InitExcutorTask());
            taskList.add(new InitReceiverTask());
            taskList.add(new DeviceScoreTask());
            if (!LaunchABUtils.enableLowendOpV2()) {
                taskList.add(new DisableClassVerifierTask());
            }
            if (SpeedStats.getInstance().getLaunchType() == 2) {
                taskList.add(new FeedPreloadTask());
            }
            taskList.add(new SpOptTask());
            taskList.add(new LokiMonitorUploadTask());
            taskList.add(new RemoteConfigInitTask());
            if (LaunchABUtils.getRegisterReceiverOptSwitch() != 0) {
                taskList.add(new NPSInitTask());
            }
            taskList.add(new SysThreadScheduleTask());
        } else {
            taskList.add(new DeviceInfoSyncTask());
            taskList.add(new SkinTask());
            taskList.add(new PluginInitTask());
            taskList.add(new WebkitTask());
            taskList.add(new FrescoTask());
            if (LaunchABUtils.getRegisterReceiverOptSwitch() == 0) {
                taskList.add(new NPSInitTask());
            }
            if (AppConfig.isDebug()) {
                taskList.add(new LeakCanaryTask());
                taskList.add(new StrictModeTask());
            }
        }
        return taskList;
    }

    public List<LaunchTask> onUiReady(boolean isAsync) {
        List<LaunchTask> taskList = new ArrayList<>();
        if (isAsync) {
            taskList.add(new MemorySnapShotMonitorTask());
            taskList.add(new CheckRepackagingTask());
        }
        return taskList;
    }
}
