package com.baidu.searchbox.talos.lite.impl.ioc;

public class TalosLiteRouter_Factory {
    private static volatile TalosLiteRouter instance;

    private TalosLiteRouter_Factory() {
    }

    public static synchronized TalosLiteRouter get() {
        TalosLiteRouter talosLiteRouter;
        synchronized (TalosLiteRouter_Factory.class) {
            if (instance == null) {
                instance = new TalosLiteRouter();
            }
            talosLiteRouter = instance;
        }
        return talosLiteRouter;
    }
}
