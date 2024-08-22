package com.baidu.talos.yoga;

import com.baidu.talos.exception.TalosExceptionHandler;

public enum YogaDirection {
    INHERIT(0),
    LTR(1),
    RTL(2);
    
    private final int mIntValue;

    private YogaDirection(int intValue) {
        this.mIntValue = intValue;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaDirection fromInt(int value) {
        switch (value) {
            case 0:
                return INHERIT;
            case 1:
                return LTR;
            case 2:
                return RTL;
            default:
                TalosExceptionHandler.handleFromRN(new IllegalArgumentException("Unknown enum value: " + value), "YogaDirection", false);
                return INHERIT;
        }
    }
}
