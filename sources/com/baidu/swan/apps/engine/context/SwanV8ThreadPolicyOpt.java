package com.baidu.swan.apps.engine.context;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;

public class SwanV8ThreadPolicyOpt implements V8ThreadDelegatePolicy {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    /* access modifiers changed from: private */
    public static final String TAG = SwanV8ThreadPolicyOpt.class.getSimpleName();
    private Thread jsThread = null;
    /* access modifiers changed from: private */
    public final int mAndroidThreadPriority;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private V8Engine mV8Engine;

    public SwanV8ThreadPolicyOpt(int androidThreadPriority) {
        this.mAndroidThreadPriority = androidThreadPriority;
    }

    public void startV8Engine(V8Engine var1) {
        if (this.jsThread == null) {
            this.mV8Engine = var1;
            Thread thread = new Thread(new V8EngineRunnable(var1));
            this.jsThread = thread;
            thread.setName(var1.threadName());
            this.jsThread.start();
        }
    }

    public void doDelegateRunnable(Runnable var1) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new SafelyRunnable(this.mV8Engine, var1));
        }
    }

    public void doDelegateRunnable(Runnable var1, long var2) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new SafelyRunnable(this.mV8Engine, var1), var2);
        }
    }

    public void doDelegateRunnableDirectly(Runnable var1) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new SafelyRunnable(this.mV8Engine, var1));
        }
    }

    public void shutdown() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mHandler.getLooper().quitSafely();
    }

    public Thread getThread() {
        Handler handler = this.mHandler;
        if (handler != null) {
            return handler.getLooper().getThread();
        }
        return null;
    }

    class V8EngineRunnable implements Runnable {
        V8Engine mV8Engine;

        V8EngineRunnable(V8Engine v8Engine) {
            this.mV8Engine = v8Engine;
        }

        public void run() {
            try {
                Process.setThreadPriority(SwanV8ThreadPolicyOpt.this.mAndroidThreadPriority);
            } catch (Exception e2) {
                if (SwanV8ThreadPolicyOpt.DEBUG) {
                    Log.e(SwanV8ThreadPolicyOpt.TAG, Log.getStackTraceString(e2));
                }
            }
            Looper.prepare();
            Handler unused = SwanV8ThreadPolicyOpt.this.mHandler = new Handler();
            this.mV8Engine.startEngineInternal();
            Looper.loop();
        }
    }

    static class SafelyRunnable implements Runnable {
        Runnable mRunnable;
        V8Engine mV8Engine;

        SafelyRunnable(V8Engine v8Engine, Runnable runnable) {
            this.mV8Engine = v8Engine;
            this.mRunnable = runnable;
        }

        public void run() {
            if (!this.mV8Engine.isDestroyed()) {
                try {
                    this.mRunnable.run();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                    SwanAppLog.logToFile(SwanV8ThreadPolicyOpt.TAG, Log.getStackTraceString(throwable));
                }
            }
        }
    }
}
