package com.baidu.searchbox.ioc;

public class NadActiveRecommendRequestImpl_Factory {
    private static volatile NadActiveRecommendRequestImpl instance;

    private NadActiveRecommendRequestImpl_Factory() {
    }

    public static synchronized NadActiveRecommendRequestImpl get() {
        NadActiveRecommendRequestImpl nadActiveRecommendRequestImpl;
        synchronized (NadActiveRecommendRequestImpl_Factory.class) {
            if (instance == null) {
                instance = new NadActiveRecommendRequestImpl();
            }
            nadActiveRecommendRequestImpl = instance;
        }
        return nadActiveRecommendRequestImpl;
    }
}
