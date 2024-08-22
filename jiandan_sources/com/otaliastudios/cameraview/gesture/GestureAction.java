package com.otaliastudios.cameraview.gesture;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public enum GestureAction {
    NONE(0, GestureType.ONE_SHOT),
    AUTO_FOCUS(1, GestureType.ONE_SHOT),
    TAKE_PICTURE(2, GestureType.ONE_SHOT),
    ZOOM(3, GestureType.CONTINUOUS),
    EXPOSURE_CORRECTION(4, GestureType.CONTINUOUS),
    FILTER_CONTROL_1(5, GestureType.CONTINUOUS),
    FILTER_CONTROL_2(6, GestureType.CONTINUOUS);
    
    public static final GestureAction DEFAULT_LONG_TAP = null;
    public static final GestureAction DEFAULT_PINCH = null;
    public static final GestureAction DEFAULT_SCROLL_HORIZONTAL = null;
    public static final GestureAction DEFAULT_SCROLL_VERTICAL = null;
    public static final GestureAction DEFAULT_TAP = null;
    public GestureType type;
    public int value;

    /* access modifiers changed from: public */
    static {
        GestureAction gestureAction;
        DEFAULT_PINCH = gestureAction;
        DEFAULT_TAP = gestureAction;
        DEFAULT_LONG_TAP = gestureAction;
        DEFAULT_SCROLL_HORIZONTAL = gestureAction;
        DEFAULT_SCROLL_VERTICAL = gestureAction;
    }

    /* access modifiers changed from: public */
    GestureAction(int i2, @NonNull GestureType gestureType) {
        this.value = i2;
        this.type = gestureType;
    }

    @Nullable
    public static GestureAction fromValue(int i2) {
        for (GestureAction gestureAction : values()) {
            if (gestureAction.value() == i2) {
                return gestureAction;
            }
        }
        return null;
    }

    @NonNull
    public GestureType type() {
        return this.type;
    }

    public int value() {
        return this.value;
    }
}
