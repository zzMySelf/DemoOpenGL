package com.temp.searchbox.v8engine;

import com.baidu.talos.core.Debug;
import com.temp.smallgame.sdk.MarioLog;
import java.util.concurrent.atomic.AtomicLong;

public abstract class JsReleaser {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = Debug.isDebug();
    private static final String TAG = "JsReleaser";
    public AtomicLong mNativeObject;
    final long mOwnedNativeEngine;
    final long mOwnedThreadId;

    public JsReleaser() {
        this.mNativeObject = new AtomicLong(0);
        this.mOwnedThreadId = 0;
        this.mOwnedNativeEngine = 0;
    }

    public JsReleaser(long nativeObject, long ownedNativeEngine, long ownedThreadId) {
        AtomicLong atomicLong = new AtomicLong(0);
        this.mNativeObject = atomicLong;
        atomicLong.set(nativeObject);
        this.mOwnedThreadId = ownedThreadId;
        this.mOwnedNativeEngine = ownedNativeEngine;
    }

    private static void safeRelease(long ownedNativeEngine, long ownedThreadId, long nativeObject, boolean finalized, String className) {
        V8Engine engine = V8Engine.getInstance(ownedNativeEngine);
        if (engine != null) {
            final long j2 = nativeObject;
            final long j3 = ownedThreadId;
            final boolean z = finalized;
            final String str = className;
            final long j4 = ownedNativeEngine;
            engine.runOnJSThread(new Runnable() {
                public void run() {
                    if (j2 != 0) {
                        long currentId = Thread.currentThread().getId();
                        boolean threadSafe = j3 == currentId;
                        if (threadSafe) {
                            if (JsReleaser.DEBUG && str.contains("JsSerializeValue")) {
                                if (z) {
                                    MarioLog.e("JsSerializeValue", "垃圾回收Java对象，释放JsSerializeValue对象。ptr = " + j2);
                                } else {
                                    MarioLog.e("JsSerializeValue", "主动调用release，释放JsSerializeValue对象。ptr = " + j2);
                                }
                            }
                            V8Engine.nativeDeleteJsReleaser(j4, j2, threadSafe);
                        } else if (JsReleaser.DEBUG) {
                            MarioLog.w(JsReleaser.TAG, "[JsReleaser][ERROR] Incorrect thread ID, current ID = " + currentId + ", expect ID = " + j3 + ", finalize=" + z);
                        }
                    }
                }
            });
        }
    }

    public void release() {
        long nativeObject = this.mNativeObject.getAndSet(0);
        if (nativeObject != 0) {
            safeRelease(this.mOwnedNativeEngine, this.mOwnedThreadId, nativeObject, false, getClass().getName());
        }
    }

    public long nativePtr() {
        return this.mNativeObject.get();
    }
}
