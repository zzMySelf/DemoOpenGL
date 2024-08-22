package com.baidu.searchbox.talos.lite.impl.ioc;

public class TalosLiteQRCode_Factory {
    private static volatile TalosLiteQRCode instance;

    private TalosLiteQRCode_Factory() {
    }

    public static synchronized TalosLiteQRCode get() {
        TalosLiteQRCode talosLiteQRCode;
        synchronized (TalosLiteQRCode_Factory.class) {
            if (instance == null) {
                instance = new TalosLiteQRCode();
            }
            talosLiteQRCode = instance;
        }
        return talosLiteQRCode;
    }
}
