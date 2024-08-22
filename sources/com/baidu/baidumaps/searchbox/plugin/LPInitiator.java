package com.baidu.baidumaps.searchbox.plugin;

import android.app.Application;
import android.content.Context;
import com.baidu.mapframework.api2.ComAPIManager;
import com.baidu.platform.comapi.ContextHolder;
import com.baidu.platform.comapi.util.SysOSAPIv2;

public class LPInitiator {
    public static final String TAG = "LPInitiator";
    private static boolean sIsEngineInit = false;

    public static boolean initInAppOnCreate(Application application) {
        if (application != null) {
            ContextHolder.setApplicationContext(application);
            initEngine(application);
            return true;
        }
        throw new RuntimeException("initInAppOnCreate must have an app Context param");
    }

    public static boolean initEngine(Application app) {
        return initMapEngineResource(app);
    }

    private static synchronized boolean initMapEngineResource(Context appContext) {
        synchronized (LPInitiator.class) {
            if (sIsEngineInit) {
                return true;
            }
            sIsEngineInit = true;
            if (appContext == null) {
                return false;
            }
            SysOSAPIv2.getInstance().setChannel(ComAPIManager.getComAPIManager().getSearchBoxPluginApi().getChannel());
            return true;
        }
    }
}
