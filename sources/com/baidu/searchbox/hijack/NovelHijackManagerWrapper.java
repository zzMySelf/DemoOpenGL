package com.baidu.searchbox.hijack;

import android.content.Context;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.noveladapter.scheme.INovelUnitedSchemeCallbackHandler;
import com.baidu.searchbox.noveladapter.scheme.warpper.NovelUnitedSchemeEntityWarpper;

public class NovelHijackManagerWrapper implements NoProGuard {
    public static boolean transOpen(Context context, NovelUnitedSchemeEntityWarpper entityWarpper, INovelUnitedSchemeCallbackHandler handlerWrapper) {
        return NovelHijackManager.transOpen(context, entityWarpper, handlerWrapper);
    }

    public static void closeContainer(String containerId) {
        NovelHijackManager.closeContainer(containerId);
    }

    public static String getHijackValue(String key, String defaultValue) {
        return NovelHijackManager.getHijackValue(key, defaultValue);
    }

    public static String getNoveFEHost() {
        if (AppConfig.isDebug()) {
            return AppConfig.getStringConfig("NOVEL_FE_HOST", "");
        }
        return "";
    }

    public static boolean isNaHijackSwitchOpen() {
        return NovelHijackManager.isNaHijackSwitchOpen();
    }
}
