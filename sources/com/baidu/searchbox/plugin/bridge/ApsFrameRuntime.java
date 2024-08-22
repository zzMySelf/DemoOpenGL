package com.baidu.searchbox.plugin.bridge;

import com.baidu.searchbox.bridge.ApsFrameImpl_Factory;
import com.baidu.searchbox.plugins.bridge.IApsFrameUtilImpl_Factory;

public class ApsFrameRuntime {
    public static IApsFrameInterface getApsFrameInterface() {
        return ApsFrameImpl_Factory.get();
    }

    public static IApsFrameUtilsInterface getApsFrameUtilsInterface() {
        return IApsFrameUtilImpl_Factory.get();
    }
}
