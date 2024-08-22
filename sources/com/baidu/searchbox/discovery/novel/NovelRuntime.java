package com.baidu.searchbox.discovery.novel;

import android.content.Context;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.novel.NovelContext_Factory;

public class NovelRuntime {
    public static boolean DEBUG = AppConfig.isDebug();
    public static final String INTENT_FRAGMENT_NAME_KEY = "invoke_fragment";
    public static final String PROTOCOL_NOVEL_NAME = "DiscoveryNovelHomeFragment";

    static {
        com.baidu.searchbox.environment.runtime.NovelRuntime.initNovelPath();
    }

    public static Context getAppContext() {
        return com.baidu.searchbox.environment.runtime.NovelRuntime.getAppContext();
    }

    public static String getNovelSDPath() {
        return com.baidu.searchbox.environment.runtime.NovelRuntime.getNovelSDPath();
    }

    public static INovelContext getNovelContext() {
        return NovelContext_Factory.get();
    }
}
