package com.baidu.android.util.concurrent;

import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;

@Deprecated
public class ExecutorUtils {
    private ExecutorUtils() {
    }

    @Deprecated
    public static void postOnIO(Runnable r, String name) {
        ExecutorUtilsExt.postOnElastic(r, name, 2);
    }

    @Deprecated
    public static void postOnComputation(Runnable r, String name) {
        ExecutorUtilsExt.postOnElastic(r, name, 2);
    }

    @Deprecated
    public static String getStandardThreadName(String name) {
        String newName = null;
        if (name != null) {
            if (!name.startsWith("RxDeprecate_")) {
                newName = "RxDeprecate_" + name;
            } else {
                newName = name;
            }
        }
        if (newName == null) {
            newName = "RxDeprecate";
        }
        if (newName.length() > 256) {
            return newName.substring(0, 255);
        }
        return newName;
    }
}
