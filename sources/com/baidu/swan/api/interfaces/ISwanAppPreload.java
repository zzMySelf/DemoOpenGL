package com.baidu.swan.api.interfaces;

import android.content.Context;
import android.os.Bundle;

public interface ISwanAppPreload {
    public static final String EXTRA_KEY_PRELOAD_DELAY = "bundle_key_preload_delay";
    public static final String EXTRA_KEY_PRELOAD_PRELOAD_SCENE = "bundle_key_preload_preload_scene";
    public static final String WORD_COMMAND_FLAG = "type=smartProgram";

    public interface DownloadScene {
        public static final String PERSONAL_CENTER = "9";
        public static final String SECOND_FLOOR = "8";
        public static final String SILENT_SECOND_FLOOR = "4";
    }

    public interface LoadEnvScene {
        public static final String BY_LAUNCH = "0";
        public static final String BY_PERSONAL_CENTER = "3";
        public static final String BY_SECOND_FLOOR = "4";
        public static final String BY_SMART_TASK = "7";
    }

    void executeSwanLaunchTask(Bundle bundle);

    void handlePreloadSwanApp();

    boolean isSwanScheme(String str);

    void preDownloadSwanAppsByScene(String str);

    void prefetchAppData(String str, String str2);

    void prefetchCardData(String str, String str2, String str3);

    void startSwanRuntimeEnvironment(Context context, Bundle bundle);
}
