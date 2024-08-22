package com.baidu.searchbox.ioc;

public class NadSearchLoftPositionImpl_Factory {
    private static volatile NadSearchLoftPositionImpl instance;

    private NadSearchLoftPositionImpl_Factory() {
    }

    public static synchronized NadSearchLoftPositionImpl get() {
        NadSearchLoftPositionImpl nadSearchLoftPositionImpl;
        synchronized (NadSearchLoftPositionImpl_Factory.class) {
            if (instance == null) {
                instance = new NadSearchLoftPositionImpl();
            }
            nadSearchLoftPositionImpl = instance;
        }
        return nadSearchLoftPositionImpl;
    }
}
