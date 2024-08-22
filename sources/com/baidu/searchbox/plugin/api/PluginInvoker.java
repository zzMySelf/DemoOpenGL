package com.baidu.searchbox.plugin.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.megapp.APSClassLoader;
import com.baidu.megapp.ProxyEnvironment;
import com.baidu.megapp.api.INewGetClassLoaderCallback;
import com.baidu.megapp.api.INewGetContextCallBack;
import com.baidu.megapp.api.INewTargetLoadedCallBack;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.megapp.ma.MAApplication;
import com.baidu.megapp.pm.MAPackageManager;
import com.baidu.megapp.util.MegUtils;
import com.baidu.megapp.util.Util;
import com.baidu.searchbox.aps.base.PluginManager;
import com.baidu.searchbox.aps.base.callback.CallbackController;
import com.baidu.searchbox.aps.base.callback.ProcessCallback;
import com.baidu.searchbox.aps.base.db.PluginCache;
import com.baidu.searchbox.aps.base.utils.ApsThreadUtils;
import com.baidu.searchbox.aps.base.utils.BaseConfiger;
import com.baidu.searchbox.aps.center.activator.TargetActivatorProxy;
import com.baidu.searchbox.aps.invoker.callback.InvokerCallback;
import com.baidu.searchbox.aps.invoker.callback.InvokerCallbackController;
import com.baidu.searchbox.aps.invoker.process.PluginInvokerInterface;
import com.baidu.searchbox.aps.invoker.process.PluginProcessManager;
import com.baidu.searchbox.aps.invoker.process.PluginUtility;
import com.baidu.searchbox.aps.invoker.process.ProcessController;
import com.baidu.searchbox.aps.invoker.statistic.PluginSpeedStatisticHelper;
import com.baidu.searchbox.aps.invoker.statistic.PluginStatistic;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class PluginInvoker {
    public static final String IMPL_CLASS_NAME = ".PluginInvoker";
    private static final String TAG = "PluginInvoker";
    private static MAActivity.ActivityLifecycleCallbacks sActivityLifeCallbacks;

    public interface LoadContextCallback {
        void onCallback();
    }

    private PluginInvoker() {
    }

    /* access modifiers changed from: private */
    public static Context getAppContext() {
        return PluginManager.getAppContext();
    }

    /* access modifiers changed from: private */
    public static boolean isMainProcess() {
        return PluginManager.isMainProcess();
    }

    /* access modifiers changed from: private */
    public static int getProcessIndex() {
        return PluginManager.getProcessIndex();
    }

    public static boolean supportMultiProcess() {
        InvokerCallback callback = getInvokerCallback();
        boolean z = true;
        boolean support = callback != null && callback.supportMultiProcess();
        if (support) {
            z = false;
        }
        MegUtils.setMultiProcessDebug(z);
        return support;
    }

    public static ProcessCallback getProcessCallback() {
        return CallbackController.getInstance(getAppContext()).getProcessCallback();
    }

    public static InvokerCallback getInvokerCallback() {
        return InvokerCallbackController.getInstance(getAppContext()).getInvokerCallback();
    }

    public static void invokePlugin(Context context, String packageName, String methodName, String from, String params, InvokeCallback callback, InvokeListener[] listeners) {
        Util.removeStartContext(packageName);
        invokePlugin(context, packageName, methodName, from, params, (LoadContextCallback) null, callback, listeners, 286261248, (Object[]) null);
    }

    public static void invokePluginBySwan(Context context, String packageName, String methodName, String from, String params, InvokeCallback callback, InvokeListener[] listeners) {
        Context context2 = context;
        if (context2 instanceof Activity) {
            String str = packageName;
            Util.setStartContext(packageName, (Activity) context2);
        } else {
            String str2 = packageName;
        }
        invokePlugin(context, packageName, methodName, from, params, (LoadContextCallback) null, callback, listeners, 286261248, (Object[]) null);
    }

    public static void invokePluginInSameTask(Context context, String packageName, String methodName, String from, String params, InvokeCallback callback, InvokeListener[] listeners) {
        Context context2 = context;
        if (context2 instanceof Activity) {
            String str = packageName;
            Util.setStartContext(packageName, (Activity) context2);
        } else {
            String str2 = packageName;
        }
        invokePlugin(context, packageName, methodName, from, params, (LoadContextCallback) null, callback, listeners, 286261248, (Object[]) null);
    }

    public static void invokePluginWithHostContext(Context context, String packageName, String methodName, String from, String params, InvokeCallback callback, InvokeListener[] listeners, int flag, Object[] options) {
        if (isMainProcess()) {
            handleLoadAndGetClassloaderInInvokePlugin(getAppContext(), PluginCache.getInstance(packageName).isInstallInvokeMethod(getAppContext(), methodName), packageName, methodName, from, params, callback, listeners, flag, options, true);
            return;
        }
        String str = methodName;
    }

    private static class OrganizedInvokeCallback extends ObjectInvokeCallback {
        private InvokeCallback mCallback;
        private Object[] mOptions;
        private String mPackageName;

        OrganizedInvokeCallback(String packageName, Object[] options, InvokeCallback callback) {
            this.mPackageName = packageName;
            this.mOptions = options;
            this.mCallback = callback;
            if (callback != null && (callback instanceof ObjectInvokeCallback)) {
                this.objects = ((ObjectInvokeCallback) callback).objects;
            }
        }

        public void onResult(int statusCode, String result) {
            if (PluginInvoker.isMainProcess() && statusCode == -4 && this.mOptions != null && !TextUtils.isEmpty(this.mPackageName)) {
                TargetActivatorProxy.handleOpenFailedInPlugin(this.mPackageName, this.mOptions);
            }
            InvokeCallback invokeCallback = this.mCallback;
            if (invokeCallback != null) {
                invokeCallback.onResult(statusCode, result);
            }
        }

        public void onResult(int statusCode, Object[] result) {
            InvokeCallback invokeCallback = this.mCallback;
            if (invokeCallback != null && (invokeCallback instanceof ObjectInvokeCallback)) {
                ((ObjectInvokeCallback) invokeCallback).onResult(statusCode, result);
            }
        }
    }

    /* access modifiers changed from: private */
    public static int invokeMethodInInvokePlugin(Context context, String packageName, String methodName, String from, String params, LoadContextCallback loadContextCallback, InvokeCallback callback, InvokeListener[] listeners, int flag, Object[] options, boolean isInvokeMethod, boolean isUseExt) {
        if (BaseConfiger.isDebug()) {
            Log.d(TAG, "invokeMethodInInvokePlugin: packageName=" + packageName + ", methodName=" + methodName);
        } else {
            String str = packageName;
            String str2 = methodName;
        }
        try {
            PluginInvokerInterface service = PluginProcessManager.getInstance(context).getService(isUseExt);
            if (service != null) {
                if (BaseConfiger.isDebug()) {
                    Log.d(TAG, "invokeMethodInInvokePlugin: service != null");
                }
                return service.invokeMethod(packageName, methodName, params, from, isInvokeMethod, PluginUtility.convertInvokeCallback(callback), PluginUtility.convertInvokeListener(listeners), PluginUtility.convertLoadContextCallback(loadContextCallback), flag, options);
            }
            if (BaseConfiger.isDebug()) {
                Log.d(TAG, "invokeMethodInInvokePlugin: service == null");
            }
            return -1000000;
        } catch (RemoteException e2) {
            if (BaseConfiger.isDebug()) {
                e2.printStackTrace();
            }
            if (BaseConfiger.isDebug()) {
                Log.d(TAG, "invokeMethodInInvokePlugin: RemoteException!!");
            }
            tryReBind();
            return -1000000;
        }
    }

    /* access modifiers changed from: private */
    public static int checkAndHandleBeforeLoadFromNonMainProcess(Context context, String packageName, int flag, Object[] options) {
        try {
            PluginInvokerInterface service = PluginProcessManager.getInstance(context).getHostService();
            if (service != null) {
                return service.checkAndHandleBeforeLoad(packageName, flag, options);
            }
            return -1000000;
        } catch (RemoteException e2) {
            if (BaseConfiger.isDebug()) {
                e2.printStackTrace();
            }
            tryReBind();
            return -1000000;
        }
    }

    /* access modifiers changed from: private */
    public static void handleLoadAndGetClassloaderInInvokePlugin(Context pluginContext, boolean isInvokeMethod, String packageName, String methodName, String from, String params, InvokeCallback callback, InvokeListener[] listeners, int flag, Object[] options, boolean needCheck) {
        final InvokeCallback invokeCallback = callback;
        final boolean isMainProcess = isMainProcess();
        final String str = packageName;
        final Object[] objArr = options;
        final String str2 = methodName;
        final String str3 = from;
        final int i2 = flag;
        final boolean z = isInvokeMethod;
        final Context context = pluginContext;
        final String str4 = params;
        final InvokeListener[] invokeListenerArr = listeners;
        int sCode = TargetActivatorProxy.loadAndGetClassLoader(getAppContext(), packageName, new INewGetClassLoaderCallback() {
            /* JADX WARNING: Removed duplicated region for block: B:34:0x0145  */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x0152  */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x015f  */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x016c  */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0179  */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x0186  */
            /* JADX WARNING: Removed duplicated region for block: B:64:0x0193  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onGetClassLoaderCallback(int r21, java.lang.ClassLoader r22) {
                /*
                    r20 = this;
                    r1 = r20
                    java.lang.String r2 = ""
                    if (r21 == 0) goto L_0x0036
                    com.baidu.searchbox.plugin.api.InvokeCallback r0 = com.baidu.searchbox.plugin.api.InvokeCallback.this
                    if (r0 == 0) goto L_0x000e
                    r3 = -3
                    r0.onResult(r3, r2)
                L_0x000e:
                    r0 = -1000000(0xfffffffffff0bdc0, float:NaN)
                    boolean r2 = r2
                    if (r2 == 0) goto L_0x0021
                    android.content.Context r2 = com.baidu.searchbox.plugin.api.PluginInvoker.getAppContext()
                    java.lang.String r3 = r3
                    java.lang.Object[] r4 = r4
                    int r0 = com.baidu.searchbox.aps.center.activator.TargetActivatorProxy.handleLoadError(r2, r3, r4)
                L_0x0021:
                    android.content.Context r2 = com.baidu.searchbox.plugin.api.PluginInvoker.getAppContext()
                    java.lang.String r4 = r3
                    java.lang.String r5 = r5
                    java.lang.String r6 = r6
                    int r7 = r7
                    java.lang.Object[] r8 = r4
                    boolean r9 = r8
                    r3 = r0
                    com.baidu.searchbox.aps.invoker.statistic.PluginStatistic.addInvokePluginStatistic(r2, r3, r4, r5, r6, r7, r8, r9)
                    return
                L_0x0036:
                    r3 = 0
                    boolean r0 = com.baidu.megapp.util.MegUtils.isCallPluginSpeedDebug()
                    java.lang.String r5 = ",method:"
                    java.lang.String r6 = "pkg:"
                    java.lang.String r7 = "CallPluginSpeed"
                    if (r0 == 0) goto L_0x0081
                    long r8 = java.lang.System.currentTimeMillis()
                    r3 = r8
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.StringBuilder r0 = r0.append(r6)
                    java.lang.String r10 = r3
                    java.lang.StringBuilder r0 = r0.append(r10)
                    java.lang.StringBuilder r0 = r0.append(r5)
                    java.lang.String r10 = r5
                    java.lang.StringBuilder r0 = r0.append(r10)
                    java.lang.String r10 = " get plugin classloader："
                    java.lang.StringBuilder r0 = r0.append(r10)
                    long r10 = com.baidu.megapp.util.MegUtils.sCallPluginSpeedTime
                    long r10 = r8 - r10
                    java.lang.StringBuilder r0 = r0.append(r10)
                    java.lang.String r0 = r0.toString()
                    android.util.Log.d(r7, r0)
                    long r10 = com.baidu.megapp.util.MegUtils.sCallPluginSpeedTime
                    long r10 = r8 - r10
                    long r12 = com.baidu.megapp.util.MegUtils.sPluginEnvInitTime
                    long r10 = r10 - r12
                    com.baidu.megapp.util.MegUtils.sApsLogicTime = r10
                L_0x0081:
                    r8 = 0
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x018a, NoSuchMethodException -> 0x017d, InstantiationException -> 0x0170, IllegalAccessException -> 0x0163, IllegalArgumentException -> 0x0156, InvocationTargetException -> 0x0149, LinkageError -> 0x013c }
                    r0.<init>()     // Catch:{ ClassNotFoundException -> 0x018a, NoSuchMethodException -> 0x017d, InstantiationException -> 0x0170, IllegalAccessException -> 0x0163, IllegalArgumentException -> 0x0156, InvocationTargetException -> 0x0149, LinkageError -> 0x013c }
                    java.lang.String r9 = r3     // Catch:{ ClassNotFoundException -> 0x018a, NoSuchMethodException -> 0x017d, InstantiationException -> 0x0170, IllegalAccessException -> 0x0163, IllegalArgumentException -> 0x0156, InvocationTargetException -> 0x0149, LinkageError -> 0x013c }
                    java.lang.StringBuilder r0 = r0.append(r9)     // Catch:{ ClassNotFoundException -> 0x018a, NoSuchMethodException -> 0x017d, InstantiationException -> 0x0170, IllegalAccessException -> 0x0163, IllegalArgumentException -> 0x0156, InvocationTargetException -> 0x0149, LinkageError -> 0x013c }
                    java.lang.String r9 = ".PluginInvoker"
                    java.lang.StringBuilder r0 = r0.append(r9)     // Catch:{ ClassNotFoundException -> 0x018a, NoSuchMethodException -> 0x017d, InstantiationException -> 0x0170, IllegalAccessException -> 0x0163, IllegalArgumentException -> 0x0156, InvocationTargetException -> 0x0149, LinkageError -> 0x013c }
                    java.lang.String r0 = r0.toString()     // Catch:{ ClassNotFoundException -> 0x018a, NoSuchMethodException -> 0x017d, InstantiationException -> 0x0170, IllegalAccessException -> 0x0163, IllegalArgumentException -> 0x0156, InvocationTargetException -> 0x0149, LinkageError -> 0x013c }
                    r9 = r22
                    java.lang.Class r0 = r9.loadClass(r0)     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.Object r10 = r0.newInstance()     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    r11 = 6
                    java.lang.Class[] r12 = new java.lang.Class[r11]     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.Class<android.content.Context> r13 = android.content.Context.class
                    r14 = 0
                    r12[r14] = r13     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.Class<java.lang.String> r13 = java.lang.String.class
                    r15 = 1
                    r12[r15] = r13     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.Class<java.lang.String> r13 = java.lang.String.class
                    r16 = 2
                    r12[r16] = r13     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.Class<java.lang.String> r13 = java.lang.String.class
                    r17 = 3
                    r12[r17] = r13     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.Class<com.baidu.searchbox.plugin.api.InvokeCallback> r13 = com.baidu.searchbox.plugin.api.InvokeCallback.class
                    r18 = 4
                    r12[r18] = r13     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.Class<com.baidu.searchbox.plugin.api.InvokeListener[]> r13 = com.baidu.searchbox.plugin.api.InvokeListener[].class
                    r19 = 5
                    r12[r19] = r13     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.String r13 = "invoke"
                    java.lang.reflect.Method r13 = r0.getDeclaredMethod(r13, r12)     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    android.content.Context r15 = r9     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    r11[r14] = r15     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.String r14 = r3     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    r15 = 1
                    r11[r15] = r14     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.String r14 = r5     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    r11[r16] = r14     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.String r14 = r10     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    r11[r17] = r14     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    com.baidu.searchbox.plugin.api.InvokeCallback r14 = com.baidu.searchbox.plugin.api.InvokeCallback.this     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    r11[r18] = r14     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    com.baidu.searchbox.plugin.api.InvokeListener[] r14 = r11     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    r11[r19] = r14     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    r13.invoke(r10, r11)     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    boolean r14 = com.baidu.megapp.util.MegUtils.isCallPluginSpeedDebug()     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    if (r14 == 0) goto L_0x0129
                    long r14 = java.lang.System.currentTimeMillis()     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    r16 = r0
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    r0.<init>()     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.StringBuilder r0 = r0.append(r6)     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.String r6 = r3     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.StringBuilder r0 = r0.append(r6)     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.String r5 = r5     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.String r5 = " execute relect method："
                    java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    long r5 = com.baidu.megapp.util.MegUtils.sCallPluginSpeedTime     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    long r5 = r14 - r5
                    java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    java.lang.String r0 = r0.toString()     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    android.util.Log.d(r7, r0)     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    long r5 = r14 - r3
                    com.baidu.megapp.util.MegUtils.sApsSystemTime = r5     // Catch:{ ClassNotFoundException -> 0x013a, NoSuchMethodException -> 0x0138, InstantiationException -> 0x0136, IllegalAccessException -> 0x0134, IllegalArgumentException -> 0x0132, InvocationTargetException -> 0x0130, LinkageError -> 0x012e }
                    goto L_0x012b
                L_0x0129:
                    r16 = r0
                L_0x012b:
                    r8 = 1
                L_0x012c:
                    goto L_0x0197
                L_0x012e:
                    r0 = move-exception
                    goto L_0x013f
                L_0x0130:
                    r0 = move-exception
                    goto L_0x014c
                L_0x0132:
                    r0 = move-exception
                    goto L_0x0159
                L_0x0134:
                    r0 = move-exception
                    goto L_0x0166
                L_0x0136:
                    r0 = move-exception
                    goto L_0x0173
                L_0x0138:
                    r0 = move-exception
                    goto L_0x0180
                L_0x013a:
                    r0 = move-exception
                    goto L_0x018d
                L_0x013c:
                    r0 = move-exception
                    r9 = r22
                L_0x013f:
                    boolean r5 = com.baidu.searchbox.aps.base.utils.BaseConfiger.isDebug()
                    if (r5 == 0) goto L_0x0197
                    r0.printStackTrace()
                    goto L_0x0197
                L_0x0149:
                    r0 = move-exception
                    r9 = r22
                L_0x014c:
                    boolean r5 = com.baidu.searchbox.aps.base.utils.BaseConfiger.isDebug()
                    if (r5 == 0) goto L_0x012c
                    r0.printStackTrace()
                    goto L_0x012c
                L_0x0156:
                    r0 = move-exception
                    r9 = r22
                L_0x0159:
                    boolean r5 = com.baidu.searchbox.aps.base.utils.BaseConfiger.isDebug()
                    if (r5 == 0) goto L_0x012c
                    r0.printStackTrace()
                    goto L_0x012c
                L_0x0163:
                    r0 = move-exception
                    r9 = r22
                L_0x0166:
                    boolean r5 = com.baidu.searchbox.aps.base.utils.BaseConfiger.isDebug()
                    if (r5 == 0) goto L_0x012c
                    r0.printStackTrace()
                    goto L_0x012c
                L_0x0170:
                    r0 = move-exception
                    r9 = r22
                L_0x0173:
                    boolean r5 = com.baidu.searchbox.aps.base.utils.BaseConfiger.isDebug()
                    if (r5 == 0) goto L_0x012c
                    r0.printStackTrace()
                    goto L_0x012c
                L_0x017d:
                    r0 = move-exception
                    r9 = r22
                L_0x0180:
                    boolean r5 = com.baidu.searchbox.aps.base.utils.BaseConfiger.isDebug()
                    if (r5 == 0) goto L_0x012c
                    r0.printStackTrace()
                    goto L_0x012c
                L_0x018a:
                    r0 = move-exception
                    r9 = r22
                L_0x018d:
                    boolean r5 = com.baidu.searchbox.aps.base.utils.BaseConfiger.isDebug()
                    if (r5 == 0) goto L_0x012c
                    r0.printStackTrace()
                    goto L_0x012c
                L_0x0197:
                    if (r8 != 0) goto L_0x01a1
                    com.baidu.searchbox.plugin.api.InvokeCallback r0 = com.baidu.searchbox.plugin.api.InvokeCallback.this
                    if (r0 == 0) goto L_0x01a1
                    r5 = -1
                    r0.onResult(r5, r2)
                L_0x01a1:
                    android.content.Context r10 = com.baidu.searchbox.plugin.api.PluginInvoker.getAppContext()
                    r11 = 0
                    java.lang.String r12 = r3
                    java.lang.String r13 = r5
                    java.lang.String r14 = r6
                    int r15 = r7
                    java.lang.Object[] r0 = r4
                    boolean r2 = r8
                    r16 = r0
                    r17 = r2
                    com.baidu.searchbox.aps.invoker.statistic.PluginStatistic.addInvokePluginStatistic(r10, r11, r12, r13, r14, r15, r16, r17)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.plugin.api.PluginInvoker.AnonymousClass1.onGetClassLoaderCallback(int, java.lang.ClassLoader):void");
            }
        }, flag, objArr, needCheck);
        handleInvokePluginNativeCallback(sCode, callback);
        if (sCode != 0) {
            PluginStatistic.addInvokePluginStatistic(getAppContext(), sCode, packageName, methodName, from, flag, options, isInvokeMethod);
        }
    }

    private static void tryReBind() {
        if (PluginProcessManager.getInstance(getAppContext()).isBound()) {
            if (BaseConfiger.isDebug()) {
                Log.v(TAG, "PluginInvoker tryReBind bindService.");
            }
            PluginProcessManager.getInstance(getAppContext()).bindService((PluginProcessManager.BindCallback) null);
        }
    }

    public static boolean isInvokeMethod(String packageName, String methodName) {
        return isInvokeMethod(getAppContext(), packageName, methodName);
    }

    private static boolean isInvokeMethod(Context context, String packageName, String methodName) {
        if (TextUtils.isEmpty(packageName) || TextUtils.isEmpty(methodName)) {
            return false;
        }
        return PluginCache.getInstance(packageName).isInstallInvokeMethod(getAppContext(), methodName);
    }

    public static void handleInvokePluginNativeCallback(int statusCode, InvokeCallback callback) {
        if (callback != null) {
            switch (statusCode) {
                case 0:
                    return;
                case 11:
                    callback.onResult(-1, "");
                    return;
                default:
                    callback.onResult(-2, "");
                    return;
            }
        }
    }

    public static void handleInvokePluginClassCallback(int statusCode, InvokeClassCallback callback) {
        if (callback != null) {
            switch (statusCode) {
                case 0:
                    return;
                case 11:
                    callback.onResult(-1, (Class<?>) null);
                    return;
                default:
                    callback.onResult(-2, (Class<?>) null);
                    return;
            }
        }
    }

    private static void doException(RuntimeException e2) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, PluginInvokeException, IllegalArgumentException {
        if (BaseConfiger.isDebug()) {
            e2.printStackTrace();
        }
        Throwable throwable = e2.getCause();
        if (throwable instanceof NoSuchMethodException) {
            throw ((NoSuchMethodException) throwable);
        } else if (throwable instanceof IllegalAccessException) {
            throw ((IllegalAccessException) throwable);
        } else if (throwable instanceof IllegalArgumentException) {
            throw ((IllegalArgumentException) throwable);
        } else if (throwable instanceof InvocationTargetException) {
            throw ((InvocationTargetException) throwable);
        } else if (throwable instanceof PluginInvokeException) {
            throw ((PluginInvokeException) throwable);
        }
    }

    /* access modifiers changed from: private */
    public static void invokeHostFromMegappProcess(int managerId, String methodName, Class<?>[] parameterTypes, Object[] parameters, String from, HostInvokeCallback callback) throws PluginInvokeException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        try {
            ProcessCallback processCallback = getProcessCallback();
            if (processCallback != null) {
                processCallback.onHandleCompatibleInHost(managerId, methodName, parameterTypes, parameters, from);
            }
            if (PluginUtility.validateClassArray(parameters)) {
                PluginInvokerInterface service = PluginProcessManager.getInstance(getAppContext()).getHostService();
                if (service != null) {
                    service.invokeHost(managerId, methodName, parameterTypes, parameters, from, PluginUtility.convertHostInvokeCallback(callback));
                    return;
                }
                throw new PluginInvokeException("bind fail");
            }
            throw new PluginInvokeException("not support muti process");
        } catch (RemoteException e2) {
            tryReBind();
            throw new PluginInvokeException("bind fail");
        } catch (RuntimeException e3) {
            doException(e3);
        }
    }

    public static void invokeHost(int managerId, String methodName, Class<?>[] parameterTypes, Object[] parameters, String from, HostInvokeCallback callback) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, PluginInvokeException {
        if (!ProcessController.supportMultiProcess() || isMainProcess()) {
            invokeHostFromMainProcess(managerId, methodName, parameterTypes, parameters, from, callback);
            return;
        }
        final int i2 = managerId;
        final String str = methodName;
        final Class<?>[] clsArr = parameterTypes;
        final Object[] objArr = parameters;
        final String str2 = from;
        final HostInvokeCallback hostInvokeCallback = callback;
        if (ProcessController.bindHostServiceIfNeed(new PluginProcessManager.BindCallback() {
            public void onBind() {
                try {
                    PluginInvoker.invokeHostFromMegappProcess(i2, str, clsArr, objArr, str2, hostInvokeCallback);
                } catch (PluginInvokeException e2) {
                    if (BaseConfiger.isDebug()) {
                        e2.printStackTrace();
                    }
                } catch (NoSuchMethodException e3) {
                    if (BaseConfiger.isDebug()) {
                        e3.printStackTrace();
                    }
                } catch (IllegalAccessException e4) {
                    if (BaseConfiger.isDebug()) {
                        e4.printStackTrace();
                    }
                } catch (InvocationTargetException e5) {
                    if (BaseConfiger.isDebug()) {
                        e5.printStackTrace();
                    }
                }
            }
        })) {
            invokeHostFromMegappProcess(managerId, methodName, parameterTypes, parameters, from, callback);
        }
    }

    public static void invokeHostFromMainProcess(int managerId, String methodName, Class<?>[] parameterTypes, Object[] parameters, String from, HostInvokeCallback callback) throws NoSuchMethodException, PluginInvokeException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        InvokerCallback invokerCallback = getInvokerCallback();
        if (invokerCallback != null) {
            Object ret = invokerCallback.onInvokeHostInHost(managerId, methodName, parameterTypes, parameters, from);
            if (callback != null) {
                callback.onResult(0, ret);
                return;
            }
            return;
        }
        throw new PluginInvokeException("Host not support!!");
    }

    public static Object invokeHostFromMainProcessSync(int managerId, String methodName, Class<?>[] parameterTypes, Object[] parameters, String from) throws NoSuchMethodException, PluginInvokeException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        InvokerCallback invokerCallback = getInvokerCallback();
        if (invokerCallback != null) {
            return invokerCallback.onInvokeHostInHost(managerId, methodName, parameterTypes, parameters, from);
        }
        throw new PluginInvokeException("Host not support!!");
    }

    public static Class<?> invokePluginClass(String pkgName, String pluginClass, String from, boolean ignoreProcess) throws PluginInvokeException {
        final List<Class> cls = new ArrayList<>();
        final CountDownLatch latch = new CountDownLatch(1);
        invokePluginClass(pkgName, pluginClass, from, new InvokeClassCallback() {
            public void onResult(int statusCode, Class<?> clazz) {
                if (statusCode == 0) {
                    cls.add(clazz);
                }
                Log.d(PluginInvoker.TAG, "onResult: statusCode = " + statusCode + ", clazz = " + clazz.getName());
                latch.countDown();
            }
        }, ignoreProcess);
        try {
            latch.await();
        } catch (InterruptedException e2) {
        }
        if (cls.isEmpty()) {
            throw new PluginInvokeException("Didn't find class: " + pluginClass + " in APSclassloaders.");
        } else if (!cls.isEmpty()) {
            return cls.get(0);
        } else {
            return null;
        }
    }

    public static void invokePluginClass(String packageName, String pluginClass, String from, InvokeClassCallback callback, boolean ignoreProcess) {
        invokePluginClass(packageName, pluginClass, from, callback, 286261248, (Object[]) null, ignoreProcess);
    }

    public static void invokePluginClass(String packageName, String pluginClass, String from, InvokeClassCallback callback, int flag, Object[] options, boolean ignoreProcess) {
        if (isMainProcess() || ignoreProcess) {
            final String str = packageName;
            final String str2 = pluginClass;
            final String str3 = from;
            final InvokeClassCallback invokeClassCallback = callback;
            final int i2 = flag;
            final Object[] objArr = options;
            handleInvokePluginClassCallback(getPluginContext(getAppContext(), str, new INewGetContextCallBack() {
                public void onGetTargetApplicationContext(int statusCode, Context pluginContext) {
                    if (pluginContext != null) {
                        if (BaseConfiger.isDebug()) {
                            Log.d(PluginInvoker.TAG, "invokePluginInSameProcess onGetTargetApplicationContext: pluginContext != null");
                        }
                        PluginInvoker.handleLoadAndGetClassloaderInInvokePluginClass(false, str, str2, str3, invokeClassCallback, i2, objArr, false);
                    }
                }
            }, flag, options, true), callback);
        } else if (MegUtils.isDebug()) {
            Log.e(TAG, "invokePluginClass not support multi process!");
        }
    }

    private static int getPluginContext(Context context, String packageName, final INewGetContextCallBack callback, int flag, Object[] options, boolean needCheck) {
        int statusCode;
        if (needCheck && (statusCode = TargetActivatorProxy.checkAndHandleBeforeLoad(context, packageName, flag, options)) != 0) {
            return statusCode;
        }
        loadTarget(context, packageName, new INewTargetLoadedCallBack() {
            public void onTargetLoaded(int statusCode, String packageName) {
                INewGetContextCallBack iNewGetContextCallBack = INewGetContextCallBack.this;
                if (iNewGetContextCallBack != null) {
                    if (statusCode != 0) {
                        iNewGetContextCallBack.onGetTargetApplicationContext(statusCode, (Context) null);
                        return;
                    }
                    MAApplication app = ProxyEnvironment.getInstance(packageName).getApplication();
                    if (app != null) {
                        INewGetContextCallBack.this.onGetTargetApplicationContext(0, app);
                    } else {
                        INewGetContextCallBack.this.onGetTargetApplicationContext(-1000000, (Context) null);
                    }
                }
            }
        });
        return 0;
    }

    private static void loadTarget(final Context context, String packageName, INewTargetLoadedCallBack callback) {
        if (ProxyEnvironment.isEnterProxy(packageName)) {
            if (callback != null) {
                callback.onTargetLoaded(0, packageName);
            }
            if (MegUtils.isDebug()) {
                Log.d(TAG, "loadTarget and target is loaded!");
            }
        } else if (!MAPackageManager.getInstance(context).isPackageInstalled(packageName)) {
            if (callback != null) {
                callback.onTargetLoaded(-1, packageName);
            }
            if (MegUtils.isDebug()) {
                Log.e(TAG, "Plugin do not installed!");
            }
        } else if (!ProxyEnvironment.initProxyEnvironment(context, packageName)) {
            if (callback != null) {
                callback.onTargetLoaded(-1, packageName);
            }
            if (MegUtils.isDebug()) {
                Log.e(TAG, "Env init failed!!!");
            }
        } else if (ProxyEnvironment.getInstance(packageName).getApplication() == null) {
            ComponentName cn2 = new ComponentName(packageName, ProxyEnvironment.EXTRA_VALUE_LOADTARGET_STUB);
            final Intent intent = new Intent();
            intent.setComponent(cn2);
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                ProxyEnvironment.launchIntent(context, intent);
            } else {
                final CountDownLatch latch = new CountDownLatch(1);
                new AsyncTask<String, Integer, String>() {
                    /* access modifiers changed from: protected */
                    public String doInBackground(String... params) {
                        return params[0];
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(String result) {
                        try {
                            ProxyEnvironment.launchIntent(context, intent);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        latch.countDown();
                    }
                }.execute(new String[]{packageName});
                try {
                    latch.await();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            if (callback != null) {
                callback.onTargetLoaded(0, packageName);
            }
            if (MegUtils.isDebug()) {
                Log.d(TAG, "Env init successful!!!");
            }
        }
    }

    /* access modifiers changed from: private */
    public static void handleLoadAndGetClassloaderInInvokePluginClass(boolean isInvokeMethod, String packageName, String className, String from, InvokeClassCallback callback, int flag, Object[] options, boolean needCheck) {
        final InvokeClassCallback invokeClassCallback = callback;
        final String str = packageName;
        final Object[] objArr = options;
        final String str2 = className;
        final String str3 = from;
        final int i2 = flag;
        final boolean z = isInvokeMethod;
        int sCode = TargetActivatorProxy.loadAndGetClassLoader(getAppContext(), packageName, new INewGetClassLoaderCallback() {
            public void onGetClassLoaderCallback(int statusCode, ClassLoader classLoader) {
                Class<?> clazz = null;
                if (statusCode != 0) {
                    InvokeClassCallback invokeClassCallback = InvokeClassCallback.this;
                    if (invokeClassCallback != null) {
                        invokeClassCallback.onResult(-3, (Class<?>) null);
                    }
                    PluginStatistic.addInvokePluginStatistic(PluginInvoker.getAppContext(), TargetActivatorProxy.handleLoadError(PluginInvoker.getAppContext(), str, objArr), str, str2, str3, i2, objArr, z);
                    return;
                }
                boolean suc = false;
                try {
                    if (classLoader instanceof APSClassLoader) {
                        clazz = ((APSClassLoader) classLoader).loadExportedClass(str2);
                        suc = true;
                    }
                } catch (ClassNotFoundException e2) {
                    if (BaseConfiger.isDebug()) {
                        e2.printStackTrace();
                    }
                } catch (IllegalArgumentException e3) {
                    if (BaseConfiger.isDebug()) {
                        e3.printStackTrace();
                    }
                } catch (LinkageError e4) {
                    if (BaseConfiger.isDebug()) {
                        e4.printStackTrace();
                    }
                }
                InvokeClassCallback invokeClassCallback2 = InvokeClassCallback.this;
                if (invokeClassCallback2 != null) {
                    if (suc) {
                        invokeClassCallback2.onResult(0, clazz);
                    } else {
                        invokeClassCallback2.onResult(-1, (Class<?>) null);
                    }
                }
                PluginStatistic.addInvokePluginStatistic(PluginInvoker.getAppContext(), 0, str, str2, str3, i2, objArr, z);
            }
        }, flag, options, needCheck);
        InvokeClassCallback invokeClassCallback2 = callback;
        handleInvokePluginClassCallback(sCode, callback);
        if (sCode != 0) {
            PluginStatistic.addInvokePluginStatistic(getAppContext(), sCode, packageName, className, from, flag, options, isInvokeMethod);
        }
    }

    public static void urlInvokePlugin(String packageName, String from, String url, InvokeCallback callback, InvokeListener[] listeners) {
        Object[] options;
        String str = packageName;
        String str2 = url;
        InvokerCallback invokerCallback = getInvokerCallback();
        if (invokerCallback != null) {
            invokerCallback.onUrlInvokePluginBefore(packageName, str2);
            options = invokerCallback.parseUrlInvokePluginOptionInHost(packageName, str2);
        } else {
            options = null;
        }
        invokePlugin(getAppContext(), packageName, "url_invoke", from, url, (LoadContextCallback) null, callback, listeners, 286261248, options);
    }

    public static void removeStartContext(String packageName) {
        Util.removeStartContext(packageName);
    }

    public static void invokePlugin(Context context, String packageName, String methodName, String from, String params, LoadContextCallback loadContextCallback, InvokeCallback callback, InvokeListener[] listeners, int flag, Object[] options) {
        OrganizedInvokeCallback organizedCallback;
        String str = packageName;
        String str2 = methodName;
        Object[] objArr = options;
        if (MegUtils.isCallPluginSpeedDebug()) {
            MegUtils.sCallPluginSpeedTime = System.currentTimeMillis();
        }
        if (MegUtils.isCallPluginSpeedDebug()) {
            Log.d(MegUtils.CALL_PLUGIN_SPEED_TAG, "pkg:" + str + ",method:" + str2 + " invokePlugin：" + (System.currentTimeMillis() - MegUtils.sCallPluginSpeedTime));
        }
        initActivityLifeCallbacks();
        boolean isMainProcess = isMainProcess();
        boolean supportMultiProcess = ProcessController.supportMultiProcess();
        boolean isInvokeMethod = isInvokeMethod(packageName, methodName);
        OrganizedInvokeCallback organizedCallback2 = new OrganizedInvokeCallback(str, objArr, callback);
        if (isMainProcess) {
            PluginSpeedStatisticHelper.getInstance().onStartCallPlugin(str, str2, from);
        } else {
            String str3 = from;
        }
        if (getProcessIndex() != 0) {
            final String str4 = packageName;
            final int i2 = flag;
            final Object[] objArr2 = options;
            final OrganizedInvokeCallback organizedInvokeCallback = organizedCallback2;
            final String str5 = methodName;
            final String str6 = from;
            final boolean z = isInvokeMethod;
            final String str7 = params;
            organizedCallback = organizedCallback2;
            final LoadContextCallback loadContextCallback2 = loadContextCallback;
            final InvokeListener[] invokeListenerArr = listeners;
            if (ProcessController.bindHostServiceIfNeed(new PluginProcessManager.BindCallback() {
                public void onBind() {
                    int statusCode = PluginInvoker.checkAndHandleBeforeLoadFromNonMainProcess(PluginInvoker.getAppContext(), str4, i2, objArr2);
                    if (statusCode != 0) {
                        PluginInvoker.handleInvokePluginNativeCallback(statusCode, organizedInvokeCallback);
                        PluginStatistic.addInvokePluginStatistic(PluginInvoker.getAppContext(), statusCode, str4, str5, str6, i2, objArr2, z);
                    } else if (PluginInvoker.getProcessIndex() == 1) {
                        PluginInvoker.invokePluginFromMegaProcess(PluginInvoker.getAppContext(), str4, str5, str6, str7, loadContextCallback2, organizedInvokeCallback, invokeListenerArr, i2, objArr2, z);
                    } else {
                        PluginInvoker.invokePluginFromOtherProcess(PluginInvoker.getAppContext(), str4, str5, str6, str7, loadContextCallback2, organizedInvokeCallback, invokeListenerArr, i2, objArr2, z);
                    }
                }
            })) {
                int statusCode = checkAndHandleBeforeLoadFromNonMainProcess(getAppContext(), str, flag, objArr);
                if (statusCode != 0) {
                    handleInvokePluginNativeCallback(statusCode, organizedCallback);
                    PluginStatistic.addInvokePluginStatistic(getAppContext(), statusCode, packageName, methodName, from, flag, options, isInvokeMethod);
                    return;
                }
            } else {
                return;
            }
        } else {
            int i3 = flag;
            organizedCallback = organizedCallback2;
        }
        if (getProcessIndex() == 0) {
            invokePluginFromMainProcess(getAppContext(), packageName, methodName, from, params, loadContextCallback, organizedCallback, listeners, flag, options, isInvokeMethod);
        } else if (getProcessIndex() == 1) {
            invokePluginFromMegaProcess(getAppContext(), packageName, methodName, from, params, loadContextCallback, organizedCallback, listeners, flag, options, isInvokeMethod);
        } else {
            invokePluginFromOtherProcess(getAppContext(), packageName, methodName, from, params, loadContextCallback, organizedCallback, listeners, flag, options, isInvokeMethod);
        }
    }

    private static void invokePluginByCall(Context context, String packageName, String methodName, String from, String params, LoadContextCallback loadContextCallback, InvokeCallback callback, InvokeListener[] listeners, int flag, Object[] options, boolean isInvokeMethod, boolean needCheck) {
        final LoadContextCallback loadContextCallback2 = loadContextCallback;
        final InvokeCallback invokeCallback = callback;
        final boolean isMainProcess = isMainProcess();
        final String str = packageName;
        final Object[] objArr = options;
        final String str2 = methodName;
        final String str3 = from;
        final int i2 = flag;
        final boolean z = isInvokeMethod;
        final String str4 = params;
        final InvokeListener[] invokeListenerArr = listeners;
        int statusCode = TargetActivatorProxy.loadAndGetApplicationContext(getAppContext(), packageName, new INewGetContextCallBack() {
            public void onGetTargetApplicationContext(int statusCode, Context pluginContext) {
                LoadContextCallback loadContextCallback = LoadContextCallback.this;
                if (loadContextCallback != null) {
                    loadContextCallback.onCallback();
                }
                if (statusCode != 0) {
                    InvokeCallback invokeCallback = invokeCallback;
                    if (invokeCallback != null) {
                        invokeCallback.onResult(-3, "");
                    }
                    int sCode = -1000000;
                    if (isMainProcess) {
                        sCode = TargetActivatorProxy.handleLoadError(PluginInvoker.getAppContext(), str, objArr);
                    }
                    PluginStatistic.addInvokePluginStatistic(PluginInvoker.getAppContext(), sCode, str, str2, str3, i2, objArr, z);
                } else if (pluginContext != null) {
                    if (BaseConfiger.isDebug()) {
                        Log.d(PluginInvoker.TAG, "invokePluginInSameProcess onGetTargetApplicationContext: pluginContext != null");
                    }
                    if (MegUtils.isCallPluginSpeedDebug()) {
                        Log.d(MegUtils.CALL_PLUGIN_SPEED_TAG, "pkg:" + str + ",method:" + str2 + ")get plugin context：" + (System.currentTimeMillis() - MegUtils.sCallPluginSpeedTime));
                    }
                    PluginInvoker.handleLoadAndGetClassloaderInInvokePlugin(pluginContext, z, str, str2, str3, str4, invokeCallback, invokeListenerArr, i2, objArr, false);
                }
            }
        }, flag, options, needCheck);
        handleInvokePluginNativeCallback(statusCode, callback);
        if (statusCode != 0) {
            PluginStatistic.addInvokePluginStatistic(getAppContext(), statusCode, packageName, methodName, from, flag, options, isInvokeMethod);
        }
    }

    private static void invokePluginInMainProcessByService(Context context, String packageName, String methodName, String from, String params, LoadContextCallback loadContextCallback, InvokeCallback callback, InvokeListener[] listeners, int flag, Object[] options, boolean isInvokeMethod) {
        final Context context2 = context;
        final String str = packageName;
        final String str2 = methodName;
        final String str3 = from;
        final String str4 = params;
        final LoadContextCallback loadContextCallback2 = loadContextCallback;
        final InvokeCallback invokeCallback = callback;
        final InvokeListener[] invokeListenerArr = listeners;
        final int i2 = flag;
        final Object[] objArr = options;
        final boolean z = isInvokeMethod;
        PluginProcessManager.BindCallback bc = new PluginProcessManager.BindCallback() {
            public void onBind() {
                PluginInvoker.invokeMethodInInvokePluginAsync(context2, str, str2, str3, str4, loadContextCallback2, invokeCallback, invokeListenerArr, i2, objArr, z, false);
            }
        };
        if (ProcessController.bindHostServiceIfNeed(bc)) {
            if (BaseConfiger.isDebug()) {
                Log.d(TAG, "invokePluginInOtherProcess onBind: bindServiceIfNeed success");
            }
            bc.onBind();
        }
    }

    private static void invokePluginInMegaProcessByService(Context context, String packageName, String methodName, String from, String params, LoadContextCallback loadContextCallback, InvokeCallback callback, InvokeListener[] listeners, int flag, Object[] options, boolean isInvokeMethod) {
        int statusCode = TargetActivatorProxy.checkAndHandleBeforeLoad(getAppContext(), packageName, flag, options);
        if (statusCode != 0) {
            handleInvokePluginNativeCallback(statusCode, callback);
            PluginStatistic.addInvokePluginStatistic(getAppContext(), statusCode, packageName, methodName, from, flag, options, isInvokeMethod);
            return;
        }
        InvokeCallback invokeCallback = callback;
        final Context context2 = context;
        final String str = packageName;
        final String str2 = methodName;
        final String str3 = from;
        final String str4 = params;
        final LoadContextCallback loadContextCallback2 = loadContextCallback;
        final InvokeCallback invokeCallback2 = callback;
        final InvokeListener[] invokeListenerArr = listeners;
        final int i2 = flag;
        final Object[] objArr = options;
        final boolean z = isInvokeMethod;
        PluginProcessManager.BindCallback bc = new PluginProcessManager.BindCallback() {
            public void onBind() {
                PluginInvoker.invokeMethodInInvokePluginAsync(context2, str, str2, str3, str4, loadContextCallback2, invokeCallback2, invokeListenerArr, i2, objArr, z, true);
            }
        };
        if (ProcessController.bindMegappServiceIfNeed(bc)) {
            if (BaseConfiger.isDebug()) {
                Log.d(TAG, "invokePluginInOtherProcess onBind: bindServiceIfNeed success");
            }
            bc.onBind();
        }
    }

    /* access modifiers changed from: private */
    public static void invokeMethodInInvokePluginAsync(Context context, String packageName, String methodName, String from, String params, LoadContextCallback loadContextCallback, InvokeCallback callback, InvokeListener[] listeners, int flag, Object[] options, boolean isInvokeMethod, boolean isUseExt) {
        final String str = packageName;
        final String str2 = methodName;
        final String str3 = from;
        final String str4 = params;
        final LoadContextCallback loadContextCallback2 = loadContextCallback;
        final InvokeCallback invokeCallback = callback;
        final InvokeListener[] invokeListenerArr = listeners;
        final int i2 = flag;
        final Object[] objArr = options;
        final boolean z = isInvokeMethod;
        final boolean z2 = isUseExt;
        new AsyncTask<Void, Void, Integer>() {
            /* access modifiers changed from: protected */
            public Integer doInBackground(Void... voids) {
                return Integer.valueOf(PluginInvoker.invokeMethodInInvokePlugin(PluginInvoker.getAppContext(), str, str2, str3, str4, loadContextCallback2, invokeCallback, invokeListenerArr, i2, objArr, z, z2));
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Integer result) {
                super.onPostExecute(result);
                int statusCode = result.intValue();
                if (BaseConfiger.isDebug()) {
                    Log.d(PluginInvoker.TAG, "invokePluginInOtherProcess onBind: statusCode=" + statusCode);
                }
                PluginInvoker.handleInvokePluginNativeCallback(statusCode, invokeCallback);
                if (statusCode != 0) {
                    PluginStatistic.addInvokePluginStatistic(PluginInvoker.getAppContext(), statusCode, str, str2, str3, i2, objArr, z);
                }
            }
        }.executeOnExecutor(ApsThreadUtils.getExecutor(false), new Void[0]);
    }

    private static void invokePluginFromMainProcess(Context context, String packageName, String methodName, String from, String params, LoadContextCallback loadContextCallback, InvokeCallback callback, InvokeListener[] listeners, int flag, Object[] options, boolean isInvokeMethod) {
        if (!com.baidu.megapp.ma.Util.isUseExt(context, packageName)) {
            invokePluginByCall(context, packageName, methodName, from, params, loadContextCallback, callback, listeners, flag, options, isInvokeMethod, true);
        } else {
            invokePluginInMegaProcessByService(context, packageName, methodName, from, params, loadContextCallback, callback, listeners, flag, options, isInvokeMethod);
        }
    }

    /* access modifiers changed from: private */
    public static void invokePluginFromMegaProcess(Context context, String packageName, String methodName, String from, String params, LoadContextCallback loadContextCallback, InvokeCallback callback, InvokeListener[] listeners, int flag, Object[] options, boolean isInvokeMethod) {
        if (com.baidu.megapp.ma.Util.isUseExt(context, packageName)) {
            invokePluginByCall(context, packageName, methodName, from, params, loadContextCallback, callback, listeners, flag, options, isInvokeMethod, false);
        } else {
            invokePluginInMainProcessByService(context, packageName, methodName, from, params, loadContextCallback, callback, listeners, flag, options, isInvokeMethod);
        }
    }

    /* access modifiers changed from: private */
    public static void invokePluginFromOtherProcess(Context context, String packageName, String methodName, String from, String params, LoadContextCallback loadContextCallback, InvokeCallback callback, InvokeListener[] listeners, int flag, Object[] options, boolean isInvokeMethod) {
        if (com.baidu.megapp.ma.Util.isUseExt(context, packageName)) {
            invokePluginInMegaProcessByService(context, packageName, methodName, from, params, loadContextCallback, callback, listeners, flag, options, isInvokeMethod);
        } else {
            invokePluginInMainProcessByService(context, packageName, methodName, from, params, loadContextCallback, callback, listeners, flag, options, isInvokeMethod);
        }
    }

    public static void initActivityLifeCallbacks() {
        if (isMainProcess()) {
            synchronized (MAActivity.ActivityLifecycleCallbacks.class) {
                if (sActivityLifeCallbacks == null) {
                    AnonymousClass13 r1 = new MAActivity.ActivityLifecycleCallbacks() {
                        public void onActivityStopped(Activity activity) {
                            ProcessCallback processCallback = PluginInvoker.getProcessCallback();
                            if (processCallback != null) {
                                processCallback.onPluginActivityStopped(activity, true);
                            }
                        }

                        public void onActivityStarted(Activity activity) {
                            ProcessCallback processCallback = PluginInvoker.getProcessCallback();
                            if (processCallback != null) {
                                processCallback.onPluginActivityStarted(activity, true);
                            }
                        }

                        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                            ProcessCallback processCallback = PluginInvoker.getProcessCallback();
                            if (processCallback != null) {
                                processCallback.onPluginActivitySaveInstanceState(activity, bundle, true);
                            }
                        }

                        public void onActivityResumed(Activity activity) {
                            if (MegUtils.isCallPluginSpeedDebug()) {
                                long time = System.currentTimeMillis();
                                Log.d(MegUtils.CALL_PLUGIN_SPEED_TAG, "Activity onActivityResumed：" + (time - MegUtils.sCallPluginSpeedTime));
                                MegUtils.sPluginLoadInitTime = (((time - MegUtils.sCallPluginSpeedTime) - MegUtils.sPluginEnvInitTime) - MegUtils.sApsLogicTime) - MegUtils.sApsSystemTime;
                                Log.d(MegUtils.CALL_PLUGIN_SPEED_TAG, "-------APS插件调起速度测试结果如下-------");
                                Log.d(MegUtils.CALL_PLUGIN_SPEED_TAG, "总耗时（ms）：" + (time - MegUtils.sCallPluginSpeedTime));
                                Log.d(MegUtils.CALL_PLUGIN_SPEED_TAG, "APS框架耗时：" + (MegUtils.sApsLogicTime + MegUtils.sApsSystemTime));
                                Log.d(MegUtils.CALL_PLUGIN_SPEED_TAG, "APS插件耗时：" + (MegUtils.sPluginEnvInitTime + MegUtils.sPluginLoadInitTime));
                                Log.d(MegUtils.CALL_PLUGIN_SPEED_TAG, "APS框架逻辑代码执行耗时：" + MegUtils.sApsLogicTime);
                                Log.d(MegUtils.CALL_PLUGIN_SPEED_TAG, "APS框架系统代码执行耗时：" + MegUtils.sApsSystemTime);
                                Log.d(MegUtils.CALL_PLUGIN_SPEED_TAG, "APS插件运行环境初始化耗时：" + MegUtils.sPluginEnvInitTime);
                                Log.d(MegUtils.CALL_PLUGIN_SPEED_TAG, "APS插件主界面初始化耗时：" + MegUtils.sPluginLoadInitTime);
                                float per = ((((float) (MegUtils.sApsLogicTime + MegUtils.sApsSystemTime)) * 1.0f) / ((float) (time - MegUtils.sCallPluginSpeedTime))) * 100.0f;
                                Log.d(MegUtils.CALL_PLUGIN_SPEED_TAG, "测试结果分析，APS框架耗时占比：" + per + "%，插件内耗时占比：" + (100.0f - per) + "%");
                                Log.d(MegUtils.CALL_PLUGIN_SPEED_TAG, "-------APS插件调起速度测试结果如上-------");
                                MegUtils.clearSpeedData();
                            }
                            ProcessCallback processCallback = PluginInvoker.getProcessCallback();
                            if (processCallback != null) {
                                processCallback.onPluginActivityResumed(activity, true);
                            }
                            if (PluginInvoker.isMainProcess()) {
                                PluginSpeedStatisticHelper.getInstance().onPluginActivityResumed(activity);
                            }
                        }

                        public void onActivityPaused(Activity activity) {
                            ProcessCallback processCallback = PluginInvoker.getProcessCallback();
                            if (processCallback != null) {
                                processCallback.onPluginActivityPaused(activity, true);
                            }
                        }

                        public void onActivityDestroyed(Activity activity) {
                            ProcessCallback processCallback = PluginInvoker.getProcessCallback();
                            if (processCallback != null) {
                                processCallback.onPluginActivityDestroyed(activity, true);
                            }
                        }

                        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                            if (MegUtils.isCallPluginSpeedDebug()) {
                                Log.d(MegUtils.CALL_PLUGIN_SPEED_TAG, "Activity onActivityCreated：" + (System.currentTimeMillis() - MegUtils.sCallPluginSpeedTime));
                            }
                            ProcessCallback processCallback = PluginInvoker.getProcessCallback();
                            if (processCallback != null) {
                                processCallback.onPluginActivityCreated(activity, savedInstanceState, true);
                            }
                        }
                    };
                    sActivityLifeCallbacks = r1;
                    MAActivity.setActivityLifecycleCallbacks(r1);
                }
            }
        }
    }

    public static final class HostManager {
        public static final int AI_MML_RECEIVER = 21;
        public static final int APPFRAME_RECEIVER = 18;
        public static final int CARD_RECEIVER = 9;
        public static final int DOWNLAOD_FUN_RECEIVER = 20;
        public static final int DOWNLOAD_RECEIVER = 1;
        public static final int FREE_WIFI_RECEIVER = 16;
        public static final int IM_RECEIVER = 11;
        public static final int LIGHTAPP_RECEIVER = 10;
        public static final int LIVE_RECEIVER = 15;
        public static final int LOCATION_RECEIVER = 3;
        public static final int LOGIN_RECEIVER = 2;
        public static final int MESSAGE_RECEIVER = 13;
        public static final int NETWORK_RECEIVER = 17;
        public static final int NOVEL_RECEIVER = 12;
        public static final int PAY_RECEIVER = 8;
        public static final int PICTURE_RECEIVER = 7;
        public static final int PUBLISH_RECEIVER = 19;
        public static final int RN_RECEIVER = 14;
        public static final int SHARE_RECEIVER = 4;
        public static final int UBC_RECEIVER = 22;
        public static final int UTILITY_RECEIVER = 6;

        private HostManager() {
        }
    }
}
