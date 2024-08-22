package com.baidu.map.poitalos.modules;

import com.baidu.talos.core.context.IRuntimeContext;
import com.baidu.talos.core.module.ITalosModuleWrapper;
import com.baidu.talos.core.module.TalosNativeModule;

public class BMStatisticsModule$$ModuleWrapper implements ITalosModuleWrapper {
    public TalosNativeModule createModule(IRuntimeContext context) {
        return new BMStatisticsModule(context);
    }

    public Class getModuleClass() {
        return BMStatisticsModule.class;
    }
}
