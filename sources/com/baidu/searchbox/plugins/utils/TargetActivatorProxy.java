package com.baidu.searchbox.plugins.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.browser.ILightBrowser;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.plugins.PluginInvokeActivity;
import com.baidu.searchbox.plugins.bridge.ApsBusinessRuntime;
import com.baidu.searchbox.util.BaiduIdentityManager;

public final class TargetActivatorProxy implements NoProGuard {
    private static final boolean DEBUG = (AppConfig.isDebug() & false);
    private static final String TAG = "TargetActivatorProxy";

    public static class Option {
        public String appId = null;
        public String appSrc = null;
        public boolean isVipApp = false;
        public boolean needBaiduParams = false;
        public int urlFrameCode = 1;
        public boolean useNewWindow = false;
        public String websiteUrl = null;
        public IWindowListener windowListener = null;
    }

    private TargetActivatorProxy() {
    }

    public static boolean checkOpenable(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (TextUtils.equals(action, "com.baidu.searchbox.plugin.action.INVOKE") || TextUtils.equals(action, PluginInvokeActivity.LBS_ENTER_ACTION) || TextUtils.equals(action, PluginInvokeActivity.THIRD_INVOKE_ACTION)) {
                String packageName = intent.getStringExtra("package_name");
                if (!TextUtils.isEmpty(packageName)) {
                    if (packageName.equals("com.baidu.appsearch")) {
                        if (ApsBusinessRuntime.getApsBusinessInterface().isInstallAppsearch(context)) {
                            boolean loadAppsearchWithoutMain = "1".equals(intent.getStringExtra(PluginInvokeActivity.EXTRA_PLUGIN_APPSEARCH_WITHOUT_MAIN));
                            boolean loadAppsearchSpecial = !"0".equals(intent.getStringExtra(PluginInvokeActivity.EXTRA_PLUGIN_APPSEARCH_SPECIAL));
                            if (!loadAppsearchWithoutMain && loadAppsearchSpecial) {
                                return true;
                            }
                        }
                    } else if (packageName.equals("com.baidu.wallet") && NPSPackageManager.getInstance().getBundleStatus(packageName) == 43) {
                        return true;
                    }
                    if (com.baidu.searchbox.aps.center.activator.TargetActivatorProxy.checkOpenable(context, packageName, false, 0, (Object[]) null) == 1) {
                        return true;
                    }
                    return false;
                }
            } else if (!TextUtils.equals(action, "com.baidu.searchbox.action.SEARCHCOMBINE_BARCODE") || com.baidu.searchbox.aps.center.activator.TargetActivatorProxy.checkOpenable(context, "com.baidu.searchbox.godeye", false, 0, (Object[]) null) != 1) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private static boolean handleOpenFailedWebsiteUrl(Context context, String packageName, Option option) {
        String innerWebsiteUrl = option.websiteUrl;
        boolean innerNeedBaiduParams = option.needBaiduParams;
        if (TextUtils.isEmpty(innerWebsiteUrl)) {
            return false;
        }
        ILightBrowser lightBrowser = (ILightBrowser) ServiceManager.getService(ILightBrowser.SERVICE_REFERENCE);
        if (option.urlFrameCode == 2) {
            if (option.useNewWindow) {
                lightBrowser.openExt(context, innerWebsiteUrl, (String) null, innerNeedBaiduParams);
            } else {
                lightBrowser.open(context, innerWebsiteUrl, (String) null, innerNeedBaiduParams);
            }
            return true;
        }
        if (innerNeedBaiduParams) {
            innerWebsiteUrl = BaiduIdentityManager.getInstance(context).processUrl(innerWebsiteUrl);
        }
        if (option.windowListener == null || !option.useNewWindow) {
            ApsBusinessRuntime.getApsBusinessInterface().loadUrl(context, innerWebsiteUrl, false, option.useNewWindow);
        } else {
            option.windowListener.onNewWindowOpenUrl(innerWebsiteUrl);
        }
        return true;
    }

    public static boolean handleOpenFailedDefault(Context context, String packageName, Option option) {
        if (handleOpenFailedWebsiteUrl(context, packageName, option)) {
            return true;
        }
        return false;
    }
}
