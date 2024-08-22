package com.baidu.swan.apps.core.prelink.strategy;

public class EnhanceStrategy extends LocalLruStrategy {
    private static final int INTERVAL = 30;

    public EnhanceStrategy() {
        super(30);
    }
}
