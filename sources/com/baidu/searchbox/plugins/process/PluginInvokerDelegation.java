package com.baidu.searchbox.plugins.process;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.plugin.api.InvokeCallback;
import com.baidu.searchbox.plugin.api.InvokeListener;
import com.baidu.searchbox.plugin.api.PluginInvoker;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.activity.PluginBaseDelegation;

public class PluginInvokerDelegation extends PluginBaseDelegation {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String PARAMS = "params";
    public static final String PARAMS_FORM = "from";
    public static final String PARAMS_METHOD_NAME = "method_name";
    public static final String PARAMS_PACKAGE_NAME = "package_name";
    public static final String RESULT_CODE = "status_code";
    public static final String RESULT_DATA = "params";
    private static final String TAG = "PluginInvokerDelegation";
    public String mPackageName;

    public String getPluginPackageName() {
        return this.mPackageName;
    }

    /* access modifiers changed from: protected */
    public boolean onExec() {
        if (DEBUG) {
            Log.d(TAG, "onExec params:" + this.mParams);
        }
        if (this.mParams.isEmpty()) {
            return false;
        }
        this.mPackageName = this.mParams.getString("package_name");
        String methodName = this.mParams.getString("method_name");
        String from = this.mParams.getString("from");
        PluginInvoker.invokePluginInSameTask((Context) getAgent(), this.mPackageName, methodName, from, this.mParams.getString("params"), new InvokeCallback() {
            public void onResult(int statusCode, String result) {
                if (PluginInvokerDelegation.DEBUG) {
                    Log.d(PluginInvokerDelegation.TAG, "statusCode: " + statusCode + " ,result:" + result);
                }
                PluginInvokerDelegation.this.mResult.putInt("status_code", statusCode);
                PluginInvokerDelegation.this.mResult.putString("params", result);
                PluginInvokerDelegation.this.finish();
            }
        }, (InvokeListener[]) null);
        return false;
    }

    public void onAgentDestroy() {
        PluginInvoker.removeStartContext(getPluginPackageName());
    }

    private static Bundle createExecParams(String packageName, String methodName, String from, String params) {
        Bundle bundle = new Bundle();
        bundle.putString("package_name", packageName);
        bundle.putString("method_name", methodName);
        bundle.putString("from", from);
        bundle.putString("params", params);
        return bundle;
    }

    public static void invokePluginInSameTask(Context context, String packageName, String methodName, String from, String params, final InvokeCallback callback) {
        if (context instanceof Activity) {
            DelegateUtils.callOnMainWithActivity((Activity) context, PluginDelegateActivity.class, PluginInvokerDelegation.class, createExecParams(packageName, methodName, from, params), new DelegateListener() {
                public void onDelegateCallBack(DelegateResult result) {
                    int statusCode = result.mResult.getInt("status_code");
                    String params = result.mResult.getString("params");
                    if (PluginInvokerDelegation.DEBUG) {
                        Log.d(PluginInvokerDelegation.TAG, "result: " + statusCode + " params: " + params);
                    }
                    InvokeCallback.this.onResult(statusCode, params);
                }
            });
        }
    }
}
