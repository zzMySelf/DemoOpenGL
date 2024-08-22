package com.otaliastudios.cameraview.controls;

import androidx.annotation.NonNull;

public enum Flash implements Control {
    OFF(0),
    ON(1),
    AUTO(2),
    TORCH(3);
    
    public static final Flash DEFAULT = null;
    public int value;

    /* access modifiers changed from: public */
    static {
        Flash flash;
        DEFAULT = flash;
    }

    /* access modifiers changed from: public */
    Flash(int i2) {
        this.value = i2;
    }

    @NonNull
    public static Flash fromValue(int i2) {
        for (Flash flash : values()) {
            if (flash.value() == i2) {
                return flash;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
