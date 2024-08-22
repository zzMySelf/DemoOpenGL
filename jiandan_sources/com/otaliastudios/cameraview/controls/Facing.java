package com.otaliastudios.cameraview.controls;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fe.vvv.qw.de;

public enum Facing implements Control {
    BACK(0),
    FRONT(1);
    
    public int value;

    /* access modifiers changed from: public */
    Facing(int i2) {
        this.value = i2;
    }

    @NonNull
    public static Facing defaultValue(@Nullable Context context) {
        if (context == null) {
            return BACK;
        }
        if (de.rg(context, BACK)) {
            return BACK;
        }
        if (de.rg(context, FRONT)) {
            return FRONT;
        }
        return BACK;
    }

    @Nullable
    public static Facing fromValue(int i2) {
        for (Facing facing : values()) {
            if (facing.value() == i2) {
                return facing;
            }
        }
        return null;
    }

    public int value() {
        return this.value;
    }
}
