package com.baidu.swan.apps.impl.ioc.impl;

public class SwanMemoryMonitor_Factory {
    private static volatile SwanMemoryMonitor instance;

    private SwanMemoryMonitor_Factory() {
    }

    public static synchronized SwanMemoryMonitor get() {
        SwanMemoryMonitor swanMemoryMonitor;
        synchronized (SwanMemoryMonitor_Factory.class) {
            if (instance == null) {
                instance = new SwanMemoryMonitor();
            }
            swanMemoryMonitor = instance;
        }
        return swanMemoryMonitor;
    }
}
