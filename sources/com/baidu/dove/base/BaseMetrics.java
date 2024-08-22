package com.baidu.dove.base;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseMetrics {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "Dove-BaseMetrics";
    private BaseConfig mConfig;
    private BaseRecorder mRecorder;
    private Map<String, BaseMonitor> monitors = new ConcurrentHashMap();
    private Map<String, BaseTracer> tracers = new ConcurrentHashMap();

    public BaseMetrics() {
    }

    public BaseMetrics(Map monitors2, Map tracers2, BaseConfig config, BaseRecorder recorder) {
        this.monitors = monitors2;
        this.tracers = tracers2;
        this.mConfig = config;
        this.mRecorder = recorder;
    }

    public void startMetrics() {
    }

    public void stopMetrics() {
    }

    public void addMonitor(String name, BaseMonitor monitor) {
        if (!TextUtils.isEmpty(name) && monitor != null) {
            this.monitors.put(name, monitor);
        }
    }

    public void removeMonitor(String name) {
        BaseMonitor monitor;
        if (!TextUtils.isEmpty(name) && (monitor = this.monitors.get(name)) != null) {
            this.monitors.remove(monitor);
        }
    }

    public void removeMonitor(BaseMonitor monitor) {
        if (monitor != null) {
            this.monitors.remove(monitor);
        }
    }

    public void startMonitor(String name) {
        BaseMonitor monitor;
        if (!TextUtils.isEmpty(name) && (monitor = this.monitors.get(name)) != null) {
            monitor.start();
        }
    }

    public void startMonitor(String name, BaseMonitor monitor) {
        if (!TextUtils.isEmpty(name) && monitor != null) {
            addMonitor(name, monitor);
            monitor.start();
        }
    }

    public void resumeMonitor(String name) {
        BaseMonitor monitor;
        if (!TextUtils.isEmpty(name) && (monitor = this.monitors.get(name)) != null) {
            monitor.resume();
        }
    }

    public void resumeMonitor(String name, BaseMonitor monitor) {
        if (!TextUtils.isEmpty(name) && monitor != null) {
            monitor.resume();
        }
    }

    public void pauseMonitor(String name) {
        BaseMonitor monitor;
        if (!TextUtils.isEmpty(name) && (monitor = this.monitors.get(name)) != null) {
            monitor.pause();
        }
    }

    public void pauseMonitor(String name, BaseMonitor monitor) {
        if (!TextUtils.isEmpty(name) && monitor != null) {
            monitor.pause();
        }
    }

    public void stopMonitor(String name) {
        BaseMonitor monitor;
        if (!TextUtils.isEmpty(name) && (monitor = this.monitors.get(name)) != null) {
            monitor.stop();
        }
    }

    public void stopMonitor(String name, BaseMonitor monitor) {
        if (!TextUtils.isEmpty(name) && monitor != null) {
            removeMonitor(name);
            monitor.stop();
        }
    }

    public void addTracer(String name, BaseTracer tracer) {
        if (!TextUtils.isEmpty(name) && tracer != null) {
            this.tracers.put(name, tracer);
        }
    }

    public void removeTracer(String name) {
        BaseTracer tracer;
        if (!TextUtils.isEmpty(name) && (tracer = this.tracers.get(name)) != null) {
            this.tracers.remove(tracer);
        }
    }

    public void removeTracer(BaseTracer tracer) {
        if (tracer != null) {
            this.tracers.remove(tracer);
        }
    }

    public void startTracer(String name) {
        BaseTracer tracer;
        if (!TextUtils.isEmpty(name) && (tracer = this.tracers.get(name)) != null) {
            tracer.start();
        }
    }

    public void startTracer(String name, BaseTracer tracer) {
        if (!TextUtils.isEmpty(name) && tracer != null) {
            addTracer(name, tracer);
            tracer.start();
        }
    }

    public void stopTracer(String name) {
        BaseTracer tracer;
        if (!TextUtils.isEmpty(name) && (tracer = this.tracers.get(name)) != null) {
            tracer.stop();
        }
    }

    public void stopTracer(String name, BaseTracer tracer) {
        if (!TextUtils.isEmpty(name) && tracer != null) {
            removeTracer(name);
            tracer.stop();
        }
    }

    public void setConfig(BaseConfig config) {
        this.mConfig = config;
    }

    public BaseConfig getConfig() {
        BaseConfig baseConfig = this.mConfig;
        if (baseConfig != null) {
            return baseConfig;
        }
        if (!DEBUG) {
            return null;
        }
        Log.d(TAG, "getConfig error, because of mConfig is null, please check");
        return null;
    }

    public BaseRecorder getRecorder() {
        BaseRecorder baseRecorder = this.mRecorder;
        if (baseRecorder != null) {
            return baseRecorder;
        }
        if (!DEBUG) {
            return null;
        }
        Log.d(TAG, "getRecorder error, because of mRecorder is null, please check");
        return null;
    }

    public void setRecorder(BaseRecorder recorder) {
        this.mRecorder = recorder;
    }

    public void startRecorder() {
        BaseRecorder baseRecorder = this.mRecorder;
        if (baseRecorder != null) {
            baseRecorder.startGlobalRecord();
        }
    }

    public void stopRecorder() {
        BaseRecorder baseRecorder = this.mRecorder;
        if (baseRecorder != null) {
            baseRecorder.stopGlobalRecord();
        }
    }
}
