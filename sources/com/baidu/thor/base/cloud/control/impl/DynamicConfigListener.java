package com.baidu.thor.base.cloud.control.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.thor.base.ThorConfig;
import com.baidu.thor.base.ThorKV;
import com.baidu.thor.common.ThorConstant;
import com.baidu.thor.downloader.IProcessListener;
import com.baidu.thor.downloader.PMSManagerHelper;
import com.baidu.thor.sdk.manager.ioc.IThorConfig;
import com.baidu.thor.sdk.manager.ioc.PluginFuncInfo;
import com.baidu.thor.sdk.manager.ioc.impl.ThorConfigManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicConfigListener extends JSONObjectCommandListener {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "DynamicConfigListener";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (!TextUtils.isEmpty(module) && !TextUtils.isEmpty(action)) {
            Log.i(TAG, "post data.action: " + action);
            if (postData != null && postData.getVersion() != null) {
                postData.getVersion().put(action, getLocalVersion(context, module, action));
            }
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        JSONArray jsonArray;
        final String str = action;
        ActionData<JSONObject> actionData = value;
        if (actionData != null && actionData.data != null && !TextUtils.isEmpty(module)) {
            if (!TextUtils.isEmpty(action)) {
                if (DEBUG) {
                    Log.d(TAG, "executeCommand start: " + ((JSONObject) actionData.data).toString());
                }
                final String version = actionData.version;
                JSONObject data = (JSONObject) actionData.data;
                if (TextUtils.isEmpty(version) || data == null || data.length() == 0) {
                    return true;
                } else if (getLocalVersion(context, module, action).equals(version) || (jsonArray = data.optJSONArray("thor_plugin_funcs")) == null) {
                    return false;
                } else {
                    HashMap<String, PluginFuncInfo> pluginFuncInfos = new HashMap<>();
                    long now = System.currentTimeMillis() / 1000;
                    for (int i2 = 0; i2 < jsonArray.length(); i2++) {
                        JSONObject jo = null;
                        try {
                            jo = jsonArray.getJSONObject(i2);
                            if (jo != null) {
                                String expiredTime = jo.optString("expired_time");
                                if (TextUtils.isEmpty(expiredTime) || now <= Long.valueOf(expiredTime).longValue()) {
                                    jo.put(ThorConstant.PLUGIN_FUNC_VERSION_TIME, version);
                                    PluginFuncInfo pluginFuncInfo = new PluginFuncInfo(jo);
                                    if (!TextUtils.isEmpty(pluginFuncInfo.getPluginFuncName())) {
                                        pluginFuncInfos.put(pluginFuncInfo.getPluginFuncName(), pluginFuncInfo);
                                    }
                                } else if (DEBUG) {
                                    Log.i(TAG, "Func config is expired.");
                                }
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    boolean thorEnabled = ThorKV.getInstance().getBooleanWrapper("thor_config", "thor_enable", false);
                    ThorConfig thorConfig = new ThorConfig(1, thorEnabled, pluginFuncInfos);
                    if (!thorEnabled) {
                        ThorConfigManager.getInstance().updateConfig(thorConfig);
                        ThorConfigManager.getInstance().refreshConfig();
                        ThorKV.getInstance().putStringWrapper(str, "version", version);
                        return true;
                    }
                    PMSManagerHelper.getInstance().process(thorConfig, new IProcessListener() {
                        public void onProcessSuccess(IThorConfig config) {
                            if (DynamicConfigListener.DEBUG) {
                                Log.i(DynamicConfigListener.TAG, "process success. " + (config == null ? "" : config.getPluginFuncInfos()));
                            }
                            ThorConfigManager.getInstance().updateConfig(config);
                            ThorConfigManager.getInstance().refreshConfig();
                            ThorKV.getInstance().putStringWrapper(str, "version", version);
                        }

                        public void onProcessError(IThorConfig config, String errorMsg) {
                            HashMap<String, PluginFuncInfo> infos;
                            if (DynamicConfigListener.DEBUG) {
                                Log.i(DynamicConfigListener.TAG, "process error: " + errorMsg);
                            }
                            if (config != null && (infos = config.getPluginFuncInfos()) != null && !infos.isEmpty()) {
                                Set<String> pkgNames = new HashSet<>();
                                for (PluginFuncInfo info : infos.values()) {
                                    if (info != null && !TextUtils.isEmpty(info.getPluginPackageName())) {
                                        pkgNames.add(info.getPluginPackageName());
                                    }
                                }
                                for (String packageName : pkgNames) {
                                    PMSManagerHelper.getInstance().resetPMSInfo(packageName);
                                }
                            }
                        }
                    });
                    if (!DEBUG) {
                        return true;
                    }
                    Log.d(TAG, "executeCommand end.");
                    return true;
                }
            }
        }
        return false;
    }

    public String getLocalVersion(Context context, String module, String action) {
        if (TextUtils.isEmpty(module) || TextUtils.isEmpty(action)) {
            return "0";
        }
        return ThorKV.getInstance().getStringWrapper(action, "version", "0");
    }
}
