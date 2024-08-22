package com.baidu.sapi2.utils.enums;

public enum ThirdPartyLoginBindType {
    TYPE_STANDDARD("standard", 0),
    TYPE_BIND_WITH_AUTH_CODE("bind_with_auth_code", 1),
    TYPE_SILENT_LOGIN_BIND("silent_login_bind", 2),
    TYPE_ONLY_AUTH_LOGIN("only_auth_login", 3);
    
    public String bindTypeName;
    public int bindTypeNum;

    /* access modifiers changed from: public */
    ThirdPartyLoginBindType(String str, int i2) {
        this.bindTypeName = str;
        this.bindTypeNum = i2;
    }

    public String getTypeName() {
        return this.bindTypeName;
    }

    public int getTypeNum() {
        return this.bindTypeNum;
    }
}
