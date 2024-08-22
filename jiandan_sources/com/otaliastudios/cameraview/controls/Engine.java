package com.otaliastudios.cameraview.controls;

import androidx.annotation.NonNull;

public enum Engine implements Control {
    CAMERA1(0),
    CAMERA2(1);
    
    public static final Engine DEFAULT = null;
    public int value;

    /* access modifiers changed from: public */
    static {
        Engine engine;
        DEFAULT = engine;
    }

    /* access modifiers changed from: public */
    Engine(int i2) {
        this.value = i2;
    }

    @NonNull
    public static Engine fromValue(int i2) {
        for (Engine engine : values()) {
            if (engine.value() == i2) {
                return engine;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
