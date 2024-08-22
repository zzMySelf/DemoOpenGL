package com.baidu.talos.core.modules.core;

import android.net.Uri;
import com.baidu.talos.core.anno.TalosMethod;
import com.baidu.talos.core.anno.TalosModule;
import com.baidu.talos.core.context.IRuntimeContext;
import com.baidu.talos.core.data.ParamMap;
import com.baidu.talos.core.data.ParamMapImpl;
import com.baidu.talos.core.module.TalosNativeModule;
import com.baidu.talos.core.render.events.TalosEventEmitter;
import com.baidu.talos.util.UiThreadUtil;

@TalosModule(name = "DeviceEventManager")
public class DeviceEventManagerModule extends TalosNativeModule {
    private final Runnable mInvokeDefaultBackPressRunnable;

    public DeviceEventManagerModule(IRuntimeContext context, final DefaultHardwareBackBtnHandler backBtnHandler) {
        super(context);
        this.mInvokeDefaultBackPressRunnable = new Runnable() {
            public void run() {
                UiThreadUtil.assertOnUiThread();
                backBtnHandler.invokeDefaultOnBackPressed();
            }
        };
    }

    public void initialize() {
    }

    public void destroy() {
    }

    public void emitHardwareBackPressed() {
        ((TalosEventEmitter) this.mContext.getModuleManager().getJavaScriptModule(TalosEventEmitter.class)).emit("hardwareBackPress", (Object) null);
    }

    public void emitNewIntentReceived(Uri uri) {
        ParamMap map = new ParamMapImpl();
        map.putString("url", uri.toString());
        ((TalosEventEmitter) this.mContext.getModuleManager().getJavaScriptModule(TalosEventEmitter.class)).emit("url", map);
    }

    @TalosMethod(thread = TalosMethod.Thread.BRIDGE, type = TalosMethod.Type.CALLBACK)
    public void invokeDefaultBackPressHandler() {
        UiThreadUtil.runOnUiThread(this.mInvokeDefaultBackPressRunnable);
    }
}
