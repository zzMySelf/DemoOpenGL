package com.baidu.searchbox.aps.invoker.statistic;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.megapp.ProxyEnvironment;
import com.baidu.searchbox.aps.base.PluginManager;
import com.baidu.searchbox.aps.base.manager.PluginStatisticManager;
import com.baidu.searchbox.aps.base.utils.BaseConfiger;
import com.baidu.searchbox.aps.invoker.process.PluginInvokerInterface;
import com.baidu.searchbox.aps.invoker.process.PluginProcessManager;
import com.baidu.searchbox.aps.invoker.process.ProcessController;
import com.baidu.searchbox.plugin.api.PluginInvoker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PluginSpeedStatisticHelper {
    private static final int INVALID_INVOKE_DURATION = 60000;
    private static final String TAG = "PluginSpeedStatistic";
    private static final long UBC_SPEED_MAX = 60000;
    private static final long UBC_SPEED_MIN = 0;
    private static volatile PluginSpeedStatisticHelper mInstance;
    private Map<String, CallPluginEvent> mCallPluginEventMap = new HashMap();

    private PluginSpeedStatisticHelper() {
    }

    public static PluginSpeedStatisticHelper getInstance() {
        if (mInstance == null) {
            synchronized (PluginSpeedStatisticHelper.class) {
                if (mInstance == null) {
                    mInstance = new PluginSpeedStatisticHelper();
                }
            }
        }
        return mInstance;
    }

    private static class CallPluginEvent {
        public String from;
        public boolean isPluginInited;
        public String methodName;
        public String packageName;
        public long startTime;

        private CallPluginEvent() {
        }
    }

    public void onStartCallPlugin(String packageName, String methodName, String from) {
        if (BaseConfiger.isDebug()) {
            Log.d(TAG, "onStartCallPlugin " + packageName + ", " + methodName + ", " + from);
            Log.d(TAG, "onStartCallPlugin isInvokeMethod=" + PluginInvoker.isInvokeMethod(packageName, methodName));
        }
        if (PluginManager.isMainProcess() && !TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(methodName) && PluginInvoker.isInvokeMethod(packageName, methodName)) {
            CallPluginEvent event = new CallPluginEvent();
            event.packageName = packageName;
            event.methodName = methodName;
            event.from = from;
            event.startTime = System.currentTimeMillis();
            event.isPluginInited = ProxyEnvironment.isEnterProxy(packageName);
            this.mCallPluginEventMap.put(packageName, event);
        }
    }

    public void onPluginActivityResumed(Activity activity) {
        Intent intent;
        CallPluginEvent event;
        if (BaseConfiger.isDebug()) {
            Log.d(TAG, "onPluginActivityResumed " + activity + ", intent=" + activity.getIntent().toUri(1));
        }
        if (PluginManager.isMainProcess() && activity != null && (intent = activity.getIntent()) != null) {
            String packageName = intent.getStringExtra(ProxyEnvironment.EXTRA_TARGET_PACKAGNAME);
            if (!TextUtils.isEmpty(packageName) && (event = this.mCallPluginEventMap.get(packageName)) != null) {
                doPluginSpeedStatistic(event);
                checkAndClearInvalidInvoke();
            }
        }
    }

    public void onPluginActivityResumed(String packageName) {
        CallPluginEvent event;
        if (BaseConfiger.isDebug()) {
            Log.d(TAG, "onPluginActivityResumed " + packageName);
        }
        if (!TextUtils.isEmpty(packageName) && (event = this.mCallPluginEventMap.get(packageName)) != null) {
            doPluginSpeedStatistic(event);
            checkAndClearInvalidInvoke();
        }
    }

    public static void onActivityResumedInMegProcess(final String packageName) {
        if (BaseConfiger.isDebug()) {
            Log.d(TAG, "onActivityResumedInMegProcess " + packageName);
        }
        if (ProcessController.supportMultiProcess() && !PluginManager.isMainProcess()) {
            PluginProcessManager.BindCallback bc = new PluginProcessManager.BindCallback() {
                public void onBind() {
                    try {
                        PluginInvokerInterface service = PluginProcessManager.getInstance(PluginManager.getAppContext()).getHostService();
                        if (service != null) {
                            service.onActivityResumed(packageName);
                        }
                        if (BaseConfiger.isDebug()) {
                            Log.d(PluginSpeedStatisticHelper.TAG, "onActivityResumedInMegProcess real call onActivityResumed");
                        }
                    } catch (RemoteException e2) {
                        if (BaseConfiger.isDebug()) {
                            e2.printStackTrace();
                        }
                    }
                }
            };
            if (ProcessController.bindHostServiceIfNeed(bc)) {
                bc.onBind();
            }
        } else if (BaseConfiger.isDebug()) {
            throw new RuntimeException("Called onActivityResumedInMegProcess from main Process");
        }
    }

    private synchronized void checkAndClearInvalidInvoke() {
        CallPluginEvent event;
        Map<String, CallPluginEvent> map = this.mCallPluginEventMap;
        if (map != null && map.size() > 0) {
            Iterator<Map.Entry<String, CallPluginEvent>> iterator = this.mCallPluginEventMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, CallPluginEvent> eventEntry = iterator.next();
                if (!(eventEntry == null || (event = eventEntry.getValue()) == null || System.currentTimeMillis() - event.startTime < 60000)) {
                    iterator.remove();
                }
            }
        }
    }

    private void doPluginSpeedStatistic(CallPluginEvent event) {
        int cpu = getCpuCore();
        long duration = System.currentTimeMillis() - event.startTime;
        if (BaseConfiger.isDebug()) {
            Log.d(TAG, "doPluginSpeedStatistic package=" + event.packageName + ", method=" + event.methodName + ", from=" + event.from + ", isPluginInited=" + event.isPluginInited + ", duration=" + duration + "ms");
        }
        if (duration > 0 && duration < 60000) {
            PluginStatisticManager.getInstance(PluginManager.getAppContext()).addInvokePluginSpeedStatistic(PluginManager.getAppContext(), duration, event.packageName, event.methodName, event.from, event.isPluginInited, cpu);
        }
        this.mCallPluginEventMap.remove(event.packageName);
    }

    private int getCpuCore() {
        Runtime runtime = Runtime.getRuntime();
        if (runtime != null) {
            return runtime.availableProcessors();
        }
        return 0;
    }
}
