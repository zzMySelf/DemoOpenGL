package com.baidu.growthsystem.wealth.exit;

import android.content.Intent;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.growthsystem.wealth.common.util.WealthVideoPreferenceUtil;
import com.baidu.growthsystem.wealth.scenes.SceneConfigRepo;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/growthsystem/wealth/exit/WealthTaskExitManager;", "", "()V", "DEFAULT_VALUE_WEALTH_TASK_EXIT", "", "KEY_WEALTH_VIDEO_TASK_EXIT", "", "isWealthTaskExit", "getWealthTaskExitSp", "isHitExit", "openWealthVideoTaskExitSettingActivity", "", "setWealthTaskExit", "exit", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthTaskExitManager.kt */
public final class WealthTaskExitManager {
    private static final boolean DEFAULT_VALUE_WEALTH_TASK_EXIT = false;
    public static final WealthTaskExitManager INSTANCE;
    private static final String KEY_WEALTH_VIDEO_TASK_EXIT = "key_wealth_video_task_exit";
    private static boolean isWealthTaskExit;

    private WealthTaskExitManager() {
    }

    static {
        WealthTaskExitManager wealthTaskExitManager = new WealthTaskExitManager();
        INSTANCE = wealthTaskExitManager;
        isWealthTaskExit = wealthTaskExitManager.getWealthTaskExitSp();
    }

    public final boolean isHitExit() {
        return SceneConfigRepo.INSTANCE.isHitWealthVideoTaskExitExp();
    }

    public final boolean isWealthTaskExit() {
        if (!isHitExit()) {
            return false;
        }
        return isWealthTaskExit;
    }

    private final boolean getWealthTaskExitSp() {
        return WealthVideoPreferenceUtil.INSTANCE.getBoolean(KEY_WEALTH_VIDEO_TASK_EXIT, false);
    }

    public final void setWealthTaskExit(boolean exit) {
        isWealthTaskExit = exit;
        WealthVideoPreferenceUtil.INSTANCE.putBoolean(KEY_WEALTH_VIDEO_TASK_EXIT, exit);
    }

    public final void openWealthVideoTaskExitSettingActivity() {
        try {
            ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), new Intent(AppRuntime.getAppContext(), WealthTaskShowSettingActivity.class));
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }
}
