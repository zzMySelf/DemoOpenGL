package com.pichillilorenzo.flutter_inappwebview.content_blocker;

public enum ContentBlockerActionType {
    BLOCK("block"),
    CSS_DISPLAY_NONE("css-display-none"),
    MAKE_HTTPS("make-https");
    
    public final String value;

    /* access modifiers changed from: public */
    ContentBlockerActionType(String str) {
        this.value = str;
    }

    public static ContentBlockerActionType fromValue(String str) {
        for (ContentBlockerActionType contentBlockerActionType : values()) {
            if (str.equals(contentBlockerActionType.value)) {
                return contentBlockerActionType;
            }
        }
        throw new IllegalArgumentException("No enum constant: " + str);
    }

    public boolean equalsValue(String str) {
        return this.value.equals(str);
    }

    public String toString() {
        return this.value;
    }
}
