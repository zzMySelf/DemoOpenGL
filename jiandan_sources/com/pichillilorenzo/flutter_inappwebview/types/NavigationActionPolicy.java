package com.pichillilorenzo.flutter_inappwebview.types;

public enum NavigationActionPolicy {
    CANCEL(0),
    ALLOW(1);
    
    public final int value;

    /* access modifiers changed from: public */
    NavigationActionPolicy(int i2) {
        this.value = i2;
    }

    public static NavigationActionPolicy fromValue(int i2) {
        for (NavigationActionPolicy navigationActionPolicy : values()) {
            if (i2 == navigationActionPolicy.value) {
                return navigationActionPolicy;
            }
        }
        throw new IllegalArgumentException("No enum constant: " + i2);
    }

    public boolean equalsValue(int i2) {
        return this.value == i2;
    }

    public int rawValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
