package com.baidu.talos.core.modules.device;

import android.bluetooth.BluetoothAdapter;
import android.media.AudioManager;
import com.baidu.talos.core.anno.TalosMethod;
import com.baidu.talos.core.anno.TalosModule;
import com.baidu.talos.core.callback.Promise;
import com.baidu.talos.core.context.IRuntimeContext;
import com.baidu.talos.core.data.ParamMap;
import com.baidu.talos.core.data.ParamMapImpl;
import com.baidu.talos.core.module.TalosNativeModule;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\b\u0010\u000e\u001a\u00020\fH\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/talos/core/modules/device/DeviceModule;", "Lcom/baidu/talos/core/module/TalosNativeModule;", "context", "Lcom/baidu/talos/core/context/IRuntimeContext;", "(Lcom/baidu/talos/core/context/IRuntimeContext;)V", "destroy", "", "initialize", "isBluetoothHeadSetIn", "promise", "Lcom/baidu/talos/core/callback/Promise;", "isBluetoothHeadSetInSync", "Lcom/baidu/talos/core/data/ParamMap;", "isHeadphonesPluggedIn", "isHeadphonesPluggedInSync", "lib-talos-modules_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@TalosModule(name = "Device")
/* compiled from: DeviceModule.kt */
public final class DeviceModule extends TalosNativeModule {
    private final IRuntimeContext context;

    public DeviceModule(IRuntimeContext context2) {
        super(context2);
        this.context = context2;
    }

    public void initialize() {
    }

    public void destroy() {
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    @TalosMethod(thread = TalosMethod.Thread.JS, type = TalosMethod.Type.SYNC)
    public final ParamMap isHeadphonesPluggedInSync() {
        ParamMapImpl paramMap = new ParamMapImpl();
        boolean curHeadsetConnect = false;
        try {
            Object systemService = this.mContext.getApplicationContext().getSystemService("audio");
            if (systemService != null) {
                curHeadsetConnect = ((AudioManager) systemService).isWiredHeadsetOn();
                paramMap.putBoolean("isPluggedIn", curHeadsetConnect);
                return paramMap;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
        } catch (Throwable e2) {
            e2.printStackTrace();
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    @TalosMethod(thread = TalosMethod.Thread.BRIDGE, type = TalosMethod.Type.PROMISE)
    public final void isHeadphonesPluggedIn(Promise promise) {
        ParamMapImpl paramMap = new ParamMapImpl();
        boolean curHeadsetConnect = false;
        try {
            Object systemService = this.mContext.getApplicationContext().getSystemService("audio");
            if (systemService != null) {
                curHeadsetConnect = ((AudioManager) systemService).isWiredHeadsetOn();
                paramMap.putBoolean("isPluggedIn", curHeadsetConnect);
                if (promise != null) {
                    promise.resolve(paramMap);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
        } catch (Throwable e2) {
            e2.printStackTrace();
        }
    }

    @TalosMethod(thread = TalosMethod.Thread.JS, type = TalosMethod.Type.SYNC)
    public final ParamMap isBluetoothHeadSetInSync() {
        ParamMapImpl paramMap = new ParamMapImpl();
        boolean curBluetoothHeadsetConnect = false;
        try {
            BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
            boolean z = true;
            if (adapter == null) {
                z = false;
            } else if (adapter.getProfileConnectionState(1) != 2) {
                z = false;
            }
            curBluetoothHeadsetConnect = z;
        } catch (Throwable e2) {
            e2.printStackTrace();
        }
        paramMap.putBoolean("isPluggedIn", curBluetoothHeadsetConnect);
        return paramMap;
    }

    @TalosMethod(thread = TalosMethod.Thread.BRIDGE, type = TalosMethod.Type.PROMISE)
    public final void isBluetoothHeadSetIn(Promise promise) {
        ParamMapImpl paramMap = new ParamMapImpl();
        boolean curBluetoothHeadsetConnect = false;
        try {
            BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
            boolean z = true;
            if (adapter == null) {
                z = false;
            } else if (adapter.getProfileConnectionState(1) != 2) {
                z = false;
            }
            curBluetoothHeadsetConnect = z;
        } catch (Throwable e2) {
            e2.printStackTrace();
        }
        paramMap.putBoolean("isPluggedIn", curBluetoothHeadsetConnect);
        if (promise != null) {
            promise.resolve(paramMap);
        }
    }
}
