package com.baidu.sapi2.enums;

public enum LoginTypes {
    ONE_KEY_LOGIN(1, "one_key_login"),
    SHARE(2, "share"),
    HISTORY(3, "history"),
    FACE(4, "face"),
    FINGER(5, "finger");
    
    public String name;
    public int type;

    /* access modifiers changed from: public */
    LoginTypes(int i2, String str) {
        this.type = i2;
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }
}
