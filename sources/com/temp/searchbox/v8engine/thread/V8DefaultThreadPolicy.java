package com.temp.searchbox.v8engine.thread;

import android.os.Handler;
import android.os.Looper;
import com.temp.searchbox.v8engine.V8Engine;

public class V8DefaultThreadPolicy implements V8ThreadDelegatePolicy {
    private Thread jsThread = null;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private V8Engine mV8Engine;

    public V8DefaultThreadPolicy(V8Engine v8Engine) {
        this.mV8Engine = v8Engine;
    }

    public void startV8Engine(V8Engine engine) {
        if (this.jsThread == null) {
            Thread thread = new Thread(new V8EngineRunnable());
            this.jsThread = thread;
            thread.setName(engine.threadName());
            this.jsThread.start();
        }
    }

    class V8EngineRunnable implements Runnable {
        V8EngineRunnable() {
        }

        public void run() {
            Looper.prepare();
            Handler unused = V8DefaultThreadPolicy.this.mHandler = new Handler();
            Looper.loop();
        }
    }

    public void doDelegateRunnable(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public void doDelegateRunnable(Runnable runnable, long delayMillis) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(runnable, delayMillis);
        }
    }

    public void doDelegateRunnableDirectly(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(runnable);
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
}
