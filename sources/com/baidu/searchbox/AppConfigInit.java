package com.baidu.searchbox;

import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.abtest.AbtestConstants;
import com.baidu.searchbox.aop.annotation.TimeSpendTrace;
import com.baidu.searchbox.buildconfig.BuildConfigManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.util.Utility;

public class AppConfigInit {
    @TimeSpendTrace(tag = "AppInit")
    public static void initAppConfig() {
        if (SearchBox.DEBUG) {
            AppConfig.parseConfig((AppConfig.ConfigValueFilter) null);
        } else if (BuildConfigManager.getBoolean("BuildConfig", "BUILD_FORCE_USE_CONFIG") || QuickPersistConfig.getInstance().getBoolean(QuickPersistConfigConst.KEY_DEVELOPMENT_SETTINGS, false)) {
            AppConfig.parseConfig(new AppConfig.ConfigValueFilter() {
                public boolean isIllegalContent(String value) {
                    if (!Utility.isPartofBaidu(value)) {
                        return true;
                    }
                    return false;
                }
            });
        }
        HostConfig.setsConfigInterceptor(new HostConfig.ConfigInterceptor() {
            public boolean getBooleanConfig(String scop, String key) {
                if (!HostConfig.CONFIG_ABTEST_SCOP.equals(scop) || !HostConfig.CONFIG_KEY_TCBOX_HOST.equals(key)) {
                    return false;
                }
                return AbTestManager.getInstance().getSwitch(AbtestConstants.TCBOX_HTTPS_SWITCH, true);
            }
        });
    }
}
