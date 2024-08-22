package com.otaliastudios.cameraview.controls;

import androidx.annotation.NonNull;

public enum Mode implements Control {
    PICTURE(0),
    VIDEO(1);
    
    public static final Mode DEFAULT = null;
    public int value;

    /* access modifiers changed from: public */
    static {
        Mode mode;
        DEFAULT = mode;
    }

    /* access modifiers changed from: public */
    Mode(int i2) {
        this.value = i2;
    }

    @NonNull
    public static Mode fromValue(int i2) {
        for (Mode mode : values()) {
            if (mode.value() == i2) {
                return mode;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
