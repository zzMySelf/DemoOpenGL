package com.baidu.searchbox.talos.modules;

import android.util.Log;
import com.baidu.assistant.model.interfaces.ModelManagerInterface;
import com.baidu.assistant.model.pyramd.ModelTalosInterface;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.talos.core.anno.TalosMethod;
import com.baidu.talos.core.anno.TalosModule;
import com.baidu.talos.core.context.IRuntimeContext;
import org.json.JSONObject;

@TalosModule(name = "AssistantTTSModule")
public final class Assistant3DModelTtsModule extends RNSearchBoxAbsModule {
    public static final String COMMANDID = "commandID";
    public static final String DATA = "data";
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String NAME = "AssistantTTSModule";
    public static final String TAG = "Model-TLSAssistantTTSModule";
    private IRuntimeContext mReactContext;

    public Assistant3DModelTtsModule(IRuntimeContext reactContext) {
        super(reactContext);
        this.mReactContext = reactContext;
    }

    public void initialize() {
    }

    public void destroy() {
    }

    @TalosMethod(thread = TalosMethod.Thread.BRIDGE, type = TalosMethod.Type.CALLBACK)
    public void assistantTTSNativeCallback(String cmd, String data, String pageId) {
        try {
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "receive talos cmd = " + cmd + " data =" + data + " pageId = " + pageId);
            }
            ModelManagerInterface managerInterface = ((ModelTalosInterface) ServiceManager.getService(ModelTalosInterface.SERVICE_REFERENCE)).getModelManager(pageId);
            if (managerInterface != null) {
                managerInterface.receiveTalosEvent(this.mReactContext.getApplicationContext(), cmd, data);
            } else if (z) {
                Log.d(TAG, "pageId不匹配 = " + pageId);
            }
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d(TAG, "assistantTTSNativeCallback Exception" + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    @TalosMethod(thread = TalosMethod.Thread.BRIDGE, type = TalosMethod.Type.CALLBACK)
    public void assistantBusinessNativeCallback(String cmd, String data, String pageId, String commandId) {
        try {
            boolean z = DEBUG;
            if (z) {
                Log.d(TAG, "receive assistantBusinessNativeCallback cmd = " + cmd + " data =" + data + " cmd = " + cmd);
            }
            ModelManagerInterface managerInterface = ((ModelTalosInterface) ServiceManager.getService(ModelTalosInterface.SERVICE_REFERENCE)).getModelManager(pageId);
            if (managerInterface != null) {
                JSONObject info = new JSONObject();
                info.put("data", data);
                info.put(COMMANDID, commandId);
                managerInterface.receiveTalosEvent(this.mReactContext.getApplicationContext(), cmd, info.toString());
            } else if (z) {
                Log.d(TAG, "pageId不匹配 = " + pageId);
            }
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d(TAG, "assistantTTSNativeCallback Exception" + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }
}
