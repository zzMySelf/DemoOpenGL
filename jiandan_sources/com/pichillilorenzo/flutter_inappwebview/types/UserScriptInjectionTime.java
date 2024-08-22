package com.pichillilorenzo.flutter_inappwebview.types;

public enum UserScriptInjectionTime {
    AT_DOCUMENT_START(0),
    AT_DOCUMENT_END(1);
    
    public final int value;

    /* access modifiers changed from: public */
    UserScriptInjectionTime(int i2) {
        this.value = i2;
    }

    public static UserScriptInjectionTime fromValue(int i2) {
        for (UserScriptInjectionTime userScriptInjectionTime : values()) {
            if (i2 == userScriptInjectionTime.toValue()) {
                return userScriptInjectionTime;
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
