package com.otaliastudios.cameraview.controls;

import androidx.annotation.NonNull;

public enum WhiteBalance implements Control {
    AUTO(0),
    INCANDESCENT(1),
    FLUORESCENT(2),
    DAYLIGHT(3),
    CLOUDY(4);
    
    public static final WhiteBalance DEFAULT = null;
    public int value;

    /* access modifiers changed from: public */
    static {
        WhiteBalance whiteBalance;
        DEFAULT = whiteBalance;
    }

    /* access modifiers changed from: public */
    WhiteBalance(int i2) {
        this.value = i2;
    }

    @NonNull
    public static WhiteBalance fromValue(int i2) {
        for (WhiteBalance whiteBalance : values()) {
            if (whiteBalance.value() == i2) {
                return whiteBalance;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
