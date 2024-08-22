package com.otaliastudios.cameraview;

public class CameraException extends RuntimeException {
    public static final int REASON_DISCONNECTED = 3;
    public static final int REASON_FAILED_TO_CONNECT = 1;
    public static final int REASON_FAILED_TO_START_PREVIEW = 2;
    public static final int REASON_NO_CAMERA = 6;
    public static final int REASON_PICTURE_FAILED = 4;
    public static final int REASON_UNKNOWN = 0;
    public static final int REASON_VIDEO_FAILED = 5;
    public int reason = 0;

    public CameraException(Throwable th2) {
        super(th2);
    }

    public int getReason() {
        return this.reason;
    }

    public boolean isUnrecoverable() {
        int reason2 = getReason();
        return reason2 == 1 || reason2 == 2 || reason2 == 3;
    }

    public CameraException(Throwable th2, int i2) {
        super(th2);
        this.reason = i2;
    }

    public CameraException(int i2) {
        this.reason = i2;
    }
}
