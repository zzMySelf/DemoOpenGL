package com.otaliastudios.cameraview.controls;

import androidx.annotation.NonNull;

public enum VideoCodec implements Control {
    DEVICE_DEFAULT(0),
    H_263(1),
    H_264(2);
    
    public static final VideoCodec DEFAULT = null;
    public int value;

    /* access modifiers changed from: public */
    static {
        VideoCodec videoCodec;
        DEFAULT = videoCodec;
    }

    /* access modifiers changed from: public */
    VideoCodec(int i2) {
        this.value = i2;
    }

    @NonNull
    public static VideoCodec fromValue(int i2) {
        for (VideoCodec videoCodec : values()) {
            if (videoCodec.value() == i2) {
                return videoCodec;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
