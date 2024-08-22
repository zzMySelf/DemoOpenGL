package com.baidu.crius;

public class CriusConfig {
    long mNativePointer;

    private native void jni_CSConfigFree(long j2);

    private native long jni_CSConfigNew();

    private native void jni_CSConfigSetLoggerEnabled(long j2, boolean z);

    private native void jni_CSConfigSetPointScaleFactor(long j2, float f2);

    public CriusConfig() {
        long jni_CSConfigNew = jni_CSConfigNew();
        this.mNativePointer = jni_CSConfigNew;
        if (jni_CSConfigNew == 0 && CriusConstants.DEBUG) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            jni_CSConfigFree(this.mNativePointer);
        } finally {
            super.finalize();
        }
    }

    public void setPointScaleFactor(float pixelsInPoint) {
        jni_CSConfigSetPointScaleFactor(this.mNativePointer, pixelsInPoint);
    }

    public void setLoggerEnabled(boolean enabled) {
        jni_CSConfigSetLoggerEnabled(this.mNativePointer, enabled);
    }
}
