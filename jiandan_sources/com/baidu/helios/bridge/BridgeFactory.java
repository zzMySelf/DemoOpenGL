package com.baidu.helios.bridge;

public class BridgeFactory {
    public BridgeProvider qw;

    public interface BridgeProvider {
        BaseBridge qw();
    }

    public BridgeFactory(BridgeProvider bridgeProvider) {
        this.qw = bridgeProvider;
    }

    public BaseBridge qw() {
        return this.qw.qw();
    }
}
