package com.baidu.sapi2.utils.enums;

public enum UIOrientation {
    SCREEN_ORIENTATION_LANDSCAPE(0),
    SCREEN_ORIENTATION_PORTRAIT(1),
    SCREEN_ORIENTATION_USER(2);
    
    public final int value;

    /* access modifiers changed from: public */
    UIOrientation(int i2) {
        this.value = i2;
    }

    public int getValue() {
        return this.value;
    }
}
