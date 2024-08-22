package com.baidu.swan.apps.performance.template.interfaces;

public interface ISwanLaunchTrigger {
    void consumeTask(Runnable runnable, String str);

    String getName();

    void triggerDestroy();

    void triggerFcp(String str);

    void triggerFmp(boolean z);

    void triggerLaunch(String str);
}
