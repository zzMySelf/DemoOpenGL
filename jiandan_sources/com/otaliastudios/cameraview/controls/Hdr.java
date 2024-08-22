package com.otaliastudios.cameraview.controls;

import androidx.annotation.NonNull;

public enum Hdr implements Control {
    OFF(0),
    ON(1);
    
    public static final Hdr DEFAULT = null;
    public int value;

    /* access modifiers changed from: public */
    static {
        Hdr hdr;
        DEFAULT = hdr;
    }

    /* access modifiers changed from: public */
    Hdr(int i2) {
        this.value = i2;
    }

    @NonNull
    public static Hdr fromValue(int i2) {
        for (Hdr hdr : values()) {
            if (hdr.value() == i2) {
                return hdr;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
