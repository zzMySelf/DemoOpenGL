package com.baidu.swan.apps.util;

import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;

public class SwanAppThreadUtils {
    public static final int BACKGROUND = 3;
    public static final int IMMEDIATE = 0;
    public static final int INTIME = 2;
    public static final int SERIAL = 4;
    public static final int USER_RELATED = 1;

    public static void postOnElastic(Runnable r, String taskName, int priority) {
        ExecutorUtilsExt.postOnElastic(r, taskName, priority);
    }
}
