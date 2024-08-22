package com.baidu.swan.apps.impl.account;

public class RebateInfoManager_Factory {
    private static volatile RebateInfoManager instance;

    private RebateInfoManager_Factory() {
    }

    public static synchronized RebateInfoManager get() {
        RebateInfoManager rebateInfoManager;
        synchronized (RebateInfoManager_Factory.class) {
            if (instance == null) {
                instance = new RebateInfoManager();
            }
            rebateInfoManager = instance;
        }
        return rebateInfoManager;
    }
}
