package com.baidu.map.poitalos.modules;

import com.baidu.map.poitalos.event.TalosH5ToNaEvent;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.talos.core.anno.TalosMethod;
import com.baidu.talos.core.anno.TalosModule;
import com.baidu.talos.core.callback.Promise;
import com.baidu.talos.core.context.IRuntimeContext;
import com.baidu.talos.core.data.ParamMap;
import com.baidu.talos.core.module.TalosAutoRegNativeModule;

@TalosModule(name = "BMTLSEvent")
public class BMEventModule extends TalosAutoRegNativeModule implements NoProGuard {
    public BMEventModule(IRuntimeContext reactContext) {
        super(reactContext);
    }

    public void initialize() {
    }

    public void destroy() {
    }

    @TalosMethod(thread = TalosMethod.Thread.MAIN, type = TalosMethod.Type.PROMISE)
    public void sendEvent(String pageId, String event, ParamMap data, Promise promise) {
        BdEventBus.Companion.getDefault().post(new TalosH5ToNaEvent(pageId, event, data, promise));
    }
}
