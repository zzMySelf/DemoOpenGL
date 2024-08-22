package com.google.zxing.searchbox.client.android.camera.focus.manager;

import android.content.Context;
import android.hardware.Camera;

public final class AutoFocusManager extends AbstractAutoFocusManager {
    public static final long AUTO_FOCUS_INTERVAL_MS = 200;
    private static final long AUTO_FOCUS_WAIT_TIME_DELTA = 1000;
    private static final long AUTO_FOCUS_WAIT_TIME_OUT = 2000;
    private static final long AUTO_FOCUS_WAIT_TIME_THRESHOLD = 6000;
    public static final boolean DEBUG = false;
    public static final String TAG = "AutoFocusManager";
    /* access modifiers changed from: private */
    public volatile boolean active;
    /* access modifiers changed from: private */
    public long mAutoFocusWaitTime = 2000;
    private Camera.AutoFocusCallback mCallback;
    Runnable mFocusRunnable = new Runnable() {
        public void run() {
            while (AutoFocusManager.this.active && AutoFocusManager.this.mThreadId == Thread.currentThread().getId()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
                synchronized (AutoFocusManager.this) {
                    if (AutoFocusManager.this.active) {
                        try {
                            AutoFocusManager.this.mCamera.cancelAutoFocus();
                            AutoFocusManager.this.mCamera.autoFocus(AutoFocusManager.this);
                        } catch (RuntimeException e3) {
                        }
                        try {
                            AutoFocusManager autoFocusManager = AutoFocusManager.this;
                            autoFocusManager.wait(autoFocusManager.mAutoFocusWaitTime);
                        } catch (InterruptedException e4) {
                            e4.printStackTrace();
                            if (AutoFocusManager.this.mAutoFocusWaitTime < 6000) {
                                AutoFocusManager.access$214(AutoFocusManager.this, 1000);
                            }
                        }
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public volatile long mThreadId;

    static /* synthetic */ long access$214(AutoFocusManager x0, long x1) {
        long j2 = x0.mAutoFocusWaitTime + x1;
        x0.mAutoFocusWaitTime = j2;
        return j2;
    }

    public AutoFocusManager(Context context, Camera camera) {
        super(context, camera);
        start();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0012, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onAutoFocus(boolean r2, android.hardware.Camera r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.hardware.Camera$AutoFocusCallback r0 = r1.mCallback     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x000a
            r0.onAutoFocus(r2, r3)     // Catch:{ all -> 0x0013 }
            monitor-exit(r1)
            return
        L_0x000a:
            boolean r0 = r1.active     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0011
            r1.notifyAll()     // Catch:{ all -> 0x0013 }
        L_0x0011:
            monitor-exit(r1)
            return
        L_0x0013:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.searchbox.client.android.camera.focus.manager.AutoFocusManager.onAutoFocus(boolean, android.hardware.Camera):void");
    }

    public synchronized void start() {
        if (isUseAutoFocus()) {
            this.active = true;
            Thread thread = new Thread(this.mFocusRunnable);
            this.mThreadId = thread.getId();
            thread.start();
        }
    }

    public synchronized void stop() {
        if (isUseAutoFocus()) {
            try {
                this.mCamera.cancelAutoFocus();
            } catch (RuntimeException e2) {
            }
        }
        this.active = false;
        notifyAll();
    }

    public void setAutoFocusCallback(Camera.AutoFocusCallback callback) {
        this.mCallback = callback;
    }
}
