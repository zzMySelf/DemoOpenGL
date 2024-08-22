package com.baidu.sapi2.enums;

public enum PortraitCategory {
    NORMAL(""),
    NEW("new");
    
    public String a;

    /* access modifiers changed from: public */
    PortraitCategory(String str) {
        this.a = str;
    }

    public String getValue() {
        return this.a;
    }
}
