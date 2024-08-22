package com.baidu.sapi2.utils.enums;

public enum FromType {
    LOGIN("login"),
    REG("reg");
    
    public int index;
    public String value;

    /* access modifiers changed from: public */
    FromType(String str) {
        this.value = str;
    }

    public static FromType getFromType(String str) {
        if ("reg".equals(str)) {
            return REG;
        }
        return LOGIN;
    }

    public int getIndex() {
        return this.index;
    }

    public String getValue() {
        return this.value;
    }
}
