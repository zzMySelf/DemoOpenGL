package com.baidu.searchbox.aps.base.callback.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import com.baidu.searchbox.aps.base.callback.ProcessCallback;

public class ProcessCallbackImpl extends ProcessCallback {
    public void onStartHandleExceptionInOtherProcess() {
    }

    /* access modifiers changed from: protected */
    public Object serializeObjectInHost(Object object) {
        return null;
    }

    public boolean isSerializableInHost(Object object) {
        return false;
    }

    public void onHandleCompatibleInHost(int managerId, String methodName, Class<?>[] clsArr, Object[] parameters, String from) {
    }

    public void onPluginActivityCreated(Activity activity, Bundle savedInstanceState, boolean isMainProcess) {
    }

    public void onPluginActivityStarted(Activity activity, boolean isMainProcess) {
    }

    public void onPluginActivityResumed(Activity activity, boolean isMainProcess) {
    }

    public void onPluginActivityPaused(Activity activity, boolean isMainProcess) {
    }

    public void onPluginActivityStopped(Activity activity, boolean isMainProcess) {
    }

    public void onPluginActivitySaveInstanceState(Activity activity, Bundle bundle, boolean isMainProcess) {
    }

    public void onPluginActivityDestroyed(Activity activity, boolean isMainProcess) {
    }

    /* access modifiers changed from: protected */
    public Intent getRestartAppIntentInHost(String pluginPackageName) {
        return null;
    }

    public void onRestartAppBefore(String pluginPackageName) {
    }

    /* access modifiers changed from: protected */
    public Object deserializeIBinderInHost(IInterface iInterface) {
        return null;
    }

    /* access modifiers changed from: protected */
    public Object deserializeNotIBinderInHost(Object object) {
        return null;
    }

    public boolean isIBinderDeserializableInHost(IInterface iInterface) {
        return false;
    }

    public boolean isNotIBinderDeserializableInHost(Object object) {
        return false;
    }
}
