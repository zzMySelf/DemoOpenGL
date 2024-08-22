package com.baidu.horae;

import android.text.TextUtils;

public class TraceSession {
    private static final boolean DEBUG = false;
    public static final int ERROR_CODE_FAILED = 2;
    public static final int ERROR_CODE_JAVA_EXCEPTION = -3;
    public static final int ERROR_CODE_NATIVE_PTR_NULL = -1;
    public static final int ERROR_CODE_PARAM_ERR = -5;
    public static final int ERROR_CODE_PEER_DISCONNECTION = 1;
    public static final int ERROR_CODE_SO_LOAD_FAILED = -2;
    public static final int ERROR_CODE_STATE_ERROR = -4;
    public static final int ERROR_CODE_SUCCESS = 0;
    private static final int STATE_IDLE = 0;
    private static final int STATE_RELEASED = 3;
    private static final int STATE_STARTED = 1;
    private static final int STATE_STOPPED = 2;
    private static final String TAG = "TraceSession";
    private long nativePtr;
    private int state = 0;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int start(com.baidu.horae.TraceConfig r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0006
            r0 = -5
            monitor-exit(r2)
            return r0
        L_0x0006:
            int r0 = r2.state     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x0015
            int r0 = com.baidu.horae.HoraeNative.startTraceSession(r2, r3)     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x0013
            r1 = 1
            r2.state = r1     // Catch:{ all -> 0x0018 }
        L_0x0013:
            monitor-exit(r2)
            return r0
        L_0x0015:
            r0 = -4
            monitor-exit(r2)
            return r0
        L_0x0018:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.horae.TraceSession.start(com.baidu.horae.TraceConfig):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int stop() {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.state     // Catch:{ all -> 0x0016 }
            r1 = 1
            if (r0 != r1) goto L_0x0013
            long r0 = r2.nativePtr     // Catch:{ all -> 0x0016 }
            int r0 = com.baidu.horae.HoraeNative.stopTraceSession(r0)     // Catch:{ all -> 0x0016 }
            if (r0 != 0) goto L_0x0011
            r1 = 2
            r2.state = r1     // Catch:{ all -> 0x0016 }
        L_0x0011:
            monitor-exit(r2)
            return r0
        L_0x0013:
            r0 = -4
            monitor-exit(r2)
            return r0
        L_0x0016:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.horae.TraceSession.stop():int");
    }

    public synchronized int dumpTrace(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return -5;
        }
        int i2 = this.state;
        if (i2 != 1 && i2 != 2) {
            return -4;
        }
        return HoraeNative.dumpTrace(this.nativePtr, filePath);
    }

    public int release() {
        int i2 = this.state;
        if (i2 != 1 && i2 != 2) {
            return -4;
        }
        int code = HoraeNative.releaseTraceSession(this.nativePtr);
        if (code == 0) {
            this.state = 3;
        }
        return code;
    }
}
