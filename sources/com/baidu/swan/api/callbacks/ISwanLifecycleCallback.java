package com.baidu.swan.api.callbacks;

import com.baidu.swan.api.models.SwanAppLifecycleEvent;

public interface ISwanLifecycleCallback {
    void onAppExit(SwanAppLifecycleEvent swanAppLifecycleEvent);

    void onCloseApp(SwanAppLifecycleEvent swanAppLifecycleEvent);

    void onEvent(SwanAppLifecycleEvent swanAppLifecycleEvent);

    void onFullScreen(SwanAppLifecycleEvent swanAppLifecycleEvent);

    void onHalfScreen(SwanAppLifecycleEvent swanAppLifecycleEvent);

    void onHandleSwanExit(SwanAppLifecycleEvent swanAppLifecycleEvent);

    void onMostScreen(SwanAppLifecycleEvent swanAppLifecycleEvent);

    void onNightModeChanged(SwanAppLifecycleEvent swanAppLifecycleEvent);

    void onScreenClosed(SwanAppLifecycleEvent swanAppLifecycleEvent);

    void onTopPageActionBarColorChanged(SwanAppLifecycleEvent swanAppLifecycleEvent);
}
