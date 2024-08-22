package com.baidu.searchbox.shake;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.plugins.annotation.PluginAccessable;

public final class BDShakePluginManager implements NoProGuard {
    @PluginAccessable(methodName = "globalShakeOn", paramClasses = {String.class})
    public static void globalShakeOn(String business) {
        BDShakePowerManager.globalShakeOn(business);
    }

    @PluginAccessable(methodName = "globalShakeOff", paramClasses = {String.class})
    public static void globalShakeOff(String business) {
        BDShakePowerManager.globalShakeOff(business);
    }

    @PluginAccessable(methodName = "isGlobalShakeOn", paramClasses = {})
    public static boolean isGlobalShakeOn() {
        return BDShakePowerManager.isGlobalShakeOn();
    }
}
