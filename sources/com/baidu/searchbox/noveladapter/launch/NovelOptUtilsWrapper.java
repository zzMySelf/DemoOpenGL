package com.baidu.searchbox.noveladapter.launch;

import com.baidu.launch.GcOptManager;
import com.baidu.searchbox.NoProGuard;

public class NovelOptUtilsWrapper implements NoProGuard {
    public static final int DEFAULT_OPT_STAGE = 0;
    public static final int DEFAULT_TOPIC_ID = 0;
    public static final int GC_OPT_NOVEL_DELAY = 5000;
    public static final int OPT_STAGE_40 = 1;
    public static final int OPT_STAGE_41 = 2;
    public static final int OPT_STAGE_42 = 4;
    public static final int OPT_STAGE_43 = 8;
    public static final int OPT_STAGE_45 = 16;
    public static final int OPT_STAGE_46 = 32;
    public static final int TOPIC_ID_NOVEL = 1;
    public static final int TOPIC_ID_PERF = 2;
    public static final int TOPIC_ID_VIDEO = 4;

    public static boolean isEnable(int topic, int stage) {
        return true;
    }

    public static void updateGcConfigGentle() {
        GcOptManager.updateGcConfigGentle();
    }

    public static void updateGcConfigViolence() {
        GcOptManager.updateGcConfigViolence();
    }
}
