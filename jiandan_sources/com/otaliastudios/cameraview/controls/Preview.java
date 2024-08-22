package com.otaliastudios.cameraview.controls;

import androidx.annotation.NonNull;

public enum Preview implements Control {
    SURFACE(0),
    TEXTURE(1),
    GL_SURFACE(2);
    
    public static final Preview DEFAULT = null;
    public int value;

    /* access modifiers changed from: public */
    static {
        Preview preview;
        DEFAULT = preview;
    }

    /* access modifiers changed from: public */
    Preview(int i2) {
        this.value = i2;
    }

    @NonNull
    public static Preview fromValue(int i2) {
        for (Preview preview : values()) {
            if (preview.value() == i2) {
                return preview;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
