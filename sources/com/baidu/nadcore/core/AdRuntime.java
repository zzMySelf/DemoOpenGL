package com.baidu.nadcore.core;

import android.app.Application;
import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceManager;

public class AdRuntime {
    public static final boolean DEBUG = false;
    public static final String SDK_VERSION = "6.11.0.28";
    protected static Application sApp;
    private static IAdConfig sConfigRef = null;

    private static class DeviceInfoHolder {
        /* access modifiers changed from: private */
        public static final IDeviceInfo DEVICE_INFO = new DeviceInfoImpl();

        private DeviceInfoHolder() {
        }
    }

    public static IAdConfig config() {
        if (sConfigRef == null) {
            synchronized (AdRuntime.class) {
                if (sConfigRef == null) {
                    sConfigRef = (IAdConfig) ServiceManager.getService(IAdConfig.SERVICE_REFERENCE);
                }
                if (sConfigRef == null) {
                    sConfigRef = IAdConfig.EMPTY;
                }
            }
        }
        return sConfigRef;
    }

    public static Context applicationContext() {
        return sApp;
    }

    public static Application application() {
        return sApp;
    }

    @Deprecated
    public static IDeviceInfo appInfo() {
        return DeviceInfoHolder.DEVICE_INFO;
    }

    public static IDeviceInfo deviceInfo() {
        return DeviceInfoHolder.DEVICE_INFO;
    }

    public static String getUserAgent() {
        return AppInfoManager.instance().getUserAgent();
    }
}
