package com.otaliastudios.cameraview.controls;

import androidx.annotation.NonNull;

public enum AudioCodec implements Control {
    DEVICE_DEFAULT(0),
    AAC(1),
    HE_AAC(2),
    AAC_ELD(3);
    
    public static final AudioCodec DEFAULT = null;
    public int value;

    /* access modifiers changed from: public */
    static {
        AudioCodec audioCodec;
        DEFAULT = audioCodec;
    }

    /* access modifiers changed from: public */
    AudioCodec(int i2) {
        this.value = i2;
    }

    @NonNull
    public static AudioCodec fromValue(int i2) {
        for (AudioCodec audioCodec : values()) {
            if (audioCodec.value() == i2) {
                return audioCodec;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
