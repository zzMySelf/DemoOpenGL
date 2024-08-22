package com.baidu.searchbox.nps.init;

import android.content.Context;
import com.baidu.nps.main.manager.Configurations;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.searchbox.buildconfig.BuildConfigManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.nps.impl.PackageGetterBridge;
import com.baidu.searchbox.pms.init.RequestParams;

public class PluginInitManager {
    private static volatile PluginInitManager instance;
    private volatile PackageGetterBridge mPackageGetterBridge;

    private PluginInitManager() {
        initPackageGetter();
    }

    public static PluginInitManager getInstance() {
        if (instance == null) {
            synchronized (PluginInitManager.class) {
                if (instance == null) {
                    instance = new PluginInitManager();
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        Configurations.Builder builder = new Configurations.Builder();
        builder.debug(AppConfig.isDebug() || isReleaseConfig());
        NPSManager.getInstance().init(context, builder.build(), false);
    }

    private boolean isReleaseConfig() {
        try {
            return BuildConfigManager.getBoolean("BuildConfig", "BUILD_FORCE_USE_CONFIG");
        } catch (Throwable e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private synchronized void initPackageGetter() {
        if (this.mPackageGetterBridge == null) {
            this.mPackageGetterBridge = new PackageGetterBridge();
        }
    }

    public PackageGetterBridge getPackageGetterBridge() {
        initPackageGetter();
        return this.mPackageGetterBridge;
    }

    public RequestParams.Channel getFetchAllChannel() {
        initPackageGetter();
        return this.mPackageGetterBridge.getFetchAllChannel();
    }
}
