package com.baidu.searchbox.goodsrender.interfaces;

import com.baidu.searchbox.goodsrender.impl.IAppInfoHelperImpl_Factory;
import com.baidu.searchbox.goodsrender.impl.IRouterHandlerImpl_Factory;

public class HostPluginAppRuntime {
    public static IRouterHandler getRouterHandler() {
        return IRouterHandlerImpl_Factory.get();
    }

    public static IAppInfoHelper getAppInfoService() {
        return IAppInfoHelperImpl_Factory.get();
    }
}
