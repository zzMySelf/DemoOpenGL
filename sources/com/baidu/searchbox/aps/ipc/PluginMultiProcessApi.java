package com.baidu.searchbox.aps.ipc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.megapp.util.ProcessUtil;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.aps.base.db.PluginCache;
import com.baidu.searchbox.aps.center.install.api.PluginInstallCallback;
import com.baidu.searchbox.aps.center.install.api.PluginInstallManager;
import com.baidu.searchbox.aps.ipc.delegate.PluginInvokerDelegation;
import com.baidu.searchbox.aps.ipc.service.api.ApiResultCallback;
import com.baidu.searchbox.aps.ipc.service.api.task.PluginInstallTask;
import com.baidu.searchbox.aps.ipc.service.api.task.PluginVersionTask;
import com.baidu.searchbox.aps.ipc.service.base.ClientCallback;
import com.baidu.searchbox.aps.ipc.service.base.ClientHandler;
import com.baidu.searchbox.plugin.api.InvokeCallback;
import com.baidu.searchbox.plugin.api.InvokeListener;
import com.baidu.searchbox.plugin.api.PluginInvoker;

public class PluginMultiProcessApi implements NoProGuard {
    private static final String TAG = "PluginMultiProcessApi";

    private static class Holder {
        /* access modifiers changed from: private */
        public static final PluginMultiProcessApi INSTANCE = new PluginMultiProcessApi();

        private Holder() {
        }
    }

    public static PluginMultiProcessApi getInstance() {
        return Holder.INSTANCE;
    }

    public void startInstall(Context context, String packageName, final PluginInstallCallback callback) {
        if (context != null && !TextUtils.isEmpty(packageName)) {
            if (ProcessUtil.isMainProcess()) {
                PluginInstallManager.getInstance(context).startInstall(packageName, callback);
                return;
            }
            PluginInstallTask task = new PluginInstallTask();
            Bundle params = new Bundle();
            params.putString("package_name", packageName);
            task.setParams(params);
            ClientHandler.getInstance(context).executeTask(task, new ClientCallback() {
                public void onResult(Bundle result) {
                    int resultCode = result.getInt("code");
                    String extraInfo = result.getString("ext");
                    String packageName = result.getString("package_name");
                    PluginInstallCallback pluginInstallCallback = callback;
                    if (pluginInstallCallback != null) {
                        pluginInstallCallback.onResult(packageName, resultCode, extraInfo);
                    }
                }
            });
        }
    }

    public void getInstallVersion(Context context, String packageName, final ApiResultCallback<Long> callback) {
        if (context != null && callback != null && !TextUtils.isEmpty(packageName)) {
            if (ProcessUtil.isMainProcess()) {
                callback.onResult(Long.valueOf(PluginCache.getInstance(packageName).getInstallVersion(context)));
                return;
            }
            PluginVersionTask task = new PluginVersionTask();
            Bundle params = new Bundle();
            params.putString("package_name", packageName);
            task.setParams(params);
            ClientHandler.getInstance(context).executeTask(task, new ClientCallback() {
                public void onResult(Bundle result) {
                    callback.onResult(Long.valueOf(result.getLong("version")));
                }
            });
        }
    }

    public void invokePluginInSameTask(Context context, String packageName, String methodName, String from, String params, InvokeCallback callback) {
        if (ProcessUtil.isMainProcess()) {
            PluginInvoker.invokePluginInSameTask(context, packageName, methodName, from, params, callback, (InvokeListener[]) null);
        } else {
            PluginInvokerDelegation.invokePluginInSameTask(context, packageName, methodName, from, params, callback);
        }
    }
}
