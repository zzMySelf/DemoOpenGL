package com.baidu.nps.interfa.manager;

import com.baidu.nps.interfa.INpsAbTestManager;
import com.baidu.searchbox.nps.impl.NpsAbTestManager_Factory;

public class NpsAbTestManager {
    public static INpsAbTestManager getAbTestManager() {
        return NpsAbTestManager_Factory.get();
    }
}
