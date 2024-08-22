package com.baidu.searchbox.feed.event;

import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.launch.task.UniTask;
import com.baidu.searchbox.launch.task.UniTaskBuilder;
import com.baidu.searchbox.launch.task.UniTaskManager;

public class OnFeedUIReadyEvent {
    public static final int SCENE_HOT_LAUNCH = 2;
    public static final int SCENE_WITHOUT_REFRESH = 0;
    public static final int SCENE_WITH_REFRESH = 1;
    public int scene;

    public OnFeedUIReadyEvent(int scene2) {
        this.scene = scene2;
    }

    public static void registerLaunchFeedUIReadyEventTasks() {
        UniTask task = UniTaskBuilder.createImmediateUniTask(new Runnable() {
            public void run() {
                BdEventBus.Companion.getDefault().post(new OnFeedUIReadyEvent(1));
            }
        }, "feedUIReadyEvent", true);
        UniTaskManager.getInstance().registerLaunchTasks(task);
    }
}
