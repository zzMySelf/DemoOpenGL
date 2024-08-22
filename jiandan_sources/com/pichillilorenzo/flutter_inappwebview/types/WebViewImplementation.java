package com.pichillilorenzo.flutter_inappwebview.types;

public enum WebViewImplementation {
    NATIVE(0);
    
    public final int value;

    /* access modifiers changed from: public */
    WebViewImplementation(int i2) {
        this.value = i2;
    }

    public static WebViewImplementation fromValue(int i2) {
        for (WebViewImplementation webViewImplementation : values()) {
            if (i2 == webViewImplementation.value) {
                return webViewImplementation;
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
