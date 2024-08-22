package com.baidu.searchbox.aps.center.install.manager;

import android.content.Context;
import com.baidu.searchbox.aps.center.install.api.PluginInstallManager;

public class PluginRestartInstallManager {
    private static final String TAG = "PluginRestartInstallManager";
    private static boolean sHasRestart = false;

    public static void restartInstall(Context context) {
        synchronized (PluginRestartInstallManager.class) {
            if (!sHasRestart) {
                sHasRestart = true;
                PluginInstallManager.getInstance(context).resumeInstallToAllWithoutManual(true);
            }
        }
    }
}
