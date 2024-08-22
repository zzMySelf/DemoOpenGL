package com.baidu.talos.common;

import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.talos.TalosAdapterManager;

public class TalosUrlParamUtil {
    public static String appendParam(String url) {
        if (enableDoubleList()) {
            return BaiduIdentityManager.getInstance().appendParam(url, 1);
        }
        return BaiduIdentityManager.getInstance().processUrl(url);
    }

    private static synchronized boolean enableDoubleList() {
        boolean z;
        synchronized (TalosUrlParamUtil.class) {
            z = TalosAdapterManager.getABTestManager().getSwitch("talos_android_double_list_switch", true);
        }
        return z;
    }
}
