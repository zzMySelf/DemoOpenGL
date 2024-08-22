package com.pichillilorenzo.flutter_inappwebview.types;

public enum PreferredContentModeOptionType {
    RECOMMENDED(0),
    MOBILE(1),
    DESKTOP(2);
    
    public final int value;

    /* access modifiers changed from: public */
    PreferredContentModeOptionType(int i2) {
        this.value = i2;
    }

    public static PreferredContentModeOptionType fromValue(int i2) {
        for (PreferredContentModeOptionType preferredContentModeOptionType : values()) {
            if (i2 == preferredContentModeOptionType.toValue()) {
                return preferredContentModeOptionType;
            }
        }
        throw new IllegalArgumentException("No enum constant: " + i2);
    }

    public boolean equalsValue(int i2) {
        return this.value == i2;
    }

    public int toValue() {
        return this.value;
    }
}
