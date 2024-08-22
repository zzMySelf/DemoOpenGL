package com.baidu.taskmanager;

import android.content.Context;

public interface ITaskManager {
    void registerTasks(Context context);

    void registerTasks(Context context, int i2, int i3);

    void requestPriorityScheduling(String str);

    void requestStopPriorityScheduling(String str);
}
