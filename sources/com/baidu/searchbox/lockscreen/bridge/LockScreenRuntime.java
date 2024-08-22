package com.baidu.searchbox.lockscreen.bridge;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.lockscreen.LockScreenContext_Factory;
import com.baidu.searchbox.lockscreen.LockScreenFavor_Factory;
import com.baidu.searchbox.lockscreen.LockScreenImpl_Factory;
import com.baidu.searchbox.lockscreen.util.LockScreenUtil;

public class LockScreenRuntime {
    public static boolean GLOBAL_DEBUG = LockScreenUtil.GLOBAL_DEBUG;
    static Context sAppContext = AppRuntime.getAppContext();
    private static ILockScreenContext sLockScreenContext;
    private static Handler sMainHandler = new Handler(Looper.getMainLooper());

    public static Context getAppContext() {
        return sAppContext;
    }

    public static void setLockScreenContext(ILockScreenContext lockScreenContext) {
        sLockScreenContext = lockScreenContext;
    }

    public static ILockScreenContext getLockScreenContext() {
        return LockScreenContext_Factory.get();
    }

    public static Handler getLockScreenHandler() {
        return sMainHandler;
    }

    public static ILockScreenFavor getLockScreenFavor() {
        return LockScreenFavor_Factory.get();
    }

    public static ILockScreenInterface getLockScreenInterface() {
        return LockScreenImpl_Factory.get();
    }
}
