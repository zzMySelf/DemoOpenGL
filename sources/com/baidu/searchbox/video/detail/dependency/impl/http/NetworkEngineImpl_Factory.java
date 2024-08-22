package com.baidu.searchbox.video.detail.dependency.impl.http;

public class NetworkEngineImpl_Factory {
    private static volatile NetworkEngineImpl instance;

    private NetworkEngineImpl_Factory() {
    }

    public static synchronized NetworkEngineImpl get() {
        NetworkEngineImpl networkEngineImpl;
        synchronized (NetworkEngineImpl_Factory.class) {
            if (instance == null) {
                instance = new NetworkEngineImpl();
            }
            networkEngineImpl = instance;
        }
        return networkEngineImpl;
    }
}
