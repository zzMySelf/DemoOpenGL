package com.baidu.searchbox.feed.dependency.iocimpl;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.aps.base.db.PluginCache;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.ioc.IFeedAps;
import com.baidu.searchbox.feed.ioc.aps.InvokeListenerBridge;
import com.baidu.searchbox.feed.ioc.aps.LoadContextCallbackBridge;
import com.baidu.searchbox.feed.ioc.aps.ObjectInvokeCallbackBridge;
import com.baidu.searchbox.plugin.api.InvokeListener;
import com.baidu.searchbox.plugin.api.ObjectInvokeCallback;
import com.baidu.searchbox.plugin.api.PluginInvoker;
import java.util.ArrayList;
import java.util.List;

public class FeedApsImpl implements IFeedAps {
    public void invokePlugin(Context context, String packageName, String methodName, String from, String params, LoadContextCallbackBridge loadContextCallbackBridge, ObjectInvokeCallbackBridge objectInvokeCallbackBridge, InvokeListenerBridge[] invokeListenerBridge, int var, Object[] options) {
        ObjectInvokeCallback objectInvokeCallback = getObjectInvokeCallback(objectInvokeCallbackBridge);
        PluginInvoker.invokePlugin(context, packageName, methodName, from, params, getLoadContextCallback(loadContextCallbackBridge), objectInvokeCallback, getInvokeListenerArray(invokeListenerBridge), var, options);
    }

    public boolean isPluginInstall(String packageName) {
        if (!TextUtils.isEmpty(packageName) && PluginCache.getInstance(packageName).getInstallVersion(AppRuntime.getAppContext()) >= 0) {
            return true;
        }
        return false;
    }

    private ObjectInvokeCallback getObjectInvokeCallback(final ObjectInvokeCallbackBridge objectInvokeCallbackBridge) {
        if (objectInvokeCallbackBridge != null) {
            return new ObjectInvokeCallback() {
                public void onResult(int i2, Object[] objects) {
                    objectInvokeCallbackBridge.onResult(i2, objects);
                }

                public void onResult(int i2, String s) {
                    objectInvokeCallbackBridge.onResult(i2, s);
                }
            };
        }
        return null;
    }

    private InvokeListener[] getInvokeListenerArray(InvokeListenerBridge[] invokeListenerBridges) {
        if (invokeListenerBridges == null) {
            return null;
        }
        List<InvokeListener> invokeListenerList = new ArrayList<>();
        for (final InvokeListenerBridge invokeListenerBridge : invokeListenerBridges) {
            invokeListenerList.add(new InvokeListener() {
                public String onExecute(String s) {
                    return invokeListenerBridge.onExecute(s);
                }
            });
        }
        return (InvokeListener[]) invokeListenerList.toArray(new InvokeListener[0]);
    }

    private PluginInvoker.LoadContextCallback getLoadContextCallback(final LoadContextCallbackBridge loadContextCallbackBridge) {
        if (loadContextCallbackBridge != null) {
            return new PluginInvoker.LoadContextCallback() {
                public void onCallback() {
                    loadContextCallbackBridge.onCallback();
                }
            };
        }
        return null;
    }
}
