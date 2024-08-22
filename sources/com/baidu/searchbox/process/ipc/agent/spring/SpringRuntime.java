package com.baidu.searchbox.process.ipc.agent.spring;

import com.baidu.searchbox.shake.GlobalAppShakeImpl_Factory;

public class SpringRuntime {
    public static IAgentSpring getAgentSpring() {
        return GlobalAppShakeImpl_Factory.get();
    }
}
