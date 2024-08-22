package com.baidu.searchbox.launch.task;

import android.text.TextUtils;

public class UniTaskBuilder {
    public static UniTask createUniTask(Runnable runnable, int taskType, String taskName, boolean isInUiThread) {
        return createUniTask(runnable, taskType, taskName, isInUiThread, "", "");
    }

    public static UniTask createUniTask(Runnable runnable, int taskType, String taskName, boolean isInUiThread, String context, String topic) {
        final boolean z = isInUiThread;
        final int i2 = taskType;
        final Runnable runnable2 = runnable;
        final String str = taskName;
        final String str2 = context;
        final String str3 = topic;
        return new UniTask() {
            public boolean isInUiThread() {
                return z;
            }

            public int getType() {
                return i2;
            }

            public void execute() {
                Runnable runnable = runnable2;
                if (runnable != null) {
                    runnable.run();
                }
            }

            public String getName() {
                return str;
            }

            public String getContext() {
                if (TextUtils.isEmpty(str2)) {
                    return super.getContext();
                }
                return str2;
            }

            public String getTopic() {
                if (TextUtils.isEmpty(str3)) {
                    return super.getTopic();
                }
                return str3;
            }
        };
    }

    public static UniTask createIdleUniTask(Runnable runnable, String taskName, boolean isInUiThread) {
        return createUniTask(runnable, 1, taskName, isInUiThread);
    }

    public static UniTask createImmediateUniTask(Runnable runnable, String taskName, boolean isInUiThread) {
        return createUniTask(runnable, 0, taskName, isInUiThread);
    }
}
