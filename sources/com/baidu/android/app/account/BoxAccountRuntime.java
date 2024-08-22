package com.baidu.android.app.account;

import android.content.Context;
import com.baidu.searchbox.account.config.IAccountConfig;
import com.baidu.searchbox.account.config.IAccountConfig_Impl_Factory;
import com.baidu.searchbox.account.listener.LowDeviceOptimizeCommandListenerKt;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ioc.impl.LoginContext_Factory;
import com.baidu.searchbox.ioc.impl.WebKitAbility_Factory;
import com.baidu.searchbox.security.WarmTipsManager;
import com.baidu.sofire.ac.FH;

public class BoxAccountRuntime {
    public static ILoginContext getLoginContext() {
        return LoginContext_Factory.get();
    }

    public static IWebKitAbility getWebKitAbility() {
        return WebKitAbility_Factory.get();
    }

    public static IAccountConfig getAccountConfig() {
        return IAccountConfig_Impl_Factory.get();
    }

    public static Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    @Deprecated
    public static final boolean isDebug() {
        return AppConfig.isDebug();
    }

    public static void initSofireSdk() {
        IAccountConfig config;
        if (getLowDeviceOptimizeSwitch() && (config = getAccountConfig()) != null) {
            FH.init(getAppContext(), config.getPassSofireAppKey(), config.getPassSofireSecKey(), config.getPassSofireId());
            FH.setAgreePolicy(getAppContext(), WarmTipsManager.hasConfirmDialog());
        }
    }

    public static boolean getLowDeviceOptimizeSwitch() {
        return LowDeviceOptimizeCommandListenerKt.enableAccountLowDeviceOptimize();
    }
}
