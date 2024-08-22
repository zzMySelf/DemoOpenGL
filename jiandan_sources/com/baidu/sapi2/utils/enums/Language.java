package com.baidu.sapi2.utils.enums;

public enum Language {
    CHINESE(0, "chinese"),
    ENGLISH(1, "english");
    
    public String name;
    public int type;

    /* access modifiers changed from: public */
    Language(int i2, String str) {
        this.type = i2;
        this.name = str;
    }

    public int getType() {
        return this.type;
    }
}
