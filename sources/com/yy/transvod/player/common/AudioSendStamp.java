package com.yy.transvod.player.common;

public class AudioSendStamp {
    public long mCaptureStampMs;
    public long mSendStampMs;

    public static native void nativeClassInit();

    public AudioSendStamp(long capStampMs, long sendStampMs) {
        this.mSendStampMs = sendStampMs;
        this.mCaptureStampMs = capStampMs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" sendStampMs=").append(this.mSendStampMs);
        sb.append(" mCaptureStampMs=").append(this.mCaptureStampMs);
        return sb.toString();
    }
}
