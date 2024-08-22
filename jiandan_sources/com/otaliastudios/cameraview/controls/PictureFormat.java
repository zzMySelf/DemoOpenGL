package com.otaliastudios.cameraview.controls;

import androidx.annotation.NonNull;

public enum PictureFormat implements Control {
    JPEG(0),
    DNG(1);
    
    public static final PictureFormat DEFAULT = null;
    public int value;

    /* access modifiers changed from: public */
    static {
        PictureFormat pictureFormat;
        DEFAULT = pictureFormat;
    }

    /* access modifiers changed from: public */
    PictureFormat(int i2) {
        this.value = i2;
    }

    @NonNull
    public static PictureFormat fromValue(int i2) {
        for (PictureFormat pictureFormat : values()) {
            if (pictureFormat.value() == i2) {
                return pictureFormat;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
