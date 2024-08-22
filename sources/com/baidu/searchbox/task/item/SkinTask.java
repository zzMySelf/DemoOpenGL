package com.baidu.searchbox.task.item;

import android.content.Context;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.home.theme.IHomeThemeFun;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.skin.SkinManager;
import com.baidu.searchbox.skin.model.SkinManagerConfig;
import com.baidu.searchbox.speed.box.SpeedDependcyRuntime;

public class SkinTask extends LaunchTask {
    public void execute() {
        Context context = SpeedDependcyRuntime.getAppContext();
        if (SpeedDependcyRuntime.getSpeedClient().isMainProcess()) {
            SkinManager.getInstance().init(context);
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    PreloadTask.preloadUIResources();
                    long startTime = System.currentTimeMillis();
                    ((IHomeThemeFun) ServiceManager.getService(IHomeThemeFun.SERVICE_REFERENCE)).preload();
                    long endTime = System.currentTimeMillis();
                    if (SkinTask.DEBUG) {
                        Log.d("NewThemeManager", " preload time = " + (endTime - startTime));
                    }
                    SpeedStatsManager.getInstance().setTaskRunTime("preloadHomeSkin", endTime - startTime);
                }
            }, "preloadResource", 0);
        } else if (SpeedDependcyRuntime.getSpeedClient().isSwanAppProcess()) {
            SkinManager.getInstance().init(context, SkinManagerConfig.Builder.newBuilder().setIsLoadSkinResources(false).create());
        }
    }

    public String getName() {
        return "skin";
    }

    public int getProcess() {
        return 3;
    }
}
