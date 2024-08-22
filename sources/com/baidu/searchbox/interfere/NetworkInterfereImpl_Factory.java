package com.baidu.searchbox.interfere;

public class NetworkInterfereImpl_Factory {
    private static volatile NetworkInterfereImpl instance;

    private NetworkInterfereImpl_Factory() {
    }

    public static synchronized NetworkInterfereImpl get() {
        NetworkInterfereImpl networkInterfereImpl;
        synchronized (NetworkInterfereImpl_Factory.class) {
            if (instance == null) {
                instance = new NetworkInterfereImpl();
            }
            networkInterfereImpl = instance;
        }
        return networkInterfereImpl;
    }
}
