package com.baidu.searchbox.getuiwakeup;

import android.content.Context;
import com.baidu.android.pushservice.PushManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.push.DeveloperConstants;
import com.baidu.searchbox.security.WarmTipsManager;

public class GetuiWakeupUtils {
    public static void enableProxy(Context context) {
        PushManager.enableXiaomiProxy(context, WarmTipsManager.isPermissionGrantedForProcess(), DeveloperConstants.XIAOMI_PUSH_APPID, DeveloperConstants.XIAOMI_PUSH_APPKEY);
        if (!AppConfig.AppInfo.isModifyPkg()) {
            PushManager.enableHuaweiProxy(context, true);
            PushManager.enableHonorProxy(context, true);
            PushManager.enableOppoProxy(context, true, DeveloperConstants.OPPO_PUSH_APPKEY, DeveloperConstants.OPPO_PUSH_APPSECRET);
            PushManager.enableVivoProxy(context, true);
            PushManager.enableMeizuProxy(context, WarmTipsManager.isPermissionGrantedForProcess(), DeveloperConstants.MEIZU_PUSH_APPID, DeveloperConstants.MEIZU_PUSH_APPKEY);
        }
    }
}
