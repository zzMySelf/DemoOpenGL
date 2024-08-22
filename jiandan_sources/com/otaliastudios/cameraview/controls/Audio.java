package com.otaliastudios.cameraview.controls;

import androidx.annotation.NonNull;

public enum Audio implements Control {
    OFF(0),
    ON(1),
    MONO(2),
    STEREO(3);
    
    public static final Audio DEFAULT = null;
    public int value;

    /* access modifiers changed from: public */
    static {
        Audio audio;
        DEFAULT = audio;
    }

    /* access modifiers changed from: public */
    Audio(int i2) {
        this.value = i2;
    }

    @NonNull
    public static Audio fromValue(int i2) {
        for (Audio audio : values()) {
            if (audio.value() == i2) {
                return audio;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
