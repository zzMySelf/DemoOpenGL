package com.baidu.searchbox.task.item;

import android.util.Log;
import com.baidu.android.util.media.PreloadUIResUtil;
import com.baidu.searchbox.launchbusinesstask.R;
import com.baidu.searchbox.performance.speed.task.LaunchTask;

public class PreloadSplashBgTask extends LaunchTask {
    public void execute() {
        if (DEBUG) {
            Log.e("PreloadUIResUtil", "ParallelRender: preload");
        }
        PreloadUIResUtil.preloadDrawable(R.drawable.splash_widow_bg);
    }

    public String getName() {
        return "PreloadSplashBg";
    }

    public int getProcess() {
        return 1;
    }
}
