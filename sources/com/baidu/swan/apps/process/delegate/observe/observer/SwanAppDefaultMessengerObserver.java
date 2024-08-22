package com.baidu.swan.apps.process.delegate.observe.observer;

public abstract class SwanAppDefaultMessengerObserver extends SwanAppMessengerObserver {
    public boolean isDisposable() {
        return true;
    }

    public long getTimeoutMillis() {
        return 0;
    }
}
