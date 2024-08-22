package com.otaliastudios.cameraview.controls;

import androidx.annotation.NonNull;

public enum Grid implements Control {
    OFF(0),
    DRAW_3X3(1),
    DRAW_4X4(2),
    DRAW_PHI(3);
    
    public static final Grid DEFAULT = null;
    public int value;

    /* access modifiers changed from: public */
    static {
        Grid grid;
        DEFAULT = grid;
    }

    /* access modifiers changed from: public */
    Grid(int i2) {
        this.value = i2;
    }

    @NonNull
    public static Grid fromValue(int i2) {
        for (Grid grid : values()) {
            if (grid.value() == i2) {
                return grid;
            }
        }
        return DEFAULT;
    }

    public int value() {
        return this.value;
    }
}
