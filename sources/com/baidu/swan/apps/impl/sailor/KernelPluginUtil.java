package com.baidu.swan.apps.impl.sailor;

import android.content.Context;
import android.content.Intent;
import com.baidu.swan.apps.util.SwanAppActivityUtils;

class KernelPluginUtil {
    private static final String ACTION_PLUGIN_DETAIL = "com.baidu.searchbox.action.PLUGIN_DETAIL";
    private static final String KEY_PLUGIN_NAME = "plugin_kernel_name";
    private static final String WEBKIT_KERNEL_PLUGIN_ID = "WebkitKernelPlugin";

    KernelPluginUtil() {
    }

    public static void startWebkitKernelPluginActivity(Context context) {
        Intent intent = new Intent();
        intent.setAction(ACTION_PLUGIN_DETAIL);
        intent.setPackage(context.getPackageName());
        intent.putExtra("plugin_kernel_name", "WebkitKernelPlugin");
        SwanAppActivityUtils.startActivitySafely(context, intent, true);
    }
}
